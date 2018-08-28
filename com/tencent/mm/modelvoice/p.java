package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;

public final class p {
    public int bWA = -1;
    public String bWJ = "";
    public long bYu = 0;
    public String clientId = "";
    int cqa = 0;
    String cqb = "";
    public long createTime = 0;
    public int dHI = 0;
    int dYP = 0;
    public int emu = 0;
    public String enF = "";
    public int enH = 0;
    public long enK = 0;
    public int enN = 0;
    int enO = 0;
    String eoB = "";
    int eoI = 0;
    public int epI = 0;
    long epJ = 0;
    int epK = 0;
    public String fileName = "";
    public int status = 0;

    public final boolean TL() {
        if (this.status == 5 || this.status == 6) {
            return true;
        }
        return false;
    }

    public final boolean TM() {
        if ((this.status <= 1 || this.status > 3) && this.status != 8) {
            return false;
        }
        return true;
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if ((this.bWA & 1) != 0) {
            contentValues.put("FileName", this.fileName);
        }
        if ((this.bWA & 2) != 0) {
            contentValues.put("User", this.bWJ);
        }
        if ((this.bWA & 4) != 0) {
            contentValues.put("MsgId", Long.valueOf(this.bYu));
        }
        if ((this.bWA & 8) != 0) {
            contentValues.put("NetOffset", Integer.valueOf(this.emu));
        }
        if ((this.bWA & 16) != 0) {
            contentValues.put("FileNowSize", Integer.valueOf(this.enH));
        }
        if ((this.bWA & 32) != 0) {
            contentValues.put("TotalLen", Integer.valueOf(this.dHI));
        }
        if ((this.bWA & 64) != 0) {
            contentValues.put("Status", Integer.valueOf(this.status));
        }
        if ((this.bWA & 128) != 0) {
            contentValues.put("CreateTime", Long.valueOf(this.createTime));
        }
        if ((this.bWA & 256) != 0) {
            contentValues.put("LastModifyTime", Long.valueOf(this.enK));
        }
        if ((this.bWA & 512) != 0) {
            contentValues.put("ClientId", this.clientId);
        }
        if ((this.bWA & 1024) != 0) {
            contentValues.put("VoiceLength", Integer.valueOf(this.epI));
        }
        if ((this.bWA & 2048) != 0) {
            contentValues.put("MsgLocalId", Integer.valueOf(this.enN));
        }
        if ((this.bWA & 4096) != 0) {
            contentValues.put("Human", this.enF);
        }
        if ((this.bWA & 8192) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.enO));
        }
        if ((this.bWA & 16384) != 0) {
            contentValues.put("reserved2", this.eoB);
        }
        if ((this.bWA & 32768) != 0) {
            contentValues.put("MsgSource", this.cqb);
        }
        if ((this.bWA & 65536) != 0) {
            contentValues.put("MsgFlag", Integer.valueOf(this.cqa));
        }
        if ((this.bWA & 131072) != 0) {
            contentValues.put("MsgSeq", Integer.valueOf(this.dYP));
        }
        if ((this.bWA & 262144) != 0) {
            contentValues.put("MasterBufId", Long.valueOf(this.epJ));
        }
        if ((this.bWA & 524288) != 0) {
            contentValues.put("checksum", Integer.valueOf(this.epK));
        }
        return contentValues;
    }

    public final void d(Cursor cursor) {
        this.fileName = cursor.getString(0);
        this.bWJ = cursor.getString(1);
        this.bYu = cursor.getLong(2);
        this.emu = cursor.getInt(3);
        this.enH = cursor.getInt(4);
        this.dHI = cursor.getInt(5);
        this.status = cursor.getInt(6);
        this.createTime = cursor.getLong(7);
        this.enK = cursor.getLong(8);
        this.clientId = cursor.getString(9);
        this.epI = cursor.getInt(10);
        this.enN = cursor.getInt(11);
        this.enF = cursor.getString(12);
        this.enO = cursor.getInt(13);
        this.eoB = cursor.getString(14);
        this.cqb = cursor.getString(15);
        this.cqa = cursor.getInt(16);
        this.dYP = cursor.getInt(17);
        this.epJ = cursor.getLong(18);
        this.epK = cursor.getInt(19);
    }
}
