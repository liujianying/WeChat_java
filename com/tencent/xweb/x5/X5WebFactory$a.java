package com.tencent.xweb.x5;

import android.content.Context;
import android.widget.TextView;
import com.tencent.smtt.utils.TbsLogClient;
import org.xwalk.core.Log;

class X5WebFactory$a extends TbsLogClient {
    final /* synthetic */ X5WebFactory vDN;

    public X5WebFactory$a(X5WebFactory x5WebFactory, Context context) {
        this.vDN = x5WebFactory;
        super(context);
    }

    public final void writeLog(String str) {
        super.writeLog(str);
    }

    public final void writeLogToDisk() {
        super.writeLogToDisk();
    }

    public final void showLog(String str) {
        super.showLog(str);
    }

    public final void setLogView(TextView textView) {
        super.setLogView(textView);
    }

    public final void i(String str, String str2) {
        super.i(str, str2);
        Log.i(str, str2);
    }

    public final void e(String str, String str2) {
        super.e(str, str2);
        Log.e(str, str2);
    }

    public final void w(String str, String str2) {
        super.w(str, str2);
        Log.w(str, str2);
    }

    public final void d(String str, String str2) {
        super.d(str, str2);
        Log.d(str, str2);
    }

    public final void v(String str, String str2) {
        super.v(str, str2);
        Log.v(str, str2);
    }
}
