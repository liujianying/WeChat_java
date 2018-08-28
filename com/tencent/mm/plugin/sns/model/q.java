package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.boz;
import com.tencent.mm.protocal.c.bpa;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import java.util.Vector;

public final class q extends l implements k {
    public static List<Long> nnQ = new Vector();
    public b diG;
    public e diJ;
    private long nkI;

    public static boolean eK(long j) {
        if (nnQ.contains(Long.valueOf(j))) {
            return false;
        }
        nnQ.add(Long.valueOf(j));
        return true;
    }

    private static boolean eL(long j) {
        nnQ.remove(Long.valueOf(j));
        return true;
    }

    public q(long j) {
        this.nkI = j;
        a aVar = new a();
        aVar.dIG = new boz();
        aVar.dIH = new bpa();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectdetail";
        aVar.dIF = 210;
        aVar.dII = 101;
        aVar.dIJ = 1000000101;
        this.diG = aVar.KT();
        ((boz) this.diG.dID.dIL).rlK = j;
        x.d("MicroMsg.NetSceneSnsObjectDetial", "req snsId " + j);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 210;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            boy boy = ((bpa) this.diG.dIE.dIL).snd;
            if (boy != null) {
                x.i("MicroMsg.NetSceneSnsObjectDetial", "snsdetail xml " + ab.b(boy.smH));
            }
            aj.d(boy);
            this.diJ.a(i2, i3, str, this);
            eL(this.nkI);
            return;
        }
        this.diJ.a(i2, i3, str, this);
        eL(this.nkI);
    }
}
