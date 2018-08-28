package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView$d;
import java.lang.reflect.Method;

public class MMWebView extends WebView {
    public static final WebView$d uHn = WebView$d.WV_KIND_X5;
    public static final String uHo = null;
    public boolean dfF;
    private OnTouchListener oQM;
    private String qht;
    private boolean uHm;
    protected boolean uHp;
    private boolean uHq;
    private ViewGroup uHr;
    public d uHs;

    private class b {
        private b() {
        }

        /* synthetic */ b(MMWebView mMWebView, byte b) {
            this();
        }
    }

    public MMWebView(Context context) {
        this(context, null);
    }

    public MMWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, WebView$d.WV_KIND_NONE);
    }

    public MMWebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, WebView$d.WV_KIND_NONE);
    }

    public MMWebView(Context context, AttributeSet attributeSet, int i, WebView$d webView$d) {
        super(context, attributeSet, i, webView$d);
        this.dfF = false;
        this.uHp = false;
        this.uHq = false;
        this.uHs = null;
        cAw();
    }

    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @TargetApi(11)
    public final void cAw() {
        try {
            if (VERSION.SDK_INT >= 11) {
                super.removeJavascriptInterface("searchBoxJavaBridge_");
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMWebView", "removeConfigJsInterface, ex = %s", new Object[]{e.getMessage()});
        }
    }

    public final void cAx() {
        if (VERSION.SDK_INT >= 5) {
            c cVar = new c(this, (byte) 0);
            setScrollbarFadingEnabled(true);
            setScrollBarStyle(0);
            return;
        }
        b bVar = new b(this, (byte) 0);
        setScrollBarStyle(0);
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!bi.oW(str)) {
            int i;
            if (d.fR(19) || this.isX5Kernel) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                super.evaluateJavascript(str, valueCallback);
            } else if (!this.uHp || !a(this, str)) {
                try {
                    if (!str.startsWith("javascript:")) {
                        str = "javascript:" + str;
                    }
                    super.loadUrl(str);
                } catch (Exception e) {
                    x.i("MicroMsg.MMWebView", "evaluateJavascript failed : %s", new Object[]{e.getMessage()});
                }
            }
        }
    }

    private static boolean a(MMWebView mMWebView, String str) {
        try {
            Object obj = new c(new c(new c(mMWebView, "mSysWebView", null).get(), "mProvider", null).get(), "mWebViewCore", null).get();
            Method declaredMethod = obj.getClass().getDeclaredMethod("sendMessage", new Class[]{Message.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, new Object[]{Message.obtain(null, 194, str)});
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MMWebView", "reflectJSExec, e = %s", new Object[]{e});
            return false;
        }
    }

    public void setCompetitorView(ViewGroup viewGroup) {
        this.uHr = viewGroup;
    }

    public boolean getIsX5Kernel() {
        return this.isX5Kernel;
    }

    public final void cAy() {
        super.setOnTouchListener(new 1(this));
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.oQM = onTouchListener;
    }

    @TargetApi(9)
    public final boolean c(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean super_overScrollBy = super.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        if (i4 < 0 || (i4 == 0 && i2 < 0)) {
            this.uHq = true;
        }
        return super_overScrollBy;
    }

    public final boolean N(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean super_onTouchEvent = super.super_onTouchEvent(motionEvent);
        switch (action & 255) {
            case 0:
                this.uHq = false;
                break;
            case 2:
                if (this.uHr != null) {
                    if (!this.uHq) {
                        this.uHr.requestDisallowInterceptTouchEvent(true);
                        break;
                    }
                    this.uHr.requestDisallowInterceptTouchEvent(false);
                    break;
                }
                break;
        }
        if (!super_onTouchEvent) {
            return super_onTouchEvent;
        }
        if (this.uHq) {
            return false;
        }
        return true;
    }

    @TargetApi(9)
    public final void d(int i, int i2, boolean z, boolean z2) {
        super.super_onOverScrolled(i, i2, z, z2);
    }

    public final boolean O(MotionEvent motionEvent) {
        return super.super_dispatchTouchEvent(motionEvent);
    }

    public final boolean P(MotionEvent motionEvent) {
        return super.super_onInterceptTouchEvent(motionEvent);
    }

    @TargetApi(9)
    public final void cAz() {
        super.super_computeScroll();
    }

    public final void A(int i, int i2, int i3, int i4) {
        super.super_onScrollChanged(i, i2, i3, i4);
    }

    public static void he(Context context) {
        boolean z;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        x.i("MicroMsg.MMWebView", "initTbsSettings, tbsDisable = %s, minSdkVersion = %s, maxSdkVersion = %s", new Object[]{sharedPreferences.getString("tbs_webview_disable", "0"), sharedPreferences.getString("tbs_webview_min_sdk_version", null), sharedPreferences.getString("tbs_webview_max_sdk_version", null)});
        if ("1".equals(sharedPreferences.getString("tbs_webview_disable", "0"))) {
            int i = bi.getInt(r4, 0);
            int i2 = bi.getInt(r5, 0);
            int i3 = VERSION.SDK_INT;
            if (i3 >= i && (i3 <= i2 || i2 == 0)) {
                x.i("MicroMsg.MMWebView", "in selection, disable x5");
                z = false;
                x.i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", new Object[]{Boolean.valueOf(z)});
                if (!z) {
                    com.tencent.xweb.x5.sdk.d.forceSysWebView();
                }
                x.i("MicroMsg.MMWebView", "initTbsSettings, tbs_download_oversea = %b, isGPVersion = %b", new Object[]{Boolean.valueOf(sharedPreferences.getBoolean("tbs_download_oversea", false)), Boolean.valueOf(e.chv())});
                if (!sharedPreferences.getBoolean("tbs_download_oversea", false) && r3) {
                    com.tencent.xweb.x5.sdk.d.forceSysWebView();
                    return;
                }
            }
        }
        z = true;
        x.i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            com.tencent.xweb.x5.sdk.d.forceSysWebView();
        }
        x.i("MicroMsg.MMWebView", "initTbsSettings, tbs_download_oversea = %b, isGPVersion = %b", new Object[]{Boolean.valueOf(sharedPreferences.getBoolean("tbs_download_oversea", false)), Boolean.valueOf(e.chv())});
        if (!sharedPreferences.getBoolean("tbs_download_oversea", false)) {
        }
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        super.onWebViewScrollChanged(i, i2, i3, i4);
        if (this.uHs != null) {
            this.uHs.onWebViewScrollChanged(i, i2, i3, i4);
        }
    }

    public String getRandomStr() {
        return this.qht;
    }

    public void setRandomStr(String str) {
        this.qht = str;
    }

    public void setPreload(boolean z) {
        this.uHm = z;
    }
}
