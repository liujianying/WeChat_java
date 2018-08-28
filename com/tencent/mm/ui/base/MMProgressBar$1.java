package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.al.a;

class MMProgressBar$1 implements a {
    final /* synthetic */ MMProgressBar twn;

    MMProgressBar$1(MMProgressBar mMProgressBar) {
        this.twn = mMProgressBar;
    }

    public final boolean vD() {
        int a = MMProgressBar.a(this.twn) - MMProgressBar.b(this.twn);
        if (a > 0) {
            int i = (int) (((double) a) * 0.6d);
            MMProgressBar mMProgressBar = this.twn;
            int b = MMProgressBar.b(this.twn);
            if (i <= 0) {
                i = 1;
            }
            MMProgressBar.a(mMProgressBar, i + b);
            MMProgressBar.b(this.twn, MMProgressBar.b(this.twn));
            long c = (long) (((MMProgressBar.c(this.twn) - a) * 40) / MMProgressBar.c(this.twn));
            MMProgressBar.d(this.twn).J(c, c);
        }
        return false;
    }
}
