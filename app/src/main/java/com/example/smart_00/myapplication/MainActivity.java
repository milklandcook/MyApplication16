package com.example.smart_00.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("대화상자 다루기");
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] versionArray = {"마시멜로", "누가", "오레오"};
                final boolean[] checkArray = {true, false, false};
                //1> 클래스
                AlertDialog.Builder dlg =
                        new AlertDialog.Builder(MainActivity.this);
                //2> 모양
                dlg.setTitle("창 제목 ");
                dlg.setIcon(R.mipmap.ic_launcher);
                //dlg.setMessage(" 창에 보여지는 내용"); //간단한메시지가 들어간 창

                //목록으로 보여지는 창 setMessage대신에 setItems 로 변경
//                dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        button1.setText(versionArray[which]);
//                        //which ==> 몇번째 값인지 위치
//                    }
//                });

//                //setItems대신에 setSingleChoiceItems() :라디오 버튼으로 보여짐
//                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        button1.setText(versionArray[which]);
//
//                    }
//                });

                //setSingleChoiceItems() 대신에 setMultiChoiceItems()로 변경
                dlg.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        button1.setText(versionArray[which]);
                    }
                });





                //버튼 1개
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText
                                (getApplicationContext(),"확인눌렀음",
                                        Toast.LENGTH_SHORT).show();
                    }
                });

                dlg.setNegativeButton("취소", null);
                dlg.setNeutralButton("중간기능",null);
                //3> 보여주기
                dlg.show();

            }
        });

    }
}
