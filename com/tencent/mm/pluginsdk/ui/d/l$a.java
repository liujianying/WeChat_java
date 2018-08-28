package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import junit.framework.Assert;

class l$a extends BaseAdapter {
    private List<String> jWl = null;
    private Context mContext = null;
    private Bundle pa = null;
    private OnDismissListener qQj = null;
    a qQk = null;

    public l$a(List<String> list, Context context, OnDismissListener onDismissListener, Bundle bundle) {
        Assert.assertTrue(context != null);
        this.jWl = list;
        this.mContext = context;
        this.qQj = onDismissListener;
        this.pa = bundle;
    }

    public final int getCount() {
        return this.jWl == null ? 0 : this.jWl.size();
    }

    public final Object getItem(int i) {
        return this.jWl.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final int getItemViewType(int i) {
        if (this.mContext.getString(R.l.chatting_phone_download_wxpb).equals((String) this.jWl.get(i))) {
            return 1;
        }
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        Object obj;
        String str = (String) getItem(i);
        int itemViewType = getItemViewType(i);
        if (view == null) {
            Object bVar;
            LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
            View inflate;
            if (itemViewType == 1) {
                inflate = layoutInflater.inflate(R.i.chatting_item_phone_alert_item_download, viewGroup, false);
                bVar = new b(this, (byte) 0);
                ((b) bVar).eGX = (TextView) inflate.findViewById(R.h.title);
                ((b) bVar).jch = (Button) inflate.findViewById(R.h.download_btn);
                ((b) bVar).qQm = (TextView) inflate.findViewById(R.h.tip_msg);
                view2 = inflate;
            } else {
                inflate = layoutInflater.inflate(R.i.chatting_item_phone_alert_item_normal, viewGroup, false);
                bVar = new c(this, (byte) 0);
                ((c) bVar).eGX = (TextView) inflate.findViewById(R.h.title);
                view2 = inflate;
            }
            view2.setTag(bVar);
            obj = bVar;
        } else {
            obj = view.getTag();
            view2 = view;
        }
        switch (itemViewType) {
            case 0:
                c cVar = (c) obj;
                cVar.eGX.setText(j.a(this.mContext, bi.oV(str), cVar.eGX.getTextSize()));
                break;
            case 1:
                b bVar2 = (b) obj;
                bVar2.eGX.setText(j.a(this.mContext, bi.oV(str), bVar2.eGX.getTextSize()));
                bVar2.qQm.setText(this.mContext.getString(R.l.chatting_phone_wx_pb_tips));
                bVar2.jch.setOnClickListener(new 1(this));
                break;
            default:
                x.e("MicroMsg.MailPhoneMenuHelper", "hy: error tag");
                break;
        }
        return view2;
    }
}
