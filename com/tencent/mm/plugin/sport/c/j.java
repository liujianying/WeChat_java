package com.tencent.mm.plugin.sport.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.booter.MMReceivers.a;
import com.tencent.mm.sdk.platformtools.x;

public final class j implements a {
    public final void onReceive(Context context, Intent intent) {
        x.i("MicroMsg.Sport.SportRebootReceiverImpl", "onReceive, save rebootTime = %d %s", new Object[]{Long.valueOf(r0), n.bx(System.currentTimeMillis())});
        i.N(205, r0);
    }
}
