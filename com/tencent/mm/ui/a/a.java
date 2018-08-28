package com.tencent.mm.ui.a;

import android.content.Context;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.w.a.i;
import java.util.Locale;

public final class a {
    private AccessibilityManager gD;
    Vibrator hni;
    public Context rc;
    TextToSpeech tqQ = null;

    /* renamed from: com.tencent.mm.ui.a.a$1 */
    class AnonymousClass1 implements OnInitListener {
        final /* synthetic */ String efo;

        AnonymousClass1(String str) {
            this.efo = str;
        }

        public final void onInit(int i) {
            if (a.this.tqQ != null) {
                a.this.tqQ.setLanguage(w.chL() ? Locale.CHINESE : Locale.ENGLISH);
                a.this.tqQ.speak(this.efo, 0, null);
            }
        }
    }

    private static class a {
        private static final a tqS = new a(ad.getContext());
    }

    public a(Context context) {
        this.rc = context;
        this.gD = (AccessibilityManager) this.rc.getSystemService("accessibility");
    }

    public final boolean cqW() {
        return this.gD.isEnabled() && this.gD.isTouchExplorationEnabled();
    }

    public final void a(View view, String str, int i, String str2, String str3) {
        if (cqW() && this.rc != null && view != null && str != null && str2 != null && str3 != null) {
            b bVar = new b();
            bVar.ZU(str);
            if (i > 0) {
                bVar.ZU(this.rc.getResources().getQuantityString(i.conversation_item_desc_unread, 1, new Object[]{Integer.valueOf(i)}));
            }
            bVar.ZU(str2).ZU(str3);
            bVar.dl(view);
        }
    }

    public final void J(View view, int i) {
        if (cqW() && this.rc != null && view != null) {
            int max = Math.max(i, 1);
            b bVar = new b();
            bVar.ZU(this.rc.getResources().getQuantityString(i.chatting_voice_item_desc, max, new Object[]{Integer.valueOf(max)}));
            bVar.dl(view);
        }
    }
}
