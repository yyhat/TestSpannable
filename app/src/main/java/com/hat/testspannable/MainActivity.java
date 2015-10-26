package com.hat.testspannable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

/**
 * Created by anting.hu on 2015/10/26.
 */
public class MainActivity extends Activity {

    private TextView textView1;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);

        String text1 = "显示Activity1";
        String text2 = "显示Activity2";




        SpannableString span1 = new SpannableString(text1);

        span1.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(MainActivity.this, Test1Activity.class);
                startActivity(intent);

            }
        }, 0, text1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView1.setText(span1);
        textView1.setMovementMethod(LinkMovementMethod.getInstance());

        SpannableString span2 = new SpannableString(text2);

        span2.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(MainActivity.this, Test2Activity.class);
                startActivity(intent);
            }
        }, 0, text2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView2.setText(span2);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
