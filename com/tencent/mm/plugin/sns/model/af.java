package com.tencent.mm.plugin.sns.model;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Point;
import android.os.Looper;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.bt.h;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.cj;
import com.tencent.mm.g.a.ck;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.nl;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ar;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.f.e;
import com.tencent.mm.plugin.sns.f.g;
import com.tencent.mm.plugin.sns.lucky.a.l;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.n;
import com.tencent.mm.plugin.sns.p;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public final class af implements ar, j {
    private static int npC;
    private static int npD;
    public static boolean npv = true;
    private static int npw = 0;
    private static int npx = 0;
    private static String nqc = "";
    protected static HashMap<Integer, d> nqd = new HashMap();
    private static int nql = 103;
    private static Point nqm = new Point();
    private String dIp;
    private h dqq;
    private byte[] dsN = new byte[0];
    private ag handler = new ag(Looper.getMainLooper());
    private c lyA = new 32(this);
    private ag npA = null;
    private ag npB = null;
    private s npE;
    private o npF;
    private f npG;
    private com.tencent.mm.plugin.sns.storage.d npH;
    private y npI;
    private g npJ;
    private m npK;
    private k npL;
    private u npM;
    private ad npN;
    private a npO;
    private b npP;
    private aw npQ;
    private aj npR;
    private com.tencent.mm.plugin.sns.f.c npS;
    private g npT;
    private q npU;
    private i npV;
    private ao npW = new ao();
    private boolean npX = false;
    private boolean npY = true;
    private w npZ = new w();
    private ag[] npy = new ag[3];
    private ag[] npz = new ag[1];
    private c nqA = new c<ck>() {
        {
            this.sFo = ck.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            com.tencent.mm.kernel.g.Ek();
            String str = com.tencent.mm.kernel.g.Ei().cachePath;
            com.tencent.mm.kernel.g.Ek();
            String str2 = com.tencent.mm.kernel.g.Ei().dqo;
            x.i("MicroMsg.SnsCore", "dump %s", new Object[]{str2});
            str = str + "SnsMicroMsg.db";
            FileOp.deleteFile(str2 + "sns.dump");
            FileOp.y(str, str2 + "sns.dump");
            return false;
        }
    };
    private c nqB = new 15(this);
    private c nqC = new 16(this);
    private c nqD = new 17(this);
    private c nqE = new 18(this);
    private c nqF = new 19(this);
    private c nqG = new 20(this);
    private c nqH = new 21(this);
    private c nqI = new c<cl>() {
        {
            this.sFo = cl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            af.byC();
            return false;
        }
    };
    private c nqJ = new c<cj>() {
        {
            this.sFo = cj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            e.MN("100004");
            e.MN("100007");
            return false;
        }
    };
    private c nqK = new c<rw>() {
        {
            this.sFo = rw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            x.i("MicroMsg.SnsCore", "triger snslogmgr try report");
            af.byi().bwP();
            return false;
        }
    };
    private c nqL = new 26(this);
    private c nqM = new c<nl>() {
        {
            this.sFo = nl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            nl nlVar = (nl) bVar;
            SnsAdClick snsAdClick = nlVar.bYw.bYl;
            if (nlVar.bYw.bYx == 1) {
                com.tencent.mm.modelsns.b ip;
                if (snsAdClick.egM == 1) {
                    i byi;
                    int i;
                    int i2;
                    int bAI;
                    Object[] objArr;
                    Object[] objArr2;
                    com.tencent.mm.plugin.sns.storage.e eZ = af.byr().eZ(snsAdClick.egG);
                    Object[] objArr3;
                    if (eZ == null || !eZ.bzx()) {
                        byi = af.byi();
                        i = 13155;
                        objArr3 = new Object[7];
                        objArr3[0] = com.tencent.mm.plugin.sns.data.i.eF(snsAdClick.egG);
                        objArr3[1] = snsAdClick.egH;
                        objArr3[2] = Integer.valueOf(snsAdClick.scene);
                        objArr3[3] = Long.valueOf(snsAdClick.egK);
                        objArr3[4] = Long.valueOf(System.currentTimeMillis());
                        i2 = 5;
                        if (eZ != null) {
                            bAI = eZ.bAI();
                            objArr = objArr3;
                            objArr2 = objArr3;
                        } else {
                            bAI = -1;
                            objArr = objArr3;
                            objArr2 = objArr3;
                        }
                    } else {
                        byi = af.byi();
                        i = 14647;
                        objArr3 = new Object[7];
                        objArr3[0] = com.tencent.mm.plugin.sns.data.i.eF(snsAdClick.egG);
                        objArr3[1] = snsAdClick.egH;
                        objArr3[2] = Integer.valueOf(snsAdClick.scene);
                        objArr3[3] = Long.valueOf(snsAdClick.egK);
                        objArr3[4] = Long.valueOf(System.currentTimeMillis());
                        i2 = 5;
                        bAI = eZ.bAI();
                        objArr = objArr3;
                        objArr2 = objArr3;
                    }
                    objArr[i2] = Integer.valueOf(bAI);
                    objArr2[6] = "";
                    byi.h(i, objArr2);
                    ip = com.tencent.mm.modelsns.b.ip(750);
                    ip.nb(com.tencent.mm.plugin.sns.data.i.eF(snsAdClick.egG)).nb(snsAdClick.egH).ir(snsAdClick.scene).nb(snsAdClick.egK).nb(System.currentTimeMillis());
                    ip.RD();
                } else {
                    com.tencent.mm.plugin.sns.storage.e eZ2 = af.byr().eZ(snsAdClick.egG);
                    long LP = !bi.oW(snsAdClick.egI) ? com.tencent.mm.plugin.sns.data.i.LP(snsAdClick.egI) : snsAdClick.egG;
                    String str = !bi.oW(snsAdClick.egI) ? snsAdClick.egI : snsAdClick.egG;
                    String str2 = (com.tencent.mm.plugin.sns.a.b.f.a(LP, str, snsAdClick.egH, Integer.valueOf(snsAdClick.scene), Long.valueOf(snsAdClick.egK), Long.valueOf(System.currentTimeMillis())) + String.format(",%s", new Object[]{snsAdClick.egN})) + String.format(",%s", new Object[]{((System.currentTimeMillis() - snsAdClick.egK) - snsAdClick.egP)});
                    if (eZ2 == null || !eZ2.bzx()) {
                        af.byi().h(12013, new Object[]{str2});
                    } else {
                        af.byi().h(14643, new Object[]{str2});
                    }
                    ip = com.tencent.mm.modelsns.b.ip(733);
                    ip.nb(com.tencent.mm.plugin.sns.data.i.eF(snsAdClick.egG)).nb(snsAdClick.egH).ir(snsAdClick.scene).nb(snsAdClick.egK).nb(System.currentTimeMillis());
                    ip.RD();
                }
            }
            return false;
        }
    };
    private c nqN = new 28(this);
    private c nqO = new 29(this);
    private c nqP = new 30(this);
    private boolean nqQ = false;
    private c nqR = new 33(this);
    private c nqS = new 35(this);
    private boolean nqa = false;
    private byte[] nqb = new byte[0];
    private com.tencent.mm.plugin.sns.d nqe;
    private com.tencent.mm.plugin.sns.e.a nqf;
    private ar nqg;
    private com.tencent.mm.plugin.sns.lucky.a.f nqh = new com.tencent.mm.plugin.sns.lucky.a.f();
    private com.tencent.mm.plugin.sns.lucky.a.j nqi = new com.tencent.mm.plugin.sns.lucky.a.j();
    private com.tencent.mm.plugin.sns.lucky.a.d nqj = new com.tencent.mm.plugin.sns.lucky.a.d();
    private l nqk = new l();
    private n nqn;
    private com.tencent.mm.plugin.sns.k nqo;
    private com.tencent.mm.plugin.sns.e nqp;
    private p nqq;
    private com.tencent.mm.plugin.sns.h nqr;
    private com.tencent.mm.plugin.sns.g nqs;
    private com.tencent.mm.plugin.sns.m nqt;
    private com.tencent.mm.plugin.sns.j nqu;
    private com.tencent.mm.plugin.sns.b nqv;
    private com.tencent.mm.plugin.sns.c nqw;
    private com.tencent.mm.plugin.sns.f nqx;
    private c nqy = new 11(this);
    private c nqz = new 13(this);

    static /* synthetic */ void byC() {
        x.i("MicroMsg.SnsCore", "dumptable");
        StringBuffer stringBuffer = new StringBuffer();
        o byo = byo();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor b = byo.diF.b("select count(*) from SnsInfo", null, 2);
        int i = b.moveToFirst() ? b.getInt(0) : 0;
        b.close();
        x.i("MicroMsg.SnsInfoStorage", "sns table count %d passed %d", new Object[]{Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        s byd = byd();
        long currentTimeMillis2 = System.currentTimeMillis();
        Cursor b2 = byd.dCZ.b("select count(*) from SnsMedia", null, 2);
        int i2 = b2.moveToFirst() ? b2.getInt(0) : 0;
        b2.close();
        x.i("MicroMsg.snsMediaStorage", "media table count %d passed %d", new Object[]{Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        m bys = bys();
        currentTimeMillis2 = System.currentTimeMillis();
        b = bys.diF.b("select count(*) from snsExtInfo3", null, 2);
        int i3 = b.moveToFirst() ? b.getInt(0) : 0;
        b.close();
        x.i("MicroMsg.SnsExtStorage", "ext table count %d passed %d", new Object[]{Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        stringBuffer.append(" snscount " + i);
        stringBuffer.append(" mediacount " + i2);
        stringBuffer.append(" extcount " + i3);
        x.i("MicroMsg.SnsCore", "dump table " + stringBuffer.toString());
    }

    static /* synthetic */ void c(af afVar) {
        if (!afVar.nqQ) {
            bxW().npB.post(new 31(afVar));
        }
    }

    static /* synthetic */ String d(af afVar) {
        if (afVar.nqQ) {
            return "";
        }
        afVar.nqQ = true;
        File[] listFiles = new File(getAccSnsPath()).listFiles();
        x.i("MicroMsg.SnsCore", "snscheckfile start");
        long j = 0;
        for (File listFiles2 : listFiles) {
            File[] listFiles3 = listFiles2.listFiles();
            if (listFiles3 != null) {
                for (int i = 0; i < listFiles3.length; i++) {
                    String[] list = listFiles3[i].list();
                    if (list != null) {
                        File[] listFiles4 = listFiles3[i].listFiles();
                        if (listFiles4 != null) {
                            StringBuffer stringBuffer = new StringBuffer();
                            long j2 = j;
                            for (File file : listFiles4) {
                                j2 += file.length();
                                String str = file.getAbsolutePath() + " " + file.length() + " " + file.lastModified() + " " + ((String) DateFormat.format("yyyy-M-d kk:mm", file.lastModified()));
                                stringBuffer.append(str + "\r\n");
                                x.i("MicroMsg.SnsCore", str);
                            }
                            int length = list.length;
                            x.i("MicroMsg.SnsCore", "filepath %s %d", new Object[]{listFiles3[i].getAbsolutePath(), Integer.valueOf(length)});
                            j = j2;
                        }
                    }
                }
            }
        }
        x.i("MicroMsg.SnsCore", "snscheckfile end " + j);
        afVar.nqQ = false;
        return "";
    }

    static {
        nqd.put(Integer.valueOf("CanvasInfo".hashCode()), new 12());
        nqd.put(Integer.valueOf("UxCanvasInfo".hashCode()), new 23());
        nqd.put(Integer.valueOf("SNSMEDIA_TABLE".hashCode()), new 34());
        nqd.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new 36());
        nqd.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new 37());
        nqd.put(Integer.valueOf("ADSNSINFO_TABLE".hashCode()), new 38());
        nqd.put(Integer.valueOf("SNSEXT_TABLE".hashCode()), new 39());
        nqd.put(Integer.valueOf("SNSCOMMENT_TABLE".hashCode()), new 40());
        nqd.put(Integer.valueOf("SNSTAGINFO_TABLE".hashCode()), new 2());
        nqd.put(Integer.valueOf("SNSKVREPORT_TABLE".hashCode()), new 3());
    }

    public static String Gq() {
        com.tencent.mm.kernel.g.Eg().Ds();
        com.tencent.mm.kernel.g.Ek();
        return com.tencent.mm.kernel.g.Ei().dqp;
    }

    public static String bxU() {
        com.tencent.mm.kernel.g.Ek();
        return (String) com.tencent.mm.kernel.g.Ei().DT().get(2, null);
    }

    public static int bxV() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eg();
        return com.tencent.mm.kernel.a.Df();
    }

    public static h FO() {
        return bxW().dqq;
    }

    private static af bxW() {
        af afVar = (af) com.tencent.mm.model.p.v(af.class);
        if (!afVar.nqa) {
            synchronized (afVar.nqb) {
                if (!afVar.nqa) {
                    x.i("MicroMsg.SnsCore", "onAccInit because bug!");
                    afVar.bn(true);
                }
            }
        }
        if (afVar.npX) {
            synchronized (afVar.dsN) {
                x.i("MicroMsg.SnsCore", "getCore need reset DB now " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + afVar.hashCode());
                if (afVar.npX) {
                    afVar.npY = false;
                    w wVar = afVar.npZ;
                    HashMap hashMap = nqd;
                    if (wVar.nJO) {
                        x.i("MicroMsg.TrimSnsDb", "pass hasTrim");
                    } else {
                        com.tencent.mm.kernel.g.Ek();
                        if (com.tencent.mm.kernel.g.Eg().Dx()) {
                            int i = bi.getInt(com.tencent.mm.k.g.AT().getValue("AndroidCleanSnsDb"), 0);
                            x.i("MicroMsg.TrimSnsDb", "pass dynamic? " + i);
                            if (i <= 0) {
                                com.tencent.mm.kernel.g.Ek();
                                String str = com.tencent.mm.kernel.g.Ei().cachePath;
                                if (FileOp.cn(str + "SnsMicroMsg2.db.ini")) {
                                    w.NI(str);
                                    FileOp.deleteFile(str + "SnsMicroMsg2.db.ini");
                                }
                                SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences(ad.chY(), 0);
                                if (bi.bG(sharedPreferences.getLong("check_trim_time", 0)) < 604800) {
                                    x.i("MicroMsg.TrimSnsDb", "trim sns pass because time short");
                                } else {
                                    sharedPreferences.edit().putLong("check_trim_time", bi.VE()).commit();
                                    wVar.nJO = true;
                                    long currentTimeMillis = System.currentTimeMillis();
                                    int BP = com.tencent.mm.o.a.BP();
                                    if (BP == 1 || BP == 2) {
                                        x.i("MicroMsg.TrimSnsDb", "trim sns error space dangerous");
                                    } else {
                                        if (FileOp.cn(str + "sns_mark.ini")) {
                                            if (bi.bH(FileOp.mJ(str + "sns_mark.ini")) < 2592000000L) {
                                                x.i("MicroMsg.TrimSnsDb", "mark file exist and return");
                                                w.NI(str);
                                            } else {
                                                FileOp.deleteFile(str + "sns_mark.ini");
                                            }
                                        }
                                        long mI = FileOp.mI(str + "SnsMicroMsg.db");
                                        x.i("MicroMsg.TrimSnsDb", "trim sns " + mI);
                                        if (mI < 52428800) {
                                            x.i("MicroMsg.TrimSnsDb", "trim sns free pass: " + (System.currentTimeMillis() - currentTimeMillis));
                                        } else {
                                            FileOp.mM(str + "sns_mark.ini");
                                            String str2 = str + "SnsMicroMsg2.db";
                                            h hVar = new h();
                                            if (hVar.b(str2, null, false)) {
                                                h hVar2 = new h();
                                                if (hVar2.b(str + "SnsMicroMsg.db", hashMap, true)) {
                                                    long currentTimeMillis2;
                                                    long currentTimeMillis3 = System.currentTimeMillis();
                                                    if (w.a(hVar2, hVar)) {
                                                        currentTimeMillis2 = System.currentTimeMillis();
                                                        str2 = "snsExtInfo3";
                                                        w.a(hVar2, hVar, str2);
                                                        x.i("MicroMsg.TrimSnsDb", "copysns ret_ext:" + hVar.fV("", "insert into " + str2 + " select * from old." + str2) + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                        str2 = "SnsComment";
                                                        w.a(hVar2, hVar, str2);
                                                        x.i("MicroMsg.TrimSnsDb", "copysns ret_msg:" + hVar.fV("", "insert into " + str2 + " select * from old." + str2) + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                        str2 = "SnsInfo";
                                                        w.a(hVar2, hVar, str2);
                                                        x.i("MicroMsg.TrimSnsDb", "copysns ret_sns:" + hVar.fV("", "insert into " + str2 + " select * from old." + str2 + " where  (sourceType & 2 != 0 ) " + o.nJs + " limit 200") + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                        boolean fV = hVar.fV("", "update snsExtinfo3 set md5 = '', faults = '';");
                                                        x.i("MicroMsg.TrimSnsDb", "update ext info  passed  %s  updateRet %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), Boolean.valueOf(fV)});
                                                        hVar.fV("", "DETACH DATABASE old");
                                                        BP = 1;
                                                    } else {
                                                        BP = -1;
                                                    }
                                                    currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis3;
                                                    x.i("MicroMsg.TrimSnsDb", "copysns insert all %d passed ret:" + BP, new Object[]{Long.valueOf(currentTimeMillis2)});
                                                    hVar2.closeDB();
                                                    hVar.closeDB();
                                                    if (BP >= 0) {
                                                        com.tencent.mm.kernel.g.Ek();
                                                        String str3 = com.tencent.mm.kernel.g.Ei().cachePath;
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg.db");
                                                        x.i("MicroMsg.TrimSnsDb", "rename file " + FileOp.i(str3, "SnsMicroMsg2.db", "SnsMicroMsg.db"));
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg.db-shm");
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg.db-wal");
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg.db.ini");
                                                        FileOp.y("SnsMicroMsg2.db.ini", "SnsMicroMsg.db.ini");
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg2.db.ini");
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg2.db");
                                                        FileOp.deleteFile(str3 + "sns_mark.ini");
                                                    }
                                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                                                    x.i("MicroMsg.TrimSnsDb", "copysns data ret=%d all: %d copytime %d ", new Object[]{Integer.valueOf(BP), Long.valueOf(currentTimeMillis4), Long.valueOf(currentTimeMillis4 - currentTimeMillis2)});
                                                    x.i("MicroMsg.TrimSnsDb", "trim sns done pass: " + (System.currentTimeMillis() - currentTimeMillis));
                                                } else {
                                                    throw new com.tencent.mm.model.b((byte) 0);
                                                }
                                            }
                                            throw new com.tencent.mm.model.b((byte) 0);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (afVar.dqq == null) {
                        afVar.dqq = new h();
                        com.tencent.mm.kernel.g.Ek();
                        if (!afVar.dqq.b(com.tencent.mm.kernel.g.Ei().cachePath + "SnsMicroMsg.db", nqd, true)) {
                            throw new SQLiteException("sns db init failed");
                        }
                    }
                    afVar.npX = false;
                    x.i("MicroMsg.SnsCore", "resetdb done");
                }
            }
        }
        return afVar;
    }

    public static boolean bxX() {
        bxW();
        return !com.tencent.mm.kernel.g.Eg().Dx();
    }

    public af() {
        x.i("MicroMsg.SnsCore", "snscore create! " + Thread.currentThread().getId());
        byA();
        if (this.npA == null) {
            com.tencent.mm.sdk.f.e.d(new 6(this), "SnsCore_fileTask_handler", 1).start();
        }
        if (this.npB == null) {
            com.tencent.mm.sdk.f.e.d(new Runnable() {
                public final void run() {
                    Looper.prepare();
                    af.this.npB = new ag();
                    Looper.loop();
                }
            }, "SnsCore_task_handler", 10).start();
        }
        ah.i(new 1(this), 3000);
    }

    public static ag bxY() {
        com.tencent.mm.kernel.g.Ek();
        return com.tencent.mm.kernel.g.Em().cil();
    }

    public static ag bxZ() {
        if (npw >= z.sOq || npw >= 3) {
            npw = 0;
        }
        ag[] agVarArr = bxW().npy;
        int i = npw;
        npw = i + 1;
        return agVarArr[i];
    }

    public static ag aRs() {
        if (npx > 0) {
            npx = 0;
        }
        ag[] agVarArr = bxW().npz;
        int i = npx;
        npx = i + 1;
        return agVarArr[i];
    }

    protected static ag bya() {
        return bxW().npA;
    }

    public static ag byb() {
        return bxW().npB;
    }

    public static ag aRu() {
        return bxW().handler;
    }

    public static String getAccSnsPath() {
        return ((com.tencent.mm.plugin.sns.b.b) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath();
    }

    public static String getAccSnsTmpPath() {
        return ((com.tencent.mm.plugin.sns.b.b) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath();
    }

    public static ay byc() {
        com.tencent.mm.kernel.g.Ek();
        return ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR();
    }

    public static s byd() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npE == null) {
            bxW().npE = new s(bxW().dqq);
        }
        return bxW().npE;
    }

    public static a bye() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npO == null) {
            bxW().npO = new a();
            com.tencent.mm.plugin.sns.b.n.nkC = bxW().npO;
        }
        return bxW().npO;
    }

    public static com.tencent.mm.plugin.sns.f.c byf() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npS == null) {
            bxW().npS = new com.tencent.mm.plugin.sns.f.c();
        }
        return bxW().npS;
    }

    public static g byg() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npT == null) {
            bxW().npT = new g();
        }
        return bxW().npT;
    }

    public static q byh() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npU == null) {
            bxW().npU = new q(bxW().dqq);
        }
        return bxW().npU;
    }

    public static i byi() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npV == null) {
            bxW().npV = new i();
        }
        return bxW().npV;
    }

    public static b byj() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npP == null) {
            bxW().npP = new b();
        }
        return bxW().npP;
    }

    public static aw byk() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npQ == null) {
            bxW().npQ = new aw();
            com.tencent.mm.plugin.sns.b.n.nkw = bxW().npQ;
        }
        return bxW().npQ;
    }

    public static g byl() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npJ == null) {
            bxW().npJ = new g();
            com.tencent.mm.plugin.sns.b.n.nkx = bxW().npJ;
        }
        return bxW().npJ;
    }

    public static ar bym() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().nqg == null) {
            bxW().nqg = new ar();
        }
        return bxW().nqg;
    }

    public static ad byn() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npN == null) {
            af bxW = bxW();
            StringBuilder stringBuilder = new StringBuilder();
            com.tencent.mm.kernel.g.Ek();
            bxW.npN = new ad(stringBuilder.append(com.tencent.mm.kernel.g.Ei().cachePath).append("snsAsyncQueue.data").toString());
        }
        return bxW().npN;
    }

    public static o byo() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npF == null) {
            bxW().npF = new o(bxW().dqq);
            com.tencent.mm.plugin.sns.b.n.nkD = bxW().npF;
        }
        return bxW().npF;
    }

    public static com.tencent.mm.plugin.sns.storage.d byp() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npH == null) {
            bxW().npH = new com.tencent.mm.plugin.sns.storage.d(bxW().dqq);
        }
        return bxW().npH;
    }

    public static y byq() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npI == null) {
            bxW().npI = new y(bxW().dqq);
        }
        return bxW().npI;
    }

    public static f byr() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npG == null) {
            bxW().npG = new f(bxW().dqq);
        }
        return bxW().npG;
    }

    public static m bys() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npK == null) {
            bxW().npK = new m(bxW().dqq, new ah());
            com.tencent.mm.plugin.sns.b.n.nky = bxW().npK;
        }
        return bxW().npK;
    }

    public static k byt() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npL == null) {
            bxW().npL = new k(bxW().dqq);
            com.tencent.mm.plugin.sns.b.n.nkz = bxW().npL;
        }
        return bxW().npL;
    }

    public static u byu() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npM == null) {
            bxW().npM = new u(bxW().dqq);
            com.tencent.mm.plugin.sns.b.n.nkA = bxW().npM;
        }
        return bxW().npM;
    }

    public static aj byv() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bxW().npR == null) {
            bxW().npR = new aj();
        }
        return bxW().npR;
    }

    public static int byw() {
        int i;
        if (bdF().y < bdF().x) {
            i = bdF().y;
        } else {
            i = bdF().x - com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), nql);
        }
        i /= 3;
        npC = i;
        if (i > 10) {
            return npC;
        }
        x.e("MicroMsg.SnsCore", "can not get multiThumbDisplaySize or the multiThumbDisplaySize < 10");
        return 150;
    }

    public static int byx() {
        if (npD <= 0) {
            npD = 200;
            npD = com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), npD);
        }
        return npD;
    }

    private static Point bdF() {
        WindowManager windowManager = (WindowManager) ad.getContext().getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        nqm.x = displayMetrics.widthPixels;
        nqm.y = displayMetrics.heightPixels;
        return nqm;
    }

    public static boolean byy() {
        SharedPreferences m = an.m(ad.getContext(), "sp_sns_dynswitch_stg", 4);
        if (m.contains("st_sw_use_vcodec_img")) {
            x.w("MicroMsg.SnsCore", "isUseVCodecImg: %b (set statically outside)", new Object[]{Boolean.valueOf(m.getBoolean("st_sw_use_vcodec_img", false))});
            return m.getBoolean("st_sw_use_vcodec_img", false);
        }
        x.d("MicroMsg.SnsCore", "isUseVCodecImg: %b", new Object[]{Boolean.valueOf(m.getBoolean("sw_use_vcodec_img", false))});
        return m.getBoolean("sw_use_vcodec_img", false);
    }

    public static boolean byz() {
        SharedPreferences m = an.m(ad.getContext(), "sp_sns_dynswitch_stg", 4);
        if (m.contains("st_sw_use_wxpc_img")) {
            x.w("MicroMsg.SnsCore", "isUseWxpcImg: %b (set statically outside)", new Object[]{Boolean.valueOf(m.getBoolean("st_sw_use_wxpc_img", false))});
            return m.getBoolean("st_sw_use_wxpc_img", false);
        }
        x.d("MicroMsg.SnsCore", "isUseWxpcImg: %b", new Object[]{Boolean.valueOf(m.getBoolean("sw_use_wxpc_img", false))});
        return m.getBoolean("sw_use_wxpc_img", false);
    }

    private void byA() {
        int i;
        for (i = 0; i < 3; i++) {
            if (this.npy[i] == null) {
                com.tencent.mm.sdk.f.e.d(new 4(this, i), "SnsCore_CDNDownload_handler", 1).start();
            }
        }
        for (i = 0; i <= 0; i++) {
            if (this.npz[0] == null) {
                com.tencent.mm.sdk.f.e.d(new 5(this), "SnsCore_thumbDecode_handler", 1).start();
            }
        }
    }

    public final void onAccountRelease() {
        i byi = byi();
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(1802, byi);
        ao aoVar = this.npW;
        com.tencent.mm.sdk.b.a.sFg.c(aoVar.nry);
        com.tencent.mm.sdk.b.a.sFg.c(aoVar.nrz);
        com.tencent.mm.sdk.b.a.sFg.c(aoVar.nrA);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqO);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqP);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqN);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqM);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqC);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqA);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqB);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqD);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqE);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqF);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqq);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqr);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqH);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqI);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqn);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqo);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqp);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqs);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqt);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqu);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqv);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqw);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqx);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqG);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqe);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqJ);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqK);
        com.tencent.mm.sdk.b.a.sFg.c(this.lyA);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqR);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqL);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqy);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqz);
        com.tencent.mm.sdk.b.a.sFg.c(this.nqS);
        ((com.tencent.mm.plugin.messenger.foundation.a.o) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().b("NewYearSNSCtrl2016", this.nqh, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.o) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().b("NewYearSNSTips2016", this.nqi, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.o) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().b("NewYearSNSAmountLevelCtrl2016", this.nqj, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.o) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().b("SnsAd", this.nqk, true);
        aw byk = byk();
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(207, byk);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(209, byk);
        af afVar = (af) com.tencent.mm.model.p.v(af.class);
        if (afVar != null) {
            int i;
            x.d("MicroMsg.SnsCore", "SnsCore close db");
            if (afVar.dqq != null) {
                afVar.dqq.closeDB();
                afVar.dqq = null;
            }
            for (i = 0; i < 3; i++) {
                if (afVar.npy[i] != null) {
                    afVar.npy[i].getLooper().quit();
                }
            }
            for (i = 0; i <= 0; i++) {
                if (afVar.npz[0] != null) {
                    afVar.npz[0].getLooper().quit();
                }
            }
            if (afVar.npA != null) {
                afVar.npA.getLooper().quit();
            }
            if (afVar.npB != null) {
                afVar.npB.getLooper().quit();
            }
        }
        com.tencent.mm.plugin.sns.e.a aVar = this.nqf;
        byj().b(aVar);
        com.tencent.mm.sdk.b.a.sFg.c(aVar.nll);
        ap.Wa();
        com.tencent.mm.memory.g.dva.Fm();
        com.tencent.mm.memory.c.duT.Fm();
        com.tencent.mm.memory.o.dvq.Fm();
        ar bym = bym();
        bym.nrJ = null;
        bym.emO = null;
        bym.nrL.clear();
        bym.nrK.clear();
        synchronized (bym.nrM) {
            bym.nrM.clear();
        }
        com.tencent.mm.sdk.b.a.sFg.c(bym.nrN);
        com.tencent.mm.sdk.b.a.sFg.c(bym.nrz);
        com.tencent.mm.sdk.b.a.sFg.c(bym.nrA);
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        x.i("MicroMsg.SnsCore", "onAccountPostReset " + Thread.currentThread().getId() + " isAccInit: " + this.nqa);
        if (!this.nqa) {
            this.nqa = true;
            this.npX = true;
            FileOp.mL(Gq() + "sfs");
            this.dIp = getAccSnsPath();
            checkDir();
            ((com.tencent.mm.plugin.messenger.foundation.a.o) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().a("NewYearSNSCtrl2016", this.nqh, true);
            ((com.tencent.mm.plugin.messenger.foundation.a.o) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().a("NewYearSNSTips2016", this.nqi, true);
            ((com.tencent.mm.plugin.messenger.foundation.a.o) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().a("NewYearSNSAmountLevelCtrl2016", this.nqj, true);
            ((com.tencent.mm.plugin.messenger.foundation.a.o) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().a("SnsAd", this.nqk, true);
            com.tencent.mm.plugin.sns.b.n.nkw = byk();
            com.tencent.mm.plugin.sns.b.n.nkx = byl();
            com.tencent.mm.plugin.sns.b.n.nky = bys();
            com.tencent.mm.plugin.sns.b.n.nkz = byt();
            com.tencent.mm.plugin.sns.b.n.nkA = byu();
            com.tencent.mm.plugin.sns.b.n.nkC = bye();
            com.tencent.mm.plugin.sns.b.n.nkB = this;
            com.tencent.mm.plugin.sns.b.n.nkD = byo();
            com.tencent.mm.sdk.b.a.sFg.b(this.nqO);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqP);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqC);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqA);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqB);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqD);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqE);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqF);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqG);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqH);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqI);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqJ);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqK);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqS);
            this.nqn = new n();
            this.nqo = new com.tencent.mm.plugin.sns.k();
            this.nqp = new com.tencent.mm.plugin.sns.e();
            this.nqq = new p();
            this.nqr = new com.tencent.mm.plugin.sns.h();
            this.nqs = new com.tencent.mm.plugin.sns.g();
            this.nqt = new com.tencent.mm.plugin.sns.m();
            this.nqu = new com.tencent.mm.plugin.sns.j();
            this.nqv = new com.tencent.mm.plugin.sns.b();
            this.nqw = new com.tencent.mm.plugin.sns.c();
            this.nqx = new com.tencent.mm.plugin.sns.f();
            com.tencent.mm.sdk.b.a.sFg.b(this.nqN);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqM);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqq);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqn);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqo);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqp);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqr);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqs);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqt);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqu);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqv);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqw);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqx);
            com.tencent.mm.sdk.b.a.sFg.b(this.lyA);
            this.nqe = new com.tencent.mm.plugin.sns.d();
            com.tencent.mm.sdk.b.a.sFg.b(this.nqe);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqR);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqy);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqz);
            com.tencent.mm.sdk.b.a.sFg.b(this.nqL);
            i byi = byi();
            i.njw = com.tencent.mm.k.g.AT().getInt("MMUxAdLog2GSendSize", 20480);
            i.njx = com.tencent.mm.k.g.AT().getInt("MMUxAdLog3GSendSize", 30720);
            i.njy = com.tencent.mm.k.g.AT().getInt("MMUxAdLogWifiSendSize", 51200);
            i.njz = com.tencent.mm.k.g.AT().getInt("MMUxAdLogMinRandTime", 60);
            i.njA = com.tencent.mm.k.g.AT().getInt("MMUxAdLogMaxRandTime", 1800);
            i.njB = com.tencent.mm.k.g.AT().getInt("MMUxAdLogMaxExceptionTime", 43200);
            x.i("MicroMsg.SnsLogMgr", "init " + i.njw + ";" + i.njx + ";" + i.njy + ";" + i.njz + ";" + i.njA + ";" + i.njB);
            if (i.njA - i.njz < 0) {
                i.njA = i.njz;
            }
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(1802, byi);
            aw byk = byk();
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(207, byk);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(209, byk);
            ao aoVar = this.npW;
            com.tencent.mm.sdk.b.a.sFg.b(aoVar.nry);
            com.tencent.mm.sdk.b.a.sFg.b(aoVar.nrz);
            com.tencent.mm.sdk.b.a.sFg.b(aoVar.nrA);
            this.nqf = new com.tencent.mm.plugin.sns.e.a();
            ap.init();
            com.tencent.mm.modelsns.c cVar = com.tencent.mm.modelsns.c.ehc;
            com.tencent.mm.modelsns.c.RE();
            if (com.tencent.mm.memory.l.Fv()) {
                com.tencent.mm.memory.c cVar2 = com.tencent.mm.memory.c.duT;
                com.tencent.mm.memory.c cVar3 = com.tencent.mm.memory.c.duT;
                cVar3.getClass();
                cVar2.a(new 8(this, cVar3));
            }
            com.tencent.mm.memory.o oVar = com.tencent.mm.memory.o.dvq;
            com.tencent.mm.memory.o oVar2 = com.tencent.mm.memory.o.dvq;
            oVar2.getClass();
            oVar.a(new 9(this, oVar2));
            com.tencent.mm.memory.g gVar = com.tencent.mm.memory.g.dva;
            com.tencent.mm.memory.g gVar2 = com.tencent.mm.memory.g.dva;
            gVar2.getClass();
            gVar.a(new 10(this, gVar2));
            bym();
        }
    }

    private static void checkDir() {
        FileOp.mL(((com.tencent.mm.plugin.sns.b.b) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath());
        FileOp.mL(((com.tencent.mm.plugin.sns.b.b) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath());
    }

    public final void bo(boolean z) {
        FileOp.mL(Gq() + "sfs");
        checkDir();
    }

    public final void a(ap apVar) {
        u.a(apVar);
    }

    public final void b(ap apVar) {
        u.b(apVar);
    }

    public static String byB() {
        if (bi.oW(nqc)) {
            Iterator it = ax.ciH().iterator();
            while (it.hasNext()) {
                ax.a aVar = (ax.a) it.next();
                if (com.tencent.mm.compatible.util.e.bnC.equals(aVar.sIK)) {
                    nqc = aVar.sIL;
                    break;
                }
            }
            x.i("MicroMsg.SnsCore", "get filesys " + nqc);
        }
        return bi.aG(nqc, "");
    }
}
