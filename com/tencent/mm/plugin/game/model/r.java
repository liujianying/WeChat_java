package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class r implements e {
    private static boolean bgH = false;
    private static int jMd = 20;
    private static LinkedList<k> jMe = new LinkedList();
    private static ah jMf;
    private int offset = 0;

    public static void update() {
        if (!f.aTG()) {
            x.i("MicroMsg.GameListUpdater", "No need to update");
        } else if (bgH) {
            x.e("MicroMsg.GameListUpdater", "Already running");
        } else {
            jMf = new ah("GameListUpdate");
            jMe.clear();
            r rVar = new r();
            g.DF().a(1215, rVar);
            g.DF().a(new bc(rVar.offset, jMd), 0);
            bgH = true;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            jMf.H(new 1(this, lVar));
        } else {
            aTV();
        }
    }

    private void aTV() {
        bgH = false;
        jMf.lnJ.quit();
        g.DF().b(1215, this);
    }
}
