package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bl extends c {
    private static final int cAa = "mid".hashCode();
    private static final int cAb = "connectState".hashCode();
    private static final int cAc = "expiredTime".hashCode();
    private static final int cAd = "wifiType".hashCode();
    private static final int cAe = "action".hashCode();
    private static final int cAf = "showUrl".hashCode();
    private static final int cAg = "showWordEn".hashCode();
    private static final int cAh = "showWordCn".hashCode();
    private static final int cAi = "showWordTw".hashCode();
    private static final int cAj = "mac".hashCode();
    private static final int cAk = "verifyResult".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cqH = "url".hashCode();
    private static final int czY = "ssidmd5".hashCode();
    private static final int czZ = "ssid".hashCode();
    private boolean cqo = true;
    private boolean czL = true;
    private boolean czM = true;
    private boolean czN = true;
    private boolean czO = true;
    private boolean czP = true;
    private boolean czQ = true;
    private boolean czR = true;
    private boolean czS = true;
    private boolean czT = true;
    private boolean czU = true;
    private boolean czV = true;
    private boolean czW = true;
    private boolean czX = true;
    public int field_action;
    public int field_connectState;
    public long field_expiredTime;
    public String field_mac;
    public String field_mid;
    public String field_showUrl;
    public String field_showWordCn;
    public String field_showWordEn;
    public String field_showWordTw;
    public String field_ssid;
    public String field_ssidmd5;
    public String field_url;
    public int field_verifyResult;
    public int field_wifiType;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (czY == hashCode) {
                    this.field_ssidmd5 = cursor.getString(i);
                    this.czL = true;
                } else if (czZ == hashCode) {
                    this.field_ssid = cursor.getString(i);
                } else if (cAa == hashCode) {
                    this.field_mid = cursor.getString(i);
                } else if (cqH == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (cAb == hashCode) {
                    this.field_connectState = cursor.getInt(i);
                } else if (cAc == hashCode) {
                    this.field_expiredTime = cursor.getLong(i);
                } else if (cAd == hashCode) {
                    this.field_wifiType = cursor.getInt(i);
                } else if (cAe == hashCode) {
                    this.field_action = cursor.getInt(i);
                } else if (cAf == hashCode) {
                    this.field_showUrl = cursor.getString(i);
                } else if (cAg == hashCode) {
                    this.field_showWordEn = cursor.getString(i);
                } else if (cAh == hashCode) {
                    this.field_showWordCn = cursor.getString(i);
                } else if (cAi == hashCode) {
                    this.field_showWordTw = cursor.getString(i);
                } else if (cAj == hashCode) {
                    this.field_mac = cursor.getString(i);
                } else if (cAk == hashCode) {
                    this.field_verifyResult = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.czL) {
            contentValues.put("ssidmd5", this.field_ssidmd5);
        }
        if (this.czM) {
            contentValues.put("ssid", this.field_ssid);
        }
        if (this.czN) {
            contentValues.put("mid", this.field_mid);
        }
        if (this.cqo) {
            contentValues.put("url", this.field_url);
        }
        if (this.czO) {
            contentValues.put("connectState", Integer.valueOf(this.field_connectState));
        }
        if (this.czP) {
            contentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
        }
        if (this.czQ) {
            contentValues.put("wifiType", Integer.valueOf(this.field_wifiType));
        }
        if (this.czR) {
            contentValues.put("action", Integer.valueOf(this.field_action));
        }
        if (this.czS) {
            contentValues.put("showUrl", this.field_showUrl);
        }
        if (this.czT) {
            contentValues.put("showWordEn", this.field_showWordEn);
        }
        if (this.czU) {
            contentValues.put("showWordCn", this.field_showWordCn);
        }
        if (this.czV) {
            contentValues.put("showWordTw", this.field_showWordTw);
        }
        if (this.czW) {
            contentValues.put("mac", this.field_mac);
        }
        if (this.czX) {
            contentValues.put("verifyResult", Integer.valueOf(this.field_verifyResult));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
