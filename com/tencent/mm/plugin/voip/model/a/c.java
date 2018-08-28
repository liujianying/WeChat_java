package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bzr;
import com.tencent.mm.protocal.c.bzs;
import com.tencent.mm.protocal.c.cas;

public final class c extends n<bzr, bzs> {
    public c(int i, long j, String str, String str2, int i2) {
        a aVar = new a();
        aVar.dIG = new bzr();
        aVar.dIH = new bzs();
        aVar.uri = "/cgi-bin/micromsg-bin/voipcancelinvite";
        aVar.dIF = 171;
        aVar.dII = 64;
        aVar.dIJ = 1000000064;
        this.diG = aVar.KT();
        bzr bzr = (bzr) this.diG.dID.dIL;
        bzr.rxG = i;
        bzr.rxH = j;
        bzr.jTu = str;
        bzr.sef = i2;
        cas cas = new cas();
        bhz bhz = new bhz();
        bhz.VO(str2);
        cas.spT = bhz;
        bzr.svJ = cas;
        bzr.suO = System.currentTimeMillis();
    }

    public final int bLn() {
        bzr bzr = (bzr) bLr();
        if (bzr.rxG == 0 && bzr.sef == 0) {
            return -1;
        }
        return 0;
    }

    public final int getType() {
        return 171;
    }

    public final e bLm() {
        return new 1(this);
    }
}
