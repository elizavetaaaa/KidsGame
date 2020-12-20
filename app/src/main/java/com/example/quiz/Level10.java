package com.example.quiz;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Random;

public class Level10 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogGameEnd;
    public int numLeft;//для левой картинки
    public int numRight;//для правой картинки
    Array array = new Array();
    Random random = new Random();
    public int count = 0;//счетчик правильных ответов

    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level10);

        //скругляем углы для левой картинки
        final ImageView imgLeft = (ImageView)findViewById(R.id.img_left);
        imgLeft.setClipToOutline(true);
        //скругляем углы для правой картинки
        final ImageView imgRight = (ImageView)findViewById(R.id.img_right);
        imgRight.setClipToOutline(true);

        //путь к левой textview
        final TextView text_left = findViewById(R.id.text_left);
        //путь к левой textview
        final TextView text_right = findViewById(R.id.text_right);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //вызов диалогового окна
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//без заголовка
        dialog.setContentView(R.layout.previewdialogten);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);//нельзя закрыть кнопкой назад


        //кнопка закрывающая диалоговое окно
        TextView btnclose   =  (TextView) dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Level10.this,GameLevels.class);
                    startActivity(intent);
                    finish();
            }
                catch (Exception e){}
            dialog.dismiss();//закрытие диалогового окна
                 }

        });


        //вызов диалогового окна в конце игры-  начало
        dialogGameEnd = new Dialog(this);
        dialogGameEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//без заголовка
        dialogGameEnd.setContentView(R.layout.dialoggameend);
        dialogGameEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogGameEnd.setCancelable(false);//нельзя закрыть кнопкой назад

        //кнопка закрывающая диалоговое окно
        TextView btnclose2   =  (TextView) dialog.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Level10.this,GameLevels.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e){}
                dialog.dismiss();//закрытие диалогового окна
            }

        });

        //кнопка продолжить
        Button btncontinue2 = (Button)dialogGameEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Level10.this,GameLevels.class);// конец игры
                startActivity(intent);
                finish();
                dialogGameEnd.dismiss();
            }
        });
        //вызов диалогового окнав конце игры-  конец


        //кнопка продолжить
        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

        //код для кнопк назад- переход на лэвэлы
        Button btnBack = (Button)findViewById(R.id.button_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level10.this,GameLevels.class);
                    startActivity(intent);
                    finish();

                }
                catch (Exception e){

                }
            }
        });


        //массив для прогресса инры-начало
        final int[] progress ={
                R.id.point1,R.id.point2,R.id.point3,R.id.point4,R.id.point5,R.id.point6,R.id.point7,R.id.point8,R.id.point9,R.id.point10,
                R.id.point11,R.id.point12,R.id.point13,R.id.point14,R.id.point15,R.id.point16,R.id.point17,R.id.point18,R.id.point19,R.id.point20,

        };
        //массив для прогресса инры-конец

        // код подключения анимации-начало
        final Animation a = AnimationUtils.loadAnimation(Level10.this,R.anim.alhpa);
        // код подключения анимации-конец
        numLeft = random.nextInt(20);
        imgLeft.setImageResource(array.images10[numLeft]);//достаем из массива картинку
        text_left.setText(array.texts10[numLeft]);//достаем ткст из массива

        numRight = random.nextInt(20);
        //проверка на равенство чисел
        while (array.strong[numLeft]==array.strong[numRight]){
            numRight = random.nextInt(20);
        }

        imgRight.setImageResource(array.images10[numRight]);
        text_right.setText(array.texts10[numRight]);


        //обрабатывае нажатие на левую картинку-начало
        imgLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //условие касания картинки-начало
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    //eсли коснулся артинки-начало
                    imgRight.setEnabled(false);
                    if(array.strong[numLeft]>array.strong[numRight]){
                        imgLeft.setImageResource(R.drawable.img_true);
                    }
                    else imgLeft.setImageResource(R.drawable.img_false);
                    //eсли коснулся картинки-конец
                }
                //условие касания картинки-конец

                //если оптустил палец-начало
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    if (array.strong[numLeft]>array.strong[numRight]) {
                        //если левая картинка больше
                        if (count < 20) {
                            count = count + 1;
                        }

                        //закрашиваем прогресс серым цветом-начало
                        for (int i=0; i<2; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом-конец

                        //определяем правильные ответы и закрашиваем зеленым-начало
                        for(int i = 0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем зеленым-конец

                    }else {
                        //если левая картинка меньше
                        if(count>0){
                            if(count==1) {
                                count = 0;
                            }
                            else {
                                count = count-1 ;
                            }
                        }
                        //закрашиваем прогресс серым цветом-начало
                        for (int i=0; i<19 ; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом-конец

                        //определяем правильные ответы и закрашиваем зеленым-начало
                        for(int i = 0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем зеленым-конец

                    }
                    if(count==20) {
                        //ВЫХОД ИЗ УРОвНЯ
                        dialogGameEnd.show();
                    }
                    else{
                        numLeft = random.nextInt(20);
                        imgLeft.setImageResource(array.images10[numLeft]);//достаем из массива картинку
                        text_left.setText(array.texts10[numLeft]);//достаем ткст из массива

                        numRight = random.nextInt(20);
                        //проверка на равенство чисел
                        while (array.strong[numLeft]==array.strong[numRight]){
                            numRight = random.nextInt(20);
                        }

                        imgRight.setImageResource(array.images10[numRight]);
                        text_right.setText(array.texts10[numRight]);

                        imgRight.setEnabled(true);//обратно включаем правую картинку

                    }

                    }

                //если оптустил палец-конец




            return true;}
        });
        //обрабатывае нажатие на левую картинку-конец

        //обрабатывае нажатие на правую картинку-начало
        imgRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //условие касания картинки-начало
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    //eсли коснулся артинки-начало
                    imgLeft .setEnabled(false);//блочим левую картинку
                    if(array.strong[numLeft]<array.strong[numRight]){
                        imgRight.setImageResource(R.drawable.img_true);
                    }
                    else imgRight.setImageResource(R.drawable.img_false);
                    //eсли коснулся картинки-конец
                }
                //условие касания картинки-конец

                //если оптустил палец-начало
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    if (array.strong[numLeft]<array.strong[numRight]) {
                        //если правая картинка больше
                        if (count < 20) {
                            count = count + 1;
                        }

                        //закрашиваем прогресс серым цветом-начало
                        for (int i=0; i<2; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом-конец

                        //определяем правильные ответы и закрашиваем зеленым-начало
                        for(int i = 0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем зеленым-конец

                    }else {
                        //если правая картинка меньше
                        if(count>0){
                            if(count==1) {
                                count = 0;
                            }
                            else {
                                count = count-1 ;
                            }
                        }
                        //закрашиваем прогресс серым цветом-начало
                        for (int i=0; i<19 ; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом-конец

                        //определяем правильные ответы и закрашиваем зеленым-начало
                        for(int i = 0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем зеленым-конец

                    }
                    if(count==20) {
                        //ВЫХОД ИЗ УРОвНЯ
                        dialogGameEnd.show();
                    }
                    else{
                        numLeft = random.nextInt(20);
                        imgLeft.setImageResource(array.images10[numLeft]);//достаем из массива картинку
                        text_left.setText(array.texts10[numLeft]);//достаем ткст из массива

                        numRight = random.nextInt(20);
                        //проверка на равенство чисел
                        while (array.strong[numLeft]==array.strong[numRight]){
                            numRight = random.nextInt(20);
                        }

                        imgRight.setImageResource(array.images10[numRight]);
                        text_right.setText(array.texts10[numRight]);

                        imgLeft.setEnabled(true);//обратно включаем левую картинку

                    }

                }

                //если оптустил палец-конец




                return true;}
        });
        //обрабатывае нажатие на правую картинку-конец
    }

    @Override

    public void onBackPressed(){
        try {

        }
        catch (Exception e){}

    }


}