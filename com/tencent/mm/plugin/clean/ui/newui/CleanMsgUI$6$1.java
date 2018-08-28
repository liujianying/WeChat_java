package com.tencent.mm.plugin.clean.ui.newui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;
import com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI.6;

class CleanMsgUI$6$1 implements OnClickListener {
    final /* synthetic */ 6 hTz;

    CleanMsgUI$6$1(6 6) {
        this.hTz = 6;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        CleanMsgUI.a(this.hTz.hTx, new e(d.aBg(), this.hTz.hTx, CleanMsgUI.aBB()));
        CleanMsgUI.b(this.hTz.hTx).start();
        CleanMsgUI.c(this.hTz.hTx).show();
    }
}
