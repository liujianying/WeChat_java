package com.tencent.mm.modelvoice;

import android.widget.Toast;
import com.tencent.mm.modelvoice.i.a;
import com.tencent.mm.sdk.platformtools.ad;

class i$a$1 implements Runnable {
    final /* synthetic */ a epj;

    i$a$1(a aVar) {
        this.epj = aVar;
    }

    public final void run() {
        Toast.makeText(ad.getContext(), "Save to: " + this.epj.epi.epd.mFilePath, 1).show();
    }
}
