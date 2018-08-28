package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public abstract class c {
    public j fEE = new j();
    private final AtomicInteger fEF = new AtomicInteger(0);
    private final SparseArray<a> fEG = new SparseArray();
    public boolean fEH = false;

    public abstract void a(String str, String str2, int[] iArr);

    public abstract b aaI();

    public abstract Context getContext();

    public abstract g getRuntime();

    public abstract boolean isRunning();

    public void j(String str, String str2, int i) {
        if (bi.oW(str2)) {
            str2 = "{}";
        }
        x.d("MicroMsg.AppBrandComponent", "dispatch, event: %s, data size: %s, srcId: %d", new Object[]{str, Integer.valueOf(str2.length()), Integer.valueOf(i)});
        b aaI = aaI();
        String str3 = "typeof WeixinJSCoreAndroid !== 'undefined' && WeixinJSCoreAndroid.subscribeHandler(\"%s\", %s, %s, %s)";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = i == 0 ? "undefined" : String.valueOf(i);
        objArr[3] = Db();
        aaI.evaluateJavascript(String.format(str3, objArr), null);
    }

    public void E(int i, String str) {
        if (isRunning()) {
            if (bi.oW(str)) {
                str = "{}";
            }
            x.d("MicroMsg.AppBrandComponent", "callbackId: %d, data size: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(str.length())});
            a kx = kx(i);
            if (kx == null) {
                x.e("MicroMsg.AppBrandComponent", "callbackid = [%d] This is a Sync Api, No callback runtime stored.");
                return;
            }
            kx.fEI.evaluateJavascript(String.format("typeof WeixinJSCoreAndroid !== 'undefined' && WeixinJSCoreAndroid.invokeCallbackHandler(%d, %s)", new Object[]{Integer.valueOf(kx.id), str}), null);
            this.fEE.H(i, str);
            return;
        }
        x.e("MicroMsg.AppBrandComponent", "callback but destroyed, callbackId %d", new Object[]{Integer.valueOf(i)});
    }

    public static String Db() {
        Map hashMap = new HashMap();
        hashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
        return new JSONObject(hashMap).toString();
    }

    public String getAppId() {
        return getRuntime().mAppId;
    }

    public void cleanup() {
        synchronized (this.fEG) {
            this.fEG.clear();
        }
    }

    public int a(b bVar, int i) {
        if (i == 0) {
            return 0;
        }
        int incrementAndGet = this.fEF.incrementAndGet();
        synchronized (this.fEG) {
            this.fEG.put(incrementAndGet, new a(bVar, i));
        }
        return incrementAndGet;
    }

    private a kx(int i) {
        a aVar;
        synchronized (this.fEG) {
            aVar = (a) this.fEG.get(i);
        }
        return aVar;
    }

    public void onResume() {
    }

    public String aeI() {
        return null;
    }
}
