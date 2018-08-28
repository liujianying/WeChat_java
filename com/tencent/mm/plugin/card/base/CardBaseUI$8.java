package com.tencent.mm.plugin.card.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class CardBaseUI$8 implements OnClickListener {
    final /* synthetic */ CardBaseUI htt;

    CardBaseUI$8(CardBaseUI cardBaseUI) {
        this.htt = cardBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.htt.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
