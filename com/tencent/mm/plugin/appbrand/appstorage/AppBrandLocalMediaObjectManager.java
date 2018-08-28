package com.tencent.mm.plugin.appbrand.appstorage;

import android.annotation.TargetApi;
import android.support.annotation.Keep;
import android.system.Os;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.j.d;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;

@Keep
public final class AppBrandLocalMediaObjectManager {
    private static final Collection<a> MEDIA_OBJECT_INFO_HANDLERS;
    private static final AppBrandLocalMediaObject Nil = new 3();
    public static final String OBJECT_NAME_PREFIX = "wxfile://";
    static final String OBJECT_ROOT_DIR_PATH;
    static final String PREFIX_STORE_FILE = "store_";
    static final String PREFIX_TEMP_FILE = "tmp_";
    static final String SUFFIX_PERMANENT_FILE = ".dat";
    static final String SUFFIX_TEMP_FILE = ".tmp";
    private static final String TAG = "MicroMsg.AppBrand.LocalMediaObjectManager";

    private interface a {
        com.tencent.mm.vending.j.a B(String str, String str2, String str3);

        AppBrandLocalMediaObject a(AppBrandLocalMediaObject appBrandLocalMediaObject);

        AppBrandLocalMediaObject aV(String str, String str2);

        AppBrandLocalMediaObject aW(String str, String str2);
    }

    private static final class c implements a {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final String toString() {
            return "V2MediaObjectInfoHandler";
        }

