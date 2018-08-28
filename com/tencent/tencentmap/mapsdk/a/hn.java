package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class hn extends aq {
    protected String a = "GBK";

    /* renamed from: a */
    public final hn taf_hash(int i) {
        super.taf_hash(i);
        return this;
    }

    public final Map a() {
        return new HashMap();
    }

    public final int a(String str, ly lyVar, ly lyVar2) {
        return a(str, lyVar, lyVar2, a());
    }

    public final int a(String str, ly lyVar, ly lyVar2, Map map) {
        me meVar = new me(0);
        meVar.a(this.a);
        meVar.a(str, 1);
        if (lyVar.a != null) {
            meVar.a(lyVar.a, 2);
        }
        if (lyVar2.a != null) {
            meVar.a(lyVar2.a, 3);
        }
        md mdVar = new md(taf_invoke("findObjectByIdInSameGroup", mg.a(meVar.a()), map, new HashMap()));
        mdVar.a(this.a);
        int a = mdVar.a(0, 0, true);
        lyVar.a = new ArrayList();
        lyVar.a.add(new fl());
        lyVar.a = (ArrayList) mdVar.a(lyVar.a, 2, true);
        lyVar2.a = new ArrayList();
        lyVar2.a.add(new fl());
        lyVar2.a = (ArrayList) mdVar.a(lyVar2.a, 3, true);
        return a;
    }

    public final void a(gm gmVar, String str) {
        a(gmVar, str, a());
    }

    public final void a(gm gmVar, String str, Map map) {
        me meVar = new me(0);
        meVar.a(this.a);
        meVar.a(str, 1);
        ar arVar = gmVar;
        a(arVar, "findObjectByIdInSameGroup", mg.a(meVar.a()), map, new HashMap());
    }

    public final int a(String str, String str2, ly lyVar, ly lyVar2) {
        return a(str, str2, lyVar, lyVar2, a());
    }

    public final int a(String str, String str2, ly lyVar, ly lyVar2, Map map) {
        me meVar = new me(0);
        meVar.a(this.a);
        meVar.a(str, 1);
        meVar.a(str2, 2);
        if (lyVar.a != null) {
            meVar.a(lyVar.a, 3);
        }
        if (lyVar2.a != null) {
            meVar.a(lyVar2.a, 4);
        }
        md mdVar = new md(taf_invoke("findObjectByIdInSameSet", mg.a(meVar.a()), map, new HashMap()));
        mdVar.a(this.a);
        int a = mdVar.a(0, 0, true);
        lyVar.a = new ArrayList();
        lyVar.a.add(new fl());
        lyVar.a = (ArrayList) mdVar.a(lyVar.a, 3, true);
        lyVar2.a = new ArrayList();
        lyVar2.a.add(new fl());
        lyVar2.a = (ArrayList) mdVar.a(lyVar2.a, 4, true);
        return a;
    }

    public final void a(gm gmVar, String str, String str2) {
        a(gmVar, str, str2, a());
    }

    public final void a(gm gmVar, String str, String str2, Map map) {
        me meVar = new me(0);
        meVar.a(this.a);
        meVar.a(str, 1);
        meVar.a(str2, 2);
        ar arVar = gmVar;
        a(arVar, "findObjectByIdInSameSet", mg.a(meVar.a()), map, new HashMap());
    }
}
