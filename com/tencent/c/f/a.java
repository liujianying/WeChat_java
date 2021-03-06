package com.tencent.c.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class a {
    public static List<com.tencent.c.a.a> hs(Context context) {
        List<com.tencent.c.a.a> arrayList = new ArrayList();
        try {
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(0)) {
                if (!(applicationInfo.packageName == null || applicationInfo.packageName.equals(packageName))) {
                    int i;
                    Object obj = (applicationInfo.flags & 1) != 0 ? 1 : null;
                    com.tencent.c.a.a bK = bK(context, applicationInfo.packageName);
                    bK.vhM = packageManager.getApplicationLabel(applicationInfo).toString();
                    if (bK.vhM == null) {
                        bK.vhM = "";
                    }
                    if (obj != null) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    bK.dPU = i;
                    bK.fileSize = new File(applicationInfo.sourceDir).length();
                    bK.vhO = applicationInfo.sourceDir;
                    arrayList.add(bK);
                    h.cF("add app: " + applicationInfo.packageName);
                }
            }
        } catch (Throwable th) {
            h.cD("getAllAppInfos(), exception: " + th);
        }
        return arrayList;
    }

    public static String act(String str) {
        Object th;
        Throwable th2;
        String str2 = null;
        ZipFile zipFile;
        BufferedReader bufferedReader;
        try {
            if (new File(str).exists()) {
                zipFile = new ZipFile(str);
                try {
                    ZipEntry entry = zipFile.getEntry("META-INF/MANIFEST.MF");
                    if (entry == null) {
                        try {
                            zipFile.close();
                        } catch (IOException e) {
                        }
                    } else if (entry.getSize() >= 10485760) {
                        try {
                            zipFile.close();
                        } catch (IOException e2) {
                        }
                    } else {
                        bufferedReader = new BufferedReader(new InputStreamReader(zipFile.getInputStream(entry)));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e3) {
                                    }
                                    try {
                                        zipFile.close();
                                        break;
                                    } catch (IOException e4) {
                                    }
                                } else if (readLine.contains("classes.dex")) {
                                    readLine = bufferedReader.readLine();
                                    if (readLine != null && readLine.contains("SHA1-Digest")) {
                                        int indexOf = readLine.indexOf(":");
                                        if (indexOf > 0) {
                                            str2 = readLine.substring(indexOf + 1).trim();
                                            try {
                                                bufferedReader.close();
                                            } catch (IOException e5) {
                                            }
                                            try {
                                                zipFile.close();
                                                break;
                                            } catch (IOException e6) {
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    h.cE("getAppDexSha1(), exception: " + th);
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e7) {
                                        }
                                    }
                                    if (zipFile != null) {
                                        try {
                                            zipFile.close();
                                        } catch (IOException e8) {
                                        }
                                    }
                                    return str2;
                                } catch (Throwable th4) {
                                    th2 = th4;
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e9) {
                                        }
                                    }
                                    if (zipFile != null) {
                                        try {
                                            zipFile.close();
                                        } catch (IOException e10) {
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e92) {
                        }
                    }
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e102) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th6) {
            th2 = th6;
            zipFile = null;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e922) {
                }
            }
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e1022) {
                }
            }
            throw th2;
        }
        return str2;
    }

    public static List<byte[]> bJ(Context context, String str) {
        List<byte[]> arrayList = new ArrayList();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                Signature[] signatureArr = packageInfo.signatures;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= signatureArr.length || i2 >= 5) {
                        break;
                    }
                    X509Certificate x509Certificate = (X509Certificate) a(CertificateFactory.getInstance("X.509"), signatureArr[i2]);
                    if (x509Certificate != null) {
                        arrayList.add(e.bO(x509Certificate.getEncoded()));
                    }
                    i = i2 + 1;
                }
            }
        } catch (CertificateEncodingException e) {
            h.cE("extractPkgCertMd5s(), CertificateEncodingException: " + e);
        } catch (Throwable th) {
            h.cE("extractPkgCertMd5s(), Exception: " + th);
        }
        return arrayList;
    }

    public static com.tencent.c.a.a bK(Context context, String str) {
        com.tencent.c.a.a aVar = new com.tencent.c.a.a();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            aVar.byT = str;
            aVar.versionName = packageInfo.versionName;
            aVar.versionCode = packageInfo.versionCode;
            X509Certificate x509Certificate = (X509Certificate) a(CertificateFactory.getInstance("X.509"), packageInfo.signatures[0]);
            if (x509Certificate != null) {
                String str2;
                byte[] bO = e.bO(x509Certificate.getEncoded());
                if (bO == null) {
                    str2 = null;
                } else {
                    StringBuffer stringBuffer = new StringBuffer(bO.length);
                    for (byte b : bO) {
                        String toHexString = Integer.toHexString(b & 255);
                        if (toHexString.length() < 2) {
                            stringBuffer.append(0);
                        }
                        stringBuffer.append(toHexString.toUpperCase());
                    }
                    str2 = stringBuffer.toString();
                }
                aVar.vhN = str2;
            }
        } catch (Throwable th) {
        }
        return aVar;
    }

    private static Certificate a(CertificateFactory certificateFactory, Signature signature) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
        try {
            X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
            try {
                byteArrayInputStream.close();
                return x509Certificate;
            } catch (IOException e) {
                return x509Certificate;
            }
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (IOException e2) {
            }
            throw th;
        }
    }
}
