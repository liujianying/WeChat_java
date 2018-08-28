package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.R;

class e$1 implements Runnable {
    final /* synthetic */ boolean qsI;
    final /* synthetic */ e qsJ;

    e$1(e eVar, boolean z) {
        this.qsJ = eVar;
        this.qsI = z;
    }

    public final void run() {
        RecyclerView a = e.a(this.qsJ);
        if (a != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.getChildCount()) {
                    View childAt = a.getChildAt(i2);
                    c dd = f.dd(childAt);
                    if (dd != null) {
                        if (dd.qrX != null) {
                            if (this.qsI) {
                                dd.qrX.postInvalidate();
                            }
                        } else if (!(dd.qrY == null || dd.qrZ == null)) {
                            this.qsJ.a((LinearLayout) childAt.findViewById(R.h.other_cover_view), (LinearLayout) childAt.findViewById(R.h.other_up_cover_view), (LinearLayout) childAt.findViewById(R.h.other_down_cover_view), dd.qrY.getPosInDataList());
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
