package com.tencent.mm.plugin.fav.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.c.a;

public class FavTipsUI extends MMBaseActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = new a(this);
        aVar.abt(getString(i.favorite_intro_title));
        aVar.abu(getString(i.favorite_intro_p_1) + "\n\n" + getString(i.favorite_intro_p_2));
        aVar.Gt(i.favorite_intro_btn).a(new 1(this));
        aVar.e(new 2(this));
        aVar.anj().show();
    }
}
