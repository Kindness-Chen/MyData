package com.example.hp.mydata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HealthFragment extends BaseFragment {

    @BindView(R.id.webView)
    WebView webView;
    Unbinder unbinder;
    private WebSettings webSettings;

    public static HealthFragment newInstance() {
        HealthFragment fragment = new HealthFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_health, container, false);
        unbinder = ButterKnife.bind(this, mRootView);
        init();
        return mRootView;
    }

    @Override
    protected int setLayoutResouceId() {
        return 0;
    }

    /**
     * 初始化事件
     */
    public void init() {

        showWebView(webSettings,webView,"https://app.ssm.gov.mo/healthPHD/page/index.html");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}