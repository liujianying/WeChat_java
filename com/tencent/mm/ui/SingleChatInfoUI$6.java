package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class SingleChatInfoUI$6 implements OnClickListener {
    final /* synthetic */ ProgressDialog hsv;
    final /* synthetic */ SingleChatInfoUI tqo;

    SingleChatInfoUI$6(SingleChatInfoUI singleChatInfoUI, ProgressDialog progressDialog) {
        this.tqo = singleChatInfoUI;
        this.hsv = progressDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(14553, new Object[]{Integer.valueOf(6), Integer.valueOf(3), SingleChatInfoUI.d(this.tqo)});
        this.hsv.show();
        SingleChatInfoUI.dv(false);
        SingleChatInfoUI.a(this.tqo, this.hsv);
    }
}
