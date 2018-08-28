package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.a.o;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.af;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.an;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.c;

public class StartUnbindQQ extends MMWizardActivity implements e {
    private String eGa = null;
    private View eJh;
    private c eJi;
    private p tipDialog;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.DF().a(253, this);
        this.eGa = getIntent().getStringExtra("notice");
    }

    public void onDestroy() {
        g.DF().b(253, this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        initView();
    }

    protected final int getLayoutId() {
        return a.g.start_unbindqq;
    }

    protected final void initView() {
        setMMTitle(j.unbind_qq);
        this.eJh = findViewById(f.setting_start_unbind_qq);
        setBackBtn(new 1(this));
        this.eJh.setOnClickListener(new 2(this));
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.StartUnbindQQ", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + lVar.getType());
        if (lVar.getType() == 253) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i == 0 && i2 == 0) {
                int a = bi.a((Integer) g.Ei().DT().get(9, null), 0);
                x.d("MicroMsg.StartUnbindQQ", "iBindUin " + a);
                if (a != 0) {
                    ((i) g.l(i.class)).FZ().delete(new o(a) + "@qqim");
                }
                Object obj = g.Ei().DT().get(102407, null);
                if (obj != null && ((String) obj).length() > 0) {
                    g.Ei().DT().set(102407, null);
                }
                try {
                    com.tencent.mm.sdk.b.a.sFg.m(new af());
                    String str2 = new o(bi.a((Integer) g.Ei().DT().get(9, null), 0)) + "@qqim";
                    ((i) g.l(i.class)).FZ().delete(str2);
                    ((i) g.l(i.class)).FR().Ym(str2);
                    q.KH().kd(str2);
                    String str3 = com.tencent.mm.model.q.GF() + "@qqim";
                    q.KH().kd(str3);
                    q.Kp();
                    com.tencent.mm.aa.f.B(str2, false);
                    q.Kp();
                    com.tencent.mm.aa.f.B(str2, true);
                    q.Kp();
                    com.tencent.mm.aa.f.B(str3, false);
                    q.Kp();
                    com.tencent.mm.aa.f.B(str3, true);
                    an anVar = (an) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
                    x.d("MicroMsg.QQGroupStorage", "delete all");
                    if (anVar.dCZ.delete("qqgroup", null, null) > 0) {
                        anVar.doNotify();
                    }
                    com.tencent.mm.plugin.account.a.a.ezo.vl();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.StartUnbindQQ", e, "", new Object[0]);
                    x.printErrStackTrace("MicroMsg.StartUnbindQQ", e, "", new Object[0]);
                }
                g.Ei().DT().set(9, Integer.valueOf(0));
                sf sfVar = new sf();
                sfVar.ccY.ccZ = false;
                sfVar.ccY.cda = true;
                com.tencent.mm.sdk.b.a.sFg.m(sfVar);
                if (bi.oW(this.eGa)) {
                    DT(1);
                } else {
                    h.a(this, this.eGa, "", getString(j.app_i_known), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            StartUnbindQQ.this.DT(1);
                        }
                    });
                }
            }
            com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
            if (eV != null) {
                eV.a(this, null, null);
            }
        }
    }
}
