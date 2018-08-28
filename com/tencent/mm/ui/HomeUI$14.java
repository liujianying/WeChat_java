package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class HomeUI$14 implements OnClickListener {
    final /* synthetic */ HomeUI tjS;

    HomeUI$14(HomeUI homeUI) {
        this.tjS = homeUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        HomeUI.d(this.tjS).startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
