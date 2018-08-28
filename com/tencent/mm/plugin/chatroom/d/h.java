package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aca;
import com.tencent.mm.protocal.c.acb;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends l implements k {
    public String chatroomName;
    private final b diG;
    private e diJ = null;
    public String hKX;
    public int hKY;
    public int hKZ;
    public int status;

    public h(String str) {
        a aVar = new a();
        aVar.dIG = new aca();
        aVar.dIH = new acb();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroomupgradestatus";
        aVar.dIF = 519;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.chatroomName = str;
        ((aca) this.diG.dID.dIL).rvj = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 519;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        acb acb = (acb) this.diG.dIE.dIL;
        x.d("MicroMsg.NetSceneGetChatRoomUpgradeStatus", "NetSceneGetChatRoomUpgradeStatus onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.status = acb.hcd;
        this.hKX = acb.rGJ;
        this.hKZ = acb.rGK;
        this.hKX = acb.rGJ;
        this.hKY = acb.rGI;
        this.diJ.a(i2, i3, str, this);
    }
}
