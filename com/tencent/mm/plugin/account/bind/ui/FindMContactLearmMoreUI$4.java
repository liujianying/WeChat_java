package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;

class FindMContactLearmMoreUI$4 implements OnCancelListener {
    final /* synthetic */ FindMContactLearmMoreUI eHR;

    FindMContactLearmMoreUI$4(FindMContactLearmMoreUI findMContactLearmMoreUI) {
        this.eHR = findMContactLearmMoreUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (FindMContactLearmMoreUI.e(this.eHR) != null) {
            g.DF().b(d.CTRL_INDEX, FindMContactLearmMoreUI.e(this.eHR));
            FindMContactLearmMoreUI.f(this.eHR);
        }
    }
}
