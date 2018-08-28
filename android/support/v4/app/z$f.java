package android.support.v4.app;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.z.g;

public final class z$f implements g {
    private int pN = 0;
    public a pS;
    private Bitmap px;

    public final z$d a(z$d z_d) {
        if (VERSION.SDK_INT >= 21) {
            Bundle bundle = new Bundle();
            if (this.px != null) {
                bundle.putParcelable("large_icon", this.px);
            }
            if (this.pN != 0) {
                bundle.putInt("app_color", this.pN);
            }
            if (this.pS != null) {
                bundle.putBundle("car_conversation", z.by().a(this.pS));
            }
            if (z_d.mExtras == null) {
                z_d.mExtras = new Bundle();
            }
            z_d.mExtras.putBundle("android.car.EXTENSIONS", bundle);
        }
        return z_d;
    }
}
