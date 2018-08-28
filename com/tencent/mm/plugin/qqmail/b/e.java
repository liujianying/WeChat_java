package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.util.Map;
import java.util.Map.Entry;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class e {
    public static int mcm = 100;
    private int daw = mcm;
    public String mcn = null;

    public e(String str, int i) {
        x.i("Msg.Plugin.HttpRequestCache", "HttpRequestCache constructor, path = " + str + ", maxCount = " + i);
        this.mcn = str;
        File file = new File(this.mcn);
        if (!file.exists()) {
            file.mkdir();
        }
        if (i <= 0) {
            i = mcm;
        }
        this.daw = i;
    }

    public final byte[] m(String str, Map<String, String> map) {
        if (str == null || str.length() == 0) {
            x.e("Msg.Plugin.HttpRequestCache", "getCache, invalid argument");
            return null;
        }
        String n = n(str, map);
        byte[] readFromFile = readFromFile(this.mcn + n);
        if (readFromFile == null) {
            x.i("Msg.Plugin.HttpRequestCache", "readFromFile fail, cipherText is null, read error or cache not exist");
            return null;
        }
        byte[] decrypt = decrypt(readFromFile, JP(n));
        if (decrypt != null) {
            return decrypt;
        }
        x.e("Msg.Plugin.HttpRequestCache", "decrypt fail, plaintText is null");
        return null;
    }

    public final boolean a(String str, Map<String, String> map, byte[] bArr) {
        if (str == null || str.length() == 0 || bArr == null || bArr.length == 0) {
            x.e("Msg.Plugin.HttpRequestCache", "setCache, invalid argument");
            return false;
        }
        bok();
        String n = n(str, map);
        byte[] encrypt = encrypt(bArr, JP(n));
        if (encrypt != null) {
            return r(this.mcn + n, encrypt);
        }
        x.e("Msg.Plugin.HttpRequestCache", "encrypt fail, cipherText is null");
        return false;
    }

    private static String n(String str, Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                stringBuffer.append(str2);
                stringBuffer.append(str3);
            }
        }
        return g.u(stringBuffer.toString().getBytes());
    }

    private static byte[] JP(String str) {
        return g.u(str.toString().getBytes()).substring(8, 16).getBytes();
    }

    public final void bok() {
        int length;
        int i = 0;
        String[] list = new File(this.mcn).list();
        if (list != null) {
            length = list.length;
        } else {
            length = 0;
        }
        if (length >= this.daw) {
            String[] list2 = new File(this.mcn).list();
            File file = null;
            int length2 = list2.length;
            while (i < length2) {
                file = new File(list2[i]);
                file.lastModified();
                i++;
            }
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(1, generateSecret, new IvParameterSpec("12345678".getBytes()));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
            return null;
        }
    }

    private static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, generateSecret, new IvParameterSpec("12345678".getBytes()));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
            return null;
        }
    }

    public static byte[] readFromFile(String str) {
        Throwable e;
        FileInputStream fileInputStream;
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            int length = (int) file.length();
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[length];
                if (fileInputStream.read(bArr) != length) {
                    try {
                        fileInputStream.close();
                        return null;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e2, "", new Object[0]);
                        return null;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Throwable e3) {
                    x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e3, "", new Object[0]);
                }
                return bArr;
            } catch (Exception e4) {
                e2 = e4;
            }
        } catch (Exception e5) {
            e2 = e5;
            fileInputStream = null;
            try {
                x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e2, "", new Object[0]);
                if (fileInputStream == null) {
                    return null;
                }
                try {
                    fileInputStream.close();
                    return null;
                } catch (Throwable e22) {
                    x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e22, "", new Object[0]);
                    return null;
                }
            } catch (Throwable e32) {
                e22 = e32;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e322) {
                        x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e322, "", new Object[0]);
                    }
                }
                throw e22;
            }
        } catch (Throwable th) {
            e22 = th;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e3222) {
                    x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e3222, "", new Object[0]);
                }
            }
            throw e22;
        }
    }

    public static boolean r(String str, byte[] bArr) {
        Throwable e;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (Throwable e2) {
                    x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e2, "", new Object[0]);
                }
                return true;
            } catch (Exception e3) {
                e2 = e3;
                try {
                    x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e2, "", new Object[0]);
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e4, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            fileOutputStream = null;
            x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e22, "", new Object[0]);
            if (fileOutputStream != null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (Throwable e222) {
                x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e222, "", new Object[0]);
                return false;
            }
        } catch (Throwable th2) {
            e222 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e42) {
                    x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e42, "", new Object[0]);
                }
            }
            throw e222;
        }
    }
}
