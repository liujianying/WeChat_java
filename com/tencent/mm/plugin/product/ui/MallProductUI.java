package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.product.b.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.product.ui.f.1;
import com.tencent.mm.plugin.product.ui.f.2;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import java.util.List;

@a(3)
public class MallProductUI extends MallBaseUI implements y.a {
    private Button eWk;
    private TextView hVS;
    protected c lSG;
    private HtmlTextView lSm;
    private ListView lTO;
    private a lTP;
    private LinearLayout lTR;
    private LinearLayout lTS;
    private ImageView lTT;
    private TextView lTU;
    private HtmlTextView lTV;
    private RelativeLayout lTW;
    private ListView lTX;
    private k lTY = null;
    private Button lTZ;
    private TextView lTj;
    private f lTp;

    static /* synthetic */ void d(MallProductUI mallProductUI) {
        List list = mallProductUI.lSG.lQM;
        if (list != null && list.size() > 0) {
            mallProductUI.lTY.lTz = list;
        }
    }

    protected final int getLayoutId() {
        return g.product_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ux(8);
        boolean booleanExtra = getIntent().getBooleanExtra("key_go_finish", false);
        setResult(-1);
        if (booleanExtra) {
            finish();
            return;
        }
        initView();
        com.tencent.mm.plugin.product.a.a.bmF();
        this.lSG = com.tencent.mm.plugin.product.a.a.bmG();
        this.lTp = new f(this.mController.tml, new 1(this));
        f fVar = this.lTp;
        com.tencent.mm.kernel.g.Em().a(new 1(fVar, getIntent(), new m()));
        fVar.lSE = true;
        mi miVar = new mi();
        miVar.bXb.errCode = -1;
        miVar.bJX = new 2(fVar, miVar);
        com.tencent.mm.sdk.b.a.sFg.a(miVar, Looper.getMainLooper());
    }

    protected void onResume() {
        super.onResume();
        this.lTp.onStart();
    }

    protected void onPause() {
        this.lTp.onStop();
        super.onPause();
    }

    protected final void initView() {
        setMMTitle(i.mall_product_title);
        setBackBtn(new 2(this));
        this.lTR = (LinearLayout) findViewById(f.mall_product_normal_ll);
        this.lTS = (LinearLayout) findViewById(f.mall_product_sold_out_ll);
        this.lTT = (ImageView) findViewById(f.mall_product_img);
        this.hVS = (TextView) findViewById(f.mall_product_desc);
        this.lTj = (TextView) findViewById(f.mall_product_price);
        this.lTU = (TextView) findViewById(f.mall_product_org_price);
        this.lTU.getPaint().setFlags(16);
        this.lTW = (RelativeLayout) findViewById(f.mall_product_detail_rl);
        this.lSm = (HtmlTextView) findViewById(f.mall_product_detail);
        this.lTV = (HtmlTextView) findViewById(f.mall_product_oss_info);
        this.lTO = (ListView) findViewById(f.mall_product_actions_lv);
        this.lTP = new a(this);
        this.lTO.setAdapter(this.lTP);
        this.lTO.setOnItemClickListener(new 3(this));
        this.lTZ = (Button) findViewById(f.mall_product_seller_btn);
        this.lTZ.setOnClickListener(new 4(this));
        this.lTX = (ListView) findViewById(f.mall_product_sold_out_lv);
        this.lTY = new k(this);
        this.lTY.lTs = new 5(this);
        this.lTX.setAdapter(this.lTY);
        this.eWk = (Button) findViewById(f.mall_product_go_sku_list);
        this.eWk.setOnClickListener(new 6(this));
        addIconOptionMenu(0, e.mm_title_btn_menu, new 7(this));
        showOptionMenu(false);
        this.lTT.setFocusable(true);
        this.lTT.setFocusableInTouchMode(true);
        this.lTT.requestFocus();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        x.v("MicroMsg.MallProductUI", "onNewIntent");
        setIntent(intent);
    }

    protected final void aL() {
        m mVar = this.lSG.lQL;
        if (mVar == null) {
            showOptionMenu(false);
            return;
        }
        showOptionMenu(true);
        ux(0);
        this.lTR.setVisibility(0);
        this.lTS.setVisibility(8);
        if (mVar.lRp != null) {
            this.hVS.setText(mVar.lRp.name);
            this.lTj.setText(b.l(mVar.lRp.lRB, mVar.lRp.lRC, mVar.lRp.lNV));
            this.lTU.setText(b.d((double) mVar.lRp.lRA, mVar.lRp.lNV));
        }
        if (this.lSG.bmR() <= 0) {
            this.eWk.setEnabled(false);
            this.eWk.setText(i.mall_product_sold_out);
        } else if (this.lSG.lQL.lRo <= 0) {
            this.eWk.setEnabled(false);
            this.eWk.setText(i.mall_product_sold_limit);
        } else {
            this.eWk.setEnabled(true);
            if (bi.oW(mVar.lRu)) {
                this.eWk.setText(i.mall_product_go_sku_list);
            } else {
                this.eWk.setText(mVar.lRu);
            }
        }
        if (mVar.lRp == null || mVar.lRp.lRK == null || mVar.lRp.lRK.size() <= 0) {
            this.lTO.setVisibility(8);
        } else {
            this.lTO.setVisibility(0);
            this.lTP.bG(mVar.lRp.lRK);
            this.lTP.notifyDataSetChanged();
        }
        if (mVar.lRp == null || bi.oW(mVar.lRp.detail)) {
            this.lTW.setVisibility(8);
            this.lSm.setVisibility(8);
        } else {
            this.lTW.setVisibility(0);
            this.lSm.setVisibility(0);
            this.lSm.setText(mVar.lRp.detail);
        }
        if (bi.oW(mVar.lRv)) {
            this.lTV.setVisibility(8);
        } else {
            this.lTV.setVisibility(0);
            this.lTV.setText(mVar.lRv);
        }
        showOptionMenu(true);
        if (!bi.oW(this.lSG.lQT)) {
            this.lTT.setImageBitmap(y.a(new c(this.lSG.lQT)));
            y.a((y.a) this);
        }
    }

    public final void m(String str, Bitmap bitmap) {
        if (str != null && str.equals(this.lSG.lQT)) {
            this.lTT.post(new 8(this, bitmap));
        }
    }
}
