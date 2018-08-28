package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.pluginsdk.ui.chat.i.a;
import java.util.ArrayList;

class ChatFooter$27 implements a {
    final /* synthetic */ ChatFooter qMv;
    final /* synthetic */ Context val$context;

    ChatFooter$27(ChatFooter chatFooter, Context context) {
        this.qMv = chatFooter;
        this.val$context = context;
    }

    public final void TO(String str) {
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(str);
        if (ChatFooter.e(this.qMv) != null) {
            intent.putExtra("GalleryUI_FromUser", ChatFooter.e(this.qMv));
        }
        if (ChatFooter.f(this.qMv) != null) {
            intent.putExtra("GalleryUI_ToUser", ChatFooter.f(this.qMv));
        }
        intent.putExtra("query_source_type", 3);
        intent.putExtra("preview_image", true);
        intent.putStringArrayListExtra("preview_image_list", arrayList);
        intent.putExtra("max_select_count", 1);
        intent.addFlags(67108864);
        if (ChatFooter.g(this.qMv) != null) {
            d.a(ChatFooter.g(this.qMv), "gallery", ".ui.GalleryEntryUI", intent, 217);
        } else {
            d.b(this.val$context, "gallery", ".ui.GalleryEntryUI", intent, 217);
        }
    }
}
