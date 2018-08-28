package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class dc extends dn {
    private Context e = null;
    private Long[] f = null;
    private List<Long> g = null;
    private byte[] h = null;
    private boolean i = false;

    public dc(Context context) {
        super(context, 1, 4);
        this.e = context;
    }

    private synchronized boolean f() {
        return this.i;
    }

    public final synchronized void a(boolean z) {
        this.i = z;
    }

    public final synchronized cn a() {
        cn cnVar = null;
        synchronized (this) {
            dl d = dl.d();
            if (d == null || !d.e()) {
                ct.c(" imposiable! ua not ready!", new Object[0]);
            } else {
                df g = d.g();
                if (g == null) {
                    ct.c(" imposiable! ua S not ready!", new Object[0]);
                } else {
                    try {
                        Object obj;
                        if (f()) {
                            List a = cb.a(this.e);
                            if (a != null && a.size() > 0) {
                                Object obj2 = (byte[]) a.get(3);
                                this.d = String.valueOf(a.get(1));
                                ((Integer) a.get(4)).intValue();
                                obj = obj2;
                                if (obj == null) {
                                    cnVar = a(this.a, obj);
                                } else {
                                    List a2;
                                    int e = g.e();
                                    if (!e.l(this.e)) {
                                        e /= 2;
                                    }
                                    if (e >= 0) {
                                        a2 = e.a(this.e, e);
                                    } else {
                                        a2 = null;
                                    }
                                    if (a2 == null || a2.size() <= 0) {
                                        ct.h(" no up datas", new Object[0]);
                                    } else {
                                        cm a3;
                                        cn a4;
                                        ct.h(" size:%d", new Object[]{Integer.valueOf(a2.size())});
                                        try {
                                            a3 = a(a2);
                                        } catch (Exception e2) {
                                            b();
                                            a3 = null;
                                        }
                                        this.f = new Long[r6];
                                        for (int i = 0; i < this.f.length; i++) {
                                            this.f[i] = Long.valueOf(((di) a2.get(i)).a());
                                        }
                                        a2.clear();
                                        if (a3 != null) {
                                            obj2 = a3.a();
                                        } else {
                                            obj2 = obj;
                                        }
                                        this.h = new byte[obj2.length];
                                        System.arraycopy(obj2, 0, this.h, 0, obj2.length);
                                        this.d = e.b(this.c, 4);
                                        ct.a("comm rid:%s", new Object[]{this.d});
                                        try {
                                            a4 = a(this.a, obj2);
                                        } catch (Exception e3) {
                                            b();
                                            a4 = null;
                                        }
                                        cnVar = a4;
                                    }
                                }
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            List a22;
                            int e4 = g.e();
                            if (!e.l(this.e)) {
                                e4 /= 2;
                            }
                            if (e4 >= 0) {
                                a22 = e.a(this.e, e4);
                            } else {
                                a22 = null;
                            }
                            if (a22 == null || a22.size() <= 0) {
                                ct.h(" no up datas", new Object[0]);
                            } else {
                                cm a32;
                                cn a42;
                                ct.h(" size:%d", new Object[]{Integer.valueOf(a22.size())});
                                try {
                                    a32 = a(a22);
                                } catch (Exception e22) {
                                    b();
                                    a32 = null;
                                }
                                this.f = new Long[r6];
                                for (int i2 = 0; i2 < this.f.length; i2++) {
                                    this.f[i2] = Long.valueOf(((di) a22.get(i2)).a());
                                }
                                a22.clear();
                                if (a32 != null) {
                                    obj2 = a32.a();
                                } else {
                                    obj2 = obj;
                                }
                                this.h = new byte[obj2.length];
                                System.arraycopy(obj2, 0, this.h, 0, obj2.length);
                                this.d = e.b(this.c, 4);
                                ct.a("comm rid:%s", new Object[]{this.d});
                                try {
                                    a42 = a(this.a, obj2);
                                } catch (Exception e32) {
                                    b();
                                    a42 = null;
                                }
                                cnVar = a42;
                            }
                        } else {
                            cnVar = a(this.a, obj);
                        }
                    } catch (Throwable th) {
                        ct.a(th);
                        ct.d(" get req datas error: %s", new Object[]{th.toString()});
                    }
                }
            }
        }
        return cnVar;
    }

    private cm a(List<di> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        this.g = new ArrayList();
        int i = 0;
        while (i < size) {
            try {
                di diVar = (di) list.get(i);
                Map e = diVar.e();
                ct.a(" bean.getTP: " + diVar.b(), new Object[0]);
                if (e != null && "UA".equals(diVar.b())) {
                    ct.f(" Pack2Upload eventName:}%s ", new Object[]{diVar.d()});
                    cp a = e.a(diVar);
                    if (a != null) {
                        arrayList.add(a);
                    } else {
                        this.g.add(Long.valueOf(diVar.a()));
                    }
                }
                i++;
            } catch (Throwable th) {
                ct.a(th);
                ct.d(" CommonRecordUploadDatas.encode2MixPackage() error1", new Object[0]);
            }
        }
        if (this.g.size() > 0) {
            e.a(this.e, (Long[]) this.g.toArray(new Long[this.g.size()]));
        }
        ct.b(" up erList:" + arrayList.size(), new Object[0]);
        try {
            cq cqVar;
            if (arrayList.size() > 0) {
                cqVar = new cq();
                cqVar.a = arrayList;
            } else {
                cqVar = null;
            }
            if (cqVar == null) {
                return null;
            }
            Map hashMap = new HashMap();
            hashMap.put(Integer.valueOf(1), cqVar.a());
            cm cmVar = new cm();
            cmVar.a = hashMap;
            return cmVar;
        } catch (Throwable th2) {
            ct.a(th2);
            ct.d(" CommonRecordUploadDatas.encode2MixPackage() error2", new Object[0]);
            b();
            return null;
        }
    }

    public final synchronized void b() {
        ct.c(" encode failed, clear db data", new Object[0]);
        if (this.f != null && this.f.length > 0) {
            ct.b(" remove num :" + e.a(this.e, this.f), new Object[0]);
            this.f = null;
        }
    }

    public final synchronized void b(boolean z) {
        int i = 0;
        synchronized (this) {
            if (this.f != null) {
                i = this.f.length;
            }
            if (i > 0) {
                ct.b(" t_event remove num :" + e.a(this.e, this.f), new Object[0]);
            }
            this.f = null;
            if (z && f()) {
                cb.a(this.e, this.d);
            } else if (!z) {
                if (this.h != null) {
                    ct.a("comm rid2:%s", new Object[]{this.d});
                    cb.a(this.e, this.h, this.d, i);
                }
            }
            this.h = null;
        }
    }
}
