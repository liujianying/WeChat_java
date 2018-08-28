package com.tencent.mm.u.c;

import android.webkit.JavascriptInterface;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.b.c;
import com.tencent.mm.u.b.d;

public final class e {
    public volatile boolean Sx;
    public String doU;
    public c doV;
    public f doW;
    public d doX;
    private volatile boolean doY;
    public a doZ;

    @JavascriptInterface
    public final void publishHandler(String str, String str2, String str3) {
        int i = 0;
        String str4 = "MicroMsg.MiniJsBridge";
        String str5 = "publishHandler, event: %s, data size: %d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (str2 != null) {
            i = str2.length();
        }
        objArr[1] = Integer.valueOf(i);
        x.d(str4, str5, objArr);
    }

    @JavascriptInterface
    public final String invokeHandler(String str, String str2, int i) {
        if (this.Sx) {
            return this.doV.b(str, str2, i);
        }
        return this.doV.doO.H(str, "fail:JsApi core not started");
    }

    public final boolean a(c cVar) {
        f fVar = this.doW;
        if (cVar == null) {
            x.i("MicroMsg.MiniJsEventDispatcher", "dispatchJsEvent failed, event is null.");
            return false;
        }
        com.tencent.mm.u.b.e fO = fVar.dpa.fO(cVar.name);
        if (fO == null) {
            x.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[]{cVar});
            return false;
        } else if (fVar.doM.gu(fO.getIndex())) {
            String jSONObject = cVar.tR().toString();
            x.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[]{cVar.name, Integer.valueOf(jSONObject.length()), Integer.valueOf(0)});
            fVar.doX.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[]{cVar.name, jSONObject, "undefined", f.Db()}), null);
            return true;
        } else {
            x.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[]{cVar});
            return false;
        }
    }

    public final void b(c cVar) {
        if (!this.doY) {
            x.v("MicroMsg.MiniJsBridge", "onPause(%s)", new Object[]{this.doU});
            this.doY = true;
            if (this.doX.CY()) {
                this.doX.pause();
            } else {
                a(cVar);
            }
            if (this.doZ != null) {
                this.doZ.C(this.doU, 3);
            }
        }
    }

    public final void c(c cVar) {
        if (this.doY) {
            x.v("MicroMsg.MiniJsBridge", "onResume(%s)", new Object[]{this.doU});
            if (this.doX.CY()) {
                this.doX.resume();
            } else {
                a(cVar);
            }
            this.doY = false;
            if (this.doZ != null) {
                this.doZ.C(this.doU, 2);
            }
        }
    }

    public final void onStart() {
        if (!this.Sx) {
            x.v("MicroMsg.MiniJsBridge", "onStart(%s)", new Object[]{this.doU});
            this.Sx = true;
            if (this.doZ != null) {
                this.doZ.C(this.doU, 1);
            }
        }
    }
}
