package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aha;
import com.tencent.mm.protocal.c.ahb;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends l implements com.tencent.mm.network.k {
    public final b diG;
    private e doG;
    public Object tag;

    public k(String str, String str2, int i, int i2) {
        x.d("MicroMsg.NetSceneGetReadingModeInfoProxy", "NetSceneSetOAuthScope doScene url[%s], userAgent[%s], width[%d], height[%d]", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2)});
        a aVar = new a();
        aVar.dIG = new aha();
        aVar.dIH = new ahb();
        aVar.uri = "/cgi-bin/micromsg-bin/getreadingmodeinfo";
        aVar.dIF = 673;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aha aha = (aha) this.diG.dID.dIL;
        aha.URL = str;
        aha.rKq = str2;
        aha.Width = i;
        aha.Height = i2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + i2 + ", errCode = " + i3);
        this.doG.a(i2, i3, str, this);
        if (i2 != 0 || i3 != 0) {
            x.e("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + i2 + ", errCode = " + i3);
        }
    }

    public final int getType() {
        return 673;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "doScene");
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }
}
