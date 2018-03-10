package com.morziz.gcm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edtAccountNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);


        edtAccountNumber = findViewById(R.id.account_number);
        edtAccountNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text = edtAccountNumber.getText().toString();
                int textlength = edtAccountNumber.getText().length();
                if (text.endsWith("-"))
                    return;
                if (textlength == 5 || textlength == 10 || textlength == 15) {
                    edtAccountNumber.setText(new StringBuilder(text).insert(text.length() - 1, "-").toString());
                    edtAccountNumber.setSelection(edtAccountNumber.getText().length());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        btn.setOnClickListener(view -> {
            String accountnumber = edtAccountNumber.getText().toString().trim();
            Log.d("TAGS",accountnumber.replace("-",""));
        });


    }
}
