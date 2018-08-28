package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;

public final class am {
    int bWA = -1;
    int eLo = 0;
    int eLp = 0;
    int eLq = 0;
    int eLr = 0;
    int eLs = 0;
    int eLt = 0;
    String eLu = "";
    String eLv = "";

    public final void d(Cursor cursor) {
        this.eLo = cursor.getInt(0);
        this.eLp = cursor.getInt(1);
        this.eLq = cursor.getInt(2);
        this.eLr = cursor.getInt(3);
        this.eLs = cursor.getInt(4);
        this.eLt = cursor.getInt(5);
        this.eLu = cursor.getString(6);
        this.eLv = cursor.getString(7);
    }

    public final ContentValues XS() {
        ContentValues contentValues = new ContentValues();
        if ((this.bWA & 1) != 0) {
            contentValues.put("grouopid", Integer.valueOf(this.eLo));
        }
        if ((this.bWA & 2) != 0) {
            contentValues.put("membernum", Integer.valueOf(this.eLp));
        }
        if ((this.bWA & 4) != 0) {
            contentValues.put("weixinnum", Integer.valueOf(this.eLq));
        }
        if ((this.bWA & 8) != 0) {
            contentValues.put("insert_time", Integer.valueOf(this.eLr));
        }
        if ((this.bWA & 16) != 0) {
            contentValues.put("lastupdate_time", Integer.valueOf(this.eLs));
        }
        if ((this.bWA & 32) != 0) {
            contentValues.put("needupdate", Integer.valueOf(this.eLt));
        }
        if ((this.bWA & 64) != 0) {
            contentValues.put("updatekey", XT());
        }
        if ((this.bWA & 128) != 0) {
            contentValues.put("groupname", XU());
        }
        return contentValues;
    }

    public final String XT() {
        return this.eLu == null ? "" : this.eLu;
    }

    public final String XU() {
        return this.eLv == null ? "" : this.eLv;
    }
}
