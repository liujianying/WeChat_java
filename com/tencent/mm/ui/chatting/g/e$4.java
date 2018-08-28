package com.tencent.mm.ui.chatting.g;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.ch;
import java.util.List;

class e$4 implements OnClickListener {
    final /* synthetic */ List gco;
    final /* synthetic */ ch tOZ;
    final /* synthetic */ e tYu;

    e$4(e eVar, ch chVar, List list) {
        this.tYu = eVar;
        this.tOZ = chVar;
        this.gco = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.tOZ.bJF.type != 14 || this.tOZ.bJF.bJH.rBI.size() != 0) {
            e.a(this.tYu, this.tOZ);
            e.dP(this.gco);
        }
    }
}
