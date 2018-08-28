package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class c$2 implements OnClickListener {
    final /* synthetic */ OnClickListener iYI;

    c$2(OnClickListener onClickListener) {
        this.iYI = onClickListener;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.iYI != null) {
            this.iYI.onClick(dialogInterface, -1);
        }
    }
}
