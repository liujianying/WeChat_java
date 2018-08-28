package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public abstract class BasePanelKeybordLayout extends KeyboardLinearLayout {
    private int qMH = -1;
    private a tgV = null;

    public abstract List<View> getPanelView();

    public BasePanelKeybordLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BasePanelKeybordLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnMeasureListener(a aVar) {
        this.tgV = aVar;
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        x.d("MicroMsg.BasePanelKeybordLayout", "onMeasure, width: %d, height: %d", new Object[]{Integer.valueOf(size), Integer.valueOf(size2)});
        if (size2 >= 0) {
            if (this.qMH < 0) {
                this.qMH = size2;
            } else {
                int i3 = this.qMH - size2;
                this.qMH = size2;
                if (i3 != 0) {
                    List<View> panelView = getPanelView();
                    if (panelView != null) {
                        for (View view : panelView) {
                            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                            if (layoutParams == null) {
                                break;
                            }
                            int i4 = layoutParams.height < 0 ? 0 : layoutParams.height - i3;
                            if (i4 < 0) {
                                i4 = 0;
                            }
                            int s = j.s(ad.getContext(), true);
                            int fA = j.fA(getContext());
                            if (j.Ag() > 0 && size2 >= j.Ag()) {
                                i4 = fA;
                            }
                            if (i4 > 0 && i4 < s && view.getVisibility() != 0) {
                                i4 = 0;
                            }
                            if (i4 > fA) {
                                i4 = fA;
                            }
                            if (i4 > 0 && i4 < fA) {
                                i4 = fA;
                            }
                            x.d("MicroMsg.BasePanelKeybordLayout", "oldHeight: %d, offset: %d newHeight: %d, validPanelHeight: %d", new Object[]{Integer.valueOf(layoutParams.height), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(fA)});
                            layoutParams.height = i4;
                            view.setLayoutParams(layoutParams);
                        }
                    }
                }
            }
        }
        super.onMeasure(i, i2);
    }
}
