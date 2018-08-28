package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class p$2 implements OnLongClickListener {
    final /* synthetic */ p gnH;

    p$2(p pVar) {
        this.gnH = pVar;
    }

    public final boolean onLongClick(View view) {
        if (!(this.gnH.fdO.fcE.scene == 1086 || this.gnH.gno == null)) {
            if (this.gnH.gno.getCount() > 0) {
                this.gnH.gno.refresh();
                this.gnH.gnp.showAsDropDown(view);
                a.a(this.gnH.mAppId, this.gnH.getURL(), 21, "", bi.VE(), 1, 0);
            } else {
                x.i("MicroMsg.AppBrandPageView", "AppBrandRecentView getCount < 0, appId: %s", new Object[]{this.gnH.mAppId});
            }
        }
        return true;
    }
}
