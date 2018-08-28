package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.model.au;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class al$1 implements a {
    final /* synthetic */ al qAD;

    al$1(al alVar) {
        this.qAD = alVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        String str2 = "MicroMsg.NetSceneUploadAppAttach";
        String str3 = "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]";
        Object[] objArr = new Object[7];
        objArr[0] = this.qAD.dVk;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = keep_progressinfo;
        objArr[3] = keep_sceneresult;
        objArr[4] = Boolean.valueOf(keep_progressinfo != null);
        objArr[5] = Boolean.valueOf(keep_sceneresult != null);
        objArr[6] = Boolean.valueOf(z);
        x.d(str2, str3, objArr);
        ao.asF().b(this.qAD.qAh, this.qAD.qAe);
        boolean c;
        if (i == -21005) {
            x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[]{this.qAD.dVk});
            return 0;
        } else if (i != 0) {
            l.fK(this.qAD.qAe.sKx);
            ao.asF().b(this.qAD.qAh, this.qAD.qAe);
            this.qAD.qAe.field_signature = "";
            c = ao.asF().c(this.qAD.qAe, new String[0]);
            x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", new Object[]{Integer.valueOf(i), Long.valueOf(this.qAD.qAh), Boolean.valueOf(c)});
            this.qAD.diJ.a(3, i, "", this.qAD);
            h.mEJ.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.qAD.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(0), ""});
            return 0;
        } else if (this.qAD.qAe.field_status == 105) {
            x.i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", new Object[]{Long.valueOf(this.qAD.qAe.field_status), Long.valueOf(this.qAD.qAh)});
            g.ND().lw(this.qAD.dVk);
            this.qAD.diJ.a(3, i, "attach  has paused, status" + this.qAD.qAe.field_status, this.qAD);
            return 0;
        } else if (keep_progressinfo != null) {
            this.qAD.qAe.field_lastModifyTime = bi.VE();
            this.qAD.qAe.field_offset = (long) keep_progressinfo.field_finishedLength;
            c = ao.asF().c(this.qAD.qAe, new String[0]);
            if (c) {
                return 0;
            }
            x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + c);
            this.qAD.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            this.qAD.diJ.a(3, i, "", this.qAD);
            return 0;
        } else {
            if (keep_sceneresult != null) {
                if (keep_sceneresult.field_retCode != 0) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult.field_arg, keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
                    l.fK(this.qAD.qAe.sKx);
                    ao.asF().b(this.qAD.qAh, this.qAD.qAe);
                    this.qAD.qAe.field_signature = "";
                    c = ao.asF().c(this.qAD.qAe, new String[0]);
                    x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", new Object[]{Integer.valueOf(i), Integer.valueOf(keep_sceneresult.field_retCode), Long.valueOf(this.qAD.qAh), Boolean.valueOf(c)});
                    h.mEJ.h(10421, new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(this.qAD.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
                    h.mEJ.h(13937, new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(this.qAD.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
                    this.qAD.diJ.a(3, keep_sceneresult.field_retCode, "", this.qAD);
                } else {
                    x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[]{Integer.valueOf(keep_sceneresult.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(keep_sceneresult.field_exist_whencheck), bi.Xf(this.qAD.qAe.field_signature)});
                    if (!z) {
                        a(i, keep_sceneresult);
                    } else if (keep_sceneresult.field_exist_whencheck) {
                        au.DF().a(new aa(this.qAD.bGT, this.qAD.qAe.field_fileFullPath, this.qAD.toUser, new 1(this, i, keep_sceneresult)), 0);
                    } else {
                        x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
                        au.DF().a(new aa(null, this.qAD.qAe.field_fileFullPath, this.qAD.toUser, new 2(this, i)), 0);
                    }
                }
            }
            return 0;
        }
    }

    final void a(int i, keep_SceneResult keep_sceneresult) {
        this.qAD.qAe.field_status = 199;
        boolean c = ao.asF().c(this.qAD.qAe, new String[0]);
        if (c) {
            l.a(this.qAD.qAe.field_msgInfoId, this.qAD.qAe.field_mediaSvrId, keep_sceneresult);
            au.DF().a(new aj(this.qAD.qAe.field_msgInfoId, true, keep_sceneresult, new 3(this, keep_sceneresult), this.qAD.bJK, this.qAD.qAe), 0);
            return;
        }
        x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + c);
        this.qAD.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
        this.qAD.diJ.a(3, i, "", this.qAD);
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return null;
    }
}
