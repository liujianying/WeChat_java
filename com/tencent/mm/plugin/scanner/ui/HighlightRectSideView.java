package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

public class HighlightRectSideView extends View {
    private al eOf = new al(new 1(this), true);
    private Paint kx;
    private boolean[] mIp;
    private Rect mIq;
    private int mIr;
    private int mIs;
    private int mIt;
    private int mIu = 0;

    public HighlightRectSideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Bitmap decodeResource = a.decodeResource(getResources(), R.g.scanqr1);
        this.mIr = decodeResource.getWidth();
        this.mIs = decodeResource.getHeight();
        if (this.mIs != this.mIr) {
            x.e("MicroMsg.HighlightRectSideView", "width is not same as height");
        }
        this.mIt = (this.mIr * 6) / 24;
        this.mIp = new boolean[4];
        this.kx = new Paint();
        this.kx.setColor(6676738);
        this.kx.setAlpha(255);
        this.kx.setStrokeWidth((float) this.mIt);
        this.kx.setStyle(Style.STROKE);
        this.eOf.J(300, 300);
    }

    public void setMaskRect(Rect rect) {
        this.mIq = rect;
        x.d("MicroMsg.HighlightRectSideView", "rect:%s", new Object[]{rect});
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.eOf != null) {
            this.eOf.SO();
            this.eOf = null;
        }
    }

    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        for (int i2 = 0; i2 < 4; i2++) {
            if (!this.mIp[i2]) {
                i = 0;
                break;
            }
        }
        i = 1;
        int i3 = this.mIt / 2;
        if (this.mIp[0] && (1 == i || this.mIu % 2 == 0)) {
            canvas.drawLine((float) (this.mIq.left + i3), (float) (this.mIq.top + this.mIs), (float) (this.mIq.left + i3), (float) (this.mIq.bottom - this.mIs), this.kx);
        }
        if (this.mIp[1] && (1 == i || this.mIu % 2 == 0)) {
            canvas.drawLine((float) (this.mIq.right - i3), (float) (this.mIq.top + this.mIs), (float) (this.mIq.right - i3), (float) (this.mIq.bottom - this.mIs), this.kx);
        }
        if (this.mIp[2] && (1 == i || this.mIu % 3 == 0)) {
            canvas.drawLine((float) (this.mIq.left + this.mIr), (float) (this.mIq.top + i3), (float) (this.mIq.right - this.mIr), (float) (this.mIq.top + i3), this.kx);
        }
        if (!this.mIp[3]) {
            return;
        }
        if (1 == i || this.mIu % 3 == 0) {
            canvas.drawLine((float) (this.mIq.left + this.mIr), (float) (this.mIq.bottom - i3), (float) (this.mIq.right - this.mIr), (float) (this.mIq.bottom - i3), this.kx);
        }
    }

    public void setShowRectEdges(boolean[] zArr) {
        int i = 0;
        if (zArr != null && 4 == zArr.length) {
            x.d("MicroMsg.HighlightRectSideView", "%s, %s, %s, %s", new Object[]{Boolean.valueOf(zArr[0]), Boolean.valueOf(zArr[1]), Boolean.valueOf(zArr[2]), Boolean.valueOf(zArr[3])});
            while (i < 4) {
                this.mIp[i] = zArr[i];
                i++;
            }
            invalidate();
        }
    }
}
