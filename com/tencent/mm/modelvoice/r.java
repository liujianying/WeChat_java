package com.tencent.mm.modelvoice;

import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class r implements d {
    private static Set<c> epP = new HashSet();

    public static void c(c cVar) {
        if (!epP.contains(cVar)) {
            epP.add(cVar);
        }
    }

    public static void b(c cVar) {
        epP.remove(cVar);
    }

    public final b b(a aVar) {
        by byVar = aVar.dIN;
        if (byVar == null) {
            x.e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
            return null;
        }
        String a;
        p bE;
        x.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + byVar.rcq);
        String a2 = ab.a(byVar.rcj);
        if (a2.equals(q.GF())) {
            a = ab.a(byVar.rck);
        } else {
            a = a2;
        }
        bd I = ((i) g.l(i.class)).bcY().I(a, byVar.rcq);
        if (I.field_msgId != 0 && I.field_createTime + 604800000 < com.tencent.mm.model.bd.o(a, (long) byVar.lOH)) {
            x.w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", new Object[]{Long.valueOf(byVar.rcq)});
            com.tencent.mm.model.bd.p(a, byVar.rcq);
            bE = m.TI().bE(byVar.rcq);
            if (!(bE == null || bi.oW(bE.fileName))) {
                q.oq(bE.fileName);
            }
        }
        bE = new p();
        bE.bWJ = a;
        bE.createTime = (long) byVar.lOH;
        bE.bYu = byVar.rcq;
        bE.cqb = byVar.rco;
        x.d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", new Object[]{byVar.rco});
        String a3 = ab.a(byVar.rcl);
        if (s.fq(a2)) {
            a2 = com.tencent.mm.model.bd.iC(a3);
            x.i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=" + a2);
        } else {
            a2 = a3;
        }
        Map z = bl.z(a2, "msg");
        if (z == null) {
            h.mEJ.a(111, 227, 1, false);
            return null;
        }
        try {
            bE.emu = Integer.valueOf((String) z.get(".msg.voicemsg.$length")).intValue();
            bE.clientId = (String) z.get(".msg.voicemsg.$clientmsgid");
            int intValue = Integer.valueOf((String) z.get(".msg.voicemsg.$endflag")).intValue();
            int intValue2 = Integer.valueOf((String) z.get(".msg.voicemsg.$cancelflag")).intValue();
            bE.epI = Integer.valueOf((String) z.get(".msg.voicemsg.$voicelength")).intValue();
            bE.enF = (String) z.get(".msg.voicemsg.$fromusername");
            String str = (String) z.get(".msg.commenturl");
            bE.eoI = Integer.valueOf(bi.aG((String) z.get(".msg.voicemsg.$forwardflag"), "0")).intValue();
            bE.eoB = (String) z.get(".msg.voicemsg.$voiceformat");
            bE.epJ = bi.getLong((String) z.get(".msg.voicemsg.$bufid"), 0);
            if (intValue2 == 1) {
                x.v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + byVar.rcq);
                bE = m.TI().bE(bE.bYu);
                if (bE != null) {
                    q.oo(bE.fileName);
                }
                return null;
            }
            cm I2;
            if (intValue == 1) {
                x.v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + byVar.rcq);
                bE.dHI = bE.emu;
            }
            bE.bWA = 284334;
            byte[] a4 = ab.a(byVar.rcn);
            if (a4 != null) {
                x.d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + a4.length + " srvId:" + byVar.rcq);
            }
            if (q.a(bE, a4, byVar.hcd, str, byVar.rco, aVar) > 0) {
                x.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", new Object[]{Integer.valueOf(q.a(bE, a4, byVar.hcd, str, byVar.rco, aVar)), Long.valueOf(byVar.rcq), Integer.valueOf(byVar.rcr)});
                h.mEJ.a(111, 228, 1, false);
                I2 = ((i) g.l(i.class)).bcY().I(bE.bWJ, bE.bYu);
                I2.Dn(0);
                for (c 1 : epP) {
                    ah.A(new 1(this, 1, bE));
                }
            } else {
                x.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", new Object[]{Integer.valueOf(q.a(bE, a4, byVar.hcd, str, byVar.rco, aVar)), Long.valueOf(byVar.rcq), Integer.valueOf(byVar.rcr), bi.cjd()});
                I2 = null;
            }
            if (I2 != null) {
                ai Yq = ((i) g.l(i.class)).FW().Yq(a);
                if (Yq != null) {
                    Yq.gg(16777216);
                    ((i) g.l(i.class)).FW().a(Yq, a);
                }
            }
            boolean z2 = I2 != null && I2.field_msgId > 0;
            return new b(I2, z2);
        } catch (Throwable e) {
            h.mEJ.a(111, 227, 1, false);
            x.e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
            x.e("MicroMsg.VoiceMsgExtension", "exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }

    public final void h(bd bdVar) {
        x.d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + bdVar.field_imgPath + " " + bdVar.field_talker);
        if (!s.hB(bdVar.field_talker)) {
            q.oq(bdVar.field_imgPath);
        }
    }
}
