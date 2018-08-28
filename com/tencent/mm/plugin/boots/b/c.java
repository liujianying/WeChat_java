package com.tencent.mm.plugin.boots.b;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;

public final class c {
    private static final char[] buX = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private String hjG = null;
    private final HashMap<String, String> hjH;
    private final HashMap<String, String> hjI;

    public c(Context context) {
        try {
            this.hjG = ag(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            if (this.hjG == null) {
                throw new a("LuggageSecurityChecker get public key md5 is null");
            }
            SharePatchFileUtil.ar(null);
            this.hjH = new HashMap();
            this.hjI = new HashMap();
        } catch (Throwable e) {
            throw new a("LuggageSecurityChecker init public key fail", e);
        } catch (Throwable th) {
            SharePatchFileUtil.ar(null);
        }
    }

    public final boolean D(File file) {
        Throwable e;
        JarFile jarFile;
        try {
            JarFile jarFile2 = new JarFile(file);
            try {
                Enumeration entries = jarFile2.entries();
                while (entries.hasMoreElements()) {
                    JarEntry jarEntry = (JarEntry) entries.nextElement();
                    if (jarEntry != null) {
                        String name = jarEntry.getName();
                        if (name.startsWith("META-INF/")) {
                            continue;
                        } else {
                            this.hjH.put(name, a(jarFile2, jarEntry));
                            Certificate[] certificates = jarEntry.getCertificates();
                            if (certificates == null || !a(file, certificates)) {
                                try {
                                    jarFile2.close();
                                } catch (Throwable e2) {
                                    x.printErrStackTrace("MicroMsg.Boots.LuggageSecurityChecker", e2, "verifySignature", new Object[0]);
                                }
                                return false;
                            }
                        }
                    }
                }
                try {
                    jarFile2.close();
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.Boots.LuggageSecurityChecker", e22, "verifySignature", new Object[0]);
                }
                return true;
            } catch (Exception e3) {
                e22 = e3;
                jarFile = jarFile2;
                try {
                    x.printErrStackTrace("MicroMsg.Boots.LuggageSecurityChecker", e22, "LuggageSecurityChecker verifySignature", new Object[0]);
                    throw new a(String.format("LuggageSecurityChecker file %s, size %d verifySignature failed.", new Object[]{file.getAbsoluteFile(), Long.valueOf(file.length())}), e22);
                } catch (Throwable th) {
                    e22 = th;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.Boots.LuggageSecurityChecker", e4, "verifySignature", new Object[0]);
                        }
                    }
                    throw e22;
                }
            } catch (Throwable th2) {
                e22 = th2;
                jarFile = jarFile2;
                if (jarFile != null) {
                    try {
                        jarFile.close();
                    } catch (Throwable e42) {
                        x.printErrStackTrace("MicroMsg.Boots.LuggageSecurityChecker", e42, "verifySignature", new Object[0]);
                    }
                }
                throw e22;
            }
        } catch (Exception e5) {
            e22 = e5;
            jarFile = null;
            x.printErrStackTrace("MicroMsg.Boots.LuggageSecurityChecker", e22, "LuggageSecurityChecker verifySignature", new Object[0]);
            throw new a(String.format("LuggageSecurityChecker file %s, size %d verifySignature failed.", new Object[]{file.getAbsoluteFile(), Long.valueOf(file.length())}), e22);
        } catch (Throwable th3) {
            e22 = th3;
            jarFile = null;
            if (jarFile != null) {
                try {
                    jarFile.close();
                } catch (Throwable e422) {
                    x.printErrStackTrace("MicroMsg.Boots.LuggageSecurityChecker", e422, "verifySignature", new Object[0]);
                }
            }
            throw e22;
        }
    }

    private boolean a(File file, Certificate[] certificateArr) {
        if (certificateArr.length > 0) {
            try {
                for (int length = certificateArr.length - 1; length >= 0; length--) {
                    if (this.hjG.equals(ag(certificateArr[length].getEncoded()))) {
                        return true;
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Boots.LuggageSecurityChecker", e, "LuggageSecurityChecker check file %s", new Object[]{file});
            }
        }
        return false;
    }

    private static String a(JarFile jarFile, JarEntry jarEntry) {
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder();
        Object bufferedInputStream;
        try {
            byte[] bArr = new byte[16384];
            bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        stringBuilder.append(new String(bArr, 0, read));
                    } else {
                        ar(bufferedInputStream);
                        return stringBuilder.toString();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    ar(bufferedInputStream);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            ar(bufferedInputStream);
            throw th;
        }
    }

    private static void ar(Object obj) {
        if (obj != null) {
            if (obj instanceof Closeable) {
                try {
                    ((Closeable) obj).close();
                } catch (Throwable th) {
                }
            } else if (VERSION.SDK_INT >= 19 && (obj instanceof AutoCloseable)) {
                try {
                    ((AutoCloseable) obj).close();
                } catch (Throwable th2) {
                }
            } else if (obj instanceof ZipFile) {
                try {
                    ((ZipFile) obj).close();
                } catch (Throwable th3) {
                }
            } else {
                throw new IllegalArgumentException("obj: " + obj + " cannot be closed.");
            }
        }
    }

    private static String ag(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr = new char[(length * 2)];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr[i2] = buX[(b >>> 4) & 15];
                int i4 = i3 + 1;
                cArr[i3] = buX[b & 15];
                i++;
                i2 = i4;
            }
            return new String(cArr);
        } catch (Exception e) {
            return null;
        }
    }
}
