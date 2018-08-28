package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.xweb.WebView;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.j;

public class g extends j {
    private Activity bOb;
    private int jJE = 0;

    public g(MMWebViewWithJsApi mMWebViewWithJsApi) {
        this.bOb = (Activity) mMWebViewWithJsApi.getContext();
    }

    public void d(WebView webView, String str) {
        super.d(webView, str);
    }

    public final void onGeolocationPermissionsShowPrompt(final String str, final Callback callback) {
        h.a(this.bOb, false, this.bOb.getString(R.l.wv_get_location_msg, new Object[]{str}), this.bOb.getString(R.l.wv_get_location_title), this.bOb.getString(R.l.app_ok), this.bOb.getString(R.l.app_cancel), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                callback.invoke(str, true, true);
            }
        }, new 2(this, callback, str));
    }

    public final boolean a(WebView webView, String str, String str2, f fVar) {
        c a;
        this.jJE++;
        if (this.jJE > 2) {
            a = h.a(this.bOb, str2, "", this.bOb.getString(R.l.wv_close_webview), this.bOb.getString(R.l.app_ok), new 3(this, fVar), new 4(this, fVar), R.e.link_color);
        } else {
            a = h.a(this.bOb, str2, "", this.bOb.getString(R.l.app_ok), new 5(this, fVar));
        }
        if (a == null) {
            return super.a(webView, str, str2, fVar);
        }
        a.setCanceledOnTouchOutside(false);
        a.cpX();
        return true;
    }

    public final boolean b(WebView webView, String str, String str2, final f fVar) {
        c a;
        this.jJE++;
        if (this.jJE > 2) {
            a = h.a(this.bOb, str2, "", this.bOb.getString(R.l.wv_close_webview), this.bOb.getString(R.l.app_ok), new 6(this, fVar), new 7(this, fVar), R.e.btn_green_color_normal);
        } else {
            a = h.a(this.bOb, false, str2, "", this.bOb.getString(R.l.app_ok), this.bOb.getString(R.l.app_cancel), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    fVar.confirm();
                }
            }, new 9(this, fVar));
        }
        if (a == null) {
            return super.b(webView, str, str2, fVar);
        }
        a.setCancelable(false);
        a.setCanceledOnTouchOutside(false);
        return true;
    }

    public final boolean a(WebView webView, String str, String str2, String str3, e eVar) {
        return super.a(webView, str, str2, str3, eVar);
    }

    public void onClose() {
        this.bOb.finish();
    }
}
