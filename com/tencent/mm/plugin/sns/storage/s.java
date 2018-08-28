package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.bt.h;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.p.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.c.atb;
import com.tencent.mm.protocal.c.ath;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

public final class s extends j {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS SnsMedia ( local_id INTEGER PRIMARY KEY, seqId LONG, type INT, createTime LONG, userName VARCHAR(40), totallen INT, offset INT, local_flag INT, tmp_path TEXT, nums INT, try_times INT, StrId VARCHAR(40), upload_buf TEXT, reserved1 INT, reserved2 TEXT, reserved3 TEXT, reserved4 TEXT, reserved5 TEXT )", "CREATE INDEX IF NOT EXISTS serverSnsMediaTimeIndex ON SnsMedia ( createTime )"};
    private static int niY = 0;
    private static int nig = 0;
    private static Point nqm = new Point();
    public h dCZ;

    public s(h hVar) {
        this.dCZ = hVar;
    }

    public static int getScreenWidth() {
        return niY > nig ? nig : niY;
    }

    public static void dA(int i, int i2) {
        niY = i;
        nig = i2;
        x.i("MicroMsg.snsMediaStorage", "SCREEN %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    private static String Nz(String str) {
        if (str == null) {
            return "";
        }
        String u = g.u(str.getBytes());
        String str2 = "";
        String str3 = "";
        if (u.length() > 0) {
            str2 = u.charAt(0) + "/";
        }
        if (u.length() >= 2) {
            str3 = u.charAt(1) + "/";
        }
        return af.getAccSnsPath() + str2 + str3;
    }

    public final boolean a(String str, r rVar) {
        x.d("MicroMsg.snsMediaStorage", "replace AlbumLikeList " + str);
        Cursor a = this.dCZ.a("SnsMedia", null, "StrId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            a.close();
            x.d("MicroMsg.snsMediaStorage", "snsMedia Insert");
            if (rVar != null) {
                if (((int) this.dCZ.insert("SnsMedia", "local_id", rVar.bBA())) != -1) {
                    return true;
                }
            }
            return false;
        }
        a.close();
        return this.dCZ.update("SnsMedia", rVar.bBA(), "StrId=?", new String[]{str}) > 0;
    }

    public final int a(int i, r rVar) {
        return this.dCZ.update("SnsMedia", rVar.bBA(), "local_id=?", new String[]{String.valueOf(i)});
    }

    public final r NA(String str) {
        r rVar = new r();
        Cursor a = this.dCZ.a("SnsMedia", null, "StrId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            rVar.d(a);
            a.close();
            return rVar;
        }
        a.close();
        return null;
    }

    public final r fj(long j) {
        r rVar = new r();
        Cursor a = this.dCZ.a("SnsMedia", null, "local_id=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            rVar.d(a);
            a.close();
            return rVar;
        }
        a.close();
        return null;
    }

    public final List<com.tencent.mm.plugin.sns.data.h> cn(List<com.tencent.mm.plugin.sns.data.h> list) {
        List<com.tencent.mm.plugin.sns.data.h> linkedList = new LinkedList();
        if (list == null || list.size() == 0) {
            return null;
        }
        for (com.tencent.mm.plugin.sns.data.h hVar : list) {
            int a = a(hVar);
            if (a == -1) {
                return null;
            }
            com.tencent.mm.plugin.sns.data.h hVar2 = new com.tencent.mm.plugin.sns.data.h(a, hVar.type);
            hVar2.height = hVar.height;
            hVar2.width = hVar.width;
            hVar2.fileSize = hVar.fileSize;
            linkedList.add(hVar2);
        }
        return linkedList;
    }

    private static com.tencent.mm.plugin.sns.data.h a(com.tencent.mm.plugin.sns.data.h hVar, String str) {
        int orientationInDegree;
        int i;
        Throwable e;
        Throwable th;
        InputStream inputStream = null;
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            InputStream openRead = FileOp.openRead(str);
            try {
                if (openRead instanceof FileInputStream) {
                    inputStream = new i((FileInputStream) openRead);
                } else {
                    inputStream = openRead;
                }
                inputStream.mark(1048576);
                BitmapFactory.decodeStream(inputStream, null, options);
                inputStream.reset();
                Exif exif = new Exif();
                exif.parseFromStream(inputStream);
                orientationInDegree = exif.getOrientationInDegree();
                if (orientationInDegree == 90 || orientationInDegree == TXLiveConstants.RENDER_ROTATION_LANDSCAPE) {
                    orientationInDegree = options.outWidth;
                    try {
                        i = options.outHeight;
                    } catch (Throwable e2) {
                        e = e2;
                    }
                } else {
                    orientationInDegree = options.outHeight;
                    i = options.outWidth;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Exception e4) {
                e = e4;
                inputStream = openRead;
                orientationInDegree = 0;
                try {
                    x.printErrStackTrace("MicroMsg.snsMediaStorage", e, "setImageExtInfo failed: " + str, new Object[0]);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            i = 0;
                        } catch (IOException e5) {
                            i = 0;
                        }
                    } else {
                        i = 0;
                    }
                    hVar.width = i;
                    hVar.height = orientationInDegree;
                    hVar.fileSize = (int) FileOp.mI(str);
                    return hVar;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = openRead;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e62) {
                    }
                }
                throw th;
            }
        } catch (Throwable e22) {
            e = e22;
            orientationInDegree = 0;
        }
        hVar.width = i;
        hVar.height = orientationInDegree;
        hVar.fileSize = (int) FileOp.mI(str);
        return hVar;
    }

    private int a(com.tencent.mm.plugin.sns.data.h hVar) {
        String accSnsPath = af.getAccSnsPath();
        String accSnsTmpPath = af.getAccSnsTmpPath();
        x.i("MicroMsg.snsMediaStorage", "SnsMediaStorage %s %s", new Object[]{accSnsPath, accSnsTmpPath});
        long currentTimeMillis = System.currentTimeMillis();
        String str = hVar.path;
        int i = hVar.type;
        if (!FileOp.cn(str)) {
            return -1;
        }
        String u = g.u((str + System.currentTimeMillis()).getBytes());
        String LE = com.tencent.mm.plugin.sns.data.i.LE(u);
        x.d("MicroMsg.snsMediaStorage", "insert : original img path = " + str);
        if (!FileOp.cn(accSnsTmpPath)) {
            x.i("MicroMsg.snsMediaStorage", "create snstmp path " + accSnsTmpPath);
            FileOp.mL(accSnsTmpPath);
        }
        if (!FileOp.cn(accSnsPath)) {
            x.i("MicroMsg.snsMediaStorage", "create snsPath " + accSnsPath);
            FileOp.mL(accSnsPath);
        }
        a aVar = new a();
        com.tencent.mm.plugin.sns.data.h a = a(hVar, str);
        int i2 = a.width;
        int i3 = a.height;
        int i4 = a.fileSize;
        aVar.knp = str;
        aVar.knr = i2;
        aVar.kns = i3;
        aVar.knt = i4;
        if (!e(accSnsTmpPath, str, LE, true)) {
            return -1;
        }
        x.d("MicroMsg.snsMediaStorage", "insert0 " + (System.currentTimeMillis() - currentTimeMillis));
        x.d("MicroMsg.snsMediaStorage", "insert: compressed bigMediaPath = " + LE);
        i2 = (int) FileOp.mI(accSnsTmpPath + LE);
        if (str.toLowerCase().contains("jpg") || str.toLowerCase().contains("jpeg")) {
            accSnsPath = c.bu(FileOp.e(str, 0, i2));
            if (accSnsPath != null) {
                x.i("MicroMsg.snsMediaStorage", "insert yuvInfo:%s", new Object[]{accSnsPath});
                try {
                    ExifInterface exifInterface = new ExifInterface(accSnsTmpPath + LE);
                    exifInterface.setAttribute("UserComment", accSnsPath);
                    exifInterface.saveAttributes();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.snsMediaStorage", e, "", new Object[0]);
                }
            }
        }
        i2 = (int) FileOp.mI(accSnsTmpPath + LE);
        com.tencent.mm.plugin.sns.data.h a2 = a(a, accSnsTmpPath + LE);
        int i5 = a2.width;
        i3 = a2.height;
        aVar.knu = i5;
        aVar.knv = i3;
        aVar.knw = i2;
        r rVar = new r();
        rVar.nJI = u;
        rVar.createTime = (long) ((int) bi.VE());
        rVar.type = i;
        ath ath = new ath();
        ath.rVG = a2.nkY;
        ath.rWb = a2.nkX;
        ath.token = a2.nla;
        ath.rWk = a2.nlb;
        ath.rWy = 0;
        ath.rWx = new atb();
        ath.dHg = 0;
        ath.jOS = a2.desc;
        x.d("MicroMsg.snsMediaStorage", "upload.filterId " + a2.nkW);
        ath.rWa = a2.nkW;
        ath.rWA = 2;
        ath.bKg = g.cu(accSnsTmpPath + LE);
        try {
            rVar.nJM = ath.toByteArray();
        } catch (Exception e2) {
            x.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        rVar.bBB();
        rVar.nJH = i2;
        x.i("MicroMsg.snsMediaStorage", "insert a local snsMedia  totallen  :" + i2 + " filepath: " + accSnsTmpPath + LE);
        int insert = (int) this.dCZ.insert("SnsMedia", "local_id", rVar.bBA());
        x.d("MicroMsg.snsMediaStorage", "insert localId " + insert);
        String str2 = "Locall_path" + insert;
        aVar.knq = String.valueOf(insert);
        Exif fromFile = Exif.fromFile(aVar.knp);
        i2 = 0;
        if (aVar.knp.indexOf("png") >= 0) {
            i2 = 1;
        } else if (aVar.knp.indexOf("jpg") >= 0 || aVar.knp.indexOf("jpeg") >= 0) {
            i2 = 2;
        } else if (aVar.knp.indexOf("mp3") >= 0) {
            i2 = 3;
        }
        d dVar = new d();
        dVar.r("20 localID", aVar.knq + ",");
        dVar.r("21 MediaType", i2 + ",");
        dVar.r("22 OriginWidth", aVar.knr + ",");
        dVar.r("23 OriginHeight", aVar.kns + ",");
        dVar.r("24 CompressedWidth", aVar.knu + ",");
        dVar.r("25 CompressedHeight", aVar.knv + ",");
        dVar.r("26 OriginSize", aVar.knt + ",");
        dVar.r("27 CompressedSize", aVar.knw + ",");
        dVar.r("28 FNumber", fromFile.fNumber + ",");
        dVar.r("29 ExposureTime", fromFile.exposureTime + ",");
        dVar.r("30 ISO", fromFile.isoSpeedRatings + ",");
        dVar.r("31 Flash", fromFile.flash + ",");
        dVar.r("32 LensModel", a.EK(fromFile.model) + ",");
        dVar.r("33 CreatTime", a.EK(fromFile.dateTimeOriginal) + ",");
        dVar.r("34 IsFromWeChat", "0,");
        dVar.r("35 Scene", ",");
        dVar.r("36 sceneType", fromFile.sceneType + ",");
        dVar.r("37 fileSource", fromFile.fileSource + ",");
        dVar.r("38 make", fromFile.make + ",");
        dVar.r("39 software", fromFile.software + ",");
        dVar.r("40 fileExt", a.cp(aVar.knp) + ",");
        x.v("MicroMsg.ImgExtInfoReport", "report logbuffer MMImageExifInfo(14525): %s, orgPath:%s", new Object[]{dVar.wF(), aVar.knp});
        com.tencent.mm.plugin.report.service.h.mEJ.h(14525, new Object[]{dVar});
        accSnsPath = com.tencent.mm.plugin.sns.data.i.LE(str2);
        u = Nz(str2);
        FileOp.mL(u);
        x.i("MicroMsg.snsMediaStorage", "checkcntpath " + u);
        FileOp.y(accSnsTmpPath + LE, u + accSnsPath);
        accSnsTmpPath = u + com.tencent.mm.plugin.sns.data.i.LA(str2);
        LE = u + com.tencent.mm.plugin.sns.data.i.LB(str2);
        FileOp.deleteFile(accSnsTmpPath);
        FileOp.deleteFile(LE);
        x.i("MicroMsg.snsMediaStorage", "insert done " + (System.currentTimeMillis() - currentTimeMillis) + " targetPath : " + u + accSnsPath + " totalLen:" + FileOp.mI(u + accSnsPath) + "  now delete...:" + accSnsTmpPath + " & " + LE);
        rVar.nJI = str2;
        a(insert, rVar);
        return insert;
    }

    public final com.tencent.mm.plugin.sns.data.h a(com.tencent.mm.plugin.sns.data.h hVar, String str, String str2, String str3, String str4) {
        r rVar = new r();
        rVar.createTime = (long) ((int) bi.VE());
        rVar.type = hVar.type;
        ath ath = new ath();
        ath.rVG = hVar.nkY;
        ath.rWb = hVar.nkX;
        ath.token = hVar.nla;
        ath.rWk = hVar.nlb;
        ath.rWy = 0;
        ath.rWx = new atb();
        ath.dHg = 0;
        ath.jOS = hVar.desc;
        x.d("MicroMsg.snsMediaStorage", "upload.filterId " + hVar.nkW);
        ath.rWa = hVar.nkW;
        ath.rWA = 2;
        ath.videoPath = str;
        ath.rWC = str2;
        ath.bKg = hVar.nlc;
        try {
            rVar.nJM = ath.toByteArray();
        } catch (Exception e) {
            x.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        rVar.bBB();
        int insert = (int) this.dCZ.insert("SnsMedia", "local_id", rVar.bBA());
        String str5 = "Locall_path" + insert;
        x.d("MicroMsg.snsMediaStorage", "insert localId " + insert);
        String LE = com.tencent.mm.plugin.sns.data.i.LE(str5);
        String LF = com.tencent.mm.plugin.sns.data.i.LF(str5);
        String LD = com.tencent.mm.plugin.sns.data.i.LD(str5);
        String LG = com.tencent.mm.plugin.sns.data.i.LG(str5);
        String Nz = Nz(str5);
        FileOp.mL(Nz);
        FileOp.y(str2, Nz + LE);
        FileOp.y(str2, Nz + LF);
        FileOp.y(str2, Nz + LD);
        FileOp.y(str, Nz + LG);
        ath.videoPath = Nz + LG;
        ath.rWC = Nz + LF;
        ath.bKg = hVar.nlc;
        try {
            rVar.nJM = ath.toByteArray();
        } catch (Exception e2) {
            x.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        rVar.nJI = str5;
        if (!(TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) {
            atb atb = new atb();
            atb.hcE = 1;
            atb.jPK = str3;
            ath.rWx = atb;
            ath.rWA = 0;
            com.tencent.mm.modelcdntran.g.NE();
            ath.rVZ = b.ls(str);
            if (!bi.oW(str4)) {
                atb = new atb();
                atb.hcE = 1;
                atb.jPK = str4;
                ath.rWz.add(atb);
            }
            try {
                rVar.nJM = ath.toByteArray();
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.snsMediaStorage", e3, "", new Object[0]);
            }
            rVar.bBC();
        }
        a(insert, rVar);
        com.tencent.mm.plugin.sns.data.h a = a(hVar, ath.rWC);
        a.nkZ = insert;
        return a;
    }

    public static boolean bBD() {
        if ("hevc".equals(com.tencent.mm.platformtools.af.exZ)) {
            return true;
        }
        return af.byy();
    }

    public static boolean bBE() {
        if ("wxpc".equals(com.tencent.mm.platformtools.af.exZ)) {
            return true;
        }
        return af.byz();
    }

    public static boolean ad(String str, String str2, String str3) {
        return e(str, str2, str3, true);
    }

    public static boolean bBF() {
        return nig >= 1080 && niY >= 1080;
    }

    public static boolean e(String str, String str2, String str3, boolean z) {
        boolean z2;
        Object obj;
        int i;
        int i2;
        int i3;
        int i4;
        int mI;
        int detectFaceCnt;
        int i5;
        int i6;
        int i7;
        int i8;
        Throwable th;
        InputStream inputStream;
        Options VZ = c.VZ(str2);
        if (VZ != null) {
            String str4 = VZ.outMimeType;
            x.d("MicroMsg.snsMediaStorage", "mimetype: " + str4);
            if (str4 != null) {
                str4 = str4.toLowerCase();
                if (str4.indexOf("jpg") >= 0) {
                    z2 = true;
                } else if (str4.indexOf("jpeg") >= 0) {
                    z2 = true;
                } else if (str4.indexOf("png") >= 0) {
                    z2 = true;
                }
                if (VZ != null) {
                    str4 = VZ.outMimeType;
                    if (str4 != null) {
                        str4 = str4.toLowerCase();
                        if (str4.indexOf("jpg") >= 0) {
                            obj = 1;
                        } else if (str4.indexOf("jpeg") >= 0) {
                            int obj2 = 1;
                        }
                        i = -1;
                        i2 = 100;
                        if (z) {
                            try {
                                com.tencent.mm.modelcdntran.g.ND();
                                if (com.tencent.mm.modelcdntran.c.hz(64) || bBD() || bBE()) {
                                    if (ao.isWifi(ad.getContext())) {
                                        i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelForWifi"), 70);
                                    } else if (ao.is2G(ad.getContext())) {
                                        i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor2G"), 70);
                                    } else if (ao.is3G(ad.getContext())) {
                                        i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor3G"), 60);
                                    } else {
                                        i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor4G"), 60);
                                    }
                                } else if (ao.isWifi(ad.getContext())) {
                                    i2 = Integer.valueOf(com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelForWifi")).intValue();
                                } else if (ao.is2G(ad.getContext())) {
                                    i2 = Integer.valueOf(com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelFor2G")).intValue();
                                } else {
                                    i2 = Integer.valueOf(com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelFor3G")).intValue();
                                }
                                x.d("MicroMsg.snsMediaStorage", "createPic comLev---webpWifi:%s, webp2G:%s, webp3G:%s,webp4G:%s   wifi:%s, 2G:%s, 3G:%s", new Object[]{com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelForWifi"), com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor2G"), com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor3G"), com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor4G"), com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelForWifi"), com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelFor2G"), com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelFor3G")});
                            } catch (Exception e) {
                            }
                            x.i("MicroMsg.snsMediaStorage", "CompresssnsPicLevel-level:%d isUpload: %s", new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)});
                            if (i2 <= 10 || i2 > 100) {
                                i3 = 60;
                            } else {
                                i3 = i2;
                            }
                            if (obj2 != null) {
                                i2 = MMNativeJpeg.queryQuality(str2);
                                if (i2 >= i3 || i2 <= 25) {
                                    i4 = i3;
                                    i = i2;
                                } else {
                                    i4 = i2;
                                    i = i2;
                                }
                            } else {
                                i4 = i3;
                            }
                        } else {
                            i4 = 100;
                        }
                        mI = (int) FileOp.mI(str2);
                        i3 = 0;
                        i2 = 1080;
                        detectFaceCnt = FaceProNative.detectFaceCnt(str2);
                        x.i("MicroMsg.snsMediaStorage", "FaceCnt:%d", new Object[]{Integer.valueOf(detectFaceCnt)});
                        if (detectFaceCnt >= 5) {
                            i3 = 0;
                            i2 = 1440;
                        }
                        String value;
                        if (detectFaceCnt < 5) {
                            try {
                                value = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionForMultiHead");
                                i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                                i2 = Integer.valueOf(value.split("\\*")[1]).intValue();
                            } catch (Exception e2) {
                            }
                        } else if (ao.isWifi(ad.getContext())) {
                            value = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionForWifi");
                            i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i2 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        } else if (ao.is2G(ad.getContext())) {
                            value = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionFor2G");
                            i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i2 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        } else if (ao.is3G(ad.getContext())) {
                            value = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionFor3G");
                            i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i2 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        } else {
                            value = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionFor4G");
                            i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i2 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        }
                        x.i("MicroMsg.snsMediaStorage", "server target conf_long config_short %d %d screen %d %d comLev: %d isUpload%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(nig), Integer.valueOf(niY), Integer.valueOf(i4), Boolean.valueOf(z)});
                        if (i3 > 0 && i2 <= 0) {
                            i3 = 0;
                            detectFaceCnt = 1080;
                        } else if (i2 < 2160) {
                            i3 = 0;
                            detectFaceCnt = 1080;
                        } else if (i2 > 0 || i3 <= 3240) {
                            detectFaceCnt = i2;
                        } else {
                            i3 = 1620;
                            detectFaceCnt = 0;
                        }
                        i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
                        if (i2 <= 0) {
                            i2 = 100;
                        }
                        i5 = i2 * 1024;
                        i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("PicCompressAvoidanceActiveSizeLong"), 200);
                        if (i2 <= 0) {
                            i2 = 200;
                        }
                        i6 = i2 * 1024;
                        i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("PicCompressAvoidanceRemainderPerc"), 10);
                        if (i2 > 0 || i2 >= 100) {
                            i7 = 10;
                        } else {
                            i7 = i2;
                        }
                        i2 = 0;
                        if (obj2 != null) {
                            try {
                                Exif fromFile = Exif.fromFile(str2);
                                if (fromFile != null) {
                                    i2 = fromFile.getOrientationInDegree() % 360;
                                }
                                i8 = i2;
                            } catch (Exception e3) {
                                x.e("MicroMsg.snsMediaStorage", "get degree error " + e3.getMessage());
                            }
                            x.i("MicroMsg.snsMediaStorage", "option info " + VZ.outWidth + " " + VZ.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + mI + " target " + i3 + " " + detectFaceCnt);
                            bi.getInt(com.tencent.mm.k.g.AT().getValue("CompressLongImageRatio"), 10);
                            boolean z3;
                            if (VZ.outWidth < VZ.outHeight * 2 || VZ.outHeight >= VZ.outWidth * 2) {
                                if (VZ.outWidth * VZ.outHeight > 10240000) {
                                    x.i("MicroMsg.snsMediaStorage", "too max pic " + VZ.outWidth + " " + VZ.outHeight);
                                    if (VZ.outHeight <= 0) {
                                        VZ.outHeight = 1;
                                    }
                                    if (VZ.outWidth <= 0) {
                                        VZ.outWidth = 1;
                                    }
                                    if (VZ.outWidth > VZ.outHeight) {
                                        i2 = VZ.outWidth / VZ.outHeight;
                                    } else {
                                        i2 = VZ.outHeight / VZ.outWidth;
                                    }
                                    if (i2 == 0) {
                                        i2 = 1;
                                    }
                                    detectFaceCnt = (int) Math.sqrt((double) (10240000 / i2));
                                    if (VZ.outWidth > VZ.outHeight) {
                                        i = detectFaceCnt * i2;
                                        i3 = detectFaceCnt;
                                    } else {
                                        i3 = detectFaceCnt * i2;
                                        i = detectFaceCnt;
                                    }
                                    x.i("MicroMsg.snsMediaStorage", "new width height " + i + " " + i3 + " " + i2);
                                    return a(str2, i3, i, CompressFormat.JPEG, i4, str, str3, z);
                                } else if (mI < i6 && z2 && i8 == 0) {
                                    x.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeLong " + i6);
                                    if (FileOp.y(str2, str + str3) >= 0) {
                                        return true;
                                    }
                                    return false;
                                } else {
                                    Options options = new Options();
                                    c.c(options);
                                    InputStream inputStream2 = null;
                                    try {
                                        InputStream inputStream3;
                                        inputStream2 = FileOp.openRead(str2);
                                        try {
                                            if (inputStream2.markSupported() || !(inputStream2 instanceof FileInputStream)) {
                                                inputStream3 = inputStream2;
                                            } else {
                                                inputStream3 = new i((FileInputStream) inputStream2);
                                            }
                                        } catch (Throwable e4) {
                                            th = e4;
                                            inputStream = inputStream2;
                                            try {
                                                x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "Decode bitmap failed: " + str2, new Object[0]);
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException e5) {
                                                    }
                                                }
                                                return false;
                                            } catch (Throwable e42) {
                                                th = e42;
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException e6) {
                                                    }
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable e422) {
                                            th = e422;
                                            inputStream = inputStream2;
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e62) {
                                                }
                                            }
                                            throw th;
                                        }
                                        try {
                                            inputStream3.mark(1048576);
                                            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                                            Bitmap decodeStream = MMBitmapFactory.decodeStream(inputStream3, null, options, decodeResultLogger, 0, new int[0]);
                                            inputStream3.reset();
                                            if (decodeStream == null) {
                                                if (decodeResultLogger.getDecodeResult() >= 2000) {
                                                    com.tencent.mm.plugin.report.service.h.mEJ.k(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                                                }
                                                if (inputStream3 != null) {
                                                    try {
                                                        inputStream3.close();
                                                    } catch (IOException e7) {
                                                    }
                                                }
                                                return false;
                                            }
                                            c.a(c.b(decodeStream, (float) i8), i4, CompressFormat.JPEG, str + str3, true);
                                            if (z2 && i8 == 0) {
                                                x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str + str3)), Integer.valueOf(i7)});
                                                if ((((long) mI) - FileOp.mI(str + str3)) * 100 < ((long) (i7 * mI))) {
                                                    FileOp.deleteFile(str + str3);
                                                    z3 = FileOp.y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                                                    if (inputStream3 == null) {
                                                        return z3;
                                                    }
                                                    try {
                                                        inputStream3.close();
                                                        return z3;
                                                    } catch (IOException e8) {
                                                        return z3;
                                                    }
                                                }
                                                if (inputStream3 != null) {
                                                    try {
                                                        inputStream3.close();
                                                    } catch (IOException e9) {
                                                    }
                                                }
                                                return true;
                                            }
                                            if (inputStream3 != null) {
                                                try {
                                                    inputStream3.close();
                                                } catch (IOException e10) {
                                                }
                                            }
                                            return true;
                                        } catch (Throwable e11) {
                                            th = e11;
                                            inputStream = inputStream3;
                                            x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "Decode bitmap failed: " + str2, new Object[0]);
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e52) {
                                                }
                                            }
                                            return false;
                                        } catch (Throwable e112) {
                                            th = e112;
                                            inputStream = inputStream3;
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e622) {
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable e4222) {
                                        th = e4222;
                                        inputStream = inputStream2;
                                    } catch (Throwable e42222) {
                                        th = e42222;
                                        inputStream = inputStream2;
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e6222) {
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            } else if (mI < i5 && z2 && i8 == 0) {
                                x.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeNormal " + i5);
                                return FileOp.y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                            } else {
                                i2 = VZ.outWidth > VZ.outHeight ? VZ.outWidth : VZ.outHeight;
                                i = VZ.outWidth < VZ.outHeight ? VZ.outWidth : VZ.outHeight;
                                if ((detectFaceCnt <= 0 || i > detectFaceCnt) && (detectFaceCnt > 0 || i2 > i3)) {
                                    if (detectFaceCnt > 0) {
                                        z3 = a(str2, VZ.outWidth, VZ.outHeight, detectFaceCnt, CompressFormat.JPEG, i4, str, str3);
                                    } else {
                                        double d = (((double) i2) * 1.0d) / ((double) i3);
                                        z3 = a(str2, (int) (((double) VZ.outHeight) / d), (int) (((double) VZ.outWidth) / d), CompressFormat.JPEG, i4, str, str3, z);
                                    }
                                    if (!z2 || i8 != 0) {
                                        return z3;
                                    }
                                    x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str + str3)), Integer.valueOf(i7)});
                                    if ((((long) mI) - FileOp.mI(str + str3)) * 100 >= ((long) (i7 * mI))) {
                                        return z3;
                                    }
                                    FileOp.deleteFile(str + str3);
                                    if (FileOp.y(str2, str + str3) >= 0) {
                                        return true;
                                    }
                                    return false;
                                }
                                x.i("MicroMsg.snsMediaStorage", "hello ieg this is little img  %d w: %d h: %d", new Object[]{Integer.valueOf(mI), Integer.valueOf(VZ.outWidth), Integer.valueOf(VZ.outHeight)});
                                if (FileOp.mI(str2) < 71680) {
                                    if (z2) {
                                        x.i("MicroMsg.snsMediaStorage", "isSysSupportedPic %s", new Object[]{str2});
                                        if (FileOp.y(str2, str + str3) >= 0) {
                                            return true;
                                        }
                                        return false;
                                    } else if (VZ.outWidth < 150 && VZ.outHeight < 150) {
                                        return a(str2, VZ.outHeight, VZ.outWidth, CompressFormat.PNG, i4, str, str3, z);
                                    }
                                }
                                z3 = a(str2, VZ.outHeight, VZ.outWidth, CompressFormat.JPEG, i4, str, str3, z);
                                if (!z2 || i8 != 0) {
                                    return z3;
                                }
                                x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str + str3)), Integer.valueOf(i7)});
                                if ((((long) mI) - FileOp.mI(str + str3)) * 100 >= ((long) (i7 * mI))) {
                                    return z3;
                                }
                                FileOp.deleteFile(str + str3);
                                return FileOp.y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                            }
                        }
                        i8 = 0;
                        x.i("MicroMsg.snsMediaStorage", "option info " + VZ.outWidth + " " + VZ.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + mI + " target " + i3 + " " + detectFaceCnt);
                        bi.getInt(com.tencent.mm.k.g.AT().getValue("CompressLongImageRatio"), 10);
                        if (VZ.outWidth < VZ.outHeight * 2) {
                        }
                        if (VZ.outWidth * VZ.outHeight > 10240000) {
                            x.i("MicroMsg.snsMediaStorage", "too max pic " + VZ.outWidth + " " + VZ.outHeight);
                            if (VZ.outHeight <= 0) {
                                VZ.outHeight = 1;
                            }
                            if (VZ.outWidth <= 0) {
                                VZ.outWidth = 1;
                            }
                            if (VZ.outWidth > VZ.outHeight) {
                                i2 = VZ.outWidth / VZ.outHeight;
                            } else {
                                i2 = VZ.outHeight / VZ.outWidth;
                            }
                            if (i2 == 0) {
                                i2 = 1;
                            }
                            detectFaceCnt = (int) Math.sqrt((double) (10240000 / i2));
                            if (VZ.outWidth > VZ.outHeight) {
                                i = detectFaceCnt * i2;
                                i3 = detectFaceCnt;
                            } else {
                                i3 = detectFaceCnt * i2;
                                i = detectFaceCnt;
                            }
                            x.i("MicroMsg.snsMediaStorage", "new width height " + i + " " + i3 + " " + i2);
                            return a(str2, i3, i, CompressFormat.JPEG, i4, str, str3, z);
                        } else if (mI < i6 && z2 && i8 == 0) {
                            x.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeLong " + i6);
                            if (FileOp.y(str2, str + str3) >= 0) {
                                return true;
                            }
                            return false;
                        } else {
                            Options options2 = new Options();
                            c.c(options2);
                            InputStream inputStream22 = null;
                            try {
                                InputStream inputStream32;
                                inputStream22 = FileOp.openRead(str2);
                                try {
                                    if (inputStream22.markSupported() || !(inputStream22 instanceof FileInputStream)) {
                                        inputStream32 = inputStream22;
                                    } else {
                                        inputStream32 = new i((FileInputStream) inputStream22);
                                    }
                                } catch (Throwable e422222) {
                                    th = e422222;
                                    inputStream = inputStream22;
                                    try {
                                        x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "Decode bitmap failed: " + str2, new Object[0]);
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e522) {
                                            }
                                        }
                                        return false;
                                    } catch (Throwable e4222222) {
                                        th = e4222222;
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e62222) {
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable e42222222) {
                                    th = e42222222;
                                    inputStream = inputStream22;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e622222) {
                                        }
                                    }
                                    throw th;
                                }
                                try {
                                    inputStream32.mark(1048576);
                                    DecodeResultLogger decodeResultLogger2 = new DecodeResultLogger();
                                    Bitmap decodeStream2 = MMBitmapFactory.decodeStream(inputStream32, null, options2, decodeResultLogger2, 0, new int[0]);
                                    inputStream32.reset();
                                    if (decodeStream2 == null) {
                                        if (decodeResultLogger2.getDecodeResult() >= 2000) {
                                            com.tencent.mm.plugin.report.service.h.mEJ.k(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger2));
                                        }
                                        if (inputStream32 != null) {
                                            try {
                                                inputStream32.close();
                                            } catch (IOException e72) {
                                            }
                                        }
                                        return false;
                                    }
                                    c.a(c.b(decodeStream2, (float) i8), i4, CompressFormat.JPEG, str + str3, true);
                                    if (z2 && i8 == 0) {
                                        x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str + str3)), Integer.valueOf(i7)});
                                        if ((((long) mI) - FileOp.mI(str + str3)) * 100 < ((long) (i7 * mI))) {
                                            FileOp.deleteFile(str + str3);
                                            z3 = FileOp.y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                                            if (inputStream32 == null) {
                                                return z3;
                                            }
                                            try {
                                                inputStream32.close();
                                                return z3;
                                            } catch (IOException e82) {
                                                return z3;
                                            }
                                        }
                                        if (inputStream32 != null) {
                                            try {
                                                inputStream32.close();
                                            } catch (IOException e92) {
                                            }
                                        }
                                        return true;
                                    }
                                    if (inputStream32 != null) {
                                        try {
                                            inputStream32.close();
                                        } catch (IOException e102) {
                                        }
                                    }
                                    return true;
                                } catch (Throwable e1122) {
                                    th = e1122;
                                    inputStream = inputStream32;
                                    x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "Decode bitmap failed: " + str2, new Object[0]);
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e5222) {
                                        }
                                    }
                                    return false;
                                } catch (Throwable e11222) {
                                    th = e11222;
                                    inputStream = inputStream32;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e6222222) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable e422222222) {
                                th = e422222222;
                                inputStream = inputStream22;
                            } catch (Throwable e4222222222) {
                                th = e4222222222;
                                inputStream = inputStream22;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e62222222) {
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                }
                obj2 = null;
                i = -1;
                i2 = 100;
                if (z) {
                    i4 = 100;
                } else {
                    try {
                        com.tencent.mm.modelcdntran.g.ND();
                        if (com.tencent.mm.modelcdntran.c.hz(64) || bBD() || bBE()) {
                            if (ao.isWifi(ad.getContext())) {
                                i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelForWifi"), 70);
                            } else if (ao.is2G(ad.getContext())) {
                                i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor2G"), 70);
                            } else if (ao.is3G(ad.getContext())) {
                                i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor3G"), 60);
                            } else {
                                i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor4G"), 60);
                            }
                        } else if (ao.isWifi(ad.getContext())) {
                            i2 = Integer.valueOf(com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelForWifi")).intValue();
                        } else if (ao.is2G(ad.getContext())) {
                            i2 = Integer.valueOf(com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelFor2G")).intValue();
                        } else {
                            i2 = Integer.valueOf(com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelFor3G")).intValue();
                        }
                        x.d("MicroMsg.snsMediaStorage", "createPic comLev---webpWifi:%s, webp2G:%s, webp3G:%s,webp4G:%s   wifi:%s, 2G:%s, 3G:%s", new Object[]{com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelForWifi"), com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor2G"), com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor3G"), com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor4G"), com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelForWifi"), com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelFor2G"), com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelFor3G")});
                    } catch (Exception e12) {
                    }
                    x.i("MicroMsg.snsMediaStorage", "CompresssnsPicLevel-level:%d isUpload: %s", new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)});
                    if (i2 <= 10 || i2 > 100) {
                        i3 = 60;
                    } else {
                        i3 = i2;
                    }
                    if (obj2 != null) {
                        i2 = MMNativeJpeg.queryQuality(str2);
                        if (i2 >= i3 || i2 <= 25) {
                            i4 = i3;
                            i = i2;
                        } else {
                            i4 = i2;
                            i = i2;
                        }
                    } else {
                        i4 = i3;
                    }
                }
                mI = (int) FileOp.mI(str2);
                i3 = 0;
                i2 = 1080;
                detectFaceCnt = FaceProNative.detectFaceCnt(str2);
                x.i("MicroMsg.snsMediaStorage", "FaceCnt:%d", new Object[]{Integer.valueOf(detectFaceCnt)});
                if (detectFaceCnt >= 5) {
                    i3 = 0;
                    i2 = 1440;
                }
                if (detectFaceCnt < 5) {
                    try {
                        value = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionForMultiHead");
                        i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                        i2 = Integer.valueOf(value.split("\\*")[1]).intValue();
                    } catch (Exception e22) {
                    }
                } else if (ao.isWifi(ad.getContext())) {
                    value = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionForWifi");
                    i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i2 = Integer.valueOf(value.split("\\*")[1]).intValue();
                } else if (ao.is2G(ad.getContext())) {
                    value = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionFor2G");
                    i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i2 = Integer.valueOf(value.split("\\*")[1]).intValue();
                } else if (ao.is3G(ad.getContext())) {
                    value = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionFor3G");
                    i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i2 = Integer.valueOf(value.split("\\*")[1]).intValue();
                } else {
                    value = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionFor4G");
                    i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i2 = Integer.valueOf(value.split("\\*")[1]).intValue();
                }
                x.i("MicroMsg.snsMediaStorage", "server target conf_long config_short %d %d screen %d %d comLev: %d isUpload%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(nig), Integer.valueOf(niY), Integer.valueOf(i4), Boolean.valueOf(z)});
                if (i3 > 0) {
                }
                if (i2 < 2160) {
                    i3 = 0;
                    detectFaceCnt = 1080;
                } else if (i2 > 0 || i3 <= 3240) {
                    detectFaceCnt = i2;
                } else {
                    i3 = 1620;
                    detectFaceCnt = 0;
                }
                i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
                if (i2 <= 0) {
                    i2 = 100;
                }
                i5 = i2 * 1024;
                i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("PicCompressAvoidanceActiveSizeLong"), 200);
                if (i2 <= 0) {
                    i2 = 200;
                }
                i6 = i2 * 1024;
                i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("PicCompressAvoidanceRemainderPerc"), 10);
                if (i2 > 0) {
                }
                i7 = 10;
                i2 = 0;
                if (obj2 != null) {
                    try {
                        Exif fromFile2 = Exif.fromFile(str2);
                        if (fromFile2 != null) {
                            i2 = fromFile2.getOrientationInDegree() % 360;
                        }
                        i8 = i2;
                    } catch (Exception e32) {
                        x.e("MicroMsg.snsMediaStorage", "get degree error " + e32.getMessage());
                    }
                    x.i("MicroMsg.snsMediaStorage", "option info " + VZ.outWidth + " " + VZ.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + mI + " target " + i3 + " " + detectFaceCnt);
                    bi.getInt(com.tencent.mm.k.g.AT().getValue("CompressLongImageRatio"), 10);
                    boolean z32;
                    if (VZ.outWidth < VZ.outHeight * 2 || VZ.outHeight >= VZ.outWidth * 2) {
                        if (VZ.outWidth * VZ.outHeight > 10240000) {
                            x.i("MicroMsg.snsMediaStorage", "too max pic " + VZ.outWidth + " " + VZ.outHeight);
                            if (VZ.outHeight <= 0) {
                                VZ.outHeight = 1;
                            }
                            if (VZ.outWidth <= 0) {
                                VZ.outWidth = 1;
                            }
                            if (VZ.outWidth > VZ.outHeight) {
                                i2 = VZ.outWidth / VZ.outHeight;
                            } else {
                                i2 = VZ.outHeight / VZ.outWidth;
                            }
                            if (i2 == 0) {
                                i2 = 1;
                            }
                            detectFaceCnt = (int) Math.sqrt((double) (10240000 / i2));
                            if (VZ.outWidth > VZ.outHeight) {
                                i = detectFaceCnt * i2;
                                i3 = detectFaceCnt;
                            } else {
                                i3 = detectFaceCnt * i2;
                                i = detectFaceCnt;
                            }
                            x.i("MicroMsg.snsMediaStorage", "new width height " + i + " " + i3 + " " + i2);
                            return a(str2, i3, i, CompressFormat.JPEG, i4, str, str3, z);
                        } else if (mI < i6 && z2 && i8 == 0) {
                            x.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeLong " + i6);
                            if (FileOp.y(str2, str + str3) >= 0) {
                                return true;
                            }
                            return false;
                        } else {
                            Options options22 = new Options();
                            c.c(options22);
                            InputStream inputStream222 = null;
                            try {
                                InputStream inputStream322;
                                inputStream222 = FileOp.openRead(str2);
                                try {
                                    if (inputStream222.markSupported() || !(inputStream222 instanceof FileInputStream)) {
                                        inputStream322 = inputStream222;
                                    } else {
                                        inputStream322 = new i((FileInputStream) inputStream222);
                                    }
                                } catch (Throwable e42222222222) {
                                    th = e42222222222;
                                    inputStream = inputStream222;
                                    try {
                                        x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "Decode bitmap failed: " + str2, new Object[0]);
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e52222) {
                                            }
                                        }
                                        return false;
                                    } catch (Throwable e422222222222) {
                                        th = e422222222222;
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e622222222) {
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable e4222222222222) {
                                    th = e4222222222222;
                                    inputStream = inputStream222;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e6222222222) {
                                        }
                                    }
                                    throw th;
                                }
                                try {
                                    inputStream322.mark(1048576);
                                    DecodeResultLogger decodeResultLogger22 = new DecodeResultLogger();
                                    Bitmap decodeStream22 = MMBitmapFactory.decodeStream(inputStream322, null, options22, decodeResultLogger22, 0, new int[0]);
                                    inputStream322.reset();
                                    if (decodeStream22 == null) {
                                        if (decodeResultLogger22.getDecodeResult() >= 2000) {
                                            com.tencent.mm.plugin.report.service.h.mEJ.k(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger22));
                                        }
                                        if (inputStream322 != null) {
                                            try {
                                                inputStream322.close();
                                            } catch (IOException e722) {
                                            }
                                        }
                                        return false;
                                    }
                                    c.a(c.b(decodeStream22, (float) i8), i4, CompressFormat.JPEG, str + str3, true);
                                    if (z2 && i8 == 0) {
                                        x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str + str3)), Integer.valueOf(i7)});
                                        if ((((long) mI) - FileOp.mI(str + str3)) * 100 < ((long) (i7 * mI))) {
                                            FileOp.deleteFile(str + str3);
                                            z32 = FileOp.y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                                            if (inputStream322 == null) {
                                                return z32;
                                            }
                                            try {
                                                inputStream322.close();
                                                return z32;
                                            } catch (IOException e822) {
                                                return z32;
                                            }
                                        }
                                        if (inputStream322 != null) {
                                            try {
                                                inputStream322.close();
                                            } catch (IOException e922) {
                                            }
                                        }
                                        return true;
                                    }
                                    if (inputStream322 != null) {
                                        try {
                                            inputStream322.close();
                                        } catch (IOException e1022) {
                                        }
                                    }
                                    return true;
                                } catch (Throwable e112222) {
                                    th = e112222;
                                    inputStream = inputStream322;
                                    x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "Decode bitmap failed: " + str2, new Object[0]);
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e522222) {
                                        }
                                    }
                                    return false;
                                } catch (Throwable e1122222) {
                                    th = e1122222;
                                    inputStream = inputStream322;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e62222222222) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable e42222222222222) {
                                th = e42222222222222;
                                inputStream = inputStream222;
                            } catch (Throwable e422222222222222) {
                                th = e422222222222222;
                                inputStream = inputStream222;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e622222222222) {
                                    }
                                }
                                throw th;
                            }
                        }
                    } else if (mI < i5 && z2 && i8 == 0) {
                        x.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeNormal " + i5);
                        return FileOp.y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                    } else {
                        i2 = VZ.outWidth > VZ.outHeight ? VZ.outWidth : VZ.outHeight;
                        i = VZ.outWidth < VZ.outHeight ? VZ.outWidth : VZ.outHeight;
                        if ((detectFaceCnt <= 0 || i > detectFaceCnt) && (detectFaceCnt > 0 || i2 > i3)) {
                            if (detectFaceCnt > 0) {
                                z32 = a(str2, VZ.outWidth, VZ.outHeight, detectFaceCnt, CompressFormat.JPEG, i4, str, str3);
                            } else {
                                double d2 = (((double) i2) * 1.0d) / ((double) i3);
                                z32 = a(str2, (int) (((double) VZ.outHeight) / d2), (int) (((double) VZ.outWidth) / d2), CompressFormat.JPEG, i4, str, str3, z);
                            }
                            if (!z2 || i8 != 0) {
                                return z32;
                            }
                            x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str + str3)), Integer.valueOf(i7)});
                            if ((((long) mI) - FileOp.mI(str + str3)) * 100 >= ((long) (i7 * mI))) {
                                return z32;
                            }
                            FileOp.deleteFile(str + str3);
                            if (FileOp.y(str2, str + str3) >= 0) {
                                return true;
                            }
                            return false;
                        }
                        x.i("MicroMsg.snsMediaStorage", "hello ieg this is little img  %d w: %d h: %d", new Object[]{Integer.valueOf(mI), Integer.valueOf(VZ.outWidth), Integer.valueOf(VZ.outHeight)});
                        if (FileOp.mI(str2) < 71680) {
                            if (z2) {
                                x.i("MicroMsg.snsMediaStorage", "isSysSupportedPic %s", new Object[]{str2});
                                if (FileOp.y(str2, str + str3) >= 0) {
                                    return true;
                                }
                                return false;
                            } else if (VZ.outWidth < 150 && VZ.outHeight < 150) {
                                return a(str2, VZ.outHeight, VZ.outWidth, CompressFormat.PNG, i4, str, str3, z);
                            }
                        }
                        z32 = a(str2, VZ.outHeight, VZ.outWidth, CompressFormat.JPEG, i4, str, str3, z);
                        if (!z2 || i8 != 0) {
                            return z32;
                        }
                        x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str + str3)), Integer.valueOf(i7)});
                        if ((((long) mI) - FileOp.mI(str + str3)) * 100 >= ((long) (i7 * mI))) {
                            return z32;
                        }
                        FileOp.deleteFile(str + str3);
                        return FileOp.y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                    }
                }
                i8 = 0;
                x.i("MicroMsg.snsMediaStorage", "option info " + VZ.outWidth + " " + VZ.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + mI + " target " + i3 + " " + detectFaceCnt);
                bi.getInt(com.tencent.mm.k.g.AT().getValue("CompressLongImageRatio"), 10);
                if (VZ.outWidth < VZ.outHeight * 2) {
                }
                if (VZ.outWidth * VZ.outHeight > 10240000) {
                    x.i("MicroMsg.snsMediaStorage", "too max pic " + VZ.outWidth + " " + VZ.outHeight);
                    if (VZ.outHeight <= 0) {
                        VZ.outHeight = 1;
                    }
                    if (VZ.outWidth <= 0) {
                        VZ.outWidth = 1;
                    }
                    if (VZ.outWidth > VZ.outHeight) {
                        i2 = VZ.outWidth / VZ.outHeight;
                    } else {
                        i2 = VZ.outHeight / VZ.outWidth;
                    }
                    if (i2 == 0) {
                        i2 = 1;
                    }
                    detectFaceCnt = (int) Math.sqrt((double) (10240000 / i2));
                    if (VZ.outWidth > VZ.outHeight) {
                        i = detectFaceCnt * i2;
                        i3 = detectFaceCnt;
                    } else {
                        i3 = detectFaceCnt * i2;
                        i = detectFaceCnt;
                    }
                    x.i("MicroMsg.snsMediaStorage", "new width height " + i + " " + i3 + " " + i2);
                    return a(str2, i3, i, CompressFormat.JPEG, i4, str, str3, z);
                } else if (mI < i6 && z2 && i8 == 0) {
                    x.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeLong " + i6);
                    if (FileOp.y(str2, str + str3) >= 0) {
                        return true;
                    }
                    return false;
                } else {
                    Options options222 = new Options();
                    c.c(options222);
                    InputStream inputStream2222 = null;
                    try {
                        InputStream inputStream3222;
                        inputStream2222 = FileOp.openRead(str2);
                        try {
                            if (inputStream2222.markSupported() || !(inputStream2222 instanceof FileInputStream)) {
                                inputStream3222 = inputStream2222;
                            } else {
                                inputStream3222 = new i((FileInputStream) inputStream2222);
                            }
                        } catch (Throwable e4222222222222222) {
                            th = e4222222222222222;
                            inputStream = inputStream2222;
                            try {
                                x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "Decode bitmap failed: " + str2, new Object[0]);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e5222222) {
                                    }
                                }
                                return false;
                            } catch (Throwable e42222222222222222) {
                                th = e42222222222222222;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e6222222222222) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable e422222222222222222) {
                            th = e422222222222222222;
                            inputStream = inputStream2222;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e62222222222222) {
                                }
                            }
                            throw th;
                        }
                        try {
                            inputStream3222.mark(1048576);
                            DecodeResultLogger decodeResultLogger222 = new DecodeResultLogger();
                            Bitmap decodeStream222 = MMBitmapFactory.decodeStream(inputStream3222, null, options222, decodeResultLogger222, 0, new int[0]);
                            inputStream3222.reset();
                            if (decodeStream222 == null) {
                                if (decodeResultLogger222.getDecodeResult() >= 2000) {
                                    com.tencent.mm.plugin.report.service.h.mEJ.k(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger222));
                                }
                                if (inputStream3222 != null) {
                                    try {
                                        inputStream3222.close();
                                    } catch (IOException e7222) {
                                    }
                                }
                                return false;
                            }
                            c.a(c.b(decodeStream222, (float) i8), i4, CompressFormat.JPEG, str + str3, true);
                            if (z2 && i8 == 0) {
                                x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str + str3)), Integer.valueOf(i7)});
                                if ((((long) mI) - FileOp.mI(str + str3)) * 100 < ((long) (i7 * mI))) {
                                    FileOp.deleteFile(str + str3);
                                    z32 = FileOp.y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                                    if (inputStream3222 == null) {
                                        return z32;
                                    }
                                    try {
                                        inputStream3222.close();
                                        return z32;
                                    } catch (IOException e8222) {
                                        return z32;
                                    }
                                }
                                if (inputStream3222 != null) {
                                    try {
                                        inputStream3222.close();
                                    } catch (IOException e9222) {
                                    }
                                }
                                return true;
                            }
                            if (inputStream3222 != null) {
                                try {
                                    inputStream3222.close();
                                } catch (IOException e10222) {
                                }
                            }
                            return true;
                        } catch (Throwable e11222222) {
                            th = e11222222;
                            inputStream = inputStream3222;
                            x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "Decode bitmap failed: " + str2, new Object[0]);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e52222222) {
                                }
                            }
                            return false;
                        } catch (Throwable e112222222) {
                            th = e112222222;
                            inputStream = inputStream3222;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e622222222222222) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable e4222222222222222222) {
                        th = e4222222222222222222;
                        inputStream = inputStream2222;
                    } catch (Throwable e42222222222222222222) {
                        th = e42222222222222222222;
                        inputStream = inputStream2222;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e6222222222222222) {
                            }
                        }
                        throw th;
                    }
                }
            }
        }
        z2 = false;
        if (VZ != null) {
            str4 = VZ.outMimeType;
            if (str4 != null) {
                str4 = str4.toLowerCase();
                if (str4.indexOf("jpg") >= 0) {
                    obj2 = 1;
                } else if (str4.indexOf("jpeg") >= 0) {
                    int obj22 = 1;
                }
                i = -1;
                i2 = 100;
                if (z) {
                    try {
                        com.tencent.mm.modelcdntran.g.ND();
                        if (com.tencent.mm.modelcdntran.c.hz(64) || bBD() || bBE()) {
                            if (ao.isWifi(ad.getContext())) {
                                i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelForWifi"), 70);
                            } else if (ao.is2G(ad.getContext())) {
                                i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor2G"), 70);
                            } else if (ao.is3G(ad.getContext())) {
                                i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor3G"), 60);
                            } else {
                                i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor4G"), 60);
                            }
                        } else if (ao.isWifi(ad.getContext())) {
                            i2 = Integer.valueOf(com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelForWifi")).intValue();
                        } else if (ao.is2G(ad.getContext())) {
                            i2 = Integer.valueOf(com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelFor2G")).intValue();
                        } else {
                            i2 = Integer.valueOf(com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelFor3G")).intValue();
                        }
                        x.d("MicroMsg.snsMediaStorage", "createPic comLev---webpWifi:%s, webp2G:%s, webp3G:%s,webp4G:%s   wifi:%s, 2G:%s, 3G:%s", new Object[]{com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelForWifi"), com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor2G"), com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor3G"), com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor4G"), com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelForWifi"), com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelFor2G"), com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelFor3G")});
                    } catch (Exception e122) {
                    }
                    x.i("MicroMsg.snsMediaStorage", "CompresssnsPicLevel-level:%d isUpload: %s", new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)});
                    if (i2 <= 10 || i2 > 100) {
                        i3 = 60;
                    } else {
                        i3 = i2;
                    }
                    if (obj22 != null) {
                        i2 = MMNativeJpeg.queryQuality(str2);
                        if (i2 >= i3 || i2 <= 25) {
                            i4 = i3;
                            i = i2;
                        } else {
                            i4 = i2;
                            i = i2;
                        }
                    } else {
                        i4 = i3;
                    }
                } else {
                    i4 = 100;
                }
                mI = (int) FileOp.mI(str2);
                i3 = 0;
                i2 = 1080;
                detectFaceCnt = FaceProNative.detectFaceCnt(str2);
                x.i("MicroMsg.snsMediaStorage", "FaceCnt:%d", new Object[]{Integer.valueOf(detectFaceCnt)});
                if (detectFaceCnt >= 5) {
                    i3 = 0;
                    i2 = 1440;
                }
                String value2;
                if (detectFaceCnt < 5) {
                    try {
                        value2 = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionForMultiHead");
                        i3 = Integer.valueOf(value2.split("\\*")[0]).intValue();
                        i2 = Integer.valueOf(value2.split("\\*")[1]).intValue();
                    } catch (Exception e222) {
                    }
                } else if (ao.isWifi(ad.getContext())) {
                    value2 = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionForWifi");
                    i3 = Integer.valueOf(value2.split("\\*")[0]).intValue();
                    i2 = Integer.valueOf(value2.split("\\*")[1]).intValue();
                } else if (ao.is2G(ad.getContext())) {
                    value2 = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionFor2G");
                    i3 = Integer.valueOf(value2.split("\\*")[0]).intValue();
                    i2 = Integer.valueOf(value2.split("\\*")[1]).intValue();
                } else if (ao.is3G(ad.getContext())) {
                    value2 = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionFor3G");
                    i3 = Integer.valueOf(value2.split("\\*")[0]).intValue();
                    i2 = Integer.valueOf(value2.split("\\*")[1]).intValue();
                } else {
                    value2 = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionFor4G");
                    i3 = Integer.valueOf(value2.split("\\*")[0]).intValue();
                    i2 = Integer.valueOf(value2.split("\\*")[1]).intValue();
                }
                x.i("MicroMsg.snsMediaStorage", "server target conf_long config_short %d %d screen %d %d comLev: %d isUpload%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(nig), Integer.valueOf(niY), Integer.valueOf(i4), Boolean.valueOf(z)});
                if (i3 > 0 && i2 <= 0) {
                    i3 = 0;
                    detectFaceCnt = 1080;
                } else if (i2 < 2160) {
                    i3 = 0;
                    detectFaceCnt = 1080;
                } else if (i2 > 0 || i3 <= 3240) {
                    detectFaceCnt = i2;
                } else {
                    i3 = 1620;
                    detectFaceCnt = 0;
                }
                i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
                if (i2 <= 0) {
                    i2 = 100;
                }
                i5 = i2 * 1024;
                i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("PicCompressAvoidanceActiveSizeLong"), 200);
                if (i2 <= 0) {
                    i2 = 200;
                }
                i6 = i2 * 1024;
                i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("PicCompressAvoidanceRemainderPerc"), 10);
                if (i2 > 0 || i2 >= 100) {
                    i7 = 10;
                } else {
                    i7 = i2;
                }
                i2 = 0;
                if (obj22 != null) {
                    try {
                        Exif fromFile22 = Exif.fromFile(str2);
                        if (fromFile22 != null) {
                            i2 = fromFile22.getOrientationInDegree() % 360;
                        }
                        i8 = i2;
                    } catch (Exception e322) {
                        x.e("MicroMsg.snsMediaStorage", "get degree error " + e322.getMessage());
                    }
                    x.i("MicroMsg.snsMediaStorage", "option info " + VZ.outWidth + " " + VZ.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + mI + " target " + i3 + " " + detectFaceCnt);
                    bi.getInt(com.tencent.mm.k.g.AT().getValue("CompressLongImageRatio"), 10);
                    boolean z322;
                    if (VZ.outWidth < VZ.outHeight * 2 || VZ.outHeight >= VZ.outWidth * 2) {
                        if (VZ.outWidth * VZ.outHeight > 10240000) {
                            x.i("MicroMsg.snsMediaStorage", "too max pic " + VZ.outWidth + " " + VZ.outHeight);
                            if (VZ.outHeight <= 0) {
                                VZ.outHeight = 1;
                            }
                            if (VZ.outWidth <= 0) {
                                VZ.outWidth = 1;
                            }
                            if (VZ.outWidth > VZ.outHeight) {
                                i2 = VZ.outWidth / VZ.outHeight;
                            } else {
                                i2 = VZ.outHeight / VZ.outWidth;
                            }
                            if (i2 == 0) {
                                i2 = 1;
                            }
                            detectFaceCnt = (int) Math.sqrt((double) (10240000 / i2));
                            if (VZ.outWidth > VZ.outHeight) {
                                i = detectFaceCnt * i2;
                                i3 = detectFaceCnt;
                            } else {
                                i3 = detectFaceCnt * i2;
                                i = detectFaceCnt;
                            }
                            x.i("MicroMsg.snsMediaStorage", "new width height " + i + " " + i3 + " " + i2);
                            return a(str2, i3, i, CompressFormat.JPEG, i4, str, str3, z);
                        } else if (mI < i6 && z2 && i8 == 0) {
                            x.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeLong " + i6);
                            if (FileOp.y(str2, str + str3) >= 0) {
                                return true;
                            }
                            return false;
                        } else {
                            Options options2222 = new Options();
                            c.c(options2222);
                            InputStream inputStream22222 = null;
                            try {
                                InputStream inputStream32222;
                                inputStream22222 = FileOp.openRead(str2);
                                try {
                                    if (inputStream22222.markSupported() || !(inputStream22222 instanceof FileInputStream)) {
                                        inputStream32222 = inputStream22222;
                                    } else {
                                        inputStream32222 = new i((FileInputStream) inputStream22222);
                                    }
                                } catch (Throwable e422222222222222222222) {
                                    th = e422222222222222222222;
                                    inputStream = inputStream22222;
                                    try {
                                        x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "Decode bitmap failed: " + str2, new Object[0]);
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e522222222) {
                                            }
                                        }
                                        return false;
                                    } catch (Throwable e4222222222222222222222) {
                                        th = e4222222222222222222222;
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e62222222222222222) {
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable e42222222222222222222222) {
                                    th = e42222222222222222222222;
                                    inputStream = inputStream22222;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e622222222222222222) {
                                        }
                                    }
                                    throw th;
                                }
                                try {
                                    inputStream32222.mark(1048576);
                                    DecodeResultLogger decodeResultLogger2222 = new DecodeResultLogger();
                                    Bitmap decodeStream2222 = MMBitmapFactory.decodeStream(inputStream32222, null, options2222, decodeResultLogger2222, 0, new int[0]);
                                    inputStream32222.reset();
                                    if (decodeStream2222 == null) {
                                        if (decodeResultLogger2222.getDecodeResult() >= 2000) {
                                            com.tencent.mm.plugin.report.service.h.mEJ.k(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger2222));
                                        }
                                        if (inputStream32222 != null) {
                                            try {
                                                inputStream32222.close();
                                            } catch (IOException e72222) {
                                            }
                                        }
                                        return false;
                                    }
                                    c.a(c.b(decodeStream2222, (float) i8), i4, CompressFormat.JPEG, str + str3, true);
                                    if (z2 && i8 == 0) {
                                        x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str + str3)), Integer.valueOf(i7)});
                                        if ((((long) mI) - FileOp.mI(str + str3)) * 100 < ((long) (i7 * mI))) {
                                            FileOp.deleteFile(str + str3);
                                            z322 = FileOp.y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                                            if (inputStream32222 == null) {
                                                return z322;
                                            }
                                            try {
                                                inputStream32222.close();
                                                return z322;
                                            } catch (IOException e82222) {
                                                return z322;
                                            }
                                        }
                                        if (inputStream32222 != null) {
                                            try {
                                                inputStream32222.close();
                                            } catch (IOException e92222) {
                                            }
                                        }
                                        return true;
                                    }
                                    if (inputStream32222 != null) {
                                        try {
                                            inputStream32222.close();
                                        } catch (IOException e102222) {
                                        }
                                    }
                                    return true;
                                } catch (Throwable e1122222222) {
                                    th = e1122222222;
                                    inputStream = inputStream32222;
                                    x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "Decode bitmap failed: " + str2, new Object[0]);
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e5222222222) {
                                        }
                                    }
                                    return false;
                                } catch (Throwable e11222222222) {
                                    th = e11222222222;
                                    inputStream = inputStream32222;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e6222222222222222222) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable e422222222222222222222222) {
                                th = e422222222222222222222222;
                                inputStream = inputStream22222;
                            } catch (Throwable e4222222222222222222222222) {
                                th = e4222222222222222222222222;
                                inputStream = inputStream22222;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e62222222222222222222) {
                                    }
                                }
                                throw th;
                            }
                        }
                    } else if (mI < i5 && z2 && i8 == 0) {
                        x.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeNormal " + i5);
                        return FileOp.y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                    } else {
                        i2 = VZ.outWidth > VZ.outHeight ? VZ.outWidth : VZ.outHeight;
                        i = VZ.outWidth < VZ.outHeight ? VZ.outWidth : VZ.outHeight;
                        if ((detectFaceCnt <= 0 || i > detectFaceCnt) && (detectFaceCnt > 0 || i2 > i3)) {
                            if (detectFaceCnt > 0) {
                                z322 = a(str2, VZ.outWidth, VZ.outHeight, detectFaceCnt, CompressFormat.JPEG, i4, str, str3);
                            } else {
                                double d22 = (((double) i2) * 1.0d) / ((double) i3);
                                z322 = a(str2, (int) (((double) VZ.outHeight) / d22), (int) (((double) VZ.outWidth) / d22), CompressFormat.JPEG, i4, str, str3, z);
                            }
                            if (!z2 || i8 != 0) {
                                return z322;
                            }
                            x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str + str3)), Integer.valueOf(i7)});
                            if ((((long) mI) - FileOp.mI(str + str3)) * 100 >= ((long) (i7 * mI))) {
                                return z322;
                            }
                            FileOp.deleteFile(str + str3);
                            if (FileOp.y(str2, str + str3) >= 0) {
                                return true;
                            }
                            return false;
                        }
                        x.i("MicroMsg.snsMediaStorage", "hello ieg this is little img  %d w: %d h: %d", new Object[]{Integer.valueOf(mI), Integer.valueOf(VZ.outWidth), Integer.valueOf(VZ.outHeight)});
                        if (FileOp.mI(str2) < 71680) {
                            if (z2) {
                                x.i("MicroMsg.snsMediaStorage", "isSysSupportedPic %s", new Object[]{str2});
                                if (FileOp.y(str2, str + str3) >= 0) {
                                    return true;
                                }
                                return false;
                            } else if (VZ.outWidth < 150 && VZ.outHeight < 150) {
                                return a(str2, VZ.outHeight, VZ.outWidth, CompressFormat.PNG, i4, str, str3, z);
                            }
                        }
                        z322 = a(str2, VZ.outHeight, VZ.outWidth, CompressFormat.JPEG, i4, str, str3, z);
                        if (!z2 || i8 != 0) {
                            return z322;
                        }
                        x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str + str3)), Integer.valueOf(i7)});
                        if ((((long) mI) - FileOp.mI(str + str3)) * 100 >= ((long) (i7 * mI))) {
                            return z322;
                        }
                        FileOp.deleteFile(str + str3);
                        return FileOp.y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                    }
                }
                i8 = 0;
                x.i("MicroMsg.snsMediaStorage", "option info " + VZ.outWidth + " " + VZ.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + mI + " target " + i3 + " " + detectFaceCnt);
                bi.getInt(com.tencent.mm.k.g.AT().getValue("CompressLongImageRatio"), 10);
                if (VZ.outWidth < VZ.outHeight * 2) {
                }
                if (VZ.outWidth * VZ.outHeight > 10240000) {
                    x.i("MicroMsg.snsMediaStorage", "too max pic " + VZ.outWidth + " " + VZ.outHeight);
                    if (VZ.outHeight <= 0) {
                        VZ.outHeight = 1;
                    }
                    if (VZ.outWidth <= 0) {
                        VZ.outWidth = 1;
                    }
                    if (VZ.outWidth > VZ.outHeight) {
                        i2 = VZ.outWidth / VZ.outHeight;
                    } else {
                        i2 = VZ.outHeight / VZ.outWidth;
                    }
                    if (i2 == 0) {
                        i2 = 1;
                    }
                    detectFaceCnt = (int) Math.sqrt((double) (10240000 / i2));
                    if (VZ.outWidth > VZ.outHeight) {
                        i = detectFaceCnt * i2;
                        i3 = detectFaceCnt;
                    } else {
                        i3 = detectFaceCnt * i2;
                        i = detectFaceCnt;
                    }
                    x.i("MicroMsg.snsMediaStorage", "new width height " + i + " " + i3 + " " + i2);
                    return a(str2, i3, i, CompressFormat.JPEG, i4, str, str3, z);
                } else if (mI < i6 && z2 && i8 == 0) {
                    x.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeLong " + i6);
                    if (FileOp.y(str2, str + str3) >= 0) {
                        return true;
                    }
                    return false;
                } else {
                    Options options22222 = new Options();
                    c.c(options22222);
                    InputStream inputStream222222 = null;
                    try {
                        InputStream inputStream322222;
                        inputStream222222 = FileOp.openRead(str2);
                        try {
                            if (inputStream222222.markSupported() || !(inputStream222222 instanceof FileInputStream)) {
                                inputStream322222 = inputStream222222;
                            } else {
                                inputStream322222 = new i((FileInputStream) inputStream222222);
                            }
                        } catch (Throwable e42222222222222222222222222) {
                            th = e42222222222222222222222222;
                            inputStream = inputStream222222;
                            try {
                                x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "Decode bitmap failed: " + str2, new Object[0]);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e52222222222) {
                                    }
                                }
                                return false;
                            } catch (Throwable e422222222222222222222222222) {
                                th = e422222222222222222222222222;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e622222222222222222222) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable e4222222222222222222222222222) {
                            th = e4222222222222222222222222222;
                            inputStream = inputStream222222;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e6222222222222222222222) {
                                }
                            }
                            throw th;
                        }
                        try {
                            inputStream322222.mark(1048576);
                            DecodeResultLogger decodeResultLogger22222 = new DecodeResultLogger();
                            Bitmap decodeStream22222 = MMBitmapFactory.decodeStream(inputStream322222, null, options22222, decodeResultLogger22222, 0, new int[0]);
                            inputStream322222.reset();
                            if (decodeStream22222 == null) {
                                if (decodeResultLogger22222.getDecodeResult() >= 2000) {
                                    com.tencent.mm.plugin.report.service.h.mEJ.k(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger22222));
                                }
                                if (inputStream322222 != null) {
                                    try {
                                        inputStream322222.close();
                                    } catch (IOException e722222) {
                                    }
                                }
                                return false;
                            }
                            c.a(c.b(decodeStream22222, (float) i8), i4, CompressFormat.JPEG, str + str3, true);
                            if (z2 && i8 == 0) {
                                x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str + str3)), Integer.valueOf(i7)});
                                if ((((long) mI) - FileOp.mI(str + str3)) * 100 < ((long) (i7 * mI))) {
                                    FileOp.deleteFile(str + str3);
                                    z322 = FileOp.y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                                    if (inputStream322222 == null) {
                                        return z322;
                                    }
                                    try {
                                        inputStream322222.close();
                                        return z322;
                                    } catch (IOException e822222) {
                                        return z322;
                                    }
                                }
                                if (inputStream322222 != null) {
                                    try {
                                        inputStream322222.close();
                                    } catch (IOException e922222) {
                                    }
                                }
                                return true;
                            }
                            if (inputStream322222 != null) {
                                try {
                                    inputStream322222.close();
                                } catch (IOException e1022222) {
                                }
                            }
                            return true;
                        } catch (Throwable e112222222222) {
                            th = e112222222222;
                            inputStream = inputStream322222;
                            x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "Decode bitmap failed: " + str2, new Object[0]);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e522222222222) {
                                }
                            }
                            return false;
                        } catch (Throwable e1122222222222) {
                            th = e1122222222222;
                            inputStream = inputStream322222;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e62222222222222222222222) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable e42222222222222222222222222222) {
                        th = e42222222222222222222222222222;
                        inputStream = inputStream222222;
                    } catch (Throwable e422222222222222222222222222222) {
                        th = e422222222222222222222222222222;
                        inputStream = inputStream222222;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e622222222222222222222222) {
                            }
                        }
                        throw th;
                    }
                }
            }
        }
        obj22 = null;
        i = -1;
        i2 = 100;
        if (z) {
            try {
                com.tencent.mm.modelcdntran.g.ND();
                if (com.tencent.mm.modelcdntran.c.hz(64) || bBD() || bBE()) {
                    if (ao.isWifi(ad.getContext())) {
                        i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelForWifi"), 70);
                    } else if (ao.is2G(ad.getContext())) {
                        i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor2G"), 70);
                    } else if (ao.is3G(ad.getContext())) {
                        i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor3G"), 60);
                    } else {
                        i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor4G"), 60);
                    }
                } else if (ao.isWifi(ad.getContext())) {
                    i2 = Integer.valueOf(com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelForWifi")).intValue();
                } else if (ao.is2G(ad.getContext())) {
                    i2 = Integer.valueOf(com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelFor2G")).intValue();
                } else {
                    i2 = Integer.valueOf(com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelFor3G")).intValue();
                }
                x.d("MicroMsg.snsMediaStorage", "createPic comLev---webpWifi:%s, webp2G:%s, webp3G:%s,webp4G:%s   wifi:%s, 2G:%s, 3G:%s", new Object[]{com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelForWifi"), com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor2G"), com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor3G"), com.tencent.mm.k.g.AT().getValue("SnsWebpCompressPicLevelFor4G"), com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelForWifi"), com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelFor2G"), com.tencent.mm.k.g.AT().getValue("SnsCompressPicLevelFor3G")});
            } catch (Exception e1222) {
            }
            x.i("MicroMsg.snsMediaStorage", "CompresssnsPicLevel-level:%d isUpload: %s", new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)});
            if (i2 <= 10 || i2 > 100) {
                i3 = 60;
            } else {
                i3 = i2;
            }
            if (obj22 != null) {
                i2 = MMNativeJpeg.queryQuality(str2);
                if (i2 >= i3 || i2 <= 25) {
                    i4 = i3;
                    i = i2;
                } else {
                    i4 = i2;
                    i = i2;
                }
            } else {
                i4 = i3;
            }
        } else {
            i4 = 100;
        }
        mI = (int) FileOp.mI(str2);
        i3 = 0;
        i2 = 1080;
        detectFaceCnt = FaceProNative.detectFaceCnt(str2);
        x.i("MicroMsg.snsMediaStorage", "FaceCnt:%d", new Object[]{Integer.valueOf(detectFaceCnt)});
        if (detectFaceCnt >= 5) {
            i3 = 0;
            i2 = 1440;
        }
        if (detectFaceCnt < 5) {
            try {
                value2 = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionForMultiHead");
                i3 = Integer.valueOf(value2.split("\\*")[0]).intValue();
                i2 = Integer.valueOf(value2.split("\\*")[1]).intValue();
            } catch (Exception e2222) {
            }
        } else if (ao.isWifi(ad.getContext())) {
            value2 = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionForWifi");
            i3 = Integer.valueOf(value2.split("\\*")[0]).intValue();
            i2 = Integer.valueOf(value2.split("\\*")[1]).intValue();
        } else if (ao.is2G(ad.getContext())) {
            value2 = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionFor2G");
            i3 = Integer.valueOf(value2.split("\\*")[0]).intValue();
            i2 = Integer.valueOf(value2.split("\\*")[1]).intValue();
        } else if (ao.is3G(ad.getContext())) {
            value2 = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionFor3G");
            i3 = Integer.valueOf(value2.split("\\*")[0]).intValue();
            i2 = Integer.valueOf(value2.split("\\*")[1]).intValue();
        } else {
            value2 = com.tencent.mm.k.g.AT().getValue("SnsCompressResolutionFor4G");
            i3 = Integer.valueOf(value2.split("\\*")[0]).intValue();
            i2 = Integer.valueOf(value2.split("\\*")[1]).intValue();
        }
        x.i("MicroMsg.snsMediaStorage", "server target conf_long config_short %d %d screen %d %d comLev: %d isUpload%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(nig), Integer.valueOf(niY), Integer.valueOf(i4), Boolean.valueOf(z)});
        if (i3 > 0) {
        }
        if (i2 < 2160) {
            i3 = 0;
            detectFaceCnt = 1080;
        } else if (i2 > 0 || i3 <= 3240) {
            detectFaceCnt = i2;
        } else {
            i3 = 1620;
            detectFaceCnt = 0;
        }
        i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        if (i2 <= 0) {
            i2 = 100;
        }
        i5 = i2 * 1024;
        i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("PicCompressAvoidanceActiveSizeLong"), 200);
        if (i2 <= 0) {
            i2 = 200;
        }
        i6 = i2 * 1024;
        i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if (i2 > 0) {
        }
        i7 = 10;
        i2 = 0;
        if (obj22 != null) {
            try {
                Exif fromFile222 = Exif.fromFile(str2);
                if (fromFile222 != null) {
                    i2 = fromFile222.getOrientationInDegree() % 360;
                }
                i8 = i2;
            } catch (Exception e3222) {
                x.e("MicroMsg.snsMediaStorage", "get degree error " + e3222.getMessage());
            }
            x.i("MicroMsg.snsMediaStorage", "option info " + VZ.outWidth + " " + VZ.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + mI + " target " + i3 + " " + detectFaceCnt);
            bi.getInt(com.tencent.mm.k.g.AT().getValue("CompressLongImageRatio"), 10);
            boolean z3222;
            if (VZ.outWidth < VZ.outHeight * 2 || VZ.outHeight >= VZ.outWidth * 2) {
                if (VZ.outWidth * VZ.outHeight > 10240000) {
                    x.i("MicroMsg.snsMediaStorage", "too max pic " + VZ.outWidth + " " + VZ.outHeight);
                    if (VZ.outHeight <= 0) {
                        VZ.outHeight = 1;
                    }
                    if (VZ.outWidth <= 0) {
                        VZ.outWidth = 1;
                    }
                    if (VZ.outWidth > VZ.outHeight) {
                        i2 = VZ.outWidth / VZ.outHeight;
                    } else {
                        i2 = VZ.outHeight / VZ.outWidth;
                    }
                    if (i2 == 0) {
                        i2 = 1;
                    }
                    detectFaceCnt = (int) Math.sqrt((double) (10240000 / i2));
                    if (VZ.outWidth > VZ.outHeight) {
                        i = detectFaceCnt * i2;
                        i3 = detectFaceCnt;
                    } else {
                        i3 = detectFaceCnt * i2;
                        i = detectFaceCnt;
                    }
                    x.i("MicroMsg.snsMediaStorage", "new width height " + i + " " + i3 + " " + i2);
                    return a(str2, i3, i, CompressFormat.JPEG, i4, str, str3, z);
                } else if (mI < i6 && z2 && i8 == 0) {
                    x.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeLong " + i6);
                    if (FileOp.y(str2, str + str3) >= 0) {
                        return true;
                    }
                    return false;
                } else {
                    Options options222222 = new Options();
                    c.c(options222222);
                    InputStream inputStream2222222 = null;
                    try {
                        InputStream inputStream3222222;
                        inputStream2222222 = FileOp.openRead(str2);
                        try {
                            if (inputStream2222222.markSupported() || !(inputStream2222222 instanceof FileInputStream)) {
                                inputStream3222222 = inputStream2222222;
                            } else {
                                inputStream3222222 = new i((FileInputStream) inputStream2222222);
                            }
                        } catch (Throwable e4222222222222222222222222222222) {
                            th = e4222222222222222222222222222222;
                            inputStream = inputStream2222222;
                            try {
                                x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "Decode bitmap failed: " + str2, new Object[0]);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e5222222222222) {
                                    }
                                }
                                return false;
                            } catch (Throwable e42222222222222222222222222222222) {
                                th = e42222222222222222222222222222222;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e6222222222222222222222222) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable e422222222222222222222222222222222) {
                            th = e422222222222222222222222222222222;
                            inputStream = inputStream2222222;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e62222222222222222222222222) {
                                }
                            }
                            throw th;
                        }
                        try {
                            inputStream3222222.mark(1048576);
                            DecodeResultLogger decodeResultLogger222222 = new DecodeResultLogger();
                            Bitmap decodeStream222222 = MMBitmapFactory.decodeStream(inputStream3222222, null, options222222, decodeResultLogger222222, 0, new int[0]);
                            inputStream3222222.reset();
                            if (decodeStream222222 == null) {
                                if (decodeResultLogger222222.getDecodeResult() >= 2000) {
                                    com.tencent.mm.plugin.report.service.h.mEJ.k(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger222222));
                                }
                                if (inputStream3222222 != null) {
                                    try {
                                        inputStream3222222.close();
                                    } catch (IOException e7222222) {
                                    }
                                }
                                return false;
                            }
                            c.a(c.b(decodeStream222222, (float) i8), i4, CompressFormat.JPEG, str + str3, true);
                            if (z2 && i8 == 0) {
                                x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str + str3)), Integer.valueOf(i7)});
                                if ((((long) mI) - FileOp.mI(str + str3)) * 100 < ((long) (i7 * mI))) {
                                    FileOp.deleteFile(str + str3);
                                    z3222 = FileOp.y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                                    if (inputStream3222222 == null) {
                                        return z3222;
                                    }
                                    try {
                                        inputStream3222222.close();
                                        return z3222;
                                    } catch (IOException e8222222) {
                                        return z3222;
                                    }
                                }
                                if (inputStream3222222 != null) {
                                    try {
                                        inputStream3222222.close();
                                    } catch (IOException e9222222) {
                                    }
                                }
                                return true;
                            }
                            if (inputStream3222222 != null) {
                                try {
                                    inputStream3222222.close();
                                } catch (IOException e10222222) {
                                }
                            }
                            return true;
                        } catch (Throwable e11222222222222) {
                            th = e11222222222222;
                            inputStream = inputStream3222222;
                            x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "Decode bitmap failed: " + str2, new Object[0]);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e52222222222222) {
                                }
                            }
                            return false;
                        } catch (Throwable e112222222222222) {
                            th = e112222222222222;
                            inputStream = inputStream3222222;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e622222222222222222222222222) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable e4222222222222222222222222222222222) {
                        th = e4222222222222222222222222222222222;
                        inputStream = inputStream2222222;
                    } catch (Throwable e42222222222222222222222222222222222) {
                        th = e42222222222222222222222222222222222;
                        inputStream = inputStream2222222;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e6222222222222222222222222222) {
                            }
                        }
                        throw th;
                    }
                }
            } else if (mI < i5 && z2 && i8 == 0) {
                x.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeNormal " + i5);
                return FileOp.y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
            } else {
                i2 = VZ.outWidth > VZ.outHeight ? VZ.outWidth : VZ.outHeight;
                i = VZ.outWidth < VZ.outHeight ? VZ.outWidth : VZ.outHeight;
                if ((detectFaceCnt <= 0 || i > detectFaceCnt) && (detectFaceCnt > 0 || i2 > i3)) {
                    if (detectFaceCnt > 0) {
                        z3222 = a(str2, VZ.outWidth, VZ.outHeight, detectFaceCnt, CompressFormat.JPEG, i4, str, str3);
                    } else {
                        double d222 = (((double) i2) * 1.0d) / ((double) i3);
                        z3222 = a(str2, (int) (((double) VZ.outHeight) / d222), (int) (((double) VZ.outWidth) / d222), CompressFormat.JPEG, i4, str, str3, z);
                    }
                    if (!z2 || i8 != 0) {
                        return z3222;
                    }
                    x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str + str3)), Integer.valueOf(i7)});
                    if ((((long) mI) - FileOp.mI(str + str3)) * 100 >= ((long) (i7 * mI))) {
                        return z3222;
                    }
                    FileOp.deleteFile(str + str3);
                    if (FileOp.y(str2, str + str3) >= 0) {
                        return true;
                    }
                    return false;
                }
                x.i("MicroMsg.snsMediaStorage", "hello ieg this is little img  %d w: %d h: %d", new Object[]{Integer.valueOf(mI), Integer.valueOf(VZ.outWidth), Integer.valueOf(VZ.outHeight)});
                if (FileOp.mI(str2) < 71680) {
                    if (z2) {
                        x.i("MicroMsg.snsMediaStorage", "isSysSupportedPic %s", new Object[]{str2});
                        if (FileOp.y(str2, str + str3) >= 0) {
                            return true;
                        }
                        return false;
                    } else if (VZ.outWidth < 150 && VZ.outHeight < 150) {
                        return a(str2, VZ.outHeight, VZ.outWidth, CompressFormat.PNG, i4, str, str3, z);
                    }
                }
                z3222 = a(str2, VZ.outHeight, VZ.outWidth, CompressFormat.JPEG, i4, str, str3, z);
                if (!z2 || i8 != 0) {
                    return z3222;
                }
                x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str + str3)), Integer.valueOf(i7)});
                if ((((long) mI) - FileOp.mI(str + str3)) * 100 >= ((long) (i7 * mI))) {
                    return z3222;
                }
                FileOp.deleteFile(str + str3);
                return FileOp.y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
            }
        }
        i8 = 0;
        x.i("MicroMsg.snsMediaStorage", "option info " + VZ.outWidth + " " + VZ.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + mI + " target " + i3 + " " + detectFaceCnt);
        bi.getInt(com.tencent.mm.k.g.AT().getValue("CompressLongImageRatio"), 10);
        if (VZ.outWidth < VZ.outHeight * 2) {
        }
        if (VZ.outWidth * VZ.outHeight > 10240000) {
            x.i("MicroMsg.snsMediaStorage", "too max pic " + VZ.outWidth + " " + VZ.outHeight);
            if (VZ.outHeight <= 0) {
                VZ.outHeight = 1;
            }
            if (VZ.outWidth <= 0) {
                VZ.outWidth = 1;
            }
            if (VZ.outWidth > VZ.outHeight) {
                i2 = VZ.outWidth / VZ.outHeight;
            } else {
                i2 = VZ.outHeight / VZ.outWidth;
            }
            if (i2 == 0) {
                i2 = 1;
            }
            detectFaceCnt = (int) Math.sqrt((double) (10240000 / i2));
            if (VZ.outWidth > VZ.outHeight) {
                i = detectFaceCnt * i2;
                i3 = detectFaceCnt;
            } else {
                i3 = detectFaceCnt * i2;
                i = detectFaceCnt;
            }
            x.i("MicroMsg.snsMediaStorage", "new width height " + i + " " + i3 + " " + i2);
            return a(str2, i3, i, CompressFormat.JPEG, i4, str, str3, z);
        } else if (mI < i6 && z2 && i8 == 0) {
            x.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeLong " + i6);
            if (FileOp.y(str2, str + str3) >= 0) {
                return true;
            }
            return false;
        } else {
            Options options2222222 = new Options();
            c.c(options2222222);
            InputStream inputStream22222222 = null;
            try {
                InputStream inputStream32222222;
                inputStream22222222 = FileOp.openRead(str2);
                try {
                    if (inputStream22222222.markSupported() || !(inputStream22222222 instanceof FileInputStream)) {
                        inputStream32222222 = inputStream22222222;
                    } else {
                        inputStream32222222 = new i((FileInputStream) inputStream22222222);
                    }
                } catch (Throwable e422222222222222222222222222222222222) {
                    th = e422222222222222222222222222222222222;
                    inputStream = inputStream22222222;
                    try {
                        x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "Decode bitmap failed: " + str2, new Object[0]);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e522222222222222) {
                            }
                        }
                        return false;
                    } catch (Throwable e4222222222222222222222222222222222222) {
                        th = e4222222222222222222222222222222222222;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e62222222222222222222222222222) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable e42222222222222222222222222222222222222) {
                    th = e42222222222222222222222222222222222222;
                    inputStream = inputStream22222222;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e622222222222222222222222222222) {
                        }
                    }
                    throw th;
                }
                try {
                    inputStream32222222.mark(1048576);
                    DecodeResultLogger decodeResultLogger2222222 = new DecodeResultLogger();
                    Bitmap decodeStream2222222 = MMBitmapFactory.decodeStream(inputStream32222222, null, options2222222, decodeResultLogger2222222, 0, new int[0]);
                    inputStream32222222.reset();
                    if (decodeStream2222222 == null) {
                        if (decodeResultLogger2222222.getDecodeResult() >= 2000) {
                            com.tencent.mm.plugin.report.service.h.mEJ.k(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger2222222));
                        }
                        if (inputStream32222222 != null) {
                            try {
                                inputStream32222222.close();
                            } catch (IOException e72222222) {
                            }
                        }
                        return false;
                    }
                    c.a(c.b(decodeStream2222222, (float) i8), i4, CompressFormat.JPEG, str + str3, true);
                    if (z2 && i8 == 0) {
                        x.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str + str3)), Integer.valueOf(i7)});
                        if ((((long) mI) - FileOp.mI(str + str3)) * 100 < ((long) (i7 * mI))) {
                            FileOp.deleteFile(str + str3);
                            z3222 = FileOp.y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                            if (inputStream32222222 == null) {
                                return z3222;
                            }
                            try {
                                inputStream32222222.close();
                                return z3222;
                            } catch (IOException e82222222) {
                                return z3222;
                            }
                        }
                        if (inputStream32222222 != null) {
                            try {
                                inputStream32222222.close();
                            } catch (IOException e92222222) {
                            }
                        }
                        return true;
                    }
                    if (inputStream32222222 != null) {
                        try {
                            inputStream32222222.close();
                        } catch (IOException e102222222) {
                        }
                    }
                    return true;
                } catch (Throwable e1122222222222222) {
                    th = e1122222222222222;
                    inputStream = inputStream32222222;
                    x.printErrStackTrace("MicroMsg.snsMediaStorage", th, "Decode bitmap failed: " + str2, new Object[0]);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5222222222222222) {
                        }
                    }
                    return false;
                } catch (Throwable e11222222222222222) {
                    th = e11222222222222222;
                    inputStream = inputStream32222222;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e6222222222222222222222222222222) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable e422222222222222222222222222222222222222) {
                th = e422222222222222222222222222222222222222;
                inputStream = inputStream22222222;
            } catch (Throwable e4222222222222222222222222222222222222222) {
                th = e4222222222222222222222222222222222222222;
                inputStream = inputStream22222222;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e62222222222222222222222222222222) {
                    }
                }
                throw th;
            }
        }
    }

    private static boolean a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, String str3, boolean z) {
        Options VZ = c.VZ(str);
        if (VZ == null || VZ.outWidth <= 0 || VZ.outHeight <= 0) {
            return false;
        }
        return a(str, VZ.outWidth, VZ.outHeight, i, i2, compressFormat, i3, str2, str3, z);
    }

    private static boolean a(String str, int i, int i2, int i3, CompressFormat compressFormat, int i4, String str2, String str3) {
        OutputStream outputStream = null;
        try {
            Bitmap b;
            x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %d, srcHeight: %d, fixShort: %d, quality:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            Options options = new Options();
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            int i5 = i2 > i ? i : i2;
            if (i5 == i3) {
                b = com.tencent.mm.plugin.sns.d.a.b(str, options, decodeResultLogger);
            } else {
                options.inSampleSize = 1;
                if (i5 > i3) {
                    options.inSampleSize = i5 / i3;
                    if (options.inSampleSize <= 1) {
                        options.inSampleSize = 1;
                    }
                }
                while (((i2 * i) / options.inSampleSize) / options.inSampleSize > 5529600) {
                    options.inSampleSize++;
                }
                x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", new Object[]{Integer.valueOf(options.inSampleSize)});
                b = com.tencent.mm.plugin.sns.d.a.b(str, options, decodeResultLogger);
            }
            x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", new Object[]{b});
            if (b == null) {
                if (decodeResultLogger.getDecodeResult() >= 2000) {
                    com.tencent.mm.plugin.report.service.h.mEJ.k(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
                }
                return false;
            }
            int i6;
            int i7;
            int i8 = (i * i3) / i5;
            int i9 = (i2 * i3) / i5;
            int VX = ExifHelper.VX(str);
            if (VX == 90 || VX == TXLiveConstants.RENDER_ROTATION_LANDSCAPE) {
                i6 = i9;
                i7 = i8;
            } else {
                i6 = i8;
                i7 = i9;
            }
            x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s, new:[%d,%d], src:[%d, %d], shortEdge:%d,degree:%d", new Object[]{Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(VX)});
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b, i6, i7, true);
            if (createScaledBitmap == null) {
                createScaledBitmap = b;
            } else if (b != createScaledBitmap) {
                l.Fu().l(b);
            }
            x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort, bm.width: %s, bm.height: %s, quality:%d", new Object[]{Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(createScaledBitmap.getHeight()), Integer.valueOf(i4)});
            outputStream = FileOp.jx(str2 + str3);
            c.a(createScaledBitmap, i4, compressFormat, outputStream, false);
            l.Fu().l(createScaledBitmap);
            outputStream.close();
            x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort saving to %s, size:%d", new Object[]{str2 + str3, Long.valueOf(FileOp.mI(str2 + str3))});
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.snsMediaStorage", e, "create thumbnail from orig failed: %s", new Object[]{str3});
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
            return false;
        }
    }

    public static boolean NB(String str) {
        InputStream inputStream = null;
        try {
            inputStream = FileOp.openRead(str);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeStream(inputStream, null, options, null, 0, new int[0]);
            String str2 = options.outMimeType;
            x.d("MicroMsg.snsMediaStorage", "mineType " + str2);
            if (str2.toLowerCase().indexOf("webp") >= 0) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
                return true;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
            return false;
        } catch (Exception e3) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
            return false;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
        }
    }

    public static boolean a(String str, String str2, String str3, float f) {
        Object obj;
        InputStream inputStream = null;
        double d;
        int i;
        String str4;
        double d2;
        double d3;
        double d4;
        Object obj2;
        int i2;
        int i3;
        int i4;
        CompressFormat compressFormat;
        try {
            inputStream = FileOp.openRead(str + str2);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeStream(inputStream, null, options, null, 0, new int[0]);
            inputStream.close();
            try {
                Object i5;
                d = (double) options.outWidth;
                double d5 = (double) options.outHeight;
                if (d > 120.0d || d5 > 120.0d) {
                    i5 = null;
                } else {
                    i5 = 1;
                }
                try {
                    str4 = options.outMimeType;
                    if (d < 0.0d || d5 < 0.0d) {
                        d2 = 240.0d;
                        d3 = 240.0d;
                    } else {
                        d3 = d5;
                        d2 = d;
                    }
                    double d6 = (double) f;
                    d4 = (double) ((f / 200.0f) * 44.0f);
                    double d7 = (double) ((f / 200.0f) * 160.0f);
                    if (d2 <= 0.0d || d3 <= 0.0d) {
                        obj2 = i5;
                        d3 = d5;
                        d2 = d7;
                        d4 = d7;
                        str4 = str + str2;
                        i2 = (int) d;
                        i3 = (int) d3;
                        i4 = (int) d2;
                        i5 = (int) d4;
                        if (obj2 != null) {
                            compressFormat = CompressFormat.PNG;
                        } else {
                            compressFormat = CompressFormat.JPEG;
                        }
                        return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
                    }
                    double min = Math.min(d6 / d2, d6 / d3);
                    d7 = d2 * min;
                    d3 *= min;
                    if (d7 < d4) {
                        d2 = (1.0d * d4) / d7;
                        d7 *= d2;
                        d3 *= d2;
                    }
                    if (d3 < d4) {
                        d2 = (1.0d * d4) / d3;
                        d7 *= d2;
                        d3 *= d2;
                    }
                    if (d7 > d6) {
                        d7 = d6;
                    }
                    if (d3 <= d6) {
                        d6 = d3;
                    }
                    obj2 = i5;
                    d3 = d5;
                    d2 = d6;
                    d4 = d7;
                    str4 = str + str2;
                    i2 = (int) d;
                    i3 = (int) d3;
                    i4 = (int) d2;
                    i5 = (int) d4;
                    if (obj2 != null) {
                        compressFormat = CompressFormat.JPEG;
                    } else {
                        compressFormat = CompressFormat.PNG;
                    }
                    return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
                } catch (Exception e) {
                    inputStream = null;
                    obj = i5;
                    d3 = d5;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            obj2 = obj;
                            d2 = 240.0d;
                            d4 = 240.0d;
                        } catch (IOException e2) {
                            obj2 = obj;
                            d2 = 240.0d;
                            d4 = 240.0d;
                            str4 = str + str2;
                            i2 = (int) d;
                            i3 = (int) d3;
                            i4 = (int) d2;
                            i5 = (int) d4;
                            if (obj2 != null) {
                                compressFormat = CompressFormat.PNG;
                            } else {
                                compressFormat = CompressFormat.JPEG;
                            }
                            return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
                        }
                        str4 = str + str2;
                        i2 = (int) d;
                        i3 = (int) d3;
                        i4 = (int) d2;
                        i5 = (int) d4;
                        if (obj2 != null) {
                            compressFormat = CompressFormat.PNG;
                        } else {
                            compressFormat = CompressFormat.JPEG;
                        }
                        return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
                    }
                    obj2 = obj;
                    d2 = 240.0d;
                    d4 = 240.0d;
                    str4 = str + str2;
                    i2 = (int) d;
                    i3 = (int) d3;
                    i4 = (int) d2;
                    i5 = (int) d4;
                    if (obj2 != null) {
                        compressFormat = CompressFormat.JPEG;
                    } else {
                        compressFormat = CompressFormat.PNG;
                    }
                    return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
                }
            } catch (Exception e3) {
                inputStream = null;
                i2 = 1;
                d3 = 0.0d;
                d = 0.0d;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        obj2 = obj;
                        d2 = 240.0d;
                        d4 = 240.0d;
                    } catch (IOException e22) {
                        obj2 = obj;
                        d2 = 240.0d;
                        d4 = 240.0d;
                        str4 = str + str2;
                        i2 = (int) d;
                        i3 = (int) d3;
                        i4 = (int) d2;
                        i5 = (int) d4;
                        if (obj2 != null) {
                            compressFormat = CompressFormat.PNG;
                        } else {
                            compressFormat = CompressFormat.JPEG;
                        }
                        return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
                    }
                    str4 = str + str2;
                    i2 = (int) d;
                    i3 = (int) d3;
                    i4 = (int) d2;
                    i5 = (int) d4;
                    if (obj2 != null) {
                        compressFormat = CompressFormat.PNG;
                    } else {
                        compressFormat = CompressFormat.JPEG;
                    }
                    return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
                }
                obj2 = obj;
                d2 = 240.0d;
                d4 = 240.0d;
                str4 = str + str2;
                i2 = (int) d;
                i3 = (int) d3;
                i4 = (int) d2;
                i5 = (int) d4;
                if (obj2 != null) {
                    compressFormat = CompressFormat.JPEG;
                } else {
                    compressFormat = CompressFormat.PNG;
                }
                return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
            }
        } catch (Exception e4) {
            obj = 1;
            d3 = 0.0d;
            d = 0.0d;
            if (inputStream != null) {
                try {
                    inputStream.close();
                    obj2 = obj;
                    d2 = 240.0d;
                    d4 = 240.0d;
                } catch (IOException e222) {
                    obj2 = obj;
                    d2 = 240.0d;
                    d4 = 240.0d;
                    str4 = str + str2;
                    i2 = (int) d;
                    i3 = (int) d3;
                    i4 = (int) d2;
                    i5 = (int) d4;
                    if (obj2 != null) {
                        compressFormat = CompressFormat.PNG;
                    } else {
                        compressFormat = CompressFormat.JPEG;
                    }
                    return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
                }
                str4 = str + str2;
                i2 = (int) d;
                i3 = (int) d3;
                i4 = (int) d2;
                i5 = (int) d4;
                if (obj2 != null) {
                    compressFormat = CompressFormat.PNG;
                } else {
                    compressFormat = CompressFormat.JPEG;
                }
                return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
            }
            obj2 = obj;
            d2 = 240.0d;
            d4 = 240.0d;
            str4 = str + str2;
            i2 = (int) d;
            i3 = (int) d3;
            i4 = (int) d2;
            i5 = (int) d4;
            if (obj2 != null) {
                compressFormat = CompressFormat.PNG;
            } else {
                compressFormat = CompressFormat.JPEG;
            }
            return a(str4, i2, i3, i4, i5, compressFormat, 70, str, str3, false);
        }
    }

    private static boolean a(String str, int i, int i2, int i3, int i4, CompressFormat compressFormat, int i5, String str2, String str3, boolean z) {
        OutputStream outputStream = null;
        try {
            Bitmap b;
            x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3)});
            Options options = new Options();
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            double d = (((double) i2) * 1.0d) / ((double) i3);
            double d2 = (((double) i) * 1.0d) / ((double) i4);
            if (i == i4 && i2 == i3) {
                b = com.tencent.mm.plugin.sns.d.a.b(str, options, decodeResultLogger);
            } else {
                options.inSampleSize = 1;
                if (i2 > i3 || i > i4) {
                    options.inSampleSize = (int) (d < d2 ? d2 : d);
                    if (options.inSampleSize <= 1) {
                        options.inSampleSize = 1;
                    }
                }
                while (((i2 * i) / options.inSampleSize) / options.inSampleSize > 2764800) {
                    options.inSampleSize++;
                }
                x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", new Object[]{Integer.valueOf(options.inSampleSize)});
                b = com.tencent.mm.plugin.sns.d.a.b(str, options, decodeResultLogger);
            }
            x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", new Object[]{b});
            if (b == null) {
                if (decodeResultLogger.getDecodeResult() >= 2000) {
                    com.tencent.mm.plugin.report.service.h.mEJ.k(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
                }
                return false;
            }
            x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight())});
            if (z) {
                int ceil;
                int i6;
                int i7;
                if (d < d2) {
                    ceil = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i2)) / ((double) i));
                    i6 = i4;
                } else {
                    i6 = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) i)) / ((double) i2));
                    ceil = i3;
                }
                int VX = ExifHelper.VX(str);
                if (VX == 90 || VX == TXLiveConstants.RENDER_ROTATION_LANDSCAPE) {
                    VX = ceil;
                    i7 = i6;
                } else {
                    VX = i6;
                    i7 = ceil;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b, VX, i7, true);
                if (createScaledBitmap != null) {
                    if (b != createScaledBitmap) {
                        l.Fu().l(b);
                    }
                    b = createScaledBitmap;
                }
                x.i("MicroMsg.snsMediaStorage", "createThumbNailUnScalebyUpload, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight())});
            }
            outputStream = FileOp.jx(str2 + str3);
            c.a(b, i5, compressFormat, outputStream, false);
            l.Fu().l(b);
            outputStream.close();
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.snsMediaStorage", e, "create thumbnail from orig failed: %s", new Object[]{str3});
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
            return false;
        }
    }

    public static boolean b(String str, String str2, String str3, float f) {
        try {
            FileOp.deleteFile(str + str3);
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            Options VZ = c.VZ(str + str2);
            if (VZ == null) {
                x.e("MicroMsg.snsMediaStorage", "createUserAlbum, getImageOptions error");
                return false;
            }
            Bitmap b;
            if (VZ.outMimeType == null || !(VZ.outMimeType.toLowerCase().endsWith("png") || VZ.outMimeType.toLowerCase().endsWith("vcodec"))) {
                int i = VZ.outWidth;
                int i2 = VZ.outHeight;
                int i3 = (int) f;
                int i4 = (int) f;
                VZ.inJustDecodeBounds = false;
                x.i("MicroMsg.snsMediaStorage", "createUserAlbum, srcWidth: %s, srcHeight: %s, dstWidth: %s, dstHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
                if (i == i3 && i2 == i4) {
                    b = com.tencent.mm.plugin.sns.d.a.b(str + str2, VZ, decodeResultLogger);
                } else {
                    int i5;
                    int ceil;
                    if ((((double) i2) * 1.0d) / ((double) i4) > (((double) i) * 1.0d) / ((double) i3)) {
                        i5 = i3;
                        ceil = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) i2)) / ((double) i));
                    } else {
                        i5 = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i)) / ((double) i2));
                        ceil = i4;
                    }
                    x.d("MicroMsg.snsMediaStorage", "createUserAlbum, newWidth: %s, newHeight: %s", new Object[]{Integer.valueOf(i5), Integer.valueOf(ceil)});
                    VZ.inSampleSize = 1;
                    if (i2 > ceil || i > i5) {
                        VZ.inSampleSize = 1;
                        if (i2 > ceil || i > i5) {
                            double d = (((double) i2) * 1.0d) / ((double) ceil);
                            double d2 = (((double) i) * 1.0d) / ((double) i5);
                            if (d >= d2) {
                                d2 = d;
                            }
                            VZ.inSampleSize = (int) d2;
                            if (VZ.inSampleSize <= 1) {
                                VZ.inSampleSize = 1;
                            }
                        }
                        while (((i2 * i) / VZ.inSampleSize) / VZ.inSampleSize > 2764800) {
                            VZ.inSampleSize++;
                        }
                    }
                    x.i("MicroMsg.snsMediaStorage", "createUserAlbum, inSampleSize: %s", new Object[]{Integer.valueOf(VZ.inSampleSize)});
                    Bitmap b2;
                    if (((float) i2) / ((float) i) == ((float) i4) / ((float) i3)) {
                        b2 = com.tencent.mm.plugin.sns.d.a.b(str + str2, VZ, decodeResultLogger);
                        x.i("MicroMsg.snsMediaStorage", "createUserAlbum, directly use inSampleSize");
                        b = b2;
                    } else {
                        float max = Math.max(((float) i5) / ((float) i), ((float) ceil) / ((float) i2));
                        int i6 = (int) (((float) i4) / max);
                        int min = Math.min(i, (int) (((float) i3) / max));
                        i6 = Math.min(i2, i6);
                        i5 = (i2 - i6) >> 1;
                        i3 = Math.max(0, (i - min) >> 1);
                        i5 = Math.max(0, i5);
                        Rect rect = new Rect();
                        rect.left = i3;
                        rect.right = i3 + min;
                        rect.top = i5;
                        rect.bottom = i5 + i6;
                        String str4 = str + str2;
                        long currentTimeMillis = System.currentTimeMillis();
                        b2 = l.Fu().a(str4, rect, VZ, decodeResultLogger);
                        if (b2 != null) {
                            b2 = com.tencent.mm.plugin.sns.data.i.s(str4, b2);
                        }
                        x.d("MicroMsg.SnsBitmapUtil", "regionDecodeWithRotateByExif used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        x.i("MicroMsg.snsMediaStorage", "createUserAlbum, dstWidth: %s, dstHeight: %s, startX: %s, startY: %s, scaleFactor: %s", new Object[]{Integer.valueOf(min), Integer.valueOf(i6), Integer.valueOf(i3), Integer.valueOf(i5), Float.valueOf(max)});
                        b = b2;
                    }
                }
            } else {
                b = c.a(str + str2, (int) f, (int) f, true, decodeResultLogger, 0);
            }
            if (b == null) {
                x.i("MicroMsg.snsMediaStorage", "bitmap error " + str + str2);
                if (decodeResultLogger.getDecodeResult() >= 2000) {
                    com.tencent.mm.plugin.report.service.h.mEJ.k(12712, KVStatHelper.getKVStatString(str + str2, 10, decodeResultLogger));
                }
                FileOp.deleteFile(str + str2);
                return false;
            }
            x.i("MicroMsg.snsMediaStorage", "createUserAlbum, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight())});
            Object obj = 1;
            if (b.getHeight() > 120 || b.getWidth() > 120) {
                obj = null;
            }
            c.a(b, 100, obj != null ? CompressFormat.PNG : CompressFormat.JPEG, str + str3, false);
            l.Fu().l(b);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.snsMediaStorage", "createUserAlbum error: %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.snsMediaStorage", e, "", new Object[0]);
        }
    }

    public static Bitmap NC(String str) {
        int i = 640;
        Options VZ = c.VZ(str);
        int i2 = VZ.outWidth >= VZ.outHeight ? 960 : 640;
        if (VZ.outWidth < VZ.outHeight) {
            i = 960;
        }
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        Bitmap a = c.a(str, i, i2, false, decodeResultLogger, 0);
        if (a == null) {
            if (decodeResultLogger.getDecodeResult() >= 2000) {
                com.tencent.mm.plugin.report.service.h.mEJ.k(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
            }
            return null;
        }
        try {
            Exif exif = new Exif();
            exif.parseFromFile(str);
            return c.b(a, (float) exif.getOrientationInDegree());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.snsMediaStorage", e, "parse exif failed: " + str, new Object[0]);
            return a;
        }
    }
}
