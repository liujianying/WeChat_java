package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.adc;
import com.tencent.mm.protocal.c.add;
import com.tencent.mm.protocal.c.to;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.j;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public final class l extends com.tencent.mm.ab.l implements k {
    private int aIs;
    private final b diG;
    private e diJ;
    private int fdx;
    public String iiv;

    public l(String str, int i, int i2) {
        this.iiv = str;
        this.fdx = i;
        this.aIs = i2;
        a aVar = new a();
        aVar.dIG = new adc();
        aVar.dIH = new add();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotiondetail";
        aVar.dIF = TbsListener$ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX;
        aVar.dII = 211;
        aVar.dIJ = 1000000211;
        this.diG = aVar.KT();
    }

    public l(String str, int i) {
        this(str, i, -1);
    }

    public final int getType() {
        return TbsListener$ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ProductID:%s, Scene:%d, Version:%d", new Object[]{this.iiv, Integer.valueOf(this.fdx), Integer.valueOf(this.aIs)});
        this.diJ = eVar2;
        adc adc = (adc) this.diG.dID.dIL;
        adc.rem = this.iiv;
        adc.otY = this.fdx;
        adc.hcD = this.aIs;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ErrType:" + i2 + "   errCode:" + i3);
        if (i2 == 0 || i3 == 0 || i3 == 5) {
            if (i2 == 0 && i3 == 0) {
                j jVar = i.aEA().igB;
                String str2 = this.iiv;
                add add = (add) this.diG.dIE.dIL;
                String fD = w.fD(ad.getContext());
                if (bi.oW(str2) || add == null) {
                    x.w("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
                }
                try {
                    com.tencent.mm.storage.emotion.i iVar = new com.tencent.mm.storage.emotion.i();
                    iVar.field_productID = str2;
                    iVar.field_content = add.toByteArray();
                    iVar.field_lan = fD;
                    if (jVar.diF.replace("EmotionDetailInfo", "productID", iVar.wH()) > 0) {
                        x.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID success. ProductId:%s", new Object[]{str2});
                    } else {
                        x.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID failed. ProductId:%s", new Object[]{str2});
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[]{bi.i(e)});
                }
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final to aEO() {
        to toVar = new to();
        return ((add) this.diG.dIE.dIL).rHx;
    }
}
