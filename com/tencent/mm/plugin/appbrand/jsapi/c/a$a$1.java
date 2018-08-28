package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.plugin.appbrand.jsapi.c.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

class a$a$1 implements LeScanCallback {
    final /* synthetic */ a fQz;

    a$a$1(a aVar) {
        this.fQz = aVar;
    }

    public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        if (bi.bC(bArr)) {
            x.e("MicroMsg.BeaconManager", "valueByte is null or nil");
            return;
        }
        int i2;
        int i3 = 2;
        Object obj = null;
        while (true) {
            i2 = i3;
            if (i2 <= 5) {
                if ((bArr[i2 + 2] & 255) == 2 && (bArr[i2 + 3] & 255) == 21) {
                    obj = 1;
                    break;
                }
                i3 = i2 + 1;
            } else {
                break;
            }
        }
        if (obj != null) {
            int i4;
            Object obj2 = new byte[16];
            System.arraycopy(bArr, i2 + 4, obj2, 0, 16);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i5 = 0; i5 < 16; i5++) {
                i4 = obj2[i5] & 255;
                if (i4 < 16) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(Integer.toHexString(i4));
            }
            String toUpperCase = stringBuilder.toString().toUpperCase(Locale.US);
            if (bi.oW(toUpperCase)) {
                x.e("MicroMsg.BeaconManager", "hexString is null, err");
                return;
            }
            int i6;
            UUID fromString = UUID.fromString(toUpperCase.substring(0, 8) + "-" + toUpperCase.substring(8, 12) + "-" + toUpperCase.substring(12, 16) + "-" + toUpperCase.substring(16, 20) + "-" + toUpperCase.substring(20, 32));
            obj = null;
            for (UUID equals : this.fQz.fQw) {
                if (equals.equals(fromString)) {
                    obj = 1;
                    break;
                }
            }
            if (obj != null) {
                double d;
                i4 = ((bArr[i2 + 20] & 255) * GLIcon.TOP) + (bArr[i2 + 21] & 255);
                i6 = ((bArr[i2 + 22] & 255) * GLIcon.TOP) + (bArr[i2 + 23] & 255);
                byte b = bArr[i2 + 24];
                double d2 = (double) i;
                if (d2 == 0.0d) {
                    d = -1.0d;
                } else {
                    d = (d2 * 1.0d) / ((double) b);
                    d = d < 1.0d ? Math.pow(d, 10.0d) : (Math.pow(d, 9.9476d) * 0.92093d) + 0.54992d;
                }
                String address = bluetoothDevice.getAddress();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("uuid", fromString);
                    jSONObject.put("major", i4);
                    jSONObject.put("minor", i6);
                    jSONObject.put("proximity", 0);
                    jSONObject.put("accuracy", d);
                    jSONObject.put("rssi", i);
                    this.fQz.fQv.put(address, jSONObject);
                    x.d("MicroMsg.BeaconManager", "found device ibeacon %s", new Object[]{jSONObject});
                } catch (JSONException e) {
                    x.e("MicroMsg.BeaconManager", "put JSON data error : %s", new Object[]{e});
                }
                if (this.fQz.fQx != null) {
                    this.fQz.fQx.A(this.fQz.fQv);
                }
            }
        }
    }
}
