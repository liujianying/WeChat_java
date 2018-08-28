package com.tencent.mm.az;

import com.tencent.mm.aa.c;
import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.g.a.fr;
import com.tencent.mm.model.au;
import com.tencent.mm.model.e;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.a;

public final class b extends e {
    protected final bd a(by byVar, String str, String str2, String str3) {
        String a = ab.a(byVar.rcl);
        if (a == null || a.length() <= 0) {
            x.e("MicroMsg.FMessageExtension", "possible friend msg : content is null");
        } else {
            a YV = a.YV(a);
            if (!(YV.tbE == null && YV.tbF == null) && (YV.scene == 10 || YV.scene == 11)) {
                fr frVar = new fr();
                frVar.bOi.bOk = YV.tbE;
                frVar.bOi.bOl = YV.tbF;
                com.tencent.mm.sdk.b.a.sFg.m(frVar);
                if (frVar.bOj.bOm) {
                    x.v("MicroMsg.FMessageExtension", "possible mobile friend is not in local address book");
                }
            }
            if (YV.lWQ > 0) {
                c.d(YV.lWQ, YV.tbD);
            }
            if (bi.oV(YV.otZ).length() > 0) {
                j jVar = new j();
                jVar.username = YV.otZ;
                jVar.csA = 3;
                jVar.by(true);
                jVar.bWA = -1;
                jVar.dHR = YV.tbG;
                jVar.dHQ = YV.tbH;
                jVar.bWA = -1;
                x.d("MicroMsg.FMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[]{YV.otZ, jVar.Kx(), jVar.Ky()});
                q.KH().a(jVar);
            }
            at atVar = new at();
            atVar.field_createTime = c.o(str, (long) byVar.lOH);
            atVar.field_isSend = 0;
            atVar.field_msgContent = ab.a(byVar.rcl);
            atVar.field_svrId = byVar.rcq;
            atVar.field_talker = YV.otZ;
            atVar.field_type = 0;
            ar YL = d.SF().YL(atVar.field_talker);
            if (YL != null) {
                x.d("MicroMsg.FMessageExtension", "getByEncryptTalker success. encryptTalker = " + atVar.field_talker + " , real talker = " + YL.field_talker);
                atVar.field_encryptTalker = atVar.field_talker;
                atVar.field_talker = YL.field_talker;
            }
            au.HU();
            com.tencent.mm.storage.ab Yg = com.tencent.mm.model.c.FR().Yg(atVar.field_talker);
            if (Yg == null || !com.tencent.mm.l.a.gd(Yg.field_type) || Yg.dhP <= 0) {
                d.SE().b(atVar);
            } else {
                x.d("MicroMsg.FMessageExtension", "The biz contact whose talker is " + atVar.field_talker + " has already been in user's contact list");
            }
        }
        return null;
    }
}
