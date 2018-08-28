package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.sdk.platformtools.bi;

class p$31 implements OnClickListener {
    final /* synthetic */ p gnH;

    p$31(p pVar) {
        this.gnH = pVar;
    }

    public final void onClick(View view) {
        e.a(this.gnH.mAppId, c.fcf);
        this.gnH.fdO.close();
        a.a(this.gnH.mAppId, this.gnH.getURL(), 22, "", bi.VE(), 1, 0);
    }
}
