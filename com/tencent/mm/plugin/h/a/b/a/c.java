package com.tencent.mm.plugin.h.a.b.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.h.a.b.a.g.a;
import com.tencent.mm.plugin.h.a.b.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
public class c {
    public static final String TAG = c.class.getName();
    private static HashMap<String, Long> hgB = new HashMap();
    private static HashMap<String, Long> hhL;

    static {
        HashMap hashMap = new HashMap();
        hhL = hashMap;
        hashMap.put(h.hgQ, Long.valueOf(1));
        hhL.put(h.hgR, Long.valueOf(1));
        hhL.put(h.hgS, Long.valueOf(16));
        hhL.put(h.hgT, Long.valueOf(16));
        hhL.put(h.hgU, Long.valueOf(16));
        hhL.put(h.hgV, Long.valueOf(16));
        hgB.put(h.hgN, Long.valueOf(0));
        hgB.put(h.hgW, Long.valueOf(2));
        hgB.put(h.hgZ, Long.valueOf(4));
        hgB.put(h.hhd, Long.valueOf(8));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean ae(byte[] r12) {
        /*
        r11 = 16;
        r10 = 2;
        r1 = 1;
        r0 = 0;
        r2 = com.tencent.mm.sdk.platformtools.bi.bC(r12);
        if (r2 == 0) goto L_0x0014;
    L_0x000b:
        r1 = TAG;
        r2 = "parseBroadcastServiceUuid error. broadcast data is null or nil";
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
    L_0x0013:
        return r0;
    L_0x0014:
        r2 = r0;
    L_0x0015:
        if (r2 < 0) goto L_0x0013;
    L_0x0017:
        r3 = r12.length;
        if (r2 >= r3) goto L_0x0013;
    L_0x001a:
        r3 = r2 + 1;
        r2 = r12[r2];
        r4 = r3 + r2;
        r5 = r12.length;
        if (r4 <= r5) goto L_0x0042;
    L_0x0023:
        r4 = TAG;
        r5 = "broadcast data len is not enough. offset = %d, current len = %d, broadcast len = %d";
        r6 = 3;
        r6 = new java.lang.Object[r6];
        r3 = java.lang.Integer.valueOf(r3);
        r6[r0] = r3;
        r2 = java.lang.Integer.valueOf(r2);
        r6[r1] = r2;
        r1 = r12.length;
        r1 = java.lang.Integer.valueOf(r1);
        r6[r10] = r1;
        com.tencent.mm.sdk.platformtools.x.w(r4, r5, r6);
        goto L_0x0013;
    L_0x0042:
        if (r2 > 0) goto L_0x0055;
    L_0x0044:
        r3 = TAG;
        r4 = "current part of data's len = %d.";
        r1 = new java.lang.Object[r1];
        r2 = java.lang.Integer.valueOf(r2);
        r1[r0] = r2;
        com.tencent.mm.sdk.platformtools.x.w(r3, r4, r1);
        goto L_0x0013;
    L_0x0055:
        r4 = r3 + 1;
        r3 = r12[r3];
        r2 = r2 + -1;
        switch(r3) {
            case -1: goto L_0x00f0;
            case 0: goto L_0x005e;
            case 1: goto L_0x005e;
            case 2: goto L_0x0060;
            case 3: goto L_0x0060;
            case 4: goto L_0x005e;
            case 5: goto L_0x005e;
            case 6: goto L_0x0118;
            case 7: goto L_0x0118;
            default: goto L_0x005e;
        };
    L_0x005e:
        r2 = r2 + r4;
        goto L_0x0015;
    L_0x0060:
        if (r10 > r2) goto L_0x0099;
    L_0x0062:
        r3 = r4 + 1;
        r4 = r12[r4];
        r5 = r4 & 255;
        r4 = r3 + 1;
        r3 = r12[r3];
        r3 = r3 & 255;
        r3 = r3 << 8;
        r3 = r3 | r5;
        r2 = r2 + -2;
        r5 = "%08x-0000-1000-8000-00805f9b34fb";
        r6 = new java.lang.Object[r1];
        r3 = java.lang.Integer.valueOf(r3);
        r6[r0] = r3;
        r3 = java.lang.String.format(r5, r6);
        r5 = TAG;
        r6 = "find 16-bit broacast service = %s";
        r7 = new java.lang.Object[r1];
        r7[r0] = r3;
        com.tencent.mm.sdk.platformtools.x.d(r5, r6, r7);
        r5 = hgB;
        r3 = r5.containsKey(r3);
        if (r3 == 0) goto L_0x0060;
    L_0x0096:
        r0 = r1;
        goto L_0x0013;
    L_0x0099:
        r2 = r2 + r4;
        goto L_0x0015;
    L_0x009c:
        r4 = r4 + 16;
        r2 = r3 + -16;
        r3 = r2;
    L_0x00a1:
        if (r11 > r3) goto L_0x00ec;
    L_0x00a3:
        r2 = 16;
        r2 = java.nio.ByteBuffer.wrap(r12, r4, r2);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r5 = java.nio.ByteOrder.LITTLE_ENDIAN;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2 = r2.order(r5);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r6 = r2.getLong();	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r8 = r2.getLong();	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2 = new java.util.UUID;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2.<init>(r8, r6);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2 = r2.toString();	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r5 = TAG;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r6 = "find 128-bit broacast service = %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r8 = 0;
        r7[r8] = r2;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        com.tencent.mm.sdk.platformtools.x.d(r5, r6, r7);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r5 = hgB;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2 = r5.containsKey(r2);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        if (r2 == 0) goto L_0x009c;
    L_0x00d6:
        r0 = r1;
        goto L_0x0013;
    L_0x00d9:
        r2 = move-exception;
        r5 = "BlueToothDeviceFilter.parseUUID";
        r2 = r2.toString();	 Catch:{ all -> 0x00ea }
        com.tencent.mm.sdk.platformtools.x.e(r5, r2);	 Catch:{ all -> 0x00ea }
        r4 = r4 + 16;
        r2 = r3 + -16;
        r3 = r2;
        goto L_0x00a1;
    L_0x00ea:
        r0 = move-exception;
        throw r0;
    L_0x00ec:
        r2 = r4 + r3;
        goto L_0x0015;
    L_0x00f0:
        r3 = TAG;
        r5 = "Manufacturer Specific Data size = %s";
        r6 = new java.lang.Object[r1];
        r7 = java.lang.Integer.valueOf(r2);
        r6[r0] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r3, r5, r6);
        r3 = TAG;
        r5 = "Manufacturer Specific Data = %s";
        r6 = new java.lang.Object[r1];
        r7 = r4 + r2;
        r7 = java.util.Arrays.copyOfRange(r12, r4, r7);
        r7 = com.tencent.mm.plugin.exdevice.j.b.aq(r7);
        r6[r0] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r3, r5, r6);
        goto L_0x005e;
    L_0x0118:
        r3 = r2;
        goto L_0x00a1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.h.a.b.a.c.ae(byte[]):boolean");
    }

    public static String bX(long j) {
        for (String str : hgB.keySet()) {
            if (((Long) hgB.get(str)).longValue() == j) {
                return str;
            }
        }
        if (hhL.containsValue(Long.valueOf(j))) {
            return h.hgN;
        }
        return null;
    }

    public static long a(BluetoothGattService bluetoothGattService) {
        long j = 0;
        if (bluetoothGattService == null) {
            x.e(TAG, "service is null");
            return 0;
        }
        String uuid = bluetoothGattService.getUuid().toString();
        Long l;
        if (!uuid.equalsIgnoreCase(h.hgN) || bluetoothGattService.getCharacteristic(UUID.fromString(h.hgQ)) == null) {
            l = (Long) hgB.get(uuid);
            if (l != null) {
                j = l.longValue();
            }
            x.d(TAG, "service uuid = %s, profileType = %d", new Object[]{uuid, Long.valueOf(j)});
            return j;
        }
        List characteristics = bluetoothGattService.getCharacteristics();
        long j2 = 0;
        int i = 0;
        while (i < characteristics.size()) {
            l = (Long) hhL.get(((BluetoothGattCharacteristic) characteristics.get(i)).getUuid().toString());
            i++;
            j2 = (l == null ? 0 : l.longValue()) | j2;
        }
        x.d(TAG, "wechat service, profileType = %d", new Object[]{Long.valueOf(j2)});
        return j2;
    }

    public static boolean b(BluetoothGattService bluetoothGattService) {
        if (bluetoothGattService == null) {
            x.e(TAG, "service is null");
            return false;
        }
        long a = a(bluetoothGattService);
        BluetoothGattCharacteristic characteristic;
        int properties;
        if (0 != (1 & a)) {
            if (bluetoothGattService == null) {
                x.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.hgQ));
            if (characteristic == null) {
                x.e(TAG, "no step measurement characteristic found");
                return false;
            }
            properties = characteristic.getProperties();
            x.d(TAG, "step measurement characteristic properties = %d", new Object[]{Integer.valueOf(properties)});
            if ((properties & 48) == 0 || (properties & 2) == 0) {
                x.e(TAG, "step measurement characteristic has incorrect proterties(%d)", new Object[]{Integer.valueOf(properties)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.hgR));
            if (characteristic != null) {
                properties = characteristic.getProperties();
                if ((properties & 2) == 0 || (properties & 32) == 0) {
                    x.e(TAG, "step target characteristic has incorrect proterties(%d)", new Object[]{Integer.valueOf(properties)});
                    return false;
                }
            }
            return true;
        } else if (0 != (2 & a)) {
            if (bluetoothGattService == null) {
                x.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.hgX));
            if (characteristic == null) {
                x.e(TAG, "weight scale feature characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 2) == 0) {
                x.e(TAG, "weight scale feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.hgY));
            if (characteristic == null) {
                x.e(TAG, "weight measurement characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 32) != 0) {
                return true;
            }
            x.e(TAG, "weight measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32)});
            return false;
        } else if (0 != (4 & a)) {
            if (bluetoothGattService == null) {
                x.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.hha));
            if (characteristic == null) {
                x.e(TAG, "heart rate measurement characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 16) == 0) {
                x.e(TAG, "heart rate measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(16)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.hhb));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 2) == 0) {
                    x.e(TAG, "heart rate body sensor location characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2)});
                    return false;
                }
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.hhc));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 8) == 0) {
                    x.e(TAG, "heart rate control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(8)});
                    return false;
                }
            }
            return true;
        } else if (0 != (8 & a)) {
            if (bluetoothGattService == null) {
                x.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.hhe));
            if (characteristic == null) {
                x.e(TAG, "blood pressure measurement characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 32) == 0) {
                x.e(TAG, "blood pressure measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.hhg));
            if (characteristic == null) {
                x.e(TAG, "blood pressure feature characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 2) == 0) {
                x.e(TAG, "blood pressure feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.hhf));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 16) == 0) {
                    x.e(TAG, "blood pressure intermediate cuff pressure characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(16)});
                    return false;
                }
            }
            return true;
        } else if (0 == (a & 16)) {
            return false;
        } else {
            if (bluetoothGattService == null) {
                x.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.hgS));
            if (characteristic == null) {
                x.e(TAG, "light color characteristic not found");
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) == 0 || (properties & 16) == 0 || (properties & 2) == 0 || (properties & 8) == 0) {
                x.e(TAG, "light color characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(properties), Integer.valueOf(32)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.hgT));
            if (characteristic == null) {
                x.e(TAG, "light work state characteristic not found");
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) == 0 || (properties & 2) == 0 || (properties & 8) == 0) {
                x.e(TAG, "light work state characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(properties), Integer.valueOf(32)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.hgU));
            if (characteristic == null) {
                x.e(TAG, "light state changed characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 32) == 0) {
                x.e(TAG, "light state changed characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.hgV));
            if (characteristic == null) {
                x.e(TAG, "control point characteristic not found");
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) != 0 && (properties & 8) != 0) {
                return true;
            }
            x.e(TAG, "control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(properties), Integer.valueOf(32)});
            return false;
        }
    }

    public static byte[] a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        boolean z = false;
        if (bluetoothGattCharacteristic == null || bArr == null) {
            x.e(TAG, "characteristic or recvData is null");
            return null;
        }
        long j = 0;
        String uuid = bluetoothGattCharacteristic.getUuid().toString();
        BluetoothGattService service = bluetoothGattCharacteristic.getService();
        if (service != null) {
            j = a(service);
        } else {
            x.e(TAG, "the characteristic has no parent service");
        }
        x.d(TAG, "recv data. uuid = %s, data = %s", new Object[]{uuid, b.aq(bArr)});
        boolean z2;
        int i;
        int i2;
        int i3;
        byte[] bw;
        if (0 != (1 & j) && (uuid.equalsIgnoreCase(f.hin) || uuid.equalsIgnoreCase(f.hio))) {
            f fVar = new f();
            if (bArr.length <= 0 || (bArr[0] & 1) == 0) {
                x.e(f.TAG, "pase step data error");
                z2 = false;
            } else if (uuid == null || !(uuid.equals(f.hin) || uuid.equals(f.hio))) {
                x.e(f.TAG, "uuid is not correct");
                z2 = false;
            } else {
                fVar.hhi = uuid;
                i = 4;
                if ((bArr[0] & 2) != 0) {
                    i = 7;
                }
                if ((bArr[0] & 4) != 0) {
                    i += 3;
                }
                if (i > bArr.length) {
                    x.e(f.TAG, "data len is not enough");
                    z2 = false;
                } else {
                    fVar.hip = 0;
                    i = 1;
                    for (i2 = 0; i2 < 3; i2++) {
                        fVar.hip += (bArr[i] & 255) << (i2 * 8);
                        i++;
                    }
                    if ((bArr[0] & 2) != 0) {
                        fVar.hiq = 0;
                        for (i2 = 0; i2 < 3; i2++) {
                            fVar.hiq += (bArr[i] & 255) << (i2 * 8);
                            i++;
                        }
                    }
                    if ((bArr[0] & 4) != 0) {
                        fVar.hir = 0;
                        i3 = i;
                        for (i2 = 0; i2 < 3; i2++) {
                            fVar.hir += (bArr[i3] & 255) << (i2 * 8);
                            i3++;
                        }
                    }
                    z2 = true;
                }
            }
            if (z2) {
                bw = b.bw(fVar);
                x.d(TAG, "step info. stepCount=%d, stepDistance=%d, stepColarie=%d", new Object[]{Integer.valueOf(fVar.hip), Integer.valueOf(fVar.hiq), Integer.valueOf(fVar.hir)});
                return bw;
            }
            x.e(TAG, "parse step data error");
            return null;
        } else if (0 != (2 & j) && (uuid.equalsIgnoreCase(g.hgY) || uuid.equalsIgnoreCase(g.hgX))) {
            g gVar = new g();
            if (uuid == null || uuid.length() <= 0 || bArr == null || bArr.length <= 0) {
                x.e(g.TAG, "characteristicUuid or data is null or nil");
                z2 = false;
            } else {
                gVar.hhi = uuid;
                String str;
                Object[] objArr;
                if (gVar.hhi.equalsIgnoreCase(g.hgX)) {
                    if (4 > bArr.length) {
                        x.e(g.TAG, "weight scale feature characteristic data is a 32bit value, but current value len is %d", new Object[]{Integer.valueOf(bArr.length)});
                        z2 = false;
                    } else {
                        gVar.hiu = new com.tencent.mm.plugin.h.a.b.a.g.c();
                        gVar.hiu.hiA = (bArr[0] & 1) != 0;
                        gVar.hiu.hiB = (bArr[0] & 2) != 0;
                        gVar.hiu.hiC = (bArr[0] & 4) != 0;
                        gVar.hiu.hiD = (byte) ((bArr[0] & TbsListener$ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR) >> 3);
                        gVar.hiu.hiE = (byte) (((bArr[0] & 128) >> 7) + ((bArr[1] & 3) << 1));
                        uuid = g.TAG;
                        str = "timestampSupported = %s, multipleUsersSupported = %s, BMISupported = %s, weightResolution = %d, heightResolution = %d";
                        objArr = new Object[5];
                        objArr[0] = gVar.hiu.hiA ? "true" : "false";
                        objArr[1] = gVar.hiu.hiB ? "true" : "false";
                        objArr[2] = gVar.hiu.hiC ? "true" : "false";
                        objArr[3] = Byte.valueOf(gVar.hiu.hiD);
                        objArr[4] = Byte.valueOf(gVar.hiu.hiE);
                        x.d(uuid, str, objArr);
                    }
                } else if (gVar.hhi.equalsIgnoreCase(g.hgY)) {
                    byte b = bArr[0];
                    if ((b & 2) != 0) {
                        i = 10;
                    } else {
                        i = 3;
                    }
                    if ((b & 4) != 0) {
                        i++;
                    }
                    if ((b & 8) != 0) {
                        i += 4;
                    }
                    if (i > bArr.length) {
                        x.e(g.TAG, "data len is not enough for parse. current len = %d, needed len = %d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i)});
                        z2 = false;
                    } else {
                        gVar.hiv = new g$b();
                        gVar.hiv.hiw = (b & 1) != 0;
                        gVar.hiv.hix = (bArr[1] & 255) + ((bArr[2] & 255) << 8);
                        if ((b & 2) != 0) {
                            gVar.hiv.hiy = new a();
                            a aVar = gVar.hiv.hiy;
                            String str2 = g.TAG;
                            String str3 = "data size = %d, offset = %d, lenght = %d";
                            Object[] objArr2 = new Object[3];
                            objArr2[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                            objArr2[1] = Integer.valueOf(3);
                            objArr2[2] = Integer.valueOf(7);
                            x.d(str2, str3, objArr2);
                            if (bArr == null || bArr.length < 10) {
                                x.e(g.TAG, "data input error");
                            } else {
                                aVar.hhF = (bArr[3] & 255) + ((bArr[4] & 255) << 8);
                                aVar.hhG = bArr[5] & 255;
                                aVar.hhH = bArr[6] & 255;
                                aVar.hhI = bArr[7] & 255;
                                aVar.hhJ = bArr[8] & 255;
                                aVar.hhK = bArr[9] & 255;
                                x.d(g.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[]{Integer.valueOf(aVar.hhF), Integer.valueOf(aVar.hhG), Integer.valueOf(aVar.hhH), Integer.valueOf(aVar.hhI), Integer.valueOf(aVar.hhJ), Integer.valueOf(aVar.hhK)});
                            }
                            i = 10;
                        } else {
                            i = 3;
                        }
                        if ((b & 4) != 0) {
                            gVar.hiv.hhy = bArr[i] & 255;
                            i++;
                        }
                        if ((b & 8) != 0) {
                            gVar.hiv.hiz = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
                            i += 2;
                            gVar.hiv.mHeight = ((bArr[i + 1] & 255) << 8) + (bArr[i] & 255);
                        }
                        uuid = g.TAG;
                        str = "WeightAndHeightUnit = %s, Weight = %d, TimeStamp = %s, UserId = %d, BMI = %d, Height = %d";
                        objArr = new Object[6];
                        objArr[0] = gVar.hiv.hiw ? "lb&inch" : "kg&meter";
                        objArr[1] = Integer.valueOf(gVar.hiv.hix);
                        objArr[2] = gVar.hiv.hiy == null ? "null" : "object";
                        objArr[3] = Integer.valueOf(gVar.hiv.hhy);
                        objArr[4] = Integer.valueOf(gVar.hiv.hiz);
                        objArr[5] = Integer.valueOf(gVar.hiv.mHeight);
                        x.d(uuid, str, objArr);
                    }
                }
                z2 = true;
            }
            if (z2) {
                bw = b.bw(gVar);
                x.d(TAG, "weight info. weight = %d", new Object[]{Integer.valueOf(gVar.hiv.hix)});
                return bw;
            }
            x.e(TAG, "parse weight scale data error");
            return null;
        } else if (0 != (4 & j) && (uuid.equalsIgnoreCase(d.hhk) || uuid.equalsIgnoreCase(d.hhM) || uuid.equalsIgnoreCase(d.hhN))) {
            d dVar = new d();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                x.e(d.TAG, "characteristicUuid or data is null");
            } else {
                dVar.hhi = uuid;
                i3 = bArr.length;
                if (dVar.hhi.equalsIgnoreCase(d.hhk)) {
                    if (bArr.length < 2) {
                        x.e(d.TAG, "Received data length is not right:" + i3);
                    } else {
                        int i4;
                        dVar.hhU = new d.a(dVar);
                        byte b2 = bArr[0];
                        x.d(d.TAG, "flag=" + b2);
                        if ((b2 & 1) == 1 && i3 >= 3) {
                            x.d(d.TAG, "Value Format = uint16");
                            dVar.hhU.hhV = (((bArr[2] << 8) & 65280) & 65280) + (bArr[1] & 255);
                            i = 3;
                        } else if (i3 >= 2) {
                            x.d(d.TAG, "Value Format = uint8");
                            dVar.hhU.hhV = bArr[1] & 255;
                            i = 2;
                        } else {
                            x.d(d.TAG, "receive data error");
                        }
                        x.v(d.TAG, "Data received from HR " + dVar.hhU.hhV);
                        if ((b2 & 6) == 4) {
                            x.d(d.TAG, "Sensor Contact feature is supported, but contact is not detected");
                            dVar.hhU.hhW = 1;
                        } else if ((b2 & 6) == 6) {
                            x.d(d.TAG, "Sensor Contact feature is supported and contact is detected");
                            dVar.hhU.hhW = 2;
                        } else {
                            x.d(d.TAG, "Sensor Contact feature is not supported in the current connection");
                            dVar.hhU.hhW = 0;
                        }
                        if ((b2 & 8) == 8 && i3 >= i + 2) {
                            x.d(d.TAG, "Energy Expend Present");
                            i4 = (bArr[i + 1] << 8) & 65280;
                            dVar.hhU.hhX = (bArr[i] & 255) + (i4 & 65280);
                            x.v("H7ConnectThread", "energyExp from HR energyExph " + i4 + " " + dVar.hhU.hhX);
                            i += 2;
                        }
                        if ((b2 & 16) == 16 && i3 >= i + 2) {
                            x.d(d.TAG, "RR Interval Present");
                            i4 = (bArr[i + 1] & 255) << 8;
                            dVar.hhU.hhY = (bArr[i] & 255) + (i4 & 65280);
                            x.v(d.TAG, "rrInterval from HR rrIntervalh" + i4 + " " + dVar.hhU.hhY);
                        }
                    }
                } else if (dVar.hhi.equalsIgnoreCase(d.hhM)) {
                    switch (bArr[0]) {
                        case (byte) 0:
                            dVar.hhT = "Other";
                            break;
                        case (byte) 1:
                            dVar.hhT = "Chest";
                            break;
                        case (byte) 2:
                            dVar.hhT = "Wrist";
                            break;
                        case (byte) 3:
                            dVar.hhT = "Finger";
                            break;
                        case (byte) 4:
                            dVar.hhT = "Hand";
                            break;
                        case (byte) 5:
                            dVar.hhT = "Ear Lobe";
                            break;
                        case (byte) 6:
                            dVar.hhT = "Foot";
                            break;
                        default:
                            dVar.hhT = "Unknown";
                            break;
                    }
                    x.d(d.TAG, "position=" + dVar.hhT);
                }
                z = true;
            }
            if (z) {
                return b.bw(dVar);
            }
            x.e(TAG, "parse heart rate data error");
            return null;
        } else if (0 != (8 & j) && (uuid.equalsIgnoreCase(b.hhk) || uuid.equalsIgnoreCase(b.hhl) || uuid.equalsIgnoreCase(b.hhm))) {
            b bVar = new b();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                x.e(b.TAG, "characteristicUuid or data is null");
            } else {
                bVar.hhi = uuid;
                i = bArr.length;
                byte b3;
                if (bVar.hhi.equalsIgnoreCase(b.hhk)) {
                    if (i < 7) {
                        x.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.hhs = new b$b(bVar);
                        b3 = bArr[0];
                        x.d(b.TAG, "flag=" + b3);
                        if ((b3 & 1) != 0) {
                            x.d(b.TAG, "the value unit is kPa.");
                            bVar.hhs.hhv = true;
                        } else {
                            x.d(b.TAG, "the value unit is mmHg.");
                            bVar.hhs.hhv = false;
                        }
                        bVar.hhs.hhC = b.K(bArr, 1);
                        bVar.hhs.hhD = b.K(bArr, 3);
                        bVar.hhs.hhE = b.K(bArr, 5);
                        i2 = 7;
                        if ((b3 & 2) == 0 || i < 14) {
                            x.d(b.TAG, "TimeStamp not Present.");
                        } else {
                            x.d(b.TAG, "TimeStamp Present.");
                            bVar.hhs.hhA.L(bArr, 7);
                            i2 = 14;
                        }
                        if ((b3 & 4) == 0 || i < i2 + 2) {
                            x.d(b.TAG, "PulseRate not Present.");
                        } else {
                            x.d(b.TAG, "PulseRate Present.");
                            bVar.hhs.hhx = (int) b.K(bArr, i2);
                            i2 += 2;
                            x.d(b.TAG, "PulseRate =" + bVar.hhs.hhx);
                        }
                        if ((b3 & 8) != 0) {
                            x.d(b.TAG, "UserId Present.");
                            i = i2 + 1;
                            bVar.hhs.hhy = bArr[i2];
                            x.d(b.TAG, "UserId = " + bVar.hhs.hhy);
                        } else {
                            x.d(b.TAG, "UserId not Present.");
                            i = i2;
                        }
                        if ((b3 & 16) != 0) {
                            x.d(b.TAG, "MeasurementStatus Present.");
                            bVar.hhs.hhz = (bArr[i] & 255) + (((bArr[i + 1] << 8) & 65280) & 65280);
                            x.d(b.TAG, "MeasurementStatus = " + bVar.hhs.hhz);
                        } else {
                            x.d(b.TAG, "MeasurementStatus not Present.");
                        }
                    }
                } else if (bVar.hhi.equalsIgnoreCase(b.hhl)) {
                    if (i < 3) {
                        x.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.hht = new b.a(bVar);
                        b3 = bArr[0];
                        x.d(b.TAG, "flag=" + b3);
                        if ((b3 & 1) != 0) {
                            x.d(b.TAG, "the value unit is kPa.");
                            bVar.hht.hhv = true;
                        } else {
                            x.d(b.TAG, "the value unit is mmHg.");
                            bVar.hht.hhv = false;
                        }
                        bVar.hht.hhw = b.K(bArr, 1);
                        if ((b3 & 2) == 0 || i < 10) {
                            x.d(b.TAG, "TimeStamp not Present.");
                            i2 = 3;
                        } else {
                            x.d(b.TAG, "TimeStamp Present.");
                            bVar.hht.hhA.L(bArr, 3);
                            i2 = 10;
                        }
                        if ((b3 & 4) == 0 || i < i2 + 2) {
                            x.d(b.TAG, "PulseRate not Present.");
                        } else {
                            x.d(b.TAG, "PulseRate Present.");
                            bVar.hht.hhx = (int) b.K(bArr, i2);
                            i2 += 2;
                            x.d(b.TAG, "PulseRate =" + bVar.hht.hhx);
                        }
                        if ((b3 & 8) != 0) {
                            x.d(b.TAG, "UserId Present.");
                            i = i2 + 1;
                            bVar.hht.hhy = bArr[i2];
                            x.d(b.TAG, "UserId = " + bVar.hht.hhy);
                        } else {
                            x.d(b.TAG, "UserId not Present.");
                            i = i2;
                        }
                        if ((b3 & 16) != 0) {
                            x.d(b.TAG, "MeasurementStatus Present.");
                            bVar.hht.hhz = (bArr[i] & 255) + (((bArr[i + 1] << 8) & 65280) & 65280);
                            x.d(b.TAG, "MeasurementStatus = " + bVar.hht.hhz);
                        } else {
                            x.d(b.TAG, "MeasurementStatus not Present.");
                        }
                    }
                } else if (bVar.hhi.equalsIgnoreCase(b.hhm)) {
                    x.d(b.TAG, "Blood Pressure Feature Characteristic.");
                    if (i < 2) {
                        x.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.hhu = (((bArr[1] << 8) & 65280) & 65280) + (bArr[0] & 255);
                        x.d(b.TAG, "bloodPressureFeatureParameters=" + bVar.hhu);
                    }
                }
                z = true;
            }
            if (z) {
                return b.bw(bVar);
            }
            x.e(TAG, "parse blood pressure data error");
            return null;
        } else if (0 == (j & 16) || !(uuid.equalsIgnoreCase(e.hia) || uuid.equalsIgnoreCase(e.hib) || uuid.equalsIgnoreCase(e.hic) || uuid.equalsIgnoreCase(e.hid))) {
            x.e(TAG, "unknown characteristic uuid = %s", new Object[]{uuid});
            return null;
        } else {
            e eVar = new e();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                x.e(e.TAG, "characteristicUuid or data is null");
            } else {
                eVar.hhi = uuid;
                if (eVar.hhi.equalsIgnoreCase(e.hia)) {
                    if (bArr.length != 3) {
                        x.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.hie = bArr[0];
                        eVar.hif = bArr[1];
                        eVar.hig = bArr[2];
                    }
                } else if (eVar.hhi.equalsIgnoreCase(e.hib)) {
                    if (bArr.length != 1) {
                        x.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.hih = bArr[0];
                    }
                } else if (eVar.hhi.equalsIgnoreCase(e.hic)) {
                    if (bArr.length < 2) {
                        x.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.hii[0] = bArr[0];
                        eVar.hii[1] = bArr[1];
                    }
                } else if (!eVar.hhi.equalsIgnoreCase(e.hid)) {
                    x.e(e.TAG, "characteristicUuid is incorrect");
                } else if (bArr.length < 4) {
                    x.e(e.TAG, "Data length incorrect");
                } else {
                    eVar.hij = (bArr[0] & 255) + ((bArr[1] & 255) << 8);
                    eVar.hil = bArr[2];
                    eVar.hik = bArr[3];
                    if (bArr.length > 4) {
                        eVar.him = new byte[(bArr.length - 4)];
                        System.arraycopy(bArr, 4, eVar.him, 0, bArr.length - 4);
                    } else {
                        eVar.him = null;
                    }
                }
                z = true;
            }
            if (z) {
                return b.bw(eVar);
            }
            x.e(TAG, "parse light data error");
            return null;
        }
    }
}
