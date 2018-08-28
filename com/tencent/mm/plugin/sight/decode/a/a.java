package com.tencent.mm.plugin.sight.decode.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.a.b.g;

public interface a {
    void aO(String str, boolean z);

    void bvE();

    boolean bvF();

    void clear();

    void dt(int i, int i2);

    Object getTagObject();

    Context getUIContext();

    String getVideoPath();

    void setCanPlay(boolean z);

    void setDrawableWidth(int i);

    void setForceRecordState(boolean z);

    void setOnCompletionListener(e eVar);

    void setOnDecodeDurationListener(f fVar);

    void setOnSightCompletionAction(g gVar);

    void setPosition(int i);

    void setSightInfoView(TextView textView);

    void setTagObject(Object obj);

    void setThumbBmp(Bitmap bitmap);
}
