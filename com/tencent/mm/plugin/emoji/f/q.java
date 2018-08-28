package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.auh;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class q extends l implements k {
    private final b diG;
    private e doG;
    private int iiX;
    public String iiv;

    public q(String str, int i) {
        this.iiv = str;
        if (!bi.oW(str) && str.equals(String.valueOf(EmojiGroupInfo.tcy))) {
            this.iiv = "com.tencent.xin.emoticon.tusiji";
        }
        this.iiX = i;
        a aVar = new a();
        aVar.dIG = new auh();
        aVar.dIH = new aui();
        aVar.uri = "/cgi-bin/micromsg-bin/modemotionpack";
        aVar.dIF = 413;
        aVar.dII = 212;
        aVar.dIJ = 1000000212;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 413;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        auh auh = (auh) this.diG.dID.dIL;
        auh.rem = this.iiv;
        auh.qZc = this.iiX;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneModEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            if (this.iiX == 1) {
                h.mEJ.a(165, 2, 1, false);
            } else {
                h.mEJ.a(165, 4, 1, false);
            }
            this.doG.a(i2, i3, str, this);
            return;
        }
        this.doG.a(i2, i3, str, this);
        if (this.iiX == 1) {
            h.mEJ.a(165, 3, 1, false);
            x.i("MicroMsg.emoji.NetSceneModEmotionPack", "del tukiz failed  ");
            return;
        }
        h.mEJ.a(165, 5, 1, false);
        x.i("MicroMsg.emoji.NetSceneModEmotionPack", "del emoji failed md5:%s", new Object[]{this.iiv});
    }
}
