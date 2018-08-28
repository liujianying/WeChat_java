package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.model.g.b;
import com.tencent.mm.sdk.platformtools.x;

class g$5 implements Runnable {
    final /* synthetic */ g nnr;

    g$5(g gVar) {
        this.nnr = gVar;
    }

    public final void run() {
        if (g.d(this.nnr)) {
            x.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
        } else if (g.e(this.nnr).size() > 0) {
            x.i("MicroMsg.LazyerImageLoader2", "tryStart loaderlist size:" + g.e(this.nnr).size());
            ((b) g.e(this.nnr).removeLast()).o(new String[]{""});
        }
    }
}
