package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.os.Environment;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public final class h {
    private static Boolean dgB = null;
    private static Boolean dgC = null;

    public static File getExternalStorageDirectory() {
        if (bi.oW(q.deW.def)) {
            return Environment.getExternalStorageDirectory();
        }
        return new File(q.deW.def);
    }

    @TargetApi(8)
    public static File getExternalStoragePublicDirectory(String str) {
        if (bi.oW(q.deW.deg)) {
            return Environment.getExternalStoragePublicDirectory(str);
        }
        return new File(q.deW.deg);
    }

    public static File getDataDirectory() {
        if (bi.oW(q.deW.deh)) {
            return Environment.getDataDirectory();
        }
        return new File(q.deW.deh);
    }

    public static File getRootDirectory() {
        if (bi.oW(q.deW.dei)) {
            return Environment.getRootDirectory();
        }
        return new File(q.deW.dei);
    }

    public static File getDownloadCacheDirectory() {
        if (bi.oW(q.deW.dek)) {
            return Environment.getDownloadCacheDirectory();
        }
        return new File(q.deW.dek);
    }

    public static String getExternalStorageState() {
        if (bi.oW(q.deW.dej)) {
            return Environment.getExternalStorageState();
        }
        return q.deW.dej;
    }

    public static boolean Ae() {
        Throwable e;
        if (dgB == null) {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    dgB = Boolean.valueOf(properties.containsKey("ro.miui.ui.version.name"));
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                        dgB = Boolean.valueOf(false);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        return dgB.booleanValue();
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileInputStream = null;
                x.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                dgB = Boolean.valueOf(false);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e42) {
                    }
                }
                return dgB.booleanValue();
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e52) {
                    }
                }
                throw e;
            }
        }
        return dgB.booleanValue();
    }

    public static boolean Af() {
        Throwable e;
        if (dgC == null) {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    dgC = Boolean.valueOf(properties.getProperty("ro.miui.ui.version.name", "").contains("V8"));
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                        dgC = Boolean.valueOf(false);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        return dgC.booleanValue();
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileInputStream = null;
                x.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                dgC = Boolean.valueOf(false);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e42) {
                    }
                }
                return dgC.booleanValue();
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e52) {
                    }
                }
                throw e;
            }
        }
        return dgC.booleanValue();
    }
}
