package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.blc;
import com.tencent.mm.protocal.c.bld;

public final class aj extends l implements k {
    private final b diG;
    private e diJ;

    public aj(String str) {
        a aVar = new a();
        aVar.dIG = new blc();
        aVar.dIH = new bld();
        aVar.uri = "/cgi-bin/micromsg-bin/sendverifyemail";
        aVar.dIF = 108;
        aVar.dII = 43;
        aVar.dIJ = 1000000043;
        this.diG = aVar.KT();
        ((blc) this.diG.dID.dIL).rvi = new bhz().VO(str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 108;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }
}
