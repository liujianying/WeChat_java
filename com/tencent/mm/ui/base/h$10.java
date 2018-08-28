package com.tencent.mm.ui.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

class h$10 implements OnCancelListener {
    final /* synthetic */ OnClickListener pVb;

    h$10(OnClickListener onClickListener) {
        this.pVb = onClickListener;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.pVb != null) {
            this.pVb.onClick(dialogInterface, 0);
        }
    }
}
