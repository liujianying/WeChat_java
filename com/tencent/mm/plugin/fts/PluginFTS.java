package com.tencent.mm.plugin.fts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.SparseArray;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.by.a;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.d;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class PluginFTS extends f implements b, c, n {
    public static boolean jpy;
    private com.tencent.mm.sdk.b.c jpA = new 5(this);
    private com.tencent.mm.sdk.b.c jpB = new 6(this);
    private e jpC = new 7(this);
    private com.tencent.mm.sdk.b.c jpD = new 8(this);
    private BroadcastReceiver jpE = new 9(this);
    private ConcurrentHashMap<Integer, i> jpF = new ConcurrentHashMap();
    private f jpG;
    private SparseArray<d> jpH = new SparseArray();
    private com.tencent.mm.plugin.fts.a.d.c jpI;
    private SparseArray<com.tencent.mm.plugin.fts.a.d.a.b> jpJ = new SparseArray();
    private SparseArray<k> jpK = new SparseArray();
    private com.tencent.mm.sdk.b.c jpL = new 2(this);
    private volatile g jpp;
    private volatile d jpq;
    private volatile boolean jpr = false;
    private volatile boolean jps = false;
    private boolean jpt = false;
    private boolean jpu = false;
    private boolean jpv;
    private Runnable jpw = new 1(this);
    private e jpx = new 3(this);
    private a jpz = new a() {
        public final boolean IS() {
            x.w("MicroMsg.FTS.PluginFTS", "HERE UninitForUEH is called! stg:%s ", new Object[]{PluginFTS.this.jpq});
            PluginFTS.jpy = true;
            if (PluginFTS.this.jpq != null) {
                PluginFTS.this.jpq.rollback();
                PluginFTS.this.jpq.close();
            }
            return true;
        }
    };

    public boolean isCharging() {
        return this.jpt;
    }

    public boolean isInBackground() {
        return this.jpu;
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        File file = new File(com.tencent.mm.plugin.fts.a.c.jqx);
        if (!file.exists()) {
            file.mkdir();
        }
        if (this.jpp != null) {
            this.jpp.quit();
        }
        initFTSTaskDaemon();
        Intent registerReceiver = ad.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            boolean z = intExtra == 2 || intExtra == 5;
            this.jpt = z;
        } else {
            this.jpt = false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        ad.getContext().registerReceiver(this.jpE, intentFilter);
        g.El().a(this.jpz);
        this.jpB.cht();
        this.jpD.cht();
        this.jpA.cht();
        this.jpL.cht();
        g.DF().a(138, this.jpC);
        this.jpp.a(-131072, new b(this, (byte) 0));
        this.jpp.a(-131071, new a(this, (byte) 0));
        this.jpI = new c();
        addCheckLanguageTask();
    }

    public void onAccountRelease() {
        destroyNativeLogic();
        destroyNativeUILogic();
        destroyItemClickHandler();
        destroyStorage();
        if (this.jpp != null) {
            this.jpp.quit();
            this.jpp = null;
        }
        if (this.jpq != null) {
            this.jpq.close();
            this.jpq = null;
        }
        if (this.jpI != null) {
            this.jpI.aPQ();
            this.jpI = null;
        }
        try {
            ad.getContext().unregisterReceiver(this.jpE);
        } catch (Exception e) {
        }
        this.jpB.dead();
        this.jpA.dead();
        this.jpL.dead();
        this.jpD.dead();
        g.DF().b(138, this.jpC);
        g.El().b(this.jpz);
        this.jpr = false;
        this.jps = false;
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    public void initFTSTaskDaemon() {
        if (this.jpp == null) {
            this.jpp = new g();
            g gVar = this.jpp;
            if (gVar.jpf == null || !gVar.jpf.isAlive()) {
                gVar.jpf = new g.a(gVar);
                x.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon initialized, waiting for starting.");
            } else {
                x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", new Throwable(), "Duplicated daemon initialization detected, working queue maybe dirty!", new Object[0]);
            }
            gVar = this.jpp;
            Runnable runnable = this.jpw;
            if (gVar.jpf != null) {
                gVar.jpf.jpl = runnable;
            }
            this.jpp.jpf.jpm = this.jpx;
        }
    }

    public m getFTSTaskDaemon() {
        initFTSTaskDaemon();
        return this.jpp;
    }

    public h getFTSIndexDB() {
        return this.jpq;
    }

    public void parallelsDependency() {
        com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).aN(g.l(com.tencent.mm.plugin.chatroom.b.b.class));
    }

    private void registerSearchLogic() {
        registerNativeLogic(1, new com.tencent.mm.plugin.fts.b.e());
        registerNativeLogic(2, new com.tencent.mm.plugin.fts.b.a());
        registerNativeLogic(3, new com.tencent.mm.plugin.fts.b.c());
        registerNativeLogic(4, new com.tencent.mm.plugin.fts.b.b());
        registerNativeLogic(8, new com.tencent.mm.plugin.fts.b.d());
        registerNativeLogic(10000, new com.tencent.mm.plugin.fts.b.f());
    }

    private void registerStorage() {
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.e());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.a());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.b());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.c());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.d());
    }

    private void createNativeLogic() {
        x.i("MicroMsg.FTS.PluginFTS", "Create Native Logic");
        for (int i = 0; i < this.jpK.size(); i++) {
            k kVar = (k) this.jpK.get(this.jpK.keyAt(i));
            if (kVar != null) {
                try {
                    kVar.create();
                } catch (Throwable e) {
                    x.e("MicroMsg.FTS.PluginFTS", "Create Native Logic name=%s \nexception=%s", new Object[]{kVar.getName(), bi.i(e)});
                }
            }
        }
    }

    private void destroyNativeLogic() {
        x.i("MicroMsg.FTS.PluginFTS", "Destroy Native Logic");
        for (int i = 0; i < this.jpK.size(); i++) {
            k kVar = (k) this.jpK.get(this.jpK.keyAt(i));
            if (kVar != null) {
                try {
                    kVar.destroy();
                } catch (Throwable e) {
                    x.e("MicroMsg.FTS.PluginFTS", "Create Native Logic name=%s \nexception=%s", new Object[]{kVar.getName(), bi.i(e)});
                }
            }
        }
    }

    private void destroyNativeUILogic() {
        this.jpH.clear();
    }

    private void destroyItemClickHandler() {
        this.jpJ.clear();
    }

    private void createIndexStorage() {
        x.i("MicroMsg.FTS.PluginFTS", "Create Index Storage");
        LinkedList linkedList = new LinkedList();
        for (i add : this.jpF.values()) {
            linkedList.add(add);
        }
        Collections.sort(linkedList);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                ((i) linkedList.get(i2)).create();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void destroyStorage() {
        x.i("MicroMsg.FTS.PluginFTS", "Destroy Index Storage");
        for (i iVar : this.jpF.values()) {
            if (iVar != null) {
                iVar.destroy();
            }
        }
    }

    private void waitAndStartDaemon() {
        g.Ek();
        this.jpr = bi.f((Integer) g.Ei().DT().get(15, null)) != 0;
        if (this.jpr) {
            x.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon user is initialized.");
        } else {
            g.DF().a(138, this.jpC);
            x.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon wait for account initialized");
        }
        if (this.jps) {
            x.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon all account post reset.");
        } else {
            x.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon wait for all account post reset.");
        }
        if (this.jpr && this.jps) {
            startDaemon();
        }
    }

    private void startDaemon() {
        if (!this.jpp.aiS()) {
            g gVar = this.jpp;
            gVar.jpf.start();
            x.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon started with TID: " + gVar.jpf.getId());
        }
    }

    public com.tencent.mm.plugin.fts.a.a.a search(int i, com.tencent.mm.plugin.fts.a.a.i iVar) {
        com.tencent.mm.plugin.fts.a.a.a bVar;
        if (!isFTSContextReady()) {
            b bVar2 = new b(-2, iVar);
            com.tencent.mm.sdk.f.e.post(bVar2, "FTSExceptionHandler");
            return bVar2;
        } else if (!isFTSIndexReady()) {
            bVar = new b(-4, iVar);
            com.tencent.mm.sdk.f.e.post(bVar, "FTSExceptionHandler");
            return bVar;
        } else if (this.jpK.indexOfKey(i) >= 0) {
            k kVar = (k) this.jpK.get(i);
            if (kVar.aPX()) {
                return kVar.a(iVar);
            }
            bVar = new b(-2, iVar);
            com.tencent.mm.sdk.f.e.post(bVar, "FTSExceptionHandler");
            return bVar;
        } else {
            x.e("MicroMsg.FTS.PluginFTS", "Not Found Search Logic, LogicArraySize=%d", new Object[]{Integer.valueOf(this.jpK.size())});
            bVar = new b(-2, iVar);
            com.tencent.mm.sdk.f.e.post(bVar, "FTSExceptionHandler");
            return bVar;
        }
    }

    public void cancelSearchTask(com.tencent.mm.plugin.fts.a.a.a aVar) {
        if (isFTSContextReady()) {
            g gVar = this.jpp;
            if (gVar.jpf != null) {
                g.a aVar2 = gVar.jpf;
                aVar.fE = true;
                aVar2.jph.remove(aVar);
                if (aVar2.jpj == aVar) {
                    aVar2.interrupt();
                }
            }
        }
    }

    public void updateTopHitsRank(String str, l lVar, int i) {
        if (isFTSContextReady() && this.jpK.indexOfKey(1) >= 0) {
            ((k) this.jpK.get(1)).a(str, lVar, i, com.tencent.mm.plugin.fts.a.d.aPY());
        }
    }

    public void addSOSHistory(String str) {
        if (isFTSContextReady() && this.jpK.indexOfKey(8) >= 0) {
            ((k) this.jpK.get(8)).addSOSHistory(str);
        }
    }

    public void deleteSOSHistory() {
        if (isFTSContextReady() && this.jpK.indexOfKey(8) >= 0) {
            ((k) this.jpK.get(8)).deleteSOSHistory();
        }
    }

    public void deleteSOSHistory(String str) {
        if (isFTSContextReady() && this.jpK.indexOfKey(8) >= 0) {
            ((k) this.jpK.get(8)).deleteSOSHistory(str);
        }
    }

    public void registerIndexStorage(i iVar) {
        this.jpF.put(Integer.valueOf(iVar.getType()), iVar);
    }

    public void unregisterIndexStorage(int i) {
        if (this.jpF.containsKey(Integer.valueOf(i))) {
            try {
                ((i) this.jpF.get(Integer.valueOf(i))).destroy();
            } catch (Throwable e) {
                x.e("MicroMsg.FTS.PluginFTS", "Destroy Index Storage name=%s \nexception=%s", new Object[]{r0.getName(), bi.i(e)});
            }
        }
        this.jpF.remove(Integer.valueOf(i));
    }

    public i getFTSIndexStorage(int i) {
        return (i) this.jpF.get(Integer.valueOf(i));
    }

    public j getFTSMainDB() {
        if (this.jpG == null) {
            this.jpG = new f();
        }
        return this.jpG;
    }

    public int stringCompareUtfBinary(String str, String str2) {
        return FTSJNIUtils.stringCompareUtfBinary(str, str2);
    }

    public void registerFTSUILogic(d dVar) {
        try {
            this.jpH.put(dVar.getType(), dVar);
        } catch (Exception e) {
        }
    }

    public void unregisterFTSUILogic(int i) {
        try {
            this.jpH.remove(i);
        } catch (Exception e) {
        }
    }

    public void setFTSImageLoader(com.tencent.mm.plugin.fts.a.d.c cVar) {
        this.jpI = cVar;
    }

    public com.tencent.mm.plugin.fts.a.d.c getFTSImageLoader() {
        return this.jpI;
    }

    public LinkedList<com.tencent.mm.plugin.fts.a.d.e> createFTSUIUnitList(HashSet<Integer> hashSet, Context context, com.tencent.mm.plugin.fts.a.d.e.b bVar, int i) {
        LinkedList<com.tencent.mm.plugin.fts.a.d.e> linkedList = new LinkedList();
        Object linkedList2 = new LinkedList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            d dVar = (d) this.jpH.get(((Integer) it.next()).intValue());
            if (dVar != null) {
                linkedList2.add(dVar);
            }
        }
        Collections.sort(linkedList2);
        Iterator it2 = linkedList2.iterator();
        while (it2.hasNext()) {
            linkedList.add(((d) it2.next()).a(context, bVar, i));
        }
        return linkedList;
    }

    public com.tencent.mm.plugin.fts.a.d.e createFTSUIUnit(int i, Context context, com.tencent.mm.plugin.fts.a.d.e.b bVar, int i2) {
        d dVar = (d) this.jpH.get(i);
        if (dVar != null) {
            return dVar.a(context, bVar, i2);
        }
        return null;
    }

    public void registerItemClickHandler(int i, com.tencent.mm.plugin.fts.a.d.a.b bVar) {
        this.jpJ.put(i, bVar);
    }

    public void unregisterItemClickHandler(int i) {
        this.jpJ.remove(i);
    }

    public com.tencent.mm.plugin.fts.a.d.a.b getItemClickHandler(int i) {
        return (com.tencent.mm.plugin.fts.a.d.a.b) this.jpJ.get(i);
    }

    public void registerNativeLogic(int i, k kVar) {
        this.jpK.put(i, kVar);
    }

    public void unregisterNativeLogic(int i) {
        if (this.jpK.indexOfKey(i) >= 0) {
            try {
                ((k) this.jpK.get(i)).destroy();
            } catch (Throwable e) {
                x.e("MicroMsg.FTS.PluginFTS", "Destroy Native Logic name=%s \nexception=%s", new Object[]{r0.getName(), bi.i(e)});
            }
        }
        this.jpK.remove(i);
    }

    public boolean isFTSContextReady() {
        return getFTSTaskDaemon().aiS();
    }

    public boolean isFTSIndexReady() {
        return this.jpv;
    }

    public void setFTSIndexReady(boolean z) {
        this.jpv = z;
    }

    public com.tencent.mm.plugin.fts.b.e getTopHitsLogic() {
        return (com.tencent.mm.plugin.fts.b.e) this.jpK.get(1);
    }

    private void addCheckLanguageTask() {
        ((n) g.n(n.class)).getFTSTaskDaemon().a(65536, new 10(this));
    }
}
