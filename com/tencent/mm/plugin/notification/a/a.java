package com.tencent.mm.plugin.notification.a;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements b {
    private final String TAG = "MicroMsg.NotificationObserver";
    private final int lHi = 50;
    public boolean lHj = false;
    private ag mHandler = new 1(this, Looper.getMainLooper());

    public final void a(int i, m mVar, Object obj) {
        x.i("MicroMsg.NotificationObserver", "event: %d", new Object[]{Integer.valueOf(i)});
        if (!(obj instanceof String) || bi.oW((String) obj)) {
            x.d("MicroMsg.NotificationObserver", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        int i2;
        if (au.HM()) {
            i2 = 0;
        } else {
            au.HU();
            i2 = (int) c.FR().Ye((String) obj).dhP;
        }
        this.mHandler.removeMessages(i2);
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("com.tencent.mm.notification.observer", (String) obj);
        obtain.setData(bundle);
        obtain.what = i2;
        this.mHandler.sendMessageDelayed(obtain, 50);
    }
}
