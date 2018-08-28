package com.tencent.mm.plugin.order.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem$Skus;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@a(3)
public class MallOrderDetailInfoUI extends WalletBaseUI implements y.a {
    private ListView CU;
    private OnClickListener eZF = new 1(this);
    private String hTI = "";
    private HashMap<String, View> lLj = new HashMap();
    private List<MallOrderDetailObject.a> lNu = new ArrayList();
    protected MallOrderDetailObject lOC = null;
    private CheckedTextView lPA;
    OnClickListener lPB = new OnClickListener() {
        public final void onClick(View view) {
            if (MallOrderDetailInfoUI.this.lPz != null && MallOrderDetailInfoUI.this.lPA != null) {
                if (view.getId() == f.order_action_item_good_tv) {
                    MallOrderDetailInfoUI.this.lPz.setSelected(true);
                    MallOrderDetailInfoUI.this.lPA.setSelected(false);
                    MallOrderDetailInfoUI.this.lPy = 100;
                    return;
                }
                MallOrderDetailInfoUI.this.lPz.setSelected(false);
                MallOrderDetailInfoUI.this.lPA.setSelected(true);
                MallOrderDetailInfoUI.this.lPy = -100;
            }
        }
    };
    String lPn;
    private a lPo;
    private View lPp;
    private View lPq;
    private View lPr;
    private View lPs;
    private View lPt;
    private View lPu;
    private View lPv;
    private boolean lPw = false;
    private boolean lPx = false;
    private int lPy = 0;
    private CheckedTextView lPz;

    static /* synthetic */ void d(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        Context context = mallOrderDetailInfoUI;
        h.a(context, "", new String[]{mallOrderDetailInfoUI.getString(i.mall_order_protect_text)}, "", false, new 5(mallOrderDetailInfoUI));
    }

    protected final int getLayoutId() {
        return g.mall_order_detail_info_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c af = com.tencent.mm.wallet_core.a.af(this);
        if (af != null && (af instanceof com.tencent.mm.plugin.order.a.a)) {
            String string = this.sy.getString("key_trans_id");
            this.hTI = string;
            if (string != null) {
                b.bmn();
                if (!b.bmq().Js(string)) {
                    this.lPw = false;
                    a(new com.tencent.mm.plugin.order.model.h(string), true, true);
                }
            }
            b.bmn();
            if (b.bmq().Js(string)) {
                MallOrderDetailObject mallOrderDetailObject;
                this.lPw = true;
                b.bmn();
                com.tencent.mm.plugin.order.model.c bmq = b.bmq();
                if (TextUtils.isEmpty(string)) {
                    mallOrderDetailObject = null;
                } else {
                    x.v("MicroMsg.MallPayMsgManager", "getMallOrderDetailObjectByMsgId msgId:" + string);
                    mallOrderDetailObject = com.tencent.mm.plugin.order.model.c.a(bmq.Jt(string));
                }
                this.lOC = mallOrderDetailObject;
                if (this.lOC == null) {
                    bmz();
                }
            } else {
                x.w("MicroMsg.MallOrderDetailInfoUI", "mOrders info is Illegal!");
                bmz();
            }
        }
        initView();
    }

