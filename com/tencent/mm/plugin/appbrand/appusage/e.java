package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.akr;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.c;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class e {
    private static volatile e flj;
    public final Set<b> flk = new HashSet();
    public volatile aks fll = null;
    public final Object mLock = new Object();

    static /* synthetic */ void a(e eVar, aks aks) {
        if (g.Eg().Dx()) {
            eVar.fll = aks;
            LinkedList linkedList = null;
            synchronized (eVar.mLock) {
                if (eVar.flk.size() != 0) {
                    linkedList = new LinkedList(eVar.flk);
                }
            }
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).acN();
                }
            }
        }
    }

    public static e acM() {
        if (flj == null) {
            synchronized (e.class) {
                if (flj == null) {
                    flj = new e();
                }
            }
        }
        return flj;
    }

    public static void release() {
        synchronized (e.class) {
            flj = null;
        }
    }

    public final void refresh() {
        this.fll = null;
        a aVar = new a();
        aVar.dIF = 1841;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxagame";
        aVar.dIG = new akr();
        aVar.dIH = new aks();
        v.a(aVar.KT(), new 1(this));
    }

    public static boolean enabled() {
        if (g.Eg().Dx()) {
            c fJ = com.tencent.mm.model.c.c.Jx().fJ("100328");
            if (fJ.isValid()) {
                a jJ = a.jJ(bi.getInt((String) fJ.ckq().get("isOpenGameEntry"), 0));
                if (jJ != null && jJ == a.flo) {
                    return true;
                }
            }
        }
        return false;
    }
}
