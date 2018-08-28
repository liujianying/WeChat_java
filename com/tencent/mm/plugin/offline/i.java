package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.f;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class i implements e {
    private boolean lJe = false;
    private boolean lJf = false;
    private int lJg = 10;
    private int lJh = 0;
    private String lJi = "";
    a lJj;
    private m lJk;
    public b lJl = new b(this, (byte) 0);
    int lJm = 14400000;
    al lJn = new al(new a() {
        public final boolean vD() {
            if (g.Eg().Dx()) {
                long j;
                i.this.df(5, 5);
                al alVar = i.this.lJn;
                i iVar = i.this;
                long blU = (long) com.tencent.mm.plugin.offline.c.a.blU();
                if (blU <= 0) {
                    j = (long) iVar.lJm;
                } else {
                    x.i("MicroMsg.OfflineTokensMgr", "OfflineTokensMgr updateInterval:" + blU);
                    j = 1000 * blU;
                }
                alVar.J(j, j);
            } else {
                long j2 = (long) i.this.lJm;
                i.this.lJn.J(j2, j2);
            }
            return false;
        }
    }, false);
    public ag mHandler = new ag();

    public i() {
        long j = 1;
        try {
            com.tencent.mm.wallet_core.c.a.cCW();
            com.tencent.mm.wallet_core.c.a.init(ad.getContext());
        } catch (Exception e) {
            x.e("MicroMsg.OfflineTokensMgr", "NO MPERMISSION for READ_PHONE_STATE:%s.", new Object[]{e});
        }
        g.Ek();
        g.Eh().dpP.a(385, this);
        k.bkO();
        String uk = k.uk(196649);
        if (TextUtils.isEmpty(uk) || !com.tencent.mm.plugin.offline.c.a.xW(uk)) {
            x.i("MicroMsg.OfflineTokensMgr", "genInitInterval: update_interval is empty or is not number,update token");
        } else {
            Object blG = com.tencent.mm.plugin.offline.c.a.blG();
            x.i("MicroMsg.OfflineTokensMgr", "genInitInterval: token is not over update interval,lastUpdate is " + blG);
            long longValue = Long.valueOf(uk).longValue();
            if (TextUtils.isEmpty(blG)) {
                x.i("MicroMsg.OfflineTokensMgr", "genInitInterval lastUpdate is empty, update token");
            } else {
                j = Long.valueOf(blG).longValue();
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                x.i("MicroMsg.OfflineTokensMgr", "genInitInterval token is not over update interval,curTime = " + currentTimeMillis + ";");
                j = longValue - (currentTimeMillis - j);
            }
        }
        x.i("MicroMsg.OfflineTokensMgr", "autoPusher startTimer interval=" + j);
        j *= 1000;
        this.lJn.J(j, j);
    }

    public static int bkN() {
        k.bkO();
        String uk = k.uk(196617);
        com.tencent.mm.wallet_core.c.a.cCW();
        int abT = com.tencent.mm.wallet_core.c.a.abT(uk);
        x.i("MicroMsg.OfflineTokensMgr", "offline tokens count:" + abT);
        return abT;
    }

    public final void df(int i, int i2) {
        if (ao.isNetworkConnected(ad.getContext()) && com.tencent.mm.plugin.offline.c.a.bly()) {
            x.i("MicroMsg.OfflineTokensMgr", "onNotify return false, token is invalid, do doNetSceneToken");
            dg(i, i2);
        }
    }

    public final boolean gW(boolean z) {
        if (!com.tencent.mm.plugin.offline.c.a.bly()) {
            x.e("MicroMsg.OfflineTokensMgr", "offline is not create!");
            return false;
        } else if (bkN() < k.lJy) {
            x.i("MicroMsg.OfflineTokensMgr", "getTokenCount < %s, do doNetSceneToken", new Object[]{Integer.valueOf(k.lJy)});
            com.tencent.mm.wallet_core.c.a.cCW();
            int lastError = com.tencent.mm.wallet_core.c.a.getLastError();
            if (lastError != 0) {
                x.e("MicroMsg.OfflineTokensMgr", "getTokenCount occurs error, the error is " + lastError + ", don't  doNetSceneToken");
                return false;
            }
            x.i("MicroMsg.OfflineTokensMgr", "getTokenCount is success! do doNetSceneToken");
            if (z) {
                uj(9);
            } else {
                uj(2);
            }
            return true;
        } else if (com.tencent.mm.plugin.offline.c.a.blV()) {
            x.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isTokenOverUpdateInterval() return false, token is over update_interval, do doNetSceneToken");
            if (z) {
                dg(5, 9);
            } else {
                dg(5, 5);
            }
            return true;
        } else if (com.tencent.mm.plugin.offline.c.a.blS()) {
            return false;
        } else {
            x.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, bindserial is change, do doNetSceneToken");
            if (z) {
                dg(3, 9);
            } else {
                dg(3, 3);
            }
            return true;
        }
    }

    public final void uj(int i) {
        if (bkN() > 2) {
            this.mHandler.postDelayed(new 2(this, i), 3000);
        } else {
            dg(2, i);
        }
    }

    public final void dg(int i, int i2) {
        int i3 = 0;
        if (!this.lJe) {
            this.lJe = true;
            m mVar = new m((System.currentTimeMillis() / 1000), i, i2);
            g.Ek();
            g.Eh().dpP.a(mVar, 0);
            boolean dE = com.tencent.mm.plugin.offline.c.a.dE(ad.getContext());
            boolean isNetworkConnected = ao.isNetworkConnected(ad.getContext());
            h hVar = h.mEJ;
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(4);
            objArr[1] = Integer.valueOf(dE ? 0 : 1);
            objArr[2] = Integer.valueOf(isNetworkConnected ? 1 : 0);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(i);
            if (k.lJx) {
                i3 = 1;
            }
            objArr[5] = Integer.valueOf(i3);
            hVar.h(14163, objArr);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(135);
            iDKey.SetValue(1);
            iDKey.SetKey(isNetworkConnected ? 36 : 37);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(135);
            iDKey.SetValue(1);
            iDKey.SetKey(dE ? 38 : 39);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(135);
            iDKey.SetValue(1);
            iDKey.SetKey(k.lJx ? 40 : 41);
            arrayList.add(iDKey);
            IDKey iDKey2;
            if (i == 2) {
                iDKey = new IDKey();
                iDKey.SetID(135);
                iDKey.SetValue(1);
                iDKey.SetKey(k.lJx ? 42 : 43);
                arrayList.add(iDKey);
                iDKey = new IDKey();
                iDKey.SetID(135);
                iDKey.SetValue(1);
                iDKey.SetKey(dE ? 44 : 45);
                arrayList.add(iDKey);
                iDKey2 = new IDKey();
                iDKey2.SetID(135);
                iDKey2.SetValue(1);
                iDKey2.SetKey(isNetworkConnected ? 46 : 47);
                arrayList.add(iDKey2);
            } else if (i == 6) {
                iDKey = new IDKey();
                iDKey.SetID(135);
                iDKey.SetValue(1);
                iDKey.SetKey(k.lJx ? 48 : 49);
                arrayList.add(iDKey);
                iDKey = new IDKey();
                iDKey.SetID(135);
                iDKey.SetValue(1);
                iDKey.SetKey(dE ? 50 : 51);
                arrayList.add(iDKey);
                iDKey2 = new IDKey();
                iDKey2.SetID(135);
                iDKey2.SetValue(1);
                iDKey2.SetKey(isNetworkConnected ? 52 : 53);
                arrayList.add(iDKey2);
            } else if (i == 6) {
                IDKey iDKey3 = new IDKey();
                iDKey3.SetID(135);
                iDKey3.SetValue(1);
                iDKey3.SetKey(dE ? 54 : 55);
                arrayList.add(iDKey3);
            }
            h.mEJ.b(arrayList, true);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        int i3 = 6;
        if ((lVar instanceof com.tencent.mm.plugin.offline.a.h) || (lVar instanceof f)) {
            ArrayList arrayList = new ArrayList();
            if (lVar instanceof m) {
                IDKey iDKey = new IDKey();
                iDKey.SetID(135);
                iDKey.SetValue(1);
                iDKey.SetKey(2);
                arrayList.add(iDKey);
                if (!(i == 0 && i2 == 0)) {
                    iDKey = new IDKey();
                    iDKey.SetID(135);
                    iDKey.SetValue(1);
                    iDKey.SetKey(3);
                    arrayList.add(iDKey);
                }
                h.mEJ.b(arrayList, true);
            }
            if ((lVar instanceof f) && ((i == 0 && i2 == 0) || i != 0)) {
                x.i("MicroMsg.OfflineTokensMgr", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                if (this.lJk != null) {
                    boolean bkV = this.lJk.bkV();
                    this.lJk = null;
                    if (bkV && this.lJj != null) {
                        this.lJj.bkI();
                    }
                }
            }
            if (i == 0 && i2 == 0) {
                if (lVar instanceof m) {
                    this.lJh = 0;
                    this.lJe = false;
                    this.mHandler.removeCallbacks(this.lJl);
                    this.lJk = (m) lVar;
                    String str2 = this.lJk.lKk;
                    k.bkO();
                    f fVar = new f(str2, k.uk(196617));
                    g.Ek();
                    g.Eh().dpP.a(fVar, 0);
                } else if (lVar instanceof com.tencent.mm.plugin.offline.a.l) {
                    this.lJf = false;
                    this.lJi = ((com.tencent.mm.plugin.offline.a.l) lVar).lJi;
                    if (this.lJj != null) {
                        this.lJj.bkI();
                    }
                } else if (!(lVar instanceof f)) {
                }
            } else if (lVar instanceof m) {
                x.e("MicroMsg.OfflineTokensMgr", "gettoken is failed!");
                this.lJh++;
                this.lJe = false;
                if (i2 == 411) {
                    x.i("MicroMsg.OfflineTokensMgr", "errcode is  411, do clearAllOfflineData");
                    com.tencent.mm.plugin.offline.c.a.blJ();
                } else if (this.lJh < this.lJg) {
                    this.mHandler.removeCallbacks(this.lJl);
                    int i4 = this.lJh - 1;
                    if (i4 <= 6) {
                        i3 = i4;
                    }
                    this.mHandler.postDelayed(this.lJl, (long) ((((int) Math.pow(2.0d, (double) i3)) * 60) * 1000));
                }
            } else if (lVar instanceof com.tencent.mm.plugin.offline.a.l) {
                this.lJf = false;
            } else if (lVar instanceof f) {
                this.lJk = null;
            }
        }
    }
}
