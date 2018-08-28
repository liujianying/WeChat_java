package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.xwalk.core.XWalkEnvironment;

class o {
    static boolean a = false;
    private static o c = null;
    private static int f = 0;
    private static int g = 0;
    private static int h = 3;
    private static String j = null;
    private bi b = null;
    private boolean d = false;
    private boolean e = false;
    private File i = null;

    private o() {
    }

    public static o a(boolean z) {
        if (c == null && z) {
            synchronized (o.class) {
                if (c == null) {
                    c = new o();
                }
            }
        }
        return c;
    }

    static void a(int i) {
        f = i;
    }

    private void b(int i) {
        String valueOf = String.valueOf(i);
        Properties properties = new Properties();
        properties.setProperty(j, valueOf);
        try {
            properties.store(new FileOutputStream(new File(this.i, "count.prop")), null);
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
        }
    }

    public static int d() {
        return f;
    }

    private int i() {
        Throwable th;
        int i = 0;
        BufferedInputStream bufferedInputStream = null;
        BufferedInputStream bufferedInputStream2;
        try {
            File file = new File(this.i, "count.prop");
            if (file.exists()) {
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    i = Integer.valueOf(properties.getProperty(j, "1")).intValue();
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e) {
                    }
                } catch (Exception e2) {
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            bufferedInputStream2 = null;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e5) {
                }
            }
            return i;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e32) {
                }
            }
            throw th;
        }
        return i;
    }

    public bi a() {
        return this.d ? this.b : null;
    }

    public synchronized void a(Context context, boolean z, boolean z2, am amVar) {
        TbsLog.addLog(XWalkEnvironment.LOCAL_TEST_VERSION, null, new Object[0]);
        TbsLog.initIfNeed(context);
        TbsLog.i("SDKEngine", "init -- context: " + context + ", isPreIniting: " + z2);
        g++;
        if (amVar != null) {
            amVar.b = g == 1;
        }
        TbsCoreLoadStat.getInstance().a();
        if (amVar != null) {
            amVar.a("tbs_rename_task", (byte) 1);
        }
        an.a().b(context, g == 1);
        an.a().k(context);
        if (amVar != null) {
            amVar.a("tbs_rename_task", (byte) 2);
        }
        TbsShareManager.forceToLoadX5ForThirdApp(context, true);
        if (amVar != null) {
            amVar.a("can_load_x5", (byte) 1);
        }
        boolean a = QbSdk.a(context, z, z2);
        if (amVar != null) {
            amVar.a("can_load_x5", (byte) 2);
        }
        boolean z3 = VERSION.SDK_INT >= 7;
        boolean z4 = a && z3;
        if (z4) {
            long currentTimeMillis = System.currentTimeMillis();
            z4 = an.a().c(context, d());
            TbsLog.i("SDKEngine", "isTbsCoreLegal: " + z4 + "; cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (!z4) {
            String str = "can_load_x5=" + a + "; is_compatible=" + z3;
            TbsLog.e("SDKEngine", "SDKEngine.init canLoadTbs=false; failure: " + str);
            if (!(QbSdk.a && this.d)) {
                this.d = false;
                TbsCoreLoadStat.getInstance().a(context, 405, new Throwable(str));
            }
            this.i = an.s(context);
            this.e = true;
        } else if (!this.d) {
            try {
                File q;
                Context e;
                File file;
                File file2;
                if (TbsShareManager.isThirdPartyApp(context)) {
                    TbsLog.addLog(995, null, new Object[0]);
                    if (amVar != null) {
                        amVar.a("read_core_info", (byte) 1);
                    }
                    z4 = TbsShareManager.j(context);
                    if (amVar != null) {
                        amVar.a("read_core_info", (byte) 2);
                    }
                    if (z4) {
                        file2 = new File(TbsShareManager.c(context));
                        q = an.a().q(context);
                        e = TbsShareManager.e(context);
                        if (q == null) {
                            this.d = false;
                            QbSdk.a(context, "SDKEngine::useSystemWebView by error_tbs_core_dexopt_dir null!");
                        } else {
                            file = file2;
                        }
                    } else {
                        this.d = false;
                        QbSdk.a(context, "SDKEngine::useSystemWebView by error_host_unavailable");
                    }
                } else {
                    TbsLog.addLog(996, null, new Object[0]);
                    file2 = an.a().q(context);
                    Object obj = (f == 25436 || f == 25437) ? 1 : null;
                    e = obj != null ? context.getApplicationContext() : context;
                    if (file2 == null) {
                        this.d = false;
                        QbSdk.a(context, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
                    } else {
                        q = file2;
                        file = file2;
                    }
                }
                String[] dexLoaderFileList = QbSdk.getDexLoaderFileList(context, e, file.getAbsolutePath());
                String hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : q.getAbsolutePath();
                TbsLog.i("SDKEngine", "SDKEngine init optDir is " + hostCorePathAppDefined);
                this.b = new bi(context, e, file.getAbsolutePath(), hostCorePathAppDefined, dexLoaderFileList, QbSdk.d, amVar);
                this.d = true;
            } catch (Throwable th) {
                TbsLog.e("SDKEngine", "useSystemWebView by exception: " + th);
                TbsCoreLoadStat.getInstance().a(context, 327, th);
                this.d = false;
                QbSdk.a(context, "SDKEngine::useSystemWebView by exception: " + th);
            }
            this.i = an.s(context);
            this.e = true;
        }
    }

    void a(String str) {
        j = str;
    }

    public boolean b() {
        return this.d;
    }

    boolean b(boolean z) {
        a = z;
        return z;
    }

    bi c() {
        return this.b;
    }

    public String e() {
        return (this.b == null || QbSdk.a) ? "system webview get nothing..." : this.b.a();
    }

    boolean f() {
        if (a) {
            if (j == null) {
                return false;
            }
            int i = i();
            if (i == 0) {
                b(1);
            } else if (i + 1 > h) {
                return false;
            } else {
                b(i + 1);
            }
        }
        return a;
    }

    boolean g() {
        return this.e;
    }

    public boolean h() {
        return QbSdk.useSoftWare();
    }
}
