package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.btu;
import com.tencent.mm.protocal.c.btv;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends l implements k {
    private final b diG;
    private e diJ;
    public String username;

    public n(String str, String str2) {
        a aVar = new a();
        this.username = str2;
        btu btu = new btu();
        btu.rvj = str;
        btu.srm = str2;
        aVar.dIG = btu;
        aVar.dIH = new btv();
        aVar.uri = "/cgi-bin/micromsg-bin/transferchatroomowner";
        aVar.dIF = 990;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.w("MicroMsg.NetSceneTransferChatRoomOwner", "errType = " + i2 + " errCode " + i3 + " errMsg " + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 990;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
