package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class cp extends c {
    private static final int cHK = "musicId".hashCode();
    private static final int cHL = "originMusicId".hashCode();
    private static final int cHM = "musicType".hashCode();
    private static final int cHN = "downloadedLength".hashCode();
    private static final int cHO = "wifiDownloadedLength".hashCode();
    private static final int cHP = "endFlag".hashCode();
    private static final int cHQ = "wifiEndFlag".hashCode();
    private static final int cHR = "songId".hashCode();
    private static final int cHS = "songName".hashCode();
    private static final int cHT = "songSinger".hashCode();
    private static final int cHU = "songAlbum".hashCode();
    private static final int cHV = "songAlbumType".hashCode();
    private static final int cHW = "songAlbumUrl".hashCode();
    private static final int cHX = "songHAlbumUrl".hashCode();
    private static final int cHY = "songAlbumLocalPath".hashCode();
    private static final int cHZ = "songWifiUrl".hashCode();
    private static final int cIa = "songWapLinkUrl".hashCode();
    private static final int cIb = "songWebUrl".hashCode();
    private static final int cIc = "songMediaId".hashCode();
    private static final int cId = "songSnsAlbumUser".hashCode();
    private static final int cIe = "songSnsShareUser".hashCode();
    private static final int cIf = "songLyric".hashCode();
    private static final int cIg = "songBgColor".hashCode();
    private static final int cIh = "songLyricColor".hashCode();
    private static final int cIi = "songFileLength".hashCode();
    private static final int cIj = "songWifiFileLength".hashCode();
    private static final int cIk = "hideBanner".hashCode();
    private static final int cIl = "jsWebUrlDomain".hashCode();
    private static final int cIm = "isBlock".hashCode();
    private static final int cIn = "mimetype".hashCode();
    private static final int cIo = "protocol".hashCode();
    private static final int cIp = "barBackToWebView".hashCode();
    private static final int cIq = "musicbar_url".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cjj = "startTime".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int clj = "updateTime".hashCode();
    private boolean cHA = true;
    private boolean cHB = true;
    private boolean cHC = true;
    private boolean cHD = true;
    private boolean cHE = true;
    private boolean cHF = true;
    private boolean cHG = true;
    private boolean cHH = true;
    private boolean cHI = true;
    private boolean cHJ = true;
    private boolean cHd = true;
    private boolean cHe = true;
    private boolean cHf = true;
    private boolean cHg = true;
    private boolean cHh = true;
    private boolean cHi = true;
    private boolean cHj = true;
    private boolean cHk = true;
    private boolean cHl = true;
    private boolean cHm = true;
    private boolean cHn = true;
    private boolean cHo = true;
    private boolean cHp = true;
    private boolean cHq = true;
    private boolean cHr = true;
    private boolean cHs = true;
    private boolean cHt = true;
    private boolean cHu = true;
    private boolean cHv = true;
    private boolean cHw = true;
    private boolean cHx = true;
    private boolean cHy = true;
    private boolean cHz = true;
    private boolean cjb = true;
    private boolean cky = true;
    private boolean clh = true;
    public String field_appId;
    public boolean field_barBackToWebView;
    public long field_downloadedLength;
    public int field_endFlag;
    public boolean field_hideBanner;
    public int field_isBlock;
    public String field_jsWebUrlDomain;
    public String field_mimetype;
    public String field_musicId;
    public int field_musicType;
    public String field_musicbar_url;
    public String field_originMusicId;
    public String field_protocol;
    public String field_songAlbum;
    public String field_songAlbumLocalPath;
    public int field_songAlbumType;
    public String field_songAlbumUrl;
    public int field_songBgColor;
    public long field_songFileLength;
    public String field_songHAlbumUrl;
    public int field_songId;
    public String field_songLyric;
    public int field_songLyricColor;
    public String field_songMediaId;
    public String field_songName;
    public String field_songSinger;
    public String field_songSnsAlbumUser;
    public String field_songSnsShareUser;
    public String field_songWapLinkUrl;
    public String field_songWebUrl;
    public long field_songWifiFileLength;
    public String field_songWifiUrl;
    public int field_startTime;
    public long field_updateTime;
    public long field_wifiDownloadedLength;
    public int field_wifiEndFlag;

    public static a wI() {
        a aVar = new a();
        aVar.sKy = new Field[36];
        aVar.columns = new String[37];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "musicId";
        aVar.sKA.put("musicId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" musicId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "musicId";
        aVar.columns[1] = "originMusicId";
        aVar.sKA.put("originMusicId", "TEXT");
        stringBuilder.append(" originMusicId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "musicType";
        aVar.sKA.put("musicType", "INTEGER");
        stringBuilder.append(" musicType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "downloadedLength";
        aVar.sKA.put("downloadedLength", "LONG");
        stringBuilder.append(" downloadedLength LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "wifiDownloadedLength";
        aVar.sKA.put("wifiDownloadedLength", "LONG");
        stringBuilder.append(" wifiDownloadedLength LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "endFlag";
        aVar.sKA.put("endFlag", "INTEGER");
        stringBuilder.append(" endFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "wifiEndFlag";
        aVar.sKA.put("wifiEndFlag", "INTEGER");
        stringBuilder.append(" wifiEndFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "updateTime";
        aVar.sKA.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "songId";
        aVar.sKA.put("songId", "INTEGER");
        stringBuilder.append(" songId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "songName";
        aVar.sKA.put("songName", "TEXT");
        stringBuilder.append(" songName TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "songSinger";
        aVar.sKA.put("songSinger", "TEXT");
        stringBuilder.append(" songSinger TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "songAlbum";
        aVar.sKA.put("songAlbum", "TEXT");
        stringBuilder.append(" songAlbum TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "songAlbumType";
        aVar.sKA.put("songAlbumType", "INTEGER");
        stringBuilder.append(" songAlbumType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "songAlbumUrl";
        aVar.sKA.put("songAlbumUrl", "TEXT");
        stringBuilder.append(" songAlbumUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "songHAlbumUrl";
        aVar.sKA.put("songHAlbumUrl", "TEXT");
        stringBuilder.append(" songHAlbumUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "songAlbumLocalPath";
        aVar.sKA.put("songAlbumLocalPath", "TEXT");
        stringBuilder.append(" songAlbumLocalPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "songWifiUrl";
        aVar.sKA.put("songWifiUrl", "TEXT");
        stringBuilder.append(" songWifiUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "songWapLinkUrl";
        aVar.sKA.put("songWapLinkUrl", "TEXT");
        stringBuilder.append(" songWapLinkUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "songWebUrl";
        aVar.sKA.put("songWebUrl", "TEXT");
        stringBuilder.append(" songWebUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "songMediaId";
        aVar.sKA.put("songMediaId", "TEXT");
        stringBuilder.append(" songMediaId TEXT");
        stringBuilder.append(", ");
        aVar.columns[21] = "songSnsAlbumUser";
        aVar.sKA.put("songSnsAlbumUser", "TEXT");
        stringBuilder.append(" songSnsAlbumUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "songSnsShareUser";
        aVar.sKA.put("songSnsShareUser", "TEXT");
        stringBuilder.append(" songSnsShareUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[23] = "songLyric";
        aVar.sKA.put("songLyric", "TEXT");
        stringBuilder.append(" songLyric TEXT");
        stringBuilder.append(", ");
        aVar.columns[24] = "songBgColor";
        aVar.sKA.put("songBgColor", "INTEGER");
        stringBuilder.append(" songBgColor INTEGER");
        stringBuilder.append(", ");
        aVar.columns[25] = "songLyricColor";
        aVar.sKA.put("songLyricColor", "INTEGER");
        stringBuilder.append(" songLyricColor INTEGER");
        stringBuilder.append(", ");
        aVar.columns[26] = "songFileLength";
        aVar.sKA.put("songFileLength", "LONG");
        stringBuilder.append(" songFileLength LONG");
        stringBuilder.append(", ");
        aVar.columns[27] = "songWifiFileLength";
        aVar.sKA.put("songWifiFileLength", "LONG");
        stringBuilder.append(" songWifiFileLength LONG");
        stringBuilder.append(", ");
        aVar.columns[28] = "hideBanner";
        aVar.sKA.put("hideBanner", "INTEGER");
        stringBuilder.append(" hideBanner INTEGER");
        stringBuilder.append(", ");
        aVar.columns[29] = "jsWebUrlDomain";
        aVar.sKA.put("jsWebUrlDomain", "TEXT");
        stringBuilder.append(" jsWebUrlDomain TEXT");
        stringBuilder.append(", ");
        aVar.columns[30] = "isBlock";
        aVar.sKA.put("isBlock", "INTEGER");
        stringBuilder.append(" isBlock INTEGER");
        stringBuilder.append(", ");
        aVar.columns[31] = "startTime";
        aVar.sKA.put("startTime", "INTEGER");
        stringBuilder.append(" startTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[32] = "mimetype";
        aVar.sKA.put("mimetype", "TEXT");
        stringBuilder.append(" mimetype TEXT");
        stringBuilder.append(", ");
        aVar.columns[33] = "protocol";
        aVar.sKA.put("protocol", "TEXT");
        stringBuilder.append(" protocol TEXT");
        stringBuilder.append(", ");
        aVar.columns[34] = "barBackToWebView";
        aVar.sKA.put("barBackToWebView", "INTEGER");
        stringBuilder.append(" barBackToWebView INTEGER");
        stringBuilder.append(", ");
        aVar.columns[35] = "musicbar_url";
        aVar.sKA.put("musicbar_url", "TEXT");
        stringBuilder.append(" musicbar_url TEXT");
        aVar.columns[36] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cHK == hashCode) {
                    this.field_musicId = cursor.getString(i);
                    this.cHd = true;
                } else if (cHL == hashCode) {
                    this.field_originMusicId = cursor.getString(i);
                } else if (cHM == hashCode) {
                    this.field_musicType = cursor.getInt(i);
                } else if (cHN == hashCode) {
                    this.field_downloadedLength = cursor.getLong(i);
                } else if (cHO == hashCode) {
                    this.field_wifiDownloadedLength = cursor.getLong(i);
                } else if (cHP == hashCode) {
                    this.field_endFlag = cursor.getInt(i);
                } else if (cHQ == hashCode) {
                    this.field_wifiEndFlag = cursor.getInt(i);
                } else if (clj == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (cHR == hashCode) {
                    this.field_songId = cursor.getInt(i);
                } else if (cHS == hashCode) {
                    this.field_songName = cursor.getString(i);
                } else if (cHT == hashCode) {
                    this.field_songSinger = cursor.getString(i);
                } else if (cHU == hashCode) {
                    this.field_songAlbum = cursor.getString(i);
                } else if (cHV == hashCode) {
                    this.field_songAlbumType = cursor.getInt(i);
                } else if (cHW == hashCode) {
                    this.field_songAlbumUrl = cursor.getString(i);
                } else if (cHX == hashCode) {
                    this.field_songHAlbumUrl = cursor.getString(i);
                } else if (cHY == hashCode) {
                    this.field_songAlbumLocalPath = cursor.getString(i);
                } else if (cHZ == hashCode) {
                    this.field_songWifiUrl = cursor.getString(i);
                } else if (cIa == hashCode) {
                    this.field_songWapLinkUrl = cursor.getString(i);
                } else if (cIb == hashCode) {
                    this.field_songWebUrl = cursor.getString(i);
                } else if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (cIc == hashCode) {
                    this.field_songMediaId = cursor.getString(i);
                } else if (cId == hashCode) {
                    this.field_songSnsAlbumUser = cursor.getString(i);
                } else if (cIe == hashCode) {
                    this.field_songSnsShareUser = cursor.getString(i);
                } else if (cIf == hashCode) {
                    this.field_songLyric = cursor.getString(i);
                } else if (cIg == hashCode) {
                    this.field_songBgColor = cursor.getInt(i);
                } else if (cIh == hashCode) {
                    this.field_songLyricColor = cursor.getInt(i);
                } else if (cIi == hashCode) {
                    this.field_songFileLength = cursor.getLong(i);
                } else if (cIj == hashCode) {
                    this.field_songWifiFileLength = cursor.getLong(i);
                } else if (cIk == hashCode) {
                    this.field_hideBanner = cursor.getInt(i) != 0;
                } else if (cIl == hashCode) {
                    this.field_jsWebUrlDomain = cursor.getString(i);
                } else if (cIm == hashCode) {
                    this.field_isBlock = cursor.getInt(i);
                } else if (cjj == hashCode) {
                    this.field_startTime = cursor.getInt(i);
                } else if (cIn == hashCode) {
                    this.field_mimetype = cursor.getString(i);
                } else if (cIo == hashCode) {
                    this.field_protocol = cursor.getString(i);
                } else if (cIp == hashCode) {
                    this.field_barBackToWebView = cursor.getInt(i) != 0;
                } else if (cIq == hashCode) {
                    this.field_musicbar_url = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cHd) {
            contentValues.put("musicId", this.field_musicId);
        }
        if (this.cHe) {
            contentValues.put("originMusicId", this.field_originMusicId);
        }
        if (this.cHf) {
            contentValues.put("musicType", Integer.valueOf(this.field_musicType));
        }
        if (this.cHg) {
            contentValues.put("downloadedLength", Long.valueOf(this.field_downloadedLength));
        }
        if (this.cHh) {
            contentValues.put("wifiDownloadedLength", Long.valueOf(this.field_wifiDownloadedLength));
        }
        if (this.cHi) {
            contentValues.put("endFlag", Integer.valueOf(this.field_endFlag));
        }
        if (this.cHj) {
            contentValues.put("wifiEndFlag", Integer.valueOf(this.field_wifiEndFlag));
        }
        if (this.clh) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.cHk) {
            contentValues.put("songId", Integer.valueOf(this.field_songId));
        }
        if (this.cHl) {
            contentValues.put("songName", this.field_songName);
        }
        if (this.cHm) {
            contentValues.put("songSinger", this.field_songSinger);
        }
        if (this.cHn) {
            contentValues.put("songAlbum", this.field_songAlbum);
        }
        if (this.cHo) {
            contentValues.put("songAlbumType", Integer.valueOf(this.field_songAlbumType));
        }
        if (this.cHp) {
            contentValues.put("songAlbumUrl", this.field_songAlbumUrl);
        }
        if (this.cHq) {
            contentValues.put("songHAlbumUrl", this.field_songHAlbumUrl);
        }
        if (this.cHr) {
            contentValues.put("songAlbumLocalPath", this.field_songAlbumLocalPath);
        }
        if (this.cHs) {
            contentValues.put("songWifiUrl", this.field_songWifiUrl);
        }
        if (this.cHt) {
            contentValues.put("songWapLinkUrl", this.field_songWapLinkUrl);
        }
        if (this.cHu) {
            contentValues.put("songWebUrl", this.field_songWebUrl);
        }
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.cHv) {
            contentValues.put("songMediaId", this.field_songMediaId);
        }
        if (this.cHw) {
            contentValues.put("songSnsAlbumUser", this.field_songSnsAlbumUser);
        }
        if (this.cHx) {
            contentValues.put("songSnsShareUser", this.field_songSnsShareUser);
        }
        if (this.cHy) {
            contentValues.put("songLyric", this.field_songLyric);
        }
        if (this.cHz) {
            contentValues.put("songBgColor", Integer.valueOf(this.field_songBgColor));
        }
        if (this.cHA) {
            contentValues.put("songLyricColor", Integer.valueOf(this.field_songLyricColor));
        }
        if (this.cHB) {
            contentValues.put("songFileLength", Long.valueOf(this.field_songFileLength));
        }
        if (this.cHC) {
            contentValues.put("songWifiFileLength", Long.valueOf(this.field_songWifiFileLength));
        }
        if (this.cHD) {
            contentValues.put("hideBanner", Boolean.valueOf(this.field_hideBanner));
        }
        if (this.cHE) {
            contentValues.put("jsWebUrlDomain", this.field_jsWebUrlDomain);
        }
        if (this.cHF) {
            contentValues.put("isBlock", Integer.valueOf(this.field_isBlock));
        }
        if (this.cjb) {
            contentValues.put("startTime", Integer.valueOf(this.field_startTime));
        }
        if (this.cHG) {
            contentValues.put("mimetype", this.field_mimetype);
        }
        if (this.cHH) {
            contentValues.put("protocol", this.field_protocol);
        }
        if (this.cHI) {
            contentValues.put("barBackToWebView", Boolean.valueOf(this.field_barBackToWebView));
        }
        if (this.cHJ) {
            contentValues.put("musicbar_url", this.field_musicbar_url);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
