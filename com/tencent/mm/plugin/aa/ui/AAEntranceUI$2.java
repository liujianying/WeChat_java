package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.mm.plugin.aa.ui.a.a;

class AAEntranceUI$2 implements a {
    final /* synthetic */ AAEntranceUI eBL;

    AAEntranceUI$2(AAEntranceUI aAEntranceUI) {
        this.eBL = aAEntranceUI;
    }

    public final void We() {
        this.eBL.startActivity(new Intent(this.eBL.mController.tml, AAQueryListUI.class));
    }
}
