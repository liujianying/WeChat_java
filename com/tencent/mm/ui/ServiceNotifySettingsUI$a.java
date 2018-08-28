package com.tencent.mm.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

class ServiceNotifySettingsUI$a extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private int mMode;
    private OnClickListener mOnClickListener;
    private String mSceneId;
    LinkedList<a> tqh = new LinkedList();
    LinkedList<a> tqi = new LinkedList();
    private c tqj;

    public ServiceNotifySettingsUI$a(Context context, LayoutInflater layoutInflater, final int i, String str) {
        this.mContext = context;
        this.mMode = i;
        this.mSceneId = str;
        this.mLayoutInflater = layoutInflater;
        this.mOnClickListener = new OnClickListener() {
            public final void onClick(View view) {
                String str = (String) view.getTag();
                if (!TextUtils.isEmpty(str)) {
                    h.a(view.getContext(), i == 1 ? R.l.notify_message_settings_receive_app_brand_custom_session_msg_title : R.l.notify_message_settings_receive_app_brand_msg_title, 0, i == 1 ? R.l.notify_message_settings_receive_app_brand_custom_session_msg_title_ok : R.l.app_ok, R.l.cancel, false, new 1(this, str), new 2(this), R.e.green_text_color);
                }
            }
        };
        a aVar = new a();
        aVar.dXW = true;
        aVar.dXS = com.tencent.mm.modelappbrand.b.a.JZ();
        this.tqj = aVar.Pt();
    }

    public final int getCount() {
        return this.tqh.size();
    }

    private a Eb(int i) {
        return (a) this.tqh.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        a Eb = Eb(i);
        if (view == null) {
            view = this.mLayoutInflater.inflate(R.i.service_notify_settings_app_brand_item, viewGroup, false);
            b bVar2 = new b((byte) 0);
            bVar2.eBM = (ImageView) view.findViewById(R.h.avatarIv);
            bVar2.eBO = (TextView) view.findViewById(R.h.titleTv);
            bVar2.tqn = (TextView) view.findViewById(R.h.resumeReceiveBtn);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        o.Pj().a(Eb.url, bVar.eBM, this.tqj);
        bVar.eBO.setText(Eb.title);
        if (this.mMode == 1) {
            bVar.tqn.setText(this.mContext.getString(R.l.notify_message_settings_item_custom_session_resume_receive));
        } else {
            bVar.tqn.setText(this.mContext.getString(R.l.notify_message_settings_item_resume_receive));
        }
        bVar.tqn.setTag(Eb.username);
        bVar.tqn.setOnClickListener(this.mOnClickListener);
        return view;
    }
}
