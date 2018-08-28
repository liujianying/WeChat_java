package com.tencent.mm.plugin.game.gamewebview.model;

import com.tencent.mm.plugin.game.gamewebview.ui.d;
import java.util.HashMap;

public final class a {
    private static HashMap<Integer, d> jHX = new HashMap();

    public static void a(d dVar) {
        jHX.put(Integer.valueOf(dVar.hashCode()), dVar);
    }

    public static void b(d dVar) {
        jHX.remove(Integer.valueOf(dVar.hashCode()));
    }

    public static d qL(int i) {
        return (d) jHX.get(Integer.valueOf(i));
    }

    public static void cleanup() {
        jHX.clear();
    }
}
