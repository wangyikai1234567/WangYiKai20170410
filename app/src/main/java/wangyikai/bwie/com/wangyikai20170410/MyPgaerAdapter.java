package wangyikai.bwie.com.wangyikai20170410;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * date: 2017/4/10.
 * author: 王艺凯 (lenovo )
 * function:
 */

public class MyPgaerAdapter extends FragmentPagerAdapter {
    private List<MyTitleBean.ResultBean.DateBean> mTilteLis;

    public MyPgaerAdapter(FragmentManager fm, List<MyTitleBean.ResultBean.DateBean> tilteLis) {
        super(fm);
        mTilteLis = tilteLis;
    }

    @Override
    public Fragment getItem(int position) {
       Fragment fragment=MyFragment.newInstance(mTilteLis.get(position).getUri());
        return fragment;
    }

    @Override
    public int getCount() {
        return mTilteLis.size();
    }

    //获取标题
    @Override
    public CharSequence getPageTitle(int position) {
        return mTilteLis.get(position).getTitle();
    }
}
