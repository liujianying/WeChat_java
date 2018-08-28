package com.tencent.matrix.b;

import android.app.Application;
import com.tencent.matrix.c.c.a;
import com.tencent.matrix.d.c;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b implements a {
    public Application application;
    private c boU;
    public boolean brg = true;
    public int status = 0;

    public void a(Application application, c cVar) {
        if (this.application == null && this.boU == null) {
            this.status = 1;
            this.application = application;
            this.boU = cVar;
            return;
        }
        throw new RuntimeException("plugin duplicate init, application or plugin listener is not null");
    }

    public final void a(com.tencent.matrix.c.b bVar) {
        if (bVar.tag == null) {
            bVar.tag = getTag();
        }
        bVar.brn = this;
        JSONObject jSONObject = bVar.brm;
        try {
            if (bVar.tag != null) {
                jSONObject.put("tag", bVar.tag);
            }
            if (bVar.brl != null) {
                jSONObject.put("type", bVar.brl);
            }
            jSONObject.put("process", c.aC(this.application));
        } catch (JSONException e) {
            com.tencent.matrix.d.b.e("Matrix.Plugin", "json error", e);
        }
        this.boU.b(bVar);
    }

    public void start() {
        if (tx()) {
            throw new RuntimeException("plugin start, but plugin has been already destroyed");
        } else if (tw()) {
            throw new RuntimeException("plugin start, but plugin has been already started");
        } else {
            this.status = 2;
            if (this.boU == null) {
                throw new RuntimeException("plugin start, plugin listener is null");
            }
            this.boU.c(this);
        }
    }

    public void stop() {
        if (tx()) {
            throw new RuntimeException("plugin stop, but plugin has been already destroyed");
        } else if (tw()) {
            this.status = 4;
            if (this.boU == null) {
                throw new RuntimeException("plugin stop, plugin listener is null");
            }
            this.boU.d(this);
        } else {
            throw new RuntimeException("plugin stop, but plugin is never started");
        }
    }

    public String getTag() {
        return getClass().getName();
    }

    public final boolean tw() {
        return this.status == 2;
    }

    private boolean tx() {
        return this.status == 8;
    }
}
