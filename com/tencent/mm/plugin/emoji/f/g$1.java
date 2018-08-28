package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.emoji.e.c;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;

class g$1 implements i$a {
    final /* synthetic */ g iiB;

    g$1(g gVar) {
        this.iiB = gVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        if (bi.oW(this.iiB.dVk) || !str.equals(this.iiB.dVk)) {
            x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra mediaId is no equal");
        } else if (i == -21006) {
            x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[]{this.iiB.dVk});
            g.g(this.iiB.iiv, 6, 0, this.iiB.dVk);
        } else if (i != 0) {
            x.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "download emoji pack failed. mProductId:%s:", new Object[]{this.iiB.iiv});
            g.g(this.iiB.iiv, -1, 0, this.iiB.dVk);
        } else if (keep_progressinfo != null) {
            if (keep_progressinfo.field_finishedLength == keep_progressinfo.field_toltalLength) {
                x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra ignore progress 100%");
            } else {
                x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra progresscallback id:%s finish:%d total:%d", new Object[]{this.iiB.dVk, Integer.valueOf(keep_progressinfo.field_finishedLength), Integer.valueOf(keep_progressinfo.field_toltalLength)});
                if (!this.iiB.dJO) {
                    g.g(this.iiB.iiv, 6, (int) ((((float) keep_progressinfo.field_finishedLength) / ((float) keep_progressinfo.field_toltalLength)) * 100.0f), this.iiB.dVk);
                }
            }
        } else if (keep_sceneresult != null) {
            h.mEJ.h(10625, new Object[]{Integer.valueOf(2), keep_sceneresult.field_fileId, this.iiB.iiv, keep_sceneresult.field_transInfo});
            if (keep_sceneresult.field_retCode != 0) {
                x.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji pack faild. ProductId:%s code:%d ", new Object[]{this.iiB.iiv, Integer.valueOf(keep_sceneresult.field_retCode)});
                g.g(this.iiB.iiv, -1, 0, this.iiB.dVk);
            } else {
                x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji success.");
                try {
                    c aDJ = c.aDJ();
                    String str2 = this.iiB.iiv;
                    if (aDJ.ifj != null && aDJ.ifj.contains(str2)) {
                        aDJ.ifj.remove(str2);
                    }
                    EmojiLogic.a(this.iiB.iiv, this.iiB.iiw, this.iiB.iiA);
                    i.aEA().igx.doNotify();
                    g.g(this.iiB.iiv, 7, 100, this.iiB.dVk);
                    File file = new File(e.dgj + this.iiB.iiv);
                    if (file.isFile() && file.exists()) {
                        file.delete();
                    }
                    g.ah(this.iiB.iiv, true);
                } catch (Exception e) {
                    x.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Error." + bi.cjd());
                    g.g(this.iiB.iiv, -1, 0, this.iiB.dVk);
                    g.ah(this.iiB.iiv, false);
                    return 0;
                } catch (OutOfMemoryError e2) {
                    x.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Out Of Memory Error." + bi.cjd());
                    g.g(this.iiB.iiv, -1, 0, this.iiB.dVk);
                    g.ah(this.iiB.iiv, false);
                    return 0;
                }
            }
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return null;
    }
}
