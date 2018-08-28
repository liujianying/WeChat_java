package com.tencent.mm.plugin.music.d;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class a {
    public static String IE(String str) {
        return "piece" + ac.ce(str.hashCode());
    }

    public static String IF(String str) {
        File file = new File(e.Gq(), "music");
        if (!file.exists()) {
            file.mkdirs();
        }
        x.d("MicroMsg.Music.MusicFileUtil", "getMusicPieceFilePath music name %s path %s", new Object[]{IE(str), new File(file, IE(str)).getAbsoluteFile()});
        return new File(file, IE(str)).getAbsolutePath();
    }

    public static String x(avq avq) {
        if (avq.rYj == 6) {
            return "6_" + ac.ce(avq.rsp);
        }
        return "0_" + ac.ce(avq.rsp);
    }

    public static String g(com.tencent.mm.an.a aVar, boolean z) {
        File file = new File(g.Ei().dqp, "music");
        if (!file.exists()) {
            x.i("MicroMsg.Music.MusicFileUtil", "create file folder:%b for path:%s", new Object[]{Boolean.valueOf(file.mkdirs()), file.getAbsolutePath()});
        }
        x.d("MicroMsg.Music.MusicFileUtil", "music name %s path %s", new Object[]{z ? ac.ce(aVar.field_musicId + "temp") + "-wifi" : ac.ce(aVar.field_musicId + "temp"), new File(file, z ? ac.ce(aVar.field_musicId + "temp") + "-wifi" : ac.ce(aVar.field_musicId + "temp")).getAbsoluteFile()});
        return new File(file, z ? ac.ce(aVar.field_musicId + "temp") + "-wifi" : ac.ce(aVar.field_musicId + "temp")).getAbsolutePath();
    }

    public static String h(com.tencent.mm.an.a aVar, boolean z) {
        return g(aVar, false) + "-thumb-" + z;
    }
}
