package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class l extends h {
    private static final int CTRL_INDEX = 153;
    private static final String NAME = "onNetworkStatusChange";
    private static l fFl;
    private static HashSet<String> fFm = new HashSet();

    public static synchronized void tk(String str) {
        synchronized (l.class) {
            fFm.add(str);
        }
    }

    public static synchronized void tl(String str) {
        synchronized (l.class) {
            fFm.remove(str);
        }
    }

    public static synchronized void onNetworkChange() {
        synchronized (l.class) {
            HashMap hashMap = new HashMap();
            Context context = ad.getContext();
            boolean isConnected = ao.isConnected(context);
            hashMap.put("isConnected", Boolean.valueOf(isConnected));
            if (!isConnected) {
                hashMap.put("networkType", "none");
            } else if (ao.is2G(context)) {
                hashMap.put("networkType", "2g");
            } else if (ao.is3G(context)) {
                hashMap.put("networkType", "3g");
            } else if (ao.is4G(context)) {
                hashMap.put("networkType", "4g");
            } else if (ao.isWifi(context)) {
                hashMap.put("networkType", "wifi");
            } else {
                hashMap.put("networkType", "unknown");
            }
            Iterator it = fFm.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (fFl == null) {
                    fFl = new l();
                }
                fFl.aC(str, 0).x(hashMap).ahM();
            }
        }
    }
}
