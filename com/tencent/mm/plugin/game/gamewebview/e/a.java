package com.tencent.mm.plugin.game.gamewebview.e;

import com.tencent.mm.protocal.c.aoc;
import java.util.HashMap;

public final class a {
    private static final HashMap<String, aoc> jKH = new HashMap();

    public static boolean bI(String str, String str2) {
        aoc aoc = (aoc) jKH.get(str + "#" + str2);
        if (aoc == null || aoc.reL != 1) {
            return false;
        }
        return true;
    }
}
