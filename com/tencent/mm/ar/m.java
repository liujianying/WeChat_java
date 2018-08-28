package com.tencent.mm.ar;

import android.content.ContentValues;
import android.database.Cursor;

public final class m {
    private String bNH = (this.id + "_" + this.bPh);
    public int bPh = 0;
    int bWA = -1;
    private String dHL = "";
    private String dHM = "";
    private int dHN = 0;
    private int dHO = 0;
    String ecV = "";
    public int id = 0;
    String name = "";
    int size = 0;
    public int status = 0;
    public int version = 0;

    public final void d(Cursor cursor) {
        this.version = cursor.getInt(2);
        this.name = cursor.getString(3);
        this.size = cursor.getInt(4);
        this.ecV = cursor.getString(5);
        this.status = cursor.getInt(6);
        this.dHL = cursor.getString(8);
        this.dHM = cursor.getString(9);
        this.bPh = cursor.getInt(7);
        this.dHO = cursor.getInt(11);
        this.id = cursor.getInt(1);
        this.dHN = cursor.getInt(10);
        this.bNH = cursor.getString(0);
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if ((this.bWA & 2) != 0) {
            contentValues.put("id", Integer.valueOf(this.id));
        }
        if ((this.bWA & 4) != 0) {
            contentValues.put("version", Integer.valueOf(this.version));
        }
        if ((this.bWA & 8) != 0) {
            contentValues.put("name", this.name == null ? "" : this.name);
        }
        if ((this.bWA & 16) != 0) {
            contentValues.put("size", Integer.valueOf(this.size));
        }
        if ((this.bWA & 32) != 0) {
            contentValues.put("packname", Ql());
        }
        if ((this.bWA & 64) != 0) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if ((this.bWA & 128) != 0) {
            contentValues.put("type", Integer.valueOf(this.bPh));
        }
        if ((this.bWA & 256) != 0) {
            contentValues.put("reserved1", this.dHL == null ? "" : this.dHL);
        }
        if ((this.bWA & 512) != 0) {
            contentValues.put("reserved2", this.dHM == null ? "" : this.dHM);
        }
        if ((this.bWA & 1024) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.dHN));
        }
        if ((this.bWA & 2048) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.dHO));
        }
        if ((this.bWA & 1) != 0) {
            contentValues.put("localId", this.id + "_" + this.bPh);
        }
        return contentValues;
    }

    public final String Ql() {
        return this.ecV == null ? "" : this.ecV;
    }
}
