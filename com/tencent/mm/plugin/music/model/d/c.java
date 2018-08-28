package com.tencent.mm.plugin.music.model.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahq;
import com.tencent.mm.protocal.c.ahr;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends l implements k {
    private b dZf;
    private e diJ;
    private ahq lzd;
    public String lze = "";
    public String playUrl = "";

    public c(String str) {
        a aVar = new a();
        aVar.dIF = 769;
        aVar.uri = "/cgi-bin/micromsg-bin/getshakemusicurl";
        aVar.dIG = new ahq();
        aVar.dIH = new ahr();
        this.dZf = aVar.KT();
        this.lzd = (ahq) this.dZf.dID.dIL;
        this.lzd.rKR = str;
        this.playUrl = str;
        x.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "request music url:%s", new Object[]{str});
    }

    public final int getType() {
        return 769;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            ahr ahr = (ahr) this.dZf.dIE.dIL;
            this.diJ.a(i2, i3, str, this);
            if (ahr != null) {
                this.lze = ahr.rKR;
                x.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "tempPlayUrl:%s", new Object[]{this.lze});
                return;
            }
            x.e("MicroMsg.Music.NetSceneGetShakeMusicUrl", "response is null");
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
