package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ah implements g {
    HashMap<String, l> iII = new HashMap();

    static /* synthetic */ void a(ah ahVar, int i) {
        if (ahVar.iII == null || ahVar.iII.size() == 0) {
            x.i("MicroMsg.SnsExtCache", "nothing need to pushto snsext");
            return;
        }
        long dO;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = null;
        if (af.FO() != null) {
            obj = 1;
            dO = af.FO().dO(Thread.currentThread().getId());
        } else {
            dO = 0;
        }
        x.d("MicroMsg.SnsExtCache", "writeNums " + i + " " + dO);
        LinkedList linkedList = new LinkedList();
        for (String str2 : ahVar.iII.keySet()) {
            linkedList.add(str2);
            if (linkedList.size() >= i) {
                break;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            str2 = (String) it.next();
            if (ahVar.iII.containsKey(str2) && !af.bxX()) {
                af.bys().b((l) ahVar.iII.get(str2));
                ahVar.iII.remove(str2);
            }
        }
        if (obj != null) {
            af.FO().gp(dO);
        }
        x.d("MicroMsg.SnsExtCache", "wirtes times : " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final l Mj(String str) {
        return (l) this.iII.get(str);
    }

    public final boolean byE() {
        af.bxY().post(new Runnable() {
            public final void run() {
                if (ah.this.iII.size() > 50) {
                    ah.a(ah.this, 10);
                }
            }
        });
        return true;
    }

    public final boolean byF() {
        af.bxY().post(new 2(this));
        return true;
    }

    public final boolean a(final l lVar) {
        if (lVar == null || bi.oW(lVar.field_userName)) {
            return false;
        }
        af.bxY().post(new Runnable() {
            public final void run() {
                ah.this.iII.put(lVar.field_userName, lVar);
            }
        });
        return true;
    }
}
