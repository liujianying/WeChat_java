package com.tencent.mm.booter.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public class NotificationDeleteReceive extends BroadcastReceiver {
    private NotificationDeleteReceive() {
    }

    public void onReceive(Context context, Intent intent) {
        int intExtra;
        try {
            intExtra = intent.getIntExtra("com.tencent.notification.id.key", -1);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Notification.Delete.Receive", e, "", new Object[0]);
            intExtra = -1;
        }
        x.d("MicroMsg.Notification.Delete.Receive", "receive: %d", new Object[]{Integer.valueOf(intExtra)});
        if (intExtra != -1) {
            NotificationItem notificationItem;
            Iterator it = b.yb().iterator();
            while (it.hasNext()) {
                notificationItem = (NotificationItem) it.next();
                if (notificationItem != null && notificationItem.id == intExtra) {
                    break;
                }
            }
            notificationItem = null;
            if (notificationItem == null) {
                x.w("MicroMsg.Notification.Delete.Receive", "receive delete notification: %d, but no item in queue", new Object[]{Integer.valueOf(intExtra)});
                return;
            }
            if (notificationItem.cYN != null) {
                try {
                    notificationItem.cYN.send();
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.NotificationItem", e2, "Delete intent send Exception?", new Object[0]);
                }
            }
            b.yb().remove(intExtra);
        }
    }
}
