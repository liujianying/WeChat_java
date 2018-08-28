package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.k;

class FavoriteVideoPlayUI$2 implements OnLongClickListener {
    final /* synthetic */ FavoriteVideoPlayUI jdN;

    FavoriteVideoPlayUI$2(FavoriteVideoPlayUI favoriteVideoPlayUI) {
        this.jdN = favoriteVideoPlayUI;
    }

    public final boolean onLongClick(View view) {
        view.getTag();
        k kVar = new k(this.jdN.mController.tml);
        kVar.ofp = new 1(this);
        kVar.ofq = new d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        Intent intent = new Intent();
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("select_is_ret", true);
                        intent.putExtra("mutil_select_is_ret", true);
                        if (e.cn(FavoriteVideoPlayUI.b(FavoriteVideoPlayUI$2.this.jdN))) {
                            intent.putExtra("image_path", FavoriteVideoPlayUI.b(FavoriteVideoPlayUI$2.this.jdN));
                        } else {
                            intent.putExtra("image_path", FavoriteVideoPlayUI.c(FavoriteVideoPlayUI$2.this.jdN));
                        }
                        intent.putExtra("Retr_Msg_Type", 1);
                        com.tencent.mm.bg.d.b(FavoriteVideoPlayUI$2.this.jdN.mController.tml, ".ui.transmit.SelectConversationUI", intent, 1);
                        if (FavoriteVideoPlayUI.d(FavoriteVideoPlayUI$2.this.jdN) == 0) {
                            h.f(FavoriteVideoPlayUI$2.this.jdN.getIntent().getLongExtra("key_detail_info_id", 0), 1, 0);
                            return;
                        }
                        return;
                    case 2:
                        FavoriteVideoPlayUI.f(FavoriteVideoPlayUI.c(FavoriteVideoPlayUI$2.this.jdN), FavoriteVideoPlayUI$2.this.jdN);
                        return;
                    default:
                        return;
                }
            }
        };
        kVar.bEo();
        return true;
    }
}
