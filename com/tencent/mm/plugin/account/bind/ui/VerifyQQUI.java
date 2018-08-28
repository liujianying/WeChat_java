package com.tencent.mm.plugin.account.bind.ui;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.bind.a.b;
import com.tencent.mm.protocal.c.hj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.smtt.sdk.WebViewClient;

public class VerifyQQUI extends MMWizardActivity implements e {
    private String bQX;
    private String bQZ;
    private byte[] dHe = null;
    private SecurityImage eIX = null;
    private long eJm = 0;
    private String eJn = "";
    private String eJo = "";
    private String eJp;
    private p tipDialog = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.DF().a(144, this);
    }

    public void onDestroy() {
        super.onDestroy();
        g.DF().b(144, this);
    }

    protected void onResume() {
        super.onResume();
        initView();
    }

    protected final int getLayoutId() {
        return a.g.bindqq_verifyqq;
    }

    public final boolean Xf() {
        YC();
        finish();
        return true;
    }

    protected final void initView() {
        hp hpVar = new hp();
        hpVar.bQV.context = this;
        com.tencent.mm.sdk.b.a.sFg.m(hpVar);
        this.bQX = hpVar.bQW.bQX;
        hq hqVar = new hq();
        com.tencent.mm.sdk.b.a.sFg.m(hqVar);
        this.bQZ = hqVar.bQY.bQZ;
        setMMTitle(j.bind_qq_verify_title);
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(j.app_finish), new 2(this, (EditText) findViewById(f.bind_qq_verify_qq_uin), (EditText) findViewById(f.bind_qq_verify_qq_pwd)));
    }

    public final void a(int i, int i2, String str, l lVar) {
        byte[] a;
        x.i("MicroMsg.VerifyQQUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        b bVar = (b) lVar;
        byte[] ba = g.Eg().Dp().ba(bVar.egu);
        x.i("MicroMsg.NetSceneBindQQ", "getRespImgBuf getWtloginMgr getVerifyImg:%d  uin:%d", new Object[]{Integer.valueOf(bi.i(ba, new byte[0]).length), Long.valueOf(bVar.egu)});
        if (bi.bC(ba)) {
            a = ab.a(((hj) bVar.diG.dIE.dIL).rcn);
        } else {
            a = ba;
        }
        this.dHe = a;
        this.eJo = ((hj) ((b) lVar).diG.dIE.dIL).rhV;
        if (this.dHe != null) {
            x.d("MicroMsg.VerifyQQUI", "imgSid:" + this.eJo + " img len" + this.dHe.length + " " + com.tencent.mm.compatible.util.g.Ac());
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.account.a.a.ezo.vl();
            h.a(this.mController.tml, j.bind_qq_verify_alert_succ, j.bind_qq_verify_alert_title, new 3(this));
            return;
        }
        Object obj;
        if (i == 4) {
            com.tencent.mm.h.a eV;
            switch (i2) {
                case -311:
                case -310:
                case WebViewClient.ERROR_CONNECT /*-6*/:
                    x.d("MicroMsg.VerifyQQUI", "imgSid:" + this.eJo + " img len" + this.dHe.length + " " + com.tencent.mm.compatible.util.g.Ac());
                    if (!g.Eg().Dx()) {
                        obj = 1;
                        break;
                    }
                    if (this.eIX == null) {
                        this.eIX = SecurityImage.a.a(this.mController.tml, j.regbyqq_secimg_title, 0, this.dHe, this.eJo, this.eJp, new 4(this), null, new 5(this), new a(this));
                    } else {
                        x.d("MicroMsg.VerifyQQUI", "imgSid:" + this.eJo + " img len" + this.dHe.length + " " + com.tencent.mm.compatible.util.g.Ac());
                        this.eIX.a(0, this.dHe, this.eJo, this.eJp);
                    }
                    obj = 1;
                    break;
                case -72:
                    h.i(this.mController.tml, j.bind_qq_verify_alert_failed_niceqq, j.app_tip);
                    obj = 1;
                    break;
                case -34:
                    h.i(this.mController.tml, j.bind_qq_verify_alert_failed_freq_limit, j.app_tip);
                    obj = 1;
                    break;
                case WebViewClient.ERROR_BAD_URL /*-12*/:
                    h.i(this.mController.tml, j.bind_qq_verify_alert_failed_content, j.bind_qq_verify_alert_failed_title);
                    obj = 1;
                    break;
                case WebViewClient.ERROR_PROXY_AUTHENTICATION /*-5*/:
                    h.i(this.mController.tml, j.bind_qq_verify_alert_failed_denial, j.app_tip);
                    obj = 1;
                    break;
                case WebViewClient.ERROR_AUTHENTICATION /*-4*/:
                case WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME /*-3*/:
                    eV = com.tencent.mm.h.a.eV(str);
                    if (eV == null) {
                        h.i(this.mController.tml, j.bind_qq_verify_alert_wrong, j.bind_qq_verify_alert_failed_title);
                        obj = 1;
                        break;
                    }
                    eV.a(this, null, null);
                    obj = 1;
                    break;
                default:
                    eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null) {
                        eV.a(this, null, null);
                        obj = 1;
                        break;
                    }
                    break;
            }
        }
        obj = null;
        if (obj == null) {
            Toast.makeText(this, getString(j.fmt_auth_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
