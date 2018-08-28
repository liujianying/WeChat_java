package com.tencent.mm.plugin.music.d;

import android.net.Uri;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static boolean IG(String str) {
        if (bi.oW(str)) {
            return false;
        }
        boolean contains;
        Uri parse = Uri.parse(str);
        String str2 = "";
        if (parse != null) {
            str2 = parse.getHost();
        }
        if (str2 != null) {
            contains = parse.getHost().contains(".qq.com");
            x.w("MicroMsg.Music.MusicUrlUtil", "url %s match ? %B", new Object[]{str, Boolean.valueOf(contains)});
        } else {
            x.i("MicroMsg.Music.MusicUrlUtil", "host is null, url is not match .qq.com");
            contains = false;
        }
        return contains;
    }
}
