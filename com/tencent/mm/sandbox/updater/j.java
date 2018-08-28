package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.c.i;
import com.tencent.mm.c.i.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.b$a;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sandbox.updater.f.2;
import com.tencent.mm.sandbox.updater.f.3;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class j implements a, g {
    public String bKg;
    public int bRt;
    public int bxm;
    public String bxo;
    public byte[] ccH;
    public String desc;
    public byte[] erT;
    public byte[] erV;
    private Intent intent;
    protected Context mContext;
    public int nPm;
    private Notification owf;
    public String[] sDK;
    public int sDi;
    ArrayList<g> sEA;
    public String[] sEB;
    public String sEC;
    public i sED;
    public a sEE;
    public boolean sEF;
    public boolean sEG;
    public boolean sEH;
    public String sEI;
    public boolean sEJ;
    boolean sEK;
    long sEL;
    f sEM;
    private long sEN;
    private b$a sEO;
    c sEz;
    public int size;
    public int uin;

    /* synthetic */ j(byte b) {
        this();
    }

    static /* synthetic */ void a(j jVar, int i, int i2) {
        CharSequence string = jVar.mContext.getString(R.l.app_download_update_package);
        CharSequence charSequence;
        Intent intent;
        Builder contentIntent;
        if (i < i2) {
            long j = (((long) i) * 100) / ((long) i2);
            if (j - jVar.sEN >= 1) {
                jVar.sEN = j;
                charSequence = jVar.mContext.getString(R.l.app_downloading) + String.valueOf(jVar.sEN) + "%";
                intent = new Intent(jVar.intent);
                intent.setClass(jVar.mContext, AppUpdaterUI.class);
                intent.addFlags(536870912);
                contentIntent = new Builder(jVar.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(charSequence).setContentIntent(PendingIntent.getActivity(jVar.mContext, 0, intent, 134217728));
                contentIntent.setLargeIcon(BitmapFactory.decodeResource(jVar.mContext.getResources(), R.g.update_package_download_anim0));
                contentIntent.setSmallIcon(com.tencent.mm.bf.a.cbg());
                jVar.owf = contentIntent.getNotification();
                jVar.owf.icon = R.g.update_package_download_anim0;
            } else {
                return;
            }
        } else if (!jVar.sEJ || e.cn(jVar.sEz.cgL())) {
            charSequence = jVar.mContext.getString(R.l.app_download_finish);
            intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(jVar.sEz.cgL())), "application/vnd.android.package-archive");
            intent.addFlags(536870912);
            contentIntent = new Builder(jVar.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(charSequence).setContentIntent(PendingIntent.getActivity(jVar.mContext, 0, intent, 134217728));
            contentIntent.setLargeIcon(BitmapFactory.decodeResource(jVar.mContext.getResources(), R.g.update_package_download_anim0));
            contentIntent.setSmallIcon(com.tencent.mm.bf.a.cbg());
            jVar.owf = contentIntent.getNotification();
            jVar.owf.icon = R.g.update_package_download_anim0;
            Notification notification = jVar.owf;
            notification.flags |= 16;
        } else {
            x.i("MicroMsg.UpdaterManager", "do noting. wait for merge apk.");
        }
        if (!jVar.sEG) {
            ((NotificationManager) jVar.mContext.getSystemService("notification")).notify(99, jVar.owf);
        }
    }

    static /* synthetic */ void b(j jVar) {
        x.i("MicroMsg.UpdaterManager", "showDownloadFullPackNotification()");
        CharSequence string = jVar.mContext.getString(R.l.app_download_update_package_try_full_pack, new Object[]{bi.bF((long) jVar.size)});
        Intent intent = jVar.intent;
        intent.putExtra("intent_extra_force_download_full", true);
        jVar.owf = new Builder(jVar.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(null).setContentIntent(PendingIntent.getService(jVar.mContext, 0, intent, 134217728)).getNotification();
        jVar.owf.icon = R.g.update_package_download_anim0;
        Notification notification = jVar.owf;
        notification.flags |= 16;
        ((NotificationManager) jVar.mContext.getSystemService("notification")).notify(99, jVar.owf);
    }

    static /* synthetic */ void e(j jVar) {
        CharSequence string = jVar.mContext.getString(R.l.app_download_update_package_from_website);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
        intent.addFlags(268435456);
        jVar.owf = new Builder(jVar.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(null).setContentIntent(PendingIntent.getActivity(jVar.mContext, 0, intent, 134217728)).getNotification();
        jVar.owf.icon = R.g.update_package_download_anim0;
        Notification notification = jVar.owf;
        notification.flags |= 16;
        ((NotificationManager) jVar.mContext.getSystemService("notification")).notify(99, jVar.owf);
    }

    private j() {
        this.sEz = null;
        this.sEA = new ArrayList(1);
        this.bRt = d.qVN;
        this.sEF = false;
        this.sEG = false;
        this.sEH = false;
        this.sEJ = false;
        this.sEK = false;
        this.intent = null;
        this.owf = null;
        this.mContext = null;
        this.sEM = new f(this);
        this.sEN = -1;
        this.sEO = new b$a() {
            public final void co(int i, int i2) {
                x.i("MicroMsg.UpdaterManager", "total=%d, offset=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                if (j.this.nPm != 2) {
                    j.a(j.this, i2, i);
                }
                j.this.co(i, i2);
            }

            public final void a(int i, int i2, bhp bhp) {
                j.this.sEK = false;
                j.this.sEM.stop();
                j.this.sEL = System.currentTimeMillis();
                if (j.this.sEz == null) {
                    j.this.ai(2, true);
                } else if (i == 200 && i2 == 0) {
                    x.i("MicroMsg.UpdaterManager", "packCallback onSceneEnd ok");
                    if (j.this.nPm != 2) {
                        j.a(j.this, 100, 100);
                    }
                    if (j.this.sEF) {
                        i.ah(j.this.mContext, 0);
                    } else {
                        i.ah(j.this.mContext, 9);
                    }
                    j.this.sEC = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "yyb_pkg_sig_prefs", 4).getString(ad.getPackageName(), "");
                    x.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess onSceneEnd sig[%s], path[%s]", new Object[]{j.this.sEC, j.this.sEz.cgL()});
                    if (bi.oW(j.this.sEC)) {
                        h.mEJ.a(322, 8, 1, false);
                        h.mEJ.h(11098, new Object[]{Integer.valueOf(4008)});
                    } else {
                        try {
                            com.tencent.mm.c.c.c(new File(j.this.sEz.cgL()), j.this.sEC);
                            x.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode done");
                            h.mEJ.a(322, 6, 1, false);
                            h.mEJ.h(11098, new Object[]{Integer.valueOf(4006), j.this.sEC});
                        } catch (Exception e) {
                            x.w("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode e: " + e.getMessage());
                            h.mEJ.a(322, 7, 1, false);
                            h.mEJ.h(11098, new Object[]{Integer.valueOf(4007), e.getMessage()});
                        }
                    }
                    if (j.this.nPm == 1) {
                        i.ai(j.this.mContext, 8);
                        i.a(j.this.bKg, j.this.sEC, j.this.desc, j.this.size, j.this.nPm, j.this.sDi, j.this.sEI);
                        j.this.MX(j.this.sEz.cgL());
                        if (j.this.sEJ) {
                            h.mEJ.a(614, 58, 1, false);
                            x.d("MicroMsg.UpdaterManager", "boots download success.");
                        }
                    } else if (j.this.nPm == 0) {
                        j.this.MX(j.this.sEz.cgL());
                    } else if (j.this.nPm == 2) {
                        i.ai(j.this.mContext, 1);
                        i.a(j.this.bKg, j.this.sEC, j.this.desc, j.this.size, j.this.nPm, j.this.sDi, j.this.sEI);
                    }
                    i.chf();
                } else if (i2 == -13) {
                    x.e("MicroMsg.UpdaterManager", "session timeout, killself and restart");
                    UpdaterService.cy();
                    AppUpdaterUI.cgP();
                    i.che();
                } else {
                    if (!(j.this.sEz instanceof c) || j.this.sDi == 4) {
                        x.e("MicroMsg.UpdaterManager", "update failed");
                        i.ah(j.this.mContext, 10);
                        if (j.this.nPm == 1) {
                            j.e(j.this);
                        } else if (j.this.nPm == 0) {
                            j.this.ai(1, true);
                        }
                    } else {
                        x.e("MicroMsg.UpdaterManager", "download package from cdn error.");
                        if (j.this.sEF) {
                            if (i == 3 || i == 4 || i == 2 || i == 1 || i == 13) {
                                i.ah(j.this.mContext, i);
                            }
                            j.this.sEF = false;
                            if (j.this.nPm == 1) {
                                if (j.this.sEJ) {
                                    x.d("MicroMsg.UpdaterManager", "boots download failed. %d", new Object[]{Integer.valueOf(i)});
                                    switch (i) {
                                        case 1:
                                            h.mEJ.a(614, 51, 1, false);
                                            break;
                                        case 2:
                                            h.mEJ.a(614, 54, 1, false);
                                            break;
                                        case 3:
                                            h.mEJ.a(614, 52, 1, false);
                                            break;
                                        case 4:
                                            h.mEJ.a(614, 53, 1, false);
                                            break;
                                        case 13:
                                            h.mEJ.a(614, 55, 1, false);
                                            break;
                                    }
                                }
                                j.b(j.this);
                            } else if (j.this.nPm == 0) {
                                j.this.ai(1, true);
                            } else if (j.this.nPm == 2) {
                                j.this.chk();
                            }
                        } else {
                            j.this.sEz = new b(j.this.size, j.this.bKg, j.this.sDi, j.this.uin, j.this.erT, j.this.ccH, j.this.sEB, j.this.nPm == 2);
                            j.this.chj();
                        }
                    }
                    j.this.a(j.this.sEz);
                }
            }

            public final void fV(long j) {
                f fVar = j.this.sEM;
                fVar.bAZ.post(new 2(fVar, j));
            }

            public final void fW(long j) {
                f fVar = j.this.sEM;
                fVar.bAZ.post(new 3(fVar, j));
            }
        };
        this.mContext = ad.getContext();
    }

    public final void la(boolean z) {
        x.i("MicroMsg.UpdaterManager", "summerupdate setNetStatChanged isWifi %s", new Object[]{Boolean.valueOf(z)});
        f fVar = this.sEM;
        if (fVar.iXC != z) {
            fVar.lb(true);
            fVar.iXC = z;
        }
        if (this.nPm != 2 || this.sEK) {
            x.i("MicroMsg.UpdaterManager", "downloadMode %s downloading %s", new Object[]{Integer.valueOf(this.nPm), Boolean.valueOf(this.sEK)});
        } else if (z) {
            if (ap(this.intent)) {
                lc(true);
            }
        } else if (this.sEK) {
            cancel();
        }
    }

    public final boolean ao(Intent intent) {
        boolean ap = ap(intent);
        x.i("MicroMsg.UpdaterManager", "summerupdate handleCommand(Intent intent) ret need download[%b]", new Object[]{Boolean.valueOf(ap)});
        if (ap) {
            lc(false);
        }
        return ap;
    }

    public final boolean ap(Intent intent) {
        x.i("MicroMsg.UpdaterManager", "handleCommand(Intent intent)");
        if (intent == null) {
            x.i("MicroMsg.UpdaterManager", "intent == null");
            return false;
        }
        int intExtra = intent.getIntExtra("intent_update_type", 3);
        int intExtra2 = intent.getIntExtra("intent_extra_download_mode", 1);
        String stringExtra = intent.getStringExtra("intent_extra_md5");
        if (this.sEK && !stringExtra.equalsIgnoreCase(this.bKg) && this.nPm == 2) {
            cancel();
        } else if (this.sEK) {
            x.i("MicroMsg.UpdaterManager", "downloading, duplicate download request");
            return true;
        }
        i.chf();
        reset();
        this.intent = intent;
        this.bxm = intent.getIntExtra("intent_extra_updateMode", 0);
        this.bxo = intent.getStringExtra("intent_extra_marketUrl");
        this.sEB = intent.getStringArrayExtra("intent_short_ips");
        this.bRt = intent.getIntExtra("intent_client_version", d.qVN);
        d.qVN = this.bRt;
        this.sDi = intExtra;
        this.erT = intent.getByteArrayExtra("intent_extra_session");
        this.ccH = intent.getByteArrayExtra("intent_extra_cookie");
        this.erV = intent.getByteArrayExtra("intent_extra_ecdhkey");
        this.uin = intent.getIntExtra("intent_extra_uin", 0);
        this.bKg = stringExtra;
        this.desc = intent.getStringExtra("intent_extra_desc");
        this.size = intent.getIntExtra("intent_extra_size", 0);
        this.sDK = intent.getStringArrayExtra("intent_extra_download_url");
        this.nPm = intExtra2;
        this.sEH = intent.getBooleanExtra("intent_extra_force_download_full", false);
        String stringExtra2 = intent.getStringExtra("intent_extra_patchInfo");
        if (stringExtra2 != null) {
            x.i("MicroMsg.UpdaterManager", "patchXml != null");
            this.sED = i.cG(stringExtra2);
        }
        stringExtra2 = intent.getStringExtra("intent_extra_extinfo");
        x.d("MicroMsg.UpdaterManager", "summerupdate extInfo[%s]", new Object[]{stringExtra2});
        if (!bi.oW(stringExtra2)) {
            this.sEI = (String) bl.z(stringExtra2, "extinfo").get(".extinfo.notautodownloadrange");
            x.i("MicroMsg.UpdaterManager", "summerupdate notAutoDownloadRange[%s]", new Object[]{this.sEI});
        }
        x.i("MicroMsg.UpdaterManager", "summerupdate handleCommand() downloadMode %s downloading %s", new Object[]{Integer.valueOf(intExtra2), Boolean.valueOf(this.sEK)});
        if (intExtra != 999 || this.sDK == null || this.sDK.length <= 0) {
            if (this.sDK != null) {
                for (String str : this.sDK) {
                    x.i("MicroMsg.UpdaterManager", "download url : " + str);
                }
            }
            x.i("MicroMsg.UpdaterManager", "md5 = %s , size = %s", new Object[]{stringExtra, Integer.valueOf(this.size)});
            if (stringExtra == null || this.size == 0) {
                return false;
            }
            if (intExtra == 2) {
                x.i("MicroMsg.UpdaterManager", "summerupdate handleCommandWithoutDownload recommended control[%b]", new Object[]{Boolean.valueOf(b.lz(this.sEI))});
                if (b.lz(this.sEI)) {
                    h.mEJ.a(405, 78, 1, true);
                    return false;
                }
            }
            if (this.sED != null) {
                x.i("MicroMsg.UpdaterManager", "patchInfo != null");
                stringExtra2 = com.tencent.mm.pluginsdk.f.i.eU(this.mContext);
                this.sEE = this.sED.cF(stringExtra2);
                x.i("MicroMsg.UpdaterManager", "increase apkMD5 = " + stringExtra2 + " : " + (this.sEE == null ? "not match" : "match"));
            }
            x.i("MicroMsg.UpdaterManager", "forceDownloadFull : %s", new Object[]{Boolean.valueOf(this.sEH)});
            this.sEJ = intent.getBooleanExtra("intent_extra_tinker_patch", false);
            if ((this.sEE == null || c.VQ(stringExtra)) && !this.sEJ) {
                x.i("MicroMsg.UpdaterManager", "had try to download full pack.");
            } else {
                x.i("MicroMsg.UpdaterManager", "isIncresmentUpdate");
                this.sEF = true;
            }
            stringExtra2 = i.cce();
            if (bi.oW(stringExtra2) || stringExtra2.equals(stringExtra)) {
                return true;
            }
            i.chg();
            return true;
        } else if (intExtra2 != 2) {
            return true;
        } else {
            x.e("MicroMsg.UpdaterManager", "error! DOWNLOAD_MODE_SLIENCE download don't go here! we must process it before start download");
            return true;
        }
    }

    public final void chh() {
        lc(false);
    }

    private void lc(boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.UpdaterManager", "download() isWifiRetry %s", new Object[]{Boolean.valueOf(z)});
        x.i("MicroMsg.UpdaterManager", "summerupdate download() downloadMode %s downloading %s", new Object[]{Integer.valueOf(this.nPm), Boolean.valueOf(this.sEK)});
        if (this.intent == null) {
            x.e("MicroMsg.UpdaterManager", "download() haven't handleCommand");
        } else if (this.sEK) {
            x.i("MicroMsg.UpdaterManager", "download() downloading, duplicate download request");
        } else if (com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted")) {
            if (this.nPm == 2 && !z) {
                i.ai(this.mContext, 0);
            }
            String Hw = c.Hw(this.bKg);
            x.i("MicroMsg.UpdaterManager", Hw);
            if (Hw != null) {
                x.i("MicroMsg.UpdaterManager", "update package already exist.");
                ai(1, true);
                MX(Hw);
                if (this.nPm == 2 && !i.VT(this.bKg)) {
                    i.a(this.bKg, this.sEC, this.desc, this.size, this.nPm, this.sDi, this.sEI);
                    return;
                }
                return;
            }
            if (this.sEH) {
                if (this.sEz != null) {
                    this.sEz.deleteTempFile();
                }
                i.ah(this.mContext, 11);
            }
            if (!this.sEH && this.sEF && this.sED != null && this.sEE != null) {
                x.i("MicroMsg.UpdaterManager", "Incresment Update");
                i.ah(this.mContext, 5);
                if (f.aM((long) (this.size + this.sEE.size))) {
                    cancel();
                    int i = this.sEE.size;
                    String str = this.bKg;
                    int i2 = this.sDi;
                    String str2 = this.sED.bxz + this.sEE.url;
                    String str3 = this.sEE.bxD;
                    String str4 = this.sEE.bxC;
                    if (this.nPm != 2) {
                        z2 = false;
                    }
                    this.sEz = new c(i, str, i2, str2, str3, str4, z2);
                    chj();
                    return;
                }
                chi();
            } else if (f.aM((long) this.size)) {
                chk();
            } else {
                x.e("MicroMsg.UpdaterManager", "SDCard is full");
                chi();
            }
        } else {
            x.e("MicroMsg.UpdaterManager", "no sdcard.");
            MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bi.VE() - 86400).commit();
            ai(2, true);
            cgR();
        }
    }

    public final void ai(int i, boolean z) {
        this.sEG = z;
        new ag().postDelayed(new 1(this, i), 300);
    }

    public final void cancel() {
        if (this.sEz != null) {
            this.sEK = false;
            this.sEz.cancel();
            this.sEz = null;
            this.sEL = System.currentTimeMillis();
            this.sEM.stop();
        }
    }

    private void reset() {
        cancel();
        this.bxm = 0;
        this.bxo = null;
        this.sEB = null;
        this.bRt = d.qVN;
        this.sDi = 0;
        this.erT = null;
        this.ccH = null;
        this.erV = null;
        this.uin = 0;
        this.bKg = null;
        this.size = 0;
        this.desc = null;
        this.sDK = null;
        this.sED = null;
        this.sEE = null;
        this.sEF = false;
        this.sEG = false;
        this.nPm = 0;
        this.sEH = false;
        this.intent = null;
        this.sEK = false;
        this.owf = null;
        this.sEN = 0;
    }

    private void chi() {
        MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bi.VE() - 86400).commit();
        ai(2, true);
        cgS();
    }

    private void chj() {
        if (this.nPm == 2 && !ao.isWifi(this.mContext)) {
            i.chd();
            x.i("MicroMsg.UpdaterManager", "we stop download, when silence and not wifi!");
        } else if (this.nPm == 2 && f.VS(this.bKg)) {
            x.e("MicroMsg.UpdaterManager", "the traffice is overload, not download anymore in silence mode!");
            this.sEM.stop();
        } else {
            this.sEM.cT(this.bKg, this.size);
            if (this.sEz != null) {
                ai(1, false);
                this.sEK = true;
                this.sEz.a(this.sEO);
                bzS();
                if (this.nPm == 2) {
                    i.chd();
                }
            }
        }
    }

    private void chk() {
        cancel();
        x.i("MicroMsg.UpdaterManager", "downloadFullPack");
        i.ah(this.mContext, 7);
        if (this.sDK == null || this.sDK.length <= 0) {
            this.sEz = new b(this.size, this.bKg, this.sDi, this.uin, this.erT, this.ccH, this.sEB, this.nPm == 2);
            h.mEJ.a(405, 77, 1, true);
        } else {
            this.sEz = new c(this.size, this.bKg, this.sDi, this.sDK, this.nPm == 2);
            h.mEJ.a(405, 76, 1, true);
        }
        chj();
    }

    public final void co(int i, int i2) {
        Iterator it = this.sEA.iterator();
        while (it.hasNext()) {
            ((g) it.next()).co(i, i2);
        }
    }

    public final void bzS() {
        Iterator it = this.sEA.iterator();
        while (it.hasNext()) {
            ((g) it.next()).bzS();
        }
    }

    public final void MX(String str) {
        Iterator it = this.sEA.iterator();
        while (it.hasNext()) {
            ((g) it.next()).MX(str);
        }
    }

    public final void a(c cVar) {
        Iterator it = this.sEA.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(cVar);
        }
    }

    public final void cgR() {
        Iterator it = this.sEA.iterator();
        while (it.hasNext()) {
            ((g) it.next()).cgR();
        }
    }

    public final void cgS() {
        Iterator it = this.sEA.iterator();
        while (it.hasNext()) {
            ((g) it.next()).cgS();
        }
    }

    public final boolean isBusy() {
        if (this.sEK || System.currentTimeMillis() - this.sEL <= UpdaterService.sEU) {
            x.i("MicroMsg.UpdaterManager", "dont stop, because of updateManager.isDownloading() %s / updateManager.getIdleTimestamp() %s / System.currentTimeMillis() - updateManager.getIdleTimestamp() %s", new Object[]{Boolean.valueOf(this.sEK), Long.valueOf(this.sEL), Long.valueOf(System.currentTimeMillis() - this.sEL)});
            return true;
        }
        x.i("MicroMsg.UpdaterManager", "not busy");
        return false;
    }

    public final void onDestroy() {
        x.i("MicroMsg.UpdaterManager", "onDestroy");
        if (!this.sEK) {
            reset();
            ai(1, true);
        }
    }
}
