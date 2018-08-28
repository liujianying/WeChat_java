package com.tencent.mm.model;

import com.tencent.mm.platformtools.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.ay.a;

class au$4 implements a {
    final /* synthetic */ au dBL;

    au$4(au auVar) {
        this.dBL = auVar;
    }

    public final void a(ay ayVar, ab abVar) {
        String str = abVar.field_username;
        if (ab.gY(abVar.field_username)) {
            abVar.setUsername(ab.XV(abVar.field_username));
        }
        if (bi.oW(abVar.wP())) {
            abVar.dy(h.oJ(abVar.field_nickname));
        }
        if (bi.oW(abVar.wQ())) {
            abVar.dz(h.oI(abVar.field_nickname));
        }
        if (bi.oW(abVar.field_conRemarkPYShort)) {
            abVar.dC(h.oJ(abVar.field_conRemark));
        }
        if (bi.oW(abVar.field_conRemarkPYFull)) {
            abVar.dB(h.oI(abVar.field_conRemark));
        }
        if (s.d(abVar)) {
            abVar.eD(43);
            abVar.dy(h.oJ(abVar.BK()));
            abVar.dz(h.oI(abVar.BK()));
            abVar.dB(h.oI(abVar.BL()));
            abVar.dC(abVar.BL());
            return;
        }
        if (s.hO(str)) {
            ab abVar2;
            abVar.Bb();
            abVar.eI(4);
            abVar.eD(33);
            if (abVar == null) {
                abVar2 = new ab();
            } else {
                abVar2 = abVar;
            }
            abVar2.setUsername(str);
            abVar2.Bb();
            aa.x(abVar2);
            abVar2.Bk();
        }
        if (abVar.BC()) {
            abVar.eD(abVar.AY());
        }
        if (s.hE(str)) {
            x.i("MicroMsg.MMCore", "update official account helper showhead %d", new Object[]{Integer.valueOf(31)});
            abVar.eD(31);
        }
        if (abVar.BA()) {
            au.HU();
            c.FW().d(new String[]{str}, "@blacklist");
        }
        x.d("MicroMsg.MMCore", "onPreInsertContact2: %s, %s", new Object[]{abVar.field_username, abVar.wP()});
    }
}
