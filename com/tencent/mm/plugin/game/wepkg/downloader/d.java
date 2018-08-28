package com.tencent.mm.plugin.game.wepkg.downloader;

import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class d {
    private static volatile d keh;
    private static Object lock = new Object();
    HashMap<String, c> kei = new HashMap();

    public static d aVs() {
        if (keh == null) {
            synchronized (lock) {
                if (keh == null) {
                    keh = new d();
                }
            }
        }
        return keh;
    }

    private d() {
    }

    public final boolean Ee(String str) {
        if (this.kei.containsKey(str)) {
            this.kei.remove(str);
        }
        return true;
    }

    private boolean a(c cVar) {
        if (!this.kei.containsKey(cVar.kdY.kev)) {
            return false;
        }
        cVar.kee = true;
        try {
            if (cVar.kea != null) {
                cVar.kea.disconnect();
            }
            if (cVar.kdZ != null) {
                cVar.kdZ.cancel(false);
            }
        } catch (Exception e) {
            x.i("MicroMsg.Wepkg.WePkgDownloadTask", "stop, " + e.getMessage());
        }
        this.kei.remove(cVar.kdY.kev);
        return true;
    }

    public final boolean aVt() {
        if (this.kei == null || this.kei.size() == 0) {
            return false;
        }
        c cVar;
        Collection<c> values = this.kei.values();
        ArrayList arrayList = new ArrayList();
        for (c cVar2 : values) {
            arrayList.add(cVar2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            cVar2 = (c) it.next();
            if (cVar2.kdY.keB) {
                a(cVar2);
            }
        }
        arrayList.clear();
        return true;
    }
}
