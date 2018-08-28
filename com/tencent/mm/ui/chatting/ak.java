package com.tencent.mm.ui.chatting;

import com.tencent.mm.g.a.nw;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.pluginsdk.model.app.an$a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

public final class ak {
    public static void aH(bd bdVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", new Object[]{Long.valueOf(bdVar.field_msgId)});
        if (s.hB(bdVar.field_talker)) {
            nx nxVar = new nx();
            nxVar.bYT.bGS = bdVar;
            a.sFg.m(nxVar);
            return;
        }
        nw nwVar = new nw();
        nwVar.bYS.bGS = bdVar;
        a.sFg.m(nwVar);
    }

    public static void aI(bd bdVar) {
        ov ovVar = new ov();
        long iD = com.tencent.mm.model.bd.iD(bdVar.field_talker);
        x.i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d, time[%d - > %d]", new Object[]{Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_createTime), Long.valueOf(iD)});
        if (iD == bdVar.field_createTime) {
            iD++;
        }
        bdVar.ay(iD);
        au.HU();
        c.FT().a(bdVar.field_msgId, bdVar);
        ovVar.bZP.bGS = bdVar;
        a.sFg.m(ovVar);
    }

    public static void aJ(bd bdVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", new Object[]{Long.valueOf(bdVar.field_msgId)});
        sm smVar = new sm();
        smVar.cdp.bGS = bdVar;
        a.sFg.m(smVar);
    }

    public static void aK(bd bdVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", new Object[]{Long.valueOf(bdVar.field_msgId)});
        long iD = com.tencent.mm.model.bd.iD(bdVar.field_talker);
        if (iD == bdVar.field_createTime) {
            iD++;
        }
        bdVar.ay(iD);
        au.HU();
        c.FT().a(bdVar.field_msgId, bdVar);
        b fH = ao.asF().fH(bdVar.field_msgId);
        if (fH == null || fH.field_msgInfoId != bdVar.field_msgId) {
            x.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
            ao.cca();
            an$a.fM(bdVar.field_msgId);
            return;
        }
        x.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
        fH.field_status = 101;
        fH.field_offset = 0;
        fH.field_lastModifyTime = System.currentTimeMillis() / 1000;
        ao.asF().c(fH, new String[0]);
        ao.cca().run();
    }

    public static void aL(bd bdVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", new Object[]{Long.valueOf(bdVar.field_msgId)});
        aO(bdVar);
    }

    public static void aM(bd bdVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", new Object[]{Long.valueOf(bdVar.field_msgId)});
        aO(bdVar);
    }

    public static void aN(bd bdVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", new Object[]{Long.valueOf(bdVar.field_msgId)});
        aO(bdVar);
    }

    private static void aO(bd bdVar) {
        long j = bdVar.field_msgId;
        if (j == -1) {
            x.e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId " + j);
        } else if (!bdVar.field_talker.equals("medianote") || (q.GJ() & 16384) != 0) {
            x.d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", new Object[]{Long.valueOf(j)});
            if (!au.DF().a(new i(j), 0)) {
                x.e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
                bdVar.setStatus(5);
                au.HU();
                c.FT().a(bdVar.field_msgId, bdVar);
                ox oxVar = new ox();
                oxVar.bZS.bGS = bdVar;
                a.sFg.m(oxVar);
            }
        }
    }
}
