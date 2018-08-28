package com.tencent.mm.booter.notification.queue;

import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.k.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class NotificationQueue {
    public ParcelNotificationQueue cYZ;

    private void save() {
        if (this.cYZ != null) {
            x.d("MicroMsg.NotificationCustomQueue", "jacks save: %d", new Object[]{Integer.valueOf(this.cYZ.size())});
            if (this.cYZ.isEmpty()) {
                f.Ah().edit().putString("com.tencent.preference.notification.queue", "").apply();
                if (this.cYZ == null) {
                    restore();
                }
                x.d("MicroMsg.NotificationCustomQueue", "jacks _reset: %d", new Object[]{Integer.valueOf(this.cYZ.size())});
            }
        }
    }

    public final synchronized void restore() {
        x.d("MicroMsg.NotificationCustomQueue", "jacks _restore");
        if (this.cYZ == null) {
            this.cYZ = new ParcelNotificationQueue();
        }
        x.d("MicroMsg.NotificationCustomQueue", "jacks _restore: %d", new Object[]{Integer.valueOf(this.cYZ.size())});
    }

    public final synchronized boolean c(NotificationItem notificationItem) {
        boolean remove;
        if (this.cYZ == null) {
            restore();
        }
        remove = this.cYZ.remove(notificationItem);
        if (remove) {
            save();
        }
        return remove;
    }

    public final synchronized NotificationItem fv(int i) {
        NotificationItem notificationItem;
        if (this.cYZ == null) {
            restore();
        }
        Iterator it = this.cYZ.iterator();
        while (it.hasNext()) {
            notificationItem = (NotificationItem) it.next();
            if (notificationItem.id == i) {
                break;
            }
        }
        notificationItem = null;
        if (notificationItem != null && this.cYZ.remove(notificationItem)) {
            save();
        }
        return notificationItem;
    }

    public final synchronized boolean d(NotificationItem notificationItem) {
        boolean add;
        if (this.cYZ == null) {
            restore();
        }
        add = this.cYZ.add(notificationItem);
        if (add) {
            save();
        }
        return add;
    }
}
