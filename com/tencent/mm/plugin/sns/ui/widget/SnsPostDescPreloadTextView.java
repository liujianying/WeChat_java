package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.c;
import com.tencent.mm.kiss.widget.textview.d;
import com.tencent.mm.kiss.widget.textview.f;

public class SnsPostDescPreloadTextView extends PLTextView {
    private static int hitCount = 0;
    private static int missCount = 0;
    private boolean onc = false;
    private int ond = 0;

    public SnsPostDescPreloadTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsPostDescPreloadTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setSpecialWidth(int i) {
        this.ond = i;
    }

    protected final a Fc() {
        this.onc = true;
        return d.bEY().getTextViewConfig();
    }

    public void setMaxLines(int i) {
        boolean z = true;
        if (getText() == null) {
            super.setMaxLines(i);
        }
        if (i <= 6) {
            if (this.onc) {
                setConfig(d.bEY().bEZ());
                this.onc = false;
            }
            z = false;
        } else {
            if (!this.onc) {
                setConfig(d.bEY().getTextViewConfig());
                this.onc = true;
            }
            z = false;
        }
        if (z) {
            f a = c.dtC.a(getConfig(), getText());
            if (a == null) {
                int postDescWidth = getPostDescWidth();
                if (postDescWidth > 0) {
                    a = d.a(getText(), postDescWidth, getConfig()).Fa();
                }
            }
            if (a != null) {
                setTextLayout(a);
            }
        }
    }

    protected final void o(CharSequence charSequence) {
        super.o(charSequence);
        hitCount++;
    }

    protected final void n(CharSequence charSequence) {
        if (charSequence != null) {
            setText(e.a(getContext(), charSequence.toString(), getConfig().duz), true);
        }
        missCount++;
    }

    private int getPostDescWidth() {
        if (this.ond > 0) {
            return this.ond;
        }
        return d.bEY().getViewWidth();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
