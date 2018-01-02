package jt.ttaa.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jt.ttaa.R;

/**
 * Created by SKL on 2017/12/26.
 */

public class CustomTitlebar extends RelativeLayout {
    private RelativeLayout Titlebar_left;
    private TextView Titlebar_center;
    private RelativeLayout Titlebar_right;

    public CustomTitlebar(Context context) {
        this(context, null);
    }

    public CustomTitlebar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTitlebar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.view_customtitlebar, this);
        Titlebar_center = findViewById(R.id.Titlebar_center);
        Titlebar_left = findViewById(R.id.Titlebar_left);
        Titlebar_right = findViewById(R.id.Titlebar_right);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CustomTitlebar);
        int n = ta.getIndexCount();
        for (int i = 0; i < n; i++) {

            int attr = ta.getIndex(i);
            switch (attr) {
                case R.styleable.CustomTitlebar_Titlebar_left:
                    int b = ta.getResourceId(n,R.mipmap.ic_launcher);
                    Titlebar_left.setVisibility(VISIBLE);
                    ImageView img = Titlebar_left.findViewById(R.id.Title_left_nei);
                    img.setImageResource(b);
                    break;
                case R.styleable.CustomTitlebar_Titlebar_center:
                    String z = ta.getString(n);
                    if (z == null || z.length() <= 0) {
                        Titlebar_center.setVisibility(GONE);
                    } else {
                        Titlebar_center.setVisibility(VISIBLE);
                        Titlebar_center.setText(z);
                    }
                    break;
                case R.styleable.CustomTitlebar_Titlebar_right:
                    int v = ta.getResourceId(n,R.mipmap.ic_launcher);
                    Titlebar_right.setVisibility(VISIBLE);
                    ImageView img2 = Titlebar_right.findViewById(R.id.Titlebar_right_nei);
                    img2.setImageResource(v);
                    break;
            }
        }
    }
}
