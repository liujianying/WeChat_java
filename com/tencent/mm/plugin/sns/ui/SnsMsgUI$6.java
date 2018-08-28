package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.r;

class SnsMsgUI$6 implements OnCancelListener {
    final /* synthetic */ SnsMsgUI nYl;
    final /* synthetic */ r nYm;

    SnsMsgUI$6(SnsMsgUI snsMsgUI, r rVar) {
        this.nYl = snsMsgUI;
        this.nYm = rVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.Ek();
        g.Eh().dpP.c(this.nYm);
    }
}
