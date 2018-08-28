package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.h;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a(3)
public class WalletForgotPwdUI extends WalletBaseUI implements WalletFormView.a {
    private Button eUb;
    private ListView eZb;
    private LinearLayout gxf;
    private ArrayList<Bankcard> pcZ = new ArrayList();
    c pdx = new 8(this);
    private List<ElementQuery> phB = new LinkedList();
    private Bankcard phC;
    private a phD;
    private WalletFormView phE;
    private WalletFormView phF;
    private int phG = 1;
    private boolean phH = false;
    private boolean phI = false;
    c phJ = new 7(this);

    static /* synthetic */ void a(WalletForgotPwdUI walletForgotPwdUI, String str, String str2, Bitmap bitmap) {
        Bundle bundle = new Bundle();
        bundle.putString("key_bankcard_id", str);
        bundle.putString("key_bankcard_des", str2);
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        bundle.putBoolean("key_is_reset_with_new_card", true);
        com.tencent.mm.wallet_core.c af = com.tencent.mm.wallet_core.a.af(walletForgotPwdUI);
        if (af != null) {
            af.a(walletForgotPwdUI, WalletConfirmCardIDUI.class, bundle, 1);
        }
    }

    static /* synthetic */ void c(WalletForgotPwdUI walletForgotPwdUI) {
        if (!"1".equals(o.bOS().bPU().field_reset_passwd_flag)) {
            x.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new");
        } else if (bi.oW(o.bOS().bPU().field_find_passwd_url)) {
            x.i("MicroMsg.WalletForgotPwdUI", "hy: support bind new directly");
            ((ViewStub) walletForgotPwdUI.findViewById(a$f.forget_pwd_stub_bind_directly)).inflate();
            ((WalletFormView) walletForgotPwdUI.findViewById(a$f.bind_new_to_forget)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    WalletForgotPwdUI.this.phH = true;
                    WalletForgotPwdUI.this.YO();
                }
            });
        } else {
            x.i("MicroMsg.WalletForgotPwdUI", "hy: support bind new h5");
            ((ViewStub) walletForgotPwdUI.findViewById(a$f.forget_pwd_stub_bind_url)).inflate();
            TextView textView = (TextView) walletForgotPwdUI.findViewById(a$f.forgot_bind_new_url_tips);
            h hVar = new h(walletForgotPwdUI);
            hVar.pvm = new 5(walletForgotPwdUI);
            String string = walletForgotPwdUI.getString(i.wallet_password_forget_bind_new_url_tips);
            CharSequence spannableString = new SpannableString(string);
            spannableString.setSpan(hVar, string.length() - 12, string.length(), 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.wallet_password_setting_ui_forget_title);
        this.phI = this.sy.getBoolean("key_is_force_bind", false);
        if (!this.phI) {
            a(new y(null, 6), true, true);
            ux(4);
        }
        initView();
        com.tencent.mm.sdk.b.a.sFg.b(this.phJ);
        com.tencent.mm.sdk.b.a.sFg.b(this.pdx);
    }

    public void onDestroy() {
        com.tencent.mm.sdk.b.a.sFg.c(this.phJ);
        com.tencent.mm.sdk.b.a.sFg.c(this.pdx);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        update();
    }

    private void update() {
        p.bNp();
        this.pcZ = p.bNq().bPD();
        if (this.pcZ == null || this.pcZ.size() == 0 || this.phI) {
            x.i("MicroMsg.WalletForgotPwdUI", "No bound bankcard process %s", new Object[]{Boolean.valueOf(this.phI)});
            this.pcZ = new ArrayList();
            this.gxf.setVisibility(0);
            this.eZb.setVisibility(8);
            setMMTitle(i.wallet_elment_title);
            ((TextView) findViewById(a$f.wallet_forgot_pwd_tips)).setText(getString(i.wallet_password_forget_passwd_bind_new_tip));
            WalletFormView walletFormView = this.phF;
            p.bNp();
            walletFormView.setText(e.acb(p.bNq().aCl()));
            return;
        }
        x.i("MicroMsg.WalletForgotPwdUI", "domestic process!");
        if (com.tencent.mm.wallet_core.a.af(this) != null) {
            a(new t(), true, false);
        }
        this.gxf.setVisibility(8);
        this.eUb.setVisibility(8);
        findViewById(a$f.more_button_tip).setVisibility(0);
        this.phD = new a(this, this);
        this.eZb.setAdapter(this.phD);
        this.phD.dEw = this.pcZ;
        this.phD.notifyDataSetChanged();
    }

    public void initView() {
        this.eZb = (ListView) findViewById(a$f.settings_lv_bankcard);
        this.gxf = (LinearLayout) findViewById(a$f.forget_ll);
        this.phF = (WalletFormView) findViewById(a$f.name_et);
        this.phE = (WalletFormView) findViewById(a$f.card_et);
        com.tencent.mm.wallet_core.ui.formview.a.b(this.phE);
        if (this.sy.getBoolean("key_is_paymanager", false)) {
            com.tencent.mm.wallet_core.ui.formview.a.d(this, this.phF);
        } else {
            com.tencent.mm.wallet_core.ui.formview.a.e(this, this.phF);
        }
        this.phF.setOnInputValidChangeListener(this);
        this.phE.setOnInputValidChangeListener(this);
        this.eUb = (Button) findViewById(a$f.next_btn);
        this.eUb.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(11353, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                WalletForgotPwdUI.this.YO();
            }
        });
        this.phH = false;
        p.bNp();
        this.pcZ = p.bNq().bPD();
        update();
        findViewById(a$f.more_button_tip).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                e.l(WalletForgotPwdUI.this, "https://kf.qq.com/touch/scene_product.html?scene_id=kf3258", false);
            }
        });
        ZB();
        a(this.phE, 0, false, false);
        this.phE.setOnInfoIvClickListener(new 3(this));
        this.phE.getInfoIv().setImageResource(a$h.wallet_scan_camera);
        this.phE.getInfoIv().setVisibility(0);
    }

    private void bOb() {
        this.sy.remove("elemt_query");
        this.sy.remove("key_bankcard");
        this.sy.remove("bank_name");
        this.sy.remove("key_card_id");
    }

    private void YO() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_reset_with_new_card", this.sy.getBoolean("key_is_reset_with_new_card", false));
        bOb();
        if (this.phC == null && !this.phH) {
            a(new t(null, this.phE.getText(), null), true, true);
        } else if (this.phH) {
            af bPU = o.bOS().bPU();
            if (bi.oW(bPU.field_find_passwd_url)) {
                bundle.putBoolean("key_is_force_bind", true);
                bundle.putBoolean("key_is_reset_with_new_card", true);
                if (cDK() != null) {
                    cDK().a(this, 0, bundle);
                    return;
                }
                return;
            }
            x.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new bankcard. start to url");
            e.l(this, bPU.field_find_passwd_url, false);
        } else {
            com.tencent.mm.wallet_core.c af = com.tencent.mm.wallet_core.a.af(this);
            bundle.putParcelable("key_bankcard", this.phC);
            ElementQuery elementQuery = new ElementQuery();
            for (Parcelable parcelable : this.phB) {
                x.i("MicroMsg.WalletForgotPwdUI", "helios:::" + parcelable.lMV);
                if (!bi.oW(parcelable.lMV) && !bi.oW(this.phC.field_bankcardType) && parcelable.lMV.trim().equals(this.phC.field_bankcardType.trim())) {
                    break;
                }
            }
            Parcelable parcelable2 = elementQuery;
            bundle.putParcelable("elemt_query", parcelable2);
            if (af != null) {
                af.a(this, 0, bundle);
            }
        }
    }

    protected final int getLayoutId() {
        return a$g.wallet_forgot_pwd_ui;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WalletForgotPwdUI", " errCode: %s errMsg :  scene: ", new Object[]{Integer.valueOf(i2), str, lVar});
        if (i == 0 && i2 == 0) {
            String str2;
            if (lVar instanceof t) {
                t tVar = (t) lVar;
                Bundle bundle = new Bundle();
                if (bi.oW(tVar.htC)) {
                    this.phB = tVar.pjy;
                    x.i("MicroMsg.WalletForgotPwdUI", "scene case 1 mCardId is null");
                    return true;
                } else if (tVar.pjz == null) {
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.phE.getText());
                    bundle.putBoolean("key_is_reset_with_new_card", true);
                    com.tencent.mm.wallet_core.a.j(this, bundle);
                } else if (tVar.pjz.isError()) {
                    x.i("MicroMsg.WalletForgotPwdUI", "scene case 2 mTargetElement is error");
                    com.tencent.mm.ui.base.h.i(this, i.wallet_bank_broken, i.app_tip);
                    return true;
                } else {
                    int i3;
                    str2 = "MicroMsg.WalletForgotPwdUI";
                    String str3 = "scene case 3 bankcards size %d";
                    Object[] objArr = new Object[1];
                    if (this.pcZ == null) {
                        i3 = 0;
                    } else {
                        i3 = this.pcZ.size();
                    }
                    objArr[0] = Integer.valueOf(i3);
                    x.i(str2, str3, objArr);
                    if (this.pcZ == null || this.pcZ.size() == 0) {
                        bOb();
                        bundle.putString("bank_name", tVar.pjz.knE);
                        bundle.putParcelable("elemt_query", tVar.pjz);
                        bundle.putString("key_card_id", this.phE.getText());
                        bundle.putBoolean("key_is_reset_with_new_card", true);
                        com.tencent.mm.wallet_core.a.j(this, bundle);
                        return true;
                    }
                }
            } else if (lVar instanceof y) {
                String str4 = "MicroMsg.WalletForgotPwdUI";
                str2 = "scene case queryBound adapter is null ? %s";
                Object[] objArr2 = new Object[1];
                objArr2[0] = Boolean.valueOf(this.phD == null);
                x.i(str4, str2, objArr2);
                if (this.phD != null) {
                    ArrayList arrayList = null;
                    if (o.bOW() != null) {
                        arrayList = o.bOW().bPD();
                    }
                    com.tencent.mm.wallet_core.c af = com.tencent.mm.wallet_core.a.af(this);
                    if (af != null) {
                        af.cCR();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Bankcard bankcard = (Bankcard) it.next();
                            if (bankcard.field_bankcardTag == 1) {
                                arrayList2.add(bankcard);
                            } else if (bankcard.field_bankcardTag == 2) {
                                arrayList3.add(bankcard);
                            }
                        }
                        if (arrayList2.size() > 0) {
                            this.pcZ = arrayList2;
                        } else {
                            this.pcZ = arrayList3;
                        }
                    }
                    str4 = "MicroMsg.WalletForgotPwdUI";
                    str2 = "scene case queryBound adapter update bankcardsize:  %d";
                    Object[] objArr3 = new Object[1];
                    objArr3[0] = Integer.valueOf(this.pcZ == null ? 0 : this.pcZ.size());
                    x.i(str4, str2, objArr3);
                    this.phD.dEw = this.pcZ;
                    new ag(Looper.getMainLooper()).post(new 4(this));
                }
            }
        }
        return false;
    }

    public final boolean bbU() {
        return true;
    }

    private boolean ZB() {
        if (this.eZb.getVisibility() == 0 || (this.phF.ZF() && this.phE.ZF())) {
            this.eUb.setEnabled(true);
            this.eUb.setClickable(true);
            return true;
        }
        this.eUb.setEnabled(false);
        this.eUb.setClickable(false);
        return false;
    }

    public final void fE(boolean z) {
        ZB();
    }

    protected boolean bND() {
        return true;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public final boolean bbR() {
        if ((this.pcZ == null || this.pcZ.size() == 0) && !bi.oW(o.bOS().bPU().field_find_passwd_url)) {
            return true;
        }
        return false;
    }

    protected final boolean aWj() {
        ux(bbR() ? 4 : 0);
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i, intent);
        if (i2 == -1 && 1 == i) {
            this.phE.set3DesValStr(intent.getStringExtra("key_bankcard_id"));
            YO();
        }
    }
}
