package com.tencent.xweb;

import android.content.Context;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.util.e;
import java.util.HashMap;
import org.xwalk.core.Log;

public final class i {
    static a vAm = ((a) com.tencent.xweb.c.i.b(d.vAP).excute("STR_CMD_GET_UPDATER", null));

    public static void a(Context context, HashMap<String, String> hashMap) {
        e.cJh();
        if (vAm != null) {
            vAm.a(context, hashMap);
        } else {
            Log.e("WCWebUpdater", "no sWebviewUpdater");
        }
    }

    public static boolean isBusy() {
        if (vAm != null) {
            return vAm.isBusy();
        }
        Log.e("WCWebUpdater", "check is busy : no sWebviewUpdater");
        return false;
    }
}
