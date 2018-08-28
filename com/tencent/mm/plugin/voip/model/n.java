package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.R;
import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.Map;

public final class n implements d {
    public final b b(a aVar) {
        by byVar = aVar.dIN;
        String a = ab.a(byVar.rcj);
        String a2 = ab.a(byVar.rck);
        String a3 = ab.a(byVar.rcl);
        x.d("MicroMsg.VoipExtension", "voip msg, from: %s, content: %s", new Object[]{a, a3});
        au.HU();
        f FT = c.FT();
        au.HU();
        String str = (String) c.DT().get(2, "");
        if (str.length() <= 0) {
            return null;
        }
        bd bdVar;
        bd I = FT.I(str.equals(a) ? a2 : a, byVar.rcq);
        if (I.field_msgId == 0) {
            I = new bd();
            I.ax(byVar.rcq);
            I.ay(com.tencent.mm.model.bd.o(a, (long) byVar.lOH));
            bdVar = I;
        } else {
            bdVar = I;
        }
        i.bJI();
        a OG = r.OG(a3);
        if (OG == null) {
            x.e("MicroMsg.VoipExtension", "parse voip message failed, voipMessage is null!");
            try {
                Map z = bl.z(a3, "voipwarnmsg");
                if (!(z == null || z.get(".voipwarnmsg.type") == null || bi.getInt((String) z.get(".voipwarnmsg.type"), 0) != 1)) {
                    str = (String) z.get(".voipwarnmsg.warntips");
                    if (!(str == null || str.equals(""))) {
                        x.i("MicroMsg.VoipExtension", "got risk tips back:" + str);
                        if (z.get(".voipwarnmsg.roomid") != null) {
                            if (!com.tencent.mm.k.f.Ak()) {
                                x.i("MicroMsg.VoipExtension", "set voipmsg not notification...");
                            } else if (bi.getInt((String) z.get(".voipwarnmsg.roomid"), 0) != i.bJI().oNa.oHa.oJX.kpo) {
                                x.i("MicroMsg.VoipExtension", "wrong roomid,now return..");
                                return null;
                            }
                        }
                        i.bJI().oMr = str;
                        i.bJI().OH(str);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VoipExtension", e, "", new Object[0]);
                x.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[]{e.getMessage()});
            }
            return null;
        }
        if ((OG.status == a.oLF ? 1 : null) != null) {
            x.i("MicroMsg.VoipExtension", "recv voip cancel message");
            r bJI = i.bJI();
            if (!(a3 == null || a3.length() == 0)) {
                a aVar2 = new a();
                if (aVar2.parse(a3) && aVar2.status == 2) {
                    bJI.yH(aVar2.oLB);
                    s sVar = bJI.oNa;
                    x.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteMessage, roomId: " + aVar2.oLB);
                    if (sVar.oHa.oKc != null && aVar2.oLB == sVar.oHa.oKc.rxG) {
                        sVar.bLi();
                        sVar.oHa.shutdown();
                    }
                }
            }
        } else {
            if ((OG.status == a.oLH ? 1 : null) != null) {
                return null;
            }
            if ((OG.status == a.oLE ? 1 : null) != null) {
                x.i("MicroMsg.VoipExtension", "recv voip invite delay");
                i.bJI().O(OG.oLB, OG.oLC);
                return null;
            } else if (!OG.bKj()) {
                return null;
            } else {
                x.i("MicroMsg.VoipExtension", "receive invite busy message");
                bdVar.ax(0);
            }
        }
        if (OG.oLB == i.bJI().oNg) {
            x.i("MicroMsg.VoipExtension", "already ignore the invite, don't add the message to db");
            return null;
        }
        bdVar.setType(byVar.jQd);
        bdVar.setContent(OG.bKi() ? bd.tby : bd.tbx);
        bdVar.eX(0);
        bdVar.ep(a);
        bdVar.setStatus(byVar.hcd > 3 ? byVar.hcd : 3);
        if (OG.bKj()) {
            bdVar.dt(ad.getContext().getString(R.l.voip_busy_msg_content));
        } else {
            bdVar.dt(null);
        }
        com.tencent.mm.model.bd.a(bdVar, aVar);
        x.d("MicroMsg.VoipExtension", "voipMessage==null: %b", new Object[]{OG});
        if (bdVar.field_msgId == 0) {
            a aVar3;
            if (OG == null) {
                aVar3 = new a();
                aVar3.parse(a3);
            } else {
                aVar3 = OG;
            }
            x.d("MicroMsg.VoipExtension", "add or update msg, roomid: %s", new Object[]{Integer.valueOf(aVar3.oLB)});
            if (i.bJI().oNf.get(Integer.valueOf(aVar3.oLB)) == null) {
                bdVar.setMsgId(com.tencent.mm.model.bd.i(bdVar));
                i.bJI().oNf.put(Integer.valueOf(aVar3.oLB), Long.valueOf(bdVar.field_msgId));
            } else {
                au.HU();
                c.FT().a(((Long) i.bJI().oNf.get(Integer.valueOf(aVar3.oLB))).longValue(), bdVar);
            }
            return new b(bdVar, true);
        }
        au.HU();
        c.FT().b(byVar.rcq, bdVar);
        return new b(bdVar, false);
    }

    public final void h(bd bdVar) {
    }
}
