package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class av implements Runnable {
    public static final av a = new av();
    private static int d = 60000;
    private ConcurrentHashMap<aq, au> b = new ConcurrentHashMap(128);
    private ConcurrentHashMap<aq, Object> c = new ConcurrentHashMap(128);

    class a extends gm {
        private aq d;
        private String e;

        public a(aq aqVar, String str) {
            this.d = aqVar;
            this.e = str;
        }

        public void a(int i) {
            ax.a(this.e + " callback_findObjectById_exception " + i);
        }

        public void b(int i) {
            ax.a(this.e + " callback_findObjectById4All_exception " + i);
        }

        public void a(ArrayList<fl> arrayList) {
            ax.a(this.e + "callback_findObjectById is not used");
        }

        public void a(int i, ArrayList<fl> arrayList, ArrayList<fl> arrayList2) {
            if (i == 0) {
                a(arrayList, arrayList2);
                bw.a(this.e, this.d.b.b());
                ax.c(this.e + " callback_findObjectById4All finish");
                return;
            }
            a();
            ax.b(this.e + "async findObjectById4All error , return " + i);
        }

        public void b(int i, ArrayList<fl> arrayList, ArrayList<fl> arrayList2) {
            if (i == 0) {
                a(arrayList, arrayList2);
                bw.a(this.e, this.d.b.b());
                ax.c(this.e + " callback_findObjectByIdInSameGroup finish");
                return;
            }
            a();
            ax.b(this.e + "async findObjectByIdInSameGroup error , return " + i);
        }

        public void c(int i) {
            ax.a(this.e + " callback_findObjectByIdInSameGroup_exception " + i);
        }

        private void a(ArrayList<fl> arrayList, ArrayList<fl> arrayList2) {
            au a = av.this.a(this.e, (ArrayList) arrayList, (ArrayList) arrayList2);
            if (a != null) {
                av.this.b.put(this.d, a);
                au a2 = av.this.a(a);
                this.d.c.a(a2);
                this.d.b.a(a2);
                ax.c(this.e + " async refresh serviceinfos:" + a);
            }
        }

        private void b(ArrayList<bb> arrayList, ArrayList<bb> arrayList2) {
            au b = av.this.b(this.e, (ArrayList) arrayList, (ArrayList) arrayList2);
            if (b != null) {
                av.this.b.put(this.d, b);
                au a = av.this.a(b);
                this.d.c.a(a);
                this.d.b.a(a);
                ax.c(this.e + " async refresh serviceinfos:" + b);
            }
        }

        private void a() {
            al alVar = this.d.b;
            ai a = bw.a(alVar.c(), alVar.d, alVar.c, alVar.g);
            if (a != null) {
                b((ArrayList) a.a, (ArrayList) a.b);
            }
        }

        public void c(int i, ArrayList<fl> arrayList, ArrayList<fl> arrayList2) {
            if (i == 0) {
                a(arrayList, arrayList2);
                bw.a(this.e, this.d.b.b());
                ax.c(this.e + " callback_findObjectByIdInSameStation finish");
                return;
            }
            a();
            ax.b(this.e + "async findObjectByIdInSameStation error , return " + i);
        }

        public void d(int i) {
            ax.a(this.e + " callback_findObjectByIdInSameStation_exception " + i);
        }

        public void d(int i, ArrayList<fl> arrayList, ArrayList<fl> arrayList2) {
            if (i == 0) {
                a(arrayList, arrayList2);
                bw.a(this.e, this.d.b.b());
                ax.c(this.e + " callback_findObjectByIdInSameSet finish");
                return;
            }
            a();
            ax.b(this.e + " async findObjectByIdInSameSet error , return " + i);
        }

        public void e(int i) {
            ax.a(this.e + " callback_findObjectByIdInSameSet_exception " + i);
        }

        public void e(int i, ArrayList<fl> arrayList, ArrayList<fl> arrayList2) {
        }

        public void f(int i) {
        }
    }

    private av() {
    }

    public static int a() {
        return d;
    }

    public void a(aq aqVar) {
        if (!this.c.contains(aqVar)) {
            this.c.putIfAbsent(aqVar, new Object());
        }
        if (!this.b.contains(aqVar) && aqVar.d == null) {
            au auVar = new au(aqVar.b.a);
            auVar.b((ArrayList) aqVar.b.h.a(), (ArrayList) aqVar.b.h.b());
            this.b.putIfAbsent(aqVar, auVar);
        }
    }

    public void b(aq aqVar) {
        if (aqVar.c()) {
            a(aqVar, aqVar.d, aqVar.b.a);
            aqVar.b();
            return;
        }
        ax.a(aqVar.b.a + " can not async refresh config for refreshing in 2s or queryPrx is null");
    }

    private au a(au auVar) {
        au auVar2 = new au(auVar.j);
        auVar2.b((ArrayList) auVar.a(), (ArrayList) auVar.b());
        return auVar2;
    }

    public au c(aq aqVar) {
        au auVar = (au) this.b.get(aqVar);
        if (auVar != null) {
            return a(auVar);
        }
        synchronized (this.c.get(aqVar)) {
            auVar = (au) this.b.get(aqVar);
            if (auVar == null) {
                if (!(aqVar instanceof hn)) {
                    auVar = b(aqVar, aqVar.d, aqVar.b.a);
                }
                if (auVar != null) {
                    this.b.putIfAbsent(aqVar, auVar);
                } else {
                    ax.b(aqVar.e.j + " sync get config is null");
                }
            }
        }
        if (auVar != null) {
            return a(auVar);
        }
        return new au(aqVar.e.j);
    }

    private void a(aq aqVar, hn hnVar, String str) {
        try {
            ax.c(str + " asyncRefreshConfig, " + aqVar.b.k + ", " + aqVar.b.m + " " + aqVar.b.hashCode());
            a aVar = new a(aqVar, str);
            a(aqVar.b.k, aqVar.b.m, hnVar, aVar, str);
        } catch (Throwable e) {
            ax.b(str + " asyncRefreshConfig error", e);
        }
    }

    private au b(aq aqVar, hn hnVar, String str) {
        au a;
        Object obj;
        try {
            ax.c(str + " refreshConfig, " + aqVar.b.k + ", " + aqVar.b.m);
            ly lyVar = new ly();
            ly lyVar2 = new ly();
            int a2 = a(aqVar.b.k, aqVar.b.m, hnVar, str, lyVar, lyVar2);
            if (a2 == 0) {
                a = a(str, lyVar.a(), lyVar2.a());
                obj = 1;
            } else {
                ax.b(str + " findObjectByQuery error , return " + a2);
                a = null;
                obj = null;
            }
        } catch (Throwable e) {
            ax.b(str + " findObjectByQuery error " + e, e);
            a = null;
            obj = null;
        }
        if (obj != null) {
            return a;
        }
        al alVar = aqVar.b;
        ai a3 = bw.a(alVar.c(), alVar.d, alVar.c, alVar.g);
        if (a3 != null) {
            return b(str, (ArrayList) a3.a, (ArrayList) a3.b);
        }
        return a;
    }

    private int a(boolean z, String str, hn hnVar, String str2, ly lyVar, ly lyVar2) {
        if (z) {
            return hnVar.a(str2, str, lyVar, lyVar2);
        }
        return hnVar.a(str2, lyVar, lyVar2);
    }

    private void a(boolean z, String str, hn hnVar, a aVar, String str2) {
        if (z) {
            hnVar.a(aVar, str2, str);
        } else {
            hnVar.a(aVar, str2);
        }
    }

    private au a(String str, ArrayList<fl> arrayList, ArrayList<fl> arrayList2) {
        if (arrayList.size() > 0) {
            au auVar = new au(str);
            auVar.a(arrayList, arrayList2);
            ax.c(str + " cacheServerData get config from " + auVar);
            return auVar;
        }
        ax.b(str + " callback_findObjectById4All get config from register active size = 0");
        return null;
    }

    private au b(String str, ArrayList<bb> arrayList, ArrayList<bb> arrayList2) {
        if (arrayList.size() > 0) {
            au auVar = new au(str);
            auVar.b(arrayList, arrayList2);
            ax.c(str + " cacheServerData get config from " + auVar);
            return auVar;
        }
        ax.b(str + " callback_findObjectById4All get config from register active size = 0");
        return null;
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        for (aq aqVar : this.c.keySet()) {
            if (aqVar.d != null) {
                a(aqVar, aqVar.d, aqVar.b.a);
            } else {
                ax.a(aqVar.b.a + " proxy.queryFPrx is null, can not refresh serviceInfo");
            }
        }
        ax.a("ServiceInfosRefresher run(), use: " + (System.currentTimeMillis() - currentTimeMillis));
    }
}
