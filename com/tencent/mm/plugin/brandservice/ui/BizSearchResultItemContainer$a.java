package com.tencent.mm.plugin.brandservice.ui;

import android.view.View;

class BizSearchResultItemContainer$a {
    View hoT;
    View hoU;
    View hoV;

    private BizSearchResultItemContainer$a() {
    }

    /* synthetic */ BizSearchResultItemContainer$a(byte b) {
        this();
    }

    public final void nw(int i) {
        switch (i) {
            case 1:
                u(true, false);
                return;
            case 2:
                u(false, true);
                return;
            case 3:
                u(false, false);
                return;
            default:
                u(false, false);
                return;
        }
    }

    private void u(boolean z, boolean z2) {
        int i;
        int i2 = 0;
        View view = this.hoT;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        this.hoU.setVisibility(8);
        View view2 = this.hoV;
        if (!z2) {
            i2 = 8;
        }
        view2.setVisibility(i2);
    }
}
