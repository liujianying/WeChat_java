package com.tencent.mm.plugin.hp.b;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.au;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.l;
import com.tencent.mm.plugin.hp.a.a.1;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.hp.d.c;
import com.tencent.mm.plugin.hp.tinker.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.lib.f.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

public final class e implements l {
    final b kmF;
    private long kmG;

    public e(b bVar) {
        this.kmF = bVar;
        d.aCU();
        com.tencent.mm.plugin.downloader.model.b.a(this);
    }

    public final boolean fL(boolean z) {
        boolean z2;
        a.i("Tinker.SyncResponseProcessor", "process tinker response: %s", this.kmF.toString());
        b bVar = this.kmF;
        if (bVar.knd.intValue() > 4 || bVar.knd.intValue() <= 0) {
            x.e("Tinker.TinkerSyncResponse", "responseState: %d must between %d and %d", bVar.knd, Integer.valueOf(1), Integer.valueOf(4));
            h.mEJ.a(614, 24, 1, false);
            z2 = false;
        } else {
            if (bVar.aWx()) {
                if (TextUtils.isEmpty(bVar.knj)) {
                    x.e("Tinker.TinkerSyncResponse", "sync response patchId should not be null");
                    h.mEJ.a(614, 25, 1, false);
                    z2 = false;
                } else if (TextUtils.isEmpty(bVar.knh)) {
                    x.e("Tinker.TinkerSyncResponse", "sync response cdnUrl should not be null");
                    h.mEJ.a(614, 26, 1, false);
                    z2 = false;
                } else if (TextUtils.isEmpty(bVar.kni)) {
                    x.e("Tinker.TinkerSyncResponse", "sync response fileMd5 should not be null");
                    h.mEJ.a(614, 27, 1, false);
                    z2 = false;
                }
            }
            z2 = true;
        }
        if (z2) {
            if (this.kmF.knd.intValue() == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                Context context = ad.getContext();
                com.tencent.tinker.lib.e.a hL = com.tencent.tinker.lib.e.a.hL(context);
                if (hL.vsE) {
                    a.i("Tinker.SyncResponseProcessor", "tinker wait screen to clean patch and kill all process", new Object[0]);
                    m mVar = new m(ad.getContext(), new 3(this, context, hL));
                    SharePatchInfo.a(hL.vsA, new SharePatchInfo(hL.vsD.vsI, "00000000000000000000000000000000", Build.FINGERPRINT, "odex"), hL.vsB);
                } else {
                    a.w("Tinker.SyncResponseProcessor", "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return", new Object[0]);
                }
                return true;
            } else if (!this.kmF.aWx()) {
                return true;
            } else {
                if (this.kmF.knf.intValue() == 3 && !bi.oW(this.kmF.clientVersion) && c.EI(this.kmF.clientVersion)) {
                    h.mEJ.a(614, 77, 1, false);
                    b bVar2 = this.kmF;
                    Context context2 = ad.getContext();
                    CharSequence string = bi.oW(bVar2.knm) ? context2.getString(R.l.app_recommend_update_alpha) : bVar2.knm;
                    CharSequence charSequence = bi.oW(bVar2.knn) ? "" : bVar2.knn;
                    String str = bi.oW(bVar2.kno) ? "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index" : bVar2.kno;
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setClassName(ad.getPackageName(), ad.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.setFlags(872415232);
                    Builder contentIntent = new Builder(context2).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(charSequence).setContentIntent(PendingIntent.getActivity(context2, 0, intent, SQLiteDatabase.CREATE_IF_NECESSARY));
                    contentIntent.setSmallIcon(com.tencent.mm.bf.a.cbg());
                    Notification notification = contentIntent.getNotification();
                    notification.icon = R.g.update_package_download_anim0;
                    notification.flags |= 16;
                    if (z) {
                        ((NotificationManager) context2.getSystemService("notification")).notify(19841110, notification);
                    } else {
                        x.i("Tinker.SyncResponseProcessor", "ignore action when load from cache,when response is alpha version");
                    }
                    return true;
                }
                a.i("Tinker.SyncResponseProcessor", "check need show before download. network type:%d msg:%s", this.kmF.kng, this.kmF.aWz());
                Context context3 = ad.getContext();
                if (this.kmF.kng.intValue() == 2 && ao.isMobile(ad.getContext()) && this.kmF.aWy()) {
                    if (g.ar(context3, this.kmF.knj)) {
                        h.mEJ.a(614, 44, 1, false);
                        x.i("Tinker.SyncResponseProcessor", "this patch id :%s show cancel before user, need show again.", this.kmF.knj);
                    } else {
                        if (this.kmF.knf.intValue() == 2) {
                            i.a(ad.getContext().getString(R.l.fmt_update), ad.getContext().getString(R.l.fmt_update_info, new Object[]{this.kmF.aWz(), ad.getContext().getString(R.l.update_increment_tips), bi.bF((long) this.kmF.fileSize)}), ad.getContext().getString(R.l.update_now), new 1(this), ad.getContext().getString(R.l.update_cancel), new 2(this, context3));
                        } else if (this.kmF.knf.intValue() == 3) {
                            String string2;
                            x.d("Tinker.SyncResponseProcessor", "showUpdateDialog ");
                            if (bi.oW(this.kmF.aWz())) {
                                string2 = context3.getString(R.l.update_tip_recommended_down);
                            } else {
                                string2 = this.kmF.aWz();
                            }
                            bsx bsx = new bsx();
                            bsx.knj = this.kmF.knj;
                            bsx.title = context3.getString(R.l.fmt_update);
                            bsx.sqq = context3.getString(R.l.update_now);
                            bsx.kcL = context3.getString(R.l.update_cancel);
                            bsx.knk = this.kmF.knk;
                            bsx.knl = this.kmF.knl;
                            bsx.gsu = this.kmF.fileSize;
                            bsx.knh = this.kmF.knh;
                            bsx.bxD = this.kmF.kni;
                            bsx.versionCode = this.kmF.versionCode;
                            bsx.sqp = i.Tg(this.kmF.knk);
                            bsx.bIr = string2;
                            i.a(bsx);
                        }
                        a.rk(4);
                    }
                } else if (this.kmF.aWw() && !g.ar(context3, this.kmF.knj)) {
                    aWp();
                }
                return true;
            }
        }
        a.i("Tinker.SyncResponseProcessor", "process check response fail, just return", new Object[0]);
        return false;
    }

    final void aWp() {
        if (!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted")) {
            x.e("Tinker.SyncResponseProcessor", "no sdcard.");
            h.mEJ.a(614, 50, 1, false);
        } else if (!f.aM((long) this.kmF.fileSize)) {
            x.e("Tinker.SyncResponseProcessor", "sdcard is full.");
            h.mEJ.a(614, 51, 1, false);
            if (this.kmF.knf.intValue() == 3) {
                h.mEJ.a(614, 55, 1, false);
            }
        } else if (this.kmF.knf.intValue() == 3 && !bi.oW(this.kmF.knk) && com.tencent.mm.a.e.cn(i.Tg(this.kmF.knk)) && com.tencent.mm.c.a.cE(i.Tg(this.kmF.knk))) {
            String string;
            Context context = ad.getContext();
            if (bi.oW(this.kmF.aWz())) {
                string = context.getString(R.l.update_tip_recommended_down);
            } else {
                string = this.kmF.aWz();
            }
            bsx bsx = new bsx();
            bsx.knj = this.kmF.knj;
            bsx.title = context.getString(R.l.fmt_update);
            bsx.sqq = context.getString(R.l.install_now);
            bsx.kcL = context.getString(R.l.update_cancel);
            bsx.knk = this.kmF.knk;
            bsx.knl = this.kmF.knl;
            bsx.gsu = this.kmF.fileSize;
            bsx.knh = this.kmF.knh;
            bsx.bxD = this.kmF.kni;
            bsx.versionCode = this.kmF.versionCode;
            bsx.sqp = i.Tg(this.kmF.knk);
            bsx.bIr = string;
            i.a(bsx);
            x.i("Tinker.SyncResponseProcessor", "file is exist. need no to download. newApkMd5:%s", this.kmF.knk);
        } else {
            this.kmF.knf.intValue();
            i.ccl();
            i.ccm();
            com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
            aVar.yQ(this.kmF.knh);
            aVar.yS(this.kmF.knj);
            aVar.yT(this.kmF.kni);
            aVar.ef(false);
            aVar.aDa();
            aVar.ox(2);
            aVar.eg(false);
            this.kmG = d.aCU().a(aVar.ick);
            x.i("Tinker.SyncResponseProcessor", "Download task id is :%d", Long.valueOf(this.kmG));
            h.mEJ.a(614, 2, 1, false);
            if (ao.isWifi(ad.getContext())) {
                h.mEJ.a(614, 7, 1, false);
            } else {
                h.mEJ.a(614, 8, 1, false);
            }
            if (this.kmF.knf.intValue() == 3) {
                h.mEJ.a(614, 56, 1, false);
                x.d("Tinker.SyncResponseProcessor", "boots download start silent.");
            }
        }
    }

    public final void onTaskStarted(long j, String str) {
        x.d("Tinker.SyncResponseProcessor", "onTaskStarted");
    }

    public final void b(long j, String str, boolean z) {
        x.i("Tinker.SyncResponseProcessor", "onTaskFinished id:%d path:%s hasChangeUrl:%s", Long.valueOf(j), str, Boolean.valueOf(z));
        if (this.kmG != j) {
            x.i("Tinker.SyncResponseProcessor", "onTaskFinished ignore. id is no equal. download id :%s callback id:%s", Long.valueOf(this.kmG), Long.valueOf(j));
            return;
        }
        b.rm(2);
        Context context = ad.getContext();
        File file = new File(str);
        ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(context);
        if (this.kmF.knf.intValue() != 2 || shareSecurityCheck.an(file)) {
            File file2;
            String absolutePath;
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                file2 = null;
            } else {
                file2 = new File(applicationInfo.dataDir, "tinker_server");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            if (file2 != null) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    String name = file.getName();
                    for (File file3 : listFiles) {
                        if (!file3.getName().equals(name)) {
                            SharePatchFileUtil.aj(file3);
                        }
                    }
                }
            }
            switch (this.kmF.knf.intValue()) {
                case 1:
                    x.i("Tinker.SyncResponseProcessor", "coming soon! now can not support full apk update.");
                    break;
                case 2:
                    a.i("Tinker.SyncResponseProcessor", "onReceiveUpgradePatch. try to start apply", new Object[0]);
                    com.tencent.tinker.lib.e.c.bP(context, file.getAbsolutePath());
                    break;
                case 3:
                    absolutePath = file.getAbsolutePath();
                    b bVar = this.kmF;
                    x.i("MicroMsg.Tinker.CTinkerInstaller", "onReceiveUpgradeBsDiff bsDiffPath:%s , new apk md5：%s", absolutePath, bVar.knk);
                    au.Em().H(new 1(i.Tg(bVar.knk), context, absolutePath, bVar));
                    break;
            }
            b bVar2 = this.kmF;
            if (bVar2.aWy()) {
                absolutePath = b.a(bVar2.kne, 2);
            } else {
                absolutePath = "";
            }
            context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_msg_key", absolutePath).apply();
        } else {
            a.i("Tinker.SyncResponseProcessor", "verify patch signature failed.", new Object[0]);
            b.rn(2);
            h.mEJ.a(614, 31, 1, false);
            if (this.kmF.knf.intValue() == 3) {
                h.mEJ.a(614, 54, 1, false);
                x.d("Tinker.SyncResponseProcessor", "boots download patch md5 no equal.");
            }
        }
        d.aCU();
        com.tencent.mm.plugin.downloader.model.b.b(this);
    }

    public final void b(long j, int i, boolean z) {
        x.w("Tinker.SyncResponseProcessor", "onTaskFailed");
        if (this.kmG != j) {
            x.i("Tinker.SyncResponseProcessor", "onTaskFailed ignore. id is no equal. download id :%s callback id:%s", Long.valueOf(this.kmG), Long.valueOf(j));
            return;
        }
        b.rn(2);
        if (this.kmF.knf.intValue() == 3) {
            h.mEJ.a(614, 51, 1, false);
        }
        d.aCU();
        com.tencent.mm.plugin.downloader.model.b.b(this);
    }

    public final void onTaskRemoved(long j) {
        x.i("Tinker.SyncResponseProcessor", "onTaskRemoved");
        d.aCU();
        com.tencent.mm.plugin.downloader.model.b.b(this);
    }

    public final void onTaskPaused(long j) {
        x.d("Tinker.SyncResponseProcessor", "onTaskPaused");
    }

    public final void bP(long j) {
        x.d("Tinker.SyncResponseProcessor", "onTaskProgressChanged");
    }

    public final void h(long j, String str) {
        x.d("Tinker.SyncResponseProcessor", "onTaskResumed");
    }
}
