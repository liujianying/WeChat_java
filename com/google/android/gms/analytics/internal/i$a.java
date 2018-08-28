package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.w;

public final class i$a {
    final long aFA;
    final /* synthetic */ i aFB;
    private final String mName;

    private i$a(i iVar, String str, long j) {
        this.aFB = iVar;
        w.bg(str);
        w.au(j > 0);
        this.mName = str;
        this.aFA = j;
    }

    /* synthetic */ i$a(i iVar, String str, long j, byte b) {
        this(iVar, str, j);
    }

    private String mY() {
        return this.mName + ":start";
    }

    final void mW() {
        long currentTimeMillis = this.aFB.aFn.aFC.currentTimeMillis();
        Editor edit = this.aFB.aFw.edit();
        edit.remove(mZ());
        edit.remove(na());
        edit.putLong(mY(), currentTimeMillis);
        edit.commit();
    }

    final long mX() {
        return this.aFB.aFw.getLong(mY(), 0);
    }

    final String mZ() {
        return this.mName + ":count";
    }

    final String na() {
        return this.mName + ":value";
    }
}
