package com.tencent.mm.plugin.card.base;

import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.ui.base.h.c;

class CardBaseUI$5 implements c {
    final /* synthetic */ CardBaseUI htt;
    final /* synthetic */ String htu;
    final /* synthetic */ b htv;

    CardBaseUI$5(CardBaseUI cardBaseUI, b bVar, String str) {
        this.htt = cardBaseUI;
        this.htv = bVar;
        this.htu = str;
    }

    public final void ju(int i) {
        if (this.htv.avZ()) {
            switch (i) {
                case 0:
                    this.htt.a((CardInfo) this.htv);
                    return;
                case 1:
                    CardBaseUI.b(this.htt, this.htu);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 0:
                CardBaseUI.b(this.htt, this.htu);
                return;
            default:
                return;
        }
    }
}
