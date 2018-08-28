package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.ui.chatting.viewitems.ai.c;

class ai$c$1 implements OnClickListener {
    final /* synthetic */ r tWJ;
    final /* synthetic */ c uev;

    ai$c$1(c cVar, r rVar) {
        this.uev = cVar;
        this.tWJ = rVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c.aaH(this.tWJ.getFileName());
    }
}
