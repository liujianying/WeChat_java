package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class i$b extends b$a {
    public static Map<String, WeakReference<i$b>> ubi = new HashMap();
    ProgressBar mgA;
    ImageView uai;
    RTChattingEmojiView ubd;
    ImageView ube;
    ProgressBar ubf;
    ImageView ubg;
    TextView ubh;

    public final b$a q(View view, boolean z) {
        super.dx(view);
        this.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
        this.ubd = (RTChattingEmojiView) view.findViewById(R.h.chatting_content_iv);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.gFD = view.findViewById(R.h.chatting_maskview);
        this.ubf = (ProgressBar) view.findViewById(R.h.chatting_download_progress);
        this.ubg = (ImageView) view.findViewById(R.h.chatting_status_btn);
        this.ubh = (TextView) view.findViewById(R.h.chatting_size_iv);
        if (!z) {
            this.mgA = (ProgressBar) view.findViewById(R.h.uploading_pb);
            this.tZv = (ImageView) view.findViewById(R.h.chatting_state_iv);
            this.uai = (ImageView) view.findViewById(R.h.chatting_status_tick);
        }
        if (this.ube != null) {
            ((ViewGroup) this.ube.getParent()).setBackgroundDrawable(null);
        }
        this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
        return this;
    }

    public static void l(String str, int i, int i2) {
        if (ubi.containsKey(str)) {
            i$b i_b = (i$b) ((WeakReference) ubi.get(str)).get();
            if (i_b != null) {
                switch (i2) {
                    case 0:
                        i_b.ubf.setVisibility(0);
                        i_b.ubh.setVisibility(8);
                        i_b.ubg.setVisibility(8);
                        i_b.ubf.setProgress(0);
                        return;
                    case 1:
                        i_b.ubf.setVisibility(8);
                        i_b.ubh.setVisibility(8);
                        i_b.ubg.setVisibility(8);
                        return;
                    case 2:
                        i_b.ubf.setVisibility(8);
                        i_b.ubh.setVisibility(8);
                        i_b.ubg.setVisibility(0);
                        i_b.ubf.setProgress(i);
                        i_b.ubg.setImageResource(R.g.emoji_download_failed_btn);
                        return;
                    default:
                        return;
                }
            }
            return;
        }
        x.i("AppMsgEmojiItemHolder", "no contain attchid:%s");
    }
}
