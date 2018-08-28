package com.tencent.mm.plugin.brandservice.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class BrandServiceSortView$1 implements OnItemClickListener {
    final /* synthetic */ BrandServiceSortView hqt;

    BrandServiceSortView$1(BrandServiceSortView brandServiceSortView) {
        this.hqt = brandServiceSortView;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag = view.getTag();
        if (tag == null || !(tag instanceof b)) {
            x.w("MicroMsg.BrandServiceSortView", "view tag is null or is not a instance of ResHolder.");
            return;
        }
        b bVar = (b) tag;
        if (bi.oW(bVar.username)) {
            x.w("MicroMsg.BrandServiceSortView", "username is null or nil.");
            return;
        }
        com.tencent.mm.plugin.websearch.api.x.PZ(bVar.username);
        com.tencent.mm.ui.contact.x.n(BrandServiceSortView.a(this.hqt), 12, 4, i - 1);
        if (BrandServiceSortView.b(this.hqt)) {
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", bVar.username);
            intent.putExtra("Select_Conv_User", bVar.username);
            if (this.hqt.getContext() instanceof Activity) {
                Activity activity = (Activity) this.hqt.getContext();
                activity.setResult(-1, intent);
                activity.finish();
                return;
            }
        }
        String str = bVar.username;
        Context context = this.hqt.getContext();
        x.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
        Intent putExtra = new Intent().putExtra("Chat_User", str);
        putExtra.putExtra("finish_direct", true);
        putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
        a.ezn.e(putExtra, context);
    }
}
