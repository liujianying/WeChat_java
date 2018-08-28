package com.tencent.mm.sdk.platformtools;

import android.os.Environment;
import android.os.StatFs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class ax {
    static String[] sIF = new String[]{"sysfs", "rootfs", "binfmt_misc", "anon_inodefs", "bdev", "proc", "cgroup", "tmpfs", "debugfs", "sockfs", "pipefs", "rpc_pipefs", "devpts", "ramfs", "fuseblk", "fusectl", "selinuxfs"};
    static String[] sIG = new String[]{"vfat", "exfat", "fuse", "sdcardfs"};
    static String[] sIH = new String[]{"/mnt/secure", "/mnt/asec", "/mnt/obb", "/dev/mapper", "/data/"};
    static String[] sII = new String[]{"/dev/block/vold"};

    public static class a {
        public boolean bvO;
        public String sIJ;
        public String sIK;
        public String sIL;
        public long sIM;
        public long sIN;
        public long sIO;
        public long sIP;
        a sIQ;

        public final String toString() {
            return "{DevName=" + this.sIJ + ", MountDir=" + this.sIK + ", FileSystem=" + this.sIL + ", TotalBlocks=" + this.sIM + ", FreeBlocks=" + this.sIN + ", AvailableBlocks=" + this.sIO + ", BlockSize=" + this.sIP + ", Shared=" + (this.sIQ != null) + "}";
        }

        public final boolean equals(Object obj) {
            a aVar = (a) obj;
            if (this.sIP != aVar.sIP) {
                return false;
            }
            long j = this.sIM - aVar.sIM;
            long j2 = this.sIN - aVar.sIN;
            long j3 = this.sIO - aVar.sIO;
            if (Math.abs(j - j2) > 4 || Math.abs(j - j3) > 4 || Math.abs(j2 - j3) > 4) {
                return false;
            }
            return true;
        }
    }

    private static ArrayList<a> ciE() {
        Throwable e;
        Exception e2;
        ArrayList<a> arrayList = new ArrayList();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/mounts"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split("\\s+");
                        if (split == null || split.length < 3) {
                            x.e("MicroMsg.SdcardUtil", "splite failed for line: " + readLine);
                        } else {
                            a aVar = new a();
                            aVar.sIJ = split[0];
                            aVar.sIK = split[1];
                            aVar.sIL = split[2];
                            arrayList.add(aVar);
                        }
                    } else {
                        try {
                            bufferedReader.close();
                            break;
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.SdcardUtil", e3, "", new Object[0]);
                        }
                    }
                } catch (Exception e4) {
                    e2 = e4;
                }
            }
        } catch (Exception e5) {
            e2 = e5;
            bufferedReader = null;
            try {
                x.e("MicroMsg.SdcardUtil", "parseProcMounts", e2);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e32) {
                        x.printErrStackTrace("MicroMsg.SdcardUtil", e32, "", new Object[0]);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                e32 = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e6) {
                        x.printErrStackTrace("MicroMsg.SdcardUtil", e6, "", new Object[0]);
                    }
                }
                throw e32;
            }
        } catch (Throwable th2) {
            e32 = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable e62) {
                    x.printErrStackTrace("MicroMsg.SdcardUtil", e62, "", new Object[0]);
                }
            }
            throw e32;
        }
        return arrayList;
    }

    private static void a(a aVar) {
        try {
            StatFs statFs = new StatFs(aVar.sIK);
            aVar.sIP = (long) statFs.getBlockSize();
            aVar.sIO = (long) statFs.getAvailableBlocks();
            aVar.sIM = (long) statFs.getBlockCount();
            aVar.sIN = (long) statFs.getFreeBlocks();
        } catch (IllegalArgumentException e) {
            x.e("MicroMsg.SdcardUtil", "statFsForStatMountParse", e);
        }
    }

    private static boolean b(a aVar) {
        boolean delete;
        IOException e;
        Throwable e2;
        File file = new File(aVar.sIK, "test_writable");
        FileOutputStream fileOutputStream;
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write("test".getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                delete = file.delete();
                try {
                    fileOutputStream.close();
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.SdcardUtil", e3, "", new Object[0]);
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
            try {
                x.e("MicroMsg.SdcardUtil", "createNewFile: " + e.getMessage() + " dir: " + aVar.sIK);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        delete = false;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.SdcardUtil", e22, "", new Object[0]);
                        delete = false;
                    }
                } else {
                    delete = false;
                }
                aVar.bvO = delete;
                return delete;
            } catch (Throwable th) {
                e22 = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e32) {
                        x.printErrStackTrace("MicroMsg.SdcardUtil", e32, "", new Object[0]);
                    }
                }
                throw e22;
            }
        } catch (Throwable th2) {
            e22 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e322) {
                    x.printErrStackTrace("MicroMsg.SdcardUtil", e322, "", new Object[0]);
                }
            }
            throw e22;
        }
        aVar.bvO = delete;
        return delete;
    }

    private static a ciF() {
        a aVar;
        ArrayList ciE = ciE();
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        Iterator it = ciE.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.sIK.equals(absolutePath)) {
                break;
            }
        }
        aVar = null;
        if (aVar == null) {
            aVar = new a();
            aVar.sIK = absolutePath;
            aVar.sIJ = "Unknown";
            aVar.sIL = "Unknown";
        }
        a(aVar);
        return aVar;
    }

    private static a ciG() {
        a aVar;
        ArrayList ciE = ciE();
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Iterator it = ciE.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.sIK.equals(absolutePath)) {
                break;
            }
        }
        aVar = null;
        if (aVar == null) {
            aVar = new a();
            aVar.sIK = absolutePath;
            aVar.sIJ = "Unknown";
            aVar.sIL = "Unknown";
        }
        a(aVar);
        return aVar;
    }

    public static ArrayList<a> ciH() {
        a aVar;
        int i;
        int size;
        a aVar2;
        ArrayList<a> ciE = ciE();
        int size2 = ciE.size();
        List asList = Arrays.asList(sIG);
        List<String> asList2 = Arrays.asList(sIH);
        List<String> asList3 = Arrays.asList(sII);
        for (int i2 = size2 - 1; i2 >= 0; i2--) {
            aVar = (a) ciE.get(i2);
            if (asList.contains(aVar.sIL)) {
                i = 0;
                for (String startsWith : asList2) {
                    i = aVar.sIK.startsWith(startsWith) | i;
                }
                if (i != 0) {
                    ciE.remove(i2);
                    x.d("MicroMsg.SdcardUtil", "Remove with bad mount dir1: " + aVar.sIK);
                } else if (aVar.sIL.equals("fuse") || aVar.sIL.equals("sdcardfs")) {
                    if (aVar.sIJ.startsWith("/data/")) {
                        ciE.remove(i2);
                        x.d("MicroMsg.SdcardUtil", "Remove with bad mount dir2: " + aVar.sIJ);
                    }
                } else if (!(aVar.sIL.equals("fuse") || aVar.sIL.equals("sdcardfs"))) {
                    i = 0;
                    for (String startsWith2 : asList3) {
                        i = aVar.sIJ.startsWith(startsWith2) | i;
                    }
                    if (i == 0) {
                        ciE.remove(i2);
                        x.d("MicroMsg.SdcardUtil", "Remove with bad device name: " + aVar.sIJ);
                    }
                }
            } else {
                ciE.remove(i2);
                x.d("MicroMsg.SdcardUtil", "Remove with filesystem mismatch: " + aVar.sIL);
            }
        }
        String path = Environment.getExternalStorageDirectory().getPath();
        for (size = ciE.size() - 1; size >= 0; size--) {
            aVar = (a) ciE.get(size);
            if (aVar.sIK.equals(path)) {
                ciE.remove(size);
                ciE.add(0, aVar);
                size2 = 1;
                break;
            }
        }
        size2 = 0;
        if (size2 == 0) {
            aVar = new a();
            aVar.sIK = path;
            aVar.sIL = "unknown";
            aVar.sIJ = "unknown";
            ciE.add(0, aVar);
        }
        for (size = ciE.size() - 1; size >= 0; size--) {
            aVar = (a) ciE.get(size);
            File file = new File(aVar.sIK);
            if (!file.exists() || !file.isDirectory()) {
                x.d("MicroMsg.SdcardUtil", "Directory verify failed: " + aVar);
                ciE.remove(size);
            }
        }
        for (size = ciE.size() - 1; size >= 0; size--) {
            aVar = (a) ciE.get(size);
            if (!b(aVar)) {
                x.d("MicroMsg.SdcardUtil", "Directory testPermissionForStatMountParse failed: " + aVar);
                ciE.remove(size);
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!ciE.isEmpty()) {
            i = ciE.size() - 1;
            aVar2 = (a) ciE.remove(0);
            while (i >= 0) {
                aVar = (a) ciE.get(i);
                if (aVar2.sIJ.equals(aVar.sIJ)) {
                    ciE.remove(i);
                    x.d("MicroMsg.SdcardUtil", "Duplicate with same DevName:" + aVar2.sIJ);
                    if (!aVar2.bvO && aVar.bvO) {
                        x.d("MicroMsg.SdcardUtil", "Keep the writable one, discard the unwritable one");
                        i--;
                        aVar2 = aVar;
                    }
                }
                aVar = aVar2;
                i--;
                aVar2 = aVar;
            }
            arrayList.add(aVar2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a((a) it.next());
        }
        ciE.clear();
        while (!arrayList.isEmpty()) {
            aVar2 = (a) arrayList.remove(0);
            ciE.add(aVar2);
            for (i = arrayList.size() - 1; i >= 0; i--) {
                aVar = (a) arrayList.get(i);
                if (aVar2.equals(aVar)) {
                    x.d("MicroMsg.SdcardUtil", "Duplicate:" + aVar2.toString() + "---" + aVar.toString());
                    arrayList.remove(i);
                }
            }
        }
        return ciE;
    }

    public static long ciI() {
        a ciF = ciF();
        return ciF.sIP * ciF.sIO;
    }

    public static long ciJ() {
        a ciG = ciG();
        return ciG.sIP * ciG.sIO;
    }

    public static boolean ciK() {
        a aVar;
        boolean z;
        a aVar2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList ciE = ciE();
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        String absolutePath2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        Iterator it = ciE.iterator();
        a aVar3 = null;
        while (true) {
            aVar = aVar2;
            if (!it.hasNext()) {
                break;
            }
            aVar2 = (a) it.next();
            if (aVar != null || !aVar2.sIK.equals(absolutePath)) {
                if (aVar3 == null && aVar2.sIK.equals(absolutePath2)) {
                    if (aVar != null) {
                        aVar3 = aVar2;
                        break;
                    }
                }
                aVar2 = aVar3;
            } else if (aVar3 != null) {
                aVar = aVar2;
                break;
            }
        }
        if (aVar != null && aVar3 == null && !bi.oW(absolutePath2) && absolutePath2.contains("emulated")) {
            String substring = absolutePath2.substring(absolutePath2.lastIndexOf(47) + 1);
            x.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage multiuser uid[%s][%d]", substring, Integer.valueOf(bi.getInt(substring, -1)));
            if (bi.getInt(substring, -1) != -1) {
                absolutePath = absolutePath2.substring(0, (absolutePath2.length() - substring.length()) - 1);
                if (!bi.oW(absolutePath)) {
                    Iterator it2 = ciE.iterator();
                    while (it2.hasNext()) {
                        aVar2 = (a) it2.next();
                        if (aVar2.sIK.equals(absolutePath)) {
                            break;
                        }
                    }
                }
            }
        }
        aVar2 = aVar3;
        if (!(aVar == null || aVar2 == null)) {
            a(aVar);
            a(aVar2);
            x.d("MicroMsg.SdcardUtil", "hasUnRemovableStorage stats dataStatMountParse[%s] storageStatMountParse[%s]", aVar, aVar2);
            if ((aVar2.sIL.equals("fuse") || aVar2.sIL.equals("sdcardfs") || aVar2.sIL.equals("esdfs")) && aVar.sIM >= aVar2.sIM && aVar2.sIM > 0 && aVar.sIP >= aVar2.sIP && aVar2.sIP > 0 && aVar.sIO >= aVar2.sIO) {
                z = true;
                x.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return z;
            }
        }
        z = false;
        x.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return z;
    }

    public static String Wz(String str) {
        String str2 = "";
        if (bi.oW(str)) {
            return str2;
        }
        a aVar;
        ArrayList ciE = ciE();
        Iterator it = ciE.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (str.equals(aVar.sIK)) {
                str2 = aVar.sIL;
                break;
            }
        }
        x.i("MicroMsg.SdcardUtil", "getFileSystem[%s] is [%s]", str, str2);
        if (!bi.oW(str2) || !str.contains("emulated")) {
            return str2;
        }
        String substring = str.substring(str.lastIndexOf(47) + 1);
        x.i("MicroMsg.SdcardUtil", "getFileSystem multiuser uid[%s][%d]", substring, Integer.valueOf(bi.getInt(substring, -1)));
        if (bi.getInt(substring, -1) == -1) {
            return str2;
        }
        String substring2 = str.substring(0, (str.length() - substring.length()) - 1);
        if (bi.oW(substring2)) {
            return str2;
        }
        Iterator it2 = ciE.iterator();
        while (it2.hasNext()) {
            aVar = (a) it2.next();
            if (substring2.equals(aVar.sIK)) {
                x.i("MicroMsg.SdcardUtil", "getFileSystem[%s] fix[%s] is [%s]", str, substring2, aVar.sIL);
                return aVar.sIL;
            }
        }
        return str2;
    }
}
