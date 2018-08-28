package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;

class BakToPcUI$3 implements OnClickListener {
    final /* synthetic */ BakToPcUI haT;

    BakToPcUI$3(BakToPcUI bakToPcUI) {
        this.haT = bakToPcUI;
    }

    public final void onClick(View view) {
        if (BakToPcUI.b(this.haT) == 0) {
            a.asN().asP().dBM = 2;
            a.asN().asP().IF();
            a.asN().asO().mO(1);
            BakToPcUI.c(this.haT);
        }
    }
}
