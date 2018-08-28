package com.tencent.mm.plugin.topstory.ui.webview;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.WebView;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.b;
import java.lang.Thread.State;
import java.lang.reflect.Field;

public class TopStoryWebView extends MMWebView {
    private Context context;

    public TopStoryWebView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public TopStoryWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public TopStoryWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    private void init() {
        x.i("MicroMsg.TopStory.TopStoryWebView", "init TopStoryWebView");
        this.dfF = true;
        he(this.context);
        if (!getIsX5Kernel() && !d.fR(19)) {
            try {
                x.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[]{new c(this, "mSysWebView", null).get()});
                x.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[]{new c(r0, "mProvider", null).get()});
                x.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[]{new c(r0, "mWebViewCore", null).get()});
                x.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[]{new c(r0, "sWebCoreHandler", null).get()});
                x.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[]{new c(r0, "mLooper", null).get()});
                Object obj = new c(obj, "mThread", null).get();
                x.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[]{obj});
                if (obj instanceof Thread) {
                    Thread thread = (Thread) obj;
                    x.i("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[]{thread.getState()});
                    if (thread.getState() == State.WAITING) {
                        thread.interrupt();
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[]{e});
            }
        }
    }

    public final void a(a aVar, c cVar) {
        getSettings().cIv();
        getSettings().setJavaScriptEnabled(true);
        getSettings().setPluginsEnabled(true);
        getSettings().setBuiltInZoomControls(false);
        getSettings().setMediaPlaybackRequiresUserGesture(true);
        getSettings().cIx();
        getSettings().setUserAgentString(s.aV(getContext(), getSettings().getUserAgentString()));
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().cIq();
        getSettings().cIp();
        getSettings().setGeolocationEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().cIx();
        getSettings().cIt();
        getSettings().setAppCachePath(this.context.getDir("webviewcache", 0).getAbsolutePath());
        getSettings().cIs();
        getSettings().cIu();
        getSettings().setDatabasePath(e.duM + "databases/");
        b.cIi().cIj();
        b.cIi().c(this);
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(true);
        setConfigCallback((WindowManager) ad.getContext().getSystemService("window"));
        super.setWebChromeClient(aVar);
        super.setWebViewClient(cVar);
        x.i("MicroMsg.TopStory.TopStoryWebView", "Is the current broswer kernel X5, " + getIsX5Kernel());
        setBackgroundColor(-1);
        setLayoutParams(new LayoutParams(-1, -1));
        cAx();
        try {
            if (VERSION.SDK_INT >= 19) {
                if (g.bHC()) {
                    WebView.setWebContentsDebuggingEnabled(true);
                } else {
                    WebView.setWebContentsDebuggingEnabled(false);
                }
            }
        } catch (Exception e) {
        }
        float f = getContext().getSharedPreferences(ad.chY(), 0).getFloat("current_text_size_scale_key", 1.0f);
        if (f >= 2.025f) {
            getSettings().setTextZoom(160);
        } else if (f >= 1.875f) {
            getSettings().setTextZoom(150);
        } else if (f >= 1.625f) {
            getSettings().setTextZoom(140);
        } else if (f >= 1.375f) {
            getSettings().setTextZoom(130);
        } else if (f >= 1.25f) {
            getSettings().setTextZoom(120);
        } else if (f >= 1.125f) {
            getSettings().setTextZoom(i$l.AppCompatTheme_spinnerStyle);
        } else if (f >= 1.0f) {
            getSettings().setTextZoom(100);
        } else if (f >= 0.875f) {
            getSettings().setTextZoom(90);
        } else {
            getSettings().setTextZoom(80);
        }
        x.i("MicroMsg.TopStory.TopStoryWebView", "SetFontSize, fontSize = %f", new Object[]{Float.valueOf(f)});
    }

    public void setConfigCallback(WindowManager windowManager) {
        try {
            Field declaredField = com.tencent.xweb.WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj != null) {
                declaredField = declaredField.getType().getDeclaredField("mWindowManager");
                declaredField.setAccessible(true);
                declaredField.set(obj, windowManager);
            }
        } catch (Exception e) {
        }
    }
}
