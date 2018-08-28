package com.tencent.mm.plugin.appbrand.appusage;

import android.os.DeadObjectException;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.ipcinvoker.e.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class h$b$2 implements b {
    final /* synthetic */ h.b fly;
    final /* synthetic */ a flz;

    h$b$2(h.b bVar, a aVar) {
        this.fly = bVar;
        this.flz = aVar;
    }

    public final void d(Exception exception) {
        if (exception instanceof DeadObjectException) {
            new ag(Looper.myLooper()).post(new 1(this));
        } else if (exception instanceof RuntimeException) {
            throw ((RuntimeException) exception);
        } else {
            x.e("MicroMsg.AppBrandLocalUsageStorageIPCImpl", "onExceptionOccur(%s)", new Object[]{Log.getStackTraceString(exception)});
        }
    }
}
