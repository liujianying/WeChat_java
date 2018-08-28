package com.tencent.mm.plugin.appbrand.game;

import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.d;
import java.net.URL;

public final class g implements b {
    private h fAa;
    private boolean nY = false;

    public g(h hVar) {
        j jVar = j.fAf;
        x.i("MicroMsg.V8JsVmManager", "lm:GameRenderer.initJsVmContext ThreadName = [%s]", new Object[]{Thread.currentThread().getName()});
        if (jVar.fAg != null) {
            throw new IllegalStateException("Init JsVm Context second time");
        }
        int addAndGet = jVar.fAh.addAndGet(1);
        x.i("MicroMsg.V8JsVmManager", "lm:GameRenderer.initJsVmContext new WAGameJsContextImpl");
        jVar.fAg = new f(true, new com.tencent.magicbrush.engine.b(), addAndGet);
        x.i("MicroMsg.V8JsVmManager", "lm:GameRenderer.initJsVmContext new WAGameJsContextImpl finished");
        jVar.fAi.put(Integer.valueOf(addAndGet), jVar.fAg);
        x.i("MicroMsg.V8JsVmManager", "lm:GameRenderer.initJsVmContext finished");
        this.fAa = hVar;
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        f fVar = j.fAf.fAg;
        if (fVar == null) {
            throw new IllegalStateException("JsVmContext Not Initialized, main");
        } else if (str == null || str.isEmpty()) {
            x.e("WAGameJsEngine", "js script is null");
            throw new IllegalArgumentException("js script is null");
        } else if (fVar == null) {
            x.w("WAGameJsEngine", "WAGameJsEngine.evaluateJavaScriptImpl jsVmContext == null");
        } else {
            synchronized (this) {
                if (this.nY) {
                    x.w("WAGameJsEngine", "evaluateSubJavascript is mDestroyed. script : " + str);
                    return;
                }
                fVar.evaluateJavascript(str, valueCallback);
            }
        }
    }

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        f fVar = j.fAf.fAg;
        if (fVar == null) {
            throw new IllegalStateException("JsVmContext Not Initialized, main");
        } else if (str == null || str.isEmpty()) {
            x.e("WAGameJsEngine", "js script is null");
            throw new IllegalArgumentException("js script is null");
        } else {
            synchronized (this) {
                if (this.nY) {
                    x.w("WAGameJsEngine", "evaluateSubJavascript is mDestroyed. script : " + str);
                    return;
                }
                fVar.a(url, str, valueCallback);
            }
        }
    }

    public final void setJsExceptionHandler(d dVar) {
    }

    public final void addJavascriptInterface(Object obj, String str) {
        f fVar = j.fAf.fAg;
        if (obj == null || str == null || str.isEmpty()) {
            x.w("WAGameJsEngine", "addJavaScriptInterface empty! : " + str);
        } else if (fVar == null) {
            x.w("WAGameJsEngine", "");
        } else {
            synchronized (this) {
                if (this.nY) {
                    x.w("WAGameJsEngine", "addJavaScriptInterface mDestroyed. name : " + str);
                    return;
                }
                x.i("WAGameJsEngine", "addJavaScriptInterface name : " + str);
                fVar.addJavascriptInterface(obj, str);
            }
        }
    }

    public final void destroy() {
        synchronized (this) {
            this.nY = true;
        }
    }

    public final <T extends c> T y(Class<T> cls) {
        if (cls.equals(f.class) || cls.equals(com.tencent.mm.plugin.appbrand.g.d.class)) {
            return j.fAf;
        }
        return !cls.isInstance(this) ? null : this;
    }
}
