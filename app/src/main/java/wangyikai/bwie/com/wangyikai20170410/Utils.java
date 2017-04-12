package wangyikai.bwie.com.wangyikai20170410;

import android.content.Context;

/**
 * date: 2017/4/12.
 * author: 王艺凯 (lenovo )
 * function:
 */
public final class Utils {

    private static Context context;

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }
    public static void init(Context context) {
        Utils.context = context.getApplicationContext();
    }
    public static Context getContext() {
        if (context != null) return context;
        throw new NullPointerException("u should init first");
    }
}