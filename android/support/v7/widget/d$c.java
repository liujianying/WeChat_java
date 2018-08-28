package android.support.v7.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

public final class d$c {
    public final ComponentName Ls;
    public final long time;
    public final float weight;

    public d$c(String str, long j, float f) {
        this(ComponentName.unflattenFromString(str), j, f);
    }

    public d$c(ComponentName componentName, long j, float f) {
        this.Ls = componentName;
        this.time = j;
        this.weight = f;
    }

    public final int hashCode() {
        return (((((this.Ls == null ? 0 : this.Ls.hashCode()) + 31) * 31) + ((int) (this.time ^ (this.time >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        d$c d_c = (d$c) obj;
        if (this.Ls == null) {
            if (d_c.Ls != null) {
                return false;
            }
        } else if (!this.Ls.equals(d_c.Ls)) {
            return false;
        }
        if (this.time != d_c.time) {
            return false;
        }
        if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(d_c.weight)) {
            return false;
        }
        return true;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("; activity:").append(this.Ls);
        stringBuilder.append("; time:").append(this.time);
        stringBuilder.append("; weight:").append(new BigDecimal((double) this.weight));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
