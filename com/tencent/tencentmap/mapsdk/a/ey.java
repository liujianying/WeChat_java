package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.eq.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ey {
    private static String d = "bott";
    public ep a;
    public String b;
    public List c = new ArrayList();

    public ey(fb fbVar) {
        if (fbVar.j() == 0 || !fbVar.r()) {
            this.c.add(a(fbVar));
        } else if (fw.c) {
            this.c.add(a(fbVar));
        } else {
            du a = ed.a();
            if (a != null) {
                a a2 = a.a(fbVar.c());
                if (a2 != null) {
                    this.a = a2.f();
                    Collection c = a2.c();
                    this.b = a2.e();
                    if (c != null && c.size() > fbVar.j()) {
                        c = c.subList(0, fbVar.j());
                    }
                    boolean a3 = a(c, this.a);
                    if (this.b == null || this.b.contains(d)) {
                        if (!(this.a == null || a3)) {
                            this.c.add(this.a);
                        }
                        this.c.add(a(fbVar));
                        this.c.addAll(c);
                        return;
                    }
                    this.c.addAll(c);
                    if (!(this.a == null || a3)) {
                        this.c.add(this.a);
                    }
                    this.c.add(a(fbVar));
                    return;
                }
                this.c.add(a(fbVar));
                return;
            }
            this.c.add(a(fbVar));
        }
    }

    private static ep a(fb fbVar) {
        return fbVar.d() != null ? new ep(fbVar.c(), fbVar.d()[0]) : new ep(fbVar.c(), -1);
    }

    private static boolean a(List list, ep epVar) {
        for (ep a : list) {
            if (a.a(epVar)) {
                return true;
            }
        }
        return false;
    }
}
