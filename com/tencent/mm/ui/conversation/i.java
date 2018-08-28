package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.g.a.im;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.a.c;

public final class i implements e, f {
    private static boolean uqL = false;
    Activity bOb;
    ProgressDialog eHw = null;
    private c uqF = null;
    private c uqG = null;
    private boolean uqH = false;
    private a uqI = new a();
    boolean uqJ = false;
    private com.tencent.mm.modelmulti.f uqK = null;
    a uqM;
    a uqN;
    com.tencent.mm.sdk.b.c uqO = new 1(this);
    com.tencent.mm.sdk.b.c uqP = new 5(this);
    FLock uqQ;
    WakeLock wakeLock = null;

    static /* synthetic */ boolean d(i iVar) {
        bsx cci = com.tencent.mm.pluginsdk.f.i.cci();
        if (com.tencent.mm.pluginsdk.f.i.ccj() && cci != null) {
            au.Em().H(new 4(iVar, cci));
            x.i("MicroMsg.InitHelper", "have tinker update.");
            return true;
        } else if (w.gp(iVar.bOb)) {
            h.mEJ.a(405, 41, 1, true);
            x.d("MicroMsg.InitHelper", "we got a install");
            return true;
        } else if (!w.W(iVar.bOb)) {
            return false;
        } else {
            x.d("MicroMsg.InitHelper", "we got an unfinished silence download");
            return true;
        }
    }

    final boolean cyU() {
        if (!l.PJ()) {
            return false;
        }
        if (this.uqG != null && this.uqG.isShowing()) {
            return false;
        }
        boolean z;
        g.Ek();
        com.tencent.mm.kernel.e Ei = g.Ei();
        g.Ek();
        g.Eg().Ds();
        int f = bi.f((Integer) Ei.dqs.get(89, null));
        if (f != 0) {
            x.i("MMKernel.CoreStorage", "isDBCorrupted: false, recoveryState: " + f);
            z = false;
        } else {
            z = bi.oV((String) Ei.dqs.get(8195, null)).length() <= 0 || bi.f((Integer) Ei.dqs.get(15, null)) == 0;
            if (!z || Ei.DP() == null) {
                Ei.dqs.set(89, Integer.valueOf(1));
                Ei.dqs.lm(false);
                x.i("MMKernel.CoreStorage", "isDBCorrupted: false, needInit: " + z);
                z = false;
            } else {
                x.i("MMKernel.CoreStorage", "isDBCorrupted: true");
                z = true;
            }
        }
        if (z) {
            this.uqG = new c.a(this.bOb).Gq(R.l.db_broken_title).abu(this.bOb.getString(R.l.db_broken_message)).mF(false).Gt(R.l.db_broken_try_recover_btn).a(new 8(this)).Gu(R.l.db_broken_cancel_btn).b(new 7(this)).anj();
            this.uqG.show();
        } else {
            aaQ();
        }
        return true;
    }

    private void aaQ() {
        if (this.uqH) {
            x.i("MicroMsg.InitHelper", "summerinit doPreCreate but hasTryDoInitButFailed true ret");
            return;
        }
        if (!this.wakeLock.isHeld()) {
            x.w("MicroMsg.InitHelper", "tryDoInit wakelock.acquire!");
            this.wakeLock.acquire();
        }
        this.uqN.cyX();
        if (this.uqK == null) {
            if (n.nky != null) {
                n.nky.bwS();
            }
            this.uqK = new com.tencent.mm.modelmulti.f(this);
            x.d("MicroMsg.InitHelper", "dkinit doPreCreate t:%d initScene:%d", new Object[]{Long.valueOf(this.uqI.Ad()), Integer.valueOf(this.uqK.hashCode())});
            this.uqI.dgA = SystemClock.elapsedRealtime();
            au.DF().a(this.uqK, 0);
        }
        ah.A(new 9(this));
    }

