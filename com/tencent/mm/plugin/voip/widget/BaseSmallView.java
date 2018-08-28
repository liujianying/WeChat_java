package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

public abstract class BaseSmallView extends FrameLayout {
    private WindowManager inU;
    protected ag ioW;
    private OnClickListener mOnClickListener;
    private long mStartTime;
    CaptureView oLP;
    protected long oMa;
    protected WeakReference<c> oQd;
    public MMTextureView oRM;
    private PointF oVD = new PointF();
    private Point oVE = new Point();
    private Point oVF = new Point();
    private Point oVG = new Point();
    private Point oVH;
    private Runnable oVI = new 1(this);

    public abstract void bLM();

    public abstract void bLN();

    public abstract void onAnimationEnd();

    public abstract void setCaptureView(CaptureView captureView);

    public void c(int i, int i2, int[] iArr) {
    }

    public void bKB() {
    }

    public void setHWDecMode(int i) {
    }

    public void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5) {
    }

    public void dV(int i, int i2) {
    }

    public void uninit() {
        this.ioW.removeCallbacks(this.oVI);
        this.inU = null;
        if (this.oLP != null) {
            removeView(this.oLP);
            this.oLP = null;
            x.d("MicroMsg.Voip.BaseSmallView", "CaptureView removed");
        }
    }

    public BaseSmallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inU = (WindowManager) context.getSystemService("window");
        this.ioW = new ag();
        this.oVH = new Point(this.inU.getDefaultDisplay().getWidth(), this.inU.getDefaultDisplay().getHeight());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.oVD.x = motionEvent.getRawX();
                this.oVD.y = motionEvent.getRawY();
                LayoutParams layoutParams = (LayoutParams) getLayoutParams();
                this.oVE.x = layoutParams.x;
                this.oVE.y = layoutParams.y;
                break;
            case 1:
                if (Math.abs(motionEvent.getRawX() - this.oVD.x) < ((float) b.b(getContext(), 3.0f)) && Math.abs(motionEvent.getRawY() - this.oVD.y) < ((float) b.b(getContext(), 3.0f)) && this.mOnClickListener != null) {
                    this.mOnClickListener.onClick(this);
                }
                bLM();
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                this.oVF.x = (int) Math.max(Math.min((rawX + ((float) this.oVE.x)) - this.oVD.x, (float) this.oVH.x), 0.0f);
                this.oVF.y = (int) Math.max(Math.min((rawY + ((float) this.oVE.y)) - this.oVD.y, (float) this.oVH.y), 0.0f);
                int b = b.b(getContext(), 5.0f);
                if (this.oVF.x + (getWidth() / 2) <= this.oVH.x / 2) {
                    this.oVG.x = b;
                } else {
                    this.oVG.x = (this.oVH.x - getWidth()) - b;
                }
                this.oVG.y = this.oVF.y;
                this.mStartTime = System.currentTimeMillis();
                this.ioW.postDelayed(this.oVI, 5);
                bLN();
                break;
            case 2:
                dW((int) Math.max(Math.min((((float) this.oVE.x) + motionEvent.getRawX()) - this.oVD.x, (float) this.oVH.x), 0.0f), (int) Math.max(Math.min((((float) this.oVE.y) + motionEvent.getRawY()) - this.oVD.y, (float) this.oVH.y), 0.0f));
                break;
        }
        return true;
    }

    private void dW(int i, int i2) {
        if (this.inU != null) {
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            layoutParams.x = i;
            layoutParams.y = i2;
            x.d("MicroMsg.Voip.BaseSmallView", "updateWindowPosition, x: %d, y: %d", new Object[]{Integer.valueOf(layoutParams.x), Integer.valueOf(layoutParams.y)});
            try {
                this.inU.updateViewLayout(this, layoutParams);
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.Voip.BaseSmallView", th, "", new Object[0]);
            }
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setConnectSec(long j) {
        this.oMa = j;
    }

    public void setVoipUIListener(c cVar) {
        x.i("MicroMsg.Voip.BaseSmallView", "hwViewSmall setVoipUIListener, before initHWView");
        this.oQd = new WeakReference(cVar);
        ((c) this.oQd.get()).a(this.oRM);
    }
}
