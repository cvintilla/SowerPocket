package interfaces;

import android.speech.tts.TextToSpeech;

/**
 * Created by Gio on 11/11/2017.
 */

public interface OnInitListener extends TextToSpeech.OnInitListener {
    void onInit(int status);
}
