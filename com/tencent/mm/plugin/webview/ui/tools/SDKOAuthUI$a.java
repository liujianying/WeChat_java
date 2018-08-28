package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.awp;
import java.util.LinkedList;

final class SDKOAuthUI$a extends BaseAdapter {
    private LayoutInflater Bc;
    private LinkedList<awp> pWv;

    public SDKOAuthUI$a(Context context, LinkedList<awp> linkedList) {
        this.Bc = LayoutInflater.from(context);
        this.pWv = linkedList;
    }

    public final LinkedList<String> bVO() {
        LinkedList<String> linkedList = new LinkedList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.pWv.size()) {
                return linkedList;
            }
            awp awp = (awp) this.pWv.get(i2);
            if (awp.rZQ == 2 || awp.rZQ == 3) {
                linkedList.add(awp.scope);
            }
            i = i2 + 1;
        }
    }

    public final int getCount() {
        return this.pWv == null ? 0 : this.pWv.size();
    }

    private awp AF(int i) {
        return (awp) this.pWv.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (this.pWv == null || this.pWv.size() <= 0) {
            return null;
        }
        a aVar;
        final awp AF = AF(i);
        if (view == null) {
            a aVar2 = new a((byte) 0);
            view = this.Bc.inflate(R.i.sdk_authorize_scope_item, null, false);
            aVar2.fyC = (ImageView) view.findViewById(R.h.app_auth_state);
            aVar2.fyD = (TextView) view.findViewById(R.h.app_auth_desc);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (AF.rZQ == 1) {
            aVar.fyC.setImageResource(R.k.login_auth_state_not_selected);
        } else if (AF.rZQ == 3) {
            aVar.fyC.setImageResource(R.k.login_auth_state_must_select);
        } else {
            aVar.fyC.setImageResource(R.k.login_auth_state_default_select);
        }
        aVar.fyD.setText(AF.desc);
        final ImageView imageView = aVar.fyC;
        aVar.fyC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (AF.rZQ == 2) {
                    imageView.setImageResource(R.k.login_auth_state_not_selected);
                    AF.rZQ = 1;
                } else if (AF.rZQ == 1) {
                    imageView.setImageResource(R.k.login_auth_state_default_select);
                    AF.rZQ = 2;
                }
            }
        });
        return view;
    }
}
