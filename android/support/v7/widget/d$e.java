package android.support.v7.widget;

import android.os.AsyncTask;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

final class d$e extends AsyncTask<Object, Void, Void> {
    final /* synthetic */ d Lr;

    private d$e(d dVar) {
        this.Lr = dVar;
    }

    /* synthetic */ d$e(d dVar, byte b) {
        this(dVar);
    }

    private Void b(Object... objArr) {
        int i = 0;
        List list = (List) objArr[0];
        try {
            OutputStream openFileOutput = d.a(this.Lr).openFileOutput((String) objArr[1], 0);
            XmlSerializer newSerializer = Xml.newSerializer();
            try {
                newSerializer.setOutput(openFileOutput, null);
                newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                newSerializer.startTag(null, "historical-records");
                int size = list.size();
                while (i < size) {
                    d$c d_c = (d$c) list.remove(0);
                    newSerializer.startTag(null, "historical-record");
                    newSerializer.attribute(null, "activity", d_c.Ls.flattenToString());
                    newSerializer.attribute(null, "time", String.valueOf(d_c.time));
                    newSerializer.attribute(null, "weight", String.valueOf(d_c.weight));
                    newSerializer.endTag(null, "historical-record");
                    i++;
                }
                newSerializer.endTag(null, "historical-records");
                newSerializer.endDocument();
                d.c(this.Lr);
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e) {
                    }
                }
            } catch (IllegalArgumentException e2) {
                d.ew();
                new StringBuilder("Error writing historical recrod file: ").append(d.b(this.Lr));
                d.c(this.Lr);
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IllegalStateException e4) {
                d.ew();
                new StringBuilder("Error writing historical recrod file: ").append(d.b(this.Lr));
                d.c(this.Lr);
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (IOException e6) {
                d.ew();
                new StringBuilder("Error writing historical recrod file: ").append(d.b(this.Lr));
                d.c(this.Lr);
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e7) {
                    }
                }
            } catch (Throwable th) {
                d.c(this.Lr);
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e8) {
                    }
                }
            }
        } catch (FileNotFoundException e9) {
            d.ew();
        }
        return null;
    }
}
