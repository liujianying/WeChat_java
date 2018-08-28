package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.a;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i extends w implements OnClickListener {
    public static int ied = 60;
    public LinkedList<a> iec;
    private int iee = 0;
    public boolean ief = false;
    public ArrayList<String> ieg = new ArrayList();
    private com.tencent.mm.ak.a.c.i ieh = new 1(this);
    private Context mContext;
    private ag mHandler = new ag();

    public i(Context context, LinkedList<a> linkedList) {
        if (linkedList == null) {
            throw new IllegalAccessError("must has emoji banner list");
        }
        this.mContext = context;
        this.iec = new LinkedList();
        this.iec.addAll(linkedList);
    }

    public final void setData(LinkedList<a> linkedList) {
        this.iec.clear();
        this.iec.addAll(linkedList);
        notifyDataSetChanged();
    }

    public final int getCount() {
        if (this.iec == null) {
            return 0;
        }
        return this.iec.size() != 1 ? this.iec.size() * ied : 1;
    }

    public final void notifyDataSetChanged() {
        if (this.ief) {
            x.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "has destroy need to notify");
            return;
        }
        this.iee = getCount();
        super.notifyDataSetChanged();
    }

    public final int k(Object obj) {
        if (this.iee <= 0) {
            return super.k(obj);
        }
        this.iee--;
        return -2;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (this.iec == null) {
            return null;
        }
        a aVar;
        int size = i % this.iec.size();
        a aVar2;
        if (view == null) {
            x.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "getView inflate");
            view = View.inflate(this.mContext, R.i.emoji_store_vp_header_item, null);
            aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar2 = (a) view.getTag();
            int i2 = EmojiStoreVpHeader.db(this.mContext)[0];
            aVar2.iek.setLayoutParams(new LayoutParams(i2, ((i2 * 3) / 8) + 1));
            aVar = aVar2;
        }
        view.setTag(R.h.emoji_header_vp_id, Integer.valueOf(size));
        view.setOnClickListener(this);
        a aVar3 = (a) this.iec.get(size);
        if (aVar3 == null) {
            x.e("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "BaseEmotionBanner is null.");
            return null;
        }
        String str;
        String str2;
        if (aVar3.iha) {
            str = aVar3.igY.rwF.rwG;
            if (bi.oW(aVar3.igY.rwH)) {
                str2 = "H5";
            } else {
                str2 = "Toptic";
            }
        } else {
            str = aVar3.igZ.rwF.rwG;
            str2 = aVar3.igZ.rwE.rem;
        }
        if (!(aVar3 == null || bi.oW(str))) {
            com.tencent.mm.bp.a.getDensity(this.mContext);
            EmojiInfo a = EmojiLogic.a(str2, 8, str, true);
            if (a != null) {
                aVar.iek.setImageFilePath(a.cnF());
            } else if (this.ieg.contains(str)) {
                x.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "url has add to list. no need to try load image.");
                aVar.iek.setImageFilePath("-");
            } else {
                o.Pj().a(str, null, f.g(str2, str, str2, "BANNER"), this.ieh);
                this.ieg.add(str);
            }
        }
        x.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "position:%d allPostion:%d banner url:%s ", new Object[]{Integer.valueOf(size), Integer.valueOf(i), str});
        return view;
    }

    public final void onClick(View view) {
        a aVar = (a) this.iec.get(((Integer) view.getTag(R.h.emoji_header_vp_id)).intValue());
        if (aVar == null) {
            return;
        }
        if (aVar.iha) {
            m.a(this.mContext, aVar.igY, true);
            return;
        }
        ts tsVar = aVar.igZ.rwE;
        if (tsVar != null) {
            String str = "MicroMsg.emoji.EmojiStoreVpHeaderAdapter";
            String str2 = "productId %s";
            Object[] objArr = new Object[1];
            objArr[0] = tsVar == null ? "" : tsVar.rem;
            x.d(str, str2, objArr);
            h.mEJ.h(11929, new Object[]{Integer.valueOf(0)});
            m.a(this.mContext, tsVar, 15, -1, -1, "", 8);
        }
    }
}
