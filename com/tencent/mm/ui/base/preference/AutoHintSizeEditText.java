package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.e;

public class AutoHintSizeEditText extends EditText {
    private int tBA = Integer.MIN_VALUE;
    private float tBB;
    private float tBx;
    private Paint tBy;
    private String tBz = "";

    public AutoHintSizeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public AutoHintSizeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.tBx = getTextSize();
        this.tBB = this.tBx;
        this.tBy = new Paint(getPaint());
        addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AutoHintSizeEditText.this.a(editable, AutoHintSizeEditText.this.getHint(), (AutoHintSizeEditText.this.getWidth() - AutoHintSizeEditText.this.getPaddingLeft()) - AutoHintSizeEditText.this.getPaddingRight());
            }
        });
    }

    private void a(Editable editable, CharSequence charSequence, int i) {
        if (editable == null || bi.oW(editable.toString())) {
            if (charSequence != null && !bi.oW(charSequence.toString())) {
                String charSequence2 = charSequence.toString();
                if (!this.tBz.equals(charSequence2) || this.tBA != i) {
                    this.tBz = charSequence2;
                    this.tBA = i;
                    if (getPaint().measureText(charSequence2) > ((float) i)) {
                        int dimensionPixelSize = getResources().getDimensionPixelSize(e.SmallestTextSize);
                        int fromDPToPix = a.fromDPToPix(getContext(), 1);
                        for (int i2 = ((int) this.tBx) - fromDPToPix; i2 > dimensionPixelSize; i2 -= fromDPToPix) {
                            this.tBy.setTextSize((float) i2);
                            if (this.tBy.measureText(charSequence2) < ((float) i)) {
                                x.v("MicroMsg.AutoHintSizeEdittext", "get new hint text size %d", new Object[]{Integer.valueOf(i2)});
                                this.tBB = (float) i2;
                                setTextSize(0, (float) i2);
                                return;
                            }
                        }
                    }
                } else if (getTextSize() != this.tBB) {
                    x.v("MicroMsg.AutoHintSizeEdittext", "use last hint text size %f", new Object[]{Float.valueOf(this.tBB)});
                    setTextSize(0, this.tBB);
                }
            } else if (getTextSize() != this.tBx) {
                x.v("MicroMsg.AutoHintSizeEdittext", "hint is null, reset text size %f", new Object[]{Float.valueOf(this.tBx)});
                setTextSize(0, this.tBx);
            }
        } else if (getTextSize() != this.tBx) {
            x.v("MicroMsg.AutoHintSizeEdittext", "content not null, reset text size %f", new Object[]{Float.valueOf(this.tBx)});
            setTextSize(0, this.tBx);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.AutoHintSizeEdittext", "on layout, changed %B", new Object[]{Boolean.valueOf(z)});
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            a(getText(), getHint(), ((i3 - i) - getPaddingLeft()) - getPaddingRight());
        }
    }
}
