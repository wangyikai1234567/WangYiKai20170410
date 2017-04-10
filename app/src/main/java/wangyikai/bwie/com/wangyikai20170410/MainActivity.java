package wangyikai.bwie.com.wangyikai20170410;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTb;
    private ViewPager mVp;
    private List<Fragment> mFragmentList;
    private List<String> mTitleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        initView();
        //添加标题
        initTitile();
        //添加fragment
        initFragment();
        //设置适配器
        mVp.setAdapter(new MyPgaerAdapter(getSupportFragmentManager(), mFragmentList, mTitleList));
        //将tablayout与fragment关联
        mTb.setupWithViewPager(mVp);
    }

    private void initTitile() {
        mTitleList = new ArrayList<>();
        mTitleList.add("头条");
        mTitleList.add("国际");
        mTitleList.add("时尚");
        mTitleList.add("财经");
        mTitleList.add("科技");
        mTitleList.add("军事");
        mTitleList.add("体育");
        mTitleList.add("娱乐");
        mTitleList.add("国内");
        mTitleList.add("社会");

        //设置tablayout模式
        mTb.setTabMode(TabLayout.MODE_SCROLLABLE);
        //tablayout获取集合中的名称
        mTb.addTab(mTb.newTab().setText(mTitleList.get(0)));
        mTb.addTab(mTb.newTab().setText(mTitleList.get(1)));
        mTb.addTab(mTb.newTab().setText(mTitleList.get(2)));
        mTb.addTab(mTb.newTab().setText(mTitleList.get(3)));
        mTb.addTab(mTb.newTab().setText(mTitleList.get(4)));
        mTb.addTab(mTb.newTab().setText(mTitleList.get(5)));
        mTb.addTab(mTb.newTab().setText(mTitleList.get(7)));
        mTb.addTab(mTb.newTab().setText(mTitleList.get(6)));
        mTb.addTab(mTb.newTab().setText(mTitleList.get(8)));
        mTb.addTab(mTb.newTab().setText(mTitleList.get(9)));
    }

    private void initFragment() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(MyFragment.newInstance("tt"));
        mFragmentList.add(MyFragment.newInstance("gj"));
        mFragmentList.add(MyFragment.newInstance("ss"));
        mFragmentList.add(MyFragment.newInstance("cj"));
        mFragmentList.add(MyFragment.newInstance("kj"));
        mFragmentList.add(MyFragment.newInstance("js"));
        mFragmentList.add(MyFragment.newInstance("ty"));
        mFragmentList.add(MyFragment.newInstance("yl"));
        mFragmentList.add(MyFragment.newInstance("gn"));
        mFragmentList.add(MyFragment.newInstance("shehui"));

    }

    private void initView() {
        mTb = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
    }
}
