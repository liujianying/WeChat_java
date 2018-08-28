package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.smtt.sdk.TbsExtensionFunctionManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.jar.JarFile;

public class a {
    public static int a(Context context, File file) {
        boolean z = false;
        if (VERSION.SDK_INT >= 23 && !TbsExtensionFunctionManager.getInstance().canUseFunction(context, "disable_get_apk_version_switch.txt")) {
            z = true;
        }
        return a(context, file, z);
    }

    public static int a(Context context, File file, boolean z) {
        int i = 1;
        if (file != null) {
            try {
                if (file.exists()) {
                    if (!((VERSION.SDK_INT == 23 || VERSION.SDK_INT == 25) && Build.MANUFACTURER.toLowerCase().contains("mi"))) {
                        i = 0;
                    }
                    if (z || i != 0) {
                        i = b(file);
                        if (i > 0) {
                            return i;
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        if (file == null || !file.exists()) {
            return 0;
        }
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1);
            return packageArchiveInfo != null ? packageArchiveInfo.versionCode : 0;
        } catch (Throwable th2) {
            return -1;
        }
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[32];
        FileInputStream fileInputStream2;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                byte[] digest = instance.digest();
                int i = 0;
                int i2 = 0;
                while (i < 16) {
                    byte b = digest[i];
                    int i3 = i2 + 1;
                    cArr2[i2] = cArr[(b >>> 4) & 15];
                    int i4 = i3 + 1;
                    cArr2[i3] = cArr[b & 15];
                    i++;
                    i2 = i4;
                }
                String str = new String(cArr2);
                if (fileInputStream2 == null) {
                    return str;
                }
                try {
                    fileInputStream2.close();
                    return str;
                } catch (IOException e) {
                    return str;
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

    public static boolean a(Context context, File file, long j, int i) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (j > 0 && j != file.length()) {
            return false;
        }
        try {
            if (i != a(context, file)) {
                return false;
            }
            return "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(b.a(context, file));
        } catch (Exception e) {
            return false;
        }
    }

    private static int b(File file) {
        BufferedReader bufferedReader;
        Throwable th;
        JarFile jarFile;
        BufferedReader bufferedReader2;
        try {
            jarFile = new JarFile(file);
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(jarFile.getInputStream(jarFile.getJarEntry("assets/webkit/tbs.conf"))));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            if (jarFile != null) {
                                jarFile.close();
                            }
                        } else if (readLine.contains("tbs_core_version")) {
                            String[] split = readLine.split("=");
                            if (split != null && split.length == 2) {
                                int parseInt = Integer.parseInt(split[1].trim());
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (Exception e) {
                                        return parseInt;
                                    }
                                }
                                if (jarFile == null) {
                                    return parseInt;
                                }
                                jarFile.close();
                                return parseInt;
                            }
                        }
                    } catch (Exception e2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e3) {
                            }
                        }
                        if (jarFile != null) {
                            jarFile.close();
                        }
                        return -1;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Exception e4) {
                                throw th;
                            }
                        }
                        if (jarFile != null) {
                            jarFile.close();
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                bufferedReader = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e32) {
                    }
                }
                if (jarFile != null) {
                    jarFile.close();
                }
                return -1;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = null;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e42) {
                        throw th;
                    }
                }
                if (jarFile != null) {
                    jarFile.close();
                }
                throw th;
            }
        } catch (Exception e6) {
            bufferedReader = null;
            jarFile = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e322) {
                }
            }
            if (jarFile != null) {
                jarFile.close();
            }
            return -1;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader2 = null;
            jarFile = null;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e422) {
                    throw th;
                }
            }
            if (jarFile != null) {
                jarFile.close();
            }
            throw th;
        }
        return -1;
    }
}
