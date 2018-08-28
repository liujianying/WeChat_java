package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ad;

class f$1 implements Runnable {
    final /* synthetic */ String fVi;
    final /* synthetic */ f fVj;

    f$1(f fVar, String str) {
        this.fVj = fVar;
        this.fVi = str;
    }

    public final void run() {
        Toast.makeText(ad.getContext(), ad.getContext().getString(j.video_file_saved, new Object[]{this.fVi}), 1).show();
    }
}
