/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package android.service.notification;

import android.os.Parcel;
import android.os.Parcelable;

public class NotificationOrderUpdate implements Parcelable {
    // TODO replace this with an update instead of the whole array
    private final String[] mKeys;

    /** @hide */
    public NotificationOrderUpdate(String[] keys) {
        this.mKeys = keys;
    }

    public NotificationOrderUpdate(Parcel in) {
        this.mKeys = in.readStringArray();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeStringArray(this.mKeys);
    }

    public static final Parcelable.Creator<NotificationOrderUpdate> CREATOR
            = new Parcelable.Creator<NotificationOrderUpdate>() {
        public NotificationOrderUpdate createFromParcel(Parcel parcel) {
            return new NotificationOrderUpdate(parcel);
        }

        public NotificationOrderUpdate[] newArray(int size) {
            return new NotificationOrderUpdate[size];
        }
    };

    /**
     * @hide
     * @return ordered list of keys
     */
    String[] getOrderedKeys() {
        return mKeys;
    }
}
