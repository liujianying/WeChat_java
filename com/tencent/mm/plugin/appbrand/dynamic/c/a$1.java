package com.tencent.mm.plugin.appbrand.dynamic.c;

import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.f;

class a$1 implements Runnable {
    final /* synthetic */ String[] dhB;
    final /* synthetic */ a fvA;

    a$1(a aVar, String[] strArr) {
        this.fvA = aVar;
        this.dhB = strArr;
    }

    public final void run() {
        String str = "com.tencent.mm";
        if (this.dhB.length > 2 && !TextUtils.isEmpty(this.dhB[2])) {
            str = str + ":" + this.dhB[2];
        }
        f.a(str, null, a$a.class, null);
    }
}
