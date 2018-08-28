package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.modelcdntran.i.b;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.protocal.c.btj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class g$b implements b {
    final /* synthetic */ g oAe;

    private g$b(g gVar) {
        this.oAe = gVar;
    }

    /* synthetic */ g$b(g gVar, byte b) {
        this(gVar);
    }

    public final void b(String str, keep_SceneResult keep_sceneresult) {
        if (this.oAe.oAd.containsKey(str)) {
            btj btj = (btj) this.oAe.oAd.get(str);
            btj.srf = (long) keep_sceneresult.field_recvedBytes;
            btj.srg = (btj.srf * 100) / ((long) keep_sceneresult.field_fileLength);
            btj.srb = (long) keep_sceneresult.field_fileLength;
            this.oAe.oAd.put(str, btj);
            x.i("MicroMsg.TopStory.TopStoryPreloadMgr", "VideoPreloadCallback onFinish %s %d %s", new Object[]{str, Long.valueOf(btj.srg), bi.a(btj.srf, 100.0d)});
        }
    }
}
