package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Dialog;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.modelcache.p;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.xweb.WebView;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.j;
import com.tencent.xweb.j.a;
import java.util.LinkedList;
import java.util.List;

protected class WebViewUI$h extends j {
    public volatile boolean iKs = false;
    private Dialog jJX = null;
    final /* synthetic */ WebViewUI pZJ;
    private final List<String> qaG = new LinkedList();

    public WebViewUI$h(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void a(WebView webView, int i) {
        if (i < 100) {
            WebViewUI.d(this.pZJ, false);
        } else if (i >= 100) {
            WebViewUI.d(this.pZJ, true);
        }
    }

    public final void d(WebView webView, String str) {
        x.i("MicroMsg.WebViewUI", "onReceivedTitle, title = %s, loadurl = %s", new Object[]{str, WebViewUI.ah(this.pZJ)});
        super.d(webView, str);
        if (this.pZJ.pXA) {
            x.i("MicroMsg.WebViewUI", "fixed title, ignore received title: " + str);
        } else if (str == null) {
            x.e("MicroMsg.WebViewUI", "null title");
        } else if (WebViewUI.q(this.pZJ) && !bi.oV(WebViewUI.ah(this.pZJ)).equals(str) && !p.vN(str)) {
            this.pZJ.setMMTitle(str);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        x.i("MicroMsg.WebViewUI", "onShowCustomView, sdk int = " + VERSION.SDK_INT);
        try {
            if (WebViewUI.an(this.pZJ) != null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            WebViewUI.a(this.pZJ, false);
            WebViewUI.a(this.pZJ, view);
            WebViewUI.a(this.pZJ, customViewCallback);
            if (this.pZJ.mhH.isXWalkKernel()) {
                this.pZJ.pXH.addView(view, 0);
                this.pZJ.fullScreenNoTitleBar(true);
                this.pZJ.setStatusBarColor(0);
                if (this.pZJ.jUX != null) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.pZJ.jUX.getLayoutParams();
                    marginLayoutParams.topMargin = 0;
                    this.pZJ.jUX.setLayoutParams(marginLayoutParams);
                    return;
                }
                return;
            }
            this.pZJ.mhH.setVisibility(8);
            this.pZJ.pXH.addView(view);
            this.pZJ.setTitleVisibility(4);
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "onShowCustomView error " + e.getMessage());
        }
    }

    public final void onHideCustomView() {
        x.i("MicroMsg.WebViewUI", "onHideCustomView, sdk int = " + VERSION.SDK_INT);
        if (WebViewUI.an(this.pZJ) != null) {
            try {
                WebViewUI.a(this.pZJ, false);
                if (this.pZJ.mhH.isXWalkKernel()) {
                    this.pZJ.fullScreenNoTitleBar(false);
                    this.pZJ.setStatusBarColor(this.pZJ.getResources().getColor(R.e.status_bar_color));
                    if (this.pZJ.jUX != null) {
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.pZJ.jUX.getLayoutParams();
                        int ao = WebViewUI.ao(this.pZJ);
                        if (ao != marginLayoutParams.topMargin) {
                            marginLayoutParams.topMargin = ao;
                            this.pZJ.jUX.setLayoutParams(marginLayoutParams);
                        }
                    }
                } else {
                    this.pZJ.mhH.setVisibility(0);
                    this.pZJ.setTitleVisibility(0);
                }
                if (this.pZJ.pXH != null) {
                    this.pZJ.pXH.removeView(WebViewUI.an(this.pZJ));
                }
                WebViewUI.a(this.pZJ, null);
                if (WebViewUI.ap(this.pZJ) != null) {
                    WebViewUI.ap(this.pZJ).onCustomViewHidden();
                }
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "onHideCustomView error " + e.getMessage());
            }
        }
    }

