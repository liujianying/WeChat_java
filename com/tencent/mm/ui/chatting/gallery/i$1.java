package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.storage.bd;

class i$1 implements OnClickListener {
    final /* synthetic */ bd dAs;
    final /* synthetic */ r tWJ;
    final /* synthetic */ i tWK;

    i$1(i iVar, bd bdVar, r rVar) {
        this.tWK = iVar;
        this.dAs = bdVar;
        this.tWJ = rVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        i.tWC = true;
        i.a(this.tWK, this.dAs, this.tWJ);
    }
}
