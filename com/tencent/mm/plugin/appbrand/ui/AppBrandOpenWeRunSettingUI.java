package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.aa.c;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.z;
import com.tencent.mm.model.am.a;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.q;

public class AppBrandOpenWeRunSettingUI extends MMActivity implements e {
    private ImageView eBM;
    private TextView eBO;
    private TextView eBR;
    private TextView eIH;
    private TextView guR;
    private ab guS = null;
    p guT;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(getString(j.app_brand_open_we_run));
        this.eBM = (ImageView) findViewById(g.open_we_run_avatar_iv);
        this.eIH = (TextView) findViewById(g.open_we_run_nickname_tv);
        this.eBR = (TextView) findViewById(g.open_we_run_status_tv);
        this.eBO = (TextView) findViewById(g.open_we_run_title);
        this.guR = (TextView) findViewById(g.open_we_run_open);
        this.guR.setOnClickListener(new 1(this));
        setBackBtn(new 2(this));
        String oV = bi.oV(getIntent().getStringExtra("OpenWeRunSettingName"));
        this.guS = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yg("gh_43f2581f6fd6");
        if (this.guS == null || ((int) this.guS.dhP) == 0) {
            getString(j.app_tip);
            this.guT = h.a(this, getString(j.app_waiting), true, null);
            this.guT.show();
            a.dBr.a("gh_43f2581f6fd6", "", new 3(this));
        }
        this.eBO.setText(getString(j.app_brand_open_we_run_title, new Object[]{oV}));
        anw();
    }

    protected final int getLayoutId() {
        return s.h.app_brand_open_we_run_ui;
    }

    private void anw() {
        b.a(this.eBM, this.guS.field_username);
        this.eIH.setText(this.guS.BL());
        if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
            this.eBR.setTextColor(q.hb(this.mController.tml));
            this.eBR.setText(((com.tencent.mm.plugin.appbrand.compat.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.compat.a.a.class)).cs(this));
            this.eBR.setCompoundDrawablesWithIntrinsicBounds(f.status_enable, 0, 0, 0);
            this.guR.setText(((com.tencent.mm.plugin.appbrand.compat.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.compat.a.a.class)).cs(this));
            this.guR.setClickable(false);
            return;
        }
        this.eBR.setTextColor(q.hc(this.mController.tml));
        this.eBR.setText(((com.tencent.mm.plugin.appbrand.compat.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.compat.a.a.class)).ct(this));
        this.eBR.setCompoundDrawablesWithIntrinsicBounds(f.status_disable, 0, 0, 0);
        this.guR.setText(((com.tencent.mm.plugin.appbrand.compat.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.compat.a.a.class)).cr(this));
        this.guR.setClickable(true);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof m) {
            com.tencent.mm.kernel.g.Eh().dpP.b(30, this);
            if (i == 0 && i2 == 0) {
                String cby = ((m) lVar).cby();
                x.i("MicroMsg.AppBrandOpenWeRunSettingUI", "bind fitness contact %s success", new Object[]{cby});
                this.guS = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yg("gh_43f2581f6fd6");
                ab abVar = this.guS;
                if (abVar == null || bi.oW(cby)) {
                    x.e("MicroMsg.AppBrandOpenWeRunSettingUI", "respUsername == " + cby + ", contact = " + abVar);
                } else {
                    d dVar;
                    if (com.tencent.mm.model.s.hd(abVar.field_username)) {
                        String oV = bi.oV(abVar.field_username);
                        d kH = com.tencent.mm.ac.f.kH(oV);
                        if (kH != null) {
                            kH.field_username = cby;
                        }
                        z.MY().delete(oV);
                        abVar.dD(oV);
                        dVar = kH;
                    } else {
                        dVar = null;
                    }
                    abVar.setUsername(cby);
                    if (((int) abVar.dhP) == 0) {
                        ((i) com.tencent.mm.kernel.g.l(i.class)).FR().U(abVar);
                    }
                    if (((int) abVar.dhP) <= 0) {
                        x.e("MicroMsg.AppBrandOpenWeRunSettingUI", "addContact : insert contact failed");
                    } else {
                        com.tencent.mm.model.s.p(abVar);
                        ab Yg = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yg(abVar.field_username);
                        if (dVar != null) {
                            z.MY().d(dVar);
                        } else {
                            dVar = com.tencent.mm.ac.f.kH(Yg.field_username);
                            if (dVar == null || dVar.LS()) {
                                x.d("MicroMsg.AppBrandOpenWeRunSettingUI", "shouldUpdate");
                                a.dBr.R(Yg.field_username, "");
                                c.jN(Yg.field_username);
                            } else if (Yg.ckZ()) {
                                x.d("MicroMsg.AppBrandOpenWeRunSettingUI", "update contact, last check time=%d", new Object[]{Integer.valueOf(Yg.csR)});
                                a.dBr.R(Yg.field_username, "");
                                c.jN(Yg.field_username);
                            }
                        }
                    }
                }
                z.MY().e(z.MY().kA(this.guS.field_username));
                com.tencent.mm.kernel.g.Ei().DT().set(327825, Boolean.valueOf(true));
                setResult(-1);
                ah.i(new 4(this), 1500);
            } else {
                x.e("MicroMsg.AppBrandOpenWeRunSettingUI", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (i == 4 && i2 == -24 && !bi.oW(str)) {
                    Toast.makeText(ad.getContext(), str, 1).show();
                }
                setResult(1);
            }
            if (this.guT != null) {
                this.guT.dismiss();
            }
            anw();
        }
    }
}
