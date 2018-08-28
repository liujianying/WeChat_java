package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.g.a.bw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.a;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$7 extends c<bw> {
    final /* synthetic */ e hCy;

    e$7(e eVar) {
        this.hCy = eVar;
        this.sFo = bw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bw bwVar = (bw) bVar;
        if (g.Eg().Dx()) {
            x.i("MicroMsg.CardDetailUIContoller", "deal with card notify event ConsumedCardByOfflinePayEvent");
            if (bwVar instanceof bw) {
                if (bwVar.bJn.bjW == 0) {
                    d.b(this.hCy.hBT, this.hCy.hBT.getResources().getString(a.g.card_wx_offline_mark_card_expire_time));
                }
                return true;
            }
        }
        return false;
    }
}
