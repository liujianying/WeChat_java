package com.tencent.mm.plugin.subapp;

import android.annotation.SuppressLint;
import com.tencent.mm.ai.d;
import com.tencent.mm.bt.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.subapp.d.c;
import com.tencent.mm.pluginsdk.f.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bx;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a implements ar {
    static bx opT;
    private Map<String, ar> opU = new HashMap();
    private a opV;
    private com.tencent.mm.plugin.subapp.d.a opW;
    private c opX;

    public a() {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp constructor: " + System.currentTimeMillis());
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getSubCoreMap: " + System.currentTimeMillis());
        Map hashMap = new HashMap();
        hashMap.put(d.class.getName(), new d());
        hashMap.put(com.tencent.mm.plugin.subapp.b.c.class.getName(), new com.tencent.mm.plugin.subapp.b.c());
        hashMap.put(com.tencent.mm.plugin.subapp.a.c.class.getName(), new com.tencent.mm.plugin.subapp.a.c());
        com.tencent.mm.plugin.subapp.c.d dVar = new com.tencent.mm.plugin.subapp.c.d();
        com.tencent.mm.model.am.a.dBu = dVar;
        hashMap.put(com.tencent.mm.plugin.subapp.c.d.class.getName(), dVar);
        com.tencent.mm.plugin.subapp.jdbiz.c cVar = new com.tencent.mm.plugin.subapp.jdbiz.c();
        hashMap.put(com.tencent.mm.plugin.subapp.jdbiz.c.class.getName(), cVar);
        f.qBo = cVar;
        this.opU = hashMap;
    }

    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, h.d> Ci() {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getBaseDBFactories: " + System.currentTimeMillis());
        HashMap<Integer, h.d> hashMap = new HashMap();
        for (Entry entry : this.opU.entrySet()) {
            if (((ar) entry.getValue()).Ci() != null) {
                hashMap.putAll(((ar) entry.getValue()).Ci());
            }
        }
        return hashMap;
    }

    public final void gi(int i) {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp clearPluginData: " + System.currentTimeMillis());
        for (Entry value : this.opU.entrySet()) {
            ((ar) value.getValue()).gi(i);
        }
    }

    public final void bn(boolean z) {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountPostReset: " + System.currentTimeMillis());
        for (Entry value : this.opU.entrySet()) {
            ((ar) value.getValue()).bn(z);
        }
        if (this.opV == null) {
            this.opV = new a();
        }
        if (this.opW == null) {
            this.opW = new com.tencent.mm.plugin.subapp.d.a();
        }
        if (this.opX == null) {
            this.opX = new c();
        }
        com.tencent.mm.sdk.b.a.sFg.b(this.opV);
        com.tencent.mm.sdk.b.a.sFg.b(this.opX);
        com.tencent.mm.sdk.b.a.sFg.b(this.opW);
    }

    public final void bo(boolean z) {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onSdcardMount: " + System.currentTimeMillis());
        for (Entry value : this.opU.entrySet()) {
            ((ar) value.getValue()).bo(z);
        }
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountRelease: " + System.currentTimeMillis());
        for (Entry value : this.opU.entrySet()) {
            ((ar) value.getValue()).onAccountRelease();
        }
        if (this.opV != null) {
            com.tencent.mm.sdk.b.a.sFg.c(this.opV);
        }
        if (this.opW != null) {
            com.tencent.mm.sdk.b.a.sFg.c(this.opW);
        }
        if (this.opX != null) {
            com.tencent.mm.sdk.b.a.sFg.c(this.opX);
        }
    }

    public final ar Oi(String str) {
        return (ar) this.opU.get(str);
    }

    public final void b(String str, ar arVar) {
        this.opU.put(str, arVar);
    }
}
