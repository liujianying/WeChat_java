package com.tencent.f;

import com.tencent.f.b.b;
import com.tencent.f.b.c;
import com.tencent.f.b.d;
import java.util.HashMap;

public final class f {
    private static f vwA;
    private HashMap<String, g> vwB = new HashMap();
    HashMap<String, Object> vwC = new HashMap();
    private Object vwD = new Object();
    Object vwE = new Object();
    private a vwF = new a(this);

    static f cHr() {
        if (vwA == null) {
            synchronized (f.class) {
                if (vwA == null) {
                    vwA = new f();
                }
            }
        }
        return vwA;
    }

    public static Object adc(String str) {
        return cHr().add(str);
    }

    public static b a(d dVar) {
        return cHr().b(dVar);
    }

    private Object add(String str) {
        if (str == null) {
            throw new h("TpfServiceCenter|getService|service name should not be null");
        }
        Object obj;
        synchronized (this.vwE) {
            obj = this.vwC.get(str);
        }
        if (obj == null) {
            g gVar;
            synchronized (this.vwD) {
                gVar = (g) this.vwB.get(str);
            }
            if (gVar != null) {
                if (gVar.vwJ.vwU) {
                    return c(gVar);
                }
                Object obj2;
                if (4 == gVar.mState) {
                    try {
                        a(gVar);
                    } catch (c e) {
                        com.tencent.pb.common.c.c.x("service", new Object[]{e});
                        return null;
                    }
                }
                synchronized (this.vwE) {
                    obj2 = this.vwC.get(str);
                }
                return obj2;
            }
        }
        return obj;
    }

    private b b(d dVar) {
        Object obj = 1;
        if (dVar == null || dVar.vwS == null) {
            return null;
        }
        String str = dVar.vwS;
        this.vwF.gt("install_", str);
        try {
            b bVar;
            Object obj2;
            synchronized (this.vwD) {
                bVar = (g) this.vwB.get(str);
                if (bVar == null) {
                    bVar = new g(this, dVar);
                    bVar.mState = 2;
                    com.tencent.pb.common.c.c.d("service", new Object[]{"service [", str, "] installed!"});
                    this.vwB.put(str, bVar);
                    obj2 = 1;
                } else {
                    com.tencent.pb.common.c.c.d("service", new Object[]{"service [", str, "] had been installed!"});
                    obj2 = null;
                }
            }
            if (obj2 != null) {
                if (dVar.vwR == null) {
                    obj = null;
                }
                if (obj != null) {
                    bVar.mState = 4;
                    com.tencent.pb.common.c.c.d("service", new Object[]{"service [", str, "] resolved!"});
                } else {
                    throw new c("resolve service [" + str + "] failed.");
                }
            }
            this.vwF.gu("install_", str);
            return bVar;
        } catch (Throwable th) {
            this.vwF.gu("install_", str);
        }
    }

    final boolean a(g gVar) {
        boolean z = false;
        d dVar = gVar.vwJ;
        String str = dVar.vwS;
        this.vwF.gt("service_", str);
        try {
            if (gVar.mState == 32) {
                z = true;
            } else if (gVar.mState == 4) {
                gVar.mState = 8;
                com.tencent.pb.common.c.c.d("service", new Object[]{"service [", str, "] starting..."});
                if (dVar.vwT != null) {
                    P(dVar.vwT);
                }
                if (b(gVar)) {
                    gVar.mState = 32;
                    com.tencent.pb.common.c.c.d("service", new Object[]{"service [", str, "] active..."});
                    z = true;
                }
            }
            this.vwF.gu("service_", str);
            if (z) {
                return true;
            }
            throw new c("startService [" + str + "] failed");
        } catch (Throwable th) {
            this.vwF.gu("service_", str);
        }
    }

    private boolean P(String[] strArr) {
        if (strArr != null) {
            for (Object obj : strArr) {
                if (obj != null) {
                    g gVar;
                    synchronized (this.vwD) {
                        gVar = (g) this.vwB.get(obj);
                    }
                    if (gVar == null) {
                        return false;
                    }
                    a(gVar);
                    if (gVar.mState != 32) {
                        return false;
                    }
                    gVar.mReferenceCount++;
                    com.tencent.pb.common.c.c.d("reference_count", new Object[]{"addReferenceCount|", gVar.vwJ.vwS, "|refcount=", Integer.valueOf(gVar.mReferenceCount)});
                }
            }
        }
        return true;
    }

    private static boolean b(g gVar) {
        if (!gVar.vwJ.vwU) {
            try {
                b bVar = (b) Class.forName(gVar.vwJ.vwR).newInstance();
                gVar.vwK = bVar;
                a aVar = new a(gVar);
                gVar.vwL = aVar;
                bVar.a(aVar);
                return true;
            } catch (Exception e) {
                com.tencent.pb.common.c.c.x("service", new Object[]{e});
            }
        }
        return false;
    }

    private static Object c(g gVar) {
        try {
            c cVar = (c) Class.forName(gVar.vwJ.vwR).newInstance();
            gVar.vwL = new a(gVar);
            gVar.mState = 32;
            return cVar.cHn();
        } catch (Exception e) {
            com.tencent.pb.common.c.c.x("service", new Object[]{e});
            return null;
        }
    }
}
