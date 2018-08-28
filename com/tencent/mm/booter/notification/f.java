package com.tencent.mm.booter.notification;

import com.tencent.mm.booter.notification.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f {
    public e cYU;

    /* synthetic */ f(byte b) {
        this();
    }

    private f() {
        this.cYU = new e();
    }

    public static boolean a(String str, bd bdVar, int i, boolean z) {
        if (bi.oW(str)) {
            return false;
        }
        return c.a(str, bdVar, i, z);
    }

    public final int a(NotificationItem notificationItem) {
        return this.cYU.a(notificationItem, null);
    }

    public static void n(int i, String str) {
        ArrayList arrayList;
        x.i("MicroMsg.Notification.AppMsg.Handle", "refreshTotalUnread, %d, %s", new Object[]{Integer.valueOf(i), str});
        if (i == -1) {
            i = com.tencent.mm.k.f.AQ();
        }
        c.fs(i);
        if (str == null || str.length() <= 0) {
            arrayList = new ArrayList();
            List AP = com.tencent.mm.k.f.AP();
            if (AP == null) {
                AP = new ArrayList();
            }
            for (String str2 : AP) {
                a aVar = new a((byte) 0);
                aVar.userName = str2;
                aVar.cYz = com.tencent.mm.k.f.fo(str2);
                arrayList.add(aVar);
            }
        } else {
            a aVar2;
            ArrayList xX = c.xX();
            arrayList = xX == null ? new ArrayList() : xX;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aVar2 = (a) it.next();
                if (aVar2.userName.equals(str)) {
                    arrayList.remove(aVar2);
                    break;
                }
            }
            aVar2 = null;
            if (aVar2 == null) {
                aVar2 = new a((byte) 0);
            }
            aVar2.userName = str;
            aVar2.cYz = com.tencent.mm.k.f.fo(str);
            if (aVar2.cYz == 0 && arrayList.isEmpty()) {
                c.d(null);
                return;
            } else if (aVar2.cYz > 0) {
                arrayList.add(aVar2);
            }
        }
        c.d(arrayList);
    }
}
