package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

public final class h {
    public static h iNB;
    public int iNA = -1;
    public int[] iNz = null;
    public int irJ = 0;

    public static a aJT() {
        String str;
        int aJP = f.iNu.aJP();
        g gVar = f.iNu.iNv.iPA;
        if (gVar.iNy == null) {
            x.e("MicroMsg.FaceDetectNativeManager", "hy: get motion data not init");
            str = null;
        } else {
            str = gVar.iNy.engineGetCurrMotionData();
        }
        return new a(aJP, str);
    }

    public final String toString() {
        return "FaceDetectProcessModel{mProcessInSequence=" + Arrays.toString(this.iNz) + '}';
    }
}
