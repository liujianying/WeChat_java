package com.tencent.mm.plugin.card.ui;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.m.a;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.d.d.7;
import com.tencent.mm.plugin.card.d.d.8;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.ArrayList;

public class CardShopUI extends DrawStatusBarActivity implements a {
    private ListView CU;
    private ProgressDialog dId;
    private OnClickListener eZF = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getId() == d.shop_poi_layout) {
                la laVar = (la) view.getTag();
                if (laVar != null) {
                    b.a(CardShopUI.this, laVar.bSx, laVar.bUg, laVar.dRH);
                    h.mEJ.h(11941, new Object[]{Integer.valueOf(5), CardShopUI.this.htQ.awq(), CardShopUI.this.htQ.awr(), "", laVar.name});
                }
            }
        }
    };
    private boolean hAj = false;
    private String hGp = "";
    private a hGq;
    private LinearLayout hGr;
    private View hGs;
    private TextView hGt;
    BroadcastReceiver hiJ = new 4(this);
    private String htC;
    private com.tencent.mm.plugin.card.base.b htQ;
    private ArrayList<la> htW = new ArrayList();

    public void onCreate(Bundle bundle) {
        CardShopUI cardShopUI;
        super.onCreate(bundle);
        this.htQ = (com.tencent.mm.plugin.card.base.b) getIntent().getParcelableExtra("key_card_info_data");
        Object stringExtra = getIntent().getStringExtra("KEY_CARD_TP_ID");
        String stringExtra2 = getIntent().getStringExtra("KEY_CARD_ID");
        if (this.htQ != null) {
            x.i("MicroMsg.CardShopUI", "onCreate  mCardInfo != null");
            this.hGp = this.htQ.awr();
            stringExtra2 = this.htQ.awq();
            cardShopUI = this;
        } else {
            if (!TextUtils.isEmpty(stringExtra)) {
                this.hGp = stringExtra;
                if (TextUtils.isEmpty(stringExtra2)) {
                    stringExtra2 = "";
                    cardShopUI = this;
                } else {
                    cardShopUI = this;
                }
            }
            if (TextUtils.isEmpty(this.hGp)) {
                x.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
                finish();
            }
            x.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
            this.hAj = r0;
            if (this.hAj) {
                ayV();
            }
            initView();
        }
        cardShopUI.htC = stringExtra2;
        if (TextUtils.isEmpty(this.hGp)) {
            x.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
            finish();
        }
        x.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
        this.hAj = r0;
        if (this.hAj) {
            ayV();
        }
        initView();
    }

    protected final void initView() {
        if (TextUtils.isEmpty(this.htQ.awm().roj)) {
            setMMTitle(g.card_adapted_stores);
        } else {
            setMMTitle(this.htQ.awm().roj);
        }
        this.CU = (ListView) findViewById(d.card_shop_lv);
        this.hGr = (LinearLayout) View.inflate(getBaseContext(), e.card_list_header_view, null);
        this.CU.addHeaderView(this.hGr);
        this.hGq = new a(this, (byte) 0);
        this.CU.setAdapter(this.hGq);
        this.CU.setOnItemClickListener(new 1(this, getIntent()));
        setBackBtn(new 2(this));
        this.hGs = View.inflate(this, e.card_list_header_tip_layout, null);
        if (this.hGr != null) {
            this.hGr.addView(this.hGs);
        }
        this.hGt = (TextView) this.hGs.findViewById(d.card_list_header_tips);
        this.hGt.setText(g.card_shop_list_header_tips);
        this.hGs.setVisibility(8);
        com.tencent.mm.ui.statusbar.a.c(this.mController.contentView, getStatusBarColor(), true);
    }

    protected void onDestroy() {
        if (this.hAj) {
            unregisterReceiver(this.hiJ);
        }
        am.axl().a(this.hGp, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return e.card_shop_ui;
    }

    public final void a(boolean z, ArrayList<la> arrayList) {
        if (this.dId != null) {
            this.dId.dismiss();
            this.dId = null;
        }
        String str = "MicroMsg.CardShopUI";
        String str2 = "onGotCardShop, isOk = %b, shop list size = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        x.d(str, str2, objArr);
        if (!z) {
            x.e("MicroMsg.CardShopUI", "onGotCardShop fail");
        } else if (arrayList == null || arrayList.size() == 0) {
            x.e("MicroMsg.CardShopUI", "list == null || list.size() == 0");
        } else {
            if (this.htW != null) {
                this.htW.clear();
                this.htW.addAll(arrayList);
                this.hGs.setVisibility(0);
            } else {
                this.hGs.setVisibility(8);
            }
            this.hGq.notifyDataSetChanged();
        }
    }

    private void ayV() {
        x.i("MicroMsg.CardShopUI", "openLocation");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        registerReceiver(this.hiJ, intentFilter);
        if (ayW()) {
            ayX();
            return;
        }
        com.tencent.mm.ui.base.h.a(this, getString(g.card_report_location_confirm_nogps, new Object[]{getString(g.card_adapted_stores)}), getString(g.app_tip), new 7(this), new 8());
    }

    private static boolean ayW() {
        boolean z;
        if (l.OC() || l.OD()) {
            z = false;
        } else {
            z = true;
        }
        return !z;
    }

    private void ayX() {
        if (am.axl().a(this.hGp, this.htC, this)) {
            ActionBarActivity actionBarActivity = this.mController.tml;
            getString(g.app_tip);
            this.dId = com.tencent.mm.ui.base.h.a(actionBarActivity, getString(g.card_getting_shop_list), true, new 3(this));
            return;
        }
        com.tencent.mm.ui.base.h.bA(this, getString(g.card_get_shop_list_fail));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.CardShopUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 69:
                if (iArr[0] == 0) {
                    x.i("MicroMsg.CardShopUI", "onMPermissionGranted LocationPermissionGranted " + this.hAj);
                    if (!this.hAj) {
                        this.hAj = true;
                        ayV();
                        return;
                    }
                    return;
                }
                com.tencent.mm.ui.base.h.a(this, getString(g.permission_location_request_again_msg), getString(g.permission_tips_title), getString(g.jump_to_settings), getString(g.confirm_dialog_cancel), false, new 6(this), null);
                return;
            default:
                return;
        }
    }
}
