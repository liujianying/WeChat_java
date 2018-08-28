package com.tencent.mm.plugin.clean.ui.newui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.clean.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class b$3 implements OnItemClickListener {
    final /* synthetic */ b hTn;

    b$3(b bVar) {
        this.hTn = bVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d", Integer.valueOf(i));
        a or = this.hTn.or(i);
        Intent intent = new Intent();
        switch (or.type) {
            case 1:
                intent.putExtra("key_title", b.a(this.hTn).getString(R.l.clean_image_detail_title));
                intent.putExtra("show_menu", false);
                intent.putExtra("key_image_path", or.filePath);
                d.e(b.a(this.hTn), ".ui.tools.ShowImageUI", intent);
                return;
            case 3:
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(new File(or.filePath)), "video/*");
                try {
                    b.a(this.hTn).startActivity(Intent.createChooser(intent, b.a(this.hTn).getString(R.l.video_title)));
                    return;
                } catch (Exception e) {
                    return;
                }
            case 4:
                intent.putExtra("app_msg_id", or.bIZ);
                d.e(b.a(this.hTn), ".ui.chatting.AppAttachDownloadUI", intent);
                return;
            default:
                return;
        }
    }
}
