package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class JDRemindDialog$2 implements OnClickListener {
    final /* synthetic */ JDRemindDialog oqC;

    JDRemindDialog$2(JDRemindDialog jDRemindDialog) {
        this.oqC = jDRemindDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.oqC.finish();
    }
}
