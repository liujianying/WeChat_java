package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class SelectPoiCategoryUI$1 implements OnItemClickListener {
    final /* synthetic */ SelectPoiCategoryUI lEA;

    SelectPoiCategoryUI$1(SelectPoiCategoryUI selectPoiCategoryUI) {
        this.lEA = selectPoiCategoryUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.SelectPoiCategoryUI", "item click on pos:%d, len:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(SelectPoiCategoryUI.a(this.lEA).size())});
        Intent intent = new Intent();
        intent.putExtra("poi_category", (String) SelectPoiCategoryUI.a(this.lEA).get(i));
        this.lEA.setResult(-1, intent);
        this.lEA.finish();
    }
}
