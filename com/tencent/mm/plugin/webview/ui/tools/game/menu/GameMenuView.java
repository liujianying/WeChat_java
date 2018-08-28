package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;

public class GameMenuView extends LinearLayout {
    private LayoutInflater Bc;
    private Context mContext;
    private boolean qgI = false;
    private View qgN;
    private LinearLayout qgO;
    private LinearLayout qgP;
    private f qgQ;
    private c qgR;
    private a qgS;

    static /* synthetic */ void a(GameMenuView gameMenuView) {
        int count = gameMenuView.qgQ.getCount();
        if (count != 0) {
            View childAt;
            int fl = (gameMenuView.qgI ? com.tencent.mm.bp.a.fl(gameMenuView.mContext) : com.tencent.mm.bp.a.fk(gameMenuView.mContext)) - (com.tencent.mm.bp.a.ae(gameMenuView.mContext, R.f.game_menu_sheet_margin) * 2);
            int ae = com.tencent.mm.bp.a.ae(gameMenuView.mContext, R.f.game_menu_portrait_item_size);
            int ae2 = com.tencent.mm.bp.a.ae(gameMenuView.mContext, R.f.game_menu_landscape_item_size);
            f fVar = gameMenuView.qgQ;
            Object obj = (fVar.ofr == null || fVar.ofr.size() == 0) ? null : (fVar.ofr.size() + 1) / 2 > 4 ? 1 : null;
            int i = obj != null ? gameMenuView.qgI ? (int) (((((double) fl) - (0.375d * ((double) ae2))) - ((double) (ae2 * 4))) / 9.0d) : (int) (((((double) fl) - (0.5d * ((double) ae))) - ((double) (ae * 4))) / 9.0d) : gameMenuView.qgI ? (int) (((double) (fl - (ae2 * 4))) / 8.0d) : (int) (((double) (fl - (ae * 4))) / 8.0d);
            LayoutParams layoutParams = gameMenuView.qgI ? i > 0 ? new LinearLayout.LayoutParams(ae2, (i * 2) + ae2) : new LinearLayout.LayoutParams(ae2, ae2) : i > 0 ? new LinearLayout.LayoutParams((i * 2) + ae, ae) : new LinearLayout.LayoutParams(ae, ae);
            for (fl = 0; fl < count; fl++) {
                View view = gameMenuView.qgQ.getView(fl, null, gameMenuView.qgO);
                if (view != null) {
                    view.setOnClickListener(new 2(gameMenuView));
                    view.setLayoutParams(layoutParams);
                    if (fl % 2 == 0) {
                        gameMenuView.qgO.addView(view);
                    } else {
                        gameMenuView.qgP.addView(view);
                    }
                }
            }
            while (true) {
                i = gameMenuView.qgO.getChildCount();
                if (i <= 0) {
                    break;
                }
                childAt = gameMenuView.qgO.getChildAt(i - 1);
                if (childAt != null && childAt.getTag() != null) {
                    break;
                }
                gameMenuView.qgO.removeViewAt(i - 1);
            }
            while (true) {
                i = gameMenuView.qgP.getChildCount();
                if (i <= 0) {
                    break;
                }
                childAt = gameMenuView.qgP.getChildAt(i - 1);
                if (childAt != null && childAt.getTag() != null) {
                    break;
                }
                gameMenuView.qgP.removeViewAt(i - 1);
            }
            if (gameMenuView.qgO.getChildCount() == 0 && gameMenuView.qgP.getChildCount() == 0) {
                if (gameMenuView.qgS != null) {
                    gameMenuView.qgS.onDismiss();
                }
            } else if (gameMenuView.qgO.getChildCount() == 0) {
                ((ViewGroup) gameMenuView.qgO.getParent()).setVisibility(8);
            } else if (gameMenuView.qgP.getChildCount() == 0) {
                ((ViewGroup) gameMenuView.qgP.getParent()).setVisibility(8);
            }
        }
    }

    public GameMenuView(Context context) {
        boolean z = false;
        super(context, null);
        this.mContext = context;
        this.Bc = LayoutInflater.from(this.mContext);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            z = true;
        }
        this.qgI = z;
        initView();
    }

    public void setAdapter(f fVar) {
        this.qgQ = fVar;
        fVar.registerDataSetObserver(new 1(this));
        fVar.notifyDataSetChanged();
    }

    public GameMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View inflate;
        if (this.qgI) {
            setOrientation(0);
            this.Bc.inflate(R.i.game_menu_split_style_landscape, this, true);
            inflate = this.Bc.inflate(R.i.game_menu_layout_landscape, this, true);
        } else {
            setOrientation(1);
            this.Bc.inflate(R.i.game_menu_split_style_portrait, this, true);
            inflate = this.Bc.inflate(R.i.game_menu_layout_portrait, this, true);
        }
        this.qgN = inflate.findViewById(R.h.game_menu_layout);
        this.qgO = (LinearLayout) inflate.findViewById(R.h.game_menu_first_line);
        this.qgP = (LinearLayout) inflate.findViewById(R.h.game_menu_second_line);
    }

    public void setGameMenuItemSelectedListener(c cVar) {
        this.qgR = cVar;
    }

    public void setDismissListener(a aVar) {
        this.qgS = aVar;
    }
}
