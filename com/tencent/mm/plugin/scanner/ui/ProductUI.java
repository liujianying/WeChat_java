package com.tencent.mm.plugin.scanner.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.d;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.q;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.a.k;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.ic;
import com.tencent.mm.protocal.c.ie;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductUI extends MMPreference implements e, a {
    private long bJC;
    private c cXl;
    private com.tencent.mm.modelgeo.a.a cXs = new 1(this);
    private boolean dMp = false;
    private TextView eBO;
    private TextView eHL;
    protected ProgressDialog eHw = null;
    protected f eOE;
    private com.tencent.mm.sdk.b.c fIu = new 5(this);
    private int fdx;
    private String iiv;
    private List<MusicPreference> lyb;
    private ImageView mIT;
    private ImageView mIU;
    private View mIV;
    private TextView mIW;
    private ImageView mIX;
    private View mIY;
    private LinearLayout mIZ;
    private ImageView mJa;
    private n.a mJb;
    private View mJc;
    private int mJd = 0;
    private int mJe;
    private a mJf;
    private boolean mJg = false;
    private HashMap<String, Boolean> mJh;
    private e.a mJi;
    private String mJj;
    private boolean mJk = false;
    private String mJl;
    private boolean mJm = false;
    private boolean mJn = false;
    private boolean mJo = false;
    private com.tencent.mm.plugin.scanner.history.a.a mJp;
    private bv.a mJq = new bv.a() {
        public final void a(d.a aVar) {
            String a = ab.a(aVar.dIN.rcl);
            x.i("MicroMsg.scanner.ProductUI", "lo-scanner-onRecieveMsg");
            n.a a2 = ProductUI.this.mJb;
            if (!(a2 == null || bi.oW(a))) {
                Map z = bl.z(a, "sysmsg");
                a = (String) z.get(".sysmsg.scanproductinfo.product.id");
                if (bi.oW(a2.field_productid) || !a2.field_productid.equals(a)) {
                    x.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: product id not match, productId=" + bi.oV(a) + ", target=" + a2.field_productid);
                } else {
                    List m = com.tencent.mm.plugin.scanner.a.a.m(z, ".sysmsg.scanproductinfo.product");
                    Map hashMap = new HashMap();
                    for (int i = 0; i < m.size(); i++) {
                        List list = ((com.tencent.mm.plugin.scanner.a.a) m.get(i)).egs;
                        if (list != null) {
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                com.tencent.mm.plugin.scanner.a.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a.a) list.get(i2);
                                if (aVar2 != null) {
                                    hashMap.put(aVar2.aAL, aVar2);
                                }
                            }
                        }
                    }
                    x.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: toUpdateSize=" + hashMap.size());
                    k.b(a2.mNX, hashMap);
                }
            }
            ah.A(new 1(this));
        }
    };
    private MusicPreference.a mJr = new 4(this);
    private boolean mJs = true;
    private long mStartTime;

    static /* synthetic */ void b(ProductUI productUI, n.a aVar) {
        if (aVar == null || bi.oW(aVar.field_thumburl)) {
            x.e("MicroMsg.scanner.ProductUI", "product == null || Util.isNullOrNil(product.field_thumburl)");
            return;
        }
        try {
            productUI.mIV.setBackgroundColor(Color.parseColor(aVar.field_headermask));
            if (!bi.oW(aVar.field_headermask) && aVar.field_headermask.length() == 9) {
                productUI.mJc.setBackgroundColor(Color.parseColor("#" + aVar.field_headermask.substring(3, 9)));
            }
        } catch (Exception e) {
            x.w("MicroMsg.scanner.ProductUI", "parse maskColor wrong");
        }
        x.e("MicroMsg.scanner.ProductUI", "begin to get the url " + aVar.field_thumburl);
        Bitmap a = y.a(productUI.mJf);
        if (a != null) {
            productUI.mIT.setImageBitmap(a);
            productUI.mIT.setBackgroundDrawable(null);
            productUI.mIT.setBackgroundColor(-1);
            productUI.mJg = true;
            productUI.bsG();
        } else {
            productUI.mIT.setImageBitmap(null);
        }
        if (!bi.oW(aVar.field_headerbackgroundurl)) {
            a = y.a(new o(aVar.field_headerbackgroundurl));
            if (a != null && !a.isRecycled()) {
                productUI.mIU.setImageBitmap(a);
            }
        }
    }

    static /* synthetic */ void j(ProductUI productUI) {
        if (productUI.mJb == null) {
            return;
        }
        if (!bi.oW(productUI.mJb.field_detailurl)) {
            productUI.aC(10000, productUI.mJb.field_detailurl);
            productUI.KN(productUI.mJb.field_detailurl);
        } else if (!bi.oW(productUI.mJb.field_xml) && productUI.mJk) {
            productUI.aC(10001, "");
            Intent intent = new Intent();
            intent.setClass(productUI, ProductFurtherInfoUI.class);
            intent.putExtra("key_Product_xml", productUI.mJb.field_xml);
            intent.putExtra("key_title", productUI.mJl);
            productUI.startActivity(intent);
        }
    }

    static /* synthetic */ void l(ProductUI productUI) {
        String str = "";
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(productUI.getString(R.l.wv_alert_share_timeline));
        linkedList2.add(Integer.valueOf(0));
        linkedList.add(productUI.getString(R.l.wv_alert_send_to_friend));
        linkedList2.add(Integer.valueOf(1));
        if (!productUI.getIntent().getBooleanExtra("key_is_favorite_item", false)) {
            linkedList.add(productUI.getString(R.l.plugin_favorite_opt));
            linkedList2.add(Integer.valueOf(2));
        } else if (productUI.getIntent().getBooleanExtra("key_can_delete_favorite_item", true)) {
            str = productUI.getString(R.l.app_delete);
            linkedList.add(productUI.getString(R.l.favorite_add_tag_tips));
            linkedList2.add(Integer.valueOf(3));
        } else {
            str = "";
        }
        if (!(productUI.mJb == null || TextUtils.isEmpty(productUI.mJb.field_exposeurl))) {
            linkedList.add(productUI.getString(R.l.contact_info_expose));
            linkedList2.add(Integer.valueOf(4));
        }
        h.a(productUI, "", linkedList, linkedList2, str, false, new 6(productUI));
    }

    static /* synthetic */ void p(ProductUI productUI) {
        if (productUI.mJb == null) {
            x.w("MicroMsg.scanner.ProductUI", "do favorite, but product is null");
            return;
        }
        ch chVar = new ch();
        wl wlVar = new wl();
        wr wrVar = new wr();
        wk wkVar = new wk();
        wrVar.Vw(q.GF());
        wrVar.Vx(q.GF());
        wrVar.CO(8);
        wrVar.fU(bi.VF());
        wrVar.VC(i.vx(productUI.mJb.field_functionType));
        wkVar.Vp(productUI.mJb.field_title);
        wkVar.Vq(productUI.mJb.field_subtitle);
        wkVar.CL(productUI.mJb.field_type);
        wkVar.Vs(n.c(productUI.mJb));
        wkVar.Vr(productUI.mJb.field_thumburl);
        chVar.bJF.title = productUI.mJb.field_title;
        chVar.bJF.desc = productUI.mJb.field_subtitle;
        chVar.bJF.bJH = wlVar;
        chVar.bJF.type = 10;
        wlVar.a(wrVar);
        wlVar.b(wkVar);
        chVar.bJF.bJM = 11;
        chVar.bJF.activity = productUI;
        com.tencent.mm.sdk.b.a.sFg.m(chVar);
    }

    static /* synthetic */ int u(ProductUI productUI) {
        TypedValue typedValue = new TypedValue();
        return productUI.getTheme().resolveAttribute(R.d.actionBarSize, typedValue, true) ? TypedValue.complexToDimensionPixelSize(typedValue.data, productUI.getResources().getDisplayMetrics()) : 0;
    }

    protected final int getLayoutId() {
        return R.i.product_detail;
    }

    public final int Ys() {
        return R.o.prodect_detail_pref;
    }

    public final int auY() {
        return R.i.product_header_view;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mStartTime = bi.VE();
        this.fdx = getIntent().getIntExtra("key_ProductUI_getProductInfoScene", 0);
        y.b(this);
        au.getSysCmdMsgExtension().a("scanproductinfo", this.mJq, true);
        initView();
    }

    protected void onResume() {
        super.onResume();
        au.DF().a(1063, this);
        au.DF().a(1068, this);
    }

    protected void onPause() {
        au.DF().b(1063, this);
        au.DF().b(1068, this);
        super.onPause();
    }

    protected void onDestroy() {
        y.c(this);
        au.getSysCmdMsgExtension().b("scanproductinfo", this.mJq, true);
        com.tencent.mm.sdk.b.a.sFg.c(this.fIu);
        if (this.cXl != null) {
            this.cXl.c(this.cXs);
        }
        aC(10100, (bi.VE() - this.mStartTime));
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.scan_product_detail_title);
        this.eOE = this.tCL;
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(null);
            getSupportActionBar();
        }
        setBackBtn(new 10(this));
        this.eBO = (TextView) findViewById(R.h.product_title);
        this.mIU = (ImageView) findViewById(R.h.product_header_bg);
        this.mIV = findViewById(R.h.product_header_mask);
        this.mIX = (ImageView) findViewById(R.h.product_certification_icon);
        this.mJc = findViewById(R.h.product_actionbar_bg);
        this.mIZ = (LinearLayout) findViewById(R.h.product_header_ll);
        this.mJa = (ImageView) findViewById(R.h.product_header_blur_area);
        this.mIY = findViewById(R.h.product_certification_area);
        j(this.mJc, 0.0f);
        if (com.tencent.mm.bp.a.fi(this.mController.tml)) {
            this.eBO.setTextSize(0, ((float) this.mController.tml.getResources().getDimensionPixelSize(R.f.DialogTitleTextSize)) * 1.25f);
        } else {
            this.eBO.setTextSize(0, (float) com.tencent.mm.bp.a.ad(this.mController.tml, R.f.DialogTitleTextSize));
        }
        this.mIW = (TextView) findViewById(R.h.product_certification);
        this.eHL = (TextView) findViewById(R.h.scan_product_intro);
        this.mJh = new HashMap();
        this.mJi = new 11(this);
        this.mJp = new com.tencent.mm.plugin.scanner.history.a.a();
        this.mJp.field_ScanTime = System.currentTimeMillis();
        this.mJp.field_scene = this.fdx;
        String stringExtra;
        String KL;
        if (this.fdx == 5) {
            this.mJm = true;
            stringExtra = getIntent().getStringExtra("key_Qrcode_Url");
            KL = KL(stringExtra);
            this.mJp.field_qrcodeUrl = stringExtra;
            this.mJp.field_productId = KL;
            n(KL, stringExtra, false);
        } else if (this.fdx == 4) {
            stringExtra = getIntent().getStringExtra("key_product_id");
            KL = getIntent().getStringExtra("key_Qrcode_Url");
            if (bi.oW(stringExtra)) {
                x.e("MicroMsg.scanner.ProductUI", "jsapi jump finish productId null");
                finish();
                return;
            }
            n(stringExtra, KL, false);
        } else {
            this.mJo = getIntent().getBooleanExtra("key_is_from_barcode", false);
            this.mJm = getIntent().getBooleanExtra("key_need_add_to_history", false);
            stringExtra = getIntent().getStringExtra("key_Product_xml");
            if (bi.oW(stringExtra)) {
                stringExtra = getIntent().getStringExtra("key_Product_ID");
                if (bi.oW(stringExtra)) {
                    x.e("MicroMsg.scanner.ProductUI", "normal finish productId null");
                    finish();
                    return;
                }
                n(stringExtra, null, false);
            } else {
                int intExtra = getIntent().getIntExtra("key_Product_funcType", 0);
                this.mJb = i.bY(stringExtra, intExtra);
                if (this.mJb == null) {
                    x.e("MicroMsg.scanner.ProductUI", "initView(), product == null");
                    finish();
                    return;
                }
                this.iiv = this.mJb.field_productid;
                this.mJj = this.mJb.field_extinfo;
                if (!this.mJm || TextUtils.isEmpty(this.iiv)) {
                    x.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.mJm + " mProductId:" + this.iiv);
                } else {
                    this.mJp.field_xmlContent = stringExtra;
                    this.mJp.field_qrcodeUrl = this.mJj;
                    this.mJp.field_productId = this.iiv;
                    this.mJp.field_funcType = intExtra;
                    bsK();
                }
                n.a aVar = this.mJb;
                getIntent().getBooleanExtra("key_ProductUI_addToDB", true);
                a(aVar);
                if (intExtra != 0 || bi.oW(this.mJb.field_productid)) {
                    bsJ();
                } else {
                    n(this.mJb.field_productid, this.mJb.field_extinfo, true);
                }
            }
        }
        findViewById(R.h.product_header_root).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ProductUI.j(ProductUI.this);
            }
        });
        findViewById(R.h.product_detail).setOnClickListener(new 13(this));
        this.mIY.setOnClickListener(new 14(this));
        b bVar = new b(this);
    }

    private void a(n.a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.scanner.ProductUI", "refreshViewByProduct(), pd == null");
            finish();
            return;
        }
        if (!bi.oW(aVar.field_thumburl)) {
            this.mJf = new a(aVar);
        }
        this.mJe = this.mController.tml.getResources().getDimensionPixelSize(R.f.product_ui_header_height);
        if (this.mJb != null && (this.mJb.field_type == 1 || this.mJb.field_type == 2)) {
            this.mJe = this.mController.tml.getResources().getDimensionPixelSize(R.f.product_ui_header_movie_height);
            LayoutParams layoutParams = this.mIU.getLayoutParams();
            layoutParams.height = this.mJe;
            this.mIU.setLayoutParams(layoutParams);
            layoutParams = this.mIV.getLayoutParams();
            layoutParams.height = this.mJe;
            this.mIZ.setLayoutParams(layoutParams);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.h.product_header_bg_mask);
            LayoutParams layoutParams2 = relativeLayout.getLayoutParams();
            layoutParams2.height = this.mJe;
            relativeLayout.setLayoutParams(layoutParams2);
            layoutParams = this.mIZ.getLayoutParams();
            layoutParams.height = this.mJe;
            this.mIZ.setLayoutParams(layoutParams);
        }
        if (bi.oW(aVar.field_introtitle) || bi.oW(aVar.field_introlink)) {
            this.eHL.setVisibility(8);
        } else {
            this.eHL.setText(aVar.field_introtitle);
            this.eHL.setOnClickListener(new 15(this, aVar));
            this.eHL.setVisibility(0);
        }
        this.mJd = this.mJb.field_functionType;
        if (aVar.field_xmlType == 3) {
            this.eBO.setText(aVar.field_title);
            if (bi.oW(aVar.field_certification)) {
                this.mIW.setText(aVar.field_source);
                this.mIX.setVisibility(8);
                this.mIY.setOnClickListener(null);
                this.mIY.setBackgroundDrawable(null);
                this.mIY.setFocusable(false);
            } else {
                this.mIW.setText(aVar.field_certification);
                this.mIX.setVisibility(0);
            }
            if (aVar.field_type == 1 || aVar.field_type == 2) {
                this.mIT = (ImageView) findViewById(R.h.product_header_book_img);
                findViewById(R.h.product_header_book_img).setVisibility(0);
                findViewById(R.h.product_header_product_img).setVisibility(8);
            } else {
                this.mIT = (ImageView) findViewById(R.h.product_header_product_img);
                findViewById(R.h.product_header_product_img).setVisibility(0);
                findViewById(R.h.product_header_book_img).setVisibility(8);
            }
            if (!bi.oW(aVar.field_playurl)) {
                ImageView imageView = (ImageView) findViewById(R.h.product_detail_play_img);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new 16(this, aVar));
            }
            addIconOptionMenu(0, R.g.mm_title_btn_menu, new 2(this));
        } else if (aVar.field_xmlType == 4) {
            this.mIT = (ImageView) findViewById(R.h.product_header_product_img);
            findViewById(R.h.product_header_product_img).setVisibility(0);
            findViewById(R.h.product_header_book_img).setVisibility(8);
            this.mIT.setImageResource(R.k.scan_without_commodity_icon);
            this.mIT.setBackgroundResource(R.k.scan_without_commodity_icon);
            this.eBO.setText(R.l.scan_img_product_not_found);
            this.mIW.setText(null);
        }
        x.v("MicroMsg.scanner.ProductUI", "start postToMainThread initBodyView");
        ah.A(new 3(this, aVar));
    }

    private void bsG() {
        this.bJC = getIntent().getLongExtra("key_ProductUI_chatting_msgId", 0);
        if (this.bJC > 0 && au.HX()) {
            au.HU();
            bd dW = com.tencent.mm.model.c.FT().dW(this.bJC);
            if (dW.field_msgId > 0) {
                dW.eq(this.mJf.Vv());
                au.HU();
                com.tencent.mm.model.c.FT().a(this.bJC, dW);
            }
        }
    }

    private void b(n.a aVar) {
        if (aVar != null && aVar.mNX != null && aVar.mNX.size() != 0 && this.eOE != null) {
            this.eOE.removeAll();
            for (int i = 0; i < aVar.mNX.size(); i++) {
                com.tencent.mm.plugin.scanner.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a) aVar.mNX.get(i);
                if (!(aVar2 == null || aVar2.egs == null || aVar2.egs.size() == 0 || aVar2.mFq == 1 || !aVar2.mFs)) {
                    if (i != 0) {
                        Preference preference = new Preference(this);
                        preference.setLayoutResource(R.i.product_category_divider);
                        this.eOE.a(preference);
                    }
                    if (!bi.oW(aVar2.title) && (aVar2.type == 6 || aVar2.type == 7)) {
                        CategoryWithTitlePreference categoryWithTitlePreference = new CategoryWithTitlePreference(this);
                        categoryWithTitlePreference.setTitle(aVar2.title);
                        this.eOE.a(categoryWithTitlePreference);
                    }
                    int i2;
                    com.tencent.mm.plugin.scanner.a.a.a aVar3;
                    if (aVar2.type == 6) {
                        List arrayList = new ArrayList();
                        for (i2 = 0; i2 < aVar2.egs.size(); i2++) {
                            aVar3 = (com.tencent.mm.plugin.scanner.a.a.a) aVar2.egs.get(i2);
                            if (aVar3.type == 10) {
                                arrayList.add(aVar3);
                            }
                        }
                        if (arrayList.size() > 0) {
                            h hVar = new h(this);
                            hVar.setKey((i * 100));
                            hVar.lSh = arrayList;
                            this.eOE.a(hVar);
                        }
                    } else {
                        i2 = 0;
                        while (i2 < aVar2.egs.size()) {
                            String str = ((i * 100) + i2);
                            aVar3 = (com.tencent.mm.plugin.scanner.a.a.a) aVar2.egs.get(i2);
                            if (aVar3.type == 11) {
                                this.mJk = true;
                                this.mJl = aVar3.name;
                            }
                            if (aVar3.showType != 2) {
                                if (aVar3.showType != 1) {
                                    if (aVar3.type == 5) {
                                        MusicPreference musicPreference = new MusicPreference(this);
                                        musicPreference.setKey(str);
                                        musicPreference.setTitle(aVar3.name);
                                        musicPreference.mFv = aVar3.mFv;
                                        musicPreference.mFw = aVar3.mFw;
                                        musicPreference.mFx = aVar3.mFx;
                                        if (KK(String.format("%s_cd_%s", new Object[]{aVar3.mFv, str}))) {
                                            musicPreference.hv(true);
                                        } else {
                                            musicPreference.hv(false);
                                        }
                                        musicPreference.mIy = this.mJr;
                                        this.eOE.a(musicPreference);
                                        com.tencent.mm.sdk.b.a.sFg.b(this.fIu);
                                        if (this.lyb == null) {
                                            this.lyb = new ArrayList();
                                        }
                                        if (this.mJs) {
                                            this.lyb.add(musicPreference);
                                        }
                                    } else if (aVar3.type == 6) {
                                        e eVar = new e(this);
                                        eVar.setKey(str);
                                        eVar.cZH = aVar3.name;
                                        eVar.setSummary(aVar3.desc);
                                        this.eOE.a(eVar);
                                        eVar.mIn = this.mJi;
                                    } else if (aVar3.type == 12) {
                                        f fVar = new f(this);
                                        fVar.setKey(str);
                                        fVar.ijO = aVar3.thumburl;
                                        fVar.eOE = this.eOE;
                                        this.eOE.a(fVar);
                                    } else if (aVar3.type == 2) {
                                        CharSequence charSequence = KM(aVar3.username) ? aVar3.mFD : aVar3.mFC;
                                        a aVar4 = new a(this);
                                        aVar4.setKey(str);
                                        aVar4.setTitle(charSequence);
                                        aVar4.setSummary(aVar3.desc);
                                        aVar4.mGM = aVar3.dzA;
                                        this.eOE.a(aVar4);
                                    } else if (aVar3.type == 22) {
                                        d dVar = new d(this);
                                        dVar.setKey(str);
                                        if (!bi.oW(aVar3.nickname)) {
                                            dVar.myS = aVar3.nickname + ":";
                                        }
                                        dVar.jNk = aVar3.content;
                                        dVar.mIa = aVar3.thumburl;
                                        this.eOE.a(dVar);
                                    } else {
                                        a aVar5 = new a(this);
                                        aVar5.setKey(str);
                                        aVar5.setTitle(aVar3.name);
                                        aVar5.setSummary(aVar3.desc);
                                        aVar5.mGM = aVar3.dzA;
                                        aVar5.iAb = aVar3.iconUrl;
                                        this.eOE.a(aVar5);
                                    }
                                    if (!(i2 >= aVar2.egs.size() - 1 || aVar3.type == 12 || ((com.tencent.mm.plugin.scanner.a.a.a) aVar2.egs.get(i2 + 1)).type == 12 || ((com.tencent.mm.plugin.scanner.a.a.a) aVar2.egs.get(i2 + 1)).showType == 1 || !a(i2, aVar2.egs))) {
                                        this.eOE.a(new g(this));
                                    }
                                } else if (!bi.oW(aVar3.mFt)) {
                                    b bVar = new b(this);
                                    bVar.setKey(str);
                                    bVar.ijO = aVar3.mFt;
                                    bVar.eOE = this.eOE;
                                    this.eOE.a(bVar);
                                }
                            }
                            i2++;
                        }
                    }
                }
            }
            this.eOE.notifyDataSetChanged();
            x.d("MicroMsg.scanner.ProductUI", "initBodyView finish");
            if (this.lyb != null) {
                this.mJs = false;
            }
        }
    }

    private static boolean a(int i, LinkedList<com.tencent.mm.plugin.scanner.a.a.a> linkedList) {
        if (linkedList != null) {
            int i2 = i + 1;
            while (true) {
                int i3 = i2;
                if (i3 >= linkedList.size()) {
                    break;
                } else if (((com.tencent.mm.plugin.scanner.a.a.a) linkedList.get(i3)).showType != 2) {
                    return true;
                } else {
                    i2 = i3 + 1;
                }
            }
        }
        return false;
    }

    private void bsH() {
        if (this.mJb != null && this.mJb.mNX != null && this.mJb.mNX.size() != 0 && this.eOE != null) {
            for (int i = 0; i < this.mJb.mNX.size(); i++) {
                com.tencent.mm.plugin.scanner.a.a aVar = (com.tencent.mm.plugin.scanner.a.a) this.mJb.mNX.get(i);
                if (!(aVar == null || aVar.egs == null || aVar.egs.size() == 0)) {
                    for (int i2 = 0; i2 < aVar.egs.size(); i2++) {
                        if (((com.tencent.mm.plugin.scanner.a.a.a) aVar.egs.get(i2)).type == 5) {
                            MusicPreference musicPreference = (MusicPreference) this.eOE.ZZ(((i * 100) + i2));
                            if (musicPreference != null) {
                                if (KK(String.format("%s_cd_%s", new Object[]{r1.mFv, r6}))) {
                                    musicPreference.hv(true);
                                } else {
                                    musicPreference.hv(false);
                                }
                            }
                        }
                    }
                }
            }
            this.eOE.notifyDataSetChanged();
        }
    }

    public final boolean a(f fVar, Preference preference) {
        x.i("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick item: [%s]", new Object[]{preference.mKey});
        if (this.mJb == null || this.mJb.mNX == null) {
            x.e("MicroMsg.scanner.ProductUI", "product == null || product.actionlist == null");
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.mKey).intValue();
            int i = intValue / 100;
            int i2 = intValue % 100;
            x.v("MicroMsg.scanner.ProductUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[]{Integer.valueOf(intValue), Integer.valueOf(i), Integer.valueOf(i2)});
            if (i < 0 || i >= this.mJb.mNX.size()) {
                x.w("MicroMsg.scanner.ProductUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mJb.mNX.size())});
                return false;
            }
            com.tencent.mm.plugin.scanner.a.a aVar = (com.tencent.mm.plugin.scanner.a.a) this.mJb.mNX.get(i);
            if (aVar == null) {
                x.w("MicroMsg.scanner.ProductUI", "actionList == null");
                return false;
            } else if (i2 < 0 || i2 >= aVar.egs.size()) {
                x.w("MicroMsg.scanner.ProductUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(aVar.egs.size())});
                return false;
            } else {
                com.tencent.mm.plugin.scanner.a.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a.a) aVar.egs.get(i2);
                if (aVar2 == null) {
                    x.w("MicroMsg.scanner.ProductUI", "action == null");
                    return false;
                }
                x.i("MicroMsg.scanner.ProductUI", "action.type = [%s]", new Object[]{Integer.valueOf(aVar2.type)});
                String str = null;
                Intent intent = new Intent();
                switch (aVar2.type) {
                    case 1:
                    case 3:
                    case 22:
                        str = aVar2.egr;
                        if (!bi.oW(aVar2.egr)) {
                            KN(aVar2.egr);
                            break;
                        }
                        break;
                    case 2:
                    case 4:
                        str = aVar2.username;
                        if (!bi.oW(aVar2.username)) {
                            Object obj = aVar2.username;
                            Intent intent2;
                            if (!KM(obj)) {
                                if (!TextUtils.isEmpty(obj)) {
                                    intent2 = new Intent();
                                    intent2.putExtra("Contact_User", obj);
                                    intent2.putExtra("force_get_contact", true);
                                    intent2.putExtra("Contact_Scene", bsI());
                                    b.ezn.d(intent2, this);
                                    break;
                                }
                                x.v("MicroMsg.scanner.ProductUI", "username is null");
                                break;
                            }
                            intent2 = new Intent();
                            intent2.putExtra("Chat_User", obj);
                            intent2.putExtra("finish_direct", true);
                            intent2.putExtra("add_scene", bsI());
                            b.ezn.e(intent2, this.mController.tml);
                            break;
                        }
                        break;
                    case 5:
                        str = aVar2.mFx;
                        intent.putExtra("rawUrl", aVar2.mFx);
                        intent.putExtra("geta8key_scene", akt());
                        b.ezn.j(intent, this);
                        com.tencent.mm.an.b.PW();
                        bsH();
                        break;
                    case 6:
                    case 7:
                    case 10:
                        break;
                    case 8:
                        str = aVar2.mFz;
                        intent.putExtra("key_card_id", aVar2.mFB);
                        intent.putExtra("key_card_ext", aVar2.mFA);
                        intent.putExtra("key_from_scene", 9);
                        com.tencent.mm.bg.d.b((Context) this, "card", ".ui.CardDetailUI", intent);
                        break;
                    case 9:
                        str = aVar2.mFz;
                        if (!bi.oW(aVar2.mFz)) {
                            intent.putExtra("key_product_id", aVar2.mFz);
                            intent.putExtra("key_product_scene", 12);
                            com.tencent.mm.bg.d.b((Context) this, "product", ".ui.MallProductUI", intent);
                            break;
                        }
                        break;
                    case 11:
                        intent.setClass(this, ProductFurtherInfoUI.class);
                        intent.putExtra("key_Product_xml", this.mJb.field_xml);
                        intent.putExtra("key_title", aVar2.name);
                        startActivity(intent);
                        break;
                    case 12:
                        str = aVar2.egr;
                        if (!bi.oW(aVar2.egr)) {
                            KN(aVar2.egr);
                            break;
                        }
                        break;
                    case 21:
                        str = aVar2.mFr;
                        intent.setClass(this, ProductPurchaseAreaUI.class);
                        intent.putExtra("key_Product_xml", this.mJb.field_xml);
                        intent.putExtra("referkey", aVar2.mFr);
                        intent.putExtra("key_Product_funcType", this.mJd);
                        startActivity(intent);
                        break;
                    default:
                        x.d("MicroMsg.scanner.ProductUI", "Default go url:" + aVar2.egr);
                        if (!bi.oW(aVar2.egr)) {
                            KN(aVar2.egr);
                            break;
                        }
                        break;
                }
                au.DF().a(new com.tencent.mm.plugin.scanner.a.h(this.mJb.field_productid, aVar2.mFy, aVar2.type, str, aVar.egs.size(), aVar2.showType), 0);
                return true;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick, [%s]", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.scanner.ProductUI", e, "", new Object[0]);
            return false;
        }
    }

    private static boolean KK(String str) {
        avq Qa = com.tencent.mm.an.b.Qa();
        if (Qa != null && Qa.rYj == 5 && str.equals(Qa.rsp) && com.tencent.mm.an.b.PY()) {
            return true;
        }
        return false;
    }

    private void aC(int i, String str) {
        if (this.mJb != null) {
            au.DF().a(new com.tencent.mm.plugin.scanner.a.h(this.mJb.field_productid, "", i, str, 0, 0), 0);
        }
    }

    public final void m(String str, Bitmap bitmap) {
        if (!bi.oW(str) && this.mJb != null && bitmap != null && !bitmap.isRecycled()) {
            x.d("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + str);
            ah.A(new 7(this, str, bitmap));
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar == null) {
            x.w("MicroMsg.scanner.ProductUI", "scene == null");
        } else if (lVar.getType() == 1063) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.scanner.a.d dVar = (com.tencent.mm.plugin.scanner.a.d) lVar;
                ie ieVar = (dVar.diG == null || dVar.diG.dIE.dIL == null) ? null : (ie) dVar.diG.dIE.dIL;
                if (ieVar == null) {
                    x.w("MicroMsg.scanner.ProductUI", "onSceneEnd productInfo == null");
                    return;
                } else if (ieVar.rjl != null) {
                    x.d("MicroMsg.scanner.ProductUI", "onSceneEnd  productInfo.DescXML != null");
                    n.a bY = i.bY(ieVar.rjl, this.mJd);
                    if (this.mJb != null && this.mJb.field_xml != null && bY != null && bY.field_xml != null && !this.mJb.field_xml.equals(bY.field_xml)) {
                        this.mJb = bY;
                        a(this.mJb);
                    } else if (!(bY == null || bY.field_xml == null)) {
                        this.mJb = bY;
                        a(this.mJb);
                    }
                    if (this.eHw != null && this.eHw.isShowing()) {
                        this.eHw.dismiss();
                    }
                    bsJ();
                    if (!this.mJm || this.mJn || TextUtils.isEmpty(this.iiv)) {
                        x.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.mJm + " mProductId:" + this.iiv + "  hasAddToHistory:" + this.mJn);
                        return;
                    }
                    this.mJp.field_xmlContent = ieVar.rjl;
                    this.mJp.field_funcType = this.mJd;
                    bsK();
                    return;
                } else {
                    return;
                }
            }
            x.e("MicroMsg.scanner.ProductUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (lVar.getType() == 1068 && i == 0 && i2 == 0) {
            List list = ((ic) ((com.tencent.mm.plugin.scanner.a.c) lVar).diG.dIE.dIL).rjk;
            if (this.mJb != null && k.b(this.mJb.mNX, k.bZ(list))) {
                b(this.mJb);
            }
        }
    }

    private static String KL(String str) {
        String str2 = null;
        if (bi.oW(str)) {
            return str2;
        }
        try {
            return Uri.parse(str).getQueryParameter("p");
        } catch (Exception e) {
            x.w("MicroMsg.scanner.ProductUI", str + ";" + e.getLocalizedMessage());
            return str2;
        }
    }

    private void n(String str, String str2, boolean z) {
        this.iiv = str;
        this.mJj = str2;
        com.tencent.mm.plugin.scanner.a.d dVar = new com.tencent.mm.plugin.scanner.a.d(str, this.fdx, str2);
        au.DF().a(dVar, 0);
        if (!z) {
            ActionBarActivity actionBarActivity = this.mController.tml;
            getString(R.l.app_tip);
            this.eHw = h.b(actionBarActivity, getString(R.l.scan_loading_tip), new 8(this, dVar));
        }
    }

    private static boolean KM(String str) {
        au.HU();
        com.tencent.mm.storage.ab Yg = com.tencent.mm.model.c.FR().Yg(str);
        if (Yg == null || ((int) Yg.dhP) <= 0 || !com.tencent.mm.l.a.gd(Yg.field_type)) {
            return false;
        }
        return true;
    }

    private int akt() {
        if (this.mJd == 4) {
            return 11;
        }
        if (this.mJd == 3) {
            return 12;
        }
        return 0;
    }

    private void KN(String str) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("jsapi_args_appid", i.vx(this.mJd));
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", str);
        intent.putExtra("pay_channel", 3);
        intent.putExtra("geta8key_scene", akt());
        com.tencent.mm.bg.d.b(this.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }

    private int bsI() {
        if (this.mJd == 3) {
            return 47;
        }
        return 49;
    }

    private void bsJ() {
        if (this.mJb != null) {
            x.i("MicroMsg.scanner.ProductUI", "doUpdateActionLogic, flag=:" + this.mJb.field_getaction);
            if ((this.mJb.field_getaction & 2) > 0) {
                this.cXl = c.OB();
                if (this.cXl != null) {
                    this.cXl.b(this.cXs);
                }
            } else if ((this.mJb.field_getaction & 1) > 0) {
                au.DF().a(new com.tencent.mm.plugin.scanner.a.c(this.iiv, k.bY(this.mJb.mNX), this.fdx, this.mJj, 0.0d, 0.0d), 0);
            }
        }
    }

    private static void j(View view, float f) {
        Animation alphaAnimation = new AlphaAnimation(f, f);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    private void bsK() {
        if (com.tencent.mm.plugin.scanner.util.i.btj()) {
            boolean c;
            com.tencent.mm.plugin.scanner.history.a.a aVar = new com.tencent.mm.plugin.scanner.history.a.a();
            aVar.field_productId = this.iiv;
            if (com.tencent.mm.plugin.scanner.c.brZ().b(aVar, new String[0])) {
                c = com.tencent.mm.plugin.scanner.c.brZ().c(this.mJp, new String[0]);
            } else {
                c = com.tencent.mm.plugin.scanner.c.brZ().b(this.mJp);
            }
            if (c) {
                x.i("MicroMsg.scanner.ProductUI", "mHistoryItem insert success!");
                this.mJn = true;
                return;
            }
            x.e("MicroMsg.scanner.ProductUI", "mHistoryItem insert fail!");
            return;
        }
        x.e("MicroMsg.scanner.ProductUI", "mHistoryItem ScanHistoryUtil.shouldShowHistoryList() is false!");
    }
}
