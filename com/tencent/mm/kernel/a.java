package com.tencent.mm.kernel;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mm.a.g;
import com.tencent.mm.a.h;
import com.tencent.mm.a.o;
import com.tencent.mm.ab.x;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.by;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.at;
import com.tencent.mm.model.av;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.w;
import com.tencent.mm.vfs.RC4EncryptedFileSystem;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

public final class a {
    private static int dpA = -1;
    private static boolean dpm = true;
    private static boolean dpn = false;
    static b dpp = new b();
    private static String dpq = "NoResetUinStack";
    private static String dpr = null;
    long dpB;
    private volatile int dpC = a.dpH;
    public volatile boolean dpD = false;
    private String dpE = "";
    private Map<String, Integer> dpF = new HashMap();
    private c dpk;
    private x dpl;
    byte[] dpo = new byte[0];
    public com.tencent.mm.model.a dps;
    public e.c dpt;
    public int dpu;
    public boolean dpv = false;
    private boolean dpw = false;
    public int dpx = 0;
    public int dpy;
    public List<aq> dpz = new LinkedList();

    private enum a {
        ;

        static {
            dpH = 1;
            dpI = 2;
            dpJ = new int[]{dpH, dpI};
        }
    }

    static final class b {
        private static boolean dpM = true;
        private boolean dpK = false;
        private w dpL;
        private int uin = 0;

        b() {
        }

        private synchronized int Df() {
            if (!this.dpK) {
                DC();
                this.dpK = true;
            }
            return this.uin;
        }

        public final synchronized void a(w wVar) {
            this.dpL = wVar;
        }

        private synchronized void eK(int i) {
            com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "Uin From %s To %s hash:%d thread:%d[%s] stack:%s", o.getString(this.uin), o.getString(i), Integer.valueOf(h.aM(i, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bi.cjd());
            Assert.assertNotNull(this.dpL);
            a(this.dpL, i);
            this.uin = i;
        }

        private synchronized void DC() {
            int i = 0;
            synchronized (this) {
                Assert.assertNotNull(this.dpL);
                w wVar = this.dpL;
                if (wVar == null) {
                    com.tencent.mm.sdk.platformtools.x.w("MMKernel.CoreAccount", "summer read detault uin exception sysCfg is null!");
                } else {
                    Integer num = (Integer) wVar.get(1);
                    if (num == null) {
                        if (wVar.sOk) {
                            f.mDy.a(148, 40, 1, false);
                        }
                        Integer valueOf = Integer.valueOf(ad.getContext().getSharedPreferences("system_config_prefs", 4).getInt("default_uin", 0));
                        if (valueOf != null) {
                            com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "summer read detault uin[%d], bakUin[%d] sysCfg.isOpenException[%b]", num, valueOf, Boolean.valueOf(wVar.sOk));
                            if (dpM) {
                                com.tencent.mm.sdk.platformtools.x.w("MMKernel.CoreAccount", "summer read detault uin exception backup uin[%d], stack[%s]", valueOf, bi.cjd());
                                f.mDy.h(11911, Integer.valueOf(bi.f(valueOf)));
                                dpM = false;
                            }
                            a(wVar, valueOf.intValue());
                            num = valueOf;
                        }
                    }
                    com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "summer getDefaultUin uin[%d]", Integer.valueOf(bi.f(num)));
                    i = bi.f(num);
                }
                this.uin = i;
            }
        }

