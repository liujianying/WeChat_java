package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.bk.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.j.a;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.aj;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;

public class CardListSelectedUI extends MMActivity implements e, a {
    private ListView CU;
    private p fUo = null;
    private View gQd;
    private boolean hAd = false;
    private BaseAdapter hAv;
    private String hBq = "";
    private String hBr;
    private TextView hEZ;
    private RelativeLayout hFa;
    private TextView hFb;
    private TextView hFc;
    boolean hFd = false;
    LinkedList<com.tencent.mm.plugin.card.model.a> hFe = new LinkedList();
    HashMap<Integer, Boolean> hFf = new HashMap();
    private boolean hFg;
    private boolean hFh;
    private boolean hFi;
    private int hFj;
    private String hFk;
    private String hFl;
    private String hFm;
    private String hFn;
    private int hFo;
    public String hFp;
    private boolean hFq = false;
    private com.tencent.mm.plugin.card.model.a hFr;
    private int hop = 0;
    private String huU;
    private String hva;
    b hxt = null;
    boolean hxu = true;
    private int time_stamp;

    static /* synthetic */ void d(CardListSelectedUI cardListSelectedUI) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < cardListSelectedUI.hFe.size()) {
                Boolean bool = (Boolean) cardListSelectedUI.hFf.get(Integer.valueOf(i2));
                if (bool != null && bool.booleanValue()) {
                    cardListSelectedUI.enableOptionMenu(true);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.card.a.e.card_list_select_card_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        am.axu().a(this);
        Intent intent = getIntent();
        x.i("MicroMsg.CardListSelectedUI", "initData()");
        if (intent == null) {
            x.e("MicroMsg.CardListSelectedUI", "doGetCardList()  intent == null");
            setResult(1);
            W(1, "");
            finish();
        } else {
            this.hop = intent.getIntExtra("key_from_scene", 0);
            x.i("MicroMsg.CardListSelectedUI", "mFromScene:" + this.hop);
            this.hva = intent.getStringExtra("app_id");
            this.hFj = intent.getIntExtra("shop_id", 0);
            this.hFk = intent.getStringExtra("sign_type");
            this.hFl = intent.getStringExtra("card_sign");
            this.time_stamp = intent.getIntExtra("time_stamp", 0);
            this.hFm = intent.getStringExtra("nonce_str");
            this.huU = intent.getStringExtra("card_tp_id");
            this.hFn = intent.getStringExtra("card_type");
            this.hFo = intent.getIntExtra("can_multi_select", 0);
            this.hBq = intent.getStringExtra("key_package_name");
            this.hBr = intent.getStringExtra("key_transaction");
            x.i("MicroMsg.CardListSelectedUI", "app_id:" + this.hva + " shop_id:" + this.hFj + " sign_type:" + this.hFk + " time_stamp:" + this.time_stamp);
            x.i("MicroMsg.CardListSelectedUI", "nonce_str:" + this.hFm + " card_tp_id:" + this.huU + " card_type:" + this.hFn + " canMultiSelect:" + this.hFo + " packateName:" + this.hBq);
            if ("INVOICE".equalsIgnoreCase(this.hFn)) {
                this.hFq = true;
            }
            if (TextUtils.isEmpty(this.hva) || TextUtils.isEmpty(this.hFl)) {
                x.e("MicroMsg.CardListSelectedUI", "doGetCardList()  app_id is nulls");
                setResult(1);
                W(1, "app_id  or card_sign is empty!");
                finish();
            }
        }
        ayN();
        initView();
    }

    private void ayN() {
        if (this.hAd) {
            x.e("MicroMsg.CardListSelectedUI", "doNetSceneGetShareCardsLayout, isDoingGetData is true");
            return;
        }
        if (this.hxt == null) {
            this.hFg = false;
            this.hFh = false;
            this.hFi = false;
        }
        g.Eh().dpP.a(664, this);
        g.Eh().dpP.a(new aj(this.hva, this.hFj, this.hFk, this.hFl, this.time_stamp, this.hFm, this.huU, this.hFn, this.hxt), 0);
        dO(true);
        this.hAd = true;
        if (this.hFo == 1) {
            this.hFd = true;
        }
    }

    protected final void initView() {
        if (this.hFq) {
            setMMTitle(com.tencent.mm.plugin.card.a.g.card_list_select_card_ui_title_invoice);
        } else {
            setMMTitle(com.tencent.mm.plugin.card.a.g.card_list_select_card_ui_title);
        }
        setBackBtn(new 1(this));
        if (!this.hFq) {
            addTextOptionMenu(0, getString(com.tencent.mm.plugin.card.a.g.app_finish), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (CardListSelectedUI.this.hFd || !CardListSelectedUI.this.hFr.hvg) {
                        CardListSelectedUI.this.ayr();
                    } else {
                        CardListSelectedUI.this.dO(true);
                        am.axu().H(CardListSelectedUI.this.hFr.hvb, l.yc(CardListSelectedUI.this.hFr.userName), 3);
                    }
                    return true;
                }
            });
            enableOptionMenu(false);
        }
        this.CU = (ListView) findViewById(d.card_list);
        if (this.hFq) {
            this.hAv = new b(this);
        } else {
            this.hAv = new a(this);
        }
        this.CU.setAdapter(this.hAv);
        this.CU.setOnItemClickListener(new 3(this));
        this.CU.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !CardListSelectedUI.this.hxu) {
                    x.d("MicroMsg.CardListSelectedUI", "onScroll() >> doGetCardList()");
                    CardListSelectedUI.this.ayN();
                }
            }
        });
        this.gQd = findViewById(d.content_no_data);
        this.hEZ = (TextView) findViewById(d.no_card_tip_text);
        if (this.hFq) {
            this.hEZ.setText(getString(com.tencent.mm.plugin.card.a.g.card_select_list_no_invoice_tips));
        }
        this.hFa = (RelativeLayout) findViewById(d.invoice_bottom);
        this.hFb = (TextView) findViewById(d.invoice_url);
        this.hFc = (TextView) findViewById(d.invoice_sure_btn);
        if (this.hFq) {
            this.hFa.setVisibility(0);
            this.hFb.setOnClickListener(new 5(this));
            this.hFc.setOnClickListener(new 6(this));
            return;
        }
        this.hFa.setVisibility(8);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (lVar instanceof aj) {
            g.Eh().dpP.b(664, this);
            dO(false);
            if (i == 0 && i2 == 0) {
                int size;
                String str2 = ((aj) lVar).hwU;
                x.d("MicroMsg.CardListSelectedUI", str2);
                Collection xk = com.tencent.mm.plugin.card.model.a.xk(str2);
                Collection xl = com.tencent.mm.plugin.card.model.a.xl(str2);
                this.hFp = xK(str2);
                if (this.hxt == null && !(xk == null && xl == null)) {
                    this.hFf.clear();
                    this.hFe.clear();
                }
                if (xk != null) {
                    if (xk.size() > 0 && !this.hFg) {
                        this.hFg = true;
                        if (this.hFq) {
                            ((com.tencent.mm.plugin.card.model.a) xk.get(0)).hoj = getString(com.tencent.mm.plugin.card.a.g.card_share_card_list_my_invoice_title);
                        } else {
                            ((com.tencent.mm.plugin.card.model.a) xk.get(0)).hoj = getString(com.tencent.mm.plugin.card.a.g.card_share_card_list_my_card_title);
                        }
                    }
                    this.hFe.addAll(xk);
                    for (size = this.hFe.size(); size < this.hFe.size(); size++) {
                        this.hFf.put(Integer.valueOf(size), Boolean.valueOf(false));
                    }
                }
                if (xl != null) {
                    if (xl.size() > 0 && !this.hFh) {
                        this.hFh = true;
                        ((com.tencent.mm.plugin.card.model.a) xl.get(0)).hoj = getString(com.tencent.mm.plugin.card.a.g.card_coupon);
                    }
                    this.hFe.addAll(xl);
                    for (size = this.hFe.size(); size < this.hFe.size(); size++) {
                        this.hFf.put(Integer.valueOf(size), Boolean.valueOf(false));
                    }
                }
                this.hxu = ((aj) lVar).hxu;
                this.hxt = ((aj) lVar).hxt;
                this.hAv.notifyDataSetChanged();
            } else {
                com.tencent.mm.plugin.card.d.d.b(this, str, i2);
            }
            if (this.hFe.size() != 0) {
                this.gQd.setVisibility(8);
                this.CU.setVisibility(0);
            } else {
                this.gQd.setVisibility(0);
                this.CU.setVisibility(8);
            }
            this.hAd = false;
        }
    }

    private static String xK(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            return new JSONObject(str).optString("rule_url");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardListSelectedUI", e, "", new Object[0]);
            return str2;
        }
    }

    public final void b(String str, j.b bVar) {
        dO(false);
        if (TextUtils.isEmpty(str) || str.equals(this.hFr.hvb)) {
            x.i("MicroMsg.CardListSelectedUI", "onMarkSuccess()");
            x.i("MicroMsg.CardListSelectedUI", "markSucc:" + bVar.huI + " markCardId: " + bVar.huJ);
            if (bVar.huI == 1) {
                if (TextUtils.isEmpty(bVar.huJ) || str.equals(bVar.huJ)) {
                    x.i("MicroMsg.CardListSelectedUI", "markCardId is same as now id!");
                } else {
                    x.i("MicroMsg.CardListSelectedUI", "markCardId is diff as now id!");
                    int i = 0;
                    while (i < this.hFe.size()) {
                        if (((com.tencent.mm.plugin.card.model.a) this.hFe.get(i)).hvb == bVar.huJ) {
                            for (int i2 = 0; i2 < this.hFe.size(); i2++) {
                                this.hFf.put(Integer.valueOf(i2), Boolean.valueOf(false));
                            }
                            this.hFf.put(Integer.valueOf(i), Boolean.valueOf(true));
                        } else {
                            i++;
                        }
                    }
                }
                ayr();
                return;
            }
            com.tencent.mm.plugin.card.d.d.b(this, getString(com.tencent.mm.plugin.card.a.g.card_mark_used));
            return;
        }
        x.e("MicroMsg.CardListSelectedUI", "onMarkSuccess(), the mark card id is diff from current id!");
    }

    public final void bZ(String str, String str2) {
        dO(false);
        if (TextUtils.isEmpty(str) || str.equals(this.hFr.hvb)) {
            x.i("MicroMsg.CardListSelectedUI", "onMarkFail()");
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(com.tencent.mm.plugin.card.a.g.card_mark_failed_tips);
            }
            com.tencent.mm.plugin.card.d.d.b(this, str2);
            return;
        }
        x.e("MicroMsg.CardListSelectedUI", "onMarkFail(), the mark card id is diff from current id!");
    }

    public final void xh(String str) {
    }

    protected void onDestroy() {
        am.axu().b(this);
        super.onDestroy();
    }

    protected final void dO(boolean z) {
        if (z) {
            this.fUo = p.b(this, getString(com.tencent.mm.plugin.card.a.g.loading_tips), false, 0, null);
        } else if (this.fUo != null && this.fUo.isShowing()) {
            this.fUo.dismiss();
            this.fUo = null;
        }
    }

    private void ayr() {
        Intent intent = new Intent();
        String ayO = ayO();
        if (this.hFq) {
            intent.putExtra("choose_invoice_info", ayO);
        } else {
            intent.putExtra("choose_card_info", ayO);
        }
        setResult(-1, intent);
        W(-1, ayO);
        finish();
    }

    private String ayO() {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.hFe.size(); i2++) {
            Boolean bool = (Boolean) this.hFf.get(Integer.valueOf(i2));
            if (bool != null && bool.booleanValue()) {
                arrayList.add(this.hFe.get(i2));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (i < arrayList.size()) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            com.tencent.mm.plugin.card.model.a aVar = (com.tencent.mm.plugin.card.model.a) arrayList.get(i);
            stringBuilder.append("{");
            stringBuilder.append("\"card_id\":");
            stringBuilder.append("\"" + aVar.huU + "\"");
            stringBuilder.append(",");
            stringBuilder.append("\"encrypt_code\":");
            stringBuilder.append("\"" + aVar.huZ + "\"");
            if (this.hFq) {
                stringBuilder.append(",");
                stringBuilder.append("\"app_id\":");
                stringBuilder.append("\"" + aVar.hva + "\"");
            }
            stringBuilder.append("}");
            i++;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            setResult(0);
            W(0, "");
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void W(int i, String str) {
        if (this.hop != 8) {
            x.e("MicroMsg.CardListSelectedUI", "setResultToSDK need MM_CARD_ITEM_FROM_SCENE_OPENAPI scene, the fromscene is " + this.hop);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_wxapi_choose_card_from_wx_card_list", str);
        f bl = com.tencent.mm.pluginsdk.model.app.g.bl(this.hva, true);
        Resp resp = new Resp(bundle);
        if (bl != null) {
            resp.openId = bl.field_openId;
        }
        resp.transaction = this.hBr;
        String str2 = "MicroMsg.CardListSelectedUI";
        String str3 = "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s";
        Object[] objArr = new Object[4];
        objArr[0] = this.hva;
        objArr[1] = bl == null ? "null appinfo" : bl.field_appName;
        objArr[2] = bl == null ? "null appinfo" : bl.field_openId;
        objArr[3] = this.hBr;
        x.i(str2, str3, objArr);
        resp.toBundle(bundle);
        x.i("MicroMsg.CardListSelectedUI", "setResultToSDK result:" + i);
        x.d("MicroMsg.CardListSelectedUI", "setResultToSDK card_list:" + str);
        if (i == -1) {
            resp.errCode = 0;
        } else {
            resp.errCode = -2;
        }
        Args args = new Args();
        args.targetPkgName = this.hBq;
        args.bundle = bundle;
        com.tencent.mm.pluginsdk.model.app.p.ae(bundle);
        com.tencent.mm.pluginsdk.model.app.p.af(bundle);
        MMessageActV2.send(ad.getContext(), args);
    }
}
