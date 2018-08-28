package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.c.v;
import com.google.android.gms.c.w;
import com.google.android.gms.tagmanager.c.a;
import com.google.android.gms.tagmanager.c.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

final class ap implements c {
    private static final String bcW = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    private v aFC;
    private final Executor bcX;
    private a bcY;
    private int bcZ;
    private final Context mContext;

    public ap(Context context) {
        this(context, w.qf(), "google_tagmanager.db", Executors.newSingleThreadExecutor());
    }

    private ap(Context context, v vVar, String str, Executor executor) {
        this.mContext = context;
        this.aFC = vVar;
        this.bcZ = 2000;
        this.bcX = executor;
        this.bcY = new a(this, this.mContext, str);
    }

    private void af(long j) {
        SQLiteDatabase rL = rL();
        if (rL != null) {
            try {
                new StringBuilder("Deleted ").append(rL.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)})).append(" expired items");
                m.rf();
            } catch (SQLiteException e) {
                m.rd();
            }
        }
    }

    private static byte[] ap(Object obj) {
        Throwable th;
        ObjectOutputStream objectOutputStream;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2;
        try {
            objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream2.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream2.close();
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream = objectOutputStream2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e4) {
            objectOutputStream2 = bArr;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e5) {
                }
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e32) {
                    throw th;
                }
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private synchronized void b(List<b> list, long j) {
        long currentTimeMillis;
        String[] strArr;
        try {
            currentTimeMillis = this.aFC.currentTimeMillis();
            af(currentTimeMillis);
            int size = list.size() + (rK() - this.bcZ);
            if (size > 0) {
                List dR = dR(size);
                new StringBuilder("DataLayer store full, deleting ").append(dR.size()).append(" entries to make room.");
                m.re();
                strArr = (String[]) dR.toArray(new String[0]);
                if (!(strArr == null || strArr.length == 0)) {
                    SQLiteDatabase rL = rL();
                    if (rL != null) {
                        rL.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                    }
                }
            }
        } catch (SQLiteException e) {
            new StringBuilder("Error deleting entries ").append(Arrays.toString(strArr));
            m.rd();
        } catch (Throwable th) {
            rM();
        }
        c(list, currentTimeMillis + j);
        rM();
    }

    private void c(List<b> list, long j) {
        SQLiteDatabase rL = rL();
        if (rL != null) {
            for (b bVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", bVar.aXv);
                contentValues.put("value", bVar.bde);
                rL.insert("datalayer", null, contentValues);
            }
        }
    }

    private List<String> dR(int i) {
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            m.rd();
            return arrayList;
        }
        SQLiteDatabase rL = rL();
        if (rL == null) {
            return arrayList;
        }
        Cursor query;
        try {
            query = rL.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    new StringBuilder("Error in peekEntries fetching entryIds: ").append(e.getMessage());
                    m.rd();
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    private static Object n(byte[] bArr) {
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream;
        ObjectInputStream readObject2 = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream2;
        try {
            objectInputStream2 = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject2 = objectInputStream2.readObject();
                try {
                    objectInputStream2.close();
                    byteArrayInputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
            } catch (ClassNotFoundException e3) {
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e4) {
                    }
                }
                byteArrayInputStream.close();
                return readObject2;
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = objectInputStream2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e6) {
            objectInputStream2 = readObject2;
            if (objectInputStream2 != null) {
                try {
                    objectInputStream2.close();
                } catch (IOException e7) {
                }
            }
            byteArrayInputStream.close();
            return readObject2;
        } catch (ClassNotFoundException e8) {
            objectInputStream2 = readObject2;
            if (objectInputStream2 != null) {
                try {
                    objectInputStream2.close();
                } catch (IOException e42) {
                }
            }
            byteArrayInputStream.close();
            return readObject2;
        } catch (Throwable th3) {
            th = th3;
            objectInputStream = readObject2;
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e52) {
                    throw th;
                }
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject2;
    }

    private List<a> rI() {
        try {
            af(this.aFC.currentTimeMillis());
            List<b> rJ = rJ();
            List<a> arrayList = new ArrayList();
            for (b bVar : rJ) {
                arrayList.add(new a(bVar.aXv, n(bVar.bde)));
            }
            return arrayList;
        } finally {
            rM();
        }
    }

    private List<b> rJ() {
        SQLiteDatabase rL = rL();
        List<b> arrayList = new ArrayList();
        if (rL == null) {
            return arrayList;
        }
        Cursor query = rL.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new b(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int rK() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase rL = rL();
        if (rL != null) {
            try {
                cursor = rL.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                m.rd();
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    private SQLiteDatabase rL() {
        try {
            return this.bcY.getWritableDatabase();
        } catch (SQLiteException e) {
            m.rd();
            return null;
        }
    }

    private void rM() {
        try {
            this.bcY.close();
        } catch (SQLiteException e) {
        }
    }

    public final void a(c.a aVar) {
        this.bcX.execute(new 2(this, aVar));
    }

    public final void a(List<a> list, long j) {
        List arrayList = new ArrayList();
        for (a aVar : list) {
            arrayList.add(new b(aVar.aXv, ap(aVar.bbv)));
        }
        this.bcX.execute(new 1(this, arrayList, j));
    }
}
