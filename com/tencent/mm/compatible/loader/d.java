package com.tencent.mm.compatible.loader;

import android.content.Context;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class d {
    private static Map<String, String> dfN;

    public static String y(Context context, String str) {
        long VF = bi.VF();
        if (dfN == null) {
            try {
                Map Wi = q.Wi(bi.convertStreamToString(context.getAssets().open("preload/libraries.ini")));
                x.v("MicroMsg.PluginClassLoader", "libraries.ini content\n%s", r0);
                if (Wi == null || Wi.size() <= 0) {
                    x.e("MicroMsg.PluginClassLoader", "parse libraries.ini failed");
                } else {
                    dfN = new HashMap(Wi.size());
                    for (Entry entry : Wi.entrySet()) {
                        x.d("MicroMsg.PluginClassLoader", "preload file, plugin=%s, md5=%s", entry.getKey(), entry.getValue());
                        dfN.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable e) {
                x.e("MicroMsg.PluginClassLoader", "load preload libraries failed");
                x.printErrStackTrace("MicroMsg.PluginClassLoader", e, "", new Object[0]);
            }
        }
        String absolutePath = context.getDir("lib", 0).getAbsolutePath();
        if (dfN == null) {
            x.e("MicroMsg.PluginClassLoader", "extractVoipDex preload so files loaded failed");
            return null;
        }
        String str2 = absolutePath + "/" + str;
        absolutePath = (String) dfN.get(str);
        if (absolutePath == null) {
            x.w("MicroMsg.PluginClassLoader", "extractVoipDex not in preloadfiles");
            return null;
        }
        File file = new File(str2);
        if (file.exists()) {
            String m = g.m(file);
            if (m == null || !m.equalsIgnoreCase(absolutePath)) {
                x.e("MicroMsg.PluginClassLoader", "extractVoipDex target file exists, but md5 check failed, target=%s assets=%s", m, absolutePath);
            } else {
                x.d("MicroMsg.PluginClassLoader", "extractVoipDex: targetFilePath:[%s] time:%d", file, Long.valueOf(bi.bH(VF)));
                return str2;
            }
        }
        e.deleteFile(str2);
        if (j.C(context, "preload/" + str, str2)) {
            x.i("MicroMsg.PluginClassLoader", "extractVoipDex time:%d so:%s md5:%s ", Long.valueOf(bi.bH(VF)), str, absolutePath);
            return str2;
        }
        x.f("MicroMsg.PluginClassLoader", "extractVoipDex  copyAssets failed");
        return null;
    }
}
