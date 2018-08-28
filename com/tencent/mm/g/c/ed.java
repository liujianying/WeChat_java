package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ed extends c {
    private static final int cNa = "from_username".hashCode();
    private static final int cNd = "local_updateTime".hashCode();
    private static final int cNe = "begin_time".hashCode();
    private static final int cNf = "end_time".hashCode();
    private static final int cNg = "block_mask".hashCode();
    private static final int cNh = "dataInfoData".hashCode();
    private static final int cNi = "cardTpInfoData".hashCode();
    private static final int cNj = "shareInfoData".hashCode();
    private static final int cNk = "shopInfoData".hashCode();
    private static final int cPo = "delete_state_flag".hashCode();
    private static final int cPp = "create_time".hashCode();
    private static final int cPq = "stickyIndex".hashCode();
    private static final int cPr = "stickyEndTime".hashCode();
    private static final int cPs = "stickyAnnouncement".hashCode();
    private static final int cPt = "label_wording".hashCode();
    private static final int cPu = "is_dynamic".hashCode();
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS UserCardInfo_card_type_index ON UserCardInfo(card_type)"};
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int clj = "updateTime".hashCode();
    private static final int cqC = "card_id".hashCode();
    private static final int cqD = "card_tp_id".hashCode();
    private static final int cqz = "card_type".hashCode();
    private static final int cyk = "updateSeq".hashCode();
    private boolean cMN = true;
    private boolean cMQ = true;
    private boolean cMR = true;
    private boolean cMS = true;
    private boolean cMT = true;
    private boolean cMU = true;
    private boolean cMV = true;
    private boolean cMW = true;
    private boolean cMX = true;
    private boolean cPh = true;
    private boolean cPi = true;
    private boolean cPj = true;
    private boolean cPk = true;
    private boolean cPl = true;
    private boolean cPm = true;
    private boolean cPn = true;
    private boolean ciS = true;
    private boolean clh = true;
    private boolean cqg = true;
    private boolean cqj = true;
    private boolean cqk = true;
    private boolean cxW = true;
    public long field_begin_time;
    public String field_block_mask;
    public byte[] field_cardTpInfoData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_card_type;
    public long field_create_time;
    public byte[] field_dataInfoData;
    public int field_delete_state_flag;
    public long field_end_time;
    public String field_from_username;
    public boolean field_is_dynamic;
    public String field_label_wording;
    public long field_local_updateTime;
    public byte[] field_shareInfoData;
    public byte[] field_shopInfoData;
    public int field_status;
    public String field_stickyAnnouncement;
    public int field_stickyEndTime;
    public int field_stickyIndex;
    public long field_updateSeq;
    public long field_updateTime;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cqC == hashCode) {
                    this.field_card_id = cursor.getString(i);
                    this.cqj = true;
                } else if (cqD == hashCode) {
                    this.field_card_tp_id = cursor.getString(i);
                } else if (cNa == hashCode) {
                    this.field_from_username = cursor.getString(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cPo == hashCode) {
                    this.field_delete_state_flag = cursor.getInt(i);
                } else if (cNd == hashCode) {
                    this.field_local_updateTime = cursor.getLong(i);
                } else if (clj == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (cyk == hashCode) {
                    this.field_updateSeq = cursor.getLong(i);
                } else if (cPp == hashCode) {
                    this.field_create_time = cursor.getLong(i);
                } else if (cNe == hashCode) {
                    this.field_begin_time = cursor.getLong(i);
                } else if (cNf == hashCode) {
                    this.field_end_time = cursor.getLong(i);
                } else if (cNg == hashCode) {
                    this.field_block_mask = cursor.getString(i);
                } else if (cNh == hashCode) {
                    this.field_dataInfoData = cursor.getBlob(i);
                } else if (cNi == hashCode) {
                    this.field_cardTpInfoData = cursor.getBlob(i);
                } else if (cNj == hashCode) {
                    this.field_shareInfoData = cursor.getBlob(i);
                } else if (cNk == hashCode) {
                    this.field_shopInfoData = cursor.getBlob(i);
                } else if (cPq == hashCode) {
                    this.field_stickyIndex = cursor.getInt(i);
                } else if (cPr == hashCode) {
                    this.field_stickyEndTime = cursor.getInt(i);
                } else if (cPs == hashCode) {
                    this.field_stickyAnnouncement = cursor.getString(i);
                } else if (cqz == hashCode) {
                    this.field_card_type = cursor.getInt(i);
                } else if (cPt == hashCode) {
                    this.field_label_wording = cursor.getString(i);
                } else if (cPu == hashCode) {
                    this.field_is_dynamic = cursor.getInt(i) != 0;
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cqj) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.cqk) {
            contentValues.put("card_tp_id", this.field_card_tp_id);
        }
        if (this.cMN) {
            contentValues.put("from_username", this.field_from_username);
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cPh) {
            contentValues.put("delete_state_flag", Integer.valueOf(this.field_delete_state_flag));
        }
        if (this.cMQ) {
            contentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
        }
        if (this.clh) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.cxW) {
            contentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
        }
        if (this.cPi) {
            contentValues.put("create_time", Long.valueOf(this.field_create_time));
        }
        if (this.cMR) {
            contentValues.put("begin_time", Long.valueOf(this.field_begin_time));
        }
        if (this.cMS) {
            contentValues.put("end_time", Long.valueOf(this.field_end_time));
        }
        if (this.cMT) {
            contentValues.put("block_mask", this.field_block_mask);
        }
        if (this.cMU) {
            contentValues.put("dataInfoData", this.field_dataInfoData);
        }
        if (this.cMV) {
            contentValues.put("cardTpInfoData", this.field_cardTpInfoData);
        }
        if (this.cMW) {
            contentValues.put("shareInfoData", this.field_shareInfoData);
        }
        if (this.cMX) {
            contentValues.put("shopInfoData", this.field_shopInfoData);
        }
        if (this.cPj) {
            contentValues.put("stickyIndex", Integer.valueOf(this.field_stickyIndex));
        }
        if (this.cPk) {
            contentValues.put("stickyEndTime", Integer.valueOf(this.field_stickyEndTime));
        }
        if (this.cPl) {
            contentValues.put("stickyAnnouncement", this.field_stickyAnnouncement);
        }
        if (this.cqg) {
            contentValues.put("card_type", Integer.valueOf(this.field_card_type));
        }
        if (this.cPm) {
            contentValues.put("label_wording", this.field_label_wording);
        }
        if (this.cPn) {
            contentValues.put("is_dynamic", Boolean.valueOf(this.field_is_dynamic));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
