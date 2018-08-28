package com.tencent.mm.bg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class d$9 implements a {
    final /* synthetic */ String qVb;
    final /* synthetic */ String qVg;
    final /* synthetic */ Bundle rQ;
    final /* synthetic */ Context val$context;
    final /* synthetic */ Intent val$intent;

    d$9(String str, Intent intent, String str2, Context context, Bundle bundle) {
        this.qVb = str;
        this.val$intent = intent;
        this.qVg = str2;
        this.val$context = context;
        this.rQ = bundle;
    }

    public final void onDone() {
        x.d("MicroMsg.PluginHelper", "[DEBUG] onDone Load %s", new Object[]{this.qVb});
        try {
            Intent intent = this.val$intent == null ? new Intent() : this.val$intent;
            String str = this.qVg.startsWith(".") ? (ad.chX() + ".plugin." + this.qVb) + this.qVg : this.qVg;
            intent.setClassName(ad.getPackageName(), str);
            Class.forName(str, false, this.val$context.getClassLoader());
            if (this.val$context instanceof Activity) {
                this.val$context.startActivity(intent, this.rQ);
                return;
            }
            intent.addFlags(268435456);
            this.val$context.startActivity(intent, this.rQ);
        } catch (ClassNotFoundException e) {
            x.e("MicroMsg.PluginHelper", "Class Not Found when startActivity %s", new Object[]{e});
        }
    }
}
