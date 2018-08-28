package com.tencent.mm.ui.base;

import android.content.Intent;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ad;

public final class x {
    public static void b(boolean z, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.setAction(z ? "com.tencent.mm.ui.ACTION_ACTIVE" : "com.tencent.mm.ui.ACTION_DEACTIVE");
        intent.putExtra("_application_context_process_", ad.getProcessName());
        intent.putExtra("process_id", Process.myPid());
        intent.putExtra("process_is_mm", ad.cic());
        ad.getContext().sendBroadcast(intent, "com.tencent.mm.permission.MM_MESSAGE");
    }
}
