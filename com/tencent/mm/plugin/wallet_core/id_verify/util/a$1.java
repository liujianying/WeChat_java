package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.wallet_core.ui.h.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.e;

class a$1 implements a {
    final /* synthetic */ MMActivity bAl;
    final /* synthetic */ int plc;
    final /* synthetic */ String pld;
    final /* synthetic */ a ple;

    a$1(a aVar, int i, String str, MMActivity mMActivity) {
        this.ple = aVar;
        this.plc = i;
        this.pld = str;
        this.bAl = mMActivity;
    }

    public final void onClick(View view) {
        e.a(3, bi.VE(), this.plc);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.pld);
        intent.putExtra("showShare", false);
        d.b(this.bAl, "webview", ".ui.tools.WebViewUI", intent);
    }
}
