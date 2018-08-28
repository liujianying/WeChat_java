package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelcdntran.j.a;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.g.b;
import com.tencent.mm.plugin.topstory.ui.video.g.c;
import com.tencent.mm.protocal.c.bti;
import com.tencent.mm.protocal.c.btj;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class o$a implements a {
    final /* synthetic */ o oCk;
    boolean oCl;
    private boolean oCm;

    private o$a(o oVar) {
        this.oCk = oVar;
    }

    /* synthetic */ o$a(o oVar, byte b) {
        this(oVar);
    }

    public final void onMoovReady(String str, int i, int i2) {
        if (!this.oCl) {
            this.oCl = true;
            ah.A(new 1(this, i, i2, str));
        }
    }

    public final void onDataAvailable(String str, int i, int i2) {
        ah.A(new 2(this, str, i, i2));
    }

    public final void h(String str, int i, int i2) {
        ah.A(new 3(this, str, i, i2));
    }

    public final void bIC() {
        if (!this.oCm && this.oCk.oCf != null && this.oCk.oAb != null) {
            int i;
            this.oCm = true;
            g bHV = this.oCk.oAb.bHV();
            bti bti = this.oCk.oCf;
            int size = bHV.oAb.bHO().size();
            for (int i2 = 0; i2 < size; i2++) {
                if (bti.sqS.equals(((bti) bHV.oAb.bHO().get(i2)).sqS)) {
                    i = i2;
                    break;
                }
            }
            i = -1;
            List<bti> arrayList = new ArrayList();
            if (i >= 0 && i + 1 < size) {
                for (i++; i < size; i++) {
                    arrayList.add(bHV.oAb.bHO().get(i));
                }
            }
            Map hashMap = new HashMap();
            for (bti bti2 : arrayList) {
                btj btj;
                String ak = d.ak(bti2.sqS, bti2.sqT);
                if (bHV.oAd.containsKey(ak)) {
                    btj = (btj) bHV.oAd.get(ak);
                } else {
                    btj = new btj();
                    btj.mediaId = ak;
                    btj.srb = bti2.srb;
                }
                hashMap.put(ak, btj);
                int longValue = (int) ((com.tencent.mm.plugin.topstory.a.a.a.oyP.longValue() * 100) / bti2.srb);
                if (longValue < 20) {
                    longValue = 20;
                } else if (longValue > 100) {
                    longValue = 100;
                }
                if (btj.srg < ((long) longValue)) {
                    String str = bHV.oAb.bHW() + ak + ".mp4";
                    String str2 = bti2.videoUrl;
                    i jVar = new j();
                    jVar.field_mediaId = ak;
                    jVar.url = str2;
                    jVar.dQg = 2;
                    jVar.dQm = 2;
                    jVar.dQh = 3;
                    jVar.dQr = longValue;
                    jVar.field_preloadRatio = longValue;
                    jVar.concurrentCount = 4;
                    jVar.field_fullpath = str;
                    jVar.dPV = new c(bHV, (byte) 0);
                    jVar.dQi = new b(bHV, (byte) 0);
                    g.ND().b(jVar, -1);
                    x.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Preload video %s from %s to %s", new Object[]{ak, Long.valueOf(btj.srg), Integer.valueOf(longValue)});
                } else {
                    x.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Already Preload video %s %s", new Object[]{ak, Long.valueOf(btj.srg)});
                }
                if (hashMap.size() == 3) {
                    break;
                }
            }
            bHV.oAd.clear();
            bHV.oAd.putAll(hashMap);
            e.post(new g$a(bHV, bHV.oAc), "TopStory.DeleteVideoCacheTask");
        }
    }

    public final void L(String str, int i) {
        x.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onFinish %s %d", new Object[]{str, Integer.valueOf(i)});
        ah.A(new 4(this, str, i));
    }
}
