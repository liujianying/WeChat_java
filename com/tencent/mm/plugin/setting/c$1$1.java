package com.tencent.mm.plugin.setting;

import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.setting.c.1;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;

class c$1$1 implements Runnable {
    final /* synthetic */ String dMs;
    final /* synthetic */ 1 mOF;

    c$1$1(1 1, String str) {
        this.mOF = 1;
        this.dMs = str;
    }

    public final void run() {
        ab Yg = ((i) g.l(i.class)).FR().Yg(this.dMs);
        if (Yg != null && !a.gd(Yg.field_type) && Yg.By() && !Yg.Bz()) {
            bd bdVar = new bd();
            bdVar.eX(0);
            bdVar.ep(this.dMs);
            bdVar.setStatus(6);
            bdVar.setContent(ad.getContext().getString(a.i.settings_jump_to_verifypage_tips));
            bdVar.ay(com.tencent.mm.model.bd.o(this.dMs, System.currentTimeMillis() / 1000));
            bdVar.setType(10000);
            ((i) g.l(i.class)).bcY().T(bdVar);
            x.i("MicroMsg.SubCoreSetting", "insert chatcontact verify sysmsg. %s", new Object[]{this.dMs});
        }
    }
}
