package com.tencent.mm.ui.f.a;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

class f$a extends p {
    final /* synthetic */ f utE;
    boolean utF;

    private f$a(f fVar) {
        this.utE = fVar;
        this.utF = true;
    }

    /* synthetic */ f$a(f fVar, byte b) {
        this(fVar);
    }

    public final boolean b(WebView webView, String str) {
        x.d("Facebook-WebView", "Redirect URL: " + str);
        if (str.startsWith("fbconnect://success")) {
            Bundle aaW = e.aaW(str);
            String string = aaW.getString("error");
            if (string == null) {
                string = aaW.getString("error_type");
            }
            if (string == null) {
                f.a(this.utE).m(aaW);
            } else if (string.equals("access_denied") || string.equals("OAuthAccessDeniedException")) {
                f.a(this.utE).onCancel();
            } else {
                f.a(this.utE).a(new d(string));
            }
            this.utE.dismiss();
            return true;
        } else if (str.startsWith("fbconnect://cancel")) {
            f.a(this.utE).onCancel();
            try {
                this.utE.dismiss();
                return true;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
                return true;
            }
        } else if (str.contains("touch")) {
            return false;
        } else {
            this.utE.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        }
    }

    public final void a(WebView webView, int i, String str, String str2) {
        super.a(webView, i, str, str2);
        this.utF = false;
        f.a(this.utE).a(new b(str, i, str2));
        try {
            this.utE.dismiss();
            f.b(this.utE).dismiss();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
        }
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        x.d("Facebook-WebView", "Webview loading URL: " + str);
        super.b(webView, str, bitmap);
        try {
            f.b(this.utE).show();
            f.b(this.utE).setOnDismissListener(new 1(this));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
        }
    }

    public final void a(WebView webView, String str) {
        super.a(webView, str);
        this.utF = false;
        try {
            f.b(this.utE).dismiss();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
        }
        f.c(this.utE).setBackgroundColor(0);
        f.d(this.utE).setVisibility(0);
        f.e(this.utE).setVisibility(0);
    }
}