        public final AppBrandLocalMediaObject aV(String str, String str2) {
            String str3 = null;
            if (!str2.startsWith(AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE) && !str2.startsWith(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE)) {
                return str3;
            }
            String adS = org.a.a.a.a.adS(str2);
            String replaceFirst = str2.replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE, "").replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE, "");
            if (!bi.oW(adS)) {
                replaceFirst = replaceFirst.replaceFirst("." + adS, "");
            }
            if (bi.oW(replaceFirst)) {
                return AppBrandLocalMediaObjectManager.Nil;
            }
            try {
                str3 = AppBrandLocalMediaObjectManager.decrypt(replaceFirst, str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "retrieveMediaObject, decrypt exp ", new Object[0]);
            }
            if (bi.oW(str3)) {
                x.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
                return AppBrandLocalMediaObjectManager.Nil;
            }
            String[] split = str3.split("\\|");
            if (split == null || split.length != 2) {
                return AppBrandLocalMediaObjectManager.Nil;
            }
            str3 = str2.startsWith(AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE) ? AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE : AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE;
            String str4 = AppBrandLocalMediaObjectManager.getParentDir(str) + str3 + replaceFirst;
            long j = bi.getLong(split[0], 0);
            String str5 = split[1];
            if (!str5.equalsIgnoreCase(adS)) {
                return AppBrandLocalMediaObjectManager.Nil;
            }
            try {
                if (j != AppBrandLocalMediaObjectManager.getCRC(str4)) {
                    x.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s), appId(%s)", new Object[]{Long.valueOf(AppBrandLocalMediaObjectManager.getCRC(str4)), Long.valueOf(j), str2, str});
                    return AppBrandLocalMediaObjectManager.Nil;
                }
                AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject();
                appBrandLocalMediaObject.bNH = new StringBuilder(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX).append(str2).toString();
                appBrandLocalMediaObject.dDG = str4;
                appBrandLocalMediaObject.mimeType = s.Uh(str5);
                appBrandLocalMediaObject.fjT = str3.equalsIgnoreCase(AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE);
                File file = new File(appBrandLocalMediaObject.dDG);
                appBrandLocalMediaObject.fjU = file.lastModified();
                appBrandLocalMediaObject.eyz = file.length();
                return appBrandLocalMediaObject;
            } catch (Throwable e2) {
                x.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", new Object[]{bi.i(e2)});
                return AppBrandLocalMediaObjectManager.Nil;
            }
        }

        public final AppBrandLocalMediaObject a(AppBrandLocalMediaObject appBrandLocalMediaObject) {
            if (appBrandLocalMediaObject == null) {
                return null;
            }
            String replaceFirst = appBrandLocalMediaObject.dDG.replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE, AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE);
            if (!i.aX(appBrandLocalMediaObject.dDG, replaceFirst)) {
                return null;
            }
            AppBrandLocalMediaObject appBrandLocalMediaObject2 = new AppBrandLocalMediaObject();
            appBrandLocalMediaObject2.dDG = replaceFirst;
            appBrandLocalMediaObject2.bNH = appBrandLocalMediaObject.bNH.replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE, AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE);
            appBrandLocalMediaObject2.eyz = appBrandLocalMediaObject.eyz;
            appBrandLocalMediaObject2.fjS = appBrandLocalMediaObject.fjS;
            appBrandLocalMediaObject2.fjU = new File(appBrandLocalMediaObject2.dDG).lastModified();
            appBrandLocalMediaObject2.mimeType = appBrandLocalMediaObject.mimeType;
            appBrandLocalMediaObject2.fjT = true;
            return appBrandLocalMediaObject2;
        }

        public final com.tencent.mm.vending.j.a B(String str, String str2, String str3) {
            String aG = bi.aG(str3, "unknown");
            try {
                String access$600;
                Long valueOf = Long.valueOf(AppBrandLocalMediaObjectManager.getCRC(str2));
                try {
                    access$600 = AppBrandLocalMediaObjectManager.encrypt(String.format(Locale.US, "%d|%s", new Object[]{valueOf, aG}), str);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "attachMediaObject, enc exp = ", new Object[0]);
                    access$600 = null;
                }
                if (bi.oW(access$600)) {
                    return null;
                }
                access$600 = new StringBuilder(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE).append(access$600).toString();
                String str4 = AppBrandLocalMediaObjectManager.getParentDir(str) + access$600;
                String stringBuilder = new StringBuilder(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX).append(access$600).append(bi.oW(aG) ? "" : "." + aG).toString();
                x.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", new Object[]{stringBuilder, str4});
                d dVar = new d();
                dVar.uRO = new Object[]{stringBuilder, str4, aG};
                return dVar;
            } catch (Throwable e2) {
                x.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, get crc exp = %s", new Object[]{bi.i(e2)});
                return null;
            }
        }

        public final AppBrandLocalMediaObject aW(String str, String str2) {
            String access$300;
            String replaceFirst = str2.replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE, "").replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE, "");
            try {
                access$300 = AppBrandLocalMediaObjectManager.decrypt(replaceFirst, str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "retrieveMediaObjectByRealFileName, dec exp = ", new Object[0]);
                access$300 = null;
            }
            if (bi.oW(access$300)) {
                return null;
            }
            String[] split = access$300.split("\\|");
            if (split == null || split.length != 2) {
                return null;
            }
            access$300 = split[1];
            access$300 = new StringBuilder(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX).append(str2).append(bi.oW(access$300) ? "" : "." + access$300).toString();
            AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject();
            appBrandLocalMediaObject.bNH = access$300;
            appBrandLocalMediaObject.dDG = AppBrandLocalMediaObjectManager.getParentDir(str) + str2;
            appBrandLocalMediaObject.fjS = replaceFirst;
            appBrandLocalMediaObject.fjT = true;
            File file = new File(appBrandLocalMediaObject.dDG);
            appBrandLocalMediaObject.fjU = file.lastModified();
            appBrandLocalMediaObject.eyz = file.length();
            return appBrandLocalMediaObject;
        }
    }

    private AppBrandLocalMediaObjectManager() {
    }

    static {
        String str = e.bnE;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        OBJECT_ROOT_DIR_PATH = str + "wxafiles/";
        Collection linkedList = new LinkedList();
        linkedList.add(new c());
        MEDIA_OBJECT_INFO_HANDLERS = Collections.unmodifiableCollection(linkedList);
    }

    @Keep
    public static String genMediaFilePath(String str, String str2) {
        if (bi.oW(str) || bi.oW(str2)) {
            return null;
        }
        return getParentDir(str) + str2;
    }

    @TargetApi(21)
    private static void symlinkOs(String str, String str2) {
        b bVar = new b((byte) 0);
        Os.symlink(str, str2);
    }

    private static boolean createLocalFileLink(boolean z, String str, String str2) {
        if (z && i.aX(str, str2)) {
            return true;
        }
        if (z || !j.fN(str, str2)) {
            return false;
        }
        return true;
    }

    public static void clear(String str) {
        if (!bi.oW(str)) {
            com.tencent.mm.a.e.co(getParentDirWithoutCheckExistence(str));
        }
    }

    public static List<AppBrandLocalMediaObject> listStoredFiles(String str) {
        File[] listStoredRawFiles = listStoredRawFiles(str);
        if (listStoredRawFiles == null || listStoredRawFiles.length <= 0) {
            return null;
        }
        List<AppBrandLocalMediaObject> linkedList = new LinkedList();
        for (File name : listStoredRawFiles) {
            AppBrandLocalMediaObject infoByRealFileName = getInfoByRealFileName(str, name.getName());
            if (infoByRealFileName != null) {
                linkedList.add(infoByRealFileName);
            }
        }
        return linkedList;
    }

    private static File[] listStoredRawFiles(String str) {
        File file = new File(getParentDir(str));
        if (file.exists() && file.isDirectory()) {
            return file.listFiles(new 1());
        }
        return null;
    }

    private static File[] listTmpRawFiles(String str) {
        File file = new File(getParentDir(str));
        if (file.exists() && file.isDirectory()) {
            return file.listFiles(new 2());
        }
        return null;
    }

    public static List<AppBrandLocalMediaObject> listTmpFiles(String str) {
        File[] listTmpRawFiles = listTmpRawFiles(str);
        if (listTmpRawFiles == null || listTmpRawFiles.length <= 0) {
            return null;
        }
        List<AppBrandLocalMediaObject> linkedList = new LinkedList();
        for (File name : listTmpRawFiles) {
            AppBrandLocalMediaObject infoByRealFileName = getInfoByRealFileName(str, name.getName());
            if (infoByRealFileName != null) {
                linkedList.add(infoByRealFileName);
            }
        }
        return linkedList;
    }

    public static long getTmpFilesOccupation(String str) {
        long j = 0;
        File[] listTmpRawFiles = listTmpRawFiles(str);
        if (listTmpRawFiles != null && listTmpRawFiles.length > 0) {
            for (File length : listTmpRawFiles) {
                j += length.length();
            }
        }
        return j;
    }

    public static long getStoredFilesOccupation(String str) {
        long j = 0;
        File[] listStoredRawFiles = listStoredRawFiles(str);
        if (listStoredRawFiles != null && listStoredRawFiles.length > 0) {
            for (File length : listStoredRawFiles) {
                j += length.length();
            }
        }
        return j;
    }

    public static AppBrandLocalVideoObject attachVideo(String str, String str2) {
        return (AppBrandLocalVideoObject) attachCast(str, str2, AppBrandLocalVideoObject.class, "mp4", false);
    }

    private static <T extends AppBrandLocalMediaObject> T attachCast(String str, String str2, Class<T> cls, String str3, boolean z) {
        if (bi.oW(str) || !com.tencent.mm.a.e.cn(str2)) {
            return null;
        }
        String nilAs = nilAs(org.a.a.a.a.adS(str2), str3);
        com.tencent.mm.vending.j.a aVar = null;
        for (a B : MEDIA_OBJECT_INFO_HANDLERS) {
            aVar = B.B(str, str2, nilAs);
            if (aVar != null) {
                break;
            }
        }
        com.tencent.mm.vending.j.a aVar2 = aVar;
        if (aVar2 == null || aVar2.size() < 2) {
            String str4 = TAG;
            nilAs = "attachCast, no handler return correct info, attach.size = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(aVar2 == null ? -1 : aVar2.size());
            x.e(str4, nilAs, objArr);
            return null;
        }
        try {
            T t = (AppBrandLocalMediaObject) cls.newInstance();
            t.bNH = (String) aVar2.get(0);
            t.mimeType = s.Uh(nilAs);
            t.dDG = (String) aVar2.get(1);
            if (bi.oW(t.dDG)) {
                x.e(TAG, "attachCast appId %s, Null Or Nil fileFullPath");
                return null;
            }
            t.fjS = bi.aG((String) aVar2.get(3), bi.aG(nilAs, "unknown"));
            if (!createLocalFileLink(z, str2, t.dDG)) {
                return null;
            }
            File file = new File(t.dDG);
            t.eyz = file.length();
            t.fjU = file.lastModified();
            return t;
        } catch (Throwable e) {
            x.printErrStackTrace(TAG, e, "", new Object[0]);
            return null;
        }
    }

    private static String nilAs(String str, String str2) {
        return bi.oW(str) ? str2 : str;
    }

    public static AppBrandLocalMediaObject attach(String str, String str2) {
        return attach(str, str2, null, false);
    }

    public static AppBrandLocalMediaObject attach(String str, String str2, boolean z) {
        return attach(str, str2, null, z);
    }

    public static AppBrandLocalMediaObject attach(String str, String str2, String str3, boolean z) {
        return attachCast(str, str2, AppBrandLocalMediaObject.class, str3, z);
    }

    private static String getParentDirWithoutCheckExistence(String str) {
        return OBJECT_ROOT_DIR_PATH + str + "/";
    }

    private static String getParentDir(String str) {
        String parentDirWithoutCheckExistence = getParentDirWithoutCheckExistence(str);
        h.Ey(parentDirWithoutCheckExistence);
        try {
            new File(parentDirWithoutCheckExistence, ".nomedia").createNewFile();
        } catch (Exception e) {
        }
        return parentDirWithoutCheckExistence;
    }

    private static String encrypt(String str, String str2) {
        return bi.bE(new ag().encrypt(str.getBytes(), str2.getBytes()));
    }

    private static String decrypt(String str, String str2) {
        int i = 0;
        byte[] WP = bi.WP(str);
        ag agVar = new ag();
        byte[] bytes = str2.getBytes();
        int length = WP.length;
        agVar.preCrypt = 0;
        agVar.crypt = 0;
        agVar.key = bytes;
        bytes = new byte[8];
        if (length % 8 != 0 || length < 16) {
            bytes = null;
        } else {
            agVar.prePlain = agVar.P(WP);
            if (agVar.prePlain == null) {
                bytes = null;
            } else {
                agVar.pos = agVar.prePlain[0] & 7;
                int i2 = (length - agVar.pos) - 10;
                if (i2 < 0) {
                    bytes = null;
                } else {
                    for (int i3 = 0; i3 < 8; i3++) {
                        bytes[i3] = (byte) 0;
                    }
                    agVar.out = new byte[i2];
                    agVar.preCrypt = 0;
                    agVar.crypt = 8;
                    agVar.contextStart = 8;
                    agVar.pos++;
                    agVar.padding = 1;
                    while (agVar.padding <= 2) {
                        if (agVar.pos < 8) {
                            agVar.pos++;
                            agVar.padding++;
                        }
                        if (agVar.pos == 8) {
                            if (!agVar.A(WP, length)) {
                                bytes = null;
                                break;
                            }
                            bytes = WP;
                        }
                    }
                    byte[] bArr = bytes;
                    while (i2 != 0) {
                        int i4;
                        if (agVar.pos < 8) {
                            agVar.out[i] = (byte) (bArr[(agVar.preCrypt + 0) + agVar.pos] ^ agVar.prePlain[agVar.pos]);
                            i4 = i + 1;
                            i = i2 - 1;
                            agVar.pos++;
                            i2 = i;
                        } else {
                            i4 = i;
                        }
                        if (agVar.pos == 8) {
                            agVar.preCrypt = agVar.crypt - 8;
                            if (!agVar.A(WP, length)) {
                                bytes = null;
                                break;
                            }
                            i = i4;
                            bArr = WP;
                        } else {
                            i = i4;
                        }
                    }
                    agVar.padding = 1;
                    bytes = bArr;
                    while (agVar.padding < 8) {
                        if (agVar.pos < 8) {
                            if ((bytes[(agVar.preCrypt + 0) + agVar.pos] ^ agVar.prePlain[agVar.pos]) != 0) {
                                bytes = null;
                                break;
                            }
                            agVar.pos++;
                        }
                        if (agVar.pos == 8) {
                            agVar.preCrypt = agVar.crypt;
                            if (!agVar.A(WP, length)) {
                                bytes = null;
                                break;
                            }
                            bytes = WP;
                        }
                        agVar.padding++;
                    }
                    bytes = agVar.out;
                }
            }
        }
        if (bi.oW(str)) {
            return null;
        }
        return new String(bytes);
    }

    public static AppBrandLocalMediaObject markPermanent(String str, AppBrandLocalMediaObject appBrandLocalMediaObject) {
        AppBrandLocalMediaObject appBrandLocalMediaObject2 = null;
        for (a a : MEDIA_OBJECT_INFO_HANDLERS) {
            appBrandLocalMediaObject2 = a.a(appBrandLocalMediaObject);
            if (appBrandLocalMediaObject2 != null) {
                break;
            }
        }
        return appBrandLocalMediaObject2;
    }

    private static AppBrandLocalMediaObject getInfoByRealFileName(String str, String str2) {
        AppBrandLocalMediaObject appBrandLocalMediaObject = null;
        if (!bi.oW(str) && !bi.oW(str2)) {
            for (a aW : MEDIA_OBJECT_INFO_HANDLERS) {
                appBrandLocalMediaObject = aW.aW(str, str2);
                if (appBrandLocalMediaObject != null) {
                    break;
                }
            }
        }
        return appBrandLocalMediaObject;
    }

    @Deprecated
    public static AppBrandLocalMediaObject getItemByLocalId(String str, String str2) {
        if (bi.oW(str2) || !str2.startsWith(OBJECT_NAME_PREFIX) || bi.oW(str)) {
            x.e(TAG, "getItemByLocalId, invalid args, localId(%s), appId(%s) ", new Object[]{str2, str});
            return null;
        } else if (str2.startsWith("wxfile://usr")) {
            File rb = new e(o.getString(((com.tencent.mm.plugin.appbrand.appstorage.a.a) g.l(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).rj(str)), str).rb(str2);
            if (rb == null || !rb.exists() || !rb.isFile()) {
                return null;
            }
            AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject();
            appBrandLocalMediaObject.bNH = str2;
            appBrandLocalMediaObject.dDG = rb.getAbsolutePath();
            appBrandLocalMediaObject.mimeType = s.Ui(str2);
            appBrandLocalMediaObject.fjT = true;
            appBrandLocalMediaObject.eyz = rb.length();
            appBrandLocalMediaObject.fjU = rb.lastModified();
            return appBrandLocalMediaObject;
        } else {
            AppBrandLocalMediaObject aV;
            String substring = str2.substring(9);
            AppBrandLocalMediaObject appBrandLocalMediaObject2 = null;
            for (a aV2 : MEDIA_OBJECT_INFO_HANDLERS) {
                aV = aV2.aV(str, substring);
                if (aV != null) {
                    x.i(TAG, "getItemByLocalId, handled by %s, result = %s", new Object[]{aV2.toString(), aV});
                    break;
                }
                appBrandLocalMediaObject2 = aV;
            }
            aV = appBrandLocalMediaObject2;
            if (Nil != aV) {
                return aV;
            }
            return null;
        }
    }

    @Keep
    @Deprecated
    public static String getFilePathByLocalId(String str, String str2) {
        AppBrandLocalMediaObject itemByLocalId = getItemByLocalId(str, str2);
        return itemByLocalId == null ? null : itemByLocalId.dDG;
    }

    private static long getCRC(String str) {
        Closeable fileInputStream = new FileInputStream(str);
        Closeable checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        do {
        } while (checkedInputStream.read(new byte[2048]) >= 0);
        long value = checkedInputStream.getChecksum().getValue();
        bi.d(checkedInputStream);
        bi.d(fileInputStream);
        return value;
    }
}
