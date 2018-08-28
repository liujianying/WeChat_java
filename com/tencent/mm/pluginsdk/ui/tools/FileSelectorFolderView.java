package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

public class FileSelectorFolderView extends LinearLayout implements OnItemClickListener {
    boolean Ld = false;
    private FrameLayout jDi;
    private View jDj;
    private ListView jDk;
    private boolean jDm = false;
    private a qSl = null;
    private b qSm;

    public FileSelectorFolderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FileSelectorFolderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    final void fk(boolean z) {
        Animation loadAnimation;
        if (this.Ld == z) {
            x.d("MicroMsg.FileSelectorFolderView", "want to expand, but same status, expanded %B", new Object[]{Boolean.valueOf(this.Ld)});
        } else if (this.jDm) {
            x.d("MicroMsg.FileSelectorFolderView", "want to expand[%B], but now in animation", new Object[]{Boolean.valueOf(z)});
        } else if (this.Ld) {
            this.jDm = true;
            loadAnimation = AnimationUtils.loadAnimation(getContext(), R.a.push_down_out);
            loadAnimation.setAnimationListener(new 1(this));
            this.jDk.startAnimation(loadAnimation);
            this.jDj.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.fast_faded_out));
        } else {
            this.jDm = true;
            this.jDi.setVisibility(0);
            this.jDj.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.fast_faded_in));
            loadAnimation = AnimationUtils.loadAnimation(getContext(), R.a.push_up_in);
            loadAnimation.setAnimationListener(new 2(this));
            this.jDk.startAnimation(loadAnimation);
        }
    }

    private void init() {
        setOrientation(1);
        this.jDi = new FrameLayout(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.jDi.setVisibility(8);
        addView(this.jDi, layoutParams);
        this.jDj = new View(getContext());
        this.jDj.setBackgroundColor(-872415232);
        this.jDj.setOnClickListener(new 3(this));
        this.jDi.addView(this.jDj, new FrameLayout.LayoutParams(-1, -1));
        this.jDk = new ListView(getContext());
        this.jDk.setCacheColorHint(0);
        this.jDk.setBackgroundResource(R.e.navpage);
        this.jDk.setSelector(R.g.mm_trans);
        this.jDk.setOnItemClickListener(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.NormalPadding);
        this.jDk.setPadding(dimensionPixelSize, dimensionPixelSize / 3, dimensionPixelSize, 0);
        layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
        layoutParams.gravity = 80;
        this.jDi.addView(this.jDk, layoutParams);
        this.qSm = new b(getContext());
        this.jDk.setAdapter(this.qSm);
    }

    public void setListener(a aVar) {
        this.qSl = aVar;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.qSl != null) {
            this.qSl.Cw(i);
        }
        this.jDj.performClick();
    }
}
