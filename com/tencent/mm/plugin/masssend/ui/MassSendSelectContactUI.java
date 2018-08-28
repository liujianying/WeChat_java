package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.c;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MassSendSelectContactUI extends MMBaseSelectContactUI {
    private HashSet<String> eCr;
    private List<String> gRN;
    private Button lbu;
    private boolean lbv;
    private MultiSelectContactView lbw;

    protected final void Wj() {
        super.Wj();
        this.gRN = new ArrayList();
        this.gRN.addAll(s.cyz());
        this.gRN.addAll(s.cyA());
        this.gRN.add(q.GF());
        this.eCr = new HashSet();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.MassSendSelectContactUI", "create!");
        this.lbw = this.lbw;
        if (this.lbw == null) {
            finish();
            return;
        }
        this.lbw.setBackgroundDrawable(null);
        a(1, getString(R.l.mass_send_next), new 1(this), b.tmX);
        this.lbu = (Button) findViewById(R.h.select_all);
        this.lbu.setOnClickListener(new 2(this));
        this.lbw.setOnContactDeselectListener(new 3(this));
        sv(this.eCr.size());
    }

    private void sv(int i) {
        if (i > 0) {
            updateOptionMenuText(1, getString(R.l.mass_send_next) + "(" + this.eCr.size() + ")");
            enableOptionMenu(1, true);
            return;
        }
        updateOptionMenuText(1, getString(R.l.mass_send_next));
        enableOptionMenu(1, false);
    }

    protected final void Gr(String str) {
        h.mEJ.h(11225, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
        Intent intent = new Intent();
        intent.putExtra("label", str);
        intent.putExtra("always_select_contact", bi.c(new ArrayList(this.eCr), ","));
        intent.putExtra("list_attr", s.s(new int[]{16384, 64}));
        d.b(this, ".ui.contact.SelectLabelContactUI", intent, 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.MassSendSelectContactUI", "requestCode=%d | resultCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 0:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    if (bi.oW(stringExtra)) {
                        x.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
                        return;
                    }
                    x.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS select username=%s", new Object[]{stringExtra});
                    String[] split = stringExtra.split(",");
                    int length = split.length;
                    while (i3 < length) {
                        String str = split[i3];
                        if (this.eCr.add(str)) {
                            this.lbw.Ty(str);
                        }
                        i3++;
                    }
                    sv(this.eCr.size());
                    cyp().notifyDataSetChanged();
                    if (this.eMS != null) {
                        this.eMS.clearFocus();
                        this.eMS.czQ();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.mass_send_select_contact;
    }

    public final void iV(int i) {
        n cyp = cyp();
        a FM = cyp.getItem(i - getContentLV().getHeaderViewsCount());
        if (FM != null && FM.guS != null) {
            x.i("MicroMsg.MassSendSelectContactUI", "ClickUser=%s", new Object[]{FM.guS.field_username});
            String str = FM.guS.field_username;
            cyv();
            if (this.eCr.contains(str)) {
                this.eCr.remove(str);
                this.lbw.Ty(str);
            } else {
                this.eCr.add(str);
                this.lbw.Ty(str);
            }
            sv(this.eCr.size());
            cyp.notifyDataSetChanged();
            cyv();
            cyw();
        }
    }

    protected final boolean Wk() {
        return false;
    }

    protected final boolean Wl() {
        return true;
    }

    protected final String Wm() {
        return getString(R.l.mass_send_select_contact_title);
    }

    protected final o Wn() {
        c.a aVar = new c.a();
        aVar.uhW = true;
        return new c(this, this.gRN, true, aVar);
    }

    protected final m Wo() {
        return new com.tencent.mm.ui.contact.q(this, this.gRN, true, this.scene);
    }

    public final boolean a(a aVar) {
        if (!aVar.ujX || aVar.guS == null) {
            return false;
        }
        return this.eCr.contains(aVar.guS.field_username);
    }

    public final int[] bbG() {
        return new int[]{131072};
    }

    protected final boolean bcN() {
        return true;
    }
}
