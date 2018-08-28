package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.bge;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.view.b;
import com.tencent.mm.ui.chatting.view.b.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

class z$2 implements a {
    final /* synthetic */ bd dAs;
    final /* synthetic */ b tNp;
    final /* synthetic */ z tRa;

    z$2(z zVar, b bVar, bd bdVar) {
        this.tRa = zVar;
        this.tNp = bVar;
        this.dAs = bdVar;
    }

    public final void gx(long j) {
        this.tNp.hide();
        h.mEJ.a(795, 1, 1, false);
        if (NetUtil.isConnected(this.tRa.bAG.tTq.getContext())) {
            bge bge = new bge();
            bge.ixe = (int) (j / 1000);
            bge.hcE = 1;
            bge.sdX = 1;
            try {
                avm avm = new avm();
                avm.hbL = this.tRa.bAG.getTalkerUserName();
                avm.rcq = this.dAs.field_msgSvrId;
                avm.bHD = z.b(this.tRa, this.dAs);
                bge.rvr = new com.tencent.mm.bk.b(avm.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.ChattingUI.MsgRemindComponent", "[onOk] %s", new Object[]{e.toString()});
            }
            au.DF().a(new com.tencent.mm.modelsimple.x(1, bge), 0);
            return;
        }
        com.tencent.mm.ui.base.h.b(this.tRa.bAG.tTq.getContext(), this.tRa.bAG.tTq.getMMResources().getString(R.l.net_warn_no_network), this.tRa.bAG.tTq.getMMResources().getString(R.l.remind_err_title), true);
    }

    public final void onCancel() {
        this.tNp.hide();
    }
}
