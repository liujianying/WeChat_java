package com.tencent.mm.bt.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteCursorDriver;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.database.SQLiteProgram;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class f extends AbstractCursor implements d {
    public static final CursorFactory FACTORY = new CursorFactory() {
        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram) {
            return new f(sQLiteCursorDriver, str, (h) sQLiteProgram);
        }

        public final SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
            return new h(sQLiteDatabase, str, cancellationSignal);
        }
    };
    private Map<String, Integer> mColumnNameMap;
    private final String[] mColumns;
    private int mCount = -1;
    private final SQLiteCursorDriver mDriver;
    private final String mEditTable;
    private final Throwable mStackTrace;
    private int pageSize = 3000;
    private final h tet;
    public a teu;
    private boolean tev;
    private b<a> tew;
    c tex;
    private boolean tey;

    public interface a {
        ArrayList<a> ae(ArrayList<Object> arrayList);

        a coc();
    }

    public f(SQLiteCursorDriver sQLiteCursorDriver, String str, h hVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("query object cannot be null");
        }
        this.mStackTrace = null;
        this.mDriver = sQLiteCursorDriver;
        this.mEditTable = str;
        this.mColumnNameMap = null;
        this.tet = hVar;
        this.mColumns = hVar.getColumnNames();
        this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
    }

    public final void Dz(int i) {
        if (i <= 15000 && i >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            this.pageSize = i;
        }
    }

    public final void lo(boolean z) {
        this.tev = z;
    }

    public final boolean onMove(int i, int i2) {
        if (!this.tev) {
            boolean z;
            if (this.tex == null) {
                cod();
            }
            c cVar = this.tex;
            int i3 = i2 / cVar.tem;
            if (cVar.tek.indexOfKey(i3) >= 0) {
                if (((Object[]) cVar.tek.get(i3))[(i2 % cVar.tem) * cVar.columnCount] != null) {
                    z = true;
                    if (!z) {
                        DB((i2 / this.pageSize) * this.pageSize);
                    }
                    this.tex.moveToPosition(i2);
                }
            }
            z = false;
            if (z) {
                DB((i2 / this.pageSize) * this.pageSize);
            }
            this.tex.moveToPosition(i2);
        } else if (this.tew == null || !this.tew.DA(i2)) {
            DB((i2 / this.pageSize) * this.pageSize);
        }
        return true;
    }

    private void cod() {
        if (this.tex == null) {
            this.tex = new c(this.mColumns, (byte) 0);
        }
    }

    public final int getCount() {
        if (this.mCount == -1) {
            this.mCount = DB(0);
            if (this.tew != null) {
                boolean z = this.mCount != -1 && this.mCount == this.tew.tef.size();
                this.tey = z;
            }
        }
        if (!this.tev || !this.tey) {
            return this.mCount;
        }
        if (this.tew == null) {
            return 0;
        }
        return this.tew.tef.size();
    }

    protected final void checkPosition() {
        super.checkPosition();
    }

    private int DB(int i) {
        if (this.tev) {
            if (this.tew == null) {
                this.tew = new b<a>() {
                    public final a coc() {
                        f fVar = f.this;
                        return fVar.teu != null ? fVar.teu.coc() : null;
                    }

                    public final ArrayList<a> ae(ArrayList<Object> arrayList) {
                        f fVar = f.this;
                        return fVar.teu != null ? fVar.teu.ae(arrayList) : null;
                    }
                };
            }
            this.tew.mStartPos = i;
            return this.tet.a(this.tew, i, this.pageSize);
        }
        cod();
        return this.tet.a(this.tex, i, this.pageSize);
    }

    public final int getColumnIndex(String str) {
        int i;
        Object str2;
        if (this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            Map hashMap = new HashMap(length, 1.0f);
            for (i = 0; i < length; i++) {
                hashMap.put(strArr[i], Integer.valueOf(i));
            }
            this.mColumnNameMap = hashMap;
        }
        i = str2.lastIndexOf(46);
        if (i != -1) {
            Exception exception = new Exception();
            Log.e("WCDB.SQLiteNewCursor", "requesting column name with table name -- " + str2, exception);
            str2 = str2.substring(i + 1);
        }
        Integer num = (Integer) this.mColumnNameMap.get(str2);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public final String[] getColumnNames() {
        return this.mColumns;
    }

    public final void deactivate() {
        super.deactivate();
        this.mDriver.cursorDeactivated();
    }

    public final void close() {
        super.close();
        synchronized (this) {
            this.tet.close();
            this.mDriver.cursorClosed();
        }
    }

    public final boolean requery() {
        boolean z = false;
        if (isClosed()) {
            return z;
        }
        synchronized (this) {
            if (this.tet.getDatabase().isOpen()) {
                if (this.tew != null) {
                    this.tew.acV();
                }
                this.mPos = -1;
                this.mCount = -1;
                this.mDriver.cursorRequeried(this);
                try {
                    return super.requery();
                } catch (IllegalStateException e) {
                    Log.w("WCDB.SQLiteNewCursor", "requery() failed " + e.getMessage(), e);
                    return z;
                }
            }
            return z;
        }
    }

    protected final void finalize() {
        try {
            if (this.tew != null) {
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final String getString(int i) {
        if (this.tev) {
            return null;
        }
        return this.tex.getString(i);
    }

    public final short getShort(int i) {
        if (this.tev) {
            return (short) 0;
        }
        return this.tex.getShort(i);
    }

    public final int getInt(int i) {
        if (this.tev) {
            return 0;
        }
        return this.tex.getInt(i);
    }

    public final long getLong(int i) {
        if (this.tev) {
            return 0;
        }
        return this.tex.getLong(i);
    }

    public final float getFloat(int i) {
        if (this.tev) {
            return 0.0f;
        }
        return this.tex.getFloat(i);
    }

    public final double getDouble(int i) {
        if (this.tev) {
            return 0.0d;
        }
        return this.tex.getDouble(i);
    }

    public final boolean isNull(int i) {
        if (this.tev) {
            return false;
        }
        return this.tex.isNull(i);
    }

    public final byte[] getBlob(int i) {
        if (this.tev) {
            return null;
        }
        return this.tex.getBlob(i);
    }

    public final a Dy(int i) {
        a aVar = null;
        int i2 = 0;
        if (this.tew != null) {
            b bVar = this.tew;
            if (bVar.DA(i)) {
                Object obj = bVar.tef.get(i);
                aVar = (a) bVar.teh.get(obj);
                if (aVar == null) {
                    x.i("MicroMsg.CursorDataWindow", "get data null %s", obj);
                    if (bVar.tei.size() != 0) {
                        ArrayList ae = bVar.ae(bVar.tei);
                        if (ae != null) {
                            while (i2 < ae.size()) {
                                aVar = (a) ae.get(i2);
                                if (aVar != null) {
                                    bVar.b(aVar.getKey(), aVar);
                                } else {
                                    x.e("MicroMsg.CursorDataWindow", "newcursor obj is null");
                                }
                                i2++;
                            }
                        }
                        bVar.tei.clear();
                    }
                    aVar = (a) bVar.teh.get(obj);
                    if (aVar == null) {
                        x.e("MicroMsg.CursorDataWindow", "newcursor error obj : " + obj + "pos:" + i);
                    }
                }
            } else {
                x.e("MicroMsg.CursorDataWindow", "newcursor cursor getItem error: pos " + i + " loaded num :" + bVar.tef.size());
            }
        }
        return aVar;
    }

    public final boolean a(Object obj, a aVar) {
        if (this.tev && this.tew != null) {
            if (!this.tey && (obj instanceof Object[]) && this.tew.cm(obj)) {
                this.mCount -= ((Object[]) obj).length;
                this.pageSize -= ((Object[]) obj).length;
            }
            b bVar = this.tew;
            if (aVar != null) {
                x.v("MicroMsg.CursorDataWindow", "newcursor cursor update Memory key : " + obj + "values : " + aVar);
                bVar.b(obj, aVar);
            } else if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                for (Object remove : objArr) {
                    bVar.teh.remove(remove);
                }
                bVar.t(objArr);
            } else {
                if (bVar.tei == null) {
                    bVar.tei = new ArrayList();
                }
                if (!bVar.tei.contains(obj)) {
                    bVar.tei.add(obj);
                    x.i("MicroMsg.CursorDataWindow", "newcursor cursor clearData : " + obj);
                }
                bVar.teh.remove(obj);
            }
        } else if (!this.tev) {
            c cVar = this.tex;
            cVar.mPos = 0;
            cVar.tek.clear();
        }
        return false;
    }

    public final boolean cnU() {
        return this.tey;
    }

    public final boolean Dx(int i) {
        if (!this.tev) {
            return false;
        }
        b bVar = this.tew;
        if (i > 50) {
            return false;
        }
        if (bVar.teg < 10) {
            return true;
        }
        if (((double) i) / ((double) bVar.teg) < 0.1d) {
            return true;
        }
        return false;
    }

    public final boolean cm(Object obj) {
        if (this.tev && this.tew != null) {
            return this.tew.cm(obj);
        }
        return false;
    }

    public final a cn(Object obj) {
        if (!this.tev) {
            Log.e("WCDB.SQLiteNewCursor", "newcursor getItemByKey error " + obj);
            return null;
        } else if (this.tew == null) {
            Log.e("WCDB.SQLiteNewCursor", "newcursor error getItemByKey window is null");
            return null;
        } else {
            b bVar = this.tew;
            if (bVar.teh != null) {
                return (a) bVar.teh.get(obj);
            }
            return null;
        }
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void a(a aVar) {
        this.teu = aVar;
    }

    public final SparseArray<Object>[] cnS() {
        if (!this.tev) {
            return null;
        }
        return new SparseArray[]{this.tew.tef};
    }

    public final HashMap cnT() {
        return this.tew.teh;
    }
}
