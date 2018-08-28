package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.view.View.OnClickListener;

class MallProductSelectAmountView$1 implements OnClickListener {
    final /* synthetic */ MallProductSelectAmountView lTh;

    MallProductSelectAmountView$1(MallProductSelectAmountView mallProductSelectAmountView) {
        this.lTh = mallProductSelectAmountView;
    }

    public final void onClick(View view) {
        if (MallProductSelectAmountView.a(this.lTh) + 1 <= MallProductSelectAmountView.b(this.lTh)) {
            MallProductSelectAmountView.e(this.lTh);
            if (MallProductSelectAmountView.f(this.lTh)) {
                MallProductSelectAmountView.g(this.lTh).setText(MallProductSelectAmountView.a(this.lTh));
            }
            if (MallProductSelectAmountView.c(this.lTh) != null) {
                MallProductSelectAmountView.c(this.lTh).ex(MallProductSelectAmountView.a(this.lTh));
            }
        } else if (MallProductSelectAmountView.c(this.lTh) != null) {
            MallProductSelectAmountView.c(this.lTh).dk(MallProductSelectAmountView.a(this.lTh), MallProductSelectAmountView.d(this.lTh));
        }
    }
}
