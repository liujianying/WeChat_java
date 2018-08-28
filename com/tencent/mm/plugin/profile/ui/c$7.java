package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.bi;

class c$7 implements OnClickListener {
    final /* synthetic */ String hGV;
    final /* synthetic */ c lVT;

    c$7(c cVar, String str) {
        this.lVT = cVar;
        this.hGV = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("tel:" + this.hGV));
        if (bi.k(this.lVT.bGc, intent)) {
            this.lVT.bGc.startActivity(intent);
        }
    }
}
