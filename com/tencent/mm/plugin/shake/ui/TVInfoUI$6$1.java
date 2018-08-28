package com.tencent.mm.plugin.shake.ui;

import com.tencent.mm.g.a.cc;
import com.tencent.mm.plugin.shake.ui.TVInfoUI.6;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.d;

class TVInfoUI$6$1 implements d {
    final /* synthetic */ 6 nbE;

    TVInfoUI$6$1(6 6) {
        this.nbE = 6;
    }

    public final void bx(int i, int i2) {
        switch (i2) {
            case -1:
                cc ccVar = new cc();
                ccVar.bJy.bJA = this.nbE.nbD.getIntent().getLongExtra("key_favorite_local_id", -1);
                a.sFg.m(ccVar);
                x.d("MicroMsg.TVInfoUI", "do del fav tv, local id %d, result %B", new Object[]{Long.valueOf(ccVar.bJy.bJA), Boolean.valueOf(ccVar.bJz.bJm)});
                if (ccVar.bJz.bJm) {
                    this.nbE.nbD.finish();
                    return;
                }
                return;
            default:
                x.d("MicroMsg.TVInfoUI", "do del cancel");
                return;
        }
    }
}
