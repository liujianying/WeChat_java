package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.chatting.ah.a;

class k$3 implements OnClickListener {
    final /* synthetic */ ah tIG;

    k$3(ah ahVar) {
        this.tIG = ahVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.tIG != null) {
            ah ahVar = this.tIG;
            a aVar = a.tMy;
            ahVar.cug();
        }
    }
}
