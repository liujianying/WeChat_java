package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.Resp;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.d.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.ky;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a(3)
public class CardAddEntranceUI extends MMActivity {
    private String appId;
    private int cae = 8;
    LinkedList<ky> hBf = new LinkedList();
    private String hBq = "";
    private String hBr;
    private int hBs = 0;

    protected final int getLayoutId() {
        return e.card_add_entrance_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onCreate() intent == null");
            setResult(0);
            finish();
            return;
        }
        x.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI doRediect() handle data");
        String stringExtra = intent.getStringExtra("key_in_card_list");
        this.cae = intent.getIntExtra("key_from_scene", 8);
        this.hBs = intent.getIntExtra("key_stastic_scene", 0);
        x.i("MicroMsg.CardAddEntranceUI", "doRediect() from_scene:" + this.cae + "  from_origin_scene:" + this.hBs);
        this.hBq = intent.getStringExtra("key_package_name");
        String stringExtra2 = intent.getStringExtra("key_sign");
        String stringExtra3 = getIntent().getStringExtra("src_username");
        x.i("MicroMsg.CardAddEntranceUI", "doRediect() src_username:" + stringExtra3);
        String stringExtra4 = getIntent().getStringExtra("js_url");
        this.appId = getIntent().getStringExtra("key_app_id");
        this.hBr = getIntent().getStringExtra("key_transaction");
        String stringExtra5 = getIntent().getStringExtra("key_consumed_card_id");
        x.i("MicroMsg.CardAddEntranceUI", "doRediect() consumedCardId:" + stringExtra5);
        String stringExtra6 = getIntent().getStringExtra("key_template_id");
        List aZ = h.aZ(stringExtra, this.cae);
        if (aZ == null || aZ.size() == 0) {
            x.e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI initView () tempList == null || tempList.size() == 0");
            setResult(0);
            finish();
            return;
        }
        this.hBf.clear();
        this.hBf.addAll(aZ);
        Intent intent2 = new Intent();
        intent2.putExtra("key_from_scene", this.cae);
        intent2.putExtra("key_stastic_scene", this.hBs);
        if (aZ.size() == 1) {
            ky kyVar = (ky) aZ.get(0);
            intent2.putExtra("key_card_id", kyVar.huU);
            intent2.putExtra("key_card_ext", kyVar.cad);
            intent2.putExtra("src_username", stringExtra3);
            intent2.putExtra("js_url", stringExtra4);
            intent2.putExtra("key_consumed_card_id", stringExtra5);
            intent2.putExtra("key_template_id", stringExtra6);
            intent2.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
            intent2.setClass(this, CardDetailUI.class);
            startActivityForResult(intent2, 1);
            return;
        }
        intent2.putExtra("key_in_card_list", stringExtra);
        intent2.putExtra("key_package_name", this.hBq);
        intent2.putExtra("key_sign", stringExtra2);
        intent2.putExtra("src_username", stringExtra3);
        intent2.putExtra("js_url", stringExtra4);
        intent2.putExtra("key_consumed_card_id", stringExtra5);
        intent2.putExtra("key_template_id", stringExtra6);
        intent2.setClass(this, CardAcceptCardListUI.class);
        startActivityForResult(intent2, 2);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.v("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onActivityResult");
        if (i2 == -1) {
            x.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_OK");
        } else {
            x.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_CANCELED");
        }
        LinkedList linkedList = new LinkedList();
        Iterator it = this.hBf.iterator();
        while (it.hasNext()) {
            ky kyVar = (ky) it.next();
            com.tencent.mm.plugin.card.model.e eVar = new com.tencent.mm.plugin.card.model.e();
            eVar.huU = kyVar.huU;
            eVar.cad = kyVar.cad;
            linkedList.add(eVar);
        }
        Intent intent2;
        if (i != 1) {
            if (i == 2) {
                x.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_ACCEPT_CARD_LIST");
                Object obj = "";
                if (intent != null) {
                    obj = intent.getStringExtra("card_list");
                }
                if (this.cae != 7 && this.cae != 16) {
                    if (this.cae != 26) {
                        switch (i2) {
                            case -1:
                                if (!TextUtils.isEmpty(obj)) {
                                    W(-1, obj);
                                    break;
                                } else {
                                    W(-1, h.a(linkedList, true, this.cae));
                                    break;
                                }
                            case 0:
                                if (!TextUtils.isEmpty(obj)) {
                                    W(0, obj);
                                    break;
                                } else {
                                    W(0, h.a(linkedList, false, this.cae));
                                    break;
                                }
                        }
                    }
                    intent2 = new Intent();
                    switch (i2) {
                        case -1:
                            if (intent != null && !TextUtils.isEmpty(obj)) {
                                intent.putExtra("card_list", h.ba(obj, this.cae));
                                setResult(-1, intent);
                                break;
                            }
                            intent2.putExtra("card_list", h.a(linkedList, true, this.cae));
                            setResult(-1, intent2);
                            break;
                        case 0:
                            if (intent != null && !TextUtils.isEmpty(obj)) {
                                intent.putExtra("card_list", h.ba(obj, this.cae));
                                setResult(0, intent);
                                break;
                            }
                            intent2.putExtra("card_list", h.a(linkedList, false, this.cae));
                            intent2.putExtra("result_code", 1);
                            setResult(0, intent2);
                            break;
                    }
                }
                intent2 = new Intent();
                switch (i2) {
                    case -1:
                        if (intent != null && !TextUtils.isEmpty(obj)) {
                            intent.putExtra("card_list", h.ba(obj, this.cae));
                            setResult(-1, intent);
                            break;
                        }
                        intent2.putExtra("card_list", h.a(linkedList, true, this.cae));
                        setResult(-1, intent2);
                        break;
                        break;
                    case 0:
                        if (intent != null && !TextUtils.isEmpty(obj)) {
                            intent.putExtra("card_list", h.ba(obj, this.cae));
                            setResult(0, intent);
                            break;
                        }
                        intent2.putExtra("card_list", h.a(linkedList, false, this.cae));
                        intent2.putExtra("result_code", 1);
                        setResult(0, intent2);
                        break;
                }
            }
        }
        x.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_DETAIL");
        if (this.cae != 7 && this.cae != 16) {
            if (this.cae != 26) {
                switch (i2) {
                    case -1:
                        if (intent != null && linkedList.size() > 0) {
                            ((com.tencent.mm.plugin.card.model.e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                        }
                        W(-1, h.a(linkedList, true, this.cae));
                        break;
                    case 0:
                        W(0, h.a(linkedList, false, this.cae));
                        break;
                }
            }
            intent2 = new Intent();
            switch (i2) {
                case -1:
                    if (intent != null && linkedList.size() > 0) {
                        ((com.tencent.mm.plugin.card.model.e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                    }
                    intent2.putExtra("card_list", h.a(linkedList, true, this.cae));
                    setResult(-1, intent2);
                    break;
                case 0:
                    intent2.putExtra("card_list", h.a(linkedList, false, this.cae));
                    setResult(0, intent2);
                    break;
            }
        }
        intent2 = new Intent();
        switch (i2) {
            case -1:
                if (intent != null && linkedList.size() > 0) {
                    ((com.tencent.mm.plugin.card.model.e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                }
                intent2.putExtra("card_list", h.a(linkedList, true, this.cae));
                setResult(-1, intent2);
                break;
            case 0:
                intent2.putExtra("card_list", h.a(linkedList, false, this.cae));
                setResult(0, intent2);
                break;
        }
        finish();
    }

    private void W(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("_wxapi_add_card_to_wx_card_list", str);
        f bl = g.bl(this.appId, true);
        Resp resp = new Resp(bundle);
        if (bl != null) {
            resp.openId = bl.field_openId;
        }
        resp.transaction = this.hBr;
        String str2 = "MicroMsg.CardAddEntranceUI";
        String str3 = "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s";
        Object[] objArr = new Object[4];
        objArr[0] = this.appId;
        objArr[1] = bl == null ? "null appinfo" : bl.field_appName;
        objArr[2] = bl == null ? "null appinfo" : bl.field_openId;
        objArr[3] = this.hBr;
        x.i(str2, str3, objArr);
        resp.toBundle(bundle);
        x.i("MicroMsg.CardAddEntranceUI", "setResultToSDK result:" + i);
        if (i == -1) {
            resp.errCode = 0;
        } else {
            resp.errCode = -2;
        }
        Args args = new Args();
        args.targetPkgName = this.hBq;
        args.bundle = bundle;
        p.ae(bundle);
        p.af(bundle);
        MMessageActV2.send(ad.getContext(), args);
    }
}
