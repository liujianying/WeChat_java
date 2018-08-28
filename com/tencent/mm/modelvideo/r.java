package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Map;

public final class r {
    public int bSX = 0;
    public int bWA = -1;
    public String bWJ = "";
    public long bYu = 0;
    public String bZN = "";
    public String cas = "";
    String clientId = "";
    public long createTime = 0;
    public int dHI = 0;
    public int dQo = 0;
    public String elu = "";
    public long emf = 0;
    public int emu = 0;
    public String enF = "";
    public int enH = 0;
    public int enI = 0;
    public int enJ = 0;
    public long enK = 0;
    public long enL = 0;
    public int enM = 0;
    public int enN = 0;
    public int enO = 0;
    public int enP = 0;
    public int enQ = 0;
    public int enR = 0;
    public String enS = "";
    public int enT = 0;
    public String enU = "";
    public bri enV = new bri();
    public aso enW = new aso();
    public String fileName = "";
    public int status = 0;
    public int videoFormat = 0;

    public static String nH(String str) {
        try {
            Map z = bl.z(str, "msg");
            if (z != null) {
                return (String) z.get(".msg.videomsg.$cdnvideourl");
            }
        } catch (Exception e) {
        }
        return "";
    }

    public final void d(Cursor cursor) {
        this.fileName = cursor.getString(0);
        this.clientId = cursor.getString(1);
        this.bYu = cursor.getLong(2);
        this.emu = cursor.getInt(3);
        this.enH = cursor.getInt(4);
        this.dHI = cursor.getInt(5);
        this.enI = cursor.getInt(6);
        this.enJ = cursor.getInt(7);
        this.status = cursor.getInt(8);
        this.createTime = cursor.getLong(9);
        this.enK = cursor.getLong(10);
        this.enL = cursor.getLong(11);
        this.enM = cursor.getInt(12);
        this.enN = cursor.getInt(13);
        this.enO = cursor.getInt(14);
        this.enP = cursor.getInt(15);
        this.bWJ = cursor.getString(16);
        this.enF = cursor.getString(17);
        this.enQ = cursor.getInt(18);
        this.enR = cursor.getInt(19);
        this.elu = cursor.getString(20);
        this.enS = cursor.getString(21);
        this.enT = cursor.getInt(22);
        this.emf = cursor.getLong(23);
        this.enU = cursor.getString(24);
        this.cas = cursor.getString(25);
        byte[] blob = cursor.getBlob(26);
        this.enV = new bri();
        try {
            this.enV.aG(blob);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoInfo", e, "", new Object[0]);
        }
        this.bZN = cursor.getString(27);
        this.dQo = cursor.getInt(28);
        blob = cursor.getBlob(29);
        this.enW = new aso();
        try {
            this.enW.aG(blob);
        } catch (Exception e2) {
        }
        this.bSX = cursor.getInt(30);
        this.videoFormat = cursor.getInt(31);
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if ((this.bWA & 1) != 0) {
            contentValues.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME, getFileName());
        }
        if ((this.bWA & 2) != 0) {
            contentValues.put("clientid", this.clientId == null ? "" : this.clientId);
        }
        if ((this.bWA & 4) != 0) {
            contentValues.put("msgsvrid", Long.valueOf(this.bYu));
        }
        if ((this.bWA & 8) != 0) {
            contentValues.put("netoffset", Integer.valueOf(this.emu));
        }
        if ((this.bWA & 16) != 0) {
            contentValues.put("filenowsize", Integer.valueOf(this.enH));
        }
        if ((this.bWA & 32) != 0) {
            contentValues.put("totallen", Integer.valueOf(this.dHI));
        }
        if ((this.bWA & 64) != 0) {
            contentValues.put("thumbnetoffset", Integer.valueOf(this.enI));
        }
        if ((this.bWA & 128) != 0) {
            contentValues.put("thumblen", Integer.valueOf(this.enJ));
        }
        if ((this.bWA & GLIcon.TOP) != 0) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.status));
        }
        if ((this.bWA & 512) != 0) {
            contentValues.put("createtime", Long.valueOf(this.createTime));
        }
        if ((this.bWA & 1024) != 0) {
            contentValues.put("lastmodifytime", Long.valueOf(this.enK));
        }
        if ((this.bWA & 2048) != 0) {
            contentValues.put("downloadtime", Long.valueOf(this.enL));
        }
        if ((this.bWA & GLIcon.LEFT) != 0) {
            contentValues.put("videolength", Integer.valueOf(this.enM));
        }
        if ((this.bWA & 8192) != 0) {
            contentValues.put("msglocalid", Integer.valueOf(this.enN));
        }
        if ((this.bWA & 16384) != 0) {
            contentValues.put("nettimes", Integer.valueOf(this.enO));
        }
        if ((this.bWA & 32768) != 0) {
            contentValues.put("cameratype", Integer.valueOf(this.enP));
        }
        if ((this.bWA & GLIcon.RIGHT) != 0) {
            contentValues.put("user", Tj());
        }
        if ((this.bWA & 131072) != 0) {
            contentValues.put("human", Tk());
        }
        if ((this.bWA & 262144) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.enQ));
        }
        if ((this.bWA & 524288) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.enR));
        }
        if ((this.bWA & 1048576) != 0) {
            contentValues.put("reserved3", Tl());
        }
        if ((this.bWA & 2097152) != 0) {
            contentValues.put("reserved4", Tm());
        }
        if ((this.bWA & 4194304) != 0) {
            contentValues.put("videofuncflag", Integer.valueOf(this.enT));
        }
        if ((this.bWA & 8388608) != 0) {
            contentValues.put("masssendid", Long.valueOf(this.emf));
        }
        if ((this.bWA & 16777216) != 0) {
            contentValues.put("masssendlist", this.enU);
        }
        if ((this.bWA & 33554432) != 0) {
            contentValues.put("videomd5", this.cas);
        }
        if ((this.bWA & 67108864) != 0) {
            contentValues.put("streamvideo", Ti());
        }
        if ((this.bWA & 134217728) != 0) {
            contentValues.put("statextstr", this.bZN);
        }
        if ((this.bWA & 268435456) != 0) {
            contentValues.put("downloadscene", Integer.valueOf(this.dQo));
        }
        if ((this.bWA & 536870912) != 0) {
            contentValues.put("mmsightextinfo", Tq());
        }
        if ((this.bWA & 1) != 0) {
            contentValues.put("preloadsize", Integer.valueOf(this.bSX));
        }
        if ((this.bWA & 2) != 0) {
            contentValues.put("videoformat", Integer.valueOf(this.videoFormat));
        }
        return contentValues;
    }

    private byte[] Ti() {
        byte[] bArr = new byte[0];
        try {
            return this.enV.toByteArray();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoInfo", e, "", new Object[0]);
            return bArr;
        }
    }

    public final String getFileName() {
        return this.fileName == null ? "" : this.fileName;
    }

    public final String Tj() {
        return this.bWJ == null ? "" : this.bWJ;
    }

    public final String Tk() {
        return this.enF == null ? "" : this.enF;
    }

    public final String Tl() {
        return this.elu == null ? "" : this.elu;
    }

    public final String Tm() {
        return this.enS == null ? "" : this.enS;
    }

    public final boolean Tn() {
        if (this.status == b.CTRL_INDEX || this.status == 141 || this.status == 142) {
            return true;
        }
        return false;
    }

    public final boolean To() {
        if (this.status == 121 || this.status == 122 || this.status == 120 || this.status == 123) {
            return true;
        }
        return false;
    }

    public final boolean Tp() {
        if (this.status == 199 || this.status == 199) {
            return true;
        }
        return false;
    }

    private byte[] Tq() {
        byte[] bArr = new byte[0];
        try {
            return this.enW.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }
}
