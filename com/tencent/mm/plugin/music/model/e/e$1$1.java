package com.tencent.mm.plugin.music.model.e;

import android.widget.Toast;
import com.tencent.mm.plugin.music.b.e;
import com.tencent.mm.plugin.music.model.e.e.1;
import com.tencent.mm.sdk.platformtools.ad;

class e$1$1 implements Runnable {
    final /* synthetic */ 1 lzP;

    e$1$1(1 1) {
        this.lzP = 1;
    }

    public final void run() {
        if (System.currentTimeMillis() - this.lzP.lzN > 10000) {
            this.lzP.lzN = System.currentTimeMillis();
            Toast.makeText(ad.getContext(), ad.getContext().getString(e.music_file_wrong), 0).show();
        }
    }
}
