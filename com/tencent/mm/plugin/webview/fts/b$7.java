package com.tencent.mm.plugin.webview.fts;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;

class b$7 extends w {
    final /* synthetic */ b pOa;

    b$7(b bVar) {
        this.pOa = bVar;
    }

    public final void js(String str) {
        x.v("FTSSearchWidgetMgr", "on widget call %s ", new Object[]{"onMakePhoneCall"});
        if (TextUtils.isEmpty(str)) {
            x.e("FTSSearchWidgetMgr", "onMakePhone null number");
            return;
        }
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
        intent.addFlags(268435456);
        if (bi.k(b.b(this.pOa), intent)) {
            b.b(this.pOa).startActivity(intent);
        }
    }
}
