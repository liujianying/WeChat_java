package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.e;

public class MMTagPanelScrollView extends ScrollView {
    private int kGo = 0;
    private Runnable tyf = new Runnable() {
        public final void run() {
            MMTagPanelScrollView.this.scrollTo(0, MMTagPanelScrollView.this.getBottom());
        }
    };
    private a tyg = new a((byte) 0);
    private int tyh = 2;

    public MMTagPanelScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMTagPanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setMaxLine(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.tyh = i;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0 && (getChildAt(0) instanceof MMTagPanel)) {
            int i3;
            MMTagPanel mMTagPanel = (MMTagPanel) getChildAt(0);
            if (mMTagPanel.txP == null) {
                i3 = 0;
            } else {
                boolean i32 = mMTagPanel.txP.isFocused();
            }
            if (mMTagPanel.getLineCount() == this.tyh) {
                this.kGo = mMTagPanel.getMeasuredHeight() + getResources().getDimensionPixelOffset(e.SmallerPadding);
            }
            if (mMTagPanel.getLineCount() >= this.tyh) {
                int i4;
                int size = MeasureSpec.getSize(i);
                int max = Math.max(0, Math.min(mMTagPanel.tst.size(), this.tyh));
                int paddingTop = mMTagPanel.getPaddingTop();
                int i5 = 0;
                while (true) {
                    i4 = paddingTop;
                    if (i5 >= max - 1) {
                        break;
                    }
                    i4 += ((Integer) mMTagPanel.tst.get(i5)).intValue() + mMTagPanel.tss;
                    paddingTop = i5 + 1;
                }
                x.d("MicroMsg.FavTagPanelScrollView", "height %d", new Object[]{Integer.valueOf(Math.max((((Integer) mMTagPanel.tst.get(max - 1)).intValue() + i4) + mMTagPanel.getPaddingBottom(), this.kGo))});
                setMeasuredDimension(size, paddingTop);
                if (i32 != 0) {
                    this.tyg.tyj = mMTagPanel;
                    removeCallbacks(this.tyg);
                    post(this.tyg);
                }
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        scrollBy(0, i4);
    }
}
