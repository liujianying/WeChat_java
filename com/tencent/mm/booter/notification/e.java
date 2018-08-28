package com.tencent.mm.booter.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.ag;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.Queue;

public final class e extends a {
    public c cYM = new c();
    private Context mContext = ad.getContext();
    private NotificationManager qr = ((NotificationManager) this.mContext.getSystemService("notification"));

    public static void cancel() {
        ag L = ag.L(ad.getContext());
        Queue linkedList = new LinkedList();
        for (Integer num : b.yb().yd()) {
            if (!linkedList.contains(num)) {
                b.yb().a(L, num.intValue());
                linkedList.add(num);
            }
        }
    }
}
