package com.tencent.mm.plugin.appbrand.g.a;

import android.text.TextUtils;
import com.eclipsesource.v8.V8Object;

abstract class b {
    private final String mKey;

    protected abstract void a(f fVar, V8Object v8Object);

    b() {
        this("");
    }

    b(String str) {
        this.mKey = str;
    }

    final b a(f fVar) {
        if (TextUtils.isEmpty(this.mKey)) {
            a(fVar, fVar.gek);
        } else {
            V8Object v8Object = new V8Object(fVar.gek);
            fVar.gek.add(this.mKey, v8Object);
            a(fVar, v8Object);
        }
        return this;
    }
}
