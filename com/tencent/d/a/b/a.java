package com.tencent.d.a.b;

import android.os.Build.VERSION;
import com.tencent.d.a.c.c;
import java.security.spec.AlgorithmParameterSpec;

public abstract class a {
    public abstract a M(String... strArr);

    public abstract a N(String... strArr);

    public abstract AlgorithmParameterSpec cFH();

    public abstract a cFI();

    public static a acE(String str) {
        if (!com.tencent.d.a.a.cFz()) {
            c.e("Soter.KeyGenParameterSpecCompatBuilder", "soter: not support soter. return dummy", new Object[0]);
            return new a();
        } else if (VERSION.SDK_INT >= 23) {
            return new b(str);
        } else {
            return new c(str);
        }
    }

    public static String[] O(String[] strArr) {
        return (strArr == null || strArr.length <= 0) ? strArr : (String[]) strArr.clone();
    }
}
