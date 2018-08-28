package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class f$b extends a {
    final /* synthetic */ f juX;

    private f$b(f fVar) {
        this.juX = fVar;
    }

    /* synthetic */ f$b(f fVar, byte b) {
        this(fVar);
    }

    public final boolean execute() {
        StringBuffer stringBuffer = new StringBuffer();
        long length = d.aPS().length();
        e.jqL.jqN = length / 1048576;
        stringBuffer.append("[DBSize]=" + bi.gc(length));
        stringBuffer.append("\n");
        e.jqL.jqO = aQs();
        e.jqL.jqP = aQt();
        e.jqL.jqR = aQq();
        e.jqL.jqQ = aQr();
        ((n) g.n(n.class)).getFTSIndexDB().t(-301, e.jqL.jqO);
        ((n) g.n(n.class)).getFTSIndexDB().t(-302, e.jqL.jqP);
        ((n) g.n(n.class)).getFTSIndexDB().t(-303, e.jqL.jqR);
        ((n) g.n(n.class)).getFTSIndexDB().t(-304, e.jqL.jqQ);
        stringBuffer.append("[WXContact]=" + e.jqL.jqO);
        stringBuffer.append("\n");
        stringBuffer.append("[WXChatroom]=" + e.jqL.jqP);
        stringBuffer.append("\n");
        stringBuffer.append("[Favorite]=" + e.jqL.jqR);
        stringBuffer.append("\n");
        stringBuffer.append("[Message]=" + e.jqL.jqQ);
        String stringBuffer2 = stringBuffer.toString();
        x.i("MicroMsg.FTS.FTSSearchTestLogic", stringBuffer2);
        File file = new File(c.jqx, "FTS5IndexMicroMsgInfo.txt");
        if (file.exists()) {
            file.delete();
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        int l = FileOp.l(file.getAbsolutePath(), stringBuffer2.getBytes());
        x.i("MicroMsg.FTS.FTSSearchTestLogic", "write fts info %d %s", new Object[]{Integer.valueOf(l), file.getAbsolutePath()});
        return true;
    }

    private static long aQq() {
        Cursor rawQuery = ((n) g.n(n.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE subtype = %d", new Object[]{"FTS5MetaFavorite", Integer.valueOf(9)}), null);
        try {
            if (rawQuery.moveToNext()) {
                long j = rawQuery.getLong(0);
                return j;
            }
            rawQuery.close();
            return 0;
        } finally {
            rawQuery.close();
        }
    }

    private static long aQr() {
        Cursor rawQuery = ((n) g.n(n.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s", new Object[]{"FTS5MetaMessage"}), null);
        try {
            if (rawQuery.moveToNext()) {
                long j = rawQuery.getLong(0);
                return j;
            }
            rawQuery.close();
            return 0;
        } finally {
            rawQuery.close();
        }
    }

    private static long aQs() {
        Cursor rawQuery = ((n) g.n(n.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[]{"FTS5MetaContact", Integer.valueOf(131072), Integer.valueOf(1)}), null);
        try {
            if (rawQuery.moveToNext()) {
                long j = rawQuery.getLong(0);
                return j;
            }
            rawQuery.close();
            return 0;
        } finally {
            rawQuery.close();
        }
    }

    private static long aQt() {
        Cursor rawQuery = ((n) g.n(n.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[]{"FTS5MetaContact", Integer.valueOf(131075), Integer.valueOf(38)}), null);
        try {
            if (rawQuery.moveToNext()) {
                long j = rawQuery.getLong(0);
                return j;
            }
            rawQuery.close();
            return 0;
        } finally {
            rawQuery.close();
        }
    }

    public final String getName() {
        return "FTS5DBInfoTask";
    }
}
