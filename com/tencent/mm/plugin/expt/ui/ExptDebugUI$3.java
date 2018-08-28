package com.tencent.mm.plugin.expt.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ExptDebugUI$3 implements OnClickListener {
    final /* synthetic */ ExptDebugUI iIU;

    ExptDebugUI$3(ExptDebugUI exptDebugUI) {
        this.iIU = exptDebugUI;
    }

    public final void onClick(View view) {
        ExptDebugUI.b(this.iIU);
    }
}
