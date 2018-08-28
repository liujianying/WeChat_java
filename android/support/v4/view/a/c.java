package android.support.v4.view.a;

import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private static final a xQ;
    public final Object xR;

    interface a {
        Object a(c cVar);
    }

    static class d implements a {
        d() {
        }

        public Object a(c cVar) {
            return null;
        }
    }

    static class b extends d {
        b() {
        }

        public final Object a(final c cVar) {
            return new android.support.v4.view.a.d.AnonymousClass1(new a() {
                public final boolean cr() {
                    return c.cr();
                }

                public final List<Object> cs() {
                    List list = null;
                    c.cs();
                    List<Object> arrayList = new ArrayList();
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        arrayList.add(((b) list.get(i)).xs);
                    }
                    return arrayList;
                }

                public final Object cu() {
                    c.cq();
                    return null;
                }
            });
        }
    }

    static class c extends d {
        c() {
        }

        public final Object a(final c cVar) {
            return new android.support.v4.view.a.e.AnonymousClass1(new a() {
                public final boolean cr() {
                    return c.cr();
                }

                public final List<Object> cs() {
                    List list = null;
                    c.cs();
                    List<Object> arrayList = new ArrayList();
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        arrayList.add(((b) list.get(i)).xs);
                    }
                    return arrayList;
                }

                public final Object cu() {
                    c.cq();
                    return null;
                }

                public final Object cv() {
                    c.ct();
                    return null;
                }
            });
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            xQ = new c();
        } else if (VERSION.SDK_INT >= 16) {
            xQ = new b();
        } else {
            xQ = new d();
        }
    }

    public c() {
        this.xR = xQ.a(this);
    }

    public c(Object obj) {
        this.xR = obj;
    }

    public static b cq() {
        return null;
    }

    public static boolean cr() {
        return false;
    }

    public static List<b> cs() {
        return null;
    }

    public static b ct() {
        return null;
    }
}
