package com.tencent.mm.plugin.music.ui;

import android.view.View;
import com.tencent.mm.an.a;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.plugin.music.ui.MusicMainUI.2;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.Map.Entry;

class MusicMainUI$2$4 implements Runnable {
    final /* synthetic */ jt lBf;
    final /* synthetic */ 2 lBg;

    MusicMainUI$2$4(2 2, jt jtVar) {
        this.lBg = 2;
        this.lBf = jtVar;
    }

    public final void run() {
        boolean z;
        b h = MusicMainUI.h(this.lBg.lBe);
        a aVar = this.lBf.bTE.bTF;
        boolean z2 = false;
        Iterator it = h.lAB.entrySet().iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            b$a b_a = (b$a) ((View) ((Entry) it.next()).getValue()).getTag();
            if (b_a.bTF.field_musicId.equals(aVar.field_musicId)) {
                b_a.f(aVar, true);
                z2 = true;
            } else {
                z2 = z;
            }
        }
        if (!z) {
            x.i("MicroMsg.Music.MusicMainAdapter", "holder song id is not exist, do refresh all");
            h.notifyDataSetChanged();
        }
    }
}
