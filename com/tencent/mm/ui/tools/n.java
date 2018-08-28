package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.x;

public final class n implements Runnable {
    public ListView lPD;
    public int mMode;
    public long uBk = System.currentTimeMillis();
    public int uBl;
    public int uBm;
    public int uBn;
    private final int uBo;
    public int uBp;

    public n(ListView listView) {
        this.lPD = listView;
        this.uBo = ViewConfiguration.get(this.lPD.getContext()).getScaledFadingEdgeLength();
        x.d("ScrollerRunnable", "mExtraScroll: %d", new Object[]{Integer.valueOf(this.uBo)});
    }

    public final void run() {
        if (System.currentTimeMillis() - this.uBk <= 10000) {
            int height = this.lPD.getHeight();
            int firstVisiblePosition = this.lPD.getFirstVisiblePosition();
            int childCount;
            switch (this.mMode) {
                case 1:
                    childCount = this.lPD.getChildCount() - 1;
                    firstVisiblePosition += childCount;
                    if (childCount >= 0) {
                        if (firstVisiblePosition == this.uBm) {
                            if (this.uBp > 20) {
                                this.lPD.setSelection(this.uBl);
                                x.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
                            } else {
                                this.lPD.post(this);
                                this.uBp++;
                                x.d("ScrollerRunnable", "dz:try scroll lastpos = %d", new Object[]{Integer.valueOf(firstVisiblePosition)});
                                return;
                            }
                        }
                        this.uBp = 0;
                        View childAt = this.lPD.getChildAt(childCount);
                        int height2 = childAt.getHeight();
                        childCount = height - childAt.getTop();
                        if (firstVisiblePosition < this.lPD.getCount() - 1) {
                            height = this.uBo;
                        } else {
                            height = this.lPD.getPaddingBottom();
                        }
                        this.lPD.smoothScrollBy(height + (height2 - childCount), this.uBn);
                        this.uBm = firstVisiblePosition;
                        if (firstVisiblePosition < this.uBl) {
                            this.lPD.post(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (firstVisiblePosition == this.uBm) {
                        if (this.uBp > 20) {
                            this.lPD.setSelection(this.uBl);
                            x.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
                        } else {
                            this.lPD.post(this);
                            this.uBp++;
                            x.d("ScrollerRunnable", "dz:try scroll firstPos = %d", new Object[]{Integer.valueOf(firstVisiblePosition)});
                            return;
                        }
                    }
                    this.uBp = 0;
                    View childAt2 = this.lPD.getChildAt(0);
                    if (childAt2 != null) {
                        childCount = childAt2.getTop();
                        if (firstVisiblePosition > 0) {
                            height = this.uBo;
                        } else {
                            height = this.lPD.getPaddingTop();
                        }
                        this.lPD.smoothScrollBy(childCount - height, this.uBn);
                        this.uBm = firstVisiblePosition;
                        if (firstVisiblePosition > this.uBl) {
                            this.lPD.post(this);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
