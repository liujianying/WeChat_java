package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class j$3 implements OnClickListener {
    final /* synthetic */ j tXq;

    j$3(j jVar) {
        this.tXq = jVar;
    }

    public final void onClick(View view) {
        if (this.tXq.tTU != null) {
            x.i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", new Object[]{Integer.valueOf(this.tXq.hashCode()), Integer.valueOf(this.tXq.mPosition)});
            this.tXq.tTU.Fr(this.tXq.mPosition);
        }
    }
}
