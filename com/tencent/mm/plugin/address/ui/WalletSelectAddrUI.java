package com.tencent.mm.plugin.address.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ab.l;
import com.tencent.mm.ar.k;
import com.tencent.mm.g.a.ju;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.address.c.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.plugin.address.e.d;
import com.tencent.mm.plugin.address.model.e;
import com.tencent.mm.plugin.address.model.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import java.util.LinkedList;
import java.util.List;

public class WalletSelectAddrUI extends MMActivity implements a {
    private boolean eYw = false;
    private List<b> eZV = new LinkedList();
    private b eZW;
    private a eZX;
    private com.tencent.mm.plugin.address.c.b eZY = null;
    private View eZZ;
    private ListView eZb;
    private TextView faa = null;
    private o fab;
    private boolean fac = false;
    private c fad = null;
    private Object lockObj = new Object();

    static /* synthetic */ void b(WalletSelectAddrUI walletSelectAddrUI) {
        au.HU();
        String oV = bi.oV((String) com.tencent.mm.model.c.DT().get(46, null));
        au.HU();
        String oV2 = bi.oV((String) com.tencent.mm.model.c.DT().get(72, null));
        if (bi.oW(oV) && bi.oW(oV2)) {
            walletSelectAddrUI.ZM();
        } else {
            walletSelectAddrUI.aP(oV, oV2);
        }
    }

