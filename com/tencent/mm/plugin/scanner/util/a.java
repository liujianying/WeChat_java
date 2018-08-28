package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.scanner.a.f;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.util.n.c;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.protocal.c.ik;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public final class a implements e {
    public Bundle bJx;
    public Activity bOb;
    public ProgressDialog eHw;

    final void bsT() {
        au.DF().b(1061, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.BarcodeStringHandler", "onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        bsT();
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (i == 4 && i2 == -4) {
            h.a(this.bOb, R.l.qrcode_no_user_tip, R.l.app_tip, null);
            return;
        }
        Object obj;
        switch (i) {
            case 1:
                if (au.DF().Lh()) {
                    au.DF().getNetworkServerIp();
                    new StringBuilder().append(i2);
                } else if (ab.bU(this.bOb)) {
                    j.eY(this.bOb);
                } else {
                    Toast.makeText(this.bOb, this.bOb.getString(R.l.fmt_http_err, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                }
                obj = 1;
                break;
            case 2:
                Toast.makeText(this.bOb, this.bOb.getString(R.l.fmt_iap_err), 1).show();
                obj = 1;
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            return;
        }
        if (i == 4 && i2 == -2004) {
            h.i(this.bOb, R.l.qrcode_ban_by_expose, R.l.app_tip);
        } else if (i != 0 || i2 != 0) {
            Toast.makeText(this.bOb, this.bOb.getString(R.l.fmt_search_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        } else if (lVar.getType() == 1061) {
            ik bsb = ((f) lVar).bsb();
            if (bsb == null) {
                x.e("MicroMsg.BarcodeStringHandler", "onSceneEnd(), getResp() == null");
                return;
            }
            x.d("MicroMsg.BarcodeStringHandler", "onSceneEnd() ScanBarcode Type = %s", new Object[]{Integer.valueOf(bsb.hcE)});
            if (!bi.oW(bsb.rjl)) {
                int i3 = bsb.hcE;
                Context context = this.bOb;
                String str2 = bsb.rjl;
                int i4 = ((f) lVar).bJr;
                int i5 = ((f) lVar).bJs;
                e eVar = new e();
                Bundle bundle = this.bJx;
                int KP = n.KP(str2);
                x.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", new Object[]{Integer.valueOf(KP)});
                Intent intent;
                if (KP == 1) {
                    c KQ = n.KQ(str2);
                    if (KQ == null || bi.oW(KQ.username)) {
                        x.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
                        obj = 2;
                    } else {
                        au.HU();
                        com.tencent.mm.storage.ab Yg = com.tencent.mm.model.c.FR().Yg(KQ.username);
                        if (Yg == null || ((int) Yg.dhP) <= 0) {
                            eVar.a(context, KQ.username, 2, i4, i5, null, bundle);
                            obj = 1;
                        } else {
                            intent = new Intent();
                            intent.putExtra("Contact_User", Yg.field_username);
                            intent.setFlags(65536);
                            b.ezn.d(intent, context);
                            obj = null;
                        }
                    }
                } else if (KP == 2) {
                    n.b KR = n.KR(str2);
                    if (KR == null || bi.oW(KR.egr)) {
                        x.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
                        obj = 2;
                    } else {
                        x.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[]{KR.egr});
                        if (i3 == 5) {
                            ((com.tencent.mm.plugin.appbrand.n.e) g.l(com.tencent.mm.plugin.appbrand.n.e.class)).b(context, KR.egr, 1031, bundle);
                            obj = null;
                        } else {
                            intent = new Intent();
                            intent.putExtra("rawUrl", KR.egr);
                            intent.setFlags(65536);
                            b.ezn.j(intent, context);
                            obj = null;
                        }
                    }
                } else if (KP == 3 || KP == 4) {
                    x.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", new Object[]{Integer.valueOf(4), Boolean.valueOf(true)});
                    intent = new Intent();
                    intent.setClass(context, ProductUI.class);
                    intent.setFlags(65536);
                    intent.putExtra("key_Product_xml", str2);
                    intent.putExtra("key_Product_funcType", 4);
                    intent.putExtra("key_ProductUI_addToDB", true);
                    intent.putExtra("key_need_add_to_history", true);
                    intent.putExtra("key_is_from_barcode", true);
                    context.startActivity(intent);
                    obj = null;
                } else {
                    x.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
                    x.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[]{str2});
                    obj = 2;
                }
                switch (obj) {
                    case null:
                        x.i("MicroMsg.BarcodeStringHandler", "onSceneEnd PROCESS_XML_RETURN_TYPE_OK");
                        return;
                    case 1:
                        x.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                        return;
                    case 2:
                        x.e("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
