package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.io.ByteArrayOutputStream;
import java.io.File;

class ac$1 implements a {
    final /* synthetic */ ac qAn;

    ac$1(ac acVar) {
        this.qAn = acVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        String str2 = "MicroMsg.NetSceneDownloadAppAttach";
        String str3 = "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]";
        Object[] objArr = new Object[5];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = keep_progressinfo;
        objArr[3] = keep_sceneresult;
        objArr[4] = Boolean.valueOf(keep_progressinfo == null);
        x.d(str2, str3, objArr);
        if (i == -21006) {
            x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[]{this.qAn.dVk});
            return 0;
        } else if (i != 0) {
            l.fK(this.qAn.qAe.sKx);
            h.mEJ.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(this.qAn.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(0), ""});
            this.qAn.diJ.a(3, i, "", this.qAn);
            return 0;
        } else {
            this.qAn.qAe = l.am(str, this.qAn.bJC);
            if (this.qAn.qAe == null) {
                x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
                this.qAn.diJ.a(3, i, "", this.qAn);
                return 0;
            } else if (this.qAn.qAe.field_status == 102) {
                x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[]{Long.valueOf(this.qAn.qAe.field_status)});
                g.ND().lw(this.qAn.dVk);
                this.qAn.diJ.a(3, i, "attach  has paused, status=" + this.qAn.qAe.field_status, this.qAn);
                return 0;
            } else if (keep_progressinfo == null) {
                if (keep_sceneresult != null) {
                    if (keep_sceneresult.field_retCode != 0) {
                        l.fK(this.qAn.qAe.sKx);
                        x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[]{Integer.valueOf(keep_sceneresult.field_retCode)});
                        this.qAn.diJ.a(3, keep_sceneresult.field_retCode, "", this.qAn);
                    } else {
                        new File(this.qAn.qAj).renameTo(new File(this.qAn.qAe.field_fileFullPath));
                        this.qAn.qAe.field_status = 199;
                        this.qAn.qAe.field_offset = this.qAn.qAe.field_totalLen;
                        ao.asF().c(this.qAn.qAe, new String[0]);
                        h.mEJ.a(198, 45, this.qAn.qAe.field_totalLen, false);
                        h.mEJ.a(198, 46, 1, false);
                        h.mEJ.a(198, s.fq(this.qAn.bXQ == null ? "" : this.qAn.bXQ.field_talker) ? 48 : 47, 1, false);
                        au.HU();
                        bd dW = c.FT().dW(this.qAn.qAe.field_msgInfoId);
                        if (dW.field_status == 5) {
                            dW.setStatus(3);
                            au.HU();
                            c.FT().a(dW.field_msgId, dW);
                        } else {
                            au.HU();
                            c.FT().a(new f.c(dW.field_talker, "update", dW));
                        }
                        this.qAn.diJ.a(0, 0, "", this.qAn);
                    }
                    h.mEJ.h(10421, new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(2), Long.valueOf(this.qAn.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_FILE), Long.valueOf(this.qAn.qAe.field_totalLen), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
                    if (keep_sceneresult.field_retCode != 0) {
                        h.mEJ.h(13937, new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(2), Long.valueOf(this.qAn.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_FILE), Long.valueOf(this.qAn.qAe.field_totalLen), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
                    }
                    if (this.qAn.dVg != null) {
                        ah.A(new 2(this));
                    }
                }
                return 0;
            } else if (((long) keep_progressinfo.field_finishedLength) == this.qAn.qAe.field_totalLen) {
                x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
                return 0;
            } else if (this.qAn.qAe.field_offset > ((long) keep_progressinfo.field_finishedLength)) {
                x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[]{Long.valueOf(this.qAn.qAe.field_offset), Integer.valueOf(keep_progressinfo.field_finishedLength)});
                l.fK(this.qAn.qAe.sKx);
                this.qAn.diJ.a(3, i, "", this.qAn);
                return 0;
            } else {
                this.qAn.qAe.field_offset = (long) keep_progressinfo.field_finishedLength;
                ao.asF().c(this.qAn.qAe, new String[0]);
                if (this.qAn.dVg != null) {
                    ah.A(new 1(this));
                }
                x.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[]{this.qAn.dVk, Integer.valueOf(keep_progressinfo.field_finishedLength), Integer.valueOf(keep_progressinfo.field_toltalLength)});
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
