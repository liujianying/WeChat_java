package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class DisasterUI$1 implements OnClickListener {
    final /* synthetic */ DisasterUI ePM;
    final /* synthetic */ String val$url;

    DisasterUI$1(DisasterUI disasterUI, String str) {
        this.ePM = disasterUI;
        this.val$url = str;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.DisasterUI", "summerdiz jump link");
        h.mEJ.h(13939, new Object[]{Integer.valueOf(1)});
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.val$url));
        this.ePM.startActivity(intent);
    }
}
