package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.g.c.ec;
import com.tencent.mm.sdk.e.i;
import java.util.concurrent.ConcurrentHashMap;

public final class bt extends i<ec> {
    public static final String[] diD = new String[]{i.a(bs.dhO, "TablesVersion")};
    public h dCZ;

    public bt(h hVar) {
        super(hVar, bs.dhO, "TablesVersion", ec.ciG);
        this.dCZ = hVar;
    }

    public final ConcurrentHashMap<Integer, String> cnb() {
        Cursor b = this.dCZ.b("select * from TablesVersion", new String[0], 0);
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap();
        if (b != null) {
            while (b.moveToNext()) {
                try {
                    concurrentHashMap.putIfAbsent(Integer.valueOf(b.getInt(0)), b.getString(1));
                } finally {
                    b.close();
                }
            }
        }
        return concurrentHashMap;
    }
}
