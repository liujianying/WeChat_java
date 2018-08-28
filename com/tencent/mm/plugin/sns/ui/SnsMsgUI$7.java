package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class SnsMsgUI$7 implements OnClickListener {
    final /* synthetic */ SnsMsgUI nYl;

    SnsMsgUI$7(SnsMsgUI snsMsgUI) {
        this.nYl = snsMsgUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SnsMsgUI.a(this.nYl, true);
    }
}
