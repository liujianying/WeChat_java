package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.viewitems.aj.c;
import com.tencent.neattextview.textview.view.NeatTextView.b;

class aj$b$1 implements b {
    final /* synthetic */ bd dAs;
    final /* synthetic */ String ueC;
    final /* synthetic */ aj.b ueF;

    aj$b$1(aj.b bVar, String str, bd bdVar) {
        this.ueF = bVar;
        this.ueC = str;
        this.dAs = bdVar;
    }

    public final boolean dK(View view) {
        c.c(ad.getContext(), this.ueC);
        aj.bD(this.dAs);
        return true;
    }
}
