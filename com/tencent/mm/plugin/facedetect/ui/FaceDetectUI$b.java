package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.sdk.platformtools.x;

class FaceDetectUI$b {
    final /* synthetic */ FaceDetectUI iRF;
    private boolean iRL;
    boolean iRM;
    private boolean iRN;
    private final boolean iRO;

    private FaceDetectUI$b(FaceDetectUI faceDetectUI) {
        this.iRF = faceDetectUI;
        this.iRL = true;
        this.iRM = false;
        this.iRN = true;
        this.iRO = true;
    }

    /* synthetic */ FaceDetectUI$b(FaceDetectUI faceDetectUI, byte b) {
        this(faceDetectUI);
    }

    public final synchronized void aKy() {
        this.iRM = true;
    }

    final synchronized void reset() {
        this.iRM = false;
    }

    final synchronized void aKz() {
        x.i("MicroMsg.FaceDetectUI", "toString: %s", new Object[]{toString()});
        if (this.iRL && this.iRM && this.iRN) {
            FaceDetectUI.m(this.iRF).setVisibility(0);
        }
    }

    public final String toString() {
        return "InitHandler{isCgiInitDone=" + this.iRL + ", isCameraInitDone=" + this.iRM + ", isLightInitDone=true, isLibraryInitDone=" + this.iRN + '}';
    }
}
