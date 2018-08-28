package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class c$4 implements OnClickListener {
    final /* synthetic */ OnClickListener iYJ;

    c$4(OnClickListener onClickListener) {
        this.iYJ = onClickListener;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.iYJ != null) {
            this.iYJ.onClick(dialogInterface, -1);
        }
    }
}
