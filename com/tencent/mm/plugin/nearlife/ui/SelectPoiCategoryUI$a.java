package com.tencent.mm.plugin.nearlife.ui;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class SelectPoiCategoryUI$a extends c<lu> {
    final /* synthetic */ SelectPoiCategoryUI lEA;
    SelectPoiCategoryUI lEB;

    public SelectPoiCategoryUI$a(SelectPoiCategoryUI selectPoiCategoryUI) {
        this.lEA = selectPoiCategoryUI;
        super(0);
        this.sFo = lu.class.getName().hashCode();
    }

    private boolean a(lu luVar) {
        if (luVar instanceof lu) {
            SelectPoiCategoryUI selectPoiCategoryUI = this.lEB;
            byte[] bArr = luVar.bWi.content;
            File file = new File(SelectPoiCategoryUI.lEv);
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                String str = SelectPoiCategoryUI.lEv + "/lastest_poi_categories.dat";
                File file2 = new File(str);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                e.b(str, bArr, bArr.length);
            } catch (Exception e) {
                x.e("MicroMsg.SelectPoiCategoryUI", "write file failed: " + e.getMessage());
            }
            selectPoiCategoryUI.aD(bArr);
            selectPoiCategoryUI.bjg();
        }
        return false;
    }
}
