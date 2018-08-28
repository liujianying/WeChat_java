package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.model.i;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import java.io.File;
import java.util.Map;

public final class o implements e, b {
    String eHp;
    g eSA = null;
    MobileVerifyUI eTG;
    String eTM;
    private boolean eTN = true;

    public final void a(MobileVerifyUI mobileVerifyUI) {
        this.eTG = mobileVerifyUI;
    }

    public final void start() {
    }

    public final void stop() {
    }

    public final boolean jn(int i) {
        final a aVar;
        MobileVerifyUI mobileVerifyUI;
        MobileVerifyUI mobileVerifyUI2;
        switch (8.eTK[i - 1]) {
            case 1:
                h.a(this.eTG, this.eTG.getString(j.mobile_verify_cancel_tip), "", this.eTG.getString(j.mobile_verify_cancel_tip_back), this.eTG.getString(j.mobile_verify_cancel_tip_wait), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        o.this.eTG.finish();
                        i.jj(i.a.eOk);
                    }
                }, new 10(this));
                return true;
            case 2:
                g.DF().a(145, this);
                aVar = new a(this.eTG.bTi, 15, this.eTG.eGC.getText().toString().trim(), 0, "");
                aVar.lD(this.eTG.eSE);
                g.DF().a(aVar, 0);
                mobileVerifyUI = this.eTG;
                mobileVerifyUI2 = this.eTG;
                this.eTG.getString(j.app_tip);
                mobileVerifyUI.eHw = h.a(mobileVerifyUI2, this.eTG.getString(j.bind_mcontact_verifing), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        g.DF().c(aVar);
                        g.DF().b(145, o.this);
                    }
                });
                return false;
            case 3:
                g.DF().a(145, this);
                aVar = new a(this.eTG.bTi, 14, "", 0, "");
                aVar.lD(this.eTG.eSE);
                g.DF().a(aVar, 0);
                i.jj(i.a.eOl);
                return false;
            case 4:
                StringBuilder stringBuilder = new StringBuilder();
                g.Eg();
                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R200_350_auto,");
                g.Eg();
                com.tencent.mm.plugin.c.a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("R200_350_auto")).append(",1").toString());
                g.DF().a(145, this);
                aVar = new a(this.eTG.bTi, 15, this.eTG.eGC.getText().toString().trim(), 0, "");
                aVar.lD(this.eTG.eSE);
                g.DF().a(aVar, 0);
                mobileVerifyUI = this.eTG;
                mobileVerifyUI2 = this.eTG;
                this.eTG.getString(j.app_tip);
                mobileVerifyUI.eHw = h.a(mobileVerifyUI2, this.eTG.getString(j.bind_mcontact_verifing), true, new 1(this, aVar));
                return false;
            default:
                return false;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.MobileVerifyRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eTG.eHw != null) {
            this.eTG.eHw.dismiss();
            this.eTG.eHw = null;
        }
        MobileVerifyUI mobileVerifyUI;
        MobileVerifyUI mobileVerifyUI2;
        if (lVar.getType() == 255) {
            g.DF().b(255, this);
            if (i != 0 || i2 != 0) {
                this.eTG.co(this.eTN);
            }
        } else if (lVar.getType() != 701 || this.eSA == null) {
            com.tencent.mm.h.a eV;
            int Oh;
            Intent intent;
            if (lVar.getType() == 145) {
                g.DF().b(145, this);
                Oh = ((a) lVar).Oh();
                if (Oh != 15) {
                    return;
                }
                if (i == 0 && i2 == 0) {
                    if (Oh != 15) {
                        return;
                    }
                    if (this.eTG.eTw == 1) {
                        this.eTM = ((a) lVar).Oj();
                        g.DF().a(126, this);
                        s sVar = new s("", this.eTG.eTo, this.eTG.bgn, 0, "", this.eTG.bTi, "", "", this.eTM, this.eTG.egg, "", "", "", true, this.eTG.eUh.booleanValue());
                        sVar.mX(this.eTG.eSE);
                        g.DF().a(sVar, 0);
                        mobileVerifyUI = this.eTG;
                        mobileVerifyUI2 = this.eTG;
                        this.eTG.getString(j.app_tip);
                        mobileVerifyUI.eHw = h.a(mobileVerifyUI2, this.eTG.getString(j.regbyqq_reg_waiting), true, new 7(this, sVar));
                        return;
                    }
                    intent = new Intent();
                    intent.putExtra("regsetinfo_ticket", ((a) lVar).Oj());
                    intent.putExtra("regsetinfo_user", this.eTG.bTi);
                    intent.putExtra("regsession_id", this.eTG.eSE);
                    intent.putExtra("regsetinfo_ismobile", 4);
                    intent.putExtra("regsetinfo_NextControl", ((a) lVar).Op());
                    intent.putExtra("key_reg_style", this.eTG.eTw);
                    intent.setClass(this.eTG, RegSetInfoUI.class);
                    this.eTG.startActivity(intent);
                    i.jj(i.a.eOm);
                    return;
                } else if (i2 == -35) {
                    eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null) {
                        eV.a(this.eTG, new 13(this, lVar), new 14(this));
                        return;
                    } else {
                        h.a(this.eTG, this.eTG.getString(j.bind_mcontact_already_bind_relogin), null, new 15(this, lVar), new 16(this));
                        return;
                    }
                } else if (i2 == -212) {
                    intent = new Intent(this.eTG, MobileLoginOrForceReg.class);
                    intent.putExtra("ticket", ((a) lVar).Oj());
                    intent.putExtra("moble", this.eTG.bTi);
                    intent.putExtra("regsession_id", this.eTG.eSE);
                    intent.putExtra("next_controll", ((a) lVar).Op());
                    intent.putExtra("username", ((a) lVar).getUsername());
                    intent.putExtra("password", ((a) lVar).Oi());
                    intent.putExtra("nickname", ((a) lVar).Ov());
                    intent.putExtra("avatar_url", ((a) lVar).Ou());
                    intent.putExtra("key_reg_style", this.eTG.eTw);
                    if (this.eTG.eTw == 1) {
                        intent.putExtra("kintent_nickname", this.eTG.bgn);
                        intent.putExtra("kintent_password", this.eTG.eTo);
                        intent.putExtra("kintent_hasavatar", this.eTG.eUh);
                    }
                    this.eTG.startActivity(intent);
                    return;
                } else if (i2 == -51) {
                    eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null) {
                        eV.a(this.eTG, null, null);
                        return;
                    } else {
                        h.i(this.eTG, j.bind_mcontact_verify_err_time_out_content, j.bind_mcontact_verify_tip);
                        return;
                    }
                }
            } else if (lVar.getType() == 126) {
                String str2;
                int i3;
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    str2 = this.eTG.bTi;
                    Boolean bool = this.eTG.eUh;
                    String str3 = this.eTG.eTo;
                    String str4 = this.eTG.bgn;
                    if (this.eTG.eIX == null) {
                        MobileVerifyUI mobileVerifyUI3 = this.eTG;
                        MobileVerifyUI mobileVerifyUI4 = this.eTG;
                        int i4 = j.regbyqq_secimg_title;
                        byte[] Rf = ((s) lVar).Rf();
                        String Re = ((s) lVar).Re();
                        Context context = mobileVerifyUI4;
                        i3 = i4;
                        int i5 = 0;
                        byte[] bArr = Rf;
                        String str5 = Re;
                        mobileVerifyUI3.eIX = SecurityImage.a.a(context, i3, i5, bArr, str5, "", new 2(this, str3, str4, lVar, bool), null, new 3(this), new 4(this, str3, str4, lVar, bool));
                        return;
                    }
                    this.eTG.eIX.a(0, ((s) lVar).Rf(), ((s) lVar).Re(), "");
                    return;
                }
                if (i == 0 && i2 == 0) {
                    String str6;
                    String str7 = this.eTG.bTi;
                    Boolean bool2 = this.eTG.eUh;
                    str2 = this.eTG.eTo;
                    str2 = this.eTG.bgn;
                    int Ro = ((s) lVar).Ro();
                    String Rp = ((s) lVar).Rp();
                    i3 = ((s) lVar).Rq();
                    String str8 = null;
                    String str9 = null;
                    boolean z = false;
                    Map z2 = bl.z(((s) lVar).Rr(), "wording");
                    if (z2 != null) {
                        str2 = (String) z2.get(".wording.switch");
                        if (bi.oW(str2)) {
                            z = true;
                        } else {
                            Oh = bi.WU(str2);
                            if (Oh == 0) {
                                z = false;
                            } else if (Oh == 1) {
                                z = true;
                            }
                        }
                        if (z) {
                            str2 = (String) z2.get(".wording.title");
                            if (!bi.oW(str2)) {
                                str8 = str2;
                            }
                            str2 = (String) z2.get(".wording.desc");
                            if (bi.oW(str2)) {
                                str6 = str8;
                            } else {
                                str9 = str2;
                                str6 = str8;
                            }
                            x.i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", new Object[]{bool2});
                            x.i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", new Object[]{Integer.valueOf(Ro)});
                            x.i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", new Object[]{Rp});
                            x.i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", new Object[]{Integer.valueOf(i3)});
                            x.i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", new Object[]{r7});
                            com.tencent.mm.kernel.a.unhold();
                            com.tencent.mm.kernel.a.bt(true);
                            if (bool2.booleanValue()) {
                                Intent intent2;
                                this.eHp = ((s) lVar).Rn();
                                at.dBv.T("login_user_name", str7);
                                if (Rp != null) {
                                    if (Rp.contains("0")) {
                                        com.tencent.mm.plugin.c.a.pU("R300_100_phone");
                                        if (z) {
                                            intent2 = new Intent(this.eTG, FindMContactAlertUI.class);
                                            intent2.putExtra("alert_title", str6);
                                            intent2.putExtra("alert_message", str9);
                                        } else {
                                            intent2 = new Intent(this.eTG, FindMContactIntroUI.class);
                                        }
                                        intent2.addFlags(67108864);
                                        intent2.putExtra("regsetinfo_ticket", this.eHp);
                                        intent2.putExtra("regsetinfo_NextStep", Rp);
                                        intent2.putExtra("regsetinfo_NextStyle", i3);
                                        intent = com.tencent.mm.plugin.account.a.a.ezn.be(this.eTG);
                                        intent.addFlags(67108864);
                                        intent.putExtra("LauncherUI.enter_from_reg", true);
                                        MMWizardActivity.b(this.eTG, intent2, intent);
                                        this.eTG.finish();
                                    }
                                }
                                intent2 = com.tencent.mm.plugin.account.a.a.ezn.be(this.eTG);
                                intent2.addFlags(67108864);
                                intent2.putExtra("LauncherUI.enter_from_reg", true);
                                this.eTG.startActivity(intent2);
                                StringBuilder stringBuilder = new StringBuilder();
                                g.Eg();
                                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(this.eTG.getClass().getName()).append(",R200_900_phone,");
                                g.Eg();
                                com.tencent.mm.plugin.c.a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("R200_900_phone")).append(",4").toString());
                                this.eTG.finish();
                            } else {
                                String str10 = com.tencent.mm.compatible.util.e.dgs + "temp.avatar";
                                str2 = com.tencent.mm.compatible.util.e.dgs + "temp.avatar.hd";
                                new File(str10).renameTo(new File(str2));
                                com.tencent.mm.a.e.deleteFile(str10);
                                c.c(str2, 96, 96, CompressFormat.JPEG, 90, str10);
                                new com.tencent.mm.aa.o(this.eTG, com.tencent.mm.compatible.util.e.dgs + "temp.avatar").a(new 5(this, lVar, str7, Rp, z, str6, str9, i3), new 6(this, lVar, str7, Rp, z, str6, str9, i3));
                            }
                        }
                    }
                    str6 = null;
                    x.i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", new Object[]{bool2});
                    x.i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", new Object[]{Integer.valueOf(Ro)});
                    x.i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", new Object[]{Rp});
                    x.i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", new Object[]{Integer.valueOf(i3)});
                    x.i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", new Object[]{r7});
                    com.tencent.mm.kernel.a.unhold();
                    com.tencent.mm.kernel.a.bt(true);
                    if (bool2.booleanValue()) {
                        Intent intent22;
                        this.eHp = ((s) lVar).Rn();
                        at.dBv.T("login_user_name", str7);
                        if (Rp != null) {
                            if (Rp.contains("0")) {
                                com.tencent.mm.plugin.c.a.pU("R300_100_phone");
                                if (z) {
                                    intent22 = new Intent(this.eTG, FindMContactAlertUI.class);
                                    intent22.putExtra("alert_title", str6);
                                    intent22.putExtra("alert_message", str9);
                                } else {
                                    intent22 = new Intent(this.eTG, FindMContactIntroUI.class);
                                }
                                intent22.addFlags(67108864);
                                intent22.putExtra("regsetinfo_ticket", this.eHp);
                                intent22.putExtra("regsetinfo_NextStep", Rp);
                                intent22.putExtra("regsetinfo_NextStyle", i3);
                                intent = com.tencent.mm.plugin.account.a.a.ezn.be(this.eTG);
                                intent.addFlags(67108864);
                                intent.putExtra("LauncherUI.enter_from_reg", true);
                                MMWizardActivity.b(this.eTG, intent22, intent);
                                this.eTG.finish();
                            }
                        }
                        intent22 = com.tencent.mm.plugin.account.a.a.ezn.be(this.eTG);
                        intent22.addFlags(67108864);
                        intent22.putExtra("LauncherUI.enter_from_reg", true);
                        this.eTG.startActivity(intent22);
                        StringBuilder stringBuilder2 = new StringBuilder();
                        g.Eg();
                        stringBuilder2 = stringBuilder2.append(com.tencent.mm.kernel.a.DA()).append(",").append(this.eTG.getClass().getName()).append(",R200_900_phone,");
                        g.Eg();
                        com.tencent.mm.plugin.c.a.pV(stringBuilder2.append(com.tencent.mm.kernel.a.gd("R200_900_phone")).append(",4").toString());
                        this.eTG.finish();
                    } else {
                        String str102 = com.tencent.mm.compatible.util.e.dgs + "temp.avatar";
                        str2 = com.tencent.mm.compatible.util.e.dgs + "temp.avatar.hd";
                        new File(str102).renameTo(new File(str2));
                        com.tencent.mm.a.e.deleteFile(str102);
                        c.c(str2, 96, 96, CompressFormat.JPEG, 90, str102);
                        new com.tencent.mm.aa.o(this.eTG, com.tencent.mm.compatible.util.e.dgs + "temp.avatar").a(new 5(this, lVar, str7, Rp, z, str6, str9, i3), new 6(this, lVar, str7, Rp, z, str6, str9, i3));
                    }
                }
                eV = com.tencent.mm.h.a.eV(str);
                if (eV != null) {
                    eV.a(this.eTG, null, null);
                    return;
                }
            }
            if (!this.eTG.e(i, i2, str)) {
                if (lVar.getType() == 701) {
                    eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null && eV.a(this.eTG, null, null)) {
                        return;
                    }
                }
                if (i != 0 || i2 != 0) {
                    Toast.makeText(this.eTG, this.eTG.getString(j.bind_mcontact_verify_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        } else {
            g.DF().b(701, this);
            this.eSA.a(this.eTG, i, i2, str, lVar);
            if (i == 0 && i2 == 0) {
                if (lVar instanceof q) {
                    this.eTN = ((q) lVar).Rm();
                }
                g.DF().a(255, this);
                r rVar = new r(1);
                g.DF().a(rVar, 0);
                mobileVerifyUI = this.eTG;
                mobileVerifyUI2 = this.eTG;
                this.eTG.getString(j.app_tip);
                mobileVerifyUI.eHw = h.a(mobileVerifyUI2, this.eTG.getString(j.app_loading), true, new 12(this, rVar));
            }
        }
    }
}
