package com.tencent.mm.plugin.exdevice.service;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public static boolean de(Context context) {
        if (k.bA(context)) {
            x.i("MicroMsg.exdevice.ExDeviceServiceHelper", "fully exited, no need to start service");
            return false;
        }
        Intent intent = new Intent(context, ExDeviceService.class);
        intent.setFlags(268435456);
        context.startService(intent);
        return true;
    }
}
