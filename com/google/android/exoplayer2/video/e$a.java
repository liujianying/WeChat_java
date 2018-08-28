package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.i.a;

public final class e$a {
    final e aDZ;
    final Handler handler;

    public e$a(Handler handler, e eVar) {
        this.handler = eVar != null ? (Handler) a.Z(handler) : null;
        this.aDZ = eVar;
    }

    public final void c(int i, int i2, int i3, float f) {
        if (this.aDZ != null) {
            this.handler.post(new 5(this, i, i2, i3, f));
        }
    }

    public final void c(Surface surface) {
        if (this.aDZ != null) {
            this.handler.post(new 6(this, surface));
        }
    }

    public final void e(d dVar) {
        if (this.aDZ != null) {
            this.handler.post(new 7(this, dVar));
        }
    }
}
