package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.account.bind.ui.f.5;

class f$5$1 implements OnCancelListener {
    final /* synthetic */ ab eJf;
    final /* synthetic */ 5 eJg;

    f$5$1(5 5, ab abVar) {
        this.eJg = 5;
        this.eJf = abVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.eJg.eJe.onDetach();
        g.DF().c(this.eJf);
    }
}
