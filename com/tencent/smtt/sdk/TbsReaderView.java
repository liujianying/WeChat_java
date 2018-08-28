package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.smtt.sdk.a.d;
import com.tencent.smtt.utils.Apn;

public class TbsReaderView extends FrameLayout {
    public static final String IS_BAR_ANIMATING = "is_bar_animating";
    public static final String IS_BAR_SHOWING = "is_bar_show";
    public static final String IS_INTO_DOWNLOADING = "into_downloading";
    public static final String KEY_FILE_PATH = "filePath";
    public static final String KEY_TEMP_PATH = "tempPath";
    public static final int READER_CHANNEL_DOC_ID = 10965;
    public static final int READER_CHANNEL_PDF_ID = 10834;
    public static final int READER_CHANNEL_PPT_ID = 10833;
    public static final int READER_CHANNEL_TXT_ID = 10835;
    public static final String READER_STATISTICS_COUNT_CANCEL_LOADED_BTN = "AHNG802";
    public static final String READER_STATISTICS_COUNT_CLICK_LOADED_BTN = "AHNG801";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_BROWSER = "AHNG829";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DIALOG = "AHNG827";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD = "AHNG828";
    public static final String READER_STATISTICS_COUNT_DOC_SEARCH_BTN = "AHNG826";
    public static final String READER_STATISTICS_COUNT_PDF_FOLDER_BTN = "AHNG810";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_BROWSER = "AHNG813";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DIALOG = "AHNG811";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD = "AHNG812";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_BROWSER = "AHNG809";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DIALOG = "AHNG807";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD = "AHNG808";
    public static final String READER_STATISTICS_COUNT_PPT_PLAY_BTN = "AHNG806";
    public static final String READER_STATISTICS_COUNT_RETRY_BTN = "AHNG803";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_BROWSER = "AHNG817";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DIALOG = "AHNG815";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD = "AHNG816";
    public static final String READER_STATISTICS_COUNT_TXT_NOVEL_BTN = "AHNG814";
    public static final String TAG = "TbsReaderView";
    static boolean f = false;
    public static String gReaderPackName = "";
    public static String gReaderPackVersion = "";
    Context a = null;
    ReaderWizard b = null;
    Object c = null;
    ReaderCallback d = null;
    ReaderCallback e = null;

    public TbsReaderView(Context context, ReaderCallback readerCallback) {
        super(context.getApplicationContext());
        if (context instanceof Activity) {
            this.d = readerCallback;
            this.a = context;
            this.e = new bb(this);
            return;
        }
        throw new RuntimeException("error: unexpect context(none Activity)");
    }

    static boolean a(Context context) {
        if (!f) {
            o.a(true).a(context.getApplicationContext(), true, false, null);
            f = o.a(false).b();
        }
        return f;
    }

    public static Drawable getResDrawable(Context context, int i) {
        return a(context) ? ReaderWizard.getResDrawable(i) : null;
    }

    public static String getResString(Context context, int i) {
        return a(context) ? ReaderWizard.getResString(i) : "";
    }

    public static boolean isSupportExt(Context context, String str) {
        return a(context) && ReaderWizard.isSupportCurrentPlatform(context) && ReaderWizard.isSupportExt(str);
    }

    boolean a() {
        try {
            if (this.b == null) {
                this.b = new ReaderWizard(this.e);
            }
            if (this.c == null) {
                this.c = this.b.getTbsReader();
            }
            return this.c != null ? this.b.initTbsReader(this.c, this.a) : false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public void doCommand(Integer num, Object obj, Object obj2) {
        if (this.b != null && this.c != null) {
            this.b.doCommand(this.c, num, obj, obj2);
        }
    }

    public boolean downloadPlugin(String str) {
        return this.c == null ? false : this.b.checkPlugin(this.c, this.a, str, true);
    }

    public void onSizeChanged(int i, int i2) {
        if (this.b != null && this.c != null) {
            this.b.onSizeChanged(this.c, i, i2);
        }
    }

    public void onStop() {
        if (this.b != null) {
            this.b.destroy(this.c);
            this.c = null;
        }
        this.a = null;
        f = false;
    }

    public void openFile(Bundle bundle) {
        int i = 1;
        if (this.c != null && bundle != null) {
            bundle.putBoolean("browser6.0", (!d.b(this.a) ? 1 : 0) | d.c(this.a));
            boolean a = d.a(this.a, 6101625, 610000);
            if (d.b(this.a)) {
                i = 0;
            }
            bundle.putBoolean("browser6.1", a | i);
            this.b.openFile(this.c, this.a, bundle, this);
        }
    }

    public boolean preOpen(String str, boolean z) {
        boolean z2 = false;
        if (!isSupportExt(this.a, str)) {
            return false;
        }
        boolean a = a(this.a);
        if (a) {
            a = a();
            if (z && a) {
                if (Apn.getApnType(this.a) == 3) {
                    z2 = true;
                }
                return this.b.checkPlugin(this.c, this.a, str, z2);
            }
        }
        return a;
    }

    public void userStatistics(String str) {
        if (this.b != null) {
            this.b.userStatistics(this.c, str);
        }
    }
}
