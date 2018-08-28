package com.tencent.mm.plugin.wallet.pwd;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet.pwd.c.2;

class c$2$1 implements OnClickListener {
    final /* synthetic */ 2 phf;

    c$2$1(2 2) {
        this.phf = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c.c(this.phf.phe).putInt("RESET_PWD_USER_ACTION", 2);
        this.phf.phe.a(this.phf.fEY, 0, c.d(this.phf.phe));
    }
}
