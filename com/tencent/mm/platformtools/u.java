package com.tencent.mm.platformtools;

import android.util.SparseBooleanArray;
import com.tencent.mm.bt.h;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class u {
    private static ConcurrentHashMap<Integer, a> evW = new ConcurrentHashMap();

    public static final class a extends h {
        public final boolean evX;
        SparseBooleanArray evY = new SparseBooleanArray();
        private final String path;

        public a(String str, boolean z) {
            x.d("MicroMsg.GeneralDBHelper", "create db %s", str);
            this.evX = z;
            this.path = str;
        }

        public final void iQ(int i) {
            x.d("MicroMsg.GeneralDBHelper", "try close db %d", Integer.valueOf(i));
            this.evY.delete(i);
            if (this.evY.size() <= 0) {
                x.d("MicroMsg.GeneralDBHelper", "close db %d succ", Integer.valueOf(i));
                super.closeDB();
                u.evW.remove(Integer.valueOf(this.path.hashCode()));
            }
        }

        @Deprecated
        public final void closeDB() {
            x.e("MicroMsg.GeneralDBHelper", "forbid to use this method %s", bi.cjd());
            if (this.evY.size() <= 1) {
                super.closeDB();
            }
        }

        @Deprecated
        public final void ex(String str) {
            x.e("MicroMsg.GeneralDBHelper", "forbid to use this method");
            if (this.evY.size() <= 1) {
                super.ex(str);
            }
        }
    }

    public static final a a(int i, String str, HashMap<Integer, d> hashMap, boolean z) {
        boolean z2 = (bi.oW(str) || hashMap == null) ? false : true;
        Assert.assertTrue(z2);
        int hashCode = str.hashCode();
        a aVar = (a) evW.get(Integer.valueOf(hashCode));
        if (aVar == null) {
            aVar = new a(str, z);
            if (z) {
                g.Eg();
                if (!aVar.a("", str, "", (long) com.tencent.mm.kernel.a.Df(), q.zy(), hashMap, true)) {
                    throw new b((byte) 0);
                }
            } else if (!aVar.b(str, (HashMap) hashMap, false)) {
                throw new b((byte) 0);
            }
            evW.put(Integer.valueOf(hashCode), aVar);
        } else {
            Assert.assertTrue(z == aVar.evX);
            long dO = aVar.dO(-1);
            for (d xb : hashMap.values()) {
                for (String str2 : xb.xb()) {
                    x.d("MicroMsg.GeneralDBHelper", "init sql:" + str2);
                    try {
                        aVar.fV(null, str2);
                    } catch (Exception e) {
                        Assert.assertTrue("CreateTable failed:[" + str2 + "][" + e.getMessage() + "]", false);
                    }
                }
            }
            aVar.gp(dO);
        }
        x.d("MicroMsg.GeneralDBHelper", "addRef %d", Integer.valueOf(i));
        aVar.evY.put(i, true);
        return aVar;
    }
}
