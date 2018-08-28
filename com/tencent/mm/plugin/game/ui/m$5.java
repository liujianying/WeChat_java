package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class m$5 implements OnClickListener {
    final /* synthetic */ m jZZ;

    m$5(m mVar) {
        this.jZZ = mVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.jZZ.notifyDataSetChanged();
    }
}
