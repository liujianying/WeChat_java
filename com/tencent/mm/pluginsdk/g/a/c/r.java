package com.tencent.mm.pluginsdk.g.a.c;

import android.annotation.SuppressLint;
import com.tencent.mm.pluginsdk.g.a.a.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public final class r {
    private static final HashMap<Integer, g> qDy;
    private static volatile List<g> qDz = null;

    static {
        HashMap hashMap = new HashMap(2);
        qDy = hashMap;
        hashMap.put(Integer.valueOf("CheckResUpdatePlugin".hashCode()), new a());
        try {
            qDy.put(Integer.valueOf("WebViewCacheDownload".hashCode()), (g) Class.forName("com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper$ResDownloaderPlugin").newInstance());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ResDownloaderPluginMap", e, "", new Object[0]);
        }
    }

    public static void init() {
    }

    public static Collection<g> ccI() {
        if (qDz != null) {
            return qDz;
        }
        List linkedList = new LinkedList();
        for (Integer intValue : qDy.keySet()) {
            g gVar = (g) qDy.get(Integer.valueOf(intValue.intValue()));
            if (gVar != null) {
                linkedList.add(gVar);
            }
        }
        qDz = linkedList;
        return linkedList;
    }
}
