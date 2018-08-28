package com.tencent.mm.ui.contact;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;

class ContactRemarkImagePreviewUI$a extends BaseAdapter {
    String imagePath;
    final /* synthetic */ ContactRemarkImagePreviewUI uiD;

    ContactRemarkImagePreviewUI$a(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI) {
        this.uiD = contactRemarkImagePreviewUI;
    }

    public final int getCount() {
        return 1;
    }

    public final Object getItem(int i) {
        return this.imagePath;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = View.inflate(this.uiD, R.i.contact_remark_image_preview_item, null);
        MultiTouchImageView multiTouchImageView = (MultiTouchImageView) inflate.findViewById(R.h.image);
        inflate.setLayoutParams(new LayoutParams(-1, -1));
        multiTouchImageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        Bitmap e = b.e(this.imagePath, a.getDensity(this.uiD));
        if (e != null) {
            int width = ContactRemarkImagePreviewUI.e(this.uiD).getWidth();
            int height = ContactRemarkImagePreviewUI.e(this.uiD).getHeight();
            Matrix matrix = new Matrix();
            matrix.reset();
            float width2 = ((float) e.getWidth()) / ((float) e.getHeight());
            float height2 = ((float) e.getHeight()) / ((float) e.getWidth());
            x.v("MicroMsg.ImagePreviewUI", "whDiv is " + width2 + " hwDiv is " + height2);
            if (height2 >= 2.0f && e.getHeight() >= 480) {
                height2 = ((float) width) / ((float) e.getWidth());
                if (((double) (((float) e.getWidth()) / ((float) width))) > 1.0d) {
                    matrix.postScale(height2, height2);
                    e.getHeight();
                    matrix.postTranslate((((float) width) - (height2 * ((float) e.getWidth()))) / 2.0f, 0.0f);
                } else {
                    matrix.postScale(1.0f, 1.0f);
                    matrix.postTranslate((float) ((width - e.getWidth()) / 2), 0.0f);
                }
            } else if (width2 < 2.0f || e.getWidth() < 480) {
                width2 = ((float) width) / ((float) e.getWidth());
                height2 = ((float) height) / ((float) e.getHeight());
                if (width2 >= height2) {
                    width2 = height2;
                }
                height2 = ((float) e.getWidth()) / ((float) width);
                float height3 = ((float) e.getHeight()) / ((float) height);
                if (height2 <= height3) {
                    height2 = height3;
                }
                if (((double) height2) > 1.0d) {
                    matrix.postScale(width2, width2);
                } else {
                    width2 = 1.0f;
                }
                matrix.postTranslate((((float) width) - (((float) e.getWidth()) * width2)) / 2.0f, (((float) height) - (width2 * ((float) e.getHeight()))) / 2.0f);
            } else {
                width2 = ((float) e.getHeight()) / 480.0f;
                height2 = 480.0f / ((float) e.getHeight());
                if (((double) width2) > 1.0d) {
                    matrix.postScale(width2, height2);
                    matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                } else {
                    matrix.postScale(1.0f, 1.0f);
                    width2 = (float) ((height - e.getHeight()) / 2);
                    x.d("MicroMsg.ImagePreviewUI", " offsety " + width2);
                    matrix.postTranslate(0.0f, width2);
                }
            }
            multiTouchImageView.setImageMatrix(matrix);
            multiTouchImageView.eT(e.getWidth(), e.getHeight());
            multiTouchImageView.setImageBitmap(e);
        }
        return inflate;
    }
}
