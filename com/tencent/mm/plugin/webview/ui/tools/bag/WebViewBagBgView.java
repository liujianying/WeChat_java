package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.sdk.platformtools.x;

public class WebViewBagBgView extends View {
    private Paint cN = new Paint();
    private RectF cP;
    int mDuration;
    long mStartTime;
    int ouh;
    private int qcd = -7829368;
    private int qce = -65536;
    private float qcf = 0.0f;
    private float qcg;
    private float qch;
    private int qci;
    private int qcj;
    boolean qck;

    public WebViewBagBgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cN.setAntiAlias(true);
        this.qcj = -1;
    }

    public void setStartColor(int i) {
        this.qcd = i;
    }

    public void setAngryColor(int i) {
        this.qce = i;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.cN.setShader(new LinearGradient(0.0f, this.qcg, 0.0f, this.qch, new int[]{this.qcd, this.qce}, null, TileMode.CLAMP));
        canvas.drawOval(this.cP, this.cN);
        if (this.qck && this.qch > 0.0f) {
            this.qcg -= this.qcf;
            this.qcg = this.qcg < ((float) (-this.qci)) ? (float) (-this.qci) : this.qcg;
            this.qch = ((float) this.qcj) - this.qcg < ((float) this.qci) ? (float) this.qcj : this.qcg + ((float) this.qci);
            postInvalidateDelayed((long) this.ouh);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.qcj = MeasureSpec.getSize(i);
        this.cP = new RectF(0.0f, 0.0f, (float) this.qcj, (float) this.qcj);
        this.qci = this.qcj / 2;
        fE(System.currentTimeMillis());
    }

    final void fE(long j) {
        if (this.qcj < 0) {
            x.i("MicroMsg.WebViewBagBgView", "doUpdateAngryInfo not measured, mDiameter:%d", new Object[]{Integer.valueOf(this.qcj)});
            return;
        }
        float f;
        WebViewBagBgView webViewBagBgView;
        this.qcf = ((float) (this.qcj * 2)) / (((float) this.mDuration) / ((float) this.ouh));
        if (j - this.mStartTime <= 0) {
            f = (float) this.qcj;
            webViewBagBgView = this;
        } else {
            this.qcg = ((float) this.qcj) - (((float) (((int) (((float) (j - this.mStartTime)) / ((float) this.ouh))) + 1)) * this.qcf);
            if (this.qcg < ((float) (-this.qci))) {
                f = (float) (-this.qci);
                webViewBagBgView = this;
            } else {
                f = this.qcg;
                webViewBagBgView = this;
            }
        }
        webViewBagBgView.qcg = f;
        if (((float) this.qcj) - this.qcg < ((float) this.qci)) {
            f = (float) this.qcj;
        } else {
            f = this.qcg + ((float) this.qci);
        }
        this.qch = f;
    }
}
