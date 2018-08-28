package com.tencent.mm.plugin.soter.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.d.a.a;

class SoterTestUI$2 implements OnClickListener {
    final /* synthetic */ SoterTestUI onW;

    SoterTestUI$2(SoterTestUI soterTestUI) {
        this.onW = soterTestUI;
    }

    public final void onClick(View view) {
        SoterTestUI.a(this.onW).setText(a.cFA().isSuccess() ? "passed" : "not support");
    }
}
