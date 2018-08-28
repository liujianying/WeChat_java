package com.tencent.mm.plugin.sns;

import com.tencent.mm.aq.h;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class g extends c<lw> {
    public g() {
        this.sFo = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!(((lw) bVar) instanceof lw)) {
            x.f("MicroMsg.PostSnsAsyncTaskListener", "mismatched event");
            return false;
        } else if (af.bxX()) {
            return false;
        } else {
            int i;
            x.d("MicroMsg.PostSnsAsyncTask", "check PostTaskSnsPost ");
            if (af.byk() != null) {
                af.byk().bwX();
            }
            x.d("MicroMsg.PostSnsAsyncTask", "check AsyncQueue");
            if (af.bye() != null) {
                af.byn().bxP();
            }
            com.tencent.mm.kernel.g.Ek();
            if (com.tencent.mm.kernel.g.Eg().Dx()) {
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Eg();
                if (!a.Dr()) {
                    i = 1;
                    if (i != 0) {
                        com.tencent.mm.kernel.g.Ek();
                        if ((bi.bG(bi.a((Long) com.tencent.mm.kernel.g.Ei().DT().get(68390, null), 0)) * 1000 > 3600000 ? 1 : 0) != 0) {
                            List linkedList = new LinkedList();
                            com.tencent.mm.kernel.g.Ek();
                            int a = bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(68388, null), 0);
                            com.tencent.mm.kernel.g.Ek();
                            i = bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(68389, null), 0);
                            if (a > 0 || i > 0) {
                                linkedList.add(new h.a(10077, a + "," + i));
                                com.tencent.mm.kernel.g.Ek();
                                com.tencent.mm.kernel.g.Ei().DT().set(68388, Integer.valueOf(0));
                                com.tencent.mm.kernel.g.Ek();
                                com.tencent.mm.kernel.g.Ei().DT().set(68389, Integer.valueOf(0));
                            }
                            com.tencent.mm.kernel.g.Ek();
                            i = bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(68391, null), 0);
                            if (i > 0) {
                                linkedList.add(new h.a(28, String.valueOf(i)));
                                com.tencent.mm.kernel.g.Ek();
                                com.tencent.mm.kernel.g.Ei().DT().set(68391, Integer.valueOf(0));
                            }
                            com.tencent.mm.kernel.g.Ek();
                            a = bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(68392, null), 0);
                            com.tencent.mm.kernel.g.Ek();
                            i = bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(68393, null), 0);
                            if (a > 0 || i > 0) {
                                linkedList.add(new h.a(10072, a + "," + i));
                                com.tencent.mm.kernel.g.Ek();
                                com.tencent.mm.kernel.g.Ei().DT().set(68392, Integer.valueOf(0));
                                com.tencent.mm.kernel.g.Ek();
                                com.tencent.mm.kernel.g.Ei().DT().set(68393, Integer.valueOf(0));
                            }
                            if (!linkedList.isEmpty()) {
                                com.tencent.mm.kernel.g.Ek();
                                ((i) com.tencent.mm.kernel.g.l(i.class)).FQ().b(new h(linkedList));
                                com.tencent.mm.kernel.g.Ek();
                                com.tencent.mm.kernel.g.Ei().DT().set(68390, Long.valueOf(bi.VE()));
                            }
                        }
                    }
                    return true;
                }
            }
            i = 0;
            if (i != 0) {
                com.tencent.mm.kernel.g.Ek();
                if ((bi.bG(bi.a((Long) com.tencent.mm.kernel.g.Ei().DT().get(68390, null), 0)) * 1000 > 3600000 ? 1 : 0) != 0) {
                    List linkedList2 = new LinkedList();
                    com.tencent.mm.kernel.g.Ek();
                    int a2 = bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(68388, null), 0);
                    com.tencent.mm.kernel.g.Ek();
                    i = bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(68389, null), 0);
                    if (a2 > 0 || i > 0) {
                        linkedList2.add(new h.a(10077, a2 + "," + i));
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Ei().DT().set(68388, Integer.valueOf(0));
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Ei().DT().set(68389, Integer.valueOf(0));
                    }
                    com.tencent.mm.kernel.g.Ek();
                    i = bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(68391, null), 0);
                    if (i > 0) {
                        linkedList2.add(new h.a(28, String.valueOf(i)));
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Ei().DT().set(68391, Integer.valueOf(0));
                    }
                    com.tencent.mm.kernel.g.Ek();
                    a2 = bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(68392, null), 0);
                    com.tencent.mm.kernel.g.Ek();
                    i = bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(68393, null), 0);
                    if (a2 > 0 || i > 0) {
                        linkedList2.add(new h.a(10072, a2 + "," + i));
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Ei().DT().set(68392, Integer.valueOf(0));
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Ei().DT().set(68393, Integer.valueOf(0));
                    }
                    if (!linkedList2.isEmpty()) {
                        com.tencent.mm.kernel.g.Ek();
                        ((i) com.tencent.mm.kernel.g.l(i.class)).FQ().b(new h(linkedList2));
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Ei().DT().set(68390, Long.valueOf(bi.VE()));
                    }
                }
            }
            return true;
        }
    }
}
