package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ah extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int crA = "chatroomname".hashCode();
    private static final int crB = "addtime".hashCode();
    private static final int crC = "memberlist".hashCode();
    private static final int crD = "displayname".hashCode();
    private static final int crE = "chatroomnick".hashCode();
    private static final int crF = "roomflag".hashCode();
    private static final int crG = "roomowner".hashCode();
    private static final int crH = "roomdata".hashCode();
    private static final int crI = "isShowname".hashCode();
    private static final int crJ = "selfDisplayName".hashCode();
    private static final int crK = "style".hashCode();
    private static final int crL = "chatroomdataflag".hashCode();
    private static final int crM = "modifytime".hashCode();
    private static final int crN = "chatroomnotice".hashCode();
    private static final int crO = "chatroomVersion".hashCode();
    private static final int crP = "chatroomnoticeEditor".hashCode();
    private static final int crQ = "chatroomnoticePublishTime".hashCode();
    private static final int crR = "chatroomLocalVersion".hashCode();
    private boolean cri = true;
    private boolean crj = true;
    private boolean crk = true;
    private boolean crl = true;
    private boolean crm = true;
    private boolean crn = true;
    private boolean cro = true;
    private boolean crp = true;
    private boolean crq = true;
    private boolean crr = true;
    private boolean crs = true;
    private boolean crt = true;
    private boolean cru = true;
    private boolean crv = true;
    private boolean crw = true;
    private boolean crx = true;
    private boolean cry = true;
    private boolean crz = true;
    public long field_addtime;
    public long field_chatroomLocalVersion;
    public int field_chatroomVersion;
    public int field_chatroomdataflag;
    public String field_chatroomname;
    public String field_chatroomnick;
    public String field_chatroomnotice;
    public String field_chatroomnoticeEditor;
    public long field_chatroomnoticePublishTime;
    public String field_displayname;
    public int field_isShowname;
    public String field_memberlist;
    public long field_modifytime;
    public byte[] field_roomdata;
    public int field_roomflag;
    public String field_roomowner;
    public String field_selfDisplayName;
    public int field_style;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (crA == hashCode) {
                    this.field_chatroomname = cursor.getString(i);
                    this.cri = true;
                } else if (crB == hashCode) {
                    this.field_addtime = cursor.getLong(i);
                } else if (crC == hashCode) {
                    this.field_memberlist = cursor.getString(i);
                } else if (crD == hashCode) {
                    this.field_displayname = cursor.getString(i);
                } else if (crE == hashCode) {
                    this.field_chatroomnick = cursor.getString(i);
                } else if (crF == hashCode) {
                    this.field_roomflag = cursor.getInt(i);
                } else if (crG == hashCode) {
                    this.field_roomowner = cursor.getString(i);
                } else if (crH == hashCode) {
                    this.field_roomdata = cursor.getBlob(i);
                } else if (crI == hashCode) {
                    this.field_isShowname = cursor.getInt(i);
                } else if (crJ == hashCode) {
                    this.field_selfDisplayName = cursor.getString(i);
                } else if (crK == hashCode) {
                    this.field_style = cursor.getInt(i);
                } else if (crL == hashCode) {
                    this.field_chatroomdataflag = cursor.getInt(i);
                } else if (crM == hashCode) {
                    this.field_modifytime = cursor.getLong(i);
                } else if (crN == hashCode) {
                    this.field_chatroomnotice = cursor.getString(i);
                } else if (crO == hashCode) {
                    this.field_chatroomVersion = cursor.getInt(i);
                } else if (crP == hashCode) {
                    this.field_chatroomnoticeEditor = cursor.getString(i);
                } else if (crQ == hashCode) {
                    this.field_chatroomnoticePublishTime = cursor.getLong(i);
                } else if (crR == hashCode) {
                    this.field_chatroomLocalVersion = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.field_chatroomname == null) {
            this.field_chatroomname = "";
        }
        if (this.cri) {
            contentValues.put("chatroomname", this.field_chatroomname);
        }
        if (this.crj) {
            contentValues.put("addtime", Long.valueOf(this.field_addtime));
        }
        if (this.crk) {
            contentValues.put("memberlist", this.field_memberlist);
        }
        if (this.crl) {
            contentValues.put("displayname", this.field_displayname);
        }
        if (this.crm) {
            contentValues.put("chatroomnick", this.field_chatroomnick);
        }
        if (this.crn) {
            contentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
        }
        if (this.cro) {
            contentValues.put("roomowner", this.field_roomowner);
        }
        if (this.crp) {
            contentValues.put("roomdata", this.field_roomdata);
        }
        if (this.crq) {
            contentValues.put("isShowname", Integer.valueOf(this.field_isShowname));
        }
        if (this.crr) {
            contentValues.put("selfDisplayName", this.field_selfDisplayName);
        }
        if (this.crs) {
            contentValues.put("style", Integer.valueOf(this.field_style));
        }
        if (this.crt) {
            contentValues.put("chatroomdataflag", Integer.valueOf(this.field_chatroomdataflag));
        }
        if (this.cru) {
            contentValues.put("modifytime", Long.valueOf(this.field_modifytime));
        }
        if (this.crv) {
            contentValues.put("chatroomnotice", this.field_chatroomnotice);
        }
        if (this.crw) {
            contentValues.put("chatroomVersion", Integer.valueOf(this.field_chatroomVersion));
        }
        if (this.crx) {
            contentValues.put("chatroomnoticeEditor", this.field_chatroomnoticeEditor);
        }
        if (this.cry) {
            contentValues.put("chatroomnoticePublishTime", Long.valueOf(this.field_chatroomnoticePublishTime));
        }
        if (this.crz) {
            contentValues.put("chatroomLocalVersion", Long.valueOf(this.field_chatroomLocalVersion));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
