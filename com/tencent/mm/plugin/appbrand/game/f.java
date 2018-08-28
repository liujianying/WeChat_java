package com.tencent.mm.plugin.appbrand.game;

import android.webkit.ValueCallback;
import com.tencent.magicbrush.engine.b;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.d;
import java.net.URL;

public final class f implements a {
    private int fzX;
    b fzY;
    private boolean fzZ;

    public f(boolean z, b bVar, int i) {
        this.fzY = bVar;
        this.fzX = i;
        this.fzZ = z;
    }

    public final void addJavascriptInterface(Object obj, String str) {
        if (this.fzY != null) {
            this.fzY.d(obj, str);
        }
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.fzY == null || bi.oW(str)) {
            x.e("MicroMsg.WAGameJsContextImpl", "evaluate Error : [%s], [%s]", new Object[]{this.fzY, str});
            if (valueCallback != null) {
                valueCallback.onReceiveValue("");
                return;
            }
            return;
        }
        String bP = this.fzY.bP(str);
        if (valueCallback != null) {
            valueCallback.onReceiveValue(bi.oV(bP));
        }
    }

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        if (url == null) {
            evaluateJavascript(str, valueCallback);
        } else if (this.fzY == null || bi.oW(str)) {
            x.e("MicroMsg.WAGameJsContextImpl", "evaluate Error : [%s], [%s]", new Object[]{this.fzY, str});
            if (valueCallback != null) {
                valueCallback.onReceiveValue("");
            }
        } else {
            String r = this.fzY.r(str, url.toString());
            if (valueCallback != null) {
                valueCallback.onReceiveValue(bi.oV(r));
            }
        }
    }

    public final void setJsExceptionHandler(d dVar) {
    }

    public final void destroy() {
        if (this.fzY != null) {
            this.fzY.dispose();
        }
    }

    public final <T extends c> T y(Class<T> cls) {
        return null;
    }

    public final boolean afV() {
        return this.fzZ;
    }

    public final int afW() {
        return this.fzX;
    }

    public final void a(a aVar, String str) {
        if (aVar == null || bi.oW(str)) {
            x.e("MicroMsg.WAGameJsContextImpl", "shareObject object name is null [%s], [%s]", new Object[]{aVar, str});
        } else if (aVar instanceof f) {
            this.fzY.a(((f) aVar).fzY, str);
        } else {
            x.e("MicroMsg.WAGameJsContextImpl", "share Object with different JSContext type , [%s]", new Object[]{aVar});
        }
    }
}
