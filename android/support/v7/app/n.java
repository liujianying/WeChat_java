package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

final class n {
    static final a FF = new a();
    private final LocationManager FG;
    final Context mContext;

    private static class a {
        boolean FH;
        long FI;
        long FJ;
        long FK;
        long FL;
        long FM;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    n(Context context) {
        this.mContext = context;
        this.FG = (LocationManager) context.getSystemService("location");
    }

    final Location M(String str) {
        if (this.FG != null) {
            try {
                if (this.FG.isProviderEnabled(str)) {
                    return this.FG.getLastKnownLocation(str);
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    static boolean a(a aVar) {
        return aVar != null && aVar.FM > System.currentTimeMillis();
    }

    static void d(Location location) {
        long j;
        a aVar = FF;
        long currentTimeMillis = System.currentTimeMillis();
        if (m.FC == null) {
            m.FC = new m();
        }
        m mVar = m.FC;
        mVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = mVar.FD;
        mVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = mVar.state == 1;
        long j3 = mVar.FE;
        long j4 = mVar.FD;
        mVar.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = mVar.FE;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            if (currentTimeMillis > j4) {
                j = 0 + j5;
            } else if (currentTimeMillis > j3) {
                j = 0 + j4;
            } else {
                j = 0 + j3;
            }
            j += 60000;
        }
        aVar.FH = z;
        aVar.FI = j2;
        aVar.FJ = j3;
        aVar.FK = j4;
        aVar.FL = j5;
        aVar.FM = j;
    }
}
