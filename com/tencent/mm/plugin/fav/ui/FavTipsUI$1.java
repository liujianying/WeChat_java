package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class FavTipsUI$1 implements OnClickListener {
    final /* synthetic */ FavTipsUI jaC;

    FavTipsUI$1(FavTipsUI favTipsUI) {
        this.jaC = favTipsUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.jaC.finish();
    }
}
