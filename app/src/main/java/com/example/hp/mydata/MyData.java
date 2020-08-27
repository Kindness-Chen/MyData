package com.example.hp.mydata;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyData extends AppCompatActivity {

    @BindView(R.id.et_number)
    EditText etNumber;
    @BindView(R.id.et_phone)
    EditText etPhone;

    //private TextView txtDate;
    //private Button btn_Date;
    @BindView(R.id.btn_Date)
    Button btn_Date;

    @BindView(R.id.txtDate)
    TextView txtDate;

    DateFormat format = DateFormat.getDateTimeInstance();
    Calendar calendar = Calendar.getInstance(Locale.CHINA);
    @BindView(R.id.rb_Male)
    RadioButton rbMale;
    @BindView(R.id.rb_FeMale)
    RadioButton rbFeMale;
    @BindView(R.id.sw_analyse)
    Switch swAnalyse;

    //底部菜单
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        /**
         * 底部菜单栏按钮事件
         */
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(MyData.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_dashboard:
                    Intent intent2 = new Intent(MyData.this, MyData.class);
                    startActivity(intent2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data);
        //初始化butterKnife事件
        ButterKnife.bind(this);
        init();
    }

    /**
     * @param view
     */
//    @OnClick(R.id.btn_Date)
//    public void onclick(View view) {
//        showDatePickerDialog(this, 6, txtDate, calendar);
//    }

    /**
     * 初始化事件
     */
    public void init() {
        //txtDate = (TextView) findViewById(R.id.txtDate);
        //btn_Date = (Button)findViewById(R.id.btn_Date);
        //btn_Date.setOnClickListener(this);
        //底部菜单
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    /**
     * 按钮事件，由ButterKnife代替
     */
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.btn_Date:
//                showDatePickerDialog(this,  2, txtDate, calendar);;
//                break;
//        }
//    }

    /**
     * 日期选择
     *
     * @param activity
     * @param themeResId
     * @param tv
     * @param calendar
     */
    public static void showDatePickerDialog(MyData activity, int themeResId, final TextView tv, Calendar calendar) {
        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        new DatePickerDialog(activity, themeResId, new DatePickerDialog.OnDateSetListener() {
            // 绑定监听器(How the parent is notified that the date is set.)
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 此处得到选择的时间，可以进行你想要的操作
                tv.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
            }
        }
                // 设置初始日期
                , calendar.get(Calendar.YEAR)
                , calendar.get(Calendar.MONTH)
                , calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.rb_Male, R.id.rb_FeMale, R.id.btn_Date})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_Male:
                Toast.makeText(this, "您选择了性别男", Toast.LENGTH_SHORT).show();
                etNumber.setText("44088219971025125X");
                break;
            case R.id.rb_FeMale:
                Toast.makeText(this, "您选择了性别女", Toast.LENGTH_SHORT).show();
                etPhone.setText("13046225259");
                Log.i("", String.valueOf(swAnalyse.getShowText()));
                break;
            case R.id.btn_Date:
                showDatePickerDialog(this, 5, txtDate, calendar);
                break;
        }
    }
}
