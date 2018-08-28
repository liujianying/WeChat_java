package com.tencent.mm.plugin.sns.model;

import android.view.Menu;
import android.widget.Toast;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ap {
    private static HashMap<String, b> nrC = new HashMap();
    private static LinkedList<a> nrD = new LinkedList();
    private static c nrE = new 1();

    public static class b {
        public int csE;
        public boolean dDR;
        public boolean dHC;
        public String dMB;
        public String id;
        public boolean nrH;
        public boolean nrI;
        public String result;
    }

    static /* synthetic */ a ce(String str, int i) {
        Iterator it = nrD.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.type == i && !bi.oW(str) && !bi.oW(aVar.id) && str.equals(aVar.id)) {
                return aVar;
            }
        }
        return null;
    }

    public static void init() {
        a.sFg.b(nrE);
    }

    public static void Wa() {
        a.sFg.c(nrE);
    }

    private static boolean vy() {
        if (!d.QS("translate")) {
            return false;
        }
        String value = g.AT().getValue("TranslateSnsOff");
        if (bi.oW(value)) {
            return true;
        }
        if (bi.WU(value) == 0) {
            return true;
        }
        return false;
    }

    public static void a(Menu menu, boolean z) {
        if (!vy()) {
            return;
        }
        if (z) {
            menu.add(0, 14, 0, j.sns_translate);
        } else {
            menu.add(0, 15, 0, j.sns_translate);
        }
    }

    public static void b(Menu menu, boolean z) {
        if (!vy()) {
            return;
        }
        if (z) {
            menu.add(0, 16, 0, j.sns_translate_original);
        } else {
            menu.add(0, 17, 0, j.sns_translate_original);
        }
    }

    public static void o(n nVar) {
        if (nVar != null) {
            String bAK = nVar.bAK();
            x.d("MicroMsg.SnsTranslateManager", "translatePost, id:%s", new Object[]{bAK});
            if (nVar.field_snsId == 0) {
                x.d("MicroMsg.SnsTranslateManager", "translatePost, the id is null or zero");
                nrC.remove(bAK);
                d(bAK, 1, null, null);
                return;
            }
            if (nrC.containsKey(bAK)) {
                b bVar = (b) nrC.get(bAK);
                if (!bVar.dDR || bVar.dHC) {
                    nrC.remove(bAK);
                } else {
                    x.d("MicroMsg.SnsTranslateManager", "translatePost, get from cache, id:%s", new Object[]{bAK});
                    d(bVar.id, 1, bVar.result, bVar.dMB);
                    return;
                }
            }
            if (nVar.bAJ() != null) {
                String str = nVar.bAJ().spZ;
                rt rtVar = new rt();
                rtVar.ccE.id = bAK;
                rtVar.ccE.ccF = str;
                rtVar.ccE.type = 2;
                a.sFg.m(rtVar);
                ca(nVar.bAK(), 1);
                a aVar = new a((byte) 0);
                aVar.id = bAK;
                aVar.nrF = str;
                aVar.type = 2;
                nrD.add(aVar);
            }
        }
    }

    public static void a(b bVar) {
        if ((bVar.csE & 2) != 0) {
            bVar.nrH = false;
        } else if ((bVar.csE & 4) != 0) {
            bVar.nrI = false;
        }
        nrC.put(bVar.id, bVar);
    }

    private static void b(b bVar) {
        if ((bVar.csE & 2) != 0) {
            bVar.nrH = true;
        } else if ((bVar.csE & 4) != 0) {
            bVar.nrI = true;
        }
        nrC.put(bVar.id, bVar);
    }

    public static void p(n nVar) {
        if (nVar != null) {
            String bAK = nVar.bAK();
            b(Mq(bAK));
            qp qpVar = new qp();
            qpVar.cbf.type = 1;
            qpVar.cbf.id = bAK;
            a.sFg.m(qpVar);
            x.d("MicroMsg.SnsTranslateManager", "unTranslatePost, id:%s", new Object[]{bAK});
        }
    }

    public static void a(m mVar) {
        if (mVar != null && mVar.noe != null) {
            long j;
            String str = mVar.jSA;
            StringBuilder stringBuilder = new StringBuilder();
            if (mVar.noe.smh != 0) {
                j = (long) mVar.noe.smh;
            } else {
                j = mVar.noe.smk;
            }
            String ez = ez(mVar.nMv, stringBuilder.append(j).toString());
            if (nrC.containsKey(ez)) {
                b bVar = (b) nrC.get(ez);
                if (!bVar.dDR || bi.oW(bVar.result)) {
                    nrC.remove(ez);
                } else {
                    x.d("MicroMsg.SnsTranslateManager", "translateComment, get from cache, id:%s", new Object[]{ez});
                    d(bVar.id, 2, bVar.result, bVar.dMB);
                    return;
                }
            }
            rt rtVar = new rt();
            rtVar.ccE.id = ez;
            rtVar.ccE.ccF = str;
            rtVar.ccE.type = 3;
            a.sFg.m(rtVar);
            ca(ez, 2);
            a aVar = new a((byte) 0);
            aVar.id = ez;
            aVar.nrF = str;
            aVar.type = 3;
            nrD.add(aVar);
            x.d("MicroMsg.SnsTranslateManager", "translateComment, id:%s", new Object[]{aVar.id});
        }
    }

    public static void b(m mVar) {
        if (mVar != null) {
            String ez = ez(mVar.nMv, (mVar.noe.smh != 0 ? (long) mVar.noe.smh : mVar.noe.smk));
            b(Mq(ez));
            qp qpVar = new qp();
            qpVar.cbf.type = 2;
            qpVar.cbf.id = ez;
            a.sFg.m(qpVar);
            x.d("MicroMsg.SnsTranslateManager", "unTranslateComment, id:%s", new Object[]{ez});
        }
    }

    private static void ca(String str, int i) {
        if (!nrC.containsKey(str)) {
            b bVar = new b();
            bVar.id = str;
            bVar.dMB = null;
            bVar.result = null;
            bVar.dDR = false;
            bVar.dHC = false;
            bVar.nrI = true;
            bVar.nrH = true;
            nrC.put(str, bVar);
        }
        qo qoVar = new qo();
        qoVar.cbe.type = i;
        qoVar.cbe.id = str;
        a.sFg.m(qoVar);
    }

    private static void d(String str, int i, String str2, String str3) {
        if (nrC.containsKey(str)) {
            b bVar = (b) nrC.get(str);
            bVar.dMB = str3;
            bVar.result = str2;
            bVar.dDR = true;
            bVar.dHC = bi.oW(str2);
            nrC.put(str, bVar);
        }
        if (bi.oW(str2)) {
            Toast.makeText(ad.getContext(), j.sns_translate_failed, 1).show();
        }
        qn qnVar = new qn();
        qnVar.cbc.type = i;
        qnVar.cbc.id = str;
        qnVar.cbc.result = str2;
        qnVar.cbc.cbd = str3;
        a.sFg.m(qnVar);
    }

    public static String ez(String str, String str2) {
        return str + ";" + str2;
    }

    public static HashMap<String, b> byQ() {
        return nrC;
    }

    public static void cb(String str, int i) {
        if (nrC.containsKey(str)) {
            b bVar = (b) nrC.get(str);
            bVar.csE |= i;
            nrC.put(str, bVar);
        }
    }

    public static void cc(String str, int i) {
        if (nrC.containsKey(str)) {
            b bVar = (b) nrC.get(str);
            bVar.csE &= i ^ -1;
            if (i != 2 && i == 4) {
                bVar.nrI = true;
            }
            nrC.put(str, bVar);
        }
    }

    public static boolean cd(String str, int i) {
        if (!nrC.containsKey(str)) {
            return false;
        }
        if ((((b) nrC.get(str)).csE & i) != 0) {
            return true;
        }
        return false;
    }

    public static boolean c(b bVar) {
        if (bVar == null || (bVar.csE & 2) == 0) {
            return false;
        }
        return true;
    }

    public static b Mq(String str) {
        if (nrC.containsKey(str)) {
            return (b) nrC.get(str);
        }
        return null;
    }
}
