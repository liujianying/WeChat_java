package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.pwd.a.d;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Iterator;
import java.util.Vector;

public class WalletDigitalCertUI extends WalletBaseUI {
    private Button eOQ;
    private ImageView gxd;
    private TextView mvO;
    private Button phv;
    private LinearLayout phw;
    private TextView phx;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jr(1654);
        jr(1568);
        jr(1669);
        initView();
        h.mEJ.h(13731, new Object[]{Integer.valueOf(1)});
    }

    public final void initView() {
        setMMTitle(i.wallet_password_setting_digitalcert);
        this.gxd = (ImageView) findViewById(a$f.cert_icon_iv);
        this.mvO = (TextView) findViewById(a$f.cert_tip_state);
        this.phv = (Button) findViewById(a$f.install_cert);
        this.eOQ = (Button) findViewById(a$f.del_cert);
        this.phw = (LinearLayout) findViewById(a$f.installed_list);
        this.phx = (TextView) findViewById(a$f.installed_list_tip);
        this.phv.setOnClickListener(new 1(this));
        this.eOQ.setOnClickListener(new 2(this));
        setBackBtn(new 3(this));
        bOa();
    }

    private void bOa() {
        x.i("MicroMsg.WalletDigitalCertUI", "updateCrtState");
        this.phw.removeAllViews();
        if (s.cDi().cDj()) {
            this.phv.setVisibility(8);
            this.eOQ.setVisibility(0);
            this.mvO.setText(i.wallet_password_setting_digitalcert_succ);
            this.gxd.setImageResource(e.wallet_cert_installed);
        } else {
            this.phv.setVisibility(0);
            this.eOQ.setVisibility(8);
            this.mvO.setText(i.wallet_password_setting_digitalcert_fail);
            this.gxd.setImageResource(e.wallet_cert_uninstall);
        }
        Vector vector = s.cDi().uXD;
        if (vector.size() == 0) {
            this.phw.setVisibility(8);
            this.phx.setVisibility(8);
            return;
        }
        this.phw.setVisibility(0);
        this.phx.setVisibility(0);
        Iterator it = vector.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar.uXx <= 0) {
                View inflate = View.inflate(this, a$g.wallet_cert_adapter_item, null);
                TextView textView = (TextView) inflate.findViewById(a$f.cert_summary);
                TextView textView2 = (TextView) inflate.findViewById(a$f.del_item);
                ((TextView) inflate.findViewById(a$f.cert_title)).setText(rVar.sxq);
                textView.setText(rVar.uXw);
                textView2.setTag(rVar);
                textView2.setOnClickListener(new 4(this));
                this.phw.addView(inflate);
            }
        }
        if (this.phw.getChildCount() == 0) {
            this.phx.setVisibility(8);
        } else {
            this.phx.setVisibility(0);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        js(1654);
        js(1568);
        js(1669);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof d)) {
            if (lVar instanceof f) {
                if (i2 == 0) {
                    h.mEJ.h(13731, new Object[]{Integer.valueOf(11)});
                    s.cDi().abV(((f) lVar).uXa);
                } else {
                    h.mEJ.h(13731, new Object[]{Integer.valueOf(12)});
                }
            }
            return false;
        }
        bOa();
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (1 == i && i2 == -1) {
            String string;
            String string2;
            boolean aNa = ((k) g.l(k.class)).aNa();
            SharedPreferences chZ = ad.chZ();
            if (chZ != null) {
                string = chZ.getString("cpu_id", null);
                string2 = chZ.getString("uid", null);
            } else {
                string2 = null;
                string = null;
            }
            x.i("MicroMsg.WalletDigitalCertUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[]{Boolean.valueOf(aNa)});
            a(new d(aNa, string, string2), false, false);
        }
    }

    protected final int getLayoutId() {
        return a$g.wallet_digital_certui;
    }
}
