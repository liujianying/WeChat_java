package c.t.m.g;

import android.os.Process;
import java.util.Map;

final class cg implements Runnable {
    private /* synthetic */ String a;
    private /* synthetic */ int b;
    private /* synthetic */ int c;
    private /* synthetic */ String d;
    private /* synthetic */ Map e;
    private /* synthetic */ Map f;
    private /* synthetic */ boolean g;

    cg(String str, int i, int i2, String str2, Map map, Map map2, boolean z) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = str2;
        this.e = map;
        this.f = map2;
        this.g = z;
    }

    public final void run() {
        Process.setThreadPriority(10);
        ce.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, true);
    }
}
