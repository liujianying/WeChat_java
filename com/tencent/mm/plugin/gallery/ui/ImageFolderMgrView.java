package com.tencent.mm.plugin.gallery.ui;

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
import com.tencent.mm.plugin.gallery.model.GalleryItem$AlbumItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.g.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public class ImageFolderMgrView extends LinearLayout implements OnItemClickListener, a {
    boolean Ld = false;
    private a jDh = null;
    FrameLayout jDi;
    private View jDj;
    private ListView jDk;
    private b jDl;
    boolean jDm = false;

    public ImageFolderMgrView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
        this.jDk.setPadding(dimensionPixelSize, dimensionPixelSize / 3, dimensionPixelSize, (dimensionPixelSize * 2) / 3);
        layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
        layoutParams.gravity = 80;
        this.jDi.addView(this.jDk, layoutParams);
        this.jDl = new b(getContext(), c.aRf().aRJ());
        this.jDk.setAdapter(this.jDl);
    }

    public final void aRT() {
        fk(!this.Ld);
    }

    private void fk(boolean z) {
        Animation loadAnimation;
        if (this.Ld == z) {
            x.d("MicroMsg.ImageFolderMgrView", "want to expand, but same status, expanded %B", new Object[]{Boolean.valueOf(this.Ld)});
        } else if (this.jDm) {
            x.d("MicroMsg.ImageFolderMgrView", "want to expand[%B], but now in animation", new Object[]{Boolean.valueOf(z)});
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

    public void setListener(a aVar) {
        this.jDh = aVar;
    }

    public final void w(ArrayList<GalleryItem$AlbumItem> arrayList) {
        b bVar = this.jDl;
        bVar.jCO = arrayList;
        if (!(bVar.jCO == null || bVar.jCO.isEmpty() || ((GalleryItem$AlbumItem) bVar.jCO.get(0)).jAR == null)) {
            GalleryItem$AlbumItem galleryItem$AlbumItem;
            GalleryItem$AlbumItem galleryItem$AlbumItem2 = null;
            Iterator it = bVar.jCO.iterator();
            while (true) {
                galleryItem$AlbumItem = galleryItem$AlbumItem2;
                if (!it.hasNext()) {
                    break;
                }
                galleryItem$AlbumItem2 = (GalleryItem$AlbumItem) it.next();
                if (galleryItem$AlbumItem != null) {
                    if (galleryItem$AlbumItem.jAR.jAV >= galleryItem$AlbumItem2.jAR.jAV) {
                        galleryItem$AlbumItem2 = galleryItem$AlbumItem;
                    }
                }
            }
            if (galleryItem$AlbumItem != null) {
                bVar.jCP.jAR = galleryItem$AlbumItem.jAR;
            }
        }
        c.aRg().A(new 4(this));
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GalleryItem$AlbumItem qB = this.jDl.qB(i);
        if (qB == null) {
            x.d("MicroMsg.ImageFolderMgrView", "get folder failed:" + i);
            return;
        }
        if (this.jDh != null) {
            this.jDh.b(qB);
        }
        this.jDl.jCQ = bi.aG(qB.jAQ, "");
        this.jDk.setSelection(0);
        this.jDl.notifyDataSetChanged();
        this.jDj.performClick();
    }
}