    protected final void initView() {
        if (this.lPw) {
            b.bmn();
            j Jt = b.bmq().Jt(this.hTI);
            int intValue = (Jt == null || TextUtils.isEmpty(Jt.lOY) || !com.tencent.mm.plugin.order.c.c.xW(Jt.lOY)) ? -1 : Integer.valueOf(Jt.lOY).intValue();
            if (intValue == 2) {
                setMMTitle(i.mall_order_detail_ui_for_notify_title);
            } else if (intValue == 1) {
                setMMTitle(i.mall_order_detail_ui_for_reminder_title);
            }
        } else {
            setMMTitle(i.mall_order_detail_ui_title);
        }
        this.lPp = findViewById(f.order_latest_status_info_layout);
        this.lPq = findViewById(f.order_latest_status_info_for_msg_layout);
        this.lPu = findViewById(f.order_product_item_text_x4);
        this.lPv = findViewById(f.order_product_item_icon_text_x4);
        this.lPt = findViewById(f.order_product_item_text_x1);
        this.lPr = findViewById(f.order_transaction_info_parent_layout);
        this.lPs = findViewById(f.order_transaction_info_layout);
        this.lPp.setOnClickListener(this.eZF);
        this.lPv.setOnClickListener(this.eZF);
        this.lPu.setOnClickListener(this.eZF);
        this.lPt.setOnClickListener(this.eZF);
        this.lPr.setOnClickListener(this.eZF);
        findViewById(f.order_confirm_result_btn).setOnClickListener(this.eZF);
        findViewById(f.hot_contact_phone_title_tv).setOnClickListener(this.eZF);
        findViewById(f.wx_contact_service_title_tv).setOnClickListener(this.eZF);
        this.CU = (ListView) findViewById(f.order_action_list);
        this.lPo = new a(this, (byte) 0);
        this.CU.setAdapter(this.lPo);
        this.lPo.notifyDataSetChanged();
        this.CU.setOnItemClickListener(new 6(this));
        YI();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (com.tencent.mm.wallet_core.a.af(this) instanceof com.tencent.mm.plugin.order.a.a) {
            com.tencent.mm.wallet_core.a.ac(this);
        }
        return true;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (lVar instanceof com.tencent.mm.plugin.order.model.h) {
            MallOrderDetailObject mallOrderDetailObject = ((com.tencent.mm.plugin.order.model.h) lVar).lOC;
            x.d("MicroMsg.MallOrderDetailInfoUI", "tempObject:" + mallOrderDetailObject);
            if (mallOrderDetailObject != null) {
                this.lOC = mallOrderDetailObject;
                YI();
            }
        }
        return true;
    }

