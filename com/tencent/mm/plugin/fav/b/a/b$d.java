package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.mm.plugin.fav.b.a.b.c;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.sdk.platformtools.x;

class b$d extends a {
    final /* synthetic */ b iXs;
    private long iXx;
    private int iXz;

    /* synthetic */ b$d(b bVar, long j, byte b) {
        this(bVar, j);
    }

    private b$d(b bVar, long j) {
        this.iXs = bVar;
        this.iXx = j;
    }

    public final boolean execute() {
        if (this.iXs.iXq == null) {
            x.e("MicroMsg.FTS.FTS5SearchFavoriteLogic", "InsertFavItemTask: fav db is null");
        } else {
            x.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to insert favorite item");
            Cursor b = this.iXs.iXq.b("SELECT localId, type, updateTime, fromUser, favProto, tagProto FROM FavItemInfo WHERE localId = ? AND flag <> -1;", new String[]{String.valueOf(this.iXx)}, 2);
            try {
                if (b.moveToFirst()) {
                    c cVar = new c(this.iXs, (byte) 0);
                    cVar.d(b);
                    b.close();
                    b = null;
                    this.iXs.iXp.beginTransaction();
                    this.iXs.iXp.b(com.tencent.mm.plugin.fts.a.c.jqd, this.iXx);
                    this.iXz = b.a(this.iXs, cVar);
                    this.iXs.iXp.commit();
                }
                if (b != null) {
                    b.close();
                }
            } catch (Exception e) {
                throw e;
            } catch (Throwable th) {
                if (b != null) {
                    b.close();
                }
            }
        }
        return true;
    }

    public final String afC() {
        return String.format("{favItemId: %d transactionCount: %d}", new Object[]{Long.valueOf(this.iXx), Integer.valueOf(this.iXz)});
    }

    public final String getName() {
        return "InsertFavItemTask";
    }
}
