package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.c$c;
import com.google.android.gms.common.api.c.b;

public final class c<T extends IInterface> extends k<T> {
    private final d<T> aNq;

    public c(Context context, Looper looper, int i, b bVar, c$c c_c, h hVar, d dVar) {
        super(context, looper, i, hVar, bVar, c_c);
        this.aNq = dVar;
    }

    protected final T f(IBinder iBinder) {
        return this.aNq.oy();
    }

    protected final String ow() {
        return this.aNq.ow();
    }

    protected final String ox() {
        return this.aNq.ox();
    }
}
