package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.sdk.platformtools.x;

class c$12 implements OnClickListener {
    final /* synthetic */ c lLe;
    final /* synthetic */ g lLf;

    c$12(c cVar, g gVar) {
        this.lLe = cVar;
        this.lLf = gVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.lLe.lKZ != null) {
            this.lLe.lKZ.o(0, this.lLf.id, "");
        }
        com.tencent.mm.plugin.offline.g.bR(this.lLf.bQa, com.tencent.mm.plugin.offline.g.lIT);
        x.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
    }
}
