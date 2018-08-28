package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class ExdeviceProfileUI$27 implements Runnable {
    final /* synthetic */ ExdeviceProfileUI iEx;

    ExdeviceProfileUI$27(ExdeviceProfileUI exdeviceProfileUI) {
        this.iEx = exdeviceProfileUI;
    }

    public final void run() {
        a l = ExdeviceProfileUI.l(this.iEx);
        Object p = ExdeviceProfileUI.p(this.iEx);
        List q = ExdeviceProfileUI.q(this.iEx);
        l.iDx = ad.aHg().Af(l.gtX);
        l.iDA = p;
        if (bi.cX(p)) {
            l.iDy = 0;
        } else {
            l.iDy = p.size();
        }
        l.iDB = q;
        if (!bi.cX(q)) {
            l.iDz = q.size();
        }
        x.d("MicroMsg.ExdeviceProfileAdapter", "setData,mIsFollower:%s ,mFollowersNum:%s  ,mButtonNum:%s ,mUsername:%s", new Object[]{Boolean.valueOf(l.iDx), Integer.valueOf(l.iDy), Integer.valueOf(l.iDz), l.gtX});
        ExdeviceProfileUI.l(this.iEx).notifyDataSetChanged();
    }
}
