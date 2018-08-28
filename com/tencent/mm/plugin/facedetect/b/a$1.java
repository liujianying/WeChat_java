package com.tencent.mm.plugin.facedetect.b;

import android.os.Bundle;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class a$1 implements a {
    final /* synthetic */ a iMi;

    a$1(a aVar) {
        this.iMi = aVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        if (i == -21005) {
            x.i("MicroMsg.FaceUploadProcessor", "hy: ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
        } else if (keep_sceneresult != null && keep_sceneresult.field_retCode == 0) {
            x.i("MicroMsg.FaceUploadProcessor", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
            String str2 = keep_sceneresult.field_fileId;
            Bundle bundle = new Bundle();
            bundle.putString("key_pic_cdn_id", str2);
            bundle.putString("key_cdn_aes_key", keep_sceneresult.field_aesKey);
            a aVar = this.iMi;
            String str3 = "ok";
            if (aVar.iLX != null) {
                aVar.iLX.e(str3, bundle);
            }
        } else if (keep_sceneresult != null) {
            x.w("MicroMsg.FaceUploadProcessor", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
            this.iMi.h(3, 90020, "cdn ret error");
        } else if (i != 0) {
            x.w("MicroMsg.FaceUploadProcessor", "hy: start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
            this.iMi.h(3, 90021, "cdn start error");
        } else {
            x.i("MicroMsg.FaceUploadProcessor", "hy: on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
            if (keep_progressinfo != null) {
                x.d("MicroMsg.FaceUploadProcessor", "hy: cdn process: %f", new Object[]{Double.valueOf(((double) keep_progressinfo.field_finishedLength) / ((double) keep_progressinfo.field_toltalLength))});
                a aVar2 = this.iMi;
                if (aVar2.iLX != null) {
                    aVar2.iLX.s(r0);
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
