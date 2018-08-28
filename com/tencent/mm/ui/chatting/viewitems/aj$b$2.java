package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.ad;
import com.tencent.mm.ui.chatting.viewitems.aj.b;

class aj$b$2 implements OnClickListener {
    final /* synthetic */ bd dAs;
    final /* synthetic */ ad ueE;
    final /* synthetic */ b ueF;

    aj$b$2(b bVar, ad adVar, bd bdVar) {
        this.ueF = bVar;
        this.ueE = adVar;
        this.dAs = bdVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.ueE.cwi();
        this.ueE.e(this.dAs, true);
    }
}
