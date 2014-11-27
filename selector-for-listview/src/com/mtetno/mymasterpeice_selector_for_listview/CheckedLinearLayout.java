package com.mtetno.mymasterpeice_selector_for_listview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CheckedLinearLayout extends LinearLayout implements Checkable {
    private boolean mChecked;

    public CheckedLinearLayout(Context context) {
        super(context);
    }

    public CheckedLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setChecked(boolean checked) {
        mChecked = checked;

        // Use this code for setting custom color in background of this layout
        setBackgroundDrawable(checked ? new ColorDrawable(
                android.graphics.Color.LTGRAY) : null);

        // Use this code for setting custom image in background of this layout
        /*
         * setBackgroundResource(checked ? R.drawable.ic_action_search :
         * R.drawable.ic_launcher);
         */

        // Propagate to childs
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            ImageView img = (ImageView) child.findViewById(R.id.icon);
            if (checked) {
                img.setImageResource(R.drawable.arrow__select);
            } else {
                img.setImageResource(R.drawable.arrow_right);
            }
        }
    }

    public boolean isChecked() {
        return mChecked;
    }

    public void toggle() {
        setChecked(!mChecked);
    }

}
