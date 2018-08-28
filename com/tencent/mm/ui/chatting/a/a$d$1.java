package com.tencent.mm.ui.chatting.a;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.a.a.c;
import com.tencent.mm.ui.chatting.a.a.d;

class a$d$1 implements OnClickListener {
    final /* synthetic */ a tNQ;
    final /* synthetic */ d tNR;

    a$d$1(d dVar, a aVar) {
        this.tNR = dVar;
        this.tNQ = aVar;
    }

    public final void onClick(View view) {
        c EY = this.tNR.tNI.EY(((Integer) view.getTag()).intValue());
        if (EY != null) {
            a aVar = this.tNR.tNI;
            Intent intent = new Intent();
            intent.putExtra("key_biz_chat_id", aVar.tNE);
            intent.putExtra("key_is_biz_chat", aVar.qIZ);
            if (EY == null) {
                x.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] item == null");
                return;
            }
            bd bdVar = EY.bXQ;
            if (bdVar == null) {
                x.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] msg == null");
                return;
            }
            int width;
            int height;
            int i = aVar.mContext.getResources().getConfiguration().orientation;
            int[] iArr = new int[2];
            if (view != null) {
                width = view.getWidth();
                height = view.getHeight();
                view.getLocationInWindow(iArr);
            } else {
                height = 0;
                width = 0;
            }
            intent.addFlags(536870912);
            intent.putExtra("img_gallery_msg_id", bdVar.field_msgId).putExtra("img_gallery_msg_svr_id", bdVar.field_msgSvrId).putExtra("img_gallery_talker", bdVar.field_talker).putExtra("img_gallery_chatroom_name", bdVar.field_talker).putExtra("img_gallery_orientation", i);
            if (view != null) {
                intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
            } else {
                intent.putExtra("img_gallery_back_from_grid", true);
            }
            com.tencent.mm.bg.d.e(aVar.mContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", intent);
            ((Activity) aVar.mContext).overridePendingTransition(0, 0);
        }
    }
}
