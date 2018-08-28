package com.tencent.mm.ar;

import android.content.ContentValues;
import android.database.Cursor;

public final class a {
    int bWA = -1;
    private String dHL = "";
    private String dHM = "";
    private int dHN = 0;
    private int dHO = 0;
    public int ecv = 0;
    private String path = "";
    public String username = "";

    public final void d(Cursor cursor) {
        this.username = cursor.getString(0);
        this.ecv = cursor.getInt(1);
        this.path = cursor.getString(2);
        this.dHL = cursor.getString(3);
        this.dHM = cursor.getString(4);
        this.dHN = cursor.getInt(5);
        this.dHO = cursor.getInt(6);
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if ((this.bWA & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bWA & 2) != 0) {
            contentValues.put("bgflag", Integer.valueOf(this.ecv));
        }
        if ((this.bWA & 4) != 0) {
            contentValues.put("path", this.path == null ? "" : this.path);
        }
        if ((this.bWA & 8) != 0) {
            contentValues.put("reserved1", this.dHL == null ? "" : this.dHL);
        }
        if ((this.bWA & 16) != 0) {
            contentValues.put("reserved2", this.dHM == null ? "" : this.dHM);
        }
        if ((this.bWA & 32) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.dHN));
        }
        if ((this.bWA & 64) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.dHO));
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }
}
