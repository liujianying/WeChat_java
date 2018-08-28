package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage$a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.w;

public class NewTaskUI extends MMBaseActivity implements e {
    static NewTaskUI uBe;
    private ProgressDialog eHw = null;
    private SecurityImage eIX = null;
    private c eQf = new c<iz>() {
        {
            this.sFo = iz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            iz izVar = (iz) bVar;
            if (izVar == null || izVar.bSF == null) {
                return false;
            }
            x.i("MicroMsg.NewTaskUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", new Object[]{izVar.bSF.content, izVar.bSF.url});
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", izVar.bSF.content);
            intent.putExtra("key_disaster_url", izVar.bSF.url);
            intent.setClass(ad.getContext(), DisasterUI.class).addFlags(268435456);
            ad.getContext().startActivity(intent);
            return true;
        }
    };
    private h uBf = new h();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.NewTaskUI", "onCreate :%d", new Object[]{Integer.valueOf(hashCode())});
        setContentView(R.i.background_transparent);
        au.DF().a(701, this);
        uBe = this;
        q qVar = new q(0, "", "", "");
        au.DF().a(qVar, 0);
        getString(R.l.app_tip);
        this.eHw = h.a(this, getString(R.l.login_logining), true, new 2(this, qVar));
    }

    public void onResume() {
        a.sFg.b(this.eQf);
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        a.sFg.c(this.eQf);
    }

    public void onDestroy() {
        x.i("MicroMsg.NewTaskUI", "onDestroy :%d", new Object[]{Integer.valueOf(hashCode())});
        if (equals(uBe)) {
            uBe = null;
        }
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
        }
        if (this.eIX != null) {
            this.eIX.dismiss();
        }
        au.DF().b(701, this);
        super.onDestroy();
    }

    public static NewTaskUI czP() {
        return uBe;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.NewTaskUI", "onSceneEnd :%d  [%d,%d,%s]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
        }
        if (i == 4 && i2 == -3) {
            x.i("MicroMsg.NewTaskUI", "summerauth MM_ERR_PASSWORD need kick out acc ready[%b]", new Object[]{Boolean.valueOf(au.HX())});
            if (w.a(uBe, i, i2, new Intent().setClass(uBe, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                return;
            }
        }
        if (i == 4 && (i2 == -6 || i2 == -311 || i2 == -310)) {
            if (lVar instanceof q) {
                q qVar = (q) lVar;
                this.uBf.eRQ = qVar.getSecCodeType();
                this.uBf.eIZ = qVar.Rf();
                this.uBf.eJa = qVar.Re();
                this.uBf.eJb = qVar.Rg();
                x.i("MicroMsg.NewTaskUI", "onSceneEnd dkwt imgSid:" + this.uBf.eJa + " img len" + this.uBf.eIZ.length + " " + g.Ac());
            }
            if (this.eIX == null) {
                this.eIX = SecurityImage$a.a(this, R.l.regbyqq_secimg_title, this.uBf.eRQ, this.uBf.eIZ, this.uBf.eJa, this.uBf.eJb, new 3(this), new 4(this), new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        NewTaskUI.this.eIX = null;
                    }
                }, this.uBf);
                return;
            }
            x.d("MicroMsg.NewTaskUI", "imgSid:" + this.uBf.eJa + " img len" + this.uBf.eIZ.length + " " + g.Ac());
            this.eIX.a(this.uBf.eRQ, this.uBf.eIZ, this.uBf.eJa, this.uBf.eJb);
            return;
        }
        uBe = null;
        finish();
    }
}
