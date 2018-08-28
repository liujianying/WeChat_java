package com.tencent.mm.modelgeo;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements a {
    public static c dMm;
    List<WeakReference<a>> avD = new ArrayList();
    double bhF = 0.0d;
    public boolean dSc = false;
    g dSd;
    long dSe = 0;
    public long dSf = 0;
    boolean dSg = false;
    public boolean dSh = false;
    double dSi = 23.0d;
    double dSj = 100.0d;
    int dSk = 0;
    double dSl = 0.0d;
    double dSm = 0.0d;
    String dSn;
    String dSo;
    int dSp;
    private boolean dSq = false;
    private boolean dSr = false;
    private e dSs = new 1(this);
    private f dSt = new 2(this);
    private ag dvh = new ag(Looper.getMainLooper());
    private Context mContext;

    static /* synthetic */ void a(c cVar, boolean z, double d, double d2, double d3, boolean z2) {
        if (!z || !cVar.dSq) {
            if (z || !cVar.dSr) {
                int i = 10;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - cVar.dSe <= 500) {
                    i = 10;
                } else if (currentTimeMillis - cVar.dSe <= 1000) {
                    i = 12;
                } else if (currentTimeMillis - cVar.dSe <= 2000) {
                    i = 14;
                } else if (currentTimeMillis - cVar.dSe <= 4000) {
                    i = 16;
                } else if (currentTimeMillis - cVar.dSe <= 8000) {
                    i = 18;
                }
                if (!z) {
                    i++;
                }
                h.mEJ.a(584, (long) i, 1, true);
                if (z) {
                    h.mEJ.a(584, 30, 1, true);
                    h.mEJ.a(584, 31, currentTimeMillis - cVar.dSe, true);
                    cVar.dSq = true;
                    h hVar = h.mEJ;
                    Object[] objArr = new Object[5];
                    objArr[0] = Integer.valueOf((int) (1000000.0d * d));
                    objArr[1] = Integer.valueOf((int) (1000000.0d * d2));
                    objArr[2] = Integer.valueOf((int) (1000000.0d * d3));
                    objArr[3] = Integer.valueOf((int) d3);
                    objArr[4] = Integer.valueOf(z2 ? 1 : 2);
                    hVar.h(15391, objArr);
                    return;
                }
                cVar.dSr = true;
            }
        }
    }

    static /* synthetic */ void a(c cVar, boolean z, double d, double d2, int i, double d3, double d4, double d5, Bundle bundle) {
        List<a> linkedList = new LinkedList();
        for (WeakReference weakReference : cVar.avD) {
            if (!(weakReference == null || weakReference.get() == null)) {
                linkedList.add((a) weakReference.get());
            }
        }
        if (linkedList.isEmpty()) {
            x.w("MicroMsg.LocationGeo", "no location listener weakrefers, may have leak, stop location");
            cVar.avD.clear();
            g.OF();
        }
        for (a aVar : linkedList) {
            if (af.ewL && b.chp()) {
                boolean z2 = z;
                aVar.a(z2, (float) af.lng, (float) af.lat, i, (double) ((float) d3), d4, d5);
            } else {
                aVar.a(z, (float) d2, (float) d, i, (double) ((float) d3), d4, d5);
            }
            if (aVar instanceof a.b) {
                ((a.b) aVar).a(z, (float) d2, (float) d, i, (double) ((float) d3), d4, bundle);
            }
        }
    }

    public static c OB() {
        if (dMm == null) {
            dMm = new c(ad.getContext());
        }
        return dMm;
    }

    private c(Context context) {
        this.mContext = context;
        this.dSd = g.bM(context);
    }

    public final void a(a aVar, boolean z) {
        Object obj;
        x.i("MicroMsg.LocationGeo", "startWgs84 %s userCache %s delay %d", new Object[]{aVar, Boolean.valueOf(z), Integer.valueOf(0)});
        if (this.dSc && this.avD.size() > 0) {
            try {
                this.dSe = System.currentTimeMillis();
                this.dSq = false;
                this.dSr = false;
                g.OF();
                g.a(this.dSt, 0, Looper.getMainLooper());
            } catch (g.a e) {
                x.d("MicroMsg.LocationGeo", e.toString());
            }
        }
        this.dSc = false;
        for (WeakReference weakReference : this.avD) {
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                obj = null;
                break;
            }
        }
        int obj2 = 1;
        if (obj2 != null) {
            this.avD.add(new WeakReference(aVar));
        }
        x.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[]{Integer.valueOf(this.avD.size())});
        if (this.avD.size() == 1 && obj2 != null) {
            try {
                this.dSe = System.currentTimeMillis();
                this.dSq = false;
                this.dSr = false;
                g.a(this.dSt, 0, Looper.getMainLooper());
            } catch (g.a e2) {
                x.d("MicroMsg.LocationGeo", e2.toString());
            }
        }
        if (z && this.dSh && System.currentTimeMillis() - this.dSf < 60000) {
            this.dSt.a(true, this.dSi, this.dSj, this.dSk, this.dSl, this.dSm, this.bhF, this.dSn, this.dSo, this.dSp);
        }
    }

    public final void b(a aVar) {
        a(aVar, true);
    }

    public final void a(a aVar) {
        b(aVar, true);
    }

    public final void b(a aVar, boolean z) {
        Object obj;
        if (!this.dSc && this.avD.size() > 0) {
            try {
                this.dSe = System.currentTimeMillis();
                this.dSq = false;
                this.dSr = false;
                g.OF();
                g.a(this.dSs, 1, Looper.getMainLooper());
            } catch (g.a e) {
                x.d("MicroMsg.LocationGeo", e.toString());
            }
        }
        this.dSc = true;
        for (WeakReference weakReference : this.avD) {
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                obj = null;
                break;
            }
        }
        int obj2 = 1;
        if (obj2 != null) {
            this.avD.add(new WeakReference(aVar));
        }
        x.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[]{Integer.valueOf(this.avD.size())});
        if (this.avD.size() == 1 && obj2 != null) {
            try {
                this.dSe = System.currentTimeMillis();
                this.dSq = false;
                this.dSr = false;
                g.a(this.dSs, 1, Looper.getMainLooper());
            } catch (g.a e2) {
                x.d("MicroMsg.LocationGeo", e2.toString());
            }
        }
        if (z && this.dSg && System.currentTimeMillis() - this.dSf < 60000) {
            this.dSs.a(true, this.dSi, this.dSj, this.dSk, this.dSl, this.dSm, this.bhF, this.dSn, this.dSo, this.dSp);
        }
    }

    public final void c(a aVar) {
        new ag().post(new 3(this, aVar));
    }

    public static boolean OC() {
        try {
            return ((LocationManager) ad.getContext().getSystemService("location")).isProviderEnabled(TencentLocation.GPS_PROVIDER);
        } catch (Throwable e) {
            x.e("MicroMsg.LocationGeo", "exception:%s", new Object[]{bi.i(e)});
            return false;
        }
    }

    public static boolean OD() {
        try {
            return ((LocationManager) ad.getContext().getSystemService("location")).isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
        } catch (Throwable e) {
            x.e("MicroMsg.LocationGeo", "exception:%s", new Object[]{bi.i(e)});
            return false;
        }
    }
}
