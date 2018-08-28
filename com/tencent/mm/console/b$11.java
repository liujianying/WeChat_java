package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;

class b$11 implements OnClickListener {
    final /* synthetic */ Context dhl;
    final /* synthetic */ String dho;

    b$11(Context context, String str) {
        this.dhl = context;
        this.dho = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ((ClipboardManager) this.dhl.getSystemService("clipboard")).setText(this.dho);
    }
}
