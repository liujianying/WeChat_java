package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

class c$c$2 implements OnClickListener {
    final /* synthetic */ long bAw;
    final /* synthetic */ bd dAs;
    final /* synthetic */ Boolean uaw;
    final /* synthetic */ String uax;

    c$c$2(Boolean bool, long j, String str, bd bdVar) {
        this.uaw = bool;
        this.bAw = j;
        this.uax = str;
        this.dAs = bdVar;
    }

    public final void onClick(View view) {
        if (!this.uaw.booleanValue()) {
            long j = this.bAw;
            String str = this.uax;
            b fH = ao.asF().fH(j);
            if (fH == null) {
                x.e("MicroMsg.AppMsgLogic", "ERR:" + g.Ac() + " getinfo failed: " + str);
            } else if (fH.field_status != 105) {
                x.e("MicroMsg.AppMsgLogic", "ERR:" + g.Ac() + " get status failed: " + str + " status:" + fH.field_status);
            } else {
                fH.field_status = 101;
                fH.field_lastModifyTime = bi.VE();
                ao.asF().c(fH, new String[0]);
                ao.cca().run();
            }
            this.dAs.setStatus(1);
            au.HU();
            c.FT().dW(this.bAw);
        }
    }
}
