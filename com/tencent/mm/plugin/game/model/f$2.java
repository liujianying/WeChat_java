package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.g.a;

class f$2 implements Runnable {
    final /* synthetic */ f jLD;
    final /* synthetic */ WXMediaMessage jLE;
    final /* synthetic */ a jLF;
    final /* synthetic */ Context val$context;

    f$2(Context context, f fVar, WXMediaMessage wXMediaMessage, a aVar) {
        this.val$context = context;
        this.jLD = fVar;
        this.jLE = wXMediaMessage;
        this.jLF = aVar;
    }

    public final void run() {
        g.a(this.val$context, this.jLD.field_packageName, this.jLE, this.jLD.field_appId, this.jLD.field_openId, 0, this.jLF, null);
    }
}
