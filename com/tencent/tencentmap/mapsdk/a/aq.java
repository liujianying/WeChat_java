package com.tencent.tencentmap.mapsdk.a;

import com.qq.sim.Millis100TimeProvider;
import com.qq.tac2.jdt.share.AsyncClientRuntimeInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class aq implements ap {
    private static final AsyncClientRuntimeInfo q = new 1();
    public static final short version = (short) 1;
    private as a;
    al b;
    be c;
    hn d = null;
    au e;
    long f = 0;
    ConcurrentHashMap<String, AtomicInteger> g = new ConcurrentHashMap();
    private String h = "ServantProxy";
    private km i;
    private int j = 10000;
    private int k = 20;
    private int l = 2;
    private int m = 60000;
    private int n = 5;
    private float o = 0.5f;
    private int p = 30;

    void b() {
        this.f = Millis100TimeProvider.INSTANCE.currentTimeMillis();
    }

    boolean c() {
        return this.d != null && Millis100TimeProvider.INSTANCE.currentTimeMillis() - this.f > 2000;
    }

    public void taf_init(al alVar, be beVar, CopyOnWriteArrayList<Integer> copyOnWriteArrayList, hn hnVar) {
        this.b = alVar;
        this.e = new au(alVar.c());
        this.c = beVar;
        this.c.a(this);
        this.c.a(copyOnWriteArrayList);
        this.d = hnVar;
        av.a.a(this);
    }

    public int getID() {
        return this.b.hashCode();
    }

    public km getStatPrxPr() {
        return this.i;
    }

    public void setStatPrxPr(km kmVar) {
        this.i = kmVar;
    }

    public void taf_pointStatInterv(List<Integer> list) {
        this.c.a(list);
    }

    public aq taf_hash(int i) {
        if (i < 0) {
            i = -i;
        }
        at.a.a().a = i;
        return this;
    }

    public int taf_hash() {
        return at.a.a().a;
    }

    public void taf_del_hash() {
        at.a.a().a = -1;
    }

    public void taf_tAdapterSelector(aw awVar) {
        this.c.a(awVar);
    }

    public aw taf_tAdapterSelector() {
        return this.c.d();
    }

    public void taf_referNodeInterv(int i) {
    }

    public long taf_referNodeInterv() {
        return (long) av.a();
    }

    public void taf_sync_timeout(int i) {
        this.b.d = i;
    }

    public int taf_sync_timeout() {
        return this.b.d;
    }

    public void taf_async_timeout(int i) {
        this.b.c = i;
    }

    public int taf_async_timeout() {
        return this.b.c;
    }

    public void taf_refreshEndPInterval(int i) {
        this.b.b = i;
    }

    public int taf_refreshEndPInterval() {
        return this.b.b;
    }

    public int taf_ServiceConnNum() {
        return this.b.g;
    }

    public void taf_ServiceConnNum(int i) {
        this.b.g = i;
        b(i);
    }

    public void taf_set_router(as asVar) {
        this.a = asVar;
    }

    public void taf_del_router() {
        this.a = null;
    }

    public as taf_Router() {
        return this.a;
    }

    public int taf_readBufferSize() {
        return this.b.i;
    }

    public void taf_readBufferSize(int i) {
        if (i > 0) {
            this.b.i = i;
            return;
        }
        throw new IllegalArgumentException("readBufferSize must Greater than zero");
    }

    public int taf_writeBufferSize() {
        return this.b.j;
    }

    public void taf_writeBufferSize(int i) {
        if (i > 0) {
            this.b.j = i;
            return;
        }
        throw new IllegalArgumentException("writeBuffer must Greater than zero");
    }

    public byte[] taf_invoke(String str, byte[] bArr, Map<String, String> map) {
        return a(null, str, bArr, map, new HashMap(), true, false);
    }

    public byte[] taf_invoke(String str, byte[] bArr, Map<String, String> map, Map<String, String> map2) {
        return a(null, str, bArr, map, map2, true, false);
    }

    protected final void a(ar arVar, String str, byte[] bArr, Map<String, String> map, Map<String, String> map2) {
        if (arVar == null) {
            a(arVar, str, bArr, map, map2, false, true);
        } else {
            a(arVar, str, bArr, map, map2, true, true);
        }
    }

    public ConcurrentLinkedQueue<li> getStatSampleMsg() {
        return this.c.o;
    }

    private boolean a(String str) {
        if (!this.g.containsKey(str)) {
            this.g.putIfAbsent(str, new AtomicInteger());
        }
        int incrementAndGet = ((AtomicInteger) this.g.get(str)).incrementAndGet();
        if (incrementAndGet == 1 || (incrementAndGet % this.j == 0 && incrementAndGet < this.j * this.k)) {
            return true;
        }
        return false;
    }

    private byte[] a(ar arVar, String str, byte[] bArr, Map<String, String> map, Map<String, String> map2, boolean z, boolean z2) {
        ao a;
        if (arVar != null) {
            arVar._data = at.a.a();
        }
        if (z2) {
            a = this.c.a((long) taf_async_timeout(), z2);
        } else {
            a = this.c.a((long) taf_sync_timeout(), z2);
        }
        return a(new am(this.b.c(), str, bArr, this.b.a(), map, map2, a, arVar, z), arVar, str, bArr, map, map2, z, z2);
    }

    private byte[] a(am amVar, mi miVar, String str, byte[] bArr, Map<String, String> map, Map<String, String> map2, boolean z, boolean z2) {
        amVar.l = this;
        if (a(str)) {
            amVar.g();
        }
        amVar.h();
        amVar.i();
        amVar.j();
        if (z2) {
            this.b.f.a(amVar);
            return new byte[0];
        }
        a(amVar);
        if (!z) {
            return new byte[0];
        }
        try {
            Object b = amVar.e().b();
            if (!z) {
                return new byte[0];
            }
            jp jpVar = (jp) b;
            if (jpVar.e == 0) {
                return jpVar.f;
            }
            throw new bm(this.b.c() + "#" + str, bj.a(jpVar.e));
        } catch (InterruptedException e) {
            throw new bm(" thread is InterruptedExceptioned ");
        } catch (CancellationException e2) {
            throw new bm(" thread is CancellationException ");
        } catch (bj e3) {
            ax.a("sendMsg throw TafException " + e3);
            throw new bm(this.b.c() + "#" + str, e3);
        } catch (Exception e4) {
            ax.a("sendMsg throw Exception " + e4);
            throw new bm(this.b.c() + " ", e4);
        }
    }

    void a(am amVar) {
        Throwable e;
        int i = 0;
        this.c.a();
        long currentTimeMillis = Millis100TimeProvider.INSTANCE.currentTimeMillis() - amVar.e().i();
        az a;
        if (currentTimeMillis > amVar.e().e) {
            ak.a().a(this.c.c()).a(bw.a(this.c.e(), amVar.d().e, amVar.d().f, "", "0.0.0.0", 0, 0, this.b.f(), this.b.g(), this.b.h(), ""), (int) currentTimeMillis);
            ax.a("waitSend msg timeout " + amVar.e().h() + " inQueue time:" + currentTimeMillis);
            amVar.e().a(new bi("asyncMsg " + amVar.e().h() + " waiteResp timeout "));
            if (amVar.e().g()) {
                a = az.a(-7, amVar.e().h());
                a.a(amVar.e());
                this.b.e().a(a);
            }
        } else {
            try {
                this.c.a(amVar);
            } catch (bn e2) {
                av.a.b(this);
                this.c.b(amVar);
            } catch (bj e3) {
                ax.a("send msg TafException " + e3, e3);
                amVar.e().a(e3);
                if (amVar.e().g()) {
                    a = az.a(-8, amVar.e().h());
                    a.a(amVar.e());
                    this.b.e().a(a);
                }
            } catch (Throwable e4) {
                amVar.e().a(new bj(e4.toString(), e4));
                ax.a("send msg error " + e4, e4);
                if (amVar.e().g()) {
                    a = az.a(-8, amVar.e().h());
                    a.a(amVar.e());
                    this.b.e().a(a);
                }
            } catch (Throwable th) {
                e4 = th;
                i = 1;
            }
        }
        taf_del_hash();
        return;
        if (i != 0 && amVar.e().g()) {
            az a2 = az.a(-8, amVar.e().h());
            a2.a(amVar.e());
            this.b.e().a(a2);
        }
        throw e4;
    }

    public am createPingPackage(ar arVar) {
        return new am(this.b.c(), "taf_ping", new byte[0], this.b.a(), new HashMap(), new HashMap(), this.c.a((long) taf_async_timeout(), true), arVar, true);
    }

    @Deprecated
    protected void b(int i) {
        this.c.a(i);
    }

    public List<bb> getAliveServices() {
        return this.e.a();
    }

    public List<bb> getInAliveServices() {
        return this.e.b();
    }

    public int getSampleRate() {
        return this.j;
    }

    public void setSampleRate(int i) {
        this.j = i;
    }

    public int getMaxSampleCount() {
        return this.k;
    }

    public void setMaxSampleCount(int i) {
        this.k = i;
    }

    public void taf_check_timeout(int i, int i2, int i3, float f, int i4) {
        this.l = i;
        this.m = i2;
        this.n = i3;
        this.o = f;
        this.p = i4;
    }

    public void taf_frequence_fail_invoke(int i) {
        this.n = i;
    }

    public int taf_frequence_fail_invoke() {
        return this.n;
    }

    public void taf_min_timeout_invoke(int i) {
        this.l = i;
    }

    public int taf_min_timeout_invoke() {
        return this.l;
    }

    public void taf_timeout_interval(int i) {
        this.m = i;
    }

    public int taf_timeout_interval() {
        return this.m;
    }

    public void taf_timeout_radio(float f) {
        this.o = f;
    }

    public float taf_timeout_radio() {
        return this.o;
    }

    public void taf_try_time_interval(int i) {
        this.p = i;
    }

    public int taf_try_time_interval() {
        return this.p;
    }

    public String taf_proxyName() {
        return this.h;
    }

    public void taf_proxyName(String str) {
        this.h = str;
    }

    public long taf_idleStatusInteval() {
        return this.b.l;
    }

    public void taf_idleStatusInteval(long j) {
        if (j > 30000) {
            this.b.l = j;
            return;
        }
        throw new IllegalArgumentException("idleStatusInteval must Greater than 30000");
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public boolean equals(Object obj) {
        return (this == null && obj == null) || (obj != null && (obj instanceof aq) && ((aq) obj).b.equals(this.b));
    }
}
