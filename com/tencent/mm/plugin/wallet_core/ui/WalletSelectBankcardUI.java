package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.List;

@a(19)
public class WalletSelectBankcardUI extends WalletBaseUI {
    private int fdx = 0;
    private TextView hVU;
    private TextView pyf;
    private MaxListView pyg;
    private a pyh = null;
    private String pyi = null;
    private boolean pyj = true;
    private String pyk = null;
    private List<Bankcard> pyl = null;

    static /* synthetic */ void a(WalletSelectBankcardUI walletSelectBankcardUI, Bankcard bankcard) {
        walletSelectBankcardUI.sy.putParcelable("key_bankcard", bankcard);
        walletSelectBankcardUI.cDL().m(new Object[0]);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.wallet_bancard_list_dialog_title);
        this.fdx = this.sy.getInt("key_scene", 0);
        this.pyi = this.sy.getString("key_top_tips");
        this.pyj = this.sy.getBoolean("key_is_show_new_bankcard", true);
        this.pyk = this.sy.getString("bottom_tips");
        this.pyl = this.sy.getParcelableArrayList("key_showing_bankcards");
        if (this.pyl == null) {
            this.pyl = o.bOW().bPD();
        }
        this.pyf = (TextView) findViewById(f.title_tips_tv);
        this.pyg = (MaxListView) findViewById(f.bankcard_lv);
        this.hVU = (TextView) findViewById(f.bottom_tips_tv);
        if (bi.oW(this.pyi)) {
            this.pyf.setVisibility(8);
        } else {
            this.pyf.setVisibility(0);
            this.pyf.setText(this.pyi);
        }
        if (bi.oW(this.pyk)) {
            this.hVU.setVisibility(8);
        } else {
            this.hVU.setVisibility(0);
            this.hVU.setText(this.pyk);
        }
        if (this.fdx == 0) {
            this.hVU.setVisibility(0);
            h hVar = new h(this);
            hVar.pvm = new 1(this);
            String string = getString(i.wallet_select_bankcard_bcp_bottom_tips);
            CharSequence spannableString = new SpannableString(string);
            spannableString.setSpan(hVar, string.length() - 14, string.length(), 33);
            this.hVU.setText(spannableString);
            this.hVU.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.pyh = new a(this, (byte) 0);
        this.pyg.setAdapter(this.pyh);
        this.pyg.setOnItemClickListener(new 2(this));
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.wallet_select_bankcard_ui;
    }

    protected final boolean bND() {
        return true;
    }
}
