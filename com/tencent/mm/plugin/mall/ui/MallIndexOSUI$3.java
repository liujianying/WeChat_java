package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ccq;

class MallIndexOSUI$3 implements OnClickListener {
    final /* synthetic */ MallIndexOSUI kZI;
    final /* synthetic */ ccq kZK;

    MallIndexOSUI$3(MallIndexOSUI mallIndexOSUI, ccq ccq) {
        this.kZI = mallIndexOSUI;
        this.kZK = ccq;
    }

    public final void onClick(View view) {
        h.mEJ.h(13867, new Object[]{ab.a(this.kZK.syr), Integer.valueOf(this.kZI.kYc)});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", ab.a(this.kZK.syr));
        intent.putExtra("geta8key_username", q.GF());
        intent.putExtra("pay_channel", 1);
        d.b(this.kZI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
