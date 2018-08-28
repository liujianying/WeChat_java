package com.tencent.mm.plugin.multitalk.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class MultiTalkMainUI$4 implements OnClickListener {
    final /* synthetic */ MultiTalkMainUI luY;

    MultiTalkMainUI$4(MultiTalkMainUI multiTalkMainUI) {
        this.luY = multiTalkMainUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.luY.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
