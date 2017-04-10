package wangyikai.bwie.com.wangyikai20170410;

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
                return false;
            }
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                //对象
              MyBean myBean= gson.fromJson(result,MyBean.class);

                mListView.setAdapter(new MyBaseAdapter(myBean,mContext));
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
}
