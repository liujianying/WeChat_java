package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;

class IPCallShareCouponCardUI$12 implements c {
    final /* synthetic */ IPCallShareCouponCardUI kyi;

    IPCallShareCouponCardUI$12(IPCallShareCouponCardUI iPCallShareCouponCardUI) {
        this.kyi = iPCallShareCouponCardUI;
    }

    public final void a(l lVar) {
        Iterator it = IPCallShareCouponCardUI.a(this.kyi, IPCallShareCouponCardUI.b(this.kyi).syn).iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            CharSequence H = IPCallShareCouponCardUI.H(this.kyi.mController.tml, num.intValue());
            int rH = IPCallShareCouponCardUI.rH(num.intValue());
            if (!(H == null || rH == -1)) {
                lVar.a(num.intValue(), H, rH);
            }
        }
    }
}
