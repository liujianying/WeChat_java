package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.rtmp.TXLiveBase;
import java.text.SimpleDateFormat;

public class a extends LinearLayout {
    StringBuffer a;
    private TextView b;
    private TextView c;
    private ScrollView d;
    private ScrollView e;
    private final int f;
    private boolean g;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new StringBuffer("");
        this.f = 3000;
        this.g = false;
        setOrientation(1);
        this.b = new TextView(context);
        this.c = new TextView(context);
        this.d = new ScrollView(context);
        this.e = new ScrollView(context);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 0.2f;
        this.d.setLayoutParams(layoutParams);
        this.d.setBackgroundColor(1627389951);
        this.d.setVerticalScrollBarEnabled(true);
        this.d.setScrollbarFadingEnabled(true);
        this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.b.setTextSize(2, 11.0f);
        this.b.setTextColor(-16777216);
        this.b.setTypeface(Typeface.MONOSPACE, 1);
        this.b.setLineSpacing(4.0f, 1.0f);
        this.b.setPadding(a(context, 2.0f), a(context, 2.0f), a(context, 2.0f), a(context, 2.0f));
        this.d.addView(this.b);
        layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 0.8f;
        layoutParams.topMargin = a(context, 2.0f);
        this.e.setLayoutParams(layoutParams);
        this.e.setBackgroundColor(1627389951);
        this.e.setVerticalScrollBarEnabled(true);
        this.e.setScrollbarFadingEnabled(true);
        this.c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.c.setTextSize(2, 13.0f);
        this.c.setTextColor(-16777216);
        this.c.setPadding(a(context, 2.0f), a(context, 2.0f), a(context, 2.0f), a(context, 2.0f));
        this.e.addView(this.c);
        addView(this.d);
        addView(this.e);
        setVisibility(8);
    }

    public static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public void a(Bundle bundle, Bundle bundle2, int i) {
        if (!this.g && i != 2011 && i != 2012) {
            if (bundle != null && getVisibility() == 0) {
                this.b.setText(a(bundle));
            }
            if (this.a.length() <= 0) {
                this.a.append("liteav sdk version:" + TXLiveBase.getSDKVersionStr());
            }
            if (bundle2 != null) {
                String string = bundle2.getString("EVT_MSG");
                if (string != null && !string.isEmpty()) {
                    a(i, string);
                    if (getVisibility() == 0) {
                        this.c.setText(this.a.toString());
                        a(this.e, this.c);
                    }
                }
            }
        }
    }

    protected void a(int i, String str) {
        if (i != 1020) {
            String format = new SimpleDateFormat("HH:mm:ss.SSS").format(Long.valueOf(System.currentTimeMillis()));
            while (this.a.length() > 3000) {
                int indexOf = this.a.indexOf("\n");
                if (indexOf == 0) {
                    indexOf = 1;
                }
                this.a = this.a.delete(0, indexOf);
            }
            this.a = this.a.append("\n[" + format + "]" + str);
        }
    }

    protected String a(Bundle bundle) {
        r1 = new Object[12];
        r1[7] = "QUE:" + bundle.getInt("CODEC_CACHE") + " | " + bundle.getInt("CACHE_SIZE") + "," + bundle.getInt("VIDEO_CACHE_SIZE") + "," + bundle.getInt("V_DEC_CACHE_SIZE") + " | " + bundle.getInt("AV_RECV_INTERVAL") + "," + bundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[]{Float.valueOf(bundle.getFloat("AUDIO_PLAY_SPEED"))}).toString();
        r1[8] = "VRA:" + bundle.getInt("VIDEO_BITRATE") + "Kbps";
        r1[9] = "DRP:" + bundle.getInt("CODEC_DROP_CNT") + "|" + bundle.getInt("DROP_SIZE");
        r1[10] = "SVR:" + bundle.getString("SERVER_IP");
        r1[11] = "AUDIO:" + bundle.getString("AUDIO_PLAY_INFO");
        return String.format("%-16s %-16s %-16s\n%-12s %-12s %-12s %-12s\n%-14s %-14s %-14s\n%-16s %-16s", r1);
    }

    public void a() {
        this.a.setLength(0);
        this.b.setText("");
        this.c.setText("");
    }

    public void a(boolean z) {
        setVisibility(z ? 0 : 8);
        if (z) {
            this.c.setText(this.a.toString());
            a(this.e, this.c);
            return;
        }
        this.c.setText("");
    }

    public void b(boolean z) {
        this.g = z;
    }

    private void a(ScrollView scrollView, View view) {
        if (scrollView != null && view != null) {
            int measuredHeight = view.getMeasuredHeight() - scrollView.getMeasuredHeight();
            if (measuredHeight < 0) {
                measuredHeight = 0;
            }
            scrollView.scrollTo(0, measuredHeight);
        }
    }
}
