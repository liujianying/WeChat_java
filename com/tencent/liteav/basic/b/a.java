package com.tencent.liteav.basic.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.util.LinkedList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class a {
    private long A;
    private long B;
    private long C;
    private long D;
    private long E;
    private long F;
    private ReadWriteLock G;
    private b a;
    private LinkedList<b> b;
    private LinkedList<b> c;
    private long d;
    private long e;
    private volatile boolean f;
    private volatile float g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private boolean p;
    private HandlerThread q;
    private Handler r;
    private boolean s;
    private long t;
    private long u;
    private volatile long v;
    private volatile long w;
    private int x;
    private int y;
    private long z;

    static /* synthetic */ long i(a aVar) {
        long j = aVar.A + 1;
        aVar.A = j;
        return j;
    }

    static /* synthetic */ long k(a aVar) {
        long j = aVar.E + 1;
        aVar.E = j;
        return j;
    }

    public a() {
        this.a = null;
        this.b = new LinkedList();
        this.c = new LinkedList();
        this.d = 0;
        this.e = 15;
        this.f = false;
        this.g = 1.0f;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = false;
        this.q = null;
        this.r = null;
        this.s = false;
        this.t = 20;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = new ReentrantReadWriteLock();
        this.q = new HandlerThread("VideoJitterBufferHandler");
        this.q.start();
        this.G.writeLock().lock();
        this.r = new Handler(this.q.getLooper());
        this.G.writeLock().unlock();
    }

    public void a(b bVar) {
        this.G.readLock().lock();
        if (this.r != null) {
            this.r.post(new 1(this, bVar));
        }
        this.G.readLock().unlock();
    }

    public void a() {
        this.G.readLock().lock();
        if (this.r != null) {
            this.r.post(new 2(this));
        }
        this.G.readLock().unlock();
        m();
    }

    public void b() {
        this.G.writeLock().lock();
        if (this.r != null) {
            this.r.post(new 3(this));
        }
        this.r = null;
        this.G.writeLock().unlock();
    }

    private void l() {
        this.b.clear();
        this.d = 0;
        this.c.clear();
        this.e = 15;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.v = 0;
        this.w = 0;
        this.y = 0;
        this.x = 0;
        this.f = false;
        this.g = 1.0f;
        this.k = 0;
        this.o = 0;
        this.l = 0;
        this.m = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.p = false;
    }

    public void a(boolean z) {
        this.p = z;
    }

    private void m() {
        this.G.readLock().lock();
        if (this.r != null) {
            this.r.postDelayed(new 4(this), this.t);
        }
        this.G.readLock().unlock();
    }

    public void a(b bVar) {
        if (bVar != null) {
            if (bVar.g > this.w || bVar.g + 500 < this.w) {
                this.w = bVar.g;
            }
            if (this.v > this.w) {
                this.v = this.w;
            }
            if (bVar.b == 0) {
                this.x = this.y;
                this.y = 1;
            } else if (bVar.b == 2 || bVar.b == 1) {
                this.y++;
            }
            this.G.readLock().lock();
            if (this.r != null) {
                this.r.post(new 5(this, bVar));
            }
            this.G.readLock().unlock();
        }
    }

    private b n() {
        if (this.b == null || this.b.isEmpty()) {
            return null;
        }
        Object obj;
        b bVar;
        if (this.v > this.w) {
            this.v = this.w;
        }
        long timeTick = TXCTimeUtil.getTimeTick();
        if (this.k == 0) {
            obj = 1;
        } else {
            long b;
            bVar = (b) this.b.getFirst();
            if (bVar.h > this.k) {
                b = b(bVar.h - this.k);
            } else {
                long b2 = b(0);
                TXCLog.w("TXCVideoJitterBuffer", "videojitter pull nal with invalid ts, current dts [" + bVar.h + "] < last dts[ " + this.k + "]!!! decInterval is " + b2);
                b = b2;
            }
            if (this.o + b <= this.u + timeTick) {
                this.u = (this.u + timeTick) - (this.o + b);
                if (this.u > b) {
                    this.u = b;
                }
                int obj2 = 1;
            } else {
                obj2 = null;
            }
        }
        if (obj2 == null) {
            return null;
        }
        bVar = o();
        f(bVar.h);
        this.o = timeTick;
        return bVar;
    }

    private long b(long j) {
        long j2 = 500;
        if (j > 500) {
            j = 500;
        }
        if (j > 0) {
            long n;
            float d;
            if (this.a != null) {
                n = this.a.n();
            } else {
                n = 0;
            }
            if (n > 0) {
                j2 = 50;
            } else if (this.f) {
                j2 = 200;
            }
            j2 = a(j, j2);
            if (this.f) {
                d = d(j2);
            } else {
                d = c(j2);
            }
            return (long) (((float) j) / d);
        } else if (this.e > 0) {
            return 1000 / this.e;
        } else {
            return 0;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long a(long r6, long r8) {
        /*
        r5 = this;
        r0 = r5.e;
        r2 = 0;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0017;
    L_0x0008:
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r5.e;
        r0 = r0 / r2;
        r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r2 >= 0) goto L_0x0017;
    L_0x0011:
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x0016;
    L_0x0015:
        r8 = r0;
    L_0x0016:
        return r8;
    L_0x0017:
        r0 = r6;
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.b.a.a(long, long):long");
    }

    private float c(long j) {
        long j2 = 0;
        int i = 0;
        if (this.a != null) {
            i = this.a.o();
        }
        if (i > 24) {
            TXCLog.e("TXCVideoJitterBuffer", "videojitter pull nal with speed : 0.1");
            return 0.1f;
        }
        long n;
        if (this.a != null) {
            n = this.a.n();
        } else {
            n = 0;
        }
        if (n <= 0) {
            float f;
            if (this.w > this.v) {
                n = this.w - this.v;
            } else {
                n = 0;
            }
            long j3 = (long) (this.g * 1000.0f);
            if (this.a != null) {
                j2 = this.n * ((long) this.a.o());
            }
            if (j2 > j3) {
                j3 = j2;
            }
            if (n > j3 + j) {
                f = 1.1f;
            } else {
                f = 1.0f;
            }
            if (n <= j3) {
                return 1.0f;
            }
            return f;
        } else if (n >= this.v + j) {
            if (n >= (this.v + j) + 200) {
                return 2.2f;
            }
            return 1.2f;
        } else if (this.v < n + j) {
            return 1.0f;
        } else {
            if (this.v >= (n + j) + 200) {
                return 0.5f;
            }
            return 0.9f;
        }
    }

    private float d(long j) {
        long j2 = 0;
        int i = 0;
        if (this.a != null) {
            i = this.a.o();
        }
        if (i > 24) {
            TXCLog.e("TXCVideoJitterBuffer", "videojitter pull nal with speed : 0.1");
            return 0.1f;
        }
        long n;
        if (this.a != null) {
            n = this.a.n();
        } else {
            n = 0;
        }
        if (n <= 0) {
            float f;
            if (this.w > this.v) {
                n = this.w - this.v;
            } else {
                n = 0;
            }
            long j3 = (long) (this.g * 1000.0f);
            if (this.a != null) {
                j2 = this.n * ((long) this.a.o());
            }
            if (j2 > j3) {
                j3 = j2;
            }
            if (n > j3 + j) {
                f = 1.2f;
            } else {
                f = 1.0f;
            }
            if (n <= j3) {
                return 1.0f;
            }
            return f;
        } else if (n >= this.v + j) {
            if (n >= (this.v + j) + 200) {
                return 2.2f;
            }
            return 1.5f;
        } else if (this.v < n + j) {
            return 1.0f;
        } else {
            if (this.v >= (n + j) + 200) {
                return 0.5f;
            }
            return 0.7f;
        }
    }

    void c() {
        int i = 0;
        if (this.b.size() != 0) {
            this.b.getFirst();
            this.b.getLast();
            int o;
            if (this.a != null) {
                o = this.a.o();
            } else {
                o = 0;
            }
            if (!this.b.isEmpty() && o >= 24) {
                int i2;
                int i3 = 0;
                for (i2 = 0; i2 < this.b.size(); i2++) {
                    if (((b) this.b.get(i2)).b == 0) {
                        i3 = i2;
                    }
                }
                while (true) {
                    i2 = i;
                    if (!this.b.isEmpty() && i2 < i3) {
                        this.k = ((b) this.b.getFirst()).h;
                        while (!this.c.isEmpty()) {
                            b bVar = (b) this.c.getFirst();
                            if (bVar.g > ((b) this.b.getFirst()).h) {
                                break;
                            }
                            this.a.c(bVar);
                            this.c.removeFirst();
                        }
                        this.b.removeFirst();
                        i = i2 + 1;
                    } else if (i2 > 0) {
                        TXCLog.w("TXCVideoJitterBuffer", "videojitter cache too maney ， so drop " + i2 + " frames");
                    }
                }
                if (i2 > 0) {
                    TXCLog.w("TXCVideoJitterBuffer", "videojitter cache too maney ， so drop " + i2 + " frames");
                }
            }
        }
    }

    private b o() {
        b bVar = null;
        if (!this.b.isEmpty()) {
            bVar = (b) this.b.getFirst();
            this.b.removeFirst();
            this.d = (long) this.b.size();
            if (this.a != null) {
                this.d += (long) this.a.o();
            }
        }
        return bVar;
    }

    private void e(long j) {
        if (this.j != 0) {
            if (this.i >= 5) {
                this.e = this.h / this.i;
                if (this.e > 200) {
                    this.e = 200;
                } else if (this.e < 1) {
                    this.e = 1;
                }
                if (this.e >= 30 && this.t != 5) {
                    this.t = 5;
                }
                this.h = 0;
                this.i = 0;
            } else {
                long j2 = j - this.j;
                if (j2 > 0) {
                    this.h = (1000 / j2) + this.h;
                    this.i++;
                }
            }
        }
        this.j = j;
    }

    private void f(long j) {
        if (this.k != 0) {
            long j2;
            if (j > this.k) {
                j2 = j - this.k;
                if (j2 > 500) {
                    j2 = 500;
                }
            } else if (this.e > 0) {
                j2 = 1000 / this.e;
            } else {
                j2 = 0;
            }
            this.l = j2 + this.l;
            this.m++;
            if (this.m >= 5) {
                this.n = this.l / this.m;
                if (this.n > 500) {
                    this.n = 500;
                } else if (this.n < 5) {
                    this.n = 5;
                }
                this.l = 0;
                this.m = 0;
            }
        }
        this.k = j;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public void a(float f) {
        this.g = f;
    }

    public void a(long j) {
        this.v = j;
        if (this.v > this.w) {
            this.v = this.w;
        }
    }

    public long d() {
        return this.w - this.v;
    }

    public long e() {
        return this.d;
    }

    public long f() {
        return this.v;
    }

    public long g() {
        return this.w;
    }

    public int h() {
        return this.x;
    }

    public long i() {
        return this.C;
    }

    public long j() {
        return this.F;
    }

    public long k() {
        long j;
        if (this.A != 0) {
            j = this.z / this.A;
        } else {
            j = 0;
        }
        this.A = 0;
        this.z = 0;
        return j;
    }

    protected void finalize() {
        super.finalize();
        try {
            b();
        } catch (Exception e) {
        }
    }
}
