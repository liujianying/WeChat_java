package com.tencent.mm.plugin.messenger.foundation;

import android.database.Cursor;
import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.be;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.protocal.c.rd;
import com.tencent.mm.protocal.c.rj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.List;

public final class c implements q {
    public final void a(pm pmVar, byte[] bArr, boolean z, s sVar) {
        boolean z2 = false;
        switch (pmVar.rtM) {
            case 5:
                by byVar = (by) new by().aG(bArr);
                if (byVar != null) {
                    a aVar = new a(byVar, false, false, false);
                    a(aVar, sVar);
                    if (!aVar.dIO) {
                        be.a(ab.a(byVar.rcj), byVar.rcq, ((long) byVar.lOH) * 1000, byVar.jQd);
                        return;
                    }
                    return;
                }
                return;
            case 8:
                rd rdVar = (rd) new rd().aG(bArr);
                String a = ab.a(rdVar.rvi);
                int i = rdVar.rvm;
                Cursor bD = ((i) g.l(i.class)).bcY().bD(a, i);
                if (bD.moveToFirst()) {
                    while (!bD.isAfterLast()) {
                        bd bdVar = new bd();
                        bdVar.d(bD);
                        com.tencent.mm.model.bd.j(bdVar);
                        bD.moveToNext();
                    }
                }
                bD.close();
                ((i) g.l(i.class)).bcY().bC(a, i);
                return;
            case 9:
                rj rjVar = (rj) new rj().aG(bArr);
                List list = rjVar.rvp;
                while (true) {
                    boolean z3 = z2;
                    if (z3 < list.size()) {
                        com.tencent.mm.model.bd.p(ab.a(rjVar.rvi), (long) ((Integer) list.get(z3)).intValue());
                        z2 = z3 + 1;
                    } else {
                        return;
                    }
                }
            default:
                return;
        }
    }

