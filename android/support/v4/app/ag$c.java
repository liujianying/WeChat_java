package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;

class ag$c implements ag$b {
    ag$c() {
    }

    public void a(NotificationManager notificationManager, int i) {
        notificationManager.cancel(i);
    }

    public void a(NotificationManager notificationManager, int i, Notification notification) {
        notificationManager.notify(i, notification);
    }

    public int bC() {
        return 1;
    }
}
