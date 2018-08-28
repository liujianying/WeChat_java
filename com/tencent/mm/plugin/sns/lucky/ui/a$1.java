package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements OnCancelListener {
    final /* synthetic */ Dialog nmd;

    a$1(Dialog dialog) {
        this.nmd = dialog;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onCancel");
        if (this.nmd != null && this.nmd.isShowing()) {
            this.nmd.dismiss();
        }
    }
}
