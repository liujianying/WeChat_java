package com.tencent.mm.ak;

import com.tencent.mm.model.s;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class k$2 implements a {
    final /* synthetic */ k dVy;

    k$2(k kVar) {
        this.dVy = kVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        h hVar;
        Object[] objArr;
        if (i == -21006) {
            x.i(this.dVy.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[]{this.dVy.dVk});
            return 0;
        } else if (i != 0) {
            i.hU((int) this.dVy.dVh);
            i.hT((int) this.dVy.dVh);
            hVar = h.mEJ;
            objArr = new Object[16];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(2);
            objArr[2] = Long.valueOf(this.dVy.startTime);
            objArr[3] = Long.valueOf(bi.VF());
            objArr[4] = Integer.valueOf(d.bL(ad.getContext()));
            objArr[5] = Integer.valueOf(this.dVy.dVl);
            objArr[6] = Integer.valueOf(this.dVy.dHI);
            objArr[7] = keep_sceneresult == null ? "" : keep_sceneresult.field_transInfo;
            objArr[8] = "";
            objArr[9] = "";
            objArr[10] = "";
            objArr[11] = "";
            objArr[12] = "";
            objArr[13] = "";
            objArr[14] = "";
            objArr[15] = keep_sceneresult == null ? "" : keep_sceneresult.report_Part2;
            hVar.h(10421, objArr);
            hVar = h.mEJ;
            objArr = new Object[16];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(2);
            objArr[2] = Long.valueOf(this.dVy.startTime);
            objArr[3] = Long.valueOf(bi.VF());
            objArr[4] = Integer.valueOf(d.bL(ad.getContext()));
            objArr[5] = Integer.valueOf(this.dVy.dVl);
            objArr[6] = Integer.valueOf(this.dVy.dHI);
            objArr[7] = keep_sceneresult == null ? "" : keep_sceneresult.field_transInfo;
            objArr[8] = "";
            objArr[9] = "";
            objArr[10] = "";
            objArr[11] = "";
            objArr[12] = "";
            objArr[13] = "";
            objArr[14] = "";
            objArr[15] = keep_sceneresult == null ? "" : keep_sceneresult.report_Part2;
            hVar.h(13937, objArr);
            this.dVy.diJ.a(3, i, "", this.dVy);
            return 0;
        } else {
            e b = o.Pf().b(Long.valueOf(this.dVy.dlN));
            if (keep_progressinfo == null) {
                if (keep_sceneresult != null) {
                    if (keep_sceneresult.field_retCode != 0) {
                        i.hT((int) this.dVy.dVh);
                        x.e(this.dVy.TAG, "cdntra sceneResult.retCode :%d", new Object[]{Integer.valueOf(keep_sceneresult.field_retCode)});
                        this.dVy.diJ.a(3, keep_sceneresult.field_retCode, "", this.dVy);
                    } else {
                        x.i(this.dVy.TAG, "cdntra getimg ok. need convert:%b", new Object[]{Boolean.valueOf(keep_sceneresult.field_convert2baseline)});
                        if (b.dTO == 1) {
                            h.mEJ.a(198, 26, (long) b.dHI, false);
                            h.mEJ.a(198, 27, 1, false);
                            h.mEJ.a(198, s.fq(this.dVy.bGS != null ? this.dVy.bGS.field_talker : "") ? 29 : 28, 1, false);
                        } else {
                            long j;
                            h.mEJ.a(198, 21, (long) b.dHI, false);
                            h.mEJ.a(198, 22, 1, false);
                            hVar = h.mEJ;
                            if (s.fq(this.dVy.bGS != null ? this.dVy.bGS.field_talker : "")) {
                                j = 24;
                            } else {
                                j = 23;
                            }
                            hVar.a(198, j, 1, false);
                        }
                        if (keep_sceneresult.field_convert2baseline) {
                            x.i(this.dVy.TAG, "cdntra need convert2baseline. file:%s", new Object[]{this.dVy.dVn});
                            boolean Convert2Baseline = MMNativeJpeg.Convert2Baseline(this.dVy.dVn, 60);
                            x.i(this.dVy.TAG, "convert result:%b", new Object[]{Boolean.valueOf(Convert2Baseline)});
                        }
                        if (this.dVy.dVt) {
                            k.a(this.dVy, b, b.offset, b.offset, 0);
                        } else {
                            k.a(this.dVy, b, this.dVy.dHI, b.offset, this.dVy.dHI - b.offset);
                        }
                    }
                    hVar = h.mEJ;
                    objArr = new Object[16];
                    objArr[0] = Integer.valueOf(keep_sceneresult.field_retCode);
                    objArr[1] = Integer.valueOf(2);
                    objArr[2] = Long.valueOf(this.dVy.startTime);
                    objArr[3] = Long.valueOf(bi.VF());
                    objArr[4] = Integer.valueOf(d.bL(ad.getContext()));
                    objArr[5] = Integer.valueOf(this.dVy.dVl);
                    objArr[6] = Integer.valueOf(this.dVy.dHI);
                    objArr[7] = keep_sceneresult == null ? "" : keep_sceneresult.field_transInfo;
                    objArr[8] = "";
                    objArr[9] = "";
                    objArr[10] = "";
                    objArr[11] = "";
                    objArr[12] = "";
                    objArr[13] = "";
                    objArr[14] = "";
                    objArr[15] = keep_sceneresult == null ? "" : keep_sceneresult.report_Part2;
                    hVar.h(10421, objArr);
                    if (keep_sceneresult.field_retCode != 0) {
                        hVar = h.mEJ;
                        objArr = new Object[16];
                        objArr[0] = Integer.valueOf(keep_sceneresult.field_retCode);
                        objArr[1] = Integer.valueOf(2);
                        objArr[2] = Long.valueOf(this.dVy.startTime);
                        objArr[3] = Long.valueOf(bi.VF());
                        objArr[4] = Integer.valueOf(d.bL(ad.getContext()));
                        objArr[5] = Integer.valueOf(this.dVy.dVl);
                        objArr[6] = Integer.valueOf(this.dVy.dHI);
                        objArr[7] = keep_sceneresult == null ? "" : keep_sceneresult.field_transInfo;
                        objArr[8] = "";
                        objArr[9] = "";
                        objArr[10] = "";
                        objArr[11] = "";
                        objArr[12] = "";
                        objArr[13] = "";
                        objArr[14] = "";
                        objArr[15] = keep_sceneresult == null ? "" : keep_sceneresult.report_Part2;
                        hVar.h(13937, objArr);
                    }
                }
                return 0;
            } else if (keep_progressinfo.field_finishedLength == this.dVy.dHI) {
                x.d(this.dVy.TAG, "cdntra ignore progress 100%");
                return 0;
            } else {
                this.dVy.dVt = true;
                if (!this.dVy.dVp) {
                    this.dVy.dVp = keep_progressinfo.field_mtlnotify;
                }
                x.i(this.dVy.TAG, "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", new Object[]{this.dVy.dVk, Integer.valueOf(keep_progressinfo.field_finishedLength), Integer.valueOf(keep_progressinfo.field_toltalLength), Boolean.valueOf(this.dVy.dVp)});
                k.a(this.dVy, b, this.dVy.dHI, b.offset, keep_progressinfo.field_finishedLength - b.offset);
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
