package com.tencent.mm.ui;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.o.a;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.account.bind.ui.BindMobileUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.j.3;
import com.tencent.mm.ui.j.5;

class j$6 implements Runnable {
    final /* synthetic */ j tjf;

    j$6(j jVar) {
        this.tjf = jVar;
    }

    public final void run() {
        boolean z;
        SharedPreferences chZ = ad.chZ();
        long j = chZ.getLong("show_sdcard_full_time", 0);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = currentTimeMillis - j > 10800000 || j > currentTimeMillis;
        j jVar = this.tjf;
        int BP = a.BP();
        boolean Aa = f.Aa();
        x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "%d check mobile available space _dataRet[%d] checkSdIsFull[%b] needShowAlert[%b] testCode[%d] ", new Object[]{Integer.valueOf(jVar.hashCode()), Integer.valueOf(BP), Boolean.valueOf(Aa), Boolean.valueOf(z2), Integer.valueOf(jVar.bIA)});
        if (jVar.bIA == 1) {
            BP = 1;
            z = true;
            jVar.bIA = 4;
        } else {
            if (jVar.bIA == 2) {
                z = true;
                BP = 2;
            } else if (jVar.bIA == 3) {
                BP = 0;
                Aa = true;
                z = true;
            } else if (jVar.bIA == 4) {
                jVar.bIA = 0;
                z2 = false;
                if (z2) {
                    chZ.edit().putLong("show_sdcard_full_time", currentTimeMillis).commit();
                }
                if (!z2) {
                    au.HU();
                    if (((Boolean) c.DT().get(aa.a.sQC, Boolean.valueOf(false))).booleanValue()) {
                        au.HU();
                        if (ai.oW((String) c.DT().get(6, ""))) {
                            au.HU();
                            z = ((Boolean) c.DT().get(aa.a.sQD, Boolean.valueOf(false))).booleanValue();
                            au.HU();
                            final String str = (String) c.DT().get(aa.a.sQE, this.tjf.getString(R.l.bind_mcontact_security_bander_hint));
                            x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile tip[%b], bindMobile[%s], force[%b], wording[%s]", new Object[]{Boolean.valueOf(r2), r0, Boolean.valueOf(z), str});
                            if (z) {
                                h.a(this.tjf.tiY, str, this.tjf.getString(R.l.app_tip), this.tjf.getString(R.l.app_ok), false, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent();
                                        intent.setClass(j$6.this.tjf.tiY, BindMobileUI.class);
                                        intent.putExtra("kstyle_bind_wording", new BindWordingContent(str, ""));
                                        MMWizardActivity.D(j$6.this.tjf.tiY, intent);
                                        dialogInterface.dismiss();
                                    }
                                });
                            } else {
                                h.a(this.tjf.tiY, str, this.tjf.getString(R.l.app_tip), this.tjf.getString(R.l.app_ok), this.tjf.getString(R.l.app_cancel), new 2(this, str), new 3(this));
                            }
                        } else {
                            x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile has bind[%s]", new Object[]{(String) c.DT().get(6, "")});
                        }
                        au.HU();
                        c.DT().a(aa.a.sQC, Boolean.valueOf(false));
                        au.HU();
                        c.DT().a(aa.a.sQE, "");
                        au.HU();
                        c.DT().lm(true);
                    }
                }
            } else {
                z = z2;
            }
            jVar.bIA = 0;
        }
        com.tencent.mm.ui.widget.a.c.a aVar;
        if (BP == 1) {
            if (z) {
                z2 = true;
                aVar = new com.tencent.mm.ui.widget.a.c.a(jVar.tiY);
                aVar.Gq(R.l.check_db_size_tip_normal_title);
                aVar.abu(jVar.tiY.getString(R.l.check_db_size_tip_normal_message));
                aVar.mF(false);
                aVar.Gt(R.l.check_db_size_btn_message).a(new 3(jVar));
                aVar.anj().show();
                x.d("MicroMsg.LauncherUI.GlobalAlertMgr", "%d show no space notification isShowLackSpaceNotification[%b]", new Object[]{Integer.valueOf(jVar.hashCode()), Boolean.valueOf(jVar.tjc)});
                if (!jVar.tjc) {
                    au.getNotification().cancel(45);
                    jVar.tjc = true;
                    Notification build = new Builder(ad.getContext()).setTicker(jVar.getString(R.l.check_db_size_tip_normal_title)).setContentTitle(jVar.getString(R.l.check_db_size_tip_normal_title)).setContentText(jVar.getString(R.l.check_db_size_tip_normal_message)).setAutoCancel(false).setContentIntent(PendingIntent.getActivity(ad.getContext(), 45, new Intent(ad.getContext(), LauncherUI.class), 134217728)).setOngoing(true).build();
                    build.icon = com.tencent.mm.bf.a.cbg();
                    build.flags |= 32;
                    au.getNotification().a(45, build, false);
                }
                com.tencent.mm.plugin.report.service.h.mEJ.a(282, 20, 1, false);
            }
            z2 = false;
        } else if (BP == 2) {
            if (z) {
                z2 = true;
                au.hold();
                aVar = new com.tencent.mm.ui.widget.a.c.a(jVar.tiY);
                aVar.Gq(R.l.check_db_size_tip_dangerous_title);
                aVar.abu(jVar.tiY.getString(R.l.check_db_size_tip_dangerous_message));
                aVar.mF(false);
                aVar.Gt(R.l.check_db_size_btn_dangerous_message).a(new j$4(jVar));
                aVar.anj().show();
                com.tencent.mm.plugin.report.service.h.mEJ.a(282, 2, 1, false);
            }
            z2 = false;
        } else {
            x.d("MicroMsg.LauncherUI.GlobalAlertMgr", "%d cancel no space notification isShowLackSpaceNotification[%b]", new Object[]{Integer.valueOf(jVar.hashCode()), Boolean.valueOf(jVar.tjc)});
            if (jVar.tjc) {
                au.getNotification().cancel(45);
                jVar.tjc = false;
            }
            if (Aa && z) {
                h.a(jVar.tiY, jVar.getString(R.l.sdcard_full), jVar.getString(R.l.sdcard_full_title), jVar.getString(R.l.app_clear_mm), jVar.getString(R.l.app_ignore), new 5(jVar), null);
                com.tencent.mm.plugin.report.service.h.mEJ.a(282, 0, 1, false);
                z2 = true;
            }
            z2 = false;
        }
        x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "%d check mobile available space isShowAlert[%b]", new Object[]{Integer.valueOf(jVar.hashCode()), Boolean.valueOf(z2)});
        if (z2) {
            chZ.edit().putLong("show_sdcard_full_time", currentTimeMillis).commit();
        }
        if (!z2) {
            au.HU();
            if (((Boolean) c.DT().get(aa.a.sQC, Boolean.valueOf(false))).booleanValue()) {
                au.HU();
                if (ai.oW((String) c.DT().get(6, ""))) {
                    au.HU();
                    z = ((Boolean) c.DT().get(aa.a.sQD, Boolean.valueOf(false))).booleanValue();
                    au.HU();
                    final String str2 = (String) c.DT().get(aa.a.sQE, this.tjf.getString(R.l.bind_mcontact_security_bander_hint));
                    x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile tip[%b], bindMobile[%s], force[%b], wording[%s]", new Object[]{Boolean.valueOf(r2), r0, Boolean.valueOf(z), str2});
                    if (z) {
                        h.a(this.tjf.tiY, str2, this.tjf.getString(R.l.app_tip), this.tjf.getString(R.l.app_ok), false, /* anonymous class already generated */);
                    } else {
                        h.a(this.tjf.tiY, str2, this.tjf.getString(R.l.app_tip), this.tjf.getString(R.l.app_ok), this.tjf.getString(R.l.app_cancel), new 2(this, str2), new 3(this));
                    }
                } else {
                    x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile has bind[%s]", new Object[]{(String) c.DT().get(6, "")});
                }
                au.HU();
                c.DT().a(aa.a.sQC, Boolean.valueOf(false));
                au.HU();
                c.DT().a(aa.a.sQE, "");
                au.HU();
                c.DT().lm(true);
            }
        }
    }

    public final String toString() {
        return super.toString() + "|doOnResumeCheck";
    }
}
