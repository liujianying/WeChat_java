package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class z$1 implements a {
    final /* synthetic */ z noV;

    z$1(z zVar) {
        this.noV = zVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        if (i == -21005) {
            x.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.noV.dVk, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
            this.noV.diJ.a(3, -1, "doScene failed", this.noV);
            return 0;
        } else if (keep_sceneresult != null && keep_sceneresult.field_retCode == 0) {
            x.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.noV.dVk, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
            this.noV.a(keep_sceneresult.field_fileUrl, 1, keep_sceneresult.field_thumbUrl, 1, "upload_" + this.noV.dVk, keep_sceneresult.field_filemd5);
            x.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns cdndone pass: " + (System.currentTimeMillis() - this.noV.noT) + " " + keep_sceneresult.field_filemd5);
            h.mEJ.h(10421, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.noV.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.noV.dVl), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
            this.noV.diJ.a(0, 0, "doScene", this.noV);
            return 0;
        } else if (keep_sceneresult != null && keep_sceneresult.field_retCode != 0) {
            x.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.noV.dVk, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
            if (this.noV.noU == 21) {
                if (keep_sceneresult.field_retCode <= -10000 && keep_sceneresult.field_retCode > -20000) {
                    b.kB(10);
                } else if (keep_sceneresult.field_retCode <= -20000 && keep_sceneresult.field_retCode >= -22000) {
                    b.kB(11);
                } else if (keep_sceneresult.field_retCode > -5103000 || keep_sceneresult.field_retCode < -5103087) {
                    b.kB(15);
                } else {
                    b.kB(9);
                }
            }
            z.a(this.noV, keep_sceneresult.field_retCode);
            h.mEJ.h(10421, new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(this.noV.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.noV.dVl), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
            h.mEJ.h(13937, new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(this.noV.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.noV.dVl), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
            this.noV.diJ.a(3, -1, "doScene failed", this.noV);
            return 0;
        } else if (i != 0) {
            x.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.noV.dVk, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
            this.noV.wp(0);
            if (keep_sceneresult != null) {
                h.mEJ.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.noV.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.noV.dVl), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
            }
            this.noV.diJ.a(3, -1, "doScene failed", this.noV);
            return 0;
        } else {
            x.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.noV.dVk, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return null;
    }
}
