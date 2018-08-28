package c.t.m.g;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Arrays;
import java.util.List;

class df$a extends Handler {
    private /* synthetic */ df a;

    public df$a(df dfVar, Looper looper) {
        this.a = dfVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        int i = 0;
        if (message != null) {
            try {
                removeMessages(message.what);
                switch (message.what) {
                    case 1101:
                        Location c = df.c(this.a);
                        if (c != null && df.a(c) && !df.a(this.a, c)) {
                            df.b(this.a, c);
                            df.d(this.a);
                            df.a(this.a, df.e(this.a) | 2);
                            if (df.f(this.a) == -1 || df.f(this.a) == 0) {
                                df.a(this.a, true);
                                df.a(this.a, System.currentTimeMillis());
                                return;
                            }
                            return;
                        }
                        return;
                    case 1102:
                        boolean z;
                        df.d(this.a);
                        df.g(this.a);
                        if (!(df.h(this.a) == null || df.i(this.a) == null || df.i(this.a).size() <= 0)) {
                            try {
                                cz j = df.j(this.a);
                                List i2 = df.i(this.a);
                                if (i2.size() >= 5) {
                                    float[] fArr = new float[i2.size()];
                                    for (int i3 = 0; i3 < fArr.length; i3++) {
                                        Float f = (Float) i2.get(i3);
                                        fArr[i3] = f == null ? 0.0f : f.floatValue();
                                    }
                                    Arrays.sort(fArr);
                                    float[] fArr2 = new float[5];
                                    float f2 = 0.0f;
                                    while (i < 5) {
                                        fArr2[i] = fArr[(fArr.length - 1) - i];
                                        f2 += fArr2[i];
                                        i++;
                                    }
                                    f2 /= 5.0f;
                                    if (j.b < f2) {
                                        j.b = f2;
                                    }
                                    if (j.c > f2) {
                                        j.c = f2;
                                    }
                                    j.a = f2;
                                    if (j.a - f2 > 2.0f) {
                                        j.d = false;
                                    }
                                    if (f2 > (j.b + j.c) / 2.0f) {
                                        j.d = true;
                                    } else if (f2 < 22.0f) {
                                        j.d = false;
                                    }
                                }
                                z = j.d;
                            } catch (Throwable th) {
                            }
                            if (z) {
                                if (df.f(this.a) == -1 || df.f(this.a) == 0) {
                                    df.a(this.a, z);
                                }
                                df.a(this.a, System.currentTimeMillis());
                                return;
                            } else if (df.f(this.a) == -1 || (System.currentTimeMillis() - df.f(this.a) > 40000 && df.f(this.a) != 0)) {
                                df.a(this.a, z);
                                df.a(this.a, 0);
                                return;
                            } else {
                                return;
                            }
                        }
                        z = true;
                        if (z) {
                            if (df.f(this.a) == -1 || df.f(this.a) == 0) {
                                df.a(this.a, z);
                            }
                            df.a(this.a, System.currentTimeMillis());
                            return;
                        } else if (df.f(this.a) == -1 || (System.currentTimeMillis() - df.f(this.a) > 40000 && df.f(this.a) != 0)) {
                            df.a(this.a, z);
                            df.a(this.a, 0);
                            return;
                        } else {
                            return;
                        }
                    case 1103:
                        df.a(this.a, 4);
                        df.k(this.a);
                        return;
                    case 1104:
                        df.b(this.a, df.l(this.a));
                        df.a(this.a, 0);
                        df.m(this.a);
                        df.k(this.a);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th2) {
            }
        }
    }
}
