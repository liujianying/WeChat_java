package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.smtt.sdk.WebView;

public class ExdeviceConnectedRouterStateView extends ImageView {
    private int bottom;
    private Paint cN;
    private ag dvh;
    int iCE;
    private int iCF;
    private Runnable iCG;
    private int left;
    private Context mContext;
    private int right;
    private int state;
    private int top;

    public ExdeviceConnectedRouterStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExdeviceConnectedRouterStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iCE = 2;
        this.left = -1;
        this.top = -1;
        this.right = -1;
        this.bottom = -1;
        this.iCF = -1;
        this.iCG = new 1(this);
        this.mContext = context;
        this.cN = new Paint();
        this.cN.setAntiAlias(true);
        this.cN.setStyle(Style.STROKE);
        this.left = a.fromDPToPix(this.mContext, 2);
        this.top = this.left;
        this.iCF = a.fromDPToPix(this.mContext, 3);
        this.dvh = new ag(Looper.getMainLooper());
    }

    public void setState(int i) {
        this.state = i;
        pi(10);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.state == 1) {
            int width = getWidth() / 2;
            this.cN.setARGB(WebView.NORMAL_MODE_ALPHA, 103, 209, 79);
            this.cN.setStrokeWidth((float) this.iCF);
            if (this.right == -1) {
                this.right = (width * 2) - this.left;
            }
            if (this.bottom == -1) {
                this.bottom = this.right;
            }
            canvas.drawArc(new RectF((float) this.left, (float) this.top, (float) this.right, (float) this.bottom), 270.0f, (float) this.iCE, false, this.cN);
            this.iCE += 5;
            if (this.iCE > 365) {
                this.iCE = 0;
            }
            pi(100);
        }
    }

    private void pi(int i) {
        this.dvh.removeCallbacks(this.iCG);
        this.dvh.postDelayed(this.iCG, (long) i);
    }
}
