package com.mtetno.mymasterpeice_selector_for_listview;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ExamsActivityAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflator;
    private static String TAG = "ExamsActivityAdapter";
    private ArrayList<String> mExams;
    private ViewGroup mParent;

    public ExamsActivityAdapter(Context context, ArrayList<String> exams) {
        // TODO Auto-generated constructor stub
        this.mContext = context;
        mInflator = LayoutInflater.from(context);
        this.mExams = exams;

    }

    @Override
    public int getCount() {
        return mExams.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Planet to display
        String item = mExams.get(position);
        mParent = parent;
        TextView examName;
        ImageView icon;

        // Create a new row view
        if (convertView == null) {
            convertView = mInflator.inflate(R.layout.exams_activity_row, null);

            // Find the child views.
            examName = (TextView) convertView.findViewById(R.id.examName);
            icon = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(new Holder(examName, icon,position));
        }

        // Reuse existing row view
        else {
            // Because we use a ViewHolder, we avoid having to call
            // findViewById().
            Holder viewHolder = (Holder) convertView.getTag();

            examName = viewHolder.getExamName();

            icon = viewHolder.getIcon();
        }

        examName.setText(item);

        convertView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                View clickedView = v;
                //
                 Holder holderItem =(Holder) clickedView.getTag();
                //icon.setBackgroundColor(Color.RED);
                //
                // clickedView.setBackgroundColor(Color.GREEN);
                ((ListView) mParent).setItemChecked(holderItem.getPosition(), true);

            }
        });

        return convertView;

    }

    public class Holder {

        private TextView examName;

        private ImageView icon;

        private int position;

        public Holder() {
        }

        public Holder(TextView tvName, ImageView icn, int pos) {

            this.examName = tvName;

            this.icon = icn;

            this.position = pos;
        }

        public TextView getExamName() {
            return examName;
        }

        public void setExamName(TextView graphName) {
            this.examName = graphName;
        }

        public ImageView getIcon() {
            return icon;
        }

        public void setIcon(ImageView icon) {
            this.icon = icon;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

    }
}
