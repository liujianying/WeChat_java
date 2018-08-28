package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import java.util.ArrayList;
import java.util.List;

public class GameDetailAutoScrollView extends LinearLayout {
    private int irJ = 0;
    private al jUl = new al(new a() {
        public final boolean vD() {
            GameDetailAutoScrollView.a(GameDetailAutoScrollView.this);
            return true;
        }
    }, true);
    private ArrayList<String> jVK = new ArrayList();
    private ViewGroup jVL;
    private TextView jVM;
    private TextView jVN;
    private ViewGroup jVO;
    private TextView jVP;
    private TextView jVQ;
    private Animation jVR;
    private Animation jVS;

    static /* synthetic */ void a(GameDetailAutoScrollView gameDetailAutoScrollView) {
        if (gameDetailAutoScrollView.irJ < (gameDetailAutoScrollView.jVK.size() / 2) - 1) {
            gameDetailAutoScrollView.irJ++;
        } else {
            gameDetailAutoScrollView.irJ = 0;
        }
        String str = (String) gameDetailAutoScrollView.jVK.get((gameDetailAutoScrollView.irJ * 2) + 1);
        gameDetailAutoScrollView.jVP.setText(j.a(gameDetailAutoScrollView.getContext(), (String) gameDetailAutoScrollView.jVK.get(gameDetailAutoScrollView.irJ * 2), gameDetailAutoScrollView.jVP.getTextSize()));
        gameDetailAutoScrollView.jVQ.setText(str);
        gameDetailAutoScrollView.jVL.startAnimation(gameDetailAutoScrollView.jVS);
        gameDetailAutoScrollView.jVL.setVisibility(8);
        gameDetailAutoScrollView.jVO.startAnimation(gameDetailAutoScrollView.jVR);
        gameDetailAutoScrollView.jVO.setVisibility(0);
        ViewGroup viewGroup = gameDetailAutoScrollView.jVL;
        gameDetailAutoScrollView.jVL = gameDetailAutoScrollView.jVO;
        gameDetailAutoScrollView.jVO = viewGroup;
        TextView textView = gameDetailAutoScrollView.jVM;
        gameDetailAutoScrollView.jVM = gameDetailAutoScrollView.jVP;
        gameDetailAutoScrollView.jVP = textView;
        textView = gameDetailAutoScrollView.jVN;
        gameDetailAutoScrollView.jVN = gameDetailAutoScrollView.jVQ;
        gameDetailAutoScrollView.jVQ = textView;
    }

    public GameDetailAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jVL = (ViewGroup) LayoutInflater.from(context).inflate(f.game_detail2_brief_item, this, false);
        this.jVM = (TextView) this.jVL.findViewById(e.game_detail_brief_item_text1);
        this.jVN = (TextView) this.jVL.findViewById(e.game_detail_brief_item_text2);
        addView(this.jVL);
        this.jVL.setVisibility(8);
        this.jVO = (ViewGroup) LayoutInflater.from(context).inflate(f.game_detail2_brief_item, this, false);
        this.jVP = (TextView) this.jVO.findViewById(e.game_detail_brief_item_text1);
        this.jVQ = (TextView) this.jVO.findViewById(e.game_detail_brief_item_text2);
        addView(this.jVO);
        this.jVO.setVisibility(8);
        this.jVR = AnimationUtils.loadAnimation(context, com.tencent.mm.plugin.game.f.a.slide_bottom_in);
        this.jVS = AnimationUtils.loadAnimation(context, com.tencent.mm.plugin.game.f.a.slide_top_out);
    }

    public void setText(List<String> list) {
        this.jVK.clear();
        this.jUl.SO();
        if (list == null || list.size() == 0 || list.size() % 2 != 0) {
            this.jVL.setVisibility(8);
            this.jVO.setVisibility(8);
            return;
        }
        this.jVK.addAll(list);
        this.irJ = 0;
        this.jVM.setText(j.a(getContext(), (CharSequence) this.jVK.get(0), this.jVM.getTextSize()));
        this.jVN.setText((CharSequence) this.jVK.get(1));
        this.jVL.setVisibility(0);
        this.jVO.setVisibility(8);
        if (this.jVK.size() / 2 != 1) {
            this.jUl.J(5000, 5000);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.jUl.SO();
    }
}
