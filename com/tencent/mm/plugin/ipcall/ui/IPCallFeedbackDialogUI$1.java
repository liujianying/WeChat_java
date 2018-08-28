package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class IPCallFeedbackDialogUI$1 implements OnDismissListener {
    final /* synthetic */ IPCallFeedbackDialogUI kwl;

    IPCallFeedbackDialogUI$1(IPCallFeedbackDialogUI iPCallFeedbackDialogUI) {
        this.kwl = iPCallFeedbackDialogUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.kwl.finish();
    }
}
