package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.signin.internal.i;
import java.util.concurrent.Executors;

public final class b {
    public static final c<i> baS = new c();
    public static final c<i> baT = new c();
    public static final a<i, e> baU = new 1();
    static final a<i, Object> baV = new a<i, Object>() {
        public final /* synthetic */ com.google.android.gms.common.api.a.b a(Context context, Looper looper, h hVar, Object obj, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar) {
            e eVar = e.bbb;
            return new i(context, looper, false, hVar, bVar, cVar, Executors.newSingleThreadExecutor());
        }
    };
    public static final Scope baW = new Scope("profile");
    public static final Scope baX = new Scope("email");
    public static final com.google.android.gms.common.api.a<e> baY = new com.google.android.gms.common.api.a("SignIn.API", baU, baS);
    public static final com.google.android.gms.common.api.a<Object> baZ = new com.google.android.gms.common.api.a("SignIn.INTERNAL_API", baV, baT);
    public static final c bba = new com.google.android.gms.signin.internal.h();
}
