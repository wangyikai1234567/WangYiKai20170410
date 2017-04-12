package wangyikai.bwie.com.wangyikai20170410;

import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.gson.Gson;
import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.ex.DbException;
import org.xutils.http.RequestParams;
import org.xutils.x;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTb;
    private ViewPager mVp;
    private List<MyTitleBean.ResultBean.DateBean> mMyTitle;
    private ArrayList<ChildInfo> childInfos = new ArrayList<>();
    private String mUri;
    private String mTitle;
    private int mT_id;
    private DbManager mDbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        //添加标题

        MyApplication myApplication = new MyApplication();
        mDbManager = myApplication.getDaoCnfig();
        if (NetworkUtils.isConnected() == true) {
            initTitile();
        } else {
            setPro();
        }
    }

    private void setPro() {
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setTitle("是否打开wifi");
        ab.setPositiveButton("设置wifi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                NetworkUtils.openWirelessSettings();
            }
        });
        ab.setNegativeButton("继续", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                initTitile();
            }
        });
        ab.show();
    }

    private void initTitile() {
        RequestParams params = new RequestParams(MyUrls.TITLE);
        params.addQueryStringParameter("uri", "news");

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
                MyTitleBean mtb = gson.fromJson(result, MyTitleBean.class);
                mMyTitle = mtb.getResult().getDate();

                for (int i = 0; i < mMyTitle.size(); i++) {
                    mUri = mMyTitle.get(i).getUri();
                    mTitle = mMyTitle.get(i).getTitle();
                    mT_id = mMyTitle.get(i).getId();
                    //用集合向child_info表中插入多条数据
                    childInfos.add(new ChildInfo(0, mT_id, mTitle, mUri));
                }
                try {
                    mDbManager.save(childInfos);
                } catch (DbException e) {
                    e.printStackTrace();
                }
                tabViewPager();
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
    private void tabViewPager() {
        //设置tablayout模式
        mTb.setTabMode(TabLayout.MODE_SCROLLABLE);
        mVp.setAdapter(new MyPgaerAdapter(getSupportFragmentManager(), mMyTitle));
        //将tablayout与fragment关联
        mTb.setupWithViewPager(mVp);
    }

    private void initView() {
        mTb = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
    }
}
