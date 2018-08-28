package com.tencent.mm.pluginsdk.ui.chat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.3;
import com.tencent.mm.sdk.b.a;

class AppPanel$3$3 implements OnClickListener {
    final /* synthetic */ 3 qKI;

    AppPanel$3$3(3 3) {
        this.qKI = 3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        rn rnVar = new rn();
        rnVar.ccn.ccq = true;
        a.sFg.m(rnVar);
        AppPanel.k(this.qKI.qKH).bcz();
        dialogInterface.dismiss();
    }
}
