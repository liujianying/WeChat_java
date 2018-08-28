package com.tencent.mm.bg;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMWizardActivity;

class d$7 implements a {
    final /* synthetic */ String qVb;
    final /* synthetic */ String qVg;
    final /* synthetic */ Intent qVj;
    final /* synthetic */ Context val$context;
    final /* synthetic */ Intent val$intent;

    d$7(Intent intent, String str, String str2, Context context, Intent intent2) {
        this.val$intent = intent;
        this.qVb = str;
        this.qVg = str2;
        this.val$context = context;
        this.qVj = intent2;
    }

    public final void onDone() {
        Intent intent = this.val$intent == null ? new Intent() : this.val$intent;
        intent.setClassName(ad.getPackageName(), this.qVg.startsWith(".") ? (ad.chX() + ".plugin." + this.qVb) + this.qVg : this.qVg);
        MMWizardActivity.b(this.val$context, intent, this.qVj);
    }
}
