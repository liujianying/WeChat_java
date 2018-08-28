package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.tc;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@a(3)
public class WalletChangeBankcardUI extends WalletBaseUI implements a.a {
    public static int pfu = 1;
    protected int bVY = 0;
    public String eWo;
    protected TextView hEy;
    protected Button mAE;
    private c mBs = new 1(this);
    public Orders mCZ = null;
    public PayInfo mCn = null;
    public o oZD;
    public ArrayList<Bankcard> oZG;
    public Bankcard oZH = null;
    public Authen pdF = null;
    private a pfA;
    com.tencent.mm.plugin.wallet_core.ui.c pfB = null;
    protected ListView pfv;
    public int pfw;
    public g pfx = null;
    protected String pfy = null;
    public FavorPayInfo pfz;

    private void bNy() {
        com.tencent.mm.wallet_core.c af = com.tencent.mm.wallet_core.a.af(this);
        if (af != null) {
            af.c(this, 1);
        } else {
            finish();
        }
        tl tlVar = new tl();
        tlVar.ceY.result = -1;
        com.tencent.mm.sdk.b.a.sFg.m(tlVar);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.WalletChangeBankcardUI", "onActivityResult %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == pfu) {
            bNy();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.wallet_select_use_bankcard_title);
        Bundle bundle2 = this.sy;
        bundle2.putInt("key_err_code", 0);
        this.pfw = bundle2.getInt("key_support_bankcard", 1);
        this.pdF = (Authen) bundle2.getParcelable("key_authen");
        this.mCZ = (Orders) bundle2.getParcelable("key_orders");
        this.mCn = (PayInfo) bundle2.getParcelable("key_pay_info");
        this.pfz = (FavorPayInfo) bundle2.getParcelable("key_favor_pay_info");
        this.bVY = this.mCn == null ? 0 : this.mCn.bVY;
        x.i("MicroMsg.WalletChangeBankcardUI", "pay_scene %d", new Object[]{Integer.valueOf(this.bVY)});
        if (this.sy.getBoolean("key_is_filter_bank_type")) {
            jm(true);
        } else {
            this.oZG = jl(bNz());
        }
        if (!(this.mCZ == null || this.mCZ.ppf == null || this.mCZ.ppf.size() <= 0)) {
            this.pfy = getString(i.wallet_change_bankcard_tips, new Object[]{e.e(this.mCZ.mBj, this.mCZ.lNV), ((Commodity) this.mCZ.ppf.get(0)).desc});
        }
        bNA();
        initView();
        q.fu(7, 0);
        com.tencent.mm.sdk.b.a.sFg.b(this.mBs);
        if (this.sy.getBoolean("key_is_filter_bank_type") && this.pfx != null) {
            this.pfx.puO = false;
        }
    }

    private ArrayList<Bankcard> jl(boolean z) {
        if (this.bVY == 8) {
            p.bNp();
            return p.bNq().jt(z);
        }
        p.bNp();
        return p.bNq().jl(z);
    }

    public void onDestroy() {
        if (this.pfA != null) {
            this.pfA.bNx();
            this.pfA.release();
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.mBs);
        this.pfB = null;
        super.onDestroy();
    }

    private boolean bNz() {
        return (this.mCn == null || this.mCn.bVY == 11) ? false : true;
    }

    protected final void bNA() {
        if (this.oZG != null) {
            Collections.sort(this.oZG, new 2(this));
        }
    }

    public final void initView() {
        this.mAE = (Button) findViewById(f.pay_btn);
        this.mAE.setEnabled(false);
        this.mAE.setOnClickListener(new 3(this));
        if (bi.oW(this.sy.getString("key_pwd1"))) {
            this.mAE.setText(i.app_ok);
        } else {
            this.mAE.setText(i.wallet_pwd_dialog_pay_again);
        }
        this.pfv = (ListView) findViewById(f.settings_lv_address);
        this.pfx = bNB();
        this.pfv.setAdapter(this.pfx);
        this.pfv.setOnItemClickListener(new 4(this));
        aL();
    }

    public g bNB() {
        bNA();
        return new g(this, this.oZG, this.pfw, this.mCZ);
    }

    public final void aL() {
        this.hEy = (TextView) findViewById(f.input_tip);
        if (this.pfz != null && !bi.oW(this.pfz.pnT)) {
            this.hEy.setVisibility(0);
            this.hEy.setText(this.pfz.pnT);
        } else if (this.sy.getInt("key_main_bankcard_state", 0) != 0) {
            this.hEy.setVisibility(0);
            this.hEy.setText(this.pfy);
        } else {
            this.hEy.setVisibility(8);
        }
    }

    protected void zg(int i) {
        int i2 = 0;
        int size = this.oZG != null ? this.oZG.size() : 0;
        if (this.oZG != null && i < size) {
            Bankcard bankcard = (Bankcard) this.oZG.get(i);
            this.oZH = bankcard;
            if (this.mCn != null) {
                i2 = this.mCn.bVY;
            }
            u.d(i2, this.mCn == null ? "" : this.mCn.bOd, 13, this.oZH.field_bindSerial);
            this.pfx.puN = bankcard.field_bindSerial;
            this.mAE.setEnabled(true);
            this.pfx.notifyDataSetChanged();
            bNC();
        } else if (size == i) {
            com.tencent.mm.plugin.wallet_core.model.g bOA = com.tencent.mm.plugin.wallet_core.model.g.bOA();
            if (bOA.aKp()) {
                h.b(this, bOA.lMX, getString(i.app_tip), true);
                return;
            }
            if (this.mCn != null) {
                i2 = this.mCn.bVY;
            }
            u.d(i2, this.mCn == null ? "" : this.mCn.bOd, 14, "");
            this.sy.putInt("key_err_code", -1003);
            com.tencent.mm.wallet_core.a.j(this, this.sy);
        }
    }

    public void onResume() {
        this.sy.putInt("key_err_code", 0);
        super.onResume();
        if (this.pfB != null) {
            this.pfB.bPW();
        }
    }

    public final boolean bbR() {
        if (super.bbR()) {
            return true;
        }
        if (this.mCn == null || !this.mCn.jNf) {
            return false;
        }
        if (this.mCn.jNf) {
            return true;
        }
        p.bNp();
        if (p.bNq().bPs()) {
            return false;
        }
        return false;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.wallet_change_bankcard;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        int i2 = 0;
        if (i == 4 && this.pfz != null && this.oZG.size() == 0) {
            FavorPayInfo favorPayInfo = this.pfz;
            boolean z = (favorPayInfo == null || favorPayInfo.pnQ == 0) ? false : true;
            if (z) {
                x.i("MicroMsg.WalletChangeBankcardUI", "favor need bankcard bind but usr cancel");
                String string = this.sy.getString("key_is_cur_bankcard_bind_serial");
                if (bi.oW(string)) {
                    x.e("MicroMsg.WalletChangeBankcardUI", "curBankcardBindSerial null & finish");
                    return super.onKeyUp(i, keyEvent);
                }
                List jl = jl(true);
                if (jl != null && this.oZH == null) {
                    while (true) {
                        int i3 = i2;
                        if (i3 >= jl.size()) {
                            break;
                        } else if (string.equals(((Bankcard) jl.get(i3)).field_bindSerial)) {
                            x.i("MicroMsg.WalletChangeBankcardUI", "get cur bankcard, bind_serial:" + string);
                            this.oZH = (Bankcard) jl.get(i3);
                            break;
                        } else {
                            i2 = i3 + 1;
                        }
                    }
                    if (this.oZH == null) {
                        x.e("MicroMsg.WalletChangeBankcardUI", "mDefaultBankcard still null & finish");
                        return super.onKeyUp(i, keyEvent);
                    }
                }
                bNC();
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public boolean d(int i, int i2, String str, l lVar) {
        boolean z = false;
        if (i != 0 || i2 != 0) {
            Bundle bundle = new Bundle();
            bundle.putString("pwd", this.eWo);
            this.sy.putBoolean("key_need_verify_sms", false);
            ((k) com.tencent.mm.kernel.g.l(k.class)).a(this.pdF.mpb.pxN == 1, true, bundle);
            switch (i2) {
                case 100000:
                case 100001:
                case 100102:
                    this.mCn.qUM = i2;
                    bNC();
                    return true;
                case 100100:
                case 100101:
                    this.mCn.qUM = i2;
                    if (i2 == 100100) {
                        z = true;
                    }
                    if (this.pfA == null) {
                        this.pfA = new a(this, this);
                    }
                    this.pfA.a(z, this.mCn.bPZ, this.mCn.bOd);
                    x.i("MicroMsg.WalletChangeBankcardUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is " + z);
                    return true;
            }
        } else if (lVar instanceof com.tencent.mm.plugin.wallet.pay.a.c.e) {
            return true;
        } else {
            if (lVar instanceof b) {
                Bundle bundle2 = this.sy;
                b bVar = (b) lVar;
                if (!bi.oW(this.eWo)) {
                    bundle2.putString("key_pwd1", this.eWo);
                }
                bundle2.putString("kreq_token", bVar.token);
                bundle2.putParcelable("key_authen", bVar.pfc);
                bundle2.putBoolean("key_need_verify_sms", !bVar.pfa);
                bundle2.putParcelable("key_pay_info", this.mCn);
                bundle2.putInt("key_pay_flag", 3);
                RealnameGuideHelper realnameGuideHelper = bVar.lJN;
                if (realnameGuideHelper != null) {
                    bundle2.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
                Bundle bundle3 = new Bundle();
                bundle3.putString("pwd", this.eWo);
                ((k) com.tencent.mm.kernel.g.l(k.class)).a(bVar.bNu(), true, bundle3);
                if (bVar.pgm) {
                    bundle2.putParcelable("key_orders", bVar.pfb);
                    if (this.mCn != null && this.mCn.bVY == 8) {
                        tc tcVar = new tc();
                        tcVar.ceC.ceD = this.pdF.lMW;
                        com.tencent.mm.sdk.b.a.sFg.m(tcVar);
                    }
                }
                com.tencent.mm.wallet_core.a.j(this, bundle2);
                return true;
            }
        }
        return false;
    }

    public void bNC() {
        x.d("MicroMsg.WalletChangeBankcardUI", "pay with old bankcard!");
        String string = this.sy.getString("key_pwd1");
        if (bi.oW(string)) {
            ux(4);
            this.oZD = o.a(this, this.mCZ, this.pfz, this.oZH, this.mCn, new 5(this), new 6(this), new 7(this));
            this.pfB = this.oZD;
            return;
        }
        OQ(string);
    }

    public void OQ(String str) {
        this.pdF.pli = str;
        if (this.oZH != null) {
            this.sy.putString("key_mobile", this.oZH.field_mobile);
            this.sy.putParcelable("key_bankcard", this.oZH);
            this.pdF.lMW = this.oZH.field_bindSerial;
            this.pdF.lMV = this.oZH.field_bankcardType;
            if (this.pfz != null) {
                this.pdF.plu = this.pfz.pnP;
            } else {
                this.pdF.plu = null;
            }
            if (this.mCZ.ppg != null) {
                this.pdF.plt = this.mCZ.ppg.pdY;
            }
            if (this.mCZ != null && this.mCZ.pjA == 3) {
                boolean z;
                if (this.oZH.bOv()) {
                    this.pdF.bWA = 3;
                } else {
                    this.pdF.bWA = 6;
                }
                Bundle bundle = this.sy;
                String str2 = "key_is_oversea";
                if (this.oZH.bOv()) {
                    z = false;
                } else {
                    z = true;
                }
                bundle.putBoolean(str2, z);
            }
        }
        this.sy.putString("key_pwd1", str);
        this.sy.putParcelable("key_authen", this.pdF);
        b a = com.tencent.mm.plugin.wallet.pay.a.a.a(this.pdF, this.mCZ, false);
        if (a != null) {
            a.dox = "PayProcess";
            a.sy = this.sy;
            if (this.mCn.bVY == 6 && this.mCn.qUI == 100) {
                a.fdx = 100;
            } else {
                a.fdx = this.mCn.bVY;
            }
            a(a, true, true);
        }
    }

    protected final boolean bND() {
        return true;
    }

    public final void rj(int i) {
        if (i == 0) {
            bNE();
        } else if (i == 1) {
            this.sy.putString("key_pwd1", "");
            bNC();
        } else {
            x.w("MicroMsg.WalletChangeBankcardUI", "hy: clean ui data not handled");
        }
    }

    public final void bNE() {
        cDH();
        com.tencent.mm.wallet_core.c af = com.tencent.mm.wallet_core.a.af(this);
        if (af != null) {
            af.b(this, this.sy);
        } else {
            finish();
        }
    }

    protected int getForceOrientation() {
        return 1;
    }

    protected final void jm(boolean z) {
        int i = 0;
        this.oZG = jl(bNz());
        if (this.pfz != null) {
            int i2;
            if (this.pfz.pnQ != 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 != 0 && z) {
                String str = this.pfz.pnR;
                ArrayList arrayList = new ArrayList();
                while (true) {
                    i2 = i;
                    if (i2 < this.oZG.size()) {
                        Bankcard bankcard = (Bankcard) this.oZG.get(i2);
                        if (bi.oW(str)) {
                            if (!bankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
                                arrayList.add(bankcard);
                            }
                        } else if (bankcard.field_bankcardType.equals(str)) {
                            arrayList.add(bankcard);
                        }
                        i = i2 + 1;
                    } else {
                        this.oZG = arrayList;
                        bNA();
                        return;
                    }
                }
            }
        }
    }

    protected final boolean aWj() {
        return true;
    }

    public final void c(boolean z, String str, String str2) {
        x.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback");
        if (z) {
            x.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is true");
            this.mCn.bQb = str;
            this.mCn.bQc = str2;
            OQ(this.eWo);
            return;
        }
        x.e("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is false");
        OQ(this.eWo);
    }

    public void onPause() {
        super.onPause();
        if (this.pfB != null) {
            this.pfB.bPX();
        }
    }
}