    private void YI() {
        if (this.lOC != null) {
            y.a(this);
            this.lLj.clear();
            MallOrderDetailObject.b bVar = this.lOC.lNs;
            if (bVar != null) {
                CharSequence charSequence;
                String str = bVar.lNA;
                if (TextUtils.isEmpty(bVar.lNB)) {
                    Object charSequence2 = str;
                } else {
                    charSequence2 = str + "：" + bVar.lNB;
                }
                if (this.lPw) {
                    this.lPp.setVisibility(8);
                    this.lPq.setVisibility(0);
                    ((TextView) this.lPq.findViewById(f.order_latest_status_title_tv)).setText(charSequence2);
                    ((TextView) this.lPq.findViewById(f.order_latest_status_subtitle_tv)).setText(e.hb(this.lOC.lNz));
                    if (TextUtils.isEmpty(bVar.thumbUrl) || !e.abY(bVar.thumbUrl)) {
                        c((ImageView) this.lPq.findViewById(f.order_merchant_logo_img));
                    } else {
                        l((ImageView) this.lPq.findViewById(f.order_merchant_logo_img), bVar.thumbUrl);
                    }
                } else {
                    this.lPq.setVisibility(8);
                    this.lPp.setVisibility(0);
                    ((TextView) this.lPp.findViewById(f.order_latest_status_title_tv)).setText(charSequence2);
                    ((TextView) this.lPp.findViewById(f.order_latest_status_subtitle_tv)).setText(e.hb(this.lOC.lNz));
                    if (TextUtils.isEmpty(bVar.thumbUrl) || !e.abY(bVar.thumbUrl)) {
                        c((ImageView) this.lPp.findViewById(f.order_merchant_logo_img));
                    } else {
                        l((ImageView) this.lPp.findViewById(f.order_merchant_logo_img), bVar.thumbUrl);
                    }
                }
            } else {
                this.lPp.setVisibility(8);
                this.lPq.setVisibility(8);
            }
            List list = this.lOC.lNt;
            if (list == null || list.size() == 0) {
                this.lPt.setVisibility(8);
                this.lPu.setVisibility(8);
                this.lPv.setVisibility(8);
            } else if (list.size() == 1) {
                this.lPv.setVisibility(8);
                ProductSectionItem productSectionItem = (ProductSectionItem) list.get(0);
                if (TextUtils.isEmpty(productSectionItem.iconUrl)) {
                    this.lPu.setVisibility(8);
                    this.lPt.setVisibility(0);
                    ((TextView) this.lPt.findViewById(f.item_product_descript_tv)).setText(productSectionItem.name);
                    if (TextUtils.isEmpty(productSectionItem.jumpUrl)) {
                        Rect rect = new Rect();
                        rect.set(this.lPt.findViewById(f.item_product_descript_layout).getPaddingLeft(), this.lPt.findViewById(f.item_product_descript_layout).getPaddingTop(), this.lPt.findViewById(f.item_product_descript_layout).getPaddingRight(), this.lPt.findViewById(f.item_product_descript_layout).getPaddingBottom());
                        this.lPt.findViewById(f.item_product_descript_layout).setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.list_item_normal);
                        this.lPt.findViewById(f.item_product_descript_layout).setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    } else {
                        ((TextView) this.lPt.findViewById(f.item_product_descript_tv)).setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.mall_order_detail_item_title_color));
                    }
                } else {
                    this.lPt.setVisibility(8);
                    this.lPu.setVisibility(0);
                    ((TextView) this.lPu.findViewById(f.item_product_descript_tv)).setText(productSectionItem.name);
                    ((TextView) this.lPu.findViewById(f.item_product_price_tv)).setText(productSectionItem.lPj);
                    ((TextView) this.lPu.findViewById(f.item_product_count_tv)).setText("+" + productSectionItem.count);
                    ((TextView) this.lPu.findViewById(f.item_product_catalog_tv)).setText(ProductSectionItem$Skus.bD(productSectionItem.lPi));
                    if (!TextUtils.isEmpty(productSectionItem.iconUrl)) {
                        l((ImageView) this.lPu.findViewById(f.item_product_logo_img), productSectionItem.iconUrl);
                    }
                }
            } else {
                this.lPt.setVisibility(8);
                this.lPu.setVisibility(8);
                this.lPv.setVisibility(0);
                if (list.size() == 2) {
                    a(this.lPv.findViewById(f.order_product_item_x4_1_layout), (ProductSectionItem) list.get(0));
                    a(this.lPv.findViewById(f.order_product_item_x4_2_layout), (ProductSectionItem) list.get(1));
                    this.lPv.findViewById(f.order_product_item_x4_3_layout).setVisibility(8);
                    this.lPv.findViewById(f.order_product_item_x4_4_layout).setVisibility(8);
                } else if (list.size() == 3) {
                    a(this.lPv.findViewById(f.order_product_item_x4_1_layout), (ProductSectionItem) list.get(0));
                    a(this.lPv.findViewById(f.order_product_item_x4_2_layout), (ProductSectionItem) list.get(1));
                    a(this.lPv.findViewById(f.order_product_item_x4_3_layout), (ProductSectionItem) list.get(2));
                    this.lPv.findViewById(f.order_product_item_x4_4_layout).setVisibility(8);
                } else if (list.size() >= 4) {
                    a(this.lPv.findViewById(f.order_product_item_x4_1_layout), (ProductSectionItem) list.get(0));
                    a(this.lPv.findViewById(f.order_product_item_x4_2_layout), (ProductSectionItem) list.get(1));
                    a(this.lPv.findViewById(f.order_product_item_x4_3_layout), (ProductSectionItem) list.get(2));
                    a(this.lPv.findViewById(f.order_product_item_x4_4_layout), (ProductSectionItem) list.get(3));
                }
            }
            MallTransactionObject mallTransactionObject = this.lOC.lNr;
            if (mallTransactionObject != null) {
                this.lPr.setVisibility(0);
                ((TextView) findViewById(f.order_transaction_subtitle_tv)).setText(e.e(mallTransactionObject.hUL, mallTransactionObject.lNV));
                if (!(this.lOC == null || this.lOC.lNu == null || this.lOC.lNu.size() <= 0)) {
                    a(this.lPs, (MallOrderDetailObject.a) this.lOC.lNu.get(0));
                }
            } else {
                this.lPr.setVisibility(8);
            }
            Collection collection = this.lOC.lNu;
            if (collection != null) {
                this.lNu.addAll(collection);
                this.lPo.notifyDataSetChanged();
            }
            findViewById(f.mall_order_contact_layout).setVisibility(0);
            TextView textView;
            if (this.lOC != null && TextUtils.isEmpty(this.lOC.lNy) && TextUtils.isEmpty(this.lOC.bPg)) {
                findViewById(f.mall_order_contact_layout).setVisibility(8);
            } else if (this.lOC != null && !TextUtils.isEmpty(this.lOC.lNy) && TextUtils.isEmpty(this.lOC.bPg)) {
                findViewById(f.wx_contact_service_title_tv).setVisibility(8);
                findViewById(f.wx_contact_divider_tv).setVisibility(8);
                textView = (TextView) findViewById(f.hot_contact_phone_title_tv);
                textView.setVisibility(0);
                textView.setGravity(3);
            } else if (!(this.lOC == null || !TextUtils.isEmpty(this.lOC.lNy) || TextUtils.isEmpty(this.lOC.bPg))) {
                findViewById(f.hot_contact_phone_title_tv).setVisibility(8);
                findViewById(f.wx_contact_divider_tv).setVisibility(8);
                textView = (TextView) findViewById(f.wx_contact_service_title_tv);
                textView.setVisibility(0);
                textView.setGravity(3);
            }
            if (this.lOC != null && !TextUtils.isEmpty(this.lOC.lNx)) {
                addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.mm_title_btn_menu, new 4(this));
            }
        }
    }

    private void a(View view, ProductSectionItem productSectionItem) {
        if (view != null && productSectionItem != null) {
            view.setVisibility(0);
            TextView textView = (TextView) view.findViewById(f.item_product_descript_tv);
            if (textView != null) {
                textView.setText(productSectionItem.name);
            }
            if (!TextUtils.isEmpty(productSectionItem.iconUrl)) {
                l((ImageView) view.findViewById(f.item_product_logo_img), productSectionItem.iconUrl);
            }
        }
    }

    private void l(ImageView imageView, String str) {
        if (imageView != null && !TextUtils.isEmpty(str) && e.abY(str)) {
            imageView.setImageBitmap(y.a(new com.tencent.mm.plugin.order.c.b(str)));
            this.lLj.put(str, imageView);
        }
    }

    private static void a(View view, MallOrderDetailObject.a aVar) {
        if (aVar != null) {
            Rect rect = new Rect();
            rect.left = view.getPaddingLeft();
            rect.right = view.getPaddingRight();
            rect.top = view.getPaddingTop();
            rect.bottom = view.getPaddingBottom();
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (aVar == null || !aVar.hvi) {
                view.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.list_item_normal);
            } else {
                view.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.mm_trans);
            }
            view.setLayoutParams(layoutParams);
            view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public final void m(String str, Bitmap bitmap) {
        ImageView imageView = (ImageView) this.lLj.get(str);
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    private void c(ImageView imageView) {
        Bitmap decodeResource = com.tencent.mm.compatible.g.a.decodeResource(getResources(), com.tencent.mm.plugin.wxpay.a.h.mall_order_trade_state_icon);
        if (decodeResource != null) {
            imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.c.a(decodeResource, false, 96.0f));
        }
    }

    private void bmy() {
        if (!this.lPx && this.lPy != 0) {
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(new com.tencent.mm.plugin.order.model.f(this.hTI, "", this.lPy), 0);
            this.lPx = true;
        }
    }

    public void finish() {
        bmy();
        super.finish();
    }

    public void onDestroy() {
        bmy();
        super.onDestroy();
    }

    public final void rj(int i) {
        finish();
    }

    private void bmz() {
        h.a(this.mController.tml, i.wallet_order_info_err, 0, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                MallOrderDetailInfoUI.this.finish();
            }
        });
    }
}
