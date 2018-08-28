package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.app.an.a;
import com.tencent.mm.pluginsdk.model.b;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public class ao implements ar {
    private static HashMap<Integer, d> cVM;
    private o qAL;
    private a qAM = null;
    private j qAN = new j();
    private b qAO = new b();
    private c qAP = new 3(this);
    private c qAQ = new 4(this);

    private static ao cbW() {
        au.HN();
        ao aoVar = (ao) bs.iK(ao.class.getName());
        if (aoVar == null) {
            return new ao();
        }
        return aoVar;
    }

    public static j cbX() {
        return cbW().qAN;
    }

    public static c asF() {
        return com.tencent.mm.plugin.ac.a.asF();
    }

    public static h bme() {
        return com.tencent.mm.plugin.ac.a.bme();
    }

    public static i bmf() {
        return com.tencent.mm.plugin.ac.a.bmf();
    }

    public static k cbY() {
        return com.tencent.mm.plugin.ac.a.bmg();
    }

    public static o cbZ() {
        g.Eg().Ds();
        if (cbW().qAL == null) {
            ao cbW = cbW();
            au.HU();
            cbW.qAL = new o(com.tencent.mm.model.c.FO());
        }
        return cbW().qAL;
    }

    public static a cca() {
        g.Eg().Ds();
        if (cbW().qAM == null) {
            cbW().qAM = new a();
        }
        return cbW().qAM;
    }

    public static m bmh() {
        return com.tencent.mm.plugin.ac.a.bmh();
    }

    public static d bmi() {
        return com.tencent.mm.plugin.ac.a.bmi();
    }

    public final void onAccountRelease() {
        a aVar = cbW().qAM;
        if (aVar != null) {
            aVar.bFj = 0;
        }
        com.tencent.mm.ab.d.c.b(Integer.valueOf(47), this.qAO);
        com.tencent.mm.ab.d.c.b(Integer.valueOf(49), this.qAN);
        com.tencent.mm.sdk.b.a.sFg.c(this.qAP);
        com.tencent.mm.sdk.b.a.sFg.c(this.qAQ);
        j.cbv();
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("APPMESSAGE_TABLE".hashCode()), new 1());
        cVM.put(Integer.valueOf("APPSORT_TABLE".hashCode()), new d() {
            public final String[] xb() {
                return o.diD;
            }
        });
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        ac.a.dBp = com.tencent.mm.plugin.ac.a.bme();
        com.tencent.mm.ab.d.c.a(Integer.valueOf(47), this.qAO);
        com.tencent.mm.ab.d.c.a(Integer.valueOf(49), this.qAN);
        com.tencent.mm.sdk.b.a.sFg.b(this.qAP);
        com.tencent.mm.sdk.b.a.sFg.b(this.qAQ);
        SightVideoJNI.registerALL();
    }

    public final void bo(boolean z) {
    }
}
