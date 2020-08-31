package com.example.hp.mydata;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.List;


/**
 * Created by chenshengrui on 2020/8/28.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected List<Fragment> mFragments;
    protected int lastPosition;//上次fragment的位置
    protected Fragment currentFragment;//要显示的Fragment
    protected Fragment hideFragment;//要隐藏的Fragment

    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        //设置布局 绑定布局
        setContentView(getLayoutId());
        //initView(savedInstanceState);
        initData();
    }

    /**
     * 加载Layout
     */
    protected abstract int getLayoutId();

    /**
     * 初始化视图
     */
    //protected abstract void initView(Bundle savedInstanceState);

    /**
     * 业务逻辑
     */
    public abstract void initData();


    public void openActivity(Class<?> cls) {
        Intent i = new Intent(this, cls);
        startActivity(i);
    }

    protected void openActivity(Class<?> cls, String key, String value) {
        Intent intent = new Intent(this, cls);
        intent.putExtra(key, value);
        startActivity(intent);
    }
    /**
     * 根据位置选择Fragment
     * @param position 要选中的fragment的位置
     */
    protected void  setSelectedFragment(int position){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        currentFragment = fragmentManager.findFragmentByTag("fragment"+position);//要显示的fragment(解决了activity重建时新建实例的问题)
        hideFragment = fragmentManager.findFragmentByTag("fragment" + lastPosition);//要隐藏的fragment(解决了activity重建时新建实例的问题)
        if (position != lastPosition){//如果位置不同
            if (hideFragment != null){//如果要隐藏的fragment存在，则隐藏
                transaction.hide(hideFragment);
            }
            if (currentFragment == null){//如果要显示的fragment不存在，则新加并提交事务
                currentFragment = mFragments.get(position);
                transaction.add(R.id.fl_container,currentFragment,"fragment"+position);
            }else {//如果要显示的存在则直接显示
                transaction.show(currentFragment);
            }
        }

        if (position == lastPosition){//如果位置相同
            if (currentFragment == null){//如果fragment不存在(第一次启动应用的时候)
                currentFragment = mFragments.get(position);
                transaction.add(R.id.fl_container,currentFragment,"fragment"+position);
            }//如果位置相同，且fragment存在，则不作任何操作
        }
        transaction.commit();//提交事务
        lastPosition = position;//更新要隐藏的fragment的位置
    }

}