package jt.ttaa.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import jt.ttaa.R;
import jt.ttaa.model.bean.item_banner;
import jt.ttaa.utils.Sp;

public class BannerAdapter extends PagerAdapter {

    private Context context;
    private List<item_banner> newsList;
    private ViewPager mViewPager;

    public BannerAdapter(Context context, List<item_banner> list, ViewPager mViewPager) {
        this.context = context;
        this.newsList = list;
        this.mViewPager = mViewPager;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position %= Sp.INSTANCE.getDEFAULT_BANNER_SIZE();
        View view = LayoutInflater.from(context).inflate(R.layout.carousel_image, container, false);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        ImageLoader.getInstance().displayImage(newsList.get(position).getUrl(), image);
        final String link = newsList.get(position).getLink();
        final String title = newsList.get(position).getTitle();
        System.out.println("link" + link);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!link.equals("")) {
//                    Intent intent = new Intent(context, web_view_info.class);
//                    intent.putExtra("web_url", link);
//                    intent.putExtra("title", title);
//                    context.startActivity(intent);
//                }
//            }
//        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        int position = mViewPager.getCurrentItem();
        if (position == 0) {
            position = Sp.INSTANCE.getDEFAULT_BANNER_SIZE();
        }
        Sp.INSTANCE.setNow_BANNER_SIZE(position);
        mViewPager.setCurrentItem(position, false);
    }
}