package c.t.m.g;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.map.geolocation.internal.TencentLogImpl;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

public final class dk {
    final LinkedBlockingQueue<a> a = new LinkedBlockingQueue(3);
    final ct b;
    long c;
    long d;
    long e;
    long f;
    volatile boolean g;
    boolean h;
    volatile Handler i;

    static class a {
        public static final a d = new a();
        final Object a;
        public String b;
        public long c;
        private final int e;
        private final byte[] f;
        private final String g;
        private int h;

        private a() {
            this.h = 1;
            this.e = 0;
            this.f = null;
            this.g = null;
            this.a = null;
        }

        a(int i, byte[] bArr, String str, Object obj) {
            this.h = 1;
            this.e = i;
            this.f = bArr;
            this.g = str;
            this.a = obj;
        }
    }

    dk(ct ctVar) {
        this.b = ctVar;
    }

    public final void a(String str, dr drVar, int i) {
        try {
            byte[] a = j.a(str.getBytes("GBK"));
            a aVar = new a(1, a, a(a, i), drVar);
            aVar.b = str;
            a(aVar);
        } catch (Throwable th) {
        }
    }

    final boolean a(a aVar) {
        boolean offer;
        SystemClock.elapsedRealtime();
        if (aVar.f != null) {
            offer = this.a.offer(aVar);
        } else {
            offer = false;
        }
        if (!offer) {
            this.a.clear();
            this.a.offer(aVar);
            String str = "Location";
            if (aVar.e == 2) {
                str = "List";
            } else if (aVar.e == 3) {
                str = "Wifis";
            } else if (aVar.e == 4) {
                str = "EventTrack";
            }
            new StringBuilder("post").append(str).append("Request: failed to add request,because the queue has full,so we delete the first");
        }
        return offer;
    }

    final void b(a aVar) {
        Object obj;
        aVar.h = aVar.h - 1;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).e == aVar.e) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (aVar.h > 0 && obj == null) {
            new StringBuilder("retryIfNeed: times=").append(aVar.h);
            this.a.offer(aVar);
        }
    }

    private static String a(byte[] bArr, int i) {
        if (!(TencentLogImpl.isDebugEnabled() || bArr == null)) {
            try {
                if (e.o(bArr, 1) >= 0) {
                    return dd.a(i, 1);
                }
            } catch (UnsatisfiedLinkError e) {
                return null;
            }
        }
        return dd.a(i, 0);
    }
}