    static /* synthetic */ void b(WalletSelectAddrUI walletSelectAddrUI, b bVar) {
        if (bVar != null) {
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(bVar.eYd)) {
                stringBuilder.append(walletSelectAddrUI.getString(R.l.address_name));
                stringBuilder.append("：");
                stringBuilder.append(bVar.eYd);
                stringBuilder.append(" \n");
            }
            if (!TextUtils.isEmpty(bVar.eYe)) {
                stringBuilder.append(walletSelectAddrUI.getString(R.l.address_phone));
                stringBuilder.append("：");
                stringBuilder.append(bVar.eYe);
                stringBuilder.append(" \n");
            }
            stringBuilder.append(walletSelectAddrUI.getString(R.l.address_select_title));
            stringBuilder.append("：");
            if (!TextUtils.isEmpty(bVar.eXY)) {
                stringBuilder.append(bVar.eXY);
            }
            if (!TextUtils.isEmpty(bVar.eXZ)) {
                stringBuilder.append(bVar.eXZ);
            }
            if (!TextUtils.isEmpty(bVar.eYa)) {
                stringBuilder.append(bVar.eYa);
            }
            if (!TextUtils.isEmpty(bVar.eYc)) {
                stringBuilder.append(bVar.eYc);
            }
            if (!TextUtils.isEmpty(bVar.eYb)) {
                stringBuilder.append(" \n");
                stringBuilder.append(walletSelectAddrUI.getString(R.l.address_post));
                stringBuilder.append("：");
                stringBuilder.append(bVar.eYb);
            }
            try {
                d.R(walletSelectAddrUI.mController.tml, stringBuilder.toString());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WalletSelectAddrUI", e, "", new Object[0]);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eZY = new com.tencent.mm.plugin.address.c.b(this, this);
        Intent intent = getIntent();
        this.fac = intent.getBooleanExtra("launch_from_appbrand", false);
        if (intent.getBooleanExtra("launch_from_webview", false) || this.fac) {
            this.eYw = true;
            this.mController.contentView.setVisibility(8);
            if (this.fac) {
                getWindow().setBackgroundDrawableResource(R.e.navpage);
            }
            x.i("MicroMsg.WalletSelectAddrUI", "showDisclaimerDailog()");
            au.HU();
            if (((Boolean) com.tencent.mm.model.c.DT().get(aa.a.USERINFO_ADDRESS_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(true))).booleanValue()) {
                x.i("MicroMsg.WalletSelectAddrUI", "isShowDisclaimerDialog");
                h.a(this, getString(R.l.address_third_party_disclaimer_content), getString(R.l.address_third_party_disclaimer_title), getString(R.l.I_known), new 1(this));
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.USERINFO_ADDRESS_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(false));
            }
        }
        setMMTitle(R.l.address_select_title);
        this.eZY.jr(417);
        this.eZY.jr(416);
        this.eZY.jr(419);
        this.eZY.jr(582);
        this.eZY.g(new e(intent.getStringExtra("req_url"), intent.getStringExtra("req_app_id"), 2));
        au.HU();
        this.fab = new o(bi.a((Integer) com.tencent.mm.model.c.DT().get(9, null), 0));
        initView();
        au.HU();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            au.DF().a(new k(12), 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.eZY.js(417);
        this.eZY.js(416);
        this.eZY.js(419);
        this.eZY.js(582);
    }

    public void onResume() {
        super.onResume();
        ZH();
    }

    private void ZH() {
        synchronized (this.lockObj) {
            com.tencent.mm.plugin.address.a.a.Zv();
            this.eZV = com.tencent.mm.plugin.address.a.a.Zx().eXO.eXW;
            this.eZX.dEw = this.eZV;
            this.eZV.size();
            this.eZZ.setVisibility(8);
            this.eZX.notifyDataSetChanged();
        }
    }

    public final void initView() {
        this.faa = (TextView) findViewById(R.h.import_ecc_address_tv);
        this.faa.setVisibility(8);
        this.faa.setOnClickListener(new 3(this));
        this.eZb = (ListView) findViewById(R.h.settings_lv_address);
        this.eZX = new a(this, this);
        this.eZZ = findViewById(R.h.add_address);
        this.eZZ.findViewById(R.h.address_content_tv).setVisibility(8);
        ((TextView) this.eZZ.findViewById(R.h.address_name_tv)).setText(R.l.address_add_item);
        this.eZb.setAdapter(this.eZX);
        this.eZb.setOnItemClickListener(new 4(this));
        this.eZb.setOnItemLongClickListener(new 5(this));
        ZH();
        this.eZZ.setOnClickListener(new 6(this));
        this.eZX.notifyDataSetChanged();
        setBackBtn(new 7(this));
        addIconOptionMenu(0, R.l.address_add_title, R.k.actionbar_icon_dark_add, new 8(this));
    }

    protected final int getLayoutId() {
        return R.i.wallet_address_select_ui;
    }

    public final void f(int i, int i2, String str, l lVar) {
        this.eZY.a(i, i2, str, lVar);
        if (i == 0 && i2 == 0) {
            if (lVar.getType() == 417) {
                if (((e) lVar).eXH) {
                    ZH();
                    this.mController.contentView.setVisibility(0);
                    if (this.eYw && this.eZV.size() == 0) {
                        Intent intent = new Intent();
                        intent.setClass(this, WalletAddAddressUI.class);
                        startActivityForResult(intent, 1);
                    }
                }
            } else if (lVar.getType() == 416) {
                f fVar = (f) lVar;
                com.tencent.mm.plugin.address.a.a.Zv();
                b jq = com.tencent.mm.plugin.address.a.a.Zx().jq(fVar.eXI);
                if (jq != null) {
                    com.tencent.mm.plugin.address.a.a.Zv();
                    x.d("MicroMsg.WalletSelectAddrUI", "delte addr " + com.tencent.mm.plugin.address.a.a.Zx().a(jq));
                }
                ZH();
            } else if (lVar.getType() == 419) {
                if (this.eZW != null) {
                    setResult(-1, com.tencent.mm.plugin.address.e.a.b(this.eZW));
                    finish();
                }
            } else if (lVar.getType() == 582) {
                String string = getString(R.l.addressui_mall_address_import_fail);
                switch (((com.tencent.mm.plugin.address.model.d) lVar).status) {
                    case 0:
                        au.HU();
                        com.tencent.mm.model.c.DT().set(196657, Boolean.valueOf(true));
                        this.faa.setVisibility(8);
                        ZH();
                        this.mController.contentView.setVisibility(0);
                        string = getString(R.l.addressui_mall_address_import_ok);
                        break;
                    case 1:
                    case 2:
                        au.HU();
                        com.tencent.mm.model.c.DT().set(196657, Boolean.valueOf(true));
                        this.faa.setVisibility(8);
                        string = getString(R.l.addressui_mall_address_import_noinfo);
                        break;
                    case 3:
                        ZM();
                        return;
                }
                if (this.fad != null) {
                    this.fad.dismiss();
                }
                this.fad = h.a(this, string, null, true, null);
            }
        } else if (lVar.getType() == 419 && i2 == -3103) {
            h.a(this, true, str, "", getString(R.l.address_change_telephone), getString(R.l.app_cancel), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    WalletSelectAddrUI.this.jw(WalletSelectAddrUI.this.eZW.id);
                }
            }, new 2(this));
        }
    }

    private void aP(String str, String str2) {
        this.eZY.g(new com.tencent.mm.plugin.address.model.d(str, str2, this.fab));
    }

    private void ZM() {
        com.tencent.mm.sdk.b.b juVar = new ju();
        juVar.bTI.bOb = this;
        juVar.bTI.bTK = new 9(this, juVar);
        com.tencent.mm.sdk.b.a.sFg.a(juVar, Looper.myLooper());
    }

    private void jw(int i) {
        Intent intent = new Intent();
        intent.setClass(this, WalletAddAddressUI.class);
        intent.putExtra("address_id", i);
        startActivity(intent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (-1 == i2) {
                b bVar;
                if (intent == null) {
                    x.e("MicroMsg.AddrUtil", "intent == null");
                    bVar = null;
                } else {
                    bVar = new b();
                    bVar.eYf = intent.getStringExtra("nationalCode");
                    bVar.eYd = intent.getStringExtra("userName");
                    bVar.eYe = intent.getStringExtra("telNumber");
                    bVar.eYb = intent.getStringExtra("addressPostalCode");
                    bVar.eXY = intent.getStringExtra("proviceFirstStageName");
                    bVar.eXZ = intent.getStringExtra("addressCitySecondStageName");
                    bVar.eYa = intent.getStringExtra("addressCountiesThirdStageName");
                    bVar.eYc = intent.getStringExtra("addressDetailInfo");
                }
                setResult(-1, com.tencent.mm.plugin.address.e.a.b(bVar));
            } else {
                setResult(0);
            }
            finish();
        }
    }
}
