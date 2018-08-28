package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import java.util.List;
import junit.framework.Assert;

class ProfileMobilePhoneView$a extends BaseAdapter {
    private List<String> jWl = null;
    private Context mContext = null;

    private class a {
        TextView eGX;

        private a() {
        }

        /* synthetic */ a(ProfileMobilePhoneView$a profileMobilePhoneView$a, byte b) {
            this();
        }
    }

    public ProfileMobilePhoneView$a(Context context, List<String> list) {
        Assert.assertTrue(context != null);
        this.mContext = context;
        this.jWl = list;
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

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object obj;
        String str = (String) getItem(i);
        if (view == null) {
            view = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.i.chatting_item_phone_alert_item_normal, viewGroup, false);
            a aVar = new a(this, (byte) 0);
            aVar.eGX = (TextView) view.findViewById(R.h.title);
            view.setTag(aVar);
            obj = aVar;
        } else {
            obj = view.getTag();
        }
        ((a) obj).eGX.setText(str);
        return view;
    }
}
