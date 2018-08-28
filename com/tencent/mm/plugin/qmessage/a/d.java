package com.tencent.mm.plugin.qmessage.a;

import android.content.ContentValues;

public final class d {
    public int bWA = -1;
    int dCV = 0;
    int dHN = 0;
    int dHO = 0;
    int dSJ = 0;
    long eLw = 0;
    String extInfo = "";
    String mbA = "";
    String mbB = "";
    public int mbv = 0;
    public long mbw = 0;
    public long mbx = 0;
    String mby = "";
    String mbz = "";
    public String username = "";

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if ((this.bWA & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bWA & 2) != 0) {
            contentValues.put("qq", Long.valueOf(this.eLw));
        }
        if ((this.bWA & 4) != 0) {
            contentValues.put("extinfo", boa());
        }
        if ((this.bWA & 8) != 0) {
            contentValues.put("needupdate", Integer.valueOf(this.mbv));
        }
        if ((this.bWA & 16) != 0) {
            contentValues.put("extupdateseq", Long.valueOf(this.mbw));
        }
        if ((this.bWA & 32) != 0) {
            contentValues.put("imgupdateseq", Long.valueOf(this.mbx));
        }
        if ((this.bWA & 64) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.dCV));
        }
        if ((this.bWA & 128) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.dSJ));
        }
        if ((this.bWA & 256) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.dHN));
        }
        if ((this.bWA & 512) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.dHO));
        }
        if ((this.bWA & 1024) != 0) {
            contentValues.put("reserved5", this.mby == null ? "" : this.mby);
        }
        if ((this.bWA & 2048) != 0) {
            contentValues.put("reserved6", this.mbz == null ? "" : this.mbz);
        }
        if ((this.bWA & 4096) != 0) {
            contentValues.put("reserved7", this.mbA == null ? "" : this.mbA);
        }
        if ((this.bWA & 8192) != 0) {
            contentValues.put("reserved8", this.mbB == null ? "" : this.mbB);
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String boa() {
        return this.extInfo == null ? "" : this.extInfo;
    }
}
