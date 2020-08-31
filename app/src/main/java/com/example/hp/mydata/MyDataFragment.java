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
//    /**
//     * 日期选择
//     *
//     * @param context
//     * @param themeResId
//     * @param tv
//     * @param calendar
//     */
//    public static void showDatePickerDialog(Context context, int themeResId, final TextView tv, Calendar calendar) {
//        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
//        new DatePickerDialog(context, themeResId, new DatePickerDialog.OnDateSetListener() {
//            // 绑定监听器(How the parent is notified that the date is set.)
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                // 此处得到选择的时间，可以进行你想要的操作
//                tv.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
//            }
//        }
//                // 设置初始日期
//                , calendar.get(Calendar.YEAR)
//                , calendar.get(Calendar.MONTH)
//                , calendar.get(Calendar.DAY_OF_MONTH)).show();
//    }

    @OnClick(R.id.btn_Date)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.btn_Date :
                showDatePickerDialog(getContext(), 5, txtDate, calendar);
                break;
        }
    }
}
