package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class BrandServiceIndexUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ BrandServiceIndexUI hpc;

    BrandServiceIndexUI$3(BrandServiceIndexUI brandServiceIndexUI) {
        this.hpc = brandServiceIndexUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.v("MicroMsg.BrandService.BrandServiceIndexUI", "search btn was clicked.");
        Intent intent = new Intent(this.hpc, BrandServiceLocalSearchUI.class);
        intent.putExtra("is_return_result", BrandServiceIndexUI.a(this.hpc));
        intent.addFlags(67108864);
        this.hpc.startActivityForResult(intent, 1);
        return true;
    }
}
