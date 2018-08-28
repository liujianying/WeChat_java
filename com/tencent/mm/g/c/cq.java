package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.btb;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public abstract class cq extends c {
    private static final int cID = "tipId".hashCode();
    private static final int cIE = "tipVersion".hashCode();
    private static final int cIF = "tipkey".hashCode();
    private static final int cIG = "tipType".hashCode();
    private static final int cIH = "isExit".hashCode();
    private static final int cII = "hadRead".hashCode();
    private static final int cIJ = "isReject".hashCode();
    private static final int cIK = "beginShowTime".hashCode();
    private static final int cIL = "disappearTime".hashCode();
    private static final int cIM = "overdueTime".hashCode();
    private static final int cIN = "tipsShowInfo".hashCode();
    private static final int cIO = "pagestaytime".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cps = "extInfo".hashCode();
    private boolean cIA = true;
    private boolean cIB = true;
    private boolean cIC = true;
    private boolean cIr = true;
    private boolean cIs = true;
    private boolean cIt = true;
    private boolean cIu = true;
    private boolean cIv = true;
    private boolean cIw = true;
    private boolean cIx = true;
    private boolean cIy = true;
    private boolean cIz = true;
    private boolean cpe = true;
    public long field_beginShowTime;
    public long field_disappearTime;
    public String field_extInfo;
    public boolean field_hadRead;
    public boolean field_isExit;
    public boolean field_isReject;
    public long field_overdueTime;
    public long field_pagestaytime;
    public int field_tipId;
    public int field_tipType;
    public int field_tipVersion;
    public String field_tipkey;
    public btb field_tipsShowInfo;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cID == hashCode) {
                    this.field_tipId = cursor.getInt(i);
                    this.cIr = true;
                } else if (cIE == hashCode) {
                    this.field_tipVersion = cursor.getInt(i);
                } else if (cIF == hashCode) {
                    this.field_tipkey = cursor.getString(i);
                } else if (cIG == hashCode) {
                    this.field_tipType = cursor.getInt(i);
                } else if (cIH == hashCode) {
                    this.field_isExit = cursor.getInt(i) != 0;
                } else if (cII == hashCode) {
                    this.field_hadRead = cursor.getInt(i) != 0;
                } else if (cIJ == hashCode) {
                    this.field_isReject = cursor.getInt(i) != 0;
                } else if (cIK == hashCode) {
                    this.field_beginShowTime = cursor.getLong(i);
                } else if (cIL == hashCode) {
                    this.field_disappearTime = cursor.getLong(i);
                } else if (cIM == hashCode) {
                    this.field_overdueTime = cursor.getLong(i);
                } else if (cIN == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_tipsShowInfo = (btb) new btb().aG(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseNewTipsInfo", e.getMessage());
                    }
                } else if (cps == hashCode) {
                    this.field_extInfo = cursor.getString(i);
                } else if (cIO == hashCode) {
                    this.field_pagestaytime = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cIr) {
            contentValues.put("tipId", Integer.valueOf(this.field_tipId));
        }
        if (this.cIs) {
            contentValues.put("tipVersion", Integer.valueOf(this.field_tipVersion));
        }
        if (this.cIt) {
            contentValues.put("tipkey", this.field_tipkey);
        }
        if (this.cIu) {
            contentValues.put("tipType", Integer.valueOf(this.field_tipType));
        }
        if (this.cIv) {
            contentValues.put("isExit", Boolean.valueOf(this.field_isExit));
        }
        if (this.cIw) {
            contentValues.put("hadRead", Boolean.valueOf(this.field_hadRead));
        }
        if (this.cIx) {
            contentValues.put("isReject", Boolean.valueOf(this.field_isReject));
        }
        if (this.cIy) {
            contentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
        }
        if (this.cIz) {
            contentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
        }
        if (this.cIA) {
            contentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
        }
        if (this.cIB && this.field_tipsShowInfo != null) {
            try {
                contentValues.put("tipsShowInfo", this.field_tipsShowInfo.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseNewTipsInfo", e.getMessage());
            }
        }
        if (this.cpe) {
            contentValues.put("extInfo", this.field_extInfo);
        }
        if (this.cIC) {
            contentValues.put("pagestaytime", Long.valueOf(this.field_pagestaytime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
