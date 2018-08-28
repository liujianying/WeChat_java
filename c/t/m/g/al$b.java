package c.t.m.g;

import android.text.TextUtils;
import c.t.m.g.al.a;

public final class al$b extends a {
    private String a;
    private boolean b = true;
    private /* synthetic */ al c;

    public al$b(al alVar, String str) {
        this.c = alVar;
        super(alVar, (byte) 0);
        this.a = str;
    }

    public final void run() {
        al.b(this.c).decrementAndGet();
        if (!TextUtils.isEmpty(this.a)) {
            int a = w.a("report_new_record_num", 1, 50, 10);
            if (av.a(this.c.c()).b(this.a) != -1) {
                if (al.c(this.c)) {
                    al.a(this.c, false);
                    al.b(this.c, false);
                }
                if (al.d(this.c).incrementAndGet() >= a) {
                    al.a(this.c, false, this.b);
                    return;
                }
                return;
            }
            al.d();
        }
    }
}
