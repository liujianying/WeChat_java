package com.tencent.mm.plugin.emoji.sync;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public final class BKGLoaderManager implements e {
    boolean bts = false;
    int dTp;
    public Vector<d> ijA = new Vector();
    public Vector<d> ijB = new Vector();
    public Vector<d> ijC = new Vector();
    public Set<c> ijD = new HashSet();
    public ConnectivityReceiver ijE;
    long ijF = 0;
    long ijG = 0;
    al ijH = new al(Looper.getMainLooper(), new 1(this), false);
    public c ijI = new 2(this);
    public c ijJ = new 3(this);
    public int ijp = 0;
    private int ijq = 0;
    public boolean ijr = false;
    boolean ijs = false;
    boolean ijt = false;
    public boolean iju = false;
    public boolean ijv = false;
    private boolean ijw = false;
    boolean ijx = false;
    d ijy = null;
    private b ijz;
    int mNetWorkType = -1;

    public BKGLoaderManager(b bVar) {
        this.ijz = bVar;
        this.dTp = Process.myUid();
        this.mNetWorkType = ao.getNetType(ad.getContext());
    }

    public final void aO(List<d> list) {
        if (this.ijB == null) {
            this.ijB = new Vector();
        }
        if (list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                d dVar = (d) list.get(i);
                if (dVar == null || this.ijB.contains(dVar)) {
                    x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[]{dVar.getKey()});
                } else {
                    this.ijB.add(dVar);
                }
            }
        }
    }

    public final synchronized void aEV() {
        if (ao.isWifi(ad.getContext()) || this.ijr) {
            if (this.ijA != null && this.ijA.size() > 0) {
                this.ijx = f.Aa();
                this.ijs = true;
                this.ijt = false;
                this.ijv = false;
                this.iju = false;
                if (this.ijx) {
                    x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] sdcard is full.");
                } else {
                    this.ijy = (d) this.ijA.remove(0);
                    this.ijy.a(this);
                    this.ijz.ijn.execute(this.ijy);
                    x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s donwload list size:%d", new Object[]{this.ijy.getKey(), Integer.valueOf(this.ijA.size())});
                }
                aEX();
            } else if (this.ijB == null || this.ijB.size() <= 0) {
                x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart no task list .");
                if (this.ijA == null || this.ijA.size() <= 0) {
                    if (this.ijs && this.bts) {
                        this.ijv = true;
                    }
                    this.ijs = false;
                }
                if (this.ijB == null || this.ijB.size() <= 0) {
                    if (this.ijt && this.bts) {
                        this.ijw = true;
                    }
                    this.ijt = false;
                }
                if ((this.ijA == null || this.ijA.size() <= 0) && ((this.ijB == null || this.ijB.size() <= 0) && ((this.ijs || this.ijt) && this.bts))) {
                    this.ijt = false;
                    this.ijs = false;
                }
                this.ijr = false;
                aEX();
            } else {
                this.ijt = true;
                this.ijs = false;
                this.ijw = false;
                this.iju = false;
                this.ijy = (d) this.ijB.remove(0);
                this.ijy.a(this);
                this.ijz.ijn.execute(this.ijy);
                x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s upload list size:%d", new Object[]{this.ijy.getKey(), Integer.valueOf(this.ijB.size())});
                aEX();
            }
            if (!(this.ijt || this.ijs)) {
                if (this.ijC == null || this.ijC.size() <= 0) {
                    this.iju = false;
                } else {
                    this.iju = true;
                    this.ijy = (d) this.ijC.remove(0);
                    this.ijy.a(this);
                    this.ijz.ijn.execute(this.ijy);
                    x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart download store emoji task is runing. productID:%s size:%d", new Object[]{this.ijy.getKey(), Integer.valueOf(this.ijC.size())});
                }
            }
        } else if (aDK()) {
            x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is 3g or 4g]");
            this.ijs = false;
            this.ijt = false;
            this.ijv = false;
            this.iju = false;
            aEX();
        } else {
            x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is not wifi, 3g nor 4g]");
        }
    }

    public final void aEW() {
        this.ijs = false;
        this.ijt = false;
        this.ijr = false;
        aEX();
        if (this.ijy != null) {
            this.ijy.cancel();
        }
    }

    public final void aEX() {
        if (this.ijD != null && this.ijD.size() > 0) {
            for (c aEZ : this.ijD) {
                aEZ.aEZ();
            }
        }
    }

    public final void zI(String str) {
        x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is ruing. key:%s", new Object[]{str});
    }

    public final void j(String str, int i, boolean z) {
        x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is finish. key:%s success:%b", new Object[]{str, Boolean.valueOf(z)});
        if (this.ijy == null || bi.oW(str)) {
            x.e("MicroMsg.BKGLoader.BKGLoaderManager", "CurrentTask or key is null. or key is no equal crrentkey ");
            return;
        }
        if (this.ijA.contains(this.ijy)) {
            this.ijA.remove(this.ijy);
        } else if (this.ijB.contains(this.ijy)) {
            this.ijB.remove(this.ijy);
        } else if (this.ijC.contains(this.ijy)) {
            this.ijC.remove(this.ijy);
        }
        if (!z) {
            x.i("MicroMsg.BKGLoader.BKGLoaderManager", "retry later.");
        } else if (!(i == 2 || this.ijD == null || this.ijD.size() <= 0)) {
            for (c aFa : this.ijD) {
                aFa.aFa();
            }
        }
        if (i == 2) {
            this.ijH.J(5000, 5000);
        } else {
            this.ijH.J(1000, 1000);
        }
    }

    public static boolean aEY() {
        NetworkInfo networkInfo = ((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getNetworkInfo(1);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    public static boolean aDK() {
        return ao.is3G(ad.getContext()) || ao.is4G(ad.getContext()) || ao.is2G(ad.getContext());
    }
}
