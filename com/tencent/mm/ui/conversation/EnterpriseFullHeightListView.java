package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;

public class EnterpriseFullHeightListView extends ListView {
    private int hGJ = 0;
    public boolean uqD = true;
    private View uqE;

    public EnterpriseFullHeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EnterpriseFullHeightListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5 = 0;
        super.onSizeChanged(i, i2, i3, i4);
        if (!this.uqD) {
            try {
                if (!this.uqD) {
                    int headerViewsCount = getHeaderViewsCount();
                    int count = getAdapter().getCount();
                    if (this.uqE != null) {
                        count--;
                    }
                    while (headerViewsCount < count) {
                        if (this.hGJ <= 0) {
                            try {
                                View view = getAdapter().getView(headerViewsCount, null, this);
                                view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                                this.hGJ = view.getMeasuredHeight();
                            } catch (Exception e) {
                            }
                        }
                        i5 += this.hGJ;
                        if (i5 <= i2) {
                            headerViewsCount++;
                        } else if (this.uqE != null) {
                            removeFooterView(this.uqE);
                            this.uqE = null;
                            return;
                        } else {
                            return;
                        }
                    }
                    if (i5 < i2) {
                        if (this.uqE == null) {
                            this.uqE = new View(getContext());
                        }
                        removeFooterView(this.uqE);
                        this.uqE.setLayoutParams(new LayoutParams(-1, i2 - i5));
                        addFooterView(this.uqE, null, false);
                    }
                }
            } catch (Exception e2) {
            }
        }
    }
}
