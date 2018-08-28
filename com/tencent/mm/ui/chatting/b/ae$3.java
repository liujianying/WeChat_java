package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.BitmapFactory.Options;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ak.l;
import com.tencent.mm.k.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.ui.chatting.b.b.m;
import com.tencent.mm.ui.chatting.w;

class ae$3 implements OnClickListener {
    final /* synthetic */ m tRN;
    final /* synthetic */ ae tRO;
    final /* synthetic */ boolean tRQ;
    final /* synthetic */ String tRR;

    ae$3(ae aeVar, boolean z, m mVar, String str) {
        this.tRO = aeVar;
        this.tRQ = z;
        this.tRN = mVar;
        this.tRR = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (!this.tRQ || this.tRN.cvb() == null || this.tRN.cvb().getCallback() == null || !(this.tRN.cvb().getCallback() instanceof w)) {
            au.DF().a(new l(5, this.tRO.bAG.cwp(), this.tRO.bAG.getTalkerUserName(), this.tRR, 0, null, 0, "", "", true, R.g.chat_img_template), 0);
            return;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        if ((c.decodeFile(this.tRR, options) == null || options.outHeight <= b.Az()) && options.outWidth <= b.Az()) {
            String a = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(this.tRO.bAG.tTq.getContext(), new WXMediaMessage(new WXEmojiObject(this.tRR)), null);
            if (a != null) {
                ((w) this.tRN.cvb().getCallback()).m(((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(a));
                return;
            }
            return;
        }
        Toast.makeText(this.tRO.bAG.tTq.getContext(), R.l.emoji_custom_gif_max_size_limit_cannot_send, 0).show();
    }
}
