package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;

public class GameMenuImageButton extends LinearLayout {
    private ImageView bOA;
    public boolean qgp;

    public GameMenuImageButton(Context context) {
        super(context);
        co(context);
    }

    public GameMenuImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        co(context);
    }

    public GameMenuImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        co(context);
    }

    private void co(Context context) {
        this.bOA = new ImageView(context);
        this.bOA.setLayoutParams(new LayoutParams(a.ae(context, R.f.game_menu_button_size), a.ae(context, R.f.game_menu_button_size)));
        this.bOA.setScaleType(ScaleType.FIT_CENTER);
        this.bOA.setImageResource(R.g.game_menu_btn_icon);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, a.ae(context, R.f.game_menu_button_margin), a.ae(context, R.f.game_menu_button_margin), 0);
        addView(this.bOA, layoutParams);
    }

    public final void a(FrameLayout frameLayout, final a aVar) {
        if (getParent() == null && frameLayout != null) {
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            frameLayout.addView(this, layoutParams);
        }
        if (this.bOA != null) {
            this.bOA.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (aVar != null) {
                        aVar.aTd();
                    }
                }
            });
        }
        this.qgp = true;
    }
}
