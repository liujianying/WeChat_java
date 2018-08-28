package com.tencent.mm.plugin.walletlock.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.plugin.walletlock.a$g;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.a.i;
import com.tencent.mm.plugin.walletlock.b.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.c;

public class WalletLockSettingUI extends MMPreference {
    private f eOE;
    private c evj;
    private int fdx = -1;
    private IconPreference pID;
    private IconPreference pIE;
    private IconPreference pIF;
    private boolean pIG = false;
    private boolean pIH = true;
    private boolean pII = true;

    public final int Ys() {
        return i.wallet_lock_setting_pref;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (WalletLockSettingUI.this.pIG) {
                    WalletLockSettingUI.this.p(0, 4, "user cancel setting wallet lock");
                } else {
                    WalletLockSettingUI.this.finish();
                }
                return false;
            }
        });
        setMMTitle(a$g.wallet_lock_page_title);
        this.eOE = this.tCL;
        this.eOE = this.tCL;
        this.pID = (IconPreference) this.eOE.ZZ("wallet_lock_fingerprint");
        this.pIE = (IconPreference) this.eOE.ZZ("wallet_lock_gesture");
        this.pIF = (IconPreference) this.eOE.ZZ("wallet_lock_close");
        this.fdx = getIntent().getIntExtra("key_wallet_lock_setting_scene", -1);
        if (this.fdx == 1) {
            this.pIG = true;
            this.pIH = false;
        }
        x.i("MicroMsg.WalletLockSettingUI", "alvinluo isNeedFinish: %b, isNeedShowOpenIcon: %b", new Object[]{Boolean.valueOf(this.pIG), Boolean.valueOf(this.pIH)});
    }

    protected void onResume() {
        super.onResume();
        bSj();
    }

    protected void onPause() {
        super.onPause();
        if (this.evj != null && this.evj.isShowing()) {
            this.evj.dismiss();
        }
    }

    public void onBackPressed() {
        x.i("MicroMsg.WalletLockSettingUI", "alvinluo onBackPressed");
        if (this.pIG) {
            p(0, 4, "user cancel setting wallet lock");
        } else {
            finish();
        }
    }

    private void p(int i, int i2, String str) {
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i2);
        intent.putExtra("key_err_msg", str);
        g(i, intent);
    }

    private void g(int i, Intent intent) {
        setResult(i, intent);
        finish();
    }

    private void bSj() {
        bSk();
        x.i("MicroMsg.WalletLockSettingUI", "alvinluo current wallet lock type: %d", new Object[]{Integer.valueOf(g.pIt.bRY())});
        g gVar = g.pIt;
        if (g.bSb()) {
            boolean bFl = h.bFl();
            g gVar2 = g.pIt;
            if (g.bRt()) {
                if (!bFl) {
                    this.eOE.bw("wallet_lock_fingerprint", false);
                    this.pID.setDesc(getString(a$g.wallet_lock_device_not_support_fingerprint));
                    this.pID.csj();
                    a(this.pID, true, false);
                    this.pID.setEnabled(false);
                    this.pID.tCp = true;
                    this.pII = false;
                } else if (this.pIH) {
                    this.eOE.bw("wallet_lock_fingerprint", false);
                    a(this.pID, true, true);
                }
            } else if (bFl) {
                this.eOE.bw("wallet_lock_fingerprint", false);
                a(this.pID, false, true);
            } else {
                this.eOE.bw("wallet_lock_fingerprint", true);
            }
        } else {
            x.w("MicroMsg.WalletLockSettingUI", "alvinluo FingerprintLock entry is not opened and don't show FingerprintLock entry");
            this.eOE.bw("wallet_lock_fingerprint", true);
        }
        Object[] objArr = new Object[1];
        g gVar3 = g.pIt;
        objArr[0] = Boolean.valueOf(g.bRE());
        x.i("MicroMsg.WalletLockSettingUI", "alvinluo isUserSetGesturePwd: %b", objArr);
        if (g.pIt.bRY() == 2 || g.pIt.bRY() != 1) {
            a(this.pIE, false, true);
            this.eOE.bw("wallet_lock_modify_gesture", true);
        } else if (this.pIH) {
            a(this.pIE, true, true);
            this.eOE.bw("wallet_lock_modify_gesture", false);
        }
        if (g.pIt.bRY() != 0) {
            a(this.pIF, false, true);
        } else if (this.pIH) {
            a(this.pIF, true, true);
        }
    }

    private void bSk() {
        if (this.pID != null && this.pII) {
            a(this.pID, false, this.pII);
        }
        if (this.pIE != null) {
            a(this.pIE, false, true);
        }
        if (this.pIF != null) {
            a(this.pIF, false, true);
        }
    }

    private void a(Preference preference, boolean z, boolean z2) {
        if (preference instanceof IconPreference) {
            IconPreference iconPreference = (IconPreference) preference;
            iconPreference.eW(a.fromDPToPix(this, 20), a.fromDPToPix(this, 20));
            if (z) {
                if (z2) {
                    iconPreference.Eu(com.tencent.mm.plugin.walletlock.a.f.radio_on);
                } else {
                    iconPreference.Eu(com.tencent.mm.plugin.walletlock.a.f.radio_default_on);
                }
                iconPreference.Ev(0);
                return;
            }
            iconPreference.Eu(com.tencent.mm.plugin.walletlock.a.f.radio_off);
            iconPreference.Ev(0);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        if ("wallet_lock_fingerprint".equals(preference.mKey)) {
            bSk();
            a(preference, true, true);
            if (this.pII && !(this.pIH && g.pIt.bRY() == 2)) {
                if (!com.tencent.d.a.a.hz(this)) {
                    this.evj = com.tencent.mm.ui.base.h.a((Context) this, getString(a$g.wallet_lock_no_fingerprint_tips), "", new 2(this));
                    this.evj.setCanceledOnTouchOutside(false);
                } else if (!(this.pIH && g.pIt.bRY() == 2)) {
                    x.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock");
                    ((b) com.tencent.mm.kernel.g.l(b.class)).b(this, 2, 1);
                }
            }
            return true;
        } else if ("wallet_lock_gesture".equals(preference.mKey)) {
            bSk();
            a(preference, true, true);
            if (g.pIt.bRY() != 1) {
                x.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture lock");
                ((b) com.tencent.mm.kernel.g.l(b.class)).b(this, 1, 2);
            }
            return true;
        } else if ("wallet_lock_close".equals(preference.mKey)) {
            bSk();
            a(preference, true, true);
            if (g.pIt.bRY() != 0) {
                x.i("MicroMsg.WalletLockSettingUI", "alvinluo request close wallet lock");
                ((b) com.tencent.mm.kernel.g.l(b.class)).i(this, 3);
            }
            return true;
        } else if (!"wallet_lock_modify_gesture".equals(preference.mKey)) {
            return false;
        } else {
            ((b) com.tencent.mm.kernel.g.l(b.class)).K(this);
            return true;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletLockSettingUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (intent == null) {
            x.e("MicroMsg.WalletLockSettingUI", "alvinluo data is null");
            return;
        }
        int intExtra = intent.getIntExtra("key_err_code", -1);
        x.i("MicroMsg.WalletLockSettingUI", "alvinluo wallet lock setting onActivityResult errCode: %d", new Object[]{Integer.valueOf(intExtra)});
        if (i == 1) {
            x.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock onActivityResult");
            if (intExtra == 0) {
                if (this.pIG) {
                    g(i2, intent);
                }
            } else if (intExtra != 4) {
                x.i("MicroMsg.WalletLockSettingUI", "alvinluo open fingerprint lock failed");
                zK(getString(a$g.wallet_lock_fingerprint_open_failed));
            }
        } else if (i == 2) {
            x.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture onActivityResult");
            if (intExtra == 0) {
                if (this.pIG) {
                    g(i2, intent);
                }
            } else if (intExtra != 4) {
                x.i("MicroMsg.WalletLockSettingUI", "alvinluo open gesture lock failed");
                zK(getString(a$g.wallet_lock_gesture_open_failed));
            }
        } else if (i != 3) {
        } else {
            if (intExtra == 0) {
                ((b) com.tencent.mm.kernel.g.l(b.class)).zw(0);
                g gVar = g.pIt;
                g.bRv();
                bSj();
                Toast.makeText(this, getString(a$g.wallet_lock_close_all_success), 0).show();
                com.tencent.mm.plugin.walletlock.b.h.bSd();
                if (this.pIG) {
                    p(-1, 0, "close wallet lock ok");
                }
            } else if (intExtra != 4) {
                zK(getString(a$g.wallet_lock_close_error));
            }
        }
    }

    private void zK(String str) {
        this.evj = com.tencent.mm.ui.base.h.a((Context) this, str, "", new 3(this));
        this.evj.setCanceledOnTouchOutside(false);
        this.evj.show();
    }
}