    public final View getVideoLoadingProgressView() {
        if (WebViewUI.aq(this.pZJ) == null) {
            WebViewUI.a(this.pZJ, new ProgressBar(this.pZJ));
            WebViewUI.aq(this.pZJ).setIndeterminate(true);
        }
        return WebViewUI.aq(this.pZJ);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        x.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[]{str});
        h.a(this.pZJ, false, this.pZJ.getString(R.l.wv_get_location_msg, new Object[]{str}), this.pZJ.getString(R.l.wv_get_location_title), this.pZJ.getString(R.l.app_ok), this.pZJ.getString(R.l.app_cancel), new 1(this, callback, str), new 4(this, callback, str));
    }

    public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        WebViewUI.as(this.pZJ).a(this.pZJ, this.pZJ.gcP, valueCallback, null, str, str2);
    }

    public final boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, a aVar) {
        if (aVar.getMode() != 0) {
            return false;
        }
        if (aVar.getAcceptTypes() == null || aVar.getAcceptTypes().length <= 0) {
            x.i("MicroMsg.WebViewUI", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
            return true;
        }
        String str = aVar.getAcceptTypes()[0];
        String str2 = "*";
        if (aVar.isCaptureEnabled()) {
            if ("image/*".equalsIgnoreCase(str)) {
                str2 = "camera";
            } else if ("video/*".equalsIgnoreCase(str)) {
                str2 = "camcorder";
            }
        }
        WebViewUI.as(this.pZJ).a(this.pZJ, this.pZJ.gcP, null, valueCallback, str, str2);
        return true;
    }

    public final boolean b(WebView webView, String str, String str2, f fVar) {
        x.d("MicroMsg.WebViewUI", "onJsConfirm");
        PBool pBool = new PBool();
        pBool.value = false;
        if (this.pZJ.isFinishing() || this.pZJ.tlP) {
            x.d("MicroMsg.WebViewUI", "onJsConfirm finish");
            fVar.cancel();
            return true;
        }
        WebViewUI.at(this.pZJ);
        if (WebViewUI.au(this.pZJ) > 2) {
            this.jJX = h.a(this.pZJ, str2, "", this.pZJ.getString(R.l.wv_close_webview), this.pZJ.getString(R.l.app_ok), new 5(this, str, fVar), new 6(this, pBool, fVar), R.e.btn_green_color_normal);
        } else {
            this.jJX = h.a(this.pZJ.mController.tml, false, str2, "", this.pZJ.getString(R.l.app_ok), this.pZJ.getString(R.l.app_cancel), new 7(this, pBool, fVar), new 8(this, fVar));
        }
        if (this.jJX == null) {
            return super.b(webView, str, str2, fVar);
        }
        this.jJX.setOnDismissListener(new 9(this, pBool, fVar));
        this.jJX.setCancelable(false);
        this.jJX.setCanceledOnTouchOutside(false);
        return true;
    }

    public final boolean a(WebView webView, String str, String str2, String str3, e eVar) {
        return super.a(webView, str, str2, str3, eVar);
    }

    public final boolean a(WebView webView, String str, String str2, f fVar) {
        x.d("MicroMsg.WebViewUI", "onJsAlert");
        PBool pBool = new PBool();
        pBool.value = false;
        if (this.pZJ.isFinishing() || this.pZJ.tlP) {
            x.d("MicroMsg.WebViewUI", "onJsAlert finish");
            fVar.cancel();
            return true;
        }
        c a;
        WebViewUI.at(this.pZJ);
        if (WebViewUI.au(this.pZJ) > 2) {
            a = h.a(this.pZJ, str2, "", this.pZJ.getString(R.l.wv_close_webview), this.pZJ.getString(R.l.app_ok), new 10(this, str, fVar), new 11(this, pBool, fVar), R.e.link_color);
        } else {
            a = h.a(this.pZJ, str2, "", this.pZJ.getString(R.l.app_ok), new 2(this, pBool, fVar));
        }
        if (a == null) {
            return super.a(webView, str, str2, fVar);
        }
        a.setOnDismissListener(new 3(this, pBool, fVar));
        a.setCanceledOnTouchOutside(false);
        a.cpX();
        return true;
    }
}
