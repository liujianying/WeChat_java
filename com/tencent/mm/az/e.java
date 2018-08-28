package com.tencent.mm.az;

import com.tencent.mm.aa.j;
import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bd;

public final class e implements d {
    public final b b(a aVar) {
        int i = 0;
        by byVar = aVar.dIN;
        String a = ab.a(byVar.rcj);
        if ("fmessage".equals(a) || byVar.jQd == 37) {
            String a2 = ab.a(byVar.rcl);
            bd.d YY = bd.d.YY(a2);
            String GF = q.GF();
            if (YY.otZ == null || !YY.otZ.equals(GF)) {
                com.tencent.mm.storage.ab Yg;
                String str;
                j jVar = new j();
                jVar.username = YY.otZ;
                jVar.csA = 3;
                jVar.by(true);
                jVar.bWA = -1;
                jVar.dHR = YY.tbG;
                jVar.dHQ = YY.tbH;
                x.d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[]{YY.otZ, jVar.Kx(), jVar.Ky()});
                com.tencent.mm.aa.q.KH().a(jVar);
                if (!bi.oW(YY.otZ)) {
                    if (YY.scene == 18) {
                        d.a(byVar, YY);
                        au.HU();
                        c.DT().set(73729, Integer.valueOf(1));
                        au.HU();
                        Yg = c.FR().Yg(YY.tbT);
                        if (Yg == null || ((int) Yg.dhP) <= 0) {
                            am.a.dBr.a(YY.tbT, null, new 1(this, YY));
                        } else {
                            str = Yg.field_username;
                            if (!(str == null || s.hd(str))) {
                                Yg.setUsername(YY.tbT);
                                Yg.dD(null);
                                au.HU();
                                c.FR().a(str, Yg);
                            }
                            it itVar = new it();
                            itVar.bSl.bSm = YY.tbT;
                            itVar.bSl.type = 1;
                            com.tencent.mm.sdk.b.a.sFg.m(itVar);
                        }
                    } else if (com.tencent.mm.model.bd.hd(YY.scene)) {
                        d.b(byVar, YY);
                        au.HU();
                        c.DT().set(73730, Integer.valueOf(1));
                    } else if (YY.scene == 48) {
                        mg mgVar = new mg();
                        mgVar.bWU.bWW = a2;
                        mgVar.bWU.talker = YY.otZ;
                        com.tencent.mm.sdk.b.a.sFg.m(mgVar);
                    }
                }
                at atVar = new at();
                atVar.field_createTime = c.o(a, (long) byVar.lOH);
                if (byVar.hcd == 4) {
                    i = 2;
                }
                atVar.field_isSend = i + 0;
                atVar.field_msgContent = ab.a(byVar.rcl);
                atVar.field_svrId = byVar.rcq;
                atVar.field_talker = YY.otZ;
                au.HU();
                Yg = c.FR().Yg(YY.chatroomName);
                if (!(Yg == null || ((int) Yg.dhP) == -1)) {
                    atVar.field_chatroomName = YY.chatroomName;
                }
                switch (YY.bOh) {
                    case 2:
                        atVar.field_type = 1;
                        break;
                    case 5:
                        atVar.field_type = 2;
                        break;
                    case 6:
                        atVar.field_type = 3;
                        break;
                    default:
                        atVar.field_type = 1;
                        break;
                }
                if (bi.oW(YY.tbT)) {
                    x.e("MicroMsg.VerifyMessageExtension", "it should not go in here");
                    ar YL = d.SF().YL(atVar.field_talker);
                    if (YL != null) {
                        atVar.field_encryptTalker = YL.field_talker;
                        atVar.field_talker = YL.field_talker;
                    }
                    d.SE().b(atVar);
                } else {
                    atVar.field_encryptTalker = YY.tbT;
                    if (d.SF().Gx(YY.tbT) != null) {
                        com.tencent.mm.storage.au SE = d.SE();
                        str = atVar.field_encryptTalker;
                        SE.diF.fV("fmessage_msginfo", "update fmessage_msginfo set talker = '" + bi.oU(atVar.field_talker) + "'  where talker = '" + bi.oU(str) + "'");
                        d.SF().m(0, atVar.field_encryptTalker);
                    }
                    d.SE().b(atVar);
                }
            } else {
                x.d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", new Object[]{Integer.valueOf(YY.scene), a2});
                x.e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
            }
        }
        return null;
    }

    public final void h(bd bdVar) {
    }
}
