package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.util.Log;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

class c$1 implements Runnable {
    c$1() {
    }

    public final void run() {
        a aVar = b.dnp;
        c fJ = a.fJ("100284");
        if (fJ == null) {
            x.i("MicroMsg.WidgetDrawableViewFactory", "widget canvas mode ABTest item is null.");
        } else if (fJ.isValid()) {
            try {
                c.ki(bi.getInt((String) fJ.ckq().get("mode"), 0));
                x.i("MicroMsg.WidgetDrawableViewFactory", "current canvas mode is : %d", new Object[]{Integer.valueOf(c.bB())});
            } catch (Throwable e) {
                x.w("MicroMsg.WidgetDrawableViewFactory", "parse widget canvas mode error : %s", new Object[]{Log.getStackTraceString(e)});
            }
        } else {
            c.ki(0);
        }
    }
}
