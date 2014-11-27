package com.mtetno.mymasterpeice_selector_for_listview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

/**
 * 
 * @author Monika L
 * 
 */

/*
 * Home Activity basically lauches the all exams view in listview
 */

public class MainActivity extends Activity {

    private ListView mExamsListView;
    private ArrayList<String> mExamsDataArrayList;
    private Button btContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exams_activity);
        mExamsListView = (ListView) findViewById(R.id.examsListview);
        btContinue = (Button) findViewById(R.id.btContinue);

        btContinue.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent categoryGridViewActivity = new Intent(
                        MainActivity.this, DummyActivity.class);
                categoryGridViewActivity.putExtra("position",
                        mExamsListView.getCheckedItemPosition());
                startActivity(categoryGridViewActivity);
            }
        });

        mExamsDataArrayList = new ArrayList<String>();
        // HardCording the Arraylist -- > need to populate the listview from
        // webservices
        mExamsDataArrayList.add("Exam 1");
        mExamsDataArrayList.add("Exam 2");
        mExamsDataArrayList.add("Exam 3");
        mExamsDataArrayList.add("Exam 4");
        mExamsDataArrayList.add("Exam 5");
        mExamsDataArrayList.add("Exam 6");

        ExamsActivityAdapter examsActivityAdapter = new ExamsActivityAdapter(
                MainActivity.this, mExamsDataArrayList);

        mExamsListView.setAdapter(examsActivityAdapter);
        mExamsListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        mExamsListView.setItemChecked(1, true);

    }
}