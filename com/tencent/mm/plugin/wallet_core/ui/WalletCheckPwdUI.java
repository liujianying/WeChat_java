package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.plugin.wallet_core.c.b;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.c.azw;
import com.tencent.mm.protocal.c.btk;
import com.tencent.mm.protocal.c.oh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.wcdb.database.SQLiteDatabase;

@a(3)
public class WalletCheckPwdUI extends WalletBaseUI {
    private String bOd;
    private int bQK = 0;
    private TextView eBT;
    private String eTo;
    private ScrollView fPS;
    public EditHintPasswdView kkY;
    private boolean puU = false;
    private LinearLayout puV;
    private ImageView puW;
    private TextView puX;
    private TextView puY;
    private TextView puZ;
    private boolean pva = false;
    private boolean pvb = false;
    private String pvc;
    private int pvd = 0;
    private int pve;
    private String pvf;
    private String pvg;
    private Animation pvh;

    protected final int getLayoutId() {
        return g.wallet_check_pwd;
    }

    public final void ux(int i) {
        this.mController.contentView.setVisibility(i);
    }

    public void onCreate(Bundle bundle) {
        int i = -1;
        super.onCreate(bundle);
        this.mController.hideTitleView();
        cqh();
        Intent intent = getIntent();
        if (intent == null || !getIntent().hasExtra("scene")) {
            c af = com.tencent.mm.wallet_core.a.af(this);
            if (af != null) {
                int i2 = af.jfZ.getInt("scene", -1);
                boolean z = i2 == 1 && "UnbindProcess".equals(af.aNK());
                this.pvb = z;
                i = i2;
            }
        } else {
            i = intent.getIntExtra("scene", -1);
        }
        if (i == 1) {
            l aVar;
            this.pva = true;
            x.d("Micromsg.WalletCheckPwdUI", "check pwd jsapi");
            ux(4);
            Bundle bundle2 = null;
            if (this.pvb) {
                c af2 = com.tencent.mm.wallet_core.a.af(this);
                if (af2 != null) {
                    bundle2 = af2.jfZ;
                }
                if (bundle2 == null) {
                    x.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] process.getContextData null");
                    setResult(1);
                    finish();
                }
            } else if (getIntent() == null) {
                x.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] intent null");
                setResult(0);
                finish();
            } else {
                bundle2 = getIntent().getExtras();
            }
            String string = bundle2.getString("appId");
            String string2 = bundle2.getString("timeStamp");
            String string3 = bundle2.getString("nonceStr");
            String string4 = bundle2.getString("packageExt");
            String string5 = bundle2.getString("signtype");
            String string6 = bundle2.getString("paySignature");
            String string7 = bundle2.getString("url");
            int i3 = bundle2.getInt("pay_channel", 0);
            if (this.pvb) {
                x.i("Micromsg.WalletCheckPwdUI", "appId is null? " + bi.oW(string));
                aVar = new com.tencent.mm.plugin.wallet_core.c.a(string, string2, string3, string4, string5, string6, string7, 10, "verifyWCPayPassword", i3);
            } else {
                aVar = new b(string, string2, string3, string4, string5, string6, string7, "verifyWCPayPassword", i3);
            }
            a(aVar, true, false);
        } else {
            ux(0);
            this.sy.getBoolean("key_is_expired_bankcard", false);
        }
        initView();
        bQf();
        setBackBtn(new 1(this));
        findViewById(f.close_button).setOnClickListener(new 2(this));
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.white));
            if (VERSION.SDK_INT >= 23) {
                window.getDecorView().setSystemUiVisibility(8192);
            }
        }
        this.mController.contentView.setFitsSystemWindows(true);
    }

    protected final void baT() {
        x.d("Micromsg.WalletCheckPwdUI", "check pwd ");
        this.uYO.baT();
    }

    public void onResume() {
        if (this.kkY != null) {
            this.kkY.bqn();
        }
        jr(580);
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        js(580);
    }

    public void onDestroy() {
        super.onDestroy();
        bQh();
    }

    protected final void initView() {
        bi.K(cDM());
        this.kkY = (EditHintPasswdView) findViewById(f.input_et);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.kkY);
        this.kkY.setOnInputValidListener(new 3(this));
        this.fPS = (ScrollView) findViewById(f.wcp_root_view);
        this.puV = (LinearLayout) findViewById(f.finger_print_layout);
        this.puW = (ImageView) findViewById(f.finger_print_icon);
        this.puY = (TextView) findViewById(f.wallet_pwd_title);
        this.puZ = (TextView) findViewById(f.wallet_pwd_content);
        this.puX = (TextView) findViewById(f.finger_print_tips);
        this.eBT = (TextView) findViewById(f.wcp_bottom_link_tv);
        this.eBT.setOnClickListener(new 4(this));
        this.kTx = new 5(this);
        d(this.kkY, 0, false);
        cDJ();
    }

    private void a(azw azw) {
        if (!(azw == null || bi.oW(azw.title))) {
            this.puY.setText(azw.title);
        }
        if (!(azw == null || bi.oW(azw.scE))) {
            this.puZ.setText(azw.scE);
        }
        bQf();
    }

    private void bQe() {
        x.i("Micromsg.WalletCheckPwdUI", "change mode: %s", Integer.valueOf(this.bQK));
        if (this.bQK == 1) {
            this.puV.setVisibility(0);
            this.kkY.setVisibility(8);
            this.eBT.setText(i.wallet_check_mode_pwd);
            Wq();
            if (bi.oW(this.pvg)) {
                this.puZ.setText(i.wallet_check_pwd_main_content_fp);
                return;
            } else {
                this.puZ.setText(this.pvg);
                return;
            }
        }
        this.puV.setVisibility(8);
        this.kkY.bqn();
        this.kkY.setVisibility(0);
        this.eBT.setText(i.wallet_check_mode_fp);
        cDJ();
        if (bi.oW(this.pvf)) {
            this.puZ.setText(i.wallet_check_pwd_main_content);
        } else {
            this.puZ.setText(this.pvf);
        }
    }

    private void bQf() {
        c cDK = cDK();
        if (cDK == null) {
            return;
        }
        if ("UnbindProcess".equals(cDK.aNK())) {
            this.puY.setText(i.wallet_index_ui_unbind_bankcard_title);
            this.puZ.setText(i.wallet_check_pwd_tip);
        } else if (cDK instanceof com.tencent.mm.plugin.wallet_core.b.b) {
            this.puY.setText(i.wallet_index_ui_bind_card_pref);
            this.puZ.setText(i.wallet_check_pwd_tip);
        } else if ("ModifyPwdProcess".equals(cDK.aNK())) {
            this.puY.setText(i.wallet_modify_password_title);
            this.puZ.setText(i.wallet_check_pwd_tip);
        } else if ("OfflineProcess".equals(cDK.aNK())) {
            this.puY.setText(i.wallet_check_pwd_open_offline);
            this.puZ.setText(i.wallet_check_pwd_tip);
        }
    }

    public boolean d(int i, int i2, String str, l lVar) {
        x.d("Micromsg.WalletCheckPwdUI", " errCode: " + i2 + " errMsg :" + str);
        c af;
        if (i != 0 || i2 != 0) {
            if (this.kkY != null) {
                this.kkY.bqn();
            }
            if (!(lVar instanceof com.tencent.mm.plugin.wallet_core.c.a) && !(lVar instanceof b)) {
                return false;
            }
            x.i("Micromsg.WalletCheckPwdUI", "check jsapi fail");
            af = com.tencent.mm.wallet_core.a.af(this);
            if (af == null || !af.aNK().equals("UnbindProcess")) {
                setResult(0);
                finish();
                return true;
            }
            setResult(1);
            af.jfZ.putInt("key_process_result_code", 1);
            com.tencent.mm.wallet_core.a.j(this, af.jfZ);
            return true;
        } else if (lVar instanceof r) {
            Bundle bundle = this.sy;
            bundle.putString("key_pwd1", this.kkY.getText());
            com.tencent.mm.wallet_core.a.j(this, bundle);
            if (this.kkY != null) {
                this.kkY.bqn();
            }
            finish();
            return true;
        } else if (lVar instanceof y) {
            h.bA(this, getString(i.wallet_check_pwd_unbind_success_tip));
            af = com.tencent.mm.wallet_core.a.af(this);
            if (af != null) {
                af.jfZ.putInt("key_process_result_code", -1);
            }
            com.tencent.mm.wallet_core.a.j(this, af.jfZ);
            if (this.kkY != null) {
                this.kkY.bqn();
            }
            finish();
            return true;
        } else if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
            com.tencent.mm.pluginsdk.wallet.f.Ul(((com.tencent.mm.plugin.wallet_core.c.a) lVar).bOj());
            this.pvc = ((com.tencent.mm.plugin.wallet_core.c.a) lVar).blM();
            setResult(-1);
            a(((oh) ((com.tencent.mm.plugin.wallet_core.c.a) lVar).diG.dIE.dIL).rsE);
            ux(0);
            return true;
        } else if (lVar instanceof b) {
            b bVar = (b) lVar;
            this.pvc = bVar.piY.token;
            this.bOd = bVar.piY.qUU;
            com.tencent.mm.pluginsdk.wallet.f.Ul(bVar.piY.qUU);
            if (bVar.piY.rsE != null) {
                this.pvf = bVar.piY.rsE.scE;
                this.pvg = bVar.piY.rsE.scF;
            }
            setResult(-1);
            a(bVar.piY.rsE);
            btk btk = bVar.piY.rsY;
            if (!(btk == null || btk.rkW == null)) {
                k kVar = (k) com.tencent.mm.kernel.g.l(k.class);
                if (btk.srh == 1 && kVar.aNi() && kVar.aNh() && !kVar.aNc()) {
                    x.i("Micromsg.WalletCheckPwdUI", "can use touch pay");
                    this.bQK = 1;
                    if (btk.rkW != null) {
                        s.pqR.jgX = btk.rkW.cfV();
                    }
                    s.pqR.jgY = btk.rkX == 1;
                    bQg();
                    this.eBT.setVisibility(0);
                }
            }
            bQe();
            ux(0);
            return true;
        } else if (!(lVar instanceof com.tencent.mm.plugin.wallet_core.c.s)) {
            return true;
        } else {
            com.tencent.mm.plugin.wallet_core.c.s sVar = (com.tencent.mm.plugin.wallet_core.c.s) lVar;
            if (sVar.bOk()) {
                x.i("Micromsg.WalletCheckPwdUI", "need free sms");
                Bundle bundle2 = new Bundle();
                bundle2.putString("key_pwd1", this.eTo);
                bundle2.putString("key_jsapi_token", this.pvc);
                bundle2.putString("key_relation_key", sVar.pjx);
                bundle2.putString("key_mobile", sVar.pjw);
                com.tencent.mm.wallet_core.a.a(this, l.class, bundle2, new c.a() {
                    public final Intent n(int i, Bundle bundle) {
                        Intent intent = new Intent();
                        intent.putExtra("token", bundle.getString("key_jsapi_token"));
                        intent.putExtra("key_process_result_code", i);
                        intent.setClass(WalletCheckPwdUI.this.mController.tml, WalletCheckPwdUI.class);
                        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                        intent.putExtra("key_process_is_stay", false);
                        return intent;
                    }
                });
                return true;
            }
            Intent intent = new Intent();
            intent.putExtra("token", ((com.tencent.mm.plugin.wallet_core.c.s) lVar).pju);
            setResult(-1, intent);
            finish();
            return true;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.kMk == null || !this.kMk.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.kMk.setVisibility(8);
        return true;
    }

    public boolean bND() {
        if (this.sy.getInt("key_pay_flag", 0) != 0) {
            return true;
        }
        return false;
    }

    public final void rj(int i) {
        if (this.puU) {
            finish();
        } else if (this.kkY != null) {
            this.kkY.bqn();
        }
    }

    public final boolean bbR() {
        return this.puU;
    }

    public int getForceOrientation() {
        return 1;
    }

    private void bQg() {
        com.tencent.mm.plugin.soter.c.a.bFf();
        final com.tencent.mm.sdk.b.b lgVar = new lg();
        lgVar.bVz.bQa = this.bOd;
        lgVar.bVz.bVB = 1;
        lgVar.bVz.bVD = new Runnable() {
            public final void run() {
                x.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback");
                lg.b bVar = lgVar.bVA;
                if (bVar == null) {
                    x.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, result == null");
                    return;
                }
                int i = bVar.errCode;
                x.v("Micromsg.WalletCheckPwdUI", "alvinluo errCode: %d, errMsg: %s", Integer.valueOf(i), bVar.Yy);
                if (i == 0) {
                    x.i("Micromsg.WalletCheckPwdUI", "hy: payInfo soterAuthReq: %s", bVar.bVE);
                    WalletCheckPwdUI.this.puX.setVisibility(8);
                    WalletCheckPwdUI.b(WalletCheckPwdUI.this, bVar.bVE);
                    com.tencent.mm.plugin.soter.c.a.xP(0);
                    return;
                }
                boolean z;
                x.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                int j = currentTimeMillis - WalletCheckPwdUI.this.pve;
                if (j > 1) {
                    WalletCheckPwdUI.this.pve = currentTimeMillis;
                    WalletCheckPwdUI.this.pvd = WalletCheckPwdUI.this.pvd + 1;
                }
                boolean z2 = i == 2 || i == 10308;
                if (bVar.bVF == 2) {
                    z = true;
                } else {
                    z = false;
                }
                x.v("Micromsg.WalletCheckPwdUI", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", Boolean.valueOf(z2), Integer.valueOf(WalletCheckPwdUI.this.pvd), Integer.valueOf(i), Boolean.valueOf(z));
                if ((z || (WalletCheckPwdUI.this.pvd < 3 && j > 1)) && !z2) {
                    x.v("Micromsg.WalletCheckPwdUI", "alvinluo fingerprint pay");
                    if (WalletCheckPwdUI.this.pvh == null) {
                        WalletCheckPwdUI.this.pvh = com.tencent.mm.ui.c.a.gz(WalletCheckPwdUI.this.mController.tml);
                    }
                    WalletCheckPwdUI.this.puX.setVisibility(0);
                    WalletCheckPwdUI.this.puX.startAnimation(WalletCheckPwdUI.this.pvh);
                    WalletCheckPwdUI.this.pvh.setFillAfter(true);
                    com.tencent.mm.plugin.soter.c.a.xP(1);
                } else if (WalletCheckPwdUI.this.pvd >= 3 || z2) {
                    x.v("Micromsg.WalletCheckPwdUI", "alvinluo change to pwd pay");
                    WalletCheckPwdUI.bQh();
                    WalletCheckPwdUI.this.bQK = 0;
                    WalletCheckPwdUI.this.bQe();
                    WalletCheckPwdUI.this.eBT.setVisibility(8);
                    com.tencent.mm.plugin.soter.c.a.xP(2);
                }
            }
        };
        com.tencent.mm.sdk.b.a.sFg.a(lgVar, Looper.getMainLooper());
    }

    private static void bQh() {
        x.i("Micromsg.WalletCheckPwdUI", "hy: send release FPManager");
        com.tencent.mm.sdk.b.a.sFg.m(new nd());
    }
}
