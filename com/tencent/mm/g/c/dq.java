package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dq extends c {
    private static final int cNa = "from_username".hashCode();
    private static final int cNb = "consumer".hashCode();
    private static final int cNc = "share_time".hashCode();
    private static final int cNd = "local_updateTime".hashCode();
    private static final int cNe = "begin_time".hashCode();
    private static final int cNf = "end_time".hashCode();
    private static final int cNg = "block_mask".hashCode();
    private static final int cNh = "dataInfoData".hashCode();
    private static final int cNi = "cardTpInfoData".hashCode();
    private static final int cNj = "shareInfoData".hashCode();
    private static final int cNk = "shopInfoData".hashCode();
    private static final int cNl = "categoryType".hashCode();
    private static final int cNm = "itemIndex".hashCode();
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS ShareCardInfo_card_tp_id_index ON ShareCardInfo(card_tp_id)"};
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int clj = "updateTime".hashCode();
    private static final int cqC = "card_id".hashCode();
    private static final int cqD = "card_tp_id".hashCode();
    private static final int cvW = "app_id".hashCode();
    private static final int cyk = "updateSeq".hashCode();
    private boolean cMN = true;
    private boolean cMO = true;
    private boolean cMP = true;
    private boolean cMQ = true;
    private boolean cMR = true;
    private boolean cMS = true;
    private boolean cMT = true;
    private boolean cMU = true;
    private boolean cMV = true;
    private boolean cMW = true;
    private boolean cMX = true;
    private boolean cMY = true;
    private boolean cMZ = true;
    private boolean ciS = true;
    private boolean clh = true;
    private boolean cqj = true;
    private boolean cqk = true;
    private boolean cvu = true;
    private boolean cxW = true;
    public String field_app_id;
    public long field_begin_time;
    public long field_block_mask;
    public byte[] field_cardTpInfoData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_categoryType;
    public String field_consumer;
    public byte[] field_dataInfoData;
    public long field_end_time;
    public String field_from_username;
    public int field_itemIndex;
    public long field_local_updateTime;
    public byte[] field_shareInfoData;
    public long field_share_time;
    public byte[] field_shopInfoData;
    public int field_status;
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
                } else if (cNb == hashCode) {
                    this.field_consumer = cursor.getString(i);
                } else if (cvW == hashCode) {
                    this.field_app_id = cursor.getString(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cNc == hashCode) {
                    this.field_share_time = cursor.getLong(i);
                } else if (cNd == hashCode) {
                    this.field_local_updateTime = cursor.getLong(i);
                } else if (clj == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (cNe == hashCode) {
                    this.field_begin_time = cursor.getLong(i);
                } else if (cNf == hashCode) {
                    this.field_end_time = cursor.getLong(i);
                } else if (cyk == hashCode) {
                    this.field_updateSeq = cursor.getLong(i);
                } else if (cNg == hashCode) {
                    this.field_block_mask = cursor.getLong(i);
                } else if (cNh == hashCode) {
                    this.field_dataInfoData = cursor.getBlob(i);
                } else if (cNi == hashCode) {
                    this.field_cardTpInfoData = cursor.getBlob(i);
                } else if (cNj == hashCode) {
                    this.field_shareInfoData = cursor.getBlob(i);
                } else if (cNk == hashCode) {
                    this.field_shopInfoData = cursor.getBlob(i);
                } else if (cNl == hashCode) {
                    this.field_categoryType = cursor.getInt(i);
                } else if (cNm == hashCode) {
                    this.field_itemIndex = cursor.getInt(i);
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
        if (this.cMO) {
            contentValues.put("consumer", this.field_consumer);
        }
        if (this.cvu) {
            contentValues.put("app_id", this.field_app_id);
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cMP) {
            contentValues.put("share_time", Long.valueOf(this.field_share_time));
        }
        if (this.cMQ) {
            contentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
        }
        if (this.clh) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.cMR) {
            contentValues.put("begin_time", Long.valueOf(this.field_begin_time));
        }
        if (this.cMS) {
            contentValues.put("end_time", Long.valueOf(this.field_end_time));
        }
        if (this.cxW) {
            contentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
        }
        if (this.cMT) {
            contentValues.put("block_mask", Long.valueOf(this.field_block_mask));
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
        if (this.cMY) {
            contentValues.put("categoryType", Integer.valueOf(this.field_categoryType));
        }
        if (this.cMZ) {
            contentValues.put("itemIndex", Integer.valueOf(this.field_itemIndex));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
