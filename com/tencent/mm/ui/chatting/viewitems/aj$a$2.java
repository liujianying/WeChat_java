package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.ad;
import com.tencent.mm.ui.chatting.viewitems.aj.a;

class aj$a$2 implements OnClickListener {
    final /* synthetic */ bd dAs;
    final /* synthetic */ a ueD;
    final /* synthetic */ ad ueE;

    aj$a$2(a aVar, bd bdVar, ad adVar) {
        this.ueD = aVar;
        this.dAs = bdVar;
        this.ueE = adVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        q.H(this.dAs);
        this.ueE.cwi();
        this.ueE.e(this.dAs, true);
    }
}
