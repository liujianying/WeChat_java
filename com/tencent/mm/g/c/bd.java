package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class bd extends c {
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS FavCdnTransferInfo_LocalId ON FavCdnInfo(favLocalId)", "CREATE INDEX IF NOT EXISTS FavCDNInfo_modifyTime_Index ON FavCdnInfo(modifyTime)"};
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int ckU = "totalLen".hashCode();
    private static final int ckV = "offset".hashCode();
    private static final int cke = "type".hashCode();
    private static final int clo = "dataType".hashCode();
    private static final int cmm = "modifyTime".hashCode();
    private static final int cwd = "cdnUrl".hashCode();
    private static final int cxJ = "dataId".hashCode();
    private static final int cxK = "favLocalId".hashCode();
    private static final int cxL = "cdnKey".hashCode();
    private static final int cxM = "path".hashCode();
    private static final int cxN = "extFlag".hashCode();
    private static final int cxO = "attrFlag".hashCode();
    private boolean ciS = true;
    private boolean cjI = true;
    private boolean ckD = true;
    private boolean ckE = true;
    private boolean clP = true;
    private boolean cll = true;
    private boolean cvC = true;
    private boolean cxD = true;
    private boolean cxE = true;
    private boolean cxF = true;
    private boolean cxG = true;
    private boolean cxH = true;
    private boolean cxI = true;
    public long field_attrFlag;
    public String field_cdnKey;
    public String field_cdnUrl;
    public String field_dataId;
    public int field_dataType;
    public int field_extFlag;
    public long field_favLocalId;
    public long field_modifyTime;
    public int field_offset;
    public String field_path;
    public int field_status;
    public int field_totalLen;
    public int field_type;

    public static a wI() {
        a aVar = new a();
        aVar.sKy = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "dataId";
        aVar.sKA.put("dataId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" dataId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "dataId";
        aVar.columns[1] = "favLocalId";
        aVar.sKA.put("favLocalId", "LONG");
        stringBuilder.append(" favLocalId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "type";
        aVar.sKA.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "cdnUrl";
        aVar.sKA.put("cdnUrl", "TEXT");
        stringBuilder.append(" cdnUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "cdnKey";
        aVar.sKA.put("cdnKey", "TEXT");
        stringBuilder.append(" cdnKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "totalLen";
        aVar.sKA.put("totalLen", "INTEGER");
        stringBuilder.append(" totalLen INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "offset";
        aVar.sKA.put("offset", "INTEGER");
        stringBuilder.append(" offset INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "status";
        aVar.sKA.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "path";
        aVar.sKA.put("path", "TEXT");
        stringBuilder.append(" path TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "dataType";
        aVar.sKA.put("dataType", "INTEGER");
        stringBuilder.append(" dataType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "modifyTime";
        aVar.sKA.put("modifyTime", "LONG default '0' ");
        stringBuilder.append(" modifyTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "extFlag";
        aVar.sKA.put("extFlag", "INTEGER default '0' ");
        stringBuilder.append(" extFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "attrFlag";
        aVar.sKA.put("attrFlag", "LONG default '0' ");
        stringBuilder.append(" attrFlag LONG default '0' ");
        aVar.columns[13] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cxJ == hashCode) {
                    this.field_dataId = cursor.getString(i);
                    this.cxD = true;
                } else if (cxK == hashCode) {
                    this.field_favLocalId = cursor.getLong(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (cwd == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (cxL == hashCode) {
                    this.field_cdnKey = cursor.getString(i);
                } else if (ckU == hashCode) {
                    this.field_totalLen = cursor.getInt(i);
                } else if (ckV == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cxM == hashCode) {
                    this.field_path = cursor.getString(i);
                } else if (clo == hashCode) {
                    this.field_dataType = cursor.getInt(i);
                } else if (cmm == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (cxN == hashCode) {
                    this.field_extFlag = cursor.getInt(i);
                } else if (cxO == hashCode) {
                    this.field_attrFlag = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cxD) {
            contentValues.put("dataId", this.field_dataId);
        }
        if (this.cxE) {
            contentValues.put("favLocalId", Long.valueOf(this.field_favLocalId));
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.cvC) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.cxF) {
            contentValues.put("cdnKey", this.field_cdnKey);
        }
        if (this.ckD) {
            contentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
        }
        if (this.ckE) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cxG) {
            contentValues.put("path", this.field_path);
        }
        if (this.cll) {
            contentValues.put("dataType", Integer.valueOf(this.field_dataType));
        }
        if (this.clP) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.cxH) {
            contentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
        }
        if (this.cxI) {
            contentValues.put("attrFlag", Long.valueOf(this.field_attrFlag));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
