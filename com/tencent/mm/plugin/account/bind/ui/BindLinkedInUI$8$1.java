package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.bind.a.c;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.8;
import com.tencent.mm.ui.base.h;

class BindLinkedInUI$8$1 implements OnClickListener {
    final /* synthetic */ 8 eFO;

    BindLinkedInUI$8$1(8 8) {
        this.eFO = 8;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c cVar = new c();
        BindLinkedInUI.a(this.eFO.eFM, h.a(this.eFO.eFM, this.eFO.eFM.getString(a$j.loading_tips), false, new 1(this, cVar)));
        g.DF().a(cVar, 0);
    }
}
