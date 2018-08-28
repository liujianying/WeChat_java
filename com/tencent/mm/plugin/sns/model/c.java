package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.protocal.c.bsv;
import com.tencent.mm.protocal.c.vu;
import com.tencent.mm.protocal.c.xs;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    public static void d(String str, long j, long j2, int i) {
        if (j2 != 0) {
            xs xsVar;
            xs Nn = af.bys().Nn(str);
            if (Nn == null) {
                xsVar = new xs();
            } else {
                xsVar = Nn;
            }
            if (j != 0 || !xsVar.rDy.isEmpty()) {
                vu vuVar;
                if (j == 0) {
                    j = ((vu) xsVar.rDy.getFirst()).rza;
                }
                vu vuVar2 = new vu();
                vuVar2.rza = j;
                vuVar2.rzb = j2;
                bsv bsv = new bsv();
                bsv.sqk = j;
                bsv.sqm = j2;
                bsv.sqn = i;
                vuVar2.rzc.add(bsv);
                while (true) {
                    vuVar = vuVar2;
                    if (xsVar.rDy.isEmpty()) {
                        break;
                    }
                    vuVar2 = (vu) xsVar.rDy.getFirst();
                    if (A(vuVar.rzb, vuVar2.rza) > 0) {
                        x.e("MicroMsg.FaultLogic", "has a fault: newerMin:" + vuVar.rzb + " fault.Max" + vuVar2.rza);
                        break;
                    } else {
                        xsVar.rDy.removeFirst();
                        vuVar2 = a(vuVar2, vuVar);
                    }
                }
                xsVar.rDy.addFirst(vuVar);
                while (xsVar.rDy.size() > 100) {
                    xsVar.rDy.removeLast();
                }
                if (xsVar.rDy.size() > 0) {
                    x.d("MicroMsg.FaultLogic", "min " + ((vu) xsVar.rDy.get(0)).rzb + " max " + ((vu) xsVar.rDy.get(0)).rza);
                }
                l Np = af.bys().Np(str);
                try {
                    Np.field_userName = str;
                    Np.field_faultS = xsVar.toByteArray();
                    af.bys().c(Np);
                } catch (Exception e) {
                }
                if (xsVar.rDy.size() > 1) {
                    x.d("MicroMsg.FaultLogic", "fault size : " + xsVar.rDy.size());
                    Iterator it = xsVar.rDy.iterator();
                    while (it.hasNext()) {
                        vuVar2 = (vu) it.next();
                        x.d("MicroMsg.FaultLogic", "min - max " + vuVar2.rzb + " " + vuVar2.rza);
                    }
                }
            }
        }
    }

    private static vu a(vu vuVar, vu vuVar2) {
        vu vuVar3 = new vu();
        if (A(vuVar.rza, vuVar2.rza) > 0) {
            vuVar3.rza = vuVar.rza;
        } else {
            vuVar3.rza = vuVar2.rza;
        }
        if (A(vuVar.rzb, vuVar2.rzb) < 0) {
            vuVar3.rzb = vuVar.rzb;
        } else {
            vuVar3.rzb = vuVar2.rzb;
        }
        LinkedList linkedList = vuVar.rzc;
        Iterator it = vuVar2.rzc.iterator();
        while (it.hasNext()) {
            bsv bsv = (bsv) it.next();
            if (linkedList.isEmpty()) {
                x.e("MicroMsg.FaultLogic", "fault's segments should not empty!!");
                linkedList.addFirst(bsv);
            } else {
                int i;
                long j = bsv.sqm;
                int size = linkedList.size() - 1;
                while (size >= 0) {
                    if (A(j, ((bsv) linkedList.get(size)).sqk) <= 0) {
                        break;
                    }
                    size--;
                }
                size = -1;
                j = bsv.sqk;
                int i2 = 0;
                while (true) {
                    i = i2;
                    if (i >= linkedList.size()) {
                        i = linkedList.size();
                        break;
                    } else if (A(j, ((bsv) linkedList.get(i)).sqm) >= 0) {
                        break;
                    } else {
                        i2 = i + 1;
                    }
                }
                if (size == -1) {
                    linkedList.addFirst(bsv);
                } else if (i == linkedList.size()) {
                    linkedList.addLast(bsv);
                } else {
                    bsv bsv2 = (bsv) linkedList.get(i);
                    if (A(bsv.sqk, bsv2.sqk) < 0) {
                        bsv bsv3 = new bsv();
                        bsv3.sqk = bsv2.sqk;
                        j = bsv.sqk;
                        bsv3.sqm = j == Long.MAX_VALUE ? Long.MIN_VALUE : j + 1;
                        bsv3.sqn = bsv2.sqn;
                        linkedList.add(i, bsv3);
                        size++;
                        i++;
                    }
                    bsv2 = (bsv) linkedList.get(size);
                    if (A(bsv.sqm, bsv2.sqm) > 0) {
                        bsv bsv4 = new bsv();
                        bsv4.sqm = bsv2.sqm;
                        bsv4.sqk = eJ(bsv.sqm);
                        bsv4.sqn = bsv2.sqn;
                        linkedList.add(size + 1, bsv4);
                    }
                    while (size >= i) {
                        linkedList.remove(size);
                        size--;
                    }
                    linkedList.add(i, bsv);
                    if (linkedList.size() > 100) {
                        long j2;
                        long j3 = ((bsv) linkedList.getLast()).sqm;
                        long j4 = ((bsv) linkedList.getLast()).sqk;
                        int i3 = ((bsv) linkedList.getLast()).sqn;
                        while (true) {
                            j2 = j4;
                            if (linkedList.size() < 100) {
                                break;
                            }
                            bsv = (bsv) linkedList.removeLast();
                            j4 = bsv.sqk;
                            if (bsv.sqn < i3) {
                                i3 = bsv.sqn;
                            }
                        }
                        bsv bsv5 = new bsv();
                        bsv5.sqk = j2;
                        bsv5.sqm = j3;
                        bsv5.sqn = i3;
                        linkedList.addLast(bsv5);
                    }
                }
            }
        }
        vuVar3.rzc = linkedList;
        return vuVar3;
    }

    private static long A(long j, long j2) {
        if ((j <= 0 || j2 <= 0) && (j >= 0 || j2 >= 0)) {
            return j < 0 ? 1 : -1;
        } else {
            return j - j2;
        }
    }

    public static long eJ(long j) {
        if (j == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        }
        return j - 1;
    }

    public static int a(long j, long j2, String str) {
        LinkedList linkedList = af.bys().Nn(str).rDy;
        x.i("MicroMsg.FaultLogic", "getLastReqTimeByMinId fault.count %s", new Object[]{Integer.valueOf(r0.rDy.size())});
        if (linkedList.isEmpty()) {
            return 0;
        }
        vu vuVar = (vu) linkedList.getFirst();
        if (j == 0 || A(vuVar.rzb, j) > 0) {
            x.e("MicroMsg.FaultLogic", "has a fault  minId:" + j2 + " fault.min:" + vuVar.rzb);
            return 0;
        } else if (j2 == 0 || A(vuVar.rza, j2) >= 0) {
            LinkedList linkedList2 = vuVar.rzc;
            if (linkedList2.isEmpty()) {
                return 0;
            }
            Iterator it = linkedList2.iterator();
            int i = Integer.MAX_VALUE;
            while (it.hasNext()) {
                bsv bsv = (bsv) it.next();
                if (j2 == 0 || A(j2, bsv.sqm) >= 0) {
                    if (bsv.sqn < i) {
                        i = bsv.sqn;
                    }
                    if (A(j, bsv.sqm) >= 0) {
                        if (i == Integer.MAX_VALUE) {
                            return 0;
                        }
                        return i;
                    }
                }
            }
            x.i("MicroMsg.FaultLogic", "should not to hear  minId:" + j);
            return 0;
        } else {
            x.e("MicroMsg.FaultLogic", ":" + j2 + " fault.max:" + vuVar.rza);
            return 0;
        }
    }
}
