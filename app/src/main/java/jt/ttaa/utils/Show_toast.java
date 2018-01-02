package jt.ttaa.utils;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jt.ttaa.customview.banner.BannerLayout;

/**
 * Created by Administrator on 2016/11/4.
 */
public class Show_toast {
    // 构造方法私有化 不允许new对象
    private Show_toast() {
    }
    // Toast对象
    private static Toast toast = null;

    /**
     * 显示Toast
     */
    public static void showText(Context context, String text) {
        List<ImageView> list = new ArrayList<ImageView>();
        if (toast == null) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
        toast.setText(text);
        toast.show();

    }
}
