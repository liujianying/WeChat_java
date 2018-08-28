package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.fav.ui.widget.a.a;
import com.tencent.mm.ui.base.h;

class FavCleanUI$5 implements a {
    final /* synthetic */ FavCleanUI iYA;

    FavCleanUI$5(FavCleanUI favCleanUI) {
        this.iYA = favCleanUI;
    }

    public final void aMh() {
        h.a(this.iYA.mController.tml, this.iYA.getString(i.fav_clean_delete_tips), "", new 1(this), null);
    }
}
