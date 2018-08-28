package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.wh;
import com.tencent.mm.protocal.c.wi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    private com.tencent.mm.ab.b diG;
    private e diJ;
    public String nHM = "";

    public b(String str) {
        this.nHM = str;
        a aVar = new a();
        aVar.dIG = new wh();
        aVar.dIH = new wi();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_favofficialitem";
        aVar.dIF = 2874;
        this.diG = aVar.KT();
        ((wh) this.diG.dID.dIL).rBB = str;
        x.i("MicroMsg.NetSceneFavOfficialItem", "Req: item_buff[%s]", new Object[]{str});
    }

    public final int getType() {
        return 2874;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneFavOfficialItem", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.diJ.a(i2, i3, str, this);
    }
}
