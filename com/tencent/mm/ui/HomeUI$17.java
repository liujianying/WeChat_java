package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class HomeUI$17 implements OnClickListener {
    final /* synthetic */ HomeUI tjS;

    HomeUI$17(HomeUI homeUI) {
        this.tjS = homeUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        HomeUI.d(this.tjS).startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
