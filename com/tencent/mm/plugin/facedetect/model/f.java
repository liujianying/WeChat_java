package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public enum f {
    ;
    
    private static ah iNw;
    public FaceDetectProcessService iNv;

    private f(String str) {
        this.iNv = null;
    }

    static {
        iNw = new ah("face_process");
    }

    public static void y(Runnable runnable) {
        iNw.H(runnable);
    }

    public static void aJK() {
        iNw.cil().removeCallbacksAndMessages(null);
    }

    public static ag aJL() {
        return iNw.cil();
    }

    public static boolean eJ(boolean z) {
        x.i("MicroMsg.FaceDetectManager", "alvinluo: face detect isCheckDynCfg: %b", new Object[]{Boolean.valueOf(z)});
        boolean aJM = aJM();
        boolean aJW = o.aJW();
        if (z) {
            x.i("MicroMsg.FaceDetectManager", "hy: face config support: %b, hardware support: %b, isModelFileValid: %b", new Object[]{Boolean.valueOf(bi.getInt(((a) g.l(a.class)).AT().getValue("BioSigFaceEntry"), 0) == 1), Boolean.valueOf(aJM), Boolean.valueOf(aJW)});
            if (!(bi.getInt(((a) g.l(a.class)).AT().getValue("BioSigFaceEntry"), 0) == 1) || (aJM & aJW) == 0) {
                return false;
            }
            return true;
        }
        x.i("MicroMsg.FaceDetectManager", "hy: hardware support: %b, isModelFileValid: %b", new Object[]{Boolean.valueOf(aJM), Boolean.valueOf(aJW)});
        if (aJW && aJM) {
            return true;
        }
        return false;
    }

    public static boolean aJM() {
        return ad.getContext().getPackageManager().hasSystemFeature("android.hardware.camera.front");
    }

    public static boolean aJN() {
        return o.aJW();
    }

    public final int aJO() {
        g gVar = this.iNv.iPA;
        if (gVar.iNy != null) {
            return gVar.iNy.engineReleaseCurrMotion();
        }
        x.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
        return -3;
    }

    public final int aJP() {
        g gVar = this.iNv.iPA;
        if (gVar.iNy != null) {
            return gVar.iNy.engineGetCurrMotion();
        }
        x.e("MicroMsg.FaceDetectNativeManager", "hy: getCurrentMotion not init");
        return -1;
    }

    public static int aJQ() {
        return FaceProNative.engineVersion();
    }
}