        private static void a(w wVar, int i) {
            com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "setSysUin uin: %d, stack: %s", Integer.valueOf(i), bi.cjd());
            ad.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("default_uin", i).commit();
            wVar.set(1, Integer.valueOf(i));
        }
    }

    public a(c cVar) {
        Assert.assertNotNull(dpp);
        g.Ek();
        dpm = bi.f((Integer) g.Ei().dqk.get(17)) != 0;
        com.tencent.mm.protocal.i.c.a.qWj = new av(HardCoderJNI.SCENE_ALBUM_SCROLL);
        this.dpk = cVar;
    }

    public static int Df() {
        return dpp.Df();
    }

    public static String Dg() {
        return new o(dpp.Df()).toString();
    }

    public static String Dh() {
        return dpr;
    }

    public static String gb(String str) {
        dpr = str;
        return str;
    }

    public static String Di() {
        return dpq;
    }

    public static void gc(String str) {
        dpq = str;
    }

    static boolean gG(int i) {
        return i != 0;
    }

    protected static void Dj() {
        dpp.eK(0);
    }

    protected static void Dk() {
        dpp.eK(0);
    }

    private void Dl() {
        this.dpC = a.dpH;
        this.dpD = false;
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "mAccountStatus to NotReady");
        ad.getContext().getSharedPreferences(ad.chY(), 0).edit().putBoolean("isLogin", false).commit();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        com.tencent.mm.sdk.platformtools.x.w("MMKernel.CoreAccount", "[arthurdan.AccountNR] account storage reset! uin:%d, resetStack is:%s, resetTime:%s", Integer.valueOf(dpp.Df()), dpq, simpleDateFormat.format(new Date()));
    }

    final void Dm() {
        com.tencent.mm.sdk.platformtools.x.w("MMKernel.CoreAccount", "account storage release  uin:%s thread:%s stack:%s", o.getString(dpp.Df()), Thread.currentThread().getName(), bi.cjd());
        if (Dx()) {
            this.dpk.onAccountRelease();
            g.Ek();
            g.Ei().ex(null);
            Dl();
            g.Ek();
            g.Ei().dqy.clear();
            return;
        }
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "Fatal crash error!!! status is not initialized when release(), this callStack is:%s, last reset stack is:%s", bi.cjd().toString(), dpq);
    }

    final void bs(boolean z) {
        boolean z2;
        int cij;
        if (!z) {
            z2 = HardCoderJNI.hcBootEnable;
            int i = HardCoderJNI.hcBootDelay;
            int i2 = HardCoderJNI.hcBootCPU;
            int i3 = HardCoderJNI.hcBootIO;
            if (HardCoderJNI.hcBootThr) {
                cij = g.Em().cij();
            } else {
                cij = 0;
            }
            this.dpu = HardCoderJNI.startPerformance(z2, i, i2, i3, cij, HardCoderJNI.hcBootTimeout, 101, HardCoderJNI.hcBootAction, "MMKernel.CoreAccount");
            com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "summerhardcoder startPerformance[%s] stack[%s]", Integer.valueOf(this.dpu), bi.cjd());
        }
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "UserStatusChange: clear");
        synchronized (this.dpz) {
            this.dpz.clear();
        }
        long currentTimeMillis = System.currentTimeMillis();
        int a = dpp.Df();
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "dkacc setAccuin %s hash:%d thread:%d[%s] stack:%s", o.getString(a), Integer.valueOf(h.aM(a, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bi.cjd());
        if ((a != 0 ? 1 : null) == null) {
            com.tencent.mm.sdk.platformtools.x.w("MMKernel.CoreAccount", "setAccUin, Reset by MMCore.resetAccUin");
        } else {
            boolean z3;
            long currentTimeMillis2;
            o.getString(a);
            g.Ek();
            e Ei = g.Ei();
            Runnable anonymousClass1 = new Runnable() {
                public final void run() {
                    a.this.dpC = a.dpI;
                }
            };
            ad.getContext().getSharedPreferences(ad.chY(), 0).edit().putBoolean("isLogin", true).commit();
            String u = g.u(("mm" + a).getBytes());
            Ei.dqp = Ei.dqo + u + "/";
            Ei.cachePath = aa.duN + u + "/";
            File file = new File(Ei.cachePath);
            com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "dkacc cachePath:" + Ei.cachePath + " accPath:" + Ei.dqp);
            if (file.exists()) {
                z3 = false;
            } else {
                com.tencent.mm.sdk.platformtools.x.w("MMKernel.CoreStorage", "setUin REBUILD data now ! DO NOT FUCKING TELL ME DB BROKEN !!! uin:%s data:%s sd:%s", o.getString(a), Ei.cachePath, Ei.dqp);
                file.mkdirs();
                if (!Ei.cachePath.equalsIgnoreCase(Ei.dqp)) {
                    currentTimeMillis2 = System.currentTimeMillis();
                    new File(Ei.dqp).renameTo(new File(e.bnE + (u + "temp" + System.currentTimeMillis())));
                    com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "find the old files and rename then %s" + (System.currentTimeMillis() - currentTimeMillis2), u);
                }
                z3 = true;
            }
            Ei.dqx = new cb(Ei.cachePath, z3);
            Ei.DO();
            u = Ei.cachePath + "MicroMsg.db";
            String str = Ei.cachePath + "EnMicroMsg.db";
            String str2 = Ei.cachePath + "EnMicroMsg2.db";
            Ei.ex(null);
            Ei.gg(str);
            Ei.dqq = new com.tencent.mm.bt.h(new com.tencent.mm.bt.h.a() {
                public final void Ea() {
                    if (e.this.dqs != null) {
                        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "summer preCloseCallback userConfigStg: " + e.this.dqs);
                        e.this.dqs.lm(true);
                    }
                    e.this.dqm.Ea();
                }

                public final void Eb() {
                    e.this.dqm.Eb();
                }

                public final void Ec() {
                    e.this.dqm.Ec();
                }
            });
            if (Ei.dqq.a(u, str, str2, (long) a, q.zy(), e.Ci(), true)) {
                String str3 = Ei.dqq.tdP;
                if (!bi.oW(str3)) {
                    com.tencent.mm.sdk.platformtools.x.e("MMKernel.CoreStorage", "dbinit failed :" + str3);
                    com.tencent.mm.sdk.a.b.A("init db Failed: [ " + str3 + "]", "DBinit");
                }
                com.tencent.mm.bt.h hVar = Ei.dqq;
                if (hVar.tdM != null ? hVar.tdM.tdo : false) {
                    Ei.dqw = true;
                }
                Ei.dqs = new com.tencent.mm.storage.x(Ei.dqq);
                Ei.dqu = new bt(Ei.dqq);
                Ei.dqq.tdO = new com.tencent.mm.bt.h.e() {
                    public final void Ed() {
                        if (e.this.dqu != null) {
                            e.this.dqu.dCZ.fV("TablesVersion", "delete * from TablesVersion");
                        } else {
                            com.tencent.mm.sdk.platformtools.x.e("MMKernel.CoreStorage", "tablesVersionStorage is null");
                        }
                    }
                };
                Ei.dqv = Ei.dqu.cnb();
                Ei.dqr = new com.tencent.mm.bt.h(Ei.dqn);
                if (Ei.dqr.a(u, str, str2, (long) a, q.zy(), new HashMap(), true)) {
                    Ei.dqt = new bn(Ei.dqs);
                    Ei.dqt.c(new com.tencent.mm.sdk.e.j.a() {
                        public final void a(String str, l lVar) {
                            q.fd(str);
                        }
                    });
                    Ei.dqt.cmW();
                    anonymousClass1.run();
                    if (z3) {
                        currentTimeMillis2 = ((Long) Ei.dqs.get(com.tencent.mm.storage.aa.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0))).longValue();
                        int intValue = ((Integer) Ei.dqs.get(com.tencent.mm.storage.aa.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0))).intValue();
                        if (currentTimeMillis2 > 0) {
                            com.tencent.mm.sdk.platformtools.x.w("MMKernel.CoreStorage", "summerinstall new install but firsttime[%d] > 0", Long.valueOf(currentTimeMillis2));
                        } else {
                            Ei.dqs.a(com.tencent.mm.storage.aa.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
                        }
                        if (intValue > 0) {
                            com.tencent.mm.sdk.platformtools.x.w("MMKernel.CoreStorage", "summerinstall new install but version[%d] > 0", Integer.valueOf(intValue));
                        } else {
                            Ei.dqs.a(com.tencent.mm.storage.aa.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(d.qVN));
                        }
                        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "edw setAccUin, summerinstall time[%d]，version[%d], clientversion[%d]", (Long) Ei.dqs.get(com.tencent.mm.storage.aa.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0)), (Integer) Ei.dqs.get(com.tencent.mm.storage.aa.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0)), Integer.valueOf(d.qVN));
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    g.Eg();
                    byte[] v = g.v(stringBuilder.append(Dg()).append("mmbiz").toString().getBytes());
                    com.tencent.mm.vfs.a.a aVar = new com.tencent.mm.vfs.a.a(com.tencent.mm.vfs.a.cBR(), (byte) 0);
                    aVar.cBT();
                    aVar.uRY.clear();
                    aVar.uSf.clear();
                    aVar.uSa = com.tencent.mm.vfs.a.uRX;
                    RC4EncryptedFileSystem rC4EncryptedFileSystem = new RC4EncryptedFileSystem(Ei.dqp + "bizmsg", v);
                    aVar.cBT();
                    aVar.uRY.put("bizmsg", rC4EncryptedFileSystem);
                    str3 = Ei.dqp + "bizmsg";
                    aVar.cBT();
                    aVar.uSf.put(com.tencent.mm.vfs.a.abN(str3), "bizmsg");
                    aVar.cBT();
                    com.tencent.mm.vfs.a.a(aVar.uSd, aVar.uRY, aVar.uSf, aVar.uSa);
                    aVar.uRY = null;
                    aVar.uSf = null;
                    aVar.uSa = null;
                    if (!z) {
                        Object obj;
                        g.Ek();
                        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "summerinit validateUsername username[%s]", bi.oV((String) g.Ei().DT().get(2, null)));
                        if (bi.oV((String) g.Ei().DT().get(2, null)).length() <= 0) {
                            com.tencent.mm.sdk.platformtools.x.e("MMKernel.CoreAccount", "username of acc stg not set: uin=" + dpp.Df());
                            Dl();
                            dpp.eK(0);
                            dpq = bi.cjd().toString();
                            ah.A(new Runnable() {
                                public final void run() {
                                    g.Ek().releaseAll();
                                }
                            });
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj == null) {
                            f.mDy.a(598, 21, 1, true);
                            com.tencent.mm.sdk.platformtools.x.w("MMKernel.CoreAccount", "setAccUin, validateUsername false no need initialize!");
                        }
                    }
                    com.tencent.mm.sdk.b.a.sFg.m(new bz());
                    g.Ek();
                    e Ei2 = g.Ei();
                    e.c cVar = new e.c();
                    cij = bi.f((Integer) Ei2.dqs.get(14, null));
                    int i4 = d.qVN;
                    boolean z4 = i4 == cij ? false : (i4 <= 570425344 || cij > 570425344) ? i4 > 570556456 && cij <= 570556456 : true;
                    if (z4) {
                        Ei2.dqs.set(8197, "");
                        Ei2.dqs.set(15, Integer.valueOf(0));
                    }
                    z2 = cij != i4;
                    if (cij > 620822536 || cij == i4) {
                        Ei2.dqs.set(274480, Boolean.valueOf(false));
                        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "[initialize] need not init emoji");
                    } else {
                        Ei2.dqs.set(274480, Boolean.valueOf(true));
                        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreStorage", "[initialize] need init emoji");
                    }
                    if (cij != 0 && cij < 637599744) {
                        Ei2.dqs.set(348162, Boolean.valueOf(true));
                    }
                    if ((cij != i4 ? 1 : null) != null) {
                        com.tencent.mm.sdk.platformtools.x.w("MMKernel.CoreStorage", "account storage version changed from " + Integer.toHexString(cij) + " to " + Integer.toHexString(i4) + ", init=" + z4);
                        if (((Integer) Ei2.dqk.get(37, Integer.valueOf(0))).intValue() == 0) {
                            Ei2.dqk.set(37, Integer.valueOf(cij));
                        }
                        Ei2.dqs.set(30, Boolean.valueOf(false));
                        Ei2.dqs.set(-2046825377, Boolean.valueOf(false));
                        Ei2.dqs.set(-2046825369, Boolean.valueOf(false));
                        Ei2.dqs.set(54, Boolean.valueOf(false));
                        Ei2.dqs.set(-2046825368, Boolean.valueOf(false));
                        Ei2.dqs.set(-2046825366, Boolean.valueOf(true));
                        Ei2.dqs.set(62, Boolean.valueOf(true));
                        ad.getContext().getSharedPreferences("update_config_prefs", 4).edit().clear().commit();
                        if ((cij & -256) == (i4 & -256)) {
                            af.Wp("show_whatsnew");
                        }
                    }
                    cVar.dqH = z2;
                    cVar.dqI = cij;
                    this.dpt = cVar;
                    com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "check is update :%b ", Boolean.valueOf(cVar.dqH));
                    this.dpw = true;
                    if (!this.dpv) {
                        Dn();
                        g.Eg().Dy();
                    }
                    at.dBv.T("last_login_uin", o.getString(a));
                    f.mDy.eK(a);
                    u = "MMKernel.CoreAccount";
                    str = "SmcLogic.setUin, class loader %s, %s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(getClass().getClassLoader() == null ? -1 : getClass().getClassLoader().hashCode());
                    objArr[1] = Integer.valueOf(Thread.currentThread().getContextClassLoader() == null ? -1 : Thread.currentThread().getContextClassLoader().hashCode());
                    com.tencent.mm.sdk.platformtools.x.i(u, str, objArr);
                    this.dps = new com.tencent.mm.model.a();
                    com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "setAccUin done :%s", o.getString(a));
                    g.Ek();
                    if (g.Eh().dpP != null) {
                        g.Ek();
                        if (g.Eh().dpP.dJs != null) {
                            g.Ek();
                            g.Eh().dpP.dJs.bD(true);
                            g.Ek();
                            com.tencent.mm.network.c Lr = g.Eh().dpP.dJs.Lr();
                            if (!(a == 0 || Lr == null || a == Lr.Df())) {
                                com.tencent.mm.sdk.platformtools.x.w("MMKernel.CoreAccount", "summerauth update acc info with acc stg: old acc uin=%d, this uin=%d", Integer.valueOf(Lr.Df()), Integer.valueOf(a));
                                f.mDy.a(148, 46, 1, false);
                                Lr.eK(a);
                            }
                        }
                    }
                } else {
                    throw new com.tencent.mm.model.b((byte) 0);
                }
            }
            throw new SQLiteException("main db init failed");
        }
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "start time check setUinImpl end total time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "mAccountStatus to AccountHasReady");
    }

    public final void Dn() {
        if (this.dpw) {
            this.dpw = false;
            com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized tid:%d, stack[%s]", Long.valueOf(Thread.currentThread().getId()), bi.cjd());
            long currentTimeMillis = System.currentTimeMillis();
            this.dpk.onAccountInitialized(this.dpt);
            com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            Do();
            return;
        }
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "no need do account initialized notify.");
    }

    public final void Do() {
        if (Dx() && com.tencent.mm.kernel.a.c.Et().drB) {
            com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "Flush client version.");
            g.Ei().dqs.set(14, Integer.valueOf(d.qVN));
        }
    }

    public final synchronized x Dp() {
        if (this.dpl == null) {
            this.dpl = new x();
        }
        return this.dpl;
    }

    public static boolean Dq() {
        return dpn;
    }

    public static void bt(boolean z) {
        dpn = z;
    }

    public static boolean Dr() {
        if (dpm) {
            String string;
            String str = "MMKernel.CoreAccount";
            String str2 = "account holded :%s init:%b";
            Object[] objArr = new Object[2];
            g.Ek();
            if (g.Eg() != null) {
                g.Ek();
                g.Eg();
                string = o.getString(dpp.Df());
            } else {
                string = "-1";
            }
            objArr[0] = string;
            objArr[1] = Boolean.valueOf(g.Eg().Dx());
            com.tencent.mm.sdk.platformtools.x.w(str, str2, objArr);
        }
        return dpm;
    }

    public static void hold() {
        String string;
        String str = "MMKernel.CoreAccount";
        String str2 = " HOLD ACCOUNT! uin:%s stack:%s init:%b";
        Object[] objArr = new Object[3];
        g.Ek();
        if (g.Eg() != null) {
            g.Ek();
            g.Eg();
            string = o.getString(dpp.Df());
        } else {
            string = "-1";
        }
        objArr[0] = string;
        objArr[1] = bi.cjd();
        objArr[2] = Boolean.valueOf(g.Eg().Dx());
        com.tencent.mm.sdk.platformtools.x.w(str, str2, objArr);
        dpm = true;
        g.Ek();
        g.Ei().dqk.set(17, Integer.valueOf(1));
    }

    public static void unhold() {
        String string;
        String str = "MMKernel.CoreAccount";
        String str2 = " UN HOLD ACCOUNT! uin:%s init:%b";
        Object[] objArr = new Object[2];
        g.Ek();
        if (g.Eg() != null) {
            g.Ek();
            g.Eg();
            string = o.getString(dpp.Df());
        } else {
            string = "-1";
        }
        objArr[0] = string;
        objArr[1] = Boolean.valueOf(g.Eg().Dx());
        com.tencent.mm.sdk.platformtools.x.w(str, str2, objArr);
        dpm = false;
        g.Ek();
        g.Ei().dqk.set(17, Integer.valueOf(0));
    }

    public final void Ds() {
        if (!Dx()) {
            throw new com.tencent.mm.model.b();
        }
    }

    public final void Dt() {
        new ag(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                aq[] aqVarArr = new aq[a.this.dpz.size()];
                a.this.dpz.toArray(aqVarArr);
                for (aq HK : aqVarArr) {
                    HK.HK();
                }
            }
        });
    }

    public final void aW(int i, int i2) {
        int i3 = (this.dpx == i && this.dpy == i2) ? 0 : 1;
        com.tencent.mm.sdk.platformtools.x.d("MMKernel.CoreAccount", "online status, %d, %d, %d ,%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.dpy), Integer.valueOf(this.dpx));
        if (i3 != 0) {
            this.dpx = i;
            this.dpy = i2;
            new ag(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    a.this.Dt();
                }
            });
        }
    }

    public static void gH(int i) {
        if (dpA == -1 || dpA != i) {
            dpA = i;
            Dv().edit().putInt("notification.user.state", i).commit();
            com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "[NOTIFICATION SETTINGS]save UserStatus: %d", Integer.valueOf(i));
        }
    }

    public static int Du() {
        return Dv().getInt("notification.user.state", 0);
    }

    public static SharedPreferences Dv() {
        return ad.getContext().getSharedPreferences("notify_key_pref_settings", 4);
    }

    public static boolean gI(int i) {
        return (i & 1) != 0;
    }

    public final void release() {
        synchronized (this.dpo) {
            Dm();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize() {
        /*
        r6 = this;
        r0 = r6.Dx();
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r1 = r6.dpo;
        monitor-enter(r1);
        r0 = r6.Dx();	 Catch:{ all -> 0x0012 }
        if (r0 == 0) goto L_0x0015;
    L_0x0010:
        monitor-exit(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x0006;
    L_0x0012:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0012 }
        throw r0;
    L_0x0015:
        r0 = dpp;	 Catch:{ all -> 0x0012 }
        r0 = r0.Df();	 Catch:{ all -> 0x0012 }
        if (r0 == 0) goto L_0x0041;
    L_0x001d:
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0012 }
        r6.dpB = r2;	 Catch:{ all -> 0x0012 }
        r2 = "MMKernel.CoreAccount";
        r3 = "auto set up account storage uin: %d, stack: %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0012 }
        r5 = 0;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x0012 }
        r4[r5] = r0;	 Catch:{ all -> 0x0012 }
        r0 = 1;
        r5 = com.tencent.mm.sdk.platformtools.bi.cjd();	 Catch:{ all -> 0x0012 }
        r4[r0] = r5;	 Catch:{ all -> 0x0012 }
        com.tencent.mm.sdk.platformtools.x.w(r2, r3, r4);	 Catch:{ all -> 0x0012 }
        r0 = 0;
        r6.bs(r0);	 Catch:{ all -> 0x0012 }
    L_0x0041:
        monitor-exit(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.a.initialize():void");
    }

    public static boolean Dw() {
        return dpp.Df() != 0;
    }

    public final boolean Dx() {
        return this.dpC == a.dpI;
    }

    public final void Dy() {
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "summerasyncinit setInitializedNotifyAllDone[%b] to true stack[%s]", Boolean.valueOf(this.dpD), bi.cjd());
        this.dpD = true;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.tencent.mm.sdk.platformtools.x.i("MMKernel.CoreAccount", "summerhardcoder setInitializedNotifyAllDone [%d %d] take[%d]ms, stack[%s]", Long.valueOf(this.dpB), Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime - this.dpB), bi.cjd());
        com.tencent.mm.sdk.b.a.sFg.m(new by());
    }

    public static int Dz() {
        return Integer.valueOf(ad.getContext().getSharedPreferences("system_config_prefs", 4).getInt("default_uin", 0)).intValue();
    }

    public static String DA() {
        g.Ek();
        if (bi.oW(g.Eg().dpE)) {
            DB();
        }
        g.Ek();
        return g.Eg().dpE;
    }

    public static void DB() {
        g.Ek();
        g.Eg().dpE = q.zz() + "_" + System.currentTimeMillis();
        g.Ek();
        g.Eg().dpF.clear();
    }

    public static int gd(String str) {
        int i;
        g.Ek();
        if (g.Eg().dpF.get(str) == null) {
            i = 0;
        } else {
            g.Ek();
            i = ((Integer) g.Eg().dpF.get(str)).intValue();
        }
        int VE = (int) bi.VE();
        if (i == 0) {
            g.Ek();
            g.Eg().dpF.put(str, Integer.valueOf(VE));
            return i;
        }
        i = VE - i;
        g.Ek();
        g.Eg().dpF.put(str, Integer.valueOf(VE));
        return i < 0 ? 0 : i;
    }
}
