package com.tencent.mm.ui.i;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.f.a.b;
import com.tencent.mm.ui.i.b.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
class b$b extends p {
    final /* synthetic */ b uFq;
    boolean utF;

    private b$b(b bVar) {
        this.uFq = bVar;
        this.utF = true;
    }

    /* synthetic */ b$b(b bVar, byte b) {
        this(bVar);
    }

    public final boolean b(WebView webView, String str) {
        x.d("Twitter-WebView", "Redirect URL: " + str);
        if (str.startsWith("wechatapp://sign-in-twitter.wechatapp.com/")) {
            Bundle aaW = aaW(str);
            if (aaW.getString("denied") == null) {
                b.a(this.uFq).m(aaW);
            } else {
                b.a(this.uFq).onCancel();
            }
            this.uFq.dismiss();
        } else {
            this.uFq.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
        return true;
    }

    public final void a(WebView webView, int i, String str, String str2) {
        super.a(webView, i, str, str2);
        this.utF = false;
        a a = b.a(this.uFq);
        b bVar = new b(str, i, str2);
        a.cAp();
        try {
            this.uFq.dismiss();
            b.b(this.uFq).dismiss();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TwitterDialog", e, "", new Object[0]);
        }
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        x.d("Twitter-WebView", "Webview loading URL: " + str);
        super.b(webView, str, bitmap);
        try {
            b.b(this.uFq).show();
            b.b(this.uFq).setOnDismissListener(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    if (b$b.this.utF && b$b.this.uFq != null) {
                        b.a(b$b.this.uFq).onCancel();
                        b$b.this.uFq.dismiss();
                    }
                }
            });
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TwitterDialog", e, "", new Object[0]);
        }
    }

    public final void a(WebView webView, String str) {
        super.a(webView, str);
        this.utF = false;
        try {
            b.b(this.uFq).dismiss();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TwitterDialog", e, "", new Object[0]);
        }
        b.c(this.uFq).setBackgroundColor(0);
        b.d(this.uFq).setVisibility(0);
        b.e(this.uFq).setVisibility(0);
    }

    private static Bundle aaV(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
            }
        }
        return bundle;
    }

    private static Bundle aaW(String str) {
        try {
            URL url = new URL(str.replace("wechatapp", "http"));
            Bundle aaV = aaV(url.getQuery());
            aaV.putAll(aaV(url.getRef()));
            return aaV;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }
}
