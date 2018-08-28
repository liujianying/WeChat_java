package com.tencent.mm.plugin.facedetect.views;

class FaceNumberItemView$1 implements Runnable {
    final /* synthetic */ FaceNumberItemView iUl;

    FaceNumberItemView$1(FaceNumberItemView faceNumberItemView) {
        this.iUl = faceNumberItemView;
    }

    public final void run() {
        if (FaceNumberItemView.a(this.iUl) <= 30) {
            FaceNumberItemView.b(this.iUl);
            this.iUl.invalidate();
            return;
        }
        this.iUl.aKM();
    }
}
