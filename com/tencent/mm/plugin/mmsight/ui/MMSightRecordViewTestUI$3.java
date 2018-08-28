package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView$e;
import com.tencent.mm.plugin.w.a.d;

class MMSightRecordViewTestUI$3 implements OnClickListener {
    final /* synthetic */ MMSightRecordViewTestUI loN;

    MMSightRecordViewTestUI$3(MMSightRecordViewTestUI mMSightRecordViewTestUI) {
        this.loN = mMSightRecordViewTestUI;
    }

    public final void onClick(View view) {
        MMSightRecordViewTestUI.a(this.loN).a(new MMSightRecordView$e() {
            public final void v(Bitmap bitmap) {
                if (bitmap != null) {
                    ((ImageView) MMSightRecordViewTestUI$3.this.loN.findViewById(d.image_iv)).setImageBitmap(bitmap);
                }
            }

            public final void aiP() {
            }
        }, true);
    }
}
