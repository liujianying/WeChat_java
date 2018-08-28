package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.plugin.subapp.c.d;

class RemindDialog$2 implements OnClickListener {
    final /* synthetic */ RemindDialog otT;

    RemindDialog$2(RemindDialog remindDialog) {
        this.otT = remindDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d bGs = d.bGs();
        if (bGs != null) {
            bGs.ix(RemindDialog.c(this.otT));
        }
        if (s.hC(au.getNotification().xQ())) {
            this.otT.finish();
            return;
        }
        b.ezn.e(new Intent().putExtra("Chat_User", RemindDialog.c(this.otT)), this.otT);
        this.otT.finish();
    }
}
