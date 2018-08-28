package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.ui.base.h;

class BindMContactIntroUI$24 implements OnClickListener {
    final /* synthetic */ BindMContactIntroUI eGe;

    BindMContactIntroUI$24(BindMContactIntroUI bindMContactIntroUI) {
        this.eGe = bindMContactIntroUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (BindMContactIntroUI.e(this.eGe) != null && !BindMContactIntroUI.e(this.eGe).equals("")) {
            g.DF().a(new y(y.eKQ), 0);
            BindMContactIntroUI bindMContactIntroUI = this.eGe;
            BindMContactIntroUI bindMContactIntroUI2 = this.eGe;
            this.eGe.getString(j.app_tip);
            BindMContactIntroUI.a(bindMContactIntroUI, h.a(bindMContactIntroUI2, this.eGe.getString(j.app_loading), true, new 1(this)));
        }
    }
}
