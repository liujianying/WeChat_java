package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements OnClickListener {
    final /* synthetic */ c lLe;

    c$3(c cVar) {
        this.lLe = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.lLe.lKZ.bkZ();
        x.i("MicroMsg.OfflineLogicMgr", "do changeBankcard");
    }
}
