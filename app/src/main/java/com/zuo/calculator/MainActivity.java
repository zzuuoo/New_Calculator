package com.zuo.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{


    private Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, bt_point, bt_chu;
    private Button bt_clear, bt_del, bt_cheng, bt_add, bt_jian, bt_deng, bt_zuo, bt_you;
    private TextView et;

    boolean clear_flag=true;

    private static Stack<Character> theStack;
    private static char charKey = (char) 97;
    private static Map<Character, String> hashMap = new HashMap<Character, String>();
    private static String result = "0";
    Button page_button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page_button1 =(Button) findViewById(R.id.button2);
        page_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bt1 = (Button) findViewById(R.id.button_1);
        bt2 = (Button) findViewById(R.id.button_2);
        bt3 = (Button) findViewById(R.id.button_3);
        bt4 = (Button) findViewById(R.id.button_4);
        bt5 = (Button) findViewById(R.id.button_5);
        bt6 = (Button) findViewById(R.id.button_6);
        bt7 = (Button) findViewById(R.id.button_7);
        bt8 = (Button) findViewById(R.id.button_8);
        bt9 = (Button) findViewById(R.id.button_9);
        bt0 = (Button) findViewById(R.id.button_0);
        bt_point = (Button) findViewById(R.id.button_point);
        bt_chu = (Button) findViewById(R.id.button_chu);
        bt_add = (Button) findViewById(R.id.button_add);
        bt_cheng = (Button) findViewById(R.id.button_cheng);
        bt_jian = (Button) findViewById(R.id.button_jian);
        bt_deng = (Button) findViewById(R.id.button_deng);
        bt_clear = (Button) findViewById(R.id.button_clear);
        bt_del = (Button) findViewById(R.id.button_del);
        bt_zuo = (Button) findViewById(R.id.button_zuo);
        bt_you = (Button) findViewById(R.id.button_you);

        //实例化输入框
        et = (TextView) findViewById(R.id.et);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        bt0.setOnClickListener(this);
        bt_point.setOnClickListener(this);
        bt_jian.setOnClickListener(this);
        bt_chu.setOnClickListener(this);
        bt_add.setOnClickListener(this);
        bt_clear.setOnClickListener(this);
        bt_del.setOnClickListener(this);
        bt_you.setOnClickListener(this);
        bt_zuo.setOnClickListener(this);
        bt_cheng.setOnClickListener(this);
        bt_deng.setOnClickListener(this);


    }

    @Override
    public void onClick(View v){

        String str = et.getText().toString();
        switch (v.getId()) {
            case R.id.button_0:
            case R.id.button_1:
            case R.id.button_2:
            case R.id.button_3:
            case R.id.button_4:
            case R.id.button_5:
            case R.id.button_6:
            case R.id.button_7:
            case R.id.button_8:
            case R.id.button_9:
                if(clear_flag) {
                    clear_flag = false;
                    str = "";
                    et.setText("");
                }
                if(str==null||str.equals("")||str.charAt(str.length()-1)!=')'){
                    et.setText((str + ((Button) v).getText()));
                }else{
                    et.setText(str );
                    Toast.makeText(MainActivity.this,"",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.button_zuo:
                if(clear_flag) {
                    clear_flag = false;
                    str = "";
                    et.setText("");
                }
                if(str==null||str.equals("")||str.charAt(str.length()-1)=='+'||str.charAt(str.length()-1)=='-'
                        ||str.charAt(str.length()-1)=='*'||str.charAt(str.length()-1)=='/'||str.charAt(str.length()-1)=='('){
                    et.setText((str + ((Button) v).getText()));
                }else{
                    et.setText(str );
                    Toast.makeText(MainActivity.this,"You can't click it",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_point:
                clear_flag=false;
                if (str != null && !str.equals("") && str.charAt(str.length()-1)!='.'&& str.charAt(str.length()-1)!='('
                        && str.charAt(str.length()-1)!='*' && str.charAt(str.length()-1)!='/'
                        && str.charAt(str.length()-1)!='+' && str.charAt(str.length()-1)!='-'){
                    et.setText((str + ((Button) v).getText()));

                }
                else{
                    et.setText(str );
                    Toast.makeText(MainActivity.this,"You can't click it",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_add:
            case R.id.button_cheng:
            case R.id.button_chu:
                clear_flag=false;
                if(str != null && !str.equals("")&&str .length()>0&&
                        str.charAt(str.length()-1)!='+' && str.charAt(str.length()-1)!='-'
                        &&str.charAt(str.length()-1)!='*' &&str.charAt(str.length()-1)!='/'
                        &&str.charAt(str.length()-1)!='('&&str.charAt(str.length()-1)!='.'){
                        et.setText((str + ((Button) v).getText()));

                }
                else{
                    et.setText(str);
                    Toast.makeText(MainActivity.this,"You can't click it",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_jian:
                clear_flag=false;
                if(str != null && !str.equals("")&&str .length()>0&&
                        str.charAt(str.length()-1)!='+' && str.charAt(str.length()-1)!='-'
                        &&str.charAt(str.length()-1)!='*' &&str.charAt(str.length()-1)!='/'
                        &&str.charAt(str.length()-1)!='.'
                       ){

                    et.setText((str + ((Button) v).getText()));

                }
               // else if(str == null || str.equals("")){
                 //   et.setText((str + ((Button) v).getText()));
                //}
                else{
                    et.setText(str);
                    Toast.makeText(MainActivity.this,"You can't click it",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.button_you:
                //result = result + String.valueOf(((Button) v).getText());
                if(str != null && !str.equals("")&&geshu(str,'(')>geshu(str,')')) {
                    et.setText((str + ((Button) v).getText()));
                    clear_flag=false;
                }else{
                    et.setText(str);
                    Toast.makeText(MainActivity.this,"You can't click it",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.button_del:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    et.setText("");
                } else if (str != null && !str.equals("")) {
                    et.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.button_clear:
                clear_flag = false;
                et.setText("");
                break;
            case R.id.button_deng:
                clear_flag=true;
                String qq,kk,pp;
                if(et.getText().toString()=="-"){
                    et.setText("error");
                }else {
                    qq = processBeforeEvaluation(et.getText().toString());
                    fuhao(qq);
                    kk = qu(qq);
                    pp = translateToPostfixExpression(kk);
                    String rrr = "" + evaluatePostfixExpression(pp);
                    et.setText(rrr);
                }
                break;
            default:
                break;
        }
    }


    private static String qu(String n){
        String m="";
        for(int i=0;i<n.length();i++){

            if(i==0&&n.charAt(i)=='-'){
                continue;
            }
            if(n.charAt(i)=='-'&&i!=0&&n.charAt(i-1)=='('){
                continue;
            }
            m=m+n.charAt(i);
        }

        return m;
    }

    private static void fuhao(String nidongde){
        String he="";
        String s1,s2;
        Double d1;
        for(int i = 0;i<nidongde.length();i++){
            if(nidongde.charAt(i)=='-'){

                if(i==0){
                    s1=hashMap.get(nidongde.charAt(i+1));
                    d1=Double.parseDouble(s1);
                    hashMap.put(nidongde.charAt(i+1),"-"+d1);
                }
                else if(nidongde.charAt(i-1)=='('){

                    s1=hashMap.get(nidongde.charAt(i+1));
                    d1=Double.parseDouble(s1);
                    hashMap.put(nidongde.charAt(i+1),"-"+d1);
                }

            }

        }

    }


    private  int geshu(String a,char b){

        int c=0,k=0;
        while(a.indexOf(b,k)!=-1){
            k=a.indexOf(b,k)+1;
            c++;
            if(k>=a.length()){
                break;
            }
        }
        return c;
    }
    private static String processBeforeEvaluation(String zuo) {
        Matcher legal = Pattern.compile("[^0-9.*+/\\()-]").matcher(zuo);
        if (legal.find()) {
            //如果不合法则退出
            System.exit(0);
        }
        StringBuffer sbuf = new StringBuffer();
        Matcher m = Pattern.compile("\\d+(\\.\\d+)?").matcher(zuo);
        while (m.find()) {
            String temp = m.group(0);
            hashMap.put(charKey, temp);
            m.appendReplacement(sbuf, charKey + "");
            charKey = (char) (charKey + 1);
        }
        m.appendTail(sbuf);
        return sbuf.toString();
    }


    private static String translateToPostfixExpression(String zuo) {
        theStack = new Stack<Character>();
        result = "";
        for (int j = 0; j < zuo.length(); j++) {
            char ch = zuo.charAt(j);
            switch (ch) {
                case '+':
                case '-':
                case '*':
                case '/':
                    gotOper(ch);
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    result += ch;
                    break;
            }
        }
        while (!theStack.empty()) {
            result += theStack.pop();
        }
        return result;
    }

    private static void gotOper(char opThis) {
        while (!theStack.empty()) {
            char opTop = theStack.pop();
            if (opTop == '(') {
                theStack.push(opTop);
                break;
            } else {
                if (opThis == '*' || opThis == '/') {   //如果是本次是乘除,栈里最多可弹出一个乘号
                    if (opTop == '+' || opTop == '-') {
                        theStack.push(opTop);
                    } else {
                        result += opTop;
                    }
                    break;
                } else {            //如果是本次是加减,栈里最多可弹出一次乘除,再加一次加减
                    result += opTop;
                }
            } //end else
        }//end while
        theStack.push(opThis);
    }


    private static void gotParen(char ch) {
        while (!theStack.empty()) {
            char chx = theStack.pop();
            if (chx == '(')
                break;
            else
                result += chx;
        }
    }


    private static BigDecimal evaluatePostfixExpression(String zuo) {
        char ch;
        //double num1, num2, interAns = 0;
        BigDecimal n1,n2,res;
        res = new BigDecimal("0");
        String str1, str2;
        theStack = new Stack<Character>(); //重置栈,后缀表达式求值是将数字放入栈中
        try {
            for (int j = 0; j < zuo.length(); j++) {
                ch = zuo.charAt(j);
                if (ch >= 97) {  //j代表一个double型的数字
                    theStack.push(ch);
                } else {
                    str2 = hashMap.get(theStack.pop());
                    str1 = hashMap.get(theStack.pop());
                   // num2 = Double.parseDouble(str2);
                 //   num1 = Double.parseDouble(str1);
                    n1 = new BigDecimal(str1);
                    n2= new BigDecimal(str2);
                    switch (ch) {
                        case '+':
                            //interAns = num1 + num2;
                            res = n1.add(n2);
                            break;
                        case '-':
                            //interAns = num1 - num2;
                            res= n1.subtract(n2);
                            break;
                        case '*':
                            //interAns = num1 * num2;
                            res = n1.multiply(n2);
                            break;
                        case '/':
                            //interAns = num1 / num2;
                            res = n1.divide(n2,15,BigDecimal.ROUND_HALF_DOWN);
                            break;
                        default:
                            //interAns = 0;
                            res = new BigDecimal("0");
                            break;
                    } //end switch
                    hashMap.put(charKey, res + "");
                    theStack.push(charKey);
                    charKey = (char) (charKey + 1);
                }
            }
            str1 = hashMap.get(theStack.pop());
            //interAns = Double.parseDouble(str1);
            res = new BigDecimal(str1);
        } catch (Exception e) {
            // 要求合法符号
            e.printStackTrace();
        }
        //return interAns;
        return res;
    }

}
