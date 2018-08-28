package c.t.m.g;

import android.os.SystemClock;
import c.t.m.g.as.a;
import java.util.HashMap;
import java.util.Map;

public final class am extends as {
    public final boolean a(byte[] bArr, int i, boolean z, Object obj, a aVar) {
        Object obj2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.b = aVar;
        this.a = obj;
        Map hashMap = new HashMap();
        hashMap.put("B-Length", String.valueOf(i));
        String str = "HLReportCmd";
        if (z) {
            obj2 = "realtime_speed";
        } else {
            obj2 = "hllog";
        }
        hashMap.put(str, obj2);
        ag a = ag.a("https://up-hl.3g.qq.com/upreport", hashMap, bArr, 20000, ci.d(), null);
        a.o = "event";
        try {
            y$a.a.a.execute(new an(this, a, elapsedRealtime));
            return true;
        } catch (Throwable th) {
            this.b.a(false, this.a);
            return false;
        }
    }
}
