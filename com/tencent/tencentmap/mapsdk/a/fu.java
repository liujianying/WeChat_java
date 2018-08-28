package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.eq.a;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public final class fu {
    private static fu a = new fu();
    private int b = 20000;
    private Socket c;
    private int d = -1;
    private fv e;
    private ep f;
    private OutputStream g;
    private InputStream h;
    private int i = -1;
    private int j = -1;
    private long k = -1;
    private int l = -1;
    private int m = -1;

    public static synchronized fu a() {
        fu fuVar;
        synchronized (fu.class) {
            fuVar = a;
        }
        return fuVar;
    }

    private synchronized void a(int i) {
        a(i, null);
    }

    private synchronized void a(int i, String str) {
        if (!(i == this.d || this.e == null)) {
            this.e.b = i;
            if (str != null) {
                this.e.c = str;
            }
        }
    }

    private synchronized boolean a(fv fvVar) {
        boolean z;
        int i = 0;
        z = false;
        while (!z) {
            if (fvVar != null) {
                if (System.currentTimeMillis() - fvVar.i < ((long) fvVar.j)) {
                    Object obj = null;
                    if (obj != null || i >= 5) {
                        break;
                    }
                    i++;
                    if (c()) {
                        e();
                    } else {
                        try {
                            fx.b("WupTaskController", "doSendData try send task:" + fvVar.j() + ",sk:" + this.c);
                            byte[] k = fvVar.k();
                            this.g.write(k, 0, k.length);
                            this.g.flush();
                            this.k = System.currentTimeMillis();
                            fx.a("WupTaskController", "doSendData: sent data len:" + k.length);
                            z = true;
                        } catch (Exception e) {
                            fvVar.b = -5;
                            fvVar.c = fz.a(e);
                            if (!z) {
                                try {
                                    a(fvVar.b);
                                    this.g.close();
                                    this.c.close();
                                    e();
                                } catch (Exception e2) {
                                }
                            }
                        } catch (Throwable th) {
                            if (!z) {
                                try {
                                    a(fvVar.b);
                                    this.g.close();
                                    this.c.close();
                                    e();
                                } catch (Exception e3) {
                                }
                            }
                        }
                    }
                }
            }
            int obj2 = 1;
            i++;
            if (c()) {
                e();
            } else {
                try {
                    fx.b("WupTaskController", "doSendData try send task:" + fvVar.j() + ",sk:" + this.c);
                    byte[] k2 = fvVar.k();
                    this.g.write(k2, 0, k2.length);
                    this.g.flush();
                    this.k = System.currentTimeMillis();
                    fx.a("WupTaskController", "doSendData: sent data len:" + k2.length);
                    z = true;
                } catch (Exception e4) {
                    fvVar.b = -5;
                    fvVar.c = fz.a(e4);
                    if (!z) {
                        try {
                            a(fvVar.b);
                            this.g.close();
                            this.c.close();
                            e();
                        } catch (Exception e22) {
                        }
                    }
                } catch (Throwable th2) {
                    if (!z) {
                        try {
                            a(fvVar.b);
                            this.g.close();
                            this.c.close();
                            e();
                        } catch (Exception e32) {
                        }
                    }
                }
            }
        }
        return z;
    }

    private synchronized void b() {
        int i = 0;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                int read;
                fx.b("WupTaskController", "doReadData: try read data...sk:" + this.c);
                Object obj = new byte[4];
                while (i < 4) {
                    fx.a("WupTaskController", "try read packet size: 4 bytes");
                    read = this.h.read(obj, i, 4 - i);
                    if (read <= 0) {
                        if (read == -1) {
                            break;
                        }
                    } else {
                        this.l = (int) (System.currentTimeMillis() - this.k);
                        i += read;
                        if (i == 4) {
                            break;
                        }
                    }
                }
                if (i == 4) {
                    read = fz.a(obj, 0);
                    if (read <= 4 || read > 524288) {
                        a(-6, "packSizeFail:" + read);
                    } else {
                        Object obj2 = new byte[read];
                        System.arraycopy(obj, 0, obj2, 0, 4);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        while (i < read) {
                            int i2 = read - i;
                            fx.a("WupTaskController", "try read:" + i2);
                            i2 = this.h.read(obj2, i, i2);
                            fx.a("WupTaskController", "read ret:" + i2);
                            if (i2 > 0) {
                                i += i2;
                            } else if (i2 == -1) {
                                break;
                            }
                        }
                        if (i != read) {
                            fx.c("WupTaskController", "read fail. readLen:" + i + ",packSize:" + read);
                            a(-6, "readLen != packSize,rspBuff:" + fz.a(obj2));
                        } else {
                            this.m = (int) (System.currentTimeMillis() - currentTimeMillis2);
                            fx.b("WupTaskController", "doSendReceive: read finish,readLen=" + i);
                            gd gdVar = new gd();
                            try {
                                gdVar.a(obj2);
                                if (this.e != null) {
                                    this.e.a = gdVar;
                                    this.e.b = 0;
                                    this.m = (int) (System.currentTimeMillis() - currentTimeMillis);
                                    this.e.f = this.l;
                                    this.e.d = this.j;
                                    this.e.g = this.m;
                                }
                            } catch (Exception e) {
                                a(-8, fz.a(e));
                            }
                        }
                    }
                } else {
                    a(-6, "readLen fail:" + i);
                }
            } catch (Exception e2) {
                a(-7, fz.a(e2));
            }
        }
        return;
    }

    private synchronized boolean c() {
        boolean z;
        z = false;
        if (!(this.c == null || !this.c.isConnected() || this.c.isClosed() || this.g == null)) {
            z = true;
        }
        return z;
    }

    private synchronized void d() {
        if (this.h != null) {
            try {
                this.h.close();
                this.h = null;
            } catch (Exception e) {
                this.c = null;
            } catch (Exception e2) {
                this.g = null;
            } catch (Exception e3) {
                this.h = null;
            } catch (Throwable th) {
                this.h = null;
            }
        }
        if (this.g != null) {
            this.g.close();
            this.g = null;
        }
        if (this.c != null) {
            this.c.close();
            this.c = null;
        }
        fr.a();
        return;
    }

    private synchronized void e() {
        boolean z = true;
        synchronized (this) {
            fx.c("WupTaskController", "try reConnect...");
            ft ftVar = new ft();
            if (this.e.j > 0) {
                ftVar.a(this.e.j);
            } else {
                ftVar.a(dx.a().b.a);
            }
            ftVar.b(dx.a().b.d);
            String str = "dispatcher.3g.qq.com";
            int[] iArr = dy.a;
            ftVar.a(str);
            ftVar.a(iArr);
            a a = er.a().a(str);
            if (a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a.c());
                ftVar.a(arrayList);
            }
            long j = dx.a().a.b;
            if (j > 0) {
                if (j + ((long) ((dx.a().b.e * 60) * 1000)) >= System.currentTimeMillis()) {
                    z = false;
                }
            }
            ftVar.a(dx.a().a.c(), z);
            this.j = 0;
            ftVar.a();
            this.i = ftVar.e();
            this.j = ftVar.f();
            this.e.e = this.i;
            this.e.d = this.j;
            if (ftVar.b() == 0) {
                this.c = ftVar.c();
                this.f = ftVar.g();
                this.e.h = this.f;
                fx.c("WupTaskController", "Connect ok. sk:" + this.c + ",accessIP:" + this.f);
                if (this.c != null && this.c.isConnected() && !this.c.isClosed()) {
                    try {
                        this.c.setSoTimeout(this.b);
                        this.c.setReceiveBufferSize(524288);
                        this.g = this.c.getOutputStream();
                        this.h = this.c.getInputStream();
                        fx.b("WupTaskController", "reConnect socket succ. sk:" + this.c);
                    } catch (Throwable e) {
                        fx.a("WupTaskController", "reConnect socket fail. sk:" + this.c, e);
                        a(-3, fz.a(e));
                        d();
                    }
                } else if (this.c == null) {
                    a(-3, "sk is null");
                } else {
                    a(-3, "connect:" + this.c.isConnected() + "close:" + this.c.isClosed());
                }
            } else if (!fw.e()) {
                a(-4);
            } else if (ee.a("info.3g.qq.com", 80, 5000)) {
                a(-3, "ret:" + ftVar.b() + ",failInfo:" + ftVar.d());
            } else {
                a(-16);
            }
        }
        return;
    }

    public final void a(fv fvVar, int i) {
        if (fvVar != null) {
            try {
                this.e = fvVar;
                this.e.i = System.currentTimeMillis();
                this.e.j = i * 1000;
                e();
                if (c()) {
                    a(fvVar);
                    b();
                    d();
                }
            } catch (Exception e) {
            }
        }
    }
}
