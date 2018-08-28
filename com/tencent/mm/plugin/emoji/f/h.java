package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.acq;
import com.tencent.mm.protocal.c.acr;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.g;

public final class h extends l implements k {
    private final b diG;
    private e doG;
    public int eKI;
    private int iiC;
    public byte[] iiD;
    private int iiE;
    private String iiF;
    private int iiG;

    public h(int i, int i2, int i3, String str, int i4, byte[] bArr) {
        a aVar = new a();
        aVar.dIG = new acq();
        aVar.dIH = new acr();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetdesigneremojilist";
        aVar.dIF = 821;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.eKI = i;
        this.iiC = i2;
        this.iiE = i3;
        this.iiF = str;
        this.iiD = bArr;
        this.iiG = i4;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (((i2 == 0 && i3 == 0) || (i2 == 4 && (i3 == 2 || i3 == 3))) && ((this.iiD == null || this.iiD.length <= 0) && this.eKI != 3)) {
            com.tencent.mm.storage.emotion.h hVar = i.aEA().igD;
            String str2 = this.iiC;
            acr aEL = aEL();
            if (bi.oW(str2) || aEL == null) {
                x.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerEmojiListResponseByUIN failed. designerID or response is null.");
            } else {
                try {
                    g gVar = new g();
                    gVar.field_designerIDAndType = str2 + com.tencent.mm.storage.emotion.h.a.tdb.value;
                    gVar.field_content = aEL.toByteArray();
                    ContentValues wH = gVar.wH();
                    new String[1][0] = str2 + com.tencent.mm.storage.emotion.h.a.tdb.value;
                    if (hVar.diF.replace("EmotionDesignerInfo", "designerIDAndType", wH) > 0) {
                        x.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN success. designerID:%s", new Object[]{str2});
                    } else {
                        x.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN failed. designerID:%s", new Object[]{str2});
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[]{bi.i(e)});
                }
            }
        }
        acr acr = (acr) ((b) qVar).dIE.dIL;
        if (acr.rHj != null) {
            this.iiD = ab.a(acr.rHj);
        }
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 821;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        acq acq = (acq) this.diG.dID.dIL;
        if (this.iiD != null) {
            acq.rHj = ab.O(this.iiD);
        } else {
            acq.rHj = new bhy();
        }
        x.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", acq.rHj == null ? "Buf is NULL" : acq.rHj.toString());
        acq.rHi = this.iiC;
        acq.qZc = this.eKI;
        acq.rwr = this.iiE;
        acq.rHk = this.iiF;
        acq.rHl = this.iiG;
        return a(eVar, this.diG, this);
    }

    public final acr aEL() {
        return this.diG == null ? null : (acr) this.diG.dIE.dIL;
    }
}
