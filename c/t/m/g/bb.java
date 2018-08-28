package c.t.m.g;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bb extends ay implements bx {
    private ab a = new ab();
    private List<d> b = new ArrayList();

    public bb() {
        Object b = cd.b("settings_in_client", "");
        if (!TextUtils.isEmpty(b)) {
            try {
                this.a.a(b);
                c();
            } catch (Throwable th) {
                cd.a("settings_in_client", "");
            }
        }
    }

    private synchronized void c() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public final String a() {
        return "settings";
    }

    public final String a(String str, int i, String str2, String str3, String str4, String str5) {
        return this.a.a(str, i, str2, str3, str4, str5);
    }

    public final void a(String str, String str2) {
        if (!(TextUtils.isEmpty(str2) || bf.a().b().equals(str2))) {
            bf.a().a(str2, true);
        }
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.a) {
                this.a.b();
                this.a.a(str);
            }
            cd.a("settings_in_client", this.a.a());
            c();
        }
    }

    public final void a_() {
        bz.c().b();
    }
}