    public final void a(int i, int i2, com.tencent.mm.ab.l lVar) {
        if (lVar != null && lVar.getType() == 139) {
            ah.A(new 10(this, (int) (i2 != 0 ? (((long) i) * 100) / ((long) i2) : 0)));
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (lVar.getType() == 138 || lVar.getType() == 139) {
            int i3;
            String str2 = "MicroMsg.InitHelper";
            String str3 = "dkinit onSceneEnd:[%d,%d,%s] type:%d hash:%d init:%d ";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = str;
            objArr[3] = Integer.valueOf(lVar.getType());
            objArr[4] = Integer.valueOf(hashCode());
            if (this.uqK == null) {
                i3 = -2;
            } else {
                i3 = this.uqK.hashCode();
            }
            objArr[5] = Integer.valueOf(i3);
            x.i(str2, str3, objArr);
            if (this.uqK != null && lVar.getType() == 139) {
                this.uqK = null;
                x.w("MicroMsg.InitHelper", "summerinit dkinit Kevin init FINISH : %d ", new Object[]{Long.valueOf(this.uqI.Ad())});
                am.a.dBr.a(null, null, null);
                if (n.nky != null) {
                    n.nky.bwT();
                }
                this.uqN.cyY();
                if (this.wakeLock.isHeld()) {
                    x.w("MicroMsg.InitHelper", "onSceneEnd wakelock.release!");
                    this.wakeLock.release();
                }
                au.Em().cik();
                if (this.eHw != null) {
                    this.eHw.dismiss();
                    this.eHw = null;
                }
            }
            if (w.a(this.bOb, i, i2, new Intent().setClass(this.bOb, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                x.i("MicroMsg.InitHelper", "summerinit onSceneEnd accountExpired ret");
            } else if (au.HX()) {
                if (!this.uqJ) {
                    this.uqJ = true;
                    au.HU();
                    str2 = (String) com.tencent.mm.model.c.DT().get(5, null);
                    au.HU();
                    if ((((Integer) com.tencent.mm.model.c.DT().get(57, Integer.valueOf(0))).intValue() != 0) && str2 != null) {
                        com.tencent.mm.ui.base.h.a(this.bOb, this.bOb.getString(R.l.regbyfacebook_reg_setpwd_request, new Object[]{str2}), this.bOb.getString(R.l.app_tip), this.bOb.getString(R.l.regbyfacebook_reg_setpwd_setnow), this.bOb.getString(R.l.regbyfacebook_reg_setpwd_setcancel), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent();
                                intent.setClassName(i.this.bOb, "com.tencent.mm.plugin.account.ui.RegByFacebookSetPwdUI");
                                i.this.bOb.startActivity(intent);
                            }
                        }, new 3(this));
                    }
                }
                if (i == 4 && i2 == -17 && !uqL) {
                    o.PM().id(7);
                    uqL = true;
                }
                if (al(i, i2, lVar.getType())) {
                    x.w("MicroMsg.InitHelper", "summerinit onSceneEnd checkUpdate ret");
                    return;
                }
                if (lVar.getType() == 139) {
                    im imVar = new im();
                    if (i == 3 && i2 == -1) {
                        this.uqH = true;
                        imVar.bRX.bQA = false;
                        com.tencent.mm.sdk.b.a.sFg.m(imVar);
                        this.uqM.cyF();
                    } else {
                        imVar.bRX.bQA = true;
                        com.tencent.mm.sdk.b.a.sFg.m(imVar);
                    }
                }
                if (!w.a.a(this.bOb, i, i2, str, 4)) {
                    if (lVar.getType() == 139) {
                        new ag().post(new 11(this));
                        if ((q.GL() & MapRouteSectionWithName.kMaxRoadNameLength) != 0) {
                            au.HU();
                            if (com.tencent.mm.model.c.FW().Yq("masssendapp") == null) {
                                ai aiVar = new ai();
                                aiVar.setUsername("masssendapp");
                                aiVar.setContent(ad.getContext().getResources().getString(R.l.contact_info_masssend_tip));
                                aiVar.as(com.tencent.mm.platformtools.ai.VF() + 2000);
                                aiVar.eX(0);
                                aiVar.eV(0);
                                au.HU();
                                com.tencent.mm.model.c.FW().d(aiVar);
                                i3 = q.GL() & -129;
                                au.HU();
                                com.tencent.mm.model.c.DT().set(40, Integer.valueOf(i3));
                            }
                        }
                    }
                    if (lVar.getType() == 138 || lVar.getType() == 139) {
                        ah.A(new 12(this));
                        this.uqM.cyF();
                    }
                }
            } else {
                x.w("MicroMsg.InitHelper", "summerinit onSceneEnd not set uin");
            }
        } else if (lVar.getType() == 113 || lVar.getType() == 0) {
            x.i("MicroMsg.InitHelper", "onSceneEnd from GetUpdateInfo, ignore it.");
        } else {
            al(i, i2, lVar.getType());
        }
    }

    private boolean al(int i, int i2, int i3) {
        if (g.Eg().Dx()) {
            au.HU();
            long d = com.tencent.mm.platformtools.ai.d((Long) com.tencent.mm.model.c.DT().get(aa.a.sOv, null));
            au.HU();
            long d2 = com.tencent.mm.platformtools.ai.d((Long) com.tencent.mm.model.c.DT().get(aa.a.sOx, null));
            au.HU();
            long d3 = com.tencent.mm.platformtools.ai.d((Long) com.tencent.mm.model.c.DT().get(aa.a.sOw, null));
            au.HU();
            com.tencent.mm.model.c.DT().a(aa.a.sOv, Long.valueOf(0));
            au.HU();
            com.tencent.mm.model.c.DT().a(aa.a.sOw, Long.valueOf(0));
            if (d3 == ((long) d.qVN) && com.tencent.mm.platformtools.ai.bG(d2) < 3600) {
                if (d == 1) {
                    if (w.c(this.bOb, 4, -17)) {
                        return true;
                    }
                } else if (d == 2 && w.c(this.bOb, 4, -16)) {
                    return true;
                }
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                x.i("MicroMsg.InitHelper", "trigger check update: errCode:%d, sceneType:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                if (af.ewZ) {
                    ad.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", (com.tencent.mm.platformtools.ai.VE() - 86400) - 1).commit();
                }
                if (w.c(this.bOb, i, i2)) {
                    return true;
                }
            }
            return false;
        }
        x.w("MicroMsg.InitHelper", "account not ready");
        return false;
    }

    final int cyV() {
        return this.uqK == null ? -2 : this.uqK.hashCode();
    }

    public final boolean cyW() {
        return this.uqK != null;
    }
}
