package com.tencent.mm.c;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

public final class g {
    private static String a(InputStream inputStream, int i, byte[] bArr) {
        int i2 = 0;
        if (i <= 0) {
            return null;
        }
        try {
            if (inputStream.skip(0) < 0) {
                return null;
            }
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuilder stringBuilder = new StringBuilder(32);
            byte[] bArr2 = new byte[102400];
            int i3 = 0;
            while (true) {
                int read = inputStream.read(bArr2);
                if (read == -1 || i3 >= i) {
                    if (bArr != null && bArr.length > 0) {
                        instance.update(bArr);
                    }
                } else if (i3 + read <= i) {
                    instance.update(bArr2, 0, read);
                    i3 += read;
                } else {
                    instance.update(bArr2, 0, i - i3);
                    i3 = i;
                }
            }
            instance.update(bArr);
            byte[] digest = instance.digest();
            while (i2 < digest.length) {
                stringBuilder.append(Integer.toString((digest[i2] & WebView.NORMAL_MODE_ALPHA) + ab.CTRL_BYTE, 16).substring(1));
                i2++;
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return null;
        }
    }

    private static String b(InputStream inputStream, int i) {
        if (i <= 0) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuilder stringBuilder = new StringBuilder(32);
            byte[] bArr = new byte[i];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            byte[] digest = instance.digest();
            for (byte b : digest) {
                stringBuilder.append(Integer.toString((b & WebView.NORMAL_MODE_ALPHA) + ab.CTRL_BYTE, 16).substring(1));
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String cu(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return m(file);
        }
        return null;
    }

    private static String m(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        long j = 102400;
        if (!file.exists()) {
            return null;
        }
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(file);
            try {
                if (102400 > file.length()) {
                    j = file.length();
                }
                String b = b(fileInputStream2, (int) j);
                fileInputStream2.close();
                try {
                    fileInputStream2.close();
                } catch (IOException e) {
                }
                return b;
            } catch (Exception e2) {
                fileInputStream = fileInputStream2;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            fileInputStream = null;
            if (fileInputStream == null) {
                return null;
            }
            try {
                fileInputStream.close();
                return null;
            } catch (IOException e5) {
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e32) {
                }
            }
            throw th;
        }
    }

    public static String a(File file, int i, byte[] bArr) {
        FileInputStream fileInputStream;
        Throwable th;
        if (!file.exists() || i <= 0) {
            return null;
        }
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(file);
            try {
                String a = a((InputStream) fileInputStream2, i, bArr);
                fileInputStream2.close();
                try {
                    fileInputStream2.close();
                    return a;
                } catch (IOException e) {
                    return a;
                }
            } catch (Exception e2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e32) {
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e42) {
                }
            }
            throw th;
        }
    }
}
