package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;

class FindMContactLearmMoreUI$2 implements OnClickListener {
    final /* synthetic */ FindMContactLearmMoreUI eHR;

    FindMContactLearmMoreUI$2(FindMContactLearmMoreUI findMContactLearmMoreUI) {
        this.eHR = findMContactLearmMoreUI;
    }

    public final void onClick(View view) {
        g.Ei().DT().set(12322, Boolean.valueOf(false));
        ((a) g.n(a.class)).syncUploadMContactStatus(true, false);
        FindMContactLearmMoreUI.b(this.eHR);
    }
}
