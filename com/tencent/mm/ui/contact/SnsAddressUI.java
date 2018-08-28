package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsAddressUI extends MMBaseSelectContactUI {
    private HashSet<String> eCr;
    private List<String> gRN;

    protected final void Wj() {
        super.Wj();
        this.gRN = new ArrayList();
        Collection F = bi.F(bi.aG(getIntent().getStringExtra("Block_list"), "").split(","));
        Collection cyz = s.cyz();
        cyz.addAll(F);
        this.gRN.addAll(cyz);
        this.gRN.addAll(s.cyA());
        this.eCr = new HashSet();
        String aG = bi.aG(getIntent().getStringExtra("Select_Contact"), "");
        if (!bi.oW(aG)) {
            this.eCr.addAll(bi.F(aG.split(",")));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.SnsAddressUI", "Create!");
        a(1, getString(R.l.app_ok), new 1(this), b.tmX);
        setBackBtn(new 2(this));
        Iterator it = this.eCr.iterator();
        while (it.hasNext()) {
            this.lbw.Ty((String) it.next());
        }
        this.lbw.setOnContactDeselectListener(new 3(this));
        Wp();
    }

    public final void iV(int i) {
        n cyp = cyp();
        a FM = cyp.FM(i - getContentLV().getHeaderViewsCount());
        if (FM != null && FM.guS != null) {
            x.i("MicroMsg.SnsAddressUI", "ClickUser=%s", new Object[]{FM.guS.field_username});
            String str = FM.guS.field_username;
            cyv();
            if (this.eCr.contains(str)) {
                this.eCr.remove(str);
                this.lbw.Ty(str);
            } else if (this.eCr.size() < z.sOr) {
                this.eCr.add(str);
                this.lbw.Ty(str);
            } else {
                Toast.makeText(this, R.l.sns_max_select_at, 0).show();
                x.i("MicroMsg.SnsAddressUI", "select user size equal max size:%d", new Object[]{Integer.valueOf(z.sOr)});
            }
            Wp();
            cyp.notifyDataSetChanged();
        }
    }

    protected final boolean Wk() {
        return false;
    }

    protected final boolean Wl() {
        return true;
    }

    protected final String Wm() {
        return bi.aG(getIntent().getStringExtra("Add_address_titile"), "");
    }

    protected final o Wn() {
        c.a aVar = new c.a();
        aVar.uhW = true;
        aVar.uie = true;
        aVar.uig = getString(R.l.address_near_contact_catalog_name);
        aVar.uif = bi.aG(getIntent().getStringExtra("Add_get_from_sns"), "");
        aVar.ugF = "@all.contact.without.chatroom.without.openim";
        return new c(this, this.gRN, true, aVar);
    }

    protected final m Wo() {
        return new q(this, this.gRN, true, this.scene);
    }

    private void Wp() {
        String format;
        boolean z;
        if (this.eCr.size() == 0) {
            format = String.format("%s", new Object[]{getString(R.l.app_ok)});
        } else {
            format = String.format("%s(%d/%d)", new Object[]{getString(R.l.app_ok), Integer.valueOf(this.eCr.size()), Integer.valueOf(z.sOr)});
        }
        updateOptionMenuText(1, format);
        if (this.eCr.size() >= 0) {
            z = true;
        } else {
            z = false;
        }
        enableOptionMenu(1, z);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 3:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    if (bi.oW(stringExtra)) {
                        x.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS return usernames is null or empty");
                        return;
                    }
                    x.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS select username=%s", new Object[]{stringExtra});
                    String[] split = stringExtra.split(",");
                    int length = split.length;
                    while (i3 < length) {
                        String str = split[i3];
                        if (this.eCr.add(str)) {
                            this.lbw.Ty(str);
                        }
                        i3++;
                    }
                    Wp();
                    cyp().notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        }
    }

    protected final boolean bcN() {
        return true;
    }

    protected final void Gr(String str) {
        Intent intent = new Intent();
        intent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
        intent.putExtra("label", str);
        Collection hashSet = new HashSet();
        hashSet.addAll(this.eCr);
        intent.putExtra("always_select_contact", bi.c(new ArrayList(hashSet), ","));
        intent.putExtra("list_attr", s.s(16384, 64));
        startActivityForResult(intent, 3);
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

    public final void pf(String str) {
        this.eCr.remove(str);
        cyp().notifyDataSetChanged();
        Wp();
    }
}
