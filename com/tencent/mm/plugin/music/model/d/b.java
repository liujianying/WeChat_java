package com.tencent.mm.plugin.music.model.d;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.an.a;
import com.tencent.mm.an.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.agw;
import com.tencent.mm.protocal.c.agx;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    public a bTF;
    private com.tencent.mm.ab.b dZf;
    private e diJ;
    public agx lzb;
    public boolean lzc;

    public b(a aVar, boolean z) {
        int i;
        this.bTF = aVar;
        this.lzc = z;
        com.tencent.mm.ab.b.a aVar2 = new com.tencent.mm.ab.b.a();
        aVar2.dIG = new agw();
        aVar2.dIH = new agx();
        aVar2.uri = "/cgi-bin/micromsg-bin/getqqmusiclyric";
        aVar2.dIF = 520;
        this.dZf = aVar2.KT();
        agw agw = (agw) this.dZf.dID.dIL;
        agw.rKe = aVar.field_songId;
        if (aVar.field_songWebUrl != null) {
            agw.rKf = ab.O(aVar.field_songWebUrl.getBytes());
        }
        if (c.Qh()) {
            i = 0;
        } else {
            i = 1;
        }
        agw.rKg = i;
        if (c.Qg()) {
            i = 1;
        } else {
            i = 0;
        }
        agw.rKh = i;
        x.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "songId=%d, url=%s IsOutsideGFW=%d ShakeMusicGlobalSwitch=%d", new Object[]{Integer.valueOf(aVar.field_songId), aVar.field_songWebUrl, Integer.valueOf(agw.rKg), Integer.valueOf(agw.rKh)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.lzb = (agx) this.dZf.dIE.dIL;
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 520;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }
}
