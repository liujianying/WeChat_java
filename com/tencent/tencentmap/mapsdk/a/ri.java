package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.tc.a;
import java.net.URL;

public abstract class ri implements rh {
    public final rf a(int i, int i2, int i3, a aVar, Object... objArr) {
        URL a = a(i, i2, i3, objArr);
        return a == null ? null : new rf(i, i2, i3, tn.a(a));
    }

    public abstract URL a(int i, int i2, int i3, Object... objArr);
}
