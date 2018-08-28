package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Scroller;
import com.tencent.mm.plugin.game.f.e;

public class GameCenterListView extends ListView {
    static boolean jVp;
    static int jVr;
    private View Iq;
    private boolean jVl;
    private float jVm;
    private int jVn;
    private boolean jVo;
    private boolean jVq;
    private ImageView jVs;
    private ImageView jVt;
    private Context mContext;
    private Scroller wf;

    public GameCenterListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jVn = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        this.wf = new Scroller(this.mContext);
        super.setOnScrollListener(new 1(this));
    }

    public static void setCanPulldown(boolean z) {
        jVp = z;
    }

    public static void setDefaultPadding(int i) {
        jVr = i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && !this.jVl) {
            this.Iq = getChildAt(0);
            this.jVt = (ImageView) this.Iq.findViewById(e.small_image);
            this.jVs = (ImageView) this.Iq.findViewById(e.big_image);
            this.jVl = true;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!jVp || this.Iq == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.jVq = false;
                this.jVm = motionEvent.getRawY();
                break;
            case 2:
                if (this.jVo) {
                    if (this.jVq) {
                        return true;
                    }
                    int rawY = (int) (motionEvent.getRawY() - this.jVm);
                    if (this.Iq.getPaddingTop() <= jVr + this.jVn) {
                        if (rawY > 0 && Math.abs(rawY) >= this.jVn) {
                            this.jVq = true;
                            this.wf.startScroll(0, this.Iq.getPaddingTop(), 0, -this.Iq.getPaddingTop(), 500);
                            this.jVs.setClickable(true);
                            invalidate();
                            motionEvent.setAction(3);
                            super.dispatchTouchEvent(motionEvent);
                            return true;
                        }
                    } else if (this.Iq.getPaddingTop() >= (-this.jVn) && rawY < 0 && Math.abs(rawY) >= this.jVn) {
                        this.jVq = true;
                        this.wf.startScroll(0, 0, 0, jVr, 500);
                        invalidate();
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        return true;
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void computeScroll() {
        if (this.Iq != null && this.wf.computeScrollOffset()) {
            int currY = this.wf.getCurrY();
            this.Iq.setPadding(0, currY, 0, 0);
            float f = (((float) (jVr - currY)) / ((float) jVr)) * 255.0f;
            int i = 255 - ((int) f);
            currY = (int) f;
            this.jVt.setAlpha(i);
            this.jVs.setAlpha(currY);
            invalidate();
        }
    }
}
