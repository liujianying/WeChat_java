package com.tencent.mm.bg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class d$11 implements a {
    final /* synthetic */ int ms;
    final /* synthetic */ String qVb;
    final /* synthetic */ String qVg;
    final /* synthetic */ Context val$context;
    final /* synthetic */ Intent val$intent;

    d$11(Intent intent, String str, String str2, Context context, int i) {
        this.val$intent = intent;
        this.qVb = str;
        this.qVg = str2;
        this.val$context = context;
        this.ms = i;
    }

    public final void onDone() {
        Intent intent = this.val$intent == null ? new Intent() : this.val$intent;
        intent.setClassName(ad.getPackageName(), this.qVg.startsWith(".") ? (ad.chX() + ".plugin." + this.qVb) + this.qVg : this.qVg);
        if (this.val$context instanceof Activity) {
            ((Activity) this.val$context).startActivityForResult(intent, this.ms);
            d.f(this.val$context, this.qVg, intent);
            return;
        }
        x.f("MicroMsg.PluginHelper", "context not activity, skipped");
    }
}
