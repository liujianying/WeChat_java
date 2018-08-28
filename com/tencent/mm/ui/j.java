package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.bb;
import com.tencent.mm.g.a.ia.a;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI.b;
import com.tencent.mm.ui.widget.a.c;

public final class j {
    int bIA = 0;
    ProgressDialog eHw;
    c eJi;
    boolean mRA;
    private View mRx;
    private TextView mRy;
    EditText mRz;
    MMFragmentActivity tiY;
    b tiZ;
    a tja = null;
    e tjb;
    boolean tjc = false;
    com.tencent.mm.sdk.b.c tjd = new 1(this);
    com.tencent.mm.sdk.b.c<bb> tje = new 2(this);

    static /* synthetic */ void a(j jVar, int i, int i2, int i3, String str) {
        x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert jumpByActionType  alertId[%d], actionType[%d], btnId[%d], url[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        h.mEJ.h(13191, new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(false)});
        Intent intent;
        switch (i2) {
            case 2:
                intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
                d.b(jVar.tiY, "webview", ".ui.tools.WebViewUI", intent);
                return;
            case 3:
                if (jVar.mRA) {
                    jVar.lx(true);
                    return;
                }
                jVar.cpu();
                au.DF().a(255, jVar.tjb);
                r rVar = new r(1);
                au.DF().a(rVar, 0);
                MMFragmentActivity mMFragmentActivity = jVar.tiY;
                jVar.getString(R.l.app_tip);
                jVar.eHw = com.tencent.mm.ui.base.h.a(mMFragmentActivity, jVar.getString(R.l.settings_loading), true, new 10(jVar, rVar));
                return;
            case 4:
                Intent intent2 = new Intent();
                intent2.setClass(jVar.tiY, BindMContactUI.class);
                intent2.putExtra("is_bind_for_change_mobile", true);
                String simCountryIso = ((TelephonyManager) jVar.tiY.getSystemService("phone")).getSimCountryIso();
                if (!ai.oW(simCountryIso)) {
                    com.tencent.mm.al.b.a j = com.tencent.mm.al.b.j(jVar.tiY, simCountryIso, jVar.getString(R.l.country_code));
                    if (j != null) {
                        intent2.putExtra("country_name", j.dYy);
                        intent2.putExtra("couttry_code", j.dYx);
                    }
                }
                MMWizardActivity.D(jVar.tiY, intent2);
                return;
            case 5:
                intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
                intent.setFlags(65536);
                if (!com.tencent.mm.p.a.bx(jVar.tiY) && !com.tencent.mm.ax.e.Sz()) {
                    d.b(jVar.tiY, "scanner", ".ui.BaseScanUI", intent);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public j(MMFragmentActivity mMFragmentActivity, b bVar) {
        this.tiY = mMFragmentActivity;
        this.tiZ = bVar;
    }

    final boolean a(a aVar) {
        if (aVar == null || aVar.bRz == null || aVar.bRz.qXY == null || aVar.bRz.qXY.size() == 0) {
            return false;
        }
        int i = aVar.bRz.id;
        String str = aVar.bRz.title;
        String str2 = aVar.bRz.bIr;
        int i2 = aVar.type;
        int size = aVar.bRz.qXY.size();
        if (i2 == 0) {
            if (size == 1) {
                com.tencent.mm.protocal.b.a.a aVar2 = (com.tencent.mm.protocal.b.a.a) aVar.bRz.qXY.get(0);
                x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(aVar2.id), Integer.valueOf(aVar2.actionType), aVar2.qXW, aVar2.qXX});
                com.tencent.mm.ui.base.h.a(this.tiY, str2, str, aVar2.qXW, false, new 7(this, i, aVar2));
            } else {
                com.tencent.mm.protocal.b.a.a aVar3 = (com.tencent.mm.protocal.b.a.a) aVar.bRz.qXY.get(1);
                com.tencent.mm.protocal.b.a.a aVar4 = (com.tencent.mm.protocal.b.a.a) aVar.bRz.qXY.get(0);
                x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", new Object[]{str, str2, Integer.valueOf(aVar3.id), Integer.valueOf(aVar3.actionType), aVar3.qXW, aVar3.qXX, Integer.valueOf(aVar4.id), Integer.valueOf(aVar4.actionType), aVar4.qXW, aVar4.qXX});
                com.tencent.mm.ui.base.h.a(this.tiY, str2, str, aVar3.qXW, aVar4.qXW, false, new 8(this, i, aVar3), new 9(this, i, aVar4));
            }
        } else if (i2 == 1) {
            String str3 = str2;
            String str4 = str;
            boolean z = false;
            com.tencent.mm.ui.base.h.a(this.tiY, str3, str4, ((com.tencent.mm.protocal.b.a.a) aVar.bRz.qXY.get(0)).qXW, ((com.tencent.mm.protocal.b.a.a) aVar.bRz.qXY.get(1)).qXW, z, aVar.bRA, aVar.bRB);
        }
        return true;
    }

    final e cpu() {
        if (this.tjb == null) {
            this.tjb = new 11(this);
        }
        return this.tjb;
    }

    final void lx(boolean z) {
        x.d("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert handlePassword " + z);
        if (z) {
            cpv();
            return;
        }
        Intent intent = new Intent(this.tiY, RegByMobileSetPwdUI.class);
        intent.putExtra("kintent_hint", getString(R.l.settings_modify_password_tip));
        this.tiY.startActivity(intent);
    }

    final void cpv() {
        if (this.eJi != null) {
            this.eJi.show();
            return;
        }
        if (this.mRx == null) {
            this.mRx = View.inflate(this.tiY, R.i.sendrequest_dialog, null);
            this.mRy = (TextView) this.mRx.findViewById(R.h.sendrequest_tip);
            this.mRy.setText(getString(R.l.settings_independent_password_tip));
            this.mRz = (EditText) this.mRx.findViewById(R.h.sendrequest_content);
            this.mRz.setInputType(129);
        }
        this.eJi = com.tencent.mm.ui.base.h.a(this.tiY, null, this.mRx, new 12(this), new 13(this));
    }

    final String getString(int i) {
        return this.tiY.getString(i);
    }
}
