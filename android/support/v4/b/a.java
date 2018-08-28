package android.support.v4.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

public final class a {
    static final b rn;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            rn = new e();
        } else if (i >= 18) {
            rn = new d();
        } else if (i >= 12) {
            rn = new c();
        } else {
            rn = new a();
        }
    }

    public static int e(Bitmap bitmap) {
        return rn.e(bitmap);
    }
}
