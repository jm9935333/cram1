//³Ì·s®ø®§ Adapter
package com.example.cram;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.cram.NewMessageListRow;

;

public class NewMessageAdapter extends BaseAdapter {
	private Context context;

	private List<NewMessageListRow> listRow;

	public NewMessageAdapter(List<NewMessageListRow> listRow, Context context) {
		this.context = context;
		this.listRow = listRow;

	}

	public int getCount() {
		return listRow.size();
	}

	public Object getItem(int position) {
		return listRow.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		NewMessageListRow entry = listRow.get(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.newmessagelistrow, null);
		}
		String Date = entry.getDate();
		String Message = entry.getMessage();
//		int See = entry.getSee();
		TextView txtDate = (TextView) convertView.findViewById(R.id.txtDate);

		txtDate.setText(entry.getDate());

		TextView txtMessage = (TextView) convertView
				.findViewById(R.id.txtMessage);
		txtMessage.setText(entry.getMessage());

//		TextView txtSee = (TextView) convertView.findViewById(R.id.New);
//		txtSee.setText(""+entry.getSee());

		return convertView;
	}

}
