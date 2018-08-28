package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiConfiguration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.Proxy;

public final class a {
    private com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a gdF;
    public Context gdG;
    a gdH = null;
    b gdI = null;
    public WifiConfiguration gdJ = null;
    ConnectivityManager gdK;
    private int gdL = 0;
    private final int gdM = 13000;
    public boolean gdr = false;
    public BroadcastReceiver gds = null;
    public String gdv;
    public String gdw;
    public Handler mHandler = null;

    private static Object a(a aVar, String str) {
        return Proxy.newProxyInstance(Class.forName(str).getClassLoader(), new Class[]{r0}, aVar);
    }

    public a(com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a aVar, Context context) {
        this.gdF = aVar;
        this.gdG = context;
        try {
            this.gdK = (ConnectivityManager) this.gdG.getSystemService("connectivity");
        } catch (Exception e) {
        }
        this.mHandler = new Handler(context.getMainLooper()) {
            public final void handleMessage(Message message) {
                if (message != null) {
                    switch (message.what) {
                        case 1:
                            if (!a.this.akx()) {
                                a.this.ui("fail to connect wifi:time out");
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        };
    }

    public final boolean a(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration == null || wifiConfiguration.networkId == d.gdP || this.gdK == null) {
            return false;
        }
        try {
            Class cls = Class.forName("android.net.wifi.WifiManager");
            String str;
            Object a;
            Class cls2;
            if (VERSION.SDK_INT < 16) {
                cls.getMethod("asyncConnect", new Class[]{Context.class, Handler.class}).invoke(c.bgP, new Object[]{this.gdG, this.mHandler});
                cls.getMethod("connectNetwork", new Class[]{Integer.TYPE}).invoke(c.bgP, new Object[]{Integer.valueOf(wifiConfiguration.networkId)});
                return true;
            } else if (VERSION.SDK_INT == 16) {
                str = "android.net.wifi.WifiManager$ChannelListener";
                if (this.gdI == null) {
                    this.gdI = new b(this);
                }
                a = a(this.gdH, str);
                cls2 = Class.forName(str);
                Object invoke = cls.getMethod("initialize", new Class[]{Context.class, Looper.class, cls2}).invoke(c.bgP, new Object[]{this.gdG, this.gdG.getMainLooper(), a});
                String str2 = "android.net.wifi.WifiManager$ActionListener";
                if (this.gdH == null) {
                    this.gdH = new a(this);
                }
                Object a2 = a(this.gdH, str2);
                Class cls3 = Class.forName(str2);
                cls.getMethod("connect", new Class[]{Class.forName("android.net.wifi.WifiManager$Channel"), Integer.TYPE, cls3}).invoke(c.bgP, new Object[]{invoke, Integer.valueOf(wifiConfiguration.networkId), a2});
                return true;
            } else {
                if (this.gdH == null) {
                    this.gdH = new a(this);
                }
                str = "android.net.wifi.WifiManager$ActionListener";
                a = a(this.gdH, str);
                cls2 = Class.forName(str);
                cls.getMethod("connect", new Class[]{Integer.TYPE, cls2}).invoke(c.bgP, new Object[]{Integer.valueOf(wifiConfiguration.networkId), a});
                return true;
            }
        } catch (Exception e) {
            return c.lb(wifiConfiguration.networkId);
        }
    }

    public final boolean akx() {
        return this.gdL == 3 || this.gdL == 2;
    }

    public final void ui(String str) {
        if (this.gdJ != null) {
            b.la(this.gdJ.networkId);
            g(false, str);
            new StringBuilder("cancelConnect, ").append(d.uj(this.gdJ.SSID)).append(" networkId:").append(this.gdJ.networkId);
        }
    }

    public final void kZ(int i) {
        if (this.gdL != i) {
            String str;
            this.gdL = i;
            StringBuilder stringBuilder = new StringBuilder("switchState:");
            switch (this.gdL) {
                case 0:
                    str = "STATE_NONE";
                    break;
                case 1:
                    str = "STATE_CONNECTING";
                    break;
                case 2:
                    str = "STATE_CONNECTED";
                    break;
                case 3:
                    str = "STATE_FAIL";
                    break;
                default:
                    str = "UnknowState";
                    break;
            }
            stringBuilder.append(str);
        }
    }

    public final void g(boolean z, String str) {
        if (!akx()) {
            if (this.gdF != null) {
                com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a aVar = this.gdF;
                if (z) {
                    str = "ok";
                }
                aVar.uh(str);
            }
            this.mHandler.removeMessages(1);
            if (this.gdr) {
                this.gdG.unregisterReceiver(this.gds);
                this.gdr = false;
            }
            kZ(z ? 2 : 3);
            if (!z && this.gdJ != null) {
                b.la(this.gdJ.networkId);
            }
        }
    }
}
