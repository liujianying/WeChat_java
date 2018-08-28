package com.tencent.mm.plugin.product.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ab.o;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.plugin.product.b.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.product.ui.d.1;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bfm;
import com.tencent.mm.protocal.c.bnx;
import com.tencent.mm.protocal.c.um;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ListViewInScrollView;
import java.util.ArrayList;
import java.util.List;

public class MallProductSubmitUI extends MallBaseUI implements a {
    private Button eWk;
    private TextView gsY;
    private e lRa;
    private c lSG;
    private RelativeLayout lTF;
    private TextView lTG;
    private TextView lTH;
    private MallProductItemView lTI;
    private MallProductItemView lTJ;
    private TextView lTK;
    private TextView lTL;
    private TextView lTM;
    private TextView lTN;
    private ListView lTO;
    private a lTP;
    private ImageView lTi;
    private TextView lTj;
    private f lTp;

    protected final int getLayoutId() {
        return g.product_submit_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lTp = new f(this.mController.tml, new 1(this));
        com.tencent.mm.plugin.product.a.a.bmF();
        this.lSG = com.tencent.mm.plugin.product.a.a.bmG();
        this.lRa = this.lSG.lRa;
        initView();
        aL();
    }

    public void onStart() {
        this.lTp.onStart();
        super.onStart();
    }

    protected void onStop() {
        this.lTp.onStop();
        super.onStop();
    }

