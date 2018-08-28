package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.rtmp.sharp.jni.TraeAudioManager.d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TraeAudioManager$c extends d {
    Class<?> a = null;
    Class<?> b = null;
    Object c = null;
    Method d = null;
    Context e = null;
    TraeAudioManager$e f = null;
    final /* synthetic */ TraeAudioManager g;

    TraeAudioManager$c(TraeAudioManager traeAudioManager) {
        this.g = traeAudioManager;
        super(traeAudioManager);
    }

    public boolean a(Context context, TraeAudioManager$e traeAudioManager$e) {
        AudioDeviceInterface.LogTraceEntry("");
        this.e = context;
        this.f = traeAudioManager$e;
        if (this.e == null || this.f == null) {
            return false;
        }
        try {
            this.a = Class.forName("android.bluetooth.BluetoothHeadset");
        } catch (Exception e) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset class not found");
            }
        }
        if (this.a == null) {
            return false;
        }
        try {
            this.b = Class.forName("android.bluetooth.BluetoothHeadset$ServiceListener");
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset.ServiceListener class not found:" + e2);
            }
        }
        try {
            this.d = this.a.getDeclaredMethod("getCurrentHeadset", new Class[0]);
        } catch (NoSuchMethodException e3) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset NoSuchMethodException");
            }
        }
        if (this.d == null) {
            return false;
        }
        try {
            this.c = this.a.getConstructor(new Class[]{Context.class, this.b}).newInstance(new Object[]{context, null});
        } catch (IllegalArgumentException e4) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalArgumentException");
            }
        } catch (InstantiationException e5) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor InstantiationException");
            }
        } catch (IllegalAccessException e6) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalAccessException");
            }
        } catch (InvocationTargetException e7) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor InvocationTargetException");
            }
        } catch (NoSuchMethodException e8) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor NoSuchMethodException");
            }
        }
        if (this.c == null) {
            return false;
        }
        this.f.a("DEVICE_BLUETOOTHHEADSET", b());
        if (b()) {
            this.f.a("DEVICE_BLUETOOTHHEADSET", true);
            this.g.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
        } else {
            this.f.a("DEVICE_BLUETOOTHHEADSET", false);
        }
        AudioDeviceInterface.LogTraceExit();
        return true;
    }

    public void a() {
        AudioDeviceInterface.LogTraceEntry("");
        if (this.c != null) {
            Method declaredMethod;
            try {
                declaredMethod = this.a.getDeclaredMethod("close", new Class[0]);
            } catch (NoSuchMethodException e) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread _uninitHeadsetfor2x method close NoSuchMethodException");
                }
                declaredMethod = null;
            }
            if (declaredMethod != null) {
                try {
                    declaredMethod.invoke(this.c, new Object[0]);
                } catch (IllegalArgumentException e2) {
                } catch (IllegalAccessException e3) {
                } catch (InvocationTargetException e4) {
                }
                this.a = null;
                this.b = null;
                this.c = null;
                this.d = null;
                AudioDeviceInterface.LogTraceExit();
            }
        }
    }

    public boolean b() {
        Object obj = null;
        if (this.d == null || this.d == null) {
            return false;
        }
        try {
            obj = this.d.invoke(this.c, new Object[0]);
        } catch (IllegalArgumentException e) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalArgumentException");
            }
        } catch (IllegalAccessException e2) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalAccessException");
            }
        } catch (InvocationTargetException e3) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset InvocationTargetException");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset res:" + (obj != null ? " Y" : "N"));
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    void a(IntentFilter intentFilter) {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " " + c() + " _addAction");
        }
        intentFilter.addAction("android.bluetooth.headset.action.AUDIO_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.action.STATE_CHANGED");
    }

    void a(Context context, Intent intent) {
        int intExtra;
        int intExtra2;
        int intExtra3;
        if ("android.bluetooth.headset.action.AUDIO_STATE_CHANGED".equals(intent.getAction())) {
            intExtra = intent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
            intExtra2 = intent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
            intExtra3 = intent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "++ AUDIO_STATE_CHANGED|  STATE " + intExtra);
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "       PREVIOUS_STATE " + intExtra2);
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "       AUDIO_STATE " + intExtra3);
            }
            if (intExtra3 == 2) {
                this.f.a("DEVICE_BLUETOOTHHEADSET", true);
            } else if (intExtra3 == 0) {
                this.f.a("DEVICE_BLUETOOTHHEADSET", false);
            }
        } else if ("android.bluetooth.headset.action.STATE_CHANGED".equals(intent.getAction())) {
            intExtra = intent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
            intExtra2 = intent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
            intExtra3 = intent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "++ STATE_CHANGED|  STATE " + intExtra);
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "       PREVIOUS_STATE " + intExtra2);
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "       AUDIO_STATE " + intExtra3);
            }
            if (intExtra3 == 2) {
                this.f.a("DEVICE_BLUETOOTHHEADSET", true);
            } else if (intExtra3 == 0) {
                this.f.a("DEVICE_BLUETOOTHHEADSET", false);
            }
        }
    }

    public String c() {
        return "BluetoohHeadsetCheckFor2x";
    }
}
