package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.c;

class AlbumPreviewUI$7 implements a$a {
    private OnClickListener iZP = new 1(this);
    final /* synthetic */ AlbumPreviewUI jCE;

    AlbumPreviewUI$7(AlbumPreviewUI albumPreviewUI) {
        this.jCE = albumPreviewUI;
    }

    public final View getView() {
        View inflate = View.inflate(this.jCE.mController.tml, R.i.cemera_icon, null);
        inflate.setOnClickListener(this.iZP);
        TextView textView = (TextView) inflate.findViewById(R.h.media_thumb);
        if (c.aRf().aRJ() == 2 || c.aRf().aRI() == 13) {
            textView.setText(R.l.gallery_take_vedio);
        } else if (c.aRf().aRJ() == 1) {
            textView.setText(R.l.gallery_take_picture);
        }
        inflate.setLayerType(1, null);
        return inflate;
    }
}
