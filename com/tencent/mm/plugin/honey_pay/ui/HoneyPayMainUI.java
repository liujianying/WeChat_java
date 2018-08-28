package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.honey_pay.a.a;
import com.tencent.mm.plugin.honey_pay.a.b;
import com.tencent.mm.plugin.honey_pay.a.f;
import com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.alq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HoneyPayMainUI extends HoneyPayBaseUI {
    private TextView klA;
    private ArrayList<HoneyPayCardLayout> klB = new ArrayList();
    private LinearLayout klv;
    private ImageView klw;
    private RelativeLayout klx;
    private Button kly;
    private LinearLayout klz;

    static /* synthetic */ void a(HoneyPayMainUI honeyPayMainUI) {
        x.i(honeyPayMainUI.TAG, "do check payer");
        a aVar = new a();
        aVar.m(honeyPayMainUI);
        honeyPayMainUI.a(aVar, true, false);
    }

    static /* synthetic */ void a(HoneyPayMainUI honeyPayMainUI, long j, long j2, String str, String str2, String str3) {
        x.i(honeyPayMainUI.TAG, "go to give card");
        Intent intent = new Intent(honeyPayMainUI, HoneyPayGiveCardUI.class);
        intent.putExtra("key_max_credit_line", j);
        intent.putExtra("key_min_credit_line", j2);
        intent.putExtra("key_true_name", str);
        intent.putExtra("key_take_message", str2);
        intent.putExtra("key_username", str3);
        honeyPayMainUI.startActivityForResult(intent, 2);
    }

    static /* synthetic */ void b(HoneyPayMainUI honeyPayMainUI) {
        Iterator it = honeyPayMainUI.klB.iterator();
        while (it.hasNext()) {
            honeyPayMainUI.klz.removeView((HoneyPayCardLayout) it.next());
        }
        honeyPayMainUI.klB.clear();
    }

    static /* synthetic */ void b(HoneyPayMainUI honeyPayMainUI, List list) {
        ArrayList arrayList = new ArrayList();
        if (!(list == null || list.isEmpty())) {
            for (alq honeyPayCardType : list) {
                arrayList.add(new HoneyPayCardType(honeyPayCardType));
            }
        }
        Intent intent = new Intent(honeyPayMainUI, HoneyPaySelectCardTypeUI.class);
        intent.putParcelableArrayListExtra("key_card_type_list", arrayList);
        honeyPayMainUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jr(2725);
        jr(2618);
        jr(2926);
        M(getIntent());
        initView();
        fJ(true);
        setMMTitle(i.honey_pay_main_title);
    }

    protected final void initView() {
        this.klz = (LinearLayout) findViewById(a$f.hpmu_content_layout);
        this.klx = (RelativeLayout) findViewById(a$f.hpou_empty_header_layout);
        this.klw = (ImageView) findViewById(a$f.hpou_empty_header_iv);
        this.kly = (Button) findViewById(a$f.hpou_empty_add_friend_btn);
        this.klA = (TextView) findViewById(a$f.hpou_empty_header_tv);
        this.klv = (LinearLayout) findViewById(a$f.hpou_add_friend_layout);
        this.klv.setOnClickListener(new 1(this));
        this.kly.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i(HoneyPayMainUI.this.TAG, "click empty header add friend");
                HoneyPayMainUI.a(HoneyPayMainUI.this);
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        js(2725);
        js(2618);
        js(2926);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof f) {
            f fVar = (f) lVar;
            fVar.a(new 9(this, fVar)).b(new h.a() {
                public final void g(int i, int i2, String str, l lVar) {
                    com.tencent.mm.plugin.report.service.h.mEJ.e(875, 1, 1);
                }
            }).c(new h.a() {
                public final void g(int i, int i2, String str, l lVar) {
                    com.tencent.mm.plugin.report.service.h.mEJ.e(875, 1, 1);
                }
            });
        } else if (lVar instanceof a) {
            a aVar = (a) lVar;
            aVar.a(new 12(this, aVar)).b(new 11(this, aVar)).c(new 10(this));
        } else if (lVar instanceof b) {
            b bVar = (b) lVar;
            bVar.a(new 3(this, bVar)).b(new 2(this)).c(new 13(this));
        }
        return true;
    }

    protected final int getLayoutId() {
        return a$g.honey_pay_main_ui;
    }

    protected void onNewIntent(Intent intent) {
        x.i(this.TAG, "on new intent");
        M(intent);
        super.onNewIntent(intent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 3) {
            fJ(false);
        }
        super.onActivityResult(i, i2, intent);
    }

    private void M(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("key_create_succ", false);
        String stringExtra = intent.getStringExtra("key_card_no");
        String stringExtra2 = intent.getStringExtra("key_card_type");
        x.i(this.TAG, "create succ: %s", new Object[]{Boolean.valueOf(booleanExtra)});
        if (booleanExtra) {
            a(stringExtra, true, stringExtra2);
        }
    }

    private void fJ(boolean z) {
        x.i(this.TAG, "get payer list");
        f fVar = new f();
        fVar.m(this);
        a(fVar, z, false);
    }

    private void a(String str, boolean z, String str2) {
        x.i(this.TAG, "go to card manager: %s", new Object[]{str});
        Intent intent = new Intent(this, HoneyPayCardManagerUI.class);
        intent.putExtra("key_card_no", str);
        intent.putExtra("key_scene", 0);
        intent.putExtra("key_is_create", z);
        intent.putExtra("key_card_type", str2);
        startActivityForResult(intent, 3);
    }
}
