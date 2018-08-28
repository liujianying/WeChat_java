package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ds extends c {
    private static final int cNA = "fileLength".hashCode();
    private static final int cNB = "fileStatus".hashCode();
    private static final int cNC = "fileDuration".hashCode();
    private static final int cNy = "fileNameHash".hashCode();
    private static final int cNz = "fileMd5".hashCode();
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS file_name_hash_index ON SightDraftInfo(fileNameHash)"};
    private static final int ciP = "rowid".hashCode();
    private static final int ckb = "createTime".hashCode();
    private static final int cxT = "localId".hashCode();
    private static final int czu = "fileName".hashCode();
    private boolean cNt = true;
    private boolean cNu = true;
    private boolean cNv = true;
    private boolean cNw = true;
    private boolean cNx = true;
    private boolean cjF = true;
    private boolean cxR = true;
    private boolean cyZ = true;
    public long field_createTime;
    public int field_fileDuration;
    public long field_fileLength;
    public String field_fileMd5;
    public String field_fileName;
    public int field_fileNameHash;
    public int field_fileStatus;
    public int field_localId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cxT == hashCode) {
                    this.field_localId = cursor.getInt(i);
                    this.cxR = true;
                } else if (czu == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (cNy == hashCode) {
                    this.field_fileNameHash = cursor.getInt(i);
                } else if (cNz == hashCode) {
                    this.field_fileMd5 = cursor.getString(i);
                } else if (cNA == hashCode) {
                    this.field_fileLength = cursor.getLong(i);
                } else if (cNB == hashCode) {
                    this.field_fileStatus = cursor.getInt(i);
                } else if (cNC == hashCode) {
                    this.field_fileDuration = cursor.getInt(i);
                } else if (ckb == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cxR) {
            contentValues.put("localId", Integer.valueOf(this.field_localId));
        }
        if (this.cyZ) {
            contentValues.put("fileName", this.field_fileName);
        }
        if (this.cNt) {
            contentValues.put("fileNameHash", Integer.valueOf(this.field_fileNameHash));
        }
        if (this.field_fileMd5 == null) {
            this.field_fileMd5 = "";
        }
        if (this.cNu) {
            contentValues.put("fileMd5", this.field_fileMd5);
        }
        if (this.cNv) {
            contentValues.put("fileLength", Long.valueOf(this.field_fileLength));
        }
        if (this.cNw) {
            contentValues.put("fileStatus", Integer.valueOf(this.field_fileStatus));
        }
        if (this.cNx) {
            contentValues.put("fileDuration", Integer.valueOf(this.field_fileDuration));
        }
        if (this.cjF) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
