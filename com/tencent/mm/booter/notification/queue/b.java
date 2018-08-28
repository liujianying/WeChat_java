package com.tencent.mm.booter.notification.queue;

import android.os.Build.VERSION;
import android.support.v4.app.ag;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.booter.notification.queue.a.a;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class b implements Iterable<NotificationItem> {
    public NotificationQueue cZa;
    public a cZb;
    public int mark;

    /* synthetic */ b(byte b) {
        this();
    }

    public static final b yb() {
        return a.yf();
    }

    private b() {
        this.mark = -1;
        this.cZa = new NotificationQueue();
        this.cZb = new a();
        restore();
    }

    public final void restore() {
        this.cZa.restore();
        this.cZb.restore();
    }

    public final int size() {
        NotificationQueue notificationQueue = this.cZa;
        if (notificationQueue.cYZ == null) {
            notificationQueue.restore();
        }
        return notificationQueue.cYZ.size();
    }

    public final NotificationItem yc() {
        for (int i = 0; i < size(); i++) {
            NotificationQueue notificationQueue = this.cZa;
            if (notificationQueue.cYZ == null) {
                notificationQueue.restore();
            }
            NotificationItem notificationItem = (NotificationItem) notificationQueue.cYZ.get(i);
            if (notificationItem.cYR) {
                if (this.cZb.aX(notificationItem.id)) {
                    x.d("MicroMsg.NotificationAppMsgQueue", "remove: [%s]", new Object[]{notificationItem.toString()});
                }
                this.cZa.c(notificationItem);
                return notificationItem;
            }
        }
        return null;
    }

    public final void remove(int i) {
        this.cZb.aX(i);
        NotificationItem fv = this.cZa.fv(i);
        if (fv != null) {
            fv.clear();
        }
    }

    public final Queue<Integer> yd() {
        Queue<Integer> linkedList = new LinkedList();
        for (int i = 4097; i < 4102; i++) {
            linkedList.add(Integer.valueOf(i));
        }
        linkedList.addAll(ye());
        return linkedList;
    }

    private Queue<Integer> ye() {
        Queue<Integer> linkedList = new LinkedList();
        Queue<NotificationItem> linkedList2 = new LinkedList();
        NotificationQueue notificationQueue = this.cZa;
        if (notificationQueue.cYZ == null) {
            notificationQueue.restore();
        }
        linkedList2.addAll(notificationQueue.cYZ);
        for (NotificationItem notificationItem : linkedList2) {
            if (notificationItem.cYR) {
                linkedList.add(Integer.valueOf(notificationItem.id));
                x.d("MicroMsg.Notification.Queue", "remove allcustom: %d", new Object[]{Integer.valueOf(notificationItem.id)});
            }
        }
        linkedList2.clear();
        Queue<a> linkedList3 = new LinkedList();
        a aVar = this.cZb;
        if (aVar.cYW == null) {
            aVar.restore();
        }
        linkedList3.addAll(aVar.cYW);
        for (a aVar2 : linkedList3) {
            if (aVar2.cYR) {
                linkedList.add(Integer.valueOf(aVar2.cYX));
                x.d("MicroMsg.Notification.Queue", "remove allcustom: %d", new Object[]{Integer.valueOf(aVar2.cYX)});
            }
        }
        linkedList3.clear();
        return linkedList;
    }

    public final int getId(String str) {
        if (ai.oW(str)) {
            return -1;
        }
        Iterator it = this.cZb.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.userName.equals(str)) {
                return aVar.cYX;
            }
        }
        return -1;
    }

    public final void cancel(int i) {
        a(ag.L(ad.getContext()), i);
    }

    public final void a(ag agVar, int i) {
        ag.qu.a(agVar.qr, i);
        if (VERSION.SDK_INT <= 19) {
            agVar.a(new ag.a(agVar.mContext.getPackageName(), i));
        }
        remove(i);
    }

    public final int eM(String str) {
        int id = getId(str);
        return id > 0 ? id : aU(true);
    }

    public final int aU(boolean z) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = "";
        Iterator it = this.cZb.iterator();
        while (true) {
            str = str2;
            if (!it.hasNext()) {
                break;
            }
            str2 = str + ((a) it.next()).cYX + ",";
        }
        int i = z ? 4097 : 4102;
        while (str.contains(String.valueOf(i))) {
            i++;
        }
        if (i >= 4102 && z) {
            i = 4097;
        }
        x.d("MicroMsg.Notification.Queue", "create id spend: %d, id: %d, isCustomControl: %B", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i), Boolean.valueOf(z)});
        return i;
    }

    public final Iterator<NotificationItem> iterator() {
        NotificationQueue notificationQueue = this.cZa;
        if (notificationQueue.cYZ == null) {
            notificationQueue.restore();
        }
        return notificationQueue.cYZ.iterator();
    }
}
