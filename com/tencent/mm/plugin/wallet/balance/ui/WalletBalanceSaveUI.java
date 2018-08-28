package com.tencent.mm.plugin.wallet.balance.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.c.ab;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.c;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@a(3)
public class WalletBalanceSaveUI extends WalletBaseUI {
    private final int eCE = com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), TXLiveConstants.RENDER_ROTATION_LANDSCAPE);
    protected Button eWk;
    protected WalletFormView hXD;
    private View hyK;
    private HashMap<String, Integer> lMb = new HashMap();
    public double myQ;
    private ArrayList<Bankcard> oZG;
    protected Bankcard oZH;
    private String oZI;
    public LinearLayout oZK;

    static /* synthetic */ void a(WalletBalanceSaveUI walletBalanceSaveUI) {
        List linkedList;
        walletBalanceSaveUI.lMb.clear();
        final c cVar = new c(walletBalanceSaveUI, 2, true);
        if (walletBalanceSaveUI.oZG == null) {
            linkedList = new LinkedList();
        } else {
            Object linkedList2 = walletBalanceSaveUI.oZG;
        }
        int size = linkedList2.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList2.size()) {
                Bankcard bankcard = (Bankcard) linkedList2.get(i2);
                if (!(walletBalanceSaveUI.oZH == null || bi.oW(bankcard.field_bindSerial) || !walletBalanceSaveUI.oZH.field_bindSerial.equals(bankcard.field_bindSerial))) {
                    size = i2;
                }
                i = i2 + 1;
            } else {
                cVar.ofp = new 4(walletBalanceSaveUI, linkedList2, cVar);
                cVar.ofq = new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        if (cVar != null) {
                            cVar.bzW();
                            if (i < linkedList2.size()) {
                                WalletBalanceSaveUI.this.oZH = (Bankcard) WalletBalanceSaveUI.this.oZG.get(i);
                                WalletBalanceSaveUI.this.aL();
                                return;
                            }
                            WalletBalanceSaveUI.this.oZH = null;
                            WalletBalanceSaveUI.this.aL();
                        }
                    }
                };
                View inflate = View.inflate(walletBalanceSaveUI, g.wallet_balance_fetch_bankcard_bottomsheet_header, null);
                inflate.findViewById(f.bfbh_header_desc_tv).setVisibility(8);
                ((TextView) inflate.findViewById(f.bfbh_header_title_tv)).setText(a$i.wallet_balance_bankcard_header_save_title_text);
                cVar.mqO = true;
                cVar.uKk = size;
                cVar.uKi = true;
                cVar.dS(inflate);
                cVar.bXO();
                return;
            }
        }
    }

    static /* synthetic */ void b(WalletBalanceSaveUI walletBalanceSaveUI) {
        if (walletBalanceSaveUI.hyK != null) {
            int[] iArr = new int[2];
            walletBalanceSaveUI.eWk.getLocationInWindow(iArr);
            int fl = (com.tencent.mm.bp.a.fl(walletBalanceSaveUI) - r0) - com.tencent.mm.bp.a.fromDPToPix(walletBalanceSaveUI, 30);
            x.d("MicroMsg.WalletBalanceSaveUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[]{Integer.valueOf(iArr[1] + walletBalanceSaveUI.eWk.getHeight()), Integer.valueOf(com.tencent.mm.bp.a.fl(walletBalanceSaveUI)), Integer.valueOf(fl), Integer.valueOf(walletBalanceSaveUI.eCE)});
            if (fl > 0 && fl < walletBalanceSaveUI.eCE) {
                x.d("MicroMsg.WalletBalanceSaveUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[]{Integer.valueOf(walletBalanceSaveUI.eCE - fl)});
                walletBalanceSaveUI.hyK.post(new 6(walletBalanceSaveUI, r0));
            }
        }
    }

    public boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            if (lVar instanceof com.tencent.mm.plugin.wallet.balance.a.c) {
                String str2;
                String str3;
                boolean a;
                com.tencent.mm.plugin.wallet.balance.a.c cVar = (com.tencent.mm.plugin.wallet.balance.a.c) lVar;
                if ("1".equals(cVar.ced)) {
                    x.i("MicroMsg.WalletBalanceSaveUI", "need realname verify");
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceSaveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    str2 = cVar.cee;
                    str2 = cVar.cef;
                    str3 = cVar.ceg;
                    bbR();
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, 0);
                } else if ("2".equals(cVar.ced)) {
                    x.i("MicroMsg.WalletBalanceSaveUI", "need upload credit");
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, cVar.cee, cVar.ceh, cVar.cef, cVar.ceg, bbR(), null);
                } else {
                    x.i("MicroMsg.WalletBalanceSaveUI", "realnameGuideFlag =  " + cVar.ced);
                    a = false;
                }
                if (!a) {
                    str2 = ((com.tencent.mm.plugin.wallet.balance.a.c) lVar).bQa;
                    u.j(11, str2, i2);
                    if (com.tencent.mm.plugin.wallet.b.a.bOi()) {
                        str3 = this.oZH == null ? "" : this.oZH.field_bindSerial;
                        String str4 = "";
                        double d = this.myQ;
                        if (!bi.oW(str2)) {
                            PayInfo I = h.I(str2, str4, 11);
                            I.qUS = d;
                            h.a(this, true, str3, I, 1);
                        }
                    } else {
                        h.a(this, this.oZH == null ? "" : this.oZH.field_bindSerial, str2, "", 11, 1);
                    }
                }
            } else if (lVar instanceof y) {
                bra();
                aL();
            }
        } else if (lVar instanceof com.tencent.mm.plugin.wallet.balance.a.c) {
            u.j(11, "", i2);
        }
        return false;
    }

    private void bra() {
        int i;
        p.bNp();
        ag bNq = p.bNq();
        this.oZG = bNq.bPF();
        this.oZH = bNq.a(this.oZG, null, false, true);
        if (this.oZH != null && bi.oW(this.oZH.field_forbidWord)) {
            this.oZH = null;
            i = 0;
            while (i < this.oZG.size()) {
                if (this.oZG.get(i) != null && bi.oW(((Bankcard) this.oZG.get(i)).field_forbidWord)) {
                    this.oZH = (Bankcard) this.oZG.get(i);
                    break;
                }
                i++;
            }
        }
        if (!(this.oZH == null || bi.oW(this.oZH.field_forbidWord))) {
            this.oZH = null;
        }
        ArrayList arrayList = this.oZG;
        if (arrayList != null) {
            for (i = 0; i < arrayList.size(); i++) {
                x.v("MicroMsg.WalletBalanceSaveUI", "pos %s word %s", new Object[]{Integer.valueOf(i), ((Bankcard) arrayList.get(i)).field_forbidWord});
            }
        }
    }

    protected final int getLayoutId() {
        return g.wallet_balance_save_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!q.GS()) {
            if (com.tencent.mm.plugin.wallet.b.a.bOi()) {
                a(new ab(), false, false);
            } else {
                a(new y(null, 3), false, false);
            }
        }
        bra();
        this.oZI = getString(a$i.wallet_balance_save_bind_new_card_to_save);
        initView();
        aL();
        com.tencent.mm.wallet_core.c.q.fu(3, 0);
    }

    protected final void initView() {
        setMMTitle(a$i.wallet_balance_save_title);
        this.hyK = findViewById(f.save_root_view);
        this.hXD = (WalletFormView) findViewById(f.money_ev);
        com.tencent.mm.wallet_core.ui.formview.a.f(this.hXD);
        this.hXD.getTitleTv().setText(v.cDm());
        d(this.hXD, 2, false);
        this.eWk = (Button) findViewById(f.next_btn);
        this.eWk.setOnClickListener(new 1(this));
        this.oZK = (LinearLayout) findViewById(f.balance_bankcard_layout);
        if (this.oZK != null) {
            this.oZK.setOnClickListener(new 2(this));
        }
        this.kTx = new 3(this);
    }

    private void aL() {
        if (this.oZK == null) {
            return;
        }
        if (this.oZH != null) {
            final ImageView imageView = (ImageView) this.oZK.findViewById(f.bankcard_logo_iv);
            String str = "";
            e h = b.h(this, this.oZH.field_bankcardType, this.oZH.bOr());
            if (h != null) {
                str = h.lCU;
            }
            imageView.setImageBitmap(null);
            if (this.oZH.bOs()) {
                imageView.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.wallet_balance_manager_logo_small);
            } else {
                Bitmap a = com.tencent.mm.platformtools.y.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str));
                com.tencent.mm.platformtools.y.a(new com.tencent.mm.platformtools.y.a() {
                    public final void m(String str, Bitmap bitmap) {
                        ah.A(new 1(this, bitmap));
                    }
                });
                if (!(a == null || a == null)) {
                    imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.c.a(a, getResources().getDimensionPixelOffset(com.tencent.mm.plugin.wxpay.a.d.wallet_offline_bank_logo_width), getResources().getDimensionPixelOffset(com.tencent.mm.plugin.wxpay.a.d.wallet_offline_bank_logo_width), true, false));
                }
            }
            ((TextView) this.oZK.findViewById(f.balance_bankcard_tv)).setText(getString(a$i.wallet_balance_save_bankcard_tips, new Object[]{this.oZH.field_bankName, this.oZH.field_bankcardTail}));
            ((TextView) this.oZK.findViewById(f.wallet_title)).setText(this.oZH.field_bankcardTypeName);
            if (bi.oW(this.oZH.field_avail_save_wording)) {
                x.i("MicroMsg.WalletBalanceSaveUI", "hy: wording's missing. use default");
                ((TextView) this.oZK.findViewById(f.hint_1)).setText("");
                return;
            }
            ((TextView) this.oZK.findViewById(f.hint_1)).setText(this.oZH.field_avail_save_wording);
            return;
        }
        ((TextView) this.oZK.findViewById(f.balance_bankcard_tv)).setText(this.oZI);
        ((TextView) this.oZK.findViewById(f.hint_1)).setText("");
        ((ImageView) this.oZK.findViewById(f.bankcard_logo_iv)).setImageBitmap(null);
        ((TextView) this.oZK.findViewById(f.wallet_title)).setText(getString(a$i.wallet_balance_save_bankcard_default_tips));
    }

    public void bNa() {
        if (this.oZH != null) {
            a(new com.tencent.mm.plugin.wallet.balance.a.c(this.myQ, "CNY", this.oZH.field_bindSerial, this.oZH.field_bankcardType), true, true);
            return;
        }
        com.tencent.mm.plugin.wallet_core.model.g bOA = com.tencent.mm.plugin.wallet_core.model.g.bOA();
        if (bOA.aKp()) {
            com.tencent.mm.ui.base.h.b(this, bOA.lMX, getString(a$i.app_tip), true);
        } else {
            a(new com.tencent.mm.plugin.wallet.balance.a.c(this.myQ, "CNY", "", ""), true, true);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
