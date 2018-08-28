package com.tencent.mm.plugin.emoji.f;

import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.adi;
import com.tencent.mm.protocal.c.adj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends l implements k {
    public static int iiS = 0;
    public static int iiT = 1;
    public static int iiU = 1;
    public static int iiV = 2;
    public static int iiW = GLIcon.TOP;
    private final b diG;
    private e diJ;
    private int iiX;
    private String iil;

    public o(String str, int i) {
        a aVar = new a();
        aVar.dIG = new adi();
        aVar.dIH = new adj();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetemotionreward";
        aVar.dIF = 822;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.iil = str;
        this.iiX = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneGetEmotionReward", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            if (this.iiX == iiS) {
                com.tencent.mm.storage.emotion.l lVar = i.aEA().igC;
                String str2 = this.iil;
                adj aES = aES();
                if (bi.oW(str2) || aES == null) {
                    x.w("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
                } else {
                    try {
                        com.tencent.mm.storage.emotion.k kVar = new com.tencent.mm.storage.emotion.k();
                        kVar.field_productID = str2;
                        kVar.field_content = aES.toByteArray();
                        if (lVar.diF.replace("EmotionRewardInfo", "productID", kVar.wH()) > 0) {
                            x.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID success. ProductId:%s", new Object[]{str2});
                        } else {
                            x.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. ProductId:%s", new Object[]{str2});
                        }
                    } catch (Throwable e) {
                        x.e("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[]{bi.i(e)});
                    }
                }
            }
            if (aES() == null || aES().rHP == null) {
                x.i("MicroMsg.emoji.NetSceneGetEmotionReward", "getEmotionRewardRespone is null. so i think no such product reward information");
                i.aEA().igE.dg(this.iil, iiW);
                i.aEB().bh(this.iil, iiW);
            } else {
                i.aEA().igE.dg(this.iil, aES().rHP.rbZ);
                i.aEB().bh(this.iil, aES().rHP.rbZ);
            }
        } else if (i3 == 1) {
            i.aEA().igE.dg(this.iil, iiW);
            i.aEB().bh(this.iil, iiW);
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 822;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        adi adi = (adi) this.diG.dID.dIL;
        adi.rem = this.iil;
        adi.qZc = this.iiX;
        return a(eVar, this.diG, this);
    }

    public final adj aES() {
        return (adj) this.diG.dIE.dIL;
    }
}
