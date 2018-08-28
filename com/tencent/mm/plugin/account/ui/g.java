package com.tencent.mm.plugin.account.ui;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bg.a;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.ugc.TXRecordCommon;

public final class g {
    private String account = "";
    private String cbP;
    boolean eSi = false;
    private String eSr = "";
    private a eSs;
    private String username = "";

    public g(a aVar, String str, String str2, String str3) {
        this.username = str;
        this.account = str3;
        this.eSr = str2;
        this.eSs = aVar;
    }

    public final void a(MMActivity mMActivity) {
        q qVar = new q(this.username, this.eSr, 0, "", "", "", 0, "", false, true);
        com.tencent.mm.kernel.g.DF().a(qVar, 0);
        a aVar = this.eSs;
        mMActivity.getString(j.app_tip);
        aVar.a(h.a(mMActivity, mMActivity.getString(j.login_logining), true, new 1(this, qVar)));
    }

    public final void a(MMActivity mMActivity, int i, int i2, String str, l lVar) {
        int i3;
        if (i == 4 && (i2 == -16 || i2 == -17)) {
            com.tencent.mm.kernel.g.DF().a(new bg(new a() {
                public final void a(e eVar) {
                    if (eVar != null) {
                        c Lr = eVar.Lr();
                        byte[] bArr = new byte[0];
                        com.tencent.mm.kernel.g.Eg();
                        Lr.x(bArr, com.tencent.mm.kernel.a.Df());
                    }
                }
            }), 0);
            i3 = 1;
        } else {
            boolean i32 = false;
        }
        if (lVar instanceof q) {
            this.cbP = ((q) lVar).Rd();
        }
        String string;
        if (i32 != 0 || (i == 0 && i2 == 0)) {
            com.tencent.mm.kernel.a.unhold();
            x.bZ(mMActivity);
            aa.oS(this.account);
            aa.showAddrBookUploadConfirm(mMActivity, new 3(this, mMActivity), false, 2);
            if (this.eSi) {
                string = ad.getContext().getSharedPreferences("randomid_prefs", 4).getString("randomID", "");
                com.tencent.mm.plugin.report.service.h.mEJ.h(11930, new Object[]{string, Integer.valueOf(4)});
            }
        } else if (i2 == -106) {
            aa.e(mMActivity, str, 0);
        } else if (i2 == -217) {
            aa.a(mMActivity, f.a((q) lVar), i2);
        } else {
            int i4;
            if (com.tencent.mm.plugin.account.a.a.ezo.a(mMActivity, i, i2, str)) {
                i4 = 1;
            } else {
                if (i == 4) {
                    switch (i2) {
                        case -140:
                            if (!bi.oW(this.cbP)) {
                                aa.n(mMActivity, str, this.cbP);
                            }
                            i4 = 1;
                            break;
                        case -100:
                            com.tencent.mm.kernel.a.hold();
                            com.tencent.mm.kernel.g.Eg();
                            if (TextUtils.isEmpty(com.tencent.mm.kernel.a.Dh())) {
                                string = com.tencent.mm.bp.a.af(mMActivity, j.main_err_another_place);
                            } else {
                                com.tencent.mm.kernel.g.Eg();
                                string = com.tencent.mm.kernel.a.Dh();
                            }
                            h.a(mMActivity, string, mMActivity.getString(j.app_tip), new 4(this), new 5(this));
                            i4 = 1;
                            break;
                        case -75:
                            h.i(mMActivity, j.alpha_version_tip_login, j.app_tip);
                            i4 = 1;
                            break;
                        case -72:
                            h.i(mMActivity, j.regbyqq_auth_err_failed_niceqq, j.app_tip);
                            i4 = 1;
                            break;
                        case -9:
                            h.i(mMActivity, j.login_err_mailnotverify, j.login_err_title);
                            i4 = 1;
                            break;
                        case -1:
                            if (com.tencent.mm.kernel.g.DF().Lg() == 5) {
                                h.i(mMActivity, j.net_warn_server_down_tip, j.net_warn_server_down);
                                i4 = 1;
                                break;
                            }
                        case TXRecordCommon.START_RECORD_ERR_NOT_INIT /*-4*/:
                        case -3:
                            h.i(mMActivity, j.errcode_password, j.login_err_title);
                            i4 = 1;
                            break;
                    }
                }
                boolean i42 = false;
            }
            if (i42 == 0) {
                Toast.makeText(mMActivity, mMActivity.getString(j.fmt_auth_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }
}
