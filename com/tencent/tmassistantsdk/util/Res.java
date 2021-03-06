package com.tencent.tmassistantsdk.util;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class Res {
    private static final String TAG = "Res";
    protected final String RclassName = (this.ctx.getPackageName() + ".R");
    protected Context ctx;

    public Res(Context context) {
        this.ctx = context;
    }

    private int reflectResouce(String str, String str2) {
        int i = -1;
        if (this.RclassName == null || str == null || str2 == null) {
            return 0;
        }
        try {
            Class cls = Class.forName(this.RclassName + "$" + str);
            return bi.getInt(cls.getField(str2).get(cls.newInstance()).toString(), -1);
        } catch (Throwable e) {
            x.printErrStackTrace(TAG, e, "", new Object[0]);
            return i;
        }
    }

    public int string(String str) {
        return reflectResouce("string", str);
    }

    public int drawable(String str) {
        return reflectResouce("drawable", str);
    }

    public int layout(String str) {
        return reflectResouce("layout", str);
    }

    public int id(String str) {
        return reflectResouce("id", str);
    }

    public int style(String str) {
        return reflectResouce("style", str);
    }
}
