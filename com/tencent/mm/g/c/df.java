package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class df extends c {
    private static final int cKA = "messageListStr".hashCode();
    private static final int cKB = "serviceInfoListStr".hashCode();
    private static final int cKC = "bizAccountListStr".hashCode();
    private static final int cKs = "originalArticleCount".hashCode();
    private static final int cKt = "friendSubscribeCount".hashCode();
    private static final int cKu = "allArticleWording".hashCode();
    private static final int cKv = "historyArticlesUrl".hashCode();
    private static final int cKw = "userRole".hashCode();
    private static final int cKx = "banReason".hashCode();
    private static final int cKy = "showRecommendArticle".hashCode();
    private static final int cKz = "showService".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cli = "username".hashCode();
    private boolean cKh = true;
    private boolean cKi = true;
    private boolean cKj = true;
    private boolean cKk = true;
    private boolean cKl = true;
    private boolean cKm = true;
    private boolean cKn = true;
    private boolean cKo = true;
    private boolean cKp = true;
    private boolean cKq = true;
    private boolean cKr = true;
    private boolean clg = true;
    public String field_allArticleWording;
    public String field_banReason;
    public String field_bizAccountListStr;
    public int field_friendSubscribeCount;
    public String field_historyArticlesUrl;
    public String field_messageListStr;
    public int field_originalArticleCount;
    public String field_serviceInfoListStr;
    public int field_showRecommendArticle;
    public int field_showService;
    public int field_userRole;
    public String field_username;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.clg = true;
                } else if (cKs == hashCode) {
                    this.field_originalArticleCount = cursor.getInt(i);
                } else if (cKt == hashCode) {
                    this.field_friendSubscribeCount = cursor.getInt(i);
                } else if (cKu == hashCode) {
                    this.field_allArticleWording = cursor.getString(i);
                } else if (cKv == hashCode) {
                    this.field_historyArticlesUrl = cursor.getString(i);
                } else if (cKw == hashCode) {
                    this.field_userRole = cursor.getInt(i);
                } else if (cKx == hashCode) {
                    this.field_banReason = cursor.getString(i);
                } else if (cKy == hashCode) {
                    this.field_showRecommendArticle = cursor.getInt(i);
                } else if (cKz == hashCode) {
                    this.field_showService = cursor.getInt(i);
                } else if (cKA == hashCode) {
                    this.field_messageListStr = cursor.getString(i);
                } else if (cKB == hashCode) {
                    this.field_serviceInfoListStr = cursor.getString(i);
                } else if (cKC == hashCode) {
                    this.field_bizAccountListStr = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.clg) {
            contentValues.put("username", this.field_username);
        }
        if (this.cKh) {
            contentValues.put("originalArticleCount", Integer.valueOf(this.field_originalArticleCount));
        }
        if (this.cKi) {
            contentValues.put("friendSubscribeCount", Integer.valueOf(this.field_friendSubscribeCount));
        }
        if (this.cKj) {
            contentValues.put("allArticleWording", this.field_allArticleWording);
        }
        if (this.cKk) {
            contentValues.put("historyArticlesUrl", this.field_historyArticlesUrl);
        }
        if (this.cKl) {
            contentValues.put("userRole", Integer.valueOf(this.field_userRole));
        }
        if (this.cKm) {
            contentValues.put("banReason", this.field_banReason);
        }
        if (this.cKn) {
            contentValues.put("showRecommendArticle", Integer.valueOf(this.field_showRecommendArticle));
        }
        if (this.cKo) {
            contentValues.put("showService", Integer.valueOf(this.field_showService));
        }
        if (this.cKp) {
            contentValues.put("messageListStr", this.field_messageListStr);
        }
        if (this.cKq) {
            contentValues.put("serviceInfoListStr", this.field_serviceInfoListStr);
        }
        if (this.cKr) {
            contentValues.put("bizAccountListStr", this.field_bizAccountListStr);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
