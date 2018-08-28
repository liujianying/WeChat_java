package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.Preference.b;

class k$9 implements b {
    final /* synthetic */ String lWE;
    final /* synthetic */ k lWx;
    final /* synthetic */ String val$url;

    k$9(k kVar, String str, String str2) {
        this.lWx = kVar;
        this.val$url = str;
        this.lWE = str2;
    }

    public final boolean bnw() {
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.setClassName(ad.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        intent.putExtra("rawUrl", this.val$url);
        ad.getContext().startActivity(intent);
        h.mEJ.h(15319, new Object[]{this.lWx.guS.field_openImAppid, Integer.valueOf(6), this.lWE});
        return true;
    }
}
