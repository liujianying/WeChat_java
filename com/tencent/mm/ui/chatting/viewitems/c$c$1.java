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

class c$c$1 implements OnClickListener {
    final /* synthetic */ long bAw;
    final /* synthetic */ bd dAs;
    final /* synthetic */ String sl;
    final /* synthetic */ Boolean uaw;
    final /* synthetic */ String uax;

    c$c$1(Boolean bool, long j, String str, String str2, bd bdVar) {
        this.uaw = bool;
        this.bAw = j;
        this.sl = str;
        this.uax = str2;
        this.dAs = bdVar;
    }

    public final void onClick(View view) {
        long j;
        String str;
        b fH;
        if (this.uaw.booleanValue()) {
            j = this.bAw;
            str = this.uax;
            fH = ao.asF().fH(j);
            if (fH == null) {
                x.e("MicroMsg.AppMsgLogic", "ERR:" + g.Ac() + " getinfo failed: " + str);
                return;
            } else if (fH.field_status != 101) {
                x.e("MicroMsg.AppMsgLogic", "ERR:" + g.Ac() + " get status failed: " + str + " status:" + fH.field_status);
                return;
            } else {
                fH.field_status = 102;
                fH.field_lastModifyTime = bi.VE();
                ao.asF().c(fH, new String[0]);
                return;
            }
        }
        j = this.bAw;
        str = this.uax;
        fH = ao.asF().fH(j);
        if (fH == null) {
            x.e("MicroMsg.AppMsgLogic", "ERR:" + g.Ac() + " getinfo failed: " + str);
        } else if (fH.field_status != 101) {
            x.e("MicroMsg.AppMsgLogic", "ERR:" + g.Ac() + " get status failed: " + str + " status:" + fH.field_status);
        } else {
            if (!bi.oW(fH.field_clientAppDataId) || bi.oW(fH.field_mediaSvrId)) {
                fH.field_status = 105;
            } else {
                fH.field_status = 102;
            }
            fH.field_lastModifyTime = bi.VE();
            ao.asF().c(fH, new String[0]);
        }
        this.dAs.setStatus(5);
        au.HU();
        c.FT().dW(this.bAw);
    }
}
