package wangyikai.bwie.com.wangyikai20170410;

import android.app.Application;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import org.xutils.DbManager;
import org.xutils.x;
/**
 * date: 2017/4/10.
 * author: 王艺凯 (lenovo )
 * function:
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(getApplicationContext()).memoryCacheExtraOptions(480, 800).build();
        ImageLoader.getInstance().init(imageLoaderConfiguration);
        x.Ext.init(this);
        x.Ext.setDebug(false); //输出debug日志，开启会影响性能
        Utils.init(this);
        return;
    }

    public static DbManager getDaoCnfig() {
       DbManager.DaoConfig daoConfig =  new DbManager.DaoConfig()
                .setDbName("title.db")
                .setDbVersion(1);
        return x.getDb(daoConfig);
    }
}
