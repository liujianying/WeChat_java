package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.platformtools.a.a;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bmh;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;

public abstract class SetPwdUI extends MMActivity implements e {
    protected ProgressDialog eHw = null;
    protected String eWT;
    protected String eWU;
    public boolean eWV = true;

    protected abstract l YR();

    protected abstract String YS();

    protected abstract String YT();

    protected abstract boolean f(int i, int i2, String str);

    protected abstract void jo(int i);

    public void onCreate(Bundle bundle) {
        g.DF().a(YU(), this);
        super.onCreate(bundle);
        a(0, getString(j.app_finish), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SetPwdUI.this.Za();
                return true;
            }
        }, b.tmX);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SetPwdUI setPwdUI = SetPwdUI.this;
                if (setPwdUI.Zb() && setPwdUI.eWV) {
                    x.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
                    h.mEJ.h(11868, new Object[]{Integer.valueOf(1)});
                }
                setPwdUI.YC();
                setPwdUI.setResult(0);
                setPwdUI.finish();
                return true;
            }
        });
    }

    public void onDestroy() {
        g.DF().b(YU(), this);
        super.onDestroy();
    }

    protected ProgressDialog a(Context context, String str, OnCancelListener onCancelListener) {
        return com.tencent.mm.ui.base.h.a(context, str, true, onCancelListener);
    }

    protected int YU() {
        return 383;
    }

    protected final void Zo() {
        this.eWT = YS();
        this.eWU = YT();
        if (!bi.oW(this.eWT)) {
            if (!this.eWT.equals(this.eWU)) {
                jo(a.evo);
            } else if (this.eWT.length() > 16) {
                jo(a.evp);
            } else if (bi.WC(this.eWT)) {
                com.tencent.mm.ui.base.h.i(this, j.regbyfacebook_reg_setpwd_alert_using_chinese, j.regbymobile_reg_setpwd_alert_title);
            } else if (bi.WH(this.eWT)) {
                YC();
                final l YR = YR();
                g.DF().a(YR, 0);
                getString(j.app_tip);
                this.eHw = a(this, getString(j.reg_processing), new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        g.DF().c(YR);
                    }
                });
                if (Zb() && !this.eWV) {
                    x.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 0");
                    h.mEJ.h(11868, new Object[]{Integer.valueOf(0)});
                }
            } else if (this.eWT.length() < 8 || this.eWT.length() >= 16) {
                jo(a.evq);
            } else {
                jo(a.evr);
            }
        }
    }

    protected void Za() {
        Zo();
    }

    public void a(final int i, final int i2, final String str, l lVar) {
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (lVar.getType() == YU()) {
            if (lVar.getType() == 383) {
                if (i == 0 && i2 == 0) {
                    String string;
                    bmh bmh;
                    if (bi.oW((String) g.Ei().DT().get(6, null))) {
                        x.i("MicroMsg.SetPwdUI", "has not bind mobile");
                        string = getString(j.no_mobile_setpwd_success_tip);
                    } else {
                        x.i("MicroMsg.SetPwdUI", "has bind mobile");
                        string = getString(j.bind_mobile_setpwd_success_tip);
                    }
                    y yVar = (y) lVar;
                    if (yVar.diG == null || yVar.diG.dIE.dIL == null) {
                        bmh = null;
                    } else {
                        bmh = (bmh) yVar.diG.dIE.dIL;
                    }
                    if (!(bmh == null || bmh.res == null)) {
                        byte[] toByteArray = bmh.res.siK.toByteArray();
                        Editor edit = ad.getContext().getSharedPreferences("auth_info_key_prefs", 4).edit();
                        edit.putBoolean("key_auth_info_prefs_created", true);
                        edit.putInt("key_auth_update_version", d.qVN);
                        edit.putString("_auth_key", bi.bE(toByteArray));
                        g.Eg();
                        edit.putInt("_auth_uin", com.tencent.mm.kernel.a.Df());
                        edit.commit();
                    }
                    com.tencent.mm.ui.base.h.a(this, string, "", false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            SetPwdUI.this.setResult(-1);
                            if (!SetPwdUI.this.f(i, i2, str)) {
                            }
                        }
                    });
                }
            } else if (!f(i, i2, str)) {
                Toast.makeText(this, getString(j.fmt_set_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    protected final boolean e(int i, int i2, String str) {
        if (com.tencent.mm.plugin.account.a.a.ezo.a(this.mController.tml, i, i2, str)) {
            return true;
        }
        return false;
    }

    public boolean Zb() {
        return false;
    }

    public void onBackPressed() {
        if (this.eWV) {
            if (Zb()) {
                x.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
                h.mEJ.h(11868, new Object[]{Integer.valueOf(1)});
            }
            super.onBackPressed();
        }
    }
}
