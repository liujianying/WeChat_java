package com.tencent.xweb;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.c.i;
import com.tencent.xweb.xwalk.b;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class g {
    private static String vAa = "";
    public static a vzY;
    public volatile boolean fwD = false;
    public com.tencent.xweb.c.g vzZ;

    public enum a {
        RT_TYPE_AUTO,
        RT_TYPE_SYS,
        RT_TYPE_XWALK,
        RT_TYPE_WEB_X5,
        RT_TYPE_DUMMY,
        RT_TYPE_X5,
        RT_TYPE_J2V8,
        RT_TYPE_NATIVE_SCRIPT,
        RT_TYPE_MMV8
    }

    public static a cIl() {
        return vzY;
    }

    public final boolean isValid() {
        return (this.vzZ == null || vzY == a.RT_TYPE_AUTO || vzY == a.RT_TYPE_DUMMY) ? false : true;
    }

    public static String cIm() {
        return vAa;
    }

    public static g a(a aVar, String str, Context context) {
        return new g(aVar, str, context);
    }

    public static a b(a aVar, String str, Context context) {
        k.ik(context);
        if (str == null) {
            str = "";
        }
        if (k.cIn().vAu != a.RT_TYPE_AUTO) {
            aVar = k.cIn().vAu;
            XWalkEnvironment.addXWalkInitializeLog("XWeb", "use hardcode jscore type = " + aVar);
        } else if (a.adw(str) != a.RT_TYPE_AUTO) {
            aVar = a.adw(str);
            XWalkEnvironment.addXWalkInitializeLog("XWeb", "module " + str + "use cmd jscore type = " + aVar);
        }
        if (WebView.getCurWebType() == d.vAQ) {
            if (a.RT_TYPE_SYS == aVar || a.RT_TYPE_MMV8 == aVar) {
                return aVar;
            }
            return a.RT_TYPE_X5;
        } else if (WebView.getCurWebType() == d.vAP) {
            if (a.RT_TYPE_NATIVE_SCRIPT == aVar || a.RT_TYPE_J2V8 == aVar || a.RT_TYPE_SYS == aVar) {
                return aVar;
            }
            return a.RT_TYPE_MMV8;
        } else if (WebView.getCurWebType() != d.vAR || a.RT_TYPE_SYS == aVar) {
            return aVar;
        } else {
            return a.RT_TYPE_MMV8;
        }
    }

    private g(a aVar, String str, Context context) {
        a aVar2;
        Log.i("JsRuntime", String.format("init JsRuntime (%s)", new Object[]{android.util.Log.getStackTraceString(new Throwable())}));
        a b = b(aVar, str, context);
        switch (1.vAb[b.ordinal()]) {
            case 1:
                this.vzZ = i.b(d.vAQ).getJsCore(b, context);
                if (this.vzZ != null) {
                    vAa = "x5";
                    break;
                }
                break;
            case 2:
            case 3:
                this.vzZ = i.b(d.vAP).getJsCore(b, context);
                if (this.vzZ != null) {
                    vAa = b == a.RT_TYPE_J2V8 ? "j2v8" : "nativeScript";
                    break;
                }
                break;
            case 4:
                this.vzZ = new b();
                this.vzZ.init(0);
                vAa = "mmv8";
                break;
        }
        if (this.vzZ != null) {
            aVar2 = b;
        } else if (a.RT_TYPE_SYS == b || a.RT_TYPE_X5 == b) {
            aVar2 = a.RT_TYPE_DUMMY;
            this.vzZ = new com.tencent.xweb.c.d();
        } else {
            aVar2 = a.RT_TYPE_MMV8;
            this.vzZ = new b();
            this.vzZ.init(0);
            vAa = "mmv8";
        }
        vzY = aVar2;
        Log.d("JsRuntime", "xxx IJsRuntime  request=" + aVar2.toString() + ", create=" + vAa);
    }

    public final void cleanup() {
        if (!this.fwD) {
            this.vzZ.cleanup();
        }
        this.fwD = true;
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.fwD) {
            this.vzZ.evaluateJavascript(str, valueCallback);
        }
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.vzZ.addJavascriptInterface(obj, str);
    }

    public final void pause() {
        this.vzZ.pause();
    }

    public final void resume() {
        this.vzZ.resume();
    }

    public final boolean CY() {
        return this.vzZ.CY();
    }
}
