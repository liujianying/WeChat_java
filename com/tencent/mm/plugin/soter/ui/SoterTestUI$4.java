package com.tencent.mm.plugin.soter.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.d.a.a;
import com.tencent.d.a.c.h;

class SoterTestUI$4 implements OnClickListener {
    final /* synthetic */ SoterTestUI onW;

    SoterTestUI$4(SoterTestUI soterTestUI) {
        this.onW = soterTestUI;
    }

    public final void onClick(View view) {
        h cFE = a.cFE();
        if (cFE == null) {
            SoterTestUI.a(this.onW).setText("not passed: no certificate");
        } else {
            SoterTestUI.a(this.onW).setText("model available: " + cFE.toString());
        }
    }
}
