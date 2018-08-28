package com.tencent.mm.plugin.music.b.a;

import android.text.TextUtils;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;

class a$2 implements ISoLibraryLoader {
    a$2() {
    }

    public final boolean load(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary lib_name is null");
            return false;
        } else if (k.fg(str)) {
            return true;
        } else {
            x.i("MicroMsg.Audio.AudioPlayerUtils", "load library %s", new Object[]{str});
            ClassLoader classLoader = a.class.getClassLoader();
            if (TextUtils.isEmpty(k.fh(str))) {
                x.e("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary can't find the lib %s so", new Object[]{str});
                return false;
            }
            x.i("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary find and load the lib %s so", new Object[]{k.fh(str)});
            k.b(str, classLoader);
            return true;
        }
    }
}
