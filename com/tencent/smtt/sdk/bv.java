package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.j;
import java.nio.channels.FileLock;

class bv {
    private static bv a;
    private static FileLock e = null;
    private bw b;
    private boolean c;
    private boolean d;

    private bv() {
    }

    public static bv a() {
        if (a == null) {
            synchronized (bv.class) {
                if (a == null) {
                    a = new bv();
                }
            }
        }
        return a;
    }

    public bw a(boolean z) {
        return z ? this.b : c();
    }

    public synchronized FileLock a(Context context) {
        FileLock fileLock;
        if (e != null) {
            fileLock = e;
        } else {
            fileLock = j.e(context);
            e = fileLock;
        }
        return fileLock;
    }

    public synchronized void a(Context context, am amVar) {
        Object obj;
        Object obj2 = null;
        synchronized (this) {
            if (amVar != null) {
                amVar.a("x5_core_engine_init_sync", (byte) 2);
            }
            o a = o.a(true);
            a.a(context, false, false, amVar);
            StringBuilder stringBuilder = new StringBuilder();
            if (amVar != null) {
                amVar.a("init_x5_core", (byte) 1);
            }
            bi a2 = a.a();
            if (!a.b() || a2 == null) {
                this.c = false;
                stringBuilder.append("can not use X5 by !tbs available");
                obj = null;
            } else {
                if (!this.d) {
                    if (amVar != null) {
                        amVar.a = true;
                    }
                    this.b = new bw(a2.b());
                    try {
                        this.c = this.b.a();
                        if (!this.c) {
                            stringBuilder.append("can not use X5 by x5corewizard return false");
                        }
                        obj = null;
                    } catch (NoSuchMethodException e) {
                        this.c = true;
                        obj = null;
                    } catch (Throwable th) {
                        obj = th;
                        this.c = false;
                        stringBuilder.append("can not use x5 by throwable " + Log.getStackTraceString(obj));
                    }
                    if (this.c) {
                        CookieManager.getInstance().a(context, true, true);
                        CookieManager.getInstance().a();
                    }
                }
                obj = null;
            }
            if (!this.c) {
                TbsLog.e("X5CoreEngine", "mCanUseX5 is false --> report");
                if (a.b() && a2 != null && obj == null) {
                    try {
                        DexLoader b = a2.b();
                        if (b != null) {
                            obj2 = b.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                        }
                        if (obj2 instanceof Throwable) {
                            Throwable th2 = (Throwable) obj2;
                            stringBuilder.append("#" + th2.getMessage() + "; cause: " + th2.getCause() + "; th: " + th2);
                        }
                        if (obj2 instanceof String) {
                            stringBuilder.append("failure detail:" + obj2);
                        }
                    } catch (Throwable th3) {
                    }
                    if (stringBuilder.toString().contains("isPreloadX5Disabled:-10000")) {
                        TbsCoreLoadStat.getInstance().a(context, TbsListener$ErrorCode.INFO_CAN_NOT_DISABLED_BY_CRASH, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + stringBuilder.toString()));
                    } else {
                        TbsCoreLoadStat.getInstance().a(context, TbsListener$ErrorCode.INFO_CAN_NOT_LOAD_X5, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + stringBuilder.toString()));
                    }
                } else if (a.b()) {
                    TbsCoreLoadStat.getInstance().a(context, TbsListener$ErrorCode.INFO_CAN_NOT_USE_X5_TBS_AVAILABLE, new Throwable("mCanUseX5=false, available true, reason: " + obj));
                } else {
                    TbsCoreLoadStat.getInstance().a(context, TbsListener$ErrorCode.INFO_CAN_NOT_USE_X5_TBS_NOTAVAILABLE, new Throwable("mCanUseX5=false, available false, reason: " + obj));
                }
            } else if (e == null) {
                a(context);
            }
            this.d = true;
            if (amVar != null) {
                amVar.a("init_x5_core", (byte) 2);
            }
        }
    }

    public boolean b() {
        return QbSdk.a ? false : this.c;
    }

    public bw c() {
        return QbSdk.a ? null : this.b;
    }

    boolean d() {
        return this.d;
    }
}
