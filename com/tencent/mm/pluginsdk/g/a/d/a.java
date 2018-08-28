package com.tencent.mm.pluginsdk.g.a.d;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class a {
    public static long Io(String str) {
        if (bi.oW(str)) {
            return 0;
        }
        File file = new File(str);
        if (file.isFile()) {
            return file.length();
        }
        return 0;
    }

    public static boolean v(String str, byte[] bArr) {
        Throwable e;
        if (bi.bC(bArr)) {
            return false;
        }
        File file = new File(str);
        file.delete();
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2;
        try {
            fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                try {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e2, "", new Object[0]);
                }
                return true;
            } catch (FileNotFoundException e3) {
                e2 = e3;
                try {
                    x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e2, "", new Object[0]);
                    if (fileOutputStream2 != null) {
                        return false;
                    }
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        return false;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e4, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            } catch (IOException e5) {
                e22 = e5;
                fileOutputStream = fileOutputStream2;
                try {
                    x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e22, "", new Object[0]);
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return false;
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e222, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th2) {
                    e222 = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (Throwable e42) {
                            x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e42, "", new Object[0]);
                        }
                    }
                    throw e222;
                }
            }
        } catch (FileNotFoundException e6) {
            e222 = e6;
            fileOutputStream2 = null;
            x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e222, "", new Object[0]);
            if (fileOutputStream2 != null) {
                return false;
            }
            try {
                fileOutputStream2.flush();
                fileOutputStream2.close();
                return false;
            } catch (Throwable e2222) {
                x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e2222, "", new Object[0]);
                return false;
            }
        } catch (IOException e7) {
            e2222 = e7;
            x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e2222, "", new Object[0]);
            if (fileOutputStream != null) {
                return false;
            }
            try {
                fileOutputStream.flush();
                fileOutputStream.close();
                return false;
            } catch (Throwable e22222) {
                x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e22222, "", new Object[0]);
                return false;
            }
        }
    }

    public static byte[] Tq(String str) {
        Closeable fileInputStream;
        Closeable byteArrayOutputStream;
        Throwable e;
        byte[] bArr = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (FileNotFoundException e2) {
                e = e2;
                byteArrayOutputStream = bArr;
                try {
                    x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                    g(fileInputStream);
                    g(byteArrayOutputStream);
                    return bArr;
                } catch (Throwable th) {
                    e = th;
                    g(fileInputStream);
                    g(byteArrayOutputStream);
                    throw e;
                }
            } catch (IOException e3) {
                e = e3;
                byteArrayOutputStream = bArr;
                x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                g(fileInputStream);
                g(byteArrayOutputStream);
                return bArr;
            } catch (Throwable th2) {
                e = th2;
                byteArrayOutputStream = bArr;
                g(fileInputStream);
                g(byteArrayOutputStream);
                throw e;
            }
            try {
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                byteArrayOutputStream.flush();
                bArr = byteArrayOutputStream.toByteArray();
                g(fileInputStream);
                g(byteArrayOutputStream);
            } catch (FileNotFoundException e4) {
                e = e4;
                x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                g(fileInputStream);
                g(byteArrayOutputStream);
                return bArr;
            } catch (IOException e5) {
                e = e5;
                x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                g(fileInputStream);
                g(byteArrayOutputStream);
                return bArr;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
            g(fileInputStream);
            g(byteArrayOutputStream);
            return bArr;
        } catch (IOException e7) {
            e = e7;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
            g(fileInputStream);
            g(byteArrayOutputStream);
            return bArr;
        } catch (Throwable th3) {
            e = th3;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            g(fileInputStream);
            g(byteArrayOutputStream);
            throw e;
        }
        return bArr;
    }

    public static void g(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                x.e("MicroMsg.ResDownloaderFileUtils", String.format("%s close failed (%s)", new Object[]{closeable.getClass().getSimpleName(), e.getMessage()}));
            }
        }
    }

    public static boolean Tr(String str) {
        if (bi.oW(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.delete()) {
            return true;
        }
        return false;
    }

    public static boolean cn(String str) {
        if (bi.oW(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }
}
