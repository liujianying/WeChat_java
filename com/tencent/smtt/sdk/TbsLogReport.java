package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.m;
import com.tencent.smtt.utils.n;
import com.tencent.smtt.utils.r;
import com.tencent.smtt.utils.s;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

class TbsLogReport {
    private static TbsLogReport a;
    private Handler b = null;
    private Context c;
    private boolean d = false;

    private TbsLogReport(Context context) {
        this.c = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("TbsLogReportThread");
        handlerThread.start();
        this.b = new ax(this, handlerThread.getLooper());
    }

    public static TbsLogReport a(Context context) {
        if (a == null) {
            synchronized (TbsLogReport.class) {
                if (a == null) {
                    a = new TbsLogReport(context);
                }
            }
        }
        return a;
    }

    private String a(int i) {
        return i + "|";
    }

    private String a(long j) {
        String str = null;
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
        } catch (Exception e) {
            return str;
        }
    }

    private String a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = "";
        }
        return stringBuilder.append(str).append("|").toString();
    }

    private void a(int i, TbsLogInfo tbsLogInfo) {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a(i));
        stringBuilder.append(a(b.c(this.c)));
        stringBuilder.append(a(r.a(this.c)));
        stringBuilder.append(a(an.a().m(this.c)));
        String str2 = Build.MODEL;
        try {
            str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e) {
            str = str2;
        }
        stringBuilder.append(a(str));
        str = this.c.getPackageName();
        stringBuilder.append(a(str));
        if ("com.tencent.mm".equals(str)) {
            stringBuilder.append(a(b.a(this.c, "com.tencent.mm.BuildInfo.CLIENT_VERSION")));
        } else {
            stringBuilder.append(a(b.b(this.c)));
        }
        stringBuilder.append(a(a(TbsLogInfo.a(tbsLogInfo))));
        stringBuilder.append(a(TbsLogInfo.b(tbsLogInfo)));
        stringBuilder.append(a(TbsLogInfo.c(tbsLogInfo)));
        stringBuilder.append(a(TbsLogInfo.d(tbsLogInfo)));
        stringBuilder.append(a(TbsLogInfo.e(tbsLogInfo)));
        stringBuilder.append(a(TbsLogInfo.f(tbsLogInfo)));
        stringBuilder.append(a(TbsLogInfo.g(tbsLogInfo)));
        stringBuilder.append(a(TbsLogInfo.h(tbsLogInfo)));
        stringBuilder.append(a(TbsLogInfo.i(tbsLogInfo)));
        stringBuilder.append(a(TbsLogInfo.j(tbsLogInfo)));
        stringBuilder.append(b(TbsLogInfo.k(tbsLogInfo)));
        stringBuilder.append(b(TbsLogInfo.l(tbsLogInfo)));
        stringBuilder.append(b(TbsLogInfo.m(tbsLogInfo)));
        stringBuilder.append(a(TbsLogInfo.n(tbsLogInfo)));
        stringBuilder.append(a(tbsLogInfo.a));
        stringBuilder.append(a(TbsLogInfo.o(tbsLogInfo)));
        stringBuilder.append(a(TbsLogInfo.p(tbsLogInfo)));
        stringBuilder.append(a(TbsDownloadConfig.getInstance(this.c).mPreferences.getInt("tbs_download_version", 0)));
        stringBuilder.append(a(b.f(this.c)));
        stringBuilder.append(a("3.6.0.1240_43610"));
        stringBuilder.append(false);
        SharedPreferences i2 = i();
        JSONArray f = f();
        JSONArray jSONArray = new JSONArray();
        if (jSONArray.length() >= 5) {
            for (int i3 = 4; i3 > 0; i3--) {
                try {
                    jSONArray.put(f.get(jSONArray.length() - i3));
                } catch (Exception e2) {
                    TbsLog.e("upload", "JSONArray transform error!");
                }
            }
        } else {
            jSONArray = f;
        }
        jSONArray.put(stringBuilder.toString());
        Editor edit = i2.edit();
        edit.putString("tbs_download_upload", jSONArray.toString());
        edit.commit();
        if (this.d || i != EventType.TYPE_LOAD.a) {
            g();
        }
    }

    private void a(int i, TbsLogInfo tbsLogInfo, EventType eventType) {
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        QbSdk.m.onInstallFinish(i);
        a(eventType, tbsLogInfo);
    }

    private String b(long j) {
        return j + "|";
    }

    private JSONArray f() {
        String string = i().getString("tbs_download_upload", null);
        if (string == null) {
            return new JSONArray();
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() <= 5) {
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length() - 1;
            if (length <= jSONArray.length() - 5) {
                return jSONArray;
            }
            jSONArray2.put(jSONArray.get(length));
            return jSONArray2;
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    private void g() {
        if (QbSdk.n != null && QbSdk.n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i("upload", "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return;
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat]");
        JSONArray f = f();
        if (f == null || f.length() == 0) {
            TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] no data");
            return;
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + f);
        try {
            TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] response:" + m.a(s.a(this.c).c(), f.toString().getBytes("utf-8"), new az(this), true) + " testcase: -1");
        } catch (Throwable th) {
        }
    }

    private void h() {
        Editor edit = i().edit();
        edit.remove("tbs_download_upload");
        edit.commit();
    }

    private SharedPreferences i() {
        return this.c.getSharedPreferences("tbs_download_stat", 4);
    }

    public TbsLogInfo a() {
        return new TbsLogInfo(null);
    }

    public void a(int i, String str) {
        a(i, str, EventType.TYPE_INSTALL);
    }

    public void a(int i, String str, EventType eventType) {
        if (!(i == 200 || i == 220 || i == 221)) {
            TbsLog.i("TbsDownload", "error occured in installation, errorCode:" + i, true);
        }
        TbsLogInfo a = a();
        a.setFailDetail(str);
        a(i, a, eventType);
    }

    public void a(int i, Throwable th) {
        TbsLogInfo a = a();
        a.setFailDetail(th);
        a(i, a, EventType.TYPE_INSTALL);
    }

    public void a(EventType eventType, TbsLogInfo tbsLogInfo) {
        try {
            TbsLogInfo tbsLogInfo2 = (TbsLogInfo) tbsLogInfo.clone();
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.what = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_INTERRUPTED;
            obtainMessage.arg1 = eventType.a;
            obtainMessage.obj = tbsLogInfo2;
            this.b.sendMessage(obtainMessage);
        } catch (Throwable th) {
            TbsLog.w("upload", "[TbsLogReport.eventReport] error, message=" + th.getMessage());
        }
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void b() {
        this.b.sendEmptyMessage(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CONNECT_TIMEOUT);
    }

    public void b(int i, String str) {
        TbsLogInfo a = a();
        a.setErrorCode(i);
        a.setEventTime(System.currentTimeMillis());
        a.setFailDetail(str);
        a(EventType.TYPE_LOAD, a);
    }

    public void b(int i, Throwable th) {
        String str = "NULL";
        if (th != null) {
            str = "msg: " + th.getMessage() + "; err: " + th + "; cause: " + Log.getStackTraceString(th.getCause());
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
        }
        b(i, str);
    }

    public void c() {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        if (QbSdk.n != null && QbSdk.n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i("upload", "[TbsLogReport.reportTbsLog] -- SET_SENDREQUEST_AND_UPLOAD is false");
        } else if (Apn.getApnType(this.c) == 3) {
            String tbsLogFilePath = TbsLog.getTbsLogFilePath();
            if (tbsLogFilePath != null) {
                String b = n.a().b();
                String c = b.c(this.c);
                String f = b.f(this.c);
                byte[] bytes = c.getBytes();
                byte[] bytes2 = f.getBytes();
                try {
                    bytes = n.a().a(bytes);
                    bytes2 = n.a().a(bytes2);
                } catch (Exception e) {
                }
                String b2 = n.b(bytes);
                String str = s.a(this.c).e() + b2 + "&aid=" + n.b(bytes2);
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Charset", "UTF-8");
                hashMap.put("QUA2", r.a(this.c));
                File file;
                FileInputStream fileInputStream;
                ByteArrayOutputStream byteArrayOutputStream2;
                try {
                    File file2 = new File(j.a);
                    new a(tbsLogFilePath, j.a + "/tbslog_temp.zip").a();
                    file = new File(j.a, "tbslog_temp.zip");
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            bytes2 = new byte[8192];
                            byteArrayOutputStream2 = new ByteArrayOutputStream();
                            while (true) {
                                try {
                                    int read = fileInputStream.read(bytes2);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream2.write(bytes2, 0, read);
                                } catch (Exception e2) {
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Exception e3) {
                                        }
                                    }
                                    if (byteArrayOutputStream2 != null) {
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Exception e4) {
                                        }
                                    }
                                    if (file != null) {
                                        file.delete();
                                    }
                                    throw th;
                                }
                            }
                            byteArrayOutputStream2.flush();
                            bytes2 = n.a().a(byteArrayOutputStream2.toByteArray());
                            try {
                                fileInputStream.close();
                            } catch (Exception e5) {
                            }
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception e6) {
                            }
                            file.delete();
                        } catch (Exception e7) {
                            byteArrayOutputStream = null;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e8) {
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception e9) {
                                }
                            }
                            if (file != null) {
                                file.delete();
                                bytes2 = null;
                            } else {
                                bytes2 = null;
                            }
                            m.a(str + "&ek=" + b, hashMap, bytes2, new ay(this), false);
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream2 = null;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e32) {
                                }
                            }
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Exception e42) {
                                }
                            }
                            if (file != null) {
                                file.delete();
                            }
                            throw th;
                        }
                    } catch (Exception e10) {
                        byteArrayOutputStream = null;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e82) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e92) {
                            }
                        }
                        if (file != null) {
                            bytes2 = null;
                        } else {
                            file.delete();
                            bytes2 = null;
                        }
                        m.a(str + "&ek=" + b, hashMap, bytes2, new ay(this), false);
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayOutputStream2 = null;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e322) {
                            }
                        }
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception e422) {
                            }
                        }
                        if (file != null) {
                            file.delete();
                        }
                        throw th;
                    }
                } catch (Exception e11) {
                    byteArrayOutputStream = null;
                    file = null;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e822) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e922) {
                        }
                    }
                    if (file != null) {
                        file.delete();
                        bytes2 = null;
                    } else {
                        bytes2 = null;
                    }
                    m.a(str + "&ek=" + b, hashMap, bytes2, new ay(this), false);
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream2 = null;
                    file = null;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e3222) {
                        }
                    }
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e4222) {
                        }
                    }
                    if (file != null) {
                        file.delete();
                    }
                    throw th;
                }
                m.a(str + "&ek=" + b, hashMap, bytes2, new ay(this), false);
            }
        }
    }

    public void d() {
        try {
            Editor edit = i().edit();
            edit.clear();
            edit.commit();
        } catch (Exception e) {
        }
    }

    public boolean e() {
        return this.d;
    }
}
