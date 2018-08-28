package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mu;
import com.tencent.mm.protocal.c.mv;

public final class a extends l implements k {
    private b diG;
    private e diJ;

    public a(String str, String str2) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new mu();
        aVar.dIH = new mv();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/channelpkginfo";
        aVar.dIF = 1210;
        this.diG = aVar.KT();
        mu muVar = (mu) this.diG.dID.dIL;
        muVar.rqR = str2;
        muVar.rqO = str;
        muVar.rqS = com.tencent.mm.sdk.platformtools.e.chv();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return this.diG.dIF;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
