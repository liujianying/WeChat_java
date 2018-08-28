package com.tencent.mm.plugin.music.model.e;

import android.widget.Toast;
import com.tencent.mm.plugin.music.b.e;
import com.tencent.mm.plugin.music.model.e.e.2;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.platformtools.ad;

class e$2$1 implements Runnable {
    final /* synthetic */ int bAM;
    final /* synthetic */ 2 lzQ;

    e$2$1(2 2, int i) {
        this.lzQ = 2;
        this.bAM = i;
    }

    public final void run() {
        Toast.makeText(ad.getContext(), ad.getContext().getString(e.music_url_wrong), 0).show();
        e.a(this.lzQ.lzO, h.bic().bhR(), this.bAM);
    }
}
