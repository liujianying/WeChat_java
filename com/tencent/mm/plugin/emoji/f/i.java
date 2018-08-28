package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.acs;
import com.tencent.mm.protocal.c.act;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.g;
import com.tencent.mm.storage.emotion.h;

public final class i extends l implements k {
    private final b diG;
    private e doG;
    private String iiH;

    public i(String str) {
        a aVar = new a();
        aVar.dIG = new acs();
        aVar.dIH = new act();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetdesignersimpleinfo";
        aVar.dIF = 239;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.iiH = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneGetDesignerSimpleInfo", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            h hVar = com.tencent.mm.plugin.emoji.model.i.aEA().igD;
            String str2 = this.iiH;
            act aEM = aEM();
            if (bi.oW(str2) || aEM == null) {
                x.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID or response is null.");
            } else {
                try {
                    g gVar = new g();
                    gVar.field_designerIDAndType = str2 + h.a.tcZ.value;
                    gVar.field_content = aEM.toByteArray();
                    ContentValues wH = gVar.wH();
                    new String[1][0] = str2 + h.a.tcZ.value;
                    if (hVar.diF.replace("EmotionDesignerInfo", "designerIDAndType", wH) > 0) {
                        x.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID success. designerID:%s", new Object[]{str2});
                    } else {
                        x.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID:%s", new Object[]{str2});
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[]{bi.i(e)});
                }
            }
        }
        this.doG.a(i2, i3, str, this);
    }

    public final act aEM() {
        return this.diG == null ? null : (act) this.diG.dIE.dIL;
    }

    public final int getType() {
        return 239;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        ((acs) this.diG.dID.dIL).rwl = this.iiH;
        return a(eVar, this.diG, this);
    }
}
