package com.example.lenovo.test5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {
    private List<News> newsList = new ArrayList<>();

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragment2, container, false);
        View view =inflater.inflate(R.layout.fragment_fragment2, container, false);
        initNews();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.news_recycler_view) ;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        NewsAdapter newsadapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(newsadapter);
        return view;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    private void initNews() {
        for (int i = 0; i<3;i++) {
            News news1 = new News("思考未来 方可赢得未来——《未来型教育论坛学术论文集》付梓成书", "2018-5-23", "aixin", R.drawable.news1);
            newsList.add(news1);
            News news2 = new News("“一体两翼”成果显 我校学子斩特奖 ", "2018-5-23", "aixin", R.drawable.news2);
            newsList.add(news2);
            News news3 = new News("我校财务会计学院与华西证券签订校企合作协议 ", "2018-5-23", "aixin", R.drawable.news3);
            newsList.add(news3);
        }
    }

}
