package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bvk;
import com.tencent.mm.protocal.c.bvl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.u;

public final class o extends l implements k {
    public String chatroomName = null;
    public int daw = 0;
    private final b diG;
    private e diJ = null;
    public String hKX = null;
    public String hLh = null;
    public int hLi = 0;

    public o(String str) {
        a aVar = new a();
        aVar.dIG = new bvk();
        aVar.dIH = new bvl();
        aVar.uri = "/cgi-bin/micromsg-bin/upgradechatroom";
        aVar.dIF = 482;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.chatroomName = str;
        ((bvk) this.diG.dID.dIL).rvj = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 482;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bvl bvl = (bvl) this.diG.dIE.dIL;
        x.d("MicroMsg.NetSceneUpgradeChatroom", "NetSceneUpgradeChatroom onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.hLh = bvl.rXh;
        if (!bi.oW(this.hLh)) {
            au.HU();
            u ih = c.Ga().ih(this.chatroomName);
            if (ih == null) {
                ih = new u();
            }
            ih.fY(com.tencent.mm.model.q.GF(), this.hLh);
            m.a(ih);
        }
        this.hKX = bvl.rGJ;
        this.daw = bvl.rGI;
        this.hLi = bvl.rGK;
        this.diJ.a(i2, i3, str, this);
    }
}
