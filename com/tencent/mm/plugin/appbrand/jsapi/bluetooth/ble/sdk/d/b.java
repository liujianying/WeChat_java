package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.support.v4.content.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Method;
import java.util.UUID;

public final class b {
    private static synchronized BluetoothManager aiz() {
        BluetoothManager bluetoothManager;
        synchronized (b.class) {
            bluetoothManager = (BluetoothManager) ad.getContext().getSystemService("bluetooth");
        }
        return bluetoothManager;
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static synchronized BluetoothAdapter aiA() {
        BluetoothAdapter adapter;
        synchronized (b.class) {
            BluetoothManager aiz = aiz();
            if (aiz != null) {
                adapter = aiz.getAdapter();
            } else {
                a.e("MicroMsg.Ble.BleHelper", "BluetoothManager is null err", new Object[0]);
                adapter = null;
            }
        }
        return adapter;
    }

    public static boolean tu(String str) {
        return a.f(ad.getContext(), str) == 0;
    }

    public static boolean aiB() {
        if (aiA() == null) {
            return false;
        }
        return aiA().isEnabled();
    }

    public static boolean kE(int i) {
        if ((i & 2) > 0) {
            return true;
        }
        return false;
    }

    public static boolean kF(int i) {
        if ((i & 8) > 0) {
            return true;
        }
        return false;
    }

    public static boolean kG(int i) {
        if ((i & 4) > 0) {
            return true;
        }
        return false;
    }

    public static boolean kH(int i) {
        if ((i & 16) > 0) {
            return true;
        }
        return false;
    }

    public static boolean kI(int i) {
        if ((i & 32) > 0) {
            return true;
        }
        return false;
    }

    public static boolean tv(String str) {
        try {
            UUID.fromString(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @TargetApi(18)
    public static boolean a(BluetoothGatt bluetoothGatt) {
        boolean booleanValue;
        if (bluetoothGatt != null) {
            try {
                Method method = BluetoothGatt.class.getMethod("refresh", new Class[0]);
                if (method != null) {
                    method.setAccessible(true);
                    booleanValue = ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                    return booleanValue;
                }
            } catch (Exception e) {
                return false;
            }
        }
        booleanValue = false;
        return booleanValue;
    }
}
