package com.tencent.mm.ar;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.br;
import com.tencent.mm.protocal.c.aqa;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class p extends c<lw> {
    public p() {
        this.sFo = lw.class.getName().hashCode();
    }

    private static boolean Qn() {
        int i;
        boolean z;
        if (g.Eg().Dx()) {
            g.Eg();
            if (!a.Dr()) {
                i = 1;
                if (i != 0) {
                    if (bi.bG(bi.a((Long) g.Ei().DT().get(68097, null), 0)) * 1000 > 3600000) {
                        i = 1;
                    } else {
                        z = false;
                    }
                    if (i != 0) {
                        LinkedList linkedList = new LinkedList();
                        byte[] f = e.f(g.Ei().cachePath + "eggresult.rep", 0, -1);
                        if (f != null) {
                            try {
                                Iterator it = ((h) new h().aG(f)).ecN.iterator();
                                while (it.hasNext()) {
                                    aqa aqa;
                                    g gVar = (g) it.next();
                                    if (gVar.ecL != 0) {
                                        aqa = new aqa();
                                        aqa.mEb = 17;
                                        aqa.mEl = gVar.ecA + "," + gVar.ecL;
                                        linkedList.add(aqa);
                                    }
                                    if (gVar.ecM != 0) {
                                        aqa = new aqa();
                                        aqa.mEb = 18;
                                        aqa.mEl = gVar.ecA + "," + gVar.ecM;
                                        linkedList.add(aqa);
                                    }
                                }
                                e.deleteFile(g.Ei().cachePath + "eggresult.rep");
                            } catch (Throwable e) {
                                x.e("MicroMsg.PostTaskReportEgg", "exception:%s", new Object[]{bi.i(e)});
                            }
                            if (!linkedList.isEmpty()) {
                                br.b(linkedList);
                                g.Ei().DT().set(68097, Long.valueOf(bi.VE()));
                            }
                        }
                        return false;
                    }
                }
                x.d("MicroMsg.PostTaskReportEgg", "report egg done");
                return false;
            }
        }
        z = false;
        if (i != 0) {
            if (bi.bG(bi.a((Long) g.Ei().DT().get(68097, null), 0)) * 1000 > 3600000) {
                i = 1;
            } else {
                z = false;
            }
            if (i != 0) {
                LinkedList linkedList2 = new LinkedList();
                byte[] f2 = e.f(g.Ei().cachePath + "eggresult.rep", 0, -1);
                if (f2 != null) {
                    try {
                        Iterator it2 = ((h) new h().aG(f2)).ecN.iterator();
                        while (it2.hasNext()) {
                            aqa aqa2;
                            g gVar2 = (g) it2.next();
                            if (gVar2.ecL != 0) {
                                aqa2 = new aqa();
                                aqa2.mEb = 17;
                                aqa2.mEl = gVar2.ecA + "," + gVar2.ecL;
                                linkedList2.add(aqa2);
                            }
                            if (gVar2.ecM != 0) {
                                aqa2 = new aqa();
                                aqa2.mEb = 18;
                                aqa2.mEl = gVar2.ecA + "," + gVar2.ecM;
                                linkedList2.add(aqa2);
                            }
                        }
                        e.deleteFile(g.Ei().cachePath + "eggresult.rep");
                    } catch (Throwable e2) {
                        x.e("MicroMsg.PostTaskReportEgg", "exception:%s", new Object[]{bi.i(e2)});
                    }
                    if (!linkedList2.isEmpty()) {
                        br.b(linkedList2);
                        g.Ei().DT().set(68097, Long.valueOf(bi.VE()));
                    }
                }
                return false;
            }
        }
        x.d("MicroMsg.PostTaskReportEgg", "report egg done");
        return false;
    }
}
