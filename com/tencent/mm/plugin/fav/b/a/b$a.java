package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;

class b$a extends a {
    final /* synthetic */ b iXs;
    private HashSet<Long> iXt;
    private int iXu;
    private int iXv;
    private int iXw;
    private int mFailedCount;

    private b$a(b bVar) {
        this.iXs = bVar;
        this.iXt = null;
        this.iXu = 0;
        this.iXv = 0;
        this.iXw = 0;
        this.mFailedCount = 0;
    }

    /* synthetic */ b$a(b bVar, byte b) {
        this(bVar);
    }

    public final boolean execute() {
        Exception e;
        Throwable th;
        if (this.iXs.iXq == null) {
            x.w("MicroMsg.FTS.FTS5SearchFavoriteLogic", "favorite db is null, you need to wait the favorite db event!");
        } else {
            x.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to build favorite index!");
            if (this.iXt == null) {
                this.iXt = new HashSet();
                Cursor a;
                try {
                    a = this.iXs.iXp.a(c.jqd, false, true, false, false, false);
                    while (a.moveToNext()) {
                        try {
                            this.iXt.add(Long.valueOf(a.getLong(0)));
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                throw e;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                    if (a != null) {
                        a.close();
                    }
                    this.iXu = this.iXt.size();
                } catch (Exception e3) {
                    e = e3;
                    a = null;
                } catch (Throwable th3) {
                    th = th3;
                    a = null;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            int i;
            Cursor rawQuery = this.iXs.iXq.rawQuery("SELECT localId, type, updateTime, fromUser, favProto, tagProto FROM FavItemInfo WHERE flag <> -1;", null);
            int i2 = 50;
            while (rawQuery.moveToNext()) {
                try {
                    if (Thread.interrupted()) {
                        this.iXs.iXp.commit();
                        throw new InterruptedException();
                    }
                    b.c cVar = new b.c(this.iXs, (byte) 0);
                    cVar.d(rawQuery);
                    if (!this.iXt.remove(Long.valueOf(cVar.dTK))) {
                        if (i2 >= 50) {
                            this.iXs.iXp.commit();
                            this.iXs.iXp.beginTransaction();
                            i = 0;
                        } else {
                            i = i2;
                        }
                        try {
                            i += b.a(this.iXs, cVar);
                            this.iXv++;
                            i2 = i;
                        } catch (Throwable th4) {
                            x.printErrStackTrace("MicroMsg.FTS.FTS5SearchFavoriteLogic", th4, "Build favorite index failed with exception.\n", new Object[0]);
                            this.mFailedCount++;
                            i2 = i;
                        }
                    }
                } catch (Exception e4) {
                    throw e4;
                } catch (Throwable th5) {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            this.iXs.iXp.commit();
            Iterator it = this.iXt.iterator();
            while (it.hasNext()) {
                if (Thread.interrupted()) {
                    this.iXs.iXp.commit();
                    throw new InterruptedException();
                }
                if (i2 >= 50) {
                    this.iXs.iXp.commit();
                    this.iXs.iXp.beginTransaction();
                    i = 0;
                } else {
                    i = i2;
                }
                this.iXs.iXp.b(c.jqd, ((Long) it.next()).longValue());
                i2 = i + 1;
                this.iXw++;
                it.remove();
            }
            this.iXs.iXp.commit();
        }
        return true;
    }

    public final String afC() {
        return String.format("{new: %d exist: %d removed: %d failed: %d}", new Object[]{Integer.valueOf(this.iXv), Integer.valueOf(this.iXu), Integer.valueOf(this.iXw), Integer.valueOf(this.mFailedCount)});
    }

    public final String getName() {
        return "BuildFavoriteIndexTask";
    }

    public final int getId() {
        return 6;
    }
}
