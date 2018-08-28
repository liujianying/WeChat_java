package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.j;
import com.tencent.mm.ui.chatting.m.4;
import com.tencent.mm.ui.chatting.m.b;
import java.util.List;

class m$4$9 implements OnClickListener {
    final /* synthetic */ 4 tIT;
    final /* synthetic */ MenuItem tIU;

    m$4$9(4 4, MenuItem menuItem) {
        this.tIT = 4;
        this.tIU = menuItem;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        boolean z;
        List<bd> list = this.tIT.tIF;
        if (list != null && !list.isEmpty()) {
            for (bd bdVar : list) {
                if (!j.au(bdVar)) {
                    if (!bdVar.ckz() && !j.ap(bdVar) && !bdVar.cmi() && !j.ar(bdVar) && !j.as(bdVar) && bdVar.getType() != -1879048186 && !j.az(bdVar) && !j.at(bdVar) && !j.ay(bdVar) && !j.aC(bdVar)) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        x.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to brand service error, select item empty");
        z = true;
        if (z) {
            x.w("MicroMsg.ChattingEditModeSendToBrand", "only contain invalid msg, exit long click mode");
            if (this.tIT.tIS != null) {
                this.tIT.tIS.cuQ();
                return;
            }
            return;
        }
        Context context = this.tIT.val$context;
        this.tIT.val$context.getString(R.l.app_tip);
        m.a(h.a(context, this.tIT.val$context.getString(R.l.sending_message), false, null));
        j.tOP.c(new b(this.tIT.tIQ, this.tIT.val$context, this.tIU.getTitle(), -1, m.ctg()));
        if (this.tIT.tIS != null) {
            this.tIT.tIS.cuQ();
        }
    }
}
