package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.e;

abstract class j$f {
    protected abstract String getPackageName();

    private j$f() {
    }

    /* synthetic */ j$f(byte b) {
        this();
    }

    protected void a(Context context, e eVar, e eVar2, String str) {
        if (context != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + eVar2.latitude + "," + eVar2.longitude));
            intent.setPackage(getPackageName());
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
