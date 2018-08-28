package com.google.android.gms.tagmanager;

import com.google.android.gms.c.at;
import com.google.android.gms.c.at$b;
import com.google.android.gms.c.b.a;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class ac {
    private static final v<a> bbU = new v(ai.rC(), true);
    private final f bbV;
    private final Map<String, g> bbW;
    private final Map<String, g> bbX;
    private final Map<String, g> bbY;
    private final al<at.a, v<a>> bbZ;
    private final c bby;
    private final al<String, b> bca;
    private final Set<at$b> bcb;
    private final Map<String, c> bcc;
    private volatile String bcd;
    private int bce;

    private v<Boolean> a(at.a aVar, Set<String> set, x xVar) {
        v a = a(this.bbX, aVar, (Set) set, xVar);
        Boolean c = ai.c((a) a.bbK);
        ai.ao(c);
        return new v(c, a.bbL);
    }

    private v<Boolean> a(at$b at_b, Set<String> set, aa aaVar) {
        v a;
        boolean z = true;
        for (at.a a2 : at_b.aZo) {
            a = a(a2, (Set) set, aaVar.rk());
            if (((Boolean) a.bbK).booleanValue()) {
                ai.ao(Boolean.valueOf(false));
                return new v(Boolean.valueOf(false), a.bbL);
            }
            boolean z2 = z && a.bbL;
            z = z2;
        }
        for (at.a a22 : at_b.aZn) {
            a = a(a22, (Set) set, aaVar.rl());
            if (((Boolean) a.bbK).booleanValue()) {
                z = z && a.bbL;
            } else {
                ai.ao(Boolean.valueOf(false));
                return new v(Boolean.valueOf(false), a.bbL);
            }
        }
        ai.ao(Boolean.valueOf(true));
        return new v(Boolean.valueOf(true), z);
    }

    private v<a> a(a aVar, Set<String> set, aj ajVar) {
        if (!aVar.aWk) {
            return new v(aVar, true);
        }
        a a;
        int i;
        v a2;
        switch (aVar.type) {
            case 2:
                a = at.a(aVar);
                a.aWb = new a[aVar.aWb.length];
                for (i = 0; i < aVar.aWb.length; i++) {
                    a2 = a(aVar.aWb[i], (Set) set, ajVar.rr());
                    if (a2 == bbU) {
                        return bbU;
                    }
                    a.aWb[i] = (a) a2.bbK;
                }
                return new v(a, false);
            case 3:
                a = at.a(aVar);
                if (aVar.aWc.length != aVar.aWd.length) {
                    new StringBuilder("Invalid serving value: ").append(aVar.toString());
                    m.rb();
                    return bbU;
                }
                a.aWc = new a[aVar.aWc.length];
                a.aWd = new a[aVar.aWc.length];
                for (i = 0; i < aVar.aWc.length; i++) {
                    a2 = a(aVar.aWc[i], (Set) set, ajVar.rs());
                    v a3 = a(aVar.aWd[i], (Set) set, ajVar.rt());
                    if (a2 == bbU || a3 == bbU) {
                        return bbU;
                    }
                    a.aWc[i] = (a) a2.bbK;
                    a.aWd[i] = (a) a3.bbK;
                }
                return new v(a, false);
            case 4:
                if (set.contains(aVar.aWe)) {
                    new StringBuilder("Macro cycle detected.  Current macro reference: ").append(aVar.aWe).append(".  Previous macro references: ").append(set.toString()).append(".");
                    m.rb();
                    return bbU;
                }
                set.add(aVar.aWe);
                v<a> a4 = ak.a(a(aVar.aWe, (Set) set, ajVar.rv()), aVar.aWj);
                set.remove(aVar.aWe);
                return a4;
            case 7:
                a = at.a(aVar);
                a.aWi = new a[aVar.aWi.length];
                for (i = 0; i < aVar.aWi.length; i++) {
                    a2 = a(aVar.aWi[i], (Set) set, ajVar.ru());
                    if (a2 == bbU) {
                        return bbU;
                    }
                    a.aWi[i] = (a) a2.bbK;
                }
                return new v(a, false);
            default:
                new StringBuilder("Unknown type: ").append(aVar.type);
                m.rb();
                return bbU;
        }
    }

    private v<a> a(String str, Set<String> set, o oVar) {
        this.bce++;
        b bVar = (b) this.bca.rD();
        if (bVar == null || this.bbV.qY()) {
            c cVar = (c) this.bcc.get(str);
            if (cVar == null) {
                new StringBuilder().append(ry()).append("Invalid macro: ").append(str);
                m.rb();
                this.bce--;
                return bbU;
            }
            at.a aVar;
            v a = a(cVar.bcb, cVar.bcl, cVar.bcn, cVar.bcm, cVar.bco, set, oVar.rh());
            if (((Set) a.bbK).isEmpty()) {
                aVar = cVar.bcp;
            } else {
                if (((Set) a.bbK).size() > 1) {
                    new StringBuilder().append(ry()).append("Multiple macros active for macroName ").append(str);
                    m.rd();
                }
                aVar = (at.a) ((Set) a.bbK).iterator().next();
            }
            if (aVar == null) {
                this.bce--;
                return bbU;
            }
            v a2 = a(this.bbY, aVar, (Set) set, oVar.rg());
            boolean z = a.bbL && a2.bbL;
            v<a> vVar = a2 == bbU ? bbU : new v(a2.bbK, z);
            a aVar2 = aVar.aZm;
            if (vVar.bbL) {
                b bVar2 = new b(vVar, aVar2);
            }
            a(aVar2, set);
            this.bce--;
            return vVar;
        }
        a(bVar.aZm, set);
        this.bce--;
        return bVar.bck;
    }

    private v<a> a(Map<String, g> map, at.a aVar, Set<String> set, x xVar) {
        a aVar2 = (a) Collections.unmodifiableMap(aVar.aZl).get(com.google.android.gms.c.a.aTv.toString());
        if (aVar2 == null) {
            m.rb();
            return bbU;
        }
        String str = aVar2.aWf;
        g gVar = (g) map.get(str);
        if (gVar == null) {
            new StringBuilder().append(str).append(" has no backing implementation.");
            m.rb();
            return bbU;
        }
        v<a> vVar = (v) this.bbZ.rD();
        if (vVar != null && !this.bbV.qY()) {
            return vVar;
        }
        Map hashMap = new HashMap();
        Object obj = 1;
        for (Entry entry : Collections.unmodifiableMap(aVar.aZl).entrySet()) {
            entry.getKey();
            z ri = xVar.ri();
            a aVar3 = (a) entry.getValue();
            entry.getValue();
            v a = a(aVar3, (Set) set, ri.rj());
            if (a == bbU) {
                return bbU;
            }
            Object obj2;
            if (a.bbL) {
                aVar.aZl.put((String) entry.getKey(), (a) a.bbK);
                obj2 = obj;
            } else {
                obj2 = null;
            }
            hashMap.put(entry.getKey(), a.bbK);
            obj = obj2;
        }
        if (hashMap.keySet().containsAll(gVar.bbF)) {
            boolean z = obj != null && gVar.qZ();
            return new v(gVar.ra(), z);
        }
        new StringBuilder("Incorrect keys for function ").append(str).append(" required ").append(gVar.bbF).append(" had ").append(hashMap.keySet());
        m.rb();
        return bbU;
    }

    private v<Set<at.a>> a(Set<at$b> set, Map<at$b, List<at.a>> map, Map<at$b, List<String>> map2, Map<at$b, List<at.a>> map3, Map<at$b, List<String>> map4, Set<String> set2, ab abVar) {
        return a((Set) set, (Set) set2, new 1(this, map, map2, map3, map4), abVar);
    }

    private v<Set<at.a>> a(Set<at$b> set, Set<String> set2, a aVar, ab abVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (at$b at_b : set) {
            aa rq = abVar.rq();
            v a = a(at_b, (Set) set2, rq);
            if (((Boolean) a.bbK).booleanValue()) {
                aVar.a(at_b, hashSet, hashSet2, rq);
            }
            boolean z2 = z && a.bbL;
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        return new v(hashSet, z);
    }

    private void a(a aVar, Set<String> set) {
        if (aVar != null) {
            v a = a(aVar, (Set) set, new u());
            if (a != bbU) {
                Object d = ai.d((a) a.bbK);
                if (d instanceof Map) {
                    this.bby.d((Map) d);
                } else if (d instanceof List) {
                    for (Object d2 : (List) d2) {
                        if (d2 instanceof Map) {
                            this.bby.d((Map) d2);
                        } else {
                            m.rd();
                        }
                    }
                } else {
                    m.rd();
                }
            }
        }
    }

    private synchronized void bA(String str) {
        this.bcd = str;
    }

    private String ry() {
        if (this.bce <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.bce));
        for (int i = 2; i < this.bce; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    public final synchronized void bz(String str) {
        bA(str);
        ao qW = this.bbV.qX().qW();
        for (at.a a : (Set) a(this.bcb, new HashSet(), new a() {
            public final void a(at$b at_b, Set<at.a> set, Set<at.a> set2, aa aaVar) {
                set.addAll(at_b.aZp);
                set2.addAll(at_b.aZq);
                aaVar.ro();
                aaVar.rp();
            }
        }, qW.rh()).bbK) {
            a(this.bbW, a, new HashSet(), qW.rH());
        }
        bA(null);
    }
}
