package com.tencent.mm.app;

import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.model.au;
import com.tencent.mm.model.m;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.y.g.a;

class WorkerProfile$10 extends c<nt> {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$10(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        this.sFo = nt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bd bdVar = ((nt) bVar).bYM.bGS;
        if (bdVar != null) {
            x.i("MicroMsg.WorkerProfile", "resend msg, type:%d", new Object[]{Integer.valueOf(bdVar.getType())});
            long iD;
            if (bdVar.ckz()) {
                ak.aH(bdVar);
            } else if (bdVar.ckA()) {
                ak.aI(bdVar);
            } else if (bdVar.cml()) {
                ak.aJ(bdVar);
            } else if (bdVar.isText()) {
                ak.aL(bdVar);
            } else if (bdVar.aQo()) {
                ak.aM(bdVar);
            } else if (bdVar.cmm()) {
                ak.aK(bdVar);
            } else if (bdVar.aQm()) {
                x.i("MicroMsg.ResendMsgLogic", "resendAppMsg, msgId:%d", new Object[]{Long.valueOf(bdVar.field_msgId)});
                iD = com.tencent.mm.model.bd.iD(bdVar.field_talker);
                if (iD == bdVar.field_createTime) {
                    iD++;
                }
                bdVar.ay(iD);
                au.HU();
                com.tencent.mm.model.c.FT().a(bdVar.field_msgId, bdVar);
                String str = bdVar.field_content;
                int i = bdVar.field_isSend;
                String str2 = bdVar.field_talker;
                boolean z = s.ha(str2) || m.gC(str2);
                if (z && str != null && i == 0) {
                    str = com.tencent.mm.model.bd.iC(str);
                }
                a gp = a.gp(str);
                if ((gp == null || 19 != gp.type) && (gp == null || 24 != gp.type)) {
                    l.ae(bdVar);
                } else {
                    mw mwVar = new mw();
                    mwVar.bXL.type = 4;
                    mwVar.bXL.bXQ = bdVar;
                    mwVar.bXL.toUser = bdVar.field_talker;
                    com.tencent.mm.sdk.b.a.sFg.m(mwVar);
                }
                com.tencent.mm.model.bd.aU(bdVar.field_msgId);
            } else if (bdVar.cmi()) {
                ak.aN(bdVar);
            } else if (bdVar.cmj() || bdVar.cmk()) {
                iD = com.tencent.mm.model.bd.iD(bdVar.field_talker);
                if (iD == bdVar.field_createTime) {
                    iD++;
                }
                bdVar.ay(iD);
                au.HU();
                com.tencent.mm.model.c.FT().a(bdVar.field_msgId, bdVar);
                r nI = o.Ta().nI(bdVar.field_imgPath);
                if (nI != null) {
                    nI.createTime = bdVar.field_createTime;
                    nI.bWA = 128;
                    o.Ta().b(nI);
                    x.i("MicroMsg.ResendMsgLogic", "resendVideoMsg, msgId:%d, msgtime: %d, infotime:%d", new Object[]{Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_createTime), Long.valueOf(nI.createTime)});
                }
                au.HU();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    t.nV(bdVar.field_imgPath);
                } else {
                    com.tencent.mm.ui.base.s.gH(ad.getContext());
                }
            } else {
                bdVar.setStatus(5);
                au.HU();
                com.tencent.mm.model.c.FT().a(bdVar.field_msgId, bdVar);
                x.e("MicroMsg.WorkerProfile", "resendMsg, unknown msg type");
            }
        }
        return false;
    }
}
