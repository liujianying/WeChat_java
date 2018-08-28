package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bky;
import com.tencent.mm.protocal.c.bkz;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.List;

public final class ai extends l implements k {
    private final b diG;
    private e diJ = null;

    public ai(String str, List<String> list) {
        a aVar = new a();
        aVar.dIG = new bky();
        aVar.dIH = new bkz();
        aVar.uri = "/cgi-bin/micromsg-bin/sendsmstomfriend";
        aVar.dIF = 432;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bky bky = (bky) this.diG.dID.dIL;
        bky.rwj = str;
        bky.rTA = new LinkedList();
        bky.rTz = list.size();
        for (String str2 : list) {
            if (!bi.oW(str2)) {
                bky.rTA.add(new bhz().VO(str2));
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 432;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }
}
