package com.tencent.mm.bg;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMWizardActivity;

class d$1 implements a {
    final /* synthetic */ String qVb;
    final /* synthetic */ String qVg;
    final /* synthetic */ Context val$context;
    final /* synthetic */ Intent val$intent;

    d$1(Intent intent, String str, String str2, Context context) {
        this.val$intent = intent;
        this.qVb = str;
        this.qVg = str2;
        this.val$context = context;
    }

    public final void onDone() {
        Intent intent = this.val$intent == null ? new Intent() : this.val$intent;
        intent.setClassName(ad.getPackageName(), this.qVg.startsWith(".") ? (ad.chX() + ".plugin." + this.qVb) + this.qVg : this.qVg);
        MMWizardActivity.D(this.val$context, intent);
    }
}
