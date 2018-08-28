package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Bundle;
import com.tencent.mm.model.au;
import com.tencent.mm.network.n;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map.Entry;

public final class a {
    private static HashMap<Integer, GameMMToClientEvent> fEx = new HashMap();
    private static n jkm;

    static {
        1 1 = new 1();
        jkm = 1;
        au.a(1);
    }

    public static void a(int i, GameMMToClientEvent gameMMToClientEvent) {
        fEx.put(Integer.valueOf(i), gameMMToClientEvent);
    }

    public static void qK(int i) {
        fEx.remove(Integer.valueOf(i));
    }

    public static synchronized void z(Bundle bundle) {
        synchronized (a.class) {
            x.d("MicroMsg.GameMMToClientEventCenter", "notifyToAllClint");
            for (Entry entry : fEx.entrySet()) {
                GameMMToClientEvent gameMMToClientEvent = (GameMMToClientEvent) entry.getValue();
                if (gameMMToClientEvent != null) {
                    gameMMToClientEvent.jGg = ((Integer) entry.getKey()).intValue();
                    gameMMToClientEvent.jfZ = bundle;
                    gameMMToClientEvent.ahH();
                }
            }
        }
    }
}
