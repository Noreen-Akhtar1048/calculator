package com.mysecoundapplication.myapplication;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.Expression;
public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnzero,btndot,btnadd,btnsub,btndiv,btnmul, btn_clear,btn_back,btn_bracket,btn_and,btn_equal;
    TextView textView3,textView4;
    boolean check_brackets = false;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnzero = findViewById(R.id.btnzero);
        btndot = findViewById(R.id.btndot);
        btn_back = findViewById(R.id.btn_back);
        btn_and = findViewById(R.id.btn_and);
        btn_bracket = findViewById(R.id.btn_bracktes);
        btnadd = findViewById(R.id.btnadd);
        btnsub = findViewById(R.id.btnsub);
        btndiv = findViewById(R.id.btndiv);
        btnmul = findViewById(R.id.btnmul);
        btn_clear = findViewById(R.id.btn_clear);
        btn_equal = findViewById(R.id.btnequal);

        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        btn1.setOnClickListener(view -> textView3.setText(textView3.getText()+getString(R.string._1)));
        btn2.setOnClickListener(view -> textView3.setText(textView3.getText()+getString(R.string._2)));
        btn3.setOnClickListener(view -> textView3.setText(textView3.getText()+getString(R.string._3)));
        btn4.setOnClickListener(view -> textView3.setText(textView3.getText()+getString(R.string._4)));
        btn5.setOnClickListener(view -> textView3.setText(textView3.getText()+getString(R.string._5)));
        btn6.setOnClickListener(view -> textView3.setText(textView3.getText()+getString(R.string._6)));
        btn7.setOnClickListener(view -> textView3.setText(textView3.getText()+getString(R.string._7)));
        btn8.setOnClickListener(view -> textView3.setText(textView3.getText()+getString(R.string._8)));
        btn9.setOnClickListener(view -> textView3.setText(textView3.getText()+getString(R.string._9)));
        btn_and.setOnClickListener(view -> textView3.setText(textView3.getText()+"^"));
        btnzero.setOnClickListener(view -> textView3.setText(textView3.getText()+"0"));
        btndot.setOnClickListener(view -> textView3.setText(textView3.getText()+"."));
        btnadd.setOnClickListener(view -> textView3.setText(textView3.getText()+"+"));
        btnsub.setOnClickListener(view -> textView3.setText(textView3.getText()+"-"));
        btndiv.setOnClickListener(view -> textView3.setText(textView3.getText()+"/"));
        btnmul.setOnClickListener(view -> textView3.setText(textView3.getText()+"*"));
        btn_clear.setOnClickListener(view -> {
            textView3.setText("");
            textView4.setText("");
        });
        btn_bracket.setOnClickListener(view -> {
            if(check_brackets){
                textView3.setText(textView3.getText()+")");
                check_brackets = false;
            }else {
                textView3.setText(textView3.getText()+"(");
                check_brackets = true;
            }
        });
        btn_back.setOnClickListener(view -> {
            String str = (String) textView3.getText();
            try{
                int len = str.length();
                StringBuilder builder = new StringBuilder(str);
                builder.deleteCharAt(len - 1);
                textView3.setText(builder);
            }catch (Exception e){
                textView3.setText("");
            }
        });
        btn_equal.setOnClickListener(view -> {
            String equal_str = textView3.getText().toString();
            equal_str = equal_str.replaceAll("/","/");
            equal_str = equal_str.replaceAll("x","*");
            Expression expression = new Expression(equal_str);
            String ans = String.valueOf(expression.calculate());
            textView4.setText(ans);
        });

    }
}