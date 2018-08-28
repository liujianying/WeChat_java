package com.tencent.mm.plugin.z;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class e$1 implements a {
    final /* synthetic */ e lsS;

    e$1(e eVar) {
        this.lsS = eVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        x.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdnCallback clientid:%s, startRet:%d proginfo:[%s], res:[%s]", new Object[]{str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
        if (i == -21005) {
            x.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[]{str});
            return 0;
        } else if (i != 0) {
            x.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback startRet failed. clientid:%s, startRet:%d", new Object[]{str, Integer.valueOf(i)});
            h.mEJ.a(466, 2, 1, false);
            h.mEJ.h(14108, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(this.lsS.bTr)});
            return 0;
        } else {
            if (keep_sceneresult != null) {
                if (keep_sceneresult.field_retCode != 0) {
                    x.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback failed. sceneResult.retCode[%d], arg[%s], info[%s], clientid[%s], filemd5[%s]", new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult.field_arg, keep_sceneresult.field_transInfo, str, keep_sceneresult.field_filemd5});
                    h.mEJ.a(466, 2, 1, false);
                    h.mEJ.h(14108, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(this.lsS.bTr)});
                } else {
                    x.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback success. clientid[%s], filemd5[%s], isHitCacheUpload[%d]", new Object[]{str, keep_sceneresult.field_filemd5, Integer.valueOf(keep_sceneresult.field_UploadHitCacheType)});
                    PByteArray pByteArray = new PByteArray();
                    if (MMProtocalJni.rsaPublicEncryptPemkey(keep_sceneresult.field_aesKey.getBytes(), pByteArray, this.lsS.lsI)) {
                        String bE = bi.bE(pByteArray.value);
                        this.lsS.lsJ = keep_sceneresult.field_fileId;
                        this.lsS.lsK = bE;
                        this.lsS.lsL = keep_sceneresult.field_fileLength;
                        if (com.tencent.mm.kernel.a.gI(g.Eg().dpx)) {
                            x.i("MicroMsg.MsgSynchronizeServer", "sendAppMsg immediately.");
                            this.lsS.bfE();
                        } else {
                            x.i("MicroMsg.MsgSynchronizeServer", "wait getOnlineInfoExtDeviceOnlineListener to sendAppMsg.");
                            au.HU();
                            c.a(this.lsS);
                            this.lsS.lsQ = true;
                        }
                    } else {
                        x.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize MMProtocalJni rsaPublicEncryptPemkey failed!");
                        return -1;
                    }
                }
            }
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return new byte[0];
    }
}
