package com.tencent.mm.plugin.music.model.e;

import android.widget.Toast;
import com.tencent.mm.plugin.music.b.e;
import com.tencent.mm.plugin.music.model.e.e.2;
import com.tencent.mm.sdk.platformtools.ad;

class e$2$2 implements Runnable {
    final /* synthetic */ 2 lzQ;

    e$2$2(2 2) {
        this.lzQ = 2;
    }

    public final void run() {
        Toast.makeText(ad.getContext(), ad.getContext().getString(e.music_url_wrong), 1).show();
    }
}
