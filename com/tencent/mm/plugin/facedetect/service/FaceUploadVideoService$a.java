package com.tencent.mm.plugin.facedetect.service;

import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.facedetect.b.r;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class FaceUploadVideoService$a implements a {
    private long iNq;
    final /* synthetic */ FaceUploadVideoService iPL;
    private String mAppId;
    private String mFileName;

    /* synthetic */ FaceUploadVideoService$a(FaceUploadVideoService faceUploadVideoService, long j, String str, String str2, byte b) {
        this(faceUploadVideoService, j, str, str2);
    }

    private FaceUploadVideoService$a(FaceUploadVideoService faceUploadVideoService, long j, String str, String str2) {
        this.iPL = faceUploadVideoService;
        this.iNq = -1;
        this.mAppId = null;
        this.mFileName = null;
        this.iNq = j;
        this.mAppId = str;
        this.mFileName = str2;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        x.i("MicroMsg.FaceUploadVideoService", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
        if (keep_sceneresult != null && keep_sceneresult.field_retCode == 0) {
            x.i("MicroMsg.FaceUploadVideoService", "hy: upload video done. now upload");
            FaceDetectReporter.e(this.iNq, 0, 0);
            g.DF().a(1197, this.iPL);
            g.DF().a(new r(this.mFileName, this.iNq, this.mAppId, keep_sceneresult.field_fileId, keep_sceneresult.field_aesKey), 0);
        } else if (keep_sceneresult != null) {
            x.w("MicroMsg.FaceUploadVideoService", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
            e.deleteFile(this.mFileName);
            FaceDetectReporter.e(this.iNq, 1, keep_sceneresult.field_retCode);
        } else if (i != 0) {
            x.w("MicroMsg.FaceUploadVideoService", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
            e.deleteFile(this.mFileName);
            FaceDetectReporter.e(this.iNq, 1, i);
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return new byte[0];
    }
}
