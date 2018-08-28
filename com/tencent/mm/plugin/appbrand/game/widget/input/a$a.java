package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.s$g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.widget.input.u.a;

final class a$a extends FrameLayout implements a {
    private View fDw;

    public final View getConfirmButton() {
        if (this.fDw == null) {
            this.fDw = findViewById(s$g.game_edit_send);
        }
        return this.fDw;
    }

    public a$a(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(h.app_brand_game_input_panel_edit_bar, this, true);
        ((Button) findViewById(s$g.game_edit_send)).setText(j.appbrand_game_input_confirm);
    }

    public final void setIsHide(boolean z) {
        setVisibility(z ? 8 : 0);
    }
}
