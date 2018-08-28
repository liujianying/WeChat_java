package com.tencent.c.e.a.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class g {
    private static final int[] vjY = new int[]{1, 4, 9};
    private final SensorManager bgR;
    private final HashSet<Sensor> vjW = new HashSet();
    public final SparseArray<i> vjX = new SparseArray();
    public a vjZ = new a(this);

    public g(Context context) {
        this.bgR = (SensorManager) context.getSystemService("sensor");
    }

    public final synchronized boolean gT(long j) {
        boolean z;
        if (this.bgR == null) {
            z = false;
        } else {
            a aVar = this.vjZ;
            synchronized (aVar.vka) {
                if (aVar.vka.get()) {
                } else {
                    aVar.vka.set(true);
                    aVar.vjP = System.currentTimeMillis();
                    aVar.vkb = (int) Math.ceil(((double) j) / ((double) f.vjT));
                }
            }
            synchronized (this.vjW) {
                this.vjW.clear();
            }
            synchronized (this.vjW) {
                z = false;
                for (int defaultSensor : vjY) {
                    Sensor defaultSensor2 = this.bgR.getDefaultSensor(defaultSensor);
                    if (defaultSensor2 != null && this.bgR.registerListener(this.vjZ, defaultSensor2, 0)) {
                        this.vjW.add(defaultSensor2);
                        z = true;
                    }
                }
            }
            if (!z) {
                cFo();
            }
        }
        return z;
    }

    public final synchronized void cFo() {
        if (this.bgR != null) {
            synchronized (this.vjW) {
                Iterator it = this.vjW.iterator();
                while (it.hasNext()) {
                    this.bgR.unregisterListener(this.vjZ, (Sensor) it.next());
                }
                this.vjW.clear();
            }
            a aVar = this.vjZ;
            synchronized (aVar.vka) {
                if (aVar.vka.get()) {
                    aVar.vka.set(false);
                    aVar.vkc = System.currentTimeMillis() - aVar.vjP;
                    if (aVar.vkc < 0) {
                        aVar.vkc = 0;
                    }
                    aVar.vjP = 0;
                }
            }
        }
    }

    public final SparseArray<i> cFp() {
        synchronized (this.vjX) {
            SparseArray<i> sparseArray = new SparseArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.vjX.size()) {
                    break;
                }
                sparseArray.append(this.vjX.keyAt(i2), (i) this.vjX.valueAt(i2));
                i = i2 + 1;
            }
            if (e(sparseArray)) {
                return sparseArray;
            }
            SparseArray<i> sparseArray2 = new SparseArray();
            return sparseArray2;
        }
    }

    private static boolean e(SparseArray<i> sparseArray) {
        if (sparseArray.size() == 0) {
            return false;
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            i iVar = (i) sparseArray.valueAt(i);
            if (iVar != null) {
                Object[] cFu = iVar.cFu();
                if (!(cFu == null || cFu.length == 0)) {
                    int i2 = 0;
                    for (Object obj : iVar.tD) {
                        if (((List) obj) != null) {
                            i2++;
                        }
                    }
                    if (i2 < 3) {
                        return false;
                    }
                    for (Object obj2 : cFu) {
                        List list = (List) obj2;
                        if (list != null && list.size() < f.vjU / 2) {
                            return false;
                        }
                    }
                    continue;
                }
            }
        }
        return true;
    }
}
