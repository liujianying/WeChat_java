package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements OnClickListener {
    final /* synthetic */ Dialog nmd;

    a$3(Dialog dialog) {
        this.nmd = dialog;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog OnClick: close");
        if (this.nmd != null && this.nmd.isShowing()) {
            this.nmd.dismiss();
        }
    }
}
