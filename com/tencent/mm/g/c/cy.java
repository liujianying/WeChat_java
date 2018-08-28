package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class cy extends c {
    private static final int cHK = "musicId".hashCode();
    private static final int cJD = "musicUrl".hashCode();
    private static final int cJE = "indexBitData".hashCode();
    private static final int cJF = "fileCacheComplete".hashCode();
    private static final int cJG = "pieceFileMIMEType".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int czu = "fileName".hashCode();
    private boolean cHd = true;
    private boolean cJA = true;
    private boolean cJB = true;
    private boolean cJC = true;
    private boolean cJz = true;
    private boolean cyZ = true;
    public int field_fileCacheComplete;
    public String field_fileName;
    public byte[] field_indexBitData;
    public String field_musicId;
    public String field_musicUrl;
    public String field_pieceFileMIMEType;

    public static a wI() {
        a aVar = new a();
        aVar.sKy = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "musicId";
        aVar.sKA.put("musicId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" musicId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "musicId";
        aVar.columns[1] = "musicUrl";
        aVar.sKA.put("musicUrl", "TEXT");
        stringBuilder.append(" musicUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "fileName";
        aVar.sKA.put("fileName", "TEXT");
        stringBuilder.append(" fileName TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "indexBitData";
        aVar.sKA.put("indexBitData", "BLOB");
        stringBuilder.append(" indexBitData BLOB");
        stringBuilder.append(", ");
        aVar.columns[4] = "fileCacheComplete";
        aVar.sKA.put("fileCacheComplete", "INTEGER");
        stringBuilder.append(" fileCacheComplete INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "pieceFileMIMEType";
        aVar.sKA.put("pieceFileMIMEType", "TEXT");
        stringBuilder.append(" pieceFileMIMEType TEXT");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cHK == hashCode) {
                    this.field_musicId = cursor.getString(i);
                    this.cHd = true;
                } else if (cJD == hashCode) {
                    this.field_musicUrl = cursor.getString(i);
                } else if (czu == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (cJE == hashCode) {
                    this.field_indexBitData = cursor.getBlob(i);
                } else if (cJF == hashCode) {
                    this.field_fileCacheComplete = cursor.getInt(i);
                } else if (cJG == hashCode) {
                    this.field_pieceFileMIMEType = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cHd) {
            contentValues.put("musicId", this.field_musicId);
        }
        if (this.cJz) {
            contentValues.put("musicUrl", this.field_musicUrl);
        }
        if (this.cyZ) {
            contentValues.put("fileName", this.field_fileName);
        }
        if (this.cJA) {
            contentValues.put("indexBitData", this.field_indexBitData);
        }
        if (this.cJB) {
            contentValues.put("fileCacheComplete", Integer.valueOf(this.field_fileCacheComplete));
        }
        if (this.cJC) {
            contentValues.put("pieceFileMIMEType", this.field_pieceFileMIMEType);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
