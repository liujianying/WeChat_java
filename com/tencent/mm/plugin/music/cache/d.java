package com.tencent.mm.plugin.music.cache;

import com.tencent.mm.an.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class d implements b {
    private List<String> git = new ArrayList(10);

    static /* synthetic */ void a(d dVar) {
        x.i("MicroMsg.PieceCacheCleanController", "clean music piece file");
        String str = g.Ei().dqp;
        String str2 = str.endsWith("/") ? str + "music" : str + File.separator + "music";
        File file = new File(str2);
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (list == null || list.length == 0) {
                x.i("MicroMsg.PieceCacheCleanController", "none files exist");
                return;
            }
            for (String str3 : list) {
                if (dVar.uw(str3)) {
                    x.i("MicroMsg.PieceCacheCleanController", "file is the block file, don't delete");
                } else {
                    file = new File(str2 + File.separator + str3);
                    if (!file.exists()) {
                        x.i("MicroMsg.PieceCacheCleanController", "file not exist");
                    } else if (file.isDirectory()) {
                        x.i("MicroMsg.PieceCacheCleanController", "file is directory, don't delete");
                    } else if (System.currentTimeMillis() - file.lastModified() > lxt.longValue()) {
                        x.e("MicroMsg.PieceCacheCleanController", "Clean 7 days file in music file name=%s, path:%s", new Object[]{file.getName(), file.getAbsolutePath()});
                        file.delete();
                        if (str3.startsWith("piece")) {
                            x.e("MicroMsg.PieceCacheCleanController", "file is piece prefix, delete the piece info in db");
                            ((a) g.l(a.class)).mt(str3);
                        }
                    } else {
                        x.i("MicroMsg.PieceCacheCleanController", "not delete the file, file is in valid time for 7 day");
                    }
                }
            }
            return;
        }
        x.i("MicroMsg.PieceCacheCleanController", "musicFolder is not exist or not Directory");
    }

    public d(List<String> list) {
        if (!list.isEmpty()) {
            this.git.addAll(list);
        }
    }

    public final void bhJ() {
        long longValue = ((Long) g.Ei().DT().get(aa.a.sWo, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue <= lxu.longValue()) {
            x.e("MicroMsg.PieceCacheCleanController", "startClean the last clean time is in MUSIC_NO_SCAN_TIME time");
            return;
        }
        x.i("MicroMsg.PieceCacheCleanController", "start clean music file");
        g.Ei().DT().a(aa.a.sWo, Long.valueOf(currentTimeMillis));
        e.post(new 1(this), "PieceCacheCleanController");
    }

    private boolean uw(String str) {
        for (String contains : this.git) {
            if (str.contains(contains)) {
                return true;
            }
        }
        return false;
    }
}
