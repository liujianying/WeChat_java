package com.tencent.mm.plugin.honey_pay.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.honey_pay.a.c;
import com.tencent.mm.plugin.honey_pay.a.d;
import com.tencent.mm.plugin.honey_pay.a.g;
import com.tencent.mm.plugin.honey_pay.a.n;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class HoneyPayCheckPwdUI extends HoneyPayBaseUI {
    private int fdx;
    private TextView gsY;
    private String gtX;
    private TextView hVS;
    private EditHintPasswdView kkY;
    private String kkZ;
    private String kkc;
    private btd kkd;
    private String kla;
    private long klb;
    private int klc;

    static /* synthetic */ void b(HoneyPayCheckPwdUI honeyPayCheckPwdUI) {
        x.i("MicroMsg.HoneyPayCheckPwdUI", "do get create token sign");
        honeyPayCheckPwdUI.aBy();
        d dVar = new d(honeyPayCheckPwdUI.kkZ, honeyPayCheckPwdUI.klb);
        dVar.m(honeyPayCheckPwdUI);
        honeyPayCheckPwdUI.a(dVar, false, false);
    }

    static /* synthetic */ void c(HoneyPayCheckPwdUI honeyPayCheckPwdUI) {
        x.i("MicroMsg.HoneyPayCheckPwdUI", "modify credit line token sign");
        honeyPayCheckPwdUI.aBy();
        g gVar = new g(honeyPayCheckPwdUI.kkc, honeyPayCheckPwdUI.klb);
        gVar.m(honeyPayCheckPwdUI);
        honeyPayCheckPwdUI.a(gVar, false, false);
    }

    static /* synthetic */ void d(HoneyPayCheckPwdUI honeyPayCheckPwdUI) {
        boolean z = true;
        String str = "MicroMsg.HoneyPayCheckPwdUI";
        String str2 = "do get pwd token: %s";
        Object[] objArr = new Object[1];
        if (honeyPayCheckPwdUI.kkd != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (honeyPayCheckPwdUI.kkd != null) {
            honeyPayCheckPwdUI.aBy();
            honeyPayCheckPwdUI.a(new w(honeyPayCheckPwdUI.kkY.getText(), honeyPayCheckPwdUI.kkd.sqz, honeyPayCheckPwdUI.kkd.sqy, honeyPayCheckPwdUI.kkd.sign, honeyPayCheckPwdUI.kkd.hFk, honeyPayCheckPwdUI.kkd.rFf), false, false);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gtX = getIntent().getStringExtra("key_username");
        this.kkZ = getIntent().getStringExtra("key_take_message");
        this.klb = getIntent().getLongExtra("key_credit_line", 0);
        this.fdx = getIntent().getIntExtra("key_scene", 0);
        this.kkc = getIntent().getStringExtra("key_card_no");
        this.kla = getIntent().getStringExtra("key_wishing");
        if (this.fdx == 1) {
            this.klc = getIntent().getIntExtra("key_cardtype", 0);
            if (this.klc == 0) {
                x.w("MicroMsg.HoneyPayCheckPwdUI", "error card type: %s", new Object[]{Integer.valueOf(this.klc)});
                finish();
            }
        }
        if (this.fdx == 3) {
            btd btd = new btd();
            try {
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_toke_mess");
                if (byteArrayExtra == null || byteArrayExtra.length == 0) {
                    x.w("MicroMsg.HoneyPayCheckPwdUI", "toke mess is null when unbind !!!");
                    finish();
                }
                btd.aG(byteArrayExtra);
                this.kkd = btd;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.HoneyPayCheckPwdUI", e, "", new Object[0]);
                finish();
            }
        }
        setMMTitle("");
        jr(2662);
        jr(2865);
        jr(2630);
        jr(2815);
        jr(2659);
        initView();
    }

    protected final void initView() {
        this.kkY = (EditHintPasswdView) findViewById(f.input_et);
        a.a(this.kkY);
        this.kkY.setOnInputValidListener(new 1(this));
        d(this.kkY, 0, false);
        this.gsY = (TextView) findViewById(f.wallet_pwd_title);
        this.hVS = (TextView) findViewById(f.wallet_pwd_content_1);
        if (this.fdx == 1) {
            this.gsY.setText(i.honey_pay_check_pwd_create_desc_text);
        } else if (this.fdx == 2) {
            this.gsY.setText(i.honey_pay_check_pwd_modify_desc_text);
        } else {
            this.gsY.setText(i.honey_pay_check_pwd_unbind_desc_text);
        }
        this.hVS.setText(i.honey_pay_check_pwd_title_text);
    }

    public void onDestroy() {
        super.onDestroy();
        js(2662);
        js(2865);
        js(2630);
        js(2815);
        js(2659);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.HoneyPayCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar instanceof w) {
            w wVar = (w) lVar;
            String str2;
            if (i != 0 || i2 != 0) {
                if (this.kkY != null) {
                    this.kkY.bqn();
                }
                bfe();
                if (!(wVar.uXo || bi.oW(str))) {
                    x.i("MicroMsg.HoneyPayCheckPwdUI", "show normal error msg");
                    h.a(this.mController.tml, str, null, false, new 10(this));
                }
            } else if (this.fdx == 1) {
                String str3 = wVar.pjE;
                x.i("MicroMsg.HoneyPayCheckPwdUI", "do give card");
                aBy();
                c cVar = new c(str3, this.klb, this.gtX, this.kkZ, this.klc, this.kla);
                cVar.m(this);
                a(cVar, false, false);
            } else if (this.fdx == 2) {
                str2 = wVar.pjE;
                x.i("MicroMsg.HoneyPayCheckPwdUI", "do modify quota");
                aBy();
                com.tencent.mm.plugin.honey_pay.a.h hVar = new com.tencent.mm.plugin.honey_pay.a.h(this.klb, str2, this.kkc);
                hVar.m(this);
                a(hVar, false, false);
            } else if (this.fdx == 3) {
                str2 = wVar.pjE;
                x.i("MicroMsg.HoneyPayCheckPwdUI", "do unbind: %s", new Object[]{this.kkc});
                aBy();
                n nVar = new n(this.kkc, str2);
                nVar.m(this);
                a(nVar, false, false);
            }
        } else if (lVar instanceof c) {
            c cVar2 = (c) lVar;
            bfe();
            cVar2.a(new 13(this, cVar2)).b(new 12(this)).c(new 11(this));
        } else if (lVar instanceof com.tencent.mm.plugin.honey_pay.a.h) {
            bfe();
            com.tencent.mm.plugin.honey_pay.a.h hVar2 = (com.tencent.mm.plugin.honey_pay.a.h) lVar;
            hVar2.a(new 16(this, hVar2)).b(new com.tencent.mm.wallet_core.c.h.a() {
                public final void g(int i, int i2, String str, l lVar) {
                    if (HoneyPayCheckPwdUI.this.kkY != null) {
                        HoneyPayCheckPwdUI.this.kkY.bqn();
                    }
                    com.tencent.mm.plugin.report.service.h.mEJ.e(875, 9, 1);
                }
            }).c(new 14(this));
        } else if (lVar instanceof d) {
            d dVar = (d) lVar;
            dVar.a(new 3(this, dVar)).b(new 2(this, dVar)).c(new 17(this));
        } else if (lVar instanceof g) {
            g gVar = (g) lVar;
            this.kkd = gVar.kjG.rHg;
            gVar.a(new 6(this)).b(new 5(this)).c(new 4(this));
        } else if (lVar instanceof n) {
            bfe();
            ((n) lVar).a(new com.tencent.mm.wallet_core.c.h.a() {
                public final void g(int i, int i2, String str, l lVar) {
                    HoneyPayCheckPwdUI.this.setResult(-1);
                    HoneyPayCheckPwdUI.this.finish();
                    com.tencent.mm.plugin.report.service.h.mEJ.e(875, 6, 1);
                }
            }).b(new 8(this)).c(new 7(this));
        }
        return true;
    }

    public final void rj(int i) {
        super.rj(i);
        if (this.kkY != null) {
            this.kkY.bqn();
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.honey_pay_check_pwd_ui;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
