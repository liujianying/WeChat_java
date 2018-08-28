package com.tencent.mm.plugin.appbrand.media.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.audio.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private static Map<String, c> ghJ = new ConcurrentHashMap();
    private static Map<String, c> ghK = new HashMap();
    private static ArrayList<String> ghL = new ArrayList();

    public static void onCreate(String str) {
        x.i("MicroMsg.Audio.AppBrandAudioClientService", "onCreate");
        ghJ.clear();
        b.onCreate(str);
    }

    public static void Pa(String str) {
        x.i("MicroMsg.Audio.AppBrandAudioClientService", "onDestroy");
        b.Pa(str);
        ghJ.clear();
        Iterator it = ghL.iterator();
        while (it.hasNext()) {
            c cVar = (c) ghK.remove((String) it.next());
            if (cVar != null) {
                com.tencent.mm.sdk.b.a.sFg.c(cVar);
            }
        }
        ghK.clear();
        ghL.clear();
    }

    public static void a(String str, c cVar) {
        ghJ.put(str, cVar);
    }

    public static c ur(String str) {
        return (c) ghJ.get(str);
    }

    public static void a(String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.Audio.AppBrandAudioClientService", "appId is empty");
        } else if (cVar == null) {
            x.e("MicroMsg.Audio.AppBrandAudioClientService", "listener is null");
        } else {
            if (ghK.containsKey(str)) {
                us(str);
            }
            x.d("MicroMsg.Audio.AppBrandAudioClientService", "addAudioPlayerListener,appId:%s", new Object[]{str});
            ghK.put(str, cVar);
            if (!ghL.contains(str)) {
                ghL.add(str);
            }
            com.tencent.mm.sdk.b.a.sFg.a(cVar);
        }
    }

    public static void us(String str) {
        if (ghK.containsKey(str)) {
            x.d("MicroMsg.Audio.AppBrandAudioClientService", "removeAudioPlayerListener,appId:%s", new Object[]{str});
            ghL.remove(str);
            c cVar = (c) ghK.remove(str);
            if (cVar != null) {
                com.tencent.mm.sdk.b.a.sFg.c(cVar);
                return;
            }
            return;
        }
        x.e("MicroMsg.Audio.AppBrandAudioClientService", "appId:%s not exist the appId for listener", new Object[]{str});
    }
}
