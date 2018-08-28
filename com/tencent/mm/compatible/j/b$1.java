package com.tencent.mm.compatible.j;

import android.content.Intent;
import com.tencent.mm.compatible.a.a.a;

class b$1 implements a {
    final /* synthetic */ Intent dgK;

    b$1(Intent intent) {
        this.dgK = intent;
    }

    public final void run() {
        this.dgK.putExtra("android.intent.extra.durationLimit", 30);
        this.dgK.putExtra("android.intent.extra.sizeLimit", 10485760);
    }
}
