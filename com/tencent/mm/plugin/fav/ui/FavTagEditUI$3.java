package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.Serializable;
import java.util.Iterator;

class FavTagEditUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ FavTagEditUI jaA;
    final /* synthetic */ long jaB;

    FavTagEditUI$3(FavTagEditUI favTagEditUI, long j) {
        this.jaA = favTagEditUI;
        this.jaB = j;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (FavTagEditUI.b(this.jaA)) {
            FavTagEditUI.c(this.jaA);
        } else {
            Serializable tagList = FavTagEditUI.d(this.jaA).getTagList();
            String trim = FavTagEditUI.d(this.jaA).getEditText().trim();
            if (!bi.oW(trim)) {
                tagList.remove(trim);
                tagList.add(trim);
            }
            FavTagEditUI.a(this.jaA, ((ae) g.n(ae.class)).getFavItemInfoStorage().dy(this.jaB));
            Intent intent;
            if (FavTagEditUI.e(this.jaA) != null) {
                FavTagEditUI.a(FavTagEditUI.e(this.jaA), tagList, this.jaA.getIntent().getIntExtra("key_fav_scene", 1));
                intent = new Intent();
                intent.putExtra("key_fav_result_list", tagList);
                this.jaA.setResult(-1, intent);
            } else {
                String[] strArr = new String[tagList.size()];
                Iterator it = tagList.iterator();
                int i = 0;
                while (it.hasNext()) {
                    int i2 = i + 1;
                    strArr[i] = (String) it.next();
                    i = i2;
                }
                intent = new Intent();
                intent.putExtra("key_fav_result_array", strArr);
                intent.putExtra("key_fav_result_list", tagList);
                this.jaA.setResult(-1, intent);
            }
            this.jaA.finish();
            this.jaA.YC();
        }
        return true;
    }
}
