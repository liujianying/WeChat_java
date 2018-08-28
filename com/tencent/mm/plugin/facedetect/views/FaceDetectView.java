package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.d.b;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.c.a.c;
import com.tencent.mm.w.a.a;

public class FaceDetectView extends RelativeLayout {
    public static long iTW = 100;
    public static int iTX = 1;
    public volatile boolean hxu;
    public long iNF;
    private TextView iRy;
    public FaceDetectCameraView iTG;
    public FaceDetectDecorView iTH;
    public ViewGroup iTI;
    public ViewGroup iTJ;
    private a iTK;
    public b iTL;
    public boolean iTM;
    public boolean iTN;
    public String iTO;
    public boolean iTP;
    public boolean iTQ;
    public long iTR;
    private long iTS;
    private final int iTT;
    private Animation iTU;
    private View iTV;
    public boolean isPaused;

    static /* synthetic */ void e(FaceDetectView faceDetectView) {
        if (faceDetectView.iTL != null && faceDetectView.iTL.aKc()) {
            x.i("MicroMsg.FaceDetectView", "hy: meet require");
            faceDetectView.iTG.aKF();
            faceDetectView.isPaused = true;
            long bI = bi.bI(faceDetectView.iTR);
            x.i("MicroMsg.FaceDetectView", "hy: current motion used time: %d", new Object[]{Long.valueOf(bI)});
            if (bI < faceDetectView.iNF - 5) {
                ah.i(new 3(faceDetectView), faceDetectView.iNF - bI);
            } else if (faceDetectView.iTK != null && !faceDetectView.hxu) {
                faceDetectView.iTK.M(0, "");
            }
        }
    }

    static /* synthetic */ boolean f(FaceDetectView faceDetectView) {
        long VG = bi.VG();
        x.d("MicroMsg.FaceDetectView", "hy: tick between: %d, threshold: %d", new Object[]{Long.valueOf(VG - faceDetectView.iTS), Integer.valueOf(1500)});
        if (VG - faceDetectView.iTS <= 1500) {
            return false;
        }
        faceDetectView.iTS = VG;
        return true;
    }

    public FaceDetectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (byte) 0);
    }

    private FaceDetectView(Context context, AttributeSet attributeSet, int i, byte b) {
        Animation animation;
        super(context, attributeSet, i);
        this.iTG = null;
        this.iTH = null;
        this.iRy = null;
        this.iTI = null;
        this.iTJ = null;
        this.iTK = null;
        this.iTM = false;
        this.hxu = false;
        this.isPaused = false;
        this.iTN = false;
        this.iTO = ad.getContext().getString(h.soter_face_err_msg_ok);
        this.iTP = true;
        this.iTQ = false;
        this.iNF = -1;
        this.iTR = -1;
        this.iTS = -1;
        this.iTT = 1500;
        this.iTV = null;
        View inflate = LayoutInflater.from(context).inflate(g.soter_face_detect_view, null, false);
        addView(inflate);
        this.iTG = (FaceDetectCameraView) inflate.findViewById(e.camera_view);
        this.iTH = (FaceDetectDecorView) inflate.findViewById(e.helper_view);
        this.iTV = inflate.findViewById(e.gauss_blur_view);
        this.iTG.iSU = new 1(this);
        Context context2 = getContext();
        if (context2 == null) {
            x.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
            animation = null;
        } else {
            animation = AnimationUtils.loadAnimation(context2, a.anim_shake);
            animation.setInterpolator(new c());
        }
        this.iTU = animation;
    }

    public final void i(boolean z, String str) {
        if (z) {
            com.tencent.mm.sdk.f.e.post(new 2(this, str), "face_detect_set_backgroud");
            return;
        }
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        this.iTV.startAnimation(alphaAnimation);
    }

    private void aKL() {
        this.iRy.setText("");
        this.iRy.setVisibility(4);
    }

    private void AX(String str) {
        if (bi.oV(str).equals(this.iRy.getText().toString())) {
            x.v("MicroMsg.FaceDetectView", "hy: same error. ignore");
            return;
        }
        this.iRy.setText(str);
        this.iRy.setVisibility(0);
        this.iRy.setAnimation(this.iTU);
    }

    public int getCameraRotation() {
        return this.iTG.iTm.getRotation();
    }

    public int getCameraPreivewWidth() {
        return this.iTG.iTm.getPreviewWidth();
    }

    public int getCameraPreviewHeight() {
        return this.iTG.iTm.getPreviewHeight();
    }

    public int getCameraBestWidth() {
        return this.iTG.getEncodeVideoBestSize().x;
    }

    public int getCameraBestHeight() {
        return this.iTG.getEncodeVideoBestSize().y;
    }

    public b.b getCurrentMotionCancelInfo() {
        if (this.iTL != null) {
            return this.iTL.aKf();
        }
        return new b.b(90004, "user cancelled in processing");
    }

    public final void eL(boolean z) {
        if (this.iTL != null) {
            this.iTL.aKe();
        }
        if (this.hxu) {
            x.w("MicroMsg.FaceDetectView", "hy: already end");
            return;
        }
        this.hxu = true;
        if (z) {
            if (this.iTG != null) {
                f.y(new 5(this));
            }
        } else if (this.iTG != null) {
            this.iTG.aKF();
            f.iNu.iNv.iPA.aJS();
        }
        x.i("MicroMsg.FaceDetectView", "hy: stopped capture face");
        this.iTN = false;
        aKL();
    }

    public void setCallback(a aVar) {
        this.iTK = aVar;
    }

    public void setErrTextView(TextView textView) {
        this.iRy = textView;
    }

    public Bitmap getPreviewBm() {
        return this.iTG.getBitmap();
    }
}
