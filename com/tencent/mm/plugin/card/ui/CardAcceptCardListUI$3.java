package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.p;
import java.util.LinkedList;

class CardAcceptCardListUI$3 implements OnClickListener {
    final /* synthetic */ CardAcceptCardListUI hBm;

    CardAcceptCardListUI$3(CardAcceptCardListUI cardAcceptCardListUI) {
        this.hBm = cardAcceptCardListUI;
    }

    public final void onClick(View view) {
        if (CardAcceptCardListUI.a(this.hBm)) {
            CardAcceptCardListUI.a(this.hBm, CardAcceptCardListUI.b(this.hBm));
            return;
        }
        CardAcceptCardListUI cardAcceptCardListUI = this.hBm;
        LinkedList b = CardAcceptCardListUI.b(this.hBm);
        cardAcceptCardListUI.dO(true);
        g.Eh().dpP.a(new p(b, cardAcceptCardListUI.cae, cardAcceptCardListUI.hBh, cardAcceptCardListUI.hBi, cardAcceptCardListUI.hBg), 0);
    }
}
