package com.tencent.mm.booter.notification;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class b$1 extends ag {
    final /* synthetic */ b cYv;

    b$1(b bVar, Looper looper) {
        this.cYv = bVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        ad.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", true).apply();
        String string = message.getData().getString("notification.show.talker");
        String string2 = message.getData().getString("notification.show.message.content");
        int i = message.getData().getInt("notification.show.message.type");
        int i2 = message.getData().getInt("notification.show.tipsflag");
        x.i("MicroMsg.MMNotification", "notify need to deal: %s", new Object[]{string});
        try {
            if (message.what == 1) {
                b.a(this.cYv, string, string2, i, i2, true);
            } else {
                b.a(this.cYv, string, string2, i, i2, false);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMNotification", e, "showNotifiHandler", new Object[0]);
        }
    }
}
