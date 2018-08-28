package com.tencent.mm.plugin.ext;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

class b$9 implements a {
    final /* synthetic */ b iJo;

    b$9(b bVar) {
        this.iJo = bVar;
    }

    public final void a(String str, l lVar) {
        if (!b.b(this.iJo).contains(str)) {
            b.b(this.iJo).add(str);
        }
        b.c(this.iJo).removeMessages(0);
        b.c(this.iJo).sendEmptyMessageDelayed(0, 60);
    }
}
