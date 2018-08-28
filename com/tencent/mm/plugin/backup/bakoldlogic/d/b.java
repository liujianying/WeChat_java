package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.bg.d;
import com.tencent.mm.bt.h;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.bm;
import com.tencent.mm.g.a.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.backup.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c.1;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c.2;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.o;
import java.util.HashMap;
import junit.framework.Assert;

public final class b extends a {
    private static b haX;
    private static int hba = 0;
    private c haY;
    private a haZ;
    private c hbb;

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.d.b$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Runnable hbg;

        public AnonymousClass2(Runnable runnable) {
            this.hbg = runnable;
        }

        public final void run() {
            x.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb closeTempDB ok");
            x.chR();
            au.Em().a(new 1(this));
        }
    }

    static /* synthetic */ void atr() {
        long VF = bi.VF();
        au.HU();
        c.closeDB();
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        String stringBuilder2 = stringBuilder.append(c.DQ()).append(".tem").toString();
        au.HU();
        j.q(stringBuilder2, c.DQ(), false);
        stringBuilder = new StringBuilder();
        au.HU();
        stringBuilder2 = stringBuilder.append(c.DR()).append(".tem").toString();
        au.HU();
        j.q(stringBuilder2, c.DR(), false);
        stringBuilder = new StringBuilder();
        au.HU();
        stringBuilder2 = stringBuilder.append(c.DR()).append(".tem-journal").toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        au.HU();
        j.q(stringBuilder2, stringBuilder3.append(c.DR()).append("-journal").toString(), false);
        stringBuilder = new StringBuilder();
        au.HU();
        stringBuilder2 = stringBuilder.append(c.DR()).append(".tem-wal").toString();
        stringBuilder3 = new StringBuilder();
        au.HU();
        j.q(stringBuilder2, stringBuilder3.append(c.DR()).append("-wal").toString(), false);
        com.tencent.mm.sdk.b.a.sFg.m(new bm());
        g.Eg().release();
        g.Eg().initialize();
        atq();
        ato();
        x.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDbImp finish cost time[%d]", new Object[]{Long.valueOf(bi.bH(VF))});
    }

    static /* synthetic */ int wy() {
        int i = hba;
        hba = i + 1;
        return i;
    }

    static /* synthetic */ int wz() {
        int i = hba;
        hba = i - 1;
        return i;
    }

    public static b atl() {
        if (haX == null) {
            b bVar = new b();
            haX = bVar;
            a(bVar);
        }
        return haX;
    }

    public final void aqK() {
        haX = null;
    }

    public final c atm() {
        if (this.haY == null) {
            this.haY = new c();
        }
        return this.haY;
    }

    public final a atn() {
        if (this.haZ == null) {
            this.haZ = new a();
        }
        return this.haZ;
    }

    private static void ato() {
        com.tencent.mm.sdk.b.a.sFg.m(new z());
    }

    private c atp() {
        if (this.hbb == null) {
            this.hbb = new c();
        }
        return this.hbb;
    }

    public final void a(a aVar) {
        long VF = bi.VF();
        x.i("MicroMsg.BakOldTempDbModel", "initTempDB needSyncPauser:%b %s", new Object[]{Boolean.valueOf(false), bi.cjd()});
        ah.i(new 1(this, VF, aVar), 1000);
    }

    private boolean a(PLong pLong, PLong pLong2, PLong pLong3, a aVar, int i) {
        au.HU();
        c.closeDB();
        x.d("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after close db");
        au.HU();
        int cm = e.cm(c.DQ());
        au.HU();
        pLong3.value = (long) (cm + e.cm(c.DR()));
        long j = pLong3.value;
        au.HU();
        if (com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(j, pLong, pLong2, c.Gq())) {
            au.HU();
            String DQ = c.DQ();
            StringBuilder stringBuilder = new StringBuilder();
            au.HU();
            j.q(DQ, stringBuilder.append(c.DQ()).append(".tem").toString(), false);
            au.HU();
            DQ = c.DR();
            stringBuilder = new StringBuilder();
            au.HU();
            j.q(DQ, stringBuilder.append(c.DR()).append(".tem").toString(), false);
            StringBuilder stringBuilder2 = new StringBuilder();
            au.HU();
            DQ = stringBuilder2.append(c.DR()).append("-journal").toString();
            stringBuilder = new StringBuilder();
            au.HU();
            j.q(DQ, stringBuilder.append(c.DR()).append(".tem-journal").toString(), false);
            stringBuilder2 = new StringBuilder();
            au.HU();
            DQ = stringBuilder2.append(c.DR()).append("-wal").toString();
            stringBuilder = new StringBuilder();
            au.HU();
            j.q(DQ, stringBuilder.append(c.DR()).append(".tem-wal").toString(), false);
            x.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before reset account");
            g.Eg().release();
            g.Eg().initialize();
            x.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg setAccInfo");
            c atp = atp();
            au.HU();
            String Gq = c.Gq();
            au.HU();
            x.i("MicroMsg.BakOldTempStorage", "accPath:%s, accUin:%d", new Object[]{Gq, Integer.valueOf(c.Df())});
            atp.uin = r2;
            atp.dqp = Gq;
            x.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg initDB");
            c atp2 = atp();
            stringBuilder2 = new StringBuilder();
            au.HU();
            Gq = stringBuilder2.append(c.DQ()).append(".tem").toString();
            au.HU();
            int Df = c.Df();
            stringBuilder2 = new StringBuilder();
            au.HU();
            x.i("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB:%s  cache:%s uin:%s db:%s %s", new Object[]{atp2.hbp, Gq, Integer.valueOf(Df), stringBuilder2.append(c.DR()).append(".tem").toString(), bi.cjd()});
            if (atp2.dqq != null) {
                x.e("MicroMsg.BakOldTempStorage", "bakoldInitDB dataDB is already init!!!");
            }
            if (i > 0) {
                if (!(atp2.hbp == null || atp2.hbp.booleanValue())) {
                    x.e("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB is false!!!");
                    atp2.ats();
                }
                Assert.assertTrue("bakoldInitDB here  isTempDb should null :" + atp2.hbp, atp2.hbp == null);
            }
            atp2.hbp = Boolean.valueOf(true);
            atp2.dqq = new h(new 2(atp2));
            if (atp2.dqq.a(Gq, r2, "", (long) Df, q.zy(), new HashMap(), false)) {
                atp2.gYC = new com.tencent.mm.storage.x(atp2.dqq);
                com.tencent.mm.plugin.messenger.foundation.a.j jVar = (com.tencent.mm.plugin.messenger.foundation.a.j) g.l(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                atp2.gYD = jVar.d(atp2.dqq);
                atp2.gYF = jVar.e(atp2.dqq);
                atp2.gYE = jVar.a(atp2.dqq, atp2.gYD, atp2.gYF);
                atp2.gYE.a(new aq(atp2.gYE));
                atp2.gYE.a(new o(atp2.gYE));
                atp2.gYI = jVar.f(atp2.dqq);
                atp2.gYG = new com.tencent.mm.ak.g(atp2.dqq);
                if (d.QS("emoji")) {
                    atp2.gYH = new com.tencent.mm.storage.emotion.d(atp2.dqq);
                }
                atp2.gYK = ((com.tencent.mm.plugin.chatroom.b.b) g.l(com.tencent.mm.plugin.chatroom.b.b.class)).c(atp2.dqq);
                atp2.gYJ = new s(atp2.dqq);
                atp2.gYL = new k(atp2.dqq);
                atp2.gYM = new i(atp2.dqq);
                atp2.gYN = new com.tencent.mm.pluginsdk.model.app.c(atp2.dqq);
                atp2.hbn = new bn(atp2.gYC);
                atp2.hbn.c(new 1(atp2));
                atp2.hbn.cmW();
                x.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after TemAccStg initDB");
                ato();
                aVar.hbk = true;
                aVar.hbl = pLong.value;
                aVar.hbm = pLong2.value;
                aVar.dbSize = pLong3.value;
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.wH(com.tencent.mm.plugin.backup.bakoldlogic.a.a.asK());
                return true;
            }
            throw new com.tencent.mm.model.b((byte) 0);
        }
        x.e("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp data free error, len %d", new Object[]{Long.valueOf(pLong3.value)});
        aVar.hbk = false;
        aVar.hbl = pLong.value;
        aVar.hbm = pLong2.value;
        aVar.dbSize = pLong3.value;
        return false;
    }

    public static void atq() {
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        e.deleteFile(stringBuilder.append(c.DQ()).append(".tem").toString());
        stringBuilder = new StringBuilder();
        au.HU();
        e.deleteFile(stringBuilder.append(c.DQ()).append(".ini.tem").toString());
        stringBuilder = new StringBuilder();
        au.HU();
        e.deleteFile(stringBuilder.append(c.DR()).append(".tem").toString());
        stringBuilder = new StringBuilder();
        au.HU();
        e.deleteFile(stringBuilder.append(c.DR()).append(".ini.tem").toString());
    }

    public final void a(Runnable runnable, int i) {
        if (i < 0 || hba == 0) {
            if (i < 0) {
                x.e("MicroMsg.BakOldTempDbModel", "closeTempDB no left tryCount!!");
            }
            x.i("MicroMsg.BakOldTempDbModel", "closeDB before");
            atp().ats();
            x.i("MicroMsg.BakOldTempDbModel", "closeDB after");
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        new ag(Looper.getMainLooper()).postDelayed(new 3(this, runnable, i), 500);
    }
}
