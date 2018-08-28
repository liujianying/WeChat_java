package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.f.a.g;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.j;
import java.util.List;

final class r {
    private final List<Format> anf;
    private final k[] ani;

    public r(List<Format> list) {
        this.anf = list;
        this.ani = new k[list.size()];
    }

    public final void a(f fVar, d dVar) {
        for (int i = 0; i < this.ani.length; i++) {
            boolean z;
            dVar.kf();
            k cp = fVar.cp(dVar.kg());
            Format format = (Format) this.anf.get(i);
            String str = format.adW;
            if ("application/cea-608".equals(str) || "application/cea-708".equals(str)) {
                z = true;
            } else {
                z = false;
            }
            a.b(z, "Invalid closed caption mime type provided: " + str);
            cp.f(Format.a(format.id != null ? format.id : dVar.kh(), str, format.ael, format.aem, format.aen));
            this.ani[i] = cp;
        }
    }

    public final void a(long j, j jVar) {
        g.a(j, jVar, this.ani);
    }
}
