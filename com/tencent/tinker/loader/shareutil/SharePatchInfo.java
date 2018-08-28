package com.tencent.tinker.loader.shareutil;

import android.os.Build;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SharePatchInfo {
    public String vsJ;
    public String vvF;
    public String vvG;
    public String vvH;

    public SharePatchInfo(String str, String str2, String str3, String str4) {
        this.vvF = str;
        this.vvG = str2;
        this.vvH = str3;
        this.vsJ = str4;
    }

    public static SharePatchInfo n(File file, File file2) {
        ShareFileLockHelper ag;
        Throwable e;
        SharePatchInfo sharePatchInfo = null;
        if (!(file == null || file2 == null)) {
            File parentFile = file2.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                ag = ShareFileLockHelper.ag(file2);
                try {
                    sharePatchInfo = am(file);
                    try {
                        ag.close();
                    } catch (IOException e2) {
                    }
                } catch (Throwable e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                ag = null;
            } catch (Throwable th) {
                e = th;
                ag = null;
                if (ag != null) {
                    try {
                        ag.close();
                    } catch (IOException e5) {
                    }
                }
                throw e;
            }
        }
        return sharePatchInfo;
        try {
            throw new TinkerRuntimeException("readAndCheckPropertyWithLock fail", e);
        } catch (Throwable e32) {
            e = e32;
            if (ag != null) {
                try {
                    ag.close();
                } catch (IOException e52) {
                }
            }
            throw e;
        }
    }

    public static boolean a(File file, SharePatchInfo sharePatchInfo, File file2) {
        if (file == null || sharePatchInfo == null || file2 == null) {
            return false;
        }
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        ShareFileLockHelper shareFileLockHelper = null;
        try {
            shareFileLockHelper = ShareFileLockHelper.ag(file2);
            boolean a = a(file, sharePatchInfo);
            try {
                shareFileLockHelper.close();
                return a;
            } catch (IOException e) {
                return a;
            }
        } catch (Throwable e2) {
            throw new TinkerRuntimeException("rewritePatchInfoFileWithLock fail", e2);
        } catch (Throwable th) {
            if (shareFileLockHelper != null) {
                try {
                    shareFileLockHelper.close();
                } catch (IOException e3) {
                }
            }
        }
    }

    private static SharePatchInfo am(File file) {
        Object fileInputStream;
        String property;
        Object e;
        Throwable th;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        Object obj = null;
        while (i < 2 && obj == null) {
            int i2 = i + 1;
            Properties properties = new Properties();
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    str4 = properties.getProperty("old");
                    str3 = properties.getProperty("new");
                    str2 = properties.getProperty("print");
                    property = properties.getProperty("dir");
                    SharePatchFileUtil.ar(fileInputStream);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        new StringBuilder("read property failed, e:").append(e);
                        SharePatchFileUtil.ar(fileInputStream);
                        property = str;
                        if (str4 != null) {
                        }
                        str = property;
                        i = i2;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                fileInputStream = null;
                new StringBuilder("read property failed, e:").append(e);
                SharePatchFileUtil.ar(fileInputStream);
                property = str;
                if (str4 != null) {
                }
                str = property;
                i = i2;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
            if (str4 != null || str3 == null) {
                str = property;
                i = i2;
            } else if ((str4.equals("") || SharePatchFileUtil.acX(str4)) && SharePatchFileUtil.acX(str3)) {
                obj = 1;
                str = property;
                i = i2;
            } else {
                new StringBuilder("path info file  corrupted:").append(file.getAbsolutePath());
                str = property;
                i = i2;
            }
        }
        if (obj != null) {
            return new SharePatchInfo(str4, str3, str2, str);
        }
        return null;
        SharePatchFileUtil.ar(fileInputStream);
        throw th;
    }

    private static boolean a(File file, SharePatchInfo sharePatchInfo) {
        Object fileOutputStream;
        Object e;
        SharePatchInfo am;
        Throwable th;
        if (file == null || sharePatchInfo == null) {
            return false;
        }
        if (ShareTinkerInternals.oW(sharePatchInfo.vvH)) {
            sharePatchInfo.vvH = Build.FINGERPRINT;
        }
        if (ShareTinkerInternals.oW(sharePatchInfo.vsJ)) {
            sharePatchInfo.vsJ = "odex";
        }
        new StringBuilder("rewritePatchInfoFile file path:").append(file.getAbsolutePath()).append(" , oldVer:").append(sharePatchInfo.vvF).append(", newVer:").append(sharePatchInfo.vvG).append(", fingerprint:").append(sharePatchInfo.vvH).append(", oatDir:").append(sharePatchInfo.vsJ);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        int i = 0;
        boolean z = false;
        while (i < 2 && !z) {
            int i2 = i + 1;
            Properties properties = new Properties();
            properties.put("old", sharePatchInfo.vvF);
            properties.put("new", sharePatchInfo.vvG);
            properties.put("print", sharePatchInfo.vvH);
            properties.put("dir", sharePatchInfo.vsJ);
            try {
                fileOutputStream = new FileOutputStream(file, false);
                try {
                    properties.store(fileOutputStream, "from old version:" + sharePatchInfo.vvF + " to new version:" + sharePatchInfo.vvG);
                    SharePatchFileUtil.ar(fileOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        new StringBuilder("write property failed, e:").append(e);
                        SharePatchFileUtil.ar(fileOutputStream);
                        am = am(file);
                        if (am == null) {
                        }
                        z = false;
                        if (z) {
                            file.delete();
                        }
                        i = i2;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                new StringBuilder("write property failed, e:").append(e);
                SharePatchFileUtil.ar(fileOutputStream);
                am = am(file);
                if (am == null) {
                }
                z = false;
                if (z) {
                    file.delete();
                }
                i = i2;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            am = am(file);
            if (am == null && am.vvF.equals(sharePatchInfo.vvF) && am.vvG.equals(sharePatchInfo.vvG)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                file.delete();
            }
            i = i2;
        }
        if (z) {
            return true;
        }
        return false;
        SharePatchFileUtil.ar(fileOutputStream);
        throw th;
    }
}
