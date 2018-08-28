package com.tencent.mm.plugin.music.b.b;

import com.google.android.exoplayer2.d.b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.tencent.mm.sdk.platformtools.x;
import java.text.NumberFormat;
import java.util.Locale;

public final class a {
    private static final NumberFormat lAf;

    static {
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        lAf = instance;
        instance.setMinimumFractionDigits(2);
        lAf.setMaximumFractionDigits(2);
        lAf.setGroupingUsed(false);
    }

    public static void biB() {
        b.DEBUG = false;
        b.a(new 1());
    }

    public static String ee(long j) {
        return j == -9223372036854775807L ? "?" : lAf.format((double) (((float) j) / 1000.0f));
    }

    public static String tN(int i) {
        switch (i) {
            case 1:
                return "I";
            case 2:
                return "B";
            case 3:
                return "R";
            case 4:
                return "E";
            default:
                return "?";
        }
    }

    public static void a(Metadata metadata, String str) {
        for (Entry entry : metadata.aqq) {
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                x.d("MicroMsg.ExoPlayer", str + String.format("%s: value=%s", new Object[]{textInformationFrame.id, textInformationFrame.value}));
            } else if (entry instanceof UrlLinkFrame) {
                UrlLinkFrame urlLinkFrame = (UrlLinkFrame) entry;
                x.d("MicroMsg.ExoPlayer", str + String.format("%s: url=%s", new Object[]{urlLinkFrame.id, urlLinkFrame.url}));
            } else if (entry instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) entry;
                x.d("MicroMsg.ExoPlayer", str + String.format("%s: owner=%s", new Object[]{privFrame.id, privFrame.aqU}));
            } else if (entry instanceof GeobFrame) {
                GeobFrame geobFrame = (GeobFrame) entry;
                x.d("MicroMsg.ExoPlayer", str + String.format("%s: mimeType=%s, filename=%s, description=%s", new Object[]{geobFrame.id, geobFrame.mimeType, geobFrame.filename, geobFrame.description}));
            } else if (entry instanceof ApicFrame) {
                ApicFrame apicFrame = (ApicFrame) entry;
                x.d("MicroMsg.ExoPlayer", str + String.format("%s: mimeType=%s, description=%s", new Object[]{apicFrame.id, apicFrame.mimeType, apicFrame.description}));
            } else if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                x.d("MicroMsg.ExoPlayer", str + String.format("%s: language=%s, description=%s", new Object[]{commentFrame.id, commentFrame.aem, commentFrame.description}));
            } else if (entry instanceof Id3Frame) {
                Id3Frame id3Frame = (Id3Frame) entry;
                x.d("MicroMsg.ExoPlayer", str + String.format("%s", new Object[]{id3Frame.id}));
            } else if (entry instanceof EventMessage) {
                EventMessage eventMessage = (EventMessage) entry;
                x.d("MicroMsg.ExoPlayer", str + String.format("EMSG: scheme=%s, id=%d, value=%s", new Object[]{eventMessage.aqB, Long.valueOf(eventMessage.id), eventMessage.value}));
            }
        }
    }
}
