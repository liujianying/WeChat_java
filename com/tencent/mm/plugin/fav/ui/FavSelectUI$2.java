package com.tencent.mm.plugin.fav.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.fav.a.b;

class FavSelectUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FavSelectUI jag;

    FavSelectUI$2(FavSelectUI favSelectUI) {
        this.jag = favSelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.putExtra("key_to_user", FavSelectUI.b(this.jag));
        intent.putExtra("key_fav_item_id", FavSelectUI.c(this.jag));
        intent.putExtra("key_search_type", 1);
        intent.putExtra("key_enter_fav_search_from", 1);
        Bundle bundle = null;
        if (VERSION.SDK_INT >= 21) {
            bundle = ActivityOptions.makeSceneTransitionAnimation(this.jag, new Pair[0]).toBundle();
        }
        b.a(this.jag.mController.tml, ".ui.FavSearchUI", intent, 0, bundle);
        return true;
    }
}
