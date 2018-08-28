package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.j.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.app.a.b;

class SnsTimeLineUI$20 implements b<c.b> {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$20(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final /* synthetic */ void be(Object obj) {
        c.b bVar = (c.b) obj;
        if (bVar.onp > 0 || ((bVar.onq != null && bVar.onq.size() > 0) || (SnsTimeLineUI.h(this.odw).nvg != null && SnsTimeLineUI.h(this.odw).nvg.bDo()))) {
            SnsTimeLineUI.w(this.odw).setVisibility(0);
        } else {
            SnsTimeLineUI.w(this.odw).setVisibility(8);
        }
        if (bVar.onp > 0) {
            SnsTimeLineUI.a(this.odw, bVar);
            SnsTimeLineUI.w(this.odw).findViewById(f.sns_notify_for_click).setVisibility(0);
        } else {
            SnsTimeLineUI.w(this.odw).findViewById(f.sns_notify_for_click).setVisibility(8);
        }
        if (bVar.onq == null || bVar.onq.size() <= 0) {
            SnsTimeLineUI.x(this.odw).setVisibility(8);
        } else {
            SnsTimeLineUI.x(this.odw).setVisibility(0);
            SnsTimeLineUI.x(this.odw).removeAllViews();
            for (Long longValue : bVar.onq) {
                SnsTimeLineUI.a(this.odw, longValue.longValue());
            }
        }
        if (SnsTimeLineUI.a(this.odw) != null && SnsTimeLineUI.y(this.odw).hasDrawed()) {
            SnsTimeLineUI.a(this.odw).oeg.notifyVendingDataChange();
            x.i("MicroMsg.SnsTimeLineUI", "has not show view, pass");
        }
    }
}
