package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;

public final class p {
    int bWA = -1;
    private int dCV = 0;
    private String dCX = "";
    private String dCY = "";
    public int dLB = 0;
    private int dSJ = 0;
    public int eKy = 0;
    public String username = "";

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if ((this.bWA & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bWA & 2) != 0) {
            contentValues.put("friendtype", Integer.valueOf(this.eKy));
        }
        if ((this.bWA & 4) != 0) {
            contentValues.put("updatetime", Integer.valueOf(this.dLB));
        }
        if ((this.bWA & 8) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.dCV));
        }
        if ((this.bWA & 16) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.dSJ));
        }
        if ((this.bWA & 32) != 0) {
            contentValues.put("reserved3", this.dCX == null ? "" : this.dCX);
        }
        if ((this.bWA & 64) != 0) {
            contentValues.put("reserved4", this.dCY == null ? "" : this.dCY);
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }
}
