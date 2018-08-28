package com.tencent.mm.modelvideo;

import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class f$1 implements a {
    final /* synthetic */ f emq;

    f$1(f fVar) {
        this.emq = fVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        if (i != 0) {
            x.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[]{Integer.valueOf(this.emq.hashCode()), Integer.valueOf(i)});
            if (this.emq.emp != null) {
                this.emq.emp.a(this.emq, false, 0, 0);
            }
        }
        if (keep_progressinfo != null) {
            x.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[]{Integer.valueOf(this.emq.hashCode()), Integer.valueOf(keep_progressinfo.field_finishedLength), Integer.valueOf(keep_progressinfo.field_toltalLength), str});
        }
        if (keep_sceneresult != null) {
            x.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[]{Integer.valueOf(this.emq.hashCode()), Integer.valueOf(keep_sceneresult.field_retCode)});
            if (keep_sceneresult.field_retCode == 0) {
                x.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[]{Integer.valueOf(this.emq.hashCode())});
                this.emq.f(this.emq.emj, keep_sceneresult.field_fileLength, this.emq.dQk);
            } else if (this.emq.emp != null) {
                this.emq.emp.a(this.emq, false, 0, 0);
            }
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return new byte[0];
    }
}
