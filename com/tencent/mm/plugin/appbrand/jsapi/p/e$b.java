package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

class e$b extends i {
    final /* synthetic */ e gdb;

    e$b(e eVar, MMWebView mMWebView) {
        this.gdb = eVar;
        super(mMWebView);
    }

    protected final k aks() {
        return e.a(this.gdb);
    }

    protected final void a(d dVar, e eVar) {
        e.a(this.gdb, dVar);
        e.a(this.gdb, eVar);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("key_webview_container_env", "miniProgram");
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("jsapiargs", bundle);
            dVar.a(20, bundle2, this.dEn.hashCode());
        } catch (RemoteException e) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onServiceConnected, invoke AC_SET_INITIAL_ARGS, ex = " + e.getMessage());
        }
    }

    protected final boolean Ke(String str) {
        Intent intent;
        if (str.startsWith("tel:")) {
            intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse(str));
            this.dEn.getContext().startActivity(intent);
            return true;
        } else if (!str.startsWith("sms:") && !str.startsWith("smsto:")) {
            return false;
        } else {
            intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse(str));
            this.dEn.getContext().startActivity(intent);
            return true;
        }
    }

    protected final void a(WebView webView, String str, Bitmap bitmap) {
        e.a(this.gdb, str);
        e.b(this.gdb).akn();
    }

    protected final void e(WebView webView, String str) {
        e.a(this.gdb, str);
        e.b(this.gdb).ue(str);
    }

    protected final int akt() {
        if (e.b(this.gdb).akq()) {
            return 55;
        }
        return 49;
    }

    protected final void e(Bundle bundle, String str) {
        super.e(bundle, str);
        bundle.putString("geta8key_data_appid", e.b(this.gdb).getAppId());
    }
}
