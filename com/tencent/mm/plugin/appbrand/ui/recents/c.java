package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.ui.recents.h.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

final class c extends h implements a {
    ViewGroup goL;
    private List<h> gzs;
    private final a gzt;

    c(Activity activity, ViewGroup viewGroup) {
        if (activity == null || viewGroup == null) {
            throw new IllegalStateException("Unexpected parameters");
        }
        this.gzt = new a(this, activity, (byte) 0);
        ViewGroup linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        this.goL = linearLayout;
        linearLayout = this.goL;
        List arrayList = new ArrayList(2);
        e eVar = new e(activity, linearLayout);
        eVar.gAw = this;
        arrayList.add(eVar);
        f fVar = new f(activity, linearLayout);
        fVar.gAw = this;
        arrayList.add(fVar);
        this.gzs = arrayList;
        a(this.gzs, this.goL);
        aq(this.gzs);
    }

    private void a(List<h> list, ViewGroup viewGroup) {
        if (list != null && list.size() != 0 && viewGroup != null) {
            View view;
            for (int i = 0; i < list.size(); i++) {
                viewGroup.addView(((h) list.get(i)).aoh());
                if (i != list.size() - 1) {
                    view = new View(viewGroup.getContext());
                    view.setBackgroundColor(-1);
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(this.gzt.gzv, this.gzt.gzu);
                    layoutParams.gravity = 3;
                    viewGroup.addView(view, layoutParams);
                }
            }
            Context context = viewGroup.getContext();
            Drawable colorDrawable = new ColorDrawable(this.gzt.gzy);
            view = new ImageView(context);
            view.setImageDrawable(colorDrawable);
            view.setBackgroundColor(-1);
            LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, this.gzt.gzz);
            viewGroup.addView(view, 0, layoutParams2);
            View imageView = new ImageView(context);
            imageView.setImageDrawable(colorDrawable);
            imageView.setBackgroundColor(-1);
            viewGroup.addView(imageView, layoutParams2);
            viewGroup.addView(new View(context), -1, this.gzt.gzx);
            imageView = new ImageView(context);
            imageView.setImageDrawable(colorDrawable);
            imageView.setBackgroundColor(-1);
            viewGroup.addView(imageView, -1, this.gzt.gzz);
        }
    }

    private static void aq(List<h> list) {
        if (list != null) {
            for (h df : list) {
                df.df(false);
            }
        }
    }

    final void aog() {
        for (h aog : this.gzs) {
            aog.aog();
        }
    }

    final void onDetached() {
        for (h onDetached : this.gzs) {
            onDetached.onDetached();
        }
    }

    final void onResume() {
        for (h onResume : this.gzs) {
            onResume.onResume();
        }
    }

    final View aoh() {
        return this.goL;
    }

    public final void a(h hVar, View view, boolean z) {
        if (this.goL != null) {
            h hVar2;
            View childAt;
            int i;
            x.i("AppBrandLauncherRecentsListHeaderController", "onViewEnabledChanged [%s] [%s] [%b]", new Object[]{hVar, view, Boolean.valueOf(z)});
            if (!(this.goL == null || this.gzs == null)) {
                for (int i2 = 0; i2 < this.gzs.size() - 1; i2++) {
                    hVar2 = (h) this.gzs.get(i2);
                    if (hVar2 != null) {
                        if (hVar2.aol()) {
                            int i3 = i2 + 1;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= this.gzs.size()) {
                                    i3 = 0;
                                    break;
                                }
                                h hVar3 = (h) this.gzs.get(i4);
                                if (hVar3 != null && hVar3.aol()) {
                                    i3 = 1;
                                    break;
                                }
                                i3 = i4 + 1;
                            }
                            if (i3 != 0) {
                                childAt = this.goL.getChildAt(this.goL.indexOfChild(hVar2.aoh()) + 1);
                                if (childAt != null) {
                                    childAt.setVisibility(0);
                                }
                            }
                        } else {
                            childAt = this.goL.getChildAt(this.goL.indexOfChild(hVar2.aoh()) + 1);
                            if (childAt != null) {
                                childAt.setVisibility(8);
                            }
                        }
                    }
                }
            }
            for (h hVar22 : this.gzs) {
                childAt = hVar22.aoh();
                if (childAt != null && childAt.getVisibility() == 0) {
                    x.i("AppBrandLauncherRecentsListHeaderController", "hasValidHeader %s", new Object[]{hVar});
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (i != 0) {
                this.goL.setVisibility(0);
            } else {
                this.goL.setVisibility(8);
            }
        }
    }
}
