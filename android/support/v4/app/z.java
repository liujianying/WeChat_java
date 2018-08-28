package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.aa.a;
import android.support.v4.app.ac.b;
import android.widget.RemoteViews;

public final class z {
    private static final i pl;

    protected static class e {
        protected e() {
        }
    }

    static class j extends q {
        j() {
        }

        public Notification b(d dVar) {
            y aVar = new a(dVar.mContext, dVar.pQ, dVar.ps, dVar.pt, dVar.py, dVar.pw, dVar.pz, dVar.pu, dVar.pv, dVar.px, dVar.pE, dVar.pF, dVar.pG, dVar.pA, dVar.pB, dVar.mPriority, dVar.pD, dVar.pL, dVar.pR, dVar.mExtras, dVar.pH, dVar.pI, dVar.pJ);
            z.a((x) aVar, dVar.pK);
            z.a(aVar, dVar.pC);
            return aVar.build();
        }
    }

    static class l implements i {
        l() {
        }

        public Notification b(d dVar) {
            Notification notification = dVar.pQ;
            notification.setLatestEventInfo(dVar.mContext, dVar.ps, dVar.pt, dVar.pu);
            if (dVar.mPriority > 0) {
                notification.flags |= 128;
            }
            return notification;
        }

        public Bundle a(Notification notification) {
            return null;
        }

        public Bundle a(b bVar) {
            return null;
        }
    }

    static class n extends l {
        n() {
        }

        public final Notification b(d dVar) {
            Context context = dVar.mContext;
            Notification notification = dVar.pQ;
            CharSequence charSequence = dVar.ps;
            CharSequence charSequence2 = dVar.pt;
            CharSequence charSequence3 = dVar.py;
            RemoteViews remoteViews = dVar.pw;
            int i = dVar.pz;
            PendingIntent pendingIntent = dVar.pu;
            return new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.pv, (notification.flags & 128) != 0).setLargeIcon(dVar.px).setNumber(i).getNotification();
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            pl = new k();
        } else if (VERSION.SDK_INT >= 20) {
            pl = new j();
        } else if (VERSION.SDK_INT >= 19) {
            pl = new q();
        } else if (VERSION.SDK_INT >= 16) {
            pl = new p();
        } else if (VERSION.SDK_INT >= 14) {
            pl = new o();
        } else if (VERSION.SDK_INT >= 11) {
            pl = new n();
        } else if (VERSION.SDK_INT >= 9) {
            pl = new m();
        } else {
            pl = new l();
        }
    }

    public static Bundle a(Notification notification) {
        return pl.a(notification);
    }
}
