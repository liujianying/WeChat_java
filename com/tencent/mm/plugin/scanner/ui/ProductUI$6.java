package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;

class ProductUI$6 implements d {
    final /* synthetic */ ProductUI mJt;

    ProductUI$6(ProductUI productUI) {
        this.mJt = productUI;
    }

    public final void bx(int i, int i2) {
        if (ProductUI.a(this.mJt) != null) {
            Intent intent;
            switch (i2) {
                case -1:
                    h.a(this.mJt.mController.tml, this.mJt.mController.tml.getString(R.l.app_delete_tips), null, null, this.mJt.mController.tml.getString(R.l.app_delete), new d() {
                        public final void bx(int i, int i2) {
                            switch (i2) {
                                case -1:
                                    cc ccVar = new cc();
                                    ccVar.bJy.bJA = ProductUI$6.this.mJt.getIntent().getLongExtra("key_favorite_local_id", -1);
                                    a.sFg.m(ccVar);
                                    x.d("MicroMsg.scanner.ProductUI", "do del fav product, local id %d, result %B", new Object[]{Long.valueOf(ccVar.bJy.bJA), Boolean.valueOf(ccVar.bJz.bJm)});
                                    if (ccVar.bJz.bJm) {
                                        ProductUI$6.this.mJt.finish();
                                        return;
                                    }
                                    return;
                                default:
                                    x.d("MicroMsg.scanner.ProductUI", "do del cancel");
                                    return;
                            }
                        }
                    });
                    return;
                case 0:
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11446, new Object[]{ProductUI.a(this.mJt).field_productid, Integer.valueOf(2)});
                    if (ProductUI.c(this.mJt) == 3) {
                        com.tencent.mm.plugin.fav.a.h.f(this.mJt.getIntent().getLongExtra("key_favorite_local_id", -1), 1, 0);
                        com.tencent.mm.plugin.report.service.h.mEJ.h(10651, new Object[]{Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0)});
                    }
                    intent = new Intent();
                    intent.putExtra("KContentObjDesc", ProductUI.a(this.mJt).field_subtitle);
                    intent.putExtra("Ksnsupload_title", ProductUI.a(this.mJt).field_title);
                    intent.putExtra("Ksnsupload_link", ProductUI.a(this.mJt).field_shareurl);
                    intent.putExtra("Ksnsupload_appname", n.K(this.mJt, ProductUI.a(this.mJt).field_type));
                    intent.putExtra("Ksnsupload_appid", i.vx(ProductUI.a(this.mJt).field_functionType));
                    intent.putExtra("Ksnsupload_imgurl", ProductUI.a(this.mJt).field_thumburl);
                    x.i("MicroMsg.scanner.ProductUI", "product.field_thumburl : " + ProductUI.a(this.mJt).field_thumburl);
                    if (ProductUI.m(this.mJt) != null) {
                        intent.putExtra("KsnsUpload_imgPath", ProductUI.m(this.mJt).Vv());
                    } else {
                        x.e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
                    }
                    intent.putExtra("Ksnsupload_type", 3);
                    intent.putExtra("KUploadProduct_UserData", n.c(ProductUI.a(this.mJt)));
                    intent.putExtra("KUploadProduct_subType", ProductUI.a(this.mJt).field_type);
                    String ic = u.ic("scan_product");
                    u.Hx().v(ic, true).p("prePublishId", "scan_product");
                    intent.putExtra("reportSessionId", ic);
                    com.tencent.mm.bg.d.b(this.mJt, "sns", ".ui.SnsUploadUI", intent);
                    return;
                case 1:
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11446, new Object[]{ProductUI.a(this.mJt).field_productid, Integer.valueOf(1)});
                    String a = i.a(this.mJt.mController.tml, ProductUI.a(this.mJt));
                    Intent intent2 = new Intent();
                    intent2.putExtra("Retr_Msg_content", a);
                    intent2.putExtra("Retr_Msg_Type", 2);
                    if (ProductUI.m(this.mJt) != null) {
                        intent2.putExtra("Retr_Msg_thumb_path", ProductUI.m(this.mJt).Vv());
                    } else {
                        x.e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
                    }
                    intent2.putExtra("Retr_go_to_chattingUI", false);
                    intent2.putExtra("Retr_show_success_tips", true);
                    b.ezn.l(intent2, this.mJt);
                    if (ProductUI.c(this.mJt) == 3) {
                        com.tencent.mm.plugin.report.service.h.mEJ.h(10651, new Object[]{Integer.valueOf(10), Integer.valueOf(1), Integer.valueOf(0)});
                        return;
                    }
                    return;
                case 2:
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11446, new Object[]{ProductUI.a(this.mJt).field_productid, Integer.valueOf(3)});
                    ProductUI.p(this.mJt);
                    return;
                case 3:
                    intent = new Intent();
                    intent.putExtra("key_fav_scene", 2);
                    intent.putExtra("key_fav_item_id", this.mJt.getIntent().getLongExtra("key_favorite_local_id", -1));
                    com.tencent.mm.plugin.fav.a.b.a(this.mJt.mController.tml, ".ui.FavTagEditUI", intent);
                    return;
                case 4:
                    intent = new Intent();
                    intent.putExtra("rawUrl", ProductUI.a(this.mJt).field_exposeurl);
                    com.tencent.mm.bg.d.b(this.mJt.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                default:
                    return;
            }
        }
    }
}
