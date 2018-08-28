package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public abstract class di extends c {
    private static final int cKQ = "oriMsgId".hashCode();
    private static final int cKR = "dataProto".hashCode();
    private static final int cKS = "favFrom".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciO = "msgId".hashCode();
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int cke = "type".hashCode();
    private static final int cnf = "title".hashCode();
    private static final int cws = "desc".hashCode();
    private static final int cxT = "localId".hashCode();
    private static final int cyp = "toUser".hashCode();
    private boolean cKN = true;
    private boolean cKO = true;
    private boolean cKP = true;
    private boolean ciK = true;
    private boolean ciS = true;
    private boolean cjI = true;
    private boolean cnb = true;
    private boolean cwo = true;
    private boolean cxR = true;
    private boolean cyb = true;
    public wl field_dataProto;
    public String field_desc;
    public String field_favFrom;
    public int field_localId;
    public long field_msgId;
    public long field_oriMsgId;
    public int field_status;
    public String field_title;
    public String field_toUser;
    public int field_type;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cxT == hashCode) {
                    this.field_localId = cursor.getInt(i);
                    this.cxR = true;
                } else if (ciO == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                } else if (cKQ == hashCode) {
                    this.field_oriMsgId = cursor.getLong(i);
                } else if (cyp == hashCode) {
                    this.field_toUser = cursor.getString(i);
                } else if (cnf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (cws == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (cKR == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_dataProto = (wl) new wl().aG(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseRecordMessageInfo", e.getMessage());
                    }
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cKS == hashCode) {
                    this.field_favFrom = cursor.getString(i);
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
        if (this.ciK) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.cKN) {
            contentValues.put("oriMsgId", Long.valueOf(this.field_oriMsgId));
        }
        if (this.field_toUser == null) {
            this.field_toUser = "";
        }
        if (this.cyb) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.cnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.cwo) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.cKO && this.field_dataProto != null) {
            try {
                contentValues.put("dataProto", this.field_dataProto.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseRecordMessageInfo", e.getMessage());
            }
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cKP) {
            contentValues.put("favFrom", this.field_favFrom);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
