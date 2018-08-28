package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ca extends c {
    private static final int cDe = "rankID".hashCode();
    private static final int cDf = "appusername".hashCode();
    private static final int cDi = "score".hashCode();
    private static final int cDo = "ranknum".hashCode();
    private static final int cDp = "likecount".hashCode();
    private static final int cDq = "selfLikeState".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cli = "username".hashCode();
    private boolean cDb = true;
    private boolean cDc = true;
    private boolean cDh = true;
    private boolean cDl = true;
    private boolean cDm = true;
    private boolean cDn = true;
    private boolean clg = true;
    public String field_appusername;
    public int field_likecount;
    public String field_rankID;
    public int field_ranknum;
    public int field_score;
    public int field_selfLikeState;
    public String field_username;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cDe == hashCode) {
                    this.field_rankID = cursor.getString(i);
                } else if (cDf == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (cDo == hashCode) {
                    this.field_ranknum = cursor.getInt(i);
                } else if (cDi == hashCode) {
                    this.field_score = cursor.getInt(i);
                } else if (cDp == hashCode) {
                    this.field_likecount = cursor.getInt(i);
                } else if (cDq == hashCode) {
                    this.field_selfLikeState = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cDb) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.cDc) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.clg) {
            contentValues.put("username", this.field_username);
        }
        if (this.cDl) {
            contentValues.put("ranknum", Integer.valueOf(this.field_ranknum));
        }
        if (this.cDh) {
            contentValues.put("score", Integer.valueOf(this.field_score));
        }
        if (this.cDm) {
            contentValues.put("likecount", Integer.valueOf(this.field_likecount));
        }
        if (this.cDn) {
            contentValues.put("selfLikeState", Integer.valueOf(this.field_selfLikeState));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
