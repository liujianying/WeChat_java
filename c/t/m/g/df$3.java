package c.t.m.g;

import android.annotation.SuppressLint;

class df$3 implements Runnable {
    private /* synthetic */ df a;

    df$3(df dfVar) {
        this.a = dfVar;
    }

    @SuppressLint({"MissingPermission"})
    public final void run() {
        try {
            df.b(this.a).requestLocationUpdates("passive", 1000, 0.0f, df.a(this.a));
        } catch (Throwable th) {
            th.toString();
        }
    }
}
