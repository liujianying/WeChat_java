package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

public class WalletBankcardDetailUI extends WalletBaseUI {
    public Bankcard paI;
    protected TextView pcR;
    private TextView pcS;
    private View pcT;
    protected LinearLayout pcU;
    protected LinearLayout pcV;
    protected LinearLayout pcW;

    protected final int getLayoutId() {
        return g.wallet_bankcard_detail;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jr(621);
        setMMTitle(i.wallet_bankcard_detail_title);
        initView();
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        js(621);
        super.onDestroy();
    }

    protected final void initView() {
        this.paI = (Bankcard) this.sy.getParcelable("key_bankcard");
        if (this.paI != null) {
            this.pcU = (LinearLayout) findViewById(f.wallet_bankcard_detail_expired);
            this.pcV = (LinearLayout) findViewById(f.wallet_bankcard_detail_ll);
            this.pcW = (LinearLayout) findViewById(f.wallet_bankcard_detail_international_ll);
            this.pcS = (TextView) findViewById(f.wallet_bankcard_detail_finance);
            this.pcT = findViewById(f.wallet_bankcard_detail_repay_layout);
            this.pcT.setOnClickListener(new 1(this));
            if (1 == this.paI.field_bankcardState) {
                bNg();
                return;
            }
            String str;
            if (this.paI.bOv()) {
                ji(true);
                this.pcR = (TextView) findViewById(f.wallet_bankcard_detail_default);
                p.bNp();
                p.bNq();
                str = this.paI.field_bindSerial;
                this.pcR.setVisibility(8);
            } else {
                ji(false);
                this.pcR = (TextView) findViewById(f.wallet_bankcard_detail_international_default);
                p.bNp();
                p.bNq();
                str = this.paI.field_bindSerial;
                this.pcR.setVisibility(8);
            }
            addIconOptionMenu(0, a$e.mm_title_btn_menu, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    p.bNp();
                    List bPD = p.bNq().bPD();
                    if (bPD != null && bPD.size() > 1) {
                        p.bNp();
                        p.bNq();
                        String str = WalletBankcardDetailUI.this.paI.field_bindSerial;
                    }
                    List arrayList = new ArrayList();
                    h.a(WalletBankcardDetailUI.this, null, (String[]) arrayList.toArray(new String[arrayList.size()]), WalletBankcardDetailUI.this.getString(i.wallet_index_ui_unbind_bankcard), false, new 1(this));
                    return true;
                }
            });
        }
    }

    public final void ji(boolean z) {
        if (z) {
            this.pcU.setVisibility(8);
            this.pcV.setVisibility(0);
            ((TextView) findViewById(f.wallet_bankcard_detail_bankphone)).setOnClickListener(new 2(this));
            TextView textView = (TextView) findViewById(f.wallet_bankcard_detail_per_order_virtual);
            TextView textView2 = (TextView) findViewById(f.wallet_bankcard_detail_per_day_kind);
            TextView textView3 = (TextView) findViewById(f.wallet_bankcard_detail_per_day_virtual);
            ((TextView) findViewById(f.wallet_bankcard_detail_per_order_kind)).setText(e.e(this.paI.field_onceQuotaKind, null));
            textView.setText(e.e(this.paI.field_onceQuotaVirtual, null));
            textView2.setText(e.e(this.paI.field_dayQuotaKind, null));
            textView3.setText(e.e(this.paI.field_dayQuotaVirtual, null));
            if (!bi.oW(this.paI.field_repay_url)) {
                this.pcS.setVisibility(0);
                this.pcT.setVisibility(0);
                return;
            }
            return;
        }
        this.pcU.setVisibility(8);
        this.pcV.setVisibility(8);
        this.pcW.setVisibility(0);
    }

    public final void bNg() {
        this.pcU.setVisibility(0);
        this.pcV.setVisibility(8);
        ((TextView) findViewById(f.wallet_bankcard_detail_expired_bankphone)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletBankcardDetailUI.this.showDialog(0);
            }
        });
        ((TextView) findViewById(f.wallet_bankcard_detail_unbind)).setOnClickListener(new 4(this));
    }

    private void jj(boolean z) {
        if (q.GS() || z || ((b) com.tencent.mm.kernel.g.l(b.class)).bRp()) {
            this.sy.putBoolean("offline_pay", false);
            a.j(this, this.sy);
            return;
        }
        e.He(0);
        h.a((Context) this, i.wallet_bankcard_detail_unbind_dialog_tip, -1, i.wallet_bankcard_detail_unbind_dialog_open_gesture, i.wallet_bankcard_detail_unbind_dialog_unbind_btn, true, new 6(this), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                WalletBankcardDetailUI.this.jj(true);
                e.He(2);
            }
        });
    }

    @Deprecated
    protected Dialog onCreateDialog(int i) {
        return h.a(this.mController.tml, getString(i.wallet_bankcard_detail_bankphone_tips), getResources().getStringArray(com.tencent.mm.plugin.wxpay.a.b.wallet_phone_call), "", new 8(this));
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            if (lVar instanceof com.tencent.mm.plugin.wallet.bind.a.b) {
                if (this.pcR == null) {
                    return false;
                }
                this.pcR.setVisibility(0);
                return false;
            } else if (!(lVar instanceof com.tencent.mm.plugin.wallet.bind.a.a)) {
                return false;
            } else {
                com.tencent.mm.plugin.wallet.bind.a.a aVar = (com.tencent.mm.plugin.wallet.bind.a.a) lVar;
                x.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo succ and level = " + aVar.pcr);
                switch (aVar.pcr) {
                    case 2:
                    case 3:
                        h.a((Context) this, aVar.pcs, null, false, new 9(this, aVar.pcr));
                        return false;
                    default:
                        jj(false);
                        return false;
                }
            }
        } else if (!(lVar instanceof com.tencent.mm.plugin.wallet.bind.a.a)) {
            return false;
        } else {
            x.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo error");
            jj(false);
            return true;
        }
    }
}
