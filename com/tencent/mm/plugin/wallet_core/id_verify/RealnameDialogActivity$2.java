package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class RealnameDialogActivity$2 implements OnClickListener {
    final /* synthetic */ RealnameDialogActivity pjZ;

    RealnameDialogActivity$2(RealnameDialogActivity realnameDialogActivity) {
        this.pjZ = realnameDialogActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.pjZ.finish();
    }
}
