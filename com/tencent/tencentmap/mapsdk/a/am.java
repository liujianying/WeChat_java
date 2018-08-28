package com.tencent.tencentmap.mapsdk.a;

import com.qq.sim.Millis100TimeProvider;
import com.tencent.tencentmap.mapsdk.a.at.a;
import com.tencent.tencentmap.mapsdk.a.at.b;
import java.net.InetAddress;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class am implements ah {
    private static final AtomicInteger p = new AtomicInteger(0);
    String a;
    String b;
    byte[] c;
    Map<String, String> d;
    Map<String, String> e;
    ao f;
    boolean g;
    boolean h;
    io i = null;
    int j;
    int k;
    aq l;
    public li m;
    int n = -1;
    int o = -1;

    public am(String str, String str2, byte[] bArr, int i, Map<String, String> map, Map<String, String> map2, ao aoVar, ar arVar, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = bArr;
        this.d = map;
        this.e = map2;
        this.f = aoVar;
        this.g = aoVar.g();
        this.f.b(str);
        this.f.a(str2);
        this.f.a(arVar);
        this.h = z;
        this.k = i;
        if (z) {
            this.i = new io((short) 1, (byte) 0, this.j, aoVar.h(), str, str2, bArr, i, map, map2);
        } else {
            this.i = new io((short) 1, (byte) 1, this.j, aoVar.h(), str, str2, bArr, i, map, map2);
        }
    }

    public io d() {
        return this.i;
    }

    public String a() {
        return this.a;
    }

    public ao e() {
        return this.f;
    }

    public boolean f() {
        return this.h;
    }

    public int b() {
        return this.n;
    }

    public boolean a(int i) {
        return (this.j & i) != 0;
    }

    public void b(int i) {
        this.j |= i;
        this.i.c = this.j;
    }

    public int c() {
        return this.o;
    }

    private static String k() {
        byte[] address;
        try {
            address = InetAddress.getByName(mj.a).getAddress();
        } catch (Throwable th) {
            address = new byte[]{Byte.MAX_VALUE, (byte) 0, (byte) 0, (byte) 1};
        }
        int currentTimeMillis = (int) (Millis100TimeProvider.INSTANCE.currentTimeMillis() & 4294967295L);
        int id = (int) (Thread.currentThread().getId() & 4294967295L);
        short andIncrement = (short) (p.getAndIncrement() & 65535);
        return String.format("%02x%02x%02x%02x%08x%08x%04x", new Object[]{Byte.valueOf(address[0]), Byte.valueOf(address[1]), Byte.valueOf(address[2]), Byte.valueOf(address[3]), Integer.valueOf(currentTimeMillis), Integer.valueOf(id), Short.valueOf(andIncrement)});
    }

    public void g() {
        String k;
        int i;
        int i2;
        int i3;
        a aVar = at.a.a().e;
        if (aVar.a) {
            if (aVar.e == -1) {
                aVar.a = false;
            }
            k = k();
            i = 0;
            i2 = 0;
            i3 = 0;
        } else {
            k = aVar.b;
            i3 = aVar.c;
            int i4 = aVar.d;
            i = aVar.e;
            i2 = i4;
        }
        if (k.length() != 0) {
            this.m = new li();
            this.m.a = k;
            this.m.g = i3;
            this.m.h = i2;
            this.m.i = i;
            this.m.b = null;
            this.m.c = this.a;
            this.m.d = this.b;
            this.m.e = "";
            this.m.f = null;
            aVar.b = k;
            aVar.c = i3;
            aVar.d = i2 + 1;
            aVar.e = i;
            this.e.put("STATUS_SAMPLE_KEY", k + "|" + i3 + "|" + i2);
            b(8);
        }
    }

    public void h() {
        if (this.e.containsKey("STATUS_GRID_KEY")) {
            String str = (String) this.e.get("STATUS_GRID_KEY");
            if (this.l.taf_Router() != null) {
                this.o = this.l.taf_Router().a(str);
            }
            if (this.o == -1) {
                b a = at.a.a();
                if (str.equals(a.c) && a.b != -1) {
                    this.o = a.b;
                }
            }
            if (this.o != -1) {
                this.e.put("STATUS_GRID_CODE", String.valueOf(this.o));
                b(2);
            }
        }
    }

    public void i() {
        this.n = at.a.a().a;
        if (this.n != -1) {
            b(1);
        }
    }

    public void j() {
        String str = at.a.a().d;
        if (str != null && str.trim().length() != 0) {
            this.e.put("STATUS_DYED_KEY", str);
        }
    }
}
