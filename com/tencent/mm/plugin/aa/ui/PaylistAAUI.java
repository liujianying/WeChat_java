package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.aa.a.c.f;
import com.tencent.mm.plugin.aa.a.c.g;
import com.tencent.mm.plugin.aa.a.c.g$c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.protocal.c.t;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.List;

public class PaylistAAUI extends BaseAAPresenterActivity {
    private String bJh;
    private String bXw;
    private Dialog eBX = null;
    private View eCD;
    private g eDU = ((g) t(g.class));
    private f eDV = ((f) w(f.class));
    private LinearLayout eDW;
    private LinearLayout eDX;
    private LinearLayout eDY;
    private WalletTextView eDZ;
    private Button eEa;
    private TextView eEb;
    private TextView eEc;
    private TextView eEd;
    private TextView eEe;
    private String eEf;
    private String eEg;
    private String eEh;
    private int eEi;
    private String eEj;
    private long eEk;
    private String title;

    static /* synthetic */ void b(PaylistAAUI paylistAAUI) {
        if (paylistAAUI.eBX != null) {
            paylistAAUI.eBX.dismiss();
        }
        paylistAAUI.eBX = com.tencent.mm.wallet_core.ui.g.a(paylistAAUI, false, null);
        com.tencent.mm.vending.g.g.cBK().c(paylistAAUI.eDU.eBG).f(new 6(paylistAAUI)).a(new 5(paylistAAUI));
        h.mEJ.h(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(8)});
    }

    static /* synthetic */ void e(PaylistAAUI paylistAAUI, v vVar) {
        if (vVar.qYn == a.ezM && vVar.qYB.equals(q.GF())) {
            paylistAAUI.eEe.setVisibility(0);
        } else {
            paylistAAUI.eEe.setVisibility(8);
        }
        if (paylistAAUI.eEe.getVisibility() != 0) {
            x.i("MicroMsg.PaylistAAUI", "no need to show bottom tv");
        } else if (bi.oW(vVar.qYN)) {
            x.i("MicroMsg.PaylistAAUI", "wording is null");
        } else {
            CharSequence spannableStringBuilder = new SpannableStringBuilder(vVar.qYN);
            if (vVar.qYO == 1) {
                paylistAAUI.eEe.setClickable(true);
                paylistAAUI.eEe.setOnTouchListener(new m(paylistAAUI));
                spannableStringBuilder.setSpan(new a(new 11(paylistAAUI)), 0, spannableStringBuilder.length(), 18);
            }
            paylistAAUI.eEe.setText(spannableStringBuilder);
            paylistAAUI.getWindow().getDecorView().post(new 12(paylistAAUI));
        }
    }

    static /* synthetic */ void h(PaylistAAUI paylistAAUI) {
        if (paylistAAUI.eBX != null) {
            paylistAAUI.eBX.dismiss();
        }
        paylistAAUI.eBX = com.tencent.mm.wallet_core.ui.g.a(paylistAAUI, false, null);
        com.tencent.mm.vending.g.g.cBK().c(paylistAAUI.eDU.eBF).f(new 4(paylistAAUI)).a(new 3(paylistAAUI));
        h.mEJ.h(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(6)});
    }

    static /* synthetic */ void k(PaylistAAUI paylistAAUI) {
        Intent intent = new Intent();
        intent.putExtra("close_aa", true);
        intent.putExtra("item_position", paylistAAUI.getIntent().getIntExtra("item_position", 0));
        intent.putExtra("item_offset", paylistAAUI.getIntent().getIntExtra("item_offset", 0));
        paylistAAUI.setResult(-1, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        setMMTitle(i.launch_aa_title);
        this.eEg = getIntent().getStringExtra("chatroom");
        this.eDW = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.paylist_aa_pay_info_layout);
        this.eDX = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.paylist_aa_instant_pay_layout);
        this.eDY = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.paylist_aa_bottom_layout);
        this.eEb = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.paylist_aa_pay_info_msg_tv);
        this.eEc = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.paylist_aa_close_info_msg_tv);
        this.eCD = findViewById(com.tencent.mm.plugin.wxpay.a.f.root_container);
        this.eEd = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.paylist_aa_send_tip_tv);
        this.eEd.setClickable(true);
        this.eEd.setOnTouchListener(new m(this));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(getString(i.paylist_aa_recevier_send_tip_title));
        spannableStringBuilder.setSpan(new a(new 8(this)), 0, spannableStringBuilder.length(), 18);
        this.eEd.setText(spannableStringBuilder);
        this.eEe = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.paylist_aa_bottom_tip_tv);
        WA();
    }

    private void WA() {
        this.eBX = com.tencent.mm.wallet_core.ui.g.b(this, false, null);
        this.eCD.setVisibility(4);
        com.tencent.mm.vending.g.g.cBK().c(this.eDU.eBB).f(new 10(this)).a(new 9(this));
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private static boolean C(int i, int i2, int i3) {
        return i == a.ezM && i2 != a.ezQ && i3 == a.ezI;
    }

    private void a(List<t> list, String str, boolean z) {
        ((TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.paylist_aa_top_member_hint_tv)).setText(str);
        this.eEd.setVisibility(z ? 0 : 8);
        LinearLayout linearLayout = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.paylist_aa_top_member_layout);
        linearLayout.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            boolean z2;
            t tVar = (t) list.get(i);
            if (i >= list.size() - 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            a(linearLayout, tVar, z2);
        }
    }

    private void d(List<t> list, String str) {
        ((TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.paylist_aa_bottom_member_hint_tv)).setText(str);
        LinearLayout linearLayout = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.paylist_aa_bottom_member_layout);
        linearLayout.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            boolean z;
            t tVar = (t) list.get(i);
            if (i >= list.size() - 1) {
                z = true;
            } else {
                z = false;
            }
            a(linearLayout, tVar, z);
        }
    }

    private void a(LinearLayout linearLayout, t tVar, boolean z) {
        LinearLayout linearLayout2 = (LinearLayout) getLayoutInflater().inflate(com.tencent.mm.plugin.wxpay.a.g.paylist_aa_memeber_item, linearLayout, false);
        ImageView imageView = (ImageView) linearLayout2.findViewById(com.tencent.mm.plugin.wxpay.a.f.paylist_aa_member_avatar_iv);
        TextView textView = (TextView) linearLayout2.findViewById(com.tencent.mm.plugin.wxpay.a.f.paylist_aa_member_name_tv);
        TextView textView2 = (TextView) linearLayout2.findViewById(com.tencent.mm.plugin.wxpay.a.f.paylist_aa_member_pay_state_tv);
        View findViewById = linearLayout2.findViewById(com.tencent.mm.plugin.wxpay.a.f.divider);
        if (z) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        b.a(imageView, tVar.qYy);
        ActionBarActivity actionBarActivity = this.mController.tml;
        f fVar = this.eDV;
        textView.setText(j.a(actionBarActivity, ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(tVar.qYy, fVar.uPN.getStringExtra("chatroom")), textView.getTextSize()));
        if (tVar.qYA == a.ezT) {
            textView2.setText(getString(i.paylist_aa_paid_money_title, new Object[]{Double.valueOf(((double) tVar.qYl) / 100.0d)}));
            textView2.setTextColor(getResources().getColor(c.paylist_done_receipt_text_color));
            textView2.setVisibility(0);
            linearLayout.addView(linearLayout2);
        } else if (tVar.qYA == a.ezS) {
            textView2.setText(getString(i.paylist_aa_by_person_member_unpaid_title, new Object[]{Double.valueOf(((double) tVar.qYl) / 100.0d)}));
            textView2.setTextColor(getResources().getColor(c.paylist_unreceipt_text_color));
            textView2.setVisibility(0);
            linearLayout.addView(linearLayout2);
        } else {
            textView2.setVisibility(8);
            linearLayout.addView(linearLayout2);
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.paylist_aa_ui;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Intent intent2;
        String stringExtra;
        if (i == 233) {
            if (i2 == -1) {
                x.i("MicroMsg.PaylistAAUI", "pay success, payMsgId: %s", new Object[]{this.bXw});
                RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                if (realnameGuideHelper != null) {
                    x.i("MicroMsg.PaylistAAUI", "do realname guide");
                    intent2 = new Intent();
                    intent2.putExtra("key_realname_guide_helper", realnameGuideHelper);
                    d.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", intent2);
                }
                com.tencent.mm.plugin.aa.a.h.pc(this.eEg);
                finish();
                com.tencent.mm.vending.g.g.a(this.bXw, this.eEh, this.eEj).c(this.eDU.eBD).f(new 7(this));
                h.mEJ.a(407, 12, 1, false);
                stringExtra = intent.getStringExtra("key_trans_id");
                g$c g_c = this.eDU.eBE;
                long j = this.eEk;
                com.tencent.mm.vending.g.g.a(Long.valueOf(j), this.bJh, stringExtra).c(g_c);
            }
        } else if (i == TbsListener$ErrorCode.UNLZMA_FAIURE && i2 == -1) {
            stringExtra = intent.getStringExtra("Select_Conv_User");
            x.i("MicroMsg.PaylistAAUI", "select chatroom：%s", new Object[]{stringExtra});
            if (!bi.oW(stringExtra)) {
                intent2 = new Intent(this.mController.tml, LaunchAAUI.class);
                intent2.putExtra("enter_scene", 3);
                intent2.putExtra("chatroom_name", stringExtra);
                startActivity(intent2);
            }
        }
    }
}
