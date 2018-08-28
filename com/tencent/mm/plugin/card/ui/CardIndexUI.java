package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.i;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.x;

public class CardIndexUI extends CardBaseUI {
    private final String TAG = "MicroMsg.CardIndexUI";
    int fromScene = 0;
    private View hEK;
    private TextView hEL;
    private f hEM;
    private TextView hEN;
    private TextView hEO;
    private ImageView hEP;
    private LinearLayout hEQ;
    int hER = -1;
    private long mStartTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.CardIndexUI", "oncreate");
        this.mStartTime = System.currentTimeMillis();
        initView();
        g.Eh().dpP.a(984, this);
        am.axh();
        b.nG(1);
        int i = am.axm().huN;
        if (c.Cp().aT(262152, 266256) || i > 0) {
            h.mEJ.h(11324, new Object[]{"CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), ""});
            return;
        }
        h.mEJ.h(11324, new Object[]{"CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), ""});
    }

    protected void onDestroy() {
        g.Eh().dpP.b(984, this);
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        h.mEJ.h(13219, new Object[]{"CardPackageListView", Integer.valueOf(this.fromScene), "", "", Long.valueOf(currentTimeMillis)});
        super.onDestroy();
    }

    protected final void initView() {
        if (getIntent() != null) {
            this.hER = getIntent().getIntExtra("key_card_type", -1);
        }
        super.initView();
    }

    protected final void avD() {
        if (1 == this.hER) {
            setMMTitle(a.g.card_member_card_title);
        } else if (3 == this.hER) {
            setMMTitle(a.g.card_ticket_title);
        } else {
            setMMTitle(a.g.card_mm_card_package_new);
        }
        this.hEN = (TextView) findViewById(d.no_card_tip_text);
        this.hEO = (TextView) findViewById(d.no_card_tip_title);
        this.hEP = (ImageView) findViewById(d.no_card_tip_img);
        this.hEK = findViewById(d.card_experience_layout);
        this.hEL = (TextView) findViewById(d.card_experience_url_tv);
        this.hEQ = (LinearLayout) findViewById(d.no_card_tip_layout);
        this.hEK.setVisibility(8);
        this.hEO.setVisibility(0);
        this.hEN.setVisibility(0);
        this.hEP.setVisibility(8);
        LayoutParams layoutParams = (LayoutParams) this.hEQ.getLayoutParams();
        layoutParams.topMargin = BackwardSupportUtil.b.b(this, 100.0f);
        this.hEQ.setLayoutParams(layoutParams);
        if (1 == this.hER) {
            this.hEO.setText(getString(a.g.card_list_member_card_empty_tips_title));
            this.hEN.setText(getString(a.g.card_list_member_card_empty_tips));
        } else if (3 == this.hER) {
            this.hEO.setText(getString(a.g.card_list_ticket_card_empty_tips_title));
            this.hEN.setText(getString(a.g.card_list_ticket_card_empty_tips));
        } else {
            this.hEO.setText(getString(a.g.card_select_list_no_card_tips));
            this.hEN.setText(getString(a.g.card_share_card_list_no_card_tips));
        }
        this.hEL.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (!TextUtils.isEmpty(CardIndexUI.this.hEM.hwm)) {
                    com.tencent.mm.plugin.card.d.b.a(CardIndexUI.this, CardIndexUI.this.hEM.hwm, 0);
                }
            }
        });
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onStop() {
        super.onStop();
    }

    protected final int avE() {
        if (1 == this.hER) {
            return n.a.hwR;
        }
        if (3 == this.hER) {
            return n.a.hwQ;
        }
        return n.a.hwN;
    }

    protected final BaseAdapter avF() {
        if (3 == this.hER) {
            return new k(this, avE());
        }
        return new c(this, avE());
    }

    public final void a(int i, int i2, String str, l lVar) {
        super.a(i, i2, str, lVar);
        if (i != 0 || i2 != 0) {
            return;
        }
        if (lVar instanceof com.tencent.mm.plugin.card.model.x) {
            this.hEM = i.xT((String) g.Ei().DT().get(282885, ""));
            if (this.hEM == null) {
                this.hEM = new f();
            }
            if (!(this.hEM == null || TextUtils.isEmpty(this.hEM.hwk))) {
                this.hEN.setText(this.hEM.hwk);
            }
            if (this.hEM == null || !this.hEM.hwn) {
                this.hEK.setVisibility(8);
                return;
            }
            this.hEL.setText(this.hEM.hwl);
            if (TextUtils.isEmpty(this.hEM.hwl) || TextUtils.isEmpty(this.hEM.hwm)) {
                this.hEK.setVisibility(8);
            } else {
                this.hEK.setVisibility(0);
            }
        } else if ((lVar instanceof ad) && ((ad) lVar).hxk && (this.htl instanceof c)) {
            ((c) this.htl).lB(false);
            ((c) this.htl).lB(true);
            ((c) this.htl).WT();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
