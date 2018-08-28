package com.tencent.mm.modelfriend;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class AddrBookObserver extends ContentObserver {
    private static boolean dRw = false;
    private static Intent dRx;
    private static ag handler = new 1(Looper.getMainLooper());
    private final Context context;

    public AddrBookObserver(Context context) {
        super(ag.fetchFreeHandler());
        this.context = context;
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        x.i("MicroMsg.AddrBookObserver", "address book changed, start sync after 20 second");
        if (dRw) {
            x.e("MicroMsg.AddrBookObserver", "isSyncing:" + dRw + ", is time to sync:true , return");
            return;
        }
        handler.removeMessages(0);
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = this.context;
        obtainMessage.what = 0;
        handler.sendMessageDelayed(obtainMessage, 20000);
    }
}
