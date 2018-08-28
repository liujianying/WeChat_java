package com.tencent.xweb;

import android.content.Context;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.c.i;
import com.tencent.xweb.c.i$a;
import com.tencent.xweb.util.b;
import com.tencent.xweb.util.e;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class r {
    static boolean vAT = false;
    static boolean vAU = false;

    public static void a(Context context, b bVar) {
        a(context, bVar, null, null);
    }

    public static synchronized void a(Context context, b bVar, q qVar, WebViewExtensionListener webViewExtensionListener) {
        synchronized (r.class) {
            if (bVar != null) {
                Log.SetLogCallBack(bVar);
            }
            if (qVar != null) {
                e.a(qVar);
            }
            if ((context != null && XWalkEnvironment.getApplicationContext() == null) || !vAT) {
                vAT = true;
                XWalkEnvironment.init(context);
                i$a b = i.b(d.vAP);
                if (b != null) {
                    b.initEnviroment(context);
                }
                b = i.b(d.vAQ);
                if (b != null) {
                    b.initEnviroment(context);
                }
            }
            if (webViewExtensionListener != null) {
                i.b(d.vAP).initCallback(webViewExtensionListener);
            }
        }
    }

    public static synchronized void initInterface() {
        synchronized (r.class) {
            if (!vAU) {
                vAU = true;
                i$a b = i.b(d.vAP);
                if (b != null) {
                    b.initInterface();
                }
                b = i.b(d.vAQ);
                if (b != null) {
                    b.initInterface();
                }
            }
        }
    }
}
