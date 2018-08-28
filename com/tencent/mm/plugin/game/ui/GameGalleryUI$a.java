package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;

class GameGalleryUI$a extends u {
    private String[] jYJ = new String[0];
    private View[] jYK;
    Context mContext;

    public GameGalleryUI$a(Context context, String[] strArr) {
        this.mContext = context;
        if (strArr != null) {
            this.jYJ = strArr;
        }
        this.jYK = new View[this.jYJ.length];
    }

    public final Object b(ViewGroup viewGroup, int i) {
        View view = this.jYK[i];
        if (view == null) {
            View inflate = View.inflate(this.mContext, f.game_gallery_item, null);
            this.jYK[i] = inflate;
            ImageView imageView = (ImageView) inflate.findViewById(e.game_gallery_image);
            ProgressBar progressBar = (ProgressBar) inflate.findViewById(e.game_gallery_loading);
            progressBar.setVisibility(0);
            a Pj = o.Pj();
            String str = this.jYJ[i];
            c.a aVar = new c.a();
            aVar.dXx = true;
            Pj.a(str, imageView, aVar.Pt(), new 1(this, progressBar));
            view = inflate;
        }
        viewGroup.addView(view);
        view.setOnClickListener(new 2(this));
        return view;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final int getCount() {
        return this.jYJ.length;
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }
}
