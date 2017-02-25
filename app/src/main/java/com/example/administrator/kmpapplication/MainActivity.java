package com.example.administrator.kmpapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText targetInput;
    private EditText patternInput;
    private Button Confirm;

    private String target = null;
    private String pattern = null;
    private char[] _target = null;
    private char[] _pattern = null;

    public void widgetInit(){
        targetInput = (EditText) findViewById(R.id.target_input);
        patternInput = (EditText) findViewById(R.id.pattern_input);
        Confirm = (Button) findViewById(R.id.button);
    }

    public void stringConvertToCharArr(){
        target = targetInput.getText().toString();
        pattern = patternInput.getText().toString();

        _target = target.toCharArray();
        _pattern = pattern.toCharArray();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        widgetInit();
        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringConvertToCharArr();
                KMPMatch kmpMatch = new KMPMatch(target, pattern);
                if (kmpMatch.getIndexOfStr() == -1){
                    Toast.makeText(MainActivity.this, "没有匹配成功", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "匹配成功,模式串位置为" + kmpMatch.getIndexOfStr(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
