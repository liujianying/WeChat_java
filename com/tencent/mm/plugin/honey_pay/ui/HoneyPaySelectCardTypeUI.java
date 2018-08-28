package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.honey_pay.a.b;
import com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.alq;
import com.tencent.mm.protocal.c.alr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.List;

public class HoneyPaySelectCardTypeUI extends HoneyPayBaseUI {
    private LinearLayout kmf;
    private List<alq> kmg;
    private int kmh;
    private alr kmi;

    static /* synthetic */ void a(HoneyPaySelectCardTypeUI honeyPaySelectCardTypeUI, long j, long j2, String str, String str2, String str3, String str4, String str5) {
        x.i("MicroMsg.HoneyPaySelectCardTypeUI", "go to give card");
        Intent intent = new Intent(honeyPaySelectCardTypeUI, HoneyPayGiveCardUI.class);
        intent.putExtra("key_max_credit_line", j);
        intent.putExtra("key_min_credit_line", j2);
        intent.putExtra("key_true_name", str);
        intent.putExtra("key_take_message", str2);
        intent.putExtra("key_username", str3);
        intent.putExtra("key_wishing", str4);
        intent.putExtra("key_icon_url", str5);
        intent.putExtra("key_cardtype", honeyPaySelectCardTypeUI.kmh);
        honeyPaySelectCardTypeUI.startActivity(intent);
    }

    static /* synthetic */ void b(HoneyPaySelectCardTypeUI honeyPaySelectCardTypeUI) {
        x.i("MicroMsg.HoneyPaySelectCardTypeUI", "go to select contact");
        Intent intent = new Intent();
        intent.putExtra("list_attr", s.s(new int[]{16, 1, 2, 4, 16384}));
        intent.putExtra("block_contact", q.GF());
        intent.putExtra("titile", honeyPaySelectCardTypeUI.getString(i.honey_pay_select_friend));
        d.b(honeyPaySelectCardTypeUI, ".ui.contact.SelectContactUI", intent, 1);
    }

    public void onCreate(Bundle bundle) {
        this.kjV = c.honey_pay_grey_bg_1;
        super.onCreate(bundle);
        jr(2618);
        jr(2926);
        setMMTitle(i.honey_pay_select_card_type_title);
        List<HoneyPayCardType> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_card_type_list");
        if (!(parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty())) {
            this.kmg = new ArrayList();
            try {
                for (HoneyPayCardType honeyPayCardType : parcelableArrayListExtra) {
                    alq alq = new alq();
                    alq.aG(honeyPayCardType.lR);
                    this.kmg.add(alq);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.HoneyPaySelectCardTypeUI", e, "", new Object[0]);
            }
        }
        initView();
        aoV();
    }

    protected final void initView() {
        this.kmf = (LinearLayout) findViewById(f.hpsc_top_layout);
    }

    public void onDestroy() {
        js(2618);
        js(2926);
        super.onDestroy();
    }

    protected final boolean Wt() {
        return false;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof b) {
            b bVar = (b) lVar;
            bVar.a(new 3(this, bVar)).b(new 2(this)).c(new 1(this));
        }
        return true;
    }

    protected final int getLayoutId() {
        return g.honey_pay_select_cardtype_ui;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (i2 == -1) {
                x.i("MicroMsg.HoneyPaySelectCardTypeUI", "select friend: %s", new Object[]{intent.getStringExtra("Select_Conv_User")});
                x.i("MicroMsg.HoneyPaySelectCardTypeUI", "do check user: %s", new Object[]{r0});
                b bVar = new b(r0, this.kmh);
                bVar.m(this);
                a(bVar, true, false);
            } else {
                x.i("MicroMsg.HoneyPaySelectCardTypeUI", "cancel add friend");
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    private void aoV() {
        this.kmf.removeAllViews();
        if (this.kmg != null && !this.kmg.isEmpty()) {
            for (alq alq : this.kmg) {
                View view;
                a aVar = new a(this, (byte) 0);
                if (alq.rIy == null) {
                    ActionBarActivity actionBarActivity = this.mController.tml;
                    View inflate = LayoutInflater.from(actionBarActivity).inflate(g.honey_pay_select_cardtype_item, this.kmf, false);
                    aVar.a(inflate, alq);
                    view = inflate;
                } else {
                    ActionBarActivity actionBarActivity2 = this.mController.tml;
                    View inflate2 = LayoutInflater.from(actionBarActivity2).inflate(g.honey_pay_select_cardtype_item_with_operations, this.kmf, false);
                    aVar.a(inflate2, alq);
                    aVar.kkn = (CdnImageView) inflate2.findViewById(f.hpsc_operations_icon_iv);
                    aVar.kmm = (TextView) inflate2.findViewById(f.hpsc_operations_tv);
                    aVar.kkn.setUrl(alq.rIy.bWP);
                    CharSequence spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append(alq.rIy.rOd);
                    spannableStringBuilder.append(alq.rIy.rOe);
                    spannableStringBuilder.setSpan(new m(new 1(aVar, alq, actionBarActivity2)), alq.rIy.rOd.length(), spannableStringBuilder.length(), 34);
                    aVar.kmm.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(actionBarActivity2));
                    aVar.kmm.setClickable(true);
                    aVar.kmm.setText(spannableStringBuilder);
                    view = inflate2;
                }
                this.kmf.addView(view);
            }
        }
    }
}
