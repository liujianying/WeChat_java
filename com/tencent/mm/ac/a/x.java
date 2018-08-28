package com.tencent.mm.ac.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bur;
import com.tencent.mm.protocal.c.bus;
import com.tencent.mm.protocal.c.hv;

public final class x extends l implements k {
    Object data;
    public b diG;
    private e diJ;

    public x(String str, String str2, hv hvVar, hv hvVar2, Object obj) {
        a aVar = new a();
        aVar.dIG = new bur();
        aVar.dIH = new bus();
        aVar.uri = "/cgi-bin/mmocbiz-bin/updatebizchatmemberlist";
        aVar.dIF = 1357;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bur bur = (bur) this.diG.dID.dIL;
        bur.riK = str;
        bur.riE = str2;
        bur.srQ = hvVar;
        bur.srR = hvVar2;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1357;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "do scene");
        return a(eVar, this.diG, this);
    }
}
