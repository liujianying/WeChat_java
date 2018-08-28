package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletSelectBankcardModeUI extends WalletBaseUI {
    private int hop = 0;
    private ListView lPD;
    private ArrayList<a> mData = new ArrayList();
    private ArrayList<Bankcard> oZG;
    private Bankcard oZH;
    private String oZI;
    private int oZR = 0;
    private int oZV = -1;
    private TextView paP;
    private b paQ;

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResult(0);
        this.hop = getIntent().getIntExtra("key_scene_select_bankcard_mode_ui", 0);
        this.oZV = getIntent().getIntExtra("key_select_index", -1);
        x.i("MicroMsg.WalletSelectBankcardModeUI", "onCreate() mFromScene is " + this.hop);
        initView();
    }

    protected final void initView() {
        setMMTitle(i.wallet_bancard_list_dialog_title);
        setBackBtn(new 1(this));
        this.paP = (TextView) findViewById(f.wallet_select_tips);
        if (this.hop == 0) {
            this.paP.setText(i.wallet_select_tips_for_fetch);
        } else if (this.hop == 1) {
            this.paP.setText(i.wallet_select_tips_for_save);
        }
        this.lPD = (ListView) findViewById(f.wallet_bankcard_list);
        this.paQ = new b(this);
        this.lPD.setAdapter(this.paQ);
        this.lPD.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                WalletSelectBankcardModeUI.this.oZV = i;
                WalletSelectBankcardModeUI.this.paQ.notifyDataSetChanged();
                Intent intent = new Intent();
                intent.putExtra("key_select_index", i);
                WalletSelectBankcardModeUI.this.setResult(-1, intent);
                x.i("MicroMsg.WalletSelectBankcardModeUI", "onItemClick pos is " + i);
                WalletSelectBankcardModeUI.this.finish();
            }
        });
        this.mData.clear();
        this.oZI = getString(i.wallet_balance_save_bind_new_card_to_fetch);
        if (this.hop == 0) {
            p.bNp();
            ag bNq = p.bNq();
            this.oZG = bNq.bPF();
            this.oZH = bNq.a(this.oZG, null, false, true);
            if (bNq.prE != null) {
                this.oZR = bNq.prE.oZR;
                x.e("MicroMsg.WalletSelectBankcardModeUI", "is_show_charge is " + this.oZR);
            } else {
                this.oZR = 0;
                x.e("MicroMsg.WalletSelectBankcardModeUI", "userInfo.getBalanceFetchInfo() is null");
            }
            if (this.oZG == null || this.oZG.size() <= 0) {
                x.i("MicroMsg.WalletSelectBankcardModeUI", "hy: no bankcard show new only");
            } else {
                x.i("MicroMsg.WalletSelectBankcardModeUI", "mBankcardList size is " + this.oZG.size());
                Iterator it = this.oZG.iterator();
                int i = 0;
                while (it.hasNext()) {
                    Bankcard bankcard = (Bankcard) it.next();
                    a aVar = new a((byte) 0);
                    aVar.title = bankcard.field_desc;
                    if (bankcard.field_fetch_charge_rate <= 0.0d || this.oZR != 1) {
                        x.i("MicroMsg.WalletSelectBankcardModeUI", "the bank " + bankcard.field_desc + " field_fetch_charge_rate is " + bankcard.field_fetch_charge_rate + " is_show_charge is " + this.oZR);
                    } else if (TextUtils.isEmpty(bankcard.field_fetch_charge_info)) {
                        aVar.hyz = getString(i.wallet_balance_fetch_charge_rate_tips_for_select) + (bankcard.field_fetch_charge_rate * 100.0d) + "%";
                    } else {
                        aVar.hyz = bankcard.field_fetch_charge_info;
                    }
                    this.mData.add(aVar);
                    if (this.oZV == -1 && this.oZH != null && this.oZH.equals(bankcard)) {
                        this.oZV = i;
                    }
                    i++;
                }
                if (this.oZV == -1 && this.oZH == null) {
                    this.oZV = i;
                }
            }
            a aVar2 = new a((byte) 0);
            aVar2.title = this.oZI;
            aVar2.hyz = "";
            this.mData.add(aVar2);
        }
        this.paQ.notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return g.wallet_select_bank_card_mode_ui;
    }

    public final boolean bbU() {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            setResult(0);
            finish();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
