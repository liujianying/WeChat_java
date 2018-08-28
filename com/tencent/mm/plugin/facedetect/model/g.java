package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g {
    public FaceProNative iNy = null;

    public final FaceResult aJR() {
        if (this.iNy == null) {
            x.e("MicroMsg.FaceDetectNativeManager", "hy: release out not init");
            return null;
        }
        try {
            long VG = bi.VG();
            x.i("MicroMsg.FaceDetectNativeManager", "hy: uninitialize result : %d, using: %d ms", new Object[]{Integer.valueOf(this.iNy.engineReleaseOut().result), Long.valueOf(bi.VG() - VG)});
            this.iNy = null;
            return this.iNy.engineReleaseOut();
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.FaceDetectNativeManager", th, "hy: face lib release crash!!!", new Object[0]);
            this.iNy.engineRelease();
            this.iNy = null;
            return null;
        }
    }

    public final int aJS() {
        String str = "MicroMsg.FaceDetectNativeManager";
        String str2 = "alvinluo cutDown sFaceProNative == null: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.iNy == null);
        x.v(str, str2, objArr);
        if (this.iNy == null) {
            x.e("MicroMsg.FaceDetectNativeManager", "hy: reelase not init");
            return -101;
        }
        x.i("MicroMsg.FaceDetectNativeManager", "hy: cut down result: %d", new Object[]{Integer.valueOf(this.iNy.engineRelease())});
        this.iNy = null;
        return this.iNy.engineRelease();
    }
}
