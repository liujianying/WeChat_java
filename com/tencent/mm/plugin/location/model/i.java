package com.tencent.mm.plugin.location.model;

import android.hardware.SensorManager;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public final class i {
    private SensorManager bgR = ((SensorManager) ad.getContext().getSystemService("sensor"));
    private a cXs = new 1(this);
    private c dMm;
    HashSet<WeakReference<a>> gCt = new HashSet();
    private b kCM = new b(this);
    double kCN = 900.0d;
    double kCO = 900.0d;
    double kCP = -1000.0d;
    double kCQ = -1000.0d;
    double kCR = 0.0d;
    boolean kCS = false;

    public final double aZb() {
        if (this.kCS) {
            x.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = true, result = %f", new Object[]{Double.valueOf(this.kCN)});
            return this.kCN;
        }
        x.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = false, result = %f", new Object[]{Double.valueOf(this.kCR)});
        return this.kCR;
    }

    private void aZc() {
        x.i("MicroMsg.OrientationSensorMgr", "registerSensor ");
        if (this.dMm == null) {
            this.dMm = c.OB();
        }
        this.dMm.b(this.cXs, true);
        this.bgR.registerListener(this.kCM, this.bgR.getDefaultSensor(3), 1);
    }

    final void aZd() {
        x.i("MicroMsg.OrientationSensorMgr", "unregisterSensor ");
        this.bgR.unregisterListener(this.kCM);
        c.OB().c(this.cXs);
    }

    public final void a(a aVar) {
        Iterator it = this.gCt.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                return;
            }
        }
        this.gCt.add(new WeakReference(aVar));
        x.i("MicroMsg.OrientationSensorMgr", "registerSensorListener %d", new Object[]{Integer.valueOf(this.gCt.size())});
        if (this.gCt.size() == 1) {
            aZc();
        }
    }

    public final void b(a aVar) {
        if (this.gCt != null && aVar != null) {
            Iterator it = this.gCt.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                    this.gCt.remove(weakReference);
                    break;
                }
            }
            x.i("MicroMsg.OrientationSensorMgr", "unregisterSensorListener %d", new Object[]{Integer.valueOf(this.gCt.size())});
            if (this.gCt.size() == 0) {
                aZd();
            }
        }
    }
}
