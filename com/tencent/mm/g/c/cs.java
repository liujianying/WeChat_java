package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.as;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public abstract class cs extends c {
    private static final int cIY = "acctTypeId".hashCode();
    private static final int cIZ = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE.hashCode();
    private static final int cJa = "accTypeRec".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int clj = "updateTime".hashCode();
    private boolean cIV = true;
    private boolean cIW = true;
    private boolean cIX = true;
    private boolean clh = true;
    public as field_accTypeRec;
    public String field_acctTypeId;
    public String field_language;
    public long field_updateTime;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cIY == hashCode) {
                    this.field_acctTypeId = cursor.getString(i);
                } else if (cIZ == hashCode) {
                    this.field_language = cursor.getString(i);
                } else if (cJa == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_accTypeRec = (as) new as().aG(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", e.getMessage());
                    }
                } else if (clj == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cIV) {
            contentValues.put("acctTypeId", this.field_acctTypeId);
        }
        if (this.cIW) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, this.field_language);
        }
        if (this.cIX && this.field_accTypeRec != null) {
            try {
                contentValues.put("accTypeRec", this.field_accTypeRec.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", e.getMessage());
            }
        }
        if (this.clh) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
