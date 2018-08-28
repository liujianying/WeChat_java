package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.record.ui.RecordMsgImageUI;
import com.tencent.mm.plugin.record.ui.a.b;

class a$1 implements OnClickListener {
    final /* synthetic */ a mtv;

    a$1(a aVar) {
        this.mtv = aVar;
    }

    public final void onClick(View view) {
        b bVar = (b) view.getTag();
        Intent intent;
        switch (bVar.bjS) {
            case 0:
                intent = new Intent(view.getContext(), RecordMsgImageUI.class);
                intent.putExtra("message_id", bVar.bJC);
                intent.putExtra("record_data_id", bVar.bOz.jdM);
                intent.putExtra("record_xml", bVar.bXN);
                if ((view.getContext() instanceof Activity) && ((Activity) view.getContext()).getIntent() != null) {
                    Bundle bundleExtra = ((Activity) view.getContext()).getIntent().getBundleExtra("_stat_obj");
                    if (bundleExtra != null) {
                        intent.putExtra("_stat_obj", bundleExtra);
                    }
                }
                view.getContext().startActivity(intent);
                return;
            case 1:
                intent = new Intent();
                intent.putExtra("key_detail_info_id", bVar.msw.field_localId);
                intent.putExtra("key_detail_data_id", bVar.bOz.jdM);
                com.tencent.mm.plugin.fav.a.b.a(view.getContext(), ".ui.FavImgGalleryUI", intent, 1);
                return;
            default:
                return;
        }
    }
}
