package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.blu;
import com.tencent.mm.protocal.c.blv;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends l implements k {
    private final b diG;
    private e diJ;

    public m(String str, String str2) {
        a aVar = new a();
        blu blu = new blu();
        blu.rvj = str;
        blu.rGv = str2;
        aVar.dIG = blu;
        aVar.dIH = new blv();
        aVar.uri = "/cgi-bin/micromsg-bin/setchatroomannouncement";
        aVar.dIF = 993;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.w("MicroMsg.NetSceneSetChatRoomAnnouncement", "errType = " + i2 + " errCode " + i3 + " errMsg " + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 993;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
