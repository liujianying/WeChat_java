package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.conversation.BizConversationUI.a;

class BizConversationUI$a$16 implements OnItemClickListener {
    final /* synthetic */ a unz;

    BizConversationUI$a$16(a aVar) {
        this.unz = aVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a.a(this.unz, (ai) a.e(this.unz).getItem(i));
        a.a(this.unz, a.f(this.unz).field_username);
        ai f = a.f(this.unz);
        if (f == null) {
            x.e("MicroMsg.BizConversationUI", "user should not be null. position:%d, size:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(a.e(this.unz).getCount())});
            a.e(this.unz).notifyDataSetChanged();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("biz_click_item_unread_count", a.f(this.unz).field_unReadCount);
        bundle.putInt("biz_click_item_position", i + 1);
        this.unz.ui.startChatting(f.field_username, bundle, true);
        a.e(this.unz).a(f, i);
    }
}
