package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.content.e;
import android.support.v7.view.b;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;
import java.util.Calendar;

class h extends g {
    private static n Ep;
    private int Eq = -100;
    private boolean Er;
    boolean Es = true;

    class a extends b {
        a(Callback callback) {
            super(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (h.this.Es) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        final ActionMode a(ActionMode.Callback callback) {
            Object aVar = new android.support.v7.view.f.a(h.this.mContext, callback);
            b startSupportActionMode = h.this.startSupportActionMode(aVar);
            if (startSupportActionMode != null) {
                return aVar.b(startSupportActionMode);
            }
            return null;
        }
    }

    h(Context context, Window window, d dVar) {
        super(context, window, dVar);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && this.Eq == -100) {
            this.Eq = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    Callback a(Callback callback) {
        return new a(callback);
    }

    public final boolean df() {
        this.Er = true;
        int aG = aG(this.Eq == -100 ? e.Ed : this.Eq);
        if (aG == -1) {
            return false;
        }
        Resources resources = this.mContext.getResources();
        Configuration configuration = resources.getConfiguration();
        int i = configuration.uiMode & 48;
        aG = aG == 2 ? 32 : 16;
        if (i == aG) {
            return false;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.uiMode = aG | (configuration2.uiMode & -49);
        resources.updateConfiguration(configuration2, null);
        return true;
    }

    int aG(int i) {
        Location location = null;
        switch (i) {
            case -100:
                return -1;
            case 0:
                boolean z;
                if (Ep == null) {
                    Ep = new n(this.mContext.getApplicationContext());
                }
                n nVar = Ep;
                a aVar = n.FF;
                if (n.a(aVar)) {
                    z = aVar.FH;
                } else {
                    Location M;
                    if (e.f(nVar.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        M = nVar.M("network");
                    } else {
                        M = null;
                    }
                    if (e.f(nVar.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        location = nVar.M("gps");
                    }
                    if (location == null || M == null) {
                        if (location != null) {
                            M = location;
                        }
                    } else if (location.getTime() > M.getTime()) {
                        M = location;
                    }
                    if (M != null) {
                        n.d(M);
                        z = aVar.FH;
                    } else {
                        int i2 = Calendar.getInstance().get(11);
                        z = i2 < 6 || i2 >= 22;
                    }
                }
                return z ? 2 : 1;
            default:
                return i;
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.Eq != -100) {
            bundle.putInt("appcompat:local_night_mode", this.Eq);
        }
    }
}
