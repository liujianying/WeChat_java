package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ra;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class WorkerProfile$5 extends c<ra> {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$5(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        this.sFo = ra.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ra raVar = (ra) bVar;
        Context context = raVar.cbO.context;
        String str = raVar.cbO.cbP;
        if (!(context == null || bi.oW(str))) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        }
        return false;
    }
}
