package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.b.a;

public class GameIndexSearchView extends LinearLayout {
    LayoutInflater Bc = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameIndexSearchView$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ int jUG;

        AnonymousClass1(int i) {
            this.jUG = i;
        }

        public final void onClick(View view) {
            int r;
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                a aTv = b.aTv();
                if (aTv.bWA == 2) {
                    r = c.r(GameIndexSearchView.this.mContext, aTv.url, "game_center_msgcenter");
                } else {
                    Intent intent = new Intent(GameIndexSearchView.this.mContext, GameSearchUI.class);
                    intent.putExtra("game_report_from_scene", 1001);
                    GameIndexSearchView.this.mContext.startActivity(intent);
                    r = 6;
                }
            } else {
                r = c.r(GameIndexSearchView.this.mContext, (String) view.getTag(), "game_center_msgcenter");
            }
            an.a(GameIndexSearchView.this.mContext, 14, 1401, 1, r, 0, null, this.jUG, 0, null, null, null);
        }
    }

    public GameIndexSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        this.mContext = context;
    }
}
