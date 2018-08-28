package com.tencent.mm.bn;

import com.tencent.mm.api.d;
import com.tencent.mm.api.k;
import com.tencent.mm.bi.b;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.c;
import com.tencent.mm.cache.g;
import com.tencent.mm.t.e;
import java.util.Iterator;
import java.util.Stack;

public final class a implements k {
    private b bBn;

    public a(b bVar) {
        this.bBn = bVar;
    }

    public final int ub() {
        c cVar = (c) ArtistCacheManager.yn().a(com.tencent.mm.d.a.bBj);
        if (cVar == null) {
            return 0;
        }
        return cVar.yu()[1];
    }

    public final int uc() {
        c cVar = (c) ArtistCacheManager.yn().a(com.tencent.mm.d.a.bBj);
        if (cVar == null) {
            return 0;
        }
        return cVar.yu()[0];
    }

    public final int ud() {
        g gVar = (g) ArtistCacheManager.yn().a(com.tencent.mm.d.a.bBi);
        if (gVar == null) {
            return 0;
        }
        return gVar.aW(false);
    }

    public final int ue() {
        com.tencent.mm.cache.b bVar = (com.tencent.mm.cache.b) ArtistCacheManager.yn().a(com.tencent.mm.d.a.bBh);
        if (bVar == null) {
            return 0;
        }
        return bVar.aW(false);
    }

    public final int uf() {
        int i = 0;
        com.tencent.mm.cache.b bVar = (com.tencent.mm.cache.b) ArtistCacheManager.yn().a(com.tencent.mm.d.a.bBh);
        if (bVar != null) {
            i = bVar.dal + 0;
        }
        g gVar = (g) ArtistCacheManager.yn().a(com.tencent.mm.d.a.bBi);
        if (gVar != null) {
            return i + gVar.dal;
        }
        return i;
    }

    public final boolean ug() {
        com.tencent.mm.cache.a aVar = (com.tencent.mm.cache.a) ArtistCacheManager.yn().a(com.tencent.mm.d.a.bBk);
        if (aVar == null) {
            return false;
        }
        return aVar.aW(false) > 0;
    }

    public final boolean uh() {
        com.tencent.mm.d.b b = this.bBn.b(d.bwR);
        if (b == null || b.vE() != com.tencent.mm.d.a.bBk) {
            return false;
        }
        boolean z;
        if (((com.tencent.mm.d.c) b).bCa > 0) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final int getTextColor() {
        c cVar = (c) ArtistCacheManager.yn().a(com.tencent.mm.d.a.bBj);
        if (cVar == null) {
            return 0;
        }
        int i;
        Stack stack = cVar.daj;
        if (stack != null) {
            Iterator it = stack.iterator();
            i = 0;
            while (it.hasNext()) {
                com.tencent.mm.t.c cVar2 = (com.tencent.mm.t.c) it.next();
                if (cVar2 instanceof e) {
                    e eVar = (e) cVar2;
                    int[] iArr = com.tencent.mm.view.footer.a.uUQ;
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        if (eVar.pN == iArr[i2]) {
                            i = (1 << i2) | i;
                            break;
                        }
                    }
                }
            }
        } else {
            i = 0;
        }
        return i;
    }

    public final int ui() {
        com.tencent.mm.cache.b bVar = (com.tencent.mm.cache.b) ArtistCacheManager.yn().a(com.tencent.mm.d.a.bBh);
        if (bVar == null) {
            return 0;
        }
        int i;
        Stack stack = bVar.daj;
        if (stack != null) {
            Iterator it = stack.iterator();
            i = 0;
            while (it.hasNext()) {
                com.tencent.mm.t.b bVar2 = (com.tencent.mm.t.b) it.next();
                int[] iArr = com.tencent.mm.view.footer.a.uUQ;
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    if (bVar2.pN == iArr[i2]) {
                        i = (1 << i2) | i;
                        break;
                    }
                }
            }
        } else {
            i = 0;
        }
        return i;
    }

    public final boolean uj() {
        com.tencent.mm.cache.b bVar = (com.tencent.mm.cache.b) ArtistCacheManager.yn().a(com.tencent.mm.d.a.bBh);
        g gVar = (g) ArtistCacheManager.yn().a(com.tencent.mm.d.a.bBi);
        com.tencent.mm.cache.a aVar = (com.tencent.mm.cache.a) ArtistCacheManager.yn().a(com.tencent.mm.d.a.bBk);
        c cVar = (c) ArtistCacheManager.yn().a(com.tencent.mm.d.a.bBj);
        if ((bVar == null || bVar.aW(true) <= 0) && ((gVar == null || gVar.aW(true) <= 0) && ((cVar == null || cVar.aW(true) <= 0) && (aVar == null || aVar.aW(true) <= 0)))) {
            return false;
        }
        return true;
    }
}
