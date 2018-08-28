package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.v;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

class ag {
    private static int d = 5;
    private static int e = 1;
    private static final String[] f = new String[]{"tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone"};
    private Set<String> A;
    private int B = d;
    private boolean C;
    String a;
    String[] b = null;
    int c = 0;
    private Context g;
    private String h;
    private String i;
    private String j;
    private File k;
    private long l;
    private int m = 30000;
    private int n = 20000;
    private boolean o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private HttpURLConnection t;
    private String u;
    private TbsLogReport$TbsLogInfo v;
    private String w;
    private int x;
    private boolean y;
    private Handler z;

    public ag(Context context) {
        this.g = context.getApplicationContext();
        this.v = TbsLogReport.a(this.g).a();
        this.A = new HashSet();
        this.u = "tbs_downloading_" + this.g.getPackageName();
        an.a();
        this.k = an.s(this.g);
        if (this.k == null) {
            throw new NullPointerException("TbsCorePrivateDir is null!");
        }
        f();
        this.w = null;
        this.x = -1;
    }

    private long a(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.v.setDownConsumeTime(currentTimeMillis - j);
        this.v.setDownloadSize(j2);
        return currentTimeMillis;
    }

    @TargetApi(8)
    static File a(Context context) {
        try {
            File file = VERSION.SDK_INT >= 8 ? new File(j.a(context, 4)) : null;
            if (file == null || file.exists() || file.isDirectory()) {
                return file;
            }
            file.mkdirs();
            return file;
        } catch (Exception e) {
            TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + e.getMessage());
            return null;
        }
    }

    private static File a(Context context, int i) {
        File file = new File(j.a(context, i));
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        return new File(file, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : "x5.tbs.org").exists() ? file : null;
    }

    private String a(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return stackTraceString.length() > 1024 ? stackTraceString.substring(0, 1024) : stackTraceString;
    }

    private String a(URL url) {
        String str = "";
        try {
            return InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (Exception e) {
            return str;
        } catch (Error e2) {
            return str;
        }
    }

    private void a(int i, String str, boolean z) {
        if (z || this.p > this.B) {
            this.v.setErrorCode(i);
            this.v.setFailDetail(str);
        }
    }

    private void a(long j) {
        this.p++;
        if (j <= 0) {
            try {
                j = m();
            } catch (Exception e) {
                return;
            }
        }
        Thread.sleep(j);
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static void a(File file, Context context) {
        if (file != null && file.exists()) {
            try {
                File a = a(context);
                if (a != null) {
                    File file2;
                    if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                        file2 = new File(a, "x5.tbs.decouple");
                    } else {
                        file2 = new File(a, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                    }
                    file2.delete();
                    j.b(file, file2);
                    if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1 && TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_DECOUPLECOREVERSION, 0) == a.a(context, file)) {
                        file2 = new File(a, "x5.tbs.decouple");
                        if (a.a(context, file) != a.a(context, file2)) {
                            file2.delete();
                            j.b(file, file2);
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private void a(String str) {
        URL url = new URL(str);
        if (this.t != null) {
            try {
                this.t.disconnect();
            } catch (Throwable th) {
                TbsLog.e("TbsDownload", "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
        }
        this.t = (HttpURLConnection) url.openConnection();
        this.t.setRequestProperty("User-Agent", TbsDownloader.a(this.g));
        this.t.setRequestProperty("Accept-Encoding", "identity");
        this.t.setRequestMethod("GET");
        this.t.setInstanceFollowRedirects(false);
        this.t.setConnectTimeout(this.n);
        this.t.setReadTimeout(this.m);
    }

    @TargetApi(8)
    static File b(Context context) {
        try {
            if (VERSION.SDK_INT < 8) {
                return null;
            }
            File a = a(context, 4);
            if (a == null) {
                a = a(context, 3);
            }
            if (a == null) {
                a = a(context, 2);
            }
            return a == null ? a(context, 1) : a;
        } catch (Exception e) {
            TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + e.getMessage());
            return null;
        }
    }

    private void b(boolean z) {
        v.a(this.g);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(this.g);
        instance.a.put(TbsDownloadConfig$TbsConfigKey.KEY_FULL_PACKAGE, Boolean.valueOf(false));
        instance.a.put(TbsDownloadConfig$TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(false));
        instance.a.put(TbsDownloadConfig$TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-123));
        instance.commit();
        QbSdk.m.onDownloadFinish(z ? 100 : 120);
        int i = instance.mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_RESPONSECODE, 0);
        TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0);
        if (i == 3 || i > 10000) {
            File a = a(this.g);
            if (a != null) {
                File file = new File(a, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                int a2 = a.a(this.g, file);
                File file2 = new File(this.k, "x5.tbs");
                String absolutePath = file2.exists() ? file2.getAbsolutePath() : null;
                int i2 = instance.mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                Bundle bundle = new Bundle();
                bundle.putInt("operation", i);
                bundle.putInt("old_core_ver", a2);
                bundle.putInt("new_core_ver", i2);
                bundle.putString("old_apk_location", file.getAbsolutePath());
                bundle.putString("new_apk_location", absolutePath);
                bundle.putString("diff_file_location", absolutePath);
                an.a().b(this.g, bundle);
                return;
            }
            d();
            instance.a.put(TbsDownloadConfig$TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
            instance.commit();
            return;
        }
        an.a().a(this.g, new File(this.k, "x5.tbs").getAbsolutePath(), instance.mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
        a(new File(this.k, "x5.tbs"), this.g);
    }

    private boolean b(int i) {
        try {
            File file = new File(this.k, "x5.tbs");
            File a = a(this.g);
            if (a == null) {
                return false;
            }
            File file2 = new File(a, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            file.delete();
            j.b(file2, file);
            if (a.a(this.g, file, 0, i)) {
                return true;
            }
            TbsLog.i("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
            return false;
        } catch (Exception e) {
            TbsLog.e("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + e.getMessage());
            return false;
        }
    }

    public static void c(Context context) {
        try {
            an.a();
            File s = an.s(context);
            new File(s, "x5.tbs").delete();
            new File(s, "x5.tbs.temp").delete();
            s = a(context);
            if (s != null) {
                new File(s, "x5.tbs.org").delete();
                new File(s, "x5.oversea.tbs.org").delete();
            }
        } catch (Exception e) {
        }
    }

    private boolean c(boolean z) {
        TbsLog.i("TbsDownload", "[TbsApkDownloader.deleteFile] isApk=" + z);
        File file = z ? new File(this.k, "x5.tbs") : new File(this.k, "x5.tbs.temp");
        return file.exists() ? file.delete() : true;
    }

    private boolean c(boolean z, boolean z2) {
        long j = 0;
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z);
        File file = new File(this.k, !z ? "x5.tbs" : "x5.tbs.temp");
        if (!file.exists()) {
            return false;
        }
        String string = TbsDownloadConfig.getInstance(this.g).mPreferences.getString(TbsDownloadConfig$TbsConfigKey.KEY_TBSAPK_MD5, null);
        String a = a.a(file);
        if (string == null || !string.equals(a)) {
            TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " md5 failed");
            if (!z) {
                return false;
            }
            this.v.setCheckErrorDetail("fileMd5 not match");
            return false;
        }
        boolean renameTo;
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] md5(" + a + ") successful!");
        if (z) {
            long j2;
            long j3 = TbsDownloadConfig.getInstance(this.g).mPreferences.getLong(TbsDownloadConfig$TbsConfigKey.KEY_TBSAPKFILESIZE, 0);
            if (!file.exists()) {
                j2 = 0;
            } else if (j3 > 0) {
                j2 = file.length();
                if (j3 == j2) {
                    j = j2;
                }
            }
            TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " filelength failed");
            this.v.setCheckErrorDetail("fileLength:" + j2 + ",contentLength:" + j3);
            return false;
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] length(" + j + ") successful!");
        int i = -1;
        if (z2 && !z) {
            i = a.a(this.g, file);
            int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            if (i2 != i) {
                TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " versionCode failed");
                if (!z) {
                    return false;
                }
                this.v.setCheckErrorDetail("fileVersion:" + i + ",configVersion:" + i2);
                return false;
            }
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i + ") successful!");
        if (z2 && !z) {
            string = b.a(this.g, file);
            if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(string)) {
                TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " signature failed");
                if (!z) {
                    return false;
                }
                this.v.setCheckErrorDetail("signature:" + (string == null ? "null" : Integer.valueOf(string.length())));
                return false;
            }
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] signature successful!");
        if (z) {
            Throwable th;
            try {
                renameTo = file.renameTo(new File(this.k, "x5.tbs"));
                th = null;
            } catch (Throwable e) {
                th = e;
                renameTo = false;
            }
            if (!renameTo) {
                a(s$l.AppCompatTheme_seekBarStyle, a(th), true);
                return false;
            }
        }
        renameTo = false;
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] rename(" + renameTo + ") successful!");
        return true;
    }

    private void f() {
        this.p = 0;
        this.q = 0;
        this.l = -1;
        this.j = null;
        this.o = false;
        this.r = false;
        this.s = false;
        this.y = false;
    }

    private void g() {
        TbsLog.i("TbsDownload", "[TbsApkDownloader.closeHttpRequest]");
        if (this.t != null) {
            if (!this.r) {
                this.v.setResolveIp(a(this.t.getURL()));
            }
            try {
                this.t.disconnect();
            } catch (Throwable th) {
                TbsLog.e("TbsDownload", "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
            this.t = null;
        }
        int i = this.v.a;
        if (this.r || !this.y) {
            TbsDownloader.a = false;
            return;
        }
        this.v.setEventTime(System.currentTimeMillis());
        String apnInfo = Apn.getApnInfo(this.g);
        if (apnInfo == null) {
            apnInfo = "";
        }
        int apnType = Apn.getApnType(this.g);
        this.v.setApn(apnInfo);
        this.v.setNetworkType(apnType);
        if (!(apnType == this.x && apnInfo.equals(this.w))) {
            this.v.setNetworkChange(0);
        }
        if ((this.v.a == 0 || this.v.a == s$l.AppCompatTheme_ratingBarStyleIndicator) && this.v.getDownFinalFlag() == 0) {
            if (!Apn.isNetworkAvailable(this.g)) {
                a(s$l.AppCompatTheme_buttonStyleSmall, null, true);
            } else if (!l()) {
                a(s$l.AppCompatTheme_buttonStyleSmall, null, true);
            }
        }
        if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
            TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
        } else {
            TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD, this.v);
        }
        this.v.resetArgs();
        if (i != 100) {
            QbSdk.m.onDownloadFinish(i);
        }
    }

    private boolean h() {
        File file = new File(j.a(this.g, 4), TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        int i = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        if (i == 0) {
            i = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        }
        return a.a(this.g, file, 0, i);
    }

    private void i() {
        try {
            if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) != 1) {
                File file = new File(j.a(this.g, 4), TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                if (file.exists()) {
                    file.delete();
                }
            }
        } catch (Exception e) {
        }
    }

    private boolean j() {
        return new File(this.k, "x5.tbs.temp").exists();
    }

    private long k() {
        File file = new File(this.k, "x5.tbs.temp");
        return file.exists() ? file.length() : 0;
    }

    private boolean l() {
        Throwable th;
        boolean z = false;
        Closeable inputStream;
        Closeable inputStreamReader;
        Closeable bufferedReader;
        try {
            inputStream = Runtime.getRuntime().exec("ping " + "www.qq.com").getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    int i = 0;
                    do {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.contains("TTL") || readLine.contains("ttl")) {
                                z = true;
                                break;
                            } else {
                                i++;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            a(inputStream);
                            a(inputStreamReader);
                            a(bufferedReader);
                            throw th;
                        }
                    } while (i < 5);
                    a(inputStream);
                    a(inputStreamReader);
                    a(bufferedReader);
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    a(inputStream);
                    a(inputStreamReader);
                    a(bufferedReader);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                inputStreamReader = null;
                a(inputStream);
                a(inputStreamReader);
                a(bufferedReader);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            inputStreamReader = null;
            inputStream = null;
            a(inputStream);
            a(inputStreamReader);
            a(bufferedReader);
            throw th;
        }
        return z;
    }

    private long m() {
        switch (this.p) {
            case 1:
            case 2:
                return 20000 * ((long) this.p);
            case 3:
            case 4:
                return 100000;
            default:
                return 200000;
        }
    }

    private boolean n() {
        CharSequence charSequence;
        Object charSequence2;
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = Apn.getApnType(this.g) == 3;
        TbsLog.i("TbsDownload", "[TbsApkDwonloader.detectWifiNetworkAvailable] isWifi=" + z3);
        if (z3) {
            String wifiSSID = Apn.getWifiSSID(this.g);
            TbsLog.i("TbsDownload", "[TbsApkDwonloader.detectWifiNetworkAvailable] localBSSID=" + wifiSSID);
            HttpURLConnection httpURLConnection2;
            try {
                httpURLConnection2 = (HttpURLConnection) new URL("http://pms.mb.qq.com/rsp204").openConnection();
                try {
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setReadTimeout(10000);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.getInputStream();
                    int responseCode = httpURLConnection2.getResponseCode();
                    TbsLog.i("TbsDownload", "[TbsApkDwonloader.detectWifiNetworkAvailable] responseCode=" + responseCode);
                    if (responseCode != 204) {
                        z = false;
                    }
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                            charSequence2 = wifiSSID;
                            z2 = z;
                        } catch (Exception e) {
                            charSequence2 = wifiSSID;
                            z2 = z;
                        }
                    } else {
                        charSequence2 = wifiSSID;
                        z2 = z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e22) {
                    }
                }
                throw th;
            }
        }
        if (!(z2 || TextUtils.isEmpty(charSequence2) || this.A.contains(charSequence2))) {
            this.A.add(charSequence2);
            o();
            this.z.sendMessageDelayed(this.z.obtainMessage(150, charSequence2), 120000);
        }
        if (z2 && this.A.contains(charSequence2)) {
            this.A.remove(charSequence2);
        }
        return z2;
    }

    private void o() {
        if (this.z == null) {
            this.z = new ah(this, al.a().getLooper());
        }
    }

    public void a(int i) {
        try {
            File file = new File(this.k, "x5.tbs");
            int a = a.a(this.g, file);
            if (-1 == a || (i > 0 && i == a)) {
                file.delete();
            }
        } catch (Exception e) {
        }
    }

    public boolean a() {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
        try {
            File file = new File(j.a(this.g, 4), "x5.tbs.decouple");
            if (file.exists()) {
                TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
            } else {
                File b = TbsDownloader.b(TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_DECOUPLECOREVERSION, -1));
                if (b != null && b.exists()) {
                    j.b(b, file);
                }
            }
            if (a.a(this.g, file, 0, TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_DECOUPLECOREVERSION, -1))) {
                TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
                return an.a().e(this.g);
            }
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup no backup file !!!");
            file = new File(j.a(this.g, 4), "x5.tbs.decouple");
            if (file.exists()) {
                file.delete();
            }
            return false;
        } catch (Exception e) {
        }
    }

    public boolean a(boolean z) {
        if ((z && !n() && (!QbSdk.getDownloadWithoutWifi() || !Apn.isNetworkAvailable(this.g))) || this.b == null || this.c < 0 || this.c >= this.b.length) {
            return false;
        }
        String[] strArr = this.b;
        int i = this.c;
        this.c = i + 1;
        this.j = strArr[i];
        this.p = 0;
        this.q = 0;
        this.l = -1;
        this.o = false;
        this.r = false;
        this.s = false;
        this.y = false;
        return true;
    }

    public boolean a(boolean z, boolean z2) {
        int i;
        int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        int i3 = an.a().i(this.g);
        if (i2 == 0) {
            i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            this.a = "by default key";
            i = i2;
        } else {
            this.a = "by new key";
            i = i2;
        }
        if (i == 0 || i == i3) {
            return false;
        }
        if (z2) {
            boolean z3;
            File a = TbsDownloader.a(i);
            if (a != null && a.exists()) {
                File file = new File(j.a(this.g, 4), TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                try {
                    if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1) {
                        j.b(a, file);
                        z3 = true;
                        if (h()) {
                            i();
                            if (!a.a(this.g, a, 0, i)) {
                                j.b(a);
                            }
                        } else if (b(i)) {
                            TbsDownloadConfig.getInstance(this.g).a.put(TbsDownloadConfig$TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-214));
                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
                            b(false);
                            if (!z3) {
                                return true;
                            }
                            a(100, "use local backup apk in startDownload" + this.a, true);
                            if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                                TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
                            } else {
                                TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD, this.v);
                            }
                            this.v.resetArgs();
                            return true;
                        }
                    }
                } catch (Exception e) {
                }
            }
            z3 = false;
            if (h()) {
                i();
                if (!a.a(this.g, a, 0, i)) {
                    j.b(a);
                }
            } else if (b(i)) {
                TbsDownloadConfig.getInstance(this.g).a.put(TbsDownloadConfig$TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-214));
                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
                b(false);
                if (!z3) {
                    return true;
                }
                a(100, "use local backup apk in startDownload" + this.a, true);
                if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                    TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
                } else {
                    TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD, this.v);
                }
                this.v.resetArgs();
                return true;
            }
        }
        if (c(false, z2)) {
            TbsDownloadConfig.getInstance(this.g).a.put(TbsDownloadConfig$TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-214));
            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
            b(false);
            return true;
        }
        if (!(c(true) || c(true))) {
            TbsLog.e("TbsDownload", "[TbsApkDownloader] delete file failed!");
            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-301);
        }
        return false;
    }

    public int b() {
        File a = a(this.g);
        if (a == null) {
            return 0;
        }
        return a.a(this.g, new File(a, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(boolean r31, boolean r32) {
        /*
        r30 = this;
        r4 = com.tencent.smtt.sdk.an.a();
        r0 = r30;
        r5 = r0.g;
        r4 = r4.c(r5);
        if (r4 == 0) goto L_0x0021;
    L_0x000e:
        if (r31 != 0) goto L_0x0021;
    L_0x0010:
        r4 = 0;
        com.tencent.smtt.sdk.TbsDownloader.a = r4;
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r5 = -322; // 0xfffffffffffffebe float:NaN double:NaN;
        r4.setDownloadInterruptCode(r5);
    L_0x0020:
        return;
    L_0x0021:
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4 = r4.mPreferences;
        r5 = "tbs_responsecode";
        r6 = 0;
        r4 = r4.getInt(r5, r6);
        r5 = 1;
        if (r4 == r5) goto L_0x003c;
    L_0x0036:
        r5 = 2;
        if (r4 == r5) goto L_0x003c;
    L_0x0039:
        r5 = 4;
        if (r4 != r5) goto L_0x0051;
    L_0x003c:
        r4 = 1;
        r21 = r4;
    L_0x003f:
        if (r32 != 0) goto L_0x0055;
    L_0x0041:
        r0 = r30;
        r1 = r31;
        r2 = r21;
        r4 = r0.a(r1, r2);
        if (r4 == 0) goto L_0x0055;
    L_0x004d:
        r4 = 0;
        com.tencent.smtt.sdk.TbsDownloader.a = r4;
        goto L_0x0020;
    L_0x0051:
        r4 = 0;
        r21 = r4;
        goto L_0x003f;
    L_0x0055:
        r0 = r31;
        r1 = r30;
        r1.C = r0;
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4 = r4.mPreferences;
        r5 = "tbs_downloadurl";
        r6 = 0;
        r4 = r4.getString(r5, r6);
        r0 = r30;
        r0.h = r4;
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4 = r4.mPreferences;
        r5 = "tbs_downloadurl_list";
        r6 = 0;
        r4 = r4.getString(r5, r6);
        r5 = "TbsDownload";
        r6 = new java.lang.StringBuilder;
        r7 = "backupUrlStrings:";
        r6.<init>(r7);
        r6 = r6.append(r4);
        r6 = r6.toString();
        r7 = 1;
        com.tencent.smtt.utils.TbsLog.i(r5, r6, r7);
        r5 = 0;
        r0 = r30;
        r0.b = r5;
        r5 = 0;
        r0 = r30;
        r0.c = r5;
        if (r31 != 0) goto L_0x00c4;
    L_0x00a6:
        if (r4 == 0) goto L_0x00c4;
    L_0x00a8:
        r5 = "";
        r6 = r4.trim();
        r5 = r5.equals(r6);
        if (r5 != 0) goto L_0x00c4;
    L_0x00b5:
        r5 = r4.trim();
        r6 = ";";
        r5 = r5.split(r6);
        r0 = r30;
        r0.b = r5;
    L_0x00c4:
        r5 = "TbsDownload";
        r6 = new java.lang.StringBuilder;
        r7 = "[TbsApkDownloader.startDownload] mDownloadUrl=";
        r6.<init>(r7);
        r0 = r30;
        r7 = r0.h;
        r6 = r6.append(r7);
        r7 = " backupUrlStrings=";
        r6 = r6.append(r7);
        r4 = r6.append(r4);
        r6 = " mLocation=";
        r4 = r4.append(r6);
        r0 = r30;
        r6 = r0.j;
        r4 = r4.append(r6);
        r6 = " mCanceled=";
        r4 = r4.append(r6);
        r0 = r30;
        r6 = r0.r;
        r4 = r4.append(r6);
        r6 = " mHttpRequest=";
        r4 = r4.append(r6);
        r0 = r30;
        r6 = r0.t;
        r4 = r4.append(r6);
        r4 = r4.toString();
        com.tencent.smtt.utils.TbsLog.i(r5, r4);
        r0 = r30;
        r4 = r0.h;
        if (r4 != 0) goto L_0x0138;
    L_0x011c:
        r0 = r30;
        r4 = r0.j;
        if (r4 != 0) goto L_0x0138;
    L_0x0122:
        r4 = com.tencent.smtt.sdk.QbSdk.m;
        r5 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r4.onDownloadFinish(r5);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r5 = -302; // 0xfffffffffffffed2 float:NaN double:NaN;
        r4.setDownloadInterruptCode(r5);
        goto L_0x0020;
    L_0x0138:
        r0 = r30;
        r4 = r0.t;
        if (r4 == 0) goto L_0x015a;
    L_0x013e:
        r0 = r30;
        r4 = r0.r;
        if (r4 != 0) goto L_0x015a;
    L_0x0144:
        r4 = com.tencent.smtt.sdk.QbSdk.m;
        r5 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r4.onDownloadFinish(r5);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r5 = -303; // 0xfffffffffffffed1 float:NaN double:NaN;
        r4.setDownloadInterruptCode(r5);
        goto L_0x0020;
    L_0x015a:
        if (r31 != 0) goto L_0x018d;
    L_0x015c:
        r0 = r30;
        r4 = r0.A;
        r0 = r30;
        r5 = r0.g;
        r5 = com.tencent.smtt.utils.Apn.getWifiSSID(r5);
        r4 = r4.contains(r5);
        if (r4 == 0) goto L_0x018d;
    L_0x016e:
        r4 = "TbsDownload";
        r5 = "[TbsApkDownloader.startDownload] WIFI Unavailable";
        com.tencent.smtt.utils.TbsLog.i(r4, r5);
        r4 = com.tencent.smtt.sdk.QbSdk.m;
        r5 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r4.onDownloadFinish(r5);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r5 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        r4.setDownloadInterruptCode(r5);
        goto L_0x0020;
    L_0x018d:
        r30.f();
        r4 = "TbsDownload";
        r5 = "STEP 1/2 begin downloading...";
        r6 = 1;
        com.tencent.smtt.utils.TbsLog.i(r4, r5, r6);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r24 = r4.getDownloadMaxflow();
        r6 = 0;
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4 = r4.mPreferences;
        r5 = "tbs_downloadflow";
        r8 = 0;
        r4 = r4.getLong(r5, r8);
        if (r31 == 0) goto L_0x0271;
    L_0x01bc:
        r7 = e;
        r0 = r30;
        r0.B = r7;
    L_0x01c2:
        r0 = r30;
        r7 = r0.p;
        r0 = r30;
        r8 = r0.B;
        if (r7 > r8) goto L_0x01ea;
    L_0x01cc:
        r0 = r30;
        r7 = r0.q;
        r8 = 8;
        if (r7 <= r8) goto L_0x0279;
    L_0x01d4:
        r4 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        r5 = 0;
        r7 = 1;
        r0 = r30;
        r0.a(r4, r5, r7);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r5 = -306; // 0xfffffffffffffece float:NaN double:NaN;
        r4.setDownloadInterruptCode(r5);
    L_0x01ea:
        r0 = r30;
        r4 = r0.r;
        if (r4 != 0) goto L_0x026c;
    L_0x01f0:
        r0 = r30;
        r4 = r0.s;
        if (r4 == 0) goto L_0x023d;
    L_0x01f6:
        r0 = r30;
        r4 = r0.b;
        if (r4 != 0) goto L_0x0207;
    L_0x01fc:
        if (r6 != 0) goto L_0x0207;
    L_0x01fe:
        r4 = 1;
        r0 = r30;
        r1 = r21;
        r6 = r0.c(r4, r1);
    L_0x0207:
        r0 = r30;
        r5 = r0.v;
        if (r6 == 0) goto L_0x0ebc;
    L_0x020d:
        r4 = 1;
    L_0x020e:
        r5.setUnpkgFlag(r4);
        if (r21 != 0) goto L_0x0ec2;
    L_0x0213:
        r0 = r30;
        r5 = r0.v;
        if (r6 == 0) goto L_0x0ebf;
    L_0x0219:
        r4 = 1;
    L_0x021a:
        r5.setPatchUpdateFlag(r4);
    L_0x021d:
        if (r6 == 0) goto L_0x0ecc;
    L_0x021f:
        r4 = 1;
        r0 = r30;
        r0.b(r4);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r5 = -317; // 0xfffffffffffffec3 float:NaN double:NaN;
        r4.setDownloadInterruptCode(r5);
        r4 = 100;
        r5 = "success";
        r7 = 1;
        r0 = r30;
        r0.a(r4, r5, r7);
    L_0x023d:
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        if (r6 == 0) goto L_0x0ee1;
    L_0x0247:
        r5 = r4.mPreferences;
        r7 = "tbs_download_success_retrytimes";
        r8 = 0;
        r5 = r5.getInt(r7, r8);
        r7 = r4.a;
        r8 = "tbs_download_success_retrytimes";
        r5 = r5 + 1;
        r5 = java.lang.Integer.valueOf(r5);
        r7.put(r8, r5);
    L_0x025f:
        r4.commit();
        r0 = r30;
        r5 = r0.v;
        if (r6 == 0) goto L_0x0f09;
    L_0x0268:
        r4 = 1;
    L_0x0269:
        r5.setDownFinalFlag(r4);
    L_0x026c:
        r30.g();
        goto L_0x0020;
    L_0x0271:
        r7 = d;
        r0 = r30;
        r0.B = r7;
        goto L_0x01c2;
    L_0x0279:
        r22 = java.lang.System.currentTimeMillis();
        if (r31 != 0) goto L_0x0385;
    L_0x027f:
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r7 = r7.mPreferences;	 Catch:{ Throwable -> 0x0570 }
        r8 = "tbs_downloadstarttime";
        r10 = 0;
        r8 = r7.getLong(r8, r10);	 Catch:{ Throwable -> 0x0570 }
        r8 = r22 - r8;
        r10 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r7 <= 0) goto L_0x0328;
    L_0x029b:
        r7 = "TbsDownload";
        r8 = "[TbsApkDownloader.startDownload] OVER DOWNLOAD_PERIOD";
        com.tencent.smtt.utils.TbsLog.i(r7, r8);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r7 = r7.a;	 Catch:{ Throwable -> 0x0570 }
        r8 = "tbs_downloadstarttime";
        r9 = java.lang.Long.valueOf(r22);	 Catch:{ Throwable -> 0x0570 }
        r7.put(r8, r9);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r7 = r7.a;	 Catch:{ Throwable -> 0x0570 }
        r8 = "tbs_downloadflow";
        r10 = 0;
        r9 = java.lang.Long.valueOf(r10);	 Catch:{ Throwable -> 0x0570 }
        r7.put(r8, r9);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r7.commit();	 Catch:{ Throwable -> 0x0570 }
        r4 = 0;
    L_0x02db:
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.utils.j.b(r7);	 Catch:{ Throwable -> 0x0570 }
        if (r7 != 0) goto L_0x0385;
    L_0x02e5:
        r7 = "TbsDownload";
        r8 = "DownloadBegin FreeSpace too small";
        r9 = 1;
        com.tencent.smtt.utils.TbsLog.i(r7, r8, r9);	 Catch:{ Throwable -> 0x0570 }
        r7 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        r8 = 0;
        r9 = 1;
        r0 = r30;
        r0.a(r7, r8, r9);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r8 = -308; // 0xfffffffffffffecc float:NaN double:NaN;
        r7.setDownloadInterruptCode(r8);	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x01ea;
    L_0x0307:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r7.put(r8, r4);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4.commit();
        goto L_0x01ea;
    L_0x0328:
        r7 = "TbsDownload";
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0570 }
        r9 = "[TbsApkDownloader.startDownload] downloadFlow=";
        r8.<init>(r9);	 Catch:{ Throwable -> 0x0570 }
        r8 = r8.append(r4);	 Catch:{ Throwable -> 0x0570 }
        r8 = r8.toString();	 Catch:{ Throwable -> 0x0570 }
        com.tencent.smtt.utils.TbsLog.i(r7, r8);	 Catch:{ Throwable -> 0x0570 }
        r7 = (r4 > r24 ? 1 : (r4 == r24 ? 0 : -1));
        if (r7 < 0) goto L_0x02db;
    L_0x0342:
        r7 = "TbsDownload";
        r8 = "STEP 1/2 begin downloading...failed because you exceeded max flow!";
        r9 = 1;
        com.tencent.smtt.utils.TbsLog.i(r7, r8, r9);	 Catch:{ Throwable -> 0x0570 }
        r7 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r8 = 0;
        r9 = 1;
        r0 = r30;
        r0.a(r7, r8, r9);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r8 = -307; // 0xfffffffffffffecd float:NaN double:NaN;
        r7.setDownloadInterruptCode(r8);	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x01ea;
    L_0x0364:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r7.put(r8, r4);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4.commit();
        goto L_0x01ea;
    L_0x0385:
        r7 = 1;
        r0 = r30;
        r0.y = r7;	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.j;	 Catch:{ Throwable -> 0x0570 }
        if (r7 == 0) goto L_0x0519;
    L_0x0390:
        r0 = r30;
        r7 = r0.j;	 Catch:{ Throwable -> 0x0570 }
    L_0x0394:
        r8 = "TbsDownload";
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0570 }
        r10 = "try url:";
        r9.<init>(r10);	 Catch:{ Throwable -> 0x0570 }
        r9 = r9.append(r7);	 Catch:{ Throwable -> 0x0570 }
        r10 = ",mRetryTimes:";
        r9 = r9.append(r10);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r10 = r0.p;	 Catch:{ Throwable -> 0x0570 }
        r9 = r9.append(r10);	 Catch:{ Throwable -> 0x0570 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0570 }
        r10 = 1;
        com.tencent.smtt.utils.TbsLog.i(r8, r9, r10);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r8 = r0.i;	 Catch:{ Throwable -> 0x0570 }
        r8 = r7.equals(r8);	 Catch:{ Throwable -> 0x0570 }
        if (r8 != 0) goto L_0x03cb;
    L_0x03c4:
        r0 = r30;
        r8 = r0.v;	 Catch:{ Throwable -> 0x0570 }
        r8.setDownloadUrl(r7);	 Catch:{ Throwable -> 0x0570 }
    L_0x03cb:
        r0 = r30;
        r0.i = r7;	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r0.a(r7);	 Catch:{ Throwable -> 0x0570 }
        r12 = 0;
        r0 = r30;
        r7 = r0.o;	 Catch:{ Throwable -> 0x0570 }
        if (r7 != 0) goto L_0x0438;
    L_0x03dc:
        r12 = r30.k();	 Catch:{ Throwable -> 0x0570 }
        r7 = "TbsDownload";
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0570 }
        r9 = "[TbsApkDownloader.startDownload] range=";
        r8.<init>(r9);	 Catch:{ Throwable -> 0x0570 }
        r8 = r8.append(r12);	 Catch:{ Throwable -> 0x0570 }
        r8 = r8.toString();	 Catch:{ Throwable -> 0x0570 }
        com.tencent.smtt.utils.TbsLog.i(r7, r8);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r8 = r0.l;	 Catch:{ Throwable -> 0x0570 }
        r10 = 0;
        r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r7 > 0) goto L_0x051f;
    L_0x0400:
        r7 = "TbsDownload";
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0570 }
        r9 = "STEP 1/2 begin downloading...current";
        r8.<init>(r9);	 Catch:{ Throwable -> 0x0570 }
        r8 = r8.append(r12);	 Catch:{ Throwable -> 0x0570 }
        r8 = r8.toString();	 Catch:{ Throwable -> 0x0570 }
        r9 = 1;
        com.tencent.smtt.utils.TbsLog.i(r7, r8, r9);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.t;	 Catch:{ Throwable -> 0x0570 }
        r8 = "Range";
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0570 }
        r10 = "bytes=";
        r9.<init>(r10);	 Catch:{ Throwable -> 0x0570 }
        r9 = r9.append(r12);	 Catch:{ Throwable -> 0x0570 }
        r10 = "-";
        r9 = r9.append(r10);	 Catch:{ Throwable -> 0x0570 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0570 }
        r7.setRequestProperty(r8, r9);	 Catch:{ Throwable -> 0x0570 }
    L_0x0438:
        r0 = r30;
        r8 = r0.v;	 Catch:{ Throwable -> 0x0570 }
        r10 = 0;
        r7 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
        if (r7 != 0) goto L_0x05e8;
    L_0x0442:
        r7 = 0;
    L_0x0443:
        r8.setDownloadCancel(r7);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.utils.Apn.getApnType(r7);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r8 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r8 = com.tencent.smtt.utils.Apn.getApnInfo(r8);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r9 = r0.w;	 Catch:{ Throwable -> 0x0570 }
        if (r9 != 0) goto L_0x05eb;
    L_0x045c:
        r0 = r30;
        r9 = r0.x;	 Catch:{ Throwable -> 0x0570 }
        r10 = -1;
        if (r9 != r10) goto L_0x05eb;
    L_0x0463:
        r0 = r30;
        r0.w = r8;	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r0.x = r7;	 Catch:{ Throwable -> 0x0570 }
    L_0x046b:
        r0 = r30;
        r7 = r0.p;	 Catch:{ Throwable -> 0x0570 }
        if (r7 <= 0) goto L_0x047f;
    L_0x0471:
        r0 = r30;
        r7 = r0.t;	 Catch:{ Throwable -> 0x0570 }
        r8 = "Referer";
        r0 = r30;
        r9 = r0.h;	 Catch:{ Throwable -> 0x0570 }
        r7.addRequestProperty(r8, r9);	 Catch:{ Throwable -> 0x0570 }
    L_0x047f:
        r0 = r30;
        r7 = r0.t;	 Catch:{ Throwable -> 0x0570 }
        r7 = r7.getResponseCode();	 Catch:{ Throwable -> 0x0570 }
        r8 = "TbsDownload";
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0570 }
        r10 = "[TbsApkDownloader.startDownload] responseCode=";
        r9.<init>(r10);	 Catch:{ Throwable -> 0x0570 }
        r9 = r9.append(r7);	 Catch:{ Throwable -> 0x0570 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0570 }
        com.tencent.smtt.utils.TbsLog.i(r8, r9);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r8 = r0.v;	 Catch:{ Throwable -> 0x0570 }
        r8.setHttpCode(r7);	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x04e3;
    L_0x04a6:
        r0 = r30;
        r8 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r8 = com.tencent.smtt.sdk.TbsDownloader.getOverSea(r8);	 Catch:{ Throwable -> 0x0570 }
        if (r8 != 0) goto L_0x04e3;
    L_0x04b0:
        r0 = r30;
        r8 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r8 = com.tencent.smtt.utils.Apn.getApnType(r8);	 Catch:{ Throwable -> 0x0570 }
        r9 = 3;
        if (r8 == r9) goto L_0x04c1;
    L_0x04bb:
        r8 = com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi();	 Catch:{ Throwable -> 0x0570 }
        if (r8 == 0) goto L_0x04cb;
    L_0x04c1:
        r0 = r30;
        r8 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r8 = com.tencent.smtt.utils.Apn.getApnType(r8);	 Catch:{ Throwable -> 0x0570 }
        if (r8 != 0) goto L_0x04e3;
    L_0x04cb:
        r30.c();	 Catch:{ Throwable -> 0x0570 }
        r8 = com.tencent.smtt.sdk.QbSdk.m;	 Catch:{ Throwable -> 0x0570 }
        if (r8 == 0) goto L_0x04d9;
    L_0x04d2:
        r8 = com.tencent.smtt.sdk.QbSdk.m;	 Catch:{ Throwable -> 0x0570 }
        r9 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r8.onDownloadFinish(r9);	 Catch:{ Throwable -> 0x0570 }
    L_0x04d9:
        r8 = "TbsDownload";
        r9 = "Download is canceled due to NOT_WIFI error!";
        r10 = 0;
        com.tencent.smtt.utils.TbsLog.i(r8, r9, r10);	 Catch:{ Throwable -> 0x0570 }
    L_0x04e3:
        r0 = r30;
        r8 = r0.r;	 Catch:{ Throwable -> 0x0570 }
        if (r8 == 0) goto L_0x0632;
    L_0x04e9:
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r8 = -309; // 0xfffffffffffffecb float:NaN double:NaN;
        r7.setDownloadInterruptCode(r8);	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x01ea;
    L_0x04f8:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r7.put(r8, r4);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4.commit();
        goto L_0x01ea;
    L_0x0519:
        r0 = r30;
        r7 = r0.h;	 Catch:{ Throwable -> 0x0570 }
        goto L_0x0394;
    L_0x051f:
        r7 = "TbsDownload";
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0570 }
        r9 = "#1 STEP 1/2 begin downloading...current/total=";
        r8.<init>(r9);	 Catch:{ Throwable -> 0x0570 }
        r8 = r8.append(r12);	 Catch:{ Throwable -> 0x0570 }
        r9 = "/";
        r8 = r8.append(r9);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r10 = r0.l;	 Catch:{ Throwable -> 0x0570 }
        r8 = r8.append(r10);	 Catch:{ Throwable -> 0x0570 }
        r8 = r8.toString();	 Catch:{ Throwable -> 0x0570 }
        r9 = 1;
        com.tencent.smtt.utils.TbsLog.i(r7, r8, r9);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.t;	 Catch:{ Throwable -> 0x0570 }
        r8 = "Range";
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0570 }
        r10 = "bytes=";
        r9.<init>(r10);	 Catch:{ Throwable -> 0x0570 }
        r9 = r9.append(r12);	 Catch:{ Throwable -> 0x0570 }
        r10 = "-";
        r9 = r9.append(r10);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r10 = r0.l;	 Catch:{ Throwable -> 0x0570 }
        r9 = r9.append(r10);	 Catch:{ Throwable -> 0x0570 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0570 }
        r7.setRequestProperty(r8, r9);	 Catch:{ Throwable -> 0x0570 }
        goto L_0x0438;
    L_0x0570:
        r7 = move-exception;
    L_0x0571:
        r8 = r7 instanceof javax.net.ssl.SSLHandshakeException;	 Catch:{ all -> 0x060d }
        if (r8 == 0) goto L_0x0e71;
    L_0x0575:
        if (r31 != 0) goto L_0x0e71;
    L_0x0577:
        r0 = r30;
        r8 = r0.b;	 Catch:{ all -> 0x060d }
        if (r8 == 0) goto L_0x0e71;
    L_0x057d:
        r8 = 0;
        r0 = r30;
        r8 = r0.a(r8);	 Catch:{ all -> 0x060d }
        if (r8 == 0) goto L_0x0e71;
    L_0x0586:
        r8 = "TbsDownload";
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x060d }
        r10 = "[startdownload]url:";
        r9.<init>(r10);	 Catch:{ all -> 0x060d }
        r0 = r30;
        r10 = r0.j;	 Catch:{ all -> 0x060d }
        r9 = r9.append(r10);	 Catch:{ all -> 0x060d }
        r10 = " download exception：";
        r9 = r9.append(r10);	 Catch:{ all -> 0x060d }
        r7 = r7.toString();	 Catch:{ all -> 0x060d }
        r7 = r9.append(r7);	 Catch:{ all -> 0x060d }
        r7 = r7.toString();	 Catch:{ all -> 0x060d }
        com.tencent.smtt.utils.TbsLog.e(r8, r7);	 Catch:{ all -> 0x060d }
        r7 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        r8 = 0;
        r9 = 1;
        r0 = r30;
        r0.a(r7, r8, r9);	 Catch:{ all -> 0x060d }
    L_0x05b8:
        r0 = r30;
        r7 = r0.g;	 Catch:{ all -> 0x060d }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ all -> 0x060d }
        r8 = -316; // 0xfffffffffffffec4 float:NaN double:NaN;
        r7.setDownloadInterruptCode(r8);	 Catch:{ all -> 0x060d }
        if (r31 != 0) goto L_0x01c2;
    L_0x05c7:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r9 = java.lang.Long.valueOf(r4);
        r7.put(r8, r9);
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7.commit();
        goto L_0x01c2;
    L_0x05e8:
        r7 = 1;
        goto L_0x0443;
    L_0x05eb:
        r0 = r30;
        r9 = r0.x;	 Catch:{ Throwable -> 0x0570 }
        if (r7 != r9) goto L_0x05fb;
    L_0x05f1:
        r0 = r30;
        r9 = r0.w;	 Catch:{ Throwable -> 0x0570 }
        r9 = r8.equals(r9);	 Catch:{ Throwable -> 0x0570 }
        if (r9 != 0) goto L_0x046b;
    L_0x05fb:
        r0 = r30;
        r9 = r0.v;	 Catch:{ Throwable -> 0x0570 }
        r10 = 0;
        r9.setNetworkChange(r10);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r0.w = r8;	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r0.x = r7;	 Catch:{ Throwable -> 0x0570 }
        goto L_0x046b;
    L_0x060d:
        r6 = move-exception;
        r16 = r4;
    L_0x0610:
        if (r31 != 0) goto L_0x0631;
    L_0x0612:
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4 = r4.a;
        r5 = "tbs_downloadflow";
        r7 = java.lang.Long.valueOf(r16);
        r4.put(r5, r7);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4.commit();
    L_0x0631:
        throw r6;
    L_0x0632:
        r8 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r7 == r8) goto L_0x063a;
    L_0x0636:
        r8 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r7 != r8) goto L_0x0ba2;
    L_0x063a:
        r0 = r30;
        r7 = r0.t;	 Catch:{ Throwable -> 0x0570 }
        r7 = r7.getContentLength();	 Catch:{ Throwable -> 0x0570 }
        r8 = (long) r7;	 Catch:{ Throwable -> 0x0570 }
        r8 = r8 + r12;
        r0 = r30;
        r0.l = r8;	 Catch:{ Throwable -> 0x0570 }
        r7 = "TbsDownload";
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0570 }
        r9 = "[TbsApkDownloader.startDownload] mContentLength=";
        r8.<init>(r9);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r10 = r0.l;	 Catch:{ Throwable -> 0x0570 }
        r8 = r8.append(r10);	 Catch:{ Throwable -> 0x0570 }
        r8 = r8.toString();	 Catch:{ Throwable -> 0x0570 }
        com.tencent.smtt.utils.TbsLog.i(r7, r8);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.v;	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r8 = r0.l;	 Catch:{ Throwable -> 0x0570 }
        r7.setPkgSize(r8);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r7 = r7.mPreferences;	 Catch:{ Throwable -> 0x0570 }
        r8 = "tbs_apkfilesize";
        r10 = 0;
        r8 = r7.getLong(r8, r10);	 Catch:{ Throwable -> 0x0570 }
        r10 = 0;
        r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r7 == 0) goto L_0x076e;
    L_0x0686:
        r0 = r30;
        r10 = r0.l;	 Catch:{ Throwable -> 0x0570 }
        r7 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
        if (r7 == 0) goto L_0x076e;
    L_0x068e:
        r7 = "TbsDownload";
        r10 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0570 }
        r11 = "DownloadBegin tbsApkFileSize=";
        r10.<init>(r11);	 Catch:{ Throwable -> 0x0570 }
        r10 = r10.append(r8);	 Catch:{ Throwable -> 0x0570 }
        r11 = "  but contentLength=";
        r10 = r10.append(r11);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r12 = r0.l;	 Catch:{ Throwable -> 0x0570 }
        r10 = r10.append(r12);	 Catch:{ Throwable -> 0x0570 }
        r10 = r10.toString();	 Catch:{ Throwable -> 0x0570 }
        r11 = 1;
        com.tencent.smtt.utils.TbsLog.i(r7, r10, r11);	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x0755;
    L_0x06b6:
        r7 = r30.n();	 Catch:{ Throwable -> 0x0570 }
        if (r7 != 0) goto L_0x06cc;
    L_0x06bc:
        r7 = com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi();	 Catch:{ Throwable -> 0x0570 }
        if (r7 == 0) goto L_0x0755;
    L_0x06c2:
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.utils.Apn.isNetworkAvailable(r7);	 Catch:{ Throwable -> 0x0570 }
        if (r7 == 0) goto L_0x0755;
    L_0x06cc:
        r0 = r30;
        r7 = r0.b;	 Catch:{ Throwable -> 0x0570 }
        if (r7 == 0) goto L_0x06fe;
    L_0x06d2:
        r7 = 0;
        r0 = r30;
        r7 = r0.a(r7);	 Catch:{ Throwable -> 0x0570 }
        if (r7 == 0) goto L_0x06fe;
    L_0x06db:
        if (r31 != 0) goto L_0x01c2;
    L_0x06dd:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r9 = java.lang.Long.valueOf(r4);
        r7.put(r8, r9);
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7.commit();
        goto L_0x01c2;
    L_0x06fe:
        r7 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        r10 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0570 }
        r11 = "tbsApkFileSize=";
        r10.<init>(r11);	 Catch:{ Throwable -> 0x0570 }
        r8 = r10.append(r8);	 Catch:{ Throwable -> 0x0570 }
        r9 = "  but contentLength=";
        r8 = r8.append(r9);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r10 = r0.l;	 Catch:{ Throwable -> 0x0570 }
        r8 = r8.append(r10);	 Catch:{ Throwable -> 0x0570 }
        r8 = r8.toString();	 Catch:{ Throwable -> 0x0570 }
        r9 = 1;
        r0 = r30;
        r0.a(r7, r8, r9);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r8 = -310; // 0xfffffffffffffeca float:NaN double:NaN;
        r7.setDownloadInterruptCode(r8);	 Catch:{ Throwable -> 0x0570 }
    L_0x0732:
        if (r31 != 0) goto L_0x01ea;
    L_0x0734:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r7.put(r8, r4);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4.commit();
        goto L_0x01ea;
    L_0x0755:
        r7 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r8 = "WifiNetworkUnAvailable";
        r9 = 1;
        r0 = r30;
        r0.a(r7, r8, r9);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r8 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        r7.setDownloadInterruptCode(r8);	 Catch:{ Throwable -> 0x0570 }
        goto L_0x0732;
    L_0x076e:
        r10 = 0;
        r9 = 0;
        r8 = 0;
        r7 = "TbsDownload";
        r11 = "[TbsApkDownloader.startDownload] begin readResponse";
        com.tencent.smtt.utils.TbsLog.i(r7, r11);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.t;	 Catch:{ IOException -> 0x0f2f, all -> 0x0f10 }
        r19 = r7.getInputStream();	 Catch:{ IOException -> 0x0f2f, all -> 0x0f10 }
        if (r19 == 0) goto L_0x0a6e;
    L_0x0784:
        r0 = r30;
        r7 = r0.t;	 Catch:{ IOException -> 0x0834, all -> 0x0f1b }
        r7 = r7.getContentEncoding();	 Catch:{ IOException -> 0x0834, all -> 0x0f1b }
        if (r7 == 0) goto L_0x0818;
    L_0x078e:
        r9 = "gzip";
        r9 = r7.contains(r9);	 Catch:{ IOException -> 0x0834, all -> 0x0f1b }
        if (r9 == 0) goto L_0x0818;
    L_0x0797:
        r18 = new java.util.zip.GZIPInputStream;	 Catch:{ IOException -> 0x0834, all -> 0x0f1b }
        r18.<init>(r19);	 Catch:{ IOException -> 0x0834, all -> 0x0f1b }
    L_0x079c:
        r7 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = new byte[r7];	 Catch:{ IOException -> 0x0f32, all -> 0x0f24 }
        r26 = r0;
        r20 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0f32, all -> 0x0f24 }
        r7 = new java.io.File;	 Catch:{ IOException -> 0x0f32, all -> 0x0f24 }
        r0 = r30;
        r8 = r0.k;	 Catch:{ IOException -> 0x0f32, all -> 0x0f24 }
        r9 = "x5.tbs.temp";
        r7.<init>(r8, r9);	 Catch:{ IOException -> 0x0f32, all -> 0x0f24 }
        r8 = 1;
        r0 = r20;
        r0.<init>(r7, r8);	 Catch:{ IOException -> 0x0f32, all -> 0x0f24 }
        r14 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r7 = 0;
        r8 = r12;
        r10 = r12;
        r16 = r4;
    L_0x07bf:
        r0 = r30;
        r4 = r0.r;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        if (r4 == 0) goto L_0x0891;
    L_0x07c5:
        r4 = "TbsDownload";
        r5 = "STEP 1/2 begin downloading...Canceled!";
        r8 = 1;
        com.tencent.smtt.utils.TbsLog.i(r4, r5, r8);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r0 = r30;
        r4 = r0.g;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r5 = -309; // 0xfffffffffffffecb float:NaN double:NaN;
        r4.setDownloadInterruptCode(r5);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r4 = r16;
    L_0x07de:
        if (r7 == 0) goto L_0x0a72;
    L_0x07e0:
        r0 = r30;
        r1 = r20;
        r0.a(r1);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r1 = r18;
        r0.a(r1);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r1 = r19;
        r0.a(r1);	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x01c2;
    L_0x07f7:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r9 = java.lang.Long.valueOf(r4);
        r7.put(r8, r9);
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7.commit();
        goto L_0x01c2;
    L_0x0818:
        if (r7 == 0) goto L_0x088d;
    L_0x081a:
        r9 = "deflate";
        r7 = r7.contains(r9);	 Catch:{ IOException -> 0x0834, all -> 0x0f1b }
        if (r7 == 0) goto L_0x088d;
    L_0x0823:
        r18 = new java.util.zip.InflaterInputStream;	 Catch:{ IOException -> 0x0834, all -> 0x0f1b }
        r7 = new java.util.zip.Inflater;	 Catch:{ IOException -> 0x0834, all -> 0x0f1b }
        r9 = 1;
        r7.<init>(r9);	 Catch:{ IOException -> 0x0834, all -> 0x0f1b }
        r0 = r18;
        r1 = r19;
        r0.<init>(r1, r7);	 Catch:{ IOException -> 0x0834, all -> 0x0f1b }
        goto L_0x079c;
    L_0x0834:
        r7 = move-exception;
        r9 = r19;
    L_0x0837:
        r11 = r7 instanceof java.net.SocketTimeoutException;	 Catch:{ all -> 0x0b97 }
        if (r11 != 0) goto L_0x083f;
    L_0x083b:
        r11 = r7 instanceof java.net.SocketException;	 Catch:{ all -> 0x0b97 }
        if (r11 == 0) goto L_0x0abd;
    L_0x083f:
        r11 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        r0 = r30;
        r0.m = r11;	 Catch:{ all -> 0x0b97 }
        r12 = 0;
        r0 = r30;
        r0.a(r12);	 Catch:{ all -> 0x0b97 }
        r11 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        r0 = r30;
        r7 = r0.a(r7);	 Catch:{ all -> 0x0b97 }
        r12 = 0;
        r0 = r30;
        r0.a(r11, r7, r12);	 Catch:{ all -> 0x0b97 }
        r0 = r30;
        r0.a(r10);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r0.a(r8);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r0.a(r9);	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x01c2;
    L_0x086c:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r9 = java.lang.Long.valueOf(r4);
        r7.put(r8, r9);
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7.commit();
        goto L_0x01c2;
    L_0x088d:
        r18 = r19;
        goto L_0x079c;
    L_0x0891:
        r4 = 0;
        r5 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = r18;
        r1 = r26;
        r27 = r0.read(r1, r4, r5);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        if (r27 > 0) goto L_0x08e6;
    L_0x089e:
        r0 = r30;
        r4 = r0.b;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        if (r4 == 0) goto L_0x08c9;
    L_0x08a4:
        r4 = 1;
        r0 = r30;
        r1 = r21;
        r4 = r0.c(r4, r1);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        if (r4 != 0) goto L_0x08c9;
    L_0x08af:
        if (r31 != 0) goto L_0x08bf;
    L_0x08b1:
        r4 = 0;
        r0 = r30;
        r4 = r0.a(r4);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        if (r4 == 0) goto L_0x08bf;
    L_0x08ba:
        r7 = 1;
        r4 = r16;
        goto L_0x07de;
    L_0x08bf:
        r4 = 1;
        r0 = r30;
        r0.s = r4;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r6 = 0;
        r4 = r16;
        goto L_0x07de;
    L_0x08c9:
        r4 = 1;
        r0 = r30;
        r0.s = r4;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r0 = r30;
        r4 = r0.b;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        if (r4 == 0) goto L_0x08d5;
    L_0x08d4:
        r6 = 1;
    L_0x08d5:
        r0 = r30;
        r4 = r0.g;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r5 = -311; // 0xfffffffffffffec9 float:NaN double:NaN;
        r4.setDownloadInterruptCode(r5);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r4 = r16;
        goto L_0x07de;
    L_0x08e6:
        r4 = 0;
        r0 = r20;
        r1 = r26;
        r2 = r27;
        r0.write(r1, r4, r2);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r20.flush();	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        if (r31 != 0) goto L_0x09bb;
    L_0x08f5:
        r0 = r27;
        r4 = (long) r0;
        r4 = r4 + r16;
        r12 = (r4 > r24 ? 1 : (r4 == r24 ? 0 : -1));
        if (r12 < 0) goto L_0x0945;
    L_0x08fe:
        r8 = "TbsDownload";
        r9 = "STEP 1/2 begin downloading...failed because you exceeded max flow!";
        r10 = 1;
        com.tencent.smtt.utils.TbsLog.i(r8, r9, r10);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r8 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r9 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r10 = "downloadFlow=";
        r9.<init>(r10);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r9 = r9.append(r4);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r10 = " downloadMaxflow=";
        r9 = r9.append(r10);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r0 = r24;
        r9 = r9.append(r0);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r9 = r9.toString();	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r10 = 1;
        r0 = r30;
        r0.a(r8, r9, r10);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r0 = r30;
        r8 = r0.g;	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r8 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r8);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r9 = -307; // 0xfffffffffffffecd float:NaN double:NaN;
        r8.setDownloadInterruptCode(r9);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        goto L_0x07de;
    L_0x093c:
        r7 = move-exception;
        r8 = r18;
        r9 = r19;
        r10 = r20;
        goto L_0x0837;
    L_0x0945:
        r0 = r30;
        r12 = r0.g;	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r12 = com.tencent.smtt.utils.j.b(r12);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        if (r12 != 0) goto L_0x09b9;
    L_0x094f:
        r8 = "TbsDownload";
        r9 = "DownloadEnd FreeSpace too small ";
        r10 = 1;
        com.tencent.smtt.utils.TbsLog.i(r8, r9, r10);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r8 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        r9 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r10 = "freespace=";
        r9.<init>(r10);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r10 = com.tencent.smtt.utils.v.a();	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r9 = r9.append(r10);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r10 = ",and minFreeSpace=";
        r9 = r9.append(r10);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r0 = r30;
        r10 = r0.g;	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r10 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r10);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r10 = r10.getDownloadMinFreeSpace();	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r9 = r9.append(r10);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r9 = r9.toString();	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r10 = 1;
        r0 = r30;
        r0.a(r8, r9, r10);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r0 = r30;
        r8 = r0.g;	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r8 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r8);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        r9 = -308; // 0xfffffffffffffecc float:NaN double:NaN;
        r8.setDownloadInterruptCode(r9);	 Catch:{ IOException -> 0x093c, all -> 0x099b }
        goto L_0x07de;
    L_0x099b:
        r7 = move-exception;
        r16 = r4;
    L_0x099e:
        r0 = r30;
        r1 = r20;
        r0.a(r1);	 Catch:{ Throwable -> 0x09b4, all -> 0x0f0c }
        r0 = r30;
        r1 = r18;
        r0.a(r1);	 Catch:{ Throwable -> 0x09b4, all -> 0x0f0c }
        r0 = r30;
        r1 = r19;
        r0.a(r1);	 Catch:{ Throwable -> 0x09b4, all -> 0x0f0c }
        throw r7;	 Catch:{ Throwable -> 0x09b4, all -> 0x0f0c }
    L_0x09b4:
        r7 = move-exception;
        r4 = r16;
        goto L_0x0571;
    L_0x09b9:
        r16 = r4;
    L_0x09bb:
        r0 = r27;
        r4 = (long) r0;
        r0 = r30;
        r1 = r22;
        r22 = r0.a(r1, r4);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r0 = r27;
        r4 = (long) r0;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r8 = r8 + r4;
        r4 = r12 - r14;
        r28 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = (r4 > r28 ? 1 : (r4 == r28 ? 0 : -1));
        if (r4 <= 0) goto L_0x0f47;
    L_0x09d6:
        r4 = "TbsDownload";
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r14 = "#2 STEP 1/2 begin downloading...current/total=";
        r5.<init>(r14);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r5 = r5.append(r8);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r14 = "/";
        r5 = r5.append(r14);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r0 = r30;
        r14 = r0.l;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r5 = r5.append(r14);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r5 = r5.toString();	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r14 = 1;
        com.tencent.smtt.utils.TbsLog.i(r4, r5, r14);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r4 = com.tencent.smtt.sdk.QbSdk.m;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        if (r4 == 0) goto L_0x0a10;
    L_0x0a00:
        r4 = (double) r8;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r0 = r30;
        r14 = r0.l;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r14 = (double) r14;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r4 = r4 / r14;
        r14 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r4 = r4 * r14;
        r4 = (int) r4;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r5 = com.tencent.smtt.sdk.QbSdk.m;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r5.onDownloadProgress(r4);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
    L_0x0a10:
        if (r31 != 0) goto L_0x0f44;
    L_0x0a12:
        r4 = r8 - r10;
        r14 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r4 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1));
        if (r4 <= 0) goto L_0x0f44;
    L_0x0a1b:
        r0 = r30;
        r4 = r0.g;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r4 = com.tencent.smtt.sdk.TbsDownloader.getOverSea(r4);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        if (r4 != 0) goto L_0x0a69;
    L_0x0a25:
        r0 = r30;
        r4 = r0.g;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r4 = com.tencent.smtt.utils.Apn.getApnType(r4);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r5 = 3;
        if (r4 == r5) goto L_0x0a36;
    L_0x0a30:
        r4 = com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi();	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        if (r4 == 0) goto L_0x0a40;
    L_0x0a36:
        r0 = r30;
        r4 = r0.g;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r4 = com.tencent.smtt.utils.Apn.getApnType(r4);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        if (r4 != 0) goto L_0x0a69;
    L_0x0a40:
        r30.c();	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r4 = com.tencent.smtt.sdk.QbSdk.m;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        if (r4 == 0) goto L_0x0a4e;
    L_0x0a47:
        r4 = com.tencent.smtt.sdk.QbSdk.m;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r5 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r4.onDownloadFinish(r5);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
    L_0x0a4e:
        r4 = "TbsDownload";
        r5 = "Download is paused due to NOT_WIFI error!";
        r8 = 0;
        com.tencent.smtt.utils.TbsLog.i(r4, r5, r8);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r0 = r30;
        r4 = r0.g;	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r5 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        r4.setDownloadInterruptCode(r5);	 Catch:{ IOException -> 0x0f39, all -> 0x0f2b }
        r4 = r16;
        goto L_0x07de;
    L_0x0a69:
        r4 = r8;
    L_0x0a6a:
        r14 = r12;
        r10 = r4;
        goto L_0x07bf;
    L_0x0a6e:
        r18 = r8;
        r20 = r10;
    L_0x0a72:
        r0 = r30;
        r1 = r20;
        r0.a(r1);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r1 = r18;
        r0.a(r1);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r1 = r19;
        r0.a(r1);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.s;	 Catch:{ Throwable -> 0x0570 }
        if (r7 != 0) goto L_0x0a9a;
    L_0x0a8d:
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r8 = -319; // 0xfffffffffffffec1 float:NaN double:NaN;
        r7.setDownloadInterruptCode(r8);	 Catch:{ Throwable -> 0x0570 }
    L_0x0a9a:
        if (r31 != 0) goto L_0x01ea;
    L_0x0a9c:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r7.put(r8, r4);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4.commit();
        goto L_0x01ea;
    L_0x0abd:
        if (r31 != 0) goto L_0x0b3b;
    L_0x0abf:
        r0 = r30;
        r11 = r0.g;	 Catch:{ all -> 0x0b97 }
        r11 = com.tencent.smtt.utils.j.b(r11);	 Catch:{ all -> 0x0b97 }
        if (r11 != 0) goto L_0x0b3b;
    L_0x0ac9:
        r7 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0b97 }
        r12 = "freespace=";
        r11.<init>(r12);	 Catch:{ all -> 0x0b97 }
        r12 = com.tencent.smtt.utils.v.a();	 Catch:{ all -> 0x0b97 }
        r11 = r11.append(r12);	 Catch:{ all -> 0x0b97 }
        r12 = ",and minFreeSpace=";
        r11 = r11.append(r12);	 Catch:{ all -> 0x0b97 }
        r0 = r30;
        r12 = r0.g;	 Catch:{ all -> 0x0b97 }
        r12 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r12);	 Catch:{ all -> 0x0b97 }
        r12 = r12.getDownloadMinFreeSpace();	 Catch:{ all -> 0x0b97 }
        r11 = r11.append(r12);	 Catch:{ all -> 0x0b97 }
        r11 = r11.toString();	 Catch:{ all -> 0x0b97 }
        r12 = 1;
        r0 = r30;
        r0.a(r7, r11, r12);	 Catch:{ all -> 0x0b97 }
        r0 = r30;
        r7 = r0.g;	 Catch:{ all -> 0x0b97 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ all -> 0x0b97 }
        r11 = -308; // 0xfffffffffffffecc float:NaN double:NaN;
        r7.setDownloadInterruptCode(r11);	 Catch:{ all -> 0x0b97 }
        r0 = r30;
        r0.a(r10);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r0.a(r8);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r0.a(r9);	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x01ea;
    L_0x0b1a:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r7.put(r8, r4);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4.commit();
        goto L_0x01ea;
    L_0x0b3b:
        r12 = 0;
        r0 = r30;
        r0.a(r12);	 Catch:{ all -> 0x0b97 }
        r11 = r30.j();	 Catch:{ all -> 0x0b97 }
        if (r11 != 0) goto L_0x0b88;
    L_0x0b48:
        r11 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        r0 = r30;
        r7 = r0.a(r7);	 Catch:{ all -> 0x0b97 }
        r12 = 0;
        r0 = r30;
        r0.a(r11, r7, r12);	 Catch:{ all -> 0x0b97 }
    L_0x0b56:
        r0 = r30;
        r0.a(r10);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r0.a(r8);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r0.a(r9);	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x01c2;
    L_0x0b67:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r9 = java.lang.Long.valueOf(r4);
        r7.put(r8, r9);
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7.commit();
        goto L_0x01c2;
    L_0x0b88:
        r11 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r0 = r30;
        r7 = r0.a(r7);	 Catch:{ all -> 0x0b97 }
        r12 = 0;
        r0 = r30;
        r0.a(r11, r7, r12);	 Catch:{ all -> 0x0b97 }
        goto L_0x0b56;
    L_0x0b97:
        r7 = move-exception;
        r16 = r4;
        r18 = r8;
        r19 = r9;
        r20 = r10;
        goto L_0x099e;
    L_0x0ba2:
        r8 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r7 < r8) goto L_0x0c25;
    L_0x0ba6:
        r8 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
        if (r7 > r8) goto L_0x0c25;
    L_0x0baa:
        r0 = r30;
        r7 = r0.t;	 Catch:{ Throwable -> 0x0570 }
        r8 = "Location";
        r7 = r7.getHeaderField(r8);	 Catch:{ Throwable -> 0x0570 }
        r8 = android.text.TextUtils.isEmpty(r7);	 Catch:{ Throwable -> 0x0570 }
        if (r8 != 0) goto L_0x0bec;
    L_0x0bbb:
        r0 = r30;
        r0.j = r7;	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.q;	 Catch:{ Throwable -> 0x0570 }
        r7 = r7 + 1;
        r0 = r30;
        r0.q = r7;	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x01c2;
    L_0x0bcb:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r9 = java.lang.Long.valueOf(r4);
        r7.put(r8, r9);
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7.commit();
        goto L_0x01c2;
    L_0x0bec:
        r7 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
        r8 = 0;
        r9 = 1;
        r0 = r30;
        r0.a(r7, r8, r9);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r8 = -312; // 0xfffffffffffffec8 float:NaN double:NaN;
        r7.setDownloadInterruptCode(r8);	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x01ea;
    L_0x0c04:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r7.put(r8, r4);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4.commit();
        goto L_0x01ea;
    L_0x0c25:
        r8 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r9 = java.lang.String.valueOf(r7);	 Catch:{ Throwable -> 0x0570 }
        r10 = 0;
        r0 = r30;
        r0.a(r8, r9, r10);	 Catch:{ Throwable -> 0x0570 }
        r8 = 416; // 0x1a0 float:5.83E-43 double:2.055E-321;
        if (r7 != r8) goto L_0x0ca7;
    L_0x0c35:
        r7 = 1;
        r0 = r30;
        r1 = r21;
        r7 = r0.c(r7, r1);	 Catch:{ Throwable -> 0x0570 }
        if (r7 == 0) goto L_0x0c71;
    L_0x0c40:
        r6 = 1;
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r8 = -214; // 0xffffffffffffff2a float:NaN double:NaN;
        r7.setDownloadInterruptCode(r8);	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x01ea;
    L_0x0c50:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r7.put(r8, r4);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4.commit();
        goto L_0x01ea;
    L_0x0c71:
        r7 = 0;
        r0 = r30;
        r0.c(r7);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r8 = -313; // 0xfffffffffffffec7 float:NaN double:NaN;
        r7.setDownloadInterruptCode(r8);	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x01ea;
    L_0x0c86:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r7.put(r8, r4);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4.commit();
        goto L_0x01ea;
    L_0x0ca7:
        r8 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r7 == r8) goto L_0x0caf;
    L_0x0cab:
        r8 = 406; // 0x196 float:5.69E-43 double:2.006E-321;
        if (r7 != r8) goto L_0x0ce9;
    L_0x0caf:
        r0 = r30;
        r8 = r0.l;	 Catch:{ Throwable -> 0x0570 }
        r10 = -1;
        r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r8 != 0) goto L_0x0ce9;
    L_0x0cb9:
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r8 = -314; // 0xfffffffffffffec6 float:NaN double:NaN;
        r7.setDownloadInterruptCode(r8);	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x01ea;
    L_0x0cc8:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r7.put(r8, r4);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4.commit();
        goto L_0x01ea;
    L_0x0ce9:
        r8 = 202; // 0xca float:2.83E-43 double:1.0E-321;
        if (r7 != r8) goto L_0x0d10;
    L_0x0ced:
        if (r31 != 0) goto L_0x01c2;
    L_0x0cef:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r9 = java.lang.Long.valueOf(r4);
        r7.put(r8, r9);
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7.commit();
        goto L_0x01c2;
    L_0x0d10:
        r0 = r30;
        r8 = r0.p;	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r9 = r0.B;	 Catch:{ Throwable -> 0x0570 }
        if (r8 >= r9) goto L_0x0d8b;
    L_0x0d1a:
        r8 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;
        if (r7 != r8) goto L_0x0d8b;
    L_0x0d1e:
        r0 = r30;
        r7 = r0.t;	 Catch:{ Throwable -> 0x0570 }
        r8 = "Retry-After";
        r7 = r7.getHeaderField(r8);	 Catch:{ Throwable -> 0x0570 }
        r8 = java.lang.Long.parseLong(r7);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r0.a(r8);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.r;	 Catch:{ Throwable -> 0x0570 }
        if (r7 == 0) goto L_0x0d68;
    L_0x0d38:
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r8 = -309; // 0xfffffffffffffecb float:NaN double:NaN;
        r7.setDownloadInterruptCode(r8);	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x01ea;
    L_0x0d47:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r7.put(r8, r4);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4.commit();
        goto L_0x01ea;
    L_0x0d68:
        if (r31 != 0) goto L_0x01c2;
    L_0x0d6a:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r9 = java.lang.Long.valueOf(r4);
        r7.put(r8, r9);
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7.commit();
        goto L_0x01c2;
    L_0x0d8b:
        r0 = r30;
        r8 = r0.p;	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r9 = r0.B;	 Catch:{ Throwable -> 0x0570 }
        if (r8 >= r9) goto L_0x0e05;
    L_0x0d95:
        r8 = 408; // 0x198 float:5.72E-43 double:2.016E-321;
        if (r7 == r8) goto L_0x0da5;
    L_0x0d99:
        r8 = 504; // 0x1f8 float:7.06E-43 double:2.49E-321;
        if (r7 == r8) goto L_0x0da5;
    L_0x0d9d:
        r8 = 502; // 0x1f6 float:7.03E-43 double:2.48E-321;
        if (r7 == r8) goto L_0x0da5;
    L_0x0da1:
        r8 = 408; // 0x198 float:5.72E-43 double:2.016E-321;
        if (r7 != r8) goto L_0x0e05;
    L_0x0da5:
        r8 = 0;
        r0 = r30;
        r0.a(r8);	 Catch:{ Throwable -> 0x0570 }
        r0 = r30;
        r7 = r0.r;	 Catch:{ Throwable -> 0x0570 }
        if (r7 == 0) goto L_0x0de2;
    L_0x0db2:
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r8 = -309; // 0xfffffffffffffecb float:NaN double:NaN;
        r7.setDownloadInterruptCode(r8);	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x01ea;
    L_0x0dc1:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r7.put(r8, r4);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4.commit();
        goto L_0x01ea;
    L_0x0de2:
        if (r31 != 0) goto L_0x01c2;
    L_0x0de4:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r9 = java.lang.Long.valueOf(r4);
        r7.put(r8, r9);
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7.commit();
        goto L_0x01c2;
    L_0x0e05:
        r8 = r30.k();	 Catch:{ Throwable -> 0x0570 }
        r10 = 0;
        r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r8 > 0) goto L_0x0e41;
    L_0x0e0f:
        r0 = r30;
        r8 = r0.o;	 Catch:{ Throwable -> 0x0570 }
        if (r8 != 0) goto L_0x0e41;
    L_0x0e15:
        r8 = 410; // 0x19a float:5.75E-43 double:2.026E-321;
        if (r7 == r8) goto L_0x0e41;
    L_0x0e19:
        r7 = 1;
        r0 = r30;
        r0.o = r7;	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x01c2;
    L_0x0e20:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r9 = java.lang.Long.valueOf(r4);
        r7.put(r8, r9);
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7.commit();
        goto L_0x01c2;
    L_0x0e41:
        r0 = r30;
        r7 = r0.g;	 Catch:{ Throwable -> 0x0570 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0570 }
        r8 = -315; // 0xfffffffffffffec5 float:NaN double:NaN;
        r7.setDownloadInterruptCode(r8);	 Catch:{ Throwable -> 0x0570 }
        if (r31 != 0) goto L_0x01ea;
    L_0x0e50:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r7.put(r8, r4);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4.commit();
        goto L_0x01ea;
    L_0x0e71:
        r8 = 0;
        r0 = r30;
        r0.a(r8);	 Catch:{ all -> 0x060d }
        r8 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        r0 = r30;
        r7 = r0.a(r7);	 Catch:{ all -> 0x060d }
        r9 = 0;
        r0 = r30;
        r0.a(r8, r7, r9);	 Catch:{ all -> 0x060d }
        r0 = r30;
        r7 = r0.r;	 Catch:{ all -> 0x060d }
        if (r7 == 0) goto L_0x05b8;
    L_0x0e8c:
        r0 = r30;
        r7 = r0.g;	 Catch:{ all -> 0x060d }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ all -> 0x060d }
        r8 = -309; // 0xfffffffffffffecb float:NaN double:NaN;
        r7.setDownloadInterruptCode(r8);	 Catch:{ all -> 0x060d }
        if (r31 != 0) goto L_0x01ea;
    L_0x0e9b:
        r0 = r30;
        r7 = r0.g;
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);
        r7 = r7.a;
        r8 = "tbs_downloadflow";
        r4 = java.lang.Long.valueOf(r4);
        r7.put(r8, r4);
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r4.commit();
        goto L_0x01ea;
    L_0x0ebc:
        r4 = 0;
        goto L_0x020e;
    L_0x0ebf:
        r4 = 2;
        goto L_0x021a;
    L_0x0ec2:
        r0 = r30;
        r4 = r0.v;
        r5 = 0;
        r4.setPatchUpdateFlag(r5);
        goto L_0x021d;
    L_0x0ecc:
        r0 = r30;
        r4 = r0.g;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);
        r5 = -318; // 0xfffffffffffffec2 float:NaN double:NaN;
        r4.setDownloadInterruptCode(r5);
        r4 = 0;
        r0 = r30;
        r0.c(r4);
        goto L_0x023d;
    L_0x0ee1:
        r5 = r4.mPreferences;
        r7 = "tbs_download_failed_retrytimes";
        r8 = 0;
        r5 = r5.getInt(r7, r8);
        r7 = r4.a;
        r8 = "tbs_download_failed_retrytimes";
        r5 = r5 + 1;
        r9 = java.lang.Integer.valueOf(r5);
        r7.put(r8, r9);
        r7 = r4.getDownloadFailedMaxRetrytimes();
        if (r5 != r7) goto L_0x025f;
    L_0x0eff:
        r0 = r30;
        r5 = r0.v;
        r7 = 2;
        r5.setDownloadCancel(r7);
        goto L_0x025f;
    L_0x0f09:
        r4 = 0;
        goto L_0x0269;
    L_0x0f0c:
        r4 = move-exception;
        r6 = r4;
        goto L_0x0610;
    L_0x0f10:
        r7 = move-exception;
        r16 = r4;
        r18 = r8;
        r19 = r9;
        r20 = r10;
        goto L_0x099e;
    L_0x0f1b:
        r7 = move-exception;
        r16 = r4;
        r18 = r8;
        r20 = r10;
        goto L_0x099e;
    L_0x0f24:
        r7 = move-exception;
        r16 = r4;
        r20 = r10;
        goto L_0x099e;
    L_0x0f2b:
        r4 = move-exception;
        r7 = r4;
        goto L_0x099e;
    L_0x0f2f:
        r7 = move-exception;
        goto L_0x0837;
    L_0x0f32:
        r7 = move-exception;
        r8 = r18;
        r9 = r19;
        goto L_0x0837;
    L_0x0f39:
        r7 = move-exception;
        r4 = r16;
        r8 = r18;
        r9 = r19;
        r10 = r20;
        goto L_0x0837;
    L_0x0f44:
        r4 = r10;
        goto L_0x0a6a;
    L_0x0f47:
        r12 = r14;
        r4 = r10;
        goto L_0x0a6a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.ag.b(boolean, boolean):void");
    }

    public void c() {
        this.r = true;
        if (TbsShareManager.isThirdPartyApp(this.g)) {
            TbsLogReport$TbsLogInfo a = TbsLogReport.a(this.g).a();
            a.setErrorCode(-309);
            a.setFailDetail(new Exception());
            if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD_DECOUPLE, a);
            } else {
                TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD, a);
            }
        }
    }

    public void d() {
        c();
        c(false);
        c(true);
    }

    public boolean e() {
        TbsLog.i("TbsDownload", "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.C);
        return this.C;
    }
}
