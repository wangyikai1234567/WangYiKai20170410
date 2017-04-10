package wangyikai.bwie.com.wangyikai20170410;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import org.xutils.x;

public class MyFragment extends Fragment {

    public ListView mLv;
    private String mTag;


    public static MyFragment newInstance(String tag) {
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tag", tag);
        //传递参数
        myFragment.setArguments(bundle);
        return myFragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_fragment, null);
        //初始化控件

        mLv = (ListView) view.findViewById(R.id.lv);
        x.view().inject(getActivity());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //获取参数
        Bundle arguments = getArguments();

        mTag = arguments.getString("tag");

        MyHttpUtils my = new MyHttpUtils(mLv,getActivity());
        my.getHttps(mTag);
    }


}
