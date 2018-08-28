package com.tencent.mm.plugin.bbom;

import com.tencent.mm.R;
import com.tencent.mm.ab.d;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.it;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bd;

public final class b implements a {
    public final void a(d.a aVar, bd bdVar, final String str, String str2, boolean z) {
        final by byVar = aVar.dIN;
        final com.tencent.mm.model.bd.b iF = com.tencent.mm.model.bd.iF(byVar.rco);
        if (iF != null) {
            bdVar.ev(iF.dCq);
            bdVar.et(iF.dCp);
            x.i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", new Object[]{iF.dCp});
            if (iF.dCs != null && iF.scene == 1 && byVar.jQd != 10000) {
                au.HU();
                ab Yg = c.FR().Yg(str);
                if (Yg == null || ((int) Yg.dhP) <= 0) {
                    am.a.dBr.a(str, null, new com.tencent.mm.model.am.b.a() {
                        public final void x(String str, boolean z) {
                            au.HU();
                            b.a(byVar, iF, c.FR().Yg(str));
                        }
                    });
                } else {
                    a(byVar, iF, Yg);
                }
            }
        }
    }

    public final void b(d.a aVar, bd bdVar, String str, String str2, boolean z) {
        Object obj = 1;
        Object obj2 = (s.he(str) && s.hT(str)) ? 1 : null;
        if (!s.fq(str) || s.hS(str)) {
            obj = null;
        }
        if (!z && bdVar.ckA() && obj2 == null && obj == null) {
            com.tencent.mm.modelcontrol.c.NM();
            if (com.tencent.mm.modelcontrol.c.o(bdVar)) {
                com.tencent.mm.ak.b Ph = o.Ph();
                long j = bdVar.field_msgId;
                com.tencent.mm.modelcontrol.c.NM();
                if (com.tencent.mm.modelcontrol.c.NN()) {
                    synchronized (Ph.dTg) {
                        if (Ph.dTg.size() >= 100) {
                            Ph.dTg.remove(0);
                        }
                        Ph.dTg.push(Long.valueOf(j));
                    }
                    Ph.dTk = System.currentTimeMillis();
                    Ph.start();
                }
            }
        }
    }

    static void a(by byVar, com.tencent.mm.model.bd.b bVar, ab abVar) {
        int i;
        String a = com.tencent.mm.platformtools.ab.a(byVar.rcj);
        au.HU();
        c.DT().set(73729, Integer.valueOf(1));
        String str = abVar.field_nickname;
        ba baVar = new ba();
        baVar.field_content = com.tencent.mm.platformtools.ab.a(byVar.rcl);
        baVar.field_createtime = bi.VE();
        baVar.field_imgpath = "";
        baVar.field_sayhicontent = byVar.jQd == 3 ? ad.getContext().getString(R.l.nearby_say_hi_type_image) : com.tencent.mm.platformtools.ab.a(byVar.rcl);
        baVar.field_sayhiuser = a;
        baVar.field_scene = 18;
        if (byVar.hcd > 3) {
            i = byVar.hcd;
        } else {
            i = 3;
        }
        baVar.field_status = i;
        baVar.field_svrid = byVar.rcq;
        baVar.field_talker = str;
        baVar.field_type = byVar.jQd;
        baVar.field_isSend = 0;
        baVar.field_sayhiencryptuser = a;
        baVar.field_ticket = bVar.dCs;
        com.tencent.mm.az.d.SG().a(baVar);
        it itVar = new it();
        itVar.bSl.bSm = a;
        com.tencent.mm.sdk.b.a.sFg.m(itVar);
    }
}
