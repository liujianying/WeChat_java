package com.tencent.mm.plugin.aa.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.s.b;
import java.util.Arrays;
import java.util.HashSet;

public class AASelectContactUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private HashSet<String> eCq;
    private HashSet<String> eCr;
    private long eCs;
    private int eCt;
    private CheckBox eCu;
    private View eCv;
    private String title;

    protected final void Wj() {
        super.Wj();
        this.title = getIntent().getStringExtra("titile");
        this.eCs = getIntent().getLongExtra("max_select_num", 20);
        this.eCt = getIntent().getIntExtra("select_type", 1);
        this.chatroomName = getIntent().getStringExtra("chatroomName");
        if (!s.fq(this.chatroomName)) {
            x.i("MicroMsg.AASelectContactUI", "is single chat");
        }
        this.eCr = new HashSet();
        this.eCq = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bi.oW(stringExtra)) {
            this.eCq.addAll(Arrays.asList(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!bi.oW(stringExtra)) {
            this.eCr.addAll(bi.F(stringExtra.split(",")));
            Wp();
        }
        this.eCu = (CheckBox) findViewById(f.toggle_select_all);
        this.eCv = findViewById(f.toggle_select_all_click_area);
        this.eCv.setOnClickListener(new 1(this));
        if (this.eCr.size() == h.pb(this.chatroomName).size()) {
            this.eCu.setChecked(true);
        } else {
            this.eCu.setChecked(false);
        }
        this.eCu.setOnCheckedChangeListener(new 2(this));
    }

    protected final void initView() {
        super.initView();
        a(1, getString(i.app_ok), new 3(this), b.tmX);
        Wp();
        this.lbw.setOnContactDeselectListener(this);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (AASelectContactUI.this.eCr == null || AASelectContactUI.this.eCr.size() <= 0 || ((long) AASelectContactUI.this.eCr.size()) > AASelectContactUI.this.eCs || (AASelectContactUI.this.eCr.size() == 1 && AASelectContactUI.this.eCr.contains(q.GF()))) {
                    AASelectContactUI.this.finish();
                } else {
                    com.tencent.mm.ui.base.h.a(AASelectContactUI.this, AASelectContactUI.this.getString(i.aa_select_contact_back_confirm), null, AASelectContactUI.this.getString(i.aa_select_contact_save), AASelectContactUI.this.getString(i.aa_select_contact_not_save), false, new 1(this), new 2(this));
                }
                com.tencent.mm.plugin.report.service.h.mEJ.h(13721, Integer.valueOf(2), Integer.valueOf(7));
                return true;
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bi.oW(stringExtra)) {
            this.eCq.addAll(bi.F(stringExtra.split(",")));
        }
    }

    protected final boolean Wk() {
        return false;
    }

    protected final boolean Wl() {
        return false;
    }

    protected final String Wm() {
        return this.title;
    }

    protected final o Wn() {
        return new d(this, this.chatroomName);
    }

    protected final m Wo() {
        return new e(this, this.chatroomName);
    }

    public final void iV(int i) {
        n cyp = cyp();
        a FM = cyp.FM(i - getContentLV().getHeaderViewsCount());
        if (FM != null && FM.guS != null) {
            x.i("MicroMsg.AASelectContactUI", "ClickUser=%s", FM.guS.field_username);
            String str = FM.guS.field_username;
            if (str.equals(q.GF())) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(13721, Integer.valueOf(2), Integer.valueOf(4));
            } else {
                com.tencent.mm.plugin.report.service.h.mEJ.h(13721, Integer.valueOf(2), Integer.valueOf(5));
            }
            cyv();
            if (this.eCr.contains(str)) {
                this.eCr.remove(str);
            } else {
                this.eCr.add(str);
            }
            if (this.eCr.size() == h.pb(this.chatroomName).size()) {
                this.eCu.setChecked(true);
            } else {
                this.eCu.setChecked(false);
            }
            cyp.notifyDataSetChanged();
            Wp();
        }
    }

    public final boolean a(a aVar) {
        if (!aVar.ujX || aVar.guS == null) {
            return false;
        }
        return this.eCr.contains(aVar.guS.field_username);
    }

    public final boolean b(a aVar) {
        if (!aVar.ujX || aVar.guS == null) {
            return false;
        }
        return this.eCq.contains(aVar.guS.field_username);
    }

    private void Wp() {
        if (this.eCr.size() > 0) {
            updateOptionMenuText(1, getString(i.aa_confirm_num, new Object[]{Integer.valueOf(this.eCr.size())}));
        } else {
            updateOptionMenuText(1, getString(i.app_ok));
        }
        if (this.eCr.size() == 1 && this.eCr.contains(q.GF())) {
            enableOptionMenu(1, false);
        } else {
            enableOptionMenu(1, true);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public final void pf(String str) {
        this.eCr.remove(str);
        cyp().notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return g.aa_select_contact_ui;
    }
}
