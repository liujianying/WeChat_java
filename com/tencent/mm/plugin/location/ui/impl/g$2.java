package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.model.o$b;
import com.tencent.mm.plugin.location.ui.k;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.l.8;
import com.tencent.mm.plugin.map.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bfv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class g$2 implements o$b {
    final /* synthetic */ g kJY;

    g$2(g gVar) {
        this.kJY = gVar;
    }

    public final void aZu() {
        x.i("MicroMsg.ShareMapUI", "onJoinSucess");
        o oVar = this.kJY.kJM;
        oVar.kDK = true;
        oVar.aZq();
        oVar.aZr();
        this.kJY.kJL.gk(true);
        if (this.kJY.kJO != null) {
            this.kJY.kJO.aZI();
        }
    }

    public final void a(bfv bfv) {
        g.a(this.kJY, bfv);
    }

    public final void onError(int i, String str) {
        x.v("MicroMsg.ShareMapUI", "onError type %d msg %s", new Object[]{Integer.valueOf(i), str});
        h.mEJ.h(10997, new Object[]{"7", "", Integer.valueOf(0), Integer.valueOf(0)});
        l lVar = this.kJY.kJN;
        x.d("MicroMsg.TrackPoiDialogMgr", "showErrorDialog, errMsg=%s", new Object[]{str});
        Context context = ad.getContext();
        String str2 = null;
        if (!bi.oW(str)) {
            str2 = str;
        } else if (i == 0) {
            str2 = context.getString(a.h.location_join_failed_tips);
        } else if (i == 1) {
            str2 = context.getString(a.h.location_refresh_failed_tips);
        } else if (i == 2) {
            str2 = context.getString(a.h.location_refresh_kick_out_tips);
        }
        com.tencent.mm.ui.base.h.a(lVar.mContext, str2, "", lVar.mResources.getString(a.h.app_ok), false, new 8(lVar, i));
    }

    public final void aZv() {
        this.kJY.kJL.gk(false);
        this.kJY.kJM.stop();
        this.kJY.kJM.rP(3);
        k.aZL();
        this.kJY.activity.finish();
        this.kJY.activity.overridePendingTransition(a.a.push_empty_out, a.a.push_up_out);
    }
}
