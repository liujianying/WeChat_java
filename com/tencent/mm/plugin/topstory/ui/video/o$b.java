package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.topstory.a.b.a;
import com.tencent.mm.protocal.c.btj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class o$b implements b {
    final /* synthetic */ o oCk;
    private btj oCp;

    private o$b(o oVar) {
        this.oCk = oVar;
    }

    /* synthetic */ o$b(o oVar, byte b) {
        this(oVar);
    }

    public final void q(String str, String str2, String str3) {
        btj btj;
        o$a o_a;
        x.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startHttpStream %s %s", new Object[]{str, str2});
        g bHV = this.oCk.oAb.bHV();
        a aVar = bHV.oAb.bHU().oAm;
        if (aVar != null && bHV.oAd.containsKey(str)) {
            btj = (btj) bHV.oAd.get(str);
            if (btj.srg >= 5) {
                x.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s percent %d offset %s", new Object[]{str, Long.valueOf(btj.srg), bi.gc(btj.srf)});
                aVar.oyY = 1;
                aVar.oyZ = btj.srg;
                aVar.oza = btj.srf;
                com.tencent.mm.plugin.websearch.api.a.a.kB(25);
                this.oCp = btj;
                o_a = new o$a(this.oCk, (byte) 0);
                if (this.oCp == null) {
                    boolean queryVideoMoovInfo;
                    long[] jArr = new long[2];
                    if (this.oCp.srg < 100) {
                        o.Tb().a(o.a(str, str3, str2, o_a), false);
                        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
                        c2CDownloadRequest.fileKey = str;
                        c2CDownloadRequest.fileType = 90;
                        c2CDownloadRequest.url = str3;
                        c2CDownloadRequest.savePath = str2;
                        queryVideoMoovInfo = CdnLogic.queryVideoMoovInfo(c2CDownloadRequest, jArr);
                    } else {
                        queryVideoMoovInfo = true;
                        jArr[0] = new com.tencent.mm.plugin.a.b().oY(str2);
                    }
                    x.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "moov check mediaId %s ret %b", new Object[]{str, Boolean.valueOf(queryVideoMoovInfo)});
                    if (queryVideoMoovInfo && !o_a.oCl) {
                        o_a.onMoovReady(str, (int) jArr[0], (int) jArr[1]);
                    }
                    if (o.G(this.oCp.srg, this.oCp.srf)) {
                        o_a.bIC();
                    }
                    if (this.oCp.srg == 100) {
                        o_a.h(str, (int) this.oCp.srf, (int) this.oCp.srg);
                        o_a.L(str, 0);
                    }
                }
                o.Tb().a(o.a(str, str3, str2, o_a), false);
                return;
            }
            x.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s but preload percent too small %d offset %s", new Object[]{str, Long.valueOf(btj.srg), bi.gc(btj.srf)});
            aVar.oyY = 3;
        }
        for (String lx : bHV.oAd.keySet()) {
            g.ND().lx(lx);
        }
        btj = null;
        this.oCp = btj;
        o_a = new o$a(this.oCk, (byte) 0);
        if (this.oCp == null) {
            o.Tb().a(o.a(str, str3, str2, o_a), false);
            return;
        }
        boolean queryVideoMoovInfo2;
        long[] jArr2 = new long[2];
        if (this.oCp.srg < 100) {
            o.Tb().a(o.a(str, str3, str2, o_a), false);
            C2CDownloadRequest c2CDownloadRequest2 = new C2CDownloadRequest();
            c2CDownloadRequest2.fileKey = str;
            c2CDownloadRequest2.fileType = 90;
            c2CDownloadRequest2.url = str3;
            c2CDownloadRequest2.savePath = str2;
            queryVideoMoovInfo2 = CdnLogic.queryVideoMoovInfo(c2CDownloadRequest2, jArr2);
        } else {
            queryVideoMoovInfo2 = true;
            jArr2[0] = new com.tencent.mm.plugin.a.b().oY(str2);
        }
        x.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "moov check mediaId %s ret %b", new Object[]{str, Boolean.valueOf(queryVideoMoovInfo2)});
        if (queryVideoMoovInfo2 && !o_a.oCl) {
            o_a.onMoovReady(str, (int) jArr2[0], (int) jArr2[1]);
        }
        if (o.G(this.oCp.srg, this.oCp.srf)) {
            o_a.bIC();
        }
        if (this.oCp.srg == 100) {
            o_a.h(str, (int) this.oCp.srf, (int) this.oCp.srg);
            o_a.L(str, 0);
        }
    }

    public final void ny(String str) {
        o.Tb().k(str, null);
    }

    public final void j(String str, int i, int i2) {
        o.Tb();
        f.g(str, i, i2);
    }

    public final boolean isVideoDataAvailable(String str, int i, int i2) {
        boolean isVideoDataAvailable = o.Tb().isVideoDataAvailable(str, i, i2);
        if (!(isVideoDataAvailable || this.oCp == null || ((long) (i + i2)) > this.oCp.srf)) {
            isVideoDataAvailable = true;
        }
        if (i == 0 && isVideoDataAvailable && this.oCk.oAb != null) {
            a aVar = this.oCk.oAb.bHU().oAm;
            if (aVar != null && aVar.ozg == 0) {
                aVar.ozg = System.currentTimeMillis() - aVar.oyQ;
                aVar.ozh = (long) i;
                aVar.ozi = (long) (i + i2);
                x.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "firstDataAvailable %d %d %d", new Object[]{Long.valueOf(aVar.ozd), Integer.valueOf(i), Integer.valueOf(i2)});
            }
        }
        return isVideoDataAvailable;
    }

    public final void a(b.a aVar) {
    }
}
