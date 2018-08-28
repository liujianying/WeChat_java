package com.tencent.mm.plugin.music.model.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.oe;
import com.tencent.mm.protocal.c.of;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    private b dZf;
    private e diJ;
    public oe lza;

    public a(int i, com.tencent.mm.an.a aVar) {
        com.tencent.mm.ab.b.a aVar2 = new com.tencent.mm.ab.b.a();
        aVar2.uri = "/cgi-bin/micromsg-bin/checkmusic";
        aVar2.dIG = new oe();
        aVar2.dIH = new of();
        this.dZf = aVar2.KT();
        this.lza = (oe) this.dZf.dID.dIL;
        this.lza.otY = i;
        this.lza.jQb = aVar.field_appId;
        this.lza.rsq = aVar.field_songAlbumUrl;
        this.lza.rsr = aVar.field_songHAlbumUrl;
        this.lza.rst = aVar.field_songWifiUrl;
        this.lza.rsu = aVar.field_songWapLinkUrl;
        this.lza.rss = aVar.field_songWebUrl;
        this.lza.bHD = aVar.field_songName;
        this.lza.rsp = aVar.field_musicId;
    }

    public final int getType() {
        return 940;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Music.NetSceneCheckMusic", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.diJ.a(i2, i3, str, this);
    }
}
