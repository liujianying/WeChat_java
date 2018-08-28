package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.l;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.br;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.n$d;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;

class am$5 implements n$d {
    final /* synthetic */ bd dAs;
    final /* synthetic */ String gjR;
    final /* synthetic */ boolean tMU;
    final /* synthetic */ Context val$context;

    am$5(bd bdVar, Context context, boolean z, String str) {
        this.dAs = bdVar;
        this.val$context = context;
        this.tMU = z;
        this.gjR = str;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        e br;
        e bq;
        int i2 = 1;
        String str = menuItem.getTitle();
        if (this.dAs.field_msgId > 0) {
            br = o.Pf().br(this.dAs.field_msgId);
        } else {
            br = null;
        }
        if ((br == null || br.dTK <= 0) && this.dAs.field_msgSvrId > 0) {
            bq = o.Pf().bq(this.dAs.field_msgSvrId);
        } else {
            bq = br;
        }
        if (bq == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: try get imgInfo fail");
        } else if (bq.offset < bq.dHI || bq.dHI == 0) {
            String str2;
            Bundle bundle;
            Intent intent = new Intent(this.val$context, ImageGalleryUI.class);
            intent.putExtra("img_gallery_msg_id", this.dAs.field_msgId);
            intent.putExtra("img_gallery_msg_svr_id", this.dAs.field_msgSvrId);
            intent.putExtra("img_gallery_talker", this.dAs.field_talker);
            intent.putExtra("img_gallery_chatroom_name", this.dAs.field_talker);
            intent.putExtra("img_gallery_is_restransmit_after_download", true);
            intent.putExtra("img_gallery_directly_send_name", str);
            intent.putExtra("start_chatting_ui", false);
            str = this.dAs.field_talker;
            Bundle bundle2 = new Bundle();
            if (this.tMU) {
                str2 = "stat_scene";
                i2 = 2;
                bundle = bundle2;
            } else {
                str2 = "stat_scene";
                if (s.hf(str)) {
                    i2 = 7;
                    bundle = bundle2;
                } else {
                    bundle = bundle2;
                }
            }
            bundle.putInt(str2, i2);
            bundle2.putString("stat_msg_id", "msg_" + Long.toString(this.dAs.field_msgSvrId));
            bundle2.putString("stat_chat_talker_username", str);
            bundle2.putString("stat_send_msg_user", this.gjR);
            intent.putExtra("_stat_obj", bundle2);
            this.val$context.startActivity(intent);
        } else {
            int i3;
            if (this.dAs.field_isSend == 1) {
                int i4;
                if (bq.ON()) {
                    i4 = 1;
                } else {
                    boolean i42 = false;
                }
                i3 = i42;
            } else if (!bq.ON()) {
                i3 = 0;
            } else if (com.tencent.mm.a.e.cn(f.a(bq).dTL)) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            String GF = q.GF();
            String o = o.Pf().o(f.c(bq), "", "");
            if (!bi.oW(o)) {
                x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[img]: to[%s] fileName[%s]", new Object[]{str, o});
                au.DF().a(new l(4, GF, str, o, i3, null, 0, "", "", true, R.g.chat_img_template), 0);
                br.IE().c(br.dDm, null);
            }
            h.mEJ.h(10424, new Object[]{Integer.valueOf(3), Integer.valueOf(4), str});
            com.tencent.mm.ui.base.h.bA(this.val$context, this.val$context.getString(R.l.app_saved));
        }
    }
}
