package com.tencent.mm.ui.transmit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;

class ShareImageSelectorUI$a extends BaseAdapter {
    final /* synthetic */ ShareImageSelectorUI uET;
    public a[] uEU = new a[]{new a(this, R.l.cropimg_share_to_friend, R.k.share_to_friend_icon), new a(this, R.l.cropimg_share_to_sns, R.k.find_more_friend_photograph_icon), new a(this, R.l.cropimg_share_to_fav, R.k.more_my_favorite)};

    ShareImageSelectorUI$a(ShareImageSelectorUI shareImageSelectorUI) {
        this.uET = shareImageSelectorUI;
    }

    public final /* bridge */ /* synthetic */ Object getItem(int i) {
        return this.uEU[i];
    }

    public final int getCount() {
        return 3;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        ShareImageSelectorUI$b shareImageSelectorUI$b;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.uET.mController.tml).inflate(R.i.share_image_selector_item, null);
            shareImageSelectorUI$b = new ShareImageSelectorUI$b(this.uET, view);
        } else {
            shareImageSelectorUI$b = (ShareImageSelectorUI$b) view.getTag();
        }
        a aVar = this.uEU[i];
        if (aVar != null) {
            shareImageSelectorUI$b.uEY.setText(aVar.uEV);
            shareImageSelectorUI$b.jci.setImageResource(aVar.uEW);
        }
        return view;
    }
}
