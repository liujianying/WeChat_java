package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class MMTagPanel$8 implements OnClickListener {
    final /* synthetic */ MMTagPanel txS;

    MMTagPanel$8(MMTagPanel mMTagPanel) {
        this.txS = mMTagPanel;
    }

    public final void onClick(View view) {
        if (((Integer) view.getTag()).intValue() == 0) {
            this.txS.a((TextView) view, true, false);
            if (MMTagPanel.e(this.txS) != null) {
                view.post(new 1(this, view));
            }
        } else if (!MMTagPanel.f(this.txS) || MMTagPanel.c(this.txS)) {
            this.txS.a((TextView) view, false, false);
            if (MMTagPanel.e(this.txS) != null) {
                view.post(new 2(this, view));
            }
        } else if (MMTagPanel.d(this.txS) == null) {
            MMTagPanel.a(this.txS, MMTagPanel.a(this.txS, ((TextView) view).getText().toString()));
            if (MMTagPanel.d(this.txS) != null) {
                this.txS.a(MMTagPanel.d(this.txS).tye, false, true);
            }
        } else if (MMTagPanel.d(this.txS).tye == view) {
            MMTagPanel.a(this.txS, null);
            this.txS.a((TextView) view, false, false);
            if (MMTagPanel.e(this.txS) != null) {
                view.post(new 3(this, view));
            }
        } else {
            this.txS.crR();
            MMTagPanel.a(this.txS, MMTagPanel.a(this.txS, ((TextView) view).getText().toString()));
            this.txS.a(MMTagPanel.d(this.txS).tye, false, true);
        }
    }
}
