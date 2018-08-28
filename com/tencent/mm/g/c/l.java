package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class l extends c {
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemUpdateTimeIndex ON AppBrandLauncherLayoutItem(updateTime)", "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemSceneIndex ON AppBrandLauncherLayoutItem(scene)"};
    private static final int ciP = "rowid".hashCode();
    private static final int ckw = "scene".hashCode();
    private static final int clj = "updateTime".hashCode();
    private static final int clt = "recordId".hashCode();
    private static final int clu = "brandId".hashCode();
    private static final int clv = "versionType".hashCode();
    private boolean cku = true;
    private boolean clh = true;
    private boolean clq = true;
    private boolean clr = true;
    private boolean cls = true;
    public String field_brandId;
    public int field_recordId;
    public int field_scene;
    public long field_updateTime;
    public int field_versionType;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (clt == hashCode) {
                    this.field_recordId = cursor.getInt(i);
                    this.clq = true;
                } else if (clu == hashCode) {
                    this.field_brandId = cursor.getString(i);
                } else if (clv == hashCode) {
                    this.field_versionType = cursor.getInt(i);
                } else if (clj == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (ckw == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.clq) {
            contentValues.put("recordId", Integer.valueOf(this.field_recordId));
        }
        if (this.clr) {
            contentValues.put("brandId", this.field_brandId);
        }
        if (this.cls) {
            contentValues.put("versionType", Integer.valueOf(this.field_versionType));
        }
        if (this.clh) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
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
