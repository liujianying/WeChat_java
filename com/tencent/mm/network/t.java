package com.tencent.mm.network;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.a.b;
import com.tencent.mm.network.f.a;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class t extends a implements a.a, e {
    byte[] dpW;
    int efP = 0;
    int esg = 0;
    private long esh = 0;
    private long esi = 0;
    private long esj = 0;
    private WakerLock esk = null;
    public a esl;
    a esm;
    b esn;
    long eso = 0;
    int esp = -1;
    private w esq;
    private s esr;
    g ess;
    h est;
    public ag handler;

    static /* synthetic */ void iL(int i) {
        int i2 = 0;
        x.i("MicroMsg.AutoAuth", "cancel: netid=" + i);
        if (i < 0) {
            x.e("MicroMsg.AutoAuth", "error netid < 0, " + i);
            return;
        }
        z Va = aa.Va();
        x.i("MicroMsg.MMNativeNetTaskAdapter", "stopTask netId=" + i);
        if (i >= 0 && i < 100) {
            synchronized (Va.etg) {
                if (Va.etg[i] != null) {
                    i2 = Va.etg[i].taskId;
                }
            }
            if (i2 != 0) {
                StnLogic.stopTask(i2);
            }
            synchronized (Va.etg) {
                if (Va.etg[i] != null) {
                    try {
                        x.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi stopTask outQueue: netId:%d hash:%d type:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(Va.etg[i].etk.getType()), Integer.valueOf(Va.etg[i].etk.Lb())});
                        Va.etg[i] = null;
                    } catch (Throwable e) {
                        x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bi.i(e)});
                    }
                }
            }
            return;
        }
        return;
    }

    public final /* bridge */ /* synthetic */ c Lr() {
        return this.esl;
    }

    public final /* bridge */ /* synthetic */ d Ux() {
        return this.esl;
    }

    public t(ag agVar) {
        if (agVar == null) {
            agVar = new ag();
        }
        this.handler = agVar;
        this.esl = new a(this);
        this.esk = new WakerLock(aa.getContext(), "MicroMsg.AutoAuth");
        this.esm = new a(this, this.esk);
        this.esn = new b(this, this.esk);
        this.esq = new w(aa.duN + "autoauth.cfg");
    }

    protected final void finalize() {
        reset();
        super.finalize();
    }

    public final void cancel(int i) {
        this.esk.lock(1000, String.format("MMAutoAuth.cancel,%d", new Object[]{Integer.valueOf(i)}));
        new 1(this, i).a(this.handler);
    }

    public final boolean Lh() {
        return this.esg < 5;
    }

    public final String getNetworkServerIp() {
        return MMLogic.getNetworkServerIp();
    }

    public final String[] getIPsString(boolean z) {
        return MMLogic.getIPsString(z);
    }

    public final void reset() {
        this.esk.lock(1000, "MMAutoAuth.reset");
        new 6(this).a(this.handler);
    }

    public final synchronized int a(r rVar, l lVar) {
        this.esk.lock(1000, "MMAutoAuth.send");
        return ((Integer) new 7(this, Integer.valueOf(-1), rVar, lVar).a(this.handler)).intValue();
    }

    public final boolean UD() {
        if (90000 >= SystemClock.elapsedRealtime() - this.esi) {
            x.w("MicroMsg.AutoAuth", "auto limit lastSessionTimeout=%d, curtime=%d", new Object[]{Long.valueOf(this.esi), Long.valueOf(SystemClock.elapsedRealtime())});
            return false;
        }
        this.esi = SystemClock.elapsedRealtime();
        this.esl.x(new byte[0], this.esl.Df());
        return true;
    }

    public final void bC(boolean z) {
        new 8(this, Integer.valueOf(-1), z).a(this.handler);
    }

    public final void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4) {
        ArrayList arrayList;
        this.esk.lock(1000, "MMAutoAuth.setIDCHostInfo");
        List<n> Uz = n.Uz(str2);
        List<n> Uz2 = n.Uz(str);
        String str5 = "MicroMsg.AutoAuth";
        String str6 = "dkidc setIDCHostInfo short:[%s][%s](%d) long:[%s][%s](%d) reset:%s";
        Object[] objArr = new Object[7];
        objArr[0] = str3;
        objArr[1] = str;
        objArr[2] = Integer.valueOf(Uz2.size());
        objArr[3] = str4;
        objArr[4] = str2;
        objArr[5] = Integer.valueOf(Uz.size());
        objArr[6] = z ? "!!!!!CHANGE IDC NOW" : "false";
        x.d(str5, str6, objArr);
        Map hashMap = new HashMap();
        for (n nVar : Uz) {
            arrayList = (ArrayList) hashMap.get(nVar.host);
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(nVar.host, arrayList);
            }
            arrayList.add(nVar.kCs);
        }
        Map hashMap2 = new HashMap();
        for (n nVar2 : Uz2) {
            arrayList = (ArrayList) hashMap2.get(nVar2.host);
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap2.put(nVar2.host, arrayList);
            }
            arrayList.add(nVar2.kCs);
        }
        new 9(this, Integer.valueOf(-1), hashMap, hashMap2, iArr2, iArr).a(this.handler);
    }

    public final void d(String str, String str2, String str3, String str4) {
        this.esk.lock(1000, "MMAutoAuth.setFixedHost");
        x.i("MicroMsg.AutoAuth", "dkidc setFixedHost debug short:%s:%s long:%s:%s", new Object[]{str, str2, str3, str4});
        if (bi.oW(str) || bi.oW(str3)) {
            x.w("MicroMsg.AutoAuth", "dkidc setFixedHost FAILED ! check assist");
        } else {
            new 10(this, Integer.valueOf(-1), str, str2, str3, str4).a(this.handler);
        }
    }

    public final void setNewDnsDebugHost(String str, String str2) {
        if (bi.oW(str) && bi.oW(str2)) {
            x.d("MicroMsg.AutoAuth", "setNewDnsDebugHost FAILED ! check assist");
        } else {
            new 11(this, str, str2).a(this.handler);
        }
    }

    public final void Uy() {
        this.esk.lock(1000, "MMAutoAuth.forceUpdateHostCache");
        new 13(this, Integer.valueOf(-1)).a(this.handler);
    }

    public final void kg(String str) {
        this.esk.lock(1000, "MMAutoAuth.ipxxStatistics");
        new 2(this, str).a(this.handler);
    }

    public final void a(b bVar) {
        aa.UV().etx = bVar;
    }

    public final i Uz() {
        return aa.UW();
    }

    final boolean UE() {
        if (10001 == af.exm && af.exn > 0) {
            af.exn = 0;
            UD();
        }
        if (this.esl.Ln()) {
            return true;
        }
        if (aa.Va().UN()) {
            x.i("MicroMsg.AutoAuth", "makeSureAuth hasAuthCmd ret false");
            return false;
        } else if (this.esp != -1) {
            x.w("MicroMsg.AutoAuth", "makeSureAuth auto limit now is getting cert, ret false");
            return false;
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (60000 >= elapsedRealtime - this.esh && this.esh > 0) {
                x.w("MicroMsg.AutoAuth", "makeSureAuth auto limit lastAutoAuthtime=%d, curtime=%d, return false", new Object[]{Long.valueOf(this.esh), Long.valueOf(elapsedRealtime)});
                return false;
            } else if (ad.getContext().getSharedPreferences("auth_hold_prefs", 0).getBoolean("auth_ishold", false)) {
                x.i("MicroMsg.AutoAuth", "makeSureAuth AUTH_HOLD_KEY hold ret false");
                if (!aa.Va().UO()) {
                    x.e("MicroMsg.AutoAuth", "sendImp hit push hold, pid:%d, stack[%s]", new Object[]{Integer.valueOf(Process.myPid()), bi.cjd()});
                    aa.UX().post(new 3(this));
                }
                return false;
            } else {
                r ca = aa.Va().ca(UG());
                if (ca != null) {
                    try {
                        if (!(ca instanceof r.a)) {
                            this.esh = SystemClock.elapsedRealtime();
                            x.i("MicroMsg.AutoAuth", "makeSureAuth rest lastAutoAuthTime[%d]", new Object[]{Long.valueOf(this.esh)});
                            a(ca, 3, 3);
                        } else if (30000 < elapsedRealtime - this.esj || this.esj <= 0) {
                            x.i("MicroMsg.AutoAuth", "makeSureAuth session time out in push_notify mode, send broast to mm");
                            this.esj = SystemClock.elapsedRealtime();
                            aa.Vb().onPush(5, null);
                        } else {
                            x.i("MicroMsg.AutoAuth", "makeSureAuth session time out in push_notify mode, but hit limit");
                            return false;
                        }
                    } catch (Throwable e) {
                        x.e("MicroMsg.AutoAuth", "makeSureAuth exception:%s", new Object[]{bi.i(e)});
                    }
                } else {
                    x.i("MicroMsg.AutoAuth", "makeSureAuth getAutoAuthRR is null");
                }
                x.i("MicroMsg.AutoAuth", "makeSureAuth at last ret false");
                return false;
            }
        }
    }

    final void c(int i, int i2, String str) {
        int i3;
        x.i("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail inErrType=" + i + ", inErrCode=" + i2 + ", errMsg=" + str + " stack=" + bi.cjd());
        if (i == 4 && i2 == -106) {
            x.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth should not be return MM_ERR_BLOCK_BY_SPAM trans to MM_ERR_AUTH_ANOTHERPLACE");
            i3 = -100;
        } else {
            i3 = i2;
        }
        if (i == 5 && i2 == -13) {
            x.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth should not be return MM_ERR_SESSIONTIMEOUT trans to MM_ERR_PASSWORD");
            i = 4;
            i3 = -3;
            f.mDy.a(148, 42, 1, false);
        }
        int i4 = i;
        if ((i4 == 6 && i2 == -10001) || (i4 == 5 && i2 != -13)) {
            x.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth ENCODE ERROR check sp");
            SharedPreferences Ib = aw.Ib();
            String string = Ib.getString("_auth_key", "");
            String string2 = Ib.getString("server_id", "");
            if (bi.oW(string) && bi.oW(string2)) {
                x.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth ENCODE ERROR check sp aak and cookie null logout");
                i3 = -104;
                f.mDy.a(148, 52, 1, false);
                i4 = 4;
            }
        }
        aa.Va().d(i4, i3, str);
        if (i4 != 4) {
            return;
        }
        if (i3 == -100 || i3 == -205 || i3 == -213) {
            ad.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().putBoolean("auth_ishold", true).commit();
            reset();
        }
    }

    final boolean f(String str, String str2, int i) {
        boolean z;
        int i2;
        int i3;
        String string;
        ad.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().remove("auth_ishold").commit();
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("auth_info_key_prefs", 4);
        boolean z2 = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
        int i4 = sharedPreferences.getInt("key_auth_update_version", 0);
        int i5 = sharedPreferences.getInt("_auth_uin", 0);
        String string2 = sharedPreferences.getString("_auth_key", "");
        String string3 = sharedPreferences.getString("server_id", "");
        Editor edit = sharedPreferences.edit();
        edit.putBoolean("key_auth_info_prefs_created", true);
        edit.putInt("key_auth_update_version", d.qVN);
        edit.putInt("_auth_uin", i);
        edit.putString("_auth_key", str);
        edit.putString("server_id", str2);
        if (!edit.commit()) {
            x.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed 1th!");
            f.mDy.a(148, 36, 1, false);
            if (!edit.commit()) {
                x.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed 2nd!");
                f.mDy.a(148, 37, 1, false);
                z = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
                i2 = sharedPreferences.getInt("key_auth_update_version", 0);
                i3 = sharedPreferences.getInt("_auth_uin", 0);
                string = sharedPreferences.getString("_auth_key", "");
                String string4 = sharedPreferences.getString("server_id", "");
                x.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed 2th so ret false old vs new vs input create[%b, %b, %b] version[%d, %d, %d], uin[%d, %d, %d], aak[%s, %s, %s], cookie[%s, %s, %s]", new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(true), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(d.qVN), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i), string2, string, str, string3, string4, str2});
                x.chR();
                return false;
            }
        }
        z = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
        i2 = sharedPreferences.getInt("key_auth_update_version", 0);
        i3 = sharedPreferences.getInt("_auth_uin", 0);
        string = sharedPreferences.getString("_auth_key", "");
        String string5 = sharedPreferences.getString("server_id", "");
        if (z && i2 == d.qVN && i3 == i && string.equals(str) && string5.equals(str2)) {
            this.esq.chA();
            this.esq.set(1, Integer.valueOf(d.qVN));
            this.esq.set(2, Integer.valueOf(i));
            this.esq.set(3, str);
            this.esq.set(4, str2);
            this.esq.ckR();
            String str3 = "MicroMsg.AutoAuth";
            String str4 = "summerauth save aak & id ok old vs new vs input[%b, %b, %b, %b] version[%d, %d, %d. %d], uin[%d, %d, %d, %d], aak[%s, %s, %s, %s], cookie[%s, %s, %s, %s]";
            Object[] objArr = new Object[20];
            objArr[0] = Boolean.valueOf(z2);
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(true);
            objArr[3] = Boolean.valueOf(!this.esq.sOl);
            objArr[4] = Integer.valueOf(i4);
            objArr[5] = Integer.valueOf(i2);
            objArr[6] = Integer.valueOf(d.qVN);
            objArr[7] = (Integer) this.esq.get(1);
            objArr[8] = Integer.valueOf(i5);
            objArr[9] = Integer.valueOf(i3);
            objArr[10] = Integer.valueOf(i);
            objArr[11] = (Integer) this.esq.get(2);
            objArr[12] = string2;
            objArr[13] = string;
            objArr[14] = str;
            objArr[15] = (String) this.esq.get(3);
            objArr[16] = string3;
            objArr[17] = string5;
            objArr[18] = str2;
            objArr[19] = (String) this.esq.get(4);
            x.i(str3, str4, objArr);
            return true;
        }
        x.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed check not equal so ret false old vs new vs input create[%b, %b, %b] version[%d, %d, %d], uin[%d, %d, %d], aak[%s, %s, %s], cookie[%s, %s, %s]", new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(true), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(d.qVN), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i), string2, string, str, string3, string5, str2});
        x.chR();
        return false;
    }

    final void a(r rVar, int i, int i2) {
        rVar.a(this.esm, i, i2);
    }

    public final void a(com.tencent.mm.protocal.x xVar) {
        aa.Va().UP();
    }

    public final byte[] UF() {
        if (!this.esl.Ln()) {
            return null;
        }
        com.tencent.mm.protocal.w.a aVar = new com.tencent.mm.protocal.w.a();
        aVar.uin = this.esl.Df();
        aVar.dZu = bi.WP(ad.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", ""));
        aVar.netType = com.tencent.mm.protocal.a.getNetType(ad.getContext());
        aVar.qWE = com.tencent.mm.protocal.a.cfW();
        try {
            byte[] Ie = aVar.Ie();
            this.dpW = aVar.dpW;
            return Ie;
        } catch (Throwable e) {
            x.e("MicroMsg.AutoAuth", "exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }

    public final int getHostByName(String str, List<String> list) {
        return MMLogic.getHostByName(str, list);
    }

    public final int a(boolean z, List<String> list) {
        return MMLogic.getSnsIpsForScene(list, z);
    }

    public final int a(String str, boolean z, List<String> list) {
        return MMLogic.getSnsIpsForSceneWithHostName(list, str, z);
    }

    public final String getIspId() {
        return MMLogic.getIspId();
    }

    public final void setHostInfo(String[] strArr, String[] strArr2, int[] iArr) {
        this.esk.lock(1000, "MMAutoAuth.setHostInfo");
        new 4(this, strArr, strArr2, iArr).a(this.handler);
    }

    public final int h(int i, byte[] bArr) {
        return ae.Vg().i(i, bArr);
    }

    public final void a(int i, String str, int i2, boolean z) {
        this.esk.lock(1000, "MMAutoAuth.logUtil");
        new 5(this, i, i2, str, z).a(this.handler);
    }

    public final void setSignallingStrategy(long j, long j2) {
        StnLogic.setSignallingStrategy(j, j2);
    }

    public final void keepSignalling() {
        StnLogic.keepSignalling();
    }

    public final void stopSignalling() {
        StnLogic.stopSignalling();
    }

    public final void a(o oVar) {
        aa.Vd().esY = oVar;
    }

    public final void a(s sVar) {
        this.esr = sVar;
    }

    public final boolean UG() {
        boolean z = false;
        if (this.esr == null) {
            return z;
        }
        try {
            return this.esr.uP();
        } catch (RemoteException e) {
            return z;
        }
    }

    public final void a(g gVar) {
        this.ess = gVar;
    }

    public final void reportFailIp(String str) {
        MMLogic.reportFailIp(str);
    }

    public final void kh(String str) {
        x.e("MicroMsg.AutoAuth", "killPush %s", new Object[]{str});
    }

    public final void bD(boolean z) {
        if (com.tencent.mm.sdk.b.a.sFg == null) {
            x.w("MicroMsg.AutoAuth", "loginevent but eventpool null, event:" + z);
        } else if (z) {
            com.tencent.mm.sdk.b.a.sFg.m(new av());
        } else {
            com.tencent.mm.sdk.b.a.sFg.m(new gu());
        }
    }

    public final i Ls() {
        return null;
    }

    public final void bE(boolean z) {
        com.tencent.mm.sdk.platformtools.w.initLanguage(ad.getContext());
    }

    public final void bF(boolean z) {
        x.d("MicroMsg.AutoAuth", "summer setMMTLS enable[%b]", new Object[]{Boolean.valueOf(z)});
        MMLogic.setMmtlsCtrlInfo(z);
    }

    public final void Lt() {
        StnLogic.makesureLongLinkConnected();
    }

    public final void Lu() {
        StnLogic.startNetworkAnalysis();
    }

    public final void a(h hVar) {
        this.est = hVar;
    }
}
