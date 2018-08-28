package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class b$4 implements OnItemClickListener {
    final /* synthetic */ b hRX;

    b$4(b bVar) {
        this.hRX = bVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d", new Object[]{Integer.valueOf(i)});
        i on = this.hRX.on(i);
        Intent intent = new Intent();
        switch (on.type) {
            case 1:
                intent.putExtra("key_title", b.e(this.hRX).getString(R.l.clean_image_detail_title));
                intent.putExtra("show_menu", false);
                intent.putExtra("key_image_path", FileOp.cn(on.filePath) ? on.filePath : on.bOX);
                d.e(b.e(this.hRX), ".ui.tools.ShowImageUI", intent);
                return;
            case 3:
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(new File(on.filePath)), "video/*");
                try {
                    b.e(this.hRX).startActivity(Intent.createChooser(intent, b.e(this.hRX).getString(R.l.video_title)));
                    return;
                } catch (Exception e) {
                    return;
                }
            case 4:
                intent.putExtra("app_msg_id", on.bIZ);
                d.e(b.e(this.hRX), ".ui.chatting.AppAttachDownloadUI", intent);
                return;
            default:
                return;
        }
    }
}
