package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class e$2 implements OnClickListener {
    final /* synthetic */ e hCy;

    e$2(e eVar) {
        this.hCy = eVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.hCy.hCu != null) {
            this.hCy.hCu.ayr();
        }
    }
}
