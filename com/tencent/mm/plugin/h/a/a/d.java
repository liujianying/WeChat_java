package com.tencent.mm.plugin.h.a.a;

import com.tencent.mm.sdk.platformtools.x;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Vector;
import junit.framework.Assert;

public final class d {
    private final HashMap<c, Vector<Integer>> dsh = new HashMap();
    private b heQ = null;

    public d(b bVar) {
        this.heQ = bVar;
    }

    public final void a(int i, String str, e eVar) {
        x.i("MicroMsg.exdevie.IBeaconManager", "advertismentProcess, brand = %s, rssi = %d", new Object[]{null, Integer.valueOf(i)});
        if (eVar == null) {
            x.e("MicroMsg.exdevie.IBeaconManager", "null == aProtocal");
            return;
        }
        c cVar = new c();
        cVar.heN = null;
        cVar.heO = eVar;
        cVar.bvw = str;
        Vector vector;
        if (this.dsh.containsKey(cVar)) {
            vector = (Vector) this.dsh.get(cVar);
            vector.add(Integer.valueOf(i));
            if (1 <= vector.size()) {
                try {
                    a(vector, cVar);
                    return;
                } catch (Exception e) {
                    x.e("MicroMsg.exdevie.IBeaconManager", "calDistance failed!!!, %s", new Object[]{e.getMessage()});
                    return;
                } finally {
                    vector.clear();
                }
            } else {
                return;
            }
        }
        vector = new Vector();
        vector.add(Integer.valueOf(i));
        this.dsh.put(cVar, vector);
    }

    private void a(Vector<Integer> vector, c cVar) {
        int i;
        int[] iArr;
        double i2;
        double j;
        x.i("MicroMsg.exdevie.IBeaconManager", "calDistance");
        int[] iArr2 = new int[vector.size()];
        int i3 = 0;
        while (true) {
            i = i3;
            if (i >= iArr2.length) {
                break;
            }
            iArr2[i] = ((Integer) vector.elementAt(i)).intValue();
            i3 = i + 1;
        }
        a aVar = new a(iArr2);
        if (1 == aVar.heM.length) {
            x.d("MicroMsg.exdevice.GaussianFilter", "data group length = 1, no need to filter, just return");
            iArr = aVar.heM;
        } else {
            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append("Data Before GaussianFilter \r\n");
            for (int i4 : aVar.heM) {
                stringBuilder.append(" " + i4);
            }
            x.d("MicroMsg.exdevice.GaussianFilter", stringBuilder.toString());
            i2 = i.i(aVar.heM);
            j = i.j(aVar.heM);
            double doubleValue = i.j(0.15d, j).add(new BigDecimal(i2)).doubleValue();
            double doubleValue2 = i.j(3.09d, j).add(new BigDecimal(i2)).doubleValue();
            x.d("MicroMsg.exdevice.GaussianFilter", "Mean = " + i2 + "SD = " + j + "LowerLimit = " + doubleValue + " UpperLimit = " + doubleValue2);
            i = 0;
            int[] iArr3 = new int[aVar.heM.length];
            i3 = 0;
            while (i3 < aVar.heM.length) {
                if (((double) aVar.heM[i3]) >= doubleValue && ((double) aVar.heM[i3]) <= doubleValue2) {
                    int i5 = i + 1;
                    iArr3[i] = aVar.heM[i3];
                    i = i5;
                }
                i3++;
            }
            Assert.assertTrue(i != 0);
            iArr2 = new int[i];
            for (i3 = 0; i3 < i; i3++) {
                iArr2[i3] = iArr3[i3];
            }
            stringBuilder = new StringBuilder("");
            stringBuilder.append("Data After GaussianFilter \r\n");
            for (int i42 : iArr2) {
                stringBuilder.append(" " + i42);
            }
            x.d("MicroMsg.exdevice.GaussianFilter", stringBuilder.toString());
            iArr = iArr2;
        }
        if (iArr == null || iArr.length == 0) {
            throw new NullPointerException("null == ret || 0 == ret.length");
        }
        double i6 = i.i(iArr);
        cVar.heP = new BigDecimal(i6).divide(new BigDecimal(1), 3, 4).doubleValue();
        i2 = (1.0d * i6) / ((double) cVar.heO.heS.hfw);
        if (i2 < 1.0d) {
            i2 = Math.pow(i2, 10.0d);
        } else {
            i2 = (Math.pow(i2, 9.9476d) * 0.92093d) + 0.54992d;
        }
        x.i("MicroMsg.exdevie.IBeaconManager", "txPower = %f , rssi = %f,distance = %f", new Object[]{Double.valueOf(j), Double.valueOf(i6), Double.valueOf(i2)});
        this.heQ.a(i2, cVar);
    }
}
