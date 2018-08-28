package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.model.i;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

public final class a extends BaseSmallView {
    private boolean Hg;
    private ag guJ = new ag(Looper.getMainLooper());
    private int oRO;
    private OpenGlRender oVK;
    private OpenGlView oVL;
    private OpenGlRender oVM;
    private OpenGlView oVN;
    private int[] oVO = null;
    private int oVP = 0;
    private float oVQ;
    private Runnable oVR = new 1(this);
    private Runnable oVS = new 2(this);

    public a(Context context, float f) {
        super(context, null);
        LayoutInflater.from(context).inflate(R.i.voip_widget_video_talking, this);
        this.oVQ = f;
        this.oVL = (OpenGlView) findViewById(R.h.ogv_talking);
        this.oVK = new OpenGlRender(this.oVL, OpenGlRender.oUL);
        this.oVL.setRenderer(this.oVK);
        this.oVL.setRenderMode(0);
        this.oVN = (OpenGlView) findViewById(R.h.ogv_local_video);
        this.oVM = new OpenGlRender(this.oVN, OpenGlRender.oUK);
        this.oVN.setRenderer(this.oVM);
        this.oVN.setRenderMode(0);
        this.oVN.setZOrderMediaOverlay(true);
        this.Hg = false;
        this.oRM = (MMTextureView) findViewById(R.h.hwViewSmall);
        if (this.oRM != null) {
            x.i("MicroMsg.Voip.TalkingSmallView", "hwViewSmall creat ok!");
        }
        this.ioW.postDelayed(new 3(this), 3000);
        this.ioW.postDelayed(this.oVS, 2000);
        this.ioW.postDelayed(this.oVR, 5000);
    }

    public final void dV(int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) this.oVN.getLayoutParams();
        layoutParams.height = i2 / 4;
        layoutParams.width = (int) (this.oVQ * ((float) layoutParams.height));
        this.oVN.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = (WindowManager.LayoutParams) getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new WindowManager.LayoutParams();
        }
        layoutParams2.width = i;
        layoutParams2.height = i2;
        setLayoutParams(layoutParams2);
    }

    private void bMo() {
        if (!this.Hg) {
            this.Hg = true;
            this.oVK.oUr = true;
            this.oVM.oUr = true;
        }
    }

    public final void c(int i, int i2, int[] iArr) {
        bMo();
        if (OpenGlRender.oUV == 1) {
            this.oVK.b(iArr, i, i2, OpenGlRender.oUB + OpenGlRender.oUH);
        } else {
            this.oVK.b(iArr, i, i2, OpenGlRender.oUE + OpenGlRender.oUH);
        }
    }

    public final void bKB() {
        if (this.Hg) {
            this.oVM.bMi();
            this.oVK.bMi();
        }
    }

    public final void setHWDecMode(int i) {
        int i2 = i & 1;
        if (this.guJ != null) {
            if ((i2 != 0 ? 1 : null) == null) {
                x.i("MicroMsg.Voip.TalkingSmallView", "setHWDecMode, not hwdec");
                this.guJ.post(new 4(this));
            } else {
                x.i("MicroMsg.Voip.TalkingSmallView", "setHWDecMode, is hwdec");
                this.guJ.post(new 5(this));
            }
        }
        this.oRO = i;
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5) {
        if (this.oVN.getVisibility() == 0) {
            bMo();
            if (OpenGlRender.oUV == 1) {
                if (this.oVP < i * i2) {
                    this.oVO = null;
                }
                if (this.oVO == null) {
                    this.oVP = i * i2;
                    this.oVO = new int[this.oVP];
                }
                if (i.bJI().a(bArr, (int) j, i3 & 31, i, i2, this.oVO, false) >= 0 && this.oVO != null) {
                    this.oVM.b(this.oVO, i, i2, (OpenGlRender.oUC + i4) + i5);
                }
            } else if (OpenGlRender.oUV == 2) {
                this.oVM.e(bArr, i, i2, (OpenGlRender.oUG + i4) + i5);
            }
        }
    }

    public final void uninit() {
        super.uninit();
        setVisibility(4);
        if (this.Hg) {
            this.oVK.bMh();
            this.oVM.bMh();
        }
        this.ioW.removeCallbacks(this.oVR);
    }

    public final void setCaptureView(CaptureView captureView) {
        x.k("MicroMsg.Voip.BaseSmallView", "addCaptureView", new Object[0]);
        if (this.oLP != null) {
            removeView(this.oLP);
            this.oLP = null;
        }
        if (captureView != null) {
            this.oLP = captureView;
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(1, 1);
            layoutParams.leftMargin = 20;
            layoutParams.topMargin = 20;
            addView(captureView, layoutParams);
            captureView.setVisibility(0);
            x.d("MicroMsg.Voip.BaseSmallView", "CaptureView added");
        }
    }

    protected final void bLM() {
        this.oVN.setVisibility(0);
        this.ioW.removeCallbacks(this.oVR);
        this.ioW.postDelayed(this.oVR, 3000);
    }

    protected final void bLN() {
        this.oVK.bMh();
        this.oVM.bMh();
    }

    protected final void onAnimationEnd() {
        this.oVK.oUr = true;
        this.oVM.oUr = true;
    }
}
