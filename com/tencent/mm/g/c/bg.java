package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wy;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class bg extends c {
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS FavItemInfo_id_Index ON FavItemInfo(id)", "CREATE INDEX IF NOT EXISTS FavItemInfo_type_Index ON FavItemInfo(type)", "CREATE INDEX IF NOT EXISTS FavItemInfo_updateSeq_Index ON FavItemInfo(updateSeq)", "CREATE INDEX IF NOT EXISTS FavItemInfo_flag_Index ON FavItemInfo(flag)", "CREATE INDEX IF NOT EXISTS FavItemInfo_sourceId_Index ON FavItemInfo(sourceId)", "CREATE INDEX IF NOT EXISTS FavItemInfo_datatotalsize_Index ON FavItemInfo(datatotalsize)"};
    private static final int ciP = "rowid".hashCode();
    private static final int cke = "type".hashCode();
    private static final int ckf = "sourceType".hashCode();
    private static final int clj = "updateTime".hashCode();
    private static final int cne = "xml".hashCode();
    private static final int cnk = "flag".hashCode();
    private static final int cuh = "id".hashCode();
    private static final int cxT = "localId".hashCode();
    private static final int cyj = "localSeq".hashCode();
    private static final int cyk = "updateSeq".hashCode();
    private static final int cyl = "sourceId".hashCode();
    private static final int cym = "itemStatus".hashCode();
    private static final int cyn = "sourceCreateTime".hashCode();
    private static final int cyo = "fromUser".hashCode();
    private static final int cyp = "toUser".hashCode();
    private static final int cyq = "realChatName".hashCode();
    private static final int cyr = "favProto".hashCode();
    private static final int cys = "ext".hashCode();
    private static final int cyt = "edittime".hashCode();
    private static final int cyu = "tagProto".hashCode();
    private static final int cyv = "sessionId".hashCode();
    private static final int cyw = "datatotalsize".hashCode();
    private boolean cjI = true;
    private boolean cjJ = true;
    private boolean clh = true;
    private boolean cna = true;
    private boolean cni = true;
    private boolean cue = true;
    private boolean cxR = true;
    private boolean cxV = true;
    private boolean cxW = true;
    private boolean cxX = true;
    private boolean cxY = true;
    private boolean cxZ = true;
    private boolean cya = true;
    private boolean cyb = true;
    private boolean cyc = true;
    private boolean cyd = true;
    private boolean cye = true;
    private boolean cyf = true;
    private boolean cyg = true;
    private boolean cyh = true;
    private boolean cyi = true;
    public long field_datatotalsize;
    public long field_edittime;
    public String field_ext;
    public wl field_favProto;
    public int field_flag;
    public String field_fromUser;
    public int field_id;
    public int field_itemStatus;
    public long field_localId;
    public int field_localSeq;
    public String field_realChatName;
    public String field_sessionId;
    public long field_sourceCreateTime;
    public String field_sourceId;
    public int field_sourceType;
    public wy field_tagProto;
    public String field_toUser;
    public int field_type;
    public int field_updateSeq;
    public long field_updateTime;
    public String field_xml;

    public static a wI() {
        a aVar = new a();
        aVar.sKy = new Field[21];
        aVar.columns = new String[22];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.sKA.put("localId", "LONG PRIMARY KEY ");
        stringBuilder.append(" localId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "localId";
        aVar.columns[1] = "id";
        aVar.sKA.put("id", "INTEGER");
        stringBuilder.append(" id INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "type";
        aVar.sKA.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "localSeq";
        aVar.sKA.put("localSeq", "INTEGER");
        stringBuilder.append(" localSeq INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "updateSeq";
        aVar.sKA.put("updateSeq", "INTEGER");
        stringBuilder.append(" updateSeq INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "flag";
        aVar.sKA.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "sourceId";
        aVar.sKA.put("sourceId", "TEXT");
        stringBuilder.append(" sourceId TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "itemStatus";
        aVar.sKA.put("itemStatus", "INTEGER");
        stringBuilder.append(" itemStatus INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "sourceType";
        aVar.sKA.put("sourceType", "INTEGER");
        stringBuilder.append(" sourceType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "sourceCreateTime";
        aVar.sKA.put("sourceCreateTime", "LONG");
        stringBuilder.append(" sourceCreateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "updateTime";
        aVar.sKA.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "fromUser";
        aVar.sKA.put("fromUser", "TEXT");
        stringBuilder.append(" fromUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "toUser";
        aVar.sKA.put("toUser", "TEXT");
        stringBuilder.append(" toUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "realChatName";
        aVar.sKA.put("realChatName", "TEXT");
        stringBuilder.append(" realChatName TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "favProto";
        aVar.sKA.put("favProto", "BLOB");
        stringBuilder.append(" favProto BLOB");
        stringBuilder.append(", ");
        aVar.columns[15] = "xml";
        aVar.sKA.put("xml", "TEXT");
        stringBuilder.append(" xml TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "ext";
        aVar.sKA.put("ext", "TEXT");
        stringBuilder.append(" ext TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "edittime";
        aVar.sKA.put("edittime", "LONG");
        stringBuilder.append(" edittime LONG");
        stringBuilder.append(", ");
        aVar.columns[18] = "tagProto";
        aVar.sKA.put("tagProto", "BLOB");
        stringBuilder.append(" tagProto BLOB");
        stringBuilder.append(", ");
        aVar.columns[19] = "sessionId";
        aVar.sKA.put("sessionId", "TEXT");
        stringBuilder.append(" sessionId TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "datatotalsize";
        aVar.sKA.put("datatotalsize", "LONG");
        stringBuilder.append(" datatotalsize LONG");
        aVar.columns[21] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                byte[] blob;
                if (cxT == hashCode) {
                    this.field_localId = cursor.getLong(i);
                    this.cxR = true;
                } else if (cuh == hashCode) {
                    this.field_id = cursor.getInt(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (cyj == hashCode) {
                    this.field_localSeq = cursor.getInt(i);
                } else if (cyk == hashCode) {
                    this.field_updateSeq = cursor.getInt(i);
                } else if (cnk == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (cyl == hashCode) {
                    this.field_sourceId = cursor.getString(i);
                } else if (cym == hashCode) {
                    this.field_itemStatus = cursor.getInt(i);
                } else if (ckf == hashCode) {
                    this.field_sourceType = cursor.getInt(i);
                } else if (cyn == hashCode) {
                    this.field_sourceCreateTime = cursor.getLong(i);
                } else if (clj == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (cyo == hashCode) {
                    this.field_fromUser = cursor.getString(i);
                } else if (cyp == hashCode) {
                    this.field_toUser = cursor.getString(i);
                } else if (cyq == hashCode) {
                    this.field_realChatName = cursor.getString(i);
                } else if (cyr == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_favProto = (wl) new wl().aG(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseFavItemInfo", e.getMessage());
                    }
                } else if (cne == hashCode) {
                    this.field_xml = cursor.getString(i);
                } else if (cys == hashCode) {
                    this.field_ext = cursor.getString(i);
                } else if (cyt == hashCode) {
                    this.field_edittime = cursor.getLong(i);
                } else if (cyu == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_tagProto = (wy) new wy().aG(blob);
                        }
                    } catch (IOException e2) {
                        x.e("MicroMsg.SDK.BaseFavItemInfo", e2.getMessage());
                    }
                } else if (cyv == hashCode) {
                    this.field_sessionId = cursor.getString(i);
                } else if (cyw == hashCode) {
                    this.field_datatotalsize = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cxR) {
            contentValues.put("localId", Long.valueOf(this.field_localId));
        }
        if (this.cue) {
            contentValues.put("id", Integer.valueOf(this.field_id));
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.cxV) {
            contentValues.put("localSeq", Integer.valueOf(this.field_localSeq));
        }
        if (this.cxW) {
            contentValues.put("updateSeq", Integer.valueOf(this.field_updateSeq));
        }
        if (this.cni) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.cxX) {
            contentValues.put("sourceId", this.field_sourceId);
        }
        if (this.cxY) {
            contentValues.put("itemStatus", Integer.valueOf(this.field_itemStatus));
        }
        if (this.cjJ) {
            contentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
        }
        if (this.cxZ) {
            contentValues.put("sourceCreateTime", Long.valueOf(this.field_sourceCreateTime));
        }
        if (this.clh) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.cya) {
            contentValues.put("fromUser", this.field_fromUser);
        }
        if (this.cyb) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.cyc) {
            contentValues.put("realChatName", this.field_realChatName);
        }
        if (this.cyd && this.field_favProto != null) {
            try {
                contentValues.put("favProto", this.field_favProto.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseFavItemInfo", e.getMessage());
            }
        }
        if (this.cna) {
            contentValues.put("xml", this.field_xml);
        }
        if (this.cye) {
            contentValues.put("ext", this.field_ext);
        }
        if (this.cyf) {
            contentValues.put("edittime", Long.valueOf(this.field_edittime));
        }
        if (this.cyg && this.field_tagProto != null) {
            try {
                contentValues.put("tagProto", this.field_tagProto.toByteArray());
            } catch (IOException e2) {
                x.e("MicroMsg.SDK.BaseFavItemInfo", e2.getMessage());
            }
        }
        if (this.cyh) {
            contentValues.put("sessionId", this.field_sessionId);
        }
        if (this.cyi) {
            contentValues.put("datatotalsize", Long.valueOf(this.field_datatotalsize));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
