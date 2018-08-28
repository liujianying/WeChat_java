package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static boolean v(Context context, String str) {
        if ((!str.equals("noop") || (e.sFE && e.sFD)) && k.bA(context)) {
            x.i("MicroMsg.CoreServiceHelper", "fully exited, no need to start service");
            return false;
        }
        x.d("MicroMsg.CoreServiceHelper", "ensure service running, type=" + str);
        Intent intent = new Intent(context, CoreService.class);
        intent.setFlags(268435456);
        intent.putExtra("START_TYPE", str);
        context.startService(intent);
        return true;
    }
}
