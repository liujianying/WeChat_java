package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.ac.z;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.x;

class BizTimeLineUI$4 implements Runnable {
    final /* synthetic */ BizTimeLineUI hst;
    final /* synthetic */ long hsu;

    BizTimeLineUI$4(BizTimeLineUI bizTimeLineUI, long j) {
        this.hst = bizTimeLineUI;
        this.hsu = j;
    }

    public final void run() {
        if (z.Ne().gi(this.hsu) > 0) {
            float x = BizTimeLineUI.f(this.hst).getX();
            int width = (int) ((((float) BizTimeLineUI.f(this.hst).getWidth()) + (x + x)) / 2.0f);
            int fk = a.fk(this.hst.mController.tml) / 2;
            if (width != fk) {
                BizTimeLineUI.f(this.hst).setX(((float) (fk - width)) + x);
                x.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView x = %f, new x=%f", new Object[]{Float.valueOf(x), Float.valueOf(r1)});
            }
            if (BizTimeLineUI.f(this.hst).getVisibility() != 0) {
                BizTimeLineUI.f(this.hst).setVisibility(0);
            }
        }
    }
}
