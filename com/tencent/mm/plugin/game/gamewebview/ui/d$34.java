package com.tencent.mm.plugin.game.gamewebview.ui;

import android.app.Dialog;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.xweb.WebView;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.j;
import com.tencent.xweb.j.a;

class d$34 extends j {
    final /* synthetic */ d jJO;
    private Dialog jJX = null;

    d$34(d dVar) {
        this.jJO = dVar;
    }

    public final void a(WebView webView, int i) {
    }

    public final void d(WebView webView, String str) {
        x.i("MicroMsg.GameWebPageView", "onReceivedTitle, title = %s", new Object[]{str});
        if (!bi.oV(d.r(this.jJO)).equals(str) && !d.vN(str)) {
            d.e(this.jJO).setTitleText(str);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        x.i("MicroMsg.GameWebPageView", "onShowCustomView, sdk int = " + VERSION.SDK_INT);
        try {
            if (d.u(this.jJO) != null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            d.a(this.jJO, view);
            d.a(this.jJO, customViewCallback);
            d.n(this.jJO).setVisibility(8);
            d.v(this.jJO).addView(view);
            d.e(this.jJO).setVisibility(8);
        } catch (Exception e) {
            x.e("MicroMsg.GameWebPageView", "onShowCustomView error " + e.getMessage());
        }
    }

    public final void onHideCustomView() {
        x.i("MicroMsg.GameWebPageView", "onHideCustomView, sdk int = " + VERSION.SDK_INT);
        if (d.u(this.jJO) != null) {
            try {
                d.n(this.jJO).setVisibility(0);
                if (d.v(this.jJO) != null) {
                    d.v(this.jJO).removeView(d.u(this.jJO));
                }
                d.a(this.jJO, null);
                if (d.w(this.jJO) != null) {
                    d.w(this.jJO).onCustomViewHidden();
                }
                d.e(this.jJO).setVisibility(0);
            } catch (Exception e) {
                x.e("MicroMsg.GameWebPageView", "onHideCustomView error " + e.getMessage());
            }
        }
    }

    public final View getVideoLoadingProgressView() {
        if (d.x(this.jJO) == null) {
            d.a(this.jJO, new ProgressBar(d.t(this.jJO)));
            d.x(this.jJO).setIndeterminate(true);
        }
        return d.x(this.jJO);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        x.i("MicroMsg.GameWebPageView", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[]{str});
        h.a(d.t(this.jJO), false, d.t(this.jJO).getString(R.l.wv_get_location_msg, new Object[]{str}), d.t(this.jJO).getString(R.l.wv_get_location_title), d.t(this.jJO).getString(R.l.app_ok), d.t(this.jJO).getString(R.l.app_cancel), new 1(this, callback, str), new 3(this, callback, str));
    }

    public final boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, a aVar) {
        if (aVar.getMode() != 0) {
            return false;
        }
        if (aVar.getAcceptTypes() == null || aVar.getAcceptTypes().length <= 0) {
            x.i("MicroMsg.GameWebPageView", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
            return true;
        }
        d.z(this.jJO).a(d.t(this.jJO), d.y(this.jJO), null, valueCallback, aVar.getAcceptTypes()[0], "*");
        return true;
    }

    public final boolean b(WebView webView, String str, String str2, f fVar) {
        d.a(this.jJO, fVar);
        if (d.A(this.jJO)) {
            fVar.cancel();
            return true;
        }
        d.B(this.jJO);
        if (d.C(this.jJO) > 2) {
            this.jJX = h.a(d.t(this.jJO), str2, "", d.t(this.jJO).getString(R.l.wv_close_webview), d.t(this.jJO).getString(R.l.app_ok), new 4(this, fVar), new 5(this, fVar), R.e.btn_green_color_normal);
        } else {
            this.jJX = h.a(d.t(this.jJO), false, str2, "", d.t(this.jJO).getString(R.l.app_ok), d.t(this.jJO).getString(R.l.app_cancel), new 6(this, fVar), new 7(this, fVar));
        }
        if (this.jJX == null) {
            return super.b(webView, str, str2, fVar);
        }
        this.jJX.setCancelable(false);
        this.jJX.setCanceledOnTouchOutside(false);
        return true;
    }

    public final boolean a(WebView webView, String str, String str2, String str3, e eVar) {
        return super.a(webView, str, str2, str3, eVar);
    }

    public final boolean a(WebView webView, String str, String str2, f fVar) {
        x.d("MicroMsg.GameWebPageView", "onJsAlert, mHasDestroy = %b", new Object[]{Boolean.valueOf(d.A(this.jJO))});
        d.a(this.jJO, fVar);
        if (d.A(this.jJO)) {
            fVar.cancel();
            return true;
        }
        d.B(this.jJO);
        if (d.C(this.jJO) > 2) {
            this.jJX = h.a(d.t(this.jJO), str2, "", d.t(this.jJO).getString(R.l.wv_close_webview), d.t(this.jJO).getString(R.l.app_ok), new 8(this, fVar), new 9(this, fVar), R.e.btn_green_color_normal);
        } else {
            this.jJX = h.a(d.t(this.jJO), false, str2, "", d.t(this.jJO).getString(R.l.app_ok), d.t(this.jJO).getString(R.l.app_cancel), new 10(this, fVar), new 2(this, fVar));
        }
        if (this.jJX == null) {
            return super.a(webView, str, str2, fVar);
        }
        this.jJX.setCancelable(false);
        this.jJX.setCanceledOnTouchOutside(false);
        return true;
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage != null ? consoleMessage.message() : null;
        x.i("MicroMsg.GameWebPageView", "onConsoleMessage : %s", new Object[]{message});
        if (!bi.oW(message)) {
            if (message.equalsIgnoreCase("weixin://preInjectJSBridge/start")) {
                x.i("MicroMsg.GameWebPageView", "now inject js library");
                return true;
            } else if (message.equalsIgnoreCase("weixin://preInjectJSBridge/fail")) {
                return true;
            } else {
                if (message.equalsIgnoreCase("weixin://preInjectJSBridge/ok")) {
                    x.d("MicroMsg.GameWebPageView", "preInjectJSBridge ok");
                    return true;
                } else if (message.equalsIgnoreCase("weixin://whiteScreenEnd")) {
                    x.d("MicroMsg.GameWebPageView", "whiteScreenEnd");
                    d.D(this.jJO);
                    return true;
                }
            }
        }
        return super.onConsoleMessage(consoleMessage);
    }
}
