package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.mm.bw.a.k;
import com.tencent.mm.ui.ap;

public class MMAutoAdjustTextView extends TextView {
    private float duz;
    private Paint kR;
    private float scale;

    public MMAutoAdjustTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context.obtainStyledAttributes(attributeSet, k.MMAutoAdjustTextView));
        init();
    }

    public MMAutoAdjustTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context.obtainStyledAttributes(attributeSet, k.MMAutoAdjustTextView));
        init();
    }

    private void init() {
        this.duz = getTextSize();
        this.scale = ap.fe(getContext());
        this.kR = new Paint();
        this.kR.set(getPaint());
    }

    private static void b(TypedArray typedArray) {
        if (typedArray != null) {
            typedArray.recycle();
        }
    }

    private void GL(int i) {
        if (i > 0) {
            while (true) {
                measure(0, MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                if (((float) getMeasuredWidth()) > ((float) i)) {
                    this.duz -= ap.getDensity(getContext());
                    setTextSize(0, this.duz * this.scale);
                } else {
                    return;
                }
            }
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        charSequence.toString();
        GL(getWidth());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            getText().toString();
            GL(i);
        }
    }
}
