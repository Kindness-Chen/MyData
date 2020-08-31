package com.example.hp.mydata;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import java.util.ArrayList;


public class MainActivity extends BaseActivity  {


    private BottomNavigationView nav_bottom;
    //private List<Fragment> mFragments;
    //protected Fragment currentFragment;//要显示的Fragment
    //protected Fragment hideFragment;//要隐藏的Fragment
    //private int lastPosition;//上次fragment的位置


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("last_position",lastPosition);//activity重建时保存页面的位置
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lastPosition = savedInstanceState.getInt("last_position");//获取重建时的fragment的位置
        setSelectedFragment(lastPosition);//恢复销毁前显示的fragment
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        initData();
        initView(savedInstanceState);
    }

    @Override
    public void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(HealthFragment.newInstance());
        mFragments.add(MyDataFragment.newInstance());
        nav_bottom = (BottomNavigationView) findViewById(R.id.navigation);
    }

    //@Override
    protected void initView(Bundle savedInstanceState) {
        if (savedInstanceState == null){
            //根据传入的Bundle对象判断是正常启动还是重建 true表示正常启动，false表示重建
            setSelectedFragment(0);
        }
        nav_bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        setSelectedFragment(0);
                        //openActivity(MainActivity.class);
                        break;
                    case R.id.navigation_dashboard:
                        setSelectedFragment(1);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
