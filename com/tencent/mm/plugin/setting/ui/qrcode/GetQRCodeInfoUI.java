package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;

public class GetQRCodeInfoUI extends MMBaseActivity implements e {
    private ProgressDialog eHw = null;
    private f mPz;

    static /* synthetic */ void a(GetQRCodeInfoUI getQRCodeInfoUI, String str) {
        if (!bi.oW(str)) {
            String str2 = "";
            if (str.startsWith("weixin://qr/")) {
                str2 = str.substring(12) + "@qr";
            } else if (str.startsWith("http://weixin.qq.com/r/")) {
                str2 = str.substring(23) + "@qr";
            }
            g.DF().a(s$l.AppCompatTheme_ratingBarStyle, getQRCodeInfoUI);
            getQRCodeInfoUI.mPz = new f(str2, 5);
            g.DF().a(getQRCodeInfoUI.mPz, 0);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.empty);
        Uri data = getIntent().getData();
        if (data == null) {
            finish();
            return;
        }
        String oV = bi.oV(data.getHost());
        String oV2 = bi.oV(data.getScheme());
        if (("http".equals(oV2) && "weixin.qq.com".equals(oV)) || ("weixin".equals(oV2) && "qr".equals(oV))) {
            g.DF().a(new bg(new 1(this)), 0);
        } else {
            finish();
        }
    }

    public void onResume() {
        super.onResume();
        getString(i.app_tip);
        this.eHw = h.a(this, getString(i.address_searching), true, new 2(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mPz != null) {
            g.DF().c(this.mPz);
        }
        g.DF().b(s$l.AppCompatTheme_ratingBarStyle, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.GetQRCodeInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (i == 4 && i2 == -2004) {
            h.a(this, i.qrcode_ban_by_expose, i.app_tip, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    GetQRCodeInfoUI.this.finish();
                }
            });
        } else if (i == 0 && i2 == 0) {
            bja bcS = ((f) lVar).bcS();
            String a = ab.a(bcS.rvi);
            q.Kp().g(a, ab.a(bcS.rcn));
            ((com.tencent.mm.pluginsdk.i) g.l(com.tencent.mm.pluginsdk.i.class)).a(new Intent(), bcS, 30);
            if (bi.oV(a).length() > 0) {
                if ((bcS.rTe & 8) > 0) {
                    com.tencent.mm.plugin.report.service.h.mEJ.k(10298, a + ",30");
                }
                d.c(this, "profile", ".ui.ContactInfoUI", 1);
            }
        } else {
            h.a(this, getString(i.fmt_search_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(i.app_tip), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    GetQRCodeInfoUI.this.finish();
                }
            });
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        b.ezn.q(new Intent(), this);
        finish();
    }
}
