package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.sz.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;

public class MallIndexUI extends MallIndexBaseUI {
    private String cev;
    private boolean fWB = false;
    b kZP;
    private String kZQ;
    private ECardInfo kZR;
    private boolean kZS = true;
    private RelativeLayout kZT;
    private View kZU;
    private boolean kZV;
    private boolean kZW;
    q kZX = new q();
    private c<lf> kZY = new 1(this);
    private boolean kZZ = false;
    private d laa;

    static /* synthetic */ void m(MallIndexUI mallIndexUI) {
        w wVar = new w();
        mallIndexUI.laa = new d(mallIndexUI, 1, false);
        mallIndexUI.laa.ofp = new 13(mallIndexUI, wVar);
        mallIndexUI.laa.ofq = new 2(mallIndexUI, wVar);
        mallIndexUI.laa.bXO();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 3) {
            return;
        }
        if (i2 == -1) {
            this.kZX.bcc();
        } else {
            this.kZX.cancel();
        }
    }

    public void onCreate(Bundle bundle) {
        getWindow().requestFeature(9);
        ((com.tencent.mm.plugin.walletlock.a.b) g.l(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
        i.zk(2);
        this.kZP = new b();
        this.kZP.cdV = false;
        this.kZP.cdW = true;
        this.kZP.cdX = false;
        this.kZY.cht();
        this.kZX.pzb = new 6(this);
        super.onCreate(bundle);
    }

    protected final void bbO() {
        setMMTitle(a.i.mall_index_ui_title);
    }

    protected final void cs(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(f.bankcard_area);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(f.balance_area);
        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(f.offline_area);
        this.kZT = (RelativeLayout) view.findViewById(f.lqt_area);
        this.kZl = (TextView) view.findViewById(f.balance_num);
        if (this.kZl instanceof WalletTextView) {
            ((WalletTextView) this.kZl).setTypeface(7);
        }
        relativeLayout.setOnClickListener(new 7(this));
        relativeLayout2.setOnClickListener(new 8(this, view));
        relativeLayout3.setOnClickListener(new 9(this));
        this.kZT.setOnClickListener(new 10(this));
        if (this.kZV) {
            this.kZT.setVisibility(0);
        } else {
            this.kZT.setVisibility(8);
        }
        this.kZj = (ImageView) findViewById(f.bankcard_pic);
        this.kZk = (ImageView) view.findViewById(f.add_bankcard_new_notify_img);
        View findViewById = view.findViewById(f.balance_red_dot);
        g.Ek();
        if (((Integer) g.Ei().DT().get(aa.a.sXN, Integer.valueOf(-1))).intValue() == 1) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        this.kZU = view.findViewById(f.lqt_red_dot);
        g.Ek();
        if (((Integer) g.Ei().DT().get(aa.a.sXP, Integer.valueOf(-1))).intValue() == 1) {
            this.kZU.setVisibility(0);
        } else {
            this.kZU.setVisibility(8);
        }
        bca();
    }

    protected final void bbW() {
        sy syVar = new sy();
        syVar.cdO.buF = "1";
        syVar.bJX = new 11(this, syVar);
        com.tencent.mm.sdk.b.a.sFg.m(syVar);
    }

    protected final boolean bbS() {
        x.i("MicorMsg.MallIndexUI", "init BankcardList");
        final sz szVar = new sz();
        szVar.cdR.scene = 1;
        szVar.cdR.cdT = true;
        szVar.cdR.cdU = true;
        szVar.cdS.cdN = new Runnable() {
            boolean dJP = false;

            public final void run() {
                x.d("MicorMsg.MallIndexUI", "mUserInfo needBind : " + MallIndexUI.this.kZP.cdW + " hasNewTips : " + MallIndexUI.this.kZP.cdX + " swipeOn : " + MallIndexUI.this.kZP.cdY);
                if (MallIndexUI.this.fWB || MallIndexUI.this.mController.tml.isFinishing()) {
                    x.e("MicorMsg.MallIndexUI", "error for callback ac finish");
                    return;
                }
                x.i("MicorMsg.MallIndexUI", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", new Object[]{Boolean.valueOf(szVar.cdS.cew), Boolean.valueOf(this.dJP)});
                MallIndexUI.this.kZP = szVar.cdS;
                if (MallIndexUI.this.kZP.errCode == 0) {
                    boolean booleanValue;
                    MallIndexUI.this.bca();
                    MallIndexUI.this.bbX();
                    MallIndexUI mallIndexUI = MallIndexUI.this;
                    x.i("MicorMsg.MallIndexUI", "showGetNewWalletTip call");
                    if (mallIndexUI.kZP == null || !(mallIndexUI.kZP.cdV || mallIndexUI.kZP.ceb)) {
                        x.e("MicorMsg.MallIndexUI", "user is not reg or simplereg，should not show this dialog");
                    } else {
                        boolean bPm = o.bOW().bPw().bPm();
                        g.Ek();
                        Object obj = g.Ei().DT().get(aa.a.sSo, Boolean.valueOf(false));
                        if (obj != null) {
                            booleanValue = ((Boolean) obj).booleanValue();
                        } else {
                            booleanValue = false;
                        }
                        x.i("MicorMsg.MallIndexUI", "showGetNewWalletTip hadShow=" + booleanValue + ";isswc=" + bPm);
                        if (!booleanValue && bPm) {
                            g.Ek();
                            g.Ei().DT().a(aa.a.sSo, Boolean.valueOf(true));
                            h.a(mallIndexUI, mallIndexUI.getString(a.i.mall_multi_wallet_tip), null, true, null);
                        }
                    }
                    MallIndexUI.b(MallIndexUI.this, MallIndexUI.this.kZP);
                    MallIndexUI.this.bbZ();
                    x.i("MicorMsg.MallIndexUI", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", new Object[]{Integer.valueOf(MallIndexUI.this.kZP.cet), Boolean.valueOf(MallIndexUI.this.kZP.ceu), MallIndexUI.this.kZP.cev});
                    mallIndexUI = MallIndexUI.this;
                    if (MallIndexUI.this.kZP.cet == 1) {
                        booleanValue = true;
                    } else {
                        booleanValue = false;
                    }
                    mallIndexUI.kZV = booleanValue;
                    MallIndexUI.this.kZW = MallIndexUI.this.kZP.ceu;
                    MallIndexUI.this.cev = MallIndexUI.this.kZP.cev;
                    if (MallIndexUI.this.kZT != null) {
                        if (MallIndexUI.this.kZV) {
                            MallIndexUI.this.kZT.setVisibility(0);
                        } else {
                            MallIndexUI.this.kZT.setVisibility(8);
                        }
                    }
                    MallIndexUI mallIndexUI2 = MallIndexUI.this;
                    mallIndexUI2.kZX.a(new 3(mallIndexUI2), new ae().bPo());
                }
                if (szVar.cdS.cew && this.dJP) {
                    MallIndexUI.this.aL();
                }
                this.dJP = true;
            }
        };
        com.tencent.mm.sdk.b.a.sFg.a(szVar, Looper.myLooper());
        return false;
    }

    protected final void bca() {
        if (this.kZk != null) {
            if (!(com.tencent.mm.s.c.Cp().b(aa.a.sYd, aa.a.sYe) || this.kZP.cdX)) {
                int i;
                k kVar = o.bOW().prD;
                if (kVar != null) {
                    int i2 = kVar.field_red_dot_index;
                    g.Ek();
                    if (((Integer) g.Ei().DT().get(aa.a.sRJ, Integer.valueOf(-1))).intValue() >= i2 || i2 <= 0) {
                        x.i("MicorMsg.MallIndexUI", "bankcard do not need red point");
                    } else {
                        x.i("MicorMsg.MallIndexUI", "bankcard need red point");
                        i = 1;
                        if (i == 0) {
                            this.kZk.setVisibility(8);
                            return;
                        }
                    }
                }
                i = 0;
                if (i == 0) {
                    this.kZk.setVisibility(8);
                    return;
                }
            }
            this.kZk.setVisibility(0);
        }
    }

    protected final void bbX() {
        x.i("MicorMsg.MallIndexUI", "updateBalanceNum");
        ae aeVar = new ae();
        x.i("MicroMsg.WalletSwitchConfig", "isHideBalanceNum, ret = %s switchBit %s", new Object[]{Boolean.valueOf((aeVar.prx & 16384) > 0), Integer.valueOf(aeVar.prx)});
        if ((aeVar.prx & 16384) > 0) {
            g.Ek();
            String str = (String) g.Ei().DT().get(aa.a.sTl, getString(a.i.realname_balance_title));
            this.kZl.setTextColor(getResources().getColor(a$c.mall_index_balance_num_text_color_realname));
            this.kZl.setText(str);
            this.kZl.setVisibility(0);
            return;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isShowBalanceAmount, ret = %s switchBit %s", new Object[]{Boolean.valueOf((aeVar.prx & 4194304) > 0), Integer.valueOf(aeVar.prx)});
        if ((aeVar.prx & 4194304) > 0) {
            x.i("MicorMsg.MallIndexUI", "show balance amount");
            this.kZl.setTextColor(getResources().getColor(a$c.mall_index_balance_num_text_color));
            Bankcard bankcard = o.bOW().paw;
            if (bankcard == null || bankcard.plV < 0.0d) {
                this.kZl.setText(getString(a.i.wallet_index_ui_default_balance));
            } else {
                this.kZl.setText(e.B(bankcard.plV));
            }
            this.kZl.setVisibility(0);
            return;
        }
        this.kZl.setVisibility(8);
    }

    protected final void bbZ() {
        this.mController.removeAllOptionMenu();
        if (this.kZP == null || !this.kZP.cer) {
            addIconOptionMenu(0, a.h.actionbar_icon_dark_more, new 5(this));
            return;
        }
        int i;
        g.Ek();
        boolean booleanValue = ((Boolean) g.Ei().DT().get(aa.a.sZo, Boolean.valueOf(false))).booleanValue();
        x.i("MicorMsg.MallIndexUI", "addIconOptionMenuByMode, hasRedDot: %s", new Object[]{Boolean.valueOf(booleanValue)});
        addIconOptionMenu(0, booleanValue ? a.e.mall_indexui_new_menu_icon_with_reddot : a.e.mall_indexui_new_menu_icon, new 4(this, booleanValue));
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(0);
        if (booleanValue) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = "";
        objArr[3] = "";
        objArr[4] = Integer.valueOf(1);
        hVar.h(14872, objArr);
    }

    public void onResume() {
        x.v("MicorMsg.MallIndexUI", "alvinluo MallIndexUI onResume");
        this.kZX.onResume();
        com.tencent.mm.plugin.walletlock.a.b bVar = (com.tencent.mm.plugin.walletlock.a.b) g.l(com.tencent.mm.plugin.walletlock.a.b.class);
        bVar.a(this, bVar.bRo(), null);
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        this.kZX.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        this.kZY.dead();
    }

    protected final void bbP() {
        com.tencent.mm.plugin.mall.b.a.bcf();
    }

    protected final void bbQ() {
        o.bOS().bPU();
        if ((o.bOS().bPU().bPq() || o.bOS().bPU().bPp()) && com.tencent.mm.model.q.GS()) {
            x.e("MicorMsg.MallIndexUI", "hy: user not open wallet or status unknown. try query");
            a(new com.tencent.mm.plugin.wallet_core.c.b.a("", false), true, false);
        }
    }

    public void finish() {
        this.fWB = true;
        super.finish();
    }
}
