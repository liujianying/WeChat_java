package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.LinearLayout;

final class b {
    LinearLayout mVA;
    LinearLayout mVB;
    LinearLayout mVC;
    LinearLayout mVy;
    LinearLayout mVz;

    b() {
    }

    public final void La(String str) {
        if (str.equals("downloading")) {
            this.mVy.setVisibility(0);
            this.mVz.setVisibility(8);
            this.mVA.setVisibility(8);
            this.mVB.setVisibility(8);
            this.mVC.setVisibility(8);
        } else if (str.equals("downloaded")) {
            this.mVy.setVisibility(8);
            this.mVz.setVisibility(0);
            this.mVA.setVisibility(8);
            this.mVB.setVisibility(8);
            this.mVC.setVisibility(8);
        } else if (str.equals("undownloaded")) {
            this.mVy.setVisibility(8);
            this.mVz.setVisibility(8);
            this.mVA.setVisibility(0);
            this.mVB.setVisibility(8);
            this.mVC.setVisibility(8);
        } else if (str.equals("using")) {
            this.mVy.setVisibility(8);
            this.mVz.setVisibility(8);
            this.mVA.setVisibility(8);
            this.mVB.setVisibility(0);
            this.mVC.setVisibility(8);
        } else if (str.equals("canceling")) {
            this.mVy.setVisibility(8);
            this.mVz.setVisibility(8);
            this.mVA.setVisibility(8);
            this.mVB.setVisibility(8);
            this.mVC.setVisibility(0);
        }
    }
}
