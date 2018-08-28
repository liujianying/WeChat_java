package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.k.b;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.FavDetailFooterView;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.fav.ui.widget.FavDetailTitleView;
import com.tencent.mm.plugin.fav.ui.widget.FavTagEntrance;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.widget.MMLoadScrollView;

public class FavoriteTextDetailUI extends BaseFavDetailReportUI {
    private static final int jdu = b.Ax();
    private k contextMenuHelper;
    private g jcO;
    private FavDetailTitleView jdc;
    private FavDetailFooterView jdd;
    private FavTagEntrance jde;
    private long jdk;
    private TextView jdv;
    private ClipboardManager jdw;
    private g jdx;
    private d jdy = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 1:
                    if (FavoriteTextDetailUI.this.jdw != null && FavoriteTextDetailUI.this.jcO != null && FavoriteTextDetailUI.this.jcO.field_favProto != null) {
                        FavoriteTextDetailUI.this.jdw.setText(FavoriteTextDetailUI.this.jcO.field_favProto.desc);
                        h.bA(FavoriteTextDetailUI.this.mController.tml, FavoriteTextDetailUI.this.mController.tml.getString(i.app_copy_ok));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    protected final int getLayoutId() {
        return f.favorite_text_detail_ui;
    }

    protected final MMLoadScrollView aMI() {
        return (MMLoadScrollView) findViewById(e.scroll_view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jdv = (TextView) findViewById(e.chat_fav_text_tv);
        this.jdc = (FavDetailTitleView) findViewById(e.fav_detail_title);
        this.jdd = (FavDetailFooterView) findViewById(e.fav_detail_footer);
        this.jde = (FavTagEntrance) findViewById(e.fav_tag_entrance);
        this.jdw = (ClipboardManager) getSystemService("clipboard");
        this.jdk = getIntent().getLongExtra("key_detail_info_id", -1);
        com.tencent.mm.pluginsdk.wallet.i.Cx(5);
        this.contextMenuHelper = new k(this.mController.tml);
        this.contextMenuHelper.a(this.jdv, this, this.jdy);
        setMMTitle(getString(i.favorite_detail));
        setBackBtn(new 1(this));
        addIconOptionMenu(0, i.top_item_desc_more, m.d.mm_title_btn_menu, new 2(this));
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().c(this.jde);
    }

    protected void onDestroy() {
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().d(this.jde);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        aMQ();
    }

    protected void onPause() {
        super.onPause();
    }

    private void aMQ() {
        this.jcO = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(this.jdk);
        F(this.jcO);
        if (this.jcO == null || this.jcO.field_favProto == null) {
            x.w("MicroMsg.FavoriteTextDetailUI", "id[%d] info is null, return", new Object[]{Long.valueOf(this.jdk)});
            return;
        }
        this.jde.setFavItemID(this.jcO.field_localId);
        this.jde.setTagContent(this.jcO.field_tagProto.rBX);
        if (this.jdx == null || this.jdx.field_edittime != this.jcO.field_edittime) {
            this.jdx = this.jcO;
            this.jdc.D(this.jcO);
            this.jdd.D(this.jcO);
            this.jdv.setText(this.jcO.field_favProto.desc);
            j.g(this.jdv, 1);
            return;
        }
        x.w("MicroMsg.FavoriteTextDetailUI", "not change, return");
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, getString(i.app_copy));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1 == i && -1 == i2) {
            h.bA(this.mController.tml, getString(i.app_saved));
            new ag().postDelayed(new 4(this), 250);
            return;
        }
        super.onActivityResult(i, i2, intent);
    }
}
