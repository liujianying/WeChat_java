package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.ui.base.MultiTouchImageView;

class GetHdHeadImageGalleryView$a extends BaseAdapter {
    final /* synthetic */ GetHdHeadImageGalleryView qFk;

    private GetHdHeadImageGalleryView$a(GetHdHeadImageGalleryView getHdHeadImageGalleryView) {
        this.qFk = getHdHeadImageGalleryView;
    }

    /* synthetic */ GetHdHeadImageGalleryView$a(GetHdHeadImageGalleryView getHdHeadImageGalleryView, byte b) {
        this(getHdHeadImageGalleryView);
    }

    public final int getCount() {
        return 1;
    }

    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a(this);
            view = View.inflate(this.qFk.getContext(), f.view_get_hd_avatar_dialogview, null);
            aVar2.nXq = (ProgressBar) view.findViewById(e.hd_avatar_laoding_pb);
            aVar2.bRk = (ImageView) view.findViewById(e.hd_avatar_iv);
            aVar2.qFl = view.findViewById(e.hd_avatar_mask_view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        view.setLayoutParams(new LayoutParams(-1, -1));
        if (GetHdHeadImageGalleryView.d(this.qFk) != null) {
            aVar.nXq.setVisibility(8);
            aVar.bRk.setVisibility(8);
            aVar.qFl.setVisibility(8);
            MultiTouchImageView multiTouchImageView = new MultiTouchImageView(this.qFk.getContext(), GetHdHeadImageGalleryView.d(this.qFk).getWidth(), GetHdHeadImageGalleryView.d(this.qFk).getHeight());
            multiTouchImageView.setLayoutParams(new LayoutParams(-1, -1));
            multiTouchImageView.setImageBitmap(GetHdHeadImageGalleryView.d(this.qFk));
            multiTouchImageView.setMaxZoomLimit(2.0f);
            multiTouchImageView.setMaxZoomDoubleTab(true);
            return multiTouchImageView;
        }
        aVar.nXq.setVisibility(0);
        aVar.qFl.setVisibility(0);
        if (GetHdHeadImageGalleryView.e(this.qFk) != null) {
            aVar.bRk.setVisibility(0);
            aVar.bRk.setImageBitmap(GetHdHeadImageGalleryView.e(this.qFk));
            return view;
        }
        aVar.bRk.setVisibility(8);
        return view;
    }
}
