package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.ui.a.b;
import com.tencent.mm.plugin.fav.ui.d.a;
import com.tencent.mm.plugin.fav.ui.m.d;
import com.tencent.mm.plugin.fav.ui.m.h;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public class FavSelectUI extends FavBaseUI {
    private String jac;
    private b jad = null;
    private Set<Integer> jae = new HashSet();
    private k jaf = new k();
    private String toUser;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.toUser = getIntent().getStringExtra("key_to_user");
        this.jac = getIntent().getStringExtra("key_fav_item_id");
        if (this.jac != null) {
            for (String str : this.jac.split(",")) {
                int i = bi.getInt(str, Integer.MAX_VALUE);
                if (Integer.MAX_VALUE != i) {
                    this.jae.add(Integer.valueOf(i));
                }
            }
        }
        this.jae.remove(Integer.valueOf(3));
        this.jad.g(this.jae);
        this.jaf.iWc = false;
        this.jad.a(this.jaf);
        this.iYd.post(new 1(this));
        addIconOptionMenu(0, h.actionbar_icon_dark_search, new 2(this));
        setMMTitle(i.favorite_select_title);
        setBackBtn(new 3(this));
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a.b bVar = (a.b) view.getTag();
        if (bVar == null) {
            x.w("MicroMsg.FavSelectUI", "on item click, holder is null");
        } else if (bVar.iWQ == null) {
            x.w("MicroMsg.FavSelectUI", "on item click, info is null");
        } else {
            g gVar = bVar.iWQ;
            com.tencent.mm.plugin.fav.a.h.f(gVar.field_localId, 1, 1);
            if (gVar.field_type == 3) {
                com.tencent.mm.ui.widget.snackbar.b.h(this, getString(i.Fav_Voice_CannotForward));
            } else if (gVar.field_type == 8 && s.hf(this.toUser)) {
                com.tencent.mm.ui.widget.snackbar.b.h(this, getString(i.Fav_File_CannotForward));
            } else {
                ((ab) com.tencent.mm.kernel.g.l(ab.class)).a(this.mController.tml, this.toUser, bVar.iWQ, i.app_send, true, new 4(this, bVar));
            }
        }
    }

    public final com.tencent.mm.plugin.fav.ui.a.a aMc() {
        if (this.jad == null) {
            ActionBarActivity actionBarActivity = this.mController.tml;
            this.jad = new b(this.iYh, false);
        }
        return this.jad;
    }

    protected final void aMd() {
    }

    protected final boolean aMe() {
        return ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().getCount() > 0;
    }

    protected final void aMf() {
        this.iYb.setCompoundDrawablesWithIntrinsicBounds(0, d.favorites_empty_favorites_icon, 0, 0);
        this.iYb.setCompoundDrawablePadding(com.tencent.mm.bp.a.fromDPToPix(this.mController.tml, 10));
        this.iYb.setText(i.favorite_empty_fav);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && -1 == i2) {
            finish();
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.jad != null) {
            this.jad.finish();
        }
    }
}
