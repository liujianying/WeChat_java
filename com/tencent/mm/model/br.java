package com.tencent.mm.model;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.aqa;
import com.tencent.mm.protocal.c.aqb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class br {
    public static final int dDl;
    public static final int dDm;
    public static final int dDn = (dDl + 2);
    private static br dDq;
    private long dDo = 0;
    private Map<Integer, a> dDp = new HashMap();

    static {
        int hashCode = "kv_key_start".hashCode();
        dDl = hashCode;
        dDm = hashCode + 1;
    }

    private br() {
        this.dDp.put(Integer.valueOf(dDm), new 1(this));
        this.dDp.put(Integer.valueOf(dDn), new a() {
            public final boolean a(bp bpVar) {
                if (System.currentTimeMillis() - bpVar.dDj <= 3600000 || bi.getInt(bpVar.dDi, 0) <= 0) {
                    return false;
                }
                br.r(23, bpVar.dDi + "_43");
                bpVar.dDi = "0";
                bpVar.dDj = System.currentTimeMillis();
                return true;
            }
        });
        this.dDp.put(Integer.valueOf(24), new 16(this));
        this.dDp.put(Integer.valueOf(25), new 17(this));
        this.dDp.put(Integer.valueOf(26), new 18(this));
        this.dDp.put(Integer.valueOf(10071), new a() {
            public final boolean a(bp bpVar) {
                if (System.currentTimeMillis() - bpVar.dDj <= 86400000 || bi.getInt(bpVar.dDi, 0) <= 0) {
                    return false;
                }
                br.r(bpVar.key, "1");
                bpVar.dDi = "0";
                bpVar.dDj = System.currentTimeMillis();
                return true;
            }
        });
        this.dDp.put(Integer.valueOf(10076), new 20(this));
        this.dDp.put(Integer.valueOf(19), new 21(this));
        this.dDp.put(Integer.valueOf(10112), new 22(this));
        this.dDp.put(Integer.valueOf(10113), new 2(this));
        this.dDp.put(Integer.valueOf(10114), new 3(this));
        this.dDp.put(Integer.valueOf(10115), new a() {
            public final boolean a(bp bpVar) {
                if (System.currentTimeMillis() - bpVar.dDj <= 1800000 || bi.getInt(bpVar.dDi, 0) <= 0) {
                    return false;
                }
                br.r(bpVar.key, bpVar.dDi);
                bpVar.dDi = "0";
                bpVar.dDj = System.currentTimeMillis();
                return true;
            }
        });
        this.dDp.put(Integer.valueOf(10240), new 5(this));
        this.dDp.put(Integer.valueOf(10241), new 6(this));
        this.dDp.put(Integer.valueOf(15), new 7(this));
        this.dDp.put(Integer.valueOf(16), new 8(this));
        this.dDp.put(Integer.valueOf(27), new a() {
            public final boolean a(bp bpVar) {
                if (System.currentTimeMillis() - bpVar.dDj <= 1800000 || bi.getInt(bpVar.dDi, 0) <= 0) {
                    return false;
                }
                br.r(bpVar.key, bpVar.dDi);
                bpVar.dDi = "0";
                bpVar.dDj = System.currentTimeMillis();
                return true;
            }
        });
        this.dDp.put(Integer.valueOf(38), new 10(this));
        this.dDp.put(Integer.valueOf(10090), new 11(this));
        this.dDp.put(Integer.valueOf(10237), new 13(this));
        this.dDp.put(Integer.valueOf(10238), new a() {
            public final boolean a(bp bpVar) {
                if (System.currentTimeMillis() - bpVar.dDj <= 1800000 || bi.getInt(bpVar.dDi, 0) <= 0) {
                    return false;
                }
                br.r(bpVar.key, bpVar.dDi);
                bpVar.dDi = "0";
                bpVar.dDj = System.currentTimeMillis();
                return true;
            }
        });
        this.dDp.put(Integer.valueOf(10239), new 15(this));
    }

    public static br IE() {
        if (dDq == null) {
            dDq = new br();
        }
        return dDq;
    }

    public static void r(int i, String str) {
        LinkedList linkedList = new LinkedList();
        aqa aqa = new aqa();
        aqa.mEb = i;
        aqa.mEl = str;
        linkedList.add(aqa);
        b(linkedList);
    }

    public static void b(LinkedList<aqa> linkedList) {
        if (g.Eg().Dx()) {
            g.Eg();
            if (!a.Dr()) {
                aqb aqb = new aqb();
                aqb.hbG = linkedList;
                aqb.hbF = linkedList.size();
                ((i) g.l(i.class)).FQ().b(new h.a(36, aqb));
            }
        }
    }

    public final void c(int i, Object... objArr) {
        a aVar = (a) this.dDp.get(Integer.valueOf(i));
        if (aVar != null) {
            bq IG = IG();
            for (bp bpVar : IG.dDk) {
                if (bpVar.key == i) {
                    aVar.a(bpVar, objArr);
                    break;
                }
            }
            IG.dDk.add(aVar.d(i, objArr));
            a(IG);
        }
    }

    public final void IF() {
        if (System.currentTimeMillis() - this.dDo >= 60000) {
            this.dDo = System.currentTimeMillis();
            try {
                bq IG = IG();
                int i = 0;
                for (bp bpVar : IG.dDk) {
                    int i2;
                    a aVar = (a) this.dDp.get(Integer.valueOf(bpVar.key));
                    if (aVar == null || !aVar.a(bpVar)) {
                        i2 = i;
                    } else {
                        i2 = 1;
                    }
                    i = i2;
                }
                if (i != 0) {
                    a(IG);
                }
            } catch (Throwable e) {
                x.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", new Object[]{bi.i(e)});
            }
        }
    }

    private static bq IG() {
        if (g.Eg().Dx()) {
            g.Eg();
            if (!(a.Dr() || g.Ei().DT() == null)) {
                byte[] WP = bi.WP((String) g.Ei().DT().get(8215, null));
                if (WP.length <= 0) {
                    return new bq();
                }
                try {
                    bq bqVar = new bq();
                    bqVar.aG(WP);
                    return bqVar;
                } catch (Throwable e) {
                    x.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", new Object[]{bi.i(e)});
                }
            }
        }
        return new bq();
    }

    private static void a(bq bqVar) {
        if (bqVar != null && g.Eg().Dx() && g.Ei().DT() != null) {
            g.Eg();
            if (!a.Dr()) {
                try {
                    g.Ei().DT().set(8215, bi.bE(bqVar.toByteArray()));
                } catch (Throwable e) {
                    x.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", new Object[]{bi.i(e)});
                }
            }
        }
    }
}
