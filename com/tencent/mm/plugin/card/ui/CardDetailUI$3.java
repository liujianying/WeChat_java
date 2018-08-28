package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.sdk.platformtools.x;

class CardDetailUI$3 implements e$d {
    final /* synthetic */ CardDetailUI hBR;

    CardDetailUI$3(CardDetailUI cardDetailUI) {
        this.hBR = cardDetailUI;
    }

    public final void ayo() {
        CardDetailUI.i(this.hBR);
    }

    public final void xH(String str) {
        CardDetailUI.a(this.hBR, str);
    }

    public final void ayp() {
        CardDetailUI.j(this.hBR);
    }

    public final void ayq() {
        CardDetailUI.k(this.hBR);
    }

    public final void ayr() {
        CardDetailUI.h(this.hBR);
    }

    public final void ays() {
        CardDetailUI.l(this.hBR);
    }

    public final void d(b bVar) {
        CardDetailUI.a(this.hBR, bVar);
        CardDetailUI.b(this.hBR, bVar.awq());
        CardDetailUI.m(this.hBR).htC = CardDetailUI.n(this.hBR);
    }

    public final void ayn() {
        CardDetailUI.o(this.hBR);
    }

    public final void ayt() {
        x.i("MicroMsg.CardDetailUI", "onConsumeCodeUIResult()");
    }

    public final void dT(boolean z) {
        x.i("MicroMsg.CardDetailUI", "doMark()");
        CardDetailUI.p(this.hBR);
        CardDetailUI.q(this.hBR);
        CardDetailUI.a(this.hBR, z);
        if (CardDetailUI.r(this.hBR).awf()) {
            am.axu().H(CardDetailUI.n(this.hBR), l.yc(CardDetailUI.r(this.hBR).aws()), 2);
        } else {
            am.axu().H(CardDetailUI.n(this.hBR), l.yc(CardDetailUI.r(this.hBR).aws()), 1);
        }
    }
}
