package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.m;
import java.io.InputStream;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class WxaCommLibRuntimeReader {
    private static c fgw;
    private static Future<Object> fgx;
    private static final ThreadPoolExecutor fgy = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());

    public static synchronized void abM() {
        synchronized (WxaCommLibRuntimeReader.class) {
            try {
                kS();
                if (fgw == null) {
                    fgw = a.fgA;
                }
            } catch (Throwable th) {
                if (fgw == null) {
                    fgw = a.fgA;
                }
            }
        }
    }

    public static synchronized void kS() {
        synchronized (WxaCommLibRuntimeReader.class) {
            if (fgw != null) {
                x.i("MicroMsg.WxaCommLibRuntimeReader", "load(), sReader %s loaded", new Object[]{fgw});
            } else if (af.abU()) {
                fgw = a.fgA;
                x.i("MicroMsg.WxaCommLibRuntimeReader", "load(), forceLocal, use AssetReader");
            } else if (ad.cig()) {
                try {
                    if (fgx != null) {
                        x.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), wait for existing retriever");
                    } else {
                        x.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), new retriever");
                        fgx = fgy.submit(new 1());
                    }
                    String str = fgx.get(5, TimeUnit.SECONDS);
                    if (str instanceof WxaPkgWrappingInfo) {
                        WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) str;
                        fgw = wxaPkgWrappingInfo.fik ? a.fgA : new d(wxaPkgWrappingInfo, (byte) 0);
                    } else if (str instanceof AccountNotReadyError) {
                        throw ((AccountNotReadyError) str);
                    } else if (str instanceof Exception) {
                        throw ((Exception) str);
                    } else {
                        throw new IllegalArgumentException(new StringBuilder("Unknown result ").append(null).toString() == str ? "null" : str.getClass().getName());
                    }
                } catch (Throwable th) {
                    fgx.cancel(false);
                    fgx = null;
                }
            } else {
                x.e("MicroMsg.WxaCommLibRuntimeReader", "load(), mm process not exists");
                throw new AccountNotReadyError();
            }
        }
    }

    public static synchronized boolean abN() {
        boolean z = true;
        synchronized (WxaCommLibRuntimeReader.class) {
            x.i("MicroMsg.WxaCommLibRuntimeReader", "loaded(), reader %s", new Object[]{fgw});
            if (fgw == null) {
                z = false;
            }
        }
        return z;
    }

    private static synchronized c abO() {
        c cVar;
        synchronized (WxaCommLibRuntimeReader.class) {
            if (fgw == null) {
                abM();
            }
            cVar = fgw;
        }
        return cVar;
    }

    static InputStream qI(String str) {
        if (bi.oW(str)) {
            return null;
        }
        InputStream openRead = abO().openRead(str);
        String format = String.format(Locale.US, "[v%d | %d | %s | %b]", new Object[]{Integer.valueOf(r1.abQ().fii), Integer.valueOf(r1.abQ().fih), bi.gb(r1.abQ().fij), Boolean.valueOf(r1.abQ().fik)});
        try {
            int i;
            String str2 = "MicroMsg.WxaCommLibRuntimeReader";
            String str3 = "read %s, %s, ret %d";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = format;
            if (openRead == null) {
                i = -1;
            } else {
                i = openRead.available();
            }
            objArr[2] = Integer.valueOf(i);
            x.i(str2, str3, objArr);
            return openRead;
        } catch (Exception e) {
            x.e("MicroMsg.WxaCommLibRuntimeReader", "read %s, %s, e %s", new Object[]{str, format, e});
            return openRead;
        }
    }

    public static String qJ(String str) {
        InputStream qI = qI(str);
        if (qI == null) {
            return "";
        }
        return c.convertStreamToString(qI);
    }

    public static m qK(String str) {
        InputStream qI = qI(str);
        if (qI == null) {
            return null;
        }
        return new m(s.Ui(str), "UTF-8", qI);
    }

    public static WxaPkgWrappingInfo abP() {
        return abO().abQ();
    }
}
