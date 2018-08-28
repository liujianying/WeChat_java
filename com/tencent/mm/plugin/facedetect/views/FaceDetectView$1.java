package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.plugin.facedetect.a$h;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectView$1 implements b {
    final /* synthetic */ FaceDetectView iTY;

    FaceDetectView$1(FaceDetectView faceDetectView) {
        this.iTY = faceDetectView;
    }

    public final void a(int i, CharSequence charSequence) {
        x.e("MicroMsg.FaceDetectView", "hy: onDetectError: %d, %s", new Object[]{Integer.valueOf(i), charSequence});
        if (FaceDetectView.a(this.iTY) || FaceDetectView.b(this.iTY)) {
            x.w("MicroMsg.FaceDetectView", "hy: already end or paused");
        } else if (FaceDetectView.c(this.iTY) == null || !FaceDetectView.c(this.iTY).aKd()) {
            this.iTY.eL(false);
            FaceDetectView.a(this.iTY, true);
            FaceDetectView.a(this.iTY, charSequence != null ? charSequence.toString() : this.iTY.getContext().getString(a$h.face_compare_fail));
            if (FaceDetectView.d(this.iTY) != null) {
                FaceDetectView.d(this.iTY).M(i, charSequence != null ? charSequence.toString() : this.iTY.getContext().getString(a$h.face_compare_fail));
            }
        } else {
            x.e("MicroMsg.FaceDetectView", "hy: motion eat result");
            FaceDetectView.a(this.iTY, FaceDetectView.c(this.iTY).aKg());
        }
    }

    public final void c(FaceCharacteristicsResult faceCharacteristicsResult) {
        int i = faceCharacteristicsResult.errCode;
        String str = faceCharacteristicsResult.Yy;
        x.v("MicroMsg.FaceDetectView", "hy: onDetectHelp: %d, %s", new Object[]{Integer.valueOf(i), str});
        if (FaceDetectView.a(this.iTY) || FaceDetectView.b(this.iTY)) {
            x.w("MicroMsg.FaceDetectView", "hy: already end");
        } else if (FaceDetectView.c(this.iTY) == null || !FaceDetectView.c(this.iTY).a(faceCharacteristicsResult)) {
            FaceDetectView.e(this.iTY);
            if (!FaceDetectView.f(this.iTY)) {
                return;
            }
            if (FaceDetectView.g(this.iTY) || !(faceCharacteristicsResult.errCode == 10 || faceCharacteristicsResult.errCode == 11)) {
                FaceDetectView.a(this.iTY, FaceCharacteristicsResult.ps(i));
                FaceDetectView faceDetectView = this.iTY;
                if (str == null) {
                    str = "";
                }
                FaceDetectView.a(faceDetectView, str);
            }
        } else {
            x.e("MicroMsg.FaceDetectView", "hy: motion eat result");
            FaceDetectView.a(this.iTY, FaceDetectView.c(this.iTY).aKg());
        }
    }

    public final void d(FaceCharacteristicsResult faceCharacteristicsResult) {
        x.d("MicroMsg.FaceDetectView", "hy: onDetectSucceed: %s", new Object[]{faceCharacteristicsResult.toString()});
        if (FaceDetectView.a(this.iTY) || FaceDetectView.b(this.iTY)) {
            x.w("MicroMsg.FaceDetectView", "hy: already end pr paused");
        } else if (FaceDetectView.c(this.iTY) == null || !FaceDetectView.c(this.iTY).b(faceCharacteristicsResult)) {
            FaceDetectView.a(this.iTY, false);
            if ((FaceDetectView.c(this.iTY) != null && FaceDetectView.c(this.iTY).aKc()) || FaceDetectView.f(this.iTY)) {
                FaceDetectView.h(this.iTY);
                FaceDetectView.e(this.iTY);
            }
        } else {
            x.e("MicroMsg.FaceDetectView", "hy: motion eat result");
            FaceDetectView.a(this.iTY, FaceDetectView.c(this.iTY).aKg());
        }
    }
}
