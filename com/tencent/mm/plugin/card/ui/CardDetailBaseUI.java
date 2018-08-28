package com.tencent.mm.plugin.card.ui;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a$a;
import com.tencent.mm.plugin.card.a$e;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.ui.y;

public abstract class CardDetailBaseUI extends DrawStatusBarActivity {
    private TextView gsY;
    private View gxg;
    private ImageView hBu;
    private TextView hBv;
    ImageView hBw;
    private View hBx;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gxg = y.gq(this.mController.tml).inflate(a$e.card_detail_action_bar, null);
        this.gxg.setBackgroundColor(getResources().getColor(a$a.action_bar_color));
        this.gsY = (TextView) this.gxg.findViewById(d.title_area);
        this.hBv = (TextView) this.gxg.findViewById(d.sub_title_area);
        this.hBu = (ImageView) this.gxg.findViewById(d.arrow_area_btn);
        this.hBw = (ImageView) this.gxg.findViewById(d.menu_icon);
        this.hBx = this.gxg.findViewById(d.divider);
        if (this.mController.contentView != null && ((ViewGroup) this.mController.contentView).getChildCount() > 0) {
            View childAt = ((ViewGroup) this.mController.contentView).getChildAt(0);
            ((ViewGroup) this.mController.contentView).removeView(childAt);
            View linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new LayoutParams(-1, -1));
            linearLayout.setOrientation(1);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            linearLayout.addView(this.gxg, new LinearLayout.LayoutParams(-1, displayMetrics.widthPixels > displayMetrics.heightPixels ? getResources().getDimensionPixelSize(b.DefaultActionbarHeightLand) : getResources().getDimensionPixelSize(b.DefaultActionbarHeightPort)));
            linearLayout.addView(childAt);
            ((ViewGroup) this.mController.contentView).addView(linearLayout);
        }
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        this.hBu.setOnClickListener(new 1(this, onMenuItemClickListener));
    }

    public final void setMMTitle(String str) {
        this.gsY.setText(str);
    }

    public final void nS(int i) {
        this.gsY.setTextColor(i);
    }

    public final void setMMSubTitle(String str) {
        this.hBv.setText(str);
    }

    public final void G(int i, boolean z) {
        this.gxg.setBackgroundColor(i);
        if (z) {
            this.gsY.setTextColor(getResources().getColor(a$a.black));
            this.hBv.setTextColor(getResources().getColor(a$a.black));
            this.hBu.setImageResource(f.actionbar_icon_dark_back);
            this.hBw.setImageResource(c.card_mm_title_btn_menu);
            this.hBx.setBackgroundColor(getResources().getColor(a$a.actionbar_devider_color));
            return;
        }
        this.gsY.setTextColor(getResources().getColor(a$a.white));
        this.hBv.setTextColor(getResources().getColor(a$a.white));
        this.hBu.setImageResource(f.actionbar_icon_dark_back);
        this.hBw.setImageResource(c.mm_title_btn_menu);
        this.hBx.setBackgroundColor(getResources().getColor(a$a.half_alpha_white));
    }

    public final void dQ(boolean z) {
        this.hBw.setVisibility(z ? 0 : 8);
    }

    public final boolean noActionBar() {
        return false;
    }
}
