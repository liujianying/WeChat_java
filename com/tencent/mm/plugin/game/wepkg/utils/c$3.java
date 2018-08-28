package com.tencent.mm.plugin.game.wepkg.utils;

import com.tencent.mm.plugin.game.wepkg.model.h;
import java.util.List;

class c$3 implements Runnable {
    final /* synthetic */ c kgq;
    final /* synthetic */ List kgs;

    c$3(c cVar, List list) {
        this.kgq = cVar;
        this.kgs = list;
    }

    public final void run() {
        int i = 0;
        while (i < this.kgs.size() && i < 5) {
            h.aVz().aC((String) this.kgs.get(i), false);
            i++;
        }
    }
}
