package wangyikai.bwie.com.wangyikai20170410;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.ListView;
import com.google.gson.Gson;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;
/**
 * date: 2017/4/10.
 * author: 王艺凯 (lenovo )
 * function:
 */

public class MyHttpUtils {


    private ListView mListView;
    private Context mContext;
    private ProgressDialog mMypDialog;

    public MyHttpUtils(ListView mListView, Context context) {
        this.mListView = mListView;
        mContext = context;
    }

    public void getHttps(String tag) {
        RequestParams params = new RequestParams(MyUrls.MURL);
        params.addQueryStringParameter("uri", tag);

        x.http().get(params, new Callback.CacheCallback<String>() {

            private String result;

            @Override
            public boolean onCache(String result) {
                this.result = result;
                setPro();
                return false;
            }

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                //对象
                MyBean myBean = gson.fromJson(result, MyBean.class);

                mListView.setAdapter(new MyBaseAdapter(myBean, mContext));
                mMypDialog.dismiss();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void setPro() {
        //实例化一个进度条对话框
        mMypDialog = new ProgressDialog(mContext);
        mMypDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);         //设置进度条风格         //设置进度条标题
        mMypDialog.setMessage("正在努力加载，请稍后");                        //设置提示信息
        mMypDialog.setIcon(R.mipmap.ic_launcher);                                               //设置图标
        mMypDialog.setIndeterminate(true);                                                          //设置是否精度显示进度
        mMypDialog.setCancelable(false);                                                            //设置是否触屏取消
        mMypDialog.show();
    }
}

