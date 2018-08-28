package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

public class MovableTextureView extends MMTextureView {
    private float bBS;
    private float bBT;
    private OnClickListener mOnClickListener;
    public int mScreenHeight;
    public int mScreenWidth;
    public int mWidth;
    public int oTN;
    public int oUe;
    public int oUf;
    private long oUg;

    public MovableTextureView(Context context) {
        this(context, null);
    }

    public MovableTextureView(Context context, AttributeSet attributeSet) {
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
        x.d("MicroMsg.MovableTextureView", "event: " + motionEvent.getAction());
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

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
