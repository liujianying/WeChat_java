package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.a.a.a;
import com.tencent.mm.plugin.scanner.a.h;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class ProductPurchaseAreaUI extends MMPreference {
    protected f gua;
    private String iiv;
    private List<a> mIP;
    private int mIQ;

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        initView();
        n.a bY = i.bY(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
        if (bY == null || bY.mNX == null) {
            x.w("MicroMsg.ProductPurchaseAreaUI", "Data product null");
            return;
        }
        this.iiv = bY.field_productid;
        this.mIQ = bY.field_functionType;
        String stringExtra = getIntent().getStringExtra("referkey");
        x.i("MicroMsg.ProductPurchaseAreaUI", "referkey:" + stringExtra);
        if (!bi.oW(stringExtra)) {
            while (true) {
                int i2 = i;
                if (i2 >= bY.mNX.size()) {
                    return;
                }
                if (stringExtra.equals(((com.tencent.mm.plugin.scanner.a.a) bY.mNX.get(i2)).mFr)) {
                    this.mIP = ((com.tencent.mm.plugin.scanner.a.a) bY.mNX.get(i2)).egs;
                    setMMTitle(((com.tencent.mm.plugin.scanner.a.a) bY.mNX.get(i2)).title);
                    bsF();
                    return;
                }
                i = i2 + 1;
            }
        }
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        this.gua = this.tCL;
    }

    private void bsF() {
        if (this.mIP != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mIP.size()) {
                    a aVar = (a) this.mIP.get(i2);
                    String valueOf = String.valueOf(i2);
                    if (aVar != null) {
                        a aVar2 = new a(this);
                        aVar2.setKey(valueOf);
                        aVar2.setTitle(aVar.name);
                        aVar2.setSummary(aVar.desc);
                        aVar2.mGM = aVar.dzA;
                        this.gua.a(aVar2);
                        if (i2 != this.mIP.size() - 1) {
                            this.gua.a(new g(this.mController.tml));
                        }
                    }
                    i = i2 + 1;
                } else {
                    this.gua.notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        if (this.mIP == null) {
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.mKey).intValue();
            if (intValue < 0 || intValue >= this.mIP.size()) {
                return false;
            }
            a aVar = (a) this.mIP.get(intValue);
            if (aVar == null) {
                return false;
            }
            String str = null;
            switch (aVar.type) {
                case 1:
                    str = aVar.egr;
                    if (!bi.oW(aVar.egr)) {
                        j(this.mController.tml, aVar.egr, this.mIQ);
                        break;
                    }
                    x.w("MicroMsg.ProductPurchaseAreaUI", "action link empty");
                    break;
                case 9:
                    str = aVar.mFz;
                    if (!bi.oW(aVar.mFz)) {
                        Intent intent = new Intent();
                        intent.putExtra("key_product_id", aVar.mFz);
                        intent.putExtra("key_product_scene", 12);
                        d.b(this, "product", ".ui.MallProductUI", intent);
                        break;
                    }
                    break;
                default:
                    x.i("MicroMsg.ProductPurchaseAreaUI", "Default go url:" + aVar.egr);
                    if (!bi.oW(aVar.egr)) {
                        j(this.mController.tml, aVar.egr, this.mIQ);
                        break;
                    }
                    break;
            }
            au.DF().a(new h(this.iiv, aVar.mFy, aVar.type, str, this.mIP.size(), aVar.showType), 0);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.ProductPurchaseAreaUI", "onPreferenceTreeClick, [%s]", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.ProductPurchaseAreaUI", e, "", new Object[0]);
            return false;
        }
    }

    private static void j(Context context, String str, int i) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("jsapi_args_appid", i.vx(i));
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", str);
        intent.putExtra("pay_channel", 3);
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
    }

    public final int Ys() {
        return R.o.product_purchase_area;
    }
}
