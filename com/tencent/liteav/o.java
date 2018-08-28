package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;

public class o {
    public static m a(Context context, int i) {
        if (i != 2 && i != 4 && i != 4 && i != 6 && i != 3) {
            return new e(context);
        }
        TXCLog.e("TXSDKUtil", "create player error not support type : " + i);
        return null;
    }

    public static String a() {
        return "";
    }
}
