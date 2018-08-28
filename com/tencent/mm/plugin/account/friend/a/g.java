package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;

public final class g {
    int bWA = -1;
    String bgn = "";
    String cCR = "";
    public long csC = 0;
    private String csD = "";
    int csJ = 0;
    String csK = "";
    String csL = "";
    String eJA = "";
    String eJB = "";
    String eKa = "";
    int eKb = 0;
    int sex = 0;
    String signature = "";
    public int status = 0;
    private int type = 0;
    String username = "";

    public final void d(Cursor cursor) {
        this.csC = cursor.getLong(0);
        this.eKa = cursor.getString(1);
        this.eKb = cursor.getInt(2);
        this.status = cursor.getInt(3);
        this.username = cursor.getString(4);
        this.bgn = cursor.getString(5);
        this.eJA = cursor.getString(6);
        this.eJB = cursor.getString(7);
        this.sex = cursor.getInt(8);
        this.csJ = cursor.getInt(9);
        this.csK = cursor.getString(10);
        this.csL = cursor.getString(11);
        this.signature = cursor.getString(12);
        this.cCR = cursor.getString(13);
        this.type = cursor.getInt(14);
        this.csD = cursor.getString(15);
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if ((this.bWA & 1) != 0) {
            contentValues.put("fbid", Long.valueOf(this.csC));
        }
        if ((this.bWA & 2) != 0) {
            contentValues.put("fbname", Xv());
        }
        if ((this.bWA & 4) != 0) {
            contentValues.put("fbimgkey", Integer.valueOf(this.eKb));
        }
        if ((this.bWA & 8) != 0) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if ((this.bWA & 16) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bWA & 32) != 0) {
            contentValues.put("nickname", Xm());
        }
        if ((this.bWA & 64) != 0) {
            contentValues.put("nicknamepyinitial", this.eJA == null ? "" : this.eJA);
        }
        if ((this.bWA & 128) != 0) {
            contentValues.put("nicknamequanpin", this.eJB == null ? "" : this.eJB);
        }
        if ((this.bWA & ab.CTRL_BYTE) != 0) {
            contentValues.put("sex", Integer.valueOf(this.sex));
        }
        if ((this.bWA & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("personalcard", Integer.valueOf(this.csJ));
        }
        if ((this.bWA & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("province", this.csK == null ? "" : this.csK);
        }
        if ((this.bWA & 2048) != 0) {
            contentValues.put("city", this.csL == null ? "" : this.csL);
        }
        if ((this.bWA & 4096) != 0) {
            contentValues.put("signature", this.signature == null ? "" : this.signature);
        }
        if ((this.bWA & 8192) != 0) {
            contentValues.put("alias", this.cCR == null ? "" : this.cCR);
        }
        if ((this.bWA & 16384) != 0) {
            contentValues.put("type", Integer.valueOf(this.type));
        }
        if ((this.bWA & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("email", this.csD == null ? "" : this.csD);
        }
        return contentValues;
    }

    public final String Xv() {
        return this.eKa == null ? "" : this.eKa;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String Xm() {
        return this.bgn == null ? "" : this.bgn;
    }
}
