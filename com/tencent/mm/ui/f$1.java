package com.tencent.mm.ui;

import android.util.SparseArray;
import com.tencent.mm.bt.a.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.f.c;
import com.tencent.mm.ui.f.d;
import java.util.HashSet;

class f$1 implements d {
    final /* synthetic */ f thN;

    f$1(f fVar) {
        this.thN = fVar;
    }

    public final void cpb() {
        long currentTimeMillis;
        if (f.a(this.thN, f.b(this.thN))) {
            HashSet hashSet = new HashSet(f.b(this.thN).size());
            for (b bVar : f.b(this.thN).values()) {
                hashSet.add(bVar.object);
            }
            x.i(this.thN.TAG, "newcursor all event is delete");
            f.c(this.thN).c(hashSet.toArray(), null);
        } else if (f.b(this.thN).containsKey(this.thN.thM)) {
            currentTimeMillis = System.currentTimeMillis();
            f.a(this.thN, new c(this.thN, this.thN.coW()), true, false);
            x.i(this.thN.TAG, "cache unuseful,reset cursor,last : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        } else {
            currentTimeMillis = System.currentTimeMillis();
            SparseArray[] coX = this.thN.coX();
            SparseArray[] a = this.thN.a(new HashSet(f.b(this.thN).values()), coX);
            int length = coX.length;
            if (length > 1) {
                for (int i = 0; i < length; i++) {
                    x.i(this.thN.TAG, "newcursor %d  refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[]{Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(coX[i].size()), Integer.valueOf(a[i].size())});
                }
            } else {
                x.i(this.thN.TAG, "newcursor refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(coX[0].size()), Integer.valueOf(a[0].size())});
            }
            for (b bVar2 : f.b(this.thN).values()) {
                if (bVar2 != null) {
                    if (bVar2.thQ != null) {
                        x.i(this.thN.TAG, "newcursor notify cache update : key : %s ", new Object[]{bVar2.object});
                    }
                    f.c(this.thN).c(bVar2.object, (a) bVar2.thQ);
                } else {
                    x.e(this.thN.TAG, "newcursor event is null ! ");
                }
            }
            this.thN.a(a);
            x.i(this.thN.TAG, "newcursor after resort new pos size :%d  ", new Object[]{Integer.valueOf(f.c(this.thN).cnS()[0].size())});
        }
        f.b(this.thN).clear();
    }
}
