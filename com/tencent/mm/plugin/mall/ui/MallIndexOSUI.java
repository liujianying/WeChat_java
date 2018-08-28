package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.k.g;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.ccp;
import com.tencent.mm.protocal.c.ccq;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

public class MallIndexOSUI extends MallIndexBaseUI {
    private boolean fWB = false;
    private View hsd = null;
    private TextView kZA = null;
    private boolean kZB = false;
    private long kZC = 0;
    private boolean kZD = false;
    private boolean kZE = false;
    private String kZF = "";
    private c kZG = new 1(this);
    private c kZH = new 2(this);
    private a[] kZy = new a[4];
    private ac kZz = new ac();
    private long lastUpdateTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hsd = View.inflate(this, a$g.mall_index_foot, null);
        this.hsd.setClickable(false);
        this.hsd.setEnabled(false);
        this.kZA = (TextView) this.hsd.findViewById(a$f.wallet_region_desc);
        this.kZz = o.bPc().zo(this.kYc);
        jr(1577);
        x.i("MicroMsg.MallIndexOSUI", "walletMallIndexOsUI ");
        com.tencent.mm.plugin.mall.a.c cVar = new com.tencent.mm.plugin.mall.a.c();
        if (this.kZz != null) {
            ac acVar = this.kZz;
            boolean z = acVar.pro == null || acVar.pro.rFB == null || acVar.pro.rFB.size() == 0;
            if (!z) {
                a(cVar, false, false);
                return;
            }
        }
        a(cVar, true, false);
    }

    protected final void bbW() {
        e.a(this.kZm, "1", this.kZz.prt, this.kZz.kRf);
    }

    public final void a(MallFunction mallFunction, int i) {
        super.a(mallFunction, i);
        h.mEJ.h(13720, new Object[]{mallFunction.kck, Long.valueOf(bi.WV(mallFunction.moy))});
    }

    protected final void bbO() {
        String str = this.kZz.prr;
        String str2 = this.kZz.prs;
        setMMTitle(str);
        setMMSubTitle(str2);
    }

    protected final void cs(View view) {
        this.kZy[0] = new a(this);
        this.kZy[0].view = view.findViewById(a$f.offline_area);
        this.kZy[0].kYr = (CdnImageView) view.findViewById(a$f.offline_pic);
        this.kZy[0].hND = (TextView) view.findViewById(a$f.offline_wording);
        this.kZy[0].kZO = (TextView) view.findViewById(a$f.extra_wording_first);
        this.kZy[0].kYr.setVisibility(4);
        this.kZy[1] = new a(this);
        this.kZy[1].view = view.findViewById(a$f.balance_area);
        this.kZy[1].kYr = (CdnImageView) view.findViewById(a$f.balance_pic);
        this.kZy[1].hND = (TextView) view.findViewById(a$f.balance_wording);
        this.kZy[1].kZO = (TextView) view.findViewById(a$f.balance_num);
        this.kZy[1].kYr.setVisibility(4);
        this.kZy[2] = new a(this);
        this.kZy[2].view = view.findViewById(a$f.bankcard_area);
        this.kZy[2].kYr = (CdnImageView) view.findViewById(a$f.bankcard_pic);
        this.kZy[2].hND = (TextView) view.findViewById(a$f.bankcard_tv);
        this.kZy[2].kZO = (TextView) view.findViewById(a$f.extra_wording_three);
        this.kZy[2].kYr.setVisibility(4);
        this.kZy[3] = new a(this);
        this.kZy[3].view = view.findViewById(a$f.lqt_area);
        this.kZy[3].kYr = (CdnImageView) view.findViewById(a$f.lqt_pic);
        this.kZy[3].hND = (TextView) view.findViewById(a$f.lqt_wording);
        this.kZy[3].kYr.setVisibility(4);
        this.kZy[3].view.setVisibility(8);
    }

    protected final void bbP() {
    }

    protected final void bbQ() {
    }

    public void onResume() {
        super.onResume();
        x.d("MicroMsg.MallIndexOSUI", "checkUpdate svrTime: %d lastUpdateTime : %d  curTime %d", new Object[]{Integer.valueOf(g.AT().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000), Long.valueOf(this.lastUpdateTime), Long.valueOf(System.currentTimeMillis())});
        if (System.currentTimeMillis() - this.lastUpdateTime >= ((long) (g.AT().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000))) {
            this.lastUpdateTime = System.currentTimeMillis();
            a(new com.tencent.mm.plugin.mall.a.c(), false, false);
        }
        bbO();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        js(1577);
        this.kZG.dead();
        this.kZH.dead();
    }

    protected final boolean bbS() {
        ccp ccp = this.kZz.pro;
        for (int i = 0; i < this.kZy.length; i++) {
            this.kZy[i].view.setVisibility(8);
            this.kZy[i].kYr.setImageBitmap(null);
        }
        int i2 = 0;
        while (i2 < ccp.rFB.size() && i2 < this.kZy.length) {
            ccq ccq = (ccq) ccp.rFB.get(i2);
            this.kZy[i2].view.setVisibility(0);
            this.kZy[i2].kYr.setUrl(ab.a(ccq.syq));
            this.kZy[i2].kYr.setVisibility(0);
            this.kZy[i2].hND.setText(ab.a(ccq.syp));
            x.i("MicroMsg.MallIndexOSUI", "item %d url %s", new Object[]{Integer.valueOf(i2), ab.a(ccq.syq)});
            this.kZy[i2].kZO.setVisibility(8);
            CharSequence a = ab.a(ccq.sys);
            if (!bi.oW(a)) {
                this.kZy[i2].kZO.setText(a);
                this.kZy[i2].kZO.setVisibility(0);
            }
            this.kZy[i2].view.setOnClickListener(new 3(this, ccq));
            i2++;
        }
        if (!(this.kZh == null || this.hsd == null || this.kZB)) {
            this.kZh.addFooterView(this.hsd);
            this.kZB = true;
        }
        if (!bi.oW(this.kZz.pru)) {
            this.kZA.setText(this.kZz.pru);
            this.kZA.setVisibility(0);
        }
        return true;
    }

    protected final void bbX() {
    }

    protected final void bbZ() {
        this.mController.removeAllOptionMenu();
        addIconOptionMenu(0, a.e.mm_title_btn_menu, new 4(this));
    }

    protected final void bca() {
    }

    public void finish() {
        this.fWB = true;
        super.finish();
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        super.d(i, i2, str, lVar);
        if (lVar.getType() == 1577) {
            com.tencent.mm.plugin.mall.a.c cVar = (com.tencent.mm.plugin.mall.a.c) lVar;
            if ((cVar.kYf == null ? 0 : cVar.kYf.syt) == 1 && !bi.oW(cVar.bbI())) {
                if (!this.fWB) {
                    if (System.currentTimeMillis() - this.kZC > 500) {
                        this.kZC = System.currentTimeMillis();
                        this.kZG.cht();
                        this.kZH.cht();
                        Bundle bundle = new Bundle();
                        this.kZF = cVar.bbI();
                        Intent intent = new Intent();
                        x.i("MicroMsg.MallIndexOSUI", "startWebViewUI %s", new Object[]{this.kZF});
                        bundle.putString("KoriginUrl", this.kZF);
                        bundle.putBoolean("KIsHKAgreeUrl", true);
                        intent.putExtra("rawUrl", this.kZF);
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("geta8key_username", q.GF());
                        intent.putExtra("pay_channel", 1);
                        d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 4);
                    }
                }
            }
            this.kZz = o.bPc().zo(this.kYc);
            bbW();
            bbS();
            bbO();
        }
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.MallIndexOSUI", "onActivityResult requestCode %s resultCode %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        super.onActivityResult(i, i2, intent);
    }
}
