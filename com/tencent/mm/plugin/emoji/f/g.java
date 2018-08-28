package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.tk;
import com.tencent.mm.protocal.c.ud;
import com.tencent.mm.protocal.c.ue;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.io.File;

public final class g extends l implements k {
    boolean dJO;
    public String dVk;
    private final b diG;
    private e doG;
    private int fdx;
    EmojiGroupInfo iiA;
    public String iiv;
    public String iiw;
    public String iix;
    private int iiy;
    private a iiz;

    static /* synthetic */ void ah(String str, boolean z) {
        if (!bi.oW(str)) {
            x.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "[cpan] publicStoreEmojiDownLoadTaskEvent productId:%s success:%b", new Object[]{str, Boolean.valueOf(z)});
            cs csVar = new cs();
            csVar.bKf.bKg = str;
            csVar.bKf.bIH = 2;
            csVar.bKf.success = z;
            com.tencent.mm.sdk.b.a.sFg.m(csVar);
        }
    }

    private g(String str, String str2, String str3, int i, int i2) {
        this.dVk = "";
        this.iiz = new 1(this);
        this.iiv = str;
        this.iiw = str3;
        this.iix = str2;
        this.iiA = null;
        this.iiy = i;
        this.fdx = i2;
        b.a aVar = new b.a();
        aVar.dIG = new ud();
        aVar.dIH = new ue();
        aVar.uri = "/cgi-bin/micromsg-bin/exchangeemotionpack";
        aVar.dIF = 423;
        aVar.dII = 213;
        aVar.dIJ = 1000000213;
        this.diG = aVar.KT();
    }

    public g(String str, String str2, String str3) {
        this(str, str2, str3, 0, 0);
    }

    public g(String str, String str2) {
        this(str, null, str2, 0, 0);
    }

    public g(String str) {
        this(str, null, "", 1, 0);
    }

    public g(String str, byte b) {
        this(str, null, "", 1, 1);
    }

    public final int getType() {
        return 423;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            if (this.fdx == 0) {
                File file = new File(com.tencent.mm.compatible.util.e.dgj);
                if (!file.exists()) {
                    file.mkdirs();
                }
                long currentTimeMillis = System.currentTimeMillis();
                StringBuilder stringBuilder = new StringBuilder();
                au.HU();
                this.dVk = d.a("downzip", currentTimeMillis, stringBuilder.append(c.Df()).toString(), "emoji");
                tk tkVar = ((ue) this.diG.dIE.dIL).rxP;
                i iVar = new i();
                iVar.field_mediaId = this.dVk;
                iVar.field_fullpath = com.tencent.mm.compatible.util.e.dgj + this.iiv;
                iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FILE;
                iVar.field_totalLen = tkVar.ruE;
                iVar.field_aesKey = tkVar.rwn;
                iVar.field_fileId = tkVar.jPK;
                iVar.field_priority = com.tencent.mm.modelcdntran.b.dOk;
                iVar.dPV = this.iiz;
                iVar.field_needStorage = true;
                this.dJO = false;
                if (!com.tencent.mm.modelcdntran.g.ND().b(iVar, -1)) {
                    x.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add task failed:");
                }
            } else {
                x.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add custom emoji.need no download pack");
            }
            this.doG.a(i2, i3, str, this);
            au.DF().a(new k(this.iiv), 0);
            return;
        }
        this.doG.a(i2, i3, str, this);
        g(this.iiv, -1, 0, this.dVk);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "doScene");
        this.doG = eVar2;
        if (this.fdx == 0) {
            g(this.iiv, 6, 0, this.dVk);
        }
        ud udVar = (ud) this.diG.dID.dIL;
        udVar.rem = this.iiv;
        udVar.rxN = this.iix;
        udVar.rxO = this.iiy;
        udVar.otY = this.fdx;
        return a(eVar, this.diG, this);
    }

    static void g(String str, int i, int i2, String str2) {
        com.tencent.mm.plugin.emoji.model.i.aEC().g(str, i, i2, str2);
    }

    protected final void cancel() {
        super.cancel();
        this.dJO = true;
    }
}
