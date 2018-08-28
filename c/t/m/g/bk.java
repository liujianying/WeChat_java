package c.t.m.g;

import android.os.Build;
import android.os.Build.VERSION;

public final class bk {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    public bk() {
        try {
            this.a = Build.MODEL;
            this.b = VERSION.RELEASE;
            this.c = ci.a();
            this.d = ci.b();
            ci.e();
            this.e = ci.f();
        } catch (Throwable th) {
        }
    }
}
