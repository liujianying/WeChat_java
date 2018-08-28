package com.tencent.mm.booter.notification.queue;

import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.k.f;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a implements Serializable, Iterable<a> {
    LinkedList<a> cYW;

    public static class a implements Serializable {
        public long bJC = -1;
        public boolean cYR = false;
        public int cYX;
        public int cYY = 0;
        public int cYz;
        public String userName = "";

        public a(int i, long j, String str, int i2, boolean z, int i3) {
            a(i, j, str, i2, z, i3);
        }

        public a(int i, boolean z) {
            this.cYX = i;
            this.cYR = z;
        }

        public final void a(int i, long j, String str, int i2, boolean z, int i3) {
            this.cYX = i;
            this.bJC = j;
            this.userName = str;
            this.cYz = i2;
            this.cYR = z;
            this.cYY = i3;
        }

        public final String toString() {
            return this.userName + " id:" + this.bJC + " unReadCount:" + this.cYz + "　notificationId:" + this.cYX;
        }
    }

    public final String toString() {
        String str = "";
        Iterator it = this.cYW.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            str = str2 + ((a) it.next()).toString() + ";  ";
        }
    }

    public final synchronized void restore() {
        try {
            this.cYW = (LinkedList) c.eN(f.Ah().getString("com.tencent.preference.notification.key.queue", ""));
            if (this.cYW == null) {
                this.cYW = new LinkedList();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NotificationAppMsgQueue", e, "", new Object[0]);
            if (this.cYW == null) {
                this.cYW = new LinkedList();
            }
        } catch (Throwable th) {
            if (this.cYW == null) {
                this.cYW = new LinkedList();
            }
        }
        x.i("MicroMsg.NotificationAppMsgQueue", "restore size:%d, %s", new Object[]{Integer.valueOf(this.cYW.size()), toString()});
    }

    private synchronized void save() {
        if (this.cYW != null) {
            x.d("MicroMsg.NotificationAppMsgQueue", "save: size: %d", new Object[]{Integer.valueOf(this.cYW.size())});
            if (this.cYW.isEmpty()) {
                f.Ah().edit().putString("com.tencent.preference.notification.key.queue", "").apply();
                x.i("MicroMsg.NotificationAppMsgQueue", "reset size:%d, %s", new Object[]{Integer.valueOf(this.cYW.size()), toString()});
            } else {
                try {
                    f.Ah().edit().putString("com.tencent.preference.notification.key.queue", c.a(new LinkedList(this.cYW))).apply();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NotificationAppMsgQueue", e, "", new Object[0]);
                }
                x.i("MicroMsg.NotificationAppMsgQueue", "save size:%d, %s", new Object[]{Integer.valueOf(this.cYW.size()), toString()});
            }
        }
    }

    public final synchronized void b(NotificationItem notificationItem) {
        Object obj = 1;
        synchronized (this) {
            if (notificationItem != null) {
                if (this.cYW == null) {
                    restore();
                }
                aX(notificationItem.id);
                if (!notificationItem.cYR || ai.oW(notificationItem.cYO)) {
                    this.cYW.add(new a(notificationItem.id, notificationItem.cYR));
                    x.d("MicroMsg.NotificationAppMsgQueue", "add: [%s]", new Object[]{notificationItem.toString()});
                } else {
                    Iterator it = this.cYW.iterator();
                    while (it.hasNext()) {
                        Object obj2;
                        a aVar = (a) it.next();
                        if (aVar.userName.equals(notificationItem.cYO)) {
                            aVar.a(notificationItem.id, notificationItem.cYP, notificationItem.cYO, notificationItem.cYQ, notificationItem.cYR, notificationItem.cYS);
                            obj2 = null;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                    if (obj != null) {
                        this.cYW.add(new a(notificationItem.id, notificationItem.cYP, notificationItem.cYO, notificationItem.cYQ, notificationItem.cYR, notificationItem.cYS));
                        x.d("MicroMsg.NotificationAppMsgQueue", "add: [%s]", new Object[]{notificationItem.toString()});
                    }
                }
                save();
            }
        }
    }

    public final synchronized List<Integer> fu(int i) {
        List<Integer> arrayList;
        if (this.cYW == null) {
            restore();
        }
        arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!((aVar.cYY & i) == 0 || arrayList.contains(Integer.valueOf(aVar.cYX)))) {
                arrayList.add(Integer.valueOf(aVar.cYX));
            }
        }
        return arrayList;
    }

    public final synchronized boolean aX(int i) {
        boolean z;
        if (i == -1) {
            z = false;
        } else {
            if (this.cYW == null) {
                restore();
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = this.cYW.iterator();
            Object obj = null;
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.cYX != i) {
                    linkedList.add(aVar);
                } else {
                    obj = 1;
                }
            }
            if (obj != null) {
                this.cYW = linkedList;
                save();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean eL(String str) {
        boolean z;
        x.i("MicroMsg.NotificationAppMsgQueue", "remove username: %s", new Object[]{str});
        if (ai.oW(str)) {
            z = false;
        } else {
            if (this.cYW == null) {
                restore();
            }
            Iterator it = this.cYW.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (str.equals(aVar.userName)) {
                    this.cYW.remove(aVar);
                    save();
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public final Iterator<a> iterator() {
        if (this.cYW == null) {
            restore();
        }
        return this.cYW.iterator();
    }
}
