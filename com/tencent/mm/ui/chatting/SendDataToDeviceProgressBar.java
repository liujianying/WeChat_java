package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ag;

class SendDataToDeviceProgressBar extends ImageView {
    private int bottom;
    private Paint cN;
    private ag dvh;
    private int iCE;
    private int iCF;
    private Runnable iCG;
    private int jZt;
    private int left;
    private Context mContext;
    private int right;
    private int top;

    public SendDataToDeviceProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SendDataToDeviceProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iCE = 2;
        this.left = -1;
        this.top = -1;
        this.right = -1;
        this.bottom = -1;
        this.iCF = -1;
        this.jZt = 10;
        this.iCG = new Runnable() {
            public final void run() {
                SendDataToDeviceProgressBar.this.invalidate();
            }
        };
        setImageResource(R.g.progressbar_background);
        this.mContext = context;
        this.cN = new Paint();
        this.cN.setAntiAlias(true);
        this.cN.setStyle(Style.STROKE);
        this.left = this.mContext.getResources().getDimensionPixelSize(R.f.send_data_progress_bar_circle_margin);
        this.top = this.left;
        this.iCF = this.mContext.getResources().getDimensionPixelSize(R.f.send_data_progress_bar_circle_width);
        this.dvh = new ag(Looper.getMainLooper());
    }

    public final void setProgress(int i) {
        if (i >= 100) {
            i = 100;
        }
        this.iCE = (int) ((((float) i) / 100.0f) * 360.0f);
        this.dvh.removeCallbacks(this.iCG);
        this.dvh.postDelayed(this.iCG, 0);
    }

    public final int getProgress() {
        return (int) ((((float) this.iCE) / 360.0f) * 100.0f);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        this.cN.setColor(this.mContext.getResources().getColor(R.e.progress_color));
        this.cN.setStrokeWidth((float) this.iCF);
        if (this.right == -1) {
            this.right = (width * 2) - this.left;
        }
        if (this.bottom == -1) {
            this.bottom = this.right;
        }
        RectF rectF = new RectF((float) this.left, (float) this.top, (float) this.right, (float) this.bottom);
        canvas.drawArc(rectF, 270.0f, (float) this.iCE, false, this.cN);
        width = this.iCE + 270;
        if (width > 360) {
            width -= 360;
        }
        this.cN.setColor(this.mContext.getResources().getColor(R.e.progress_background));
        canvas.drawArc(rectF, (float) width, (float) (360 - this.iCE), false, this.cN);
    }
}
