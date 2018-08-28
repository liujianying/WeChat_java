package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.ag;
import android.support.v4.app.ag.f;
import android.support.v4.app.z;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public class NotificationItem implements Parcelable {
    public static final Creator<NotificationItem> CREATOR = new Creator<NotificationItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new NotificationItem(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new NotificationItem[i];
        }
    };
    private final String TAG;
    private Bitmap b;
    PendingIntent cYN;
    public String cYO;
    public long cYP;
    public int cYQ;
    public boolean cYR;
    public int cYS;
    public int cYT;
    public int id;
    Notification pQ;

    public NotificationItem(int i, String str, Notification notification) {
        this(i, str, notification, true);
    }

    public NotificationItem(int i, Notification notification, boolean z) {
        this(i, null, notification, z);
    }

    public NotificationItem(Notification notification, boolean z) {
        this(-1, notification, z);
    }

    @TargetApi(11)
    private NotificationItem(int i, String str, Notification notification, boolean z) {
        this.TAG = "MicroMsg.NotificationItem";
        this.id = -1;
        this.cYP = 0;
        this.cYQ = 0;
        this.cYR = true;
        this.cYS = 0;
        this.cYT = 0;
        this.id = i;
        this.cYO = str;
        if (VERSION.SDK_INT >= 11) {
            this.b = notification.largeIcon;
        }
        this.pQ = notification;
        this.cYR = z;
        this.cYS = 0;
    }

    public final synchronized void clear() {
        if (!(this.b == null || this.b.isRecycled())) {
            x.i("MicroMsg.NotificationItem", "recycle bitmap:%s", new Object[]{this.b.toString()});
            this.b.recycle();
        }
        this.pQ = null;
        this.b = null;
        this.cYN = null;
    }

    public final synchronized int a(g gVar) {
        int i;
        NotificationItem notificationItem = null;
        synchronized (this) {
            this.id = this.id == -1 ? b.yb().aU(this.cYR) : this.id;
            Context context = ad.getContext();
            if (context == null) {
                x.e("MicroMsg.NotificationItem", "error, show notification but MMApplicationContext.getContext() == null");
                i = -1;
            } else if (this.pQ == null) {
                x.e("MicroMsg.NotificationItem", "error, show notification but mNotification == null");
                i = -1;
            } else {
                NotificationItem notificationItem2;
                b yb = b.yb();
                String str = this.cYO;
                if (ai.oW(str)) {
                    notificationItem2 = null;
                } else {
                    Iterator it = yb.iterator();
                    while (it.hasNext()) {
                        notificationItem2 = (NotificationItem) it.next();
                        if (notificationItem2 != null && notificationItem2.cYO != null && notificationItem2.cYO.equals(str)) {
                            break;
                        }
                    }
                    notificationItem2 = null;
                }
                if (notificationItem2 != null) {
                    b yb2 = b.yb();
                    x.d("MicroMsg.Notification.Queue", "mark: %d", new Object[]{Integer.valueOf(notificationItem2.id)});
                    yb2.mark = r7;
                }
                if (!(notificationItem2 == null || notificationItem2.pQ.tickerText == null || this.pQ.tickerText == null || !notificationItem2.pQ.tickerText.equals(this.pQ.tickerText))) {
                    this.pQ.tickerText += " ";
                }
                yb = b.yb();
                if (this == null) {
                    x.e("MicroMsg.Notification.Queue", "notification item null when put");
                } else if (this.id == -1) {
                    x.e("MicroMsg.Notification.Queue", "notification id = -1(NotificationItem.INVALID_ID) when put");
                } else {
                    if (yb.mark > 0) {
                        if (yb.mark == this.id) {
                            x.d("MicroMsg.Notification.Queue", "remove mark: %d", new Object[]{Integer.valueOf(yb.mark)});
                            yb.remove(yb.mark);
                        }
                        yb.mark = -1;
                    }
                    yb.remove(this.id);
                    if (yb.size() >= 5) {
                        notificationItem = yb.yc();
                    }
                    yb.cZa.d(this);
                    yb.cZb.b(this);
                    x.i("MicroMsg.Notification.Queue", "put item: %d, queuesize: %d", new Object[]{Integer.valueOf(this.id), Integer.valueOf(yb.size())});
                }
                if (notificationItem != null) {
                    b.yb().cancel(notificationItem.id);
                }
                this.cYT = d.a(this.pQ, gVar);
                if (context != null) {
                    if (this.pQ == null) {
                        x.e("MicroMsg.NotificationItem", "error, notify but mNotification == null");
                    } else {
                        Context context2 = ad.getContext();
                        if (context2 == null) {
                            x.e("MicroMsg.NotificationItem", "error, safeCheck but MMApplicationContext.getContext() == null");
                        } else if (this.pQ == null) {
                            x.e("MicroMsg.NotificationItem", "error, safeCheck but mNotification == null");
                        } else {
                            if (context2.getResources().getDrawable(this.pQ.icon) == null) {
                                this.pQ.icon = R.g.icon;
                            }
                        }
                        x.i("MicroMsg.NotificationItem", "notificaiton.defaults: %d, notification.sound: %s, notification.vibrate: %s", new Object[]{Integer.valueOf(this.pQ.defaults), this.pQ.sound, g.c(this.pQ.vibrate)});
                        try {
                            if (e.yk() == 1 && this.pQ.defaults != 2 && this.pQ.vibrate == null) {
                                this.pQ.defaults = 0;
                                this.pQ.sound = null;
                                x.i("MicroMsg.NotificationItem", "mode == vibrate & wechat shake is close, so notification switch to silent");
                            }
                            ag L = ag.L(ad.getContext());
                            int i2 = this.id;
                            Notification notification = this.pQ;
                            Bundle a = z.a(notification);
                            Object obj = (a == null || !a.getBoolean("android.support.useSideChannel")) ? null : 1;
                            if (obj != null) {
                                L.a(new f(L.mContext.getPackageName(), i2, notification));
                                ag.qu.a(L.qr, i2);
                            } else {
                                ag.qu.a(L.qr, i2, notification);
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.NotificationItem", e, "Notification Exception?", new Object[0]);
                        }
                        if (this.cYP != 0) {
                            c.aI(this.cYP);
                        }
                    }
                }
                i = this.id;
            }
        }
        return i;
    }

    private NotificationItem(Parcel parcel) {
        this.TAG = "MicroMsg.NotificationItem";
        this.id = -1;
        this.cYP = 0;
        this.cYQ = 0;
        this.cYR = true;
        this.cYS = 0;
        this.cYT = 0;
        if (parcel != null) {
            boolean z;
            this.id = parcel.readInt();
            this.cYO = parcel.readString();
            this.b = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
            this.pQ = (Notification) parcel.readParcelable(Notification.class.getClassLoader());
            this.cYN = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.cYR = z;
            this.cYP = parcel.readLong();
            this.cYQ = parcel.readInt();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        parcel.writeInt(this.id);
        parcel.writeString(this.cYO == null ? "" : this.cYO);
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.pQ, 0);
        parcel.writeParcelable(this.cYN, 0);
        if (this.cYR) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeLong(this.cYP);
        parcel.writeInt(this.cYQ);
    }

    public String toString() {
        return "id: " + this.id + ",msgId: " + this.cYP + ",userName: " + this.cYO + ",unreadCount: " + this.cYQ;
    }
}
