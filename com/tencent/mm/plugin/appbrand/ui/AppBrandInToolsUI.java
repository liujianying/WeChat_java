package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.x;

public final class AppBrandInToolsUI extends AppBrandUI {
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final void onDestroy() {
        super.onDestroy();
        try {
            KVCommCrossProcessReceiver.brP();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandInToolsUI", e, "sendKV", new Object[0]);
        }
        d.a(null, true);
    }
}
