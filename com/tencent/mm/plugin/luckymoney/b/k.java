package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.model.q;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

public final class k implements i$a {
    public String ixo = null;
    public a kQx;
    public String kQy;
    private boolean kQz = true;

    public static String baW() {
        return bi.oV(d.a("NewYearImg", System.currentTimeMillis(), q.Hl().field_username, ""));
    }

    public final boolean a(String str, String str2, int i, String str3, a aVar) {
        x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. imageId:%s", new Object[]{str});
        this.kQz = false;
        this.ixo = baW();
        x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. client id:%s", new Object[]{this.ixo});
        this.kQy = str3;
        this.kQx = aVar;
        i iVar = new i();
        iVar.ceW = false;
        iVar.dPV = this;
        iVar.field_fullpath = str3;
        iVar.field_mediaId = this.ixo;
        iVar.field_fileId = str;
        iVar.field_aesKey = str2;
        iVar.field_totalLen = i;
        iVar.field_fileType = b.MediaType_FILE;
        iVar.field_priority = b.dOk;
        iVar.field_needStorage = false;
        iVar.field_isStreamMedia = false;
        iVar.field_appType = 0;
        iVar.field_bzScene = 0;
        if (g.ND().b(iVar, -1)) {
            return true;
        }
        x.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: cdntra addSendTask failed. imageId:%s", new Object[]{str});
        return false;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        x.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
        if (keep_sceneresult != null && this.ixo.equals(str) && !bi.oW(keep_sceneresult.field_fileId)) {
            x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer success, sceneResult.field_retCode:" + keep_sceneresult.field_retCode);
            if (i == 0 && keep_sceneresult.field_retCode == 0) {
                if (this.kQz) {
                    x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, upload callback success");
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, download callback success");
                }
                x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:transfer done, mediaid=%s, completeInfo=%s", new Object[]{str, keep_sceneresult.toString()});
                if (this.kQx != null) {
                    this.kQx.a(keep_sceneresult, this.kQy, true);
                }
            } else {
                x.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail");
                if (this.kQx != null) {
                    this.kQx.a(keep_sceneresult, this.kQy, false);
                }
            }
        } else if (keep_sceneresult != null && this.ixo.equals(str) && keep_sceneresult.field_retCode != 0) {
            x.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail, sceneResult.field_retCode:" + keep_sceneresult.field_retCode);
            if (this.kQx != null) {
                this.kQx.a(keep_sceneresult, this.kQy, false);
            }
        } else if (keep_progressinfo != null) {
            x.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: upload progressing....");
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return null;
    }
}
