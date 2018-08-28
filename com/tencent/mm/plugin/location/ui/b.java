package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.map.a;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMGridPaper;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    private i kEl = null;
    private MMGridPaper kEm = null;
    private a kEn = null;
    private ViewGroup kEo = null;
    private RelativeLayout kEp = null;
    private ArrayList<String> kEq = null;
    private int kEr = 0;
    private Context mContext = null;

    private b(Context context) {
        this.mContext = context;
        this.kEl = new i(this.mContext, a.i.trackDialog);
        this.kEo = (ViewGroup) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(f.avatars_dialog, null);
        this.kEm = (MMGridPaper) this.kEo.findViewById(e.dialog_content);
        this.kEm.crw();
        this.kEm.setDialogMode(true);
        this.kEm.crv();
        this.kEm.setMaxRow(3);
        this.kEm.setMaxCol(3);
        this.kEm.setHeaderView(null);
        this.kEm.crw();
        this.kEm.setItemWidthInDp(70);
        this.kEm.setItemHeightInDp(70);
        this.kEl.setCanceledOnTouchOutside(true);
        this.kEl.setContentView(this.kEo);
        this.kEn = new a();
        this.kEm.setGridPaperAdapter(this.kEn);
    }

    public static void b(Context context, ArrayList<String> arrayList) {
        x.d("MicroMsg.AvatarsDialog", "showDialog, username.size = %d", new Object[]{Integer.valueOf(arrayList.size())});
        b bVar = new b(context);
        bVar.kEq = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bVar.kEq.add((String) it.next());
        }
        if (bVar.kEq.size() < 3) {
            bVar.kEm.setMaxCol(bVar.kEq.size());
        } else {
            bVar.kEm.setMaxCol(3);
        }
        LayoutParams layoutParams = bVar.kEm.getLayoutParams();
        bVar.kEr = com.tencent.mm.bp.a.fromDPToPix(bVar.mContext, 70);
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(bVar.mContext, 8);
        if (bVar.kEq.size() <= 0) {
            fromDPToPix = 0;
        } else if (bVar.kEq.size() < 3) {
            fromDPToPix = (fromDPToPix * (bVar.kEq.size() - 1)) + (bVar.kEr * bVar.kEq.size());
        } else {
            fromDPToPix = (fromDPToPix * 2) + (bVar.kEr * 3);
        }
        String fp = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.fp(bVar.mContext);
        x.d("MicroMsg.AvatarsDialog", "calculateGridWidth, result = %d, mUsername.size = %d, avatarSize = %d, densityType = %s", new Object[]{Integer.valueOf(fromDPToPix), Integer.valueOf(bVar.kEq.size()), Integer.valueOf(bVar.kEr), fp});
        layoutParams.width = fromDPToPix;
        bVar.kEr = com.tencent.mm.bp.a.fromDPToPix(bVar.mContext, 70);
        fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(bVar.mContext, 15);
        if (bVar.kEq.size() > 0) {
            if (bVar.kEq.size() <= 3) {
                fromDPToPix += bVar.kEr;
            } else if (bVar.kEq.size() <= 6) {
                fromDPToPix += bVar.kEr * 2;
            } else {
                fromDPToPix = ((fromDPToPix * 2) + (bVar.kEr * 3)) + com.tencent.mm.bp.a.fromDPToPix(bVar.mContext, 10);
            }
            x.d("MicroMsg.AvatarsDialog", "calculateGridHeight, result = %d", new Object[]{Integer.valueOf(fromDPToPix)});
        } else {
            fromDPToPix = 0;
        }
        layoutParams.height = fromDPToPix;
        bVar.kEm.setLayoutParams(layoutParams);
        bVar.kEm.requestLayout();
        bVar.kEn.B(bVar.kEq);
        bVar.kEl.show();
    }
}
