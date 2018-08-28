package com.tencent.mm.plugin.topstory;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.b.b;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.protocal.c.bgx;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.protocal.c.bti;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c implements f {
    ag oyH = new ag(new ah("TopStoryReportExposeTask").lnJ.getLooper());
    Map<Long, a> oyI = new ConcurrentHashMap();

    private class a implements Runnable {
        long createTime;
        HashSet<b> oyJ;
        bth oyK;

        private a() {
            this.oyJ = new HashSet();
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        public final void run() {
            x.i("MicroMsg.TopStory.TopStoryReporterImpl", "Star to run ReportExposeTask");
            c.this.oyI.remove(Long.valueOf(this.oyK.sqL));
            List arrayList = new ArrayList();
            arrayList.addAll(this.oyJ);
            int i = 0;
            while (true) {
                List subList;
                int i2 = i + 20;
                if (i2 >= arrayList.size()) {
                    subList = arrayList.subList(i, arrayList.size());
                } else {
                    subList = arrayList.subList(i, i2);
                }
                String a = a(subList, this.oyK);
                if (!bi.oW(a)) {
                    bgx bgx = new bgx();
                    bgx.shQ = a;
                    x.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14057VideoInfoExposeString %d report string: %s", new Object[]{Integer.valueOf(subList.size()), bgx.shQ});
                    ah.A(new 1(this, bgx));
                }
                if (i2 < arrayList.size()) {
                    i = i2;
                } else {
                    return;
                }
            }
        }

        private static String a(List<b> list, bth bth) {
            if (list.size() == 0) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append("isexpose=1&content=");
            StringBuilder stringBuilder2 = new StringBuilder("");
            for (b bVar : list) {
                bti bti = bVar.ozj;
                stringBuilder2.append(bti.bHu);
                stringBuilder2.append(":");
                stringBuilder2.append(bti.sqZ);
                stringBuilder2.append(":");
                stringBuilder2.append(bVar.jyY);
                stringBuilder2.append(":");
                stringBuilder2.append(bti.sqV);
                stringBuilder2.append(";");
            }
            try {
                stringBuilder.append(p.encode(stringBuilder2.toString(), "utf-8"));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", e, "", new Object[0]);
            }
            try {
                bti bti2;
                stringBuilder.append("&resulttype=");
                for (b bVar2 : list) {
                    bti2 = bVar2.ozj;
                    stringBuilder.append(bti2.bHu);
                    stringBuilder.append(":");
                    stringBuilder.append(bti2.sra);
                    stringBuilder.append(";");
                }
                stringBuilder.append("&expand=");
                stringBuilder2 = new StringBuilder("");
                for (b bVar22 : list) {
                    bti2 = bVar22.ozj;
                    stringBuilder2.append(bti2.bHu);
                    stringBuilder2.append(":");
                    stringBuilder2.append(bti2.sqX);
                    stringBuilder2.append(";");
                }
                try {
                    stringBuilder.append(p.encode(stringBuilder2.toString(), "utf-8"));
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", e2, "", new Object[0]);
                }
                stringBuilder.append("&itemtype=");
                CharSequence stringBuilder3 = new StringBuilder("");
                for (b bVar222 : list) {
                    stringBuilder3.append(bVar222.ozj.sqW);
                    stringBuilder3.append(";");
                }
                stringBuilder.append(stringBuilder3);
                if (bth != null) {
                    stringBuilder.append("&");
                    stringBuilder.append("searchid=");
                    stringBuilder.append(bth.fuu);
                    stringBuilder.append("&");
                    stringBuilder.append("query=");
                    try {
                        stringBuilder.append(p.encode(bth.bHt, "utf-8"));
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", e22, "", new Object[0]);
                    }
                    stringBuilder.append("&");
                    stringBuilder.append("ishomepage=0");
                    stringBuilder.append("&");
                    stringBuilder.append("sessionid=");
                    stringBuilder.append(com.tencent.mm.plugin.websearch.api.p.zK(bth.scene));
                    stringBuilder.append("&");
                    stringBuilder.append("scene=");
                    stringBuilder.append(bth.scene);
                    stringBuilder.append("&rec_category=");
                    stringBuilder.append(bth.sqL);
                }
                return stringBuilder.toString();
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", e222, "build14057VideoInfoExposeString error: %s", new Object[]{e222.getMessage()});
                return null;
            }
        }
    }

    public final void a(bth bth, HashSet<b> hashSet) {
        if (hashSet.size() != 0) {
            a aVar = (a) this.oyI.get(Long.valueOf(bth.sqL));
            Iterator it;
            if (aVar != null) {
                x.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo hit cached task %d", new Object[]{Integer.valueOf(hashSet.size())});
                it = hashSet.iterator();
                while (it.hasNext()) {
                    aVar.oyJ.add((b) it.next());
                }
                return;
            }
            x.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo new task %d", new Object[]{Integer.valueOf(hashSet.size())});
            Runnable aVar2 = new a(this, (byte) 0);
            aVar2.createTime = System.currentTimeMillis();
            it = hashSet.iterator();
            while (it.hasNext()) {
                aVar2.oyJ.add((b) it.next());
            }
            aVar2.oyK = bth;
            if (aVar2.oyJ.size() > 0) {
                this.oyH.removeCallbacksAndMessages(null);
                this.oyH.postDelayed(aVar2, 5000);
                this.oyI.put(Long.valueOf(bth.sqL), aVar2);
            }
        }
    }

    public final void a(bth bth, bti bti, int i, int i2, String str) {
        String b = b(bth, bti, i, i2, str);
        if (!bi.oW(b)) {
            bgx bgx = new bgx();
            bgx.shQ = b;
            x.i("MicroMsg.TopStory.TopStoryReporterImpl", "do12721ClickVideoReport %s", new Object[]{bgx.shQ});
            g.DF().a(new n(bgx), 0);
        }
    }

    private static String b(bth bth, bti bti, int i, int i2, String str) {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("scene=");
        stringBuilder.append(bth.scene);
        stringBuilder.append("&");
        stringBuilder.append("businesstype=3");
        stringBuilder.append("&");
        stringBuilder.append("mediatype=2");
        stringBuilder.append("&");
        stringBuilder.append("docid=");
        stringBuilder.append(bti.sqZ);
        stringBuilder.append("&");
        stringBuilder.append("typepos=");
        stringBuilder.append("0");
        stringBuilder.append("&");
        stringBuilder.append("docpos=");
        stringBuilder.append(i + 1);
        stringBuilder.append("&");
        stringBuilder.append("searchid=");
        stringBuilder.append(bth.fuu);
        stringBuilder.append("&");
        stringBuilder.append("ishomepage=");
        stringBuilder.append(0);
        stringBuilder.append("&rec_category=");
        stringBuilder.append(bti.sqT);
        stringBuilder.append("&");
        stringBuilder.append("timestamp=");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("&");
        stringBuilder.append("clicktype=");
        stringBuilder.append(i2);
        stringBuilder.append("&");
        stringBuilder.append("clickcontent=");
        try {
            stringBuilder.append(p.encode(str, "utf-8"));
        } catch (Exception e) {
        }
        try {
            stringBuilder.append("&");
            stringBuilder.append("clicksource=");
            stringBuilder.append("4");
            stringBuilder.append("&");
            stringBuilder.append("sceneactiontype=");
            stringBuilder.append(1);
            stringBuilder.append("&");
            stringBuilder.append("query=");
            try {
                stringBuilder.append(p.encode(bth.bHt, "utf-8"));
            } catch (Exception e2) {
            }
            stringBuilder.append("&");
            stringBuilder.append("resulttype=");
            stringBuilder.append(bti.sra);
            stringBuilder.append("&");
            stringBuilder.append("sessionid=");
            stringBuilder.append(com.tencent.mm.plugin.websearch.api.p.zK(bth.scene));
            stringBuilder.append("&");
            stringBuilder.append("expand=");
            try {
                stringBuilder.append(p.encode(bti.sqV, "utf-8"));
            } catch (Exception e3) {
            }
            stringBuilder.append("&");
            stringBuilder.append("title=");
            try {
                stringBuilder.append(p.encode(bti.title, "utf-8"));
            } catch (Exception e4) {
            }
            stringBuilder.append("&");
            stringBuilder.append("nettype=");
            if (ao.isWifi(ad.getContext())) {
                stringBuilder.append("wifi");
            } else if (ao.is4G(ad.getContext())) {
                stringBuilder.append("4g");
            } else {
                stringBuilder.append("3g");
            }
            stringBuilder.append("&");
            stringBuilder.append("itemtype=");
            stringBuilder.append(bti.sqW);
        } catch (Exception e5) {
        }
        return stringBuilder.toString();
    }

    public static String a(bth bth, bti bti, com.tencent.mm.plugin.topstory.a.b.a aVar) {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("ismediaplay=1");
        stringBuilder.append("&searchid=");
        stringBuilder.append(bth.fuu);
        stringBuilder.append("&scene=");
        stringBuilder.append(bth.scene);
        stringBuilder.append("&businesstype=3");
        stringBuilder.append("&mediatype=2");
        stringBuilder.append("&rec_category=");
        stringBuilder.append(bth.sqL);
        stringBuilder.append("&docid=");
        stringBuilder.append(bti.sqZ);
        stringBuilder.append("&query=");
        try {
            stringBuilder.append(p.encode(bth.bHt, "utf-8"));
        } catch (Exception e) {
        }
        stringBuilder.append("&title=");
        try {
            stringBuilder.append(p.encode(bti.title, "utf-8"));
        } catch (Exception e2) {
        }
        stringBuilder.append("&duration=");
        stringBuilder.append(bti.sqR * 1000);
        stringBuilder.append("&mediaid=");
        stringBuilder.append(bti.sqS);
        if (aVar != null) {
            stringBuilder.append("&startplaytime=");
            stringBuilder.append(aVar.oyQ);
            stringBuilder.append("&endplaytime=");
            stringBuilder.append(aVar.oyR);
            stringBuilder.append("&playtime=");
            stringBuilder.append(aVar.oyS);
            stringBuilder.append("&lastplayms=");
            stringBuilder.append(aVar.oyT);
            stringBuilder.append("&autoplay=");
            stringBuilder.append(aVar.oyX);
            stringBuilder.append("&hasplayended=");
            stringBuilder.append(aVar.oyU);
            stringBuilder.append("&hasquickplay=");
            stringBuilder.append(aVar.oyV);
            stringBuilder.append("&hasfullscreen=");
            stringBuilder.append(aVar.oyW);
            stringBuilder.append("&hitpreload=");
            stringBuilder.append(aVar.oyY);
            stringBuilder.append("&firstloadtime=");
            stringBuilder.append(aVar.ozb);
            stringBuilder.append("&downloadfinishtime=");
            stringBuilder.append(aVar.ozc);
            stringBuilder.append("&firstmoovreadytime=");
            stringBuilder.append(aVar.ozd);
            stringBuilder.append("&firstdataavailabletime=");
            stringBuilder.append(aVar.ozg);
        }
        return stringBuilder.toString();
    }
}
