package com.tencent.mm.plugin.ac;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class a implements com.tencent.mm.kernel.api.bucket.a, b, c, e, com.tencent.mm.kernel.b.c {
    private static HashMap<Integer, d> cVM;
    private static volatile a lMZ;
    private com.tencent.mm.pluginsdk.model.app.c lNa;
    private com.tencent.mm.pluginsdk.model.app.e lNb;
    private h lNc;
    private i lNd;
    private k lNe;
    private m lNf;
    private com.tencent.mm.pluginsdk.model.app.d lNg;
    private com.tencent.mm.sdk.b.c lNh = new 4(this);

    private a() {
        com.tencent.mm.plugin.ac.a.a.a.a(new 1(this));
    }

    public static a bmb() {
        if (lMZ == null) {
            synchronized (a.class) {
                if (lMZ == null) {
                    lMZ = new a();
                }
            }
        }
        return lMZ;
    }

    public List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"openapi/"});
        return linkedList;
    }

    public static String bmc() {
        return g.Ei().dqp + "openapi/";
    }

    public static com.tencent.mm.pluginsdk.model.app.c asF() {
        g.Eg().Ds();
        if (bmb().lNa == null) {
            bmb().lNa = new com.tencent.mm.pluginsdk.model.app.c(g.Ei().dqq);
        }
        return bmb().lNa;
    }

    public static com.tencent.mm.pluginsdk.model.app.e bmd() {
        g.Eg().Ds();
        if (bmb().lNb == null) {
            bmb().lNb = new com.tencent.mm.pluginsdk.model.app.e();
        }
        return bmb().lNb;
    }

    public static h bme() {
        g.Eg().Ds();
        if (bmb().lNc == null) {
            bmb().lNc = new h();
        }
        return bmb().lNc;
    }

    public static i bmf() {
        g.Eg().Ds();
        if (bmb().lNd == null) {
            bmb().lNd = new i(g.Ei().dqq);
        }
        return bmb().lNd;
    }

    public static k bmg() {
        g.Eg().Ds();
        if (bmb().lNe == null) {
            bmb().lNe = new k(g.Ei().dqq);
        }
        return bmb().lNe;
    }

    public static m bmh() {
        g.Eg().Ds();
        if (bmb().lNf == null) {
            bmb().lNf = new m();
        }
        return bmb().lNf;
    }

    public static com.tencent.mm.pluginsdk.model.app.d bmi() {
        g.Eg().Ds();
        if (bmb().lNg == null) {
            bmb().lNg = new com.tencent.mm.pluginsdk.model.app.d();
        }
        return bmb().lNg;
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        com.tencent.mm.model.ac.a.dBp = bme();
        com.tencent.mm.sdk.b.a.sFg.b(this.lNh);
    }

    public void onAccountRelease() {
        h hVar = bmb().lNc;
        if (hVar != null) {
            g.Eh().dpP.b(231, hVar);
            bmi().b(7, hVar);
        }
        com.tencent.mm.pluginsdk.model.app.e eVar = bmb().lNb;
        if (eVar != null) {
            eVar.qzB.clear();
            eVar.mTQ.clear();
            eVar.fxF.clear();
        }
        m mVar = bmb().lNf;
        if (mVar != null) {
            x.d("MicroMsg.AppSettingService", "stop service");
            mVar.qzY.clear();
            bmi().b(1, mVar);
        }
        if (this.lNg != null) {
            com.tencent.mm.pluginsdk.model.app.d dVar = this.lNg;
            g.Eh().dpP.b(452, dVar);
            dVar.dJw.clear();
        }
        if (bmb().lNd != null) {
            bmb().lNd.qzQ.clear();
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.lNh);
        x.i("XPinOpenApi", "onAccountRelease");
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("APPATTACHINFO_TABLE".hashCode()), new 2());
        cVM.put(Integer.valueOf("APPINFO_TABLE".hashCode()), new 3());
    }

    public HashMap<Integer, d> collectDatabaseFactory() {
        return cVM;
    }

    public void onDataBaseOpened(com.tencent.mm.bt.h hVar, com.tencent.mm.bt.h hVar2) {
    }

    public void onDataBaseClosed(com.tencent.mm.bt.h hVar, com.tencent.mm.bt.h hVar2) {
        this.lNa = null;
        this.lNd = null;
        x.i("XPinOpenApi", "onDataBaseClosed");
    }
}
