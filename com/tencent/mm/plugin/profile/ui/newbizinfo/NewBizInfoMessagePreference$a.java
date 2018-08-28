package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.support.v7.widget.RecyclerView$a;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public class NewBizInfoMessagePreference$a extends RecyclerView$a<a> {
    private static int lYJ = a.fromDPToPix(ad.getContext(), 6);
    private static final int lYK = ad.getResources().getDimensionPixelSize(R.f.SmallerIconSize);
    private static int lYL = a.fromDPToPix(ad.getContext(), 4);
    private static int lYM = 13;
    private static int lYN = a.fromDPToPix(ad.getContext(), 1);
    private static int lYO = a.fromDPToPix(ad.getContext(), 8);
    private static int lYP = 13;
    private Context context;
    private List<b> lYI = new ArrayList();

    public NewBizInfoMessagePreference$a(Context context, List<b> list) {
        this.context = context;
        this.lYI = list;
    }

    public final int getItemCount() {
        return this.lYI == null ? 0 : this.lYI.size();
    }
}
