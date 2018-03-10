package com.editotp;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class LoginCheckCode extends AppCompatActivity {
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private static final int NUM_PAGES = 3;
    EditText codeFirst, codeSecond, codeThird, codeFourth;
    String firstCode = "", secondCode = "", thirdCode = "", fourthCode = "";
    TextView skip;
    String otp;
    boolean doubleBackToExitPressedOnce = false;
    String access_token, mobile_num;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_check_code_layout);

        codeFirst = (EditText) findViewById(R.id.code_first);
        codeSecond = (EditText) findViewById(R.id.code_second);
        codeThird = (EditText) findViewById(R.id.code_third);
        codeFourth = (EditText) findViewById(R.id.code_fourth);



        mPager = (ViewPager) findViewById(R.id.adViewpager);
        mPagerAdapter = new LoginCheckCode.ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        codeFirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                firstCode = codeFirst.getEditableText().toString();
                if (firstCode.length()==1) {
                    codeSecond.requestFocus();
                }
            }
        });
        codeSecond.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                secondCode = codeSecond.getEditableText().toString();
                if (secondCode.length()==1) {
                    codeThird.requestFocus();
                }
                if(secondCode.length()==0){
                    codeFirst.requestFocus();
                }
            }
        });

        codeThird.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                thirdCode = codeThird.getEditableText().toString();
                if (thirdCode.length()==1) {
                    codeFourth.requestFocus();
                }
                if(thirdCode.length()==0){
                    codeSecond.requestFocus();
                }

            }
        });

        codeFourth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                fourthCode = codeFourth.getEditableText().toString();
                if (!firstCode.equals("") && !secondCode.equals("") && !thirdCode.equals("") && !fourthCode.equals("")) {
                    otp = firstCode + secondCode + thirdCode + fourthCode;
                   // otpRequest(otp);

                } if(fourthCode.length()==0){
                    codeThird.requestFocus();
                } /*else
                    Toast.makeText(LoginCheckCode.this, "Enter the fourth otp number", Toast.LENGTH_SHORT).show();
          */  }
        });


    }





    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
      //return new LoginSliderFragment();
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}