package com.tencent.c.e.a.a;

import android.hardware.SensorEvent;
import java.util.Arrays;

public final class j {
    public final long timestamp;
    public final float[] values;
    public final int vkh;

    public j(SensorEvent sensorEvent, long j) {
        this.vkh = sensorEvent.sensor.getType();
        this.timestamp = j;
        this.values = Arrays.copyOf(sensorEvent.values, sensorEvent.values.length);
    }
}
