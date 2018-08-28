package com.tencent.c.e.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import com.tencent.c.e.a.a.c;
import com.tencent.c.e.a.a.k;
import com.tencent.c.f.f;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class e$a extends c {
    int mCount;
    int mMaxCount;
    final /* synthetic */ e vjJ;
    long vjP;

    private e$a(e eVar) {
        this.vjJ = eVar;
        this.mCount = 1;
        this.mMaxCount = 3;
        this.vjP = 0;
    }

    /* synthetic */ e$a(e eVar, byte b) {
        this(eVar);
    }

    public final void cFm() {
        k kVar = new k();
        synchronized (this.vjJ) {
            Object systemService;
            int i;
            Context context = e.a(this.vjJ).context;
            try {
                if (VERSION.SDK_INT >= 20) {
                    Class cls = Class.forName("android.hardware.display.DisplayManager");
                    Field field = context.getClass().getField("DISPLAY_SERVICE");
                    field.setAccessible(true);
                    systemService = context.getSystemService((String) field.get(context));
                    if (systemService == null) {
                        i = 0;
                    } else {
                        Method method = cls.getMethod("getDisplays", new Class[0]);
                        if (method == null) {
                            i = 0;
                        } else {
                            method.setAccessible(true);
                            Display[] displayArr = (Display[]) method.invoke(systemService, new Object[0]);
                            Method method2 = Display.class.getMethod("getState", new Class[0]);
                            method2.setAccessible(true);
                            Field field2 = Display.class.getField("STATE_OFF");
                            field2.setAccessible(true);
                            int length = displayArr.length;
                            int i2 = 0;
                            Object obj = null;
                            while (i2 < length) {
                                Object obj2 = displayArr[i2];
                                if (((Integer) method2.invoke(obj2, new Object[0])).intValue() != field2.getInt(obj2)) {
                                    obj2 = 1;
                                } else {
                                    obj2 = obj;
                                }
                                i2++;
                                obj = obj2;
                            }
                            kVar.vki = obj != null ? 1 : 2;
                            i = kVar.vki;
                        }
                    }
                    kVar.vki = i;
                } else {
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    if (powerManager != null) {
                        kVar.vki = powerManager.isScreenOn() ? 1 : 2;
                    }
                }
            } catch (Throwable th) {
            }
            CharSequence Y = f.Y(new File("/sys/class/android_usb/android0/state"));
            if (!TextUtils.isEmpty(Y)) {
                if ("CONFIGURED".equals(Y)) {
                    kVar.vkk = 1;
                } else if ("DISCONNECTED".equals(Y)) {
                    kVar.vkk = 2;
                } else if ("CONNECTED".equals(Y)) {
                    kVar.vkk = 3;
                }
            }
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                i = registerReceiver.getIntExtra("status", -1);
                systemService = (i == 2 || i == 5) ? 1 : null;
                if (systemService == null) {
                    kVar.vkl = 1;
                } else {
                    i = registerReceiver.getIntExtra("plugged", -1);
                    if (i == 2) {
                        kVar.vkl = 3;
                    } else if (i == 1) {
                        kVar.vkl = 2;
                    } else {
                        kVar.vkl = 0;
                    }
                }
            }
        }
        synchronized (e.b(this.vjJ)) {
            e.b(this.vjJ).add(kVar);
        }
        if (this.mCount >= this.mMaxCount) {
            synchronized (this.vjJ) {
                if (e.c(this.vjJ)) {
                    this.vjJ.wk();
                    return;
                }
                return;
            }
        }
        this.mCount++;
        long currentTimeMillis = (this.vjP + (com.tencent.c.e.a.a.f.vjS * ((long) this.mCount))) - System.currentTimeMillis();
        if (currentTimeMillis > 0) {
            e.e(this.vjJ).postDelayed(e.d(this.vjJ), currentTimeMillis);
        } else {
            e.e(this.vjJ).post(e.d(this.vjJ));
        }
    }

    public final void cFn() {
        if (e.f(this.vjJ) != null) {
            e.f(this.vjJ);
        }
    }
}
