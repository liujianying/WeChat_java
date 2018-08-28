package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.ah.a;
import java.util.List;

class k$1 implements OnClickListener {
    final /* synthetic */ List tIF;
    final /* synthetic */ ah tIG;
    final /* synthetic */ boolean tIH;
    final /* synthetic */ String tII;
    final /* synthetic */ Context val$context;

    k$1(List list, ah ahVar, Context context, boolean z, String str) {
        this.tIF = list;
        this.tIG = ahVar;
        this.val$context = context;
        this.tIH = z;
        this.tII = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Object obj;
        List<bd> list = this.tIF;
        if (list != null && !list.isEmpty()) {
            for (bd bdVar : list) {
                if (!j.au(bdVar)) {
                    if (!bdVar.ckz() && !j.ap(bdVar) && !j.ar(bdVar) && !j.aA(bdVar) && !j.as(bdVar) && bdVar.getType() != -1879048186 && !j.az(bdVar) && !j.at(bdVar) && !j.ay(bdVar) && !j.au(bdVar) && bdVar.getType() != 318767153) {
                        obj = null;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        x.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to friend msg error, select item empty");
        obj = 1;
        if (obj != null) {
            x.w("MicroMsg.ChattingEditModeRetransmitMsg", "only contain invalid msg, exit long click mode");
            if (this.tIG != null) {
                this.tIG.b(a.tMy);
                return;
            }
            return;
        }
        k.c(this.val$context, this.tIF, this.tIH, this.tII, this.tIG);
    }
}
