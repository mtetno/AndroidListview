package com.mtetno.mymasterpeice_selector_for_listview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class DummyActivity extends Activity   {

    private ListView mExamsListView;
    private ArrayList<String> mExamsDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dummy_activity);

    }
}
