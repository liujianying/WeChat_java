package com.tencent.mm.plugin.recharge.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.plugin.recharge.model.g;
import com.tencent.mm.plugin.recharge.ui.MallEditText.b;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.aew;
import com.tencent.mm.protocal.c.xi;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RechargeUI extends MMActivity implements e, com.tencent.mm.platformtools.y.a, b {
    private Button eWk = null;
    protected Dialog eXG = null;
    private boolean lSF = false;
    private c lSI = new 10(this);
    private MallFunction mpR = null;
    private String mqA;
    public String mqB;
    private String mqC;
    public String mqD;
    private TextView mqh = null;
    private TextView mqi = null;
    private TextView mqj = null;
    private TextView mqk = null;
    private FrameLayout mql = null;
    private ImageView mqm = null;
    private ImageView mqn = null;
    private LinearLayout mqo = null;
    private a mqp = null;
    private a mqq = null;
    private MallEditText mqr;
    private TextView mqs;
    private int mqt;
    private MallRechargeProduct mqu = null;
    private String mqv = null;
    private MallNews mqw = null;
    private boolean mqx = false;
    private boolean mqy = true;
    private Map<String, Integer> mqz = new HashMap();

    private class a extends BaseAdapter {
        private List<MallRechargeProduct> moJ;

        private a() {
            this.moJ = null;
        }

        /* synthetic */ a(RechargeUI rechargeUI, byte b) {
            this();
        }

        public final void bS(List<MallRechargeProduct> list) {
            this.moJ = list;
            notifyDataSetChanged();
        }

        public final void vi(int i) {
            for (int i2 = 0; i2 < this.moJ.size(); i2++) {
                ((MallRechargeProduct) this.moJ.get(i2)).isDefault = false;
            }
            ((MallRechargeProduct) this.moJ.get(i)).isDefault = true;
        }

        public final int getCount() {
            return this.moJ == null ? 0 : this.moJ.size();
        }

        /* renamed from: vj */
        public final MallRechargeProduct getItem(int i) {
            return (MallRechargeProduct) this.moJ.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final boolean isEnabled(int i) {
            if (getItem(i).isValid()) {
                return super.isEnabled(i);
            }
            return false;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(RechargeUI.this, a$g.recharge_list_dialog_item_singlechoice, null);
            MallRechargeProduct vj = getItem(i);
            checkedTextView.setText(vj.ioy);
            checkedTextView.setEnabled(vj.isValid());
            if (vj.isDefault) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            return checkedTextView;
        }
    }

    static /* synthetic */ boolean c(RechargeUI rechargeUI) {
        if (rechargeUI.mqr.getInputRecord().bJt != 0) {
            return true;
        }
        Context context = rechargeUI;
        h.a(context, rechargeUI.getString(i.mall_recharge_confirm, new Object[]{rechargeUI.mqr.getText().toString()}), "", rechargeUI.getString(i.app_yes), rechargeUI.getString(i.app_no), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                RechargeUI.this.n(new g(RechargeUI.this.mqu, RechargeUI.this.bqf()));
            }
        }, null);
        return false;
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                int color = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.wallet_tenpay_black_color);
                int color2 = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.wechat_green);
                View inflate = getLayoutInflater().inflate(a$g.recharge_list_dialog, null);
                TextView textView = (TextView) inflate.findViewById(a$f.recharge_empty_tips);
                ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(a$f.recharge_fee_list);
                ListViewInScrollView listViewInScrollView2 = (ListViewInScrollView) inflate.findViewById(a$f.recharge_flow_list);
                TextView textView2 = (TextView) inflate.findViewById(a$f.recharge_fee_indicator);
                View findViewById = inflate.findViewById(a$f.recharge_fee_indicator_line);
                TextView textView3 = (TextView) inflate.findViewById(a$f.recharge_flow_indicator);
                View findViewById2 = inflate.findViewById(a$f.recharge_flow_indicator_line);
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(a$f.recharge_product_list_container);
                LayoutParams layoutParams = (LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.height = (getResources().getDimensionPixelSize(d.RechargeProductListItemHeight) * this.mqt) + 4;
                relativeLayout.setLayoutParams(layoutParams);
                listViewInScrollView.setAdapter(this.mqp);
                listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        RechargeUI.this.dismissDialog(1);
                        x.d("MicroMsg.MallRechargeUI", "onItemClick : " + i);
                        x.d("MicroMsg.MallRechargeUI", "checkProduct: " + RechargeUI.this.mqu);
                        RechargeUI.this.mqu = RechargeUI.this.mqp.getItem(i);
                        RechargeUI.this.mqp.vi(i);
                        RechargeUI.this.mqp.notifyDataSetChanged();
                        x.d("MicroMsg.MallRechargeUI", "checkProduct: " + RechargeUI.this.mqu);
                        RechargeUI.this.aL();
                    }
                });
                listViewInScrollView2.setAdapter(this.mqq);
                listViewInScrollView2.setOnItemClickListener(new 6(this));
                inflate.findViewById(a$f.recharge_fee_indicator_area).setOnClickListener(new 7(this, findViewById, textView2, color2, listViewInScrollView, findViewById2, textView3, color, listViewInScrollView2, textView));
                final View view = findViewById2;
                final TextView textView4 = textView3;
                final int i2 = color2;
                final ListViewInScrollView listViewInScrollView3 = listViewInScrollView2;
                final View view2 = findViewById;
                final TextView textView5 = textView2;
                final int i3 = color;
                final ListViewInScrollView listViewInScrollView4 = listViewInScrollView;
                final TextView textView6 = textView;
                inflate.findViewById(a$f.recharge_flow_indicator_area).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        view.setVisibility(0);
                        textView4.setTextColor(i2);
                        listViewInScrollView3.setVisibility(0);
                        view2.setVisibility(8);
                        textView5.setTextColor(i3);
                        listViewInScrollView4.setVisibility(8);
                        if (RechargeUI.this.mqq.getCount() == 0) {
                            textView6.setVisibility(0);
                        } else {
                            textView6.setVisibility(8);
                        }
                    }
                });
                if (this.mqp.getCount() == 0) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
                aVar.abt(null);
                aVar.dR(inflate);
                aVar.e(null);
                return aVar.anj();
            default:
                return h.b(this, getString(i.mall_recharge_pick_contact_error), "", true);
        }
    }

    protected final int getLayoutId() {
        return a$g.recharge_recharge_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.mpR = (MallFunction) intent.getParcelableExtra("key_func_info");
        List parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_product_list");
        this.mqy = !intent.getBooleanExtra("key_is_hide_progress", false);
        if (this.mpR == null) {
            x.e("MicroMsg.MallRechargeUI", "function info is null");
            s.makeText(this, "function info is null", 1).show();
            return;
        }
        if (parcelableArrayListExtra == null) {
            x.d("MicroMsg.MallRechargeUI", "function info : " + this.mpR.cbR);
            n(new com.tencent.mm.plugin.recharge.model.e(this.mpR.moy));
        } else {
            this.mqu = a.bQ(parcelableArrayListExtra);
        }
        x.i("MicroMsg.MallRechargeUI", "onCreate()");
        this.mqw = com.tencent.mm.plugin.wallet_core.model.mall.c.bPK().Pf(this.mpR.moy);
        initView();
    }

    protected final void initView() {
        setMMTitle(this.mpR.cbR);
        x.v("MicroMsg.MallRechargeUI", "initView");
        setBackBtn(new 1(this));
        this.mqh = (TextView) findViewById(a$f.mall_product_desc);
        this.mqi = (TextView) findViewById(a$f.mall_recharge_err_msg);
        this.mqj = (TextView) findViewById(a$f.mall_sell_price);
        this.eWk = (Button) findViewById(a$f.next_btn);
        this.mqo = (LinearLayout) findViewById(a$f.mall_input_ll);
        this.mqk = (TextView) findViewById(a$f.mall_recharge_phone_recharge_card);
        this.mqk.setOnClickListener(new 11(this));
        this.eWk.setOnClickListener(new 12(this));
        this.mqr = (MallEditText) findViewById(a$f.mall_mobile_et);
        this.mqr.setInfoTvOnClickListener(new 13(this));
        this.mqs = (TextView) findViewById(a$f.mall_product_name);
        List parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_product_list");
        List d = d(0, parcelableArrayListExtra);
        List d2 = d(2, parcelableArrayListExtra);
        this.mqt = d.size() > d2.size() ? d.size() : d2.size();
        this.mqp = new a(this, (byte) 0);
        this.mqp.bS(d);
        this.mqq = new a(this, (byte) 0);
        this.mqq.bS(d2);
        this.mqo.setOnClickListener(new 14(this));
        this.mql = (FrameLayout) findViewById(a$f.mall_recharge_banner);
        this.mqm = (ImageView) findViewById(a$f.mall_recharge_banner_iv);
        this.mqn = (ImageView) findViewById(a$f.mall_recharge_banner_close_iv);
        this.mqn.setOnClickListener(new 15(this));
        this.mql.setOnClickListener(new 16(this));
        this.mqr.setOnInputValidChangeListener(this);
        this.mqr.setOnClickListener(new 17(this));
        bqa();
        y.a(this);
        aL();
    }

    private void aL() {
        x.d("MicroMsg.MallRechargeUI", "mCheckedProduct " + this.mqu);
        if (this.mqu != null) {
            CharSequence string;
            this.mqs.setText(this.mqu.ioy);
            TextView textView = this.mqj;
            MallRechargeProduct mallRechargeProduct = this.mqu;
            if (!mallRechargeProduct.isValid()) {
                string = getString(i.mall_recharge_out_of_stock);
            } else if (mallRechargeProduct.moA != mallRechargeProduct.moB || (bqh() && this.mqu.moG)) {
                string = "";
            } else {
                string = String.format(getString(i.mall_recharge_price), new Object[]{Float.valueOf(mallRechargeProduct.moA)});
            }
            textView.setText(string);
        }
        if (this.mqw != null && this.mpR.prU != null && this.mqw.equals(this.mpR.prU) && !"1".equals(this.mqw.psa)) {
            this.mql.setVisibility(8);
            x.d("MicroMsg.MallRechargeUI", "dismiss banner!, news->" + this.mqw.toString());
        } else if (this.mpR.prU == null || bi.oW(this.mpR.prU.psf)) {
            this.mql.setVisibility(8);
            x.d("MicroMsg.MallRechargeUI", "dismiss banner!");
        } else {
            this.mqv = this.mpR.prU.psf;
            this.mqm.setImageBitmap(y.a(new com.tencent.mm.plugin.recharge.b.a(this.mqv)));
            this.mql.setVisibility(0);
            x.d("MicroMsg.MallRechargeUI", "Show banner!");
        }
        this.mqi.setVisibility(4);
        if (!ZB()) {
            this.mqh.setText("");
        } else if (!(this.mqu == null || bqh())) {
            this.mqh.setText(this.mqu.moz);
            this.mqh.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.hint_text_color));
        }
        String string2 = getString(i.mall_recharge_balance);
        if (!TextUtils.isEmpty(this.mqB)) {
            string2 = this.mqB;
        }
        if (!bi.oW(this.mqA)) {
            addTextOptionMenu(0, string2, new 18(this));
        }
        if (bi.oW(this.mqC)) {
            this.mqk.setVisibility(8);
        } else {
            this.mqk.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.mqD)) {
            this.mqk.setText(this.mqD);
        }
    }

    private static List<MallRechargeProduct> d(int i, List<MallRechargeProduct> list) {
        List<MallRechargeProduct> arrayList = new ArrayList();
        if (list != null) {
            boolean z = false;
            for (int i2 = 0; i2 < list.size(); i2++) {
                MallRechargeProduct mallRechargeProduct = (MallRechargeProduct) list.get(i2);
                if (mallRechargeProduct.moF == i) {
                    arrayList.add(mallRechargeProduct);
                    if (mallRechargeProduct.isDefault) {
                        if (z) {
                            mallRechargeProduct.isDefault = false;
                        }
                        z = true;
                    }
                }
            }
            if (!z && arrayList.size() > 0) {
                ((MallRechargeProduct) arrayList.get(0)).isDefault = true;
            }
        }
        return arrayList;
    }

    private void n(l lVar) {
        if (lVar.getType() == 497 || lVar.getType() == 1555) {
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(lVar, 0);
        } else if (this.mqy) {
            if (this.eXG == null || !(this.eXG == null || this.eXG.isShowing())) {
                this.eXG = com.tencent.mm.wallet_core.ui.g.a(this.mController.tml, true, new 3(this, lVar));
            }
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(lVar, 0);
        } else {
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(lVar, 0);
        }
    }

    private boolean ZB() {
        boolean z;
        MallEditText mallEditText = this.mqr;
        if (mallEditText.getVisibility() == 0) {
            if (bi.oW(mallEditText.getText())) {
                x.d("MicroMsg.MallEditText", "View:" + mallEditText.eYG + ", editType:" + mallEditText.eYH + " checkInputValid : empty ");
                z = false;
            } else if (!mallEditText.eYL) {
                x.d("MicroMsg.MallEditText", "View:" + mallEditText.eYG + ", editType:" + mallEditText.eYH + " checkInputValid : illegal ");
                z = false;
            }
            if (z) {
                z = false;
            } else {
                z = true;
            }
            if (z || this.mqu == null || !this.mqu.isValid()) {
                if (!(this.mqx || z || this.mqu == null)) {
                    this.mqu.isValid();
                }
                this.eWk.setEnabled(false);
                this.eWk.setClickable(false);
                x.d("MicroMsg.MallRechargeUI", "checkInfo : false");
                return false;
            }
            if (bqh() && this.mqu.moG) {
                n(new com.tencent.mm.plugin.recharge.model.d(this.mqu.moF, this.mpR.moy, this.mqu.bKk, this.mqu.appId, bqf(), bqg()));
            }
            YC();
            this.eWk.setEnabled(true);
            this.eWk.setClickable(true);
            x.d("MicroMsg.MallRechargeUI", "checkInfo : true");
            return true;
        }
        z = true;
        if (z) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
        }
        this.mqu.isValid();
        this.eWk.setEnabled(false);
        this.eWk.setClickable(false);
        x.d("MicroMsg.MallRechargeUI", "checkInfo : false");
        return false;
    }

    private String bqf() {
        return "mobile=" + com.tencent.mm.plugin.recharge.model.b.pK(this.mqr.getText());
    }

    private String bqg() {
        return com.tencent.mm.plugin.recharge.model.b.pK(this.mqr.getText());
    }

    private static String p(int i, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("-");
        stringBuilder.append(str);
        stringBuilder.append("-");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    private boolean bqh() {
        return !this.mqz.containsKey(p(this.mqu.moF, this.mqu.bKk, bqg()));
    }

    public final void fE(boolean z) {
        if (!z) {
            this.mqz.clear();
            this.mqh.setText("");
            this.mqi.setVisibility(4);
        }
        ZB();
    }

    public final void bqa() {
        if (bi.oW(this.mqr.getText()) || this.mqr.ZF()) {
            this.mqr.setInfoTvImageResource(com.tencent.mm.plugin.wxpay.a.e.recharge_phone_contact);
        } else {
            this.mqr.setInfoTvImageResource(com.tencent.mm.plugin.wxpay.a.e.list_clear);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.MallRechargeUI", "onSceneEnd errType = " + i + ", errCode = " + i2);
        if (!(this.eXG == null || !this.eXG.isShowing() || lVar.getType() == 497)) {
            this.eXG.dismiss();
            this.eXG = null;
        }
        if (i == 0 && i2 == 0) {
            if (lVar instanceof com.tencent.mm.plugin.recharge.model.e) {
                com.tencent.mm.plugin.recharge.model.e eVar = (com.tencent.mm.plugin.recharge.model.e) lVar;
                List list = eVar.moL;
                if (list != null) {
                    this.mqu = a.bQ(list);
                    x.d("MicroMsg.MallRechargeUI", "mCheckedProduct again" + this.mqu);
                }
                this.mqA = eVar.moM;
                this.mqB = eVar.moN;
                this.mqC = eVar.moO;
                this.mqD = eVar.moP;
                x.d("MicroMsg.MallRechargeUI", "mProductList " + list);
                aL();
                List d = d(0, list);
                List d2 = d(2, list);
                this.mqt = d.size() > d2.size() ? d.size() : d2.size();
                this.mqp.bS(d);
                this.mqq.bS(d2);
            } else if (lVar instanceof com.tencent.mm.plugin.recharge.model.d) {
                x.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.mqu);
                com.tencent.mm.plugin.recharge.model.d dVar = (com.tencent.mm.plugin.recharge.model.d) lVar;
                if (!(this.mqu == null || this.mqu.bKk == null || dVar.moI == null || ((!this.mqu.bKk.equals(dVar.moI.bKk) || !bqg().equals(dVar.eNQ)) && dVar.moF == 2))) {
                    MallRechargeProduct.a(dVar.moI, this.mqu);
                    this.mqu.isDefault = true;
                    this.mqz.put(p(dVar.moF, dVar.moI.bKk, dVar.eNQ), Integer.valueOf(1));
                    aL();
                    this.mqi.setText(str);
                    this.mqi.setVisibility(0);
                    this.mqi.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.grey));
                }
                if (dVar.moF == 2) {
                    if (this.mqu == null || !this.mqu.bKk.equals(dVar.moK) || !bqg().equals(dVar.eNQ)) {
                        this.eWk.setEnabled(true);
                        this.eWk.setClickable(true);
                        this.mqi.setText(null);
                    } else if (((aew) dVar.diG.dIE.dIL).rDj == 0 && this.mqu.bKk.equals(dVar.moI.bKk)) {
                        n(new com.tencent.mm.plugin.recharge.model.c(this.mqu.moy, bqg(), this.mqu.ioy, this.mqu.appId, bqf()));
                    } else {
                        this.eWk.setEnabled(false);
                        this.eWk.setClickable(false);
                        this.mqi.setText(((aew) dVar.diG.dIE.dIL).rDk);
                        this.mqi.setVisibility(0);
                        this.mqi.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.red));
                    }
                }
                bR(dVar.moJ);
                x.d("MicroMsg.MallRechargeUI", "NetSceneGetLatestPayProductInfo  mCheckedProduct " + this.mqu);
            } else if (lVar instanceof g) {
                PayInfo payInfo = ((g) lVar).mpb;
                payInfo.bVY = 6;
                payInfo.qUI = 100;
                com.tencent.mm.pluginsdk.wallet.h.a(this, payInfo, 2);
                com.tencent.mm.sdk.b.a.sFg.b(this.lSI);
            } else if (lVar instanceof com.tencent.mm.plugin.recharge.model.c) {
                com.tencent.mm.plugin.recharge.model.c cVar = (com.tencent.mm.plugin.recharge.model.c) lVar;
                if (this.mqu == null || !this.mqu.ioy.equals(cVar.ioy) || !bqg().equals(cVar.bTi)) {
                    this.eWk.setEnabled(true);
                    this.eWk.setClickable(true);
                    this.mqi.setText(null);
                } else if (((xi) cVar.diG.dIE.dIL).rDj != 0) {
                    this.eWk.setEnabled(false);
                    this.eWk.setClickable(false);
                    this.mqi.setText(((xi) cVar.diG.dIE.dIL).rDk);
                    this.mqi.setVisibility(0);
                    this.mqi.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.red));
                }
            }
        } else if (!(lVar instanceof com.tencent.mm.plugin.recharge.model.c)) {
            if (lVar instanceof com.tencent.mm.plugin.recharge.model.d) {
                if (i2 == 100) {
                    this.eWk.setEnabled(true);
                    this.eWk.setClickable(true);
                } else {
                    this.eWk.setEnabled(false);
                    this.eWk.setClickable(false);
                }
                bR(((com.tencent.mm.plugin.recharge.model.d) lVar).moJ);
                this.mqi.setText(str);
                this.mqi.setVisibility(0);
                this.mqi.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.red));
                this.mqh.setText(((com.tencent.mm.plugin.recharge.model.d) lVar).moz);
                this.mqh.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.red));
                return;
            }
            if (bi.oW(str)) {
                str = getString(i.wallet_unknown_err);
            }
            h.a(this, str, null, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(496, this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(497, this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(498, this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(1555, this);
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(496, this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(497, this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(498, this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(1555, this);
    }

    private void bR(List<MallRechargeProduct> list) {
        if (list != null) {
            List arrayList = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                MallRechargeProduct mallRechargeProduct = (MallRechargeProduct) list.get(i2);
                if (mallRechargeProduct.moF == 2) {
                    if (this.mqu != null && mallRechargeProduct.bKk.equals(this.mqu.bKk)) {
                        mallRechargeProduct.isDefault = true;
                        i = true;
                    }
                    arrayList.add(mallRechargeProduct);
                }
            }
            if (i == 0 && arrayList.size() > 0) {
                ((MallRechargeProduct) arrayList.get(0)).isDefault = true;
            }
            this.mqq.bS(arrayList);
            return;
        }
        this.mqq.bS(new ArrayList());
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data != null) {
                        if (com.tencent.mm.pluginsdk.permission.a.bj(this, "android.permission.READ_CONTACTS")) {
                            String str;
                            String str2;
                            Cursor query = getContentResolver().query(data, null, null, null, null);
                            if (query != null && query.getCount() > 0) {
                                query.moveToFirst();
                                int columnIndex = query.getColumnIndex("has_phone_number");
                                if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                    Cursor query2 = getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + query.getString(query.getColumnIndex("_id")), null, null);
                                    if (query2.moveToFirst()) {
                                        str = null;
                                        str2 = null;
                                        while (!query2.isAfterLast()) {
                                            columnIndex = query2.getColumnIndex("data1");
                                            int columnIndex2 = query2.getColumnIndex("display_name");
                                            String string = query2.getString(columnIndex);
                                            String string2 = query2.getString(columnIndex2);
                                            x.d("MicroMsg.MallRechargeUI", "username : " + string2);
                                            if (string != null) {
                                                x.d("MicroMsg.MallRechargeUI", "phoneNumber : " + string);
                                                string = com.tencent.mm.plugin.recharge.model.b.pK(string);
                                                x.d("MicroMsg.MallRechargeUI", "phoneNumber : " + string);
                                                if (!PhoneNumberUtils.isGlobalPhoneNumber(string)) {
                                                    string = str2;
                                                }
                                                x.d("MicroMsg.MallRechargeUI", "phoneResult : " + string);
                                            } else {
                                                string = str2;
                                            }
                                            query2.moveToNext();
                                            str = string2;
                                            str2 = string;
                                        }
                                    } else {
                                        str = null;
                                        str2 = null;
                                    }
                                    if (!query2.isClosed()) {
                                        query2.close();
                                    }
                                    if (!(query == null || query.isClosed())) {
                                        query.close();
                                    }
                                    if (PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                                        this.mqz.clear();
                                        this.mqr.setInput(new com.tencent.mm.plugin.recharge.model.a(str2, str, 1));
                                        this.mqh.setText("");
                                        this.mqi.setVisibility(4);
                                        ZB();
                                        break;
                                    }
                                    showDialog(2);
                                    break;
                                }
                            }
                            str = null;
                            str2 = null;
                            query.close();
                            if (PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                                this.mqz.clear();
                                this.mqr.setInput(new com.tencent.mm.plugin.recharge.model.a(str2, str, 1));
                                this.mqh.setText("");
                                this.mqi.setVisibility(4);
                                ZB();
                                break;
                            }
                            showDialog(2);
                            break;
                            break;
                        }
                        x.e("MicroMsg.MallRechargeUI", "no contact permission");
                        return;
                    }
                    x.e("MicroMsg.MallRechargeUI", "uri == null");
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    if (!this.lSF) {
                        x.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
                        com.tencent.mm.plugin.recharge.a.a.bpV().a(this.mqr.getInputRecord());
                        finish();
                        this.lSF = true;
                        break;
                    }
                }
                x.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onDestroy() {
        com.tencent.mm.sdk.b.a.sFg.c(this.lSI);
        super.onDestroy();
    }

    public final void m(String str, final Bitmap bitmap) {
        if (this.mqv != null && str.equals(this.mqv)) {
            this.mqm.post(new Runnable() {
                public final void run() {
                    RechargeUI.this.mqm.setImageBitmap(bitmap);
                }
            });
        }
    }

    public final void showVKB() {
        x.d("MicroMsg.MallRechargeUI", "showVKB");
        this.mqr.setInfoTvImageResource(com.tencent.mm.plugin.wxpay.a.e.list_clear);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.showSoftInput(currentFocus, 2);
            }
        }
    }

    public final void YC() {
        x.d("MicroMsg.MallRechargeUI", "hideVKB");
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }
}
