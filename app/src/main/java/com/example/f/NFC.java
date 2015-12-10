package com.example.f;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.Bundle;
import android.widget.TextView;

public class NFC extends Activity {

	//http://terryyamg.blogspot.tw/2014/11/android-nfc-tag.html
	
	/* NFC */
	// list of NFC technologies detected:
	private final String[][] techList = new String[][] { new String[] {
			NfcA.class.getName(), NfcB.class.getName(), NfcF.class.getName(),
			NfcV.class.getName(), IsoDep.class.getName(),
			MifareClassic.class.getName(), MifareUltralight.class.getName(),
			Ndef.class.getName() } };
	TextView EasyCardTag;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nfc);
		
		EasyCardTag=(TextView)findViewById(R.id.EasyCardTag);

	}

	/* NFC */
	@Override
	protected void onResume() {
		super.onResume();
		// creating pending intent:
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
				new Intent(this, getClass())
						.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
		// creating intent receiver for NFC events:
		IntentFilter filter = new IntentFilter();
		filter.addAction(NfcAdapter.ACTION_TAG_DISCOVERED);
		filter.addAction(NfcAdapter.ACTION_NDEF_DISCOVERED);
		filter.addAction(NfcAdapter.ACTION_TECH_DISCOVERED);
		// enabling foreground dispatch for getting intent from NFC event:
		NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
		nfcAdapter.enableForegroundDispatch(this, pendingIntent,
				new IntentFilter[] { filter }, this.techList);
	}

	@Override
	protected void onPause() {
		super.onPause();
		// disabling foreground dispatch:
		NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
		nfcAdapter.disableForegroundDispatch(this);
	}

	// �Ntag�쪺ID��ܥX��
	@Override
	protected void onNewIntent(Intent intent) {
		if (intent.getAction().equals(NfcAdapter.ACTION_TAG_DISCOVERED)) {
			EasyCardTag.setText( "ID (reversed):"
							+ getReversed(intent
									.getByteArrayExtra(NfcAdapter.EXTRA_ID)));
			SharedPreferences sp = getSharedPreferences("cram", 0);
			sp.edit().putString("EasyCardTag", (""+(getReversed(intent.getByteArrayExtra(NfcAdapter.EXTRA_ID)))).toString()).commit();
		}
	}

	private long getReversed(byte[] bytes) {
		long result = 0;
		long factor = 1;
		for (int i = bytes.length - 1; i >= 0; --i) {
			long value = bytes[i] & 0xffl;
			result += value * factor;
			factor *= 256l;
		}
		return result;
	}
}