package wangyikai.bwie.com.wangyikai20170410;

/**
 * date: 2017/4/12.
 * author: 王艺凯 (lenovo )
 * function:
 */

import java.io.Closeable;

        import java.io.IOException;

public final class CloseUtils {

    private CloseUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void closeIO(Closeable... closeables) {
        if (closeables == null) return;
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
