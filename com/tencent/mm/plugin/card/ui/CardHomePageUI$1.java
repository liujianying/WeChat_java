package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.am;

class CardHomePageUI$1 implements Runnable {
    final /* synthetic */ CardHomePageUI hEJ;

    CardHomePageUI$1(CardHomePageUI cardHomePageUI) {
        this.hEJ = cardHomePageUI;
    }

    public final void run() {
        am.axy().a(q.EN_DYNAMIC_CODE_SCENE_ENTER_WXCARD);
    }
}
