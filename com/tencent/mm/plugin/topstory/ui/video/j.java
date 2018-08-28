package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.a.b.a;
import com.tencent.mm.plugin.topstory.a.b.b;
import com.tencent.mm.plugin.topstory.c;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.c.bgx;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.protocal.c.bti;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class j {
    a oAb;
    Map<String, b> oAk = new HashMap();
    public int oAl = 1;
    a oAm;
    private bti ozj;

    public final void a(bti bti) {
        if (bti == null) {
            x.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose null");
        }
        b bVar = new b(bti);
        if (this.oAk.containsKey(bVar.ozj.sqS)) {
            ((b) this.oAk.get(bVar.ozj.sqS)).ozj = bti;
            return;
        }
        this.oAk.put(bVar.ozj.sqS, bVar);
        x.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose %s", new Object[]{bti});
    }

    public final void b(bti bti) {
        a(bti);
        ((b) this.oAk.get(bti.sqS)).ozk = true;
    }

    public final void bIe() {
        HashSet hashSet = new HashSet();
        for (b bVar : this.oAk.values()) {
            if (!bVar.mGh) {
                hashSet.add(bVar);
                bVar.mGh = true;
            }
        }
        if (this.oAb != null) {
            ((com.tencent.mm.plugin.topstory.a.b) g.n(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.oAb.bHT(), hashSet);
        }
    }

    public final void a(bti bti, int i, String str) {
        this.ozj = bti;
        this.oAm = new a();
        this.oAm.oyQ = System.currentTimeMillis();
        this.oAm.oyY = 2;
        this.oAm.oyX = (long) this.oAl;
        this.oAm.position = (long) (i + 1);
        bth bHT = this.oAb.bHT();
        this.oAm.jHv = bHT.scene + "_" + bHT.fuu + "_" + bHT.sqL;
        if (this.oAb.bHQ().jMc) {
            this.oAm.oyW = 1;
        }
        this.oAl = 1;
        x.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "startVideoPlay %s %s %s reportInfo: %d %d", new Object[]{str, bti.sqS, bti.title, Long.valueOf(this.oAm.oyX), Long.valueOf(this.oAm.oyY)});
    }

    public final void b(bth bth) {
        ((PluginTopStory) g.n(PluginTopStory.class)).getReporter();
        bti bti = this.ozj;
        a aVar = this.oAm;
        x.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay: %s %s", new Object[]{bti, aVar});
        if (!(bti == null || aVar == null)) {
            aVar.oyR = System.currentTimeMillis();
            aVar.oyS = aVar.oyR - aVar.oyQ;
            String a = c.a(bth, bti, aVar);
            if (!bi.oW(a)) {
                bgx bgx = new bgx();
                bgx.shQ = a;
                x.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14436VideoPlayReportString %s", new Object[]{bgx.shQ});
                g.DF().a(new n(bgx), 0);
            }
            x.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay 15414 %s", new Object[]{String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(bth.scene), bti.sqS, Long.valueOf(bti.srb), "mp4", Integer.valueOf(bti.sqR), Integer.valueOf(0), Long.valueOf(aVar.oyQ), Long.valueOf(aVar.oyR), Long.valueOf(aVar.oyT), Long.valueOf(aVar.oyS), Long.valueOf(aVar.oyV), Long.valueOf(aVar.oyW), Long.valueOf(aVar.oyX), Long.valueOf(aVar.oyY), Long.valueOf(aVar.ozb), Long.valueOf(aVar.ozc), Long.valueOf(aVar.oyU), Long.valueOf(aVar.ozd), Long.valueOf(aVar.oze), Long.valueOf(aVar.ozg), Long.valueOf(aVar.ozh), aVar.jHv, Long.valueOf(aVar.position), p.bjC(), Long.valueOf(aVar.ozf), Long.valueOf(aVar.ozi), Long.valueOf(aVar.oyZ), Long.valueOf(aVar.oza)})});
            f.mDy.k(15414, r0);
            com.tencent.mm.plugin.topstory.a.a.a.a(aVar);
        }
        this.ozj = null;
        this.oAm = null;
    }
}
