package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsReaderView$ReaderCallback;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;

public class ee {
    private boolean a;

    public ee(boolean z) {
        this.a = z;
    }

    public static fp a(gd gdVar) {
        fv fvVar = new fv(gdVar);
        try {
            fvVar.i();
        } catch (Exception e) {
            fvVar.b = -2;
            fvVar.c = fz.a(e);
        }
        return fvVar;
    }

    public static String a(String str) {
        return !TextUtils.isEmpty(str) ? str.replace(10, ' ').replace(13, ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D") : "";
    }

    public static HashMap a(fn fnVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("B50", fnVar.d);
        hashMap.put("B51", a(fnVar.g));
        hashMap.put("B69", a(fnVar.e));
        hashMap.put("B52", fnVar.h);
        hashMap.put("B53", a(fnVar.j));
        hashMap.put("B54", fnVar.k);
        hashMap.put("B55", fnVar.m);
        hashMap.put("B56", fnVar.n);
        if (!TextUtils.isEmpty(fnVar.o)) {
            hashMap.put("B57", a(fnVar.o));
        }
        if (!(TextUtils.isEmpty(fnVar.p) || fnVar.p.equals("null"))) {
            hashMap.put("B58", a(fnVar.p));
        }
        hashMap.put("B59", fnVar.q);
        hashMap.put("B63", fnVar.z);
        hashMap.put("B60", fnVar.r);
        hashMap.put("B61", fnVar.s);
        hashMap.put("B62", fnVar.t);
        hashMap.put("B71", fnVar.w);
        hashMap.put("B76", fnVar.x);
        return hashMap;
    }

    public static boolean a(String str, int i, int i2) {
        Throwable th;
        boolean z = false;
        Socket socket;
        try {
            socket = new Socket();
            try {
                socket.connect(new InetSocketAddress(str, 80), TbsReaderView$ReaderCallback.GET_BAR_ANIMATING);
                if (socket.isConnected()) {
                    z = true;
                }
                try {
                    socket.close();
                } catch (Throwable th2) {
                }
            } catch (Throwable th3) {
                th = th3;
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Throwable th4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            socket = null;
            if (socket != null) {
                try {
                    socket.close();
                } catch (Throwable th42) {
                }
            }
            throw th;
        }
        return z;
    }

    public final boolean a() {
        return this.a;
    }
}
