package com.example.lenovo.test5;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {

    private List<News> newsList = new ArrayList<>();

    private RollPagerView mRollViewPager;

    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_fragment3, container, false);
        initNews();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.news_recycler_view2) ;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        NewsAdapter newsadapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(newsadapter);
        mRollViewPager = (RollPagerView) view.findViewById(R.id.roll_view_pager2);

        //设置播放时间间隔
        mRollViewPager.setPlayDelay(3000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());

        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        Context context =getContext();
        mRollViewPager.setHintView(new ColorPointHintView(context, Color.YELLOW,Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);
        return view;

    }

    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.img5,
                R.drawable.img6,
                R.drawable.img7,
                R.drawable.img8,
        };

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    private void initNews() {
        for (int i = 0; i<3;i++) {
            News news1 = new News("我校学生自主制造的第一台3D打印机胜利诞生", "2018-5-23", "aixin", R.drawable.new4);
            newsList.add(news1);
            News news2 = new News("“锦城创业教育催生最牛“奶霸”  ", "2018-5-23", "aixin", R.drawable.news5 );
            newsList.add(news2);
            News news3 = new News("三练三创”结硕果 模拟公司成就学生CEO  ", "2018-5-23", "aixin", R.drawable.new6);
            newsList.add(news3);
            News news4 = new News("川大锦城小清新男生寝室走红网络 网友直呼：让女生情何以堪  ", "2018-5-23", "aixin", R.drawable.new7);
            newsList.add(news4);
            News news5 = new News("“锦城好人”最美女孩情暖人间  ", "2018-5-23", "aixin", R.drawable.new8);
            newsList.add(news5);
            News news6 = new News("生死抉择中 舍己救人是青春的感恩和光荣   ", "2018-5-23", "aixin", R.drawable.new9);
            newsList.add(news6);
        }
    }

}
