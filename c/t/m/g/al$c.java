package c.t.m.g;

import android.os.SystemClock;
import c.t.m.g.al.a;
import c.t.m.g.al.d;
import java.util.ArrayList;
import java.util.List;

final class al$c extends a {
    private d a;
    private /* synthetic */ al b;

    public al$c(al alVar, d dVar) {
        this.b = alVar;
        super(alVar, (byte) 0);
        this.a = dVar;
    }

    public final void run() {
        al.g(this.b);
        al.a(this.b, SystemClock.elapsedRealtime());
        int size;
        int i;
        if (this.a.d) {
            if (al.j(this.b) > 0) {
                al.k(this.b);
            }
            this.b.a.addAndGet(this.a.f);
            if (!this.a.b) {
                size = this.a.e.size();
                List arrayList = new ArrayList();
                for (i = 0; i < size; i++) {
                    arrayList.add(Long.valueOf(((av.a) this.a.e.get(i)).a));
                }
                av.a(this.b.c()).a(arrayList);
                if (al.l(this.b)) {
                    al.m(this.b);
                    al.a(this.b, true, this.a.c);
                    return;
                }
            }
            if (this.a.a) {
                al.a(this.b, true);
                return;
            }
            SystemClock.sleep(200);
            al.a(this.b, this.a.b, this.a.c);
            return;
        }
        if (p.h()) {
            if (al.j(this.b) > 0) {
                if (al.j(this.b) < w.a("report_interval_forbid_limit", 30, 1440, 60)) {
                    al.n(this.b);
                }
            } else {
                al.o(this.b);
            }
        }
        if (this.a.c && this.a.b) {
            size = this.a.e.size();
            for (i = 0; i < size; i++) {
                av.a(this.b.c()).b(((av.a) this.a.e.get(i)).b);
            }
        }
    }
}
