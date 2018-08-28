package com.tencent.mm.plugin.emoji.sync;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.b.b;
import com.tencent.mm.plugin.emoji.sync.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public final class a<T extends d> {
    public BKGLoaderManager ije;

    public enum a {
        Default,
        Syncing,
        PauseSync,
        PauseSyncOffline,
        PauseSyncSDCardFull,
        FinishSync
    }

    public a() {
        com.tencent.mm.plugin.emoji.sync.b.a aVar = new com.tencent.mm.plugin.emoji.sync.b.a();
        aVar.ijm = 1;
        aVar.dXc = 10;
        aVar.ijo = new b(aVar.ijm, aVar.ijm, TimeUnit.MILLISECONDS, new com.tencent.mm.ak.a.e.a(), new c(aVar.dXc, "bkg_loader_"));
        a(new b(aVar));
    }

    private synchronized void a(b bVar) {
        if (this.ije == null) {
            this.ije = new BKGLoaderManager(bVar);
        } else {
            x.i("MicroMsg.BKGLoader.BKGLoader", "[cpan] BKGLoader had init.");
        }
    }

    public final void s(ArrayList<d> arrayList) {
        BKGLoaderManager bKGLoaderManager = this.ije;
        bKGLoaderManager.ijr = false;
        if (bKGLoaderManager.ijA == null) {
            bKGLoaderManager.ijA = new Vector();
        }
        if (arrayList.size() > 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                d dVar = (d) arrayList.get(i);
                if (dVar == null || bKGLoaderManager.ijA.contains(dVar)) {
                    x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist.:%s", new Object[]{dVar.getKey()});
                } else {
                    bKGLoaderManager.ijA.add(dVar);
                }
            }
        }
    }

    public final void t(ArrayList<d> arrayList) {
        BKGLoaderManager bKGLoaderManager = this.ije;
        if (bKGLoaderManager.ijC == null) {
            bKGLoaderManager.ijC = new Vector();
        }
        if (arrayList.size() > 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                d dVar = (d) arrayList.get(i);
                String str;
                String str2;
                Object[] objArr;
                if (bKGLoaderManager.ijy != null && bKGLoaderManager.ijy.equals(dVar)) {
                    str = "MicroMsg.BKGLoader.BKGLoaderManager";
                    str2 = "[cpan] currentTask equals task is has exist:%s";
                    objArr = new Object[1];
                    objArr[0] = dVar == null ? "task is null" : dVar.getKey();
                    x.i(str, str2, objArr);
                } else if (dVar == null || bKGLoaderManager.ijC.contains(dVar)) {
                    str = "MicroMsg.BKGLoader.BKGLoaderManager";
                    str2 = "[cpan] task is has exist:%s";
                    objArr = new Object[1];
                    objArr[0] = dVar == null ? "task is null" : dVar.getKey();
                    x.i(str, str2, objArr);
                } else {
                    bKGLoaderManager.ijC.add(dVar);
                }
            }
        }
    }

    public final a aEU() {
        BKGLoaderManager bKGLoaderManager = this.ije;
        if (bKGLoaderManager.ijs && bKGLoaderManager.ijx) {
            return a.PauseSyncSDCardFull;
        }
        if (BKGLoaderManager.aDK() && !bKGLoaderManager.ijs && i.aEA().igx.cnK() > 0) {
            return a.PauseSync;
        }
        if (!ao.isConnected(ad.getContext()) && !bKGLoaderManager.ijs && i.aEA().igx.cnK() > 0) {
            return a.PauseSyncOffline;
        }
        if (ao.isConnected(ad.getContext())) {
            if (bKGLoaderManager.ijs && bKGLoaderManager.bts) {
                return a.Syncing;
            }
            if (bKGLoaderManager.ijv) {
                return a.FinishSync;
            }
        }
        return a.Default;
    }

    public final void ej(boolean z) {
        this.ije.bts = z;
    }
}
