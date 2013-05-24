package flix.tuner.stimmapp;

import android.app.Activity;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;

public class AudioCapture extends Activity{
	//Well actually we could get the default configration (may be more than mono)
	private static final int channels = AudioFormat.CHANNEL_IN_MONO;
	//16 bit is guaranteed to work, 8 bit not
	private static final int pcm = AudioFormat.ENCODING_PCM_16BIT;
	//setting the source, camera or Voice are other possible values
	public static final int source = MediaRecorder.AudioSource.MIC;
	//Sampling rate
	private int SamplingFrequency=8000;

	
	
	
	public int getMaxSupportedSamplingRate(){
		int[] possibleSampleRates=new int[]{11024,16000,22050,44100};
		int maxRate=8000;
		for(int psr:possibleSampleRates){
			int bufferSize=AudioRecord.getMinBufferSize(psr, channels, pcm);
			//getMinBufferSize return -3,-2 or -1 if there was an error->rate not acceptable
			if(bufferSize>0){
				maxRate=psr;
			}
		}
		return maxRate;
	}
	
	public int getSamplingFrequency() {
		return SamplingFrequency;
	}

	public void setSamplingFrequency(int sr) {
		this.SamplingFrequency = sr;
	}
	
}
