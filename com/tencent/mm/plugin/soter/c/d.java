package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.g.a.cm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends c<cm> {
    private static String TAG = "MicroMsg.SoterDynamicConfigUpdatedEventListener";

    public d() {
        this.sFo = cm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i(TAG, "alvinluo dynamic config updated.");
        h.bFi();
        return true;
    }
}
