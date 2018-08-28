package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.ay.a;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.location.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p implements a {
    private List<c> avD = new LinkedList();
    private ag handler;
    private b kDW;
    private final String path;

    public p() {
        File file = new File(l.aZm());
        if (!file.exists()) {
            file.mkdirs();
        }
        this.path = l.aZm() + "trackroominfolist.info";
        this.handler = new ag(Looper.getMainLooper());
        if (this.kDW != null) {
            return;
        }
        if (e.cn(this.path)) {
            try {
                this.kDW = (b) new b().aG(e.f(this.path, 0, -1));
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TrackRoomListMgr", e, "", new Object[0]);
                this.kDW = new b();
                return;
            }
        }
        this.kDW = new b();
    }

    public final synchronized void a(c cVar) {
        this.avD.add(cVar);
    }

    public final synchronized void b(c cVar) {
        this.avD.remove(cVar);
    }

    public final synchronized LinkedList<String> ns(String str) {
        LinkedList<String> linkedList;
        Iterator it = this.kDW.kCt.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.location.a.a aVar = (com.tencent.mm.plugin.location.a.a) it.next();
            if (aVar.username.equals(str)) {
                linkedList = (LinkedList) aVar.bUb.clone();
                break;
            }
        }
        linkedList = new LinkedList();
        return linkedList;
    }

    public final synchronized com.tencent.mm.plugin.location.a.a FM(String str) {
        com.tencent.mm.plugin.location.a.a aVar;
        Iterator it = this.kDW.kCt.iterator();
        while (it.hasNext()) {
            aVar = (com.tencent.mm.plugin.location.a.a) it.next();
            if (aVar.username.equals(str)) {
                break;
            }
        }
        aVar = null;
        return aVar;
    }

    public final synchronized void a(String str, LinkedList<String> linkedList, double d, double d2, String str2, String str3, String str4) {
        LinkedList linkedList2;
        com.tencent.mm.plugin.location.a.a aVar;
        if (linkedList2 == null) {
            linkedList2 = new LinkedList();
        }
        x.i("MicroMsg.TrackRoomListMgr", "updateList talk: %s,  size: %d %f %f", new Object[]{str, Integer.valueOf(linkedList2.size()), Double.valueOf(d), Double.valueOf(d2)});
        LinkedList linkedList3 = (LinkedList) linkedList2.clone();
        boolean isEmpty = linkedList3.isEmpty();
        Iterator it = this.kDW.kCt.iterator();
        while (it.hasNext()) {
            aVar = (com.tencent.mm.plugin.location.a.a) it.next();
            if (aVar.username.equals(str)) {
                if (isEmpty) {
                    this.kDW.kCt.remove(aVar);
                } else {
                    aVar.bUb = linkedList3;
                    aVar.kCs = str2;
                    aVar.latitude = d;
                    aVar.longitude = d2;
                }
                aZw();
                T(str, str3, str4);
            }
        }
        if (!isEmpty) {
            aVar = new com.tencent.mm.plugin.location.a.a();
            aVar.username = str;
            aVar.bUb = linkedList3;
            aVar.kCs = str2;
            aVar.latitude = d;
            aVar.longitude = d2;
            this.kDW.kCt.add(aVar);
        }
        aZw();
        T(str, str3, str4);
    }

    private void T(String str, String str2, String str3) {
        for (final c cVar : this.avD) {
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            this.handler.post(new Runnable() {
                public final void run() {
                    cVar.nu(str4);
                }
            });
        }
    }

    private boolean aZw() {
        x.d("MicroMsg.TrackRoomListMgr", "infoFile infolist size %d", new Object[]{Integer.valueOf(this.kDW.kCt.size())});
        if (this.kDW.kCt.isEmpty()) {
            e.deleteFile(this.path);
            return true;
        }
        try {
            byte[] toByteArray = this.kDW.toByteArray();
            e.b(this.path, toByteArray, toByteArray.length);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TrackRoomListMgr", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean nt(String str) {
        return ns(str).size() > 0;
    }

    public final boolean SB() {
        Iterator it = this.kDW.kCt.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.location.a.a aVar = (com.tencent.mm.plugin.location.a.a) it.next();
            x.d("MicroMsg.TrackRoomListMgr", "info :" + aVar.bUb.size());
            Iterator it2 = aVar.bUb.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                x.d("MicroMsg.TrackRoomListMgr", "member :" + str);
                if (str.equals(q.GF())) {
                    x.i("MicroMsg.TrackRoomListMgr", "now is sharing location..");
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean az(String str, String str2) {
        return ns(str).contains(str2);
    }

    public final String SC() {
        if (this.kDW != null) {
            return this.kDW.kCu;
        }
        return "";
    }

    public final void FN(String str) {
        if (this.kDW != null) {
            this.kDW.kCu = str;
        }
        aZw();
    }
}
