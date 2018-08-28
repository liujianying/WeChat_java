package com.tencent.mm.plugin.mmsight.ui;

class SightCaptureUI$23 implements MMSightRecordButton$c {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$23(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void ta(int i) {
        if (SightCaptureUI.h(this.lqr) != null) {
            SightCaptureUI.h(this.lqr).b(true, true, i);
        }
    }

    public final void tb(int i) {
        if (SightCaptureUI.h(this.lqr) != null) {
            SightCaptureUI.h(this.lqr).b(false, true, i);
        }
    }
}
