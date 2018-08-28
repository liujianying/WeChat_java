package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;

class FindMContactIntroUI$10 implements OnCancelListener {
    final /* synthetic */ FindMContactIntroUI eHN;

    FindMContactIntroUI$10(FindMContactIntroUI findMContactIntroUI) {
        this.eHN = findMContactIntroUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (FindMContactIntroUI.i(this.eHN) != null) {
            g.DF().b(431, FindMContactIntroUI.i(this.eHN));
            FindMContactIntroUI.j(this.eHN);
        }
    }
}
