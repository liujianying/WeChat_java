package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.sns.data.i;

public final class r {
    long createTime;
    private int eJD;
    private long nJG;
    public int nJH;
    public String nJI;
    private int nJJ;
    private long nJK;
    public String nJL;
    public byte[] nJM;
    public int nJc;
    public int offset;
    public int type;
    private String userName;

    public final ContentValues bBA() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("seqId", Long.valueOf(this.nJG));
        contentValues.put("type", Integer.valueOf(this.type));
        contentValues.put("createTime", Long.valueOf(this.createTime));
        contentValues.put("userName", this.userName);
        contentValues.put("totallen", Integer.valueOf(this.nJH));
        contentValues.put("offset", Integer.valueOf(this.offset));
        contentValues.put("local_flag", Integer.valueOf(this.eJD));
        contentValues.put("tmp_path", this.nJI);
        contentValues.put("nums", Integer.valueOf(this.nJJ));
        contentValues.put("try_times", Long.valueOf(this.nJK));
        contentValues.put("StrId", this.nJL);
        contentValues.put("upload_buf", this.nJM);
        return contentValues;
    }

    public final void d(Cursor cursor) {
        this.nJc = cursor.getInt(0);
        long j = cursor.getLong(1);
        this.nJG = j;
        this.nJL = i.eF(j);
        this.type = cursor.getInt(2);
        this.createTime = cursor.getLong(3);
        this.userName = cursor.getString(4);
        this.nJH = cursor.getInt(5);
        this.offset = cursor.getInt(6);
        this.eJD = cursor.getInt(7);
        this.nJI = cursor.getString(8);
        this.nJJ = cursor.getInt(9);
        this.nJK = cursor.getLong(10);
        this.nJL = cursor.getString(11);
        this.nJM = cursor.getBlob(12);
    }

    public final void bBB() {
        this.eJD |= 4;
    }

    public final void bBC() {
        this.eJD &= -5;
    }
}
