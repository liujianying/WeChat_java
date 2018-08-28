package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;

public final class j {
    int bWA = -1;
    public int csJ = 0;
    public String csK = "";
    public String csL = "";
    public int sex = 0;
    public String signature = "";
    public String username = "";

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if ((this.bWA & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bWA & 2) != 0) {
            contentValues.put("sex", Integer.valueOf(this.sex));
        }
        if ((this.bWA & 4) != 0) {
            contentValues.put("personalcard", Integer.valueOf(this.csJ));
        }
        if ((this.bWA & 8) != 0) {
            contentValues.put("province", this.csK == null ? "" : this.csK);
        }
        if ((this.bWA & 16) != 0) {
            contentValues.put("city", this.csL == null ? "" : this.csL);
        }
        if ((this.bWA & 32) != 0) {
            String str;
            String str2 = "signature";
            if (this.signature == null) {
                str = "";
            } else {
                str = this.signature;
            }
            contentValues.put(str2, str);
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }
}
