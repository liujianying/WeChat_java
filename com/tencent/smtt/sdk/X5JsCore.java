package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.nio.ByteBuffer;

public class X5JsCore {
    private static a a = a.a;
    private static a b = a.a;
    private static a c = a.a;
    private final Context d;
    private Object e = null;
    private WebView f = null;

    @Deprecated
    public X5JsCore(Context context) {
        this.d = context;
        if (canUseX5JsCore(context)) {
            Object a = a("createX5JavaBridge", new Class[]{Context.class}, context);
            if (a != null) {
                this.e = a;
                return;
            }
        }
        this.f = new WebView(context);
        this.f.getSettings().setJavaScriptEnabled(true);
    }

    protected static IX5JsVirtualMachine a(Context context, Looper looper) {
        if (canUseX5JsCore(context)) {
            Object a = a("createX5JsVirtualMachine", new Class[]{Context.class, Looper.class}, context, looper);
            if (a != null) {
                return (IX5JsVirtualMachine) a;
            }
        }
        return null;
    }

    protected static Object a() {
        return a("currentContextData", new Class[0], new Object[0]);
    }

    private static Object a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            bv a = bv.a();
            if (a != null && a.b()) {
                return a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", str, clsArr, objArr);
            }
            new StringBuilder("X5Jscore#").append(str).append(" - x5CoreEngine is null or is not x5core.");
            return null;
        } catch (Exception e) {
        }
    }

    public static boolean canUseX5JsCore(Context context) {
        if (a != a.a) {
            return a == a.c;
        } else {
            a = a.b;
            Object a = a("canUseX5JsCore", new Class[]{Context.class}, context);
            if (a == null || !(a instanceof Boolean) || !((Boolean) a).booleanValue()) {
                return false;
            }
            a("setJsValueFactory", new Class[]{Object.class}, JsValue.a());
            a = a.c;
            return true;
        }
    }

    public static boolean canUseX5JsCoreNewAPI(Context context) {
        if (c != a.a) {
            return c == a.c;
        } else {
            c = a.b;
            Object a = a("canUseX5JsCoreNewAPI", new Class[]{Context.class}, context);
            if (a == null || !(a instanceof Boolean) || !((Boolean) a).booleanValue()) {
                return false;
            }
            c = a.c;
            return true;
        }
    }

    public static boolean canX5JsCoreUseNativeBuffer(Context context) {
        if (b != a.a) {
            return b == a.c;
        } else {
            b = a.b;
            if (!canUseX5JsCore(context)) {
                return false;
            }
            Object a = a("canX5JsCoreUseBuffer", new Class[]{Context.class}, context);
            if (a == null || !(a instanceof Boolean) || !((Boolean) a).booleanValue()) {
                return false;
            }
            b = a.c;
            return true;
        }
    }

    @Deprecated
    public void addJavascriptInterface(Object obj, String str) {
        if (this.e != null) {
            a("addJavascriptInterface", new Class[]{Object.class, String.class, Object.class}, obj, str, this.e);
        } else if (this.f != null) {
            this.f.addJavascriptInterface(obj, str);
            this.f.loadUrl("about:blank");
        }
    }

    @Deprecated
    public void destroy() {
        if (this.e != null) {
            a("destroyX5JsCore", new Class[]{Object.class}, this.e);
            this.e = null;
        } else if (this.f != null) {
            this.f.clearHistory();
            this.f.clearCache(true);
            this.f.loadUrl("about:blank");
            this.f.freeMemory();
            this.f.pauseTimers();
            this.f.destroy();
            this.f = null;
        }
    }

    @Deprecated
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.e != null) {
            a("evaluateJavascript", new Class[]{String.class, ValueCallback.class, Object.class}, str, valueCallback, this.e);
        } else if (this.f != null) {
            this.f.evaluateJavascript(str, valueCallback);
        }
    }

    @Deprecated
    public ByteBuffer getNativeBuffer(int i) {
        if (this.e != null && canX5JsCoreUseNativeBuffer(this.d)) {
            Object a = a("getNativeBuffer", new Class[]{Object.class, Integer.TYPE}, this.e, Integer.valueOf(i));
            if (a != null && (a instanceof ByteBuffer)) {
                return (ByteBuffer) a;
            }
        }
        return null;
    }

    @Deprecated
    public int getNativeBufferId() {
        if (this.e != null && canX5JsCoreUseNativeBuffer(this.d)) {
            Object a = a("getNativeBufferId", new Class[]{Object.class}, this.e);
            if (a != null && (a instanceof Integer)) {
                return ((Integer) a).intValue();
            }
        }
        return -1;
    }

    @Deprecated
    public void pause() {
        if (this.e != null) {
            a("pause", new Class[]{Object.class}, this.e);
        }
    }

    @Deprecated
    public void pauseTimers() {
        if (this.e != null) {
            a("pauseTimers", new Class[]{Object.class}, this.e);
        }
    }

    @Deprecated
    public void removeJavascriptInterface(String str) {
        if (this.e != null) {
            a("removeJavascriptInterface", new Class[]{String.class, Object.class}, str, this.e);
        } else if (this.f != null) {
            this.f.removeJavascriptInterface(str);
        }
    }

    @Deprecated
    public void resume() {
        if (this.e != null) {
            a("resume", new Class[]{Object.class}, this.e);
        }
    }

    @Deprecated
    public void resumeTimers() {
        if (this.e != null) {
            a("resumeTimers", new Class[]{Object.class}, this.e);
        }
    }

    @Deprecated
    public void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        if (this.e != null && canX5JsCoreUseNativeBuffer(this.d)) {
            a("setNativeBuffer", new Class[]{Object.class, Integer.TYPE, ByteBuffer.class}, this.e, Integer.valueOf(i), byteBuffer);
        }
    }
}
