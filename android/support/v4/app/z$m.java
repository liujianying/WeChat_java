package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.z.l;

class z$m extends l {
    z$m() {
    }

    public final Notification b(z$d z_d) {
        Notification notification = z_d.pQ;
        Context context = z_d.mContext;
        CharSequence charSequence = z_d.ps;
        CharSequence charSequence2 = z_d.pt;
        PendingIntent pendingIntent = z_d.pu;
        PendingIntent pendingIntent2 = z_d.pv;
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        notification.fullScreenIntent = pendingIntent2;
        if (z_d.mPriority > 0) {
            notification.flags |= 128;
        }
        return notification;
    }
}
