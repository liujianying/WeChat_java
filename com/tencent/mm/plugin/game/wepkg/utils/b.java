package com.tencent.mm.plugin.game.wepkg.utils;

import com.tencent.mm.compatible.util.e;
import java.util.HashSet;
import java.util.Set;

public final class b {
    public static final String OBJECT_ROOT_DIR_PATH;
    public static final Set<Integer> kgj = new HashSet();
    public static a kgk = new a();
    public static boolean kgl = false;

    static {
        String str = e.bnE;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        OBJECT_ROOT_DIR_PATH = str + "wepkg/pkgfiles/";
    }
}
