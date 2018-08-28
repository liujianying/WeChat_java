package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.protocal.c.bti;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class g$a implements Runnable {
    private String jCh;
    final /* synthetic */ g oAe;

    g$a(g gVar, String str) {
        this.oAe = gVar;
        this.jCh = str;
    }

    public final void run() {
        x.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask Start preloadSize: %d", new Object[]{Integer.valueOf(this.oAe.oAd.size())});
        File file = new File(this.jCh);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                Object obj = "";
                if (this.oAe.oAb != null) {
                    bti bti = this.oAe.oAb.bHS().oCf;
                    if (bti != null) {
                        obj = d.ak(bti.sqS, bti.sqT);
                    }
                }
                for (File file2 : listFiles) {
                    String str = file2.getName().split("\\.")[0];
                    if (!(str.equals(obj) || this.oAe.oAd.containsKey(str))) {
                        file2.delete();
                        x.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Delete cache video %s", new Object[]{file2.getName()});
                    }
                }
            }
        }
    }
}
