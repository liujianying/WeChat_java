package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;

class b$15 implements OnClickListener {
    final /* synthetic */ Context dhl;
    final /* synthetic */ String dhq;

    b$15(Context context, String str) {
        this.dhl = context;
        this.dhq = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ((ClipboardManager) this.dhl.getSystemService("clipboard")).setText(this.dhq);
    }
}
