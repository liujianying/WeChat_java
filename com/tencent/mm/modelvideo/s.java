package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.support.design.a$i;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.bt.h;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import junit.framework.Assert;

public final class s {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS videoinfo2 ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat int )", "CREATE INDEX IF NOT EXISTS  video_status_index ON videoinfo2 ( status,downloadtime )", "CREATE TABLE IF NOT EXISTS videoinfo ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat int )", "alter table videoinfo2 add videofuncflag int ;", "alter table videoinfo2 add masssendid long default 0;", "alter table videoinfo2 add masssendlist text ;", "alter table videoinfo2 add videomd5 text ;", "alter table videoinfo2 add streamvideo byte[] ;", "alter table videoinfo2 add statextstr text ;", "alter table videoinfo2 add downloadscene int ;", "alter table videoinfo2 add mmsightextinfo byte[] ;", "alter table videoinfo2 add preloadsize int ;", "alter table videoinfo2 add videoformat int ;", "alter table videoinfo add videofuncflag int ;", "alter table videoinfo add masssendid long default 0;", "alter table videoinfo add masssendlist text ;", "alter table videoinfo add videomd5 text ;", "alter table videoinfo add streamvideo byte[] ;", "alter table videoinfo add statextstr text ;", "alter table videoinfo add downloadscene int ;", "alter table videoinfo add mmsightextinfo byte[] ;", "alter table videoinfo add preloadsize int ;", "alter table videoinfo add videoformat int ;", "insert into videoinfo2 select * from videoinfo ;", "delete from videoinfo ;", "CREATE INDEX IF NOT EXISTS  massSendIdIndex ON videoinfo2 ( masssendid )", "CREATE INDEX IF NOT EXISTS  LastModifyTimeIndex ON videoinfo2 ( lastmodifytime )", "CREATE TABLE IF NOT EXISTS  VideoHash  (size int , CreateTime long, hash text ,  cdnxml text, orgpath text);", "CREATE INDEX IF NOT EXISTS  VideoHashSizeIndex ON VideoHash ( size  )", "CREATE INDEX IF NOT EXISTS  VideoHashTimeIndex ON VideoHash ( CreateTime  )"};
    private static long enX = 0;
    public h dCZ;
    k<a, s$a$a> dHn = new 1(this);

    public final void a(a aVar, Looper looper) {
        this.dHn.a(aVar, looper);
    }

    public final void a(a aVar) {
        this.dHn.remove(aVar);
    }

    public s(h hVar) {
        this.dCZ = hVar;
    }

    public final boolean a(r rVar) {
        if (rVar == null) {
            return false;
        }
        rVar.bWA = -1;
        if (((int) this.dCZ.insert("videoinfo2", "filename", rVar.wH())) == -1) {
            return false;
        }
        this.dHn.ci(new s$a$a(rVar.getFileName(), b.eoe, c.eoj, rVar.enT, rVar.emf));
        this.dHn.doNotify();
        return true;
    }

    public final r nI(String str) {
        r rVar = null;
        Cursor b = this.dCZ.b("select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where videoinfo2.filename = \"" + bi.oU(str) + "\"", null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                rVar = new r();
                rVar.d(b);
            }
            b.close();
        }
        return rVar;
    }

    public final List<r> bB(long j) {
        List<r> list = null;
        Cursor b = this.dCZ.b("select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where videoinfo2.masssendid = " + j, null, 2);
        if (b != null) {
            list = new ArrayList();
            while (b.moveToNext()) {
                r rVar = new r();
                rVar.d(b);
                list.add(rVar);
            }
            b.close();
        }
        return list;
    }

    public final List<r> Tr() {
        String str = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2  " + " WHERE status=200 order by masssendid desc";
        List<r> arrayList = new ArrayList();
        Cursor b = this.dCZ.b(str, null, 2);
        int i = 0;
        while (b.moveToNext()) {
            r rVar = new r();
            rVar.d(b);
            arrayList.add(rVar);
            i++;
        }
        b.close();
        x.d("MicroMsg.VideoInfoStorage", "getUnfinishMassInfo resCount:" + i);
        return arrayList;
    }

    public final List<r> Ts() {
        String str = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2  " + " WHERE status=198 AND masssendid > 0 order by masssendid desc";
        List<r> arrayList = new ArrayList();
        Cursor b = this.dCZ.b(str, null, 2);
        while (b.moveToNext()) {
            r rVar = new r();
            rVar.d(b);
            arrayList.add(rVar);
        }
        b.close();
        return arrayList;
    }

    public final boolean b(r rVar) {
        boolean z;
        Assert.assertTrue(rVar != null);
        if (rVar.getFileName().length() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ContentValues wH = rVar.wH();
        if (wH.size() <= 0) {
            x.e("MicroMsg.VideoInfoStorage", "update failed, no values set");
        } else {
            if (this.dCZ.update("videoinfo2", wH, "filename= ?", new String[]{rVar.getFileName()}) > 0) {
                c cVar = c.eoj;
                if (rVar.status == 112) {
                    cVar = c.eol;
                } else if (rVar.status == 103 || rVar.status == a$i.AppCompatTheme_editTextStyle) {
                    cVar = c.eok;
                }
                this.dHn.ci(new s$a$a(rVar.getFileName(), b.eoh, cVar, rVar.enT, rVar.emf));
                this.dHn.doNotify();
                return true;
            }
        }
        return false;
    }

    public final List<String> Tt() {
        Throwable th;
        List<String> list = null;
        Cursor b;
        try {
            b = this.dCZ.b("select videoinfo2.filename,downloadtime from videoinfo2  " + " WHERE status=112 ORDER BY downloadtime DESC " + " LIMIT 10", null, 2);
            try {
                if (b.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        list.add(b.getString(0));
                    } while (b.moveToNext());
                }
                if (b != null) {
                    b.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (b != null) {
                    b.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            b = null;
        }
    }

    public final List<String> Tu() {
        Throwable th;
        List<String> list = null;
        String str = " LIMIT 10 )";
        Cursor b;
        try {
            b = this.dCZ.b((((" SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=122" + str) + " UNION SELECT * FROM ( ") + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=120" + str) + " ORDER BY downloadtime DESC", null, 2);
            try {
                if (b.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        list.add(b.getString(0));
                    } while (b.moveToNext());
                }
                if (b != null) {
                    b.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (b != null) {
                    b.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            b = null;
        }
    }

    public final List<String> Tv() {
        Throwable th;
        List<String> list = null;
        Cursor b;
        try {
            b = this.dCZ.b("select videoinfo2.filename,downloadtime from videoinfo2  " + " WHERE (status=199 OR status=123) AND videoformat=2 ORDER BY downloadtime DESC " + " LIMIT 10", null, 2);
            try {
                if (b.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        list.add(b.getString(0));
                    } while (b.moveToNext());
                }
                if (b != null) {
                    b.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (b != null) {
                    b.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            b = null;
        }
    }

    public final List<r> n(int i, long j) {
        Throwable th;
        List<r> list = null;
        Cursor b;
        try {
            b = this.dCZ.b("select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where status=" + i + " AND preloadsize > 0 AND lastmodifytime <= " + j + " ORDER BY createtime LIMIT 1", null, 2);
            try {
                if (b.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        r rVar = new r();
                        rVar.d(b);
                        list.add(rVar);
                    } while (b.moveToNext());
                }
                if (b != null) {
                    b.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (b != null) {
                    b.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            b = null;
        }
    }

    public final List<String> Tw() {
        Throwable th;
        List<String> list = null;
        String str = " LIMIT 10 )";
        Cursor b;
        try {
            b = this.dCZ.b((((" SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=103" + str) + " UNION SELECT * FROM ( ") + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=104" + str) + " ORDER BY downloadtime DESC", null, 2);
            try {
                if (b.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        list.add(b.getString(0));
                    } while (b.moveToNext());
                }
                if (b != null) {
                    b.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (b != null) {
                    b.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            b = null;
        }
    }

    public static String nJ(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("HHmmssddMMyy").format(new Date(currentTimeMillis));
        if (str != null && str.length() > 1) {
            format = format + g.u(str.getBytes()).substring(0, 7);
        }
        StringBuilder append = new StringBuilder().append(format + (currentTimeMillis % 10000));
        currentTimeMillis = enX;
        enX = 1 + currentTimeMillis;
        return append.append(currentTimeMillis).toString();
    }

    private static String getVideoPath() {
        return com.tencent.mm.kernel.g.Ei().dqp + "video/";
    }

    public static String nK(String str) {
        if (bi.oW(str)) {
            return null;
        }
        String str2 = getVideoPath() + str;
        return !e.cn(str2) ? str2 + ".mp4" : str2;
    }

    public static String nL(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return getVideoPath() + str + ".jpg";
    }

    public static int a(String str, int i, byte[] bArr) {
        Exception e;
        Throwable th;
        if (bi.oW(str)) {
            x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + " invalid fileName");
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (i < 0) {
            x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + "[" + str + "]  invalid startOffset:" + i);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (bi.bC(bArr)) {
            x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + "[" + str + "]  invalid writeBuf");
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else {
            a aVar = new a();
            RandomAccessFile randomAccessFile;
            int filePointer;
            try {
                randomAccessFile = new RandomAccessFile(str, "rw");
                try {
                    long Ad = aVar.Ad();
                    randomAccessFile.seek((long) i);
                    long Ad2 = aVar.Ad();
                    randomAccessFile.write(bArr, 0, bArr.length);
                    long Ad3 = aVar.Ad();
                    filePointer = (int) randomAccessFile.getFilePointer();
                    long Ad4 = aVar.Ad();
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2) {
                    }
                    x.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.Ac() + "[" + str + "]  Offset:" + i + " buf:" + bArr.length);
                    x.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.Ac() + "[" + str + "] open:" + Ad + " seek:" + Ad2 + " write:" + Ad3 + " close:" + Ad4);
                    return filePointer;
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile = null;
                try {
                    x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + "[" + str + "] \t\tOffset:" + i + " failed:[" + e.getMessage() + "]");
                    filePointer = 0 - com.tencent.mm.compatible.util.g.getLine();
                    if (randomAccessFile == null) {
                        return filePointer;
                    }
                    try {
                        randomAccessFile.close();
                        return filePointer;
                    } catch (Exception e5) {
                        return filePointer;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e6) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e62) {
                    }
                }
                throw th;
            }
        }
    }

    public static b k(String str, int i, int i2) {
        Exception e;
        Throwable th;
        int i3 = 0;
        b bVar = new b();
        if (bi.oW(str)) {
            x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + " invalid fileName");
            bVar.ret = 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (i < 0) {
            x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + "[" + str + "]  invalid readOffset:" + i);
            bVar.ret = 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (i2 <= 0) {
            x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + "[" + str + "]  invalid readLen");
            bVar.ret = 0 - com.tencent.mm.compatible.util.g.getLine();
        } else {
            a aVar = new a();
            bVar.buf = new byte[i2];
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
                try {
                    long Ad = aVar.Ad();
                    randomAccessFile.seek((long) i);
                    long Ad2 = aVar.Ad();
                    int read = randomAccessFile.read(bVar.buf, 0, i2);
                    long Ad3 = aVar.Ad();
                    long Ad4 = aVar.Ad();
                    if (read >= 0) {
                        i3 = read;
                    }
                    bVar.bEG = i3;
                    bVar.eon = i3 + i;
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2) {
                    }
                    x.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.Ac() + "[" + str + "]  Offset:" + i + " readlen:" + i2);
                    x.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.Ac() + "[" + str + "] open:" + Ad + " seek:" + Ad2 + " write:" + Ad3 + " close:" + Ad4);
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + "[" + str + "] \t\tOffset:" + bVar.eon + " failed:[" + e.getMessage() + "]");
                        bVar.ret = 0 - com.tencent.mm.compatible.util.g.getLine();
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e4) {
                            }
                        }
                        return bVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
                x.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Ac() + "[" + str + "] \t\tOffset:" + bVar.eon + " failed:[" + e.getMessage() + "]");
                bVar.ret = 0 - com.tencent.mm.compatible.util.g.getLine();
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e42) {
                    }
                }
                return bVar;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e52) {
                    }
                }
                throw th;
            }
        }
        return bVar;
    }

    public static int nM(String str) {
        if (bi.oW(str)) {
            return -1;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        int length = (int) file.length();
        if (length > 0) {
            return length;
        }
        return 0;
    }

    public final boolean r(String str, String str2, String str3) {
        return aA(str, str2 + "##" + str3);
    }

    static int[] nN(String str) {
        Throwable e;
        int i = 0;
        int[] iArr = new int[33];
        long VF = bi.VF();
        int cm = e.cm(str);
        if (cm < 102400 || cm >= 104857600) {
            int i2;
            x.e("MicroMsg.VideoInfoStorage", "genVideoHash file size :%d , give up. :%s ", new Object[]{Integer.valueOf(cm), str});
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
            Object[] objArr = new Object[2];
            if (cm < 102400) {
                i2 = 10;
            } else {
                i2 = 20;
            }
            objArr[0] = Integer.valueOf(i2 + 101);
            objArr[1] = Integer.valueOf(cm);
            hVar.h(12696, objArr);
            return null;
        }
        iArr[32] = cm;
        int i3 = (cm - 20480) / 32;
        byte[] bArr = new byte[WXMediaMessage.TITLE_LENGTH_LIMIT];
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            while (i < 32) {
                try {
                    randomAccessFile.seek((long) ((i * i3) + 10240));
                    randomAccessFile.readFully(bArr);
                    iArr[i] = (com.tencent.mm.a.h.q(bArr, WXMediaMessage.TITLE_LENGTH_LIMIT) % Integer.MIN_VALUE) | Integer.MIN_VALUE;
                    i++;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.VideoInfoStorage", "genVideoHash path:%s e:%s", new Object[]{str, bi.i(e)});
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e3) {
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw e;
                    }
                }
            }
            randomAccessFile.close();
            x.i("MicroMsg.VideoInfoStorage", "genVideoHash finish time:%d size:%d path:%s", new Object[]{Long.valueOf(bi.bH(VF)), Integer.valueOf(cm), str});
            try {
                randomAccessFile.close();
                return iArr;
            } catch (Exception e5) {
                return iArr;
            }
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            x.e("MicroMsg.VideoInfoStorage", "genVideoHash path:%s e:%s", new Object[]{str, bi.i(e)});
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e32) {
                }
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e42) {
                }
            }
            throw e;
        }
    }

    private boolean aA(String str, String str2) {
        x.i("MicroMsg.VideoInfoStorage", "saveVideoHash path:%s xml:%s stack:%s", new Object[]{str, str2, bi.cjd()});
        long VF = bi.VF();
        if (bi.oW(str) || bi.oW(str2)) {
            x.e("MicroMsg.VideoInfoStorage", "saveVideoHash failed , path:%s xml:%s", new Object[]{str, str2});
            return false;
        }
        int[] nN = nN(str);
        if (nN == null || nN.length < 33) {
            x.e("MicroMsg.VideoInfoStorage", "saveVideoHash  readHash failed :%s", new Object[]{str});
            return false;
        }
        int i = nN[32];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 32; i2++) {
            stringBuffer.append(Integer.toHexString(nN[i2]));
        }
        Cursor b = this.dCZ.b("select cdnxml from VideoHash where size = " + i + " and hash = \"" + stringBuffer.toString() + "\"", null, 2);
        Vector vector = new Vector();
        while (b.moveToNext()) {
            vector.add(b.getString(0));
            x.v("MicroMsg.VideoInfoStorage", "saveVideoHash index:%s get:%s", new Object[]{Integer.valueOf(vector.size()), vector.get(vector.size() - 1)});
        }
        b.close();
        if (vector.size() == 1 && str2.equals(vector.get(0))) {
            x.w("MicroMsg.VideoInfoStorage", "saveVideoHash Check exist now return,time:%d,  path:%s xml:%s", new Object[]{Long.valueOf(bi.bH(VF)), str, str2});
            return true;
        }
        if (vector.size() > 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(12696, new Object[]{Integer.valueOf(102), Integer.valueOf(i), "", "", Integer.valueOf(vector.size())});
            x.e("MicroMsg.VideoInfoStorage", "saveVideoHash Err Check  xml diff OR  select more than one row,  rowCount:%d size:%d ", new Object[]{Integer.valueOf(vector.size()), Integer.valueOf(i)});
            this.dCZ.fV("VideoHash", "delete from VideoHash where size = " + i + " and hash = \"" + stringBuffer.toString() + "\"");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("size", Integer.valueOf(i));
        contentValues.put("CreateTime", Long.valueOf(bi.VE()));
        contentValues.put("hash", stringBuffer.toString());
        contentValues.put("cdnxml", str2);
        contentValues.put("orgpath", str);
        x.i("MicroMsg.VideoInfoStorage", "summersafecdn saveVideoHash time:%d insert:%d path:%s hash:%s xml:%s", new Object[]{Long.valueOf(bi.bH(VF)), Long.valueOf(this.dCZ.insert("VideoHash", "", contentValues)), str, stringBuffer, str2});
        if (this.dCZ.insert("VideoHash", "", contentValues) < 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(12696, new Object[]{Integer.valueOf(103), Integer.valueOf(i)});
            x.e("MicroMsg.VideoInfoStorage", "saveVideoHash insert failed :%d  path:%s", new Object[]{Long.valueOf(r0), str});
        }
        return true;
    }
}
