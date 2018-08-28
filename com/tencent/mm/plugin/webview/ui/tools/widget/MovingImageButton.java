package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.x;

public class MovingImageButton extends ImageView {
    private int god;
    private int goe;
    private int hmV;
    private int hmW;
    private int jVn;
    private Context mContext;
    private int qld;
    private int qle;
    private int qlf = 0;
    private int qlg = 0;
    private MarginLayoutParams qlh;
    private final int qli = 100;
    private int qlj;
    private boolean qlk = false;
    private boolean qll = true;
    private int x;
    private int y;

    public MovingImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public MovingImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.qlj = a.fromDPToPix(this.mContext, 100);
        this.hmV = a.fk(this.mContext);
        this.hmW = a.fl(this.mContext);
        this.jVn = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.qll) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.qlf == 0 || this.qlg == 0) {
            Rect rect = new Rect();
            getWindowVisibleDisplayFrame(rect);
            this.qlf = rect.right - rect.left;
            this.qlg = rect.bottom - rect.top;
            x.d("MicroMsg.MovingImageButton", "right = %d, top = %d, left = %d, bottom = %d, screenX = %d, screenY = %d", new Object[]{Integer.valueOf(rect.right), Integer.valueOf(rect.top), Integer.valueOf(rect.left), Integer.valueOf(rect.bottom), Integer.valueOf(this.qlf), Integer.valueOf(this.qlg)});
        }
        this.x = (int) motionEvent.getRawX();
        this.y = (int) motionEvent.getRawY();
        switch (motionEvent.getAction()) {
            case 0:
                this.qld = this.x;
                this.qle = this.y;
                break;
            case 1:
                if (Math.abs(this.qld - this.x) + Math.abs(this.qle - this.y) <= this.jVn) {
                    performClick();
                    break;
                }
                if (this.y < this.qlj) {
                    this.qlh.topMargin = 0;
                } else if (this.y > this.qlg - this.qlj) {
                    this.qlh.topMargin = this.qlg - getHeight();
                } else if (this.x > this.qlf / 2) {
                    this.qlh.rightMargin = 0;
                } else {
                    this.qlh.rightMargin = this.qlf - getWidth();
                }
                requestLayout();
                break;
            case 2:
                int i = this.x - this.god;
                int i2 = this.y - this.goe;
                if (!(i == 0 && i2 == 0)) {
                    this.qlh = (MarginLayoutParams) getLayoutParams();
                    MarginLayoutParams marginLayoutParams = this.qlh;
                    marginLayoutParams.rightMargin = (-i) + marginLayoutParams.rightMargin;
                    marginLayoutParams = this.qlh;
                    marginLayoutParams.topMargin += i2;
                    if (this.qlh.rightMargin < 0) {
                        this.qlh.rightMargin = 0;
                    } else if (this.qlh.rightMargin > this.qlf - getWidth()) {
                        this.qlh.rightMargin = this.qlf - getWidth();
                    }
                    if (this.qlh.topMargin < 0) {
                        this.qlh.topMargin = 0;
                    } else if (this.qlh.topMargin > this.qlg - getHeight()) {
                        this.qlh.topMargin = this.qlg - getHeight();
                    }
                    requestLayout();
                    break;
                }
        }
        this.god = this.x;
        this.goe = this.y;
        return true;
    }

    public void setCanMove(boolean z) {
        this.qll = z;
    }
}
