package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.plugin.account.bind.ui.b.a;

class MobileFriendUI$15 implements a {
    final /* synthetic */ MobileFriendUI eIS;

    MobileFriendUI$15(MobileFriendUI mobileFriendUI) {
        this.eIS = mobileFriendUI;
    }

    public final void ja(int i) {
        if (i > 0) {
            MobileFriendUI.g(this.eIS).setVisibility(8);
        } else {
            MobileFriendUI.g(this.eIS).setVisibility(0);
        }
    }
}
