package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.protocal.c.ane;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class k {
    private static c cXl;
    private static float cXm = -85.0f;
    private static float cXn = -1000.0f;
    private static boolean cXo = false;
    private static Map<String, ane> cXp = new ConcurrentHashMap();
    private static List<ane> cXq = new CopyOnWriteArrayList();
    private static Boolean cXr = Boolean.valueOf(false);
    private static a cXs = new 1();
    private static al cXt = new al(Looper.getMainLooper(), new 2(), true);
    private static com.tencent.mm.sdk.b.c cXu = new com.tencent.mm.sdk.b.c<dm>() {
        {
            this.sFo = dm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            dm dmVar = (dm) bVar;
            if (dmVar != null && (dmVar instanceof dm)) {
                String str = dmVar.bLn.bLl;
                int i = dmVar.bLn.bLo;
                int i2 = dmVar.bLn.bLp;
                if (!k.cXp.containsKey(str + "," + i + "," + i2)) {
                    ane ane = new ane();
                    ane.fMk = str;
                    ane.major = i;
                    ane.minor = 65535 & i2;
                    ane.ees = dmVar.bLn.bLq;
                    k.cXp.put(str + "," + i + "," + i2, ane);
                    if (dmVar.bLn.bLq >= 0.0d && k.cXq.size() > 0) {
                        int i3 = 0;
                        while (i3 < k.cXq.size()) {
                            ane ane2 = (ane) k.cXq.get(i3);
                            if (dmVar.bLn.bLq >= ane2.ees) {
                                if (i3 == k.cXq.size() - 1 && dmVar.bLn.bLq > ane2.ees) {
                                    k.cXq.add(ane);
                                    break;
                                }
                                i3++;
                            } else {
                                k.cXq.add(i3, ane);
                                break;
                            }
                        }
                    }
                    k.cXq.add(ane);
                }
                x.i("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]result iBeacon = %s,beaconMap.size:%d", new Object[]{str + "," + i + "," + i2, Integer.valueOf(k.cXp.size())});
            }
            return false;
        }
    };

    public static void run() {
        if (au.HX() && !au.Dr()) {
            au.HU();
            Boolean valueOf = Boolean.valueOf(bi.a((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sRS, null), false));
            x.i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is " + valueOf);
            if (valueOf.booleanValue()) {
                long VE = bi.VE();
                au.HU();
                long a = bi.a((Long) com.tencent.mm.model.c.DT().get(aa.a.sRT, null), 0);
                au.HU();
                if (VE - a > bi.a((Long) com.tencent.mm.model.c.DT().get(aa.a.sRN, null), 0)) {
                    au.HU();
                    com.tencent.mm.model.c.DT().a(aa.a.sRS, Boolean.valueOf(false));
                    au.HU();
                    com.tencent.mm.model.c.DT().a(aa.a.sRR, "");
                    au.HU();
                    com.tencent.mm.model.c.DT().a(aa.a.sRQ, "");
                    au.HU();
                    com.tencent.mm.model.c.Dt();
                    return;
                }
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (VERSION.SDK_INT < 18 || defaultAdapter == null || defaultAdapter.getState() != 12) {
                    au.HU();
                    com.tencent.mm.model.c.DT().a(aa.a.sRQ, "");
                    return;
                }
                List<String> AJ = g.AU().AJ();
                if (AJ != null) {
                    for (String str : AJ) {
                        x.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", new Object[]{str});
                        dl dlVar = new dl();
                        dlVar.bLj.bLl = str;
                        dlVar.bLj.bLi = true;
                        com.tencent.mm.sdk.b.a.sFg.m(dlVar);
                    }
                    cXl = c.OB();
                    if (cXt.ciq()) {
                        cXt.J(3000, 3000);
                    }
                    if (!(cXo || cXl == null)) {
                        cXl.b(cXs);
                    }
                    com.tencent.mm.sdk.b.a.sFg.b(cXu);
                }
            }
        }
    }
}
