package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.c$c;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.signin.internal.i;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

class b$1 extends a<i, e> {
    b$1() {
    }

    public final /* synthetic */ b a(Context context, Looper looper, h hVar, Object obj, c.b bVar, c$c c_c) {
        return new i(context, looper, true, hVar, bVar, c_c, Executors.newSingleThreadExecutor());
    }

    public final /* synthetic */ List ot() {
        return Arrays.asList(new Scope[]{b.baW, b.baX});
    }
}
