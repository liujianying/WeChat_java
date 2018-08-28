package com.tencent.mm.g.c;

import com.tencent.mm.bt.h;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import junit.framework.Assert;

public final class ff extends h {
    private static ff cVL = null;
    private static HashMap<Integer, d> cVM;

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("FavItemInfo".hashCode()), new 1());
        cVM.put(Integer.valueOf("FavSearchInfo".hashCode()), new 2());
        cVM.put(Integer.valueOf("FavEditInfo".hashCode()), new 3());
        cVM.put(Integer.valueOf("FavCdnInfo".hashCode()), new 4());
        cVM.put(Integer.valueOf("FavConfigInfo".hashCode()), new 5());
    }

    private ff() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        g.Eg();
        if (a.Df() != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        x.d("MicroMsg.FavoriteDataBase", "db path", g.Ei().cachePath + "enFavorite.db");
        g.Eg();
        if (a("", g.Ei().cachePath + "enFavorite.db", (long) a.Df(), q.zy(), cVM)) {
            String str = this.tdP;
            if (!bi.oW(str)) {
                x.e("MicroMsg.FavoriteDataBase", "dbinit failed :" + str);
                b.A("init db Favorite Failed: [ " + str + "]", "DBinit");
            }
            x.d("MicroMsg.FavoriteDataBase", "init db Favorite time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        throw new com.tencent.mm.model.b((byte) 0);
    }

    public static ff xa() {
        if (cVL == null) {
            cVL = new ff();
        }
        return cVL;
    }

    public final void ex(String str) {
        super.ex(str);
        cVL = null;
    }
}
