package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.launching.i.a;
import java.util.Locale;

final class i$a$a {
    String gfG;
    String gfH;

    i$a$a() {
    }

    final i$a$a m(String str, Object... objArr) {
        this.gfG = String.format(Locale.US, str, objArr);
        return this;
    }

    final i$a$a n(String str, Object... objArr) {
        this.gfH = String.format(Locale.US, str, objArr);
        return this;
    }

    final a akF() {
        return new a(this.gfH, this.gfG);
    }
}
