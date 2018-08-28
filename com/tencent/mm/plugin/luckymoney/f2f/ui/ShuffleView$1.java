package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class ShuffleView$1 implements OnLayoutChangeListener {
    final /* synthetic */ ShuffleView kPn;

    ShuffleView$1(ShuffleView shuffleView) {
        this.kPn = shuffleView;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ShuffleView.a(this.kPn);
        ShuffleView shuffleView = this.kPn;
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 < shuffleView.kPc) {
                shuffleView.A((View) shuffleView.kOO.get(i10), i10);
                i9 = i10 + 1;
            } else {
                this.kPn.removeOnLayoutChangeListener(this);
                return;
            }
        }
    }
}
