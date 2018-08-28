package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.ui.base.h;

class BindLinkedInUI$7 implements OnClickListener {
    final /* synthetic */ BindLinkedInUI eFM;

    BindLinkedInUI$7(BindLinkedInUI bindLinkedInUI) {
        this.eFM = bindLinkedInUI;
    }

    public final void onClick(View view) {
        if (!BindLinkedInUI.b(this.eFM)) {
            BindLinkedInUI.c(this.eFM);
        } else if (BindLinkedInUI.d(this.eFM)) {
            h.a(this.eFM, this.eFM.getString(j.contact_info_linkedin_account_overwrite_binded_account), null, new 1(this), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else {
            BindLinkedInUI.e(this.eFM);
        }
    }
}
