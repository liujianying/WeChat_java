package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.contact.VoipAddressUI;

class ae$1 implements OnClickListener {
    final /* synthetic */ ae tpM;

    ae$1(ae aeVar) {
        this.tpM = aeVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        rn rnVar = new rn();
        rnVar.ccn.ccq = true;
        a.sFg.m(rnVar);
        VoipAddressUI.gR(ae.c(this.tpM));
        dialogInterface.dismiss();
    }
}