    protected final void initView() {
        setMMTitle(i.mall_product_submit_title);
        this.lTF = (RelativeLayout) findViewById(f.mall_product_submit_address_rl);
        this.lTG = (TextView) findViewById(f.mall_product_submit_address_summary_tv);
        this.lTH = (TextView) findViewById(f.mall_product_submit_address_summary_err_tv);
        this.lTI = (MallProductItemView) findViewById(f.mall_product_submit_express);
        this.lTJ = (MallProductItemView) findViewById(f.mall_product_submit_invoice);
        this.lTi = (ImageView) findViewById(f.mall_product_submit_img_iv);
        this.gsY = (TextView) findViewById(f.mall_product_submit_title_tv);
        this.lTK = (TextView) findViewById(f.mall_product_submit_list_tv);
        this.lTj = (TextView) findViewById(f.mall_product_submit_price_tv);
        this.lTL = (TextView) findViewById(f.mall_product_submit_price_desc_tv);
        this.lTM = (TextView) findViewById(f.mall_product_submit_price_desc_left_tv);
        this.lTN = (TextView) findViewById(f.mall_product_submit_total_price_tv);
        this.lTO = (ListView) findViewById(f.mall_product_submit_preferential_lv);
        this.lTP = new a(this);
        this.lTO.setAdapter(this.lTP);
        this.lTO.setOnItemClickListener(new 2(this));
        this.eWk = (Button) findViewById(f.mall_product_submit_submit);
        this.eWk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                f d = MallProductSubmitUI.this.lTp;
                if (d.lSG.bmU()) {
                    int i;
                    if (d.lSG.bmL() == 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        com.tencent.mm.kernel.g.Ek();
                        o oVar = com.tencent.mm.kernel.g.Eh().dpP;
                        bnx bmW = d.lSG.bmW();
                        d.lSG.getAppId();
                        oVar.a(new k(bmW), 0);
                        return;
                    }
                    com.tencent.mm.kernel.g.Ek();
                    com.tencent.mm.kernel.g.Eh().dpP.a(new l(d.lSG.bmW(), d.lSG.getAppId()), 0);
                }
            }
        });
        this.lTF.setOnClickListener(new 4(this));
        this.lTI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                MallProductSubmitUI.this.showDialog(1);
            }
        });
        this.lTJ.setOnClickListener(new 6(this));
        MallProductItemView mallProductItemView = this.lTJ;
        boolean z = (this.lSG.bmI().lSD & 2) > 0;
        x.d("MicroMsg.MallProductConfig", "hasReceipt, ret = " + z);
        mallProductItemView.setVisibility(z ? 0 : 8);
        if (this.lSG.bmI().bne()) {
            this.lTI.setEnabled(false);
            this.lTI.setClickable(false);
            this.lTI.setSummary(getString(i.mall_product_submit_price_express_free));
        }
    }

    private void aL() {
        m mVar = this.lSG.lQL;
        if (this.lRa != null) {
            this.lTj.setText(b.l(this.lRa.lRe, this.lRa.lRe, mVar.lRp.lNV) + " x " + this.lSG.mCount);
        } else {
            this.lTj.setText(b.l(mVar.lRp.lRB, mVar.lRp.lRC, mVar.lRp.lNV));
        }
        if (!bi.oW(this.lSG.bmJ())) {
            this.lTi.setImageBitmap(y.a(new c(this.lSG.bmJ())));
            y.a(this);
        }
        this.gsY.setText(mVar.lRp.name);
        this.lTK.setText(this.lSG.bmK());
        bfm bmN = this.lSG.bmN();
        if (bmN == null || bi.oW(bmN.jQf)) {
            this.lTJ.setSummary("");
        } else {
            this.lTJ.setSummary(bmN.jQf);
        }
        String str = "";
        if (!this.lSG.bmI().bne()) {
            um umVar = this.lSG.lQQ;
            if (umVar != null) {
                this.lTI.setEnabled(true);
                this.lTI.setClickable(true);
                this.lTI.setSummary(b.a(this, umVar));
                str = getString(i.mall_product_submit_price_express, new Object[]{b.d((double) umVar.rlz, umVar.rxc)});
                this.lTH.setVisibility(8);
            } else {
                this.lTI.setEnabled(false);
                this.lTI.setClickable(false);
                this.lTI.setSummary(getString(i.mall_product_submit_price_express_err));
                this.lTH.setVisibility(0);
            }
        }
        String str2 = "";
        if (this.lSG.bmM() > 0) {
            bi.oW(str);
            str2 = getString(i.mall_product_submit_price_discount, new Object[]{b.d((double) r3, mVar.lRp.lNV)});
        }
        List D = this.lSG.D(this);
        if (D.size() > 0) {
            this.lTO.setVisibility(0);
            this.lTP.bG(D);
            this.lTP.notifyDataSetChanged();
        } else {
            this.lTO.setVisibility(8);
        }
        if (this.lSG.lQR != null) {
            this.lTG.setText(Html.fromHtml(String.format("%s %s<br><br>%s %s %s", new Object[]{r3.hbL, r3.rcz, r3.eJI, r3.eJJ, r3.jQf})));
        }
        if (bi.oW(str + str2)) {
            this.lTM.setVisibility(0);
            this.lTL.setVisibility(8);
        } else {
            this.lTL.setText(getString(i.mall_product_submit_price_desc_more, new Object[]{str}));
            this.lTM.setVisibility(8);
            this.lTL.setVisibility(0);
        }
        this.lTN.setText(b.d((double) this.lSG.bmL(), mVar.lRp.lNV));
        this.eWk.setEnabled(this.lSG.bmU());
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.lTp.onActivityResult(i, i2, intent);
    }

    public final void m(String str, Bitmap bitmap) {
        x.d("MicroMsg.MallProductSubmitUI", str + ", bitmap = " + (bitmap == null));
        if (!bi.oW(this.lSG.bmJ())) {
            this.lTi.post(new 7(this, bitmap));
        }
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                List<um> list = this.lSG.lQY;
                if (list != null) {
                    List arrayList = new ArrayList();
                    for (um a : list) {
                        arrayList.add(b.a(this, a));
                    }
                    String string = getString(i.mall_product_submit_express);
                    8 8 = new 8(this);
                    d.a aVar = new d.a(this);
                    ListViewInScrollView listViewInScrollView = (ListViewInScrollView) View.inflate(this, g.mm_list, null);
                    listViewInScrollView.setOnItemClickListener(new 1(8, aVar));
                    aVar.lSx = arrayList;
                    aVar.lSy = 0;
                    listViewInScrollView.setAdapter(aVar);
                    com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(this);
                    aVar2.abt(string);
                    aVar2.dR(listViewInScrollView);
                    aVar2.e(null);
                    Dialog anj = aVar2.anj();
                    anj.show();
                    return anj;
                }
                break;
        }
        return super.onCreateDialog(i);
    }
}
