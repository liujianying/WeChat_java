package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.et;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public abstract class s extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cnp = "deviceId".hashCode();
    private static final int cnq = "sessionName".hashCode();
    private static final int cnr = "moveTime".hashCode();
    private boolean cnm = true;
    private boolean cnn = true;
    private boolean cno = true;
    public String field_deviceId;
    public et field_moveTime;
    public String field_sessionName;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cnp == hashCode) {
                    this.field_deviceId = cursor.getString(i);
                } else if (cnq == hashCode) {
                    this.field_sessionName = cursor.getString(i);
                } else if (cnr == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_moveTime = (et) new et().aG(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseBackupMoveTime", e.getMessage());
                    }
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.field_deviceId == null) {
            this.field_deviceId = "";
        }
        if (this.cnm) {
            contentValues.put("deviceId", this.field_deviceId);
        }
        if (this.field_sessionName == null) {
            this.field_sessionName = "";
        }
        if (this.cnn) {
            contentValues.put("sessionName", this.field_sessionName);
        }
        if (this.cno && this.field_moveTime != null) {
            try {
                contentValues.put("moveTime", this.field_moveTime.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseBackupMoveTime", e.getMessage());
            }
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
