package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c;

public abstract class eg extends c {
    private static final int cEa = "createtime".hashCode();
    private static final int cPJ = FFmpegMetadataRetriever.METADATA_KEY_FILENAME.hashCode();
    private static final int cPK = "user".hashCode();
    private static final int cPL = "msgid".hashCode();
    private static final int cPM = "filenowsize".hashCode();
    private static final int cPN = "totallen".hashCode();
    private static final int cPO = "lastmodifytime".hashCode();
    private static final int cPP = "clientid".hashCode();
    private static final int cPQ = "voicelenght".hashCode();
    private static final int cPR = "msglocalid".hashCode();
    private static final int cPS = "human".hashCode();
    private static final int cPT = "voiceformat".hashCode();
    private static final int cPU = "nettimes".hashCode();
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS voiceRemindFileNameIndex ON VoiceRemindInfo(filename)"};
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int ckV = "offset".hashCode();
    private static final int cvS = "reserved1".hashCode();
    private static final int cvT = "reserved2".hashCode();
    private boolean cDV = true;
    private boolean cPA = true;
    private boolean cPB = true;
    private boolean cPC = true;
    private boolean cPD = true;
    private boolean cPE = true;
    private boolean cPF = true;
    private boolean cPG = true;
    private boolean cPH = true;
    private boolean cPI = true;
    private boolean cPx = true;
    private boolean cPy = true;
    private boolean cPz = true;
    private boolean ciS = true;
    private boolean ckE = true;
    private boolean cvq = true;
    private boolean cvr = true;
    public String field_clientid;
    public long field_createtime;
    public String field_filename;
    public int field_filenowsize;
    public String field_human;
    public long field_lastmodifytime;
    public long field_msgid;
    public int field_msglocalid;
    public int field_nettimes;
    public int field_offset;
    public int field_reserved1;
    public String field_reserved2;
    public int field_status;
    public int field_totallen;
    public String field_user;
    public int field_voiceformat;
    public int field_voicelenght;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cPJ == hashCode) {
                    this.field_filename = cursor.getString(i);
                } else if (cPK == hashCode) {
                    this.field_user = cursor.getString(i);
                } else if (cPL == hashCode) {
                    this.field_msgid = cursor.getLong(i);
                } else if (ckV == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (cPM == hashCode) {
                    this.field_filenowsize = cursor.getInt(i);
                } else if (cPN == hashCode) {
                    this.field_totallen = cursor.getInt(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cEa == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (cPO == hashCode) {
                    this.field_lastmodifytime = cursor.getLong(i);
                } else if (cPP == hashCode) {
                    this.field_clientid = cursor.getString(i);
                } else if (cPQ == hashCode) {
                    this.field_voicelenght = cursor.getInt(i);
                } else if (cPR == hashCode) {
                    this.field_msglocalid = cursor.getInt(i);
                } else if (cPS == hashCode) {
                    this.field_human = cursor.getString(i);
                } else if (cPT == hashCode) {
                    this.field_voiceformat = cursor.getInt(i);
                } else if (cPU == hashCode) {
                    this.field_nettimes = cursor.getInt(i);
                } else if (cvS == hashCode) {
                    this.field_reserved1 = cursor.getInt(i);
                } else if (cvT == hashCode) {
                    this.field_reserved2 = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cPx) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_FILENAME, this.field_filename);
        }
        if (this.cPy) {
            contentValues.put("user", this.field_user);
        }
        if (this.cPz) {
            contentValues.put("msgid", Long.valueOf(this.field_msgid));
        }
        if (this.ckE) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.cPA) {
            contentValues.put("filenowsize", Integer.valueOf(this.field_filenowsize));
        }
        if (this.cPB) {
            contentValues.put("totallen", Integer.valueOf(this.field_totallen));
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cDV) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.cPC) {
            contentValues.put("lastmodifytime", Long.valueOf(this.field_lastmodifytime));
        }
        if (this.cPD) {
            contentValues.put("clientid", this.field_clientid);
        }
        if (this.cPE) {
            contentValues.put("voicelenght", Integer.valueOf(this.field_voicelenght));
        }
        if (this.cPF) {
            contentValues.put("msglocalid", Integer.valueOf(this.field_msglocalid));
        }
        if (this.cPG) {
            contentValues.put("human", this.field_human);
        }
        if (this.cPH) {
            contentValues.put("voiceformat", Integer.valueOf(this.field_voiceformat));
        }
        if (this.cPI) {
            contentValues.put("nettimes", Integer.valueOf(this.field_nettimes));
        }
        if (this.cvq) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.cvr) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
