package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.card.ui.m.1;

class m$1$1 implements OnClickListener {
    final /* synthetic */ String hGV;
    final /* synthetic */ 1 hGW;

    m$1$1(1 1, String str) {
        this.hGW = 1;
        this.hGV = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("tel:" + this.hGV));
        m.a(this.hGW.hGU).startActivity(intent);
    }
}
