package wangyikai.bwie.com.wangyikai20170410;

import android.app.ProgressDialog;
import android.content.DialogInterface;
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
    private Bundle mArguments;
    private ProgressDialog mMypDialog;


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
        mArguments = getArguments();
        mTag = mArguments.getString("tag");


        MyHttpUtils my = new MyHttpUtils(mLv, getActivity());
        my.getHttps(mTag);


    }

    private void setPro() {
        //实例化一个进度条对话框
        mMypDialog = new ProgressDialog(getActivity());
        mMypDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);         //设置进度条风格         //设置进度条标题
        mMypDialog.setMessage("正在努力加载，请稍后");                        //设置提示信息
        mMypDialog.setIcon(R.mipmap.ic_launcher);                                               //设置图标
        mMypDialog.setIndeterminate(true);                                                          //设置是否精度显示进度
        mMypDialog.setCancelable(false);                                                            //设置是否触屏取消
        mMypDialog.show();
    }


}
