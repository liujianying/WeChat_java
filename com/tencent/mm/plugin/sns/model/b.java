package com.tencent.mm.plugin.sns.model;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.memory.n;
import com.tencent.mm.model.am;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.sns.data.f;
import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.a.d;
import com.tencent.mm.plugin.sns.model.a.h;
import com.tencent.mm.plugin.sns.model.g.9;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b implements e, a {
    private static final int nmA = (VERSION.SDK_INT >= 14 ? 100 : 25);
    static int nmz = 0;
    LinkedList<f> dav;
    Set<b> dba;
    private ag handler;
    private long nmB;
    private int nmC;
    private int nmD;
    private LinkedList<g> nmE;
    public HashMap<String, Long> nmF;
    public boolean nmG;
    public Set<a> nmH;
    Map<String, Long> nmI;
    Map<String, com.tencent.mm.plugin.sns.data.c> nmJ;

    /* renamed from: com.tencent.mm.plugin.sns.model.b$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String dat;
        final /* synthetic */ String sl;

        public AnonymousClass3(String str, String str2) {
            this.sl = str;
            this.dat = str2;
        }

        public final void run() {
            if (b.this.nmH != null) {
                for (a aVar : b.this.nmH) {
                    if (aVar != null) {
                        aVar.ew(this.sl, this.dat);
                    }
                }
            }
        }
    }

    class c implements IdleHandler {
        c() {
        }

        public final boolean queueIdle() {
            x.d("MicroMsg.DownloadManager", "I run idleHandler ");
            b.this.nmB = bi.VE();
            return b.a(b.this);
        }
    }

    static /* synthetic */ boolean a(b bVar, ate ate, int i, com.tencent.mm.plugin.sns.data.e eVar, av avVar, String str, String str2) {
        if (!i.LM(af.Gq())) {
            x.i("MicroMsg.DownloadManager", "isHasSdcard is false accpath %s sdcard: %s", new Object[]{af.Gq(), com.tencent.mm.compatible.util.e.bnC});
            return false;
        } else if (ate.ksA.startsWith("Locall_path") || ate.ksA.startsWith("pre_temp_sns_pic")) {
            x.d("MicroMsg.DownloadManager", "is a local img not need download");
            return false;
        } else {
            String aF = i.aF(i, ate.ksA);
            if (bVar.nmJ.containsKey(aF)) {
                Iterator it = bVar.dav.iterator();
                while (it.hasNext()) {
                    f fVar = (f) it.next();
                    if (fVar.caK.ksA.equals(ate.ksA) && fVar.requestType == i) {
                        if (bVar.dav.remove(fVar)) {
                            bVar.dav.addLast(fVar);
                        }
                        x.v("MicroMsg.DownloadManager", "update the donwload list ");
                    }
                }
            } else {
                x.i("MicroMsg.DownloadManager", "add list %s", new Object[]{ate.ksA});
                bVar.nmJ.put(aF, new com.tencent.mm.plugin.sns.data.c(eVar, i));
                bVar.dav.add(new f(ate, i, aF, avVar, str, str2));
            }
            x.d("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s", new Object[]{Integer.valueOf(af.byn().bxS()), Integer.valueOf(bVar.nmI.size())});
            x.v("MicroMsg.DownloadManager", "lockwaitdownload. %s * %s memeryFiles.size() ", new Object[]{Integer.valueOf(bVar.nmJ.size()), Integer.valueOf(bVar.nmJ.size()), Integer.valueOf(bVar.nmE.size())});
            if (Looper.myLooper() == null) {
                x.w("MicroMsg.DownloadManager", "Looper.myLooper() == null");
                return false;
            }
            Looper.myQueue().addIdleHandler(new c());
            if ((bi.bG(bVar.nmB) * 1000 > 300000 ? 1 : null) != null) {
                bVar.handler.postDelayed(new 7(bVar), 500);
            }
            List<String> linkedList = new LinkedList();
            for (Entry key : bVar.nmI.entrySet()) {
                linkedList.add(key.getKey());
            }
            for (String str3 : linkedList) {
                if (bVar.nmI.containsKey(str3) && bi.bG(((Long) bVar.nmI.get(str3)).longValue()) * 1000 > 300000) {
                    x.d("MicroMsg.DownloadManager", "too long to download");
                    bVar.nmI.remove(str3);
                    bVar.nmJ.remove(str3);
                }
            }
            if (bVar.dav.size() > 0) {
                bVar.handler.postDelayed(new 4(bVar), 500);
            }
            return true;
        }
    }

    public static void bxr() {
    }

    public static boolean bxs() {
        return false;
    }

    public final void N(int i, boolean z) {
        this.nmD = i;
        try {
            String value;
            String str;
            if (ao.isWifi(ad.getContext())) {
                value = com.tencent.mm.k.g.AT().getValue("SnsImgDownloadConcurrentCountForWifi");
            } else {
                value = com.tencent.mm.k.g.AT().getValue("SnsImgDownloadConcurrentCountForNotWifi");
            }
            if (bi.oW(value) && com.tencent.mm.sdk.a.b.chp()) {
                str = "00:00-18:30-1-3;19:30-23:00-1-2;23:00-23:59-1-3;18:30-19:30-3-5;";
            } else {
                str = value;
            }
            if (!bi.oW(str)) {
                int i2;
                String[] split = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
                int WU = (bi.WU(split[1]) + (bi.WU(split[0]) * 60)) - ((((int) i.NL()) - 8) * 60);
                if (WU < 0) {
                    i2 = WU + 1440;
                } else if (WU >= 1440) {
                    i2 = WU - 1440;
                } else {
                    i2 = WU;
                }
                String[] split2 = str.split(";");
                WU = 0;
                while (true) {
                    int i3 = WU;
                    if (i3 >= split2.length) {
                        break;
                    }
                    if (!bi.oW(split2[i3])) {
                        split = split2[i3].split("-");
                        if (split == null || split.length < 4) {
                            x.e("MicroMsg.DownloadManager", "setMaxThread Err i%d :%s", new Object[]{Integer.valueOf(i3), str});
                        } else {
                            String[] split3 = split[0].split(":");
                            int WU2 = bi.WU(split3[1]) + (bi.WU(split3[0]) * 60);
                            String[] split4 = split[1].split(":");
                            x.i("MicroMsg.DownloadManager", "setMaxThread i:%d [%d,%d] now:%d threadcnt:[%s,%s]", new Object[]{Integer.valueOf(i3), Integer.valueOf(WU2), Integer.valueOf(bi.WU(split4[1]) + (bi.WU(split4[0]) * 60)), Integer.valueOf(i2), split[2], split[3]});
                            if (i2 <= bi.WU(split4[1]) + (bi.WU(split4[0]) * 60) && i2 > WU2) {
                                WU = bi.WU(z ? split[2] : split[3]);
                                if (WU > 0) {
                                    this.nmD = WU;
                                }
                            }
                        }
                    }
                    WU = i3 + 1;
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.DownloadManager", "setMaxThread :%s", new Object[]{bi.i(e)});
        }
        x.i("MicroMsg.DownloadManager", "setMaxThread Res:%d ", new Object[]{Integer.valueOf(this.nmD)});
    }

    public b() {
        this.handler = null;
        this.nmB = 0;
        this.nmC = 0;
        this.nmD = 2;
        this.nmE = new LinkedList();
        this.nmF = new HashMap();
        this.nmG = true;
        this.dba = new HashSet();
        this.nmH = new HashSet();
        this.dav = new LinkedList();
        this.nmI = new ConcurrentHashMap();
        this.nmJ = new HashMap();
        this.handler = af.aRu();
        bxt();
    }

    private void bxt() {
        this.dav.clear();
        this.nmJ.clear();
        this.nmI.clear();
        this.nmE.clear();
        this.nmF.clear();
    }

    public final void a(b bVar) {
        this.handler.post(new 1(this, bVar));
    }

    public final void b(b bVar) {
        this.handler.post(new 2(this, bVar));
    }

    public final boolean a(ate ate, int i, com.tencent.mm.plugin.sns.data.e eVar, av avVar) {
        if (ate == null) {
            x.e("MicroMsg.DownloadManager", "unknow case media is null " + bi.cjd().toString());
            return false;
        }
        af.aRu().post(new 5(this, ate, i, eVar, avVar));
        return true;
    }

    public final void LV(String str) {
        x.d("MicroMsg.DownloadManager", "unLockDownLoad the thread id is %s %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str});
        com.tencent.mm.plugin.sns.data.c cVar = (com.tencent.mm.plugin.sns.data.c) this.nmJ.get(str);
        if (cVar != null) {
            com.tencent.mm.plugin.sns.data.e eVar = cVar.nkK;
            if (eVar != null) {
                ate ate;
                g byl = af.byl();
                ate ate2 = (ate) eVar.list.get(0);
                for (int i = 1; i < eVar.list.size(); i++) {
                    ate ate3 = (ate) eVar.list.get(i);
                    if (str != null && str.indexOf(ate3.ksA) >= 0) {
                        ate = ate3;
                        break;
                    }
                }
                ate = ate2;
                String s = an.s(af.getAccSnsPath(), ate.ksA);
                String f = eVar.nkQ == 0 ? i.f(ate) : eVar.nkQ == 4 ? i.g(ate) : eVar.nkQ == 5 ? i.g(ate) : eVar.nkQ == 3 ? i.l(ate) : i.e(ate);
                if (!byl.nmV.bb(i.aE(eVar.nkQ, ate.ksA))) {
                    new com.tencent.mm.plugin.sns.model.g.b(byl, i.aE(eVar.nkQ, ate.ksA), s + f, s, ate, eVar.nkQ).o(new String[]{""});
                }
            }
        }
        this.nmJ.remove(str);
    }

    public final void OI() {
        if (!this.nmG) {
            return;
        }
        if (af.bxX()) {
            bxt();
        } else if (i.LM(af.Gq())) {
            int i = this.nmD;
            if (af.ewR > 0) {
                i = af.ewR;
            }
            if (this.dav.size() > 0 && af.byn().bxS() + this.nmI.size() <= i) {
                x.i("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s listsize %s max_thread_downloading: %s", new Object[]{Integer.valueOf(af.byn().bxS()), Integer.valueOf(this.nmI.size()), Integer.valueOf(this.dav.size()), Integer.valueOf(this.nmD)});
                f fVar = (f) this.dav.removeLast();
                ate ate = fVar.caK;
                int i2 = fVar.requestType;
                String str = fVar.aAL;
                String str2 = fVar.nkR;
                String str3 = fVar.nkS;
                if (!this.nmJ.containsKey(str) || this.nmJ.get(str) == null) {
                    this.nmJ.remove(str);
                    return;
                }
                boolean z;
                int i3;
                String str4;
                Object obj;
                com.tencent.mm.plugin.sns.data.e eVar = ((com.tencent.mm.plugin.sns.data.c) this.nmJ.get(str)).nkK;
                if (i2 == 1 && ate.nkG) {
                    i2 = 8;
                }
                if (i2 == 1 || i2 == 5 || i2 == 7) {
                    z = true;
                    String str5 = ate.rVE;
                    if (i2 == 7 && !bi.oW(ate.rVO)) {
                        str5 = ate.rVO;
                    }
                    i3 = ate.rVF;
                    if (bi.oW(str5) && ate.hcE == 2) {
                        str4 = ate.jPK;
                        i3 = ate.rVD;
                    } else {
                        str4 = str5;
                    }
                } else if (i2 == 6) {
                    z = false;
                    str4 = ate.rVL;
                    i3 = ate.rVD;
                } else {
                    z = false;
                    str4 = ate.jPK;
                    i3 = ate.rVD;
                }
                if (str4 == null || str4.equals("")) {
                    x.d("MicroMsg.DownloadManager", "url  " + str4);
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    this.nmJ.remove(str);
                } else if (i3 == 2) {
                    if (!af.byn().isDownloading(str)) {
                        x.d("MicroMsg.DownloadManager", "to downLoad scene " + ate.ksA + "  " + str4);
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Eh().dpP.a(new p(ate, ate.ksA, str4, ate.hcE, z, i2, str), 0);
                        af.byn().Mh(str);
                    }
                } else if (i3 == 1 || i3 == 0) {
                    if (i3 == 0) {
                        x.e("MicroMsg.DownloadManager", "others http: urlType" + i3 + " -- url : " + str4 + " isThumb :" + z);
                    }
                    if (!this.nmI.containsKey(str)) {
                        x.i("MicroMsg.DownloadManager", "to downLoad cdn " + ate.ksA + "  " + str4);
                        if (!(ate == null || i2 == 6 || i2 == 8 || !this.nmF.containsKey(str))) {
                            long longValue = ((Long) this.nmF.get(str)).longValue();
                            if (System.currentTimeMillis() - longValue < 300000) {
                                this.nmJ.remove(str);
                                x.w("MicroMsg.DownloadManager", "download error pass " + longValue + " url " + str4 + " id: " + ate.ksA);
                                return;
                            }
                        }
                        this.nmI.put(str, Long.valueOf(bi.VE()));
                        if (i2 == 2 || i2 == 8) {
                            com.tencent.mm.kernel.g.Ek();
                            int a = bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(68391, null), 0);
                            com.tencent.mm.kernel.g.Ek();
                            com.tencent.mm.kernel.g.Ei().DT().set(68391, Integer.valueOf(a + 1));
                        }
                        com.tencent.mm.plugin.sns.model.a.a aVar = new com.tencent.mm.plugin.sns.model.a.a(ate.ksA);
                        aVar.noc = ate;
                        aVar.nsJ = fVar.nkT;
                        if (i2 == 4) {
                            aVar.nsH = true;
                        } else {
                            aVar.nsH = false;
                        }
                        aVar.url = str4;
                        i = ate.hcE;
                        aVar.nsG = z;
                        aVar.nsI = i2;
                        aVar.nob = str;
                        aVar.nkK = eVar;
                        aVar.nkR = str2;
                        aVar.nkS = str3;
                        com.tencent.mm.plugin.sns.model.a.c cVar = null;
                        if (i2 == 1 || i2 == 5 || i2 == 7) {
                            cVar = new com.tencent.mm.plugin.sns.model.a.i(this, aVar);
                        } else if (i2 == 4) {
                            x.w("MicroMsg.DownloadManager", "it can not download sight, may be something warn here.");
                            if (ate.nkG) {
                                cVar = new h(this, aVar);
                            } else {
                                cVar = new com.tencent.mm.plugin.sns.model.a.g(this, aVar);
                            }
                        } else if (i2 == 2 || i2 == 8 || i2 == 3) {
                            cVar = new com.tencent.mm.plugin.sns.model.a.e(this, aVar);
                        } else if (i2 == 6) {
                            aVar.url = ate.rVL;
                            aVar.bKg = ate.rVN;
                            cVar = new d(this, aVar);
                        }
                        cVar.o(new String[]{""});
                    }
                } else {
                    this.nmJ.remove(str);
                }
            }
        }
    }

    public final void a(int i, ate ate, int i2, boolean z, String str, int i3) {
        x.i("MicroMsg.DownloadManager", "state:%d, mediaId:%s, reqDownloadType:%d, isThumb:%b, requestKey:%s, totalSize:%d", new Object[]{Integer.valueOf(i), ate.ksA, Integer.valueOf(i2), Boolean.valueOf(z), str, Integer.valueOf(i3)});
        if (!af.bxX()) {
            com.tencent.mm.kernel.g.Ek();
            if (com.tencent.mm.kernel.g.Eg().Dx()) {
                this.nmC += i3;
                if (this.nmC > 512000 && this.dav.size() == 0) {
                    x.d("MicroMsg.DownloadManager", "netSizeAdd %s", new Object[]{Integer.valueOf(this.nmC)});
                    am.a.dBs.aY(this.nmC, 0);
                    this.nmC = 0;
                }
                if (i == 1 || i == 3) {
                    this.nmF.put(str, Long.valueOf(System.currentTimeMillis()));
                }
                if (!(i == 3 || i != 1 || i2 == 3)) {
                    g byl = af.byl();
                    x.d("MicroMsg.LazyerImageLoader2", "updateCache " + ate.ksA);
                    n nVar = (n) byl.nmV.get(i.aE(1, ate.ksA));
                    if (i.b(nVar)) {
                        nVar.Fy();
                        x.d("MicroMsg.LazyerImageLoader2", "force update");
                        af.byb().post(new 9(byl, ate));
                    }
                }
                for (b bVar : this.dba) {
                    if (bVar != null) {
                        if (i != 2) {
                            if (i2 == 3) {
                                bVar.bxb();
                            } else if (i2 == 1 || i2 == 5 || i2 == 7) {
                                bVar.LR(ate.ksA);
                            } else if (i2 == 2 || i2 == 8) {
                                bVar.aS(ate.ksA, true);
                            } else if (i2 == 4 || i2 == 6) {
                                bVar.aT(ate.ksA, true);
                            }
                        } else if (i2 == 2 || i2 == 8) {
                            bVar.aS(ate.ksA, false);
                        } else if (i2 == 4 || i2 == 6) {
                            bVar.aT(ate.ksA, false);
                        }
                    }
                }
                x.d("MicroMsg.DownloadManager", "onDownLoadFinish by cdn %s", new Object[]{str});
                this.nmI.remove(str);
                OI();
                LV(str);
                return;
            }
        }
        bxt();
    }

    public final void LW(String str) {
        af.aRu().post(new 8(this, str));
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.DownloadManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + lVar.getType() + " @" + hashCode());
        if (lVar.getType() == TbsListener$ErrorCode.EXCEED_DEXOPT_RETRY_NUM) {
            p pVar = (p) lVar;
            if (i == 0 && i2 == 0) {
                if (lVar.getType() == TbsListener$ErrorCode.EXCEED_DEXOPT_RETRY_NUM) {
                    for (b bVar : this.dba) {
                        if (bVar != null) {
                            if (pVar.nnZ == 3) {
                                bVar.bxb();
                            } else if (pVar.nnZ == 1 || pVar.nnZ == 5 || pVar.nnZ == 7) {
                                bVar.LR(pVar.mediaId);
                            } else if (pVar.nnZ == 2 || pVar.nnZ == 8) {
                                bVar.aS(pVar.mediaId, true);
                            }
                        }
                    }
                }
            } else if (pVar.nnZ == 2 || pVar.nnZ == 8) {
                for (b bVar2 : this.dba) {
                    if (bVar2 != null) {
                        bVar2.aS(pVar.mediaId, false);
                    }
                }
            }
        }
    }
}
