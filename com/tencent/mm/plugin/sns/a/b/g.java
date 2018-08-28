package com.tencent.mm.plugin.sns.a.b;

import android.app.Activity;
import android.view.View;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.a.b.a.1;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public final class g implements b {
    public static Map<String, Integer> niX = new HashMap();
    public Activity activity;
    long hmf = 0;
    public HashMap<String, Long> niM = new HashMap();
    public HashSet<Long> niN = new HashSet();
    private Map<String, Long> niO = new HashMap();
    private Map<String, Integer> niP = new HashMap();
    private Map<String, a> niQ = new HashMap();
    public HashSet<Long> niR = new HashSet();
    public Map<Long, h> niS = new HashMap();
    public Map<Long, h> niT = new HashMap();
    public Map<String, a> niU = new HashMap();
    private LinkedList<String> niV = new LinkedList();
    private Map<String, Integer> niW = new HashMap();
    private int niY = 0;
    public View niZ = null;
    public int nig = 0;
    public Map<Long, Integer> nja = new HashMap();
    public Map<Long, Integer> njb = new HashMap();
    private int njc = -1;
    public int sceneType = 1;

    public final boolean ex(long j) {
        return this.niN.contains(Long.valueOf(j));
    }

    public g(int i) {
        this.sceneType = i;
    }

    public final void onResume() {
        if (this.hmf > 0) {
            long bI = bi.bI(this.hmf);
            for (String str : this.niU.keySet()) {
                x.i("MicroMsg.SnsAdStatistic", "before Key " + str + " " + ((a) this.niU.get(str)).time);
            }
            for (String str2 : this.niU.keySet()) {
                a aVar = (a) this.niU.get(str2);
                aVar.time += bI;
                if (aVar.nji > 0) {
                    aVar.nji += bI;
                }
                h hVar = (h) this.niS.get(Long.valueOf(aVar.egG));
                if (hVar != null) {
                    hVar.onResume();
                }
                h hVar2 = (h) this.niT.get(Long.valueOf(aVar.egG));
                if (hVar2 != null) {
                    hVar2.onResume();
                }
            }
            for (String str22 : this.niU.keySet()) {
                x.i("MicroMsg.SnsAdStatistic", "update Key " + str22 + " " + ((a) this.niU.get(str22)).time);
            }
        }
    }

    public final void o(long j, boolean z) {
        ah.A(new 1(this, j, z));
    }

    public final void d(long j, int i, boolean z) {
        ah.A(new 2(this, j, i, z));
    }

    public final void p(long j, boolean z) {
        a(j, 0, z, false);
    }

    public final void a(long j, int i, boolean z, boolean z2) {
        h hVar;
        if (z2) {
            if (this.niT.containsKey(Long.valueOf(j))) {
                hVar = (h) this.niT.get(Long.valueOf(j));
            } else {
                hVar = new h("timeline");
            }
        } else if (this.niS.containsKey(Long.valueOf(j))) {
            hVar = (h) this.niS.get(Long.valueOf(j));
        } else {
            hVar = new h("timeline");
        }
        if (i > 0) {
            hVar.nju = (long) i;
            hVar.njs.nkr = i;
        }
        hVar.njk = z ? 1 : 0;
        if (z2) {
            this.niT.put(Long.valueOf(j), hVar);
        } else {
            this.niS.put(Long.valueOf(j), hVar);
        }
    }

    public final void q(long j, boolean z) {
        a(j, z, false);
    }

    public final void a(long j, boolean z, boolean z2) {
        h hVar;
        if (z2) {
            if (this.niT.containsKey(Long.valueOf(j))) {
                hVar = (h) this.niT.get(Long.valueOf(j));
            } else {
                hVar = new h("timeline");
            }
        } else if (this.niS.containsKey(Long.valueOf(j))) {
            hVar = (h) this.niS.get(Long.valueOf(j));
        } else {
            hVar = new h("timeline");
        }
        if (z) {
            hVar.njs.nks = 2;
        } else {
            hVar.njs.nks = 1;
        }
        hVar.njs.nkt = 1;
        if (z2) {
            this.niT.put(Long.valueOf(j), hVar);
        } else {
            this.niS.put(Long.valueOf(j), hVar);
        }
    }

    public final void z(long j, long j2) {
        ah.A(new 3(this, j, j2));
    }

    public final boolean ey(long j) {
        if (this.niR.contains(Long.valueOf(j))) {
            return true;
        }
        return false;
    }

    public final void b(long j, long j2, boolean z) {
        ah.A(new 4(this, j, j2, z));
    }

    public final void r(long j, boolean z) {
        Object obj;
        if (z) {
            if (this.niT.containsKey(Long.valueOf(j))) {
                obj = (h) this.niT.get(Long.valueOf(j));
                obj.wh(0);
            } else {
                obj = new h("timeline");
            }
            this.niT.put(Long.valueOf(j), obj);
            return;
        }
        if (this.niS.containsKey(Long.valueOf(j))) {
            obj = (h) this.niS.get(Long.valueOf(j));
            obj.wh(0);
        } else {
            obj = new h("timeline");
        }
        this.niS.put(Long.valueOf(j), obj);
    }

    public final void onPause() {
        this.hmf = bi.VG();
        for (String str : this.niU.keySet()) {
            a aVar = (a) this.niU.get(str);
            h hVar = (h) this.niS.get(Long.valueOf(aVar.egG));
            if (hVar != null) {
                hVar.egO = bi.VG();
            }
            h hVar2 = (h) this.niT.get(Long.valueOf(aVar.egG));
            if (hVar2 != null) {
                hVar2.egO = bi.VG();
            }
        }
    }

    public final void a(int i, String str, String str2, boolean z, View view, long j, bf bfVar, boy boy, int i2, int i3) {
        this.niN.add(Long.valueOf(j));
        this.niM.put(str, Long.valueOf(j));
        if (this.njc == -1) {
            this.njc = this.activity == null ? -1 : e.eL(this.activity);
        }
        n Nl = af.byo().Nl(str);
        if (Nl == null) {
            x.w("MicroMsg.SnsAdStatistic", "snsinfo not found! skip onAdAdded logic!");
            return;
        }
        a aVar;
        h hVar;
        a aVar2 = (a) this.niQ.get(str);
        if (aVar2 == null && view != null && af.npv) {
            a aVar3 = new a(bfVar == null ? null : bfVar.ohp, str, j, view, this.nig, this.niZ, this.njc, this.sceneType, boy, i, Nl.bAF());
            aVar3.nip = System.currentTimeMillis();
            af.aRu().post(new 1(aVar3));
            this.niQ.put(str, aVar3);
            if (!this.nja.containsKey(Long.valueOf(j))) {
                this.nja.put(Long.valueOf(j), Integer.valueOf(Nl.field_likeFlag == 1 ? 1 : 0));
            }
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (i2 == 12 && Nl.bAJ().sqc.ruA.size() > 1) {
            if (this.niT.containsKey(Long.valueOf(j))) {
                hVar = (h) this.niT.get(Long.valueOf(j));
            } else {
                hVar = new h("timeline");
            }
            hVar.njm = bi.VG();
            this.niT.put(Long.valueOf(j), hVar);
        }
        if (this.niO.containsKey(str)) {
            long bI = bi.bI(((Long) this.niO.get(str)).longValue());
            if (bI < 1200000) {
                int intValue = this.niP.containsKey(str) ? ((Integer) this.niP.get(str)).intValue() : 0;
                if (intValue >= 2) {
                    x.i("MicroMsg.SnsAdStatistic", "passed localid " + str + " viewid " + str2 + " passedTime: " + bI);
                    return;
                }
                this.niP.put(str, Integer.valueOf(intValue + 1));
            } else {
                this.niO.put(str, Long.valueOf(bi.VG()));
                this.niP.put(str, Integer.valueOf(0));
            }
        }
        if (!this.niU.containsKey(str)) {
            l dVar;
            this.niU.put(str, new a(bi.VG(), str, i, str2, i2, j));
            x.i("MicroMsg.SnsAdStatistic", "onAdAdded " + i + " " + str + "  isExposure: " + z);
            if (i2 == 9) {
                if (this.niS.containsKey(Long.valueOf(j))) {
                    hVar = (h) this.niS.get(Long.valueOf(j));
                } else {
                    hVar = new h("timeline");
                }
                hVar.njm = bi.VG();
                this.niS.put(Long.valueOf(j), hVar);
            } else if (i2 == 12 && Nl.bAJ().sqc.ruA.size() > 0 && ((ate) Nl.bAJ().sqc.ruA.get(0)).hcE == 6) {
                if (this.niS.containsKey(Long.valueOf(j))) {
                    hVar = (h) this.niS.get(Long.valueOf(j));
                } else {
                    hVar = new h("timeline");
                }
                hVar.njm = bi.VG();
                hVar.njr = true;
                this.niS.put(Long.valueOf(j), hVar);
            }
            if (!this.niV.contains(str)) {
                this.niV.add(str);
                x.i("MicroMsg.SnsAdStatistic", "exposures item " + str);
                this.niW.put(str, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
            }
            b bAF = Nl.bAF();
            bsu bAJ = Nl.bAJ();
            com.tencent.mm.protocal.c.bi biVar = null;
            if (aVar != null && af.npv) {
                biVar = aVar.bwL();
            }
            com.tencent.mm.plugin.sns.storage.e bBp = Nl.bBp();
            int i4 = 0;
            if (i3 == 1) {
                i4 = bBp.field_exposureCount + 1;
                bBp.field_exposureCount = i4;
                af.byr().c(bBp, new String[0]);
            }
            if (bAF.bzq()) {
                dVar = new d(str2, this.sceneType, biVar, 3, i4, Nl.bBq());
            } else if (bAJ != null && bAJ.sqc.ruz == 27) {
                dVar = new d(str2, this.sceneType, 1, 0, null, biVar, 6, "", i4, Nl.bBq(), 0, 0, Nl.field_likeFlag == 1 ? 2 : 1);
            } else if (bAF.bzr()) {
                if (bAJ == null || bAJ.sqc.ruz != 15 || bAJ.sqj == 1) {
                    dVar = new d(str2, this.sceneType, biVar, 4, i4, Nl.bBq());
                } else {
                    dVar = new d(str2, this.sceneType, biVar, 5, i4, Nl.bBq());
                }
            } else if (i2 == 9) {
                dVar = new d(str2, this.sceneType, biVar, 2, i4, Nl.bBq());
            } else {
                dVar = new d(str2, this.sceneType, biVar, 1, i4, Nl.bBq());
            }
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(dVar, 0);
        }
    }

    public final void t(int i, String str, String str2) {
        int nextInt;
        int i2;
        h hVar;
        String bwN;
        if (this.niM.containsKey(str)) {
            this.niN.remove(Long.valueOf(((Long) this.niM.remove(str)).longValue()));
        }
        com.tencent.mm.protocal.c.bf bfVar = null;
        com.tencent.mm.protocal.c.bi biVar = null;
        a aVar = (a) this.niQ.get(str);
        if (aVar != null && af.npv) {
            aVar.hxu = true;
            aVar.niq = System.currentTimeMillis();
            if (aVar.nil < 0) {
                aVar.niG = 2;
            } else {
                aVar.niG = 1;
            }
            if (aVar.nin < 0) {
                aVar.niH = 2;
            } else {
                aVar.niH = 1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i.eF(aVar.egG) + ",");
            stringBuilder.append(aVar.egH + ",");
            stringBuilder.append(aVar.niG + ",");
            stringBuilder.append(aVar.niH + ",");
            stringBuilder.append(aVar.niD + ",");
            stringBuilder.append(aVar.niE + ",");
            stringBuilder.append(aVar.niF + ",");
            stringBuilder.append(aVar.nip + ",");
            stringBuilder.append(aVar.niq + ",");
            if (aVar.nit > 0 && aVar.niw == 0) {
                aVar.niw = System.currentTimeMillis();
            }
            stringBuilder.append(aVar.nit + ",");
            stringBuilder.append(aVar.niw + ",");
            if (aVar.niz > 0 && aVar.niC == 0) {
                aVar.niC = System.currentTimeMillis();
            }
            stringBuilder.append(aVar.niz + ",");
            stringBuilder.append(aVar.niC);
            f.a(aVar.egG, stringBuilder);
            x.i("MicroMsg.AdViewStatic", "report " + stringBuilder.toString());
            bfVar = new com.tencent.mm.protocal.c.bf();
            bfVar.rbA = aVar.niz;
            bfVar.rbB = aVar.niC;
            bfVar.niG = aVar.niG;
            bfVar.niH = aVar.niH;
            bfVar.rbv = (float) aVar.niD;
            bfVar.rbw = (float) aVar.niE;
            bfVar.rbx = (float) aVar.niF;
            bfVar.rby = aVar.nit;
            bfVar.rbz = aVar.niw;
            bfVar.startTime = aVar.nip;
            bfVar.endTime = aVar.niq;
            if (aVar.nik == null || !aVar.nik.bzx()) {
                af.byi().h(12010, stringBuilder.toString());
            } else {
                af.byi().h(14648, stringBuilder.toString());
            }
            com.tencent.mm.modelsns.b io = com.tencent.mm.modelsns.b.io(730);
            io.nb(i.eF(aVar.egG)).nb(aVar.egH).ir(aVar.niG).ir(aVar.niH).ir(aVar.niD).ir(aVar.niE).ir(aVar.niF).nb(aVar.nip).nb(aVar.niq).nb(aVar.nit).nb(aVar.niw).nb(aVar.niz).nb(aVar.niC);
            io.RD();
            ki kiVar = new ki();
            kiVar.bUI.position = aVar.position;
            a.sFg.m(kiVar);
            if (com.tencent.mm.platformtools.af.exR) {
                nextInt = new Random(System.currentTimeMillis()).nextInt(2000) + 10;
                x.i("MicroMsg.AdViewStatic", "run on test kv " + nextInt);
                for (i2 = 0; i2 < nextInt; i2++) {
                    if (aVar.nik == null || !aVar.nik.bzx()) {
                        af.byi().h(12010, stringBuilder.toString());
                    } else {
                        af.byi().h(14648, stringBuilder.toString());
                    }
                }
            }
            biVar = aVar.bwL();
            this.niQ.remove(str);
        }
        i2 = 0;
        n Nl = af.byo().Nl(str);
        if (Nl != null) {
            if (this.niT.containsKey(Long.valueOf(Nl.field_snsId)) && Nl.bAJ().sqc.ruz == 27) {
                i2 = Nl.field_likeFlag == 1 ? 2 : 1;
                int intValue = this.njb.containsKey(Long.valueOf(Nl.field_snsId)) ? ((Integer) this.njb.get(Long.valueOf(Nl.field_snsId))).intValue() : 0;
                if (this.nja.containsKey(Long.valueOf(Nl.field_snsId))) {
                    nextInt = ((Integer) this.nja.get(Long.valueOf(Nl.field_snsId))).intValue();
                } else {
                    nextInt = 0;
                }
                long j = 0;
                long j2 = 0;
                long j3 = 0;
                hVar = (h) this.niT.remove(Long.valueOf(Nl.field_snsId));
                if (hVar != null) {
                    hVar.wh(0);
                    hVar.bwO();
                    j = (long) hVar.njq;
                    j2 = (long) hVar.njp;
                    j3 = hVar.nju * 1000;
                }
                String str3 = "%s,%s,%s,%s,%s,%s,%s,%s,%s";
                Object[] objArr = new Object[9];
                objArr[0] = Nl.bAJ().ksA;
                objArr[1] = Nl.bBo();
                objArr[2] = this.sceneType;
                objArr[3] = String.valueOf(intValue);
                objArr[4] = String.valueOf(nextInt);
                objArr[5] = String.valueOf(j);
                objArr[6] = String.valueOf(j2);
                objArr[7] = String.valueOf(j3);
                objArr[8] = Nl.field_likeFlag == 1 ? "1" : "0";
                h.mEJ.k(15155, String.format(str3, objArr));
                x.i("MicroMsg.SnsAdStatistic", "15155, %s", new Object[]{bwN});
                this.niR.remove(Long.valueOf(Nl.field_snsId));
                this.niR.remove(Long.valueOf(Nl.field_snsId + 1));
            }
            this.njb.remove(Long.valueOf(Nl.field_snsId));
            this.nja.remove(Long.valueOf(Nl.field_snsId));
        }
        int i3 = i2;
        if (this.niU.containsKey(str)) {
            a aVar2 = (a) this.niU.remove(str);
            this.niO.put(str, Long.valueOf(bi.VG()));
            if (aVar2 != null) {
                long bI = bi.bI(aVar2.time);
                if (aVar2.nji > 0) {
                    aVar2.njj += bi.bI(aVar2.nji);
                    aVar2.nji = 0;
                }
                x.i("MicroMsg.SnsAdStatistic", "onAdRemoved " + i + " " + str + " " + bI + " ");
                if (Nl != null) {
                    int i4;
                    String str4;
                    String str5 = "";
                    bsu bAJ = Nl.bAJ();
                    b bAF = Nl.bAF();
                    if (bAF.bzq()) {
                        i4 = 3;
                        str4 = str5;
                    } else if (bAJ.sqc.ruz == 27) {
                        i4 = 6;
                        hVar = (h) this.niS.remove(Long.valueOf(aVar2.egG));
                        if (hVar != null) {
                            if (Nl.field_likeFlag == 0) {
                                hVar.wh(0);
                            }
                            bwN = hVar.bwN();
                        } else {
                            bwN = str5;
                        }
                        str4 = bwN;
                    } else if (bAF.bzr()) {
                        if (bAJ == null || bAJ.sqc.ruz != 15 || bAJ.sqj == 1) {
                            i4 = 4;
                            str4 = str5;
                        } else {
                            i4 = 5;
                            hVar = (h) this.niS.remove(Long.valueOf(aVar2.egG));
                            if (hVar != null) {
                                hVar.wh(0);
                                str5 = hVar.bwN();
                            }
                            this.niR.remove(Long.valueOf(aVar2.egG));
                            str4 = str5;
                        }
                    } else if (aVar2.hER == 9) {
                        i4 = 2;
                        hVar = (h) this.niS.remove(Long.valueOf(aVar2.egG));
                        if (hVar != null) {
                            hVar.wh(0);
                            str5 = hVar.bwN();
                        }
                        this.niR.remove(Long.valueOf(aVar2.egG));
                        str4 = str5;
                    } else {
                        i4 = 1;
                        str4 = str5;
                    }
                    d dVar = new d(str2, this.sceneType, 2, (int) bI, bfVar, biVar, i4, str4, -1, Nl.bBq(), (int) bI, (int) aVar2.njj, i3);
                    com.tencent.mm.kernel.g.Ek();
                    com.tencent.mm.kernel.g.Eh().dpP.a(dVar, 0);
                    return;
                }
                return;
            }
            return;
        }
        x.i("MicroMsg.SnsAdStatistic", "can not find onAdRemoved " + i + " " + str);
    }

    public final void bwM() {
        for (Entry value : this.niQ.entrySet()) {
            a aVar = (a) value.getValue();
            if (aVar != null && af.npv) {
                aVar.bwK();
                if (!(bi.oW(aVar.bNH) || this.niU.get(aVar.bNH) == null)) {
                    a aVar2 = (a) this.niU.get(aVar.bNH);
                    Object obj = aVar.niI == 1 ? 1 : null;
                    if (obj != null && aVar2.nji == 0) {
                        aVar2.nji = bi.VG();
                    } else if (obj == null && aVar2.nji > 0) {
                        aVar2.njj += bi.bI(aVar2.nji);
                        aVar2.nji = 0;
                    }
                }
            }
        }
    }

    public final void clear() {
        String str;
        onResume();
        x.i("MicroMsg.SnsAdStatistic", "clean the adRemove" + this.niV.size());
        List<String> linkedList = new LinkedList();
        for (String str2 : this.niU.keySet()) {
            linkedList.add(str2);
        }
        for (String str22 : linkedList) {
            a aVar = (a) this.niU.get(str22);
            t(aVar.position, aVar.cbn, aVar.egF);
        }
        Iterator it = this.niV.iterator();
        while (it.hasNext()) {
            str22 = (String) it.next();
            com.tencent.mm.plugin.sns.storage.e xa = af.byr().xa(v.NF(str22));
            if (xa != null) {
                int intValue;
                n bAL = xa.bAL();
                xa.field_localFlag |= 128;
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (this.niW.containsKey(str22)) {
                    intValue = ((Integer) this.niW.get(str22)).intValue();
                } else {
                    intValue = currentTimeMillis;
                }
                if (xa.field_exposureTime <= 0) {
                    xa.field_exposureTime = intValue;
                }
                bAL.field_localFlag |= 128;
                af.byo().b(bAL.field_snsId, bAL);
                af.byr().b(xa.field_snsId, xa);
            }
        }
        this.niV.clear();
        this.niW.clear();
    }

    public final void ez(long j) {
        int i = 0;
        if (this.nja.containsKey(Long.valueOf(j))) {
            i = ((Integer) this.nja.get(Long.valueOf(j))).intValue();
        }
        this.nja.put(Long.valueOf(j), Integer.valueOf(i + 1));
    }

    public final void eA(long j) {
        int i = 0;
        if (this.njb.containsKey(Long.valueOf(j))) {
            i = ((Integer) this.njb.get(Long.valueOf(j))).intValue();
        }
        this.njb.put(Long.valueOf(j), Integer.valueOf(i + 1));
    }
}
