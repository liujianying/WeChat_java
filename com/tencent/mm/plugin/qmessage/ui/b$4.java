package com.tencent.mm.plugin.qmessage.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.bg.d;

class b$4 implements OnClickListener {
    final /* synthetic */ b mbL;

    b$4(b bVar) {
        this.mbL = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d.a(this.mbL.context, "account", "com.tencent.mm.plugin.account.bind.ui.BindQQUI", null);
    }
}