    public static void a(a aVar, s sVar) {
        by byVar = aVar.dIN;
        if (10008 == af.exm && af.exn != 0) {
            x.i("MicroMsg.MessageSyncExtension", "dkmsgid  set svrmsgid %d -> %d", new Object[]{Long.valueOf(byVar.rcq), Integer.valueOf(af.exn)});
            byVar.rcq = Long.valueOf((long) af.exn).longValue();
            af.exn = 0;
        }
        if (((i) g.l(i.class)).bcY().dY(byVar.rcq)) {
            x.i("MicroMsg.MessageSyncExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
            return;
        }
        String a = ab.a(byVar.rcj);
        String a2 = ab.a(byVar.rck);
        if (a.equals(com.tencent.mm.model.q.GF()) && a2.equals("newsapp") && byVar.jQd != 51) {
            x.w("MicroMsg.MessageSyncExtension", "msgid:%d type:%d this fucking msg from mac weixin ,someone send msg to newsapp at mac weixin ,givp up.", new Object[]{Long.valueOf(byVar.rcq), Integer.valueOf(byVar.jQd)});
            return;
        }
        int i;
        String str = "MicroMsg.MessageSyncExtension";
        String str2 = "dkAddMsg from:%s to:%s id:[%d,%d,%d] status:%d type:%d time:[%d %s] diff:%d imgstatus:%d imgbuf:%d src:%d push:%d content:%s";
        Object[] objArr = new Object[15];
        objArr[0] = a;
        objArr[1] = a2;
        objArr[2] = Long.valueOf(byVar.rcq);
        objArr[3] = Integer.valueOf(byVar.rci);
        objArr[4] = Integer.valueOf(byVar.rcr);
        objArr[5] = Integer.valueOf(byVar.hcd);
        objArr[6] = Integer.valueOf(byVar.jQd);
        objArr[7] = Integer.valueOf(byVar.lOH);
        objArr[8] = bi.gb((long) byVar.lOH);
        objArr[9] = Long.valueOf(bi.VE() - ((long) byVar.lOH));
        objArr[10] = Integer.valueOf(byVar.rcm);
        objArr[11] = Integer.valueOf(ab.a(byVar.rcn, new byte[0]).length);
        objArr[12] = Integer.valueOf(bi.oV(byVar.rco).length());
        objArr[13] = Integer.valueOf(bi.oV(byVar.rcp).length());
        bhz bhz = byVar.rcl;
        a2 = "";
        if (bhz != null) {
            a2 = bhz.siM;
        }
        objArr[14] = bi.Xf(a2);
        x.i(str, str2, objArr);
        x.i("MicroMsg.MessageSyncExtension", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[]{byVar.rco, ""});
        t.h(byVar);
        if (a.equals("readerapp")) {
            byVar.rcj = ab.oT("newsapp");
            byVar.jQd = 12399999;
        }
        if ((a.equals("blogapp") || a.equals("newsapp")) && byVar.jQd != 10002) {
            byVar.jQd = 12399999;
        }
        if (byVar.jQd == 52) {
            byVar.jQd = 1000052;
        }
        if (byVar.jQd == 53) {
            byVar.jQd = 1000053;
        }
        if (!(aVar == null || aVar.dIN == null)) {
            by byVar2 = aVar.dIN;
            bd I = ((i) g.l(i.class)).bcY().I(ab.a(byVar2.rcj), byVar2.rcq);
            if (I.field_msgId != 0 && (I.field_isSend == 0 || byVar2.rcr != 0)) {
                i = I.field_flag;
                i = aVar.dIO ? i | 2 : i & -3;
                i = aVar.dIP ? i | 1 : i & -2;
                i = aVar.dIQ ? i | 4 : i & -5;
                if (i != I.field_flag) {
                    x.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr updateMsgFlagByAddMsgInfo msgType[%d], flag new[%d], old[%d]", new Object[]{Integer.valueOf(byVar2.jQd), Integer.valueOf(i), Integer.valueOf(I.field_flag)});
                    I.fg(i);
                    ((i) g.l(i.class)).bcY().b(I.field_msgSvrId, I);
                }
            }
        }
        Object obj = null;
        d ba = com.tencent.mm.ab.d.c.ba(Integer.valueOf(byVar.jQd));
        if (ba == null) {
            ba = com.tencent.mm.ab.d.c.ba(a);
        }
        if (ba != null) {
            b b = ba.b(aVar);
            cm cmVar = b == null ? null : b.bGS;
            if (cmVar == null) {
                x.w("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg, type=%d, svrId=%d, MsgSeq=%d, createTime=%d, addMsgInfo=%s", new Object[]{Integer.valueOf(byVar.jQd), Long.valueOf(byVar.rcq), Integer.valueOf(byVar.rcr), Integer.valueOf(byVar.lOH), aVar});
                if (aVar.dIO && aVar.dIP) {
                    bd J = ((i) g.l(i.class)).bcY().J(a, (long) byVar.rcr);
                    if (J.field_msgId != 0) {
                        i = J.field_flag;
                        x.i("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg and must revised fault[%d], flag[%d], svrId[%d], msgseq[%d], createtime[%d], type[%d]", new Object[]{Long.valueOf(J.field_msgId), Integer.valueOf(J.field_flag), Long.valueOf(J.field_msgSvrId), Long.valueOf(J.field_msgSeq), Long.valueOf(J.field_createTime), Integer.valueOf(J.getType())});
                        if ((i & 1) == 0) {
                            J.fg((i | 2) | 1);
                            ((i) g.l(i.class)).bcY().a(J.field_msgId, J);
                        }
                    } else {
                        x.i("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg and must revised fault failed[%d]", new Object[]{Long.valueOf(J.field_msgId)});
                    }
                }
                obj = 1;
            } else {
                obj = (!com.tencent.mm.model.s.hj(a) || com.tencent.mm.al.b.PD()) ? null : 1;
                if (obj == null) {
                    x.d("MicroMsg.MessageSyncExtension", " msg , id =" + cmVar.field_msgId + "  " + sVar);
                    if (cmVar.field_msgId > 0 && sVar != null && b.dIR) {
                        sVar.a(cmVar, byVar);
                    }
                }
                obj = 1;
            }
        }
        t.b(5, byVar);
        if (obj == null) {
            x.f("MicroMsg.MessageSyncExtension", "unknown add msg request, type=%d. drop now !!!", new Object[]{Integer.valueOf(byVar.jQd)});
        }
    }
}
