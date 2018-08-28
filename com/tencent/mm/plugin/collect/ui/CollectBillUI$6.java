package com.tencent.mm.plugin.collect.ui;

import android.widget.Toast;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.aup;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class CollectBillUI$6 implements a {
    final /* synthetic */ CollectBillUI hXA;

    CollectBillUI$6(CollectBillUI collectBillUI) {
        this.hXA = collectBillUI;
    }

    public final void cf(boolean z) {
        int i;
        x.i("MicroMsg.CollectBillUI", "update switch: %B", new Object[]{Boolean.valueOf(z)});
        CollectBillUI.j(this.hXA).setCheck(z);
        CollectBillUI.k(this.hXA).setCheck(z);
        if (z) {
            CollectBillUI.a(this.hXA, CollectBillUI.l(this.hXA) | 32768);
            CollectBillUI.m(this.hXA).setImageResource(h.collect_sound_on);
            CollectBillUI.n(this.hXA).setImageResource(h.collect_sound_on);
            Toast.makeText(this.hXA.mController.tml, i.collect_main_open_ring_tone_tips, 1).show();
            com.tencent.mm.plugin.report.service.h.mEJ.h(13944, new Object[]{Integer.valueOf(11)});
            i = 1;
        } else {
            CollectBillUI.a(this.hXA, CollectBillUI.l(this.hXA) & -32769);
            CollectBillUI.m(this.hXA).setImageResource(h.collect_sound_off);
            CollectBillUI.n(this.hXA).setImageResource(h.collect_sound_off);
            Toast.makeText(this.hXA.mController.tml, i.collect_main_close_ring_tone_tips, 1).show();
            com.tencent.mm.plugin.report.service.h.mEJ.h(13944, new Object[]{Integer.valueOf(12)});
            i = 2;
        }
        g.Ek();
        g.Ei().DT().set(147457, Long.valueOf(CollectBillUI.l(this.hXA)));
        aup aup = new aup();
        aup.mEc = i;
        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(209, aup));
        if (i == 1) {
            com.tencent.mm.plugin.collect.a.a.aBC().aBF();
        } else {
            com.tencent.mm.plugin.collect.a.a.aBC().aBG();
        }
    }
}
