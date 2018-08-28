package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class g extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cjZ = "userName".hashCode();
    private static final int ckw = "scene".hashCode();
    private static final int ckx = "ticket".hashCode();
    private boolean cjD = true;
    private boolean cku = true;
    private boolean ckv = true;
    public int field_scene;
    public String field_ticket;
    public String field_userName;

    public static a wI() {
        a aVar = new a();
        aVar.sKy = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userName";
        aVar.sKA.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "scene";
        aVar.sKA.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "ticket";
        aVar.sKA.put("ticket", "TEXT");
        stringBuilder.append(" ticket TEXT");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cjZ == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (ckw == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (ckx == hashCode) {
                    this.field_ticket = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cjD) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.cku) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.ckv) {
            contentValues.put("ticket", this.field_ticket);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
