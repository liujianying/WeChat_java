package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.Map;
import junit.framework.Assert;

public final class f implements d {
    public final b b(a aVar) {
        by byVar = aVar.dIN;
        if (byVar == null) {
            x.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM is null");
            return null;
        } else if (byVar.jQd == 36 || byVar.jQd == 39) {
            bd bdVar;
            int i;
            String a = ab.a(byVar.rcl);
            String a2 = ab.a(byVar.rcj);
            String a3 = ab.a(byVar.rck);
            x.d("MicroMsg.QMsgExtension", "parseQMsg content:" + a);
            au.HU();
            String str = (String) c.DT().get(2, null);
            String str2 = str.equals(a2) ? a3 : a2;
            au.HU();
            bd I = c.FT().I(str2, byVar.rcq);
            x.d("MicroMsg.QMsgExtension", "dkmsgid parseQMsg svrid:%d localid:%d", new Object[]{Long.valueOf(byVar.rcq), Long.valueOf(I.field_msgId)});
            if (I.field_msgId != 0 && I.field_createTime + 604800000 < com.tencent.mm.model.bd.o(a2, (long) byVar.lOH)) {
                x.w("MicroMsg.QMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[]{Long.valueOf(byVar.rcq), Long.valueOf(I.field_msgId)});
                com.tencent.mm.model.bd.aU(I.field_msgId);
                I.setMsgId(0);
            }
            if (I.field_msgId == 0) {
                I = new bd();
                I.ax(byVar.rcq);
                I.ay(com.tencent.mm.model.bd.o(a2, (long) byVar.lOH));
                bdVar = I;
            } else {
                bdVar = I;
            }
            bdVar.setType(byVar.jQd);
            bdVar.ep(str2);
            d JM = g.boc().JM(str2);
            if (JM == null || bi.oV(JM.getUsername()).length() <= 0) {
                JM = new d();
                JM.username = str2;
                JM.mbv = 1;
                JM.bWA = 9;
                if (!g.boc().a(JM)) {
                    x.e("MicroMsg.QMsgExtension", "parseQMsg : insert QContact failed : username = " + JM.getUsername());
                }
            }
            long j = -1;
            if (byVar.rcm == 2 && bdVar.field_msgId == 0) {
                byte[] a4 = ab.a(byVar.rcn);
                PString pString = new PString();
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                g Pf = o.Pf();
                int i2 = byVar.rcm;
                j = Pf.a(a4, byVar.rcq, false, "", pString, pInt, pInt2);
                if (j > 0) {
                    bdVar.eq(pString.value);
                    bdVar.fh(pInt.value);
                    bdVar.fi(pInt2.value);
                }
            }
            long j2 = j;
            if (byVar.jQd == 36) {
                com.tencent.mm.storage.ab abVar;
                Assert.assertTrue(true);
                Assert.assertTrue(bi.oV(a).length() > 0);
                Assert.assertTrue(bi.oV(bdVar.field_talker).length() > 0);
                Object obj = null;
                au.HU();
                com.tencent.mm.storage.ab Yg = c.FR().Yg(bdVar.field_talker);
                if (Yg == null || bi.oV(Yg.field_username).length() <= 0) {
                    obj = 1;
                    abVar = new com.tencent.mm.storage.ab(bdVar.field_talker);
                } else {
                    abVar = Yg;
                }
                a aVar2 = new a((byte) 0);
                Map z = bl.z(a, "msg");
                if (z != null) {
                    aVar2.daA = (String) z.get(".msg.from.displayname");
                    aVar2.content = (String) z.get(".msg.content.t");
                }
                abVar.dv(aVar2.daA == null ? "" : aVar2.daA);
                bdVar.setContent(aVar2.content == null ? "" : aVar2.content);
                if (obj != null) {
                    au.HU();
                    c.FR().T(abVar);
                } else {
                    au.HU();
                    c.FR().a(abVar.field_username, abVar);
                }
            }
            au.HU();
            Object obj2 = (c.FZ().has(a2) || str.equals(a2)) ? 1 : null;
            if (obj2 != null) {
                bdVar.eX(1);
                i = byVar.hcd;
                I = bdVar;
            } else {
                bdVar.eX(0);
                if (byVar.hcd > 3) {
                    i = byVar.hcd;
                    I = bdVar;
                } else {
                    i = 3;
                    I = bdVar;
                }
            }
            I.setStatus(i);
            bdVar.dt(byVar.rco);
            com.tencent.mm.model.bd.a(bdVar, aVar);
            if (bdVar.field_msgId == 0) {
                bdVar.setMsgId(com.tencent.mm.model.bd.i(bdVar));
                if (byVar.rcm == 2) {
                    e b = o.Pf().b(Long.valueOf(j2));
                    b.bo((long) ((int) bdVar.field_msgId));
                    o.Pf().a(Long.valueOf(j2), b);
                }
                return new b(bdVar, true);
            }
            au.HU();
            c.FT().b(byVar.rcq, bdVar);
            return new b(bdVar, false);
        } else {
            x.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM.type:%d", new Object[]{Integer.valueOf(byVar.jQd)});
            return null;
        }
    }

    public final void h(bd bdVar) {
        o.Pf().r(bdVar);
    }
}
