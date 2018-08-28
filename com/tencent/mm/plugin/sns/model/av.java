package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

public final class av implements f {
    private static HashMap<String, b> nrT = new HashMap();
    private static HashMap<String, WeakReference<b>> nrU = new HashMap();

    public static void Mu(String str) {
        if (af.exM) {
            x.d("MicroMsg.TimelineSmallPicStat", "recordStartLoadSmallPic, mediaId:%s", new Object[]{str});
        }
        WeakReference weakReference = (WeakReference) nrU.get(str);
        if (weakReference != null) {
            b bVar = (b) weakReference.get();
            if (bVar != null) {
                bVar.kdC = true;
            }
        }
    }

    public static void Mv(String str) {
        if (af.exM) {
            x.d("MicroMsg.TimelineSmallPicStat", "recordEndLoadSmallPic, mediaId:%s", new Object[]{str});
        }
        WeakReference weakReference = (WeakReference) nrU.get(str);
        if (weakReference != null) {
            b bVar = (b) weakReference.get();
            if (bVar != null && bVar != null && bVar.nrV == -1) {
                HashMap hashMap = bVar.nrZ;
                if (hashMap != null && hashMap.containsKey(str)) {
                    a aVar = (a) hashMap.get(str);
                    if (aVar != null && aVar.nrV == -1) {
                        aVar.nrV = 1;
                        bVar.nrY++;
                    }
                }
            }
        }
    }

    public static void Mw(String str) {
        x.d("MicroMsg.TimelineSmallPicStat", "recordClickBigpic, localId:%s", new Object[]{str});
        if (nrT.containsKey(str)) {
            x.d("MicroMsg.TimelineSmallPicStat", "recordClickBigPic, localId:%s, update map", new Object[]{str});
            b bVar = (b) nrT.get(str);
            if (bVar != null && bVar.nrV == -1 && bVar.startTime != -1) {
                bVar.nrV = 1;
                bVar.nrY = bVar.dzO;
                bVar.endTime = System.currentTimeMillis();
                bVar.nrX = bVar.endTime - bVar.startTime;
                for (a aVar : bVar.nrZ.values()) {
                    aVar.nrV = 1;
                }
            }
        }
    }

    public final void a(String str, bsu bsu) {
        if (!nrT.containsKey(str)) {
            if (af.exM) {
                x.d("MicroMsg.TimelineSmallPicStat", "put localId:%s into reportData", new Object[]{str});
            }
            if (bsu != null && bsu.sqc != null && bsu.sqc.ruz == 1 && bsu.sqc.ruA != null && bsu.sqc.ruA.size() > 0) {
                b bVar = new b(this);
                bVar.dzO = bsu.sqc.ruA.size();
                bVar.nrY = 0;
                bVar.nrZ = new HashMap();
                Iterator it = bsu.sqc.ruA.iterator();
                while (it.hasNext()) {
                    ate ate = (ate) it.next();
                    a aVar = new a(this);
                    aVar.mediaId = ate.ksA;
                    bVar.nrZ.put(ate.ksA, aVar);
                    nrU.put(ate.ksA, new WeakReference(bVar));
                }
                bVar.startTime = System.currentTimeMillis();
                nrT.put(str, bVar);
            } else if (af.exM) {
                x.d("MicroMsg.TimelineSmallPicStat", "onItemAdd error, timelineObject is nulli");
            }
        }
    }

    public final void LX(String str) {
        if (nrT.containsKey(str)) {
            if (af.exM) {
                x.d("MicroMsg.TimelineSmallPicStat", "load finish localId:%s", new Object[]{str});
            }
            b bVar = (b) nrT.get(str);
            if (bVar != null && bVar.startTime != -1 && bVar.nrV == -1) {
                bVar.endTime = System.currentTimeMillis();
                bVar.nrX = bVar.endTime - bVar.startTime;
                if (bVar.nrY == bVar.dzO) {
                    bVar.nrV = 1;
                } else {
                    bVar.nrV = 2;
                }
            }
        }
    }

    public final void bxB() {
        x.d("MicroMsg.TimelineSmallPicStat", "reportAll, reportData.size:%d", new Object[]{Integer.valueOf(nrT.size())});
        int bxa = i.bxa();
        for (String str : nrT.keySet()) {
            b bVar = (b) nrT.get(str);
            if (bVar != null && bVar.kdC) {
                if (bVar.nrX == -1 || bVar.nrV == -1 || bVar.startTime == -1) {
                    if (bVar.startTime != -1) {
                        bVar.endTime = System.currentTimeMillis();
                        bVar.nrX = bVar.endTime - bVar.startTime;
                        if (bVar.dzO == bVar.nrY) {
                            bVar.nrV = 1;
                        } else {
                            bVar.nrV = 2;
                        }
                    }
                }
                x.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d", new Object[]{Integer.valueOf(bVar.dzO), Long.valueOf(bVar.nrV), Long.valueOf(bVar.nrX), Integer.valueOf(bVar.nrY), Integer.valueOf(bxa)});
                h.mEJ.h(11600, new Object[]{Integer.valueOf(bVar.dzO), Long.valueOf(bVar.nrV), Long.valueOf(bVar.nrX), Integer.valueOf(bVar.nrY), Integer.valueOf(bxa)});
            }
        }
        nrT.clear();
        nrU.clear();
    }
}
