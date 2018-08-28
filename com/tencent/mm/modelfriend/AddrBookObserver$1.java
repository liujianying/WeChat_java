package com.tencent.mm.modelfriend;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.modelfriend.AddrBookObserver.AddrBookService;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Random;

class AddrBookObserver$1 extends ag {
    AddrBookObserver$1(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        Context context = (Context) message.obj;
        if (AddrBookObserver.Og() == null) {
            AddrBookObserver.o(new Intent());
            AddrBookObserver.Og().setClass(context, AddrBookService.class);
        }
        AddrBookObserver.Og().putExtra(AddrBookService.dRy, new Random(System.currentTimeMillis()).nextFloat());
        try {
            x.i("MicroMsg.AddrBookObserver", "time's up, start AddrBookObserver, session:%f", new Object[]{Float.valueOf(new Random(System.currentTimeMillis()).nextFloat())});
            context.startService(AddrBookObserver.Og());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AddrBookObserver", e, "startService failed", new Object[0]);
        }
    }
}
