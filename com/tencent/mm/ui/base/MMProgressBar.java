package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class MMProgressBar extends LinearLayout {
    private al lJn = new al(new 1(this), false);
    private int max = 100;
    private TextView ndP;
    private int twj = 0;
    private int twk = 0;
    private TextView twl;
    private a twm;

    static /* synthetic */ void b(MMProgressBar mMProgressBar, int i) {
        mMProgressBar.twl.setWidth(mMProgressBar.getProgressLength());
        if (mMProgressBar.twm != null) {
            mMProgressBar.twm.yl(i);
        }
    }

    public MMProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate(getContext(), h.mm_progress_bar, this);
        this.twl = (TextView) findViewById(g.mm_progress_bar_progress);
        this.ndP = (TextView) findViewById(g.mm_progress_bar_tips);
    }

    public void setMax(int i) {
        this.max = i;
    }

    public int getMax() {
        return this.max;
    }

    public void setProgress(int i) {
        if (i > this.max) {
            i = this.max;
        }
        this.twk = i;
        if (this.lJn.ciq()) {
            setAutoProgress(true);
        }
    }

    public int getProgress() {
        return this.twk;
    }

    public void setAutoProgress(boolean z) {
        if (z) {
            this.lJn.J(40, 40);
        } else {
            this.lJn.SO();
        }
    }

    public void setTips(CharSequence charSequence) {
        this.ndP.setText(charSequence);
    }

    public void setOnProgressChangedListener(a aVar) {
        this.twm = aVar;
    }

    private int getProgressLength() {
        int width = (getWidth() * this.twj) / this.max;
        if (width < b.b(getContext(), 20.0f)) {
            return b.b(getContext(), 20.0f);
        }
        return width;
    }
}
