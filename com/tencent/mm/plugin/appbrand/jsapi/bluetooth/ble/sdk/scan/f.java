package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanRecord;
import android.os.ParcelUuid;
import android.support.v4.e.a;
import android.util.SparseArray;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class f {
    private final int fNH;
    public final List<ParcelUuid> fNI;
    public final SparseArray<byte[]> fNJ;
    public final Map<ParcelUuid, byte[]> fNK;
    private final int fNL;
    final byte[] fNM;
    public final String fNv;

    private f(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i, int i2, String str, byte[] bArr) {
        this.fNI = list;
        this.fNJ = sparseArray;
        this.fNK = map;
        this.fNv = str;
        this.fNH = i;
        this.fNL = i2;
        this.fNM = bArr;
    }

    @TargetApi(21)
    f(ScanRecord scanRecord) {
        this.fNI = scanRecord.getServiceUuids();
        this.fNJ = scanRecord.getManufacturerSpecificData();
        this.fNK = scanRecord.getServiceData();
        this.fNv = scanRecord.getDeviceName();
        this.fNH = scanRecord.getAdvertiseFlags();
        this.fNL = scanRecord.getTxPowerLevel();
        this.fNM = scanRecord.getBytes();
    }

    public static f V(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int i = 0;
        List arrayList = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        a aVar = new a();
        int i2 = Integer.MIN_VALUE;
        String str = null;
        int i3 = -1;
        while (i < bArr.length) {
            try {
                int i4 = i + 1;
                i = bArr[i] & WebView.NORMAL_MODE_ALPHA;
                if (i != 0) {
                    i--;
                    int i5 = i4 + 1;
                    switch (bArr[i4] & WebView.NORMAL_MODE_ALPHA) {
                        case 1:
                            i3 = bArr[i5] & WebView.NORMAL_MODE_ALPHA;
                            break;
                        case 2:
                        case 3:
                            a(bArr, i5, i, 2, arrayList);
                            break;
                        case 4:
                        case 5:
                            a(bArr, i5, i, 4, arrayList);
                            break;
                        case 6:
                        case 7:
                            a(bArr, i5, i, 16, arrayList);
                            break;
                        case 8:
                        case 9:
                            str = new String(m(bArr, i5, i));
                            break;
                        case 10:
                            i2 = bArr[i5];
                            break;
                        case 22:
                            aVar.put(c.U(m(bArr, i5, 2)), m(bArr, i5 + 2, i - 2));
                            break;
                        case WebView.NORMAL_MODE_ALPHA /*255*/:
                            sparseArray.put(((bArr[i5 + 1] & WebView.NORMAL_MODE_ALPHA) << 8) + (bArr[i5] & WebView.NORMAL_MODE_ALPHA), m(bArr, i5 + 2, i - 2));
                            break;
                        default:
                            break;
                    }
                    i += i5;
                } else {
                    if (arrayList.isEmpty()) {
                        arrayList = null;
                    }
                    return new f(arrayList, sparseArray, aVar, i3, i2, str, bArr);
                }
            } catch (Exception e) {
                new StringBuilder("unable to parse scan record: ").append(Arrays.toString(bArr));
                return new f(null, null, null, -1, Integer.MIN_VALUE, null, bArr);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new f(arrayList, sparseArray, aVar, i3, i2, str, bArr);
    }

    public final String toString() {
        return "ScanRecord [mAdvertiseFlags=" + this.fNH + ", mServiceUuids=" + this.fNI + ", mManufacturerSpecificData=" + b(this.fNJ) + ", mServiceData=" + y(this.fNK) + ", mTxPowerLevel=" + this.fNL + ", mDeviceName=" + this.fNv + "]";
    }

    private static int a(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(c.U(m(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private static byte[] m(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return obj;
    }

    private static String b(SparseArray<byte[]> sparseArray) {
        if (sparseArray == null) {
            return "null";
        }
        if (sparseArray.size() == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray.size()) {
                stringBuilder.append(sparseArray.keyAt(i2)).append("=").append(Arrays.toString((byte[]) sparseArray.valueAt(i2)));
                i = i2 + 1;
            } else {
                stringBuilder.append('}');
                return stringBuilder.toString();
            }
        }
    }

    private static <T> String y(Map<T, byte[]> map) {
        if (map == null) {
            return "null";
        }
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object key = ((Entry) it.next()).getKey();
            stringBuilder.append(key).append("=").append(Arrays.toString((byte[]) map.get(key)));
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
