package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class FavTipsUI$2 implements OnCancelListener {
    final /* synthetic */ FavTipsUI jaC;

    FavTipsUI$2(FavTipsUI favTipsUI) {
        this.jaC = favTipsUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.jaC.finish();
    }
}
