package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.os.Process;
import com.tencent.mm.modelmulti.m.a;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

class e$3 implements a {
    final /* synthetic */ e kmH;
    final /* synthetic */ com.tencent.tinker.lib.e.a kmI;
    final /* synthetic */ Context val$context;

    e$3(e eVar, Context context, com.tencent.tinker.lib.e.a aVar) {
        this.kmH = eVar;
        this.val$context = context;
        this.kmI = aVar;
    }

    public final void bL(boolean z) {
        if (!z) {
            com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "app is background now, i can kill quietly", new Object[0]);
            ShareTinkerInternals.ie(this.val$context);
            this.kmI.aWt();
            Process.killProcess(Process.myPid());
        }
    }
}
