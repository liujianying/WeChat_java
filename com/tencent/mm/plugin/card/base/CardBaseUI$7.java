package com.tencent.mm.plugin.card.base;

import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.card.model.am;

class CardBaseUI$7 implements a$a {
    final /* synthetic */ CardBaseUI htt;

    CardBaseUI$7(CardBaseUI cardBaseUI) {
        this.htt = cardBaseUI;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (z) {
            if (!(f2 == -85.0f || f == -1000.0f)) {
                CardBaseUI.a(this.htt, f2);
                CardBaseUI.b(this.htt, f);
                am.axo().G(CardBaseUI.a(this.htt), CardBaseUI.b(this.htt));
                this.htt.avM();
            }
            if (!CardBaseUI.c(this.htt)) {
                CardBaseUI.d(this.htt);
                o.a(2010, f, f2, (int) d2);
            }
            return false;
        }
        this.htt.avN();
        return true;
    }
}
