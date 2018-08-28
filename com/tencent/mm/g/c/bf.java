package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.wb;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class bf extends c {
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS FavModInfo_LocalId_Index ON FavEditInfo(localId)"};
    private static final int ciP = "rowid".hashCode();
    private static final int cke = "type".hashCode();
    private static final int ckw = "scene".hashCode();
    private static final int cqB = "time".hashCode();
    private static final int cxT = "localId".hashCode();
    private static final int cxU = "modItem".hashCode();
    private boolean cjI = true;
    private boolean cku = true;
    private boolean cqi = true;
    private boolean cxR = true;
    private boolean cxS = true;
    public long field_localId;
    public wb field_modItem;
    public int field_scene;
    public long field_time;
    public int field_type;

    public static a wI() {
        a aVar = new a();
        aVar.sKy = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.sKA.put("localId", "LONG");
        stringBuilder.append(" localId LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "modItem";
        aVar.sKA.put("modItem", "BLOB");
        stringBuilder.append(" modItem BLOB");
        stringBuilder.append(", ");
        aVar.columns[2] = "time";
        aVar.sKA.put("time", "LONG");
        stringBuilder.append(" time LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "type";
        aVar.sKA.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "scene";
        aVar.sKA.put("scene", "INTEGER default '1' ");
        stringBuilder.append(" scene INTEGER default '1' ");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cxT == hashCode) {
                    this.field_localId = cursor.getLong(i);
                } else if (cxU == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_modItem = (wb) new wb().aG(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseFavEditInfo", e.getMessage());
                    }
                } else if (cqB == hashCode) {
                    this.field_time = cursor.getLong(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (ckw == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cxR) {
            contentValues.put("localId", Long.valueOf(this.field_localId));
        }
        if (this.cxS && this.field_modItem != null) {
            try {
                contentValues.put("modItem", this.field_modItem.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseFavEditInfo", e.getMessage());
            }
        }
        if (this.cqi) {
            contentValues.put("time", Long.valueOf(this.field_time));
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.cku) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
