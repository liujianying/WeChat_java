package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;

public class MovableVideoView extends OpenGlView {
    private float bBS;
    private float bBT;
    private OnClickListener mOnClickListener;
    private int mScreenHeight;
    private int mScreenWidth;
    int mWidth;
    int oTN;
    private int oUe;
    private int oUf;
    private long oUg;

    public MovableVideoView(Context context) {
        this(context, null);
    }

    public MovableVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWidth = 320;
        this.oTN = aq.CTRL_BYTE;
        this.oUe = 800;
        this.oUf = 480;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        x.d("MicroMsg.MovableVideoView", "event: " + motionEvent.getAction());
        switch (motionEvent.getAction()) {
            case 0:
                this.bBS = motionEvent.getRawX();
                this.bBT = motionEvent.getRawY();
                this.oUg = System.currentTimeMillis();
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (this.oUg != 0 && currentTimeMillis - this.oUg < 300 && currentTimeMillis - this.oUg >= 0 && this.mOnClickListener != null) {
                    this.mOnClickListener.onClick(this);
                }
                h.mEJ.h(11079, new Object[]{Integer.valueOf(2)});
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.bBS;
                float rawY = motionEvent.getRawY() - this.bBT;
                if (Math.abs(rawX) > 1.0f || Math.abs(rawY) > 1.0f) {
                    LayoutParams layoutParams = (LayoutParams) getLayoutParams();
                    int i2 = (int) (rawX + ((float) layoutParams.leftMargin));
                    int i3 = (int) (rawY + ((float) layoutParams.topMargin));
                    if (i2 < 0) {
                        i2 = 0;
                    } else if (i2 > this.oUf) {
                        i2 = this.oUf;
                    }
                    layoutParams.leftMargin = i2;
                    if (i3 >= 0) {
                        i = i3 > this.oUe ? this.oUe : i3;
                    }
                    layoutParams.topMargin = i;
                    setLayoutParams(layoutParams);
                    this.bBS = motionEvent.getRawX();
                    this.bBT = motionEvent.getRawY();
                    break;
                }
        }
        return true;
    }

    public final void dS(int i, int i2) {
        this.mWidth = i;
        this.oTN = i2;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (this.mScreenWidth == 0) {
            this.mScreenWidth = windowManager.getDefaultDisplay().getWidth();
            this.mScreenHeight = windowManager.getDefaultDisplay().getHeight();
        }
        ViewGroup.LayoutParams layoutParams = new LayoutParams(i, i2);
        layoutParams.topMargin = a.fromDPToPix(getContext(), 12) + s.gJ(getContext());
        layoutParams.leftMargin = ((this.mScreenWidth - this.mWidth) - layoutParams.topMargin) + s.gJ(getContext());
        setLayoutParams(layoutParams);
        this.oUe = this.mScreenHeight - this.oTN;
        this.oUf = this.mScreenWidth - this.mWidth;
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
    }

    public final void dT(int i, int i2) {
        dS(i, i2);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public final void dU(int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(i, i2);
        layoutParams2.leftMargin = layoutParams.leftMargin;
        layoutParams2.topMargin = layoutParams.topMargin;
        this.mWidth = i;
        this.oTN = i2;
        setLayoutParams(layoutParams2);
    }
}
