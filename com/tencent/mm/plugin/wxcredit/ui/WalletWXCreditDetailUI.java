package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxcredit.a.d;
import com.tencent.mm.plugin.wxcredit.a.k;
import com.tencent.mm.plugin.wxcredit.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

@a(3)
public class WalletWXCreditDetailUI extends WalletPreferenceUI {
    private f eOE;
    private boolean hasInit = false;
    private OnClickListener mVS = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getId() == com.tencent.mm.plugin.wxpay.a.f.wallet_wxcredit_detail_username_tv) {
                if (WalletWXCreditDetailUI.this.qxo != null) {
                    e.ac(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.this.qxo.qwG.username);
                }
            } else if (view.getId() == com.tencent.mm.plugin.wxpay.a.f.wallet_wxcredit_detail_help_tv && WalletWXCreditDetailUI.this.qxo != null) {
                e.l(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.this.qxo.qwF, false);
            }
        }
    };
    private Bankcard pdJ;
    private c qxn;
    private k qxo;

    static /* synthetic */ void c(WalletWXCreditDetailUI walletWXCreditDetailUI) {
        Bundle bundle = walletWXCreditDetailUI.qxn.jfZ;
        bundle.putBoolean("offline_pay", false);
        bundle.putBoolean("key_is_show_detail", false);
        com.tencent.mm.wallet_core.a.a(walletWXCreditDetailUI, com.tencent.mm.plugin.wxcredit.f.class, bundle);
    }

    static /* synthetic */ void cbd() {
    }

    public final int Ys() {
        return l.wallet_wxcredit_detail_pref;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cDP().jr(621);
        cDP().jr(Downloads.DOWNLOAD_ERR_INTERRUPTED);
        ux(4);
        this.qxn = com.tencent.mm.wallet_core.a.af(this);
        if (this.pdJ == null) {
            this.pdJ = (Bankcard) this.qxn.jfZ.getParcelable("key_bankcard");
        }
        if (cbc()) {
            if (this.uYP == null) {
                if (this.uYN == null) {
                    this.uYN = com.tencent.mm.wallet_core.a.af(this);
                }
                this.uYP = this.uYN.a((MMActivity) this, this.uYO);
            }
            if (!this.uYP.r(new Object[]{this.pdJ})) {
                ux(0);
                initView();
            }
        }
    }

    private boolean cbc() {
        if (this.pdJ == null) {
            return false;
        }
        if (this.pdJ.field_bankcardState == 0) {
            return true;
        }
        int i = this.pdJ.field_wxcreditState;
        if (this.qxo != null) {
            i = this.qxo.qwr;
        }
        switch (i) {
            case 1:
                long bG = bi.bG(o.bOW().prJ);
                x.d("MicroMsg.WalletUserInfoManger", "pass time " + bG);
                if (bG > 300) {
                    i = 1;
                } else {
                    boolean z = false;
                }
                if (i != 0) {
                    return true;
                }
                return false;
            case 3:
                h.a(this, i.wallet_wxcredit_detail_review_fail, -1, false, new 1(this));
                return false;
            case 4:
                break;
            case 5:
                this.qxn.jfZ.putBoolean("key_can_unbind", false);
                break;
            default:
                return true;
        }
        if (this.qxo == null) {
            return true;
        }
        this.qxn.jfZ.putString("key_repayment_url", this.qxo.qwz);
        this.qxn.a((Activity) this, 1, this.qxn.jfZ);
        return false;
    }

    protected void onDestroy() {
        cDP().js(621);
        cDP().js(Downloads.DOWNLOAD_ERR_INTERRUPTED);
        super.onDestroy();
    }

    protected final void initView() {
        this.hasInit = true;
        setMMTitle(i.wallet_wxcredit_detail_title);
        this.eOE = this.tCL;
        setBackBtn(new 2(this));
        addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.mm_title_btn_menu, new 4(this));
    }

    private void aL() {
        String str;
        if (!this.hasInit) {
            initView();
        }
        if (this.qxo != null) {
            WalletWXCreditDetailHeaderPreference walletWXCreditDetailHeaderPreference = (WalletWXCreditDetailHeaderPreference) this.eOE.ZZ("wallet_wxcredit_header");
            walletWXCreditDetailHeaderPreference.eBQ.setText(e.B(this.qxo.qws));
            String str2 = this.pdJ.field_bankName;
            str = this.qxo.qwE;
            walletWXCreditDetailHeaderPreference.qxm.setText(walletWXCreditDetailHeaderPreference.mContext.getString(i.wallet_wxcredit_update_tips, new Object[]{str, str2}));
        }
        if (this.qxo != null) {
            boolean z;
            this.eOE.ZZ("wallet_wxcredit_total_amount").setTitle(getString(i.wallet_wxcredit_detail_total_amount, new Object[]{e.B(this.qxo.qwm)}));
            f fVar = this.eOE;
            str = "wallet_wxcredit_change_amount";
            if (this.qxo.qwx) {
                z = false;
            } else {
                z = true;
            }
            fVar.bw(str, z);
            Preference ZZ = this.eOE.ZZ("wallet_wxcredit_bill");
            if (this.qxo.qwt != 0.0d) {
                ZZ.setSummary(e.B(this.qxo.qwt));
            }
            ZZ = this.eOE.ZZ("wallet_wxcredit_repayment");
            Preference ZZ2 = this.eOE.ZZ("wallet_wxcredit_repayment_tips");
            if (this.qxo.qwv > 0.0d) {
                ZZ.setSummary(e.B(this.qxo.qwv));
                ZZ2.setTitle(getString(i.wallet_wxcredit_repayment_tips, new Object[]{this.qxo.qwA}));
                this.eOE.bw("wallet_wxcredit_repayment_tips", false);
            } else {
                this.eOE.bw("wallet_wxcredit_repayment_tips", true);
            }
        }
        if (this.pdJ != null) {
            this.eOE.ZZ("wallet_wxcredit_bank_name").setTitle(this.pdJ.field_bankName);
        }
        ((WalletWXCreditDetailFooterPreference) this.eOE.ZZ("wallet_wxcredit_footer")).mVS = this.mVS;
        this.eOE.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        Bundle bundle;
        if ("wallet_wxcredit_change_amount".equals(str)) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("key_bankcard", this.pdJ);
            com.tencent.mm.wallet_core.a.a(this, b.class, bundle2);
            return true;
        } else if ("wallet_wxcredit_bill".equals(str)) {
            if (this.qxo == null) {
                return false;
            }
            bundle = new Bundle();
            bundle.putString("key_url", this.qxo.qwD);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.c.class, bundle);
            return false;
        } else if ("wallet_wxcredit_card_info".equals(str)) {
            if (this.qxo == null) {
                return false;
            }
            bundle = new Bundle();
            bundle.putString("key_url", this.qxo.qwB);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.c.class, bundle);
            return false;
        } else if ("wallet_wxcredit_right".equals(str)) {
            if (this.qxo == null) {
                return false;
            }
            e.l(this, this.qxo.qwC, false);
            return false;
        } else if ("wallet_wxcredit_repayment".equals(str)) {
            if (this.qxo == null) {
                return false;
            }
            e.l(this, this.qxo.qwz, false);
            return false;
        } else if (!"wallet_wxcredit_bank_name".equals(str) || this.qxo == null) {
            return false;
        } else {
            e.ab(this, this.qxo.qwG.username);
            return false;
        }
    }

    public final boolean h(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (i == 0 && i2 == 0) {
            if (lVar instanceof d) {
                o.bOW().prJ = System.currentTimeMillis() / 1000;
                this.qxo = ((d) lVar).qwn;
                if (this.qxo != null && this.qxo.qwr == 2) {
                    g.Ek();
                    if (((Boolean) g.Ei().DT().get(196658, Boolean.valueOf(false))).booleanValue()) {
                        c af = com.tencent.mm.wallet_core.a.af(this);
                        Bundle bundle = af.jfZ;
                        bundle.putDouble("key_total_amount", this.qxo.qwm);
                        bundle.putBoolean("key_can_upgrade_amount", this.qxo.qwx);
                        af.a((Activity) this, WalletWXCreditOpenNotifyUI.class, bundle, 1);
                        return true;
                    }
                }
                if (cbc()) {
                    ux(0);
                    aL();
                }
                return true;
            } else if (lVar instanceof com.tencent.mm.plugin.wxcredit.a.i) {
                cDP().a(new y(), true, 1);
            } else if (lVar instanceof y) {
                finish();
            }
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        ux(0);
        aL();
        super.onActivityResult(i, i2, intent);
    }
}
