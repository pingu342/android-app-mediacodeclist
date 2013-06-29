package jp.saka.mediacodeclist;

import android.util.Log;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MediaCodecList extends Activity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView tv = (TextView)findViewById(R.id.MediaCodecInfoTextView);

		int codecs = android.media.MediaCodecList.getCodecCount();
		appendText(tv, "Codec Count: " + codecs + "\n");
		for (int i=0; i<codecs; i++) {
			appendText(tv, "\n");
			android.media.MediaCodecInfo info = android.media.MediaCodecList.getCodecInfoAt(i);
			if (info != null) {
				appendText(tv, "Codec[" + i + "] Name: " + info.getName() + "\n");
				appendText(tv, "Codec[" + i + "] Encoder: " + (info.isEncoder() ? "YES" : "NO") + "\n");
				String[] types = info.getSupportedTypes();
				String s = "";
				for (int j=0; j<types.length; j++) {
					if (j > 0) {
						s += ",";
					}
					s += types[j];
				}
				appendText(tv, "Codec[" + i + "] Supported Types: " + s + "\n");
			}
		}
	}

	private void appendText(TextView tv, String text) {
		Log.d("sakalog", text);
		tv.append(text);
	}
}
