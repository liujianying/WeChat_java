package com.tencent.mm.d;

import com.tencent.mm.d.e.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.t.c;

class e$a$1 implements Runnable {
    final /* synthetic */ a bCC;

    e$a$1(a aVar) {
        this.bCC = aVar;
    }

    public final void run() {
        x.d("MicroMsg.EmojiAndTextArtist", "cancel focus!");
        if (this.bCC.bCB.vG() != null) {
            c ys = ((com.tencent.mm.cache.c) this.bCC.bCB.vG()).ys();
            if (ys != null && ys.dnN) {
                ys.setSelected(false);
                a.a(this.bCC).aH(false);
                a.a(this.bCC).vO();
            }
        }
    }
}
