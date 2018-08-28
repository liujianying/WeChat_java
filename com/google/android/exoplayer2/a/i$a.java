package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.e.a;
import com.google.android.exoplayer2.a.e.a.4;
import com.google.android.exoplayer2.a.e.a.6;
import com.google.android.exoplayer2.a.f.f;

final class i$a implements f {
    final /* synthetic */ i aht;

    private i$a(i iVar) {
        this.aht = iVar;
    }

    /* synthetic */ i$a(i iVar, byte b) {
        this(iVar);
    }

    public final void cb(int i) {
        a a = i.a(this.aht);
        if (a.afC != null) {
            a.handler.post(new 6(a, i));
        }
        i.jr();
    }

    public final void iS() {
        i.js();
        i.b(this.aht);
    }

    public final void d(int i, long j, long j2) {
        a a = i.a(this.aht);
        if (a.afC != null) {
            a.handler.post(new 4(a, i, j, j2));
        }
        i.jt();
    }
}
