package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.base.h;

class i$7 implements OnClickListener {
    final /* synthetic */ i uqR;

    i$7(i iVar) {
        this.uqR = iVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.Em().H(new 1(this));
        i.e(this.uqR).dismiss();
        h.a(i.a(this.uqR), R.l.data_recovery_canceled, R.l.app_tip, false, new 2(this));
    }
}
