package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class d$3 implements a {
    final /* synthetic */ Context val$context;
    final /* synthetic */ Intent val$intent;

    d$3(Intent intent, Context context) {
        this.val$intent = intent;
        this.val$context = context;
    }

    public final void x(String str, boolean z) {
        if (z) {
            this.val$intent.putExtra("Chat_User", str);
            try {
                if (this.val$context != null) {
                    this.val$context.startActivity(this.val$intent);
                    return;
                } else {
                    ad.getContext().startActivity(this.val$intent);
                    return;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.DeepLinkHelper", e, "", new Object[]{""});
                return;
            }
        }
        x.e("MicroMsg.DeepLinkHelper", "getContact fail, %s", new Object[]{str});
    }
}
