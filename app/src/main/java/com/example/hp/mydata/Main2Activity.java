package com.example.hp.mydata;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.List;



public class Main2Activity extends BaseActivity2  {

    private BottomNavigationView nav_bottom;
    private  HealthFragment fragment1;
    private MyDataFragment fragment2;
    private List<Fragment> mFragments;
    private Fragment[] fragments;
    //protected Fragment currentFragment;//要显示的Fragment
    //protected Fragment hideFragment;//要隐藏的Fragment

   // private int lastPosition;//上次fragment的位置
   private int lastfragment;

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt("last_position",lastPosition);//activity重建时保存页面的位置
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        lastPosition = savedInstanceState.getInt("last_position");//获取重建时的fragment的位置
//        setSelectedFragment(lastPosition);//恢复销毁前显示的fragment
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        //initData();
        //initView(savedInstanceState);
    }
    @Override
    public void initData()
    {

        fragment1 = new HealthFragment();
        fragment2 = new MyDataFragment();
        fragments = new Fragment[]{fragment1,fragment2};
        lastfragment=0;
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,fragment1).show(fragment1).commit();
        nav_bottom=(BottomNavigationView)findViewById(R.id.navigation);
        nav_bottom.setOnNavigationItemSelectedListener(changeFragment);

    }
    //判断选择的菜单
    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.navigation_home:
                {
                    if(lastfragment!=0)
                    {
                        switchFragment(lastfragment,0);
                        lastfragment=0;

                    }

                    return true;
                }
                case R.id.navigation_dashboard:
                {
                    if(lastfragment!=1)
                    {
                        switchFragment(lastfragment,1);
                        lastfragment=1;

                    }

                    return true;
                }

            }


            return false;
        }
    };
    //切换Fragment
    private void switchFragment(int lastfragment,int index)
    {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if(fragments[index].isAdded()==false)
        {
            transaction.add(R.id.fl_container,fragments[index]);


        }
        transaction.show(fragments[index]).commitAllowingStateLoss();


    }

//    @Override
//    public void initData() {
//        mFragments = new ArrayList<>();
//        mFragments.add(HealthFragment.newInstance());
//        mFragments.add(MyDataFragment.newInstance());
//    }

//    @Override
//    protected void initView(Bundle savedInstanceState) {
//        nav_bottom = (BottomNavigationView) findViewById(R.id.navigation);
//        if (savedInstanceState == null){
//            //根据传入的Bundle对象判断是正常启动还是重建 true表示正常启动，false表示重建
//            //setSelectedFragment(0);
//        }
//        nav_bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()) {
//                    case R.id.navigation_home:
//                        setSelectedFragment(0);
//
//                        break;
//                    case R.id.navigation_dashboard:
//                        setSelectedFragment(1);
//                        break;
//                }
//                return true;
//            }
//        });
//    }
    /**
     * 根据位置选择Fragment
     * @param position 要选中的fragment的位置
     */
//

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initView() {
        //
    }

    //    @BindView(R.id.webView)
//    WebView webView;
//    //Webview
//    //private WebView webView;
//    private RelativeLayout container;
//    //底部菜单
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        /**
//         * 底部菜单栏按钮事件
//         */
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    // container.setVisibility(View.INVISIBLE);
//                    return true;
//                case R.id.navigation_dashboard:
//                    Intent intent2 = new Intent(MainActivity.this, MyData.class);
//                    startActivity(intent2);
//                    //webView.setVisibility(View.INVISIBLE);
//                    return true;
//            }
//            return false;
//        }
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//        init();
//    }
//
//    /**
//     * 初始化事件
//     */
//    public void init() {
//        //底部菜单
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//
//        //webView = (WebView) findViewById(R.id.webView);
//        //需要加载的网页的url
//        webView.loadUrl("https://app.ssm.gov.mo/healthPHD/page/index.html");
//        WebSettings settings = webView.getSettings();
//        // 如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
//        settings.setJavaScriptEnabled(true);
//        webView.setWebViewClient(new WebViewClient() {
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//        });
//
//        webView.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                //等待证书响应
//                handler.proceed();
//            }
//        });
//    }
}
