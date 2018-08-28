package com.tencent.mm.plugin.exdevice.b;

import android.content.SharedPreferences;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import junit.framework.Assert;

public final class k implements com.tencent.mm.ab.e {
    public static k isJ = null;
    private final HashMap<Long, e> isI;
    public HashMap<String, Integer> isK;
    public ag mHandler;

    private static final class b {
        public String fGO;
        public int isA;
        public int isM;
        public l isN;

        private b() {
            this.isA = 0;
            this.isM = 0;
            this.fGO = null;
            this.isN = null;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private static final class c {
        public byte[] hfA;
        public long mSessionId;

        private c() {
            this.mSessionId = 0;
            this.hfA = null;
        }

        public /* synthetic */ c(byte b) {
            this();
        }
    }

    private static final class e {
        f isP;
        private d isQ;
        int isR;

        private e() {
            this.isP = null;
            this.isQ = null;
            this.isR = 0;
        }

        /* synthetic */ e(byte b) {
            this();
        }

        public final void a(f fVar) {
            Assert.assertNotNull(fVar);
            this.isP = fVar;
        }

        public final void a(d dVar) {
            Assert.assertNotNull(dVar);
            this.isQ = dVar;
        }

        public final f aGG() {
            Assert.assertNotNull(this.isP);
            return this.isP;
        }

        public final d aGH() {
            Assert.assertNotNull(this.isQ);
            return this.isQ;
        }
    }

    public static final class f {
        private static f isT = null;
        private long isS;

        public f() {
            long j = 0;
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("exdevice_pref", 0);
            if (sharedPreferences != null) {
                j = sharedPreferences.getLong("local_message_seq", 0);
                x.i("MicroMsg.exdevice.Util", "lasted seq id is %d", new Object[]{Long.valueOf(j)});
            }
            this.isS = j;
        }

        public static long aGI() {
            if (isT == null) {
                isT = new f();
            }
            f fVar = isT;
            if (Long.MAX_VALUE == fVar.isS) {
                x.w("MicroMsg.MMSendDataToManufacturerLogic", "Sequence Data-overrun!!!");
                fVar.isS = 0;
            }
            long j = fVar.isS + 1;
            fVar.isS = j;
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("exdevice_pref", 0);
            if (sharedPreferences != null) {
                x.i("MicroMsg.exdevice.Util", "save locall seq id : %d", new Object[]{Long.valueOf(j)});
                sharedPreferences.edit().putLong("local_message_seq", j).commit();
            }
            return j;
        }
    }

    public static k aGF() {
        if (isJ != null) {
            return isJ;
        }
        k kVar = new k();
        isJ = kVar;
        return kVar;
    }

    private k() {
        this.isI = new HashMap();
        this.mHandler = null;
        this.isK = new HashMap();
        this.mHandler = new a(this, au.Em().lnJ.getLooper());
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "******onSceneEnd******\r\n errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        b bVar = new b();
        bVar.isA = i2;
        bVar.isM = i;
        bVar.fGO = str;
        bVar.isN = lVar;
        this.mHandler.obtainMessage(2, bVar).sendToTarget();
    }
}
