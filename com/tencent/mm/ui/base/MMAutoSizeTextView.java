package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.x;

public class MMAutoSizeTextView extends TextView {
    private Paint kR;
    private float kgG;
    private float ttG;
    private float ttH;

    public MMAutoSizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public MMAutoSizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setSingleLine();
        setEllipsize(TruncateAt.END);
        this.ttG = (float) a.fromDPToPix(getContext(), 8);
        this.ttH = (float) a.fromDPToPix(getContext(), 22);
        this.kR = new Paint();
        this.kR.set(getPaint());
        crp();
    }

    private void dj(String str, int i) {
        x.i("MicroMsg.MMAutoSizeTextView", "autoAdjustTextSize[text=%s, viewWidth=%d]", new Object[]{str, Integer.valueOf(i)});
        if (i > 0) {
            int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
            crp();
            float f = this.kgG;
            this.kR.setTextSize(f);
            while (f > this.ttG && this.kR.measureText(str) > ((float) paddingLeft)) {
                f -= 1.0f;
                if (f <= this.ttG) {
                    f = this.ttG;
                    break;
                }
                this.kR.setTextSize(f);
            }
            x.i("MicroMsg.MMAutoSizeTextView", "try size[%f], maxSize[%f], measureTextSize[%f], availableWidth[%d]", new Object[]{Float.valueOf(f), Float.valueOf(this.kgG), Float.valueOf(this.kR.measureText(str)), Integer.valueOf(paddingLeft)});
            setTextSize(0, f);
        }
    }

    private void crp() {
        this.kgG = getTextSize();
        if (this.kgG <= this.ttG) {
            this.kgG = this.ttH;
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        x.w("MicroMsg.MMAutoSizeTextView", "on text changed");
        super.onTextChanged(charSequence, i, i2, i3);
        dj(charSequence.toString(), getWidth());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        x.w("MicroMsg.MMAutoSizeTextView", "on size changed");
        if (i != i3) {
            dj(getText().toString(), i);
        }
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
        }
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
            return -1;
        }
    }

    public boolean onPreDraw() {
        try {
            return super.onPreDraw();
        } catch (Throwable th) {
            return true;
        }
    }
}
