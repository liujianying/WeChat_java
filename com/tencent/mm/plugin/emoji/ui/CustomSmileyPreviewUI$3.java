package com.tencent.mm.plugin.emoji.ui;

import android.os.Message;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class CustomSmileyPreviewUI$3 extends c<cu> {
    final /* synthetic */ CustomSmileyPreviewUI ikY;

    CustomSmileyPreviewUI$3(CustomSmileyPreviewUI customSmileyPreviewUI) {
        this.ikY = customSmileyPreviewUI;
        this.sFo = cu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cu cuVar = (cu) bVar;
        if (!(cuVar == null || bi.oW(CustomSmileyPreviewUI.c(this.ikY)) || !CustomSmileyPreviewUI.c(this.ikY).equals(cuVar.bKj.bKk))) {
            CustomSmileyPreviewUI customSmileyPreviewUI = this.ikY;
            String str = cuVar.bKj.bKk;
            int i = cuVar.bKj.status;
            int i2 = cuVar.bKj.progress;
            x.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), cuVar.bKj.bKl});
            if (i == 6) {
                Message obtain = Message.obtain();
                obtain.getData().putString("product_id", str);
                obtain.getData().putInt("progress", i2);
                obtain.what = 131075;
                if (customSmileyPreviewUI.mHandler != null) {
                    customSmileyPreviewUI.mHandler.sendMessage(obtain);
                }
            } else {
                x.i("MicroMsg.emoji.CustomSmileyPreviewUI", "product status:%d", new Object[]{Integer.valueOf(i)});
                Message obtain2 = Message.obtain();
                obtain2.getData().putString("product_id", str);
                obtain2.getData().putInt("status", i);
                obtain2.what = 131076;
                if (customSmileyPreviewUI.mHandler != null) {
                    customSmileyPreviewUI.mHandler.sendMessage(obtain2);
                }
            }
            if (!(customSmileyPreviewUI.ikI == null || customSmileyPreviewUI.ikI.ien == null)) {
                f za = customSmileyPreviewUI.ikI.ien.za(str);
                if (za != null) {
                    za.ieC = r4;
                }
            }
        }
        return false;
    }
}
