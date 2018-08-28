package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.ak.a.c.i;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.adb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class EmojiLogic {
    public static final String ihe = File.separator;

    public static native boolean extractForeground(int[] iArr, int i, int i2);

    public static native boolean gifToMMAni(byte[] bArr, PByteArray pByteArray, int i);

    public static int ak(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return EmojiInfo.tcx;
        }
        if (bArr[1] == (byte) 80 && bArr[2] == (byte) 78 && bArr[3] == (byte) 71) {
            return EmojiInfo.tcI;
        }
        if (bArr[0] == (byte) 71 && bArr[1] == (byte) 73 && bArr[2] == (byte) 70) {
            return EmojiInfo.tcJ;
        }
        if (bArr[6] == (byte) 74 && bArr[7] == (byte) 70 && bArr[8] == (byte) 73 && bArr[9] == (byte) 70) {
            return EmojiInfo.tcK;
        }
        return EmojiInfo.tcx;
    }

    public static String zj(String str) {
        String str2 = null;
        if (!bi.oW(str)) {
            int cm = e.cm(str);
            if (cm > 0) {
                byte[] e = e.e(str, 0, cm);
                str2 = g.u(e);
                if (!(str2 == null && e == null)) {
                    au.HU();
                    e.b(c.Gg() + str2, e, e.length);
                    if (o.bv(e)) {
                        i.aEA().igx.a(str2, "", EmojiInfo.tcB, EmojiInfo.tcJ, e.length, "", "");
                    } else {
                        i.aEA().igx.a(str2, "", EmojiInfo.tcB, EmojiInfo.tcI, e.length, "", "");
                    }
                }
            }
        }
        return str2;
    }

    public static String b(Context context, WXMediaMessage wXMediaMessage, String str) {
        if (wXMediaMessage.getType() != 8) {
            return null;
        }
        WXEmojiObject wXEmojiObject = (WXEmojiObject) wXMediaMessage.mediaObject;
        if (!bi.bC(wXEmojiObject.emojiData)) {
            x.d("MicroMsg.emoji.EmojiLogic", " fileData:" + wXEmojiObject.emojiData.length);
            String u = g.u(wXEmojiObject.emojiData);
            a(context, wXMediaMessage.thumbData, u, wXEmojiObject.emojiData, str);
            return u;
        } else if (bi.oW(wXEmojiObject.emojiPath)) {
            return null;
        } else {
            int cm = e.cm(wXEmojiObject.emojiPath);
            if (cm <= 0) {
                return null;
            }
            byte[] e = e.e(wXEmojiObject.emojiPath, 0, cm);
            String u2 = g.u(e);
            a(context, wXMediaMessage.thumbData, u2, e, str);
            return u2;
        }
    }

    private static void a(Context context, byte[] bArr, String str, byte[] bArr2, String str2) {
        if (str != null || bArr2 != null) {
            EmojiInfo a;
            au.HU();
            String Gg = c.Gg();
            e.b(Gg + str, bArr2, bArr2.length);
            if (o.bv(bArr2)) {
                a = i.aEA().igx.a(str, "", EmojiInfo.tcB, EmojiInfo.tcL, bArr2.length, str2, "");
            } else {
                a = i.aEA().igx.a(str, "", EmojiInfo.tcB, EmojiInfo.tcM, bArr2.length, str2, "");
            }
            a(context, bArr, str, Gg, a);
        }
    }

    public static void a(Context context, byte[] bArr, String str, String str2, EmojiInfo emojiInfo) {
        Bitmap gi;
        Bitmap bitmap;
        if (bArr == null) {
            String str3 = "MicroMsg.emoji.EmojiLogic";
            String str4 = "insertEmoji: thumb is null, emojiInfo is null ? %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(emojiInfo == null);
            x.d(str3, str4, objArr);
            if (emojiInfo != null) {
                gi = emojiInfo.gi(context);
            } else {
                return;
            }
        }
        gi = com.tencent.mm.sdk.platformtools.c.bs(bArr);
        if (gi == null || (gi.getWidth() <= 300 && gi.getHeight() <= 300)) {
            bitmap = gi;
        } else {
            int width = gi.getWidth();
            int height = gi.getHeight();
            x.i("MicroMsg.emoji.EmojiLogic", "cpan app msg width:%d height:%d", new Object[]{Integer.valueOf(width), Integer.valueOf(height)});
            if (width > height) {
                float f = ((float) height) / ((float) width);
                height = 300;
                width = (int) (f * 300.0f);
            } else {
                float f2 = ((float) width) / ((float) height);
                width = 300;
                height = (int) (f2 * 300.0f);
            }
            x.i("MicroMsg.emoji.EmojiLogic", "cpan app msg new width:%d new height:%d", new Object[]{Integer.valueOf(height), Integer.valueOf(width)});
            bitmap = com.tencent.mm.sdk.platformtools.c.a(gi, width, height, false, true);
        }
        if (bitmap != null) {
            try {
                if (bitmap.getByteCount() > 32768) {
                    com.tencent.mm.sdk.platformtools.c.a(bitmap, 80, CompressFormat.JPEG, str2 + str + "_thumb", true);
                    x.i("MicroMsg.emoji.EmojiLogic", "cpan app msg bitmap is over size. save as jpg. size :%d", new Object[]{Integer.valueOf(bitmap.getByteCount())});
                    return;
                }
                com.tencent.mm.sdk.platformtools.c.a(bitmap, 100, CompressFormat.PNG, str2 + str + "_thumb", true);
                x.i("MicroMsg.emoji.EmojiLogic", "cpan app msg bitmap is in normal size. sav as png. size :%d", new Object[]{Integer.valueOf(bitmap.getByteCount())});
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.emoji.EmojiLogic", e, "insertEmoji Error", new Object[0]);
            }
        }
    }

    public static EmojiInfo a(String str, String str2, i iVar) {
        au.HU();
        if (c.isSDCardAvailable()) {
            EmojiInfo a = a(str, 4, str2, true);
            if (a == null) {
                com.tencent.mm.ak.o.Pj().a(str2, null, f.c(str, str2, new Object[0]), iVar);
                x.i("MicroMsg.emoji.EmojiLogic", "[cpan] get emoji info, try to load image:%s", new Object[]{str2});
            }
            return a;
        } else if (ad.getContext() == null || ad.getContext().getResources() == null) {
            return null;
        } else {
            new EmojiInfo().field_type = EmojiInfo.tcI;
            return null;
        }
    }

    public static EmojiInfo a(String str, int i, String str2, boolean z) {
        int i2 = 0;
        if (TextUtils.isEmpty(str)) {
            x.d("MicroMsg.emoji.EmojiLogic", "getIcon : productId is null.");
            return null;
        }
        int i3;
        EmojiInfo emojiInfo = new EmojiInfo();
        if (z) {
            au.HU();
            String K = K(c.Gg(), str, str2);
            if (e.cn(K)) {
                File file = new File(K);
                if (file.exists()) {
                    if (file.length() < 1) {
                        file.delete();
                    } else {
                        emojiInfo.field_type = ak(e.e(K, 0, 10));
                        i2 = 1;
                    }
                }
            }
            if (i2 == 0) {
                x.d("MicroMsg.emoji.EmojiLogic", "banner icon does not exist. icon path :" + K + "...., icon type:" + i);
                return null;
            }
        }
        au.HU();
        if (!e.cn(K(c.Gg(), str, str2))) {
            x.d("MicroMsg.emoji.EmojiLogic", "icon file no exist. path:%s type:%d, url:%s", new Object[]{K(c.Gg(), str, str2), Integer.valueOf(i), str2});
            return null;
        }
        emojiInfo.field_md5 = cw(str, str2);
        switch (i) {
            case 2:
                i3 = 82;
                break;
            case 4:
                i3 = 83;
                break;
            case 8:
                i3 = 84;
                break;
            default:
                i3 = EmojiInfo.tcD;
                break;
        }
        emojiInfo.field_catalog = i3;
        emojiInfo.field_groupId = str;
        emojiInfo.field_temp = 1;
        return emojiInfo;
    }

    public static boolean a(String str, String str2, EmojiGroupInfo emojiGroupInfo) {
        Exception e;
        Throwable th;
        String str3 = com.tencent.mm.compatible.util.e.dgj + str;
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        String stringBuilder2 = stringBuilder.append(c.Gg()).append(str).toString();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        HashMap hashMap = new HashMap();
        Object arrayList = new ArrayList();
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(str3);
            try {
                ZipEntry zipEntry;
                byte[] bArr;
                int read;
                EmojiInfo Zy;
                InputStream inputStream2;
                Enumeration entries = zipFile.entries();
                int i = 0;
                OutputStream outputStream2 = null;
                while (entries.hasMoreElements()) {
                    try {
                        zipEntry = (ZipEntry) entries.nextElement();
                        if (!zipEntry.isDirectory()) {
                            inputStream = zipFile.getInputStream(zipEntry);
                            String toLowerCase = zipEntry.getName().substring(zipEntry.getName().lastIndexOf("/") + 1).toLowerCase();
                            File file = new File(stringBuilder2 + "/" + zipEntry.getName());
                            if (file.isFile()) {
                                file.delete();
                            }
                            file.getParentFile().mkdirs();
                            if (!toLowerCase.startsWith(".") && (toLowerCase.endsWith(".gif") || toLowerCase.endsWith(".png"))) {
                                if (zipEntry.getName().toLowerCase().contains("/large/")) {
                                    int i2;
                                    outputStream = new FileOutputStream(stringBuilder2 + File.separator + toLowerCase);
                                    bArr = new byte[131072];
                                    while (true) {
                                        read = inputStream.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        outputStream.write(bArr, 0, read);
                                    }
                                    outputStream.close();
                                    outputStream2 = null;
                                    String cu = g.cu(stringBuilder2 + File.separator + toLowerCase);
                                    x.i("MicroMsg.emoji.EmojiLogic", "md5:%s index:%d", new Object[]{cu, Integer.valueOf(i)});
                                    File file2 = new File(stringBuilder2 + File.separator + toLowerCase);
                                    File file3 = new File(stringBuilder2 + File.separator + cu);
                                    if (o.Wf(file2.getPath())) {
                                        i2 = EmojiInfo.tcJ;
                                    } else {
                                        i2 = EmojiInfo.tcI;
                                    }
                                    Zy = i.aEA().igx.Zy(cu);
                                    if (Zy == null) {
                                        Zy = new EmojiInfo();
                                        Zy.field_catalog = 0;
                                    }
                                    Zy.field_name = toLowerCase;
                                    Zy.field_md5 = cu;
                                    Zy.field_size = (int) file2.length();
                                    Zy.field_type = i2;
                                    Zy.field_groupId = str;
                                    Zy.field_idx = i;
                                    arrayList.add(Zy);
                                    file2.renameTo(file3);
                                    hashMap.put(toLowerCase.substring(0, toLowerCase.length() - 4), cu);
                                    inputStream2 = inputStream;
                                    if (inputStream2 == null) {
                                        try {
                                            inputStream2.close();
                                            inputStream2 = null;
                                        } catch (Exception e2) {
                                            e = e2;
                                            outputStream = outputStream2;
                                            inputStream = inputStream2;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            outputStream = outputStream2;
                                            inputStream = inputStream2;
                                        }
                                    }
                                    i++;
                                    inputStream = inputStream2;
                                } else if (toLowerCase.startsWith("icon")) {
                                    outputStream = new FileOutputStream(stringBuilder2 + File.separator + (g.u(str.getBytes()) + "_panel_enable"));
                                    bArr = new byte[131072];
                                    while (true) {
                                        read = inputStream.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        outputStream.write(bArr, 0, read);
                                    }
                                    outputStream.close();
                                    outputStream2 = null;
                                    inputStream2 = inputStream;
                                    if (inputStream2 == null) {
                                        try {
                                            inputStream2.close();
                                            inputStream2 = null;
                                        } catch (Exception e22) {
                                            e = e22;
                                            outputStream = outputStream2;
                                            inputStream = inputStream2;
                                        } catch (Throwable th22) {
                                            th = th22;
                                            outputStream = outputStream2;
                                            inputStream = inputStream2;
                                        }
                                    }
                                    i++;
                                    inputStream = inputStream2;
                                }
                            }
                        }
                        inputStream2 = inputStream;
                        if (inputStream2 == null) {
                            try {
                                inputStream2.close();
                                inputStream2 = null;
                            } catch (Exception e222) {
                                e = e222;
                                outputStream = outputStream2;
                                inputStream = inputStream2;
                            } catch (Throwable th222) {
                                th = th222;
                                outputStream = outputStream2;
                                inputStream = inputStream2;
                            }
                        }
                        i++;
                        inputStream = inputStream2;
                    } catch (Exception e3) {
                        e = e3;
                        outputStream = outputStream2;
                    } catch (Throwable th3) {
                        th = th3;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        throw th;
                    }
                }
                Enumeration entries2 = zipFile.entries();
                while (entries2.hasMoreElements()) {
                    zipEntry = (ZipEntry) entries2.nextElement();
                    if (!zipEntry.isDirectory()) {
                        inputStream = zipFile.getInputStream(zipEntry);
                        String toLowerCase2 = zipEntry.getName().substring(zipEntry.getName().lastIndexOf("/") + 1).toLowerCase();
                        File file4 = new File(stringBuilder2 + "/" + zipEntry.getName());
                        if (file4.isFile()) {
                            file4.delete();
                        }
                        file4.getParentFile().mkdirs();
                        if (zipEntry.getName().toLowerCase().contains("/thumb/")) {
                            int lastIndexOf = toLowerCase2.lastIndexOf(".") + 1;
                            String str4 = toLowerCase2.substring(0, lastIndexOf - 1) + "_cover." + toLowerCase2.substring(lastIndexOf);
                            outputStream = new FileOutputStream(stringBuilder2 + File.separator + str4);
                            bArr = new byte[131072];
                            while (true) {
                                read = inputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                outputStream.write(bArr, 0, read);
                            }
                            outputStream.close();
                            outputStream2 = null;
                            String substring = str4.substring(0, str4.lastIndexOf("_cover."));
                            if (hashMap.containsKey(substring)) {
                                substring = (String) hashMap.get(substring);
                                new File(stringBuilder2 + File.separator + str4).renameTo(new File(stringBuilder2 + File.separator + substring + "_cover"));
                                hashMap.put(str4, substring);
                            }
                        }
                    }
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        inputStream2.close();
                        inputStream2 = null;
                    }
                    inputStream = inputStream2;
                }
                hashMap.clear();
                if (emojiGroupInfo == null) {
                    emojiGroupInfo = i.aEA().igy.br(str, false);
                }
                emojiGroupInfo.field_productID = str;
                if (!bi.oW(str2)) {
                    emojiGroupInfo.field_packName = str2;
                }
                emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
                emojiGroupInfo.field_status = 7;
                emojiGroupInfo.field_packStatus = 1;
                emojiGroupInfo.field_type = EmojiGroupInfo.tcv;
                emojiGroupInfo.field_recommand = 0;
                emojiGroupInfo.field_sync = 2;
                emojiGroupInfo.field_count = arrayList.size();
                if (i.aEA().igx.j(arrayList, str)) {
                    boolean c = i.aEA().igy.c(emojiGroupInfo);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Zy = (EmojiInfo) it.next();
                        Zy.field_reserved4 = 0;
                        com.tencent.mm.plugin.emoji.e.e.aDM().c(Zy, true);
                    }
                    x.i("MicroMsg.emoji.EmojiLogic", "saveGroupFlag:%b saveEmojiFlag:%b", new Object[]{Boolean.valueOf(c), Boolean.valueOf(r3)});
                } else {
                    x.i("MicroMsg.emoji.EmojiLogic", "saveEmojiFlag:%b", new Object[]{Boolean.valueOf(i.aEA().igx.j(arrayList, str))});
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                zipFile.close();
                return true;
            } catch (Exception e32) {
                e = e32;
            }
        } catch (Exception e322) {
            e = e322;
            zipFile = null;
            try {
                x.e("MicroMsg.emoji.EmojiLogic", "un zip package fail." + e.getMessage());
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (zipFile != null) {
                    zipFile.close();
                }
                return false;
            } catch (Throwable th32) {
                th = th32;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (zipFile != null) {
                    zipFile.close();
                }
                throw th;
            }
        } catch (Throwable th322) {
            th = th322;
            zipFile = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
            throw th;
        }
    }

    public static adb aEq() {
        adb adb = new adb();
        adb.rHu = 1;
        adb.rHw = 1;
        return adb;
    }

    public static String zu(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<productid>" + str + "</productid>");
        stringBuilder.append("</xml>");
        x.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", new Object[]{stringBuilder.toString()});
        return stringBuilder.toString();
    }

    public static String h(int i, String str, String str2) {
        if (i == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<designeruin>" + i + "</designeruin>");
        stringBuilder.append("<designername>" + str + "</designername>");
        stringBuilder.append("<designerrediretcturl>" + str2 + "</designerrediretcturl>");
        stringBuilder.append("</xml>");
        x.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", new Object[]{stringBuilder.toString()});
        return stringBuilder.toString();
    }

    public static int zp(String str) {
        int cx;
        Exception e;
        try {
            cx = com.tencent.mm.a.o.cx((String) bl.z(str, "xml").get(".xml.designeruin"));
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "designeruin:%s", new Object[]{Integer.valueOf(cx)});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getDesignerUINBySnsObjData exception. %s", new Object[]{e.toString()});
                return cx;
            }
        } catch (Exception e3) {
            e = e3;
            cx = 0;
        }
        return cx;
    }

    public static String zq(String str) {
        String str2;
        Exception e;
        try {
            str2 = (String) bl.z(str, "xml").get(".xml.designername");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "designeruin:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getDesignerNameBySnsObjData exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            x.e("MicroMsg.emoji.EmojiLogic", "getDesignerNameBySnsObjData exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String zv(String str) {
        String str2;
        Exception e;
        try {
            str2 = (String) bl.z(str, "xml").get(".xml.designerrediretcturl");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "designerrediretcturl:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getDesignerRediretctUrlBySnsObjData exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            x.e("MicroMsg.emoji.EmojiLogic", "getDesignerRediretctUrlBySnsObjData exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String zo(String str) {
        String str2;
        Exception e;
        try {
            str2 = (String) bl.z(str, "xml").get(".xml.productid");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "productId:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getProductIdBySnsObjData exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            x.e("MicroMsg.emoji.EmojiLogic", "getProductIdBySnsObjData exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String zn(String str) {
        x.d("MicroMsg.emoji.EmojiLogic", "url:%s", new Object[]{str});
        String str2 = "";
        if (TextUtils.isEmpty(str) || !str.startsWith("http://weixin.qq.com/emoticonstore/")) {
            return str2;
        }
        return str.substring(str.lastIndexOf("/") + 1);
    }

    public static String a(int i, String str, String str2, String str3, String str4, int i2) {
        if (i <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<tid>" + i + "</tid>");
        stringBuilder.append("<title>" + str + "</title>");
        stringBuilder.append("<desc>" + str2 + "</desc>");
        stringBuilder.append("<iconUrl>" + str3 + "</iconUrl>");
        stringBuilder.append("<secondUrl>" + str4 + "</secondUrl>");
        stringBuilder.append("<pageType>" + i2 + "</pageType>");
        stringBuilder.append("</xml>");
        x.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", new Object[]{stringBuilder.toString()});
        return stringBuilder.toString();
    }

    public static int zw(String str) {
        int WU;
        Exception e;
        try {
            WU = bi.WU((String) bl.z(str, "xml").get(".xml.tid"));
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "tid:%s", new Object[]{Integer.valueOf(WU)});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTid exception. %s", new Object[]{e.toString()});
                return WU;
            }
        } catch (Exception e3) {
            e = e3;
            WU = 0;
        }
        return WU;
    }

    public static String zx(String str) {
        String str2;
        Exception e;
        try {
            str2 = (String) bl.z(str, "xml").get(".xml.title");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "title:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTitle exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTitle exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String zy(String str) {
        String str2;
        Exception e;
        try {
            str2 = (String) bl.z(str, "xml").get(".xml.desc");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "desc:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageDesc exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageDesc exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String zz(String str) {
        String str2;
        Exception e;
        try {
            str2 = (String) bl.z(str, "xml").get(".xml.iconUrl");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "iconUrl:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageIconUrl exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageIconUrl exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String zA(String str) {
        String aG;
        Exception e;
        String str2 = "";
        try {
            aG = bi.aG((String) bl.z(str, "xml").get(".xml.secondUrl"), "");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "secondUrl:%s", new Object[]{aG});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageSecondUrl exception. %s", new Object[]{e.toString()});
                return aG;
            }
        } catch (Exception e3) {
            e = e3;
            aG = str2;
        }
        return aG;
    }

    public static int zB(String str) {
        int WU;
        Exception e;
        try {
            WU = bi.WU((String) bl.z(str, "xml").get(".xml.pageType"));
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "pageType:%s", new Object[]{Integer.valueOf(WU)});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageType exception. %s", new Object[]{e.toString()});
                return WU;
            }
        } catch (Exception e3) {
            e = e3;
            WU = 0;
        }
        return WU;
    }

    public static String K(String str, String str2, String str3) {
        if (bi.oW(str2) && bi.oW(str3)) {
            x.w("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path failed. productid and url are null.");
            return null;
        }
        String cw = cw(str2, str3);
        if (bi.oW(cw)) {
            return null;
        }
        if (bi.oW(str2)) {
            return str + cw;
        }
        return str + str2 + ihe + cw;
    }

    public static String L(String str, String str2, String str3) {
        String str4 = null;
        if (bi.oW(str2) && bi.oW(str3)) {
            x.w("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path failed. productid and md5 are null.");
        } else {
            if (!bi.oW(str3)) {
                if (bi.oW(str2)) {
                    str4 = str + str3;
                } else {
                    str4 = str + str2 + ihe + str3;
                }
            }
            x.d("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path. productid:%s md5:%s path:%s", new Object[]{str2, str3, str4});
        }
        return str4;
    }

    private static String cw(String str, String str2) {
        if (bi.oW(str) && bi.oW(str2)) {
            x.e("MicroMsg.emoji.EmojiLogic", "[cpan] product id and url are null.");
            return null;
        } else if (bi.oW(str2)) {
            return g.u(str.getBytes());
        } else {
            return g.u(str2.getBytes());
        }
    }

    public static boolean zC(String str) {
        if (!bi.oW(str)) {
            try {
                if (b.lz(str)) {
                    x.d("MicroMsg.emoji.EmojiLogic", "In Not Auto Download Time Range. timeRange:%s", new Object[]{str});
                    return true;
                }
            } catch (Throwable e) {
                x.e("MicroMsg.emoji.EmojiLogic", "isInNotAutoDownloadTimeRange :%s", new Object[]{bi.i(e)});
            }
        }
        return false;
    }
}
