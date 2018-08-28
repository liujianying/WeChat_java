package com.tencent.mm.plugin.sight.draft.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.w.a.b;
import com.tencent.mm.w.a.g;

class b$a implements OnClickListener {
    final /* synthetic */ b neG;

    private b$a(b bVar) {
        this.neG = bVar;
    }

    /* synthetic */ b$a(b bVar, byte b) {
        this(bVar);
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof b$e) {
            b$e b_e = (b$e) view.getTag();
            if (b_e.neN == null) {
                x.i("MicroMsg.SightDraftContainerAdapter", "click draft, but info null, curType %s", new Object[]{b.b(this.neG)});
                bwe();
                b.a(this.neG, null);
                return;
            }
            if (b.c(this.neG) != b_e) {
                bwe();
                String nB = k.nB(b_e.neN.field_fileName);
                b_e.neL.setCanPlay(true);
                b_e.neL.aO(nB, false);
                b_e.jez.setBackgroundResource(R.g.sight_draft_mask_selected);
                View view2 = b_e.neK;
                if (!(view2 == null || d.fS(11))) {
                    Animator animator = (Animator) view2.getTag(g.property_anim);
                    if (animator != null) {
                        animator.cancel();
                    }
                    AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(view2.getContext(), b.fast_zoom_in_property_anim);
                    animatorSet.setTarget(view2);
                    animatorSet.start();
                    view2.setTag(g.property_anim, animatorSet);
                }
                b.b(this.neG, b_e);
                b.a(this.neG, b_e);
            }
            if (b.d(this.neG) != null) {
                b.d(this.neG).bwc();
            }
        }
    }

    public final boolean bwe() {
        if (b.c(this.neG) == null) {
            return false;
        }
        b.c(this.neG).gmo.setVisibility(8);
        b.c(this.neG).neL.setCanPlay(false);
        b.c(this.neG).neL.aO(null, false);
        b.c(this.neG).neL.setThumbBmp(b.e(this.neG).o(b.c(this.neG).neN.field_fileName, k.nC(b.c(this.neG).neN.field_fileName), true));
        b.c(this.neG).jez.setBackgroundResource(R.g.sight_draft_mask);
        i.m(b.c(this.neG).neK, 1.0f);
        b.a(this.neG, null);
        return true;
    }
}
