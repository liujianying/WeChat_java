package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b extends android.support.v7.widget.RecyclerView.a {
    public static e tNS;
    public static f tNT = null;
    private Context mContext;
    public String tNU;

    public static class a extends t {
        public ImageView eCl;
        public TextView eCm;
        public TextView eMe;
        public TextView hrs;
        public View jEz;

        public a(View view) {
            super(view);
            this.jEz = view;
            this.eCl = (ImageView) view.findViewById(R.h.fav_avatar);
            this.eMe = (TextView) view.findViewById(R.h.fav_name);
            this.hrs = (TextView) view.findViewById(R.h.fav_time);
            this.eCm = (TextView) view.findViewById(R.h.fav_title);
            this.eCm.setSingleLine(false);
            this.eCm.setMaxLines(2);
            view.setOnClickListener(new 1(this));
            view.setOnLongClickListener(new 2(this));
        }

        public static void e(TextView textView, String str) {
            if (!bi.oW(str)) {
                textView.getContext();
                textView.setText(f.a(textView.getText(), str));
            }
        }
    }

    public static abstract class b {
        public long bJC;
        public String bgo;
        public String gBq;
        public String nickname;
        Pattern tNW = Pattern.compile("[._a-zA-Z0-9]+");
        public long timestamp;
        public String title;
        public int type;
        public String username;

        public b(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            this.timestamp = j;
            this.type = i;
            this.title = str;
            this.bJC = j2;
            this.username = str2;
            this.nickname = str3;
            this.bgo = str4;
            this.gBq = str5;
        }

        public int getType() {
            return this.type;
        }

        public boolean aak(String str) {
            if (aal(str)) {
                if (!bi.oW(this.title) && this.title.toLowerCase().contains(str)) {
                    return true;
                }
                if (!bi.oW(this.nickname) && this.nickname.toLowerCase().contains(str)) {
                    return true;
                }
                if (!bi.oW(this.gBq) && this.gBq.toLowerCase().contains(str)) {
                    return true;
                }
                if (!bi.oW(this.bgo) && this.bgo.toLowerCase().contains(str)) {
                    return true;
                }
            } else if (!bi.oW(this.title) && isContains(str, this.title.toLowerCase())) {
                return true;
            } else {
                if (!bi.oW(this.nickname) && isContains(str, this.nickname.toLowerCase())) {
                    return true;
                }
                if (!bi.oW(this.gBq) && isContains(str, this.gBq.toLowerCase())) {
                    return true;
                }
                if (!bi.oW(this.bgo) && isContains(str, this.bgo.toLowerCase())) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isContains(String str, String str2) {
            if (bi.oW(str2)) {
                return false;
            }
            Matcher matcher = this.tNW.matcher(str2);
            boolean z = false;
            while (matcher.find()) {
                z = matcher.group().startsWith(str);
                x.i("MicroMsg.MediaHistoryListAdapter", "[isContains] search:%s group:%s", new Object[]{str, r3});
                if (z) {
                    return z;
                }
            }
            return z;
        }

        public static boolean aal(String str) {
            char[] toCharArray = str.toCharArray();
            int i = 0;
            while (i < toCharArray.length) {
                if (toCharArray[i] >= 19968 && toCharArray[i] <= 40891) {
                    return true;
                }
                i++;
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof b)) {
                return super.equals(obj);
            }
            return this.bJC == ((b) obj).bJC;
        }
    }

    public class d extends t {
        TextView eBP;

        public d(View view) {
            super(view);
            this.eBP = (TextView) view.findViewById(R.h.date_info);
            this.eBP.setTextColor(b.this.mContext.getResources().getColor(R.e.fav_record_date_color));
            view.findViewById(R.h.content).setBackgroundColor(b.this.mContext.getResources().getColor(R.e.fav_listitem_divider_bg));
        }
    }

    public b(Context context, f fVar) {
        tNT = fVar;
        this.mContext = context;
    }

    public final int getItemViewType(int i) {
        return tNT.EZ(i).getType();
    }

    public final t a(ViewGroup viewGroup, int i) {
        if (i == Integer.MAX_VALUE) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.i.gallery_date_item, viewGroup, false));
        }
        return tNT.m(viewGroup);
    }

    public final void a(t tVar, int i) {
        int itemViewType = getItemViewType(i);
        b EZ = tNT.EZ(i);
        if (itemViewType == Integer.MAX_VALUE) {
            b EZ2 = tNT.EZ(i + 1);
            if (i == getItemCount() - 1 || gz(EZ2.timestamp) != gz(EZ.timestamp)) {
                ((d) tVar).eBP.setVisibility(8);
                return;
            }
            ((d) tVar).eBP.setVisibility(0);
            ((d) tVar).eBP.setText(gy(EZ.timestamp));
            return;
        }
        a aVar = (a) tVar;
        aVar.jEz.setTag(Integer.valueOf(i));
        if (itemViewType != 33) {
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar.eCl, EZ.username);
        }
        TextView textView = aVar.eMe;
        Context context = this.mContext;
        CharSequence charSequence = bi.oW(this.tNU) ? bi.oW(EZ.bgo) ? bi.oW(EZ.gBq) ? EZ.nickname : EZ.gBq : EZ.bgo : bi.oW(EZ.bgo) ? !bi.oW(EZ.gBq) ? (bi.oW(EZ.nickname) || !EZ.nickname.contains(this.tNU)) ? EZ.gBq : EZ.gBq + "(" + EZ.nickname + ")" : EZ.nickname : (bi.oW(EZ.gBq) || !EZ.gBq.contains(this.tNU)) ? (bi.oW(EZ.nickname) || !EZ.nickname.contains(this.tNU)) ? EZ.bgo : EZ.bgo + "(" + EZ.nickname + ")" : EZ.bgo + "(" + EZ.gBq + ")";
        textView.setText(j.a(context, charSequence, aVar.eMe.getTextSize()));
        aVar.hrs.setText(i.f(this.mContext, EZ.timestamp));
        aVar.eCm.setText(EZ.title);
        tNT.a((a) tVar, i);
        if (!bi.oW(this.tNU)) {
            a.e(aVar.eMe, this.tNU);
            a.e(aVar.eCm, this.tNU);
        }
    }

    public final int getItemCount() {
        boolean z;
        int count = tNT == null ? 0 : tNT.getCount();
        String str = "MicroMsg.MediaHistoryListAdapter";
        String str2 = " null == mIDetail?%s getItemCount:%s";
        Object[] objArr = new Object[2];
        if (tNT == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(count);
        x.i(str, str2, objArr);
        return count;
    }

    public final String gy(long j) {
        return com.tencent.mm.ui.gridviewheaders.a.czj().a(new Date(j), this.mContext);
    }

    private static long gz(long j) {
        return com.tencent.mm.ui.gridviewheaders.a.czj().b(new Date(j));
    }
}
