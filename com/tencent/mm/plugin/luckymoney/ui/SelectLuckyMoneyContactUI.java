package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class SelectLuckyMoneyContactUI extends MMBaseSelectContactUI {
    private List<String> gRN;
    private View kXV;

    protected final void Wj() {
        super.Wj();
        Collection hashSet = new HashSet();
        hashSet.addAll(s.cyz());
        hashSet.addAll(s.cyA());
        String stringExtra = getIntent().getStringExtra("Select_block_List");
        if (!bi.oW(stringExtra)) {
            hashSet.addAll(bi.F(stringExtra.split(",")));
        }
        this.gRN = new ArrayList();
        this.gRN.addAll(hashSet);
    }

    public final void iV(int i) {
        if (i < getContentLV().getHeaderViewsCount()) {
            x.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[]{Integer.valueOf(i)});
            x.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
            int intExtra = getIntent().getIntExtra("key_friends_num", 0);
            Intent intent = new Intent();
            int s = s.s(new int[]{16, 1, 2, 4, 16384, 64, 65536, 131072});
            intent.putExtra("list_type", 0);
            intent.putExtra("list_attr", s);
            intent.putExtra("max_limit_num", intExtra);
            intent.putExtra("titile", getString(i.lucky_money_select_contact_title, new Object[]{Integer.valueOf(intExtra)}));
            intent.putExtra("sub_title", getString(i.wechat_wxpay_authenticate));
            d.b(this, ".ui.contact.SelectContactUI", intent, 1);
            overridePendingTransition(a.push_up_in, a.fast_faded_out);
            return;
        }
        com.tencent.mm.ui.contact.a.a aVar = (com.tencent.mm.ui.contact.a.a) getContentLV().getAdapter().getItem(i);
        if (aVar != null) {
            ab abVar = aVar.guS;
            if (abVar != null) {
                String str = abVar.field_username;
                x.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[]{str});
                Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_User", str);
                String str2 = null;
                if (com.tencent.mm.model.s.fq(str)) {
                    str2 = getString(i.wallet_select_contact_num, new Object[]{Integer.valueOf(m.gK(str))});
                }
                ((h) g.l(h.class)).a(this.mController, str, getString(i.retransmit_to_conv_comfirm2), str, str2, getString(i.app_send), new 1(this, intent2));
            }
        }
    }

    protected final boolean Wk() {
        return false;
    }

    protected final boolean Wl() {
        return false;
    }

    protected final String Wm() {
        return getString(i.lucky_money_select_friends);
    }

    protected final o Wn() {
        return new w(this, this.gRN);
    }

    protected final com.tencent.mm.ui.contact.m Wo() {
        return new q(this, this.gRN, false, this.scene);
    }

    public final int[] bbG() {
        return new int[]{131072};
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.kXV == null) {
            View inflate = View.inflate(this, a$g.select_conversation_header, null);
            this.kXV = inflate.findViewById(a$f.content);
            ((TextView) inflate.findViewById(a$f.tip_tv)).setText(i.lucky_money_go_select_multi_contact_title);
            listView.addHeaderView(inflate);
        }
        this.kXV.setVisibility(i);
    }

    protected final void bbH() {
        super.bbH();
        YC();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bbH();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            x.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            x.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        if (i != 1) {
            x.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = " + i);
        } else if (i2 == -1) {
            x.i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
            setResult(-1, intent);
            finish();
        }
    }
}
