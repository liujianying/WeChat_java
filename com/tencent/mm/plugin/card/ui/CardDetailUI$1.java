package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.plugin.card.b.i;
import com.tencent.mm.plugin.card.model.am;

class CardDetailUI$1 implements a$a {
    final /* synthetic */ CardDetailUI hBR;

    CardDetailUI$1(CardDetailUI cardDetailUI) {
        this.hBR = cardDetailUI;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return true;
        }
        if (CardDetailUI.a(this.hBR) == -85.0f && CardDetailUI.b(this.hBR) == -1000.0f) {
            CardDetailUI.a(this.hBR, f2);
            CardDetailUI.b(this.hBR, f);
            am.axo().G(CardDetailUI.a(this.hBR), CardDetailUI.b(this.hBR));
        }
        i c = CardDetailUI.c(this.hBR);
        float b = CardDetailUI.b(this.hBR);
        float a = CardDetailUI.a(this.hBR);
        synchronized (c.hue) {
            c.cXm = a;
            c.cXn = b;
        }
        if (CardDetailUI.d(this.hBR)) {
            CardDetailUI.e(this.hBR);
            CardDetailUI.f(this.hBR);
        }
        CardDetailUI.g(this.hBR);
        return false;
    }
}
