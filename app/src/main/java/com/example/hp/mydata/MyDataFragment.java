package com.example.hp.mydata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class MyDataFragment extends BaseFragment {


    @BindView(R.id.btn_Date)
    Button btnDate;
    @BindView(R.id.txtDate)
    TextView txtDate;
    Unbinder unbinder;




    public static MyDataFragment newInstance() {
        MyDataFragment fragment = new MyDataFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_data, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected int setLayoutResouceId() {
        return 0;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_Date)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.btn_Date :
                showDatePickerDialog(getContext(), 5, txtDate, calendar);
                break;
        }
    }
}
