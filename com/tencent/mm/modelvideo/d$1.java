package com.tencent.mm.modelvideo;

import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class d$1 implements i$a {
    final /* synthetic */ d emc;

    d$1(d dVar) {
        this.emc = dVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        if (i == -21006) {
            x.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[]{this.emc.SR(), this.emc.dVk});
            return 0;
        } else if (i != 0) {
            t.nP(this.emc.fileName);
            h.mEJ.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(this.emc.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.emc.elY), Integer.valueOf(this.emc.dHI), ""});
            h.mEJ.h(13937, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(this.emc.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.emc.elY), Integer.valueOf(this.emc.dHI), ""});
            this.emc.diJ.a(3, i, "", this.emc);
            return 0;
        } else {
            this.emc.elW = t.nW(this.emc.fileName);
            int i2;
            if (this.emc.elW == null || this.emc.elW.status == 113) {
                x.i("MicroMsg.NetSceneDownloadVideo", "%s upload video info is null or has paused, status:%d", new Object[]{this.emc.SR(), Integer.valueOf(this.emc.elW == null ? -1 : this.emc.elW.status)});
                this.emc.wk();
                this.emc.diJ.a(3, i, "upload video info is null or has paused, status" + i2, this.emc);
                return 0;
            } else if (keep_progressinfo == null) {
                if (keep_sceneresult != null) {
                    x.i("MicroMsg.NetSceneDownloadVideo", "%s cdntra sceneResult.retCode:%d useTime:%d ", new Object[]{this.emc.SR(), Integer.valueOf(keep_sceneresult.field_retCode), Long.valueOf(bi.VF() - this.emc.emb)});
                    d dVar = this.emc;
                    j jVar = this.emc.elX;
                    if (jVar == null || keep_sceneresult == null) {
                        x.w("MicroMsg.NetSceneDownloadVideo", "it had not task info or scene Result, don't report.");
                    } else if (jVar.field_smallVideoFlag == 1) {
                        x.i("MicroMsg.NetSceneDownloadVideo", "it download short video, don't report.");
                    } else if (!(jVar == null || keep_sceneresult == null)) {
                        x.i("MicroMsg.NetSceneDownloadVideo", "%s sceneResult.field_recvedBytes %d, time [%d, %d]", new Object[]{dVar.SR(), Integer.valueOf(keep_sceneresult.field_recvedBytes), Long.valueOf(keep_sceneresult.field_startTime), Long.valueOf(keep_sceneresult.field_endTime)});
                        o.Tb();
                        f.a(null, keep_sceneresult, jVar, true);
                    }
                    if (keep_sceneresult.field_retCode != 0) {
                        t.nP(this.emc.fileName);
                        if (this.emc.elU) {
                            h.mEJ.a(354, 13, 1, false);
                        }
                        if (this.emc.elV) {
                            h.mEJ.a(354, 136, 1, false);
                        }
                        this.emc.diJ.a(3, keep_sceneresult.field_retCode, "", this.emc);
                    } else {
                        if (this.emc.elU) {
                            h.mEJ.a(354, 12, 1, false);
                        }
                        if (this.emc.elV) {
                            h.mEJ.a(354, 137, 1, false);
                        }
                        this.emc.iE(keep_sceneresult.field_fileLength);
                    }
                    h.mEJ.h(10421, new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(2), Long.valueOf(this.emc.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.emc.elY), Integer.valueOf(this.emc.dHI), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
                    if (keep_sceneresult.field_retCode != 0) {
                        h.mEJ.h(13937, new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(2), Long.valueOf(this.emc.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.emc.elY), Integer.valueOf(this.emc.dHI), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
                    }
                    a.a(this.emc.elW, 1);
                    this.emc.elX = null;
                }
                return 0;
            } else if (keep_progressinfo.field_finishedLength == this.emc.dHI) {
                x.d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
                return 0;
            } else if (this.emc.elW.enH <= keep_progressinfo.field_finishedLength || this.emc.elU) {
                i2 = 1024;
                this.emc.elW.enK = bi.VE();
                if (this.emc.elW.enH < keep_progressinfo.field_finishedLength) {
                    this.emc.elW.enH = keep_progressinfo.field_finishedLength;
                    i2 = 1040;
                }
                this.emc.elW.bWA = i2;
                t.e(this.emc.elW);
                x.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra progresscallback id:%s finish:%d total:%d", new Object[]{this.emc.SR(), this.emc.dVk, Integer.valueOf(keep_progressinfo.field_finishedLength), Integer.valueOf(keep_progressinfo.field_toltalLength)});
                return 0;
            } else {
                x.e("MicroMsg.NetSceneDownloadVideo", "%s cdnEndProc error oldpos:%d newpos:%d", new Object[]{this.emc.SR(), Integer.valueOf(this.emc.elW.enH), Integer.valueOf(keep_progressinfo.field_finishedLength)});
                t.nP(this.emc.fileName);
                this.emc.diJ.a(3, i, "", this.emc);
                return 0;
            }
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return null;
    }
}
