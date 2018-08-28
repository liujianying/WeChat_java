package com.tencent.mm.ac.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.aan;
import com.tencent.mm.protocal.c.aao;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends l implements k {
    Object data;
    public b diG;
    private e diJ;

    public q(String str, Object obj) {
        a aVar = new a();
        aVar.dIG = new aan();
        aVar.dIH = new aao();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatmyuserinfo";
        aVar.dIF = 1354;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((aan) this.diG.dID.dIL).riK = str;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1354;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "do scene");
        return a(eVar, this.diG, this);
    }
}
