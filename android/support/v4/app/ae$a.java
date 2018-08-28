package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ac.a;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

public class ae$a implements x, y {
    private final Bundle mExtras;
    private Builder qg;
    private List<Bundle> ql = new ArrayList();

    public ae$a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2) {
        boolean z5;
        Builder lights = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        if ((notification.flags & 2) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        lights = lights.setOngoing(z5);
        if ((notification.flags & 8) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        lights = lights.setOnlyAlertOnce(z5);
        if ((notification.flags & 16) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        lights = lights.setAutoCancel(z5).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & 128) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.qg = lights.setFullScreenIntent(pendingIntent2, z5).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
        this.mExtras = new Bundle();
        if (bundle != null) {
            this.mExtras.putAll(bundle);
        }
        if (z3) {
            this.mExtras.putBoolean("android.support.localOnly", true);
        }
        if (str != null) {
            this.mExtras.putString("android.support.groupKey", str);
            if (z4) {
                this.mExtras.putBoolean("android.support.isGroupSummary", true);
            } else {
                this.mExtras.putBoolean("android.support.useSideChannel", true);
            }
        }
        if (str2 != null) {
            this.mExtras.putString("android.support.sortKey", str2);
        }
    }

    public final void a(a aVar) {
        this.ql.add(ae.b(this.qg, aVar));
    }

    public final Builder bx() {
        return this.qg;
    }

    public final Notification build() {
        Notification build = this.qg.build();
        Bundle a = ae.a(build);
        Bundle bundle = new Bundle(this.mExtras);
        for (String str : this.mExtras.keySet()) {
            if (a.containsKey(str)) {
                bundle.remove(str);
            }
        }
        a.putAll(bundle);
        SparseArray h = ae.h(this.ql);
        if (h != null) {
            ae.a(build).putSparseParcelableArray("android.support.actionExtras", h);
        }
        return build;
    }
}
