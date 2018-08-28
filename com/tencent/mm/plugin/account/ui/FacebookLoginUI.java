package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.a.k;
import com.tencent.mm.plugin.account.ui.b.1;
import com.tencent.mm.plugin.account.ui.b.2;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.smtt.sdk.TbsMediaPlayer$TbsMediaPlayerListener;
import com.tencent.ugc.TXRecordCommon;

public class FacebookLoginUI extends MMPreference implements e {
    private String cbP = "";
    private String eHy;
    private ProgressDialog ePA;
    private OnCancelListener ePB;
    private c eQf = new 1(this);
    private com.tencent.mm.ui.f.a.c eQq;
    private String eQr = "";
    private q eQs;
    private b eQt;
    boolean eQu = true;

    static /* synthetic */ void cn(boolean z) {
        int i = z ? 19 : 20;
        g.Ei().dqk.set(i, Integer.valueOf(bi.a((Integer) g.Ei().dqk.get(i), 0) + 1));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(j.app_name);
        a.ezo.vo();
        this.eHy = com.tencent.mm.plugin.c.a.Zu();
        initView();
        g.DF().a(TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        g.DF().b(TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START, this);
    }

    protected void onResume() {
        com.tencent.mm.sdk.b.a.sFg.b(this.eQf);
        super.onResume();
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",L100_200_FB,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("L100_200_FB")).append(",1").toString());
        com.tencent.mm.plugin.c.a.pT("L100_200_FB");
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.sFg.c(this.eQf);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",L100_200_FB,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("L100_200_FB")).append(",2").toString());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        com.tencent.mm.plugin.c.a.pU(this.eHy);
        finish();
    }

    private void Yw() {
        try {
            if (this.eQq != null) {
                this.eQq.gY(this);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FacebookLoginUI", e, "", new Object[0]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",L14,");
        g.Eg();
        com.tencent.mm.plugin.c.a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("L14")).append(",1").toString());
        this.eQq = new com.tencent.mm.ui.f.a.c("290293790992170");
        this.eQq.a(this, FacebookAuthUI.eQb, new a(this, (byte) 0));
        h.mEJ.a(582, 5, 1, false);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FacebookLoginUI", "dkwt onSceneEnd: hash:%d type:%d [%d,%d,%s]", new Object[]{Integer.valueOf(lVar.hashCode()), Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.ePA != null) {
            this.ePA.dismiss();
            this.ePA = null;
        }
        if (bi.ci(this) && (lVar instanceof q)) {
            boolean z;
            this.cbP = ((q) lVar).Rd();
            if (lVar.getType() == TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START && i == 4 && (i2 == -16 || i2 == -17)) {
                g.DF().a(new bg(new 2(this)), 0);
                z = true;
            } else {
                z = false;
            }
            if (z || (i == 0 && i2 == 0)) {
                com.tencent.mm.kernel.a.unhold();
                aa.oS("");
                com.tencent.mm.platformtools.x.bZ(this);
                aa.showAddrBookUploadConfirm(this, new 3(this), false, 2);
            } else if (i2 == -106) {
                aa.e(this, str, 0);
            } else if (i2 == -217) {
                aa.a(this, f.a((q) lVar), i2);
            } else if (i2 == -6 || i2 == -311 || i2 == -310) {
                if (this.eQt == null) {
                    this.eQt = new 4(this);
                }
                b bVar = this.eQt;
                byte[] Rf = ((q) lVar).Rf();
                bVar.ePq = lVar;
                if (bVar.eIX == null) {
                    bVar.eIX = SecurityImage.a.a(this, j.regbyqq_secimg_title, 0, Rf, "", "", new 1(bVar, this), null, new 2(bVar), bVar);
                } else {
                    bVar.eIX.a(0, Rf, "", "");
                }
            } else {
                if (i == 4) {
                    switch (i2) {
                        case -107:
                            com.tencent.mm.ui.base.h.i(this.mController.tml, j.facebooklogin_user_forbiden_reg, j.app_tip);
                            z = true;
                            break;
                        case -75:
                            aa.ch(this.mController.tml);
                            z = true;
                            break;
                        case -72:
                            com.tencent.mm.ui.base.h.i(this.mController.tml, j.regbyqq_auth_err_failed_niceqq, j.app_tip);
                            z = true;
                            break;
                        case -30:
                            if (d.qVQ) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", this.cbP);
                                intent.putExtra("showShare", false);
                                intent.putExtra("show_bottom", false);
                                intent.putExtra("needRedirect", false);
                                intent.putExtra("neverGetA8Key", true);
                                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
                                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
                                a.ezn.j(intent, this);
                            }
                            z = true;
                            break;
                        case -9:
                            com.tencent.mm.ui.base.h.i(this, j.login_err_mailnotverify, j.login_err_title);
                            z = true;
                            break;
                        case -7:
                            com.tencent.mm.ui.base.h.i(this.mController.tml, j.facebooklogin_user_exist, j.app_tip);
                            z = true;
                            break;
                        case -1:
                            if (g.DF().Lg() == 5) {
                                com.tencent.mm.ui.base.h.i(this, j.net_warn_server_down_tip, j.net_warn_server_down);
                                z = true;
                                break;
                            }
                        case TXRecordCommon.START_RECORD_ERR_NOT_INIT /*-4*/:
                        case -3:
                            com.tencent.mm.ui.base.h.i(this, j.errcode_password, j.login_err_title);
                            z = true;
                            break;
                    }
                }
                z = a.ezo.a(this.mController.tml, i, i2, str);
                if (!z) {
                    if (lVar.getType() == TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START) {
                        com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
                        if (eV != null && eV.a(this, null, null)) {
                            return;
                        }
                    }
                    Toast.makeText(this, getString(j.fmt_auth_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        }
    }

    protected final void initView() {
        this.eQq = new com.tencent.mm.ui.f.a.c("290293790992170");
        this.ePB = new 5(this);
        Yw();
        setBackBtn(new 6(this));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        String str = "MicroMsg.FacebookLoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.i(str, str2, objArr);
        if (i2 == -1 && i == 1024 && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.FacebookLoginUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(bi.oW(stringExtra));
            if (!bi.oW(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            x.i(str2, str3, objArr2);
            if (intExtra == -217) {
                Yw();
                return;
            }
        }
        this.eQq.g(i, i2, intent);
    }

    public final int Ys() {
        return k.facebook_login;
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        String str = preference.mKey;
        if (str == null) {
            x.e("MicroMsg.FacebookLoginUI", "onPreferenceTreeClick, key is null");
            return true;
        } else if (!str.equals("facebook_auth_bind_btn")) {
            return false;
        } else {
            Yw();
            return true;
        }
    }
}
