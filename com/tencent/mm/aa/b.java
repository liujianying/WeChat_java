package com.tencent.mm.aa;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.wcdb.DefaultDatabaseErrorHandler;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteOpenHelper;

public final class b extends SQLiteOpenHelper {
    public b() {
        super(ad.getContext(), g.Ei().cachePath + "AuxData.db", null, 1, new DefaultDatabaseErrorHandler(true));
        setWriteAheadLoggingEnabled(true);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS AvatarFile (fileName TEXT PRIMARY KEY, accessTime INTEGER) WITHOUT ROWID");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.enableWriteAheadLogging();
        sQLiteDatabase.setAsyncCheckpointEnabled(true);
    }
}
