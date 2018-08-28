package com.tencent.mm.plugin.fts.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.a;
import com.tencent.mm.w.a.g;

class FTSEditTextView$6 implements OnClickListener {
    final /* synthetic */ FTSEditTextView jzA;

    FTSEditTextView$6(FTSEditTextView fTSEditTextView) {
        this.jzA = fTSEditTextView;
    }

    public final void onClick(View view) {
        int i = -1;
        if (view.getId() == g.tag_1) {
            i = 0;
        } else if (view.getId() == g.tag_2) {
            i = 1;
        } else if (view.getId() == g.tag_3) {
            i = 2;
        }
        if (FTSEditTextView.h(this.jzA) != null && i >= 0) {
            a h = FTSEditTextView.h(this.jzA);
            FTSEditTextView.b(this.jzA).get(i);
            h.aQC();
        }
    }
}
