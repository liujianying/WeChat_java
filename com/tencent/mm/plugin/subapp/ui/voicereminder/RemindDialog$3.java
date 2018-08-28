package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.subapp.c.d;

class RemindDialog$3 implements OnClickListener {
    final /* synthetic */ RemindDialog otT;

    RemindDialog$3(RemindDialog remindDialog) {
        this.otT = remindDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d bGs = d.bGs();
        if (bGs != null) {
            bGs.ix(RemindDialog.c(this.otT));
        }
        this.otT.finish();
    }
}
